package org.apache.hc.core5.pool;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.hc.core5.concurrent.BasicFuture;
import org.apache.hc.core5.concurrent.FutureCallback;
import org.apache.hc.core5.function.Callback;
import org.apache.hc.core5.io.CloseMode;
import org.apache.hc.core5.io.ModalCloseable;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.Asserts;
import org.apache.hc.core5.util.Deadline;
import org.apache.hc.core5.util.DeadlineTimeoutException;
import org.apache.hc.core5.util.TimeValue;
import org.apache.hc.core5.util.Timeout;

/* JADX INFO: loaded from: classes5.dex */
public class StrictConnPool<T, C extends ModalCloseable> implements ManagedConnPool<T, C> {
    private final LinkedList<PoolEntry<T, C>> available;
    private final ConcurrentLinkedQueue<LeaseRequest<T, C>> completedRequests;
    private final ConnPoolListener<T> connPoolListener;
    private volatile int defaultMaxPerRoute;
    private final DisposalCallback<C> disposalCallback;
    private final AtomicBoolean isShutDown;
    private final Set<PoolEntry<T, C>> leased;
    private final ReentrantLock lock;
    private final Map<T, Integer> maxPerRoute;
    private volatile int maxTotal;
    private final LinkedList<LeaseRequest<T, C>> pendingRequests;
    private final PoolReusePolicy policy;
    private final Map<T, PerRoutePool<T, C>> routeToPool;
    private final TimeValue timeToLive;

    public StrictConnPool(int i, int i2, TimeValue timeValue, PoolReusePolicy poolReusePolicy, DisposalCallback<C> disposalCallback, ConnPoolListener<T> connPoolListener) {
        Args.positive(i, "Max per route value");
        Args.positive(i2, "Max total value");
        this.timeToLive = TimeValue.defaultsToNegativeOneMillisecond(timeValue);
        this.policy = poolReusePolicy == null ? PoolReusePolicy.LIFO : poolReusePolicy;
        this.disposalCallback = disposalCallback;
        this.connPoolListener = connPoolListener;
        this.routeToPool = new HashMap();
        this.pendingRequests = new LinkedList<>();
        this.leased = new HashSet();
        this.available = new LinkedList<>();
        this.completedRequests = new ConcurrentLinkedQueue<>();
        this.maxPerRoute = new HashMap();
        this.lock = new ReentrantLock();
        this.isShutDown = new AtomicBoolean();
        this.defaultMaxPerRoute = i;
        this.maxTotal = i2;
    }

    public StrictConnPool(int i, int i2, TimeValue timeValue, PoolReusePolicy poolReusePolicy, ConnPoolListener<T> connPoolListener) {
        this(i, i2, timeValue, poolReusePolicy, null, connPoolListener);
    }

    public StrictConnPool(int i, int i2) {
        this(i, i2, TimeValue.NEG_ONE_MILLISECOND, PoolReusePolicy.LIFO, null);
    }

    public boolean isShutdown() {
        return this.isShutDown.get();
    }

    @Override // org.apache.hc.core5.io.ModalCloseable
    public void close(CloseMode closeMode) {
        if (this.isShutDown.compareAndSet(false, true)) {
            fireCallbacks();
            this.lock.lock();
            try {
                Iterator<PerRoutePool<T, C>> it = this.routeToPool.values().iterator();
                while (it.hasNext()) {
                    it.next().shutdown(closeMode);
                }
                this.routeToPool.clear();
                this.leased.clear();
                this.available.clear();
                this.pendingRequests.clear();
            } finally {
                this.lock.unlock();
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        close(CloseMode.GRACEFUL);
    }

    private PerRoutePool<T, C> getPool(T t) {
        PerRoutePool<T, C> perRoutePool = this.routeToPool.get(t);
        if (perRoutePool != null) {
            return perRoutePool;
        }
        PerRoutePool<T, C> perRoutePool2 = new PerRoutePool<>(t, this.disposalCallback);
        this.routeToPool.put(t, perRoutePool2);
        return perRoutePool2;
    }

    @Override // org.apache.hc.core5.pool.ConnPool
    public Future<PoolEntry<T, C>> lease(T t, Object obj, Timeout timeout, FutureCallback<PoolEntry<T, C>> futureCallback) {
        Args.notNull(t, "Route");
        Args.notNull(timeout, "Request timeout");
        boolean zTryLock = true;
        Asserts.check(!this.isShutDown.get(), "Connection pool shut down");
        Deadline deadlineCalculate = Deadline.calculate(timeout);
        BasicFuture basicFuture = new BasicFuture<PoolEntry<T, C>>(futureCallback) { // from class: org.apache.hc.core5.pool.StrictConnPool.1
            @Override // org.apache.hc.core5.concurrent.BasicFuture, java.util.concurrent.Future
            public PoolEntry<T, C> get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
                try {
                    return (PoolEntry) super.get(j, timeUnit);
                } catch (TimeoutException e) {
                    cancel();
                    throw e;
                }
            }
        };
        try {
            if (TimeValue.isPositive(timeout)) {
                zTryLock = this.lock.tryLock(timeout.getDuration(), timeout.getTimeUnit());
            } else {
                this.lock.lockInterruptibly();
            }
            if (zTryLock) {
                try {
                    LeaseRequest<T, C> leaseRequest = new LeaseRequest<>(t, obj, timeout, basicFuture);
                    boolean zProcessPendingRequest = processPendingRequest(leaseRequest);
                    if (!leaseRequest.isDone() && !zProcessPendingRequest) {
                        this.pendingRequests.add(leaseRequest);
                    }
                    if (leaseRequest.isDone()) {
                        this.completedRequests.add(leaseRequest);
                    }
                    this.lock.unlock();
                    fireCallbacks();
                    return basicFuture;
                } catch (Throwable th) {
                    this.lock.unlock();
                    throw th;
                }
            }
            basicFuture.failed(DeadlineTimeoutException.from(deadlineCalculate));
            return basicFuture;
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            basicFuture.cancel();
            return basicFuture;
        }
    }

    public Future<PoolEntry<T, C>> lease(T t, Object obj) {
        return lease(t, obj, Timeout.DISABLED, null);
    }

    @Override // org.apache.hc.core5.pool.ConnPool
    public void release(PoolEntry<T, C> poolEntry, boolean z) {
        if (poolEntry == null || this.isShutDown.get()) {
            return;
        }
        if (!z) {
            poolEntry.discardConnection(CloseMode.GRACEFUL);
        }
        this.lock.lock();
        try {
            if (this.leased.remove(poolEntry)) {
                ConnPoolListener<T> connPoolListener = this.connPoolListener;
                if (connPoolListener != null) {
                    connPoolListener.onRelease(poolEntry.getRoute(), this);
                }
                PerRoutePool<T, C> pool = getPool(poolEntry.getRoute());
                boolean z2 = poolEntry.hasConnection() && z;
                pool.free(poolEntry, z2);
                if (z2) {
                    int i = AnonymousClass2.$SwitchMap$org$apache$hc$core5$pool$PoolReusePolicy[this.policy.ordinal()];
                    if (i == 1) {
                        this.available.addFirst(poolEntry);
                    } else if (i == 2) {
                        this.available.addLast(poolEntry);
                    } else {
                        throw new IllegalStateException("Unexpected ConnPoolPolicy value: " + this.policy);
                    }
                } else {
                    poolEntry.discardConnection(CloseMode.GRACEFUL);
                }
                processNextPendingRequest();
                this.lock.unlock();
                fireCallbacks();
                return;
            }
            throw new IllegalStateException("Pool entry is not present in the set of leased entries");
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    /* JADX INFO: renamed from: org.apache.hc.core5.pool.StrictConnPool$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$hc$core5$pool$PoolReusePolicy;

        static {
            int[] iArr = new int[PoolReusePolicy.values().length];
            $SwitchMap$org$apache$hc$core5$pool$PoolReusePolicy = iArr;
            try {
                iArr[PoolReusePolicy.LIFO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$hc$core5$pool$PoolReusePolicy[PoolReusePolicy.FIFO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private void processPendingRequests() {
        ListIterator<LeaseRequest<T, C>> listIterator = this.pendingRequests.listIterator();
        while (listIterator.hasNext()) {
            LeaseRequest<T, C> next = listIterator.next();
            if (next.getFuture().isCancelled()) {
                listIterator.remove();
            } else {
                boolean zProcessPendingRequest = processPendingRequest(next);
                if (next.isDone() || zProcessPendingRequest) {
                    listIterator.remove();
                }
                if (next.isDone()) {
                    this.completedRequests.add(next);
                }
            }
        }
    }

    private void processNextPendingRequest() {
        ListIterator<LeaseRequest<T, C>> listIterator = this.pendingRequests.listIterator();
        while (listIterator.hasNext()) {
            LeaseRequest<T, C> next = listIterator.next();
            if (next.getFuture().isCancelled()) {
                listIterator.remove();
            } else {
                boolean zProcessPendingRequest = processPendingRequest(next);
                if (next.isDone() || zProcessPendingRequest) {
                    listIterator.remove();
                }
                if (next.isDone()) {
                    this.completedRequests.add(next);
                }
                if (zProcessPendingRequest) {
                    return;
                }
            }
        }
    }

    private boolean processPendingRequest(LeaseRequest<T, C> leaseRequest) {
        PoolEntry<T, C> free;
        int iMax;
        T route = leaseRequest.getRoute();
        Object state = leaseRequest.getState();
        Deadline deadline = leaseRequest.getDeadline();
        if (deadline.isExpired()) {
            leaseRequest.failed(DeadlineTimeoutException.from(deadline));
            return false;
        }
        PerRoutePool<T, C> pool = getPool(route);
        while (true) {
            free = pool.getFree(state);
            if (free == null || !free.getExpiryDeadline().isExpired()) {
                break;
            }
            free.discardConnection(CloseMode.GRACEFUL);
            this.available.remove(free);
            pool.free(free, false);
        }
        if (free != null) {
            this.available.remove(free);
            this.leased.add(free);
            leaseRequest.completed(free);
            ConnPoolListener<T> connPoolListener = this.connPoolListener;
            if (connPoolListener != null) {
                connPoolListener.onLease(free.getRoute(), this);
            }
            return true;
        }
        int max = getMax(route);
        int iMax2 = Math.max(0, (pool.getAllocatedCount() + 1) - max);
        if (iMax2 > 0) {
            for (int i = 0; i < iMax2; i++) {
                PoolEntry<T, C> lastUsed = pool.getLastUsed();
                if (lastUsed == null) {
                    break;
                }
                lastUsed.discardConnection(CloseMode.GRACEFUL);
                this.available.remove(lastUsed);
                pool.remove(lastUsed);
            }
        }
        if (pool.getAllocatedCount() >= max || (iMax = Math.max(this.maxTotal - this.leased.size(), 0)) == 0) {
            return false;
        }
        if (this.available.size() > iMax - 1) {
            PoolEntry<T, C> poolEntryRemoveLast = this.available.removeLast();
            poolEntryRemoveLast.discardConnection(CloseMode.GRACEFUL);
            getPool(poolEntryRemoveLast.getRoute()).remove(poolEntryRemoveLast);
        }
        PoolEntry<T, C> poolEntryCreateEntry = pool.createEntry(this.timeToLive);
        this.leased.add(poolEntryCreateEntry);
        leaseRequest.completed(poolEntryCreateEntry);
        ConnPoolListener<T> connPoolListener2 = this.connPoolListener;
        if (connPoolListener2 != null) {
            connPoolListener2.onLease(poolEntryCreateEntry.getRoute(), this);
        }
        return true;
    }

    private void fireCallbacks() {
        while (true) {
            LeaseRequest<T, C> leaseRequestPoll = this.completedRequests.poll();
            if (leaseRequestPoll == null) {
                return;
            }
            BasicFuture<PoolEntry<T, C>> future = leaseRequestPoll.getFuture();
            Exception exception = leaseRequestPoll.getException();
            PoolEntry<T, C> result = leaseRequestPoll.getResult();
            if (exception != null) {
                future.failed(exception);
            } else if (result != null) {
                if (future.completed(result)) {
                }
            } else {
                future.cancel();
            }
            release(result, true);
        }
    }

    public void validatePendingRequests() {
        this.lock.lock();
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            ListIterator<LeaseRequest<T, C>> listIterator = this.pendingRequests.listIterator();
            while (listIterator.hasNext()) {
                LeaseRequest<T, C> next = listIterator.next();
                if (next.getFuture().isCancelled() && !next.isDone()) {
                    listIterator.remove();
                } else {
                    Deadline deadline = next.getDeadline();
                    if (deadline.isBefore(jCurrentTimeMillis)) {
                        next.failed(DeadlineTimeoutException.from(deadline));
                    }
                    if (next.isDone()) {
                        listIterator.remove();
                        this.completedRequests.add(next);
                    }
                }
            }
            this.lock.unlock();
            fireCallbacks();
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    private int getMax(T t) {
        Integer num = this.maxPerRoute.get(t);
        if (num != null) {
            return num.intValue();
        }
        return this.defaultMaxPerRoute;
    }

    @Override // org.apache.hc.core5.pool.ConnPoolControl
    public void setMaxTotal(int i) {
        Args.positive(i, "Max value");
        this.lock.lock();
        try {
            this.maxTotal = i;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.apache.hc.core5.pool.ConnPoolControl
    public int getMaxTotal() {
        this.lock.lock();
        try {
            return this.maxTotal;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.apache.hc.core5.pool.ConnPoolControl
    public void setDefaultMaxPerRoute(int i) {
        Args.positive(i, "Max value");
        this.lock.lock();
        try {
            this.defaultMaxPerRoute = i;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.apache.hc.core5.pool.ConnPoolControl
    public int getDefaultMaxPerRoute() {
        this.lock.lock();
        try {
            return this.defaultMaxPerRoute;
        } finally {
            this.lock.unlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.concurrent.locks.ReentrantLock] */
    @Override // org.apache.hc.core5.pool.ConnPoolControl
    public void setMaxPerRoute(T t, int i) {
        Args.notNull(t, "Route");
        this.lock.lock();
        try {
            if (i > -1) {
                this.maxPerRoute.put(t, Integer.valueOf(i));
            } else {
                this.maxPerRoute.remove(t);
            }
            this = (StrictConnPool<T, C>) this.lock;
            this.unlock();
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    @Override // org.apache.hc.core5.pool.ConnPoolControl
    public int getMaxPerRoute(T t) {
        Args.notNull(t, "Route");
        this.lock.lock();
        try {
            return getMax(t);
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.apache.hc.core5.pool.ConnPoolStats
    public PoolStats getTotalStats() {
        this.lock.lock();
        try {
            int i = 0;
            for (LeaseRequest<T, C> leaseRequest : this.pendingRequests) {
                if (!leaseRequest.isDone() && !leaseRequest.getDeadline().isExpired()) {
                    i++;
                }
            }
            return new PoolStats(this.leased.size(), i, this.available.size(), this.maxTotal);
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.apache.hc.core5.pool.ConnPoolStats
    public PoolStats getStats(T t) {
        Args.notNull(t, "Route");
        this.lock.lock();
        try {
            PerRoutePool<T, C> pool = getPool(t);
            int i = 0;
            for (LeaseRequest<T, C> leaseRequest : this.pendingRequests) {
                if (!leaseRequest.isDone() && Objects.equals(t, leaseRequest.getRoute()) && !leaseRequest.getDeadline().isExpired()) {
                    i++;
                }
            }
            return new PoolStats(pool.getLeasedCount(), i, pool.getAvailableCount(), getMax(t));
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.apache.hc.core5.pool.ConnPoolControl
    public Set<T> getRoutes() {
        this.lock.lock();
        try {
            return new HashSet(this.routeToPool.keySet());
        } finally {
            this.lock.unlock();
        }
    }

    public void enumAvailable(Callback<PoolEntry<T, C>> callback) {
        this.lock.lock();
        try {
            Iterator<PoolEntry<T, C>> it = this.available.iterator();
            while (it.hasNext()) {
                PoolEntry<T, C> next = it.next();
                callback.execute(next);
                if (!next.hasConnection()) {
                    getPool(next.getRoute()).remove(next);
                    it.remove();
                }
            }
            processPendingRequests();
            purgePoolMap();
        } finally {
            this.lock.unlock();
        }
    }

    public void enumLeased(Callback<PoolEntry<T, C>> callback) {
        this.lock.lock();
        try {
            Iterator<PoolEntry<T, C>> it = this.leased.iterator();
            while (it.hasNext()) {
                callback.execute(it.next());
            }
            processPendingRequests();
        } finally {
            this.lock.unlock();
        }
    }

    private void purgePoolMap() {
        Iterator<Map.Entry<T, PerRoutePool<T, C>>> it = this.routeToPool.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue().getAllocatedCount() == 0) {
                it.remove();
            }
        }
    }

    @Override // org.apache.hc.core5.pool.ConnPoolControl
    public void closeIdle(TimeValue timeValue) {
        final long jCurrentTimeMillis = System.currentTimeMillis() - (TimeValue.isPositive(timeValue) ? timeValue.toMilliseconds() : 0L);
        enumAvailable(new Callback() { // from class: org.apache.hc.core5.pool.StrictConnPool$$ExternalSyntheticLambda1
            @Override // org.apache.hc.core5.function.Callback
            public final void execute(Object obj) {
                StrictConnPool.lambda$closeIdle$0(jCurrentTimeMillis, (PoolEntry) obj);
            }
        });
    }

    static /* synthetic */ void lambda$closeIdle$0(long j, PoolEntry poolEntry) {
        if (poolEntry.getUpdated() <= j) {
            poolEntry.discardConnection(CloseMode.GRACEFUL);
        }
    }

    @Override // org.apache.hc.core5.pool.ConnPoolControl
    public void closeExpired() {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        enumAvailable(new Callback() { // from class: org.apache.hc.core5.pool.StrictConnPool$$ExternalSyntheticLambda0
            @Override // org.apache.hc.core5.function.Callback
            public final void execute(Object obj) {
                StrictConnPool.lambda$closeExpired$1(jCurrentTimeMillis, (PoolEntry) obj);
            }
        });
    }

    static /* synthetic */ void lambda$closeExpired$1(long j, PoolEntry poolEntry) {
        if (poolEntry.getExpiryDeadline().isBefore(j)) {
            poolEntry.discardConnection(CloseMode.GRACEFUL);
        }
    }

    public String toString() {
        return "[leased: " + this.leased.size() + "][available: " + this.available.size() + "][pending: " + this.pendingRequests.size() + "]";
    }

    static class LeaseRequest<T, C extends ModalCloseable> {
        private final AtomicBoolean completed = new AtomicBoolean();
        private final Deadline deadline;
        private volatile Exception ex;
        private final BasicFuture<PoolEntry<T, C>> future;
        private volatile PoolEntry<T, C> result;
        private final T route;
        private final Object state;

        public LeaseRequest(T t, Object obj, Timeout timeout, BasicFuture<PoolEntry<T, C>> basicFuture) {
            this.route = t;
            this.state = obj;
            this.deadline = Deadline.calculate(timeout);
            this.future = basicFuture;
        }

        public T getRoute() {
            return this.route;
        }

        public Object getState() {
            return this.state;
        }

        public Deadline getDeadline() {
            return this.deadline;
        }

        public boolean isDone() {
            return (this.ex == null && this.result == null) ? false : true;
        }

        public void failed(Exception exc) {
            if (this.completed.compareAndSet(false, true)) {
                this.ex = exc;
            }
        }

        public void completed(PoolEntry<T, C> poolEntry) {
            if (this.completed.compareAndSet(false, true)) {
                this.result = poolEntry;
            }
        }

        public BasicFuture<PoolEntry<T, C>> getFuture() {
            return this.future;
        }

        public PoolEntry<T, C> getResult() {
            return this.result;
        }

        public Exception getException() {
            return this.ex;
        }

        public String toString() {
            return "[" + this.route + "][" + this.state + "]";
        }
    }

    static class PerRoutePool<T, C extends ModalCloseable> {
        private final DisposalCallback<C> disposalCallback;
        private final T route;
        private final Set<PoolEntry<T, C>> leased = new HashSet();
        private final LinkedList<PoolEntry<T, C>> available = new LinkedList<>();

        PerRoutePool(T t, DisposalCallback<C> disposalCallback) {
            this.route = t;
            this.disposalCallback = disposalCallback;
        }

        public final T getRoute() {
            return this.route;
        }

        public int getLeasedCount() {
            return this.leased.size();
        }

        public int getAvailableCount() {
            return this.available.size();
        }

        public int getAllocatedCount() {
            return this.available.size() + this.leased.size();
        }

        public PoolEntry<T, C> getFree(Object obj) {
            if (this.available.isEmpty()) {
                return null;
            }
            if (obj != null) {
                Iterator<PoolEntry<T, C>> it = this.available.iterator();
                while (it.hasNext()) {
                    PoolEntry<T, C> next = it.next();
                    if (obj.equals(next.getState())) {
                        it.remove();
                        this.leased.add(next);
                        return next;
                    }
                }
            }
            Iterator<PoolEntry<T, C>> it2 = this.available.iterator();
            while (it2.hasNext()) {
                PoolEntry<T, C> next2 = it2.next();
                if (next2.getState() == null) {
                    it2.remove();
                    this.leased.add(next2);
                    return next2;
                }
            }
            return null;
        }

        public PoolEntry<T, C> getLastUsed() {
            return this.available.peekLast();
        }

        public boolean remove(PoolEntry<T, C> poolEntry) {
            return this.available.remove(poolEntry) || this.leased.remove(poolEntry);
        }

        public void free(PoolEntry<T, C> poolEntry, boolean z) {
            Asserts.check(this.leased.remove(poolEntry), "Entry %s has not been leased from this pool", poolEntry);
            if (z) {
                this.available.addFirst(poolEntry);
            }
        }

        public PoolEntry<T, C> createEntry(TimeValue timeValue) {
            PoolEntry<T, C> poolEntry = new PoolEntry<>(this.route, timeValue, this.disposalCallback);
            this.leased.add(poolEntry);
            return poolEntry;
        }

        public void shutdown(CloseMode closeMode) {
            while (true) {
                PoolEntry<T, C> poolEntryPoll = this.available.poll();
                if (poolEntryPoll == null) {
                    break;
                } else {
                    poolEntryPoll.discardConnection(closeMode);
                }
            }
            Iterator<PoolEntry<T, C>> it = this.leased.iterator();
            while (it.hasNext()) {
                it.next().discardConnection(closeMode);
            }
            this.leased.clear();
        }

        public String toString() {
            return "[route: " + this.route + "][leased: " + this.leased.size() + "][available: " + this.available.size() + "]";
        }
    }
}
