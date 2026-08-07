package io.split.android.client.storage.mysegments;

import io.split.android.client.dtos.SegmentsChange;
import io.split.android.client.storage.RolloutDefinitionsCache;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public interface MySegmentsStorage extends RolloutDefinitionsCache {
    Set<String> getAll();

    long getChangeNumber();

    void set(SegmentsChange segmentsChange);
}
