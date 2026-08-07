package io.split.android.client.dtos;

import com.google.gson.annotations.SerializedName;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class AllSegmentsChange {

    @SerializedName("ls")
    private SegmentsChange mMyLargeSegmentsChange;

    @SerializedName("ms")
    private SegmentsChange mMySegmentsChange;

    public AllSegmentsChange() {
    }

    @Deprecated
    public AllSegmentsChange(List<String> mySegments) {
        HashSet hashSet = new HashSet();
        for (String str : mySegments) {
            Segment segment = new Segment();
            segment.setName(str);
            hashSet.add(segment);
        }
        this.mMySegmentsChange = new SegmentsChange(hashSet, null);
    }

    public SegmentsChange getSegmentsChange() {
        return this.mMySegmentsChange;
    }

    public SegmentsChange getLargeSegmentsChange() {
        return this.mMyLargeSegmentsChange;
    }

    public static AllSegmentsChange create(SegmentsChange mySegmentsChange, SegmentsChange myLargeSegmentsChange) {
        AllSegmentsChange allSegmentsChange = new AllSegmentsChange();
        allSegmentsChange.mMySegmentsChange = mySegmentsChange;
        allSegmentsChange.mMyLargeSegmentsChange = myLargeSegmentsChange;
        return allSegmentsChange;
    }
}
