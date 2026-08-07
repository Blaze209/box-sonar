package com.box.android.data.api.models.upload;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.box.android.data.jobs.ChunkUploadJob;
import com.box.android.data.jobs.JobService;
import com.box.android.data.jobs.JobWorker;
import com.box.android.data.jobs.UploadFileJobV2;
import com.box.android.data.mappers.annotation.AnnotationEntityDomainMapperKt;
import com.box.android.data.service.impl.CommonServiceUtils;
import com.box.android.data.service.impl.UploadFileService;
import com.box.android.domain.jobs.JobId;
import com.box.androidsdk.content.models.BoxRepresentation;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedFactory;
import dagger.assisted.AssistedInject;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: UploadFileStates.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001,B3\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0018\u001a\u00020\u0019H\u0096@¢\u0006\u0002\u0010\u001aJ\u000e\u0010\u001b\u001a\u00020\u0019H\u0087@¢\u0006\u0002\u0010\u001aJ\u000e\u0010\u001c\u001a\u00020\u0019H\u0087@¢\u0006\u0002\u0010\u001aJ\u0016\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001fH\u0096@¢\u0006\u0002\u0010 J\u001e\u0010!\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020#H\u0096@¢\u0006\u0002\u0010$J\u001e\u0010%\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020'H\u0096@¢\u0006\u0002\u0010(J\u000e\u0010)\u001a\u00020*H\u0087@¢\u0006\u0002\u0010\u001aJ\u000e\u0010+\u001a\u00020\u0019H\u0087@¢\u0006\u0002\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006-"}, d2 = {"Lcom/box/android/data/api/models/upload/UploadChunksState;", "Lcom/box/android/data/api/models/upload/UploadJobState;", "jobService", "Lcom/box/android/data/jobs/JobService;", "job", "Lcom/box/android/data/jobs/UploadFileJobV2;", "uploadFileService", "Lcom/box/android/data/service/impl/UploadFileService;", "moshi", "Lcom/squareup/moshi/Moshi;", "commonServiceUtils", "Lcom/box/android/data/service/impl/CommonServiceUtils;", "<init>", "(Lcom/box/android/data/jobs/JobService;Lcom/box/android/data/jobs/UploadFileJobV2;Lcom/box/android/data/service/impl/UploadFileService;Lcom/squareup/moshi/Moshi;Lcom/box/android/data/service/impl/CommonServiceUtils;)V", "getJobService", "()Lcom/box/android/data/jobs/JobService;", "getJob", "()Lcom/box/android/data/jobs/UploadFileJobV2;", "getUploadFileService", "()Lcom/box/android/data/service/impl/UploadFileService;", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "getCommonServiceUtils", "()Lcom/box/android/data/service/impl/CommonServiceUtils;", "onEnter", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "retryFailedChunks", "enqueueChunks", "childSuccess", "childJobId", "Lcom/box/android/domain/jobs/JobId;", "(Lcom/box/android/domain/jobs/JobId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "childFailed", "domainError", "Lcom/box/android/domain/models/DomainError;", "(Lcom/box/android/domain/jobs/JobId;Lcom/box/android/domain/models/DomainError;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleChildResult", BoxRepresentation.FIELD_INFO, "", "(Lcom/box/android/domain/jobs/JobId;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryCommit", "", "tryJobFailed", "Factory", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UploadChunksState implements UploadJobState {
    private final CommonServiceUtils commonServiceUtils;
    private final UploadFileJobV2 job;
    private final JobService jobService;
    private final Moshi moshi;
    private final UploadFileService uploadFileService;

    /* JADX INFO: compiled from: UploadFileStates.kt */
    @AssistedFactory
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/box/android/data/api/models/upload/UploadChunksState$Factory;", "", "createState", "Lcom/box/android/data/api/models/upload/UploadChunksState;", "job", "Lcom/box/android/data/jobs/UploadFileJobV2;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface Factory {
        UploadChunksState createState(UploadFileJobV2 job);
    }

    /* JADX INFO: renamed from: com.box.android.data.api.models.upload.UploadChunksState$childFailed$1, reason: invalid class name */
    /* JADX INFO: compiled from: UploadFileStates.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.api.models.upload.UploadChunksState", f = "UploadFileStates.kt", i = {0, 0, 1, 1}, l = {538, 552}, m = "childFailed", n = {"childJobId", "domainError", "childJobId", "domainError"}, s = {"L$0", "L$1", "L$0", "L$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UploadChunksState.this.childFailed(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.api.models.upload.UploadChunksState$childSuccess$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UploadFileStates.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.api.models.upload.UploadChunksState", f = "UploadFileStates.kt", i = {0, 1}, l = {533, 534}, m = "childSuccess", n = {"childJobId", "childJobId"}, s = {"L$0", "L$0"}, v = 1)
    static final class C10731 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C10731(Continuation<? super C10731> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UploadChunksState.this.childSuccess(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.api.models.upload.UploadChunksState$handleChildResult$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UploadFileStates.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.api.models.upload.UploadChunksState", f = "UploadFileStates.kt", i = {0, 0, 1, 1}, l = {556, 566}, m = "handleChildResult", n = {"childJobId", BoxRepresentation.FIELD_INFO, "childJobId", BoxRepresentation.FIELD_INFO}, s = {"L$0", "L$1", "L$0", "L$1"}, v = 1)
    static final class C10751 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C10751(Continuation<? super C10751> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UploadChunksState.this.handleChildResult(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.api.models.upload.UploadChunksState$onEnter$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UploadFileStates.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.api.models.upload.UploadChunksState", f = "UploadFileStates.kt", i = {}, l = {461, 462, 463, 464}, m = "onEnter", n = {}, s = {}, v = 1)
    static final class C10771 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C10771(Continuation<? super C10771> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UploadChunksState.this.onEnter(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.api.models.upload.UploadChunksState$tryCommit$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UploadFileStates.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.api.models.upload.UploadChunksState", f = "UploadFileStates.kt", i = {0}, l = {576}, m = "tryCommit", n = {"didUpdateToCommit"}, s = {"L$0"}, v = 1)
    static final class C10791 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C10791(Continuation<? super C10791> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UploadChunksState.this.tryCommit(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.api.models.upload.UploadChunksState$tryJobFailed$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UploadFileStates.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.api.models.upload.UploadChunksState", f = "UploadFileStates.kt", i = {1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4}, l = {TypedValues.MotionType.TYPE_EASING, TypedValues.MotionType.TYPE_ANIMATE_CIRCLEANGLE_TO, TypedValues.MotionType.TYPE_PATHMOTION_ARC, TypedValues.MotionType.TYPE_DRAW_PATH, TypedValues.MotionType.TYPE_POLAR_RELATIVETO}, m = "tryJobFailed", n = {"runningData", "it", "$i$a$-let-UploadChunksState$tryJobFailed$2", "runningData", "it", "$this$onSuccess$iv", "it", "$i$a$-let-UploadChunksState$tryJobFailed$2", "$i$f$onSuccess", "$i$a$-onSuccess-UploadChunksState$tryJobFailed$2$1", "runningData", "it", "$this$onError$iv", "it", "$i$a$-let-UploadChunksState$tryJobFailed$2", "$i$f$onError", "$i$a$-onError-UploadChunksState$tryJobFailed$2$2", "runningData"}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "I$2", "L$0"}, v = 1)
    static final class C10811 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C10811(Continuation<? super C10811> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UploadChunksState.this.tryJobFailed(this);
        }
    }

    @AssistedInject
    public UploadChunksState(JobService jobService, @Assisted UploadFileJobV2 job, UploadFileService uploadFileService, Moshi moshi, CommonServiceUtils commonServiceUtils) {
        Intrinsics.checkNotNullParameter(jobService, "jobService");
        Intrinsics.checkNotNullParameter(job, "job");
        Intrinsics.checkNotNullParameter(uploadFileService, "uploadFileService");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Intrinsics.checkNotNullParameter(commonServiceUtils, "commonServiceUtils");
        this.jobService = jobService;
        this.job = job;
        this.uploadFileService = uploadFileService;
        this.moshi = moshi;
        this.commonServiceUtils = commonServiceUtils;
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

    public final Moshi getMoshi() {
        return this.moshi;
    }

    public final CommonServiceUtils getCommonServiceUtils() {
        return this.commonServiceUtils;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x006d A[PHI: r8
      0x006d: PHI (r8v6 java.lang.Object) = (r8v5 java.lang.Object), (r8v1 java.lang.Object) binds: [B:27:0x006a, B:17:0x003b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:31:0x0075  */
    /* JADX WARN: Code duplicated, block: B:36:0x0081  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007b, code lost:
    
        if (enqueueChunks(r0) == r1) goto L33;
     */
    @Override // com.box.android.data.api.models.upload.UploadJobState
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object onEnter(kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.box.android.data.api.models.upload.UploadChunksState.C10771
            if (r0 == 0) goto L14
            r0 = r8
            com.box.android.data.api.models.upload.UploadChunksState$onEnter$1 r0 = (com.box.android.data.api.models.upload.UploadChunksState.C10771) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            com.box.android.data.api.models.upload.UploadChunksState$onEnter$1 r0 = new com.box.android.data.api.models.upload.UploadChunksState$onEnter$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L47
            if (r2 == r6) goto L43
            if (r2 == r5) goto L3f
            if (r2 == r4) goto L3b
            if (r2 != r3) goto L33
            kotlin.ResultKt.throwOnFailure(r8)
            goto L7e
        L33:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3b:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L6d
        L3f:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L64
        L43:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L5b
        L47:
            kotlin.ResultKt.throwOnFailure(r8)
            com.box.android.data.jobs.JobService r8 = r7.jobService
            com.box.android.data.jobs.UploadFileJobV2 r2 = r7.job
            com.box.android.domain.jobs.JobId r2 = r2.getJobId()
            r0.label = r6
            java.lang.Object r8 = r8.waitForChildren(r2, r0)
            if (r8 != r1) goto L5b
            goto L7d
        L5b:
            r0.label = r5
            java.lang.Object r8 = r7.retryFailedChunks(r0)
            if (r8 != r1) goto L64
            goto L7d
        L64:
            r0.label = r4
            java.lang.Object r8 = r7.tryCommit(r0)
            if (r8 != r1) goto L6d
            goto L7d
        L6d:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L81
            r0.label = r3
            java.lang.Object r7 = r7.enqueueChunks(r0)
            if (r7 != r1) goto L7e
        L7d:
            return r1
        L7e:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L81:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.api.models.upload.UploadChunksState.onEnter(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.box.android.data.api.models.upload.UploadChunksState$retryFailedChunks$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UploadFileStates.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "runningData", "Lcom/box/android/data/api/models/upload/UploadFileRunningData$ChunkUploadingData;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.api.models.upload.UploadChunksState$retryFailedChunks$2", f = "UploadFileStates.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {473, 478}, m = "invokeSuspend", n = {"runningData", "newRunningData", "$this$forEach$iv", "element$iv", JobWorker.JOB_ID_PARAM, "$i$f$forEach", "$i$a$-forEach-UploadChunksState$retryFailedChunks$2$1", "offset", "runningData", "newRunningData", "$this$forEach$iv", "element$iv", JobWorker.JOB_ID_PARAM, "$this$onSuccess$iv", "it", "$i$f$forEach", "$i$a$-forEach-UploadChunksState$retryFailedChunks$2$1", "offset", "$i$f$onSuccess", "$i$a$-onSuccess-UploadChunksState$retryFailedChunks$2$1$1"}, s = {"L$0", "L$1", "L$2", "L$5", "L$6", "I$0", "I$1", "J$0", "L$0", "L$1", "L$2", "L$5", "L$6", "L$7", "L$8", "I$0", "I$1", "J$0", "I$2", "I$3"}, v = 1)
    static final class C10782 extends SuspendLambda implements Function2<UploadFileRunningData.ChunkUploadingData, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        long J$0;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;

        C10782(Continuation<? super C10782> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C10782 c10782 = UploadChunksState.this.new C10782(continuation);
            c10782.L$0 = obj;
            return c10782;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(UploadFileRunningData.ChunkUploadingData chunkUploadingData, Continuation<? super Unit> continuation) {
            return ((C10782) create(chunkUploadingData, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0099  */
        /* JADX WARN: Code duplicated, block: B:16:0x00e8  */
        /* JADX WARN: Code duplicated, block: B:19:0x00f2  */
        /* JADX WARN: Code duplicated, block: B:23:0x0189  */
        /* JADX WARN: Code duplicated, block: B:27:0x019b  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v1, types: [T, com.box.android.data.api.models.upload.UploadFileRunningData$ChunkUploadingData] */
        /* JADX WARN: Type inference failed for: r1v10, types: [T, com.box.android.data.api.models.upload.UploadFileRunningData$ChunkUploadingData] */
        /* JADX WARN: Type inference failed for: r1v13, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v15 */
        /* JADX WARN: Type inference failed for: r1v16 */
        /* JADX WARN: Type inference failed for: r1v17 */
        /* JADX WARN: Type inference failed for: r1v18 */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r28v0 */
        /* JADX WARN: Type inference failed for: r28v1, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r28v2 */
        /* JADX WARN: Type inference failed for: r28v3 */
        /* JADX WARN: Type inference failed for: r28v4 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0183 -> B:22:0x0186). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x018f -> B:22:0x0186). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r32) {
            /*
                Method dump skipped, instruction units count: 420
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.api.models.upload.UploadChunksState.C10782.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Object retryFailedChunks(Continuation<? super Unit> continuation) {
        Object objUpdatingRunningInfo$default = UploadFileJobV2.updatingRunningInfo$default(this.job, false, new C10782(null), continuation, 1, null);
        return objUpdatingRunningInfo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdatingRunningInfo$default : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.box.android.data.api.models.upload.UploadChunksState$enqueueChunks$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UploadFileStates.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "runningData", "Lcom/box/android/data/api/models/upload/UploadFileRunningData$ChunkUploadingData;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.api.models.upload.UploadChunksState$enqueueChunks$2", f = "UploadFileStates.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {519, 524}, m = "invokeSuspend", n = {"runningData", JobWorker.JOB_ID_PARAM, "failedChunks", "chunksToUpload", "runningRequests", "itemId", ChunkUploadJob.CHUNK_UPLOAD_ENDPOINT_PARAM, "newRunningData", "chunkJobRequest", "childJobId", "chunkSlotsAvailable", "numOfJobsToEnqueue", "chunkSize", "it", "$i$a$-repeat-UploadChunksState$enqueueChunks$2$1", "offsetToUpload", "runningData", JobWorker.JOB_ID_PARAM, "failedChunks", "chunksToUpload", "runningRequests", "itemId", ChunkUploadJob.CHUNK_UPLOAD_ENDPOINT_PARAM, "newRunningData", "chunkJobRequest", "childJobId", "$this$onSuccess$iv", "it", "chunkSlotsAvailable", "numOfJobsToEnqueue", "chunkSize", "it", "$i$a$-repeat-UploadChunksState$enqueueChunks$2$1", "offsetToUpload", "$i$f$onSuccess", "$i$a$-onSuccess-UploadChunksState$enqueueChunks$2$1$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$9", "L$10", "I$0", "I$1", "I$2", "I$4", "I$5", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$9", "L$10", "L$11", "L$12", "I$0", "I$1", "I$2", "I$4", "I$5", "J$0", "I$6", "I$7"}, v = 1)
    static final class C10742 extends SuspendLambda implements Function2<UploadFileRunningData.ChunkUploadingData, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        int I$5;
        int I$6;
        int I$7;
        long J$0;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;

        C10742(Continuation<? super C10742> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C10742 c10742 = UploadChunksState.this.new C10742(continuation);
            c10742.L$0 = obj;
            return c10742;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(UploadFileRunningData.ChunkUploadingData chunkUploadingData, Continuation<? super Unit> continuation) {
            return ((C10742) create(chunkUploadingData, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:19:0x013f  */
        /* JADX WARN: Code duplicated, block: B:21:0x01d2  */
        /* JADX WARN: Code duplicated, block: B:22:0x01d5  */
        /* JADX WARN: Code duplicated, block: B:25:0x01fa  */
        /* JADX WARN: Code duplicated, block: B:28:0x02b6  */
        /* JADX WARN: Code duplicated, block: B:30:0x02d1  */
        /* JADX WARN: Code duplicated, block: B:32:0x02db  */
        /* JADX WARN: Code duplicated, block: B:35:0x02eb  */
        /* JADX WARN: Code duplicated, block: B:37:0x02ef  */
        /* JADX WARN: Code duplicated, block: B:39:0x02fa  */
        /* JADX WARN: Code duplicated, block: B:41:0x0300  */
        /* JADX WARN: Code duplicated, block: B:42:0x030c  */
        /* JADX WARN: Code duplicated, block: B:46:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r17v0, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r17v10 */
        /* JADX WARN: Type inference failed for: r17v11 */
        /* JADX WARN: Type inference failed for: r17v12 */
        /* JADX WARN: Type inference failed for: r17v2, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r17v3 */
        /* JADX WARN: Type inference failed for: r17v4 */
        /* JADX WARN: Type inference failed for: r17v6 */
        /* JADX WARN: Type inference failed for: r17v8 */
        /* JADX WARN: Type inference failed for: r17v9 */
        /* JADX WARN: Type inference failed for: r1v10, types: [T, com.box.android.data.api.models.upload.UploadFileRunningData$ChunkUploadingData] */
        /* JADX WARN: Type inference failed for: r7v1, types: [T, com.box.android.data.api.models.upload.UploadFileRunningData$ChunkUploadingData] */
        /* JADX WARN: Type inference failed for: r7v13 */
        /* JADX WARN: Type inference failed for: r7v4 */
        /* JADX WARN: Type inference failed for: r7v8 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x02b6 -> B:29:0x02c1). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x02db -> B:33:0x02e7). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r41) {
            /*
                Method dump skipped, instruction units count: 789
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.api.models.upload.UploadChunksState.C10742.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Object enqueueChunks(Continuation<? super Unit> continuation) {
        Object objUpdatingRunningInfo$default = UploadFileJobV2.updatingRunningInfo$default(this.job, false, new C10742(null), continuation, 1, null);
        return objUpdatingRunningInfo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdatingRunningInfo$default : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005f, code lost:
    
        if (tryCommit(r0) == r1) goto L21;
     */
    @Override // com.box.android.data.api.models.upload.UploadJobState
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object childSuccess(com.box.android.domain.jobs.JobId r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.box.android.data.api.models.upload.UploadChunksState.C10731
            if (r0 == 0) goto L14
            r0 = r7
            com.box.android.data.api.models.upload.UploadChunksState$childSuccess$1 r0 = (com.box.android.data.api.models.upload.UploadChunksState.C10731) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            com.box.android.data.api.models.upload.UploadChunksState$childSuccess$1 r0 = new com.box.android.data.api.models.upload.UploadChunksState$childSuccess$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r5 = r0.L$0
            com.box.android.domain.jobs.JobId r5 = (com.box.android.domain.jobs.JobId) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L62
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            java.lang.Object r6 = r0.L$0
            com.box.android.domain.jobs.JobId r6 = (com.box.android.domain.jobs.JobId) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L53
        L41:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$0 = r7
            r0.label = r4
            java.lang.Object r7 = r5.tryJobFailed(r0)
            if (r7 != r1) goto L53
            goto L61
        L53:
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r5 = r5.tryCommit(r0)
            if (r5 != r1) goto L62
        L61:
            return r1
        L62:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.api.models.upload.UploadChunksState.childSuccess(com.box.android.domain.jobs.JobId, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.box.android.data.api.models.upload.UploadChunksState$childFailed$2, reason: invalid class name */
    /* JADX INFO: compiled from: UploadFileStates.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "runningData", "Lcom/box/android/data/api/models/upload/UploadFileRunningData$ChunkUploadingData;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.api.models.upload.UploadChunksState$childFailed$2", f = "UploadFileStates.kt", i = {0, 0, 0, 0}, l = {549}, m = "invokeSuspend", n = {"runningData", "runningRequests", "key", "newRunningData"}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<UploadFileRunningData.ChunkUploadingData, Continuation<? super Unit>, Object> {
        final /* synthetic */ JobId $childJobId;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ UploadChunksState this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(JobId jobId, UploadChunksState uploadChunksState, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$childJobId = jobId;
            this.this$0 = uploadChunksState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$childJobId, this.this$0, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(UploadFileRunningData.ChunkUploadingData chunkUploadingData, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(chunkUploadingData, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            UploadFileRunningData.ChunkUploadingData chunkUploadingData = (UploadFileRunningData.ChunkUploadingData) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Map<String, Long> runningRequests = chunkUploadingData.getRunningRequests();
                String identifier = this.$childJobId.getIdentifier();
                UploadFileRunningData.ChunkUploadingData chunkUploadingDataCopy$default = UploadFileRunningData.ChunkUploadingData.copy$default(chunkUploadingData, null, 0L, null, null, MapsKt.minus((Map<? extends String, ? extends V>) MapsKt.toMutableMap(runningRequests), identifier), null, MapsKt.plus(MapsKt.toMutableMap(chunkUploadingData.getFailedChunks()), TuplesKt.to(identifier, MapsKt.getValue(runningRequests, identifier))), null, 175, null);
                this.L$0 = SpillingKt.nullOutSpilledVariable(chunkUploadingData);
                this.L$1 = SpillingKt.nullOutSpilledVariable(runningRequests);
                this.L$2 = SpillingKt.nullOutSpilledVariable(identifier);
                this.L$3 = SpillingKt.nullOutSpilledVariable(chunkUploadingDataCopy$default);
                this.label = 1;
                if (this.this$0.getJob().updateRunningInfo(chunkUploadingDataCopy$default, false, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0083, code lost:
    
        if (tryJobFailed(r4) == r0) goto L21;
     */
    @Override // com.box.android.data.api.models.upload.UploadJobState
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object childFailed(com.box.android.domain.jobs.JobId r9, com.box.android.domain.models.DomainError r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof com.box.android.data.api.models.upload.UploadChunksState.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r11
            com.box.android.data.api.models.upload.UploadChunksState$childFailed$1 r0 = (com.box.android.data.api.models.upload.UploadChunksState.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            com.box.android.data.api.models.upload.UploadChunksState$childFailed$1 r0 = new com.box.android.data.api.models.upload.UploadChunksState$childFailed$1
            r0.<init>(r11)
        L19:
            r4 = r0
            java.lang.Object r11 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r7 = 2
            r2 = 1
            if (r1 == 0) goto L4b
            if (r1 == r2) goto L3e
            if (r1 != r7) goto L36
            java.lang.Object r8 = r4.L$1
            com.box.android.domain.models.DomainError r8 = (com.box.android.domain.models.DomainError) r8
            java.lang.Object r8 = r4.L$0
            com.box.android.domain.jobs.JobId r8 = (com.box.android.domain.jobs.JobId) r8
            kotlin.ResultKt.throwOnFailure(r11)
            goto L86
        L36:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3e:
            java.lang.Object r9 = r4.L$1
            r10 = r9
            com.box.android.domain.models.DomainError r10 = (com.box.android.domain.models.DomainError) r10
            java.lang.Object r9 = r4.L$0
            com.box.android.domain.jobs.JobId r9 = (com.box.android.domain.jobs.JobId) r9
            kotlin.ResultKt.throwOnFailure(r11)
            goto L71
        L4b:
            kotlin.ResultKt.throwOnFailure(r11)
            com.box.android.data.jobs.UploadFileJobV2 r1 = r8.job
            com.box.android.data.api.models.upload.UploadChunksState$childFailed$2 r11 = new com.box.android.data.api.models.upload.UploadChunksState$childFailed$2
            r3 = 0
            r11.<init>(r9, r8, r3)
            r3 = r11
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r4.L$0 = r11
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r4.L$1 = r11
            r4.label = r2
            r2 = 0
            r5 = 1
            r6 = 0
            java.lang.Object r11 = com.box.android.data.jobs.UploadFileJobV2.updatingRunningInfo$default(r1, r2, r3, r4, r5, r6)
            if (r11 != r0) goto L71
            goto L85
        L71:
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r4.L$0 = r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r4.L$1 = r9
            r4.label = r7
            java.lang.Object r8 = r8.tryJobFailed(r4)
            if (r8 != r0) goto L86
        L85:
            return r0
        L86:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.api.models.upload.UploadChunksState.childFailed(com.box.android.domain.jobs.JobId, com.box.android.domain.models.DomainError, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.box.android.data.api.models.upload.UploadChunksState$handleChildResult$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UploadFileStates.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "runningData", "Lcom/box/android/data/api/models/upload/UploadFileRunningData$ChunkUploadingData;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.api.models.upload.UploadChunksState$handleChildResult$2", f = "UploadFileStates.kt", i = {0, 0, 0, 0}, l = {563}, m = "invokeSuspend", n = {"runningData", "json", "chunk", "newRunningData"}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 1)
    static final class C10762 extends SuspendLambda implements Function2<UploadFileRunningData.ChunkUploadingData, Continuation<? super Unit>, Object> {
        final /* synthetic */ JobId $childJobId;
        final /* synthetic */ byte[] $info;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ UploadChunksState this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10762(byte[] bArr, UploadChunksState uploadChunksState, JobId jobId, Continuation<? super C10762> continuation) {
            super(2, continuation);
            this.$info = bArr;
            this.this$0 = uploadChunksState;
            this.$childJobId = jobId;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C10762 c10762 = new C10762(this.$info, this.this$0, this.$childJobId, continuation);
            c10762.L$0 = obj;
            return c10762;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(UploadFileRunningData.ChunkUploadingData chunkUploadingData, Continuation<? super Unit> continuation) {
            return ((C10762) create(chunkUploadingData, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            UploadFileRunningData.ChunkUploadingData chunkUploadingData = (UploadFileRunningData.ChunkUploadingData) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                String str = new String(this.$info, Charsets.UTF_8);
                JsonAdapter jsonAdapterAdapter = this.this$0.getMoshi().adapter(UploadFileChunkDTO.class);
                Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter, "adapter(...)");
                Object objFromJsonOrNull = AnnotationEntityDomainMapperKt.fromJsonOrNull(jsonAdapterAdapter, str);
                Intrinsics.checkNotNull(objFromJsonOrNull);
                UploadFileChunkDTO uploadFileChunkDTO = (UploadFileChunkDTO) objFromJsonOrNull;
                UploadFileRunningData.ChunkUploadingData chunkUploadingDataCopy$default = UploadFileRunningData.ChunkUploadingData.copy$default(chunkUploadingData, null, 0L, null, null, MapsKt.minus((Map<? extends String, ? extends V>) MapsKt.toMutableMap(chunkUploadingData.getRunningRequests()), this.$childJobId.getIdentifier()), null, null, SetsKt.plus((Set<? extends UploadFileChunkDTO>) CollectionsKt.toMutableSet(chunkUploadingData.getSucceededChunks()), uploadFileChunkDTO), 111, null);
                this.L$0 = SpillingKt.nullOutSpilledVariable(chunkUploadingData);
                this.L$1 = SpillingKt.nullOutSpilledVariable(str);
                this.L$2 = SpillingKt.nullOutSpilledVariable(uploadFileChunkDTO);
                this.L$3 = SpillingKt.nullOutSpilledVariable(chunkUploadingDataCopy$default);
                this.label = 1;
                if (this.this$0.getJob().updateRunningInfo(chunkUploadingDataCopy$default, false, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0083, code lost:
    
        if (enqueueChunks(r4) == r0) goto L21;
     */
    @Override // com.box.android.data.api.models.upload.UploadJobState
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object handleChildResult(com.box.android.domain.jobs.JobId r9, byte[] r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof com.box.android.data.api.models.upload.UploadChunksState.C10751
            if (r0 == 0) goto L14
            r0 = r11
            com.box.android.data.api.models.upload.UploadChunksState$handleChildResult$1 r0 = (com.box.android.data.api.models.upload.UploadChunksState.C10751) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            com.box.android.data.api.models.upload.UploadChunksState$handleChildResult$1 r0 = new com.box.android.data.api.models.upload.UploadChunksState$handleChildResult$1
            r0.<init>(r11)
        L19:
            r4 = r0
            java.lang.Object r11 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r7 = 2
            r2 = 1
            if (r1 == 0) goto L4b
            if (r1 == r2) goto L3e
            if (r1 != r7) goto L36
            java.lang.Object r8 = r4.L$1
            byte[] r8 = (byte[]) r8
            java.lang.Object r8 = r4.L$0
            com.box.android.domain.jobs.JobId r8 = (com.box.android.domain.jobs.JobId) r8
            kotlin.ResultKt.throwOnFailure(r11)
            goto L86
        L36:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3e:
            java.lang.Object r9 = r4.L$1
            r10 = r9
            byte[] r10 = (byte[]) r10
            java.lang.Object r9 = r4.L$0
            com.box.android.domain.jobs.JobId r9 = (com.box.android.domain.jobs.JobId) r9
            kotlin.ResultKt.throwOnFailure(r11)
            goto L71
        L4b:
            kotlin.ResultKt.throwOnFailure(r11)
            com.box.android.data.jobs.UploadFileJobV2 r1 = r8.job
            com.box.android.data.api.models.upload.UploadChunksState$handleChildResult$2 r11 = new com.box.android.data.api.models.upload.UploadChunksState$handleChildResult$2
            r3 = 0
            r11.<init>(r10, r8, r9, r3)
            r3 = r11
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r4.L$0 = r11
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r4.L$1 = r11
            r4.label = r2
            r2 = 0
            r5 = 1
            r6 = 0
            java.lang.Object r11 = com.box.android.data.jobs.UploadFileJobV2.updatingRunningInfo$default(r1, r2, r3, r4, r5, r6)
            if (r11 != r0) goto L71
            goto L85
        L71:
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r4.L$0 = r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r4.L$1 = r9
            r4.label = r7
            java.lang.Object r8 = r8.enqueueChunks(r4)
            if (r8 != r0) goto L86
        L85:
            return r0
        L86:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.api.models.upload.UploadChunksState.handleChildResult(com.box.android.domain.jobs.JobId, byte[], kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object tryCommit(Continuation<? super Boolean> continuation) {
        C10791 c10791;
        Ref.BooleanRef booleanRef;
        if (continuation instanceof C10791) {
            c10791 = (C10791) continuation;
            if ((c10791.label & Integer.MIN_VALUE) != 0) {
                c10791.label -= Integer.MIN_VALUE;
            } else {
                c10791 = new C10791(continuation);
            }
        } else {
            c10791 = new C10791(continuation);
        }
        C10791 c10792 = c10791;
        Object obj = c10792.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10792.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
            UploadFileJobV2 uploadFileJobV2 = this.job;
            C10802 c10802 = new C10802(booleanRef2, null);
            c10792.L$0 = booleanRef2;
            c10792.label = 1;
            if (UploadFileJobV2.updatingRunningInfo$default(uploadFileJobV2, false, c10802, c10792, 1, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
            booleanRef = booleanRef2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            booleanRef = (Ref.BooleanRef) c10792.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return Boxing.boxBoolean(booleanRef.element);
    }

    /* JADX INFO: renamed from: com.box.android.data.api.models.upload.UploadChunksState$tryCommit$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UploadFileStates.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "runningData", "Lcom/box/android/data/api/models/upload/UploadFileRunningData$ChunkUploadingData;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.api.models.upload.UploadChunksState$tryCommit$2", f = "UploadFileStates.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {589, 590}, m = "invokeSuspend", n = {"runningData", "chunksToUpload", "runningRequests", "failedChunks", "commitSessionData", "runningData", "chunksToUpload", "runningRequests", "failedChunks", "commitSessionData"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"}, v = 1)
    static final class C10802 extends SuspendLambda implements Function2<UploadFileRunningData.ChunkUploadingData, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.BooleanRef $didUpdateToCommit;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10802(Ref.BooleanRef booleanRef, Continuation<? super C10802> continuation) {
            super(2, continuation);
            this.$didUpdateToCommit = booleanRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C10802 c10802 = UploadChunksState.this.new C10802(this.$didUpdateToCommit, continuation);
            c10802.L$0 = obj;
            return c10802;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(UploadFileRunningData.ChunkUploadingData chunkUploadingData, Continuation<? super Unit> continuation) {
            return ((C10802) create(chunkUploadingData, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x00e7, code lost:
        
            if (r16.this$0.getJob().updateRunningInfo(r3, false, r16) == r2) goto L22;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r17) {
            /*
                Method dump skipped, instruction units count: 241
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.api.models.upload.UploadChunksState.C10802.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:40:0x011f  */
    /* JADX WARN: Code duplicated, block: B:42:0x0123  */
    /* JADX WARN: Code duplicated, block: B:44:0x0127  */
    /* JADX WARN: Code duplicated, block: B:47:0x0130  */
    /* JADX WARN: Code duplicated, block: B:48:0x0132  */
    /* JADX WARN: Code duplicated, block: B:50:0x0136  */
    /* JADX WARN: Code duplicated, block: B:53:0x016a  */
    /* JADX WARN: Code duplicated, block: B:57:0x016f  */
    /* JADX WARN: Code duplicated, block: B:59:0x0175  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x016c, code lost:
    
        if (r4 == null) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01b4, code lost:
    
        if (r4.jobFailed(r7, com.box.android.domain.jobs.JobType.UPLOAD_FILE_V2, r8, r2) == r3) goto L63;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object tryJobFailed(kotlin.coroutines.Continuation<? super kotlin.Unit> r18) {
        /*
            Method dump skipped, instruction units count: 445
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.api.models.upload.UploadChunksState.tryJobFailed(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
