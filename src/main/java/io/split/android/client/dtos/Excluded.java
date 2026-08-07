package io.split.android.client.dtos;

import com.google.gson.annotations.SerializedName;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class Excluded {

    @SerializedName("keys")
    private Set<String> mKeys;

    @SerializedName("segments")
    private Set<ExcludedSegment> mSegments;

    public Set<ExcludedSegment> getSegments() {
        return this.mSegments;
    }

    public Set<String> getKeys() {
        return this.mKeys;
    }

    public static Excluded createEmpty() {
        Excluded excluded = new Excluded();
        excluded.mKeys = new HashSet();
        excluded.mSegments = new HashSet();
        return excluded;
    }
}
