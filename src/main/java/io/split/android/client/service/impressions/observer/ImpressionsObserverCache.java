package io.split.android.client.service.impressions.observer;

/* JADX INFO: loaded from: classes4.dex */
interface ImpressionsObserverCache {
    Long get(long hash);

    void persist();

    void put(long hash, long time);
}
