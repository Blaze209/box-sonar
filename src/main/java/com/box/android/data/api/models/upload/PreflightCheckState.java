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
import external.sdk.pendo.io.mozilla.javascript.Token;
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
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u001fB;\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u001c\u001a\u00020\u001dH\u0096@¢\u0006\u0002\u0010\u001eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006 "}, d2 = {"Lcom/box/android/data/api/models/upload/PreflightCheckState;", "Lcom/box/android/data/api/models/upload/UploadJobState;", "jobService", "Lcom/box/android/data/jobs/JobService;", "job", "Lcom/box/android/data/jobs/UploadFileJobV2;", "uploadFileService", "Lcom/box/android/data/service/impl/UploadFileService;", "localItemService", "Lcom/box/android/data/service/impl/LocalItemService;", "commonServiceUtils", "Lcom/box/android/data/service/impl/CommonServiceUtils;", "idMappingService", "Lcom/box/android/domain/services/IdMappingService;", "<init>", "(Lcom/box/android/data/jobs/JobService;Lcom/box/android/data/jobs/UploadFileJobV2;Lcom/box/android/data/service/impl/UploadFileService;Lcom/box/android/data/service/impl/LocalItemService;Lcom/box/android/data/service/impl/CommonServiceUtils;Lcom/box/android/domain/services/IdMappingService;)V", "getJobService", "()Lcom/box/android/data/jobs/JobService;", "getJob", "()Lcom/box/android/data/jobs/UploadFileJobV2;", "getUploadFileService", "()Lcom/box/android/data/service/impl/UploadFileService;", "getLocalItemService", "()Lcom/box/android/data/service/impl/LocalItemService;", "getCommonServiceUtils", "()Lcom/box/android/data/service/impl/CommonServiceUtils;", "getIdMappingService", "()Lcom/box/android/domain/services/IdMappingService;", "onEnter", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Factory", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PreflightCheckState implements UploadJobState {
    private final CommonServiceUtils commonServiceUtils;
    private final IdMappingService idMappingService;
    private final UploadFileJobV2 job;
    private final JobService jobService;
    private final LocalItemService localItemService;
    private final UploadFileService uploadFileService;

    /* JADX INFO: compiled from: UploadFileStates.kt */
    @AssistedFactory
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/box/android/data/api/models/upload/PreflightCheckState$Factory;", "", "createState", "Lcom/box/android/data/api/models/upload/PreflightCheckState;", "job", "Lcom/box/android/data/jobs/UploadFileJobV2;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface Factory {
        PreflightCheckState createState(UploadFileJobV2 job);
    }

    @AssistedInject
    public PreflightCheckState(JobService jobService, @Assisted UploadFileJobV2 job, UploadFileService uploadFileService, LocalItemService localItemService, CommonServiceUtils commonServiceUtils, IdMappingService idMappingService) {
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

    /* JADX INFO: renamed from: com.box.android.data.api.models.upload.PreflightCheckState$onEnter$2, reason: invalid class name */
    /* JADX INFO: compiled from: UploadFileStates.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "runningData", "Lcom/box/android/data/api/models/upload/UploadFileRunningData$PreflightCheckData;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.api.models.upload.PreflightCheckState$onEnter$2", f = "UploadFileStates.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12}, l = {122, 128, Token.SCRIPT, Token.XML, 150, 160, Token.GENEXPR, 179, 184, 191, 194, 195, 196}, m = "invokeSuspend", n = {"runningData", "itemId", "runningData", "itemId", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "runningData", "itemId", "localItemModel", "runningData", "itemId", "localItemModel", "localFolderId", BoxCommonConstants.EXTRA_FILE_NAME, "runningData", "itemId", "localItemModel", "localFolderId", BoxCommonConstants.EXTRA_FILE_NAME, ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "runningData", "itemId", "localItemModel", "localFolderId", BoxCommonConstants.EXTRA_FILE_NAME, "folderId", "it", "$i$a$-let-PreflightCheckState$onEnter$2$fileIdToOverwrite$1", "runningData", "itemId", "localItemModel", "localFolderId", BoxCommonConstants.EXTRA_FILE_NAME, "folderId", "it", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "$i$a$-let-PreflightCheckState$onEnter$2$fileIdToOverwrite$1", "runningData", "itemId", "localItemModel", "localFolderId", BoxCommonConstants.EXTRA_FILE_NAME, "folderId", "fileIdToOverwrite", "logMap", "runningData", "itemId", "localItemModel", "localFolderId", BoxCommonConstants.EXTRA_FILE_NAME, "folderId", "fileIdToOverwrite", "logMap", "fileSha1", "fileSize", "runningData", "itemId", "localItemModel", "localFolderId", BoxCommonConstants.EXTRA_FILE_NAME, "folderId", "fileIdToOverwrite", "logMap", "fileSha1", "$this$onSuccess$iv", "it", "runningInfo", "fileSize", "$i$f$onSuccess", "$i$a$-onSuccess-PreflightCheckState$onEnter$2$1", "runningData", "itemId", "localItemModel", "localFolderId", BoxCommonConstants.EXTRA_FILE_NAME, "folderId", "fileIdToOverwrite", "logMap", "fileSha1", "$this$onError$iv", "it", "fileSize", "$i$f$onError", "$i$a$-onError-PreflightCheckState$onEnter$2$2", "runningData", "itemId", "localItemModel", "localFolderId", BoxCommonConstants.EXTRA_FILE_NAME, "folderId", "fileIdToOverwrite", "logMap", "fileSha1", "$this$onError$iv", "it", "$this$onSuccess$iv", "it", "fileSize", "$i$f$onError", "$i$a$-onError-PreflightCheckState$onEnter$2$2", "$i$f$onSuccess", "$i$a$-onSuccess-PreflightCheckState$onEnter$2$2$1", "runningData", "itemId", "localItemModel", "localFolderId", BoxCommonConstants.EXTRA_FILE_NAME, "folderId", "fileIdToOverwrite", "logMap", "fileSha1", "$this$onError$iv", "it", "$this$onError$iv", "it", "fileSize", "$i$f$onError", "$i$a$-onError-PreflightCheckState$onEnter$2$2", "$i$f$onError", "$i$a$-onError-PreflightCheckState$onEnter$2$2$2"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "J$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "J$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "L$12", "L$13", "J$0", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "J$0", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<UploadFileRunningData.PreflightCheckData, Continuation<? super Unit>, Object> {
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
            AnonymousClass2 anonymousClass2 = PreflightCheckState.this.new AnonymousClass2(continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(UploadFileRunningData.PreflightCheckData preflightCheckData, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(preflightCheckData, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:100:0x060c  */
        /* JADX WARN: Code duplicated, block: B:102:0x0610  */
        /* JADX WARN: Code duplicated, block: B:107:0x068c  */
        /* JADX WARN: Code duplicated, block: B:109:0x0692  */
        /* JADX WARN: Code duplicated, block: B:111:0x0698  */
        /* JADX WARN: Code duplicated, block: B:113:0x069e  */
        /* JADX WARN: Code duplicated, block: B:115:0x06a4  */
        /* JADX WARN: Code duplicated, block: B:117:0x06aa  */
        /* JADX WARN: Code duplicated, block: B:122:0x0720  */
        /* JADX WARN: Code duplicated, block: B:124:0x0726  */
        /* JADX WARN: Code duplicated, block: B:129:0x077a  */
        /* JADX WARN: Code duplicated, block: B:131:0x0780  */
        /* JADX WARN: Code duplicated, block: B:136:0x07e3  */
        /* JADX WARN: Code duplicated, block: B:25:0x025b  */
        /* JADX WARN: Code duplicated, block: B:36:0x02a5  */
        /* JADX WARN: Code duplicated, block: B:38:0x02c0  */
        /* JADX WARN: Code duplicated, block: B:41:0x02f6  */
        /* JADX WARN: Code duplicated, block: B:44:0x02fd  */
        /* JADX WARN: Code duplicated, block: B:46:0x0309  */
        /* JADX WARN: Code duplicated, block: B:48:0x030d  */
        /* JADX WARN: Code duplicated, block: B:53:0x038d  */
        /* JADX WARN: Code duplicated, block: B:55:0x0393  */
        /* JADX WARN: Code duplicated, block: B:58:0x03ac  */
        /* JADX WARN: Code duplicated, block: B:62:0x03f2  */
        /* JADX WARN: Code duplicated, block: B:66:0x044a  */
        /* JADX WARN: Code duplicated, block: B:69:0x045a  */
        /* JADX WARN: Code duplicated, block: B:72:0x04d3  */
        /* JADX WARN: Code duplicated, block: B:74:0x04ee  */
        /* JADX WARN: Code duplicated, block: B:76:0x04f5  */
        /* JADX WARN: Code duplicated, block: B:80:0x04fe  */
        /* JADX WARN: Code duplicated, block: B:82:0x0502  */
        /* JADX WARN: Code duplicated, block: B:85:0x0562  */
        /* JADX WARN: Code duplicated, block: B:88:0x057a  */
        /* JADX WARN: Code duplicated, block: B:91:0x05f4  */
        /* JADX WARN: Code duplicated, block: B:94:0x05fd  */
        /* JADX WARN: Code restructure failed: missing block: B:103:0x0685, code lost:
        
            if (r5.jobFailed(r12, com.box.android.domain.jobs.JobType.UPLOAD_FILE_V2, r0, r27) == r7) goto L133;
         */
        /* JADX WARN: Code restructure failed: missing block: B:118:0x0719, code lost:
        
            if (r1.jobFailed(r2, com.box.android.domain.jobs.JobType.UPLOAD_FILE_V2, new com.box.android.domain.models.DomainError.CreateJobError(r5 + " Failed to retrieve parent folder id " + r6), r27) == r7) goto L133;
         */
        /* JADX WARN: Code restructure failed: missing block: B:125:0x0774, code lost:
        
            if (r1.jobFailed(r4, com.box.android.domain.jobs.JobType.UPLOAD_FILE_V2, new com.box.android.domain.models.DomainError.CreateJobError(r6 + " Failed to retrieve parent folder id"), r27) == r7) goto L133;
         */
        /* JADX WARN: Code restructure failed: missing block: B:132:0x07dd, code lost:
        
            if (r1.jobFailed(r4, com.box.android.domain.jobs.JobType.UPLOAD_FILE_V2, new com.box.android.domain.models.DomainError.CreateJobError(r6 + " Failed to retrieve localItem " + r8), r27) == r7) goto L133;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x0386, code lost:
        
            if (r1.jobFailed(r14, com.box.android.domain.jobs.JobType.UPLOAD_FILE_V2, r15, r27) == r7) goto L133;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r28) throws java.io.UnsupportedEncodingException {
            /*
                Method dump skipped, instruction units count: 2058
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.api.models.upload.PreflightCheckState.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // com.box.android.data.api.models.upload.UploadJobState
    public Object onEnter(Continuation<? super Unit> continuation) {
        Object objUpdatingRunningInfo = this.job.updatingRunningInfo(false, new AnonymousClass2(null), continuation);
        return objUpdatingRunningInfo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdatingRunningInfo : Unit.INSTANCE;
    }
}
