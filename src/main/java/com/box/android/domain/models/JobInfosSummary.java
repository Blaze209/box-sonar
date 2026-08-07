package com.box.android.domain.models;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JobInfosSummary.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/box/android/domain/models/JobInfosSummary;", "", "jobCount", "", "hasError", "", "totalProgress", "Lcom/box/android/domain/models/JobInfo$Progress;", "<init>", "(IZLcom/box/android/domain/models/JobInfo$Progress;)V", "getJobCount", "()I", "getHasError", "()Z", "getTotalProgress", "()Lcom/box/android/domain/models/JobInfo$Progress;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "toString", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class JobInfosSummary {
    private final boolean hasError;
    private final int jobCount;
    private final JobInfo.Progress totalProgress;

    public static /* synthetic */ JobInfosSummary copy$default(JobInfosSummary jobInfosSummary, int i, boolean z, JobInfo.Progress progress, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = jobInfosSummary.jobCount;
        }
        if ((i2 & 2) != 0) {
            z = jobInfosSummary.hasError;
        }
        if ((i2 & 4) != 0) {
            progress = jobInfosSummary.totalProgress;
        }
        return jobInfosSummary.copy(i, z, progress);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getJobCount() {
        return this.jobCount;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getHasError() {
        return this.hasError;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final JobInfo.Progress getTotalProgress() {
        return this.totalProgress;
    }

    public final JobInfosSummary copy(int jobCount, boolean hasError, JobInfo.Progress totalProgress) {
        Intrinsics.checkNotNullParameter(totalProgress, "totalProgress");
        return new JobInfosSummary(jobCount, hasError, totalProgress);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JobInfosSummary)) {
            return false;
        }
        JobInfosSummary jobInfosSummary = (JobInfosSummary) other;
        return this.jobCount == jobInfosSummary.jobCount && this.hasError == jobInfosSummary.hasError && Intrinsics.areEqual(this.totalProgress, jobInfosSummary.totalProgress);
    }

    public int hashCode() {
        return (((Integer.hashCode(this.jobCount) * 31) + Boolean.hashCode(this.hasError)) * 31) + this.totalProgress.hashCode();
    }

    public String toString() {
        return "JobInfosSummary(jobCount=" + this.jobCount + ", hasError=" + this.hasError + ", totalProgress=" + this.totalProgress + ")";
    }

    public JobInfosSummary(int i, boolean z, JobInfo.Progress totalProgress) {
        Intrinsics.checkNotNullParameter(totalProgress, "totalProgress");
        this.jobCount = i;
        this.hasError = z;
        this.totalProgress = totalProgress;
    }

    public final boolean getHasError() {
        return this.hasError;
    }

    public final int getJobCount() {
        return this.jobCount;
    }

    public final JobInfo.Progress getTotalProgress() {
        return this.totalProgress;
    }
}
