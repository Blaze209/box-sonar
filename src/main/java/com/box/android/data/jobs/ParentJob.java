package com.box.android.data.jobs;

import com.box.android.data.persistence.jobs.JobEntity;
import com.box.android.domain.jobs.JobId;
import com.box.android.domain.models.DomainError;
import com.box.androidsdk.content.models.BoxRepresentation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: Job.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\nJ&\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH¦@¢\u0006\u0002\u0010\u000fJ\u001e\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H¦@¢\u0006\u0002\u0010\u0013¨\u0006\u0014À\u0006\u0003"}, d2 = {"Lcom/box/android/data/jobs/ParentJob;", "Lcom/box/android/data/jobs/Job;", "childSucceeded", "", "childJobId", "Lcom/box/android/domain/jobs/JobId;", "(Lcom/box/android/domain/jobs/JobId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "childFailed", "domainError", "Lcom/box/android/domain/models/DomainError;", "(Lcom/box/android/domain/jobs/JobId;Lcom/box/android/domain/models/DomainError;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "childProgressed", "currentProgress", "", "estimatedWork", "(Lcom/box/android/domain/jobs/JobId;DDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveFromChild", BoxRepresentation.FIELD_INFO, "", "(Lcom/box/android/domain/jobs/JobId;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ParentJob extends Job {
    Object childFailed(JobId jobId, DomainError domainError, Continuation<? super Unit> continuation);

    Object childProgressed(JobId jobId, double d, double d2, Continuation<? super Unit> continuation);

    Object childSucceeded(JobId jobId, Continuation<? super Unit> continuation);

    Object receiveFromChild(JobId jobId, byte[] bArr, Continuation<? super Unit> continuation);

    /* JADX INFO: compiled from: Job.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static Object run(ParentJob parentJob, JobEntity jobEntity, Continuation<? super Unit> continuation) {
            return ParentJob.super.run(jobEntity, continuation);
        }
    }
}
