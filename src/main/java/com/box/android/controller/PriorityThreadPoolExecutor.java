package com.box.android.controller;

import com.box.android.coreservices.modelcontroller.PriorityFutureTask;
import java.util.concurrent.Callable;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes10.dex */
public class PriorityThreadPoolExecutor extends ThreadPoolExecutor {
    public PriorityThreadPoolExecutor(int i, int i2, long j, TimeUnit timeUnit, PriorityBlockingQueue<Runnable> priorityBlockingQueue) {
        super(i, i2, j, timeUnit, priorityBlockingQueue);
    }

    public PriorityThreadPoolExecutor(int i, int i2, long j, TimeUnit timeUnit, PriorityBlockingQueue<Runnable> priorityBlockingQueue, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, priorityBlockingQueue, threadFactory);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new PriorityFutureTask(runnable, t);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        throw new UnsupportedOperationException("Implement this method if you want to use PriorityThreadPoolExecutor with callables.");
    }
}
