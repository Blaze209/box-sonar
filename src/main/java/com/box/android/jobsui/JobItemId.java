package com.box.android.jobsui;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JobsReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/box/android/jobsui/JobItemId;", "", "identifier", "", "isLegacy", "", "groupId", "<init>", "(Ljava/lang/String;ZLjava/lang/String;)V", "getIdentifier", "()Ljava/lang/String;", "()Z", "getGroupId", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "jobsui_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class JobItemId {
    public static final int $stable = 0;
    private final String groupId;
    private final String identifier;
    private final boolean isLegacy;

    public static /* synthetic */ JobItemId copy$default(JobItemId jobItemId, String str, boolean z, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = jobItemId.identifier;
        }
        if ((i & 2) != 0) {
            z = jobItemId.isLegacy;
        }
        if ((i & 4) != 0) {
            str2 = jobItemId.groupId;
        }
        return jobItemId.copy(str, z, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getIdentifier() {
        return this.identifier;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsLegacy() {
        return this.isLegacy;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    public final JobItemId copy(String identifier, boolean isLegacy, String groupId) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        return new JobItemId(identifier, isLegacy, groupId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JobItemId)) {
            return false;
        }
        JobItemId jobItemId = (JobItemId) other;
        return Intrinsics.areEqual(this.identifier, jobItemId.identifier) && this.isLegacy == jobItemId.isLegacy && Intrinsics.areEqual(this.groupId, jobItemId.groupId);
    }

    public int hashCode() {
        int iHashCode = ((this.identifier.hashCode() * 31) + Boolean.hashCode(this.isLegacy)) * 31;
        String str = this.groupId;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "JobItemId(identifier=" + this.identifier + ", isLegacy=" + this.isLegacy + ", groupId=" + this.groupId + ")";
    }

    public JobItemId(String identifier, boolean z, String str) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        this.identifier = identifier;
        this.isLegacy = z;
        this.groupId = str;
    }

    public /* synthetic */ JobItemId(String str, boolean z, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, (i & 4) != 0 ? null : str2);
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final boolean isLegacy() {
        return this.isLegacy;
    }
}
