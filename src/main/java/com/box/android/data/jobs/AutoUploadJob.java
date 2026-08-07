package com.box.android.data.jobs;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.work.Data;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.common.utilities.OSPermissionUtils;
import com.box.android.common.utilities.RealPathUtils;
import com.box.android.coreservices.jobmanager.contentproviders.UploadSyncContentProvider;
import com.box.android.data.mappers.annotation.AnnotationEntityDomainMapperKt;
import com.box.android.data.persistence.jobs.JobEntity;
import com.box.android.data.service.impl.LocalItemService;
import com.box.android.data.service.impl.RemoteItemService;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.identity.IUserContext;
import com.box.android.domain.identity.IUserContextComponent;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.jobs.JobConstants;
import com.box.android.domain.jobs.JobId;
import com.box.android.domain.jobs.JobRequest;
import com.box.android.domain.jobs.JobType;
import com.box.android.domain.localrepo.IBoxStorage;
import com.box.android.domain.localrepo.ILocalAutoContentUploadInformation;
import com.box.android.domain.models.AutoUploadFolderJobDisplayInfoProvider;
import com.box.android.domain.models.DisplayableJob;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.IJobDisplayInfoProvider;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.MetricKeysParam;
import com.box.android.domain.models.MetricsInfoProvider;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.ItemType;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.models.BoxRepresentation;
import com.facebook.imageutils.JfifUtil;
import com.google.common.util.concurrent.AtomicDouble;
import com.microsoft.intune.mam.client.content.MAMContentResolverManagement;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedFactory;
import dagger.assisted.AssistedInject;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import sdk.pendo.io.events.IdentificationData;

/* JADX INFO: compiled from: AutoUploadJob.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0010\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u000b\u0018\u0000 \u008a\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\b\u008a\u0001\u008b\u0001\u008c\u0001\u008d\u0001BU\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u000e\u00106\u001a\u000207H\u0096@¢\u0006\u0002\u00108J\b\u00109\u001a\u00020:H\u0002J$\u0010;\u001a\b\u0012\u0004\u0012\u00020=0<2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AH\u0087@¢\u0006\u0002\u0010BJ4\u0010C\u001a\b\u0012\u0004\u0012\u00020=0<2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020G2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AH\u0087@¢\u0006\u0002\u0010HJ0\u0010I\u001a\u0004\u0018\u00010=2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020G2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AH\u0082@¢\u0006\u0002\u0010HJ\u0010\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020=H\u0007J8\u0010M\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020'0N2\f\u0010O\u001a\b\u0012\u0004\u0012\u00020=0<2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AH\u0087@¢\u0006\u0002\u0010PJX\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020R\u0012\u0004\u0012\u00020'0N2\u0006\u0010S\u001a\u00020=2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020W2\u000e\b\u0002\u0010X\u001a\b\u0012\u0004\u0012\u00020=0Y2\b\b\u0002\u0010Z\u001a\u00020:2\n\b\u0002\u0010[\u001a\u0004\u0018\u00010UH\u0087@¢\u0006\u0002\u0010\\J\u000e\u0010]\u001a\u000207H\u0087@¢\u0006\u0002\u00108J<\u0010^\u001a\u0002072\b\b\u0002\u0010_\u001a\u00020:2\"\u0010`\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020?\u0012\n\u0012\b\u0012\u0004\u0012\u0002070b\u0012\u0006\u0012\u0004\u0018\u00010c0aH\u0086@¢\u0006\u0002\u0010dJ*\u0010e\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020'0N2\u0006\u0010L\u001a\u00020=2\u0006\u0010@\u001a\u00020AH\u0087@¢\u0006\u0002\u0010fJ*\u0010g\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020'0N2\u0006\u0010h\u001a\u00020U2\u0006\u0010@\u001a\u00020AH\u0087@¢\u0006\u0002\u0010iJ2\u0010j\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020'0N2\u0006\u0010h\u001a\u00020U2\u0006\u0010@\u001a\u00020A2\u0006\u0010k\u001a\u00020=H\u0087@¢\u0006\u0002\u0010lJ\u000e\u0010m\u001a\u00020?H\u0082@¢\u0006\u0002\u00108J\u001a\u0010n\u001a\u000e\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020'0NH\u0087@¢\u0006\u0002\u00108J\u001c\u0010o\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010?\u0012\u0004\u0012\u00020'0NH\u0086@¢\u0006\u0002\u00108J\u000e\u0010p\u001a\u000207H\u0096@¢\u0006\u0002\u00108J\u000e\u0010q\u001a\u00020:H\u0096@¢\u0006\u0002\u00108J\b\u0010r\u001a\u00020=H\u0016J\u001a\u0010s\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020c0tH\u0096@¢\u0006\u0002\u00108J\u0010\u0010u\u001a\u00020v2\u0006\u0010>\u001a\u00020?H\u0007J\u0010\u0010w\u001a\u00020?2\u0006\u0010x\u001a\u00020vH\u0007J\b\u0010y\u001a\u00020zH\u0016J\u0016\u0010{\u001a\u0002072\u0006\u0010|\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010}J\u001f\u0010~\u001a\u0002072\u0006\u0010|\u001a\u00020\t2\u0006\u0010\u007f\u001a\u00020'H\u0096@¢\u0006\u0003\u0010\u0080\u0001J+\u0010\u0081\u0001\u001a\u0002072\u0006\u0010|\u001a\u00020\t2\b\u0010\u0082\u0001\u001a\u00030\u0083\u00012\u0007\u00103\u001a\u00030\u0083\u0001H\u0096@¢\u0006\u0003\u0010\u0084\u0001J\u0018\u0010\u0085\u0001\u001a\u0002072\u0006\u0010>\u001a\u00020?H\u0086@¢\u0006\u0003\u0010\u0086\u0001J!\u0010\u0087\u0001\u001a\u0002072\u0006\u0010|\u001a\u00020\t2\u0007\u0010\u0088\u0001\u001a\u00020vH\u0096@¢\u0006\u0003\u0010\u0089\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R&\u0010&\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010.\u001a\u00020/8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010)\u001a\u0004\b1\u00102R\u001c\u00103\u001a\u00020/8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b4\u0010)\u001a\u0004\b5\u00102¨\u0006\u008e\u0001"}, d2 = {"Lcom/box/android/data/jobs/AutoUploadJob;", "Lcom/box/android/data/jobs/ParentJob;", "Lcom/box/android/domain/models/DisplayableJob;", "Lcom/box/android/domain/models/MetricsInfoProvider;", "localItemService", "Lcom/box/android/data/service/impl/LocalItemService;", "moshi", "Lcom/squareup/moshi/Moshi;", JobWorker.JOB_ID_PARAM, "Lcom/box/android/domain/jobs/JobId;", "inputData", "Landroidx/work/Data;", "appContext", "Landroid/content/Context;", "jobService", "Lcom/box/android/data/jobs/JobService;", "remoteItemService", "Lcom/box/android/data/service/impl/RemoteItemService;", "boxStorage", "Lcom/box/android/domain/localrepo/IBoxStorage;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "<init>", "(Lcom/box/android/data/service/impl/LocalItemService;Lcom/squareup/moshi/Moshi;Lcom/box/android/domain/jobs/JobId;Landroidx/work/Data;Landroid/content/Context;Lcom/box/android/data/jobs/JobService;Lcom/box/android/data/service/impl/RemoteItemService;Lcom/box/android/domain/localrepo/IBoxStorage;Lcom/box/android/domain/identity/IUserContextManager;)V", "getJobId", "()Lcom/box/android/domain/jobs/JobId;", "getInputData", "()Landroidx/work/Data;", "getAppContext", "()Landroid/content/Context;", "getJobService", "()Lcom/box/android/data/jobs/JobService;", "getRemoteItemService", "()Lcom/box/android/data/service/impl/RemoteItemService;", "getBoxStorage", "()Lcom/box/android/domain/localrepo/IBoxStorage;", "getUserContextManager", "()Lcom/box/android/domain/identity/IUserContextManager;", "lastRecordError", "Lcom/box/android/domain/models/DomainError;", "getLastRecordError$annotations", "()V", "getLastRecordError", "()Lcom/box/android/domain/models/DomainError;", "setLastRecordError", "(Lcom/box/android/domain/models/DomainError;)V", "progress", "Lcom/google/common/util/concurrent/AtomicDouble;", "getProgress$annotations", "getProgress", "()Lcom/google/common/util/concurrent/AtomicDouble;", "estimatedWork", "getEstimatedWork$annotations", "getEstimatedWork", "start", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasStoragePermission", "", "processLocalFiles", "", "", "runningInfo", "Lcom/box/android/data/jobs/AutoUploadRunningInfo;", "folderMaps", "Lcom/box/android/data/jobs/AutoUploadJob$FolderMaps;", "(Lcom/box/android/data/jobs/AutoUploadRunningInfo;Lcom/box/android/data/jobs/AutoUploadJob$FolderMaps;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processCursor", "cursor", "Landroid/database/Cursor;", "indices", "Lcom/box/android/data/jobs/AutoUploadJob$CursorIndices;", "(Landroid/database/Cursor;Lcom/box/android/data/jobs/AutoUploadJob$CursorIndices;Lcom/box/android/data/jobs/AutoUploadRunningInfo;Lcom/box/android/data/jobs/AutoUploadJob$FolderMaps;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processCursorRow", "fetchFileWithPath", "Ljava/io/File;", "path", "uploadFiles", "Lcom/box/android/domain/utils/result/Result;", "filesToUpload", "(Ljava/util/List;Lcom/box/android/data/jobs/AutoUploadRunningInfo;Lcom/box/android/data/jobs/AutoUploadJob$FolderMaps;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadNestedFile", "Lcom/box/android/domain/jobs/JobRequest;", "name", IdentificationData.FIELD_PARENT_ID, "Lcom/box/android/domain/models/ItemId;", "contentUrl", "Landroid/net/Uri;", "tags", "", JobConstants.SHOW_NOTIFICATION, "fileId", "(Ljava/lang/String;Lcom/box/android/domain/models/ItemId;Landroid/net/Uri;Ljava/util/Set;ZLcom/box/android/domain/models/ItemId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkCompletion", "updatingRunningInfo", "isLockNeeded", "updateRunningData", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(ZLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveUnknownPath", "(Ljava/lang/String;Lcom/box/android/data/jobs/AutoUploadJob$FolderMaps;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ensureFolderFetched", "folderId", "(Lcom/box/android/domain/models/ItemId;Lcom/box/android/data/jobs/AutoUploadJob$FolderMaps;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scanRemoteFolderTree", "parentPrefix", "(Lcom/box/android/domain/models/ItemId;Lcom/box/android/data/jobs/AutoUploadJob$FolderMaps;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOrCreateRunningInfo", "initialRunningInfo", "getRunningInfo", "cleanup", "shouldBeRemovedFromDbOnSuccess", "getAmplitudeJobType", "getAmplitudeInfos", "", "runningInfoToByteArray", "", "byteArrayToRunningInfo", "byteArray", "getJobDisplayInfoProvider", "Lcom/box/android/domain/models/IJobDisplayInfoProvider;", "childSucceeded", "childJobId", "(Lcom/box/android/domain/jobs/JobId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "childFailed", "domainError", "(Lcom/box/android/domain/jobs/JobId;Lcom/box/android/domain/models/DomainError;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "childProgressed", "currentProgress", "", "(Lcom/box/android/domain/jobs/JobId;DDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setProgressAndEstimatedWork", "(Lcom/box/android/data/jobs/AutoUploadRunningInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveFromChild", BoxRepresentation.FIELD_INFO, "(Lcom/box/android/domain/jobs/JobId;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "FolderMaps", "CursorIndices", "Factory", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AutoUploadJob implements ParentJob, DisplayableJob, MetricsInfoProvider {
    public static final String BOX_FOLDER_ID_PARAM = "boxFolderIdParam";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String DEVICE_SOURCE_FOLDER_PATH_PATH = "sourceFolderPathParam";
    public static final String FOLDER_SUFFIX = "/";
    public static final String INVALID_FILE_URI = "content://non.existing.provider/invalid/path";
    public static final String ROOT_PATH = "/";
    private final Context appContext;
    private final IBoxStorage boxStorage;
    private final AtomicDouble estimatedWork;
    private final Data inputData;
    private final JobId jobId;
    private final JobService jobService;
    private DomainError lastRecordError;
    private final LocalItemService localItemService;
    private final Moshi moshi;
    private final AtomicDouble progress;
    private final RemoteItemService remoteItemService;
    private final IUserContextManager userContextManager;

    /* JADX INFO: compiled from: AutoUploadJob.kt */
    @AssistedFactory
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/box/android/data/jobs/AutoUploadJob$Factory;", "", "createJob", "Lcom/box/android/data/jobs/AutoUploadJob;", JobWorker.JOB_ID_PARAM, "Lcom/box/android/domain/jobs/JobId;", "inputData", "Landroidx/work/Data;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface Factory {
        AutoUploadJob createJob(JobId jobId, Data inputData);
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.AutoUploadJob$childProgressed$1, reason: invalid class name */
    /* JADX INFO: compiled from: AutoUploadJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.AutoUploadJob", f = "AutoUploadJob.kt", i = {0, 0, 0, 1, 1, 1, 1, 1}, l = {669, 670}, m = "childProgressed", n = {"childJobId", "currentProgress", "estimatedWork", "childJobId", "runningInfo", "currentProgress", "estimatedWork", "$i$a$-let-AutoUploadJob$childProgressed$2"}, s = {"L$0", "D$0", "D$1", "L$0", "L$1", "D$0", "D$1", "I$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        double D$0;
        double D$1;
        int I$0;
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
            return AutoUploadJob.this.childProgressed(null, 0.0d, 0.0d, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.AutoUploadJob$ensureFolderFetched$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AutoUploadJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.AutoUploadJob", f = "AutoUploadJob.kt", i = {0, 0}, l = {499}, m = "ensureFolderFetched", n = {"folderId", "folderMaps"}, s = {"L$0", "L$1"}, v = 1)
    static final class C12231 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C12231(Continuation<? super C12231> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutoUploadJob.this.ensureFolderFetched(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.AutoUploadJob$getOrCreateRunningInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AutoUploadJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.AutoUploadJob", f = "AutoUploadJob.kt", i = {}, l = {551, 551}, m = "getOrCreateRunningInfo", n = {}, s = {}, v = 1)
    static final class C12241 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C12241(Continuation<? super C12241> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutoUploadJob.this.getOrCreateRunningInfo(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.AutoUploadJob$getRunningInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AutoUploadJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.AutoUploadJob", f = "AutoUploadJob.kt", i = {}, l = {597}, m = "getRunningInfo", n = {}, s = {}, v = 1)
    static final class C12251 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C12251(Continuation<? super C12251> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutoUploadJob.this.getRunningInfo(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.AutoUploadJob$initialRunningInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AutoUploadJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.AutoUploadJob", f = "AutoUploadJob.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {569, 586}, m = "initialRunningInfo", n = {"uploadInfo", "uploadFolderBoxId", "uploadFolderRemoteId", "sourceFolderPath", "lastSyncTime", "syncEnabledTime", "shouldNotify", "uploadInfo", "uploadFolderBoxId", "uploadFolderRemoteId", "sourceFolderPath", "newRunningInfo", "lastSyncTime", "syncEnabledTime", "shouldNotify"}, s = {"L$0", "L$1", "L$2", "L$3", "J$0", "J$1", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "J$1", "Z$0"}, v = 1)
    static final class C12261 extends ContinuationImpl {
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C12261(Continuation<? super C12261> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutoUploadJob.this.initialRunningInfo(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.AutoUploadJob$processCursor$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AutoUploadJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.AutoUploadJob", f = "AutoUploadJob.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {249, 258}, m = "processCursor", n = {"cursor", "indices", "runningInfo", "folderMaps", "filesToUpload", "foldersToPrefetch", "cursor", "indices", "runningInfo", "folderMaps", "filesToUpload", "foldersToPrefetch", "folderId"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7"}, v = 1)
    static final class C12271 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        C12271(Continuation<? super C12271> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutoUploadJob.this.processCursor(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.AutoUploadJob$processCursorRow$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AutoUploadJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.AutoUploadJob", f = "AutoUploadJob.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {279}, m = "processCursorRow", n = {"cursor", "indices", "runningInfo", "folderMaps", "path", "sha1", "key", "isDirectory"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0"}, v = 1)
    static final class C12281 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C12281(Continuation<? super C12281> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutoUploadJob.this.processCursorRow(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.AutoUploadJob$processLocalFiles$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AutoUploadJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.AutoUploadJob", f = "AutoUploadJob.kt", i = {0, 0, 0, 0, 0}, l = {JfifUtil.MARKER_EOI}, m = "processLocalFiles", n = {"runningInfo", "folderMaps", "cursor", "indices", "$i$a$-use-AutoUploadJob$processLocalFiles$2"}, s = {"L$0", "L$1", "L$3", "L$4", "I$0"}, v = 1)
    static final class C12291 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C12291(Continuation<? super C12291> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutoUploadJob.this.processLocalFiles(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.AutoUploadJob$resolveUnknownPath$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AutoUploadJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.AutoUploadJob", f = "AutoUploadJob.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {470}, m = "resolveUnknownPath", n = {"path", "folderMaps", "pathSegments", "parentPath", "parentFolderId", "segment", "childPath", "childFolderId"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$7", "L$8"}, v = 1)
    static final class C12301 extends ContinuationImpl {
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

        C12301(Continuation<? super C12301> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutoUploadJob.this.resolveUnknownPath(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.AutoUploadJob$scanRemoteFolderTree$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AutoUploadJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.AutoUploadJob", f = "AutoUploadJob.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {518, 520, 534}, m = "scanRemoteFolderTree", n = {"folderId", "folderMaps", "parentPrefix", "folderId", "folderMaps", "parentPrefix", "folderId", "folderMaps", "parentPrefix", "itemsResult", "item", "itemPath"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$5", "L$6"}, v = 1)
    static final class C12311 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C12311(Continuation<? super C12311> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutoUploadJob.this.scanRemoteFolderTree(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.AutoUploadJob$start$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AutoUploadJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.AutoUploadJob", f = "AutoUploadJob.kt", i = {3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10}, l = {Token.DOTDOT, Token.DOTQUERY, 150, Token.SETCONSTVAR, Token.LETEXPR, Token.METHOD, Token.YIELD_STAR, 175, 178, 180, 183}, m = "start", n = {"runningInfo", "uploadFolderId", "folderMaps", "runningInfo", "uploadFolderId", "folderMaps", "$this$onError$iv", "it", "$i$f$onError", "$i$a$-onError-AutoUploadJob$start$2", "runningInfo", "uploadFolderId", "folderMaps", "$this$start_u24lambda_u242", "$i$a$-runCatching-AutoUploadJob$start$filePathsToUpload$1", "runningInfo", "uploadFolderId", "folderMaps", "it", "$i$a$-onFailure-AutoUploadJob$start$filePathsToUpload$2", "runningInfo", "uploadFolderId", "folderMaps", "filePathsToUpload", "runningInfo", "uploadFolderId", "folderMaps", "filePathsToUpload", "runningInfo", "uploadFolderId", "folderMaps", "filePathsToUpload", "$this$onError$iv", "it", "$i$f$onError", "$i$a$-onError-AutoUploadJob$start$3", "runningInfo", "uploadFolderId", "folderMaps", "filePathsToUpload"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3"}, v = 1)
    static final class C12321 extends ContinuationImpl {
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

        C12321(Continuation<? super C12321> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutoUploadJob.this.start(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.AutoUploadJob$updatingRunningInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AutoUploadJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.AutoUploadJob", f = "AutoUploadJob.kt", i = {0, 0, 1, 1, 2, 2, 2, 2}, l = {418, 424, 425}, m = "updatingRunningInfo", n = {"updateRunningData", "isLockNeeded", "updateRunningData", "isLockNeeded", "updateRunningData", "it", "isLockNeeded", "$i$a$-let-AutoUploadJob$updatingRunningInfo$3"}, s = {"L$0", "Z$0", "L$0", "Z$0", "L$0", "L$1", "Z$0", "I$0"}, v = 1)
    static final class C12331 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C12331(Continuation<? super C12331> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutoUploadJob.this.updatingRunningInfo(false, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.AutoUploadJob$uploadFiles$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AutoUploadJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.AutoUploadJob", f = "AutoUploadJob.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {353, 376}, m = "uploadFiles", n = {"filesToUpload", "runningInfo", "folderMaps", "tags", "jobIdFilenameMap", "jobIdFileSizeMap", "firstError", "path", BoxCommonConstants.EXTRA_FILE_NAME, "fileId", "directoryPath", "currentFolderId", "file", "copiedFilePath", "filesToUpload", "runningInfo", "folderMaps", "tags", "jobIdFilenameMap", "jobIdFileSizeMap", "firstError", "newRunningInfo", "runningInfoByteArray"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8"}, v = 1)
    static final class C12351 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
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

        C12351(Continuation<? super C12351> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutoUploadJob.this.uploadFiles(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.AutoUploadJob$uploadNestedFile$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AutoUploadJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.AutoUploadJob", f = "AutoUploadJob.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {389, 392}, m = "uploadNestedFile", n = {"name", IdentificationData.FIELD_PARENT_ID, "contentUrl", "tags", "fileId", JobConstants.SHOW_NOTIFICATION, "name", IdentificationData.FIELD_PARENT_ID, "contentUrl", "tags", "fileId", "$this$flatMap$iv", "fileModel", "uploadRequest", JobConstants.SHOW_NOTIFICATION, "$i$f$flatMap", "$i$a$-flatMap-AutoUploadJob$uploadNestedFile$2"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "Z$0", "I$0", "I$1"}, v = 1)
    static final class C12361 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C12361(Continuation<? super C12361> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutoUploadJob.this.uploadNestedFile(null, null, null, null, false, null, this);
        }
    }

    public static /* synthetic */ void getEstimatedWork$annotations() {
    }

    public static /* synthetic */ void getLastRecordError$annotations() {
    }

    public static /* synthetic */ void getProgress$annotations() {
    }

    @AssistedInject
    public AutoUploadJob(LocalItemService localItemService, Moshi moshi, @Assisted JobId jobId, @Assisted Data inputData, Context appContext, JobService jobService, RemoteItemService remoteItemService, IBoxStorage boxStorage, IUserContextManager userContextManager) {
        Intrinsics.checkNotNullParameter(localItemService, "localItemService");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Intrinsics.checkNotNullParameter(jobId, "jobId");
        Intrinsics.checkNotNullParameter(inputData, "inputData");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(jobService, "jobService");
        Intrinsics.checkNotNullParameter(remoteItemService, "remoteItemService");
        Intrinsics.checkNotNullParameter(boxStorage, "boxStorage");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        this.localItemService = localItemService;
        this.moshi = moshi;
        this.jobId = jobId;
        this.inputData = inputData;
        this.appContext = appContext;
        this.jobService = jobService;
        this.remoteItemService = remoteItemService;
        this.boxStorage = boxStorage;
        this.userContextManager = userContextManager;
        this.progress = new AtomicDouble(-1.0d);
        this.estimatedWork = new AtomicDouble(-1.0d);
    }

    @Override // com.box.android.data.jobs.Job
    public /* bridge */ Object run(JobEntity jobEntity, Continuation<? super Unit> continuation) {
        return super.run(jobEntity, continuation);
    }

    @Override // com.box.android.domain.models.DisplayableJob
    public /* bridge */ boolean shouldDisplay() {
        return super.shouldDisplay();
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

    public final RemoteItemService getRemoteItemService() {
        return this.remoteItemService;
    }

    public final IBoxStorage getBoxStorage() {
        return this.boxStorage;
    }

    public final IUserContextManager getUserContextManager() {
        return this.userContextManager;
    }

    /* JADX INFO: compiled from: AutoUploadJob.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/box/android/data/jobs/AutoUploadJob$Companion;", "", "<init>", "()V", "BOX_FOLDER_ID_PARAM", "", "DEVICE_SOURCE_FOLDER_PATH_PATH", "getRequest", "Lcom/box/android/domain/jobs/JobRequest;", "folderId", "Lcom/box/android/domain/models/ItemId;", "sourceFolderPath", "tags", "", "INVALID_FILE_URI", "ROOT_PATH", "FOLDER_SUFFIX", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ JobRequest getRequest$default(Companion companion, ItemId itemId, String str, Set set, int i, Object obj) {
            if ((i & 4) != 0) {
                set = SetsKt.emptySet();
            }
            return companion.getRequest(itemId, str, set);
        }

        public final JobRequest getRequest(ItemId folderId, String sourceFolderPath, Set<String> tags) {
            Intrinsics.checkNotNullParameter(folderId, "folderId");
            Intrinsics.checkNotNullParameter(sourceFolderPath, "sourceFolderPath");
            Intrinsics.checkNotNullParameter(tags, "tags");
            JobRequest.Builder builder = new JobRequest.Builder(JobType.AUTO_UPLOAD, null, null, null, 14, null);
            Data.Builder builder2 = new Data.Builder();
            builder2.putString(AutoUploadJob.BOX_FOLDER_ID_PARAM, folderId.toString());
            builder2.putString(AutoUploadJob.DEVICE_SOURCE_FOLDER_PATH_PATH, sourceFolderPath);
            builder.setData(builder2.build());
            builder.setTags(SetsKt.plus(SetsKt.setOf("auto_upload"), (Iterable) tags));
            return builder.build();
        }
    }

    public final DomainError getLastRecordError() {
        return this.lastRecordError;
    }

    public final void setLastRecordError(DomainError domainError) {
        this.lastRecordError = domainError;
    }

    public final AtomicDouble getProgress() {
        return this.progress;
    }

    public final AtomicDouble getEstimatedWork() {
        return this.estimatedWork;
    }

    /* JADX INFO: compiled from: AutoUploadJob.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0003\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u0015\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\tHÆ\u0003JE\u0010\u0014\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0004HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/box/android/data/jobs/AutoUploadJob$FolderMaps;", "", "folderMap", "", "", "Lcom/box/android/domain/models/ItemId;", "fileMap", "Lcom/box/android/domain/models/item/FileModel;", "recentlyFetchedFolders", "", "<init>", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Set;)V", "getFolderMap", "()Ljava/util/Map;", "getFileMap", "getRecentlyFetchedFolders", "()Ljava/util/Set;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class FolderMaps {
        private final Map<String, FileModel> fileMap;
        private final Map<String, ItemId> folderMap;
        private final Set<ItemId> recentlyFetchedFolders;

        public FolderMaps() {
            this(null, null, null, 7, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ FolderMaps copy$default(FolderMaps folderMaps, Map map, Map map2, Set set, int i, Object obj) {
            if ((i & 1) != 0) {
                map = folderMaps.folderMap;
            }
            if ((i & 2) != 0) {
                map2 = folderMaps.fileMap;
            }
            if ((i & 4) != 0) {
                set = folderMaps.recentlyFetchedFolders;
            }
            return folderMaps.copy(map, map2, set);
        }

        public final Map<String, ItemId> component1() {
            return this.folderMap;
        }

        public final Map<String, FileModel> component2() {
            return this.fileMap;
        }

        public final Set<ItemId> component3() {
            return this.recentlyFetchedFolders;
        }

        public final FolderMaps copy(Map<String, ItemId> folderMap, Map<String, FileModel> fileMap, Set<ItemId> recentlyFetchedFolders) {
            Intrinsics.checkNotNullParameter(folderMap, "folderMap");
            Intrinsics.checkNotNullParameter(fileMap, "fileMap");
            Intrinsics.checkNotNullParameter(recentlyFetchedFolders, "recentlyFetchedFolders");
            return new FolderMaps(folderMap, fileMap, recentlyFetchedFolders);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FolderMaps)) {
                return false;
            }
            FolderMaps folderMaps = (FolderMaps) other;
            return Intrinsics.areEqual(this.folderMap, folderMaps.folderMap) && Intrinsics.areEqual(this.fileMap, folderMaps.fileMap) && Intrinsics.areEqual(this.recentlyFetchedFolders, folderMaps.recentlyFetchedFolders);
        }

        public int hashCode() {
            return (((this.folderMap.hashCode() * 31) + this.fileMap.hashCode()) * 31) + this.recentlyFetchedFolders.hashCode();
        }

        public String toString() {
            return "FolderMaps(folderMap=" + this.folderMap + ", fileMap=" + this.fileMap + ", recentlyFetchedFolders=" + this.recentlyFetchedFolders + ")";
        }

        public FolderMaps(Map<String, ItemId> folderMap, Map<String, FileModel> fileMap, Set<ItemId> recentlyFetchedFolders) {
            Intrinsics.checkNotNullParameter(folderMap, "folderMap");
            Intrinsics.checkNotNullParameter(fileMap, "fileMap");
            Intrinsics.checkNotNullParameter(recentlyFetchedFolders, "recentlyFetchedFolders");
            this.folderMap = folderMap;
            this.fileMap = fileMap;
            this.recentlyFetchedFolders = recentlyFetchedFolders;
        }

        public /* synthetic */ FolderMaps(LinkedHashMap linkedHashMap, LinkedHashMap linkedHashMap2, LinkedHashSet linkedHashSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new LinkedHashMap() : linkedHashMap, (i & 2) != 0 ? new LinkedHashMap() : linkedHashMap2, (i & 4) != 0 ? new LinkedHashSet() : linkedHashSet);
        }

        public final Map<String, ItemId> getFolderMap() {
            return this.folderMap;
        }

        public final Map<String, FileModel> getFileMap() {
            return this.fileMap;
        }

        public final Set<ItemId> getRecentlyFetchedFolders() {
            return this.recentlyFetchedFolders;
        }
    }

    /* JADX INFO: compiled from: AutoUploadJob.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/box/android/data/jobs/AutoUploadJob$CursorIndices;", "", "pathIndex", "", "sha1Index", "isDirIndex", "<init>", "(III)V", "getPathIndex", "()I", "getSha1Index", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class CursorIndices {
        private final int isDirIndex;
        private final int pathIndex;
        private final int sha1Index;

        public static /* synthetic */ CursorIndices copy$default(CursorIndices cursorIndices, int i, int i2, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i = cursorIndices.pathIndex;
            }
            if ((i4 & 2) != 0) {
                i2 = cursorIndices.sha1Index;
            }
            if ((i4 & 4) != 0) {
                i3 = cursorIndices.isDirIndex;
            }
            return cursorIndices.copy(i, i2, i3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getPathIndex() {
            return this.pathIndex;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getSha1Index() {
            return this.sha1Index;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getIsDirIndex() {
            return this.isDirIndex;
        }

        public final CursorIndices copy(int pathIndex, int sha1Index, int isDirIndex) {
            return new CursorIndices(pathIndex, sha1Index, isDirIndex);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CursorIndices)) {
                return false;
            }
            CursorIndices cursorIndices = (CursorIndices) other;
            return this.pathIndex == cursorIndices.pathIndex && this.sha1Index == cursorIndices.sha1Index && this.isDirIndex == cursorIndices.isDirIndex;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.pathIndex) * 31) + Integer.hashCode(this.sha1Index)) * 31) + Integer.hashCode(this.isDirIndex);
        }

        public String toString() {
            return "CursorIndices(pathIndex=" + this.pathIndex + ", sha1Index=" + this.sha1Index + ", isDirIndex=" + this.isDirIndex + ")";
        }

        public CursorIndices(int i, int i2, int i3) {
            this.pathIndex = i;
            this.sha1Index = i2;
            this.isDirIndex = i3;
        }

        public final int getPathIndex() {
            return this.pathIndex;
        }

        public final int getSha1Index() {
            return this.sha1Index;
        }

        public final int isDirIndex() {
            return this.isDirIndex;
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0120  */
    /* JADX WARN: Code duplicated, block: B:37:0x013b  */
    /* JADX WARN: Code duplicated, block: B:40:0x0146 A[PHI: r0
      0x0146: PHI (r0v40 java.lang.Object) = (r0v36 java.lang.Object), (r0v1 java.lang.Object) binds: [B:38:0x0142, B:24:0x00f5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:43:0x017d  */
    /* JADX WARN: Code duplicated, block: B:46:0x0187  */
    /* JADX WARN: Code duplicated, block: B:48:0x018b  */
    /* JADX WARN: Code duplicated, block: B:53:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:55:0x01d0 A[Catch: all -> 0x00c4, TRY_ENTER, TryCatch #0 {all -> 0x00c4, blocks: (B:18:0x00bf, B:58:0x01f2, B:55:0x01d0), top: B:94:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:57:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:58:0x01f2 A[Catch: all -> 0x00c4, PHI: r0 r3 r4 r5
      0x01f2: PHI (r0v58 java.lang.Object) = (r0v51 java.lang.Object), (r0v1 java.lang.Object) binds: [B:56:0x01ee, B:18:0x00bf] A[DONT_GENERATE, DONT_INLINE]
      0x01f2: PHI (r3v23 ??) = (r3v43 ??), (r3v44 ??) binds: [B:56:0x01ee, B:18:0x00bf] A[DONT_GENERATE, DONT_INLINE]
      0x01f2: PHI (r4v21 ??) = (r4v38 ??), (r4v39 ??) binds: [B:56:0x01ee, B:18:0x00bf] A[DONT_GENERATE, DONT_INLINE]
      0x01f2: PHI (r5v14 com.box.android.data.jobs.AutoUploadRunningInfo) = (r5v10 com.box.android.data.jobs.AutoUploadRunningInfo), (r5v16 com.box.android.data.jobs.AutoUploadRunningInfo) binds: [B:56:0x01ee, B:18:0x00bf] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #0 {all -> 0x00c4, blocks: (B:18:0x00bf, B:58:0x01f2, B:55:0x01d0), top: B:94:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:63:0x020c  */
    /* JADX WARN: Code duplicated, block: B:65:0x021a  */
    /* JADX WARN: Code duplicated, block: B:71:0x0249  */
    /* JADX WARN: Code duplicated, block: B:73:0x0253  */
    /* JADX WARN: Code duplicated, block: B:77:0x0275 A[PHI: r3 r4 r5 r7
      0x0275: PHI (r3v9 java.util.List) = (r3v6 java.util.List), (r3v30 java.util.List) binds: [B:75:0x0271, B:15:0x0081] A[DONT_GENERATE, DONT_INLINE]
      0x0275: PHI (r4v6 ??) = (r4v36 ??), (r4v37 ??) binds: [B:75:0x0271, B:15:0x0081] A[DONT_GENERATE, DONT_INLINE]
      0x0275: PHI (r5v4 ??) = (r5v28 ??), (r5v29 ??) binds: [B:75:0x0271, B:15:0x0081] A[DONT_GENERATE, DONT_INLINE]
      0x0275: PHI (r7v3 com.box.android.data.jobs.AutoUploadRunningInfo) = (r7v1 com.box.android.data.jobs.AutoUploadRunningInfo), (r7v14 com.box.android.data.jobs.AutoUploadRunningInfo) binds: [B:75:0x0271, B:15:0x0081] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:80:0x0298 A[PHI: r0 r3 r4 r5 r7
      0x0298: PHI (r0v19 java.lang.Object) = (r0v18 java.lang.Object), (r0v1 java.lang.Object) binds: [B:78:0x0295, B:14:0x006c] A[DONT_GENERATE, DONT_INLINE]
      0x0298: PHI (r3v10 java.util.List) = (r3v9 java.util.List), (r3v32 java.util.List) binds: [B:78:0x0295, B:14:0x006c] A[DONT_GENERATE, DONT_INLINE]
      0x0298: PHI (r4v7 ??) = (r4v34 ??), (r4v35 ??) binds: [B:78:0x0295, B:14:0x006c] A[DONT_GENERATE, DONT_INLINE]
      0x0298: PHI (r5v5 ??) = (r5v26 ??), (r5v27 ??) binds: [B:78:0x0295, B:14:0x006c] A[DONT_GENERATE, DONT_INLINE]
      0x0298: PHI (r7v4 com.box.android.data.jobs.AutoUploadRunningInfo) = (r7v3 com.box.android.data.jobs.AutoUploadRunningInfo), (r7v16 com.box.android.data.jobs.AutoUploadRunningInfo) binds: [B:78:0x0295, B:14:0x006c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:82:0x029e  */
    /* JADX WARN: Code duplicated, block: B:84:0x02a2  */
    /* JADX WARN: Code duplicated, block: B:87:0x02e0  */
    /* JADX WARN: Code duplicated, block: B:89:0x02e6 A[PHI: r3 r4 r5 r7
      0x02e6: PHI (r3v11 java.util.List) = (r3v10 java.util.List), (r3v10 java.util.List), (r3v40 java.util.List) binds: [B:81:0x029c, B:85:0x02dd, B:13:0x004b] A[DONT_GENERATE, DONT_INLINE]
      0x02e6: PHI (r4v8 ??) = (r4v31 ??), (r4v32 ??), (r4v33 ??) binds: [B:81:0x029c, B:85:0x02dd, B:13:0x004b] A[DONT_GENERATE, DONT_INLINE]
      0x02e6: PHI (r5v6 ??) = (r5v23 ??), (r5v24 ??), (r5v25 ??) binds: [B:81:0x029c, B:85:0x02dd, B:13:0x004b] A[DONT_GENERATE, DONT_INLINE]
      0x02e6: PHI (r7v5 com.box.android.data.jobs.AutoUploadRunningInfo) = 
      (r7v4 com.box.android.data.jobs.AutoUploadRunningInfo)
      (r7v4 com.box.android.data.jobs.AutoUploadRunningInfo)
      (r7v18 com.box.android.data.jobs.AutoUploadRunningInfo)
     binds: [B:81:0x029c, B:85:0x02dd, B:13:0x004b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0134, code lost:
    
        if (r0.jobFailed(r1, com.box.android.domain.jobs.JobType.AUTO_UPLOAD, r3, r6) == r2) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x01c3, code lost:
    
        if (r8.jobFailed(r1, com.box.android.domain.jobs.JobType.AUTO_UPLOAD, r7, r6) == r2) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0242, code lost:
    
        if (r0.jobFailed(r1, com.box.android.domain.jobs.JobType.AUTO_UPLOAD, r8, r6) == r2) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x030a, code lost:
    
        if (checkCompletion(r6) == r2) goto L91;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r19v0, types: [com.box.android.data.jobs.AutoUploadJob, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v43 */
    /* JADX WARN: Type inference failed for: r3v44 */
    /* JADX WARN: Type inference failed for: r3v45 */
    /* JADX WARN: Type inference failed for: r3v46 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v32 */
    /* JADX WARN: Type inference failed for: r4v33 */
    /* JADX WARN: Type inference failed for: r4v34 */
    /* JADX WARN: Type inference failed for: r4v35 */
    /* JADX WARN: Type inference failed for: r4v36 */
    /* JADX WARN: Type inference failed for: r4v37 */
    /* JADX WARN: Type inference failed for: r4v38 */
    /* JADX WARN: Type inference failed for: r4v39 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v40 */
    /* JADX WARN: Type inference failed for: r4v41 */
    /* JADX WARN: Type inference failed for: r4v6, types: [com.box.android.data.jobs.AutoUploadJob$FolderMaps, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.lang.Object] */
    @Override // com.box.android.data.jobs.Job
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object start(kotlin.coroutines.Continuation<? super kotlin.Unit> r20) throws java.io.UnsupportedEncodingException {
        /*
            Method dump skipped, instruction units count: 812
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.AutoUploadJob.start(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final boolean hasStoragePermission() {
        return OSPermissionUtils.INSTANCE.hasStoragePermission(true);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public final Object processLocalFiles(AutoUploadRunningInfo autoUploadRunningInfo, FolderMaps folderMaps, Continuation<? super List<String>> continuation) throws IOException {
        C12291 c12291;
        Throwable th;
        Closeable closeable;
        if (continuation instanceof C12291) {
            c12291 = (C12291) continuation;
            if ((c12291.label & Integer.MIN_VALUE) != 0) {
                c12291.label -= Integer.MIN_VALUE;
            } else {
                c12291 = new C12291(continuation);
            }
        } else {
            c12291 = new C12291(continuation);
        }
        C12291 c12292 = c12291;
        Object objProcessCursor = c12292.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c12292.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objProcessCursor);
            Cursor cursorQuery = MAMContentResolverManagement.query(getAppContext().getContentResolver(), UploadSyncContentProvider.buildUri(this.userContextManager.getCurrentContextId()), null, null, null, null);
            if (cursorQuery != null) {
                Cursor cursor = cursorQuery;
                try {
                    Cursor cursor2 = cursor;
                    CursorIndices cursorIndices = new CursorIndices(cursor2.getColumnIndex(UploadSyncContentProvider.COLUMN_PATH), cursor2.getColumnIndex(UploadSyncContentProvider.COLUMN_SHA1), cursor2.getColumnIndex(UploadSyncContentProvider.COLUMN_IS_DIRECTORY));
                    c12292.L$0 = SpillingKt.nullOutSpilledVariable(autoUploadRunningInfo);
                    c12292.L$1 = SpillingKt.nullOutSpilledVariable(folderMaps);
                    c12292.L$2 = cursor;
                    c12292.L$3 = SpillingKt.nullOutSpilledVariable(cursor2);
                    c12292.L$4 = SpillingKt.nullOutSpilledVariable(cursorIndices);
                    c12292.I$0 = 0;
                    c12292.label = 1;
                    objProcessCursor = processCursor(cursor2, cursorIndices, autoUploadRunningInfo, folderMaps, c12292);
                    if (objProcessCursor == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    closeable = cursor;
                } catch (Throwable th2) {
                    th = th2;
                    closeable = cursor;
                    throw th;
                }
            }
            throw new IllegalStateException("Cursor for files to be uploaded is null");
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int i2 = c12292.I$0;
        closeable = (Closeable) c12292.L$2;
        try {
            ResultKt.throwOnFailure(objProcessCursor);
        } catch (Throwable th3) {
            th = th3;
            try {
                throw th;
            } catch (Throwable th4) {
                CloseableKt.closeFinally(closeable, th);
                throw th4;
            }
        }
        List list = (List) objProcessCursor;
        CloseableKt.closeFinally(closeable, null);
        if (list != null) {
            return list;
        }
        throw new IllegalStateException("Cursor for files to be uploaded is null");
    }

    /* JADX WARN: Code duplicated, block: B:19:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:22:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:26:0x00be  */
    /* JADX WARN: Code duplicated, block: B:29:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:31:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x00b6 -> B:23:0x00b9). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object processCursor(android.database.Cursor r17, com.box.android.data.jobs.AutoUploadJob.CursorIndices r18, com.box.android.data.jobs.AutoUploadRunningInfo r19, com.box.android.data.jobs.AutoUploadJob.FolderMaps r20, kotlin.coroutines.Continuation<? super java.util.List<java.lang.String>> r21) {
        /*
            Method dump skipped, instruction units count: 305
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.AutoUploadJob.processCursor(android.database.Cursor, com.box.android.data.jobs.AutoUploadJob$CursorIndices, com.box.android.data.jobs.AutoUploadRunningInfo, com.box.android.data.jobs.AutoUploadJob$FolderMaps, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object processCursorRow(Cursor cursor, CursorIndices cursorIndices, AutoUploadRunningInfo autoUploadRunningInfo, FolderMaps folderMaps, Continuation<? super String> continuation) {
        C12281 c12281;
        if (continuation instanceof C12281) {
            c12281 = (C12281) continuation;
            if ((c12281.label & Integer.MIN_VALUE) != 0) {
                c12281.label -= Integer.MIN_VALUE;
            } else {
                c12281 = new C12281(continuation);
            }
        } else {
            c12281 = new C12281(continuation);
        }
        Object obj = c12281.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c12281.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String string = cursor.getString(cursorIndices.getPathIndex());
            String string2 = cursor.getString(cursorIndices.getSha1Index());
            int i2 = cursor.getInt(cursorIndices.isDirIndex()) == 1 ? 1 : 0;
            Intrinsics.checkNotNull(string);
            if (!StringsKt.startsWith$default(string, autoUploadRunningInfo.getSourceFolderPath(), false, 2, (Object) null)) {
                return null;
            }
            String strRemovePrefix = StringsKt.removePrefix(string, (CharSequence) autoUploadRunningInfo.getSourceFolderPath());
            if (i2 != 0) {
                if (!folderMaps.getFolderMap().containsKey(strRemovePrefix)) {
                    c12281.L$0 = SpillingKt.nullOutSpilledVariable(cursor);
                    c12281.L$1 = SpillingKt.nullOutSpilledVariable(cursorIndices);
                    c12281.L$2 = SpillingKt.nullOutSpilledVariable(autoUploadRunningInfo);
                    c12281.L$3 = SpillingKt.nullOutSpilledVariable(folderMaps);
                    c12281.L$4 = SpillingKt.nullOutSpilledVariable(string);
                    c12281.L$5 = SpillingKt.nullOutSpilledVariable(string2);
                    c12281.L$6 = SpillingKt.nullOutSpilledVariable(strRemovePrefix);
                    c12281.I$0 = i2;
                    c12281.label = 1;
                    if (resolveUnknownPath(strRemovePrefix, folderMaps, c12281) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                FileModel fileModel = folderMaps.getFileMap().get(strRemovePrefix);
                if ((fileModel == null || !Intrinsics.areEqual(string2, fileModel.getSha1())) && fetchFileWithPath(string).lastModified() > autoUploadRunningInfo.getSyncEnabledTime()) {
                    return string;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i3 = c12281.I$0;
            ResultKt.throwOnFailure(obj);
        }
        return null;
    }

    public final File fetchFileWithPath(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return new File(path);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:25:0x0116  */
    /* JADX WARN: Code duplicated, block: B:27:0x0122  */
    /* JADX WARN: Code duplicated, block: B:30:0x013c  */
    /* JADX WARN: Code duplicated, block: B:32:0x0142  */
    /* JADX WARN: Code duplicated, block: B:37:0x017d  */
    /* JADX WARN: Code duplicated, block: B:40:0x0184  */
    /* JADX WARN: Code duplicated, block: B:44:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:47:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:48:0x0224  */
    /* JADX WARN: Code duplicated, block: B:51:0x022e  */
    /* JADX WARN: Code duplicated, block: B:53:0x0232  */
    /* JADX WARN: Code duplicated, block: B:55:0x0240  */
    /* JADX WARN: Code duplicated, block: B:57:0x026b  */
    /* JADX WARN: Code duplicated, block: B:60:0x027d  */
    /* JADX WARN: Code duplicated, block: B:65:0x02f5  */
    /* JADX WARN: Code duplicated, block: B:72:0x0283 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:0x015d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x01e3 -> B:45:0x01f0). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object uploadFiles(java.util.List<java.lang.String> r30, com.box.android.data.jobs.AutoUploadRunningInfo r31, com.box.android.data.jobs.AutoUploadJob.FolderMaps r32, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<kotlin.Unit, ? extends com.box.android.domain.models.DomainError>> r33) throws java.io.UnsupportedEncodingException {
        /*
            Method dump skipped, instruction units count: 782
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.AutoUploadJob.uploadFiles(java.util.List, com.box.android.data.jobs.AutoUploadRunningInfo, com.box.android.data.jobs.AutoUploadJob$FolderMaps, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0162 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:39:0x0163  */
    /* JADX WARN: Code duplicated, block: B:41:0x0167  */
    /* JADX WARN: Code duplicated, block: B:43:0x017c  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0133, code lost:
    
        if (r1 == r3) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object uploadNestedFile(java.lang.String r17, com.box.android.domain.models.ItemId r18, android.net.Uri r19, java.util.Set<java.lang.String> r20, boolean r21, com.box.android.domain.models.ItemId r22, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<com.box.android.domain.jobs.JobRequest, ? extends com.box.android.domain.models.DomainError>> r23) throws java.io.UnsupportedEncodingException {
        /*
            Method dump skipped, instruction units count: 392
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.AutoUploadJob.uploadNestedFile(java.lang.String, com.box.android.domain.models.ItemId, android.net.Uri, java.util.Set, boolean, com.box.android.domain.models.ItemId, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object uploadNestedFile$default(AutoUploadJob autoUploadJob, String str, ItemId itemId, Uri uri, Set set, boolean z, ItemId itemId2, Continuation continuation, int i, Object obj) {
        if ((i & 8) != 0) {
            set = SetsKt.emptySet();
        }
        Set set2 = set;
        if ((i & 16) != 0) {
            z = true;
        }
        boolean z2 = z;
        if ((i & 32) != 0) {
            itemId2 = null;
        }
        return autoUploadJob.uploadNestedFile(str, itemId, uri, set2, z2, itemId2, continuation);
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.AutoUploadJob$checkCompletion$2, reason: invalid class name */
    /* JADX INFO: compiled from: AutoUploadJob.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "runningInfo", "Lcom/box/android/data/jobs/AutoUploadRunningInfo;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.AutoUploadJob$checkCompletion$2", f = "AutoUploadJob.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {405, 410}, m = "invokeSuspend", n = {"runningInfo", "totalFiles", "succeededCount", "failedCount", "completedCount", "runningInfo", "error", "totalFiles", "succeededCount", "failedCount", "completedCount"}, s = {"L$0", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<AutoUploadRunningInfo, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        /* synthetic */ Object L$0;
        Object L$1;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = AutoUploadJob.this.new AnonymousClass2(continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AutoUploadRunningInfo autoUploadRunningInfo, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(autoUploadRunningInfo, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0062, code lost:
        
            if (r10.this$0.getJobService().jobSucceeded(r10.this$0.getJobId(), r10) == r1) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x00a3, code lost:
        
            if (r10.this$0.getJobService().jobFailed(r10.this$0.getJobId(), com.box.android.domain.jobs.JobType.AUTO_UPLOAD, r4, r10) == r1) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x00a5, code lost:
        
            return r1;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = r10.L$0
                com.box.android.data.jobs.AutoUploadRunningInfo r0 = (com.box.android.data.jobs.AutoUploadRunningInfo) r0
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r10.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L24
                if (r2 == r4) goto L1f
                if (r2 != r3) goto L17
                java.lang.Object r10 = r10.L$1
                com.box.android.domain.models.DomainError r10 = (com.box.android.domain.models.DomainError) r10
                goto L1f
            L17:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r11)
                throw r10
            L1f:
                kotlin.ResultKt.throwOnFailure(r11)
                goto La6
            L24:
                kotlin.ResultKt.throwOnFailure(r11)
                int r11 = r0.getTotalFiles()
                java.util.Set r2 = r0.getSucceededFiles()
                int r2 = r2.size()
                java.util.Map r5 = r0.getFailedFiles()
                int r5 = r5.size()
                int r6 = r2 + r5
                if (r2 != r11) goto L65
                com.box.android.data.jobs.AutoUploadJob r3 = com.box.android.data.jobs.AutoUploadJob.this
                com.box.android.data.jobs.JobService r3 = r3.getJobService()
                com.box.android.data.jobs.AutoUploadJob r7 = com.box.android.data.jobs.AutoUploadJob.this
                com.box.android.domain.jobs.JobId r7 = r7.getJobId()
                r8 = r10
                kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
                java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
                r10.L$0 = r0
                r10.I$0 = r11
                r10.I$1 = r2
                r10.I$2 = r5
                r10.I$3 = r6
                r10.label = r4
                java.lang.Object r10 = r3.jobSucceeded(r7, r8)
                if (r10 != r1) goto La6
                goto La5
            L65:
                if (r6 != r11) goto La6
                com.box.android.data.jobs.AutoUploadJob r4 = com.box.android.data.jobs.AutoUploadJob.this
                com.box.android.domain.models.DomainError r4 = r4.getLastRecordError()
                if (r4 != 0) goto L78
                com.box.android.domain.models.DomainError$UnknownError r4 = new com.box.android.domain.models.DomainError$UnknownError
                java.lang.String r7 = "Unknown error"
                r4.<init>(r7)
                com.box.android.domain.models.DomainError r4 = (com.box.android.domain.models.DomainError) r4
            L78:
                com.box.android.data.jobs.AutoUploadJob r7 = com.box.android.data.jobs.AutoUploadJob.this
                com.box.android.data.jobs.JobService r7 = r7.getJobService()
                com.box.android.data.jobs.AutoUploadJob r8 = com.box.android.data.jobs.AutoUploadJob.this
                com.box.android.domain.jobs.JobId r8 = r8.getJobId()
                r9 = r10
                kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
                java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
                r10.L$0 = r0
                java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r4)
                r10.L$1 = r0
                r10.I$0 = r11
                r10.I$1 = r2
                r10.I$2 = r5
                r10.I$3 = r6
                r10.label = r3
                java.lang.String r10 = "AutoUploadJob"
                java.lang.Object r10 = r7.jobFailed(r8, r10, r4, r9)
                if (r10 != r1) goto La6
            La5:
                return r1
            La6:
                kotlin.Unit r10 = kotlin.Unit.INSTANCE
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.AutoUploadJob.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Object checkCompletion(Continuation<? super Unit> continuation) {
        Object objUpdatingRunningInfo$default = updatingRunningInfo$default(this, false, new AnonymousClass2(null), continuation, 1, null);
        return objUpdatingRunningInfo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdatingRunningInfo$default : Unit.INSTANCE;
    }

    public static /* synthetic */ Object updatingRunningInfo$default(AutoUploadJob autoUploadJob, boolean z, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return autoUploadJob.updatingRunningInfo(z, function2, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0096  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0079, code lost:
    
        if (r9.withTransaction(r2, r0) == r1) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ad, code lost:
    
        if (r8.invoke(r6, r0) == r1) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object updatingRunningInfo(boolean r7, kotlin.jvm.functions.Function2<? super com.box.android.data.jobs.AutoUploadRunningInfo, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof com.box.android.data.jobs.AutoUploadJob.C12331
            if (r0 == 0) goto L14
            r0 = r9
            com.box.android.data.jobs.AutoUploadJob$updatingRunningInfo$1 r0 = (com.box.android.data.jobs.AutoUploadJob.C12331) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            com.box.android.data.jobs.AutoUploadJob$updatingRunningInfo$1 r0 = new com.box.android.data.jobs.AutoUploadJob$updatingRunningInfo$1
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L5a
            if (r2 == r5) goto L50
            if (r2 == r4) goto L45
            if (r2 != r3) goto L3d
            int r6 = r0.I$0
            boolean r6 = r0.Z$0
            java.lang.Object r6 = r0.L$1
            com.box.android.data.jobs.AutoUploadRunningInfo r6 = (com.box.android.data.jobs.AutoUploadRunningInfo) r6
            java.lang.Object r6 = r0.L$0
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            kotlin.ResultKt.throwOnFailure(r9)
            goto Lb0
        L3d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L45:
            boolean r7 = r0.Z$0
            java.lang.Object r6 = r0.L$0
            r8 = r6
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L8c
        L50:
            boolean r6 = r0.Z$0
            java.lang.Object r6 = r0.L$0
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            kotlin.ResultKt.throwOnFailure(r9)
            goto L7c
        L5a:
            kotlin.ResultKt.throwOnFailure(r9)
            if (r7 == 0) goto L7f
            com.box.android.data.jobs.JobService r9 = r6.getJobService()
            com.box.android.data.jobs.AutoUploadJob$updatingRunningInfo$2 r2 = new com.box.android.data.jobs.AutoUploadJob$updatingRunningInfo$2
            r3 = 0
            r2.<init>(r8, r3)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r0.L$0 = r6
            r0.Z$0 = r7
            r0.label = r5
            java.lang.Object r6 = r9.withTransaction(r2, r0)
            if (r6 != r1) goto L7c
            goto Laf
        L7c:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L7f:
            r0.L$0 = r8
            r0.Z$0 = r7
            r0.label = r4
            java.lang.Object r9 = r6.getRunningInfo(r0)
            if (r9 != r1) goto L8c
            goto Laf
        L8c:
            com.box.android.domain.utils.result.Result r9 = (com.box.android.domain.utils.result.Result) r9
            java.lang.Object r6 = com.box.android.domain.utils.result.ResultKt.getOrNull(r9)
            com.box.android.data.jobs.AutoUploadRunningInfo r6 = (com.box.android.data.jobs.AutoUploadRunningInfo) r6
            if (r6 == 0) goto Lb0
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r0.L$0 = r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$1 = r9
            r0.Z$0 = r7
            r7 = 0
            r0.I$0 = r7
            r0.label = r3
            java.lang.Object r6 = r8.invoke(r6, r0)
            if (r6 != r1) goto Lb0
        Laf:
            return r1
        Lb0:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.AutoUploadJob.updatingRunningInfo(boolean, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.AutoUploadJob$updatingRunningInfo$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AutoUploadJob.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.AutoUploadJob$updatingRunningInfo$2", f = "AutoUploadJob.kt", i = {1, 1}, l = {419, 420}, m = "invokeSuspend", n = {"it", "$i$a$-let-AutoUploadJob$updatingRunningInfo$2$1"}, s = {"L$0", "I$0"}, v = 1)
    static final class C12342 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<AutoUploadRunningInfo, Continuation<? super Unit>, Object> $updateRunningData;
        int I$0;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C12342(Function2<? super AutoUploadRunningInfo, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super C12342> continuation) {
            super(1, continuation);
            this.$updateRunningData = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return AutoUploadJob.this.new C12342(this.$updateRunningData, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C12342) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x004e, code lost:
        
            if (r1.invoke(r5, r4) == r0) goto L17;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r4.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L22
                if (r1 == r3) goto L1e
                if (r1 != r2) goto L16
                java.lang.Object r4 = r4.L$0
                com.box.android.data.jobs.AutoUploadRunningInfo r4 = (com.box.android.data.jobs.AutoUploadRunningInfo) r4
                kotlin.ResultKt.throwOnFailure(r5)
                goto L51
            L16:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L1e:
                kotlin.ResultKt.throwOnFailure(r5)
                goto L33
            L22:
                kotlin.ResultKt.throwOnFailure(r5)
                com.box.android.data.jobs.AutoUploadJob r5 = com.box.android.data.jobs.AutoUploadJob.this
                r1 = r4
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r4.label = r3
                java.lang.Object r5 = r5.getRunningInfo(r1)
                if (r5 != r0) goto L33
                goto L50
            L33:
                com.box.android.domain.utils.result.Result r5 = (com.box.android.domain.utils.result.Result) r5
                java.lang.Object r5 = com.box.android.domain.utils.result.ResultKt.getOrNull(r5)
                com.box.android.data.jobs.AutoUploadRunningInfo r5 = (com.box.android.data.jobs.AutoUploadRunningInfo) r5
                if (r5 == 0) goto L51
                kotlin.jvm.functions.Function2<com.box.android.data.jobs.AutoUploadRunningInfo, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r1 = r4.$updateRunningData
                java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
                r4.L$0 = r3
                r3 = 0
                r4.I$0 = r3
                r4.label = r2
                java.lang.Object r4 = r1.invoke(r5, r4)
                if (r4 != r0) goto L51
            L50:
                return r0
            L51:
                kotlin.Unit r4 = kotlin.Unit.INSTANCE
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.AutoUploadJob.C12342.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:37:0x0118 A[LOOP:0: B:33:0x00ef->B:37:0x0118, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:40:0x0168 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:41:0x0169  */
    /* JADX WARN: Code duplicated, block: B:53:0x012b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x0169 -> B:42:0x016b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object resolveUnknownPath(java.lang.String r18, com.box.android.data.jobs.AutoUploadJob.FolderMaps r19, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<kotlin.Unit, ? extends com.box.android.domain.models.DomainError>> r20) {
        /*
            Method dump skipped, instruction units count: 443
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.AutoUploadJob.resolveUnknownPath(java.lang.String, com.box.android.data.jobs.AutoUploadJob$FolderMaps, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object ensureFolderFetched(ItemId itemId, FolderMaps folderMaps, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        C12231 c12231;
        if (continuation instanceof C12231) {
            c12231 = (C12231) continuation;
            if ((c12231.label & Integer.MIN_VALUE) != 0) {
                c12231.label -= Integer.MIN_VALUE;
            } else {
                c12231 = new C12231(continuation);
            }
        } else {
            c12231 = new C12231(continuation);
        }
        Object objFetchFolderItemsFromRemote = c12231.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c12231.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objFetchFolderItemsFromRemote);
            if (folderMaps.getRecentlyFetchedFolders().contains(itemId)) {
                return new Result.Success(Unit.INSTANCE);
            }
            RemoteItemService remoteItemService = this.remoteItemService;
            c12231.L$0 = itemId;
            c12231.L$1 = folderMaps;
            c12231.label = 1;
            objFetchFolderItemsFromRemote = remoteItemService.fetchFolderItemsFromRemote(itemId, c12231);
            if (objFetchFolderItemsFromRemote == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            folderMaps = (FolderMaps) c12231.L$1;
            itemId = (ItemId) c12231.L$0;
            ResultKt.throwOnFailure(objFetchFolderItemsFromRemote);
        }
        Result result = (Result) objFetchFolderItemsFromRemote;
        if (result instanceof Result.Success) {
            folderMaps.getRecentlyFetchedFolders().add(itemId);
            return new Result.Success(Unit.INSTANCE);
        }
        if (result instanceof Result.Error) {
            return result;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00cb A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:36:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:38:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:41:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:54:0x0170  */
    /* JADX WARN: Code duplicated, block: B:57:0x010f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:58:0x0107 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:0x0113 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:61:0x00e2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x015c, code lost:
    
        if (r14 == r1) goto L48;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x015c -> B:49:0x015f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object scanRemoteFolderTree(com.box.android.domain.models.ItemId r11, com.box.android.data.jobs.AutoUploadJob.FolderMaps r12, java.lang.String r13, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<kotlin.Unit, ? extends com.box.android.domain.models.DomainError>> r14) {
        /*
            Method dump skipped, instruction units count: 374
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.AutoUploadJob.scanRemoteFolderTree(com.box.android.domain.models.ItemId, com.box.android.data.jobs.AutoUploadJob$FolderMaps, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0055, code lost:
    
        if (r6 == r1) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getOrCreateRunningInfo(kotlin.coroutines.Continuation<? super com.box.android.data.jobs.AutoUploadRunningInfo> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.box.android.data.jobs.AutoUploadJob.C12241
            if (r0 == 0) goto L14
            r0 = r6
            com.box.android.data.jobs.AutoUploadJob$getOrCreateRunningInfo$1 r0 = (com.box.android.data.jobs.AutoUploadJob.C12241) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            com.box.android.data.jobs.AutoUploadJob$getOrCreateRunningInfo$1 r0 = new com.box.android.data.jobs.AutoUploadJob$getOrCreateRunningInfo$1
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
            goto L58
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L45
        L39:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.label = r4
            java.lang.Object r6 = r5.getRunningInfo(r0)
            if (r6 != r1) goto L45
            goto L57
        L45:
            com.box.android.domain.utils.result.Result r6 = (com.box.android.domain.utils.result.Result) r6
            java.lang.Object r6 = com.box.android.domain.utils.result.ResultKt.getOrNull(r6)
            com.box.android.data.jobs.AutoUploadRunningInfo r6 = (com.box.android.data.jobs.AutoUploadRunningInfo) r6
            if (r6 != 0) goto L7d
            r0.label = r3
            java.lang.Object r6 = r5.initialRunningInfo(r0)
            if (r6 != r1) goto L58
        L57:
            return r1
        L58:
            com.box.android.domain.utils.result.Result r6 = (com.box.android.domain.utils.result.Result) r6
            boolean r5 = r6 instanceof com.box.android.domain.utils.result.Result.Success
            if (r5 == 0) goto L67
            com.box.android.domain.utils.result.Result$Success r6 = (com.box.android.domain.utils.result.Result.Success) r6
            java.lang.Object r5 = r6.getValue()
            com.box.android.data.jobs.AutoUploadRunningInfo r5 = (com.box.android.data.jobs.AutoUploadRunningInfo) r5
            return r5
        L67:
            boolean r5 = r6 instanceof com.box.android.domain.utils.result.Result.Error
            if (r5 == 0) goto L77
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "Failed to create initial running info"
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        L77:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        L7d:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.AutoUploadJob.getOrCreateRunningInfo(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:33:0x014d  */
    /* JADX WARN: Code duplicated, block: B:35:0x0155  */
    /* JADX WARN: Code duplicated, block: B:37:0x0159 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:38:0x015a  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object initialRunningInfo(Continuation<? super Result<AutoUploadRunningInfo, ? extends DomainError>> continuation) {
        C12261 c12261;
        ILocalAutoContentUploadInformation iLocalAutoContentUploadInformation;
        String uploadFolderId;
        ItemId.Remote remote;
        String uploadFolder;
        long lastAutoUploadSyncTime;
        boolean zIsShouldNotify;
        long j;
        AutoUploadRunningInfo autoUploadRunningInfo;
        Result result;
        if (continuation instanceof C12261) {
            c12261 = (C12261) continuation;
            if ((c12261.label & Integer.MIN_VALUE) != 0) {
                c12261.label -= Integer.MIN_VALUE;
            } else {
                c12261 = new C12261(continuation);
            }
        } else {
            c12261 = new C12261(continuation);
        }
        Object obj = c12261.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c12261.label;
        if (i != 0) {
            if (i == 1) {
                zIsShouldNotify = c12261.Z$0;
                long j2 = c12261.J$1;
                lastAutoUploadSyncTime = c12261.J$0;
                uploadFolder = (String) c12261.L$3;
                remote = (ItemId.Remote) c12261.L$2;
                uploadFolderId = (String) c12261.L$1;
                iLocalAutoContentUploadInformation = (ILocalAutoContentUploadInformation) c12261.L$0;
                ResultKt.throwOnFailure(obj);
                j = j2;
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                boolean z = c12261.Z$0;
                long j3 = c12261.J$1;
                long j4 = c12261.J$0;
                autoUploadRunningInfo = (AutoUploadRunningInfo) c12261.L$4;
                ResultKt.throwOnFailure(obj);
            }
            result = (Result) obj;
            if (result instanceof Result.Success) {
                return new Result.Success(autoUploadRunningInfo);
            }
            if (result instanceof Result.Error) {
                return result;
            }
            throw new NoWhenBranchMatchedException();
        }
        ResultKt.throwOnFailure(obj);
        IUserContextComponent userContextComponent = this.userContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.LOCAL_AUTO_CONTENT_UPLOAD_INFORMATION);
        Intrinsics.checkNotNull(userContextComponent, "null cannot be cast to non-null type com.box.android.domain.localrepo.ILocalAutoContentUploadInformation");
        iLocalAutoContentUploadInformation = (ILocalAutoContentUploadInformation) userContextComponent;
        uploadFolderId = iLocalAutoContentUploadInformation.getUploadFolderId();
        if (uploadFolderId == null) {
            throw new IllegalStateException("Failed to get the Upload folder id".toString());
        }
        remote = new ItemId.Remote(uploadFolderId, ItemType.FOLDER);
        uploadFolder = iLocalAutoContentUploadInformation.getUploadFolder();
        if (uploadFolder == null) {
            throw new IllegalStateException("Failed to get the source folder path".toString());
        }
        lastAutoUploadSyncTime = iLocalAutoContentUploadInformation.getLastAutoUploadSyncTime();
        long syncEnabledTime = iLocalAutoContentUploadInformation.getSyncEnabledTime();
        zIsShouldNotify = iLocalAutoContentUploadInformation.isShouldNotify();
        JobService jobService = getJobService();
        JobId jobId = this.jobId;
        Map<String, ? extends Object> mapMapOf = MapsKt.mapOf(TuplesKt.to(MetricKeysParam.METRIC_FILE_ID, remote.toString()));
        c12261.L$0 = SpillingKt.nullOutSpilledVariable(iLocalAutoContentUploadInformation);
        c12261.L$1 = SpillingKt.nullOutSpilledVariable(uploadFolderId);
        c12261.L$2 = remote;
        c12261.L$3 = uploadFolder;
        c12261.J$0 = lastAutoUploadSyncTime;
        c12261.J$1 = syncEnabledTime;
        c12261.Z$0 = zIsShouldNotify;
        c12261.label = 1;
        if (jobService.updateLogData(jobId, mapMapOf, c12261) != coroutine_suspended) {
            j = syncEnabledTime;
        }
        return coroutine_suspended;
        boolean z2 = zIsShouldNotify;
        long j5 = lastAutoUploadSyncTime;
        if (!RealPathUtils.INSTANCE.fileExists(uploadFolder)) {
            throw new IllegalStateException("Source directory does not exist".toString());
        }
        String str = uploadFolder;
        AutoUploadRunningInfo autoUploadRunningInfo2 = new AutoUploadRunningInfo(remote.toString(), str, j5, j, z2, 0, MapsKt.emptyMap(), SetsKt.emptySet(), MapsKt.emptyMap(), MapsKt.emptyMap());
        JobService jobService2 = getJobService();
        byte[] bArrRunningInfoToByteArray = runningInfoToByteArray(autoUploadRunningInfo2);
        JobId jobId2 = this.jobId;
        c12261.L$0 = SpillingKt.nullOutSpilledVariable(iLocalAutoContentUploadInformation);
        c12261.L$1 = SpillingKt.nullOutSpilledVariable(uploadFolderId);
        c12261.L$2 = SpillingKt.nullOutSpilledVariable(remote);
        c12261.L$3 = SpillingKt.nullOutSpilledVariable(str);
        c12261.L$4 = autoUploadRunningInfo2;
        c12261.J$0 = j5;
        c12261.J$1 = j;
        c12261.Z$0 = z2;
        c12261.label = 2;
        Object objUpdateRunningInfo = jobService2.updateRunningInfo(bArrRunningInfoToByteArray, jobId2, c12261);
        if (objUpdateRunningInfo != coroutine_suspended) {
            obj = objUpdateRunningInfo;
            autoUploadRunningInfo = autoUploadRunningInfo2;
            result = (Result) obj;
            if (result instanceof Result.Success) {
                return new Result.Success(autoUploadRunningInfo);
            }
            if (result instanceof Result.Error) {
                return result;
            }
            throw new NoWhenBranchMatchedException();
        }
        return coroutine_suspended;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getRunningInfo(Continuation<? super Result<AutoUploadRunningInfo, ? extends DomainError>> continuation) {
        C12251 c12251;
        if (continuation instanceof C12251) {
            c12251 = (C12251) continuation;
            if ((c12251.label & Integer.MIN_VALUE) != 0) {
                c12251.label -= Integer.MIN_VALUE;
            } else {
                c12251 = new C12251(continuation);
            }
        } else {
            c12251 = new C12251(continuation);
        }
        Object runningInfo = c12251.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c12251.label;
        if (i == 0) {
            ResultKt.throwOnFailure(runningInfo);
            JobService jobService = getJobService();
            JobId jobId = this.jobId;
            c12251.label = 1;
            runningInfo = jobService.getRunningInfo(jobId, c12251);
            if (runningInfo == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(runningInfo);
        }
        Result result = (Result) runningInfo;
        if (result instanceof Result.Success) {
            byte[] bArr = (byte[]) ((Result.Success) result).getValue();
            return new Result.Success(bArr == null ? null : byteArrayToRunningInfo(bArr));
        }
        if (result instanceof Result.Error) {
            return result;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.box.android.data.jobs.Job
    public Object cleanup(Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.box.android.data.jobs.Job
    public Object shouldBeRemovedFromDbOnSuccess(Continuation<? super Boolean> continuation) {
        return Boxing.boxBoolean(true);
    }

    @Override // com.box.android.domain.models.MetricsInfoProvider
    public String getAmplitudeJobType() {
        return "auto_upload";
    }

    @Override // com.box.android.domain.models.MetricsInfoProvider
    public Object getAmplitudeInfos(Continuation<? super Map<String, ? extends Object>> continuation) {
        return MapsKt.emptyMap();
    }

    public final byte[] runningInfoToByteArray(AutoUploadRunningInfo runningInfo) {
        Intrinsics.checkNotNullParameter(runningInfo, "runningInfo");
        String json = this.moshi.adapter(AutoUploadRunningInfo.class).toJson(runningInfo);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        byte[] bytes = json.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return bytes;
    }

    public final AutoUploadRunningInfo byteArrayToRunningInfo(byte[] byteArray) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        String str = new String(byteArray, Charsets.UTF_8);
        JsonAdapter jsonAdapterAdapter = this.moshi.adapter(AutoUploadRunningInfo.class);
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter, "adapter(...)");
        AutoUploadRunningInfo autoUploadRunningInfo = (AutoUploadRunningInfo) AnnotationEntityDomainMapperKt.fromJsonOrNull(jsonAdapterAdapter, str);
        if (autoUploadRunningInfo != null) {
            return autoUploadRunningInfo;
        }
        throw new IllegalStateException("Failed to parse running info from JSON ".concat(str).toString());
    }

    @Override // com.box.android.domain.models.DisplayableJob
    public IJobDisplayInfoProvider getJobDisplayInfoProvider() {
        ItemId.Companion companion = ItemId.INSTANCE;
        String string = this.inputData.getString(BOX_FOLDER_ID_PARAM);
        Intrinsics.checkNotNull(string);
        ItemId itemIdCreate = companion.create(string);
        String string2 = this.inputData.getString(DEVICE_SOURCE_FOLDER_PATH_PATH);
        Intrinsics.checkNotNull(string2);
        return new AutoUploadFolderJobDisplayInfoProvider(itemIdCreate, string2, this.localItemService);
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.AutoUploadJob$childSucceeded$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AutoUploadJob.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "runningInfo", "Lcom/box/android/data/jobs/AutoUploadRunningInfo;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.AutoUploadJob$childSucceeded$2", f = "AutoUploadJob.kt", i = {0, 0, 1, 1, 2, 2}, l = {643, 644, 645}, m = "invokeSuspend", n = {"runningInfo", "newRunningInfo", "runningInfo", "newRunningInfo", "runningInfo", "newRunningInfo"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1"}, v = 1)
    static final class C12222 extends SuspendLambda implements Function2<AutoUploadRunningInfo, Continuation<? super Unit>, Object> {
        final /* synthetic */ JobId $childJobId;
        /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ AutoUploadJob this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12222(JobId jobId, AutoUploadJob autoUploadJob, Continuation<? super C12222> continuation) {
            super(2, continuation);
            this.$childJobId = jobId;
            this.this$0 = autoUploadJob;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C12222 c12222 = new C12222(this.$childJobId, this.this$0, continuation);
            c12222.L$0 = obj;
            return c12222;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AutoUploadRunningInfo autoUploadRunningInfo, Continuation<? super Unit> continuation) {
            return ((C12222) create(autoUploadRunningInfo, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x00e6, code lost:
        
            if (r21.this$0.checkCompletion(r21) == r4) goto L20;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r22) {
            /*
                Method dump skipped, instruction units count: 236
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.AutoUploadJob.C12222.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // com.box.android.data.jobs.ParentJob
    public Object childSucceeded(JobId jobId, Continuation<? super Unit> continuation) {
        Object objUpdatingRunningInfo$default = updatingRunningInfo$default(this, false, new C12222(jobId, this, null), continuation, 1, null);
        return objUpdatingRunningInfo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdatingRunningInfo$default : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.AutoUploadJob$childFailed$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AutoUploadJob.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "runningInfo", "Lcom/box/android/data/jobs/AutoUploadRunningInfo;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.AutoUploadJob$childFailed$2", f = "AutoUploadJob.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}, l = {659, 660, 662}, m = "invokeSuspend", n = {"runningInfo", BoxCommonConstants.EXTRA_FILE_NAME, "it", "newRunningInfo", "$i$a$-let-AutoUploadJob$childFailed$2$1", "runningInfo", BoxCommonConstants.EXTRA_FILE_NAME, "it", "newRunningInfo", "$i$a$-let-AutoUploadJob$childFailed$2$1", "runningInfo", BoxCommonConstants.EXTRA_FILE_NAME}, s = {"L$0", "L$1", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1"}, v = 1)
    static final class C12212 extends SuspendLambda implements Function2<AutoUploadRunningInfo, Continuation<? super Unit>, Object> {
        final /* synthetic */ JobId $childJobId;
        int I$0;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        final /* synthetic */ AutoUploadJob this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12212(JobId jobId, AutoUploadJob autoUploadJob, Continuation<? super C12212> continuation) {
            super(2, continuation);
            this.$childJobId = jobId;
            this.this$0 = autoUploadJob;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C12212 c12212 = new C12212(this.$childJobId, this.this$0, continuation);
            c12212.L$0 = obj;
            return c12212;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AutoUploadRunningInfo autoUploadRunningInfo, Continuation<? super Unit> continuation) {
            return ((C12212) create(autoUploadRunningInfo, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0118, code lost:
        
            if (r1 == r5) goto L25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x013e, code lost:
        
            if (r23.this$0.checkCompletion(r23) == r5) goto L25;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r24) {
            /*
                Method dump skipped, instruction units count: 324
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.AutoUploadJob.C12212.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // com.box.android.data.jobs.ParentJob
    public Object childFailed(JobId jobId, DomainError domainError, Continuation<? super Unit> continuation) {
        this.lastRecordError = domainError;
        Object objUpdatingRunningInfo$default = updatingRunningInfo$default(this, false, new C12212(jobId, this, null), continuation, 1, null);
        return objUpdatingRunningInfo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdatingRunningInfo$default : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0085  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x009e, code lost:
    
        if (setProgressAndEstimatedWork(r15, r0) == r1) goto L27;
     */
    @Override // com.box.android.data.jobs.ParentJob
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object childProgressed(com.box.android.domain.jobs.JobId r10, double r11, double r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            r9 = this;
            boolean r0 = r15 instanceof com.box.android.data.jobs.AutoUploadJob.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r15
            com.box.android.data.jobs.AutoUploadJob$childProgressed$1 r0 = (com.box.android.data.jobs.AutoUploadJob.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L19
        L14:
            com.box.android.data.jobs.AutoUploadJob$childProgressed$1 r0 = new com.box.android.data.jobs.AutoUploadJob$childProgressed$1
            r0.<init>(r15)
        L19:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4f
            if (r2 == r4) goto L43
            if (r2 != r3) goto L3b
            int r9 = r0.I$0
            double r9 = r0.D$1
            double r9 = r0.D$0
            java.lang.Object r9 = r0.L$1
            com.box.android.data.jobs.AutoUploadRunningInfo r9 = (com.box.android.data.jobs.AutoUploadRunningInfo) r9
            java.lang.Object r9 = r0.L$0
            com.box.android.domain.jobs.JobId r9 = (com.box.android.domain.jobs.JobId) r9
            kotlin.ResultKt.throwOnFailure(r15)
            goto La1
        L3b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L43:
            double r13 = r0.D$1
            double r11 = r0.D$0
            java.lang.Object r10 = r0.L$0
            com.box.android.domain.jobs.JobId r10 = (com.box.android.domain.jobs.JobId) r10
            kotlin.ResultKt.throwOnFailure(r15)
            goto L7b
        L4f:
            kotlin.ResultKt.throwOnFailure(r15)
            com.google.common.util.concurrent.AtomicDouble r15 = r9.progress
            double r5 = r15.get()
            r7 = 0
            int r15 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r15 < 0) goto L68
            com.google.common.util.concurrent.AtomicDouble r15 = r9.estimatedWork
            double r5 = r15.get()
            int r15 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r15 >= 0) goto La1
        L68:
            java.lang.Object r15 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r0.L$0 = r15
            r0.D$0 = r11
            r0.D$1 = r13
            r0.label = r4
            java.lang.Object r15 = r9.getRunningInfo(r0)
            if (r15 != r1) goto L7b
            goto La0
        L7b:
            com.box.android.domain.utils.result.Result r15 = (com.box.android.domain.utils.result.Result) r15
            java.lang.Object r15 = com.box.android.domain.utils.result.ResultKt.getOrNull(r15)
            com.box.android.data.jobs.AutoUploadRunningInfo r15 = (com.box.android.data.jobs.AutoUploadRunningInfo) r15
            if (r15 == 0) goto La1
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r0.L$0 = r10
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r0.L$1 = r10
            r0.D$0 = r11
            r0.D$1 = r13
            r10 = 0
            r0.I$0 = r10
            r0.label = r3
            java.lang.Object r9 = r9.setProgressAndEstimatedWork(r15, r0)
            if (r9 != r1) goto La1
        La0:
            return r1
        La1:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.AutoUploadJob.childProgressed(com.box.android.domain.jobs.JobId, double, double, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object setProgressAndEstimatedWork(AutoUploadRunningInfo autoUploadRunningInfo, Continuation<? super Unit> continuation) {
        AtomicDouble atomicDouble = this.progress;
        Iterator<T> it = autoUploadRunningInfo.getSucceededFiles().iterator();
        double dDoubleValue = 0.0d;
        while (it.hasNext()) {
            dDoubleValue += autoUploadRunningInfo.getSizes().getOrDefault((String) it.next(), Boxing.boxDouble(0.0d)).doubleValue();
        }
        atomicDouble.set(dDoubleValue);
        this.estimatedWork.set(CollectionsKt.sumOfDouble(autoUploadRunningInfo.getSizes().values()));
        Object objUpdateLogData = getJobService().updateLogData(this.jobId, MapsKt.mapOf(TuplesKt.to(MetricKeysParam.METRIC_BYTES_PROCESSED, Boxing.boxLong((long) this.progress.get())), TuplesKt.to(MetricKeysParam.METRIC_FILE_SIZE, Boxing.boxLong((long) this.estimatedWork.get()))), continuation);
        return objUpdateLogData == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdateLogData : Unit.INSTANCE;
    }

    @Override // com.box.android.data.jobs.ParentJob
    public Object receiveFromChild(JobId jobId, byte[] bArr, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }
}
