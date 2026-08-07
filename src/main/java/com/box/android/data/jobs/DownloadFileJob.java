package com.box.android.data.jobs;

import android.content.Context;
import androidx.media3.extractor.ts.PsExtractor;
import androidx.work.Data;
import com.box.android.common.extensions.FileExtensionsKt;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.data.persistence.jobs.JobEntity;
import com.box.android.data.service.impl.DownloadFileService;
import com.box.android.data.service.impl.SharedLinkService;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.configuration.DataPolicy;
import com.box.android.domain.jobs.JobConstants;
import com.box.android.domain.jobs.JobId;
import com.box.android.domain.jobs.JobRequest;
import com.box.android.domain.jobs.JobType;
import com.box.android.domain.localrepo.IBoxStorage;
import com.box.android.domain.models.DisplayableJob;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.DownloadFileJobDisplayInfoProvider;
import com.box.android.domain.models.IJobDisplayInfoProvider;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.ItemIdKt;
import com.box.android.domain.models.MetricsInfoProvider;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.ItemModelKt;
import com.box.android.domain.models.item.ItemType;
import com.box.android.domain.services.IRemoteItemService;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.android.domain.utils.Progress;
import com.box.android.domain.utils.result.Result;
import com.box.android.domain.utils.result.ResultProgressWrapper;
import com.box.androidsdk.content.models.BoxRepresentation;
import com.box.androidsdk.content.requests.BoxRequestsFile;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.squareup.moshi.Moshi;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedFactory;
import dagger.assisted.AssistedInject;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
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
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.NonCancellable;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: DownloadFileJob.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 a2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002abBU\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0001\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0001\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\b\u0010&\u001a\u00020'H\u0007J\u000e\u0010(\u001a\u00020)H\u0096@¢\u0006\u0002\u0010*J2\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020'2\n\b\u0002\u00101\u001a\u0004\u0018\u00010#H\u0082@¢\u0006\u0002\u00102J(\u00103\u001a\u00020)2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\b\u00101\u001a\u0004\u0018\u00010#H\u0082@¢\u0006\u0002\u00104J\u001e\u00105\u001a\u00020)2\u0006\u00106\u001a\u00020\u000f2\u0006\u00107\u001a\u000208H\u0096@¢\u0006\u0002\u00109J\u0016\u0010:\u001a\u00020)2\u0006\u00106\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010;J\u001e\u0010<\u001a\u00020)2\u0006\u00106\u001a\u00020\u000f2\u0006\u0010=\u001a\u00020>H\u0096@¢\u0006\u0002\u0010?J&\u0010@\u001a\u00020)2\u0006\u00106\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020BH\u0096@¢\u0006\u0002\u0010DJ\u0010\u0010E\u001a\u0004\u0018\u00010FH\u0082@¢\u0006\u0002\u0010*J\u0010\u0010G\u001a\u0004\u0018\u00010/H\u0087@¢\u0006\u0002\u0010*J\u0018\u0010H\u001a\u00020)2\u0006\u0010I\u001a\u00020#2\u0006\u00100\u001a\u00020'H\u0007J\u0010\u0010J\u001a\u00020K2\u0006\u00100\u001a\u00020'H\u0007J\u0010\u0010L\u001a\u0004\u0018\u00010'2\u0006\u0010M\u001a\u00020#J\u0010\u0010N\u001a\u00020F2\u0006\u0010O\u001a\u000208H\u0007J\u0010\u0010P\u001a\u0002082\u0006\u0010Q\u001a\u00020FH\u0007J\u0010\u0010R\u001a\u00020S2\u0006\u0010O\u001a\u000208H\u0007J$\u0010T\u001a\u00020'2\u0006\u0010,\u001a\u00020-2\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020W0VH\u0007J\u000e\u0010X\u001a\u00020)H\u0096@¢\u0006\u0002\u0010*J\u000e\u0010Y\u001a\u00020KH\u0096@¢\u0006\u0002\u0010*J\b\u0010Z\u001a\u00020[H\u0016J\b\u0010\\\u001a\u00020KH\u0016J\b\u0010]\u001a\u00020#H\u0016J\u001a\u0010^\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020`0_H\u0096@¢\u0006\u0002\u0010*R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0012\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0014\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\u00020#X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u0006c"}, d2 = {"Lcom/box/android/data/jobs/DownloadFileJob;", "Lcom/box/android/data/jobs/ParentJob;", "Lcom/box/android/domain/models/DisplayableJob;", "Lcom/box/android/domain/models/MetricsInfoProvider;", "downloadFileService", "Lcom/box/android/data/service/impl/DownloadFileService;", "itemService", "Lcom/box/android/domain/services/IRemoteItemService;", "boxStorage", "Lcom/box/android/domain/localrepo/IBoxStorage;", "moshi", "Lcom/squareup/moshi/Moshi;", "sharedLinkService", "Lcom/box/android/data/service/impl/SharedLinkService;", JobWorker.JOB_ID_PARAM, "Lcom/box/android/domain/jobs/JobId;", "inputData", "Landroidx/work/Data;", "appContext", "Landroid/content/Context;", "jobService", "Lcom/box/android/data/jobs/JobService;", "<init>", "(Lcom/box/android/data/service/impl/DownloadFileService;Lcom/box/android/domain/services/IRemoteItemService;Lcom/box/android/domain/localrepo/IBoxStorage;Lcom/squareup/moshi/Moshi;Lcom/box/android/data/service/impl/SharedLinkService;Lcom/box/android/domain/jobs/JobId;Landroidx/work/Data;Landroid/content/Context;Lcom/box/android/data/jobs/JobService;)V", "getJobId", "()Lcom/box/android/domain/jobs/JobId;", "getInputData", "()Landroidx/work/Data;", "getAppContext", "()Landroid/content/Context;", "getJobService", "()Lcom/box/android/data/jobs/JobService;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "targetFileDeletionError", "", "getTargetFileDeletionError", "()Ljava/lang/String;", "targetFolder", "Ljava/io/File;", "start", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadSmallFile", "fileId", "Lcom/box/android/domain/models/ItemId$Remote;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "targetFile", "sharedLinkHeader", "(Lcom/box/android/domain/models/ItemId$Remote;Lcom/box/android/domain/models/item/FileModel;Ljava/io/File;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enqueueChildJobs", "(Lcom/box/android/domain/models/ItemId$Remote;Lcom/box/android/domain/models/item/FileModel;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveFromChild", "childJobId", BoxRepresentation.FIELD_INFO, "", "(Lcom/box/android/domain/jobs/JobId;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "childSucceeded", "(Lcom/box/android/domain/jobs/JobId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "childFailed", "domainError", "Lcom/box/android/domain/models/DomainError;", "(Lcom/box/android/domain/jobs/JobId;Lcom/box/android/domain/models/DomainError;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "childProgressed", "currentProgress", "", "estimatedWork", "(Lcom/box/android/domain/jobs/JobId;DDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentRunningInfo", "Lcom/box/android/data/jobs/DownloadSessionInfo;", "getFileModel", "copyChunkToFile", "chunkUri", "sha1VerificationSuccessful", "", "getUniqueDestinationFile", BoxCommonConstants.EXTRA_FILE_NAME, "getDownloadSessionInfo", "byteArray", "getDownloadInfoByteArray", "downloadSessionInfo", "getChunkData", "Lcom/box/android/data/jobs/ChunkData;", "getChunkTempFile", "jobUriPair", "Lkotlin/Pair;", "", "cleanup", "shouldBeRemovedFromDbOnSuccess", "getJobDisplayInfoProvider", "Lcom/box/android/domain/models/IJobDisplayInfoProvider;", "shouldDisplay", "getAmplitudeJobType", "getAmplitudeInfos", "", "", "Companion", "Factory", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DownloadFileJob implements ParentJob, DisplayableJob, MetricsInfoProvider {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String FILE_ID_PARAM = "FileIdParam";
    public static final String FILE_NAME_PARAM = "fileNameParam";
    public static final String FILE_SHA1_PARAM = "fileSha1Param";
    public static final String TARGET_FOLDER_URI_PARAM = "TargetFileUriParam";
    private final Context appContext;
    private final IBoxStorage boxStorage;
    private final DownloadFileService downloadFileService;
    private final Data inputData;
    private final IRemoteItemService itemService;
    private final JobId jobId;
    private final JobService jobService;
    private final Moshi moshi;
    private final Mutex mutex;
    private final SharedLinkService sharedLinkService;
    private final String targetFileDeletionError;

    /* JADX INFO: compiled from: DownloadFileJob.kt */
    @AssistedFactory
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/box/android/data/jobs/DownloadFileJob$Factory;", "", "createJob", "Lcom/box/android/data/jobs/DownloadFileJob;", JobWorker.JOB_ID_PARAM, "Lcom/box/android/domain/jobs/JobId;", "inputData", "Landroidx/work/Data;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface Factory {
        DownloadFileJob createJob(JobId jobId, Data inputData);
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.DownloadFileJob$childSucceeded$1, reason: invalid class name */
    /* JADX INFO: compiled from: DownloadFileJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.DownloadFileJob", f = "DownloadFileJob.kt", i = {0, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9}, l = {290, 290, 628, BoxCommonConstants.REQUEST_CHOOSE_REMOTE_UPLOAD_DIR, BoxCommonConstants.REQUEST_DISABLE_DOWNLOADS, 304, 314, BoxRequestsFile.DownloadThumbnail.SIZE_320, 322, 327}, m = "childSucceeded", n = {"childJobId", "childJobId", "childJobId", "fileModel", "$this$withLock_u24default$iv", "$i$f$withLock", "childJobId", "fileModel", "$this$withLock_u24default$iv", "$i$f$withLock", "$i$a$-withLock$default-DownloadFileJob$childSucceeded$2", "childJobId", "fileModel", "$this$withLock_u24default$iv", "$i$f$withLock", "$i$a$-withLock$default-DownloadFileJob$childSucceeded$2", "childJobId", "fileModel", "$this$withLock_u24default$iv", BoxCommonConstants.EXTRA_FILE_NAME, "sessionInfo", "$i$f$withLock", "$i$a$-withLock$default-DownloadFileJob$childSucceeded$2", "childJobId", "fileModel", "$this$withLock_u24default$iv", BoxCommonConstants.EXTRA_FILE_NAME, "sessionInfo", "targetFile", "$i$f$withLock", "$i$a$-withLock$default-DownloadFileJob$childSucceeded$2", "childJobId", "fileModel", "$this$withLock_u24default$iv", BoxCommonConstants.EXTRA_FILE_NAME, "sessionInfo", "targetFile", "$i$f$withLock", "$i$a$-withLock$default-DownloadFileJob$childSucceeded$2", "childJobId", "fileModel", "$this$withLock_u24default$iv", BoxCommonConstants.EXTRA_FILE_NAME, "sessionInfo", "$i$f$withLock", "$i$a$-withLock$default-DownloadFileJob$childSucceeded$2", "childJobId", "fileModel", "$this$withLock_u24default$iv", BoxCommonConstants.EXTRA_FILE_NAME, "sessionInfo", "$i$f$withLock", "$i$a$-withLock$default-DownloadFileJob$childSucceeded$2"}, s = {"L$0", "L$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DownloadFileJob.this.childSucceeded(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.DownloadFileJob$cleanup$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DownloadFileJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.DownloadFileJob", f = "DownloadFileJob.kt", i = {1, 1}, l = {410, 411}, m = "cleanup", n = {"sessionInfo", "$i$a$-also-DownloadFileJob$cleanup$2"}, s = {"L$1", "I$0"}, v = 1)
    static final class C12461 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C12461(Continuation<? super C12461> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DownloadFileJob.this.cleanup(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.DownloadFileJob$downloadSmallFile$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DownloadFileJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.DownloadFileJob", f = "DownloadFileJob.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {178, 179}, m = "downloadSmallFile", n = {"fileId", "fileModel", "targetFile", "sharedLinkHeader", "fileId", "fileModel", "targetFile", "sharedLinkHeader", "progressWrapper"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4"}, v = 1)
    static final class C12471 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C12471(Continuation<? super C12471> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DownloadFileJob.this.downloadSmallFile(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.DownloadFileJob$enqueueChildJobs$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DownloadFileJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.DownloadFileJob", f = "DownloadFileJob.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5}, l = {227, PsExtractor.VIDEO_STREAM_MASK, 241, 253, 261, 263}, m = "enqueueChildJobs", n = {"fileId", "fileModel", "sharedLinkHeader", "childRequest", "chunkSize", "offset", "fileId", "fileModel", "sharedLinkHeader", "childRequest", "chunkSize", "offset", "fileId", "fileModel", "sharedLinkHeader", "childRequest", "it", "chunkSize", "offset", "$i$a$-also-DownloadFileJob$enqueueChildJobs$2", "fileId", "fileModel", "sharedLinkHeader", "childRequest", "chunkSize", "offset", "fileId", "fileModel", "sharedLinkHeader", "childRequest", "chunkSize", "offset", "fileId", "fileModel", "sharedLinkHeader", "chunkSize"}, s = {"L$0", "L$1", "L$2", "L$3", "J$0", "J$1", "L$0", "L$1", "L$2", "L$3", "J$0", "J$1", "L$0", "L$1", "L$2", "L$3", "L$5", "J$0", "J$1", "I$0", "L$0", "L$1", "L$2", "L$3", "J$0", "J$1", "L$0", "L$1", "L$2", "L$3", "J$0", "J$1", "L$0", "L$1", "L$2", "J$0"}, v = 1)
    static final class C12481 extends ContinuationImpl {
        int I$0;
        long J$0;
        long J$1;
        long J$2;
        long J$3;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C12481(Continuation<? super C12481> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DownloadFileJob.this.enqueueChildJobs(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.DownloadFileJob$getAmplitudeInfos$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DownloadFileJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.DownloadFileJob", f = "DownloadFileJob.kt", i = {}, l = {441}, m = "getAmplitudeInfos", n = {}, s = {}, v = 1)
    static final class C12491 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C12491(Continuation<? super C12491> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DownloadFileJob.this.getAmplitudeInfos(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.DownloadFileJob$getCurrentRunningInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DownloadFileJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.DownloadFileJob", f = "DownloadFileJob.kt", i = {}, l = {350}, m = "getCurrentRunningInfo", n = {}, s = {}, v = 1)
    static final class C12501 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C12501(Continuation<? super C12501> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DownloadFileJob.this.getCurrentRunningInfo(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.DownloadFileJob$getFileModel$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DownloadFileJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.DownloadFileJob", f = "DownloadFileJob.kt", i = {}, l = {355}, m = "getFileModel", n = {}, s = {}, v = 1)
    static final class C12511 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C12511(Continuation<? super C12511> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DownloadFileJob.this.getFileModel(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.DownloadFileJob$receiveFromChild$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DownloadFileJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.DownloadFileJob", f = "DownloadFileJob.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3}, l = {628, 268, 269, 276}, m = "receiveFromChild", n = {"childJobId", BoxRepresentation.FIELD_INFO, "$this$withLock_u24default$iv", "$i$f$withLock", "childJobId", BoxRepresentation.FIELD_INFO, "$this$withLock_u24default$iv", "$i$f$withLock", "$i$a$-withLock$default-DownloadFileJob$receiveFromChild$2", "childJobId", BoxRepresentation.FIELD_INFO, "$this$withLock_u24default$iv", "$i$f$withLock", "$i$a$-withLock$default-DownloadFileJob$receiveFromChild$2", "childJobId", BoxRepresentation.FIELD_INFO, "$this$withLock_u24default$iv", "sessionInfo", "chunk", "$i$f$withLock", "$i$a$-withLock$default-DownloadFileJob$receiveFromChild$2", "$i$a$-also-DownloadFileJob$receiveFromChild$2$1"}, s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "L$4", "L$5", "I$0", "I$1", "I$2"}, v = 1)
    static final class C12521 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C12521(Continuation<? super C12521> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DownloadFileJob.this.receiveFromChild(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.DownloadFileJob$start$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DownloadFileJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.DownloadFileJob", f = "DownloadFileJob.kt", i = {0, 1, 2, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10}, l = {120, 128, 128, 134, Token.DOTQUERY, Token.XMLEND, Token.LET, Token.CONST, Token.METHOD, Token.YIELD_STAR, 168}, m = "start", n = {"itemId", "itemId", "itemId", "itemId", "fileModel", "itemId", "fileModel", BoxCommonConstants.EXTRA_FILE_NAME, "destFile", "$i$a$-also-DownloadFileJob$start$targetFile$1", "itemId", "fileModel", BoxCommonConstants.EXTRA_FILE_NAME, "itemId", "fileModel", BoxCommonConstants.EXTRA_FILE_NAME, "targetFile", "itemId", "fileModel", BoxCommonConstants.EXTRA_FILE_NAME, "targetFile", "itemId", "fileModel", BoxCommonConstants.EXTRA_FILE_NAME, "targetFile", "itemId", "fileModel", BoxCommonConstants.EXTRA_FILE_NAME, "targetFile", "sharedLinkHeader", "itemId", "fileModel", BoxCommonConstants.EXTRA_FILE_NAME, "targetFile", "sharedLinkHeader"}, s = {"L$0", "L$0", "L$0", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"}, v = 1)
    static final class C12531 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C12531(Continuation<? super C12531> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DownloadFileJob.this.start(this);
        }
    }

    @AssistedInject
    public DownloadFileJob(DownloadFileService downloadFileService, IRemoteItemService itemService, IBoxStorage boxStorage, Moshi moshi, SharedLinkService sharedLinkService, @Assisted JobId jobId, @Assisted Data inputData, Context appContext, JobService jobService) {
        Intrinsics.checkNotNullParameter(downloadFileService, "downloadFileService");
        Intrinsics.checkNotNullParameter(itemService, "itemService");
        Intrinsics.checkNotNullParameter(boxStorage, "boxStorage");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Intrinsics.checkNotNullParameter(sharedLinkService, "sharedLinkService");
        Intrinsics.checkNotNullParameter(jobId, "jobId");
        Intrinsics.checkNotNullParameter(inputData, "inputData");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(jobService, "jobService");
        this.downloadFileService = downloadFileService;
        this.itemService = itemService;
        this.boxStorage = boxStorage;
        this.moshi = moshi;
        this.sharedLinkService = sharedLinkService;
        this.jobId = jobId;
        this.inputData = inputData;
        this.appContext = appContext;
        this.jobService = jobService;
        this.mutex = MutexKt.Mutex$default(false, 1, null);
        this.targetFileDeletionError = "Unable to delete target file upon failure";
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
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/box/android/data/jobs/DownloadFileJob$Companion;", "", "<init>", "()V", "FILE_ID_PARAM", "", "TARGET_FOLDER_URI_PARAM", "FILE_NAME_PARAM", "FILE_SHA1_PARAM", "getRequest", "Lcom/box/android/domain/jobs/JobRequest;", "itemId", "Lcom/box/android/domain/models/ItemId$Remote;", "name", "sha1", "destFolderUri", "tags", "", JobConstants.SHOULD_DISPLAY_JOB, "", JobConstants.SHOW_NOTIFICATION, "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ JobRequest getRequest$default(Companion companion, ItemId.Remote remote, String str, String str2, String str3, Set set, boolean z, boolean z2, int i, Object obj) {
            if ((i & 32) != 0) {
                z = true;
            }
            if ((i & 64) != 0) {
                z2 = true;
            }
            return companion.getRequest(remote, str, str2, str3, set, z, z2);
        }

        public final JobRequest getRequest(ItemId.Remote itemId, String name, String sha1, String destFolderUri, Set<String> tags, boolean shouldDisplayJob, boolean showNotification) {
            Intrinsics.checkNotNullParameter(itemId, "itemId");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(sha1, "sha1");
            Intrinsics.checkNotNullParameter(destFolderUri, "destFolderUri");
            Intrinsics.checkNotNullParameter(tags, "tags");
            JobRequest.Builder builder = new JobRequest.Builder(JobType.DOWNLOAD_FILE, null, null, null, 14, null);
            Data.Builder builder2 = new Data.Builder();
            builder2.putString("FileIdParam", itemId.getBoxId());
            builder2.putString(DownloadFileJob.TARGET_FOLDER_URI_PARAM, destFolderUri);
            builder2.putString(DownloadFileJob.FILE_NAME_PARAM, name);
            builder2.putString(DownloadFileJob.FILE_SHA1_PARAM, sha1);
            builder2.putBoolean(JobConstants.SHOULD_DISPLAY_JOB, shouldDisplayJob);
            builder2.putBoolean(JobConstants.SHOW_NOTIFICATION, showNotification);
            builder.setData(builder2.build());
            builder.setTags(SetsKt.plus(SetsKt.setOf("{download_file_job:" + itemId.getBoxId()), (Iterable) tags));
            return builder.build();
        }
    }

    public final String getTargetFileDeletionError() {
        return this.targetFileDeletionError;
    }

    public final File targetFolder() {
        String string = this.inputData.getString(TARGET_FOLDER_URI_PARAM);
        Intrinsics.checkNotNull(string);
        return new File(string);
    }

    /* JADX WARN: Code duplicated, block: B:39:0x013c  */
    /* JADX WARN: Code duplicated, block: B:44:0x015d  */
    /* JADX WARN: Code duplicated, block: B:46:0x0167  */
    /* JADX WARN: Code duplicated, block: B:51:0x018e  */
    /* JADX WARN: Code duplicated, block: B:53:0x019f  */
    /* JADX WARN: Code duplicated, block: B:62:0x01da  */
    /* JADX WARN: Code duplicated, block: B:65:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:68:0x0222  */
    /* JADX WARN: Code duplicated, block: B:72:0x0245 A[PHI: r1 r2 r3 r5
      0x0245: PHI (r1v27 java.io.File) = (r1v24 java.io.File), (r1v29 java.io.File) binds: [B:70:0x0241, B:15:0x0078] A[DONT_GENERATE, DONT_INLINE]
      0x0245: PHI (r2v11 java.lang.String) = (r2v8 java.lang.String), (r2v13 java.lang.String) binds: [B:70:0x0241, B:15:0x0078] A[DONT_GENERATE, DONT_INLINE]
      0x0245: PHI (r3v8 com.box.android.domain.models.item.FileModel) = (r3v5 com.box.android.domain.models.item.FileModel), (r3v10 com.box.android.domain.models.item.FileModel) binds: [B:70:0x0241, B:15:0x0078] A[DONT_GENERATE, DONT_INLINE]
      0x0245: PHI (r5v8 com.box.android.domain.models.ItemId$Remote) = (r5v5 com.box.android.domain.models.ItemId$Remote), (r5v10 com.box.android.domain.models.ItemId$Remote) binds: [B:70:0x0241, B:15:0x0078] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:75:0x0263 A[PHI: r1 r2 r3 r5 r12
      0x0263: PHI (r1v30 java.io.File) = (r1v27 java.io.File), (r1v34 java.io.File) binds: [B:73:0x025f, B:14:0x0063] A[DONT_GENERATE, DONT_INLINE]
      0x0263: PHI (r2v14 java.lang.String) = (r2v11 java.lang.String), (r2v22 java.lang.String) binds: [B:73:0x025f, B:14:0x0063] A[DONT_GENERATE, DONT_INLINE]
      0x0263: PHI (r3v11 com.box.android.domain.models.item.FileModel) = (r3v8 com.box.android.domain.models.item.FileModel), (r3v13 com.box.android.domain.models.item.FileModel) binds: [B:73:0x025f, B:14:0x0063] A[DONT_GENERATE, DONT_INLINE]
      0x0263: PHI (r5v11 com.box.android.domain.models.ItemId$Remote) = (r5v8 com.box.android.domain.models.ItemId$Remote), (r5v15 com.box.android.domain.models.ItemId$Remote) binds: [B:73:0x025f, B:14:0x0063] A[DONT_GENERATE, DONT_INLINE]
      0x0263: PHI (r12v24 java.lang.Object) = (r12v23 java.lang.Object), (r12v1 java.lang.Object) binds: [B:73:0x025f, B:14:0x0063] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:77:0x0274  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code duplicated, block: B:82:0x02a5  */
    /* JADX WARN: Code duplicated, block: B:87:0x02d6  */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0124, code lost:
    
        if (r12.jobFailed(r11, com.box.android.domain.jobs.JobType.DOWNLOAD_FILE, r5, r4) == r0) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0156, code lost:
    
        if (r12.jobFailed(r11, com.box.android.domain.jobs.JobType.DOWNLOAD_FILE, r1, r4) == r0) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0187, code lost:
    
        if (r1.jobFailed(r11, com.box.android.domain.jobs.JobType.DOWNLOAD_FILE, r6, r4) == r0) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x01d3, code lost:
    
        if (r1.jobSucceeded(r11, r4) == r0) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x029f, code lost:
    
        if (downloadSmallFile(r5, r3, r1, r12, r4) == r0) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x02d0, code lost:
    
        if (enqueueChildJobs(r11, r3, r12, r4) == r0) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x02fd, code lost:
    
        if (r11.jobFailed(r1, com.box.android.domain.jobs.JobType.DOWNLOAD_FILE, r6, r4) == r0) goto L89;
     */
    @Override // com.box.android.data.jobs.Job
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object start(kotlin.coroutines.Continuation<? super kotlin.Unit> r12) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 800
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.DownloadFileJob.start(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00bf, code lost:
    
        if (kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r1, r7) == r0) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object downloadSmallFile(com.box.android.domain.models.ItemId.Remote r10, com.box.android.domain.models.item.FileModel r11, java.io.File r12, java.lang.String r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            r9 = this;
            boolean r0 = r14 instanceof com.box.android.data.jobs.DownloadFileJob.C12471
            if (r0 == 0) goto L14
            r0 = r14
            com.box.android.data.jobs.DownloadFileJob$downloadSmallFile$1 r0 = (com.box.android.data.jobs.DownloadFileJob.C12471) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L19
        L14:
            com.box.android.data.jobs.DownloadFileJob$downloadSmallFile$1 r0 = new com.box.android.data.jobs.DownloadFileJob$downloadSmallFile$1
            r0.<init>(r14)
        L19:
            r7 = r0
            java.lang.Object r14 = r7.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r8 = 2
            r2 = 1
            if (r1 == 0) goto L63
            if (r1 == r2) goto L4b
            if (r1 != r8) goto L43
            java.lang.Object r9 = r7.L$4
            com.box.android.domain.utils.result.ResultProgressWrapper r9 = (com.box.android.domain.utils.result.ResultProgressWrapper) r9
            java.lang.Object r9 = r7.L$3
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r9 = r7.L$2
            java.io.File r9 = (java.io.File) r9
            java.lang.Object r9 = r7.L$1
            com.box.android.domain.models.item.FileModel r9 = (com.box.android.domain.models.item.FileModel) r9
            java.lang.Object r9 = r7.L$0
            com.box.android.domain.models.ItemId$Remote r9 = (com.box.android.domain.models.ItemId.Remote) r9
            kotlin.ResultKt.throwOnFailure(r14)
            goto Lc2
        L43:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L4b:
            java.lang.Object r10 = r7.L$3
            r13 = r10
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r10 = r7.L$2
            r12 = r10
            java.io.File r12 = (java.io.File) r12
            java.lang.Object r10 = r7.L$1
            r11 = r10
            com.box.android.domain.models.item.FileModel r11 = (com.box.android.domain.models.item.FileModel) r11
            java.lang.Object r10 = r7.L$0
            com.box.android.domain.models.ItemId$Remote r10 = (com.box.android.domain.models.ItemId.Remote) r10
            kotlin.ResultKt.throwOnFailure(r14)
            r5 = r12
            goto L8e
        L63:
            kotlin.ResultKt.throwOnFailure(r14)
            com.box.android.data.service.impl.DownloadFileService r1 = r9.downloadFileService
            java.lang.Long r14 = r11.getSize()
            long r3 = r14.longValue()
            java.lang.Object r14 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r7.L$0 = r14
            r7.L$1 = r11
            r7.L$2 = r12
            java.lang.Object r14 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r13)
            r7.L$3 = r14
            r7.label = r2
            r2 = r10
            r5 = r12
            r6 = r13
            java.lang.Object r14 = r1.downloadFile(r2, r3, r5, r6, r7)
            if (r14 != r0) goto L8c
            goto Lc1
        L8c:
            r10 = r2
            r13 = r6
        L8e:
            r3 = r11
            r4 = r14
            com.box.android.domain.utils.result.ResultProgressWrapper r4 = (com.box.android.domain.utils.result.ResultProgressWrapper) r4
            com.box.android.data.jobs.DownloadFileJob$downloadSmallFile$2 r1 = new com.box.android.data.jobs.DownloadFileJob$downloadSmallFile$2
            r6 = 0
            r2 = r9
            r1.<init>(r3, r4, r5, r6)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r7.L$0 = r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3)
            r7.L$1 = r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
            r7.L$2 = r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r13)
            r7.L$3 = r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r4)
            r7.L$4 = r9
            r7.label = r8
            java.lang.Object r9 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r1, r7)
            if (r9 != r0) goto Lc2
        Lc1:
            return r0
        Lc2:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.DownloadFileJob.downloadSmallFile(com.box.android.domain.models.ItemId$Remote, com.box.android.domain.models.item.FileModel, java.io.File, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object downloadSmallFile$default(DownloadFileJob downloadFileJob, ItemId.Remote remote, FileModel fileModel, File file, String str, Continuation continuation, int i, Object obj) {
        if ((i & 8) != 0) {
            str = null;
        }
        return downloadFileJob.downloadSmallFile(remote, fileModel, file, str, continuation);
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.DownloadFileJob$downloadSmallFile$2, reason: invalid class name */
    /* JADX INFO: compiled from: DownloadFileJob.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.DownloadFileJob$downloadSmallFile$2", f = "DownloadFileJob.kt", i = {0, 1, 1, 2, 2, 2}, l = {180, 191, 192}, m = "invokeSuspend", n = {"$this$coroutineScope", "$this$coroutineScope", "progressFlowJob", "$this$coroutineScope", "progressFlowJob", ReactNativeFeatureActivity.RESULT_EXTRA_KEY}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {
        final /* synthetic */ FileModel $fileModel;
        final /* synthetic */ ResultProgressWrapper<Unit, DomainError, Progress> $progressWrapper;
        final /* synthetic */ File $targetFile;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(FileModel fileModel, ResultProgressWrapper<Unit, DomainError, Progress> resultProgressWrapper, File file, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$fileModel = fileModel;
            this.$progressWrapper = resultProgressWrapper;
            this.$targetFile = file;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = DownloadFileJob.this.new AnonymousClass2(this.$fileModel, this.$progressWrapper, this.$targetFile, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Object> continuation) {
            return invoke2(coroutineScope, (Continuation<Object>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<Object> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:23:0x00c9 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlinx.coroutines.Job jobLaunch$default;
            Object objFirst;
            Object objWithContext;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.L$0 = coroutineScope;
                this.label = 1;
                if (DownloadFileJob.this.getJobService().networkTaskStarting(DownloadFileJob.this.getJobId(), this.$fileModel.getSize().longValue(), this) != coroutine_suspended) {
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
                objFirst = obj;
            }
            kotlinx.coroutines.Job job = jobLaunch$default;
            Intrinsics.checkNotNull(objFirst);
            Result result = (Result) objFirst;
            this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
            this.L$1 = SpillingKt.nullOutSpilledVariable(job);
            this.L$2 = SpillingKt.nullOutSpilledVariable(result);
            this.label = 3;
            objWithContext = BuildersKt.withContext(NonCancellable.INSTANCE, new AnonymousClass1(result, job, DownloadFileJob.this, this.$targetFile, this.$fileModel, null), this);
            if (objWithContext != coroutine_suspended) {
                return coroutine_suspended;
            }
            return objWithContext;
            jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new DownloadFileJob$downloadSmallFile$2$progressFlowJob$1(this.$progressWrapper, DownloadFileJob.this, this.$fileModel, null), 3, null);
            this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
            this.L$1 = jobLaunch$default;
            this.label = 2;
            objFirst = FlowKt.first(this.$progressWrapper.getResult(), this);
            if (objFirst != coroutine_suspended) {
                kotlinx.coroutines.Job job2 = jobLaunch$default;
                Intrinsics.checkNotNull(objFirst);
                Result result2 = (Result) objFirst;
                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.L$1 = SpillingKt.nullOutSpilledVariable(job2);
                this.L$2 = SpillingKt.nullOutSpilledVariable(result2);
                this.label = 3;
                objWithContext = BuildersKt.withContext(NonCancellable.INSTANCE, new AnonymousClass1(result2, job2, DownloadFileJob.this, this.$targetFile, this.$fileModel, null), this);
                if (objWithContext != coroutine_suspended) {
                    return objWithContext;
                }
            }
            return coroutine_suspended;
        }

        /* JADX INFO: renamed from: com.box.android.data.jobs.DownloadFileJob$downloadSmallFile$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: DownloadFileJob.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.data.jobs.DownloadFileJob$downloadSmallFile$2$1", f = "DownloadFileJob.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {197, 203, 208}, m = "invokeSuspend", n = {"$this$withContext", "$this$onSuccess$iv", "it", "$i$f$onSuccess", "$i$a$-onSuccess-DownloadFileJob$downloadSmallFile$2$1$1", "$this$withContext", "$this$onSuccess$iv", "it", "$i$f$onSuccess", "$i$a$-onSuccess-DownloadFileJob$downloadSmallFile$2$1$1", "$this$withContext", "$this$onError$iv", "it", "$i$f$onError", "$i$a$-onError-DownloadFileJob$downloadSmallFile$2$1$2"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$4", "I$0", "I$1"}, v = 1)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {
            final /* synthetic */ FileModel $fileModel;
            final /* synthetic */ kotlinx.coroutines.Job $progressFlowJob;
            final /* synthetic */ Result<Unit, DomainError> $result;
            final /* synthetic */ File $targetFile;
            int I$0;
            int I$1;
            private /* synthetic */ Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            int label;
            final /* synthetic */ DownloadFileJob this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(Result<Unit, ? extends DomainError> result, kotlinx.coroutines.Job job, DownloadFileJob downloadFileJob, File file, FileModel fileModel, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$result = result;
                this.$progressFlowJob = job;
                this.this$0 = downloadFileJob;
                this.$targetFile = file;
                this.$fileModel = fileModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$result, this.$progressFlowJob, this.this$0, this.$targetFile, this.$fileModel, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Object> continuation) {
                return invoke2(coroutineScope, (Continuation<Object>) continuation);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope coroutineScope, Continuation<Object> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code duplicated, block: B:38:0x0133  */
            /* JADX WARN: Code restructure failed: missing block: B:19:0x009c, code lost:
            
                if (r2.jobFailed(r4, com.box.android.domain.jobs.JobType.DOWNLOAD_FILE, r6, r14) == r1) goto L34;
             */
            /* JADX WARN: Code restructure failed: missing block: B:22:0x00c4, code lost:
            
                if (r2.jobSucceeded(r5, r14) == r1) goto L34;
             */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r15) {
                /*
                    Method dump skipped, instruction units count: 327
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.DownloadFileJob.AnonymousClass2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:29:0x0157  */
    /* JADX WARN: Code duplicated, block: B:32:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:50:0x02cb  */
    /* JADX WARN: Code duplicated, block: B:53:0x02db  */
    /* JADX WARN: Code duplicated, block: B:69:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x02cb -> B:14:0x0068). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object enqueueChildJobs(com.box.android.domain.models.ItemId.Remote r33, com.box.android.domain.models.item.FileModel r34, java.lang.String r35, kotlin.coroutines.Continuation<? super kotlin.Unit> r36) {
        /*
            Method dump skipped, instruction units count: 872
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.DownloadFileJob.enqueueChildJobs(com.box.android.domain.models.ItemId$Remote, com.box.android.domain.models.item.FileModel, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00df A[Catch: all -> 0x008e, TRY_LEAVE, TryCatch #2 {all -> 0x008e, blocks: (B:25:0x008a, B:38:0x00da, B:40:0x00df, B:47:0x0110), top: B:60:0x008a }] */
    /* JADX WARN: Code duplicated, block: B:43:0x0109  */
    /* JADX WARN: Code duplicated, block: B:47:0x0110 A[Catch: all -> 0x008e, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x008e, blocks: (B:25:0x008a, B:38:0x00da, B:40:0x00df, B:47:0x0110), top: B:60:0x008a }] */
    /* JADX WARN: Code duplicated, block: B:50:0x016e  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r22v0, types: [com.box.android.data.jobs.DownloadFileJob] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v1, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v7 */
    @Override // com.box.android.data.jobs.ParentJob
    public Object receiveFromChild(JobId jobId, byte[] bArr, Continuation<? super Unit> continuation) throws Throwable {
        C12521 c12521;
        Mutex mutex;
        byte[] bArr2;
        JobId jobId2;
        int i;
        Mutex mutex2;
        int i2;
        int i3;
        DownloadSessionInfo downloadSessionInfo;
        JobService jobService;
        byte[] downloadInfoByteArray;
        JobId jobId3;
        Mutex mutex3;
        JobService jobService2;
        DomainError.CacheReadError cacheReadError;
        Mutex mutex4;
        if (continuation instanceof C12521) {
            c12521 = (C12521) continuation;
            if ((c12521.label & Integer.MIN_VALUE) != 0) {
                c12521.label -= Integer.MIN_VALUE;
            } else {
                c12521 = new C12521(continuation);
            }
        } else {
            c12521 = new C12521(continuation);
        }
        Object obj = c12521.result;
        ?? coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = c12521.label;
        try {
            try {
                if (i4 == 0) {
                    ResultKt.throwOnFailure(obj);
                    mutex = this.mutex;
                    c12521.L$0 = jobId;
                    bArr2 = bArr;
                    c12521.L$1 = bArr2;
                    c12521.L$2 = mutex;
                    c12521.I$0 = 0;
                    c12521.label = 1;
                    if (mutex.lock(null, c12521) != coroutine_suspended) {
                        jobId2 = jobId;
                        i = 0;
                    }
                    return coroutine_suspended;
                }
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 == 3) {
                            int i5 = c12521.I$1;
                            int i6 = c12521.I$0;
                            mutex4 = (Mutex) c12521.L$2;
                            ResultKt.throwOnFailure(obj);
                            Unit unit = Unit.INSTANCE;
                            mutex4.unlock(null);
                            return unit;
                        }
                        if (i4 != 4) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i7 = c12521.I$2;
                        int i8 = c12521.I$1;
                        int i9 = c12521.I$0;
                        mutex3 = (Mutex) c12521.L$2;
                        ResultKt.throwOnFailure(obj);
                        mutex3.unlock(null);
                        return Unit.INSTANCE;
                    }
                    i3 = c12521.I$1;
                    i2 = c12521.I$0;
                    mutex2 = (Mutex) c12521.L$2;
                    bArr2 = (byte[]) c12521.L$1;
                    jobId2 = (JobId) c12521.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        downloadSessionInfo = (DownloadSessionInfo) obj;
                        if (downloadSessionInfo == null) {
                            jobService2 = getJobService();
                            cacheReadError = new DomainError.CacheReadError("fail to get running info for receive from child");
                            c12521.L$0 = SpillingKt.nullOutSpilledVariable(jobId2);
                            c12521.L$1 = SpillingKt.nullOutSpilledVariable(bArr2);
                            c12521.L$2 = mutex2;
                            c12521.I$0 = i2;
                            c12521.I$1 = i3;
                            c12521.label = 3;
                            if (jobService2.jobFailed(jobId2, JobType.DOWNLOAD_FILE, cacheReadError, c12521) != coroutine_suspended) {
                                mutex4 = mutex2;
                                Unit unit2 = Unit.INSTANCE;
                                mutex4.unlock(null);
                                return unit2;
                            }
                        } else {
                            ChunkData chunkData = getChunkData(bArr2);
                            jobService = getJobService();
                            downloadInfoByteArray = getDownloadInfoByteArray(DownloadSessionInfo.copy$default(downloadSessionInfo, SetsKt.minus(downloadSessionInfo.getChunksToDownload(), Boxing.boxLong(chunkData.getOffset())), null, SetsKt.plus(downloadSessionInfo.getSucceededChunks(), chunkData), null, 0L, 26, null));
                            jobId3 = this.jobId;
                            c12521.L$0 = SpillingKt.nullOutSpilledVariable(jobId2);
                            c12521.L$1 = SpillingKt.nullOutSpilledVariable(bArr2);
                            c12521.L$2 = mutex2;
                            c12521.L$3 = chunkData;
                            c12521.L$4 = SpillingKt.nullOutSpilledVariable(downloadSessionInfo);
                            c12521.L$5 = SpillingKt.nullOutSpilledVariable(chunkData);
                            c12521.I$0 = i2;
                            c12521.I$1 = i3;
                            c12521.I$2 = 0;
                            c12521.label = 4;
                            if (jobService.updateRunningInfo(downloadInfoByteArray, jobId3, c12521) != coroutine_suspended) {
                                mutex3 = mutex2;
                                mutex3.unlock(null);
                                return Unit.INSTANCE;
                            }
                        }
                        return coroutine_suspended;
                    } catch (Throwable th) {
                        th = th;
                        coroutine_suspended = mutex2;
                        coroutine_suspended.unlock(null);
                        throw th;
                    }
                }
                i = c12521.I$0;
                Mutex mutex5 = (Mutex) c12521.L$2;
                bArr2 = (byte[]) c12521.L$1;
                jobId2 = (JobId) c12521.L$0;
                ResultKt.throwOnFailure(obj);
                mutex = mutex5;
                c12521.L$0 = jobId2;
                c12521.L$1 = bArr2;
                c12521.L$2 = mutex;
                c12521.I$0 = i;
                c12521.I$1 = 0;
                c12521.label = 2;
                Object currentRunningInfo = getCurrentRunningInfo(c12521);
                if (currentRunningInfo != coroutine_suspended) {
                    mutex2 = mutex;
                    obj = currentRunningInfo;
                    i2 = i;
                    i3 = 0;
                    downloadSessionInfo = (DownloadSessionInfo) obj;
                    if (downloadSessionInfo == null) {
                        jobService2 = getJobService();
                        cacheReadError = new DomainError.CacheReadError("fail to get running info for receive from child");
                        c12521.L$0 = SpillingKt.nullOutSpilledVariable(jobId2);
                        c12521.L$1 = SpillingKt.nullOutSpilledVariable(bArr2);
                        c12521.L$2 = mutex2;
                        c12521.I$0 = i2;
                        c12521.I$1 = i3;
                        c12521.label = 3;
                        if (jobService2.jobFailed(jobId2, JobType.DOWNLOAD_FILE, cacheReadError, c12521) != coroutine_suspended) {
                            mutex4 = mutex2;
                            Unit unit3 = Unit.INSTANCE;
                            mutex4.unlock(null);
                            return unit3;
                        }
                    } else {
                        ChunkData chunkData2 = getChunkData(bArr2);
                        jobService = getJobService();
                        downloadInfoByteArray = getDownloadInfoByteArray(DownloadSessionInfo.copy$default(downloadSessionInfo, SetsKt.minus(downloadSessionInfo.getChunksToDownload(), Boxing.boxLong(chunkData2.getOffset())), null, SetsKt.plus(downloadSessionInfo.getSucceededChunks(), chunkData2), null, 0L, 26, null));
                        jobId3 = this.jobId;
                        c12521.L$0 = SpillingKt.nullOutSpilledVariable(jobId2);
                        c12521.L$1 = SpillingKt.nullOutSpilledVariable(bArr2);
                        c12521.L$2 = mutex2;
                        c12521.L$3 = chunkData2;
                        c12521.L$4 = SpillingKt.nullOutSpilledVariable(downloadSessionInfo);
                        c12521.L$5 = SpillingKt.nullOutSpilledVariable(chunkData2);
                        c12521.I$0 = i2;
                        c12521.I$1 = i3;
                        c12521.I$2 = 0;
                        c12521.label = 4;
                        if (jobService.updateRunningInfo(downloadInfoByteArray, jobId3, c12521) != coroutine_suspended) {
                            mutex3 = mutex2;
                            mutex3.unlock(null);
                            return Unit.INSTANCE;
                        }
                    }
                }
                return coroutine_suspended;
            } catch (Throwable th2) {
                th = th2;
                coroutine_suspended = mutex;
                coroutine_suspended.unlock(null);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:116:0x0344  */
    /* JADX WARN: Code duplicated, block: B:120:0x039c  */
    /* JADX WARN: Code duplicated, block: B:47:0x014b  */
    /* JADX WARN: Code duplicated, block: B:52:0x016c  */
    /* JADX WARN: Code duplicated, block: B:55:0x0181  */
    /* JADX WARN: Code duplicated, block: B:59:0x0198  */
    /* JADX WARN: Code duplicated, block: B:62:0x01a2 A[Catch: all -> 0x01d3, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x01d3, blocks: (B:62:0x01a2, B:73:0x01ed, B:75:0x01ff, B:77:0x0205, B:84:0x0242, B:85:0x0257, B:87:0x025d, B:88:0x026e, B:90:0x0274, B:92:0x027a, B:93:0x027f, B:100:0x02c2), top: B:139:0x01a0 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:71:0x01d8 A[Catch: all -> 0x03ae, TRY_ENTER, TRY_LEAVE, TryCatch #7 {all -> 0x03ae, blocks: (B:60:0x019e, B:71:0x01d8, B:107:0x02ff, B:113:0x033d), top: B:147:0x019e }] */
    /* JADX WARN: Code duplicated, block: B:73:0x01ed A[Catch: all -> 0x01d3, TRY_ENTER, TryCatch #1 {all -> 0x01d3, blocks: (B:62:0x01a2, B:73:0x01ed, B:75:0x01ff, B:77:0x0205, B:84:0x0242, B:85:0x0257, B:87:0x025d, B:88:0x026e, B:90:0x0274, B:92:0x027a, B:93:0x027f, B:100:0x02c2), top: B:139:0x01a0 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0165, code lost:
    
        if (r3.jobFailed(r0, com.box.android.domain.jobs.JobType.DOWNLOAD_FILE, r4, r9) == r2) goto L119;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 7, insn: 0x0108: MOVE (r2 I:??[OBJECT, ARRAY]) = (r7 I:??[OBJECT, ARRAY]), block:B:37:0x0108 */
    /* JADX WARN: Type inference failed for: r21v0, types: [com.box.android.data.jobs.DownloadFileJob] */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v6, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r2v9 */
    @Override // com.box.android.data.jobs.ParentJob
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object childSucceeded(com.box.android.domain.jobs.JobId r22, kotlin.coroutines.Continuation<? super kotlin.Unit> r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 978
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.DownloadFileJob.childSucceeded(com.box.android.domain.jobs.JobId, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.box.android.data.jobs.ParentJob
    public Object childFailed(JobId jobId, DomainError domainError, Continuation<? super Unit> continuation) throws Throwable {
        Object objJobFailed = getJobService().jobFailed(this.jobId, JobType.DOWNLOAD_FILE, domainError, continuation);
        return objJobFailed == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objJobFailed : Unit.INSTANCE;
    }

    @Override // com.box.android.data.jobs.ParentJob
    public Object childProgressed(JobId jobId, double d, double d2, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getCurrentRunningInfo(Continuation<? super DownloadSessionInfo> continuation) {
        C12501 c12501;
        if (continuation instanceof C12501) {
            c12501 = (C12501) continuation;
            if ((c12501.label & Integer.MIN_VALUE) != 0) {
                c12501.label -= Integer.MIN_VALUE;
            } else {
                c12501 = new C12501(continuation);
            }
        } else {
            c12501 = new C12501(continuation);
        }
        Object runningInfo = c12501.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c12501.label;
        if (i == 0) {
            ResultKt.throwOnFailure(runningInfo);
            JobService jobService = getJobService();
            JobId jobId = this.jobId;
            c12501.L$0 = this;
            c12501.label = 1;
            runningInfo = jobService.getRunningInfo(jobId, c12501);
            if (runningInfo == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this = (DownloadFileJob) c12501.L$0;
            ResultKt.throwOnFailure(runningInfo);
        }
        byte[] bArr = (byte[]) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) runningInfo);
        if (bArr == null) {
            return null;
        }
        return this.getDownloadSessionInfo(bArr);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getFileModel(Continuation<? super FileModel> continuation) {
        C12511 c12511;
        if (continuation instanceof C12511) {
            c12511 = (C12511) continuation;
            if ((c12511.label & Integer.MIN_VALUE) != 0) {
                c12511.label -= Integer.MIN_VALUE;
            } else {
                c12511 = new C12511(continuation);
            }
        } else {
            c12511 = new C12511(continuation);
        }
        Object objItem = c12511.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c12511.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objItem);
            IRemoteItemService iRemoteItemService = this.itemService;
            String string = this.inputData.getString("FileIdParam");
            if (string == null) {
                return null;
            }
            ItemId.Remote remote = new ItemId.Remote(string, ItemType.FILE);
            DataPolicy dataPolicy = DataPolicy.CACHE_OR_REMOTE;
            c12511.label = 1;
            objItem = iRemoteItemService.item(remote, dataPolicy, (Continuation<? super Result<? extends ItemModel, ? extends DomainError>>) c12511);
            if (objItem == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objItem);
        }
        ItemModel itemModel = (ItemModel) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) objItem);
        if (itemModel != null) {
            return ItemModelKt.fileModel(itemModel);
        }
        return null;
    }

    public final void copyChunkToFile(String chunkUri, File targetFile) {
        Intrinsics.checkNotNullParameter(chunkUri, "chunkUri");
        Intrinsics.checkNotNullParameter(targetFile, "targetFile");
        FilesKt.appendBytes(targetFile, FilesKt.readBytes(new File(chunkUri)));
    }

    public final boolean sha1VerificationSuccessful(File targetFile) {
        Intrinsics.checkNotNullParameter(targetFile, "targetFile");
        return Intrinsics.areEqual(FileExtensionsKt.computeFileSha1(targetFile), this.inputData.getString(FILE_SHA1_PARAM));
    }

    public final File getUniqueDestinationFile(String fileName) throws IOException {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        String strEscapeFileNameForSD = CommonBoxUtil.escapeFileNameForSD(fileName);
        String string = this.inputData.getString(TARGET_FOLDER_URI_PARAM);
        Intrinsics.checkNotNull(string);
        File file = new File(string);
        file.mkdirs();
        File file2 = new File(file, strEscapeFileNameForSD);
        String absolutePath = file2.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        String[] nameExtensionPath = CommonBoxUtil.getNameExtensionPath(absolutePath);
        int i = 1;
        while (file2.exists() && !sha1VerificationSuccessful(file2)) {
            String str = nameExtensionPath[2];
            if (str == null) {
                return null;
            }
            file2 = CommonBoxUtil.getEscapedFileForSD(new File(new File(str), nameExtensionPath[0] + CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR + i + "." + nameExtensionPath[1]));
            if (file2 == null) {
                return null;
            }
            i++;
        }
        return file2;
    }

    public final DownloadSessionInfo getDownloadSessionInfo(byte[] byteArray) throws IOException {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        Object objFromJson = this.moshi.adapter(DownloadSessionInfo.class).fromJson(new String(byteArray, Charsets.UTF_8));
        Intrinsics.checkNotNull(objFromJson);
        return (DownloadSessionInfo) objFromJson;
    }

    public final byte[] getDownloadInfoByteArray(DownloadSessionInfo downloadSessionInfo) {
        Intrinsics.checkNotNullParameter(downloadSessionInfo, "downloadSessionInfo");
        String json = this.moshi.adapter(DownloadSessionInfo.class).toJson(downloadSessionInfo);
        Intrinsics.checkNotNull(json);
        byte[] bytes = json.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return bytes;
    }

    public final ChunkData getChunkData(byte[] byteArray) throws IOException {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        Object objFromJson = this.moshi.adapter(ChunkData.class).fromJson(new String(byteArray, Charsets.UTF_8));
        Intrinsics.checkNotNull(objFromJson);
        return (ChunkData) objFromJson;
    }

    public final File getChunkTempFile(ItemId.Remote fileId, Pair<String, Long> jobUriPair) {
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        Intrinsics.checkNotNullParameter(jobUriPair, "jobUriPair");
        File pendingDownloadsDirectory = this.boxStorage.getPendingDownloadsDirectory();
        String first = jobUriPair.getFirst();
        return new File(pendingDownloadsDirectory, ((Object) first) + "_" + fileId.getBoxId() + "_" + jobUriPair.getSecond());
    }

    /* JADX WARN: Code duplicated, block: B:27:0x006a  */
    /* JADX WARN: Code duplicated, block: B:28:0x006f  */
    /* JADX WARN: Code duplicated, block: B:31:0x0074  */
    /* JADX WARN: Code duplicated, block: B:33:0x0079  */
    /* JADX WARN: Code duplicated, block: B:35:0x0096  */
    /* JADX WARN: Code duplicated, block: B:38:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:44:0x00c5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x00a2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.data.jobs.Job
    public Object cleanup(Continuation<? super Unit> continuation) {
        C12461 c12461;
        DownloadSessionInfo downloadSessionInfo;
        FileModel fileModel;
        ItemId itemId;
        ItemId.Remote remote;
        File chunkTempFile;
        if (continuation instanceof C12461) {
            c12461 = (C12461) continuation;
            if ((c12461.label & Integer.MIN_VALUE) != 0) {
                c12461.label -= Integer.MIN_VALUE;
            } else {
                c12461 = new C12461(continuation);
            }
        } else {
            c12461 = new C12461(continuation);
        }
        Object currentRunningInfo = c12461.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c12461.label;
        if (i == 0) {
            ResultKt.throwOnFailure(currentRunningInfo);
            c12461.label = 1;
            currentRunningInfo = getCurrentRunningInfo(c12461);
            if (currentRunningInfo != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            ResultKt.throwOnFailure(currentRunningInfo);
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c12461.I$0;
            downloadSessionInfo = (DownloadSessionInfo) c12461.L$1;
            ResultKt.throwOnFailure(currentRunningInfo);
        }
        fileModel = (FileModel) currentRunningInfo;
        if (fileModel != null) {
            itemId = fileModel.getItemId();
        } else {
            itemId = null;
        }
        remote = itemId instanceof ItemId.Remote ? (ItemId.Remote) itemId : null;
        if (remote == null) {
            BoxLogUtils.w(ExtensionsKt.getTAG(this) + "Job clean up failed");
            return Unit.INSTANCE;
        }
        for (Map.Entry<String, Long> entry : downloadSessionInfo.getChildJobs().entrySet()) {
            chunkTempFile = getChunkTempFile(remote, new Pair<>(entry.getKey(), entry.getValue()));
            if (chunkTempFile.exists()) {
                chunkTempFile.delete();
            }
        }
        return Unit.INSTANCE;
        DownloadSessionInfo downloadSessionInfo2 = (DownloadSessionInfo) currentRunningInfo;
        if (downloadSessionInfo2 != null) {
            c12461.L$0 = downloadSessionInfo2;
            c12461.L$1 = downloadSessionInfo2;
            c12461.I$0 = 0;
            c12461.label = 2;
            Object fileModel2 = getFileModel(c12461);
            if (fileModel2 != coroutine_suspended) {
                downloadSessionInfo = downloadSessionInfo2;
                currentRunningInfo = fileModel2;
                fileModel = (FileModel) currentRunningInfo;
                if (fileModel != null) {
                    itemId = fileModel.getItemId();
                } else {
                    itemId = null;
                }
                if (itemId instanceof ItemId.Remote) {
                }
                if (remote == null) {
                    BoxLogUtils.w(ExtensionsKt.getTAG(this) + "Job clean up failed");
                    return Unit.INSTANCE;
                }
                while (r6.hasNext()) {
                    chunkTempFile = getChunkTempFile(remote, new Pair<>(entry.getKey(), entry.getValue()));
                    if (chunkTempFile.exists()) {
                        chunkTempFile.delete();
                    }
                }
            }
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // com.box.android.data.jobs.Job
    public Object shouldBeRemovedFromDbOnSuccess(Continuation<? super Boolean> continuation) {
        return Boxing.boxBoolean(false);
    }

    @Override // com.box.android.domain.models.DisplayableJob
    public IJobDisplayInfoProvider getJobDisplayInfoProvider() {
        String string = this.inputData.getString("FileIdParam");
        Intrinsics.checkNotNull(string);
        ItemId.Remote fileRemoteId = ItemIdKt.toFileRemoteId(string);
        String string2 = this.inputData.getString(FILE_NAME_PARAM);
        Intrinsics.checkNotNull(string2);
        return new DownloadFileJobDisplayInfoProvider(fileRemoteId, string2, this.itemService, this.inputData.getBoolean(JobConstants.SHOW_NOTIFICATION, true));
    }

    @Override // com.box.android.domain.models.DisplayableJob
    public boolean shouldDisplay() {
        return this.inputData.getBoolean(JobConstants.SHOULD_DISPLAY_JOB, true);
    }

    @Override // com.box.android.domain.models.MetricsInfoProvider
    public String getAmplitudeJobType() {
        return BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_DOWNLOAD_JOB;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.models.MetricsInfoProvider
    public Object getAmplitudeInfos(Continuation<? super Map<String, ? extends Object>> continuation) {
        C12491 c12491;
        Map mapMapOf;
        if (continuation instanceof C12491) {
            c12491 = (C12491) continuation;
            if ((c12491.label & Integer.MIN_VALUE) != 0) {
                c12491.label -= Integer.MIN_VALUE;
            } else {
                c12491 = new C12491(continuation);
            }
        } else {
            c12491 = new C12491(continuation);
        }
        Object fileModel = c12491.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c12491.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(fileModel);
                c12491.label = 1;
                fileModel = getFileModel(c12491);
                if (fileModel == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(fileModel);
            }
            FileModel fileModel2 = (FileModel) fileModel;
            if (fileModel2 == null || (mapMapOf = MapsKt.mapOf(TuplesKt.to(BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_FIELD_FILE_SIZE, fileModel2.getSize()), TuplesKt.to(BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_FIELD_FILE_EXTENSION, fileModel2.getExtension()), TuplesKt.to(BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_FIELD_FILE_TYPE, BoxAnalyticsParams.INSTANCE.calculateFileType(fileModel2.getExtension())))) == null) {
                throw new IllegalStateException();
            }
            return mapMapOf;
        } catch (Exception e) {
            BoxLogUtils.e("Unable to get Additional Amp Info " + e);
            return MapsKt.mapOf(TuplesKt.to(BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_FIELD_FILE_SIZE, Boxing.boxInt(-1)), TuplesKt.to(BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_FIELD_FILE_EXTENSION, "unknown"), TuplesKt.to(BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_FIELD_FILE_TYPE, "unknown"));
        }
    }
}
