package io.split.android.client.dtos;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class RuleBasedSegmentChange {

    @SerializedName("d")
    private List<RuleBasedSegment> segments;

    @SerializedName("s")
    private long since;

    @SerializedName("t")
    private long till;

    public long getSince() {
        return this.since;
    }

    public long getTill() {
        return this.till;
    }

    public List<RuleBasedSegment> getSegments() {
        return this.segments;
    }

    public static RuleBasedSegmentChange createEmpty() {
        return create(-1L, -1L, new ArrayList());
    }

    public static RuleBasedSegmentChange create(long since, long till, List<RuleBasedSegment> segments) {
        RuleBasedSegmentChange ruleBasedSegmentChange = new RuleBasedSegmentChange();
        ruleBasedSegmentChange.segments = segments;
        ruleBasedSegmentChange.since = since;
        ruleBasedSegmentChange.till = till;
        return ruleBasedSegmentChange;
    }
}
