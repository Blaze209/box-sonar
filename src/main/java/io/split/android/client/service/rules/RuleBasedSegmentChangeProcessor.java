package io.split.android.client.service.rules;

import io.split.android.client.dtos.RuleBasedSegment;
import io.split.android.client.dtos.Status;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class RuleBasedSegmentChangeProcessor {
    public ProcessedRuleBasedSegmentChange process(List<RuleBasedSegment> segments, long changeNumber) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (RuleBasedSegment ruleBasedSegment : segments) {
            if (ruleBasedSegment.getStatus() == Status.ACTIVE) {
                hashSet.add(ruleBasedSegment);
            } else {
                hashSet2.add(ruleBasedSegment);
            }
        }
        return new ProcessedRuleBasedSegmentChange(hashSet, hashSet2, changeNumber, System.currentTimeMillis());
    }

    public ProcessedRuleBasedSegmentChange process(RuleBasedSegment segment, long changeNumber) {
        return process(Collections.singletonList(segment), changeNumber);
    }
}
