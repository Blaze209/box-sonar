package io.split.android.client.storage.rbs;

import io.split.android.client.dtos.RuleBasedSegment;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public interface PersistentRuleBasedSegmentStorage {

    public interface Provider {
        PersistentRuleBasedSegmentStorage get();
    }

    void clear();

    RuleBasedSegmentSnapshot getSnapshot();

    void update(Set<RuleBasedSegment> toAdd, Set<RuleBasedSegment> toRemove, long changeNumber);
}
