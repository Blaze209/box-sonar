package com.box.android.data.api.models.upload;

import com.box.android.data.jobs.JobService;
import com.box.android.data.jobs.UploadFileJobV2;
import com.box.android.data.service.impl.LocalItemService;
import com.box.android.data.service.impl.UploadFileService;
import com.box.android.domain.jobs.JobId;
import com.box.android.domain.models.DomainError;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedFactory;
import dagger.assisted.AssistedInject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UploadFileStates.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0002\u0017\u0018B+\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0014\u001a\u00020\u0015H\u0096@¢\u0006\u0002\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/box/android/data/api/models/upload/InitialState;", "Lcom/box/android/data/api/models/upload/UploadJobState;", "jobService", "Lcom/box/android/data/jobs/JobService;", "job", "Lcom/box/android/data/jobs/UploadFileJobV2;", "uploadFileService", "Lcom/box/android/data/service/impl/UploadFileService;", "localItemService", "Lcom/box/android/data/service/impl/LocalItemService;", "<init>", "(Lcom/box/android/data/jobs/JobService;Lcom/box/android/data/jobs/UploadFileJobV2;Lcom/box/android/data/service/impl/UploadFileService;Lcom/box/android/data/service/impl/LocalItemService;)V", "getJobService", "()Lcom/box/android/data/jobs/JobService;", "getJob", "()Lcom/box/android/data/jobs/UploadFileJobV2;", "getUploadFileService", "()Lcom/box/android/data/service/impl/UploadFileService;", "getLocalItemService", "()Lcom/box/android/data/service/impl/LocalItemService;", "onEnter", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "Factory", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class InitialState implements UploadJobState {
    public static final long MIN_LARGE_FILE_SIZE = 21000000;
    public static final long MIN_SMALL_FILE_SIZE = 1000000;
    private final UploadFileJobV2 job;
    private final JobService jobService;
    private final LocalItemService localItemService;
    private final UploadFileService uploadFileService;

    /* JADX INFO: compiled from: UploadFileStates.kt */
    @AssistedFactory
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/box/android/data/api/models/upload/InitialState$Factory;", "", "createState", "Lcom/box/android/data/api/models/upload/InitialState;", "job", "Lcom/box/android/data/jobs/UploadFileJobV2;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface Factory {
        InitialState createState(UploadFileJobV2 job);
    }

    @AssistedInject
    public InitialState(JobService jobService, @Assisted UploadFileJobV2 job, UploadFileService uploadFileService, LocalItemService localItemService) {
        Intrinsics.checkNotNullParameter(jobService, "jobService");
        Intrinsics.checkNotNullParameter(job, "job");
        Intrinsics.checkNotNullParameter(uploadFileService, "uploadFileService");
        Intrinsics.checkNotNullParameter(localItemService, "localItemService");
        this.jobService = jobService;
        this.job = job;
        this.uploadFileService = uploadFileService;
        this.localItemService = localItemService;
    }

    @Override // com.box.android.data.api.models.upload.UploadJobState
    public /* bridge */ Object childFailed(JobId jobId, DomainError domainError, Continuation<? super Unit> continuation) {
        return super.childFailed(jobId, domainError, continuation);
    }

    @Override // com.box.android.data.api.models.upload.UploadJobState
    public /* bridge */ Object childSuccess(JobId jobId, Continuation<? super Unit> continuation) {
        return super.childSuccess(jobId, continuation);
    }

    @Override // com.box.android.data.api.models.upload.UploadJobState
    public /* bridge */ Object handleChildResult(JobId jobId, byte[] bArr, Continuation<? super Unit> continuation) {
        return super.handleChildResult(jobId, bArr, continuation);
    }

    public final JobService getJobService() {
        return this.jobService;
    }

    public final UploadFileJobV2 getJob() {
        return this.job;
    }

    public final UploadFileService getUploadFileService() {
        return this.uploadFileService;
    }

    public final LocalItemService getLocalItemService() {
        return this.localItemService;
    }

    /* JADX INFO: renamed from: com.box.android.data.api.models.upload.InitialState$onEnter$2, reason: invalid class name */
    /* JADX INFO: compiled from: UploadFileStates.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "runningData", "Lcom/box/android/data/api/models/upload/UploadFileRunningData$InitialData;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.api.models.upload.InitialState$onEnter$2", f = "UploadFileStates.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {84, 101}, m = "invokeSuspend", n = {"runningData", "fileSha1", "itemId", "fileSize", "runningData", "fileSha1", "itemId", "runningInfo", "fileSize"}, s = {"L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "L$2", "L$3", "J$0"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<UploadFileRunningData.InitialData, Continuation<? super Unit>, Object> {
        long J$0;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = InitialState.this.new AnonymousClass2(continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(UploadFileRunningData.InitialData initialData, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(initialData, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x00cb, code lost:
        
            if (com.box.android.data.jobs.UploadFileJobV2.updateRunningInfo$default(r14.this$0.getJob(), r8, false, r14, 2, null) == r1) goto L24;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                Method dump skipped, instruction units count: 209
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.api.models.upload.InitialState.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // com.box.android.data.api.models.upload.UploadJobState
    public Object onEnter(Continuation<? super Unit> continuation) {
        Object objUpdatingRunningInfo = this.job.updatingRunningInfo(false, new AnonymousClass2(null), continuation);
        return objUpdatingRunningInfo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdatingRunningInfo : Unit.INSTANCE;
    }
}
