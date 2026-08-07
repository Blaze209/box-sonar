package com.box.android.data.api.models.upload;

import com.box.android.domain.jobs.JobId;
import com.box.android.domain.models.DomainError;
import com.box.androidsdk.content.models.BoxRepresentation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: UploadFileStates.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\bJ\u001e\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fJ\u001e\u0010\r\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0010¨\u0006\u0011À\u0006\u0003"}, d2 = {"Lcom/box/android/data/api/models/upload/UploadJobState;", "", "onEnter", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "childSuccess", "childJobId", "Lcom/box/android/domain/jobs/JobId;", "(Lcom/box/android/domain/jobs/JobId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "childFailed", "domainError", "Lcom/box/android/domain/models/DomainError;", "(Lcom/box/android/domain/jobs/JobId;Lcom/box/android/domain/models/DomainError;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleChildResult", BoxRepresentation.FIELD_INFO, "", "(Lcom/box/android/domain/jobs/JobId;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface UploadJobState {
    default Object childFailed(JobId jobId, DomainError domainError, Continuation<? super Unit> continuation) {
        return childFailed$suspendImpl(this, jobId, domainError, continuation);
    }

    default Object childSuccess(JobId jobId, Continuation<? super Unit> continuation) {
        return childSuccess$suspendImpl(this, jobId, continuation);
    }

    default Object handleChildResult(JobId jobId, byte[] bArr, Continuation<? super Unit> continuation) {
        return handleChildResult$suspendImpl(this, jobId, bArr, continuation);
    }

    Object onEnter(Continuation<? super Unit> continuation);

    /* JADX INFO: compiled from: UploadFileStates.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static Object childSuccess(UploadJobState uploadJobState, JobId jobId, Continuation<? super Unit> continuation) {
            return UploadJobState.super.childSuccess(jobId, continuation);
        }

        @Deprecated
        public static Object childFailed(UploadJobState uploadJobState, JobId jobId, DomainError domainError, Continuation<? super Unit> continuation) {
            return UploadJobState.super.childFailed(jobId, domainError, continuation);
        }

        @Deprecated
        public static Object handleChildResult(UploadJobState uploadJobState, JobId jobId, byte[] bArr, Continuation<? super Unit> continuation) {
            return UploadJobState.super.handleChildResult(jobId, bArr, continuation);
        }
    }

    static /* synthetic */ Object childSuccess$suspendImpl(UploadJobState uploadJobState, JobId jobId, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    static /* synthetic */ Object childFailed$suspendImpl(UploadJobState uploadJobState, JobId jobId, DomainError domainError, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    static /* synthetic */ Object handleChildResult$suspendImpl(UploadJobState uploadJobState, JobId jobId, byte[] bArr, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }
}
