package com.box.android.data.jobs;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.work.Data;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.coreservices.models.BoxAccountManager;
import com.box.android.coreservices.models.BoxModelOfflineManager;
import com.box.android.data.mappers.annotation.AnnotationEntityDomainMapperKt;
import com.box.android.data.persistence.jobs.JobEntity;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.configuration.DataPolicy;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.jobs.JobConstants;
import com.box.android.domain.jobs.JobId;
import com.box.android.domain.jobs.JobRequest;
import com.box.android.domain.jobs.JobType;
import com.box.android.domain.mappers.ItemModelMapper;
import com.box.android.domain.models.AdminSettingsDomainError;
import com.box.android.domain.models.DisplayableJob;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.IJobDisplayInfoProvider;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.MarkForOfflineJobDisplayInfoProvider;
import com.box.android.domain.models.MetricKeysParam;
import com.box.android.domain.models.MetricsInfoProvider;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.ItemModelKt;
import com.box.android.domain.models.item.PermissionsModel;
import com.box.android.domain.services.IRemoteItemService;
import com.box.android.domain.utils.SupportedFileExtensions;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxRepresentation;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import com.facebook.react.modules.dialog.AlertFragment;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedFactory;
import dagger.assisted.AssistedInject;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.apache.hc.core5.http.HttpStatus;

/* JADX INFO: compiled from: MarkForOfflineFolderJob.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 {2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002{|BE\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u000e\u00107\u001a\u000208H\u0096@¢\u0006\u0002\u00109J\u0016\u0010:\u001a\u0002082\u0006\u0010;\u001a\u00020!H\u0082@¢\u0006\u0002\u0010<J\"\u0010=\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u0002000>2\u0006\u0010?\u001a\u00020@H\u0082@¢\u0006\u0002\u0010AJ\f\u0010B\u001a\u00020C*\u00020DH\u0002J\u001c\u0010E\u001a\u0002082\f\u0010F\u001a\b\u0012\u0004\u0012\u00020D0GH\u0082@¢\u0006\u0002\u0010HJH\u0010I\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00020K0G\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020M\u0012\u0004\u0012\u00020M0L0J2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020D0G2\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u00020M\u0012\u0004\u0012\u00020M0LH\u0002J\u0016\u0010O\u001a\u0002082\u0006\u0010;\u001a\u00020!H\u0082@¢\u0006\u0002\u0010<J\u001a\u0010P\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u0002000>2\u0006\u0010;\u001a\u00020!J\"\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u0002000>2\u0006\u0010?\u001a\u00020@H\u0086@¢\u0006\u0002\u0010AJ\u001c\u0010R\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010*\u0012\u0004\u0012\u0002000>H\u0086@¢\u0006\u0002\u00109J\u0010\u0010S\u001a\u00020*2\u0006\u0010T\u001a\u00020UH\u0007J\u001a\u0010V\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u0002000>H\u0087@¢\u0006\u0002\u00109J\u0010\u0010W\u001a\u00020U2\u0006\u0010X\u001a\u00020*H\u0007J\u0016\u0010Y\u001a\u0002082\u0006\u0010Z\u001a\u000200H\u0082@¢\u0006\u0002\u0010[J\u000e\u0010\\\u001a\u000208H\u0096@¢\u0006\u0002\u00109J\u000e\u0010]\u001a\u00020CH\u0096@¢\u0006\u0002\u00109J\u0018\u0010^\u001a\u00020C2\u0006\u0010_\u001a\u00020\u00072\u0006\u0010X\u001a\u00020*H\u0002J\u0016\u0010`\u001a\u0002082\u0006\u0010_\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010aJ\u001e\u0010b\u001a\u0002082\u0006\u0010_\u001a\u00020\u00072\u0006\u0010c\u001a\u000200H\u0096@¢\u0006\u0002\u0010dJ\u0016\u0010e\u001a\u0002082\u0006\u0010X\u001a\u00020*H\u0087@¢\u0006\u0002\u0010fJ<\u0010g\u001a\u0002082\b\b\u0002\u0010h\u001a\u00020C2\"\u0010i\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020*\u0012\n\u0012\b\u0012\u0004\u0012\u0002080k\u0012\u0006\u0012\u0004\u0018\u00010l0jH\u0086@¢\u0006\u0002\u0010mJ&\u0010n\u001a\u0002082\u0006\u0010_\u001a\u00020\u00072\u0006\u0010o\u001a\u00020p2\u0006\u0010q\u001a\u00020pH\u0096@¢\u0006\u0002\u0010rJ\u001e\u0010s\u001a\u0002082\u0006\u0010_\u001a\u00020\u00072\u0006\u0010t\u001a\u00020UH\u0096@¢\u0006\u0002\u0010uJ\b\u0010v\u001a\u00020wH\u0016J\b\u0010x\u001a\u00020CH\u0016J\b\u0010y\u001a\u00020MH\u0016J\u001a\u0010z\u001a\u000e\u0012\u0004\u0012\u00020M\u0012\u0004\u0012\u00020l0LH\u0096@¢\u0006\u0002\u00109R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b$\u0010%R?\u0010(\u001a&\u0012\f\u0012\n +*\u0004\u0018\u00010*0* +*\u0012\u0012\f\u0012\n +*\u0004\u0018\u00010*0*\u0018\u00010)0)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010'\u001a\u0004\b,\u0010-R&\u0010/\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u0006}"}, d2 = {"Lcom/box/android/data/jobs/MarkForOfflineFolderJob;", "Lcom/box/android/data/jobs/ParentJob;", "Lcom/box/android/domain/models/DisplayableJob;", "Lcom/box/android/domain/models/MetricsInfoProvider;", "moshi", "Lcom/squareup/moshi/Moshi;", JobWorker.JOB_ID_PARAM, "Lcom/box/android/domain/jobs/JobId;", "inputData", "Landroidx/work/Data;", "appContext", "Landroid/content/Context;", "jobService", "Lcom/box/android/data/jobs/JobService;", "remoteItemService", "Lcom/box/android/domain/services/IRemoteItemService;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "<init>", "(Lcom/squareup/moshi/Moshi;Lcom/box/android/domain/jobs/JobId;Landroidx/work/Data;Landroid/content/Context;Lcom/box/android/data/jobs/JobService;Lcom/box/android/domain/services/IRemoteItemService;Lcom/box/android/domain/identity/IUserContextManager;)V", "getJobId", "()Lcom/box/android/domain/jobs/JobId;", "getInputData", "()Landroidx/work/Data;", "getAppContext", "()Landroid/content/Context;", "getJobService", "()Lcom/box/android/data/jobs/JobService;", "getRemoteItemService", "()Lcom/box/android/domain/services/IRemoteItemService;", "getUserContextManager", "()Lcom/box/android/domain/identity/IUserContextManager;", "cachedFolderModel", "Lcom/box/android/domain/models/item/FolderModel;", "userPrefs", "Landroid/content/SharedPreferences;", "getUserPrefs", "()Landroid/content/SharedPreferences;", "userPrefs$delegate", "Lkotlin/Lazy;", "runningInfoAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/box/android/data/jobs/MarkForOfflineFolderRunningInfo;", "kotlin.jvm.PlatformType", "getRunningInfoAdapter", "()Lcom/squareup/moshi/JsonAdapter;", "runningInfoAdapter$delegate", "lastRecordError", "Lcom/box/android/domain/models/DomainError;", "getLastRecordError$annotations", "()V", "getLastRecordError", "()Lcom/box/android/domain/models/DomainError;", "setLastRecordError", "(Lcom/box/android/domain/models/DomainError;)V", "start", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markFolderOfflineStarted", "folderModel", "(Lcom/box/android/domain/models/item/FolderModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processFolderItems", "Lcom/box/android/domain/utils/result/Result;", "remoteId", "Lcom/box/android/domain/models/ItemId$Remote;", "(Lcom/box/android/domain/models/ItemId$Remote;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isUnsupportedOfflineItem", "", "Lcom/box/android/domain/models/item/ItemModel;", "enqueueChildJobs", AlertFragment.ARG_ITEMS, "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createJobRequestsForItems", "Lkotlin/Pair;", "Lcom/box/android/domain/jobs/JobRequest;", "", "", "existingChildJobMap", "markFolderOfflineCompleted", "validateOfflineEligibility", "getFolderModel", "getRunningInfo", "byteArrayToRunningInfo", "byteArray", "", "initialRunningInfo", "runningInfoToByteArray", "runningInfo", "markNotOfflinedAndFailJob", "error", "(Lcom/box/android/domain/models/DomainError;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cleanup", "shouldBeRemovedFromDbOnSuccess", "isChildJob", "childJobId", "childSucceeded", "(Lcom/box/android/domain/jobs/JobId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "childFailed", "domainError", "(Lcom/box/android/domain/jobs/JobId;Lcom/box/android/domain/models/DomainError;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkCompletionInTransaction", "(Lcom/box/android/data/jobs/MarkForOfflineFolderRunningInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatingRunningInfo", "isLockNeeded", "updateRunningData", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(ZLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "childProgressed", "currentProgress", "", "estimatedWork", "(Lcom/box/android/domain/jobs/JobId;DDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveFromChild", BoxRepresentation.FIELD_INFO, "(Lcom/box/android/domain/jobs/JobId;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getJobDisplayInfoProvider", "Lcom/box/android/domain/models/IJobDisplayInfoProvider;", "shouldDisplay", "getAmplitudeJobType", "getAmplitudeInfos", "Companion", "Factory", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MarkForOfflineFolderJob implements ParentJob, DisplayableJob, MetricsInfoProvider {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String IS_USER_OFFLINED = "isUserOfflined";
    public static final String REMOTE_ITEM_ID_PARAM = "remoteIdParam";
    public static final String TRY_DOWNLOAD_ORIGINAL = "tryDownloadOriginal";
    private final Context appContext;
    private FolderModel cachedFolderModel;
    private final Data inputData;
    private final JobId jobId;
    private final JobService jobService;
    private DomainError lastRecordError;
    private final Moshi moshi;
    private final IRemoteItemService remoteItemService;

    /* JADX INFO: renamed from: runningInfoAdapter$delegate, reason: from kotlin metadata */
    private final Lazy runningInfoAdapter;
    private final IUserContextManager userContextManager;

    /* JADX INFO: renamed from: userPrefs$delegate, reason: from kotlin metadata */
    private final Lazy userPrefs;

    /* JADX INFO: compiled from: MarkForOfflineFolderJob.kt */
    @AssistedFactory
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/box/android/data/jobs/MarkForOfflineFolderJob$Factory;", "", "createJob", "Lcom/box/android/data/jobs/MarkForOfflineFolderJob;", JobWorker.JOB_ID_PARAM, "Lcom/box/android/domain/jobs/JobId;", "inputData", "Landroidx/work/Data;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface Factory {
        MarkForOfflineFolderJob createJob(JobId jobId, Data inputData);
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.MarkForOfflineFolderJob$checkCompletionInTransaction$1, reason: invalid class name */
    /* JADX INFO: compiled from: MarkForOfflineFolderJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.MarkForOfflineFolderJob", f = "MarkForOfflineFolderJob.kt", i = {0, 0, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6}, l = {405, 408, 420, HttpStatus.SC_UPGRADE_REQUIRED, HttpStatus.SC_PRECONDITION_REQUIRED, 429, 432}, m = "checkCompletionInTransaction", n = {"runningInfo", "completedCount", "runningInfo", "completedCount", "runningInfo", "error", "completedCount", "runningInfo", "remoteItemId", "completedCount", "runningInfo", "remoteItemId", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "completedCount", "runningInfo", "remoteItemId", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "completedCount", "runningInfo", "remoteItemId", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "completedCount"}, s = {"L$0", "I$0", "L$0", "I$0", "L$0", "L$1", "I$0", "L$0", "L$1", "I$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "I$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
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
            return MarkForOfflineFolderJob.this.checkCompletionInTransaction(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.MarkForOfflineFolderJob$getFolderModel$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MarkForOfflineFolderJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.MarkForOfflineFolderJob", f = "MarkForOfflineFolderJob.kt", i = {0}, l = {259}, m = "getFolderModel", n = {"remoteId"}, s = {"L$0"}, v = 1)
    static final class C13041 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C13041(Continuation<? super C13041> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MarkForOfflineFolderJob.this.getFolderModel(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.MarkForOfflineFolderJob$getRunningInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MarkForOfflineFolderJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.MarkForOfflineFolderJob", f = "MarkForOfflineFolderJob.kt", i = {}, l = {272}, m = "getRunningInfo", n = {}, s = {}, v = 1)
    static final class C13051 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C13051(Continuation<? super C13051> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MarkForOfflineFolderJob.this.getRunningInfo(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.MarkForOfflineFolderJob$initialRunningInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MarkForOfflineFolderJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.MarkForOfflineFolderJob", f = "MarkForOfflineFolderJob.kt", i = {0, 1, 1, 2, 2, 2}, l = {292, BoxCommonConstants.REQUEST_DISABLE_DOWNLOADS, 314}, m = "initialRunningInfo", n = {"remoteItemId", "remoteItemId", "itemModel", "remoteItemId", "itemModel", "newRunningInfo"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2"}, v = 1)
    static final class C13061 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C13061(Continuation<? super C13061> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MarkForOfflineFolderJob.this.initialRunningInfo(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.MarkForOfflineFolderJob$markNotOfflinedAndFailJob$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MarkForOfflineFolderJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.MarkForOfflineFolderJob", f = "MarkForOfflineFolderJob.kt", i = {0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3}, l = {335, 336, 337, 346}, m = "markNotOfflinedAndFailJob", n = {"error", "isUserOfflined", "error", "runningInfo", "isUserOfflined", "$i$a$-let-MarkForOfflineFolderJob$markNotOfflinedAndFailJob$2", "error", "runningInfo", "folderModel", "isUserOfflined", "$i$a$-let-MarkForOfflineFolderJob$markNotOfflinedAndFailJob$2", "$i$a$-let-MarkForOfflineFolderJob$markNotOfflinedAndFailJob$2$1", "error", "isUserOfflined"}, s = {"L$0", "Z$0", "L$0", "L$1", "Z$0", "I$0", "L$0", "L$1", "L$2", "Z$0", "I$0", "I$1", "L$0", "Z$0"}, v = 1)
    static final class C13071 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C13071(Continuation<? super C13071> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MarkForOfflineFolderJob.this.markNotOfflinedAndFailJob(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.MarkForOfflineFolderJob$processFolderItems$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MarkForOfflineFolderJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.MarkForOfflineFolderJob", f = "MarkForOfflineFolderJob.kt", i = {0, 1, 2, 2, 2, 2, 2, 2}, l = {138, 139, Token.LOCAL_BLOCK}, m = "processFolderItems", n = {"remoteId", "remoteId", "remoteId", "$this$map$iv", AlertFragment.ARG_ITEMS, "offlineableItems", "$i$f$map", "$i$a$-map-MarkForOfflineFolderJob$processFolderItems$2"}, s = {"L$0", "L$0", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1"}, v = 1)
    static final class C13081 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C13081(Continuation<? super C13081> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MarkForOfflineFolderJob.this.processFolderItems(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.MarkForOfflineFolderJob$start$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MarkForOfflineFolderJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.MarkForOfflineFolderJob", f = "MarkForOfflineFolderJob.kt", i = {2, 2, 3, 3, 3, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10}, l = {93, 94, 95, 97, 103, 105, 110, 113, 115, 117, 120}, m = "start", n = {"$this$start_u24lambda_u240", "$i$a$-run-MarkForOfflineFolderJob$start$runningInfo$1", "$this$start_u24lambda_u240", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "$i$a$-run-MarkForOfflineFolderJob$start$runningInfo$1", "runningInfo", "remoteId", "runningInfo", "remoteId", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "runningInfo", "remoteId", "folderModel", "$this$onError$iv", "it", "$i$f$onError", "$i$a$-onError-MarkForOfflineFolderJob$start$2", "runningInfo", "remoteId", "folderModel", "runningInfo", "remoteId", "folderModel", "runningInfo", "remoteId", "folderModel", "$this$onError$iv", "it", "$i$f$onError", "$i$a$-onError-MarkForOfflineFolderJob$start$3", "runningInfo", "remoteId", "folderModel"}, s = {"L$0", "I$0", "L$0", "L$1", "I$0", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "L$0", "L$1", "L$2"}, v = 1)
    static final class C13091 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C13091(Continuation<? super C13091> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MarkForOfflineFolderJob.this.start(this);
        }
    }

    public static /* synthetic */ void getLastRecordError$annotations() {
    }

    @AssistedInject
    public MarkForOfflineFolderJob(Moshi moshi, @Assisted JobId jobId, @Assisted Data inputData, Context appContext, JobService jobService, IRemoteItemService remoteItemService, IUserContextManager userContextManager) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Intrinsics.checkNotNullParameter(jobId, "jobId");
        Intrinsics.checkNotNullParameter(inputData, "inputData");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(jobService, "jobService");
        Intrinsics.checkNotNullParameter(remoteItemService, "remoteItemService");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        this.moshi = moshi;
        this.jobId = jobId;
        this.inputData = inputData;
        this.appContext = appContext;
        this.jobService = jobService;
        this.remoteItemService = remoteItemService;
        this.userContextManager = userContextManager;
        this.userPrefs = LazyKt.lazy(new Function0() { // from class: com.box.android.data.jobs.MarkForOfflineFolderJob$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MarkForOfflineFolderJob.userPrefs_delegate$lambda$0(this.f$0);
            }
        });
        this.runningInfoAdapter = LazyKt.lazy(new Function0() { // from class: com.box.android.data.jobs.MarkForOfflineFolderJob$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MarkForOfflineFolderJob.runningInfoAdapter_delegate$lambda$0(this.f$0);
            }
        });
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

    public final IRemoteItemService getRemoteItemService() {
        return this.remoteItemService;
    }

    public final IUserContextManager getUserContextManager() {
        return this.userContextManager;
    }

    private final SharedPreferences getUserPrefs() {
        Object value = this.userPrefs.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (SharedPreferences) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SharedPreferences userPrefs_delegate$lambda$0(MarkForOfflineFolderJob markForOfflineFolderJob) {
        return markForOfflineFolderJob.userContextManager.getUserSharedPrefs();
    }

    private final JsonAdapter<MarkForOfflineFolderRunningInfo> getRunningInfoAdapter() {
        return (JsonAdapter) this.runningInfoAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JsonAdapter runningInfoAdapter_delegate$lambda$0(MarkForOfflineFolderJob markForOfflineFolderJob) {
        return markForOfflineFolderJob.moshi.adapter(MarkForOfflineFolderRunningInfo.class);
    }

    /* JADX INFO: compiled from: MarkForOfflineFolderJob.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J:\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/box/android/data/jobs/MarkForOfflineFolderJob$Companion;", "", "<init>", "()V", "TRY_DOWNLOAD_ORIGINAL", "", "REMOTE_ITEM_ID_PARAM", "IS_USER_OFFLINED", "getRequest", "Lcom/box/android/domain/jobs/JobRequest;", "remoteItemId", "Lcom/box/android/domain/models/ItemId$Remote;", "tags", "", "downloadOriginal", "", "isUserOfflined", JobConstants.SHOW_NOTIFICATION, "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ JobRequest getRequest$default(Companion companion, ItemId.Remote remote, Set set, boolean z, boolean z2, boolean z3, int i, Object obj) {
            if ((i & 4) != 0) {
                z = false;
            }
            return companion.getRequest(remote, set, z, (i & 8) != 0 ? true : z2, (i & 16) != 0 ? true : z3);
        }

        public final JobRequest getRequest(ItemId.Remote remoteItemId, Set<String> tags, boolean downloadOriginal, boolean isUserOfflined, boolean showNotification) {
            Intrinsics.checkNotNullParameter(remoteItemId, "remoteItemId");
            Intrinsics.checkNotNullParameter(tags, "tags");
            JobRequest.Builder builder = new JobRequest.Builder(JobType.MARK_FOR_OFFLINE_FOLDER, null, null, null, 14, null);
            Data.Builder builder2 = new Data.Builder();
            builder2.putString("remoteIdParam", remoteItemId.toString());
            builder2.putBoolean("tryDownloadOriginal", downloadOriginal);
            builder2.putBoolean(JobConstants.SHOULD_DISPLAY_JOB, isUserOfflined);
            builder2.putBoolean("isUserOfflined", isUserOfflined);
            builder2.putBoolean(JobConstants.SHOW_NOTIFICATION, showNotification);
            builder.setData(builder2.build());
            builder.setTags(SetsKt.plus(SetsKt.setOf("mark_offline:" + remoteItemId), (Iterable) tags));
            return builder.build();
        }
    }

    public final DomainError getLastRecordError() {
        return this.lastRecordError;
    }

    public final void setLastRecordError(DomainError domainError) {
        this.lastRecordError = domainError;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0101 A[PHI: r10
      0x0101: PHI (r10v7 java.lang.Object) = (r10v6 java.lang.Object), (r10v1 java.lang.Object) binds: [B:27:0x00fd, B:21:0x00d4] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:31:0x010b  */
    /* JADX WARN: Code duplicated, block: B:34:0x011d  */
    /* JADX WARN: Code duplicated, block: B:37:0x0125  */
    /* JADX WARN: Code duplicated, block: B:38:0x012e  */
    /* JADX WARN: Code duplicated, block: B:40:0x0132  */
    /* JADX WARN: Code duplicated, block: B:45:0x015d  */
    /* JADX WARN: Code duplicated, block: B:47:0x0163 A[PHI: r10
      0x0163: PHI (r10v15 com.box.android.data.jobs.MarkForOfflineFolderRunningInfo) = 
      (r10v10 com.box.android.data.jobs.MarkForOfflineFolderRunningInfo)
      (r10v25 com.box.android.data.jobs.MarkForOfflineFolderRunningInfo)
     binds: [B:30:0x0109, B:37:0x0125] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:50:0x017b A[PHI: r1 r2 r10
      0x017b: PHI (r1v7 com.box.android.domain.models.ItemId$Remote) = (r1v4 com.box.android.domain.models.ItemId$Remote), (r1v12 com.box.android.domain.models.ItemId$Remote) binds: [B:48:0x0177, B:18:0x00ae] A[DONT_GENERATE, DONT_INLINE]
      0x017b: PHI (r2v7 com.box.android.data.jobs.MarkForOfflineFolderRunningInfo) = 
      (r2v2 com.box.android.data.jobs.MarkForOfflineFolderRunningInfo)
      (r2v12 com.box.android.data.jobs.MarkForOfflineFolderRunningInfo)
     binds: [B:48:0x0177, B:18:0x00ae] A[DONT_GENERATE, DONT_INLINE]
      0x017b: PHI (r10v26 java.lang.Object) = (r10v18 java.lang.Object), (r10v1 java.lang.Object) binds: [B:48:0x0177, B:18:0x00ae] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:52:0x0181  */
    /* JADX WARN: Code duplicated, block: B:54:0x0191  */
    /* JADX WARN: Code duplicated, block: B:56:0x0195  */
    /* JADX WARN: Code duplicated, block: B:61:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:63:0x01da  */
    /* JADX WARN: Code duplicated, block: B:66:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:70:0x0215 A[PHI: r1 r2 r3 r10
      0x0215: PHI (r1v16 com.box.android.domain.models.item.FolderModel) = (r1v13 com.box.android.domain.models.item.FolderModel), (r1v22 com.box.android.domain.models.item.FolderModel) binds: [B:68:0x0211, B:14:0x005e] A[DONT_GENERATE, DONT_INLINE]
      0x0215: PHI (r2v16 com.box.android.domain.models.ItemId$Remote) = (r2v13 com.box.android.domain.models.ItemId$Remote), (r2v21 com.box.android.domain.models.ItemId$Remote) binds: [B:68:0x0211, B:14:0x005e] A[DONT_GENERATE, DONT_INLINE]
      0x0215: PHI (r3v15 com.box.android.data.jobs.MarkForOfflineFolderRunningInfo) = 
      (r3v12 com.box.android.data.jobs.MarkForOfflineFolderRunningInfo)
      (r3v20 com.box.android.data.jobs.MarkForOfflineFolderRunningInfo)
     binds: [B:68:0x0211, B:14:0x005e] A[DONT_GENERATE, DONT_INLINE]
      0x0215: PHI (r10v42 java.lang.Object) = (r10v41 java.lang.Object), (r10v1 java.lang.Object) binds: [B:68:0x0211, B:14:0x005e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:72:0x021b  */
    /* JADX WARN: Code duplicated, block: B:74:0x021f  */
    /* JADX WARN: Code duplicated, block: B:79:0x0258  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code duplicated, block: B:81:0x025e  */
    /* JADX WARN: Code duplicated, block: B:86:0x028b  */
    /* JADX WARN: Code duplicated, block: B:88:0x028f  */
    /* JADX WARN: Code duplicated, block: B:93:0x02bd  */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0156, code lost:
    
        if (r9.jobFailed(r3, com.box.android.domain.jobs.JobType.MARK_FOR_OFFLINE_FOLDER, r5, r4) == r0) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x01cd, code lost:
    
        if (r6.jobFailed(r9, com.box.android.domain.jobs.JobType.MARK_FOR_OFFLINE_FOLDER, r5, r4) == r0) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0252, code lost:
    
        if (markNotOfflinedAndFailJob(r5, r4) == r0) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0285, code lost:
    
        if (updatingRunningInfo$default(r9, false, r10, r4, 1, null) == r0) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x02b7, code lost:
    
        if (r3.jobFailed(r9, com.box.android.domain.jobs.JobType.MARK_FOR_OFFLINE_FOLDER, r5, r4) == r0) goto L90;
     */
    @Override // com.box.android.data.jobs.Job
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object start(kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            Method dump skipped, instruction units count: 736
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.MarkForOfflineFolderJob.start(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.MarkForOfflineFolderJob$start$4, reason: invalid class name */
    /* JADX INFO: compiled from: MarkForOfflineFolderJob.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/box/android/data/jobs/MarkForOfflineFolderRunningInfo;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.MarkForOfflineFolderJob$start$4", f = "MarkForOfflineFolderJob.kt", i = {0}, l = {121}, m = "invokeSuspend", n = {"it"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass4 extends SuspendLambda implements Function2<MarkForOfflineFolderRunningInfo, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass4(Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass4 anonymousClass4 = MarkForOfflineFolderJob.this.new AnonymousClass4(continuation);
            anonymousClass4.L$0 = obj;
            return anonymousClass4;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(MarkForOfflineFolderRunningInfo markForOfflineFolderRunningInfo, Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(markForOfflineFolderRunningInfo, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MarkForOfflineFolderRunningInfo markForOfflineFolderRunningInfo = (MarkForOfflineFolderRunningInfo) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.L$0 = SpillingKt.nullOutSpilledVariable(markForOfflineFolderRunningInfo);
                this.label = 1;
                if (MarkForOfflineFolderJob.this.checkCompletionInTransaction(markForOfflineFolderRunningInfo, this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public final Object markFolderOfflineStarted(FolderModel folderModel, Continuation<? super Unit> continuation) {
        if (this.inputData.getBoolean("isUserOfflined", true)) {
            BoxModelOfflineManager boxModelOfflineManager = BoxModelOfflineManager.INSTANCE;
            BoxItem boxItem = ItemModelMapper.INSTANCE.toBoxItem(folderModel, true);
            Intrinsics.checkNotNull(boxItem, "null cannot be cast to non-null type com.box.androidsdk.content.models.BoxFolder");
            Object folderOfflineSavedStarted = boxModelOfflineManager.setFolderOfflineSavedStarted((BoxFolder) boxItem, true, System.currentTimeMillis(), this.userContextManager, continuation);
            return folderOfflineSavedStarted == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? folderOfflineSavedStarted : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:26:0x0088  */
    /* JADX WARN: Code duplicated, block: B:29:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:37:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:39:0x00ec A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:40:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:43:0x00b2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:0x009f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00db, code lost:
    
        if (enqueueChildJobs(r5, r0) == r1) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object processFolderItems(com.box.android.domain.models.ItemId.Remote r9, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<kotlin.Unit, ? extends com.box.android.domain.models.DomainError>> r10) {
        /*
            Method dump skipped, instruction units count: 243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.MarkForOfflineFolderJob.processFolderItems(com.box.android.domain.models.ItemId$Remote, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final boolean isUnsupportedOfflineItem(ItemModel itemModel) {
        FileModel fileModel = itemModel instanceof FileModel ? (FileModel) itemModel : null;
        if (fileModel == null) {
            return false;
        }
        return SupportedFileExtensions.INSTANCE.isBoxNoteExtension(fileModel.getExtension()) || SupportedFileExtensions.INSTANCE.isBoxCanvasExtension(fileModel.getExtension());
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.MarkForOfflineFolderJob$enqueueChildJobs$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MarkForOfflineFolderJob.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "runningInfo", "Lcom/box/android/data/jobs/MarkForOfflineFolderRunningInfo;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.MarkForOfflineFolderJob$enqueueChildJobs$2", f = "MarkForOfflineFolderJob.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {Token.DEBUGGER, Token.GENEXPR, 168}, m = "invokeSuspend", n = {"runningInfo", "existingChildJobMap", "requests", "newChildJobs", "updatedRunningInfo", "runningInfo", "existingChildJobMap", "requests", "newChildJobs", "updatedRunningInfo", "runningInfo", "existingChildJobMap", "requests", "newChildJobs", "updatedRunningInfo", "$this$forEach$iv", "element$iv", "it", "$i$f$forEach", "$i$a$-forEach-MarkForOfflineFolderJob$enqueueChildJobs$2$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$8", "L$9", "I$0", "I$1"}, v = 1)
    static final class C13032 extends SuspendLambda implements Function2<MarkForOfflineFolderRunningInfo, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<ItemModel> $items;
        int I$0;
        int I$1;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C13032(List<? extends ItemModel> list, Continuation<? super C13032> continuation) {
            super(2, continuation);
            this.$items = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C13032 c13032 = MarkForOfflineFolderJob.this.new C13032(this.$items, continuation);
            c13032.L$0 = obj;
            return c13032;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(MarkForOfflineFolderRunningInfo markForOfflineFolderRunningInfo, Continuation<? super Unit> continuation) {
            return ((C13032) create(markForOfflineFolderRunningInfo, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:23:0x015a  */
        /* JADX WARN: Code duplicated, block: B:27:0x01b7  */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x01b1, code lost:
        
            if (com.box.android.data.jobs.IJobEventObserver.enqueueChildJob$default(r2, r1, r2, null, r4, 4, null) == r14) goto L25;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x01b1 -> B:26:0x01b4). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r20) {
            /*
                Method dump skipped, instruction units count: 442
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.MarkForOfflineFolderJob.C13032.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object enqueueChildJobs(List<? extends ItemModel> list, Continuation<? super Unit> continuation) {
        Object objUpdatingRunningInfo$default = updatingRunningInfo$default(this, false, new C13032(list, null), continuation, 1, null);
        return objUpdatingRunningInfo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdatingRunningInfo$default : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<List<JobRequest>, Map<String, String>> createJobRequestsForItems(List<? extends ItemModel> items, Map<String, String> existingChildJobMap) {
        ArrayList arrayList = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List<? extends ItemModel> list = items;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof FileModel) {
                arrayList2.add(obj);
            }
        }
        ArrayList<FileModel> arrayList3 = arrayList2;
        ArrayList arrayList4 = new ArrayList();
        for (Object obj2 : list) {
            if (obj2 instanceof FolderModel) {
                arrayList4.add(obj2);
            }
        }
        ArrayList<FolderModel> arrayList5 = arrayList4;
        for (FileModel fileModel : arrayList3) {
            String string = fileModel.getItemId().toString();
            if (!existingChildJobMap.containsKey(string)) {
                JobRequest request = MarkForOfflineJob.INSTANCE.getRequest(ItemModelKt.toItemIdRemoteId(fileModel), SetsKt.emptySet(), this.inputData.getBoolean("tryDownloadOriginal", false), false, false);
                arrayList.add(request);
                linkedHashMap.put(string, request.getJobId().getIdentifier());
            }
        }
        for (FolderModel folderModel : arrayList5) {
            String string2 = folderModel.getItemId().toString();
            if (!existingChildJobMap.containsKey(string2)) {
                JobRequest request2 = INSTANCE.getRequest(ItemModelKt.toItemIdRemoteId(folderModel), SetsKt.emptySet(), this.inputData.getBoolean("tryDownloadOriginal", false), false, false);
                arrayList.add(request2);
                linkedHashMap.put(string2, request2.getJobId().getIdentifier());
            }
        }
        return TuplesKt.to(arrayList, linkedHashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object markFolderOfflineCompleted(FolderModel folderModel, Continuation<? super Unit> continuation) {
        if (this.inputData.getBoolean("isUserOfflined", true)) {
            BoxModelOfflineManager boxModelOfflineManager = BoxModelOfflineManager.INSTANCE;
            BoxItem boxItem = ItemModelMapper.INSTANCE.toBoxItem(folderModel, true);
            Intrinsics.checkNotNull(boxItem, "null cannot be cast to non-null type com.box.androidsdk.content.models.BoxFolder");
            Object folderOfflineSavedCompleted = boxModelOfflineManager.setFolderOfflineSavedCompleted((BoxFolder) boxItem, true, this.userContextManager, continuation);
            return folderOfflineSavedCompleted == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? folderOfflineSavedCompleted : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    public final Result<Unit, DomainError> validateOfflineEligibility(FolderModel folderModel) {
        Intrinsics.checkNotNullParameter(folderModel, "folderModel");
        if (BoxAccountManager.isSaveOnDeviceAdminDisabled(getUserPrefs())) {
            return new Result.Error(new AdminSettingsDomainError.SavingOnDeviceDisabled(null, 1, null));
        }
        if (BoxAccountManager.doesSaveOnDeviceRequireEncryptedDevice(getUserPrefs())) {
            return new Result.Error(new AdminSettingsDomainError.EncryptedDeviceRequired(null, 1, null));
        }
        PermissionsModel permissions = folderModel.getPermissions();
        boolean canDownload = permissions != null ? permissions.getCanDownload() : false;
        if (!BoxAccountManager.isMobilePreviewOnlyOffliningEnabled(getUserPrefs()) && !canDownload) {
            return new Result.Error(new AdminSettingsDomainError.PreviewOnlyOffliningDisabled(null, 1, null));
        }
        return new Result.Success(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getFolderModel(ItemId.Remote remote, Continuation<? super Result<FolderModel, ? extends DomainError>> continuation) {
        C13041 c13041;
        if (continuation instanceof C13041) {
            c13041 = (C13041) continuation;
            if ((c13041.label & Integer.MIN_VALUE) != 0) {
                c13041.label -= Integer.MIN_VALUE;
            } else {
                c13041 = new C13041(continuation);
            }
        } else {
            c13041 = new C13041(continuation);
        }
        Object objItem = c13041.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c13041.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objItem);
            FolderModel folderModel = this.cachedFolderModel;
            if (folderModel != null && Intrinsics.areEqual(folderModel.getItemId(), remote)) {
                return new Result.Success(folderModel);
            }
            IRemoteItemService iRemoteItemService = this.remoteItemService;
            DataPolicy dataPolicy = DataPolicy.REMOTE_OR_CACHE;
            c13041.L$0 = SpillingKt.nullOutSpilledVariable(remote);
            c13041.label = 1;
            objItem = iRemoteItemService.item(remote, dataPolicy, (Continuation<? super Result<? extends ItemModel, ? extends DomainError>>) c13041);
            if (objItem == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objItem);
        }
        Result result = (Result) objItem;
        if (result instanceof Result.Success) {
            Object value = ((Result.Success) result).getValue();
            FolderModel folderModel2 = value instanceof FolderModel ? (FolderModel) value : null;
            if (folderModel2 == null) {
                return new Result.Error(new DomainError.UnknownError("Item fetched is not a folderModel"));
            }
            this.cachedFolderModel = folderModel2;
            return new Result.Success(folderModel2);
        }
        if (result instanceof Result.Error) {
            return result;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getRunningInfo(Continuation<? super Result<MarkForOfflineFolderRunningInfo, ? extends DomainError>> continuation) {
        C13051 c13051;
        if (continuation instanceof C13051) {
            c13051 = (C13051) continuation;
            if ((c13051.label & Integer.MIN_VALUE) != 0) {
                c13051.label -= Integer.MIN_VALUE;
            } else {
                c13051 = new C13051(continuation);
            }
        } else {
            c13051 = new C13051(continuation);
        }
        Object runningInfo = c13051.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c13051.label;
        if (i == 0) {
            ResultKt.throwOnFailure(runningInfo);
            JobService jobService = getJobService();
            JobId jobId = this.jobId;
            c13051.label = 1;
            runningInfo = jobService.getRunningInfo(jobId, c13051);
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

    public final MarkForOfflineFolderRunningInfo byteArrayToRunningInfo(byte[] byteArray) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        String str = new String(byteArray, Charsets.UTF_8);
        JsonAdapter<MarkForOfflineFolderRunningInfo> runningInfoAdapter = getRunningInfoAdapter();
        Intrinsics.checkNotNullExpressionValue(runningInfoAdapter, "<get-runningInfoAdapter>(...)");
        MarkForOfflineFolderRunningInfo markForOfflineFolderRunningInfo = (MarkForOfflineFolderRunningInfo) AnnotationEntityDomainMapperKt.fromJsonOrNull(runningInfoAdapter, str);
        if (markForOfflineFolderRunningInfo != null) {
            return markForOfflineFolderRunningInfo;
        }
        throw new IllegalStateException("Failed to parse running info from JSON".toString());
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:41:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:43:0x0102  */
    /* JADX WARN: Code duplicated, block: B:45:0x0106 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:46:0x0107  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object initialRunningInfo(Continuation<? super Result<MarkForOfflineFolderRunningInfo, ? extends DomainError>> continuation) {
        C13061 c13061;
        ItemId.Remote remote;
        ItemId.Remote remote2;
        ItemModel itemModel;
        MarkForOfflineFolderRunningInfo markForOfflineFolderRunningInfo;
        MarkForOfflineFolderRunningInfo markForOfflineFolderRunningInfo2;
        Result result;
        if (continuation instanceof C13061) {
            c13061 = (C13061) continuation;
            if ((c13061.label & Integer.MIN_VALUE) != 0) {
                c13061.label -= Integer.MIN_VALUE;
            } else {
                c13061 = new C13061(continuation);
            }
        } else {
            c13061 = new C13061(continuation);
        }
        Object objUpdateRunningInfo = c13061.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c13061.label;
        if (i != 0) {
            if (i == 1) {
                remote = (ItemId.Remote) c13061.L$0;
                ResultKt.throwOnFailure(objUpdateRunningInfo);
            } else {
                if (i == 2) {
                    itemModel = (ItemModel) c13061.L$1;
                    ItemId.Remote remote3 = (ItemId.Remote) c13061.L$0;
                    ResultKt.throwOnFailure(objUpdateRunningInfo);
                    remote2 = remote3;
                    markForOfflineFolderRunningInfo = new MarkForOfflineFolderRunningInfo(itemModel.getName(), remote2, MapsKt.emptyMap(), 0, SetsKt.emptySet(), SetsKt.emptySet());
                    JobService jobService = getJobService();
                    byte[] bArrRunningInfoToByteArray = runningInfoToByteArray(markForOfflineFolderRunningInfo);
                    JobId jobId = this.jobId;
                    c13061.L$0 = SpillingKt.nullOutSpilledVariable(remote2);
                    c13061.L$1 = SpillingKt.nullOutSpilledVariable(itemModel);
                    c13061.L$2 = markForOfflineFolderRunningInfo;
                    c13061.label = 3;
                    objUpdateRunningInfo = jobService.updateRunningInfo(bArrRunningInfoToByteArray, jobId, c13061);
                    if (objUpdateRunningInfo != coroutine_suspended) {
                        markForOfflineFolderRunningInfo2 = markForOfflineFolderRunningInfo;
                    }
                    return coroutine_suspended;
                }
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                markForOfflineFolderRunningInfo2 = (MarkForOfflineFolderRunningInfo) c13061.L$2;
                ResultKt.throwOnFailure(objUpdateRunningInfo);
            }
            result = (Result) objUpdateRunningInfo;
            if (result instanceof Result.Success) {
                return new Result.Success(markForOfflineFolderRunningInfo2);
            }
            if (result instanceof Result.Error) {
                return result;
            }
            throw new NoWhenBranchMatchedException();
        }
        ResultKt.throwOnFailure(objUpdateRunningInfo);
        String string = this.inputData.getString("remoteIdParam");
        if (string != null) {
            ItemId itemIdCreate = ItemId.INSTANCE.create(string);
            ItemId.Remote remote4 = itemIdCreate instanceof ItemId.Remote ? (ItemId.Remote) itemIdCreate : null;
            if (remote4 != null) {
                IRemoteItemService iRemoteItemService = this.remoteItemService;
                DataPolicy dataPolicy = DataPolicy.REMOTE_OR_CACHE;
                c13061.L$0 = remote4;
                c13061.label = 1;
                Object objItem = iRemoteItemService.item(remote4, dataPolicy, (Continuation<? super Result<? extends ItemModel, ? extends DomainError>>) c13061);
                if (objItem != coroutine_suspended) {
                    remote = remote4;
                    objUpdateRunningInfo = objItem;
                }
                return coroutine_suspended;
            }
        }
        throw new IllegalStateException("Unable to get remote itemId".toString());
        Result result2 = (Result) objUpdateRunningInfo;
        if (!(result2 instanceof Result.Success)) {
            if (result2 instanceof Result.Error) {
                return result2;
            }
            throw new NoWhenBranchMatchedException();
        }
        ItemModel itemModel2 = (ItemModel) ((Result.Success) result2).getValue();
        JobService jobService2 = getJobService();
        JobId jobId2 = this.jobId;
        Map<String, ? extends Object> mapMapOf = MapsKt.mapOf(TuplesKt.to(MetricKeysParam.METRIC_FILE_ID, remote.toString()));
        c13061.L$0 = remote;
        c13061.L$1 = itemModel2;
        c13061.label = 2;
        if (jobService2.updateLogData(jobId2, mapMapOf, c13061) != coroutine_suspended) {
            remote2 = remote;
            itemModel = itemModel2;
            markForOfflineFolderRunningInfo = new MarkForOfflineFolderRunningInfo(itemModel.getName(), remote2, MapsKt.emptyMap(), 0, SetsKt.emptySet(), SetsKt.emptySet());
            JobService jobService3 = getJobService();
            byte[] bArrRunningInfoToByteArray2 = runningInfoToByteArray(markForOfflineFolderRunningInfo);
            JobId jobId3 = this.jobId;
            c13061.L$0 = SpillingKt.nullOutSpilledVariable(remote2);
            c13061.L$1 = SpillingKt.nullOutSpilledVariable(itemModel);
            c13061.L$2 = markForOfflineFolderRunningInfo;
            c13061.label = 3;
            objUpdateRunningInfo = jobService3.updateRunningInfo(bArrRunningInfoToByteArray2, jobId3, c13061);
            if (objUpdateRunningInfo != coroutine_suspended) {
                markForOfflineFolderRunningInfo2 = markForOfflineFolderRunningInfo;
                result = (Result) objUpdateRunningInfo;
                if (result instanceof Result.Success) {
                    return new Result.Success(markForOfflineFolderRunningInfo2);
                }
                if (result instanceof Result.Error) {
                    return result;
                }
                throw new NoWhenBranchMatchedException();
            }
        }
        return coroutine_suspended;
    }

    public final byte[] runningInfoToByteArray(MarkForOfflineFolderRunningInfo runningInfo) {
        Intrinsics.checkNotNullParameter(runningInfo, "runningInfo");
        String json = getRunningInfoAdapter().toJson(runningInfo);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        byte[] bytes = json.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return bytes;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:33:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:36:0x0102  */
    /* JADX WARN: Code duplicated, block: B:38:0x0106  */
    /* JADX WARN: Code duplicated, block: B:39:0x0108 A[PHI: r14 r15
      0x0108: PHI (r14v5 com.box.android.domain.models.DomainError) = 
      (r14v0 com.box.android.domain.models.DomainError)
      (r14v1 com.box.android.domain.models.DomainError)
      (r14v4 com.box.android.domain.models.DomainError)
      (r14v7 com.box.android.domain.models.DomainError)
     binds: [B:21:0x008a, B:26:0x00a2, B:38:0x0106, B:37:0x0103] A[DONT_GENERATE, DONT_INLINE]
      0x0108: PHI (r15v9 boolean) = (r15v3 boolean), (r15v4 boolean), (r15v7 boolean), (r15v11 boolean) binds: [B:21:0x008a, B:26:0x00a2, B:38:0x0106, B:37:0x0103] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0123, code lost:
    
        if (r1.jobFailed(r13, com.box.android.domain.jobs.JobType.MARK_FOR_OFFLINE_FOLDER, r14, r7) == r0) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object markNotOfflinedAndFailJob(com.box.android.domain.models.DomainError r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            Method dump skipped, instruction units count: 297
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.MarkForOfflineFolderJob.markNotOfflinedAndFailJob(com.box.android.domain.models.DomainError, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.box.android.data.jobs.Job
    public Object cleanup(Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.box.android.data.jobs.Job
    public Object shouldBeRemovedFromDbOnSuccess(Continuation<? super Boolean> continuation) {
        return Boxing.boxBoolean(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isChildJob(JobId childJobId, MarkForOfflineFolderRunningInfo runningInfo) {
        return runningInfo.getChildJobMap().values().contains(childJobId.getIdentifier());
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.MarkForOfflineFolderJob$childSucceeded$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MarkForOfflineFolderJob.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "runningInfo", "Lcom/box/android/data/jobs/MarkForOfflineFolderRunningInfo;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.MarkForOfflineFolderJob$childSucceeded$2", f = "MarkForOfflineFolderJob.kt", i = {0, 0, 1, 1, 2, 2}, l = {371, 372, 374}, m = "invokeSuspend", n = {"runningInfo", "newRunningInfo", "runningInfo", "newRunningInfo", "runningInfo", "newRunningInfo"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1"}, v = 1)
    static final class C13022 extends SuspendLambda implements Function2<MarkForOfflineFolderRunningInfo, Continuation<? super Unit>, Object> {
        final /* synthetic */ JobId $childJobId;
        /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13022(JobId jobId, Continuation<? super C13022> continuation) {
            super(2, continuation);
            this.$childJobId = jobId;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C13022 c13022 = MarkForOfflineFolderJob.this.new C13022(this.$childJobId, continuation);
            c13022.L$0 = obj;
            return c13022;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(MarkForOfflineFolderRunningInfo markForOfflineFolderRunningInfo, Continuation<? super Unit> continuation) {
            return ((C13022) create(markForOfflineFolderRunningInfo, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x00ce, code lost:
        
            if (r13.this$0.checkCompletionInTransaction(r2, r13) == r0) goto L25;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                Method dump skipped, instruction units count: 212
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.MarkForOfflineFolderJob.C13022.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // com.box.android.data.jobs.ParentJob
    public Object childSucceeded(JobId jobId, Continuation<? super Unit> continuation) {
        Object objUpdatingRunningInfo$default = updatingRunningInfo$default(this, false, new C13022(jobId, null), continuation, 1, null);
        return objUpdatingRunningInfo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdatingRunningInfo$default : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.MarkForOfflineFolderJob$childFailed$2, reason: invalid class name */
    /* JADX INFO: compiled from: MarkForOfflineFolderJob.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "runningInfo", "Lcom/box/android/data/jobs/MarkForOfflineFolderRunningInfo;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.MarkForOfflineFolderJob$childFailed$2", f = "MarkForOfflineFolderJob.kt", i = {0, 0, 1, 1}, l = {389, 391}, m = "invokeSuspend", n = {"runningInfo", "newRunningInfo", "runningInfo", "newRunningInfo"}, s = {"L$0", "L$1", "L$0", "L$1"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<MarkForOfflineFolderRunningInfo, Continuation<? super Unit>, Object> {
        final /* synthetic */ JobId $childJobId;
        /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(JobId jobId, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$childJobId = jobId;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = MarkForOfflineFolderJob.this.new AnonymousClass2(this.$childJobId, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(MarkForOfflineFolderRunningInfo markForOfflineFolderRunningInfo, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(markForOfflineFolderRunningInfo, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0093, code lost:
        
            if (r12.this$0.checkCompletionInTransaction(r2, r12) == r0) goto L19;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                r12 = this;
                java.lang.Object r0 = r12.L$0
                r1 = r0
                com.box.android.data.jobs.MarkForOfflineFolderRunningInfo r1 = (com.box.android.data.jobs.MarkForOfflineFolderRunningInfo) r1
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r12.label
                r10 = 2
                r11 = 1
                if (r2 == 0) goto L2c
                if (r2 == r11) goto L24
                if (r2 != r10) goto L1c
                java.lang.Object r12 = r12.L$1
                com.box.android.data.jobs.MarkForOfflineFolderRunningInfo r12 = (com.box.android.data.jobs.MarkForOfflineFolderRunningInfo) r12
                kotlin.ResultKt.throwOnFailure(r13)
                goto L96
            L1c:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r13)
                throw r12
            L24:
                java.lang.Object r2 = r12.L$1
                com.box.android.data.jobs.MarkForOfflineFolderRunningInfo r2 = (com.box.android.data.jobs.MarkForOfflineFolderRunningInfo) r2
                kotlin.ResultKt.throwOnFailure(r13)
                goto L7c
            L2c:
                kotlin.ResultKt.throwOnFailure(r13)
                com.box.android.data.jobs.MarkForOfflineFolderJob r13 = com.box.android.data.jobs.MarkForOfflineFolderJob.this
                com.box.android.domain.jobs.JobId r2 = r12.$childJobId
                boolean r13 = com.box.android.data.jobs.MarkForOfflineFolderJob.access$isChildJob(r13, r2, r1)
                if (r13 != 0) goto L3c
                kotlin.Unit r12 = kotlin.Unit.INSTANCE
                return r12
            L3c:
                java.util.Set r13 = r1.getFailedFiles()
                com.box.android.domain.jobs.JobId r2 = r12.$childJobId
                java.lang.String r2 = r2.getIdentifier()
                java.util.Set r7 = kotlin.collections.SetsKt.plus(r13, r2)
                r8 = 31
                r9 = 0
                r2 = 0
                r3 = 0
                r4 = 0
                r5 = 0
                r6 = 0
                com.box.android.data.jobs.MarkForOfflineFolderRunningInfo r2 = com.box.android.data.jobs.MarkForOfflineFolderRunningInfo.copy$default(r1, r2, r3, r4, r5, r6, r7, r8, r9)
                com.box.android.data.jobs.MarkForOfflineFolderJob r13 = com.box.android.data.jobs.MarkForOfflineFolderJob.this
                com.box.android.data.jobs.JobService r13 = r13.getJobService()
                com.box.android.data.jobs.MarkForOfflineFolderJob r3 = com.box.android.data.jobs.MarkForOfflineFolderJob.this
                byte[] r3 = r3.runningInfoToByteArray(r2)
                com.box.android.data.jobs.MarkForOfflineFolderJob r4 = com.box.android.data.jobs.MarkForOfflineFolderJob.this
                com.box.android.domain.jobs.JobId r4 = r4.getJobId()
                r5 = r12
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
                r12.L$0 = r6
                r12.L$1 = r2
                r12.label = r11
                java.lang.Object r13 = r13.updateRunningInfo(r3, r4, r5)
                if (r13 != r0) goto L7c
                goto L95
            L7c:
                com.box.android.data.jobs.MarkForOfflineFolderJob r13 = com.box.android.data.jobs.MarkForOfflineFolderJob.this
                r3 = r12
                kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
                r12.L$0 = r1
                java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
                r12.L$1 = r1
                r12.label = r10
                java.lang.Object r12 = r13.checkCompletionInTransaction(r2, r3)
                if (r12 != r0) goto L96
            L95:
                return r0
            L96:
                kotlin.Unit r12 = kotlin.Unit.INSTANCE
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.MarkForOfflineFolderJob.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // com.box.android.data.jobs.ParentJob
    public Object childFailed(JobId jobId, DomainError domainError, Continuation<? super Unit> continuation) {
        this.lastRecordError = domainError;
        Object objUpdatingRunningInfo$default = updatingRunningInfo$default(this, false, new AnonymousClass2(jobId, null), continuation, 1, null);
        return objUpdatingRunningInfo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdatingRunningInfo$default : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0135  */
    /* JADX WARN: Code duplicated, block: B:34:0x0139  */
    /* JADX WARN: Code duplicated, block: B:40:0x015d  */
    /* JADX WARN: Code duplicated, block: B:43:0x017a  */
    /* JADX WARN: Code duplicated, block: B:46:0x0186  */
    /* JADX WARN: Code duplicated, block: B:49:0x01ad A[PHI: r2 r3 r4 r10
      0x01ad: PHI (r2v23 com.box.android.domain.utils.result.Result) = (r2v19 com.box.android.domain.utils.result.Result), (r2v26 com.box.android.domain.utils.result.Result) binds: [B:47:0x01aa, B:14:0x0053] A[DONT_GENERATE, DONT_INLINE]
      0x01ad: PHI (r3v9 com.box.android.domain.models.ItemId$Remote) = (r3v5 com.box.android.domain.models.ItemId$Remote), (r3v12 com.box.android.domain.models.ItemId$Remote) binds: [B:47:0x01aa, B:14:0x0053] A[DONT_GENERATE, DONT_INLINE]
      0x01ad: PHI (r4v11 com.box.android.data.jobs.MarkForOfflineFolderRunningInfo) = 
      (r4v8 com.box.android.data.jobs.MarkForOfflineFolderRunningInfo)
      (r4v14 com.box.android.data.jobs.MarkForOfflineFolderRunningInfo)
     binds: [B:47:0x01aa, B:14:0x0053] A[DONT_GENERATE, DONT_INLINE]
      0x01ad: PHI (r10v12 int) = (r10v8 int), (r10v14 int) binds: [B:47:0x01aa, B:14:0x0053] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:54:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:56:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:61:0x020a  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00cc, code lost:
    
        if (r2.waitForChildren(r9, r0) == r1) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0156, code lost:
    
        if (markNotOfflinedAndFailJob(r2, r0) == r1) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x01ce, code lost:
    
        if (r11.jobSucceeded(r9, r0) == r1) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0204, code lost:
    
        if (r11.jobFailed(r9, com.box.android.domain.jobs.JobType.MARK_FOR_OFFLINE_FOLDER, r5, r0) == r1) goto L58;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object checkCompletionInTransaction(com.box.android.data.jobs.MarkForOfflineFolderRunningInfo r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            Method dump skipped, instruction units count: 548
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.MarkForOfflineFolderJob.checkCompletionInTransaction(com.box.android.data.jobs.MarkForOfflineFolderRunningInfo, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object updatingRunningInfo$default(MarkForOfflineFolderJob markForOfflineFolderJob, boolean z, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return markForOfflineFolderJob.updatingRunningInfo(z, function2, continuation);
    }

    public final Object updatingRunningInfo(boolean z, Function2<? super MarkForOfflineFolderRunningInfo, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        MarkForOfflineFolderJob$updatingRunningInfo$update$1 markForOfflineFolderJob$updatingRunningInfo$update$1 = new MarkForOfflineFolderJob$updatingRunningInfo$update$1(this, function2, null);
        if (z) {
            Object objWithTransaction = getJobService().withTransaction(markForOfflineFolderJob$updatingRunningInfo$update$1, continuation);
            return objWithTransaction == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithTransaction : Unit.INSTANCE;
        }
        Object objInvoke = markForOfflineFolderJob$updatingRunningInfo$update$1.invoke(continuation);
        return objInvoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objInvoke : Unit.INSTANCE;
    }

    @Override // com.box.android.data.jobs.ParentJob
    public Object childProgressed(JobId jobId, double d, double d2, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.box.android.data.jobs.ParentJob
    public Object receiveFromChild(JobId jobId, byte[] bArr, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.box.android.domain.models.DisplayableJob
    public IJobDisplayInfoProvider getJobDisplayInfoProvider() {
        ItemId.Companion companion = ItemId.INSTANCE;
        String string = this.inputData.getString("remoteIdParam");
        Intrinsics.checkNotNull(string);
        ItemId itemIdCreate = companion.create(string);
        Intrinsics.checkNotNull(itemIdCreate, "null cannot be cast to non-null type com.box.android.domain.models.ItemId.Remote");
        return new MarkForOfflineJobDisplayInfoProvider((ItemId.Remote) itemIdCreate, this.remoteItemService, this.inputData.getBoolean(JobConstants.SHOW_NOTIFICATION, true));
    }

    @Override // com.box.android.domain.models.DisplayableJob
    public boolean shouldDisplay() {
        return this.inputData.getBoolean(JobConstants.SHOULD_DISPLAY_JOB, true);
    }

    @Override // com.box.android.domain.models.MetricsInfoProvider
    public String getAmplitudeJobType() {
        return BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_MARK_OFFLINE_FOLDER_JOB;
    }

    @Override // com.box.android.domain.models.MetricsInfoProvider
    public Object getAmplitudeInfos(Continuation<? super Map<String, ? extends Object>> continuation) {
        return MapsKt.emptyMap();
    }
}
