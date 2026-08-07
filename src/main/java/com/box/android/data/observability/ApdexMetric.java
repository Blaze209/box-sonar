package com.box.android.data.observability;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.observability.ApdexScore;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApdexMetric.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003JO\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010¨\u0006&"}, d2 = {"Lcom/box/android/data/observability/ApdexMetric;", "", "type", "", "startEpochMillis", "", "endEpochMillis", "milestones", "", "Lcom/box/android/data/observability/ApdexMetricMilestone;", FirebaseAnalytics.Param.SCORE, "Lcom/box/android/domain/models/observability/ApdexScore;", "failMessage", "<init>", "(Ljava/lang/String;JJLjava/util/List;Lcom/box/android/domain/models/observability/ApdexScore;Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "getStartEpochMillis", "()J", "getEndEpochMillis", "getMilestones", "()Ljava/util/List;", "getScore", "()Lcom/box/android/domain/models/observability/ApdexScore;", "getFailMessage", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ApdexMetric {
    private final long endEpochMillis;
    private final String failMessage;
    private final List<ApdexMetricMilestone> milestones;
    private final ApdexScore score;
    private final long startEpochMillis;
    private final String type;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ApdexMetric copy$default(ApdexMetric apdexMetric, String str, long j, long j2, List list, ApdexScore apdexScore, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = apdexMetric.type;
        }
        if ((i & 2) != 0) {
            j = apdexMetric.startEpochMillis;
        }
        if ((i & 4) != 0) {
            j2 = apdexMetric.endEpochMillis;
        }
        if ((i & 8) != 0) {
            list = apdexMetric.milestones;
        }
        if ((i & 16) != 0) {
            apdexScore = apdexMetric.score;
        }
        if ((i & 32) != 0) {
            str2 = apdexMetric.failMessage;
        }
        String str3 = str2;
        List list2 = list;
        long j3 = j2;
        return apdexMetric.copy(str, j, j3, list2, apdexScore, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getStartEpochMillis() {
        return this.startEpochMillis;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getEndEpochMillis() {
        return this.endEpochMillis;
    }

    public final List<ApdexMetricMilestone> component4() {
        return this.milestones;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final ApdexScore getScore() {
        return this.score;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getFailMessage() {
        return this.failMessage;
    }

    public final ApdexMetric copy(String type, long startEpochMillis, long endEpochMillis, List<ApdexMetricMilestone> milestones, ApdexScore score, String failMessage) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(milestones, "milestones");
        return new ApdexMetric(type, startEpochMillis, endEpochMillis, milestones, score, failMessage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApdexMetric)) {
            return false;
        }
        ApdexMetric apdexMetric = (ApdexMetric) other;
        return Intrinsics.areEqual(this.type, apdexMetric.type) && this.startEpochMillis == apdexMetric.startEpochMillis && this.endEpochMillis == apdexMetric.endEpochMillis && Intrinsics.areEqual(this.milestones, apdexMetric.milestones) && Intrinsics.areEqual(this.score, apdexMetric.score) && Intrinsics.areEqual(this.failMessage, apdexMetric.failMessage);
    }

    public int hashCode() {
        int iHashCode = ((((((this.type.hashCode() * 31) + Long.hashCode(this.startEpochMillis)) * 31) + Long.hashCode(this.endEpochMillis)) * 31) + this.milestones.hashCode()) * 31;
        ApdexScore apdexScore = this.score;
        int iHashCode2 = (iHashCode + (apdexScore == null ? 0 : apdexScore.hashCode())) * 31;
        String str = this.failMessage;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "ApdexMetric(type=" + this.type + ", startEpochMillis=" + this.startEpochMillis + ", endEpochMillis=" + this.endEpochMillis + ", milestones=" + this.milestones + ", score=" + this.score + ", failMessage=" + this.failMessage + ")";
    }

    public ApdexMetric(String type, long j, long j2, List<ApdexMetricMilestone> milestones, ApdexScore apdexScore, String str) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(milestones, "milestones");
        this.type = type;
        this.startEpochMillis = j;
        this.endEpochMillis = j2;
        this.milestones = milestones;
        this.score = apdexScore;
        this.failMessage = str;
    }

    public /* synthetic */ ApdexMetric(String str, long j, long j2, List list, ApdexScore apdexScore, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, j2, list, (i & 16) != 0 ? null : apdexScore, (i & 32) != 0 ? null : str2);
    }

    public final String getType() {
        return this.type;
    }

    public final long getStartEpochMillis() {
        return this.startEpochMillis;
    }

    public final long getEndEpochMillis() {
        return this.endEpochMillis;
    }

    public final List<ApdexMetricMilestone> getMilestones() {
        return this.milestones;
    }

    public final ApdexScore getScore() {
        return this.score;
    }

    public final String getFailMessage() {
        return this.failMessage;
    }
}
