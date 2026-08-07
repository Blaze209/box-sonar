package io.split.android.client.storage.mysegments;

import io.split.android.client.dtos.SegmentsChange;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class EmptyMySegmentsStorage implements MySegmentsStorage {
    @Override // io.split.android.client.storage.RolloutDefinitionsCache
    public void clear() {
    }

    @Override // io.split.android.client.storage.mysegments.MySegmentsStorage
    public long getChangeNumber() {
        return -1L;
    }

    @Override // io.split.android.client.storage.RolloutDefinitionsCache
    public void loadLocal() {
    }

    @Override // io.split.android.client.storage.mysegments.MySegmentsStorage
    public void set(SegmentsChange segmentsChange) {
    }

    @Override // io.split.android.client.storage.mysegments.MySegmentsStorage
    public Set<String> getAll() {
        return new HashSet();
    }
}
