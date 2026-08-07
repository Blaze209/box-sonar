package com.box.android.domain.metrics.hubs;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.observability.HubEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HubsObservabilityLaunchData.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/box/android/domain/metrics/hubs/HubsObservabilityLaunchData;", "", "event", "Lcom/box/android/domain/models/observability/HubEvent;", "startTime", "", "<init>", "(Lcom/box/android/domain/models/observability/HubEvent;J)V", "getEvent", "()Lcom/box/android/domain/models/observability/HubEvent;", "getStartTime", "()J", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class HubsObservabilityLaunchData {
    private final HubEvent event;
    private final long startTime;

    public static /* synthetic */ HubsObservabilityLaunchData copy$default(HubsObservabilityLaunchData hubsObservabilityLaunchData, HubEvent hubEvent, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            hubEvent = hubsObservabilityLaunchData.event;
        }
        if ((i & 2) != 0) {
            j = hubsObservabilityLaunchData.startTime;
        }
        return hubsObservabilityLaunchData.copy(hubEvent, j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final HubEvent getEvent() {
        return this.event;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getStartTime() {
        return this.startTime;
    }

    public final HubsObservabilityLaunchData copy(HubEvent event, long startTime) {
        Intrinsics.checkNotNullParameter(event, "event");
        return new HubsObservabilityLaunchData(event, startTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HubsObservabilityLaunchData)) {
            return false;
        }
        HubsObservabilityLaunchData hubsObservabilityLaunchData = (HubsObservabilityLaunchData) other;
        return Intrinsics.areEqual(this.event, hubsObservabilityLaunchData.event) && this.startTime == hubsObservabilityLaunchData.startTime;
    }

    public int hashCode() {
        return (this.event.hashCode() * 31) + Long.hashCode(this.startTime);
    }

    public String toString() {
        return "HubsObservabilityLaunchData(event=" + this.event + ", startTime=" + this.startTime + ")";
    }

    public HubsObservabilityLaunchData(HubEvent event, long j) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.event = event;
        this.startTime = j;
    }

    public final HubEvent getEvent() {
        return this.event;
    }

    public final long getStartTime() {
        return this.startTime;
    }
}
