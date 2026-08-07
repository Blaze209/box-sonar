package com.box.android.domain.models;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.jobs.JobId;
import external.sdk.pendo.io.mozilla.javascript.ES6Iterator;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: JobInfo.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001:\u0002!\"B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J9\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006#"}, d2 = {"Lcom/box/android/domain/models/JobInfo;", "Lcom/box/android/domain/models/DomainModel;", "id", "Lcom/box/android/domain/jobs/JobId;", "jobType", "", "infoProvider", "Lcom/box/android/domain/models/IJobDisplayInfoProvider;", "status", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/domain/models/JobInfo$Status;", "<init>", "(Lcom/box/android/domain/jobs/JobId;Ljava/lang/String;Lcom/box/android/domain/models/IJobDisplayInfoProvider;Lkotlinx/coroutines/flow/Flow;)V", "getId", "()Lcom/box/android/domain/jobs/JobId;", "getJobType", "()Ljava/lang/String;", "getInfoProvider", "()Lcom/box/android/domain/models/IJobDisplayInfoProvider;", "getStatus", "()Lkotlinx/coroutines/flow/Flow;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "Status", "Progress", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class JobInfo implements DomainModel {
    private final JobId id;
    private final IJobDisplayInfoProvider infoProvider;
    private final String jobType;
    private final Flow<Status> status;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ JobInfo copy$default(JobInfo jobInfo, JobId jobId, String str, IJobDisplayInfoProvider iJobDisplayInfoProvider, Flow flow, int i, Object obj) {
        if ((i & 1) != 0) {
            jobId = jobInfo.id;
        }
        if ((i & 2) != 0) {
            str = jobInfo.jobType;
        }
        if ((i & 4) != 0) {
            iJobDisplayInfoProvider = jobInfo.infoProvider;
        }
        if ((i & 8) != 0) {
            flow = jobInfo.status;
        }
        return jobInfo.copy(jobId, str, iJobDisplayInfoProvider, flow);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final JobId getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getJobType() {
        return this.jobType;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final IJobDisplayInfoProvider getInfoProvider() {
        return this.infoProvider;
    }

    public final Flow<Status> component4() {
        return this.status;
    }

    public final JobInfo copy(JobId id, String jobType, IJobDisplayInfoProvider infoProvider, Flow<? extends Status> status) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(jobType, "jobType");
        Intrinsics.checkNotNullParameter(status, "status");
        return new JobInfo(id, jobType, infoProvider, status);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JobInfo)) {
            return false;
        }
        JobInfo jobInfo = (JobInfo) other;
        return Intrinsics.areEqual(this.id, jobInfo.id) && Intrinsics.areEqual(this.jobType, jobInfo.jobType) && Intrinsics.areEqual(this.infoProvider, jobInfo.infoProvider) && Intrinsics.areEqual(this.status, jobInfo.status);
    }

    public int hashCode() {
        int iHashCode = ((this.id.hashCode() * 31) + this.jobType.hashCode()) * 31;
        IJobDisplayInfoProvider iJobDisplayInfoProvider = this.infoProvider;
        return ((iHashCode + (iJobDisplayInfoProvider == null ? 0 : iJobDisplayInfoProvider.hashCode())) * 31) + this.status.hashCode();
    }

    public String toString() {
        return "JobInfo(id=" + this.id + ", jobType=" + this.jobType + ", infoProvider=" + this.infoProvider + ", status=" + this.status + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public JobInfo(JobId id, String jobType, IJobDisplayInfoProvider iJobDisplayInfoProvider, Flow<? extends Status> status) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(jobType, "jobType");
        Intrinsics.checkNotNullParameter(status, "status");
        this.id = id;
        this.jobType = jobType;
        this.infoProvider = iJobDisplayInfoProvider;
        this.status = status;
    }

    public final JobId getId() {
        return this.id;
    }

    public final String getJobType() {
        return this.jobType;
    }

    public final IJobDisplayInfoProvider getInfoProvider() {
        return this.infoProvider;
    }

    public final Flow<Status> getStatus() {
        return this.status;
    }

    /* JADX INFO: compiled from: JobInfo.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\b\u0004\u0005\u0006\u0007\b\t\n\u000bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\b\f\r\u000e\u000f\u0010\u0011\u0012\u0013¨\u0006\u0014"}, d2 = {"Lcom/box/android/domain/models/JobInfo$Status;", "", "<init>", "()V", "Waiting", "Delayed", "Blocked", "Running", "Failed", "Paused", "Cancelled", "Succeeded", "Lcom/box/android/domain/models/JobInfo$Status$Blocked;", "Lcom/box/android/domain/models/JobInfo$Status$Cancelled;", "Lcom/box/android/domain/models/JobInfo$Status$Delayed;", "Lcom/box/android/domain/models/JobInfo$Status$Failed;", "Lcom/box/android/domain/models/JobInfo$Status$Paused;", "Lcom/box/android/domain/models/JobInfo$Status$Running;", "Lcom/box/android/domain/models/JobInfo$Status$Succeeded;", "Lcom/box/android/domain/models/JobInfo$Status$Waiting;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Status {
        public /* synthetic */ Status(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: JobInfo.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/domain/models/JobInfo$Status$Waiting;", "Lcom/box/android/domain/models/JobInfo$Status;", "<init>", "()V", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Waiting extends Status {
            public static final Waiting INSTANCE = new Waiting();

            private Waiting() {
                super(null);
            }
        }

        private Status() {
        }

        /* JADX INFO: compiled from: JobInfo.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/domain/models/JobInfo$Status$Delayed;", "Lcom/box/android/domain/models/JobInfo$Status;", "until", "Ljava/util/Date;", "<init>", "(Ljava/util/Date;)V", "getUntil", "()Ljava/util/Date;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Delayed extends Status {
            private final Date until;

            public static /* synthetic */ Delayed copy$default(Delayed delayed, Date date, int i, Object obj) {
                if ((i & 1) != 0) {
                    date = delayed.until;
                }
                return delayed.copy(date);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Date getUntil() {
                return this.until;
            }

            public final Delayed copy(Date until) {
                Intrinsics.checkNotNullParameter(until, "until");
                return new Delayed(until);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Delayed) && Intrinsics.areEqual(this.until, ((Delayed) other).until);
            }

            public int hashCode() {
                return this.until.hashCode();
            }

            public String toString() {
                return "Delayed(until=" + this.until + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Delayed(Date until) {
                super(null);
                Intrinsics.checkNotNullParameter(until, "until");
                this.until = until;
            }

            public final Date getUntil() {
                return this.until;
            }
        }

        /* JADX INFO: compiled from: JobInfo.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/domain/models/JobInfo$Status$Blocked;", "Lcom/box/android/domain/models/JobInfo$Status;", "failedDependencies", "", "Lcom/box/android/domain/jobs/JobId;", "<init>", "(Ljava/util/List;)V", "getFailedDependencies", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Blocked extends Status {
            private final List<JobId> failedDependencies;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Blocked copy$default(Blocked blocked, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = blocked.failedDependencies;
                }
                return blocked.copy(list);
            }

            public final List<JobId> component1() {
                return this.failedDependencies;
            }

            public final Blocked copy(List<JobId> failedDependencies) {
                Intrinsics.checkNotNullParameter(failedDependencies, "failedDependencies");
                return new Blocked(failedDependencies);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Blocked) && Intrinsics.areEqual(this.failedDependencies, ((Blocked) other).failedDependencies);
            }

            public int hashCode() {
                return this.failedDependencies.hashCode();
            }

            public String toString() {
                return "Blocked(failedDependencies=" + this.failedDependencies + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Blocked(List<JobId> failedDependencies) {
                super(null);
                Intrinsics.checkNotNullParameter(failedDependencies, "failedDependencies");
                this.failedDependencies = failedDependencies;
            }

            public final List<JobId> getFailedDependencies() {
                return this.failedDependencies;
            }
        }

        /* JADX INFO: compiled from: JobInfo.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/domain/models/JobInfo$Status$Running;", "Lcom/box/android/domain/models/JobInfo$Status;", "progress", "Lcom/box/android/domain/models/JobInfo$Progress;", "<init>", "(Lcom/box/android/domain/models/JobInfo$Progress;)V", "getProgress", "()Lcom/box/android/domain/models/JobInfo$Progress;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Running extends Status {
            private final Progress progress;

            /* JADX WARN: Multi-variable type inference failed */
            public Running() {
                this(null, 1, 0 == true ? 1 : 0);
            }

            public static /* synthetic */ Running copy$default(Running running, Progress progress, int i, Object obj) {
                if ((i & 1) != 0) {
                    progress = running.progress;
                }
                return running.copy(progress);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Progress getProgress() {
                return this.progress;
            }

            public final Running copy(Progress progress) {
                return new Running(progress);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Running) && Intrinsics.areEqual(this.progress, ((Running) other).progress);
            }

            public int hashCode() {
                Progress progress = this.progress;
                if (progress == null) {
                    return 0;
                }
                return progress.hashCode();
            }

            public String toString() {
                return "Running(progress=" + this.progress + ")";
            }

            public Running(Progress progress) {
                super(null);
                this.progress = progress;
            }

            public /* synthetic */ Running(Progress progress, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : progress);
            }

            public final Progress getProgress() {
                return this.progress;
            }
        }

        /* JADX INFO: compiled from: JobInfo.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/domain/models/JobInfo$Status$Failed;", "Lcom/box/android/domain/models/JobInfo$Status;", "error", "Lcom/box/android/domain/models/DomainError;", "<init>", "(Lcom/box/android/domain/models/DomainError;)V", "getError", "()Lcom/box/android/domain/models/DomainError;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Failed extends Status {
            private final DomainError error;

            public static /* synthetic */ Failed copy$default(Failed failed, DomainError domainError, int i, Object obj) {
                if ((i & 1) != 0) {
                    domainError = failed.error;
                }
                return failed.copy(domainError);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final DomainError getError() {
                return this.error;
            }

            public final Failed copy(DomainError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                return new Failed(error);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Failed) && Intrinsics.areEqual(this.error, ((Failed) other).error);
            }

            public int hashCode() {
                return this.error.hashCode();
            }

            public String toString() {
                return "Failed(error=" + this.error + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Failed(DomainError error) {
                super(null);
                Intrinsics.checkNotNullParameter(error, "error");
                this.error = error;
            }

            public final DomainError getError() {
                return this.error;
            }
        }

        /* JADX INFO: compiled from: JobInfo.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/domain/models/JobInfo$Status$Paused;", "Lcom/box/android/domain/models/JobInfo$Status;", "progress", "Lcom/box/android/domain/models/JobInfo$Progress;", "<init>", "(Lcom/box/android/domain/models/JobInfo$Progress;)V", "getProgress", "()Lcom/box/android/domain/models/JobInfo$Progress;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Paused extends Status {
            private final Progress progress;

            public static /* synthetic */ Paused copy$default(Paused paused, Progress progress, int i, Object obj) {
                if ((i & 1) != 0) {
                    progress = paused.progress;
                }
                return paused.copy(progress);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Progress getProgress() {
                return this.progress;
            }

            public final Paused copy(Progress progress) {
                return new Paused(progress);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Paused) && Intrinsics.areEqual(this.progress, ((Paused) other).progress);
            }

            public int hashCode() {
                Progress progress = this.progress;
                if (progress == null) {
                    return 0;
                }
                return progress.hashCode();
            }

            public String toString() {
                return "Paused(progress=" + this.progress + ")";
            }

            public Paused(Progress progress) {
                super(null);
                this.progress = progress;
            }

            public final Progress getProgress() {
                return this.progress;
            }
        }

        /* JADX INFO: compiled from: JobInfo.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/domain/models/JobInfo$Status$Cancelled;", "Lcom/box/android/domain/models/JobInfo$Status;", "<init>", "()V", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Cancelled extends Status {
            public static final Cancelled INSTANCE = new Cancelled();

            private Cancelled() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: JobInfo.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/domain/models/JobInfo$Status$Succeeded;", "Lcom/box/android/domain/models/JobInfo$Status;", "<init>", "()V", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Succeeded extends Status {
            public static final Succeeded INSTANCE = new Succeeded();

            private Succeeded() {
                super(null);
            }
        }
    }

    /* JADX INFO: compiled from: JobInfo.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/box/android/domain/models/JobInfo$Progress;", "", ES6Iterator.DONE_PROPERTY, "", "estimatedTotal", "<init>", "(DD)V", "getDone", "()D", "getEstimatedTotal", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Progress {
        private final double done;
        private final double estimatedTotal;

        public static /* synthetic */ Progress copy$default(Progress progress, double d, double d2, int i, Object obj) {
            if ((i & 1) != 0) {
                d = progress.done;
            }
            if ((i & 2) != 0) {
                d2 = progress.estimatedTotal;
            }
            return progress.copy(d, d2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final double getDone() {
            return this.done;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final double getEstimatedTotal() {
            return this.estimatedTotal;
        }

        public final Progress copy(double done, double estimatedTotal) {
            return new Progress(done, estimatedTotal);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Progress)) {
                return false;
            }
            Progress progress = (Progress) other;
            return Double.compare(this.done, progress.done) == 0 && Double.compare(this.estimatedTotal, progress.estimatedTotal) == 0;
        }

        public int hashCode() {
            return (Double.hashCode(this.done) * 31) + Double.hashCode(this.estimatedTotal);
        }

        public String toString() {
            return "Progress(done=" + this.done + ", estimatedTotal=" + this.estimatedTotal + ")";
        }

        public Progress(double d, double d2) {
            this.done = d;
            this.estimatedTotal = d2;
        }

        public final double getDone() {
            return this.done;
        }

        public final double getEstimatedTotal() {
            return this.estimatedTotal;
        }
    }
}
