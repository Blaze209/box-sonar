package com.microsoft.identity.common.java.cache;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes14.dex */
public class HttpCache {
    private static IHttpCacheCallback sHttpCache;
    private static final ReentrantReadWriteLock sLock = new ReentrantReadWriteLock();

    public interface IHttpCacheCallback {
        void flush();
    }

    public static void setHttpCache(IHttpCacheCallback iHttpCacheCallback) {
        sLock.writeLock().lock();
        try {
            sHttpCache = iHttpCacheCallback;
        } finally {
            sLock.writeLock().unlock();
        }
    }

    public static void flush() {
        sLock.readLock().lock();
        try {
            IHttpCacheCallback iHttpCacheCallback = sHttpCache;
            if (iHttpCacheCallback != null) {
                iHttpCacheCallback.flush();
            }
        } finally {
            sLock.readLock().unlock();
        }
    }
}
