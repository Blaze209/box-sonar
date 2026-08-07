package com.box.android.data.jobs;

import android.content.Context;
import androidx.work.Data;
import com.box.android.data.persistence.jobs.JobEntity;
import com.box.android.data.service.impl.DownloadFileService;
import com.box.android.domain.jobs.JobId;
import com.box.android.domain.jobs.JobRequest;
import com.box.android.domain.jobs.JobType;
import com.box.android.domain.localrepo.IBoxStorage;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.utils.Progress;
import com.box.android.domain.utils.result.Result;
import com.box.android.domain.utils.result.ResultProgressWrapper;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import com.squareup.moshi.Moshi;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedFactory;
import dagger.assisted.AssistedInject;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.NonCancellable;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: DownloadFileJob.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 -2\u00020\u0001:\u0002-.BE\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u001a\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010\u001cJ\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0007J \u0010#\u001a\n %*\u0004\u0018\u00010$0$2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0007J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0007J\u000e\u0010*\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010\u001cJ\u000e\u0010+\u001a\u00020,H\u0096@¢\u0006\u0002\u0010\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006/"}, d2 = {"Lcom/box/android/data/jobs/DownloadChunkJob;", "Lcom/box/android/data/jobs/Job;", "downloadFileService", "Lcom/box/android/data/service/impl/DownloadFileService;", "boxStorage", "Lcom/box/android/domain/localrepo/IBoxStorage;", "moshi", "Lcom/squareup/moshi/Moshi;", JobWorker.JOB_ID_PARAM, "Lcom/box/android/domain/jobs/JobId;", "inputData", "Landroidx/work/Data;", "appContext", "Landroid/content/Context;", "jobService", "Lcom/box/android/data/jobs/JobService;", "<init>", "(Lcom/box/android/data/service/impl/DownloadFileService;Lcom/box/android/domain/localrepo/IBoxStorage;Lcom/squareup/moshi/Moshi;Lcom/box/android/domain/jobs/JobId;Landroidx/work/Data;Landroid/content/Context;Lcom/box/android/data/jobs/JobService;)V", "getJobId", "()Lcom/box/android/domain/jobs/JobId;", "getInputData", "()Landroidx/work/Data;", "getAppContext", "()Landroid/content/Context;", "getJobService", "()Lcom/box/android/data/jobs/JobService;", "start", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "targetFile", "Ljava/io/File;", "fileId", "Lcom/box/android/domain/models/ItemId$Remote;", "offset", "", "targetFileUri", "", "kotlin.jvm.PlatformType", "getChunkDataByteArray", "", "chunkData", "Lcom/box/android/data/jobs/ChunkData;", "cleanup", "shouldBeRemovedFromDbOnSuccess", "", "Companion", "Factory", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DownloadChunkJob implements Job {
    public static final String CHUNK_SIZE_PARAM = "chunkSizeParam";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String FILE_MODEL_ID_PARAM = "fileModelId";
    public static final String OFFSET_PARAM = "startByteParam";
    public static final String SHARED_LINK_HEADER = "sharedLinkHeaderParam";
    private final Context appContext;
    private final IBoxStorage boxStorage;
    private final DownloadFileService downloadFileService;
    private final Data inputData;
    private final JobId jobId;
    private final JobService jobService;
    private final Moshi moshi;

    /* JADX INFO: compiled from: DownloadFileJob.kt */
    @AssistedFactory
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/box/android/data/jobs/DownloadChunkJob$Factory;", "", "createJob", "Lcom/box/android/data/jobs/DownloadChunkJob;", JobWorker.JOB_ID_PARAM, "Lcom/box/android/domain/jobs/JobId;", "inputData", "Landroidx/work/Data;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface Factory {
        DownloadChunkJob createJob(JobId jobId, Data inputData);
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.DownloadChunkJob$start$1, reason: invalid class name */
    /* JADX INFO: compiled from: DownloadFileJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.DownloadChunkJob", f = "DownloadFileJob.kt", i = {0, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3}, l = {503, 512, 520, 527}, m = "start", n = {"itemId", "itemId", "offset", "chunkSize", "itemId", "sharedLinkHeader", "offset", "chunkSize", "itemId", "sharedLinkHeader", "progressWrapper", "offset", "chunkSize"}, s = {"L$0", "L$0", "J$0", "J$1", "L$0", "L$1", "J$0", "J$1", "L$0", "L$1", "L$2", "J$0", "J$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DownloadChunkJob.this.start(this);
        }
    }

    @AssistedInject
    public DownloadChunkJob(DownloadFileService downloadFileService, IBoxStorage boxStorage, Moshi moshi, @Assisted JobId jobId, @Assisted Data inputData, Context appContext, JobService jobService) {
        Intrinsics.checkNotNullParameter(downloadFileService, "downloadFileService");
        Intrinsics.checkNotNullParameter(boxStorage, "boxStorage");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Intrinsics.checkNotNullParameter(jobId, "jobId");
        Intrinsics.checkNotNullParameter(inputData, "inputData");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(jobService, "jobService");
        this.downloadFileService = downloadFileService;
        this.boxStorage = boxStorage;
        this.moshi = moshi;
        this.jobId = jobId;
        this.inputData = inputData;
        this.appContext = appContext;
        this.jobService = jobService;
    }

    @Override // com.box.android.data.jobs.Job
    public /* bridge */ Object run(JobEntity jobEntity, Continuation<? super Unit> continuation) {
        return super.run(jobEntity, continuation);
    }

    public final JobId getJobId() {
        return this.jobId;
    }

    public final Data getInputData() {
        return this.inputData;
    }

    @Override // com.box.android.data.jobs.Job
    public Context getAppContext() {
        return this.appContext;
    }

    @Override // com.box.android.data.jobs.Job
    public JobService getJobService() {
        return this.jobService;
    }

    /* JADX INFO: compiled from: DownloadFileJob.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/box/android/data/jobs/DownloadChunkJob$Companion;", "", "<init>", "()V", "FILE_MODEL_ID_PARAM", "", "OFFSET_PARAM", "CHUNK_SIZE_PARAM", "SHARED_LINK_HEADER", "getRequest", "Lcom/box/android/domain/jobs/JobRequest;", "fileId", "Lcom/box/android/domain/models/ItemId$Remote;", "offset", "", "chunkSize", "sharedLinkHeader", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final JobRequest getRequest(ItemId.Remote fileId, long offset, long chunkSize, String sharedLinkHeader) {
            Intrinsics.checkNotNullParameter(fileId, "fileId");
            JobRequest.Builder builder = new JobRequest.Builder(JobType.CHUNK_DOWNLOAD_JOB, null, null, null, 14, null);
            Data.Builder builder2 = new Data.Builder();
            builder2.putString(DownloadChunkJob.FILE_MODEL_ID_PARAM, fileId.getBoxId());
            builder2.putLong(DownloadChunkJob.OFFSET_PARAM, offset);
            builder2.putLong(DownloadChunkJob.CHUNK_SIZE_PARAM, chunkSize);
            if (sharedLinkHeader != null) {
                builder2.putString(DownloadChunkJob.SHARED_LINK_HEADER, sharedLinkHeader);
            }
            builder.setData(builder2.build());
            return builder.build();
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00ad, code lost:
    
        if (r3.jobFailed(r2, com.box.android.domain.jobs.JobType.CHUNK_DOWNLOAD_JOB, r4, r11) == r12) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0127, code lost:
    
        if (kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r0, r11) == r12) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x014d, code lost:
    
        if (r3.jobFailed(r2, com.box.android.domain.jobs.JobType.CHUNK_DOWNLOAD_JOB, r5, r11) == r12) goto L47;
     */
    @Override // com.box.android.data.jobs.Job
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object start(kotlin.coroutines.Continuation<? super kotlin.Unit> r19) {
        /*
            Method dump skipped, instruction units count: 339
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.DownloadChunkJob.start(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.DownloadChunkJob$start$2, reason: invalid class name */
    /* JADX INFO: compiled from: DownloadFileJob.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.DownloadChunkJob$start$2", f = "DownloadFileJob.kt", i = {0, 0, 1, 1, 1}, l = {538, 539}, m = "invokeSuspend", n = {"$this$coroutineScope", "progressFlowJob", "$this$coroutineScope", "progressFlowJob", ReactNativeFeatureActivity.RESULT_EXTRA_KEY}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit, ? extends DomainError>>, Object> {
        final /* synthetic */ long $chunkSize;
        final /* synthetic */ ItemId.Remote $itemId;
        final /* synthetic */ long $offset;
        final /* synthetic */ ResultProgressWrapper<Unit, DomainError, Progress> $progressWrapper;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ DownloadChunkJob this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ResultProgressWrapper<Unit, DomainError, Progress> resultProgressWrapper, DownloadChunkJob downloadChunkJob, long j, long j2, ItemId.Remote remote, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$progressWrapper = resultProgressWrapper;
            this.this$0 = downloadChunkJob;
            this.$chunkSize = j;
            this.$offset = j2;
            this.$itemId = remote;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$progressWrapper, this.this$0, this.$chunkSize, this.$offset, this.$itemId, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit, ? extends DomainError>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Result<Unit, ? extends DomainError>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlinx.coroutines.Job jobLaunch$default;
            Object objFirst;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new DownloadChunkJob$start$2$progressFlowJob$1(this.$progressWrapper, this.this$0, this.$chunkSize, null), 3, null);
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
            jobLaunch$default = (kotlinx.coroutines.Job) this.L$1;
            ResultKt.throwOnFailure(obj);
            objFirst = obj;
            kotlinx.coroutines.Job job = jobLaunch$default;
            Intrinsics.checkNotNull(objFirst);
            Result result = (Result) objFirst;
            this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
            this.L$1 = SpillingKt.nullOutSpilledVariable(job);
            this.L$2 = SpillingKt.nullOutSpilledVariable(result);
            this.label = 2;
            Object objWithContext = BuildersKt.withContext(NonCancellable.INSTANCE, new AnonymousClass1(result, job, this.this$0, this.$offset, this.$itemId, null), this);
            return objWithContext == coroutine_suspended ? coroutine_suspended : objWithContext;
        }

        /* JADX INFO: renamed from: com.box.android.data.jobs.DownloadChunkJob$start$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: DownloadFileJob.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.data.jobs.DownloadChunkJob$start$2$1", f = "DownloadFileJob.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {542, 546, 550}, m = "invokeSuspend", n = {"$this$onSuccess$iv", "it", "$i$f$onSuccess", "$i$a$-onSuccess-DownloadChunkJob$start$2$1$1", "$this$onSuccess$iv", "it", "$i$f$onSuccess", "$i$a$-onSuccess-DownloadChunkJob$start$2$1$1", "$this$onError$iv", "it", "$i$f$onError", "$i$a$-onError-DownloadChunkJob$start$2$1$2"}, s = {"L$0", "L$2", "I$0", "I$1", "L$0", "L$1", "I$0", "I$1", "L$0", "L$3", "I$0", "I$1"}, v = 1)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit, ? extends DomainError>>, Object> {
            final /* synthetic */ ItemId.Remote $itemId;
            final /* synthetic */ long $offset;
            final /* synthetic */ kotlinx.coroutines.Job $progressFlowJob;
            final /* synthetic */ Result<Unit, DomainError> $result;
            int I$0;
            int I$1;
            long J$0;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            int label;
            final /* synthetic */ DownloadChunkJob this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(Result<Unit, ? extends DomainError> result, kotlinx.coroutines.Job job, DownloadChunkJob downloadChunkJob, long j, ItemId.Remote remote, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$result = result;
                this.$progressFlowJob = job;
                this.this$0 = downloadChunkJob;
                this.$offset = j;
                this.$itemId = remote;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$result, this.$progressFlowJob, this.this$0, this.$offset, this.$itemId, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit, ? extends DomainError>> continuation) {
                return invoke2(coroutineScope, (Continuation<? super Result<Unit, ? extends DomainError>>) continuation);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code duplicated, block: B:26:0x00d4 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:27:0x00d5  */
            /* JADX WARN: Code duplicated, block: B:29:0x00d9  */
            /* JADX WARN: Code duplicated, block: B:32:0x0111  */
            /* JADX WARN: Code duplicated, block: B:35:0x011c  */
            /* JADX WARN: Code restructure failed: missing block: B:19:0x00bf, code lost:
            
                if (r10.jobSucceeded(r9, r14) == r0) goto L31;
             */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r15) {
                /*
                    Method dump skipped, instruction units count: 296
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.DownloadChunkJob.AnonymousClass2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }
    }

    public final File targetFile(ItemId.Remote fileId, long offset) throws IOException {
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        File file = new File(this.boxStorage.getPendingDownloadsDirectory(), this.jobId + "_" + fileId.getBoxId() + "_" + offset);
        file.createNewFile();
        return file;
    }

    public final String targetFileUri(ItemId.Remote fileId, long offset) {
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        return targetFile(fileId, offset).getAbsolutePath();
    }

    public final byte[] getChunkDataByteArray(ChunkData chunkData) {
        Intrinsics.checkNotNullParameter(chunkData, "chunkData");
        String json = this.moshi.adapter(ChunkData.class).toJson(chunkData);
        Intrinsics.checkNotNull(json);
        byte[] bytes = json.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return bytes;
    }

    @Override // com.box.android.data.jobs.Job
    public Object cleanup(Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.box.android.data.jobs.Job
    public Object shouldBeRemovedFromDbOnSuccess(Continuation<? super Boolean> continuation) {
        return Boxing.boxBoolean(true);
    }
}
