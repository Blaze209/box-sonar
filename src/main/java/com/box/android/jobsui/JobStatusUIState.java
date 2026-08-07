package com.box.android.jobsui;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.JobInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JobItemReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J0\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u00122\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/box/android/jobsui/JobStatusUIState;", "", "progress", "", "jobStatus", "Lcom/box/android/domain/models/JobInfo$Status;", "errorText", "", "<init>", "(Ljava/lang/Float;Lcom/box/android/domain/models/JobInfo$Status;Ljava/lang/String;)V", "getProgress", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getJobStatus", "()Lcom/box/android/domain/models/JobInfo$Status;", "getErrorText", "()Ljava/lang/String;", "shouldIconBeAnimated", "", "getShouldIconBeAnimated", "()Z", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/Float;Lcom/box/android/domain/models/JobInfo$Status;Ljava/lang/String;)Lcom/box/android/jobsui/JobStatusUIState;", "equals", "other", "hashCode", "", "toString", "jobsui_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class JobStatusUIState {
    public static final int $stable = 8;
    private final String errorText;
    private final JobInfo.Status jobStatus;
    private final Float progress;

    public JobStatusUIState() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ JobStatusUIState copy$default(JobStatusUIState jobStatusUIState, Float f, JobInfo.Status status, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            f = jobStatusUIState.progress;
        }
        if ((i & 2) != 0) {
            status = jobStatusUIState.jobStatus;
        }
        if ((i & 4) != 0) {
            str = jobStatusUIState.errorText;
        }
        return jobStatusUIState.copy(f, status, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Float getProgress() {
        return this.progress;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final JobInfo.Status getJobStatus() {
        return this.jobStatus;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getErrorText() {
        return this.errorText;
    }

    public final JobStatusUIState copy(Float progress, JobInfo.Status jobStatus, String errorText) {
        Intrinsics.checkNotNullParameter(jobStatus, "jobStatus");
        return new JobStatusUIState(progress, jobStatus, errorText);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JobStatusUIState)) {
            return false;
        }
        JobStatusUIState jobStatusUIState = (JobStatusUIState) other;
        return Intrinsics.areEqual((Object) this.progress, (Object) jobStatusUIState.progress) && Intrinsics.areEqual(this.jobStatus, jobStatusUIState.jobStatus) && Intrinsics.areEqual(this.errorText, jobStatusUIState.errorText);
    }

    public int hashCode() {
        Float f = this.progress;
        int iHashCode = (((f == null ? 0 : f.hashCode()) * 31) + this.jobStatus.hashCode()) * 31;
        String str = this.errorText;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "JobStatusUIState(progress=" + this.progress + ", jobStatus=" + this.jobStatus + ", errorText=" + this.errorText + ")";
    }

    public JobStatusUIState(Float f, JobInfo.Status jobStatus, String str) {
        Intrinsics.checkNotNullParameter(jobStatus, "jobStatus");
        this.progress = f;
        this.jobStatus = jobStatus;
        this.errorText = str;
    }

    public /* synthetic */ JobStatusUIState(Float f, JobInfo.Status.Waiting waiting, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Float.valueOf(1.0f) : f, (i & 2) != 0 ? JobInfo.Status.Waiting.INSTANCE : waiting, (i & 4) != 0 ? null : str);
    }

    public final Float getProgress() {
        return this.progress;
    }

    public final JobInfo.Status getJobStatus() {
        return this.jobStatus;
    }

    public final String getErrorText() {
        return this.errorText;
    }

    public final boolean getShouldIconBeAnimated() {
        return this.jobStatus instanceof JobInfo.Status.Running;
    }
}
