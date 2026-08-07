package com.box.android.domain.metrics.preview;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.observability.PreviewPM23Event;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviewObservability.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/box/android/domain/metrics/preview/PreviewObservabilityLaunchData;", "", "event", "Lcom/box/android/domain/models/observability/PreviewPM23Event;", "startTime", "", "childSpan", "", "<init>", "(Lcom/box/android/domain/models/observability/PreviewPM23Event;JLjava/lang/String;)V", "getEvent", "()Lcom/box/android/domain/models/observability/PreviewPM23Event;", "setEvent", "(Lcom/box/android/domain/models/observability/PreviewPM23Event;)V", "getStartTime", "()J", "getChildSpan", "()Ljava/lang/String;", "setChildSpan", "(Ljava/lang/String;)V", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class PreviewObservabilityLaunchData {
    private String childSpan;
    private PreviewPM23Event event;
    private final long startTime;

    public static /* synthetic */ PreviewObservabilityLaunchData copy$default(PreviewObservabilityLaunchData previewObservabilityLaunchData, PreviewPM23Event previewPM23Event, long j, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            previewPM23Event = previewObservabilityLaunchData.event;
        }
        if ((i & 2) != 0) {
            j = previewObservabilityLaunchData.startTime;
        }
        if ((i & 4) != 0) {
            str = previewObservabilityLaunchData.childSpan;
        }
        return previewObservabilityLaunchData.copy(previewPM23Event, j, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final PreviewPM23Event getEvent() {
        return this.event;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getStartTime() {
        return this.startTime;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getChildSpan() {
        return this.childSpan;
    }

    public final PreviewObservabilityLaunchData copy(PreviewPM23Event event, long startTime, String childSpan) {
        Intrinsics.checkNotNullParameter(event, "event");
        return new PreviewObservabilityLaunchData(event, startTime, childSpan);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PreviewObservabilityLaunchData)) {
            return false;
        }
        PreviewObservabilityLaunchData previewObservabilityLaunchData = (PreviewObservabilityLaunchData) other;
        return Intrinsics.areEqual(this.event, previewObservabilityLaunchData.event) && this.startTime == previewObservabilityLaunchData.startTime && Intrinsics.areEqual(this.childSpan, previewObservabilityLaunchData.childSpan);
    }

    public int hashCode() {
        int iHashCode = ((this.event.hashCode() * 31) + Long.hashCode(this.startTime)) * 31;
        String str = this.childSpan;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "PreviewObservabilityLaunchData(event=" + this.event + ", startTime=" + this.startTime + ", childSpan=" + this.childSpan + ")";
    }

    public PreviewObservabilityLaunchData(PreviewPM23Event event, long j, String str) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.event = event;
        this.startTime = j;
        this.childSpan = str;
    }

    public /* synthetic */ PreviewObservabilityLaunchData(PreviewPM23Event previewPM23Event, long j, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(previewPM23Event, j, (i & 4) != 0 ? null : str);
    }

    public final String getChildSpan() {
        return this.childSpan;
    }

    public final PreviewPM23Event getEvent() {
        return this.event;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final void setChildSpan(String str) {
        this.childSpan = str;
    }

    public final void setEvent(PreviewPM23Event previewPM23Event) {
        Intrinsics.checkNotNullParameter(previewPM23Event, "<set-?>");
        this.event = previewPM23Event;
    }
}
