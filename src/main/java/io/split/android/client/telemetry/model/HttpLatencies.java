package io.split.android.client.telemetry.model;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class HttpLatencies {

    @SerializedName("ev")
    private List<Long> events;

    @SerializedName("im")
    private List<Long> impressions;

    @SerializedName("ic")
    private List<Long> impressionsCount;

    @SerializedName("mls")
    private List<Long> myLargeSegments;

    @SerializedName("ms")
    private List<Long> mySegments;

    @SerializedName("sp")
    private List<Long> splits;

    @SerializedName("te")
    private List<Long> telemetry;

    @SerializedName(TypedValues.TransitionType.S_TO)
    private List<Long> token;

    public List<Long> getSplits() {
        return this.splits;
    }

    public void setSplits(List<Long> splits) {
        this.splits = splits;
    }

    public List<Long> getMySegments() {
        return this.mySegments;
    }

    public void setMySegments(List<Long> mySegments) {
        this.mySegments = mySegments;
    }

    public List<Long> getMyLargeSegments() {
        return this.myLargeSegments;
    }

    public void setMyLargeSegments(List<Long> myLargeSegments) {
        this.myLargeSegments = myLargeSegments;
    }

    public List<Long> getImpressions() {
        return this.impressions;
    }

    public void setImpressions(List<Long> impressions) {
        this.impressions = impressions;
    }

    public List<Long> getImpressionsCount() {
        return this.impressionsCount;
    }

    public void setImpressionsCount(List<Long> impressionsCount) {
        this.impressionsCount = impressionsCount;
    }

    public List<Long> getEvents() {
        return this.events;
    }

    public void setEvents(List<Long> events) {
        this.events = events;
    }

    public List<Long> getTelemetry() {
        return this.telemetry;
    }

    public void setTelemetry(List<Long> telemetry) {
        this.telemetry = telemetry;
    }

    public List<Long> getToken() {
        return this.token;
    }

    public void setToken(List<Long> token) {
        this.token = token;
    }
}
