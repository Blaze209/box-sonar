package io.split.android.client.service.impressions.observer;

import io.split.android.client.storage.db.impressions.observer.ImpressionsObserverCacheDao;
import io.split.android.client.storage.db.impressions.observer.ImpressionsObserverCacheEntity;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public class SqlitePersistentImpressionsObserverCacheStorage implements PersistentImpressionsObserverCacheStorage {
    private final Map<Long, Long> mCache;
    private final PeriodicPersistenceTask.OnExecutedListener mCallback;
    private final AtomicBoolean mDelayedSyncRunning;
    private final ScheduledExecutorService mExecutorsService;
    private final long mExpirationPeriod;
    private final ImpressionsObserverCacheDao mImpressionsObserverCacheDao;

    public SqlitePersistentImpressionsObserverCacheStorage(ImpressionsObserverCacheDao impressionsObserverCacheDao, long expirationPeriod, ScheduledThreadPoolExecutor executorService) {
        this(impressionsObserverCacheDao, expirationPeriod, executorService, new AtomicBoolean(false));
    }

    SqlitePersistentImpressionsObserverCacheStorage(ImpressionsObserverCacheDao impressionsObserverCacheDao, long expirationPeriod, ScheduledExecutorService executorService, AtomicBoolean delayedSyncRunning) {
        this.mCache = new ConcurrentHashMap();
        this.mImpressionsObserverCacheDao = (ImpressionsObserverCacheDao) Utils.checkNotNull(impressionsObserverCacheDao);
        this.mExpirationPeriod = expirationPeriod;
        this.mExecutorsService = executorService;
        this.mDelayedSyncRunning = delayedSyncRunning;
        this.mCallback = new PeriodicPersistenceTask.OnExecutedListener() { // from class: io.split.android.client.service.impressions.observer.SqlitePersistentImpressionsObserverCacheStorage.1
            @Override // io.split.android.client.service.impressions.observer.PeriodicPersistenceTask.OnExecutedListener
            public void onExecuted() {
                Logger.v("Impressions observer cache persisted");
                SqlitePersistentImpressionsObserverCacheStorage.this.mDelayedSyncRunning.compareAndSet(true, false);
            }
        };
    }

    @Override // io.split.android.client.service.impressions.observer.ImpressionsObserverCache
    public void put(long hash, long time) {
        this.mCache.put(Long.valueOf(hash), Long.valueOf(time));
    }

    @Override // io.split.android.client.service.impressions.observer.ImpressionsObserverCache
    public Long get(long hash) {
        ImpressionsObserverCacheEntity impressionsObserverCacheEntity = this.mImpressionsObserverCacheDao.get(Long.valueOf(hash));
        if (impressionsObserverCacheEntity == null) {
            return null;
        }
        return Long.valueOf(impressionsObserverCacheEntity.getTime());
    }

    @Override // io.split.android.client.service.impressions.observer.PersistentImpressionsObserverCacheStorage
    public void deleteOutdated(long timestamp) {
        this.mImpressionsObserverCacheDao.deleteOldest(timestamp - this.mExpirationPeriod);
    }

    @Override // io.split.android.client.service.impressions.observer.ListenableLruCache.RemovalListener
    public void onRemoval(Long key) {
        this.mCache.remove(key);
        this.mImpressionsObserverCacheDao.delete(key);
    }

    @Override // io.split.android.client.service.impressions.observer.ImpressionsObserverCache
    public void persist() {
        if (this.mDelayedSyncRunning.compareAndSet(false, true)) {
            this.mExecutorsService.submit(new PeriodicPersistenceTask(this.mCache, this.mImpressionsObserverCacheDao, this.mCallback));
        }
    }
}
