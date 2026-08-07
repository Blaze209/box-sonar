package com.box.android.data.api.models.upload;

import androidx.compose.material3.ProgressIndicatorKt;
import com.box.android.data.jobs.JobService;
import com.box.android.data.jobs.UploadFileJobV2;
import com.box.android.data.service.impl.CommonServiceUtils;
import com.box.android.data.service.impl.FileMetadataService;
import com.box.android.data.service.impl.LocalItemService;
import com.box.android.data.service.impl.UploadFileService;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.jobs.JobId;
import com.box.android.domain.models.DomainError;
import dagger.Lazy;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedFactory;
import dagger.assisted.AssistedInject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UploadFileStates.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001 BI\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u001d\u001a\u00020\u001eH\u0096@¢\u0006\u0002\u0010\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/box/android/data/api/models/upload/CommitSessionState;", "Lcom/box/android/data/api/models/upload/UploadJobState;", "jobService", "Lcom/box/android/data/jobs/JobService;", "job", "Lcom/box/android/data/jobs/UploadFileJobV2;", "uploadFileService", "Lcom/box/android/data/service/impl/UploadFileService;", "localItemService", "Lcom/box/android/data/service/impl/LocalItemService;", "commonServiceUtils", "Lcom/box/android/data/service/impl/CommonServiceUtils;", "fileMetadataService", "Lcom/box/android/data/service/impl/FileMetadataService;", "featureFlips", "Ldagger/Lazy;", "Lcom/box/android/domain/configuration/FeatureFlips;", "<init>", "(Lcom/box/android/data/jobs/JobService;Lcom/box/android/data/jobs/UploadFileJobV2;Lcom/box/android/data/service/impl/UploadFileService;Lcom/box/android/data/service/impl/LocalItemService;Lcom/box/android/data/service/impl/CommonServiceUtils;Lcom/box/android/data/service/impl/FileMetadataService;Ldagger/Lazy;)V", "getJobService", "()Lcom/box/android/data/jobs/JobService;", "getJob", "()Lcom/box/android/data/jobs/UploadFileJobV2;", "getUploadFileService", "()Lcom/box/android/data/service/impl/UploadFileService;", "getLocalItemService", "()Lcom/box/android/data/service/impl/LocalItemService;", "getCommonServiceUtils", "()Lcom/box/android/data/service/impl/CommonServiceUtils;", "onEnter", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Factory", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CommitSessionState implements UploadJobState {
    private final CommonServiceUtils commonServiceUtils;
    private final Lazy<FeatureFlips> featureFlips;
    private final FileMetadataService fileMetadataService;
    private final UploadFileJobV2 job;
    private final JobService jobService;
    private final LocalItemService localItemService;
    private final UploadFileService uploadFileService;

    /* JADX INFO: compiled from: UploadFileStates.kt */
    @AssistedFactory
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/box/android/data/api/models/upload/CommitSessionState$Factory;", "", "createState", "Lcom/box/android/data/api/models/upload/CommitSessionState;", "job", "Lcom/box/android/data/jobs/UploadFileJobV2;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface Factory {
        CommitSessionState createState(UploadFileJobV2 job);
    }

    /* JADX INFO: renamed from: com.box.android.data.api.models.upload.CommitSessionState$onEnter$1, reason: invalid class name */
    /* JADX INFO: compiled from: UploadFileStates.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.api.models.upload.CommitSessionState", f = "UploadFileStates.kt", i = {2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, l = {634, 635, 639, ProgressIndicatorKt.SecondLineHeadDelay, 651, 661, 662, 664, 665, 666}, m = "onEnter", n = {"runningData", "commitSessionEndpoint", "digestHeader", "partsToUpload", "runningData", "commitSessionEndpoint", "digestHeader", "partsToUpload", "$this$onSuccess$iv", "it", "itemId", "item", "remoteId", "$this$onEnter_u24lambda_u241_u240", "$i$f$onSuccess", "$i$a$-onSuccess-CommitSessionState$onEnter$2", "$i$a$-runCatching-CommitSessionState$onEnter$2$1", "isNewVersion", "runningData", "commitSessionEndpoint", "digestHeader", "partsToUpload", "$this$onSuccess$iv", "it", "itemId", "item", "remoteId", "$this$onEnter_u24lambda_u241_u240", "contentUrl", "$i$f$onSuccess", "$i$a$-onSuccess-CommitSessionState$onEnter$2", "$i$a$-runCatching-CommitSessionState$onEnter$2$1", "isNewVersion", "$i$a$-let-CommitSessionState$onEnter$2$1$1", "runningData", "commitSessionEndpoint", "digestHeader", "partsToUpload", "$this$onSuccess$iv", "it", "itemId", "item", "remoteId", "$i$f$onSuccess", "$i$a$-onSuccess-CommitSessionState$onEnter$2", "runningData", "commitSessionEndpoint", "digestHeader", "partsToUpload", "$this$onSuccess$iv", "it", "itemId", "item", "remoteId", "$i$f$onSuccess", "$i$a$-onSuccess-CommitSessionState$onEnter$2", "runningData", "commitSessionEndpoint", "digestHeader", "partsToUpload", "$this$onError$iv", "it", "$i$f$onError", "$i$a$-onError-CommitSessionState$onEnter$3", "runningData", "commitSessionEndpoint", "digestHeader", "partsToUpload", "$this$onError$iv", "it", "$this$onSuccess$iv", "it", "$i$f$onError", "$i$a$-onError-CommitSessionState$onEnter$3", "$i$f$onSuccess", "$i$a$-onSuccess-CommitSessionState$onEnter$3$1", "runningData", "commitSessionEndpoint", "digestHeader", "partsToUpload", "$this$onError$iv", "it", "$this$onError$iv", "it", "$i$f$onError", "$i$a$-onError-CommitSessionState$onEnter$3", "$i$f$onError", "$i$a$-onError-CommitSessionState$onEnter$3$2"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "I$0", "I$1", "I$2", "I$3", "I$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
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
            return CommitSessionState.this.onEnter(this);
        }
    }

    @AssistedInject
    public CommitSessionState(JobService jobService, @Assisted UploadFileJobV2 job, UploadFileService uploadFileService, LocalItemService localItemService, CommonServiceUtils commonServiceUtils, FileMetadataService fileMetadataService, Lazy<FeatureFlips> featureFlips) {
        Intrinsics.checkNotNullParameter(jobService, "jobService");
        Intrinsics.checkNotNullParameter(job, "job");
        Intrinsics.checkNotNullParameter(uploadFileService, "uploadFileService");
        Intrinsics.checkNotNullParameter(localItemService, "localItemService");
        Intrinsics.checkNotNullParameter(commonServiceUtils, "commonServiceUtils");
        Intrinsics.checkNotNullParameter(fileMetadataService, "fileMetadataService");
        Intrinsics.checkNotNullParameter(featureFlips, "featureFlips");
        this.jobService = jobService;
        this.job = job;
        this.uploadFileService = uploadFileService;
        this.localItemService = localItemService;
        this.commonServiceUtils = commonServiceUtils;
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

    public final CommonServiceUtils getCommonServiceUtils() {
        return this.commonServiceUtils;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x04af  */
    /* JADX WARN: Code duplicated, block: B:104:0x04bf  */
    /* JADX WARN: Code duplicated, block: B:107:0x050c  */
    /* JADX WARN: Code duplicated, block: B:111:0x0514  */
    /* JADX WARN: Code duplicated, block: B:113:0x0518  */
    /* JADX WARN: Code duplicated, block: B:116:0x0567  */
    /* JADX WARN: Code duplicated, block: B:118:0x056d  */
    /* JADX WARN: Code duplicated, block: B:120:0x0573  */
    /* JADX WARN: Code duplicated, block: B:124:0x057c  */
    /* JADX WARN: Code duplicated, block: B:128:0x0291 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x01fb A[PHI: r0 r4
      0x01fb: PHI (r0v6 java.lang.Object) = (r0v5 java.lang.Object), (r0v1 java.lang.Object) binds: [B:34:0x01f7, B:28:0x01c7] A[DONT_GENERATE, DONT_INLINE]
      0x01fb: PHI (r4v3 int) = (r4v1 int), (r4v4 int) binds: [B:34:0x01f7, B:28:0x01c7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:39:0x0248  */
    /* JADX WARN: Code duplicated, block: B:42:0x0254  */
    /* JADX WARN: Code duplicated, block: B:46:0x02a4  */
    /* JADX WARN: Code duplicated, block: B:47:0x02a6  */
    /* JADX WARN: Code duplicated, block: B:51:0x02e1  */
    /* JADX WARN: Code duplicated, block: B:54:0x02fb A[Catch: all -> 0x03a3, TRY_LEAVE, TryCatch #0 {all -> 0x03a3, blocks: (B:52:0x02f1, B:54:0x02fb, B:64:0x0326), top: B:126:0x02f1 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x030b  */
    /* JADX WARN: Code duplicated, block: B:62:0x0323  */
    /* JADX WARN: Code duplicated, block: B:63:0x0325  */
    /* JADX WARN: Code duplicated, block: B:69:0x0379  */
    /* JADX WARN: Code duplicated, block: B:73:0x038d  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:82:0x03c3  */
    /* JADX WARN: Code duplicated, block: B:86:0x0409  */
    /* JADX WARN: Code duplicated, block: B:90:0x0453  */
    /* JADX WARN: Code duplicated, block: B:92:0x045c  */
    /* JADX WARN: Code duplicated, block: B:96:0x0464  */
    /* JADX WARN: Code duplicated, block: B:98:0x0468  */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0564, code lost:
    
        if (r11.jobFailed(r1, com.box.android.domain.jobs.JobType.UPLOAD_FILE_V2, r0, r9) == r2) goto L115;
     */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 12 */
    @Override // com.box.android.data.api.models.upload.UploadJobState
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object onEnter(kotlin.coroutines.Continuation<? super kotlin.Unit> r24) {
        /*
            Method dump skipped, instruction units count: 1436
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.api.models.upload.CommitSessionState.onEnter(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
