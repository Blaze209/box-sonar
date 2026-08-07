package com.box.android.data.api.models.upload;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.data.jobs.JobService;
import com.box.android.data.jobs.UploadFileJobV2;
import com.box.android.data.service.impl.FileMetadataService;
import com.box.android.data.service.impl.LocalItemService;
import com.box.android.data.service.impl.UploadFileService;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.jobs.JobId;
import com.box.android.domain.jobs.JobType;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.services.IUploadFileService;
import com.box.android.domain.services.IdMappingService;
import com.box.android.domain.utils.Progress;
import com.box.android.domain.utils.result.Result;
import com.box.android.domain.utils.result.ResultProgressWrapper;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import com.facebook.imageutils.JfifUtil;
import dagger.Lazy;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedFactory;
import dagger.assisted.AssistedInject;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.NonCancellable;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: UploadFileStates.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001 BI\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u001d\u001a\u00020\u001eH\u0096@¢\u0006\u0002\u0010\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/box/android/data/api/models/upload/UploadWholeFileState;", "Lcom/box/android/data/api/models/upload/UploadJobState;", "jobService", "Lcom/box/android/data/jobs/JobService;", "job", "Lcom/box/android/data/jobs/UploadFileJobV2;", "uploadFileService", "Lcom/box/android/data/service/impl/UploadFileService;", "localItemService", "Lcom/box/android/data/service/impl/LocalItemService;", "idMappingService", "Lcom/box/android/domain/services/IdMappingService;", "fileMetadataService", "Lcom/box/android/data/service/impl/FileMetadataService;", "featureFlips", "Ldagger/Lazy;", "Lcom/box/android/domain/configuration/FeatureFlips;", "<init>", "(Lcom/box/android/data/jobs/JobService;Lcom/box/android/data/jobs/UploadFileJobV2;Lcom/box/android/data/service/impl/UploadFileService;Lcom/box/android/data/service/impl/LocalItemService;Lcom/box/android/domain/services/IdMappingService;Lcom/box/android/data/service/impl/FileMetadataService;Ldagger/Lazy;)V", "getJobService", "()Lcom/box/android/data/jobs/JobService;", "getJob", "()Lcom/box/android/data/jobs/UploadFileJobV2;", "getUploadFileService", "()Lcom/box/android/data/service/impl/UploadFileService;", "getLocalItemService", "()Lcom/box/android/data/service/impl/LocalItemService;", "getIdMappingService", "()Lcom/box/android/domain/services/IdMappingService;", "onEnter", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Factory", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UploadWholeFileState implements UploadJobState {
    private final Lazy<FeatureFlips> featureFlips;
    private final FileMetadataService fileMetadataService;
    private final IdMappingService idMappingService;
    private final UploadFileJobV2 job;
    private final JobService jobService;
    private final LocalItemService localItemService;
    private final UploadFileService uploadFileService;

    /* JADX INFO: compiled from: UploadFileStates.kt */
    @AssistedFactory
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/box/android/data/api/models/upload/UploadWholeFileState$Factory;", "", "createState", "Lcom/box/android/data/api/models/upload/UploadWholeFileState;", "job", "Lcom/box/android/data/jobs/UploadFileJobV2;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface Factory {
        UploadWholeFileState createState(UploadFileJobV2 job);
    }

    /* JADX INFO: renamed from: com.box.android.data.api.models.upload.UploadWholeFileState$onEnter$1, reason: invalid class name */
    /* JADX INFO: compiled from: UploadFileStates.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.api.models.upload.UploadWholeFileState", f = "UploadFileStates.kt", i = {1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 11, 11, 11, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13}, l = {JfifUtil.MARKER_SOI, 220, 226, 235, 242, 243, 249, 259, 263, 275, 279, BoxCommonConstants.REQUEST_CHOOSE_LOCAL_UPLOAD_DIR, 299, 300}, m = "onEnter", n = {"runningData", "localItemId", "runningData", "localItemId", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "runningData", "localItemId", "localItemModel", "runningData", "localItemId", "localItemModel", "localFolderId", "localFileName", "runningData", "localItemId", "localItemModel", "localFolderId", "localFileName", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "runningData", "localItemId", "localItemModel", "localFolderId", "localFileName", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "runningData", "localItemId", "localItemModel", "localFolderId", "localFileName", "contentUri", "runningData", "localItemId", "localItemModel", "localFolderId", "localFileName", "contentUri", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "runningData", "localItemId", "localItemModel", "localFolderId", "localFileName", "contentUri", "folderId", "it", "$i$a$-let-UploadWholeFileState$onEnter$newFileVersionUpload$1", "runningData", "localItemId", "localItemModel", "localFolderId", "localFileName", "contentUri", "folderId", "it", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "$i$a$-let-UploadWholeFileState$onEnter$newFileVersionUpload$1", "runningData", "localItemId", "localItemModel", "localFolderId", "localFileName", "contentUri", "folderId", "newFileVersionUpload", "logMap", "runningData", "localItemId", "localItemModel", "localFolderId", "localFileName", "contentUri", "folderId", "newFileVersionUpload", "logMap", "file", "runningData", "localItemId", "localItemModel", "localFolderId", "localFileName", "contentUri", "folderId", "newFileVersionUpload", "logMap", "file", "progressWrapper"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UploadWholeFileState.this.onEnter(this);
        }
    }

    @AssistedInject
    public UploadWholeFileState(JobService jobService, @Assisted UploadFileJobV2 job, UploadFileService uploadFileService, LocalItemService localItemService, IdMappingService idMappingService, FileMetadataService fileMetadataService, Lazy<FeatureFlips> featureFlips) {
        Intrinsics.checkNotNullParameter(jobService, "jobService");
        Intrinsics.checkNotNullParameter(job, "job");
        Intrinsics.checkNotNullParameter(uploadFileService, "uploadFileService");
        Intrinsics.checkNotNullParameter(localItemService, "localItemService");
        Intrinsics.checkNotNullParameter(idMappingService, "idMappingService");
        Intrinsics.checkNotNullParameter(fileMetadataService, "fileMetadataService");
        Intrinsics.checkNotNullParameter(featureFlips, "featureFlips");
        this.jobService = jobService;
        this.job = job;
        this.uploadFileService = uploadFileService;
        this.localItemService = localItemService;
        this.idMappingService = idMappingService;
        this.fileMetadataService = fileMetadataService;
        this.featureFlips = featureFlips;
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

    public final IdMappingService getIdMappingService() {
        return this.idMappingService;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x050b  */
    /* JADX WARN: Code duplicated, block: B:105:0x057b  */
    /* JADX WARN: Code duplicated, block: B:107:0x0581  */
    /* JADX WARN: Code duplicated, block: B:109:0x0585  */
    /* JADX WARN: Code duplicated, block: B:114:0x05ee  */
    /* JADX WARN: Code duplicated, block: B:116:0x05f4  */
    /* JADX WARN: Code duplicated, block: B:121:0x0639  */
    /* JADX WARN: Code duplicated, block: B:123:0x063d  */
    /* JADX WARN: Code duplicated, block: B:128:0x0693  */
    /* JADX WARN: Code duplicated, block: B:34:0x021d  */
    /* JADX WARN: Code duplicated, block: B:37:0x0226  */
    /* JADX WARN: Code duplicated, block: B:39:0x0235  */
    /* JADX WARN: Code duplicated, block: B:47:0x0266  */
    /* JADX WARN: Code duplicated, block: B:49:0x0271  */
    /* JADX WARN: Code duplicated, block: B:54:0x02c9  */
    /* JADX WARN: Code duplicated, block: B:57:0x02ef  */
    /* JADX WARN: Code duplicated, block: B:60:0x02fa  */
    /* JADX WARN: Code duplicated, block: B:62:0x0311  */
    /* JADX WARN: Code duplicated, block: B:65:0x0348  */
    /* JADX WARN: Code duplicated, block: B:68:0x034f  */
    /* JADX WARN: Code duplicated, block: B:70:0x0363  */
    /* JADX WARN: Code duplicated, block: B:72:0x0367  */
    /* JADX WARN: Code duplicated, block: B:77:0x03ec  */
    /* JADX WARN: Code duplicated, block: B:79:0x03f2  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:82:0x040d  */
    /* JADX WARN: Code duplicated, block: B:88:0x0452  */
    /* JADX WARN: Code duplicated, block: B:92:0x049e  */
    /* JADX WARN: Code duplicated, block: B:98:0x0507  */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0574, code lost:
    
        if (r1.jobFailed(r4, com.box.android.domain.jobs.JobType.UPLOAD_FILE_V2, r5, r8) == r9) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x05e7, code lost:
    
        if (r4.jobFailed(r5, com.box.android.domain.jobs.JobType.UPLOAD_FILE_V2, r12, r8) == r9) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0633, code lost:
    
        if (r0.jobFailed(r1, com.box.android.domain.jobs.JobType.UPLOAD_FILE_V2, r3, r8) == r9) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x068d, code lost:
    
        if (r1.jobFailed(r3, com.box.android.domain.jobs.JobType.UPLOAD_FILE_V2, r4, r8) == r9) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x02c2, code lost:
    
        if (r4.jobFailed(r5, com.box.android.domain.jobs.JobType.UPLOAD_FILE_V2, r12, r8) == r9) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x03e5, code lost:
    
        if (r4.jobFailed(r5, com.box.android.domain.jobs.JobType.UPLOAD_FILE_V2, r0, r8) == r9) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0500, code lost:
    
        if (kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r0, r8) == r9) goto L125;
     */
    @Override // com.box.android.data.api.models.upload.UploadJobState
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object onEnter(kotlin.coroutines.Continuation<? super kotlin.Unit> r20) throws java.io.UnsupportedEncodingException {
        /*
            Method dump skipped, instruction units count: 1724
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.api.models.upload.UploadWholeFileState.onEnter(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.box.android.data.api.models.upload.UploadWholeFileState$onEnter$2, reason: invalid class name */
    /* JADX INFO: compiled from: UploadFileStates.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/item/FileModel;", "Lcom/box/android/domain/models/DomainError;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.api.models.upload.UploadWholeFileState$onEnter$2", f = "UploadFileStates.kt", i = {0, 0, 1, 1, 1}, l = {311, 312}, m = "invokeSuspend", n = {"$this$coroutineScope", "progressFlowJob", "$this$coroutineScope", "progressFlowJob", ReactNativeFeatureActivity.RESULT_EXTRA_KEY}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends FileModel, ? extends DomainError>>, Object> {
        final /* synthetic */ String $contentUri;
        final /* synthetic */ ItemId $localItemId;
        final /* synthetic */ IUploadFileService.NewFileVersionUpload $newFileVersionUpload;
        final /* synthetic */ ResultProgressWrapper<FileModel, DomainError, Progress> $progressWrapper;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ UploadWholeFileState this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ResultProgressWrapper<FileModel, DomainError, Progress> resultProgressWrapper, UploadWholeFileState uploadWholeFileState, ItemId itemId, String str, IUploadFileService.NewFileVersionUpload newFileVersionUpload, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$progressWrapper = resultProgressWrapper;
            this.this$0 = uploadWholeFileState;
            this.$localItemId = itemId;
            this.$contentUri = str;
            this.$newFileVersionUpload = newFileVersionUpload;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$progressWrapper, this.this$0, this.$localItemId, this.$contentUri, this.$newFileVersionUpload, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends FileModel, ? extends DomainError>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Result<FileModel, ? extends DomainError>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<FileModel, ? extends DomainError>> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Job jobLaunch$default;
            Object objFirst;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new UploadWholeFileState$onEnter$2$progressFlowJob$1(this.$progressWrapper, this.this$0, null), 3, null);
                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.L$1 = jobLaunch$default;
                this.label = 1;
                objFirst = FlowKt.first(this.$progressWrapper.getResult(), this);
                if (objFirst != coroutine_suspended) {
                }
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            jobLaunch$default = (Job) this.L$1;
            ResultKt.throwOnFailure(obj);
            objFirst = obj;
            Job job = jobLaunch$default;
            Intrinsics.checkNotNull(objFirst);
            Result result = (Result) objFirst;
            this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
            this.L$1 = SpillingKt.nullOutSpilledVariable(job);
            this.L$2 = SpillingKt.nullOutSpilledVariable(result);
            this.label = 2;
            Object objWithContext = BuildersKt.withContext(NonCancellable.INSTANCE, new AnonymousClass1(result, job, this.this$0, this.$localItemId, this.$contentUri, this.$newFileVersionUpload, null), this);
            return objWithContext == coroutine_suspended ? coroutine_suspended : objWithContext;
        }

        /* JADX INFO: renamed from: com.box.android.data.api.models.upload.UploadWholeFileState$onEnter$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: UploadFileStates.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/item/FileModel;", "Lcom/box/android/domain/models/DomainError;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.data.api.models.upload.UploadWholeFileState$onEnter$2$1", f = "UploadFileStates.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3}, l = {TypedValues.AttributesType.TYPE_PIVOT_TARGET, 328, 329, 332}, m = "invokeSuspend", n = {"$this$withContext", "$this$onSuccess$iv", "it", "$this$invokeSuspend_u24lambda_u240_u240", "fileId", "$i$f$onSuccess", "$i$a$-onSuccess-UploadWholeFileState$onEnter$2$1$1", "$i$a$-runCatching-UploadWholeFileState$onEnter$2$1$1$1", "$i$a$-let-UploadWholeFileState$onEnter$2$1$1$1$1", "$this$withContext", "$this$onSuccess$iv", "it", "$i$f$onSuccess", "$i$a$-onSuccess-UploadWholeFileState$onEnter$2$1$1", "$this$withContext", "$this$onSuccess$iv", "it", "$i$f$onSuccess", "$i$a$-onSuccess-UploadWholeFileState$onEnter$2$1$1", "$this$withContext", "$this$onError$iv", "it", "$i$f$onError", "$i$a$-onError-UploadWholeFileState$onEnter$2$1$2"}, s = {"L$0", "L$1", "L$4", "L$5", "L$6", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$4", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends FileModel, ? extends DomainError>>, Object> {
            final /* synthetic */ String $contentUri;
            final /* synthetic */ ItemId $localItemId;
            final /* synthetic */ IUploadFileService.NewFileVersionUpload $newFileVersionUpload;
            final /* synthetic */ Job $progressFlowJob;
            final /* synthetic */ Result<FileModel, DomainError> $result;
            int I$0;
            int I$1;
            int I$2;
            int I$3;
            private /* synthetic */ Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            Object L$6;
            int label;
            final /* synthetic */ UploadWholeFileState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(Result<FileModel, ? extends DomainError> result, Job job, UploadWholeFileState uploadWholeFileState, ItemId itemId, String str, IUploadFileService.NewFileVersionUpload newFileVersionUpload, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$result = result;
                this.$progressFlowJob = job;
                this.this$0 = uploadWholeFileState;
                this.$localItemId = itemId;
                this.$contentUri = str;
                this.$newFileVersionUpload = newFileVersionUpload;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$result, this.$progressFlowJob, this.this$0, this.$localItemId, this.$contentUri, this.$newFileVersionUpload, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends FileModel, ? extends DomainError>> continuation) {
                return invoke2(coroutineScope, (Continuation<? super Result<FileModel, ? extends DomainError>>) continuation);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<FileModel, ? extends DomainError>> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code duplicated, block: B:56:0x018d  */
            /* JADX WARN: Code duplicated, block: B:63:0x01c0 A[PHI: r0
              0x01c0: PHI (r0v33 com.box.android.domain.utils.result.Result<com.box.android.domain.models.item.FileModel, com.box.android.domain.models.DomainError>) = 
              (r0v5 com.box.android.domain.utils.result.Result<com.box.android.domain.models.item.FileModel, com.box.android.domain.models.DomainError>)
              (r0v32 com.box.android.domain.utils.result.Result<com.box.android.domain.models.item.FileModel, com.box.android.domain.models.DomainError>)
              (r0v48 com.box.android.domain.utils.result.Result<com.box.android.domain.models.item.FileModel, com.box.android.domain.models.DomainError>)
             binds: [B:62:0x01bf, B:58:0x01b8, B:11:0x0032] A[DONT_GENERATE, DONT_INLINE]] */
            /* JADX WARN: Code duplicated, block: B:66:0x01c9  */
            /* JADX WARN: Code duplicated, block: B:68:0x01cd  */
            /* JADX WARN: Code duplicated, block: B:72:0x0204  */
            /* JADX WARN: Code duplicated, block: B:84:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:85:? A[RETURN, SYNTHETIC] */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Result<FileModel, DomainError> result;
                Result<FileModel, DomainError> result2;
                UploadWholeFileState uploadWholeFileState;
                ItemId itemId;
                FileModel fileModel;
                UploadWholeFileState uploadWholeFileState2;
                ItemId itemId2;
                int i;
                int i2;
                FileModel fileModel2;
                ItemId.Remote remote;
                Unit unit;
                UploadWholeFileState uploadWholeFileState3;
                ItemId itemId3;
                int i3;
                int i4;
                FileModel fileModel3;
                JobService jobService;
                JobId jobId;
                UploadWholeFileState uploadWholeFileState4;
                ItemId itemId4;
                FileModel fileModel4;
                int i5;
                int i6;
                LocalItemService localItemService;
                ItemId itemId5;
                Job job;
                UploadWholeFileState uploadWholeFileState5;
                DomainError domainError;
                JobService jobService2;
                JobId jobId2;
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i7 = this.label;
                if (i7 == 0) {
                    ResultKt.throwOnFailure(obj);
                    result = this.$result;
                    Job job2 = this.$progressFlowJob;
                    UploadWholeFileState uploadWholeFileState6 = this.this$0;
                    ItemId itemId6 = this.$localItemId;
                    String str = this.$contentUri;
                    IUploadFileService.NewFileVersionUpload newFileVersionUpload = this.$newFileVersionUpload;
                    if (result instanceof Result.Success) {
                        FileModel fileModel5 = (FileModel) ((Result.Success) result).getValue();
                        Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
                        if (((FeatureFlips) uploadWholeFileState6.featureFlips.get()).getUploadFileMetadataExtraction().getEnabled()) {
                            try {
                                kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
                                ItemId itemId7 = fileModel5.getItemId();
                                if (itemId7 instanceof ItemId.Remote) {
                                    try {
                                        remote = (ItemId.Remote) itemId7;
                                    } catch (Throwable th) {
                                        th = th;
                                        itemId2 = itemId6;
                                        fileModel2 = fileModel5;
                                        i2 = 0;
                                        uploadWholeFileState2 = uploadWholeFileState6;
                                        i = 0;
                                        kotlin.Result.Companion companion2 = kotlin.Result.INSTANCE;
                                        kotlin.Result.m14780constructorimpl(ResultKt.createFailure(th));
                                    }
                                } else {
                                    remote = null;
                                }
                                if (remote != null) {
                                    ItemId.Remote remote2 = remote;
                                    FileMetadataService fileMetadataService = uploadWholeFileState6.fileMetadataService;
                                    Context appContext = uploadWholeFileState6.getJob().getAppContext();
                                    String name = fileModel5.getName();
                                    boolean z = newFileVersionUpload != null;
                                    this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                                    this.L$1 = result;
                                    this.L$2 = uploadWholeFileState6;
                                    this.L$3 = itemId6;
                                    this.L$4 = fileModel5;
                                    this.L$5 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                                    this.L$6 = SpillingKt.nullOutSpilledVariable(remote2);
                                    this.I$0 = 0;
                                    this.I$1 = 0;
                                    this.I$2 = 0;
                                    this.I$3 = 0;
                                    this.label = 1;
                                    boolean z2 = z;
                                    uploadWholeFileState = uploadWholeFileState6;
                                    fileModel = fileModel5;
                                    itemId = itemId6;
                                    try {
                                        if (fileMetadataService.extractAndUploadFileProperties(appContext, str, name, remote2, z2, this) != coroutine_suspended) {
                                            uploadWholeFileState2 = uploadWholeFileState;
                                            itemId2 = itemId;
                                            i = 0;
                                            i2 = 0;
                                            fileModel2 = fileModel;
                                            unit = Unit.INSTANCE;
                                            kotlin.Result.m14780constructorimpl(unit);
                                            i3 = i;
                                            i4 = i2;
                                            fileModel3 = fileModel2;
                                            itemId3 = itemId2;
                                            uploadWholeFileState3 = uploadWholeFileState2;
                                            jobService = uploadWholeFileState3.getJobService();
                                            jobId = uploadWholeFileState3.getJob().getJobId();
                                            this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                                            this.L$1 = result;
                                            this.L$2 = uploadWholeFileState3;
                                            this.L$3 = itemId3;
                                            this.L$4 = fileModel3;
                                            this.L$5 = null;
                                            this.L$6 = null;
                                            this.I$0 = i4;
                                            this.I$1 = i3;
                                            this.label = 2;
                                            if (jobService.jobSucceeded(jobId, this) != coroutine_suspended) {
                                                uploadWholeFileState4 = uploadWholeFileState3;
                                                itemId4 = itemId3;
                                                fileModel4 = fileModel3;
                                                i5 = i4;
                                                i6 = i3;
                                                result2 = result;
                                                localItemService = uploadWholeFileState4.getLocalItemService();
                                                itemId5 = fileModel4.getItemId();
                                                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                                                this.L$1 = result2;
                                                this.L$2 = SpillingKt.nullOutSpilledVariable(fileModel4);
                                                this.L$3 = null;
                                                this.L$4 = null;
                                                this.I$0 = i5;
                                                this.I$1 = i6;
                                                this.label = 3;
                                                if (localItemService.setServerId(itemId4, itemId5, this) != coroutine_suspended) {
                                                    job = this.$progressFlowJob;
                                                    uploadWholeFileState5 = this.this$0;
                                                    if (result2 instanceof Result.Success) {
                                                        return result2;
                                                    }
                                                    if (!(result2 instanceof Result.Error)) {
                                                        throw new NoWhenBranchMatchedException();
                                                    }
                                                    domainError = (DomainError) ((Result.Error) result2).getValue();
                                                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                                                    jobService2 = uploadWholeFileState5.getJobService();
                                                    jobId2 = uploadWholeFileState5.getJob().getJobId();
                                                    this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                                                    this.L$1 = result2;
                                                    this.L$2 = SpillingKt.nullOutSpilledVariable(domainError);
                                                    this.I$0 = 0;
                                                    this.I$1 = 0;
                                                    this.label = 4;
                                                    if (jobService2.jobFailed(jobId2, JobType.UPLOAD_FILE_V2, domainError, this) != coroutine_suspended) {
                                                        return result2;
                                                    }
                                                }
                                            }
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        uploadWholeFileState2 = uploadWholeFileState;
                                        itemId2 = itemId;
                                        i = 0;
                                        i2 = 0;
                                        fileModel2 = fileModel;
                                        kotlin.Result.Companion companion3 = kotlin.Result.INSTANCE;
                                        kotlin.Result.m14780constructorimpl(ResultKt.createFailure(th));
                                    }
                                } else {
                                    uploadWholeFileState2 = uploadWholeFileState6;
                                    itemId2 = itemId6;
                                    i = 0;
                                    i2 = 0;
                                    unit = null;
                                    fileModel2 = fileModel5;
                                    kotlin.Result.m14780constructorimpl(unit);
                                    i3 = i;
                                    i4 = i2;
                                    fileModel3 = fileModel2;
                                    itemId3 = itemId2;
                                    uploadWholeFileState3 = uploadWholeFileState2;
                                    jobService = uploadWholeFileState3.getJobService();
                                    jobId = uploadWholeFileState3.getJob().getJobId();
                                    this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                                    this.L$1 = result;
                                    this.L$2 = uploadWholeFileState3;
                                    this.L$3 = itemId3;
                                    this.L$4 = fileModel3;
                                    this.L$5 = null;
                                    this.L$6 = null;
                                    this.I$0 = i4;
                                    this.I$1 = i3;
                                    this.label = 2;
                                    if (jobService.jobSucceeded(jobId, this) != coroutine_suspended) {
                                        uploadWholeFileState4 = uploadWholeFileState3;
                                        itemId4 = itemId3;
                                        fileModel4 = fileModel3;
                                        i5 = i4;
                                        i6 = i3;
                                        result2 = result;
                                        localItemService = uploadWholeFileState4.getLocalItemService();
                                        itemId5 = fileModel4.getItemId();
                                        this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                                        this.L$1 = result2;
                                        this.L$2 = SpillingKt.nullOutSpilledVariable(fileModel4);
                                        this.L$3 = null;
                                        this.L$4 = null;
                                        this.I$0 = i5;
                                        this.I$1 = i6;
                                        this.label = 3;
                                        if (localItemService.setServerId(itemId4, itemId5, this) != coroutine_suspended) {
                                            job = this.$progressFlowJob;
                                            uploadWholeFileState5 = this.this$0;
                                            if (result2 instanceof Result.Success) {
                                                return result2;
                                            }
                                            if (!(result2 instanceof Result.Error)) {
                                                throw new NoWhenBranchMatchedException();
                                            }
                                            domainError = (DomainError) ((Result.Error) result2).getValue();
                                            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                                            jobService2 = uploadWholeFileState5.getJobService();
                                            jobId2 = uploadWholeFileState5.getJob().getJobId();
                                            this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                                            this.L$1 = result2;
                                            this.L$2 = SpillingKt.nullOutSpilledVariable(domainError);
                                            this.I$0 = 0;
                                            this.I$1 = 0;
                                            this.label = 4;
                                            if (jobService2.jobFailed(jobId2, JobType.UPLOAD_FILE_V2, domainError, this) != coroutine_suspended) {
                                                return result2;
                                            }
                                        }
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                uploadWholeFileState = uploadWholeFileState6;
                                itemId = itemId6;
                                fileModel = fileModel5;
                            }
                        } else {
                            uploadWholeFileState3 = uploadWholeFileState6;
                            itemId3 = itemId6;
                            i3 = 0;
                            i4 = 0;
                            fileModel3 = fileModel5;
                            jobService = uploadWholeFileState3.getJobService();
                            jobId = uploadWholeFileState3.getJob().getJobId();
                            this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                            this.L$1 = result;
                            this.L$2 = uploadWholeFileState3;
                            this.L$3 = itemId3;
                            this.L$4 = fileModel3;
                            this.L$5 = null;
                            this.L$6 = null;
                            this.I$0 = i4;
                            this.I$1 = i3;
                            this.label = 2;
                            if (jobService.jobSucceeded(jobId, this) != coroutine_suspended) {
                                uploadWholeFileState4 = uploadWholeFileState3;
                                itemId4 = itemId3;
                                fileModel4 = fileModel3;
                                i5 = i4;
                                i6 = i3;
                                result2 = result;
                                localItemService = uploadWholeFileState4.getLocalItemService();
                                itemId5 = fileModel4.getItemId();
                                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                                this.L$1 = result2;
                                this.L$2 = SpillingKt.nullOutSpilledVariable(fileModel4);
                                this.L$3 = null;
                                this.L$4 = null;
                                this.I$0 = i5;
                                this.I$1 = i6;
                                this.label = 3;
                                if (localItemService.setServerId(itemId4, itemId5, this) != coroutine_suspended) {
                                    job = this.$progressFlowJob;
                                    uploadWholeFileState5 = this.this$0;
                                    if (result2 instanceof Result.Success) {
                                        return result2;
                                    }
                                    if (!(result2 instanceof Result.Error)) {
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    domainError = (DomainError) ((Result.Error) result2).getValue();
                                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                                    jobService2 = uploadWholeFileState5.getJobService();
                                    jobId2 = uploadWholeFileState5.getJob().getJobId();
                                    this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                                    this.L$1 = result2;
                                    this.L$2 = SpillingKt.nullOutSpilledVariable(domainError);
                                    this.I$0 = 0;
                                    this.I$1 = 0;
                                    this.label = 4;
                                    if (jobService2.jobFailed(jobId2, JobType.UPLOAD_FILE_V2, domainError, this) != coroutine_suspended) {
                                        return result2;
                                    }
                                }
                            }
                        }
                    } else if (result instanceof Result.Error) {
                        result2 = result;
                        job = this.$progressFlowJob;
                        uploadWholeFileState5 = this.this$0;
                        if (result2 instanceof Result.Success) {
                            return result2;
                        }
                        if (!(result2 instanceof Result.Error)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        domainError = (DomainError) ((Result.Error) result2).getValue();
                        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                        jobService2 = uploadWholeFileState5.getJobService();
                        jobId2 = uploadWholeFileState5.getJob().getJobId();
                        this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                        this.L$1 = result2;
                        this.L$2 = SpillingKt.nullOutSpilledVariable(domainError);
                        this.I$0 = 0;
                        this.I$1 = 0;
                        this.label = 4;
                        if (jobService2.jobFailed(jobId2, JobType.UPLOAD_FILE_V2, domainError, this) != coroutine_suspended) {
                            return result2;
                        }
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    if (i7 == 1) {
                        i = this.I$1;
                        i2 = this.I$0;
                        fileModel2 = (FileModel) this.L$4;
                        itemId2 = (ItemId) this.L$3;
                        uploadWholeFileState2 = (UploadWholeFileState) this.L$2;
                        result = (Result) this.L$1;
                        try {
                            ResultKt.throwOnFailure(obj);
                            unit = Unit.INSTANCE;
                            kotlin.Result.m14780constructorimpl(unit);
                        } catch (Throwable th4) {
                            th = th4;
                            kotlin.Result.Companion companion4 = kotlin.Result.INSTANCE;
                            kotlin.Result.m14780constructorimpl(ResultKt.createFailure(th));
                        }
                        i3 = i;
                        i4 = i2;
                        fileModel3 = fileModel2;
                        itemId3 = itemId2;
                        uploadWholeFileState3 = uploadWholeFileState2;
                        jobService = uploadWholeFileState3.getJobService();
                        jobId = uploadWholeFileState3.getJob().getJobId();
                        this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                        this.L$1 = result;
                        this.L$2 = uploadWholeFileState3;
                        this.L$3 = itemId3;
                        this.L$4 = fileModel3;
                        this.L$5 = null;
                        this.L$6 = null;
                        this.I$0 = i4;
                        this.I$1 = i3;
                        this.label = 2;
                        if (jobService.jobSucceeded(jobId, this) != coroutine_suspended) {
                            uploadWholeFileState4 = uploadWholeFileState3;
                            itemId4 = itemId3;
                            fileModel4 = fileModel3;
                            i5 = i4;
                            i6 = i3;
                            result2 = result;
                            localItemService = uploadWholeFileState4.getLocalItemService();
                            itemId5 = fileModel4.getItemId();
                            this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                            this.L$1 = result2;
                            this.L$2 = SpillingKt.nullOutSpilledVariable(fileModel4);
                            this.L$3 = null;
                            this.L$4 = null;
                            this.I$0 = i5;
                            this.I$1 = i6;
                            this.label = 3;
                            if (localItemService.setServerId(itemId4, itemId5, this) != coroutine_suspended) {
                            }
                        }
                    } else if (i7 == 2) {
                        int i8 = this.I$1;
                        int i9 = this.I$0;
                        FileModel fileModel6 = (FileModel) this.L$4;
                        ItemId itemId8 = (ItemId) this.L$3;
                        UploadWholeFileState uploadWholeFileState7 = (UploadWholeFileState) this.L$2;
                        Result<FileModel, DomainError> result3 = (Result) this.L$1;
                        ResultKt.throwOnFailure(obj);
                        i6 = i8;
                        result2 = result3;
                        uploadWholeFileState4 = uploadWholeFileState7;
                        itemId4 = itemId8;
                        fileModel4 = fileModel6;
                        i5 = i9;
                        localItemService = uploadWholeFileState4.getLocalItemService();
                        itemId5 = fileModel4.getItemId();
                        this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                        this.L$1 = result2;
                        this.L$2 = SpillingKt.nullOutSpilledVariable(fileModel4);
                        this.L$3 = null;
                        this.L$4 = null;
                        this.I$0 = i5;
                        this.I$1 = i6;
                        this.label = 3;
                        if (localItemService.setServerId(itemId4, itemId5, this) != coroutine_suspended) {
                        }
                    } else {
                        if (i7 != 3) {
                            if (i7 != 4) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            Result result4 = (Result) this.L$1;
                            ResultKt.throwOnFailure(obj);
                            return result4;
                        }
                        result2 = (Result) this.L$1;
                        ResultKt.throwOnFailure(obj);
                    }
                    job = this.$progressFlowJob;
                    uploadWholeFileState5 = this.this$0;
                    if (result2 instanceof Result.Success) {
                        return result2;
                    }
                    if (!(result2 instanceof Result.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    domainError = (DomainError) ((Result.Error) result2).getValue();
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                    jobService2 = uploadWholeFileState5.getJobService();
                    jobId2 = uploadWholeFileState5.getJob().getJobId();
                    this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.L$1 = result2;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(domainError);
                    this.I$0 = 0;
                    this.I$1 = 0;
                    this.label = 4;
                    if (jobService2.jobFailed(jobId2, JobType.UPLOAD_FILE_V2, domainError, this) != coroutine_suspended) {
                        return result2;
                    }
                }
                return coroutine_suspended;
            }
        }
    }
}
