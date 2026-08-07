package io.split.android.client.service.impressions.observer;

import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes4.dex */
class ImpressionsObserverCacheImpl implements ImpressionsObserverCache {
    private final ListenableLruCache<Long, Long> mCache;
    private final ReadWriteLock mLock;
    private final PersistentImpressionsObserverCacheStorage mPersistentStorage;

    ImpressionsObserverCacheImpl(PersistentImpressionsObserverCacheStorage persistentStorage, int cacheSize) {
        this(persistentStorage, (ListenableLruCache<Long, Long>) new ListenableLruCache(cacheSize, persistentStorage));
    }

    ImpressionsObserverCacheImpl(PersistentImpressionsObserverCacheStorage persistentStorage, ListenableLruCache<Long, Long> cache) {
        this.mPersistentStorage = (PersistentImpressionsObserverCacheStorage) Utils.checkNotNull(persistentStorage);
        this.mCache = (ListenableLruCache) Utils.checkNotNull(cache);
        this.mLock = new ReentrantReadWriteLock();
    }

    @Override // io.split.android.client.service.impressions.observer.ImpressionsObserverCache
    public Long get(long hash) {
        this.mLock.readLock().lock();
        try {
            Long fromCache = getFromCache(hash);
            if (fromCache != null) {
                this.mLock.readLock().unlock();
                return fromCache;
            }
            this.mLock.readLock().unlock();
            this.mLock.writeLock().lock();
            try {
                Long fromCache2 = getFromCache(hash);
                if (fromCache2 != null) {
                    return fromCache2;
                }
                Long fromPersistentStorage = getFromPersistentStorage(hash);
                if (fromPersistentStorage == null) {
                    return null;
                }
                putInCache(hash, fromPersistentStorage.longValue());
                return fromPersistentStorage;
            } finally {
                this.mLock.writeLock().unlock();
            }
        } catch (Throwable th) {
            this.mLock.readLock().unlock();
            throw th;
        }
    }

    @Override // io.split.android.client.service.impressions.observer.ImpressionsObserverCache
    public void put(long hash, long time) {
        this.mLock.writeLock().lock();
        try {
            putInCache(hash, time);
            putInPersistentStorage(hash, time);
        } finally {
            this.mLock.writeLock().unlock();
        }
    }

    @Override // io.split.android.client.service.impressions.observer.ImpressionsObserverCache
    public void persist() {
        this.mPersistentStorage.persist();
    }

    private Long getFromCache(long hash) {
        try {
            Long l = this.mCache.get(Long.valueOf(hash));
            if (l != null) {
                return l;
            }
            return null;
        } catch (Exception e) {
            logWarning("Error while getting value from cache", e);
            return null;
        }
    }

    private Long getFromPersistentStorage(long hash) {
        try {
            return this.mPersistentStorage.get(hash);
        } catch (Exception e) {
            logWarning("Error while getting value from persistent storage", e);
            return null;
        }
    }

    private void putInCache(long hash, long time) {
        try {
            this.mCache.put(Long.valueOf(hash), Long.valueOf(time));
        } catch (Exception e) {
            logWarning("Error while putting value in cache", e);
        }
    }

    private void putInPersistentStorage(long hash, long time) {
        try {
            this.mPersistentStorage.put(hash, time);
        } catch (Exception e) {
            logWarning("Error while putting value in persistent storage", e);
        }
    }

    private static void logWarning(String message, Exception e) {
        Logger.w("ImpressionsObserverCache: " + message + ": " + e.getLocalizedMessage());
    }
}
