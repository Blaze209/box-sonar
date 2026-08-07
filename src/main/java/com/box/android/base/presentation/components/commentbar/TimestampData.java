package com.box.android.base.presentation.components.commentbar;

import com.amplitude.api.Constants;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: TimestampUtil.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/box/android/base/presentation/components/commentbar/TimestampData;", "", "timestampMs", "", Constants.AMP_PLAN_VERSION_ID, "", "range", "Lkotlin/ranges/IntRange;", "<init>", "(JLjava/lang/String;Lkotlin/ranges/IntRange;)V", "getTimestampMs", "()J", "getVersionId", "()Ljava/lang/String;", "getRange", "()Lkotlin/ranges/IntRange;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class TimestampData {
    public static final int $stable = 8;
    private final IntRange range;
    private final long timestampMs;
    private final String versionId;

    public static /* synthetic */ TimestampData copy$default(TimestampData timestampData, long j, String str, IntRange intRange, int i, Object obj) {
        if ((i & 1) != 0) {
            j = timestampData.timestampMs;
        }
        if ((i & 2) != 0) {
            str = timestampData.versionId;
        }
        if ((i & 4) != 0) {
            intRange = timestampData.range;
        }
        return timestampData.copy(j, str, intRange);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getTimestampMs() {
        return this.timestampMs;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getVersionId() {
        return this.versionId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final IntRange getRange() {
        return this.range;
    }

    public final TimestampData copy(long timestampMs, String versionId, IntRange range) {
        Intrinsics.checkNotNullParameter(versionId, "versionId");
        Intrinsics.checkNotNullParameter(range, "range");
        return new TimestampData(timestampMs, versionId, range);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TimestampData)) {
            return false;
        }
        TimestampData timestampData = (TimestampData) other;
        return this.timestampMs == timestampData.timestampMs && Intrinsics.areEqual(this.versionId, timestampData.versionId) && Intrinsics.areEqual(this.range, timestampData.range);
    }

    public int hashCode() {
        return (((Long.hashCode(this.timestampMs) * 31) + this.versionId.hashCode()) * 31) + this.range.hashCode();
    }

    public String toString() {
        return "TimestampData(timestampMs=" + this.timestampMs + ", versionId=" + this.versionId + ", range=" + this.range + ")";
    }

    public TimestampData(long j, String versionId, IntRange range) {
        Intrinsics.checkNotNullParameter(versionId, "versionId");
        Intrinsics.checkNotNullParameter(range, "range");
        this.timestampMs = j;
        this.versionId = versionId;
        this.range = range;
    }

    public final IntRange getRange() {
        return this.range;
    }

    public final long getTimestampMs() {
        return this.timestampMs;
    }

    public final String getVersionId() {
        return this.versionId;
    }
}
