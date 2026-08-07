package com.box.android.data.api.models.upload;

import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.data.jobs.JobService;
import com.box.android.data.jobs.UploadFileJobV2;
import com.box.android.data.service.impl.CommonServiceUtils;
import com.box.android.data.service.impl.LocalItemService;
import com.box.android.data.service.impl.UploadFileService;
import com.box.android.domain.jobs.JobId;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.services.IdMappingService;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
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
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u001fB;\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u001c\u001a\u00020\u001dH\u0096@¢\u0006\u0002\u0010\u001eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006 "}, d2 = {"Lcom/box/android/data/api/models/upload/UploadSessionCreationState;", "Lcom/box/android/data/api/models/upload/UploadJobState;", "jobService", "Lcom/box/android/data/jobs/JobService;", "job", "Lcom/box/android/data/jobs/UploadFileJobV2;", "uploadFileService", "Lcom/box/android/data/service/impl/UploadFileService;", "localItemService", "Lcom/box/android/data/service/impl/LocalItemService;", "commonServiceUtils", "Lcom/box/android/data/service/impl/CommonServiceUtils;", "idMappingService", "Lcom/box/android/domain/services/IdMappingService;", "<init>", "(Lcom/box/android/data/jobs/JobService;Lcom/box/android/data/jobs/UploadFileJobV2;Lcom/box/android/data/service/impl/UploadFileService;Lcom/box/android/data/service/impl/LocalItemService;Lcom/box/android/data/service/impl/CommonServiceUtils;Lcom/box/android/domain/services/IdMappingService;)V", "getJobService", "()Lcom/box/android/data/jobs/JobService;", "getJob", "()Lcom/box/android/data/jobs/UploadFileJobV2;", "getUploadFileService", "()Lcom/box/android/data/service/impl/UploadFileService;", "getLocalItemService", "()Lcom/box/android/data/service/impl/LocalItemService;", "getCommonServiceUtils", "()Lcom/box/android/data/service/impl/CommonServiceUtils;", "getIdMappingService", "()Lcom/box/android/domain/services/IdMappingService;", "onEnter", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Factory", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UploadSessionCreationState implements UploadJobState {
    private final CommonServiceUtils commonServiceUtils;
    private final IdMappingService idMappingService;
    private final UploadFileJobV2 job;
    private final JobService jobService;
    private final LocalItemService localItemService;
    private final UploadFileService uploadFileService;

    /* JADX INFO: compiled from: UploadFileStates.kt */
    @AssistedFactory
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/box/android/data/api/models/upload/UploadSessionCreationState$Factory;", "", "createState", "Lcom/box/android/data/api/models/upload/UploadSessionCreationState;", "job", "Lcom/box/android/data/jobs/UploadFileJobV2;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface Factory {
        UploadSessionCreationState createState(UploadFileJobV2 job);
    }

    @AssistedInject
    public UploadSessionCreationState(JobService jobService, @Assisted UploadFileJobV2 job, UploadFileService uploadFileService, LocalItemService localItemService, CommonServiceUtils commonServiceUtils, IdMappingService idMappingService) {
        Intrinsics.checkNotNullParameter(jobService, "jobService");
        Intrinsics.checkNotNullParameter(job, "job");
        Intrinsics.checkNotNullParameter(uploadFileService, "uploadFileService");
        Intrinsics.checkNotNullParameter(localItemService, "localItemService");
        Intrinsics.checkNotNullParameter(commonServiceUtils, "commonServiceUtils");
        Intrinsics.checkNotNullParameter(idMappingService, "idMappingService");
        this.jobService = jobService;
        this.job = job;
        this.uploadFileService = uploadFileService;
        this.localItemService = localItemService;
        this.commonServiceUtils = commonServiceUtils;
        this.idMappingService = idMappingService;
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

    public final CommonServiceUtils getCommonServiceUtils() {
        return this.commonServiceUtils;
    }

    public final IdMappingService getIdMappingService() {
        return this.idMappingService;
    }

    /* JADX INFO: renamed from: com.box.android.data.api.models.upload.UploadSessionCreationState$onEnter$2, reason: invalid class name */
    /* JADX INFO: compiled from: UploadFileStates.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "runningData", "Lcom/box/android/data/api/models/upload/UploadFileRunningData$SessionCreationData;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.api.models.upload.UploadSessionCreationState$onEnter$2", f = "UploadFileStates.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12}, l = {356, 362, 371, 379, 385, 400, 404, 420, 422, 437, 440, 441, 442}, m = "invokeSuspend", n = {"runningData", "localItemId", "runningData", "localItemId", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "runningData", "localItemId", "localItemModel", "runningData", "localItemId", "localItemModel", "localFolderId", BoxCommonConstants.EXTRA_FILE_NAME, "runningData", "localItemId", "localItemModel", "localFolderId", BoxCommonConstants.EXTRA_FILE_NAME, ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "runningData", "localItemId", "localItemModel", "localFolderId", BoxCommonConstants.EXTRA_FILE_NAME, "folderId", "fileSha1", "it", "fileSize", "$i$a$-let-UploadSessionCreationState$onEnter$2$fileIdToOverwrite$1", "runningData", "localItemId", "localItemModel", "localFolderId", BoxCommonConstants.EXTRA_FILE_NAME, "folderId", "fileSha1", "it", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "fileSize", "$i$a$-let-UploadSessionCreationState$onEnter$2$fileIdToOverwrite$1", "runningData", "localItemId", "localItemModel", "localFolderId", BoxCommonConstants.EXTRA_FILE_NAME, "folderId", "fileSha1", "fileIdToOverwrite", "logMap", "fileSize", "runningData", "localItemId", "localItemModel", "localFolderId", BoxCommonConstants.EXTRA_FILE_NAME, "folderId", "fileSha1", "fileIdToOverwrite", "logMap", "fileSize", "runningData", "localItemId", "localItemModel", "localFolderId", BoxCommonConstants.EXTRA_FILE_NAME, "folderId", "fileSha1", "fileIdToOverwrite", "logMap", "$this$onSuccess$iv", "sessionDTO", "runningInfo", "partOffsetsToBeUploaded", "fileSize", "$i$f$onSuccess", "$i$a$-onSuccess-UploadSessionCreationState$onEnter$2$1", "runningData", "localItemId", "localItemModel", "localFolderId", BoxCommonConstants.EXTRA_FILE_NAME, "folderId", "fileSha1", "fileIdToOverwrite", "logMap", "$this$onError$iv", "it", "fileSize", "$i$f$onError", "$i$a$-onError-UploadSessionCreationState$onEnter$2$2", "runningData", "localItemId", "localItemModel", "localFolderId", BoxCommonConstants.EXTRA_FILE_NAME, "folderId", "fileSha1", "fileIdToOverwrite", "logMap", "$this$onError$iv", "it", "$this$onSuccess$iv", "it", "fileSize", "$i$f$onError", "$i$a$-onError-UploadSessionCreationState$onEnter$2$2", "$i$f$onSuccess", "$i$a$-onSuccess-UploadSessionCreationState$onEnter$2$2$1", "runningData", "localItemId", "localItemModel", "localFolderId", BoxCommonConstants.EXTRA_FILE_NAME, "folderId", "fileSha1", "fileIdToOverwrite", "logMap", "$this$onError$iv", "it", "$this$onError$iv", "it", "fileSize", "$i$f$onError", "$i$a$-onError-UploadSessionCreationState$onEnter$2$2", "$i$f$onError", "$i$a$-onError-UploadSessionCreationState$onEnter$2$2$2"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$8", "J$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "J$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "J$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "J$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "L$12", "L$13", "J$0", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "J$0", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<UploadFileRunningData.SessionCreationData, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        long J$0;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = UploadSessionCreationState.this.new AnonymousClass2(continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(UploadFileRunningData.SessionCreationData sessionCreationData, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(sessionCreationData, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:103:0x06cd  */
        /* JADX WARN: Code duplicated, block: B:105:0x06d1  */
        /* JADX WARN: Code duplicated, block: B:110:0x074d  */
        /* JADX WARN: Code duplicated, block: B:112:0x0753  */
        /* JADX WARN: Code duplicated, block: B:114:0x0759  */
        /* JADX WARN: Code duplicated, block: B:116:0x075f  */
        /* JADX WARN: Code duplicated, block: B:118:0x0765  */
        /* JADX WARN: Code duplicated, block: B:120:0x076b  */
        /* JADX WARN: Code duplicated, block: B:125:0x07e1  */
        /* JADX WARN: Code duplicated, block: B:127:0x07e7  */
        /* JADX WARN: Code duplicated, block: B:132:0x083b  */
        /* JADX WARN: Code duplicated, block: B:134:0x0841  */
        /* JADX WARN: Code duplicated, block: B:139:0x08a4  */
        /* JADX WARN: Code duplicated, block: B:25:0x026c  */
        /* JADX WARN: Code duplicated, block: B:36:0x02b6  */
        /* JADX WARN: Code duplicated, block: B:38:0x02d9  */
        /* JADX WARN: Code duplicated, block: B:41:0x0319  */
        /* JADX WARN: Code duplicated, block: B:44:0x0324  */
        /* JADX WARN: Code duplicated, block: B:46:0x033c  */
        /* JADX WARN: Code duplicated, block: B:48:0x0340  */
        /* JADX WARN: Code duplicated, block: B:53:0x03cc  */
        /* JADX WARN: Code duplicated, block: B:55:0x03d2  */
        /* JADX WARN: Code duplicated, block: B:58:0x03f2  */
        /* JADX WARN: Code duplicated, block: B:62:0x0442  */
        /* JADX WARN: Code duplicated, block: B:66:0x0491  */
        /* JADX WARN: Code duplicated, block: B:69:0x04a6  */
        /* JADX WARN: Code duplicated, block: B:72:0x04d4 A[LOOP:0: B:70:0x04ce->B:72:0x04d4, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:76:0x0585  */
        /* JADX WARN: Code duplicated, block: B:78:0x0591  */
        /* JADX WARN: Code duplicated, block: B:80:0x0595  */
        /* JADX WARN: Code duplicated, block: B:84:0x05a1  */
        /* JADX WARN: Code duplicated, block: B:86:0x05a5  */
        /* JADX WARN: Code duplicated, block: B:89:0x060c  */
        /* JADX WARN: Code duplicated, block: B:92:0x0626  */
        /* JADX WARN: Code duplicated, block: B:95:0x06a0  */
        /* JADX WARN: Code duplicated, block: B:97:0x06bb  */
        /* JADX WARN: Code duplicated, block: B:99:0x06c3  */
        /* JADX WARN: Code restructure failed: missing block: B:106:0x0746, code lost:
        
            if (r8.jobFailed(r12, com.box.android.domain.jobs.JobType.UPLOAD_FILE_V2, r0, r33) == r7) goto L136;
         */
        /* JADX WARN: Code restructure failed: missing block: B:121:0x07da, code lost:
        
            if (r0.jobFailed(r1, com.box.android.domain.jobs.JobType.UPLOAD_FILE_V2, new com.box.android.domain.models.DomainError.CreateJobError(r4 + " Failed to retrieve parent serverID " + r5), r33) == r7) goto L136;
         */
        /* JADX WARN: Code restructure failed: missing block: B:128:0x0835, code lost:
        
            if (r1.jobFailed(r4, com.box.android.domain.jobs.JobType.UPLOAD_FILE_V2, new com.box.android.domain.models.DomainError.CreateJobError(r6 + " Failed to retrieve parent folder id"), r33) == r7) goto L136;
         */
        /* JADX WARN: Code restructure failed: missing block: B:135:0x089e, code lost:
        
            if (r1.jobFailed(r4, com.box.android.domain.jobs.JobType.UPLOAD_FILE_V2, new com.box.android.domain.models.DomainError.CreateJobError(r6 + " Failed to retrieve localItem " + r8), r33) == r7) goto L136;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x03c5, code lost:
        
            if (r2.jobFailed(r0, com.box.android.domain.jobs.JobType.UPLOAD_FILE_V2, r6, r33) == r7) goto L136;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r34) throws java.io.UnsupportedEncodingException {
            /*
                Method dump skipped, instruction units count: 2250
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.api.models.upload.UploadSessionCreationState.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // com.box.android.data.api.models.upload.UploadJobState
    public Object onEnter(Continuation<? super Unit> continuation) {
        Object objUpdatingRunningInfo = this.job.updatingRunningInfo(false, new AnonymousClass2(null), continuation);
        return objUpdatingRunningInfo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdatingRunningInfo : Unit.INSTANCE;
    }
}
