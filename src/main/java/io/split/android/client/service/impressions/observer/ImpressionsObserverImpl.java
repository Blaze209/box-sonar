package io.split.android.client.service.impressions.observer;

import io.split.android.client.impressions.Impression;
import io.split.android.client.service.impressions.ImpressionHasher;
import io.split.android.client.utils.Utils;

/* JADX INFO: loaded from: classes4.dex */
public class ImpressionsObserverImpl implements ImpressionsObserver {
    private final ImpressionsObserverCache mCache;

    public ImpressionsObserverImpl(PersistentImpressionsObserverCacheStorage persistentStorage, int size) {
        this(new ImpressionsObserverCacheImpl(persistentStorage, size));
    }

    ImpressionsObserverImpl(ImpressionsObserverCache cache) {
        this.mCache = (ImpressionsObserverCache) Utils.checkNotNull(cache);
    }

    @Override // io.split.android.client.service.impressions.observer.ImpressionsObserver
    public Long testAndSet(Impression impression) {
        if (impression == null) {
            return null;
        }
        Long lProcess = ImpressionHasher.process(impression);
        Long l = this.mCache.get(lProcess.longValue());
        this.mCache.put(lProcess.longValue(), impression.time());
        if (l == null) {
            return null;
        }
        return Long.valueOf(Math.min(l.longValue(), impression.time()));
    }

    @Override // io.split.android.client.service.impressions.observer.ImpressionsObserver
    public void persist() {
        this.mCache.persist();
    }
}
