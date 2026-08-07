package com.box.android.domain.models.observability;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Gen204EventModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010$\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0018J\t\u0010%\u001a\u00020\fHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u000eHÆ\u0003Jf\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020\f2\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006/"}, d2 = {"Lcom/box/android/domain/models/observability/ApdexGen204Metric;", "Lcom/box/android/domain/models/observability/Gen204Event;", "eventType", "", "milestone", "duration", "", "category", "magnitude", "", "secondaryMeasurement", TelemetryEventStrings.Value.FAILED, "", FirebaseAnalytics.Param.SCORE, "Lcom/box/android/domain/models/observability/ApdexScore;", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/Double;Ljava/lang/Double;ZLcom/box/android/domain/models/observability/ApdexScore;)V", "getEventType", "()Ljava/lang/String;", "getMilestone", "getDuration", "()J", "getCategory", "getMagnitude", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getSecondaryMeasurement", "getFailed", "()Z", "getScore", "()Lcom/box/android/domain/models/observability/ApdexScore;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/Double;Ljava/lang/Double;ZLcom/box/android/domain/models/observability/ApdexScore;)Lcom/box/android/domain/models/observability/ApdexGen204Metric;", "equals", "other", "", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ApdexGen204Metric extends Gen204Event {
    private final String category;
    private final long duration;
    private final String eventType;
    private final boolean failed;
    private final Double magnitude;
    private final String milestone;
    private final ApdexScore score;
    private final Double secondaryMeasurement;

    public static /* synthetic */ ApdexGen204Metric copy$default(ApdexGen204Metric apdexGen204Metric, String str, String str2, long j, String str3, Double d, Double d2, boolean z, ApdexScore apdexScore, int i, Object obj) {
        if ((i & 1) != 0) {
            str = apdexGen204Metric.eventType;
        }
        if ((i & 2) != 0) {
            str2 = apdexGen204Metric.milestone;
        }
        if ((i & 4) != 0) {
            j = apdexGen204Metric.duration;
        }
        if ((i & 8) != 0) {
            str3 = apdexGen204Metric.category;
        }
        if ((i & 16) != 0) {
            d = apdexGen204Metric.magnitude;
        }
        if ((i & 32) != 0) {
            d2 = apdexGen204Metric.secondaryMeasurement;
        }
        if ((i & 64) != 0) {
            z = apdexGen204Metric.failed;
        }
        if ((i & 128) != 0) {
            apdexScore = apdexGen204Metric.score;
        }
        ApdexScore apdexScore2 = apdexScore;
        Double d3 = d2;
        String str4 = str3;
        long j2 = j;
        return apdexGen204Metric.copy(str, str2, j2, str4, d, d3, z, apdexScore2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getEventType() {
        return this.eventType;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMilestone() {
        return this.milestone;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getDuration() {
        return this.duration;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCategory() {
        return this.category;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Double getMagnitude() {
        return this.magnitude;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Double getSecondaryMeasurement() {
        return this.secondaryMeasurement;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getFailed() {
        return this.failed;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final ApdexScore getScore() {
        return this.score;
    }

    public final ApdexGen204Metric copy(String eventType, String milestone, long duration, String category, Double magnitude, Double secondaryMeasurement, boolean failed, ApdexScore score) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(category, "category");
        return new ApdexGen204Metric(eventType, milestone, duration, category, magnitude, secondaryMeasurement, failed, score);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApdexGen204Metric)) {
            return false;
        }
        ApdexGen204Metric apdexGen204Metric = (ApdexGen204Metric) other;
        return Intrinsics.areEqual(this.eventType, apdexGen204Metric.eventType) && Intrinsics.areEqual(this.milestone, apdexGen204Metric.milestone) && this.duration == apdexGen204Metric.duration && Intrinsics.areEqual(this.category, apdexGen204Metric.category) && Intrinsics.areEqual((Object) this.magnitude, (Object) apdexGen204Metric.magnitude) && Intrinsics.areEqual((Object) this.secondaryMeasurement, (Object) apdexGen204Metric.secondaryMeasurement) && this.failed == apdexGen204Metric.failed && Intrinsics.areEqual(this.score, apdexGen204Metric.score);
    }

    public int hashCode() {
        int iHashCode = this.eventType.hashCode() * 31;
        String str = this.milestone;
        int iHashCode2 = (((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Long.hashCode(this.duration)) * 31) + this.category.hashCode()) * 31;
        Double d = this.magnitude;
        int iHashCode3 = (iHashCode2 + (d == null ? 0 : d.hashCode())) * 31;
        Double d2 = this.secondaryMeasurement;
        int iHashCode4 = (((iHashCode3 + (d2 == null ? 0 : d2.hashCode())) * 31) + Boolean.hashCode(this.failed)) * 31;
        ApdexScore apdexScore = this.score;
        return iHashCode4 + (apdexScore != null ? apdexScore.hashCode() : 0);
    }

    public String toString() {
        return "ApdexGen204Metric(eventType=" + this.eventType + ", milestone=" + this.milestone + ", duration=" + this.duration + ", category=" + this.category + ", magnitude=" + this.magnitude + ", secondaryMeasurement=" + this.secondaryMeasurement + ", failed=" + this.failed + ", score=" + this.score + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApdexGen204Metric(String eventType, String str, long j, String category, Double d, Double d2, boolean z, ApdexScore apdexScore) {
        super(0L, null, null, 7, null);
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(category, "category");
        this.eventType = eventType;
        this.milestone = str;
        this.duration = j;
        this.category = category;
        this.magnitude = d;
        this.secondaryMeasurement = d2;
        this.failed = z;
        this.score = apdexScore;
    }

    public final String getEventType() {
        return this.eventType;
    }

    public final String getMilestone() {
        return this.milestone;
    }

    public final long getDuration() {
        return this.duration;
    }

    public /* synthetic */ ApdexGen204Metric(String str, String str2, long j, String str3, Double d, Double d2, boolean z, ApdexScore apdexScore, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, j, (i & 8) != 0 ? "apdex" : str3, (i & 16) != 0 ? null : d, (i & 32) != 0 ? null : d2, (i & 64) != 0 ? false : z, (i & 128) != 0 ? null : apdexScore);
    }

    public final String getCategory() {
        return this.category;
    }

    public final Double getMagnitude() {
        return this.magnitude;
    }

    public final Double getSecondaryMeasurement() {
        return this.secondaryMeasurement;
    }

    public final boolean getFailed() {
        return this.failed;
    }

    public final ApdexScore getScore() {
        return this.score;
    }
}
