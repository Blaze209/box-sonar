package com.box.android.domain.services;

import com.box.android.data.jobs.JobWorker;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.jobs.JobConstants;
import com.box.android.domain.jobs.JobId;
import com.box.android.domain.jobs.JobRequest;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.JobInfo;
import com.box.android.domain.utils.result.Result;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.SharedFlow;

/* JADX INFO: compiled from: IJobService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001(J2\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u000b\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH¦@¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0007\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u000fH¦@¢\u0006\u0002\u0010\u0012J.\u0010\u0013\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0004\u0012\u00020\n0\b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0014H¦@¢\u0006\u0002\u0010\u0018J \u0010\u0019\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0004\u0012\u00020\n0\bH¦@¢\u0006\u0002\u0010\u001aJ,\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\u001dH¦@¢\u0006\u0002\u0010\u001eJ\"\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u0011\u001a\u00020\u000fH¦@¢\u0006\u0002\u0010\u0012J\u000e\u0010 \u001a\u00020\tH¦@¢\u0006\u0002\u0010\u001aJ \u0010!\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0004\u0012\u00020\n0\bH¦@¢\u0006\u0002\u0010\u001aJ\u0016\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020$H¦@¢\u0006\u0002\u0010%J\u000e\u0010&\u001a\u00020\tH¦@¢\u0006\u0002\u0010\u001aJ\u000e\u0010'\u001a\u00020\tH¦@¢\u0006\u0002\u0010\u001aR\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006)À\u0006\u0003"}, d2 = {"Lcom/box/android/domain/services/IJobService;", "", "jobEnqueuedFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "Lcom/box/android/domain/services/IJobService$JobEnqueuedEvent;", "getJobEnqueuedFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "enqueue", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "jobRequest", "Lcom/box/android/domain/jobs/JobRequest;", "dependingOn", "", "Lcom/box/android/domain/jobs/JobId;", "(Lcom/box/android/domain/jobs/JobRequest;Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", JobWorker.JOB_ID_PARAM, "(Lcom/box/android/domain/jobs/JobId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getJobInfos", "", "Lcom/box/android/domain/models/JobInfo;", "tags", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllJobInfos", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dequeue", "deleteDependents", "", "(Lcom/box/android/domain/jobs/JobId;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "retryJob", "cleanup", "getEnqueuedAutoUploadJobs", "cancelMarkForOfflineJob", "remoteItemId", "Lcom/box/android/domain/models/ItemId$Remote;", "(Lcom/box/android/domain/models/ItemId$Remote;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelEnqueuedAutoUploadJobs", "cancelAllMarkForOfflineJobs", "JobEnqueuedEvent", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IJobService {
    Object cancelAllMarkForOfflineJobs(Continuation<? super Unit> continuation);

    Object cancelEnqueuedAutoUploadJobs(Continuation<? super Unit> continuation);

    Object cancelMarkForOfflineJob(ItemId.Remote remote, Continuation<? super Unit> continuation);

    Object cleanup(Continuation<? super Unit> continuation);

    Object dequeue(JobId jobId, boolean z, Continuation<? super Result<Unit, ? extends DomainError>> continuation);

    Object enqueue(JobId jobId, Continuation<? super Unit> continuation);

    Object enqueue(JobRequest jobRequest, Set<JobId> set, Continuation<? super Result<Unit, ? extends DomainError>> continuation);

    Object getAllJobInfos(Continuation<? super Result<? extends List<JobInfo>, ? extends DomainError>> continuation);

    Object getEnqueuedAutoUploadJobs(Continuation<? super Result<? extends List<JobInfo>, ? extends DomainError>> continuation);

    SharedFlow<JobEnqueuedEvent> getJobEnqueuedFlow();

    Object getJobInfos(List<String> list, Continuation<? super Result<? extends List<JobInfo>, ? extends DomainError>> continuation);

    Object retryJob(JobId jobId, Continuation<? super Result<Unit, ? extends DomainError>> continuation);

    /* JADX INFO: compiled from: IJobService.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/box/android/domain/services/IJobService$JobEnqueuedEvent;", "", JobConstants.SHOW_NOTIFICATION, "", "jobType", "", "<init>", "(ZLjava/lang/String;)V", "getShowNotification", "()Z", "getJobType", "()Ljava/lang/String;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class JobEnqueuedEvent {
        private final String jobType;
        private final boolean showNotification;

        public static /* synthetic */ JobEnqueuedEvent copy$default(JobEnqueuedEvent jobEnqueuedEvent, boolean z, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                z = jobEnqueuedEvent.showNotification;
            }
            if ((i & 2) != 0) {
                str = jobEnqueuedEvent.jobType;
            }
            return jobEnqueuedEvent.copy(z, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getShowNotification() {
            return this.showNotification;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getJobType() {
            return this.jobType;
        }

        public final JobEnqueuedEvent copy(boolean showNotification, String jobType) {
            Intrinsics.checkNotNullParameter(jobType, "jobType");
            return new JobEnqueuedEvent(showNotification, jobType);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof JobEnqueuedEvent)) {
                return false;
            }
            JobEnqueuedEvent jobEnqueuedEvent = (JobEnqueuedEvent) other;
            return this.showNotification == jobEnqueuedEvent.showNotification && Intrinsics.areEqual(this.jobType, jobEnqueuedEvent.jobType);
        }

        public int hashCode() {
            return (Boolean.hashCode(this.showNotification) * 31) + this.jobType.hashCode();
        }

        public String toString() {
            return "JobEnqueuedEvent(showNotification=" + this.showNotification + ", jobType=" + this.jobType + ")";
        }

        public JobEnqueuedEvent(boolean z, String jobType) {
            Intrinsics.checkNotNullParameter(jobType, "jobType");
            this.showNotification = z;
            this.jobType = jobType;
        }

        public final String getJobType() {
            return this.jobType;
        }

        public final boolean getShowNotification() {
            return this.showNotification;
        }
    }

    /* JADX INFO: compiled from: IJobService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Object enqueue$default(IJobService iJobService, JobRequest jobRequest, Set set, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enqueue");
        }
        if ((i & 2) != 0) {
            set = SetsKt.emptySet();
        }
        return iJobService.enqueue(jobRequest, set, continuation);
    }

    static /* synthetic */ Object dequeue$default(IJobService iJobService, JobId jobId, boolean z, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dequeue");
        }
        if ((i & 2) != 0) {
            z = true;
        }
        return iJobService.dequeue(jobId, z, continuation);
    }
}
