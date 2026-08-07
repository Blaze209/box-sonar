package io.split.android.client.storage.mysegments;

import io.split.android.client.dtos.SegmentsChange;

/* JADX INFO: loaded from: classes4.dex */
public interface PersistentMySegmentsStorage {
    void close();

    SegmentsChange getSnapshot(String userKey);

    void set(String userKey, SegmentsChange segmentsChange);
}
