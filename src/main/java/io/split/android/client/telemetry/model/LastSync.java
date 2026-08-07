package io.split.android.client.telemetry.model;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class LastSync {

    @SerializedName("ev")
    private Long lastEventSync;

    @SerializedName("ic")
    private Long lastImpressionCountSync;

    @SerializedName("im")
    private Long lastImpressionSync;

    @SerializedName("mls")
    private Long lastMyLargeSegmentSync;

    @SerializedName("ms")
    private Long lastMySegmentSync;

    @SerializedName("sp")
    private Long lastSplitSync;

    @SerializedName("te")
    private Long lastTelemetrySync;

    @SerializedName(TypedValues.TransitionType.S_TO)
    private Long lastTokenRefresh;

    public long getLastSplitSync() {
        return this.lastSplitSync.longValue();
    }

    public void setLastSplitSync(long lastSplitSync) {
        this.lastSplitSync = Long.valueOf(lastSplitSync);
    }

    public long getLastMySegmentSync() {
        return this.lastMySegmentSync.longValue();
    }

    public void setLastMySegmentSync(long lastMySegmentSync) {
        this.lastMySegmentSync = Long.valueOf(lastMySegmentSync);
    }

    public long getLastMyLargeSegmentSync() {
        return this.lastMyLargeSegmentSync.longValue();
    }

    public void setLastMyLargeSegmentSync(long lastMyLargeSegmentSync) {
        this.lastMyLargeSegmentSync = Long.valueOf(lastMyLargeSegmentSync);
    }

    public long getLastImpressionSync() {
        return this.lastImpressionSync.longValue();
    }

    public void setLastImpressionSync(long lastImpressionSync) {
        this.lastImpressionSync = Long.valueOf(lastImpressionSync);
    }

    public long getLastImpressionCountSync() {
        return this.lastImpressionCountSync.longValue();
    }

    public void setLastImpressionCountSync(long lasImpressionCountSync) {
        this.lastImpressionCountSync = Long.valueOf(lasImpressionCountSync);
    }

    public long getLastEventSync() {
        return this.lastEventSync.longValue();
    }

    public void setLastEventSync(long lastEventSync) {
        this.lastEventSync = Long.valueOf(lastEventSync);
    }

    public long getLastTelemetrySync() {
        return this.lastTelemetrySync.longValue();
    }

    public void setLastTelemetrySync(long lastTelemetrySync) {
        this.lastTelemetrySync = Long.valueOf(lastTelemetrySync);
    }

    public long getLastTokenRefresh() {
        return this.lastTokenRefresh.longValue();
    }

    public void setLastTokenRefresh(long lastTokenRefresh) {
        this.lastTokenRefresh = Long.valueOf(lastTokenRefresh);
    }
}
