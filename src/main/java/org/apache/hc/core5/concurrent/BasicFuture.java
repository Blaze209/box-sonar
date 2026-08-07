package org.apache.hc.core5.concurrent;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.TimeoutValueException;

/* JADX INFO: loaded from: classes5.dex */
public class BasicFuture<T> implements Future<T>, Cancellable {
    private final FutureCallback<T> callback;
    private volatile boolean cancelled;
    private volatile boolean completed;
    private final Condition condition;
    private volatile Exception ex;
    private final ReentrantLock lock;
    private volatile T result;

    public BasicFuture(FutureCallback<T> futureCallback) {
        this.callback = futureCallback;
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.condition = reentrantLock.newCondition();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.completed;
    }

    private T getResult() throws ExecutionException {
        if (this.ex != null) {
            throw new ExecutionException(this.ex);
        }
        if (this.cancelled) {
            throw new CancellationException();
        }
        return this.result;
    }

    @Override // java.util.concurrent.Future
    public T get() throws ExecutionException, InterruptedException {
        this.lock.lock();
        while (!this.completed) {
            try {
                this.condition.await();
            } catch (Throwable th) {
                this.lock.unlock();
                throw th;
            }
        }
        T result = getResult();
        this.lock.unlock();
        return result;
    }

    @Override // java.util.concurrent.Future
    public T get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        T result;
        Args.notNull(timeUnit, "Time unit");
        long millis = timeUnit.toMillis(j);
        long jCurrentTimeMillis = millis <= 0 ? 0L : System.currentTimeMillis();
        try {
            this.lock.lock();
            if (!this.completed) {
                if (millis <= 0) {
                    throw TimeoutValueException.fromMilliseconds(millis, Math.abs(millis) + millis);
                }
                long jCurrentTimeMillis2 = millis;
                do {
                    this.condition.await(jCurrentTimeMillis2, TimeUnit.MILLISECONDS);
                    if (this.completed) {
                        result = getResult();
                    } else {
                        jCurrentTimeMillis2 = millis - (System.currentTimeMillis() - jCurrentTimeMillis);
                    }
                } while (jCurrentTimeMillis2 > 0);
                throw TimeoutValueException.fromMilliseconds(millis, Math.abs(jCurrentTimeMillis2) + millis);
            }
            result = getResult();
            this.lock.unlock();
            return result;
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    public boolean completed(T t) {
        this.lock.lock();
        try {
            if (!this.completed) {
                this.completed = true;
                this.result = t;
                this.condition.signalAll();
                this.lock.unlock();
                FutureCallback<T> futureCallback = this.callback;
                if (futureCallback != null) {
                    futureCallback.completed(t);
                }
                return true;
            }
            this.lock.unlock();
            return false;
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    public boolean failed(Exception exc) {
        this.lock.lock();
        try {
            if (!this.completed) {
                this.completed = true;
                this.ex = exc;
                this.condition.signalAll();
                this.lock.unlock();
                FutureCallback<T> futureCallback = this.callback;
                if (futureCallback != null) {
                    futureCallback.failed(exc);
                }
                return true;
            }
            this.lock.unlock();
            return false;
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        this.lock.lock();
        try {
            if (!this.completed) {
                this.completed = true;
                this.cancelled = true;
                this.condition.signalAll();
                this.lock.unlock();
                FutureCallback<T> futureCallback = this.callback;
                if (futureCallback != null) {
                    futureCallback.cancelled();
                }
                return true;
            }
            this.lock.unlock();
            return false;
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    @Override // org.apache.hc.core5.concurrent.Cancellable
    public boolean cancel() {
        return cancel(true);
    }
}
