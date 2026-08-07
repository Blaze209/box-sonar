package io.split.android.client.dtos;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class SegmentsChange {

    @SerializedName("cn")
    private Long mChangeNumber;

    @SerializedName("k")
    private Set<Segment> mSegments;

    public SegmentsChange(Set<Segment> segments, Long changeNumber) {
        this.mSegments = segments;
        this.mChangeNumber = changeNumber;
    }

    public Set<Segment> getSegments() {
        Set<Segment> set = this.mSegments;
        return set == null ? Collections.emptySet() : set;
    }

    public Long getChangeNumber() {
        return this.mChangeNumber;
    }

    public List<String> getNames() {
        HashSet hashSet = new HashSet(getSegments());
        ArrayList arrayList = new ArrayList(hashSet.size());
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            arrayList.add(((Segment) it.next()).getName());
        }
        return arrayList;
    }

    public static SegmentsChange createEmpty() {
        return new SegmentsChange(Collections.emptySet(), null);
    }

    public static SegmentsChange create(Set<String> segments, long changeNumber) {
        if (segments == null) {
            return null;
        }
        return create(segments, Long.valueOf(changeNumber));
    }

    public static SegmentsChange create(Set<String> segments, Long changeNumber) {
        if (segments == null) {
            return createEmpty();
        }
        HashSet hashSet = new HashSet();
        for (String str : segments) {
            Segment segment = new Segment();
            segment.setName(str);
            hashSet.add(segment);
        }
        return new SegmentsChange(hashSet, changeNumber);
    }
}
