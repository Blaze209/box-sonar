package io.split.android.client.service.impressions.observer;

/* JADX INFO: loaded from: classes4.dex */
public interface PersistentImpressionsObserverCacheStorage extends ImpressionsObserverCache, ListenableLruCache.RemovalListener<Long> {
    void deleteOutdated(long timestamp);
}
