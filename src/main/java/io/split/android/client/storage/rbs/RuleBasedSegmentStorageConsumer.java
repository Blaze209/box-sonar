package io.split.android.client.storage.rbs;

import io.split.android.engine.experiments.ParsedRuleBasedSegment;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public interface RuleBasedSegmentStorageConsumer {
    boolean contains(Set<String> segmentNames);

    ParsedRuleBasedSegment get(String segmentName, String matchingKey);
}
