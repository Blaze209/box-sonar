package com.box.android.base.presentation.components.topbar.component.jobsprogress;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.services.IJobManagerBridgeService;
import com.box.android.domain.services.IJobService;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JobsProgressReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/box/android/base/presentation/components/topbar/component/jobsprogress/JobsProgressEnvironment;", "", "jobManagerBridgeService", "Lcom/box/android/domain/services/IJobManagerBridgeService;", "jobService", "Lcom/box/android/domain/services/IJobService;", "<init>", "(Lcom/box/android/domain/services/IJobManagerBridgeService;Lcom/box/android/domain/services/IJobService;)V", "getJobManagerBridgeService", "()Lcom/box/android/domain/services/IJobManagerBridgeService;", "getJobService", "()Lcom/box/android/domain/services/IJobService;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class JobsProgressEnvironment {
    public static final int $stable = 8;
    private final IJobManagerBridgeService jobManagerBridgeService;
    private final IJobService jobService;

    public static /* synthetic */ JobsProgressEnvironment copy$default(JobsProgressEnvironment jobsProgressEnvironment, IJobManagerBridgeService iJobManagerBridgeService, IJobService iJobService, int i, Object obj) {
        if ((i & 1) != 0) {
            iJobManagerBridgeService = jobsProgressEnvironment.jobManagerBridgeService;
        }
        if ((i & 2) != 0) {
            iJobService = jobsProgressEnvironment.jobService;
        }
        return jobsProgressEnvironment.copy(iJobManagerBridgeService, iJobService);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final IJobManagerBridgeService getJobManagerBridgeService() {
        return this.jobManagerBridgeService;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final IJobService getJobService() {
        return this.jobService;
    }

    public final JobsProgressEnvironment copy(IJobManagerBridgeService jobManagerBridgeService, IJobService jobService) {
        Intrinsics.checkNotNullParameter(jobManagerBridgeService, "jobManagerBridgeService");
        Intrinsics.checkNotNullParameter(jobService, "jobService");
        return new JobsProgressEnvironment(jobManagerBridgeService, jobService);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JobsProgressEnvironment)) {
            return false;
        }
        JobsProgressEnvironment jobsProgressEnvironment = (JobsProgressEnvironment) other;
        return Intrinsics.areEqual(this.jobManagerBridgeService, jobsProgressEnvironment.jobManagerBridgeService) && Intrinsics.areEqual(this.jobService, jobsProgressEnvironment.jobService);
    }

    public int hashCode() {
        return (this.jobManagerBridgeService.hashCode() * 31) + this.jobService.hashCode();
    }

    public String toString() {
        return "JobsProgressEnvironment(jobManagerBridgeService=" + this.jobManagerBridgeService + ", jobService=" + this.jobService + ")";
    }

    @Inject
    public JobsProgressEnvironment(IJobManagerBridgeService jobManagerBridgeService, IJobService jobService) {
        Intrinsics.checkNotNullParameter(jobManagerBridgeService, "jobManagerBridgeService");
        Intrinsics.checkNotNullParameter(jobService, "jobService");
        this.jobManagerBridgeService = jobManagerBridgeService;
        this.jobService = jobService;
    }

    public final IJobManagerBridgeService getJobManagerBridgeService() {
        return this.jobManagerBridgeService;
    }

    public final IJobService getJobService() {
        return this.jobService;
    }
}
