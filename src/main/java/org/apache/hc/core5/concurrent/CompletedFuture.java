package org.apache.hc.core5.concurrent;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public class CompletedFuture<T> implements Future<T>, Cancellable {
    private final T result;

    @Override // org.apache.hc.core5.concurrent.Cancellable
    public boolean cancel() {
        return false;
    }

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
        return true;
    }

    public CompletedFuture(T t) {
        this.result = t;
    }

    @Override // java.util.concurrent.Future
    public T get() {
        return this.result;
    }

    @Override // java.util.concurrent.Future
    public T get(long j, TimeUnit timeUnit) {
        return this.result;
    }
}
