package org.apache.hc.core5.concurrent;

import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultThreadFactory implements ThreadFactory {
    private final AtomicLong count;
    private final boolean daemon;
    private final ThreadGroup group;
    private final String namePrefix;

    public DefaultThreadFactory(String str, ThreadGroup threadGroup, boolean z) {
        this.namePrefix = str;
        this.group = threadGroup;
        this.daemon = z;
        this.count = new AtomicLong();
    }

    public DefaultThreadFactory(String str, boolean z) {
        this(str, null, z);
    }

    public DefaultThreadFactory(String str) {
        this(str, null, false);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.group, runnable, this.namePrefix + CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR + this.count.incrementAndGet());
        thread.setDaemon(this.daemon);
        return thread;
    }
}
