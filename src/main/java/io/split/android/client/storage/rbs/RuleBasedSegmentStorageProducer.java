package io.split.android.client.storage.rbs;

import io.split.android.client.dtos.RuleBasedSegment;
import io.split.android.client.storage.RolloutDefinitionsCache;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public interface RuleBasedSegmentStorageProducer extends RolloutDefinitionsCache {
    long getChangeNumber();

    boolean update(Set<RuleBasedSegment> toAdd, Set<RuleBasedSegment> toRemove, long changeNumber);
}
