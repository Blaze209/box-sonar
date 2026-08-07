package io.split.android.client.storage.rbs;

import io.split.android.client.dtos.RuleBasedSegment;
import io.split.android.client.utils.Utils;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class RuleBasedSegmentSnapshot {
    private final long mChangeNumber;
    private final Map<String, RuleBasedSegment> mSegments;

    public RuleBasedSegmentSnapshot(Map<String, RuleBasedSegment> segments, long changeNumber) {
        this.mSegments = (Map) Utils.checkNotNull(segments);
        this.mChangeNumber = changeNumber;
    }

    public Map<String, RuleBasedSegment> getSegments() {
        return this.mSegments;
    }

    public long getChangeNumber() {
        return this.mChangeNumber;
    }
}
