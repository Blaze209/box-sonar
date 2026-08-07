package com.microsoft.identity.common.java.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes14.dex */
public class ResultFuture<T> implements Future<T> {
    private final CountDownLatch mCountDownLatch = new CountDownLatch(1);
    private T mResult = null;
    private Throwable mException = null;
    private final List<BiConsumer<T, Throwable>> mConsumers = new ArrayList();

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.mCountDownLatch.getCount() == 0;
    }

    @Override // java.util.concurrent.Future
    public T get() throws ExecutionException, InterruptedException {
        this.mCountDownLatch.await();
        if (this.mException != null) {
            throw new ExecutionException(this.mException);
        }
        return this.mResult;
    }

    @Override // java.util.concurrent.Future
    public T get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        if (timeUnit == null) {
            throw new NullPointerException("timeUnit is marked non-null but is null");
        }
        if (this.mCountDownLatch.await(j, timeUnit)) {
            if (this.mException != null) {
                throw new ExecutionException(this.mException);
            }
            return this.mResult;
        }
        throw new TimeoutException("Timed out waiting for: " + j + timeUnit.name());
    }

    public synchronized void setException(Throwable th) {
        try {
            if (th == null) {
                throw new NullPointerException("exception is marked non-null but is null");
            }
            this.mException = th;
            this.mCountDownLatch.countDown();
            Iterator<BiConsumer<T, Throwable>> it = this.mConsumers.iterator();
            while (it.hasNext()) {
                it.next().accept(this.mResult, th);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void setResult(T t) {
        this.mResult = t;
        this.mCountDownLatch.countDown();
        Iterator<BiConsumer<T, Throwable>> it = this.mConsumers.iterator();
        while (it.hasNext()) {
            it.next().accept(t, this.mException);
        }
        this.mConsumers.clear();
    }

    public synchronized void whenComplete(BiConsumer<T, Throwable> biConsumer) {
        try {
            if (biConsumer == null) {
                throw new NullPointerException("consumerToAdd is marked non-null but is null");
            }
            if (isDone()) {
                biConsumer.accept(this.mResult, this.mException);
            } else {
                this.mConsumers.add(biConsumer);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
