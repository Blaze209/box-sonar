package io.split.android.client.service.rules;

import io.split.android.client.dtos.RuleBasedSegment;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class ProcessedRuleBasedSegmentChange {
    private final Set<RuleBasedSegment> mActive;
    private final Set<RuleBasedSegment> mArchived;
    private final long mChangeNumber;
    private final long mUpdateTimestamp;

    public ProcessedRuleBasedSegmentChange(Set<RuleBasedSegment> active, Set<RuleBasedSegment> archived, long changeNumber, long updateTimestamp) {
        this.mActive = active;
        this.mArchived = archived;
        this.mChangeNumber = changeNumber;
        this.mUpdateTimestamp = updateTimestamp;
    }

    public Set<RuleBasedSegment> getActive() {
        return this.mActive;
    }

    public Set<RuleBasedSegment> getArchived() {
        return this.mArchived;
    }

    public long getChangeNumber() {
        return this.mChangeNumber;
    }

    public long getUpdateTimestamp() {
        return this.mUpdateTimestamp;
    }
}
