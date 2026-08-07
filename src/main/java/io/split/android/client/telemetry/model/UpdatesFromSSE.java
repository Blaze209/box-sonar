package io.split.android.client.telemetry.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class UpdatesFromSSE {

    @SerializedName("mls")
    private long mMyLargeSegments;

    @SerializedName("ms")
    private long mMySegments;

    @SerializedName("sp")
    private long mSplits;

    public UpdatesFromSSE(long splits, long mySegments, long myLargeSegments) {
        this.mSplits = splits;
        this.mMySegments = mySegments;
        this.mMyLargeSegments = myLargeSegments;
    }

    public long getSplits() {
        return this.mSplits;
    }

    public long getMySegments() {
        return this.mMySegments;
    }

    public long getMyLargeSegments() {
        return this.mMyLargeSegments;
    }
}
