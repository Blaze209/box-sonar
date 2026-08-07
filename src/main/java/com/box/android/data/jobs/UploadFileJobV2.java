package com.box.android.data.jobs;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import androidx.work.Data;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.common.utilities.FileUtil;
import com.box.android.data.api.models.upload.UploadFileChunkDTO;
import com.box.android.data.api.models.upload.UploadFileRunningData;
import com.box.android.data.api.models.upload.UploadJobState;
import com.box.android.data.datasource.CacheError;
import com.box.android.data.mappers.annotation.AnnotationEntityDomainMapperKt;
import com.box.android.data.persistence.jobs.JobEntity;
import com.box.android.data.service.impl.LocalItemService;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.jobs.JobConstants;
import com.box.android.domain.jobs.JobId;
import com.box.android.domain.jobs.JobRequest;
import com.box.android.domain.jobs.JobType;
import com.box.android.domain.localrepo.IBoxStorage;
import com.box.android.domain.models.DisplayableJob;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.IJobDisplayInfoProvider;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.MetricKeysParam;
import com.box.android.domain.models.MetricsInfoProvider;
import com.box.android.domain.models.UploadFileJobDisplayInfoProvider;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.services.IdMappingService;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.models.BoxRepresentation;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import com.facebook.imageutils.JfifUtil;
import com.google.common.util.concurrent.AtomicDouble;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedFactory;
import dagger.assisted.AssistedInject;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: UploadFileJobV2.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0012\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\u0018\u0000 p2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002pqBU\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\u000b\u0012\b\b\u0001\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@H\u0086@¢\u0006\u0002\u0010AJ\u0016\u0010B\u001a\u00020>2\u0006\u0010C\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010DJ\u001e\u0010E\u001a\u00020>2\u0006\u0010C\u001a\u00020\u000b2\u0006\u0010F\u001a\u00020)H\u0096@¢\u0006\u0002\u0010GJ\u001e\u0010H\u001a\u00020>2\u0006\u0010C\u001a\u00020\u000b2\u0006\u0010I\u001a\u00020JH\u0096@¢\u0006\u0002\u0010KJ&\u0010L\u001a\u00020>2\u0006\u0010C\u001a\u00020\u000b2\u0006\u0010M\u001a\u0002092\u0006\u0010N\u001a\u000209H\u0096@¢\u0006\u0002\u0010OJ\u000e\u0010P\u001a\u00020>H\u0087@¢\u0006\u0002\u0010QJ\u000e\u0010R\u001a\u00020>H\u0096@¢\u0006\u0002\u0010QJ \u0010S\u001a\u00020>2\u0006\u0010T\u001a\u00020U2\b\b\u0002\u0010V\u001a\u00020WH\u0086@¢\u0006\u0002\u0010XJ\u000e\u0010Y\u001a\u00020>H\u0086@¢\u0006\u0002\u0010QJ\u001a\u0010Z\u001a\u0004\u0018\u0001H[\"\b\b\u0000\u0010[*\u00020UH\u0086@¢\u0006\u0002\u0010QJF\u0010\\\u001a\u00020>\"\b\b\u0000\u0010[*\u00020U2\b\b\u0002\u0010]\u001a\u00020W2\"\u0010^\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H[\u0012\n\u0012\b\u0012\u0004\u0012\u00020>0`\u0012\u0006\u0012\u0004\u0018\u00010a0_H\u0086@¢\u0006\u0002\u0010bJ\u000e\u0010c\u001a\u00020>H\u0096@¢\u0006\u0002\u0010QJ\u000e\u0010d\u001a\u00020WH\u0096@¢\u0006\u0002\u0010QJ\u0010\u0010e\u001a\u00020>2\u0006\u0010f\u001a\u00020gH\u0007J\b\u0010h\u001a\u00020iH\u0016J\b\u0010j\u001a\u00020WH\u0016J\b\u0010k\u001a\u00020WH\u0002J\b\u0010l\u001a\u00020mH\u0016J\u001a\u0010n\u001a\u000e\u0012\u0004\u0012\u00020m\u0012\u0004\u0012\u00020a0oH\u0096@¢\u0006\u0002\u0010QR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010 \u001a\u00020!8\u0006@\u0006X\u0087.¢\u0006\u0014\n\u0000\u0012\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R&\u0010(\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b*\u0010#\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010/\u001a\u0002008\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b1\u0010#\u001a\u0004\b2\u00103R\u001c\u00104\u001a\u0002008\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b5\u0010#\u001a\u0004\b6\u00103R(\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u000209088\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b:\u0010#\u001a\u0004\b;\u0010<¨\u0006r"}, d2 = {"Lcom/box/android/data/jobs/UploadFileJobV2;", "Lcom/box/android/data/jobs/ParentJob;", "Lcom/box/android/domain/models/DisplayableJob;", "Lcom/box/android/domain/models/MetricsInfoProvider;", "localItemService", "Lcom/box/android/data/service/impl/LocalItemService;", "moshi", "Lcom/squareup/moshi/Moshi;", "boxStorage", "Lcom/box/android/domain/localrepo/IBoxStorage;", JobWorker.JOB_ID_PARAM, "Lcom/box/android/domain/jobs/JobId;", "inputData", "Landroidx/work/Data;", "appContext", "Landroid/content/Context;", "jobService", "Lcom/box/android/data/jobs/JobService;", "uploadStatesFactory", "Lcom/box/android/data/jobs/UploadStatesFactory;", "idMappingService", "Lcom/box/android/domain/services/IdMappingService;", "<init>", "(Lcom/box/android/data/service/impl/LocalItemService;Lcom/squareup/moshi/Moshi;Lcom/box/android/domain/localrepo/IBoxStorage;Lcom/box/android/domain/jobs/JobId;Landroidx/work/Data;Landroid/content/Context;Lcom/box/android/data/jobs/JobService;Lcom/box/android/data/jobs/UploadStatesFactory;Lcom/box/android/domain/services/IdMappingService;)V", "getJobId", "()Lcom/box/android/domain/jobs/JobId;", "getInputData", "()Landroidx/work/Data;", "getAppContext", "()Landroid/content/Context;", "getJobService", "()Lcom/box/android/data/jobs/JobService;", "state", "Lcom/box/android/data/api/models/upload/UploadJobState;", "getState$annotations", "()V", "getState", "()Lcom/box/android/data/api/models/upload/UploadJobState;", "setState", "(Lcom/box/android/data/api/models/upload/UploadJobState;)V", "lastRecordError", "Lcom/box/android/domain/models/DomainError;", "getLastRecordError$annotations", "getLastRecordError", "()Lcom/box/android/domain/models/DomainError;", "setLastRecordError", "(Lcom/box/android/domain/models/DomainError;)V", "totalProgress", "Lcom/google/common/util/concurrent/AtomicDouble;", "getTotalProgress$annotations", "getTotalProgress", "()Lcom/google/common/util/concurrent/AtomicDouble;", "totalEstimatedWork", "getTotalEstimatedWork$annotations", "getTotalEstimatedWork", "lastKnownProgressForActiveChildJobs", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getLastKnownProgressForActiveChildJobs$annotations", "getLastKnownProgressForActiveChildJobs", "()Ljava/util/concurrent/ConcurrentHashMap;", "updateLogDataWithBytesProcessed", "", "progress", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "childSucceeded", "childJobId", "(Lcom/box/android/domain/jobs/JobId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "childFailed", "domainError", "(Lcom/box/android/domain/jobs/JobId;Lcom/box/android/domain/models/DomainError;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveFromChild", BoxRepresentation.FIELD_INFO, "", "(Lcom/box/android/domain/jobs/JobId;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "childProgressed", "currentProgress", "estimatedWork", "(Lcom/box/android/domain/jobs/JobId;DDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initProgress", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "start", "updateRunningInfo", "runningInfo", "Lcom/box/android/data/api/models/upload/UploadFileRunningData;", "shouldTransition", "", "(Lcom/box/android/data/api/models/upload/UploadFileRunningData;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initState", "getRunningInfo", ExifInterface.GPS_DIRECTION_TRUE, "updatingRunningInfo", "isLockNeeded", "updateRunningData", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(ZLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cleanup", "shouldBeRemovedFromDbOnSuccess", "deleteFileIfUnderBox", "file", "Ljava/io/File;", "getJobDisplayInfoProvider", "Lcom/box/android/domain/models/IJobDisplayInfoProvider;", "shouldDisplay", "shouldDisplayInJobsUi", "getAmplitudeJobType", "", "getAmplitudeInfos", "", "Companion", "Factory", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UploadFileJobV2 implements ParentJob, DisplayableJob, MetricsInfoProvider {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int DEFAULT_MAX_NUMBER_OF_PARALLEL_CHUNK_UPLOADS = 1;
    public static final String FILE_TO_OVERWRITE_LOCAL_ITEM_ID = "fileToOverwriteLocalItemId";
    public static final String LOCAL_ITEM_ID_PARAM = "localIdParam";
    public static final String MAX_NUM_OF_PARALLEL_CHUNK_PARAM = "maxNumOfParallelChunk";
    private final Context appContext;
    private final IBoxStorage boxStorage;
    private final IdMappingService idMappingService;
    private final Data inputData;
    private final JobId jobId;
    private final JobService jobService;
    private final ConcurrentHashMap<JobId, Double> lastKnownProgressForActiveChildJobs;
    private DomainError lastRecordError;
    private final LocalItemService localItemService;
    private final Moshi moshi;
    public UploadJobState state;
    private final AtomicDouble totalEstimatedWork;
    private final AtomicDouble totalProgress;
    private final UploadStatesFactory uploadStatesFactory;

    /* JADX INFO: compiled from: UploadFileJobV2.kt */
    @AssistedFactory
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/box/android/data/jobs/UploadFileJobV2$Factory;", "", "createJob", "Lcom/box/android/data/jobs/UploadFileJobV2;", JobWorker.JOB_ID_PARAM, "Lcom/box/android/domain/jobs/JobId;", "inputData", "Landroidx/work/Data;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface Factory {
        UploadFileJobV2 createJob(JobId jobId, Data inputData);
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.UploadFileJobV2$childProgressed$1, reason: invalid class name */
    /* JADX INFO: compiled from: UploadFileJobV2.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.UploadFileJobV2", f = "UploadFileJobV2.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {Token.GET, Token.LETEXPR, 168}, m = "childProgressed", n = {"childJobId", "currentProgress", "estimatedWork", "childJobId", "currentProgress", "estimatedWork", "lastKnownProgress", "hasRetriedChild", "childJobId", "currentProgress", "estimatedWork", "lastKnownProgress", "hasRetriedChild", "progressIncremented"}, s = {"L$0", "D$0", "D$1", "L$0", "D$0", "D$1", "D$2", "I$0", "L$0", "D$0", "D$1", "D$2", "I$0", "D$3"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        double D$0;
        double D$1;
        double D$2;
        double D$3;
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UploadFileJobV2.this.childProgressed(null, 0.0d, 0.0d, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.UploadFileJobV2$cleanup$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UploadFileJobV2.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.UploadFileJobV2", f = "UploadFileJobV2.kt", i = {0}, l = {307}, m = "cleanup", n = {"itemId"}, s = {"L$0"}, v = 1)
    static final class C13361 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C13361(Continuation<? super C13361> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UploadFileJobV2.this.cleanup(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.UploadFileJobV2$getAmplitudeInfos$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UploadFileJobV2.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.UploadFileJobV2", f = "UploadFileJobV2.kt", i = {0, 1, 1}, l = {358, 360}, m = "getAmplitudeInfos", n = {"itemId", "itemId", "name"}, s = {"L$0", "L$0", "L$1"}, v = 1)
    static final class C13371 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C13371(Continuation<? super C13371> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UploadFileJobV2.this.getAmplitudeInfos(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.UploadFileJobV2$getRunningInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UploadFileJobV2.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.UploadFileJobV2", f = "UploadFileJobV2.kt", i = {}, l = {279}, m = "getRunningInfo", n = {}, s = {}, v = 1)
    static final class C13381<T extends UploadFileRunningData> extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C13381(Continuation<? super C13381> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UploadFileJobV2.this.getRunningInfo(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.UploadFileJobV2$initProgress$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UploadFileJobV2.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.UploadFileJobV2", f = "UploadFileJobV2.kt", i = {}, l = {178}, m = "initProgress", n = {}, s = {}, v = 1)
    static final class C13391 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C13391(Continuation<? super C13391> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UploadFileJobV2.this.initProgress(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.UploadFileJobV2$initState$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UploadFileJobV2.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.UploadFileJobV2", f = "UploadFileJobV2.kt", i = {}, l = {270, 270}, m = "initState", n = {}, s = {}, v = 1)
    static final class C13401 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C13401(Continuation<? super C13401> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UploadFileJobV2.this.initState(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.UploadFileJobV2$start$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UploadFileJobV2.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.UploadFileJobV2", f = "UploadFileJobV2.kt", i = {0, 1, 2, 2, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8}, l = {190, 198, 199, 205, JfifUtil.MARKER_SOI, 229, 238, 245, 248}, m = "start", n = {"itemId", "itemId", "itemId", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "itemId", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "itemId", "contentUri", "file", "fileSize", "itemId", "contentUri", "file", "fileSize", "itemId", "contentUri", "file", "fileSize", "itemId", "contentUri", "file", "runningInfo", "initialData", "fileSize", "itemId", "contentUri", "file", "runningInfo", "fileSize"}, s = {"L$0", "L$0", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "L$0", "L$1", "L$2", "L$3", "J$0"}, v = 1)
    static final class C13421 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C13421(Continuation<? super C13421> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UploadFileJobV2.this.start(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.UploadFileJobV2$updateLogDataWithBytesProcessed$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UploadFileJobV2.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.UploadFileJobV2", f = "UploadFileJobV2.kt", i = {0, 1, 1, 1, 1, 1, 1}, l = {101, 104}, m = "updateLogDataWithBytesProcessed", n = {"progress", "$this$onSuccess$iv", "it", "progress", "$i$f$onSuccess", "$i$a$-onSuccess-UploadFileJobV2$updateLogDataWithBytesProcessed$2", "currProcessed"}, s = {"J$0", "L$0", "L$1", "J$0", "I$0", "I$1", "J$1"}, v = 1)
    static final class C13431 extends ContinuationImpl {
        int I$0;
        int I$1;
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C13431(Continuation<? super C13431> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UploadFileJobV2.this.updateLogDataWithBytesProcessed(0L, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.UploadFileJobV2$updateRunningInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UploadFileJobV2.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.UploadFileJobV2", f = "UploadFileJobV2.kt", i = {0, 0, 0, 1, 1, 1}, l = {254, 258}, m = "updateRunningInfo", n = {"runningInfo", "runningInfoJson", "shouldTransition", "runningInfo", "runningInfoJson", "shouldTransition"}, s = {"L$0", "L$1", "Z$0", "L$0", "L$1", "Z$0"}, v = 1)
    static final class C13441 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C13441(Continuation<? super C13441> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UploadFileJobV2.this.updateRunningInfo(null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.UploadFileJobV2$updatingRunningInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UploadFileJobV2.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.UploadFileJobV2", f = "UploadFileJobV2.kt", i = {0, 0, 1, 1, 2, 2}, l = {BoxCommonConstants.REQUEST_OPEN_FILE, BoxCommonConstants.REQUEST_RETRY_SHARED_LINK, BoxCommonConstants.REQUEST_RETRY_SHARED_LINK}, m = "updatingRunningInfo", n = {"updateRunningData", "isLockNeeded", "updateRunningData", "isLockNeeded", "updateRunningData", "isLockNeeded"}, s = {"L$0", "Z$0", "L$0", "Z$0", "L$0", "Z$0"}, v = 1)
    static final class C13451<T extends UploadFileRunningData> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C13451(Continuation<? super C13451> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UploadFileJobV2.this.updatingRunningInfo(false, null, this);
        }
    }

    public static /* synthetic */ void getLastKnownProgressForActiveChildJobs$annotations() {
    }

    public static /* synthetic */ void getLastRecordError$annotations() {
    }

    public static /* synthetic */ void getState$annotations() {
    }

    public static /* synthetic */ void getTotalEstimatedWork$annotations() {
    }

    public static /* synthetic */ void getTotalProgress$annotations() {
    }

    @AssistedInject
    public UploadFileJobV2(LocalItemService localItemService, Moshi moshi, IBoxStorage boxStorage, @Assisted JobId jobId, @Assisted Data inputData, Context appContext, JobService jobService, UploadStatesFactory uploadStatesFactory, IdMappingService idMappingService) {
        Intrinsics.checkNotNullParameter(localItemService, "localItemService");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Intrinsics.checkNotNullParameter(boxStorage, "boxStorage");
        Intrinsics.checkNotNullParameter(jobId, "jobId");
        Intrinsics.checkNotNullParameter(inputData, "inputData");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(jobService, "jobService");
        Intrinsics.checkNotNullParameter(uploadStatesFactory, "uploadStatesFactory");
        Intrinsics.checkNotNullParameter(idMappingService, "idMappingService");
        this.localItemService = localItemService;
        this.moshi = moshi;
        this.boxStorage = boxStorage;
        this.jobId = jobId;
        this.inputData = inputData;
        this.appContext = appContext;
        this.jobService = jobService;
        this.uploadStatesFactory = uploadStatesFactory;
        this.idMappingService = idMappingService;
        this.totalProgress = new AtomicDouble(-1.0d);
        this.totalEstimatedWork = new AtomicDouble(-1.0d);
        this.lastKnownProgressForActiveChildJobs = new ConcurrentHashMap<>();
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

    public final UploadJobState getState() {
        UploadJobState uploadJobState = this.state;
        if (uploadJobState != null) {
            return uploadJobState;
        }
        Intrinsics.throwUninitializedPropertyAccessException("state");
        return null;
    }

    public final void setState(UploadJobState uploadJobState) {
        Intrinsics.checkNotNullParameter(uploadJobState, "<set-?>");
        this.state = uploadJobState;
    }

    public final DomainError getLastRecordError() {
        return this.lastRecordError;
    }

    public final void setLastRecordError(DomainError domainError) {
        this.lastRecordError = domainError;
    }

    public final AtomicDouble getTotalProgress() {
        return this.totalProgress;
    }

    public final AtomicDouble getTotalEstimatedWork() {
        return this.totalEstimatedWork;
    }

    public final ConcurrentHashMap<JobId, Double> getLastKnownProgressForActiveChildJobs() {
        return this.lastKnownProgressForActiveChildJobs;
    }

    /* JADX INFO: compiled from: UploadFileJobV2.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u0005H\u0002J:\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/box/android/data/jobs/UploadFileJobV2$Companion;", "", "<init>", "()V", "DEFAULT_MAX_NUMBER_OF_PARALLEL_CHUNK_UPLOADS", "", "MAX_NUM_OF_PARALLEL_CHUNK_PARAM", "", "LOCAL_ITEM_ID_PARAM", "FILE_TO_OVERWRITE_LOCAL_ITEM_ID", "getMaxNumOfParallelChunk", "getRequest", "Lcom/box/android/domain/jobs/JobRequest;", "itemId", "Lcom/box/android/domain/models/ItemId;", UploadFileJobV2.FILE_TO_OVERWRITE_LOCAL_ITEM_ID, "tags", "", "showInJobsUI", "", JobConstants.SHOW_NOTIFICATION, "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final int getMaxNumOfParallelChunk() {
            return 1;
        }

        private Companion() {
        }

        public static /* synthetic */ JobRequest getRequest$default(Companion companion, ItemId itemId, ItemId itemId2, Set set, boolean z, boolean z2, int i, Object obj) {
            if ((i & 8) != 0) {
                z = true;
            }
            if ((i & 16) != 0) {
                z2 = true;
            }
            return companion.getRequest(itemId, itemId2, set, z, z2);
        }

        public final JobRequest getRequest(ItemId itemId, ItemId fileToOverwriteLocalItemId, Set<String> tags, boolean showInJobsUI, boolean showNotification) {
            Intrinsics.checkNotNullParameter(itemId, "itemId");
            Intrinsics.checkNotNullParameter(tags, "tags");
            JobRequest.Builder builder = new JobRequest.Builder(JobType.UPLOAD_FILE_V2, null, null, null, 14, null);
            Data.Builder builder2 = new Data.Builder();
            builder2.putString("localIdParam", itemId.toString());
            builder2.putBoolean(JobConstants.SHOULD_DISPLAY_JOB, showInJobsUI);
            builder2.putBoolean(JobConstants.SHOW_NOTIFICATION, showNotification);
            if (fileToOverwriteLocalItemId != null) {
                builder2.putString(UploadFileJobV2.FILE_TO_OVERWRITE_LOCAL_ITEM_ID, fileToOverwriteLocalItemId.toString());
            }
            builder2.putInt(UploadFileJobV2.MAX_NUM_OF_PARALLEL_CHUNK_PARAM, UploadFileJobV2.INSTANCE.getMaxNumOfParallelChunk());
            builder.setData(builder2.build());
            builder.setTags(SetsKt.plus(SetsKt.setOf("upload_file_v2:" + itemId), (Iterable) tags));
            return builder.build();
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00af  */
    /* JADX WARN: Code duplicated, block: B:32:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:33:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object updateLogDataWithBytesProcessed(long j, Continuation<? super Unit> continuation) {
        C13431 c13431;
        Result result;
        Result result2;
        if (continuation instanceof C13431) {
            c13431 = (C13431) continuation;
            if ((c13431.label & Integer.MIN_VALUE) != 0) {
                c13431.label -= Integer.MIN_VALUE;
            } else {
                c13431 = new C13431(continuation);
            }
        } else {
            c13431 = new C13431(continuation);
        }
        Object logData = c13431.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c13431.label;
        if (i == 0) {
            ResultKt.throwOnFailure(logData);
            JobService jobService = getJobService();
            JobId jobId = this.jobId;
            c13431.J$0 = j;
            c13431.label = 1;
            logData = jobService.getLogData(jobId, c13431);
            if (logData != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            j = c13431.J$0;
            ResultKt.throwOnFailure(logData);
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            long j2 = c13431.J$1;
            int i2 = c13431.I$1;
            int i3 = c13431.I$0;
            long j3 = c13431.J$0;
            result2 = (Result) c13431.L$0;
            ResultKt.throwOnFailure(logData);
        }
        result = result2;
        if (!(result instanceof Result.Success)) {
            if (result instanceof Result.Error) {
                throw new NoWhenBranchMatchedException();
            }
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Failed to update bytes processed: " + ((CacheError) ((Result.Error) result).getValue()));
        }
        return Unit.INSTANCE;
        result = (Result) logData;
        if (result instanceof Result.Success) {
            Data data = (Data) ((Result.Success) result).getValue();
            long j4 = data.getLong(MetricKeysParam.METRIC_BYTES_PROCESSED, 0L);
            JobService jobService2 = getJobService();
            JobId jobId2 = this.jobId;
            Map<String, ? extends Object> mapMapOf = MapsKt.mapOf(TuplesKt.to(MetricKeysParam.METRIC_BYTES_PROCESSED, Boxing.boxLong(j4 + j)));
            c13431.L$0 = result;
            c13431.L$1 = SpillingKt.nullOutSpilledVariable(data);
            c13431.J$0 = j;
            c13431.I$0 = 0;
            c13431.I$1 = 0;
            c13431.J$1 = j4;
            c13431.label = 2;
            if (jobService2.updateLogData(jobId2, mapMapOf, c13431) != coroutine_suspended) {
                result2 = result;
                result = result2;
            }
            return coroutine_suspended;
        }
        if (!(result instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (!(result instanceof Result.Success)) {
            if (result instanceof Result.Error) {
                throw new NoWhenBranchMatchedException();
            }
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Failed to update bytes processed: " + ((CacheError) ((Result.Error) result).getValue()));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.UploadFileJobV2$childSucceeded$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UploadFileJobV2.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/box/android/data/api/models/upload/UploadFileRunningData;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.UploadFileJobV2$childSucceeded$2", f = "UploadFileJobV2.kt", i = {}, l = {116, 118, 123}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C13352 extends SuspendLambda implements Function2<UploadFileRunningData, Continuation<? super Unit>, Object> {
        final /* synthetic */ JobId $childJobId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13352(JobId jobId, Continuation<? super C13352> continuation) {
            super(2, continuation);
            this.$childJobId = jobId;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return UploadFileJobV2.this.new C13352(this.$childJobId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(UploadFileRunningData uploadFileRunningData, Continuation<? super Unit> continuation) {
            return ((C13352) create(uploadFileRunningData, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x0076, code lost:
        
            if (r6.this$0.getState().childSuccess(r6.$childJobId, r6) == r0) goto L24;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r6.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L25
                if (r1 == r4) goto L21
                if (r1 == r3) goto L1d
                if (r1 != r2) goto L15
                kotlin.ResultKt.throwOnFailure(r7)
                goto L79
            L15:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L1d:
                kotlin.ResultKt.throwOnFailure(r7)
                goto L5a
            L21:
                kotlin.ResultKt.throwOnFailure(r7)
                goto L36
            L25:
                kotlin.ResultKt.throwOnFailure(r7)
                com.box.android.data.jobs.UploadFileJobV2 r7 = com.box.android.data.jobs.UploadFileJobV2.this
                r1 = r6
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r6.label = r4
                java.lang.Object r7 = r7.initState(r1)
                if (r7 != r0) goto L36
                goto L78
            L36:
                com.box.android.data.jobs.UploadFileJobV2 r7 = com.box.android.data.jobs.UploadFileJobV2.this
                java.util.concurrent.ConcurrentHashMap r1 = r7.getLastKnownProgressForActiveChildJobs()
                com.box.android.domain.jobs.JobId r4 = r6.$childJobId
                java.lang.Object r1 = r1.get(r4)
                java.lang.Double r1 = (java.lang.Double) r1
                if (r1 == 0) goto L4c
                double r4 = r1.doubleValue()
                long r4 = (long) r4
                goto L4e
            L4c:
                r4 = 0
            L4e:
                r1 = r6
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r6.label = r3
                java.lang.Object r7 = r7.updateLogDataWithBytesProcessed(r4, r1)
                if (r7 != r0) goto L5a
                goto L78
            L5a:
                com.box.android.data.jobs.UploadFileJobV2 r7 = com.box.android.data.jobs.UploadFileJobV2.this
                java.util.concurrent.ConcurrentHashMap r7 = r7.getLastKnownProgressForActiveChildJobs()
                com.box.android.domain.jobs.JobId r1 = r6.$childJobId
                r7.remove(r1)
                com.box.android.data.jobs.UploadFileJobV2 r7 = com.box.android.data.jobs.UploadFileJobV2.this
                com.box.android.data.api.models.upload.UploadJobState r7 = r7.getState()
                com.box.android.domain.jobs.JobId r1 = r6.$childJobId
                r3 = r6
                kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                r6.label = r2
                java.lang.Object r6 = r7.childSuccess(r1, r3)
                if (r6 != r0) goto L79
            L78:
                return r0
            L79:
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.UploadFileJobV2.C13352.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // com.box.android.data.jobs.ParentJob
    public Object childSucceeded(JobId jobId, Continuation<? super Unit> continuation) {
        Object objUpdatingRunningInfo$default = updatingRunningInfo$default(this, false, new C13352(jobId, null), continuation, 1, null);
        return objUpdatingRunningInfo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdatingRunningInfo$default : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.UploadFileJobV2$childFailed$2, reason: invalid class name */
    /* JADX INFO: compiled from: UploadFileJobV2.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/box/android/data/api/models/upload/UploadFileRunningData;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.UploadFileJobV2$childFailed$2", f = "UploadFileJobV2.kt", i = {}, l = {129, Token.LABEL, 139}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<UploadFileRunningData, Continuation<? super Unit>, Object> {
        final /* synthetic */ JobId $childJobId;
        final /* synthetic */ DomainError $domainError;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(JobId jobId, DomainError domainError, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$childJobId = jobId;
            this.$domainError = domainError;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return UploadFileJobV2.this.new AnonymousClass2(this.$childJobId, this.$domainError, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(UploadFileRunningData uploadFileRunningData, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(uploadFileRunningData, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:24:0x006e  */
        /* JADX WARN: Code duplicated, block: B:25:0x0073  */
        /* JADX WARN: Code duplicated, block: B:28:0x0078  */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0092, code lost:
        
            if (r6.this$0.getState().childFailed(r6.$childJobId, r6.$domainError, r6) == r0) goto L31;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r6.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L26
                if (r1 == r4) goto L22
                if (r1 == r3) goto L1e
                if (r1 != r2) goto L16
                kotlin.ResultKt.throwOnFailure(r7)
                goto L95
            L16:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L1e:
                kotlin.ResultKt.throwOnFailure(r7)
                goto L5b
            L22:
                kotlin.ResultKt.throwOnFailure(r7)
                goto L37
            L26:
                kotlin.ResultKt.throwOnFailure(r7)
                com.box.android.data.jobs.UploadFileJobV2 r7 = com.box.android.data.jobs.UploadFileJobV2.this
                r1 = r6
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r6.label = r4
                java.lang.Object r7 = r7.initState(r1)
                if (r7 != r0) goto L37
                goto L94
            L37:
                com.box.android.data.jobs.UploadFileJobV2 r7 = com.box.android.data.jobs.UploadFileJobV2.this
                java.util.concurrent.ConcurrentHashMap r1 = r7.getLastKnownProgressForActiveChildJobs()
                com.box.android.domain.jobs.JobId r4 = r6.$childJobId
                java.lang.Object r1 = r1.get(r4)
                java.lang.Double r1 = (java.lang.Double) r1
                if (r1 == 0) goto L4d
                double r4 = r1.doubleValue()
                long r4 = (long) r4
                goto L4f
            L4d:
                r4 = 0
            L4f:
                r1 = r6
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r6.label = r3
                java.lang.Object r7 = r7.updateLogDataWithBytesProcessed(r4, r1)
                if (r7 != r0) goto L5b
                goto L94
            L5b:
                com.box.android.data.jobs.UploadFileJobV2 r7 = com.box.android.data.jobs.UploadFileJobV2.this
                java.util.concurrent.ConcurrentHashMap r7 = r7.getLastKnownProgressForActiveChildJobs()
                com.box.android.domain.jobs.JobId r1 = r6.$childJobId
                r7.remove(r1)
                com.box.android.data.jobs.UploadFileJobV2 r7 = com.box.android.data.jobs.UploadFileJobV2.this
                com.box.android.domain.models.DomainError r7 = r7.getLastRecordError()
                if (r7 == 0) goto L73
                com.box.android.domain.models.ErrorRecoveryType r7 = r7.getErrorType()
                goto L74
            L73:
                r7 = 0
            L74:
                com.box.android.domain.models.ErrorRecoveryType r1 = com.box.android.domain.models.ErrorRecoveryType.UNRECOVERABLE
                if (r7 == r1) goto L7f
                com.box.android.data.jobs.UploadFileJobV2 r7 = com.box.android.data.jobs.UploadFileJobV2.this
                com.box.android.domain.models.DomainError r1 = r6.$domainError
                r7.setLastRecordError(r1)
            L7f:
                com.box.android.data.jobs.UploadFileJobV2 r7 = com.box.android.data.jobs.UploadFileJobV2.this
                com.box.android.data.api.models.upload.UploadJobState r7 = r7.getState()
                com.box.android.domain.jobs.JobId r1 = r6.$childJobId
                com.box.android.domain.models.DomainError r3 = r6.$domainError
                r4 = r6
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                r6.label = r2
                java.lang.Object r6 = r7.childFailed(r1, r3, r4)
                if (r6 != r0) goto L95
            L94:
                return r0
            L95:
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.UploadFileJobV2.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // com.box.android.data.jobs.ParentJob
    public Object childFailed(JobId jobId, DomainError domainError, Continuation<? super Unit> continuation) {
        Object objUpdatingRunningInfo$default = updatingRunningInfo$default(this, false, new AnonymousClass2(jobId, domainError, null), continuation, 1, null);
        return objUpdatingRunningInfo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdatingRunningInfo$default : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.UploadFileJobV2$receiveFromChild$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UploadFileJobV2.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/box/android/data/api/models/upload/UploadFileRunningData;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.UploadFileJobV2$receiveFromChild$2", f = "UploadFileJobV2.kt", i = {}, l = {Token.COLONCOLON, Token.DOTQUERY}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C13412 extends SuspendLambda implements Function2<UploadFileRunningData, Continuation<? super Unit>, Object> {
        final /* synthetic */ JobId $childJobId;
        final /* synthetic */ byte[] $info;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13412(JobId jobId, byte[] bArr, Continuation<? super C13412> continuation) {
            super(2, continuation);
            this.$childJobId = jobId;
            this.$info = bArr;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return UploadFileJobV2.this.new C13412(this.$childJobId, this.$info, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(UploadFileRunningData uploadFileRunningData, Continuation<? super Unit> continuation) {
            return ((C13412) create(uploadFileRunningData, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0042, code lost:
        
            if (r5.this$0.getState().handleChildResult(r5.$childJobId, r5.$info, r5) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r5.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.ResultKt.throwOnFailure(r6)
                goto L45
            L12:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L1a:
                kotlin.ResultKt.throwOnFailure(r6)
                goto L2f
            L1e:
                kotlin.ResultKt.throwOnFailure(r6)
                com.box.android.data.jobs.UploadFileJobV2 r6 = com.box.android.data.jobs.UploadFileJobV2.this
                r1 = r5
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r5.label = r3
                java.lang.Object r6 = r6.initState(r1)
                if (r6 != r0) goto L2f
                goto L44
            L2f:
                com.box.android.data.jobs.UploadFileJobV2 r6 = com.box.android.data.jobs.UploadFileJobV2.this
                com.box.android.data.api.models.upload.UploadJobState r6 = r6.getState()
                com.box.android.domain.jobs.JobId r1 = r5.$childJobId
                byte[] r3 = r5.$info
                r4 = r5
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                r5.label = r2
                java.lang.Object r5 = r6.handleChildResult(r1, r3, r4)
                if (r5 != r0) goto L45
            L44:
                return r0
            L45:
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.UploadFileJobV2.C13412.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // com.box.android.data.jobs.ParentJob
    public Object receiveFromChild(JobId jobId, byte[] bArr, Continuation<? super Unit> continuation) {
        Object objUpdatingRunningInfo$default = updatingRunningInfo$default(this, false, new C13412(jobId, bArr, null), continuation, 1, null);
        return objUpdatingRunningInfo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdatingRunningInfo$default : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0129, code lost:
    
        if (r8.taskProgress(r9, r15, r17, r2) == r3) goto L33;
     */
    @Override // com.box.android.data.jobs.ParentJob
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object childProgressed(com.box.android.domain.jobs.JobId r22, double r23, double r25, kotlin.coroutines.Continuation<? super kotlin.Unit> r27) {
        /*
            Method dump skipped, instruction units count: 303
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.UploadFileJobV2.childProgressed(com.box.android.domain.jobs.JobId, double, double, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object initProgress(Continuation<? super Unit> continuation) {
        C13391 c13391;
        if (continuation instanceof C13391) {
            c13391 = (C13391) continuation;
            if ((c13391.label & Integer.MIN_VALUE) != 0) {
                c13391.label -= Integer.MIN_VALUE;
            } else {
                c13391 = new C13391(continuation);
            }
        } else {
            c13391 = new C13391(continuation);
        }
        Object runningInfo = c13391.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c13391.label;
        if (i == 0) {
            ResultKt.throwOnFailure(runningInfo);
            if (this.totalProgress.get() < 0.0d || this.totalEstimatedWork.get() < 0.0d) {
                c13391.label = 1;
                runningInfo = getRunningInfo(c13391);
                if (runningInfo == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(runningInfo);
        Intrinsics.checkNotNull(runningInfo);
        UploadFileRunningData.ChunkUploadingData chunkUploadingData = (UploadFileRunningData.ChunkUploadingData) runningInfo;
        AtomicDouble atomicDouble = this.totalProgress;
        Iterator<T> it = chunkUploadingData.getSucceededChunks().iterator();
        long size = 0;
        while (it.hasNext()) {
            size += ((UploadFileChunkDTO) it.next()).getSize();
        }
        atomicDouble.set(size);
        this.totalEstimatedWork.set(chunkUploadingData.getFileSize());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0129  */
    /* JADX WARN: Code duplicated, block: B:39:0x0135  */
    /* JADX WARN: Code duplicated, block: B:44:0x0172  */
    /* JADX WARN: Code duplicated, block: B:47:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:50:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:55:0x020e  */
    /* JADX WARN: Code duplicated, block: B:58:0x0225  */
    /* JADX WARN: Code duplicated, block: B:61:0x022b  */
    /* JADX WARN: Code duplicated, block: B:66:0x0272  */
    /* JADX WARN: Code duplicated, block: B:71:0x02a8  */
    /* JADX WARN: Code duplicated, block: B:73:0x02ac  */
    /* JADX WARN: Code duplicated, block: B:78:0x030e  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x010e, code lost:
    
        if (r15.jobFailed(r2, com.box.android.domain.jobs.JobType.UPLOAD_FILE_V2, r6, r4) == r0) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x016b, code lost:
    
        if (r2.jobFailed(r3, com.box.android.domain.jobs.JobType.UPLOAD_FILE_V2, r6, r4) == r0) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0207, code lost:
    
        if (r15.jobFailed(r14, com.box.android.domain.jobs.JobType.UPLOAD_FILE_V2, r8, r4) == r0) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x026b, code lost:
    
        if (updateRunningInfo$default(r14, r7, false, r4, 2, null) == r0) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x02a2, code lost:
    
        if (r14.onEnter(r4) == r0) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0308, code lost:
    
        if (r2.jobFailed(r3, com.box.android.domain.jobs.JobType.UPLOAD_FILE_V2, r6, r4) == r0) goto L75;
     */
    @Override // com.box.android.data.jobs.Job
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object start(kotlin.coroutines.Continuation<? super kotlin.Unit> r15) throws java.io.UnsupportedEncodingException {
        /*
            Method dump skipped, instruction units count: 812
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.UploadFileJobV2.start(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object updateRunningInfo$default(UploadFileJobV2 uploadFileJobV2, UploadFileRunningData uploadFileRunningData, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return uploadFileJobV2.updateRunningInfo(uploadFileRunningData, z, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00a9, code lost:
    
        if (r8.onEnter(r0) == r1) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object updateRunningInfo(com.box.android.data.api.models.upload.UploadFileRunningData r9, boolean r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof com.box.android.data.jobs.UploadFileJobV2.C13441
            if (r0 == 0) goto L14
            r0 = r11
            com.box.android.data.jobs.UploadFileJobV2$updateRunningInfo$1 r0 = (com.box.android.data.jobs.UploadFileJobV2.C13441) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            com.box.android.data.jobs.UploadFileJobV2$updateRunningInfo$1 r0 = new com.box.android.data.jobs.UploadFileJobV2$updateRunningInfo$1
            r0.<init>(r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L50
            if (r2 == r4) goto L40
            if (r2 != r3) goto L38
            boolean r8 = r0.Z$0
            java.lang.Object r8 = r0.L$1
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r8 = r0.L$0
            com.box.android.data.api.models.upload.UploadFileRunningData r8 = (com.box.android.data.api.models.upload.UploadFileRunningData) r8
            kotlin.ResultKt.throwOnFailure(r11)
            goto Lac
        L38:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L40:
            boolean r10 = r0.Z$0
            java.lang.Object r9 = r0.L$1
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r2 = r0.L$0
            com.box.android.data.api.models.upload.UploadFileRunningData r2 = (com.box.android.data.api.models.upload.UploadFileRunningData) r2
            kotlin.ResultKt.throwOnFailure(r11)
            r11 = r9
            r9 = r2
            goto L86
        L50:
            kotlin.ResultKt.throwOnFailure(r11)
            com.squareup.moshi.Moshi r11 = r8.moshi
            java.lang.Class<com.box.android.data.api.models.upload.UploadFileRunningData> r2 = com.box.android.data.api.models.upload.UploadFileRunningData.class
            com.squareup.moshi.JsonAdapter r11 = r11.adapter(r2)
            java.lang.String r11 = r11.toJson(r9)
            com.box.android.data.jobs.JobService r2 = r8.getJobService()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            java.nio.charset.Charset r5 = kotlin.text.Charsets.UTF_8
            byte[] r5 = r11.getBytes(r5)
            java.lang.String r6 = "getBytes(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            com.box.android.domain.jobs.JobId r6 = r8.jobId
            r0.L$0 = r9
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11)
            r0.L$1 = r7
            r0.Z$0 = r10
            r0.label = r4
            java.lang.Object r2 = r2.updateRunningInfo(r5, r6, r0)
            if (r2 != r1) goto L86
            goto Lab
        L86:
            com.box.android.data.jobs.UploadStatesFactory r2 = r8.uploadStatesFactory
            com.box.android.data.api.models.upload.UploadJobState r2 = r2.createUploadState(r8, r9)
            r8.setState(r2)
            if (r10 == 0) goto Laf
            com.box.android.data.api.models.upload.UploadJobState r8 = r8.getState()
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r0.L$0 = r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11)
            r0.L$1 = r9
            r0.Z$0 = r10
            r0.label = r3
            java.lang.Object r8 = r8.onEnter(r0)
            if (r8 != r1) goto Lac
        Lab:
            return r1
        Lac:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        Laf:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.UploadFileJobV2.updateRunningInfo(com.box.android.data.api.models.upload.UploadFileRunningData, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0064, code lost:
    
        if (r6.jobFailed(r5, com.box.android.domain.jobs.JobType.UPLOAD_FILE_V2, r2, r0) == r1) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object initState(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.box.android.data.jobs.UploadFileJobV2.C13401
            if (r0 == 0) goto L14
            r0 = r6
            com.box.android.data.jobs.UploadFileJobV2$initState$1 r0 = (com.box.android.data.jobs.UploadFileJobV2.C13401) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            com.box.android.data.jobs.UploadFileJobV2$initState$1 r0 = new com.box.android.data.jobs.UploadFileJobV2$initState$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L39
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r6)
            goto L67
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L49
        L39:
            kotlin.ResultKt.throwOnFailure(r6)
            com.box.android.data.api.models.upload.UploadJobState r6 = r5.state
            if (r6 != 0) goto L73
            r0.label = r4
            java.lang.Object r6 = r5.getRunningInfo(r0)
            if (r6 != r1) goto L49
            goto L66
        L49:
            com.box.android.data.api.models.upload.UploadFileRunningData r6 = (com.box.android.data.api.models.upload.UploadFileRunningData) r6
            if (r6 != 0) goto L6a
            com.box.android.data.jobs.JobService r6 = r5.getJobService()
            com.box.android.domain.jobs.JobId r5 = r5.jobId
            com.box.android.domain.models.DomainError$CacheReadError r2 = new com.box.android.domain.models.DomainError$CacheReadError
            java.lang.String r4 = "Unexpected job state: running info should be available"
            r2.<init>(r4)
            com.box.android.domain.models.DomainError r2 = (com.box.android.domain.models.DomainError) r2
            r0.label = r3
            java.lang.String r3 = "UploadFileJobV2"
            java.lang.Object r5 = r6.jobFailed(r5, r3, r2, r0)
            if (r5 != r1) goto L67
        L66:
            return r1
        L67:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L6a:
            com.box.android.data.jobs.UploadStatesFactory r0 = r5.uploadStatesFactory
            com.box.android.data.api.models.upload.UploadJobState r6 = r0.createUploadState(r5, r6)
            r5.setState(r6)
        L73:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.UploadFileJobV2.initState(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final <T extends UploadFileRunningData> Object getRunningInfo(Continuation<? super T> continuation) {
        C13381 c13381;
        if (continuation instanceof C13381) {
            c13381 = (C13381) continuation;
            if ((c13381.label & Integer.MIN_VALUE) != 0) {
                c13381.label -= Integer.MIN_VALUE;
            } else {
                c13381 = new C13381(continuation);
            }
        } else {
            c13381 = new C13381(continuation);
        }
        Object runningInfo = c13381.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c13381.label;
        if (i == 0) {
            ResultKt.throwOnFailure(runningInfo);
            JobService jobService = getJobService();
            JobId jobId = this.jobId;
            c13381.label = 1;
            runningInfo = jobService.getRunningInfo(jobId, c13381);
            if (runningInfo == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(runningInfo);
        }
        byte[] bArr = (byte[]) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) runningInfo);
        if (bArr == null) {
            return null;
        }
        String str = new String(bArr, Charsets.UTF_8);
        JsonAdapter jsonAdapterAdapter = this.moshi.adapter(UploadFileRunningData.class);
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter, "adapter(...)");
        Object objFromJsonOrNull = AnnotationEntityDomainMapperKt.fromJsonOrNull(jsonAdapterAdapter, str);
        Intrinsics.checkNotNull(objFromJsonOrNull);
        return (UploadFileRunningData) objFromJsonOrNull;
    }

    public static /* synthetic */ Object updatingRunningInfo$default(UploadFileJobV2 uploadFileJobV2, boolean z, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return uploadFileJobV2.updatingRunningInfo(z, function2, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0077, code lost:
    
        if (r10.withTransaction(r2, r0) == r1) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a4, code lost:
    
        if (r9.invoke(r10, r0) == r1) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <T extends com.box.android.data.api.models.upload.UploadFileRunningData> java.lang.Object updatingRunningInfo(boolean r8, kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.box.android.data.jobs.UploadFileJobV2.C13451
            if (r0 == 0) goto L14
            r0 = r10
            com.box.android.data.jobs.UploadFileJobV2$updatingRunningInfo$1 r0 = (com.box.android.data.jobs.UploadFileJobV2.C13451) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            com.box.android.data.jobs.UploadFileJobV2$updatingRunningInfo$1 r0 = new com.box.android.data.jobs.UploadFileJobV2$updatingRunningInfo$1
            r0.<init>(r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L59
            if (r2 == r6) goto L4f
            if (r2 == r5) goto L40
            if (r2 != r4) goto L38
            boolean r7 = r0.Z$0
            java.lang.Object r7 = r0.L$0
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            kotlin.ResultKt.throwOnFailure(r10)
            goto La7
        L38:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L40:
            boolean r8 = r0.Z$0
            java.lang.Object r7 = r0.L$1
            r9 = r7
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            java.lang.Object r7 = r0.L$0
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            kotlin.ResultKt.throwOnFailure(r10)
            goto L91
        L4f:
            boolean r7 = r0.Z$0
            java.lang.Object r7 = r0.L$0
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            kotlin.ResultKt.throwOnFailure(r10)
            goto L7a
        L59:
            kotlin.ResultKt.throwOnFailure(r10)
            if (r8 == 0) goto L7d
            com.box.android.data.jobs.JobService r10 = r7.getJobService()
            com.box.android.data.jobs.UploadFileJobV2$updatingRunningInfo$2 r2 = new com.box.android.data.jobs.UploadFileJobV2$updatingRunningInfo$2
            r2.<init>(r9, r7, r3)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r0.L$0 = r7
            r0.Z$0 = r8
            r0.label = r6
            java.lang.Object r7 = r10.withTransaction(r2, r0)
            if (r7 != r1) goto L7a
            goto La6
        L7a:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L7d:
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r0.L$0 = r10
            r0.L$1 = r9
            r0.Z$0 = r8
            r0.label = r5
            java.lang.Object r10 = r7.getRunningInfo(r0)
            if (r10 != r1) goto L90
            goto La6
        L90:
            r7 = r9
        L91:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r0.L$0 = r7
            r0.L$1 = r3
            r0.Z$0 = r8
            r0.label = r4
            java.lang.Object r7 = r9.invoke(r10, r0)
            if (r7 != r1) goto La7
        La6:
            return r1
        La7:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.UploadFileJobV2.updatingRunningInfo(boolean, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.UploadFileJobV2$updatingRunningInfo$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UploadFileJobV2.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.UploadFileJobV2$updatingRunningInfo$2", f = "UploadFileJobV2.kt", i = {}, l = {BoxCommonConstants.REQUEST_CHOOSE_LOCAL_UPLOAD_DIR, BoxCommonConstants.REQUEST_CHOOSE_LOCAL_UPLOAD_DIR}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C13462 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<T, Continuation<? super Unit>, Object> $updateRunningData;
        Object L$0;
        int label;
        final /* synthetic */ UploadFileJobV2 this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C13462(Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2, UploadFileJobV2 uploadFileJobV2, Continuation<? super C13462> continuation) {
            super(1, continuation);
            this.$updateRunningData = function2;
            this.this$0 = uploadFileJobV2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C13462(this.$updateRunningData, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C13462) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0043, code lost:
        
            if (r1.invoke(r6, r5) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r5.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L22
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.ResultKt.throwOnFailure(r6)
                goto L46
            L12:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L1a:
                java.lang.Object r1 = r5.L$0
                kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
                kotlin.ResultKt.throwOnFailure(r6)
                goto L37
            L22:
                kotlin.ResultKt.throwOnFailure(r6)
                kotlin.jvm.functions.Function2<T, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r1 = r5.$updateRunningData
                com.box.android.data.jobs.UploadFileJobV2 r6 = r5.this$0
                r4 = r5
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                r5.L$0 = r1
                r5.label = r3
                java.lang.Object r6 = r6.getRunningInfo(r4)
                if (r6 != r0) goto L37
                goto L45
            L37:
                kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
                r3 = 0
                r5.L$0 = r3
                r5.label = r2
                java.lang.Object r5 = r1.invoke(r6, r5)
                if (r5 != r0) goto L46
            L45:
                return r0
            L46:
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.UploadFileJobV2.C13462.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.data.jobs.Job
    public Object cleanup(Continuation<? super Unit> continuation) {
        C13361 c13361;
        ItemId itemIdCreate;
        Unit unit;
        if (continuation instanceof C13361) {
            c13361 = (C13361) continuation;
            if ((c13361.label & Integer.MIN_VALUE) != 0) {
                c13361.label -= Integer.MIN_VALUE;
            } else {
                c13361 = new C13361(continuation);
            }
        } else {
            c13361 = new C13361(continuation);
        }
        Object contentUrl = c13361.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c13361.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(contentUrl);
                String string = this.inputData.getString("localIdParam");
                if (string != null && (itemIdCreate = ItemId.INSTANCE.create(string)) != null) {
                    LocalItemService localItemService = this.localItemService;
                    c13361.L$0 = SpillingKt.nullOutSpilledVariable(itemIdCreate);
                    c13361.label = 1;
                    contentUrl = localItemService.getContentUrl(itemIdCreate, c13361);
                    if (contentUrl == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(contentUrl);
            Result result = (Result) contentUrl;
            if (result instanceof Result.Success) {
                String str = (String) ((Result.Success) result).getValue();
                if (str == null) {
                    return Unit.INSTANCE;
                }
                File fileCreateFileWithUri = FileUtil.createFileWithUri(str);
                if (fileCreateFileWithUri != null) {
                    deleteFileIfUnderBox(fileCreateFileWithUri);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                new Result.Success(unit);
            } else if (!(result instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
        } catch (Exception e) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Failed to cleanup file " + e);
        }
        return Unit.INSTANCE;
    }

    @Override // com.box.android.data.jobs.Job
    public Object shouldBeRemovedFromDbOnSuccess(Continuation<? super Boolean> continuation) {
        return Boxing.boxBoolean(false);
    }

    public final void deleteFileIfUnderBox(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        if (file.exists() && new File(this.boxStorage.getPendingUploadDirectory(), file.getName()).getPath().equals(file.getPath()) && !file.delete()) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Unable to delete local media file");
        }
    }

    @Override // com.box.android.domain.models.DisplayableJob
    public IJobDisplayInfoProvider getJobDisplayInfoProvider() {
        ItemId.Companion companion = ItemId.INSTANCE;
        String string = this.inputData.getString("localIdParam");
        Intrinsics.checkNotNull(string);
        return new UploadFileJobDisplayInfoProvider(companion.create(string), this.localItemService, this.idMappingService, this.inputData.getBoolean(JobConstants.SHOW_NOTIFICATION, true));
    }

    @Override // com.box.android.domain.models.DisplayableJob
    public boolean shouldDisplay() {
        return shouldDisplayInJobsUi();
    }

    private final boolean shouldDisplayInJobsUi() {
        if (this.inputData.getKeyValueMap().keySet().contains(JobConstants.SHOULD_DISPLAY_JOB)) {
            return this.inputData.getBoolean(JobConstants.SHOULD_DISPLAY_JOB, true);
        }
        return this.inputData.getBoolean(JobConstants.IS_USER_TRIGGERED, true);
    }

    @Override // com.box.android.domain.models.MetricsInfoProvider
    public String getAmplitudeJobType() {
        return BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_UPLOAD_JOB;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.models.MetricsInfoProvider
    public Object getAmplitudeInfos(Continuation<? super Map<String, ? extends Object>> continuation) {
        C13371 c13371;
        ItemId itemIdCreate;
        String name;
        String str;
        if (continuation instanceof C13371) {
            c13371 = (C13371) continuation;
            if ((c13371.label & Integer.MIN_VALUE) != 0) {
                c13371.label -= Integer.MIN_VALUE;
            } else {
                c13371 = new C13371(continuation);
            }
        } else {
            c13371 = new C13371(continuation);
        }
        Object itemByLocalId = c13371.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c13371.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(itemByLocalId);
                ItemId.Companion companion = ItemId.INSTANCE;
                String string = this.inputData.getString("localIdParam");
                Intrinsics.checkNotNull(string);
                itemIdCreate = companion.create(string);
                LocalItemService localItemService = this.localItemService;
                c13371.L$0 = itemIdCreate;
                c13371.label = 1;
                itemByLocalId = localItemService.getItemByLocalId(itemIdCreate, c13371);
                if (itemByLocalId == coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                itemIdCreate = (ItemId) c13371.L$0;
                ResultKt.throwOnFailure(itemByLocalId);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                str = (String) c13371.L$1;
                ResultKt.throwOnFailure(itemByLocalId);
            }
            Object obj = com.box.android.domain.utils.result.ResultKt.get((Result) itemByLocalId);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            return MapsKt.mapOf(TuplesKt.to(BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_FIELD_FILE_SIZE, Boxing.boxLong(FileUtil.createFileWithUri((String) obj).length())), TuplesKt.to(BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_FIELD_FILE_EXTENSION, CommonBoxUtil.getFileExtension(str, "")), TuplesKt.to(BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_FIELD_FILE_TYPE, BoxAnalyticsParams.INSTANCE.calculateFileType(CommonBoxUtil.getFileExtension(str, ""))));
            ItemModel itemModel = (ItemModel) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) itemByLocalId);
            if (itemModel == null || (name = itemModel.getName()) == null) {
                name = "";
            }
            LocalItemService localItemService2 = this.localItemService;
            c13371.L$0 = SpillingKt.nullOutSpilledVariable(itemIdCreate);
            c13371.L$1 = name;
            c13371.label = 2;
            Object contentUrl = localItemService2.getContentUrl(itemIdCreate, c13371);
            if (contentUrl != coroutine_suspended) {
                String str2 = name;
                itemByLocalId = contentUrl;
                str = str2;
                Object obj2 = com.box.android.domain.utils.result.ResultKt.get((Result) itemByLocalId);
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                return MapsKt.mapOf(TuplesKt.to(BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_FIELD_FILE_SIZE, Boxing.boxLong(FileUtil.createFileWithUri((String) obj2).length())), TuplesKt.to(BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_FIELD_FILE_EXTENSION, CommonBoxUtil.getFileExtension(str, "")), TuplesKt.to(BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_FIELD_FILE_TYPE, BoxAnalyticsParams.INSTANCE.calculateFileType(CommonBoxUtil.getFileExtension(str, ""))));
            }
            return coroutine_suspended;
        } catch (Exception e) {
            BoxLogUtils.e("Unable to get Additional Amp Info " + e);
            return MapsKt.mapOf(TuplesKt.to(BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_FIELD_FILE_SIZE, Boxing.boxInt(-1)), TuplesKt.to(BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_FIELD_FILE_TYPE, "unknown"), TuplesKt.to(BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_FIELD_FILE_EXTENSION, "unknown"));
        }
    }
}
