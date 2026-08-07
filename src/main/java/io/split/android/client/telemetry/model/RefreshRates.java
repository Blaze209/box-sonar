package io.split.android.client.telemetry.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class RefreshRates {

    @SerializedName("ev")
    private long events;

    @SerializedName("im")
    private long impressions;

    @SerializedName("mls")
    private long myLargeSegments;

    @SerializedName("ms")
    private long mySegments;

    @SerializedName("sp")
    private long splits;

    @SerializedName("te")
    private long telemetry;

    public long getSplits() {
        return this.splits;
    }

    public void setSplits(long splits) {
        this.splits = splits;
    }

    public long getMySegments() {
        return this.mySegments;
    }

    public void setMySegments(long mySegments) {
        this.mySegments = mySegments;
    }

    public long getMyLargeSegments() {
        return this.myLargeSegments;
    }

    public void setMyLargeSegments(long myLargeSegments) {
        this.myLargeSegments = myLargeSegments;
    }

    public long getImpressions() {
        return this.impressions;
    }

    public void setImpressions(long impressions) {
        this.impressions = impressions;
    }

    public long getEvents() {
        return this.events;
    }

    public void setEvents(long events) {
        this.events = events;
    }

    public long getTelemetry() {
        return this.telemetry;
    }

    public void setTelemetry(long telemetry) {
        this.telemetry = telemetry;
    }
}
