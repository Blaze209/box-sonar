package io.split.android.client.service.impressions.observer;

import io.split.android.client.storage.db.impressions.observer.ImpressionsObserverCacheDao;
import io.split.android.client.storage.db.impressions.observer.ImpressionsObserverCacheEntity;
import io.split.android.client.utils.logger.Logger;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class PeriodicPersistenceTask implements Runnable {
    private final Map<Long, Long> mCache;
    private final ImpressionsObserverCacheDao mImpressionsObserverCacheDao;
    private final WeakReference<OnExecutedListener> mOnExecutedListener;

    interface OnExecutedListener {
        void onExecuted();
    }

    PeriodicPersistenceTask(Map<Long, Long> cache, ImpressionsObserverCacheDao impressionsObserverCacheDao, OnExecutedListener onExecutedListener) {
        this.mCache = cache;
        this.mImpressionsObserverCacheDao = impressionsObserverCacheDao;
        this.mOnExecutedListener = new WeakReference<>(onExecutedListener);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.mCache != null) {
                try {
                    ArrayList arrayList = new ArrayList();
                    for (Map.Entry<Long, Long> entry : this.mCache.entrySet()) {
                        try {
                            arrayList.add(new ImpressionsObserverCacheEntity(entry.getKey().longValue(), entry.getValue().longValue(), System.currentTimeMillis()));
                        } catch (Exception unused) {
                            Logger.e("Error while creating observer cache entity");
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        this.mImpressionsObserverCacheDao.insert(arrayList);
                    }
                    this.mCache.clear();
                } catch (Exception e) {
                    Logger.e("Error while persisting elements in observer cache: " + e.getLocalizedMessage());
                }
            }
        } catch (Exception e2) {
            Logger.e("Error while persisting observer cache: " + e2.getLocalizedMessage());
        } finally {
            if (this.mOnExecutedListener.get() != null) {
                this.mOnExecutedListener.get().onExecuted();
            }
        }
    }
}
