package com.box.android.data.jobs;

import com.box.android.data.persistence.jobs.JobEntity;
import com.box.android.domain.jobs.JobId;
import com.box.android.domain.jobs.JobRequest;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.models.BoxRepresentation;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: JobService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J(\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010\fJ \u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000fH¦@¢\u0006\u0002\u0010\u0010J\u001e\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H¦@¢\u0006\u0002\u0010\u0014J&\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013H¦@¢\u0006\u0002\u0010\u0017J\u0016\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001aH¦@¢\u0006\u0002\u0010\u001bJ\u0016\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J:\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00052\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00050#H¦@¢\u0006\u0002\u0010$J\u001e\u0010%\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010&\u001a\u00020'H¦@¢\u0006\u0002\u0010(¨\u0006)À\u0006\u0003"}, d2 = {"Lcom/box/android/data/jobs/IJobEventObserver;", "", "jobSucceeded", "", JobWorker.JOB_ID_PARAM, "Lcom/box/android/domain/jobs/JobId;", "(Lcom/box/android/domain/jobs/JobId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "jobFailed", "jobType", "", "error", "Lcom/box/android/domain/models/DomainError;", "(Lcom/box/android/domain/jobs/JobId;Ljava/lang/String;Lcom/box/android/domain/models/DomainError;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "jobRunning", "updateStartTime", "", "(Lcom/box/android/domain/jobs/JobId;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "networkTaskStarting", "estimatedWork", "", "(Lcom/box/android/domain/jobs/JobId;DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "taskProgress", "currentProgress", "(Lcom/box/android/domain/jobs/JobId;DDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "jobSubmitted", "jobEntity", "Lcom/box/android/data/persistence/jobs/JobEntity;", "(Lcom/box/android/data/persistence/jobs/JobEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "waitForChildren", "enqueueChildJob", "Lcom/box/android/domain/utils/result/Result;", "jobRequest", "Lcom/box/android/domain/jobs/JobRequest;", "parentID", "predecessors", "", "(Lcom/box/android/domain/jobs/JobRequest;Lcom/box/android/domain/jobs/JobId;Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "notifyParent", BoxRepresentation.FIELD_INFO, "", "(Lcom/box/android/domain/jobs/JobId;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IJobEventObserver {
    Object enqueueChildJob(JobRequest jobRequest, JobId jobId, Set<JobId> set, Continuation<? super Result<Unit, ? extends DomainError>> continuation);

    Object jobFailed(JobId jobId, String str, DomainError domainError, Continuation<? super Unit> continuation);

    Object jobRunning(JobId jobId, boolean z, Continuation<? super Unit> continuation);

    Object jobSubmitted(JobEntity jobEntity, Continuation<? super Unit> continuation);

    Object jobSucceeded(JobId jobId, Continuation<? super Unit> continuation);

    Object networkTaskStarting(JobId jobId, double d, Continuation<? super Unit> continuation);

    Object notifyParent(JobId jobId, byte[] bArr, Continuation<? super Unit> continuation);

    Object taskProgress(JobId jobId, double d, double d2, Continuation<? super Unit> continuation);

    Object waitForChildren(JobId jobId, Continuation<? super Unit> continuation);

    /* JADX INFO: compiled from: JobService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object jobRunning$default(IJobEventObserver iJobEventObserver, JobId jobId, boolean z, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: jobRunning");
        }
        if ((i & 2) != 0) {
            z = true;
        }
        return iJobEventObserver.jobRunning(jobId, z, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Object enqueueChildJob$default(IJobEventObserver iJobEventObserver, JobRequest jobRequest, JobId jobId, Set set, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enqueueChildJob");
        }
        if ((i & 4) != 0) {
            set = SetsKt.emptySet();
        }
        return iJobEventObserver.enqueueChildJob(jobRequest, jobId, set, continuation);
    }
}
