package io.split.android.client.service.impressions;

import io.split.android.client.impressions.DecoratedImpression;

/* JADX INFO: loaded from: classes4.dex */
public interface ImpressionManager {
    void enableTracking(boolean enable);

    void pushImpression(DecoratedImpression impression);
}
