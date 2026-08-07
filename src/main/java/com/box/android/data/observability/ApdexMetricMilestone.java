package com.box.android.data.observability;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApdexMetric.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/box/android/data/observability/ApdexMetricMilestone;", "", "name", "", "epochMillis", "", "<init>", "(Ljava/lang/String;J)V", "getName", "()Ljava/lang/String;", "getEpochMillis", "()J", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ApdexMetricMilestone {
    private final long epochMillis;
    private final String name;

    public static /* synthetic */ ApdexMetricMilestone copy$default(ApdexMetricMilestone apdexMetricMilestone, String str, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = apdexMetricMilestone.name;
        }
        if ((i & 2) != 0) {
            j = apdexMetricMilestone.epochMillis;
        }
        return apdexMetricMilestone.copy(str, j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getEpochMillis() {
        return this.epochMillis;
    }

    public final ApdexMetricMilestone copy(String name, long epochMillis) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new ApdexMetricMilestone(name, epochMillis);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApdexMetricMilestone)) {
            return false;
        }
        ApdexMetricMilestone apdexMetricMilestone = (ApdexMetricMilestone) other;
        return Intrinsics.areEqual(this.name, apdexMetricMilestone.name) && this.epochMillis == apdexMetricMilestone.epochMillis;
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + Long.hashCode(this.epochMillis);
    }

    public String toString() {
        return "ApdexMetricMilestone(name=" + this.name + ", epochMillis=" + this.epochMillis + ")";
    }

    public ApdexMetricMilestone(String name, long j) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.epochMillis = j;
    }

    public final String getName() {
        return this.name;
    }

    public final long getEpochMillis() {
        return this.epochMillis;
    }
}
