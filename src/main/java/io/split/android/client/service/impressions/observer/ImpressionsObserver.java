package io.split.android.client.service.impressions.observer;

import io.split.android.client.impressions.Impression;

/* JADX INFO: loaded from: classes4.dex */
public interface ImpressionsObserver {
    void persist();

    Long testAndSet(Impression impression);
}
