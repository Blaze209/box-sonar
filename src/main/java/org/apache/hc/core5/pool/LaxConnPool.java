package org.apache.hc.core5.pool;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicMarkableReference;
import org.apache.hc.core5.concurrent.BasicFuture;
import org.apache.hc.core5.concurrent.Cancellable;
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
public class LaxConnPool<T, C extends ModalCloseable> implements ManagedConnPool<T, C> {
    private final ConnPoolListener<T> connPoolListener;
    private volatile int defaultMaxPerRoute;
    private final DisposalCallback<C> disposalCallback;
    private final AtomicBoolean isShutDown;
    private final PoolReusePolicy policy;
    private final ConcurrentMap<T, PerRoutePool<T, C>> routeToPool;
    private final TimeValue timeToLive;

    @Override // org.apache.hc.core5.pool.ConnPoolControl
    public int getMaxTotal() {
        return 0;
    }

    @Override // org.apache.hc.core5.pool.ConnPoolControl
    public void setMaxTotal(int i) {
    }

    public LaxConnPool(int i, TimeValue timeValue, PoolReusePolicy poolReusePolicy, DisposalCallback<C> disposalCallback, ConnPoolListener<T> connPoolListener) {
        Args.positive(i, "Max per route value");
        this.timeToLive = TimeValue.defaultsToNegativeOneMillisecond(timeValue);
        this.policy = poolReusePolicy == null ? PoolReusePolicy.LIFO : poolReusePolicy;
        this.disposalCallback = disposalCallback;
        this.connPoolListener = connPoolListener;
        this.routeToPool = new ConcurrentHashMap();
        this.isShutDown = new AtomicBoolean();
        this.defaultMaxPerRoute = i;
    }

    public LaxConnPool(int i, TimeValue timeValue, PoolReusePolicy poolReusePolicy, ConnPoolListener<T> connPoolListener) {
        this(i, timeValue, poolReusePolicy, null, connPoolListener);
    }

    public LaxConnPool(int i) {
        this(i, TimeValue.NEG_ONE_MILLISECOND, PoolReusePolicy.LIFO, null, null);
    }

    public boolean isShutdown() {
        return this.isShutDown.get();
    }

    @Override // org.apache.hc.core5.io.ModalCloseable
    public void close(CloseMode closeMode) {
        if (this.isShutDown.compareAndSet(false, true)) {
            Iterator<PerRoutePool<T, C>> it = this.routeToPool.values().iterator();
            while (it.hasNext()) {
                it.next().shutdown(closeMode);
            }
            this.routeToPool.clear();
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
        PerRoutePool<T, C> perRoutePool2 = new PerRoutePool<>(t, this.defaultMaxPerRoute, this.timeToLive, this.policy, this, this.disposalCallback, this.connPoolListener);
        PerRoutePool<T, C> perRoutePoolPutIfAbsent = this.routeToPool.putIfAbsent(t, perRoutePool2);
        return perRoutePoolPutIfAbsent == null ? perRoutePool2 : perRoutePoolPutIfAbsent;
    }

    @Override // org.apache.hc.core5.pool.ConnPool
    public Future<PoolEntry<T, C>> lease(T t, Object obj, Timeout timeout, FutureCallback<PoolEntry<T, C>> futureCallback) {
        Args.notNull(t, "Route");
        Asserts.check(!this.isShutDown.get(), "Connection pool shut down");
        return getPool(t).lease(obj, timeout, futureCallback);
    }

    public Future<PoolEntry<T, C>> lease(T t, Object obj) {
        return lease(t, obj, Timeout.DISABLED, null);
    }

    @Override // org.apache.hc.core5.pool.ConnPool
    public void release(PoolEntry<T, C> poolEntry, boolean z) {
        if (poolEntry == null || this.isShutDown.get()) {
            return;
        }
        getPool(poolEntry.getRoute()).release(poolEntry, z);
    }

    public void validatePendingRequests() {
        Iterator<PerRoutePool<T, C>> it = this.routeToPool.values().iterator();
        while (it.hasNext()) {
            it.next().validatePendingRequests();
        }
    }

    @Override // org.apache.hc.core5.pool.ConnPoolControl
    public void setDefaultMaxPerRoute(int i) {
        Args.positive(i, "Max value");
        this.defaultMaxPerRoute = i;
    }

    @Override // org.apache.hc.core5.pool.ConnPoolControl
    public int getDefaultMaxPerRoute() {
        return this.defaultMaxPerRoute;
    }

    @Override // org.apache.hc.core5.pool.ConnPoolControl
    public void setMaxPerRoute(T t, int i) {
        Args.notNull(t, "Route");
        PerRoutePool<T, C> pool = getPool(t);
        if (i <= -1) {
            i = this.defaultMaxPerRoute;
        }
        pool.setMax(i);
    }

    @Override // org.apache.hc.core5.pool.ConnPoolControl
    public int getMaxPerRoute(T t) {
        Args.notNull(t, "Route");
        return getPool(t).getMax();
    }

    @Override // org.apache.hc.core5.pool.ConnPoolStats
    public PoolStats getTotalStats() {
        int leasedCount = 0;
        int pendingCount = 0;
        int availableCount = 0;
        int max = 0;
        for (PerRoutePool<T, C> perRoutePool : this.routeToPool.values()) {
            leasedCount += perRoutePool.getLeasedCount();
            pendingCount += perRoutePool.getPendingCount();
            availableCount += perRoutePool.getAvailableCount();
            max += perRoutePool.getMax();
        }
        return new PoolStats(leasedCount, pendingCount, availableCount, max);
    }

    @Override // org.apache.hc.core5.pool.ConnPoolStats
    public PoolStats getStats(T t) {
        Args.notNull(t, "Route");
        PerRoutePool<T, C> pool = getPool(t);
        return new PoolStats(pool.getLeasedCount(), pool.getPendingCount(), pool.getAvailableCount(), pool.getMax());
    }

    @Override // org.apache.hc.core5.pool.ConnPoolControl
    public Set<T> getRoutes() {
        return new HashSet(this.routeToPool.keySet());
    }

    public void enumAvailable(Callback<PoolEntry<T, C>> callback) {
        Iterator<PerRoutePool<T, C>> it = this.routeToPool.values().iterator();
        while (it.hasNext()) {
            it.next().enumAvailable(callback);
        }
    }

    public void enumLeased(Callback<PoolEntry<T, C>> callback) {
        Iterator<PerRoutePool<T, C>> it = this.routeToPool.values().iterator();
        while (it.hasNext()) {
            it.next().enumLeased(callback);
        }
    }

    @Override // org.apache.hc.core5.pool.ConnPoolControl
    public void closeIdle(TimeValue timeValue) {
        final long jCurrentTimeMillis = System.currentTimeMillis() - (TimeValue.isPositive(timeValue) ? timeValue.toMilliseconds() : 0L);
        enumAvailable(new Callback() { // from class: org.apache.hc.core5.pool.LaxConnPool$$ExternalSyntheticLambda1
            @Override // org.apache.hc.core5.function.Callback
            public final void execute(Object obj) {
                LaxConnPool.lambda$closeIdle$0(jCurrentTimeMillis, (PoolEntry) obj);
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
        enumAvailable(new Callback() { // from class: org.apache.hc.core5.pool.LaxConnPool$$ExternalSyntheticLambda0
            @Override // org.apache.hc.core5.function.Callback
            public final void execute(Object obj) {
                LaxConnPool.lambda$closeExpired$1(jCurrentTimeMillis, (PoolEntry) obj);
            }
        });
    }

    static /* synthetic */ void lambda$closeExpired$1(long j, PoolEntry poolEntry) {
        if (poolEntry.getExpiryDeadline().isBefore(j)) {
            poolEntry.discardConnection(CloseMode.GRACEFUL);
        }
    }

    public String toString() {
        PoolStats totalStats = getTotalStats();
        return "[leased: " + totalStats.getLeased() + "][available: " + totalStats.getAvailable() + "][pending: " + totalStats.getPending() + "]";
    }

    static class LeaseRequest<T, C extends ModalCloseable> implements Cancellable {
        private final Deadline deadline;
        private final BasicFuture<PoolEntry<T, C>> future;
        private final Object state;

        LeaseRequest(Object obj, Timeout timeout, BasicFuture<PoolEntry<T, C>> basicFuture) {
            this.state = obj;
            this.deadline = Deadline.calculate(timeout);
            this.future = basicFuture;
        }

        BasicFuture<PoolEntry<T, C>> getFuture() {
            return this.future;
        }

        public Object getState() {
            return this.state;
        }

        public Deadline getDeadline() {
            return this.deadline;
        }

        public boolean isDone() {
            return this.future.isDone();
        }

        public boolean completed(PoolEntry<T, C> poolEntry) {
            return this.future.completed(poolEntry);
        }

        public boolean failed(Exception exc) {
            return this.future.failed(exc);
        }

        @Override // org.apache.hc.core5.concurrent.Cancellable
        public boolean cancel() {
            return this.future.cancel();
        }
    }

    static class PerRoutePool<T, C extends ModalCloseable> {
        private final ConnPoolListener<T> connPoolListener;
        private final ConnPoolStats<T> connPoolStats;
        private final DisposalCallback<C> disposalCallback;
        private volatile int max;
        private final PoolReusePolicy policy;
        private final T route;
        private final TimeValue timeToLive;
        private final ConcurrentMap<PoolEntry<T, C>, Boolean> leased = new ConcurrentHashMap();
        private final Deque<AtomicMarkableReference<PoolEntry<T, C>>> available = new ConcurrentLinkedDeque();
        private final Deque<LeaseRequest<T, C>> pending = new ConcurrentLinkedDeque();
        private final AtomicBoolean terminated = new AtomicBoolean();
        private final AtomicInteger allocated = new AtomicInteger(0);
        private final AtomicLong releaseSeqNum = new AtomicLong(0);

        private enum RequestServiceStrategy {
            FIRST_SUCCESSFUL,
            ALL
        }

        PerRoutePool(T t, int i, TimeValue timeValue, PoolReusePolicy poolReusePolicy, ConnPoolStats<T> connPoolStats, DisposalCallback<C> disposalCallback, ConnPoolListener<T> connPoolListener) {
            this.route = t;
            this.timeToLive = timeValue;
            this.policy = poolReusePolicy;
            this.connPoolStats = connPoolStats;
            this.disposalCallback = disposalCallback;
            this.connPoolListener = connPoolListener;
            this.max = i;
        }

        public void shutdown(CloseMode closeMode) {
            if (!this.terminated.compareAndSet(false, true)) {
                return;
            }
            while (true) {
                AtomicMarkableReference<PoolEntry<T, C>> atomicMarkableReferencePoll = this.available.poll();
                if (atomicMarkableReferencePoll == null) {
                    break;
                } else {
                    atomicMarkableReferencePoll.getReference().discardConnection(closeMode);
                }
            }
            Iterator<PoolEntry<T, C>> it = this.leased.keySet().iterator();
            while (it.hasNext()) {
                it.next().discardConnection(closeMode);
            }
            this.leased.clear();
            while (true) {
                LeaseRequest<T, C> leaseRequestPoll = this.pending.poll();
                if (leaseRequestPoll == null) {
                    return;
                } else {
                    leaseRequestPoll.cancel();
                }
            }
        }

        private PoolEntry<T, C> createPoolEntry() {
            int i;
            int i2;
            int i3 = this.max;
            do {
                i = this.allocated.get();
                i2 = i < i3 ? i + 1 : i;
            } while (!this.allocated.compareAndSet(i, i2));
            if (i < i2) {
                return new PoolEntry<>(this.route, this.timeToLive, this.disposalCallback);
            }
            return null;
        }

        private void deallocatePoolEntry() {
            this.allocated.decrementAndGet();
        }

        private void addLeased(PoolEntry<T, C> poolEntry) {
            if (this.leased.putIfAbsent(poolEntry, Boolean.TRUE) != null) {
                throw new IllegalStateException("Pool entry already present in the set of leased entries");
            }
            ConnPoolListener<T> connPoolListener = this.connPoolListener;
            if (connPoolListener != null) {
                connPoolListener.onLease(this.route, this.connPoolStats);
            }
        }

        private void removeLeased(PoolEntry<T, C> poolEntry) {
            ConnPoolListener<T> connPoolListener = this.connPoolListener;
            if (connPoolListener != null) {
                connPoolListener.onRelease(this.route, this.connPoolStats);
            }
            if (!this.leased.remove(poolEntry, Boolean.TRUE)) {
                throw new IllegalStateException("Pool entry is not present in the set of leased entries");
            }
        }

        private PoolEntry<T, C> getAvailableEntry(Object obj) {
            Iterator<AtomicMarkableReference<PoolEntry<T, C>>> it = this.available.iterator();
            while (it.hasNext()) {
                AtomicMarkableReference<PoolEntry<T, C>> next = it.next();
                PoolEntry<T, C> reference = next.getReference();
                if (next.compareAndSet(reference, reference, false, true)) {
                    it.remove();
                    if (reference.getExpiryDeadline().isExpired()) {
                        reference.discardConnection(CloseMode.GRACEFUL);
                    }
                    if (!Objects.equals(reference.getState(), obj)) {
                        reference.discardConnection(CloseMode.GRACEFUL);
                    }
                    return reference;
                }
            }
            return null;
        }

        public Future<PoolEntry<T, C>> lease(Object obj, Timeout timeout, FutureCallback<PoolEntry<T, C>> futureCallback) {
            PoolEntry<T, C> availableEntry;
            Asserts.check(!this.terminated.get(), "Connection pool shut down");
            BasicFuture basicFuture = new BasicFuture<PoolEntry<T, C>>(futureCallback) { // from class: org.apache.hc.core5.pool.LaxConnPool.PerRoutePool.1
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
            long j = this.releaseSeqNum.get();
            if (this.pending.isEmpty()) {
                availableEntry = getAvailableEntry(obj);
                if (availableEntry == null) {
                    availableEntry = createPoolEntry();
                }
            } else {
                availableEntry = null;
            }
            if (availableEntry != null) {
                addLeased(availableEntry);
                basicFuture.completed(availableEntry);
                return basicFuture;
            }
            this.pending.add(new LeaseRequest<>(obj, timeout, basicFuture));
            if (j != this.releaseSeqNum.get()) {
                servicePendingRequest();
            }
            return basicFuture;
        }

        public void release(PoolEntry<T, C> poolEntry, boolean z) {
            removeLeased(poolEntry);
            if (!z || poolEntry.getExpiryDeadline().isExpired()) {
                poolEntry.discardConnection(CloseMode.GRACEFUL);
            }
            if (poolEntry.hasConnection()) {
                int i = AnonymousClass1.$SwitchMap$org$apache$hc$core5$pool$PoolReusePolicy[this.policy.ordinal()];
                if (i == 1) {
                    this.available.addFirst(new AtomicMarkableReference<>(poolEntry, false));
                } else if (i == 2) {
                    this.available.addLast(new AtomicMarkableReference<>(poolEntry, false));
                } else {
                    throw new IllegalStateException("Unexpected ConnPoolPolicy value: " + this.policy);
                }
            } else {
                deallocatePoolEntry();
            }
            this.releaseSeqNum.incrementAndGet();
            servicePendingRequest();
        }

        private void servicePendingRequest() {
            servicePendingRequests(RequestServiceStrategy.FIRST_SUCCESSFUL);
        }

        private void servicePendingRequests(RequestServiceStrategy requestServiceStrategy) {
            while (true) {
                LeaseRequest<T, C> leaseRequestPoll = this.pending.poll();
                if (leaseRequestPoll == null) {
                    return;
                }
                if (!leaseRequestPoll.isDone()) {
                    Object state = leaseRequestPoll.getState();
                    Deadline deadline = leaseRequestPoll.getDeadline();
                    if (deadline.isExpired()) {
                        leaseRequestPoll.failed(DeadlineTimeoutException.from(deadline));
                    } else {
                        long j = this.releaseSeqNum.get();
                        PoolEntry<T, C> availableEntry = getAvailableEntry(state);
                        if (availableEntry == null) {
                            availableEntry = createPoolEntry();
                        }
                        if (availableEntry != null) {
                            addLeased(availableEntry);
                            if (!leaseRequestPoll.completed(availableEntry)) {
                                release(availableEntry, true);
                            }
                            if (requestServiceStrategy == RequestServiceStrategy.FIRST_SUCCESSFUL) {
                                return;
                            }
                        } else {
                            this.pending.addFirst(leaseRequestPoll);
                            if (j == this.releaseSeqNum.get()) {
                                return;
                            }
                        }
                    }
                }
            }
        }

        public void validatePendingRequests() {
            Iterator<LeaseRequest<T, C>> it = this.pending.iterator();
            while (it.hasNext()) {
                LeaseRequest<T, C> next = it.next();
                if (next.getFuture().isCancelled() && !next.isDone()) {
                    it.remove();
                } else {
                    Deadline deadline = next.getDeadline();
                    if (deadline.isExpired()) {
                        next.failed(DeadlineTimeoutException.from(deadline));
                    }
                    if (next.isDone()) {
                        it.remove();
                    }
                }
            }
        }

        public final T getRoute() {
            return this.route;
        }

        public int getMax() {
            return this.max;
        }

        public void setMax(int i) {
            this.max = i;
        }

        public int getPendingCount() {
            return this.pending.size();
        }

        public int getLeasedCount() {
            return this.leased.size();
        }

        public int getAvailableCount() {
            return this.available.size();
        }

        public void enumAvailable(Callback<PoolEntry<T, C>> callback) {
            Iterator<AtomicMarkableReference<PoolEntry<T, C>>> it = this.available.iterator();
            while (it.hasNext()) {
                AtomicMarkableReference<PoolEntry<T, C>> next = it.next();
                PoolEntry<T, C> reference = next.getReference();
                if (next.compareAndSet(reference, reference, false, true)) {
                    callback.execute(reference);
                    if (!reference.hasConnection()) {
                        deallocatePoolEntry();
                        it.remove();
                    } else {
                        next.set(reference, false);
                    }
                }
            }
            this.releaseSeqNum.incrementAndGet();
            servicePendingRequests(RequestServiceStrategy.ALL);
        }

        public void enumLeased(Callback<PoolEntry<T, C>> callback) {
            Iterator<PoolEntry<T, C>> it = this.leased.keySet().iterator();
            while (it.hasNext()) {
                PoolEntry<T, C> next = it.next();
                callback.execute(next);
                if (!next.hasConnection()) {
                    deallocatePoolEntry();
                    it.remove();
                }
            }
        }

        public String toString() {
            return "[route: " + this.route + "][leased: " + this.leased.size() + "][available: " + this.available.size() + "][pending: " + this.pending.size() + "]";
        }
    }

    /* JADX INFO: renamed from: org.apache.hc.core5.pool.LaxConnPool$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
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
}
