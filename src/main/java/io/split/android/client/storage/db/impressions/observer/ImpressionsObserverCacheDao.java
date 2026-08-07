package io.split.android.client.storage.db.impressions.observer;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface ImpressionsObserverCacheDao {
    void delete(Long hash);

    void deleteOldest(long timestamp);

    ImpressionsObserverCacheEntity get(Long hash);

    List<ImpressionsObserverCacheEntity> getAll(int limit);

    void insert(Long hash, Long time, Long createdAt);

    void insert(List<ImpressionsObserverCacheEntity> entities);
}
