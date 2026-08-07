package io.opentelemetry.sdk.internal;

import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
public final class DaemonThreadFactory implements ThreadFactory {
    private final AtomicInteger counter = new AtomicInteger();
    private final ThreadFactory delegate = Executors.defaultThreadFactory();
    private final String namePrefix;

    public DaemonThreadFactory(String str) {
        this.namePrefix = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread threadNewThread = this.delegate.newThread(runnable);
        try {
            threadNewThread.setDaemon(true);
            threadNewThread.setName(this.namePrefix + CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR + this.counter.incrementAndGet());
        } catch (SecurityException unused) {
        }
        return threadNewThread;
    }
}
