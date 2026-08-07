package io.split.android.client.service.synchronizer.mysegments;

import io.split.android.client.api.Key;

/* JADX INFO: loaded from: classes4.dex */
public interface MySegmentsSynchronizerRegistry {
    void registerMySegmentsSynchronizer(Key key, MySegmentsSynchronizer mySegmentsSynchronizer);

    void unregisterMySegmentsSynchronizer(Key key);
}
