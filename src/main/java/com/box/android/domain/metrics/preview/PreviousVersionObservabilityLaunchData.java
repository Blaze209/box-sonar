package com.box.android.domain.metrics.preview;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.observability.PreviousVersionPreviewPM23Event;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviousVersionPreviewObservability.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/box/android/domain/metrics/preview/PreviousVersionObservabilityLaunchData;", "", "event", "Lcom/box/android/domain/models/observability/PreviousVersionPreviewPM23Event;", "startTime", "", "<init>", "(Lcom/box/android/domain/models/observability/PreviousVersionPreviewPM23Event;J)V", "getEvent", "()Lcom/box/android/domain/models/observability/PreviousVersionPreviewPM23Event;", "setEvent", "(Lcom/box/android/domain/models/observability/PreviousVersionPreviewPM23Event;)V", "getStartTime", "()J", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class PreviousVersionObservabilityLaunchData {
    private PreviousVersionPreviewPM23Event event;
    private final long startTime;

    public static /* synthetic */ PreviousVersionObservabilityLaunchData copy$default(PreviousVersionObservabilityLaunchData previousVersionObservabilityLaunchData, PreviousVersionPreviewPM23Event previousVersionPreviewPM23Event, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            previousVersionPreviewPM23Event = previousVersionObservabilityLaunchData.event;
        }
        if ((i & 2) != 0) {
            j = previousVersionObservabilityLaunchData.startTime;
        }
        return previousVersionObservabilityLaunchData.copy(previousVersionPreviewPM23Event, j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final PreviousVersionPreviewPM23Event getEvent() {
        return this.event;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getStartTime() {
        return this.startTime;
    }

    public final PreviousVersionObservabilityLaunchData copy(PreviousVersionPreviewPM23Event event, long startTime) {
        Intrinsics.checkNotNullParameter(event, "event");
        return new PreviousVersionObservabilityLaunchData(event, startTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PreviousVersionObservabilityLaunchData)) {
            return false;
        }
        PreviousVersionObservabilityLaunchData previousVersionObservabilityLaunchData = (PreviousVersionObservabilityLaunchData) other;
        return Intrinsics.areEqual(this.event, previousVersionObservabilityLaunchData.event) && this.startTime == previousVersionObservabilityLaunchData.startTime;
    }

    public int hashCode() {
        return (this.event.hashCode() * 31) + Long.hashCode(this.startTime);
    }

    public String toString() {
        return "PreviousVersionObservabilityLaunchData(event=" + this.event + ", startTime=" + this.startTime + ")";
    }

    public PreviousVersionObservabilityLaunchData(PreviousVersionPreviewPM23Event event, long j) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.event = event;
        this.startTime = j;
    }

    public final PreviousVersionPreviewPM23Event getEvent() {
        return this.event;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final void setEvent(PreviousVersionPreviewPM23Event previousVersionPreviewPM23Event) {
        Intrinsics.checkNotNullParameter(previousVersionPreviewPM23Event, "<set-?>");
        this.event = previousVersionPreviewPM23Event;
    }
}
