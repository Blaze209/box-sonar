package io.split.android.client.telemetry.model;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.gson.annotations.SerializedName;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class HttpErrors {

    @SerializedName("ev")
    private Map<Long, Long> eventsSyncErrs;

    @SerializedName("ic")
    private Map<Long, Long> impressionCountSyncErrs;

    @SerializedName("im")
    private Map<Long, Long> impressionSyncErrs;

    @SerializedName("mls")
    private Map<Long, Long> myLargeSegmentsSyncErrs;

    @SerializedName("ms")
    private Map<Long, Long> mySegmentSyncErrs;

    @SerializedName("sp")
    private Map<Long, Long> splitSyncErrs;

    @SerializedName("te")
    private Map<Long, Long> telemetrySyncErrs;

    @SerializedName(TypedValues.TransitionType.S_TO)
    private Map<Long, Long> tokenGetErrs;

    public Map<Long, Long> getSplitSyncErrs() {
        return this.splitSyncErrs;
    }

    public void setSplitSyncErrs(Map<Long, Long> splitSyncErrs) {
        this.splitSyncErrs = splitSyncErrs;
    }

    public Map<Long, Long> getMySegmentSyncErrs() {
        return this.mySegmentSyncErrs;
    }

    public void setMySegmentSyncErrs(Map<Long, Long> mySegmentSyncErrs) {
        this.mySegmentSyncErrs = mySegmentSyncErrs;
    }

    public Map<Long, Long> getMyLargeSegmentsSyncErrs() {
        return this.myLargeSegmentsSyncErrs;
    }

    public void setMyLargeSegmentsSyncErrs(Map<Long, Long> myLargeSegmentsSyncErrs) {
        this.myLargeSegmentsSyncErrs = myLargeSegmentsSyncErrs;
    }

    public Map<Long, Long> getImpressionSyncErrs() {
        return this.impressionSyncErrs;
    }

    public void setImpressionSyncErrs(Map<Long, Long> impressionSyncErrs) {
        this.impressionSyncErrs = impressionSyncErrs;
    }

    public Map<Long, Long> getImpressionCountSyncErrs() {
        return this.impressionCountSyncErrs;
    }

    public void setImpressionCountSyncErrs(Map<Long, Long> impressionCountSyncErrs) {
        this.impressionCountSyncErrs = impressionCountSyncErrs;
    }

    public Map<Long, Long> getEventsSyncErrs() {
        return this.eventsSyncErrs;
    }

    public void setEventsSyncErrs(Map<Long, Long> eventsSyncErrs) {
        this.eventsSyncErrs = eventsSyncErrs;
    }

    public Map<Long, Long> getTelemetrySyncErrs() {
        return this.telemetrySyncErrs;
    }

    public void setTelemetrySyncErrs(Map<Long, Long> telemetrySyncErrs) {
        this.telemetrySyncErrs = telemetrySyncErrs;
    }

    public Map<Long, Long> getTokenGetErrs() {
        return this.tokenGetErrs;
    }

    public void setTokenGetErrs(Map<Long, Long> tokenGetErrs) {
        this.tokenGetErrs = tokenGetErrs;
    }
}
