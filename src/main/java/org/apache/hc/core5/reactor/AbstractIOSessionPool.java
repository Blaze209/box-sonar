package org.apache.hc.core5.reactor;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.hc.core5.concurrent.ComplexFuture;
import org.apache.hc.core5.concurrent.FutureCallback;
import org.apache.hc.core5.concurrent.FutureContribution;
import org.apache.hc.core5.function.Callback;
import org.apache.hc.core5.http.ConnectionClosedException;
import org.apache.hc.core5.io.CloseMode;
import org.apache.hc.core5.io.ModalCloseable;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.Asserts;
import org.apache.hc.core5.util.TimeValue;
import org.apache.hc.core5.util.Timeout;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractIOSessionPool<T> implements ModalCloseable {
    private final ConcurrentMap<T, PoolEntry> sessionPool = new ConcurrentHashMap();
    private final AtomicBoolean closed = new AtomicBoolean();
    private final ReentrantLock lock = new ReentrantLock();

    protected abstract void closeSession(IOSession iOSession, CloseMode closeMode);

    protected abstract Future<IOSession> connectSession(T t, Timeout timeout, FutureCallback<IOSession> futureCallback);

    protected abstract void validateSession(IOSession iOSession, Callback<Boolean> callback);

    @Override // org.apache.hc.core5.io.ModalCloseable
    public final void close(CloseMode closeMode) {
        if (this.closed.compareAndSet(false, true)) {
            for (PoolEntry poolEntry : this.sessionPool.values()) {
                this.lock.lock();
                try {
                    if (poolEntry.session != null) {
                        closeSession(poolEntry.session, closeMode);
                        poolEntry.session = null;
                    }
                    if (poolEntry.sessionFuture != null) {
                        poolEntry.sessionFuture.cancel(true);
                        poolEntry.sessionFuture = null;
                    }
                    while (true) {
                        FutureCallback<IOSession> futureCallbackPoll = poolEntry.requestQueue.poll();
                        if (futureCallbackPoll != null) {
                            futureCallbackPoll.cancelled();
                        }
                    }
                    this.lock.unlock();
                } catch (Throwable th) {
                    this.lock.unlock();
                    throw th;
                }
            }
            this.sessionPool.clear();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        close(CloseMode.GRACEFUL);
    }

    PoolEntry getPoolEntry(T t) {
        PoolEntry poolEntry = this.sessionPool.get(t);
        if (poolEntry != null) {
            return poolEntry;
        }
        PoolEntry poolEntry2 = new PoolEntry();
        PoolEntry poolEntryPutIfAbsent = this.sessionPool.putIfAbsent(t, poolEntry2);
        return poolEntryPutIfAbsent == null ? poolEntry2 : poolEntryPutIfAbsent;
    }

    public final Future<IOSession> getSession(T t, Timeout timeout, FutureCallback<IOSession> futureCallback) {
        Args.notNull(t, "Endpoint");
        Asserts.check(!this.closed.get(), "Connection pool shut down");
        ComplexFuture complexFuture = new ComplexFuture(futureCallback);
        PoolEntry poolEntry = getPoolEntry(t);
        getSessionInternal(poolEntry, false, t, timeout, new AnonymousClass1(complexFuture, poolEntry, t, timeout));
        return complexFuture;
    }

    /* JADX INFO: renamed from: org.apache.hc.core5.reactor.AbstractIOSessionPool$1, reason: invalid class name */
    class AnonymousClass1 implements FutureCallback<IOSession> {
        final /* synthetic */ Timeout val$connectTimeout;
        final /* synthetic */ Object val$endpoint;
        final /* synthetic */ ComplexFuture val$future;
        final /* synthetic */ PoolEntry val$poolEntry;

        AnonymousClass1(ComplexFuture complexFuture, PoolEntry poolEntry, Object obj, Timeout timeout) {
            this.val$future = complexFuture;
            this.val$poolEntry = poolEntry;
            this.val$endpoint = obj;
            this.val$connectTimeout = timeout;
        }

        @Override // org.apache.hc.core5.concurrent.FutureCallback
        public void completed(final IOSession iOSession) {
            AbstractIOSessionPool abstractIOSessionPool = AbstractIOSessionPool.this;
            final ComplexFuture complexFuture = this.val$future;
            final PoolEntry poolEntry = this.val$poolEntry;
            final Object obj = this.val$endpoint;
            final Timeout timeout = this.val$connectTimeout;
            abstractIOSessionPool.validateSession(iOSession, new Callback() { // from class: org.apache.hc.core5.reactor.AbstractIOSessionPool$1$$ExternalSyntheticLambda0
                @Override // org.apache.hc.core5.function.Callback
                public final void execute(Object obj2) {
                    this.f$0.m16642xd9bc59cf(complexFuture, iOSession, poolEntry, obj, timeout, (Boolean) obj2);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$completed$0$org-apache-hc-core5-reactor-AbstractIOSessionPool$1, reason: not valid java name */
        /* synthetic */ void m16642xd9bc59cf(final ComplexFuture complexFuture, IOSession iOSession, PoolEntry poolEntry, Object obj, Timeout timeout, Boolean bool) {
            if (!bool.booleanValue()) {
                AbstractIOSessionPool.this.getSessionInternal(poolEntry, true, obj, timeout, new FutureContribution<IOSession>(complexFuture) { // from class: org.apache.hc.core5.reactor.AbstractIOSessionPool.1.1
                    @Override // org.apache.hc.core5.concurrent.FutureCallback
                    public void completed(IOSession iOSession2) {
                        complexFuture.completed(iOSession2);
                    }
                });
            } else {
                complexFuture.completed(iOSession);
            }
        }

        @Override // org.apache.hc.core5.concurrent.FutureCallback
        public void failed(Exception exc) {
            this.val$future.failed(exc);
        }

        @Override // org.apache.hc.core5.concurrent.FutureCallback
        public void cancelled() {
            this.val$future.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getSessionInternal(final PoolEntry poolEntry, boolean z, T t, Timeout timeout, FutureCallback<IOSession> futureCallback) {
        poolEntry.lock.lock();
        try {
            if (poolEntry.session != null && z) {
                closeSession(poolEntry.session, CloseMode.GRACEFUL);
                poolEntry.session = null;
            }
            if (poolEntry.session != null && !poolEntry.session.isOpen()) {
                poolEntry.session = null;
            }
            if (poolEntry.session != null) {
                futureCallback.completed(poolEntry.session);
            } else {
                poolEntry.requestQueue.add(futureCallback);
                if (poolEntry.sessionFuture != null && poolEntry.completed) {
                    poolEntry.sessionFuture = null;
                }
                if (poolEntry.sessionFuture == null) {
                    poolEntry.completed = false;
                    poolEntry.sessionFuture = connectSession(t, timeout, new FutureCallback<IOSession>() { // from class: org.apache.hc.core5.reactor.AbstractIOSessionPool.2
                        @Override // org.apache.hc.core5.concurrent.FutureCallback
                        public void completed(IOSession iOSession) {
                            poolEntry.lock.lock();
                            try {
                                poolEntry.completed = true;
                                if (poolEntry.session == null) {
                                    poolEntry.session = iOSession;
                                } else {
                                    AbstractIOSessionPool.this.closeSession(iOSession, CloseMode.GRACEFUL);
                                }
                                while (true) {
                                    FutureCallback<IOSession> futureCallbackPoll = poolEntry.requestQueue.poll();
                                    if (futureCallbackPoll == null) {
                                        return;
                                    } else {
                                        futureCallbackPoll.completed(iOSession);
                                    }
                                }
                            } finally {
                                poolEntry.lock.unlock();
                            }
                        }

                        @Override // org.apache.hc.core5.concurrent.FutureCallback
                        public void failed(Exception exc) {
                            poolEntry.lock.lock();
                            try {
                                poolEntry.completed = true;
                                poolEntry.session = null;
                                while (true) {
                                    FutureCallback<IOSession> futureCallbackPoll = poolEntry.requestQueue.poll();
                                    if (futureCallbackPoll != null) {
                                        futureCallbackPoll.failed(exc);
                                    } else {
                                        poolEntry.lock.unlock();
                                        return;
                                    }
                                }
                            } catch (Throwable th) {
                                poolEntry.lock.unlock();
                                throw th;
                            }
                        }

                        @Override // org.apache.hc.core5.concurrent.FutureCallback
                        public void cancelled() {
                            failed(new ConnectionClosedException("Connection request cancelled"));
                        }
                    });
                }
            }
        } finally {
            poolEntry.lock.unlock();
        }
    }

    public final void enumAvailable(Callback<IOSession> callback) {
        for (PoolEntry poolEntry : this.sessionPool.values()) {
            if (poolEntry.session != null) {
                this.lock.lock();
                try {
                    if (poolEntry.session != null) {
                        callback.execute(poolEntry.session);
                        if (!poolEntry.session.isOpen()) {
                            poolEntry.session = null;
                        }
                    }
                    this.lock.unlock();
                } catch (Throwable th) {
                    this.lock.unlock();
                    throw th;
                }
            }
        }
    }

    public final void closeIdle(TimeValue timeValue) {
        long jCurrentTimeMillis = System.currentTimeMillis() - (TimeValue.isPositive(timeValue) ? timeValue.toMilliseconds() : 0L);
        for (PoolEntry poolEntry : this.sessionPool.values()) {
            if (poolEntry.session != null) {
                this.lock.lock();
                try {
                    if (poolEntry.session != null && poolEntry.session.getLastReadTime() <= jCurrentTimeMillis) {
                        closeSession(poolEntry.session, CloseMode.GRACEFUL);
                        poolEntry.session = null;
                    }
                    this.lock.unlock();
                } catch (Throwable th) {
                    this.lock.unlock();
                    throw th;
                }
            }
        }
    }

    public final Set<T> getRoutes() {
        return new HashSet(this.sessionPool.keySet());
    }

    public String toString() {
        return "I/O sessions: " + this.sessionPool.size();
    }

    static class PoolEntry {
        volatile boolean completed;
        volatile IOSession session;
        volatile Future<IOSession> sessionFuture;
        final Queue<FutureCallback<IOSession>> requestQueue = new ArrayDeque();
        final ReentrantLock lock = new ReentrantLock();

        PoolEntry() {
        }
    }
}
