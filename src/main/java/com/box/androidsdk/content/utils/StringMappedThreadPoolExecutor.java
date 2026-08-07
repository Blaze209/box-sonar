package com.box.androidsdk.content.utils;

import java.lang.ref.WeakReference;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes13.dex */
public final class StringMappedThreadPoolExecutor extends ThreadPoolExecutor {
    private final ConcurrentHashMap<String, WeakReference<Runnable>> mRunningTasks;

    public StringMappedThreadPoolExecutor(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory);
        this.mRunningTasks = new ConcurrentHashMap<>();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
        this.mRunningTasks.put(runnable.toString(), new WeakReference<>(runnable));
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        this.mRunningTasks.remove(runnable.toString());
    }

    public Runnable getTaskFor(String str) {
        WeakReference<Runnable> weakReference = this.mRunningTasks.get(str);
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }
}
