package io.split.android.client.localhost;

import io.split.android.client.dtos.RuleBasedSegment;
import io.split.android.client.storage.rbs.RuleBasedSegmentStorage;
import io.split.android.engine.experiments.ParsedRuleBasedSegment;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class LocalhostRuleBasedSegmentsStorage implements RuleBasedSegmentStorage {
    @Override // io.split.android.client.storage.RolloutDefinitionsCache
    public void clear() {
    }

    @Override // io.split.android.client.storage.rbs.RuleBasedSegmentStorageConsumer
    public boolean contains(Set<String> segmentNames) {
        return false;
    }

    @Override // io.split.android.client.storage.rbs.RuleBasedSegmentStorageConsumer
    public ParsedRuleBasedSegment get(String segmentName, String matchingKey) {
        return null;
    }

    @Override // io.split.android.client.storage.rbs.RuleBasedSegmentStorageProducer
    public long getChangeNumber() {
        return -1L;
    }

    @Override // io.split.android.client.storage.RolloutDefinitionsCache
    public void loadLocal() {
    }

    @Override // io.split.android.client.storage.rbs.RuleBasedSegmentStorageProducer
    public boolean update(Set<RuleBasedSegment> toAdd, Set<RuleBasedSegment> toRemove, long changeNumber) {
        return false;
    }
}
