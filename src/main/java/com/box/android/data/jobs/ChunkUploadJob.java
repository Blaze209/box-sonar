package com.box.android.data.jobs;

import android.content.Context;
import androidx.work.Data;
import com.box.android.data.api.models.upload.UploadFileChunkDTO;
import com.box.android.data.persistence.jobs.JobEntity;
import com.box.android.data.service.impl.LocalItemService;
import com.box.android.data.service.impl.UploadFileService;
import com.box.android.domain.jobs.JobId;
import com.box.android.domain.jobs.JobRequest;
import com.box.android.domain.jobs.JobType;
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
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.NonCancellable;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: ChunkUploadJob.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 )2\u00020\u0001:\u0002)*BO\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0001\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u001c\u001a\u00020\u001dH\u0096@¢\u0006\u0002\u0010\u001eJ\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020%J\u000e\u0010&\u001a\u00020\u001dH\u0096@¢\u0006\u0002\u0010\u001eJ\u000e\u0010'\u001a\u00020(H\u0096@¢\u0006\u0002\u0010\u001eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/box/android/data/jobs/ChunkUploadJob;", "Lcom/box/android/data/jobs/Job;", "uploadFileService", "Lcom/box/android/data/service/impl/UploadFileService;", "localItemService", "Lcom/box/android/data/service/impl/LocalItemService;", "moshi", "Lcom/squareup/moshi/Moshi;", JobWorker.JOB_ID_PARAM, "Lcom/box/android/domain/jobs/JobId;", "inputData", "Landroidx/work/Data;", "appContext", "Landroid/content/Context;", "jobService", "Lcom/box/android/data/jobs/JobService;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/box/android/data/service/impl/UploadFileService;Lcom/box/android/data/service/impl/LocalItemService;Lcom/squareup/moshi/Moshi;Lcom/box/android/domain/jobs/JobId;Landroidx/work/Data;Landroid/content/Context;Lcom/box/android/data/jobs/JobService;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getJobId", "()Lcom/box/android/domain/jobs/JobId;", "getInputData", "()Landroidx/work/Data;", "getAppContext", "()Landroid/content/Context;", "getJobService", "()Lcom/box/android/data/jobs/JobService;", "start", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createInputStream", "Ljava/io/FileInputStream;", "file", "Ljava/io/File;", "createFile", "contentUrl", "", "cleanup", "shouldBeRemovedFromDbOnSuccess", "", "Companion", "Factory", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ChunkUploadJob implements Job {
    public static final String CHUNK_OFFSET_PARAM = "chunkOffset";
    public static final String CHUNK_UPLOAD_ENDPOINT_PARAM = "chunkUploadEndpoint";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String LOCAL_ITEM_ID_PARAM = "localIdParam";
    public static final String PART_SIZE_PARAM = "partSize";
    private final Context appContext;
    private final CoroutineDispatcher dispatcher;
    private final Data inputData;
    private final JobId jobId;
    private final JobService jobService;
    private final LocalItemService localItemService;
    private final Moshi moshi;
    private final UploadFileService uploadFileService;

    /* JADX INFO: compiled from: ChunkUploadJob.kt */
    @AssistedFactory
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/box/android/data/jobs/ChunkUploadJob$Factory;", "", "createJob", "Lcom/box/android/data/jobs/ChunkUploadJob;", JobWorker.JOB_ID_PARAM, "Lcom/box/android/domain/jobs/JobId;", "inputData", "Landroidx/work/Data;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface Factory {
        ChunkUploadJob createJob(JobId jobId, Data inputData);
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.ChunkUploadJob$start$1, reason: invalid class name */
    /* JADX INFO: compiled from: ChunkUploadJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.ChunkUploadJob", f = "ChunkUploadJob.kt", i = {0, 1, 1, 2, 2, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7}, l = {75, 76, 82, 89, 95, 115, 121, Token.XMLEND}, m = "start", n = {"itemId", "itemId", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "itemId", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "itemId", "contentUri", "itemId", "contentUri", ChunkUploadJob.CHUNK_UPLOAD_ENDPOINT_PARAM, "file", "itemId", "contentUri", ChunkUploadJob.CHUNK_UPLOAD_ENDPOINT_PARAM, "file", "fileInputStream", "contentRangeHeader", "fileChunk", "digestHeader", ChunkUploadJob.PART_SIZE_PARAM, "startByte", "endByte", "bytesToRead", "itemId", "contentUri", ChunkUploadJob.CHUNK_UPLOAD_ENDPOINT_PARAM, "file", "fileInputStream", "contentRangeHeader", "fileChunk", "digestHeader", "progressWrapper", ChunkUploadJob.PART_SIZE_PARAM, "startByte", "endByte", "bytesToRead", "itemId", "contentUri", ChunkUploadJob.CHUNK_UPLOAD_ENDPOINT_PARAM, "file", "fileInputStream", "e"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "J$0", "J$1", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0", "J$0", "J$1", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChunkUploadJob.this.start(this);
        }
    }

    @AssistedInject
    public ChunkUploadJob(UploadFileService uploadFileService, LocalItemService localItemService, Moshi moshi, @Assisted JobId jobId, @Assisted Data inputData, Context appContext, JobService jobService, CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(uploadFileService, "uploadFileService");
        Intrinsics.checkNotNullParameter(localItemService, "localItemService");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Intrinsics.checkNotNullParameter(jobId, "jobId");
        Intrinsics.checkNotNullParameter(inputData, "inputData");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(jobService, "jobService");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.uploadFileService = uploadFileService;
        this.localItemService = localItemService;
        this.moshi = moshi;
        this.jobId = jobId;
        this.inputData = inputData;
        this.appContext = appContext;
        this.jobService = jobService;
        this.dispatcher = dispatcher;
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

    /* JADX INFO: compiled from: ChunkUploadJob.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/jobs/ChunkUploadJob$Companion;", "", "<init>", "()V", "LOCAL_ITEM_ID_PARAM", "", "CHUNK_UPLOAD_ENDPOINT_PARAM", "PART_SIZE_PARAM", "CHUNK_OFFSET_PARAM", "getRequest", "Lcom/box/android/domain/jobs/JobRequest;", "itemId", "Lcom/box/android/domain/models/ItemId;", ChunkUploadJob.CHUNK_OFFSET_PARAM, "", ChunkUploadJob.CHUNK_UPLOAD_ENDPOINT_PARAM, ChunkUploadJob.PART_SIZE_PARAM, "", "tags", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ JobRequest getRequest$default(Companion companion, ItemId itemId, long j, String str, int i, Set set, int i2, Object obj) {
            if ((i2 & 16) != 0) {
                set = SetsKt.emptySet();
            }
            return companion.getRequest(itemId, j, str, i, set);
        }

        public final JobRequest getRequest(ItemId itemId, long chunkOffset, String chunkUploadEndpoint, int partSize, Set<String> tags) {
            Intrinsics.checkNotNullParameter(itemId, "itemId");
            Intrinsics.checkNotNullParameter(chunkUploadEndpoint, "chunkUploadEndpoint");
            Intrinsics.checkNotNullParameter(tags, "tags");
            JobRequest.Builder builder = new JobRequest.Builder(JobType.CHUNK_UPLOAD, null, null, null, 14, null);
            Data.Builder builder2 = new Data.Builder();
            builder2.putString("localIdParam", itemId.toString());
            builder2.putString(ChunkUploadJob.CHUNK_UPLOAD_ENDPOINT_PARAM, chunkUploadEndpoint);
            builder2.putInt(ChunkUploadJob.PART_SIZE_PARAM, partSize);
            builder2.putLong(ChunkUploadJob.CHUNK_OFFSET_PARAM, chunkOffset);
            builder.setData(builder2.build());
            builder.setTags(SetsKt.plus(SetsKt.setOf("chunk_upload:" + itemId + " " + chunkOffset), (Iterable) tags));
            return builder.build();
        }
    }

    /* JADX WARN: Code duplicated, block: B:113:0x03cd  */
    /* JADX WARN: Code duplicated, block: B:115:0x03d1  */
    /* JADX WARN: Code duplicated, block: B:117:0x03d5  */
    /* JADX WARN: Code duplicated, block: B:122:0x0408  */
    /* JADX WARN: Code duplicated, block: B:34:0x0103 A[PHI: r0 r4 r5 r7 r8
      0x0103: PHI (r0v48 java.lang.Object) = (r0v45 java.lang.Object), (r0v64 java.lang.Object) binds: [B:62:0x021b, B:33:0x0101] A[DONT_GENERATE, DONT_INLINE]
      0x0103: PHI (r4v13 java.io.File) = (r4v12 java.io.File), (r4v33 java.io.File) binds: [B:62:0x021b, B:33:0x0101] A[DONT_GENERATE, DONT_INLINE]
      0x0103: PHI (r5v13 ??) = (r5v42 ??), (r5v43 ??) binds: [B:62:0x021b, B:33:0x0101] A[DONT_GENERATE, DONT_INLINE]
      0x0103: PHI (r7v10 java.lang.String) = (r7v8 java.lang.String), (r7v19 java.lang.String) binds: [B:62:0x021b, B:33:0x0101] A[DONT_GENERATE, DONT_INLINE]
      0x0103: PHI (r8v7 com.box.android.domain.models.ItemId) = (r8v5 com.box.android.domain.models.ItemId), (r8v16 com.box.android.domain.models.ItemId) binds: [B:62:0x021b, B:33:0x0101] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:49:0x017e  */
    /* JADX WARN: Code duplicated, block: B:51:0x018a  */
    /* JADX WARN: Code duplicated, block: B:56:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:59:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:74:0x02bd  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x03c0, code lost:
    
        if (r3.jobFailed(r11, com.box.android.domain.jobs.JobType.CHUNK_UPLOAD, r12, r6) == r2) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0402, code lost:
    
        if (r3.jobFailed(r1, com.box.android.domain.jobs.JobType.CHUNK_UPLOAD, r4, r6) == r2) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x01c1, code lost:
    
        if (r3.jobFailed(r4, com.box.android.domain.jobs.JobType.CHUNK_UPLOAD, r5, r6) == r2) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0323, code lost:
    
        if (kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r5, r8) == r2) goto L119;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v25 */
    /* JADX WARN: Type inference failed for: r10v26 */
    /* JADX WARN: Type inference failed for: r10v4, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r10v6, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r18v2 */
    /* JADX WARN: Type inference failed for: r18v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v35, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r3v52 */
    /* JADX WARN: Type inference failed for: r3v53 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21, types: [com.box.android.data.service.impl.UploadFileService] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v40 */
    /* JADX WARN: Type inference failed for: r4v45 */
    /* JADX WARN: Type inference failed for: r4v46 */
    /* JADX WARN: Type inference failed for: r4v47 */
    /* JADX WARN: Type inference failed for: r4v48 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v19, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v31 */
    /* JADX WARN: Type inference failed for: r5v33 */
    /* JADX WARN: Type inference failed for: r5v34 */
    /* JADX WARN: Type inference failed for: r5v35 */
    /* JADX WARN: Type inference failed for: r5v37, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v38 */
    /* JADX WARN: Type inference failed for: r5v39 */
    /* JADX WARN: Type inference failed for: r5v40 */
    /* JADX WARN: Type inference failed for: r5v41 */
    /* JADX WARN: Type inference failed for: r5v42 */
    /* JADX WARN: Type inference failed for: r5v43 */
    /* JADX WARN: Type inference failed for: r5v44 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.box.android.data.jobs.Job
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object start(kotlin.coroutines.Continuation<? super kotlin.Unit> r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1060
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.ChunkUploadJob.start(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.ChunkUploadJob$start$2, reason: invalid class name */
    /* JADX INFO: compiled from: ChunkUploadJob.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Ljava/io/FileInputStream;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.ChunkUploadJob$start$2", f = "ChunkUploadJob.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super FileInputStream>, Object> {
        final /* synthetic */ File $file;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(File file, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$file = file;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ChunkUploadJob.this.new AnonymousClass2(this.$file, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super FileInputStream> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ChunkUploadJob.this.createInputStream(this.$file);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.ChunkUploadJob$start$3, reason: invalid class name */
    /* JADX INFO: compiled from: ChunkUploadJob.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/data/api/models/upload/UploadFileChunkDTO;", "Lcom/box/android/domain/models/DomainError;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.ChunkUploadJob$start$3", f = "ChunkUploadJob.kt", i = {0, 1, 1, 2, 2, 2}, l = {122, Token.LOOP, 134}, m = "invokeSuspend", n = {"$this$coroutineScope", "$this$coroutineScope", "progressFlowJob", "$this$coroutineScope", "progressFlowJob", ReactNativeFeatureActivity.RESULT_EXTRA_KEY}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2"}, v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends UploadFileChunkDTO, ? extends DomainError>>, Object> {
        final /* synthetic */ ResultProgressWrapper<UploadFileChunkDTO, DomainError, Progress> $progressWrapper;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(ResultProgressWrapper<UploadFileChunkDTO, DomainError, Progress> resultProgressWrapper, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$progressWrapper = resultProgressWrapper;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass3 anonymousClass3 = ChunkUploadJob.this.new AnonymousClass3(this.$progressWrapper, continuation);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends UploadFileChunkDTO, ? extends DomainError>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Result<UploadFileChunkDTO, ? extends DomainError>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<UploadFileChunkDTO, ? extends DomainError>> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:22:0x00b4 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlinx.coroutines.Job jobLaunch$default;
            Object objWithContext;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.L$0 = coroutineScope;
                this.label = 1;
                if (ChunkUploadJob.this.getJobService().networkTaskStarting(ChunkUploadJob.this.getJobId(), 1.0d, this) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                jobLaunch$default = (kotlinx.coroutines.Job) this.L$1;
                ResultKt.throwOnFailure(obj);
            }
            Intrinsics.checkNotNull(obj);
            Result result = (Result) obj;
            this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
            this.L$1 = SpillingKt.nullOutSpilledVariable(jobLaunch$default);
            this.L$2 = SpillingKt.nullOutSpilledVariable(result);
            this.label = 3;
            objWithContext = BuildersKt.withContext(NonCancellable.INSTANCE, new AnonymousClass1(result, jobLaunch$default, ChunkUploadJob.this, null), this);
            if (objWithContext != coroutine_suspended) {
                return coroutine_suspended;
            }
            return objWithContext;
            jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new ChunkUploadJob$start$3$progressFlowJob$1(this.$progressWrapper, ChunkUploadJob.this, null), 3, null);
            this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
            this.L$1 = jobLaunch$default;
            this.label = 2;
            obj = FlowKt.first(this.$progressWrapper.getResult(), this);
            if (obj != coroutine_suspended) {
                Intrinsics.checkNotNull(obj);
                Result result2 = (Result) obj;
                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.L$1 = SpillingKt.nullOutSpilledVariable(jobLaunch$default);
                this.L$2 = SpillingKt.nullOutSpilledVariable(result2);
                this.label = 3;
                objWithContext = BuildersKt.withContext(NonCancellable.INSTANCE, new AnonymousClass1(result2, jobLaunch$default, ChunkUploadJob.this, null), this);
                if (objWithContext != coroutine_suspended) {
                    return objWithContext;
                }
            }
            return coroutine_suspended;
        }

        /* JADX INFO: renamed from: com.box.android.data.jobs.ChunkUploadJob$start$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: ChunkUploadJob.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/data/api/models/upload/UploadFileChunkDTO;", "Lcom/box/android/domain/models/DomainError;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.data.jobs.ChunkUploadJob$start$3$1", f = "ChunkUploadJob.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {Token.SCRIPT, Token.SETELEM_OP, Token.DOTDOT}, m = "invokeSuspend", n = {"$this$onSuccess$iv", "it", "$i$f$onSuccess", "$i$a$-onSuccess-ChunkUploadJob$start$3$1$1", "$this$onSuccess$iv", "it", "$i$f$onSuccess", "$i$a$-onSuccess-ChunkUploadJob$start$3$1$1", "$this$onError$iv", "it", "$i$f$onError", "$i$a$-onError-ChunkUploadJob$start$3$1$2"}, s = {"L$0", "L$2", "I$0", "I$1", "L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "I$0", "I$1"}, v = 1)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends UploadFileChunkDTO, ? extends DomainError>>, Object> {
            final /* synthetic */ kotlinx.coroutines.Job $progressFlowJob;
            final /* synthetic */ Result<UploadFileChunkDTO, DomainError> $result;
            int I$0;
            int I$1;
            Object L$0;
            Object L$1;
            Object L$2;
            int label;
            final /* synthetic */ ChunkUploadJob this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(Result<UploadFileChunkDTO, ? extends DomainError> result, kotlinx.coroutines.Job job, ChunkUploadJob chunkUploadJob, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$result = result;
                this.$progressFlowJob = job;
                this.this$0 = chunkUploadJob;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$result, this.$progressFlowJob, this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends UploadFileChunkDTO, ? extends DomainError>> continuation) {
                return invoke2(coroutineScope, (Continuation<? super Result<UploadFileChunkDTO, ? extends DomainError>>) continuation);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<UploadFileChunkDTO, ? extends DomainError>> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code duplicated, block: B:28:0x00d3  */
            /* JADX WARN: Code duplicated, block: B:30:0x00d7  */
            /* JADX WARN: Code duplicated, block: B:34:0x0103  */
            /* JADX WARN: Code restructure failed: missing block: B:20:0x00c1, code lost:
            
                if (r10.jobSucceeded(r9, r12) == r0) goto L32;
             */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r13) {
                /*
                    Method dump skipped, instruction units count: 271
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.ChunkUploadJob.AnonymousClass3.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }
    }

    public final FileInputStream createInputStream(File file) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(file, "file");
        return new FileInputStream(file);
    }

    public final File createFile(String contentUrl) {
        Intrinsics.checkNotNullParameter(contentUrl, "contentUrl");
        return new File(contentUrl);
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
