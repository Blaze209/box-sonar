package com.box.android.services;

import android.app.Application;
import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.PreferenceDataStoreDelegateKt;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import androidx.datastore.preferences.core.PreferencesKt;
import androidx.exifinterface.media.ExifInterface;
import com.box.android.R;
import com.box.android.application.BoxBaseApplication;
import com.box.android.base.BoxNotificationManager;
import com.box.android.base.presentation.BoxPresentationUtils;
import com.box.android.common.utilities.ApplicationProvider;
import com.box.android.coreservices.jobmanager.JobManager;
import com.box.android.coreservices.jobmanager.jobcollections.BoxJobCollection;
import com.box.android.coreservices.jobmanager.jobcollections.ExportBoxJobCollection;
import com.box.android.coreservices.utilities.JobEnqueuedListener;
import com.box.android.data.jobs.JobWorker;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.identity.IUserContextComponentListener;
import com.box.android.domain.jobs.JobType;
import com.box.android.domain.localrepo.sqlitetables.BoxPushNotificationSQLData;
import com.box.android.domain.models.JobInfo;
import com.box.android.domain.services.IJobService;
import com.box.android.jobsui.IJobNotificationService;
import com.box.android.jobsui.JobsUIActivity;
import com.box.android.usercontext.UserContextManager;
import com.microsoft.intune.mam.client.app.MAMPendingIntent;
import com.pspdfkit.ui.toolbar.ContextualToolbar;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.internal.CombineKt;

/* JADX INFO: compiled from: JobsNotificationService.kt */
/* JADX INFO: loaded from: classes13.dex */
@Singleton
@Metadata(d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 b2\u00020\u00012\u00020\u00022\u00020\u0003:\u0004`abcB+\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202JD\u00104\u001a8\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002080706\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002080706\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000208070605H\u0086@¢\u0006\u0002\u00109J\u000e\u0010:\u001a\u00020;H\u0086@¢\u0006\u0002\u00109J\"\u0010<\u001a\u00020;2\b\u0010=\u001a\u0004\u0018\u00010>2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020BH\u0007J\u000e\u0010C\u001a\u00020;H\u0087@¢\u0006\u0002\u00109J\u001e\u0010D\u001a\u0004\u0018\u00010>2\f\u0010E\u001a\b\u0012\u0004\u0012\u0002080FH\u0087@¢\u0006\u0002\u0010GJ\b\u0010H\u001a\u00020IH\u0007J\b\u0010J\u001a\u00020;H\u0002J\b\u0010K\u001a\u00020;H\u0016J\u0012\u0010L\u001a\u0004\u0018\u00010B2\u0006\u0010M\u001a\u00020!H\u0007J\u0012\u0010N\u001a\u0004\u0018\u00010B2\u0006\u0010O\u001a\u000202H\u0007J\u0010\u0010P\u001a\u00020@2\u0006\u0010A\u001a\u00020BH\u0007J\u0010\u0010Q\u001a\u00020;2\u0006\u0010O\u001a\u000202H\u0016J\u0010\u0010R\u001a\u00020;2\u0006\u0010S\u001a\u00020TH\u0007J\u0012\u0010U\u001a\u00020;2\b\u0010V\u001a\u0004\u0018\u00010!H\u0016J\b\u0010W\u001a\u00020;H\u0016J\b\u0010X\u001a\u00020;H\u0016J\u001f\u0010Y\u001a\u0004\u0018\u00010@2\b\u0010=\u001a\u0004\u0018\u00010>2\u0006\u0010A\u001a\u00020B¢\u0006\u0002\u0010ZJ\b\u0010_\u001a\u00020;H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R%\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017*\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR&\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0 0\u001f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u0011\u001a\u0004\b#\u0010$R!\u0010%\u001a\b\u0012\u0004\u0012\u00020!0&8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b'\u0010(R\u0014\u0010+\u001a\u00020,8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0010\u00103\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R.\u0010[\u001a\"\u0012\u0018\u0012\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020>0^\u0012\u0004\u0012\u00020B0]\u0012\u0004\u0012\u00020@0\\X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006d"}, d2 = {"Lcom/box/android/services/JobsNotificationService;", "Lcom/box/android/coreservices/utilities/JobEnqueuedListener;", "Lcom/box/android/domain/identity/IUserContextComponentListener;", "Lcom/box/android/jobsui/IJobNotificationService;", "jobManager", "Lcom/box/android/coreservices/jobmanager/JobManager;", "jobService", "Lcom/box/android/domain/services/IJobService;", "userContextManager", "Lcom/box/android/usercontext/UserContextManager;", "coroutineDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/box/android/coreservices/jobmanager/JobManager;Lcom/box/android/domain/services/IJobService;Lcom/box/android/usercontext/UserContextManager;Lkotlinx/coroutines/CoroutineDispatcher;)V", "coroutineJob", "Lkotlinx/coroutines/Job;", "getCoroutineJob$annotations", "()V", "getCoroutineJob", "()Lkotlinx/coroutines/Job;", "setCoroutineJob", "(Lkotlinx/coroutines/Job;)V", "jobNotificationDataStore", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "Landroid/content/Context;", "getJobNotificationDataStore", "(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", "jobNotificationDataStore$delegate", "Lkotlin/properties/ReadOnlyProperty;", "knownFailedJobsKey", "Landroidx/datastore/preferences/core/Preferences$Key;", "", "", "getKnownFailedJobsKey$annotations", "getKnownFailedJobsKey", "()Landroidx/datastore/preferences/core/Preferences$Key;", "knownFailedJobs", "", "getKnownFailedJobs", "()Ljava/util/Set;", "knownFailedJobs$delegate", "Lkotlin/Lazy;", "context", "Landroid/app/Application;", "getContext", "()Landroid/app/Application;", "isNotificationNeeded", "", "jobCollection", "Lcom/box/android/coreservices/jobmanager/jobcollections/BoxJobCollection;", "enqueuedEventsObserver", "getFlowsGrouped", "Lkotlin/Triple;", "", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/services/JobsNotificationService$MiniJobInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "subscribeToJobs", "", "handleFlowCollection", "status", "Lcom/box/android/domain/models/JobInfo$Status;", "inProgressNotifId", "", "notificationJobType", "Lcom/box/android/services/JobsNotificationService$NotificationJobType;", "saveKnownFailedJobs", "handleFlowMapping", "jobInfos", "", "([Lcom/box/android/services/JobsNotificationService$MiniJobInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildNotif", "Landroidx/core/app/NotificationCompat$Builder;", "cancelSubscription", "refreshSubscription", "convertJobTypeToNotificationJobType", "jobType", "convertBoxJobCollectionToNotificationJobType", "boxJobCollection", "getJobStartedTitle", "reportJobEnqueued", "handleJobEnqueuedEvent", "event", "Lcom/box/android/domain/services/IJobService$JobEnqueuedEvent;", "onCreate", "contextId", "onSoftDestroy", "onHardDestroy", "getNotificationTitle", "(Lcom/box/android/domain/models/JobInfo$Status;Lcom/box/android/services/JobsNotificationService$NotificationJobType;)Ljava/lang/Integer;", "notificationTitleMap", "", "Lkotlin/Pair;", "Lkotlin/reflect/KClass;", "cancelAll", "MiniJobInfo", "NotificationIdManager", "Companion", "NotificationJobType", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class JobsNotificationService implements JobEnqueuedListener, IUserContextComponentListener, IJobNotificationService {
    public static final String JOB_NOTIF_DATA_STORE_NAME = "JobNotificationServiceDataStore";
    private final CoroutineDispatcher coroutineDispatcher;
    private Job coroutineJob;
    private Job enqueuedEventsObserver;
    private final JobManager jobManager;

    /* JADX INFO: renamed from: jobNotificationDataStore$delegate, reason: from kotlin metadata */
    private final ReadOnlyProperty jobNotificationDataStore;
    private final IJobService jobService;

    /* JADX INFO: renamed from: knownFailedJobs$delegate, reason: from kotlin metadata */
    private final Lazy knownFailedJobs;
    private final Map<Pair<KClass<? extends JobInfo.Status>, NotificationJobType>, Integer> notificationTitleMap;
    private final UserContextManager userContextManager;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property2(new PropertyReference2Impl(JobsNotificationService.class, "jobNotificationDataStore", "getJobNotificationDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 0))};
    public static final int $stable = 8;
    private static final Set<Class<ExportBoxJobCollection>> jobCollectionsToBeNotified = SetsKt.setOf(ExportBoxJobCollection.class);

    /* JADX INFO: compiled from: JobsNotificationService.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/box/android/services/JobsNotificationService$NotificationJobType;", "", "<init>", "(Ljava/lang/String;I)V", "UPLOAD", "DOWNLOAD", "OFFLINE", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum NotificationJobType {
        UPLOAD,
        DOWNLOAD,
        OFFLINE;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<NotificationJobType> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: compiled from: JobsNotificationService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NotificationJobType.values().length];
            try {
                iArr[NotificationJobType.UPLOAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NotificationJobType.DOWNLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[NotificationJobType.OFFLINE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.box.android.services.JobsNotificationService$getFlowsGrouped$1, reason: invalid class name */
    /* JADX INFO: compiled from: JobsNotificationService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.services.JobsNotificationService", f = "JobsNotificationService.kt", i = {0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {113, 124, Token.LOOP, Token.XMLEND}, m = "getFlowsGrouped", n = {"jobManagerJobs", "jobManagerJobs", "jobServiceJobs", "allJobs", "jobManagerJobs", "jobServiceJobs", "allJobs", "uploadProgressFlows", "downloadProgressFlows", "offlineProgressFlows", "$this$forEach$iv", "element$iv", "jobCollection", "jobStatus", "$i$f$forEach", "$i$a$-forEach-JobsNotificationService$getFlowsGrouped$3", "jobManagerJobs", "jobServiceJobs", "allJobs", "uploadProgressFlows", "downloadProgressFlows", "offlineProgressFlows", "$this$forEach$iv", "element$iv", "jobInfo", "jobStatus", "$i$f$forEach", "$i$a$-forEach-JobsNotificationService$getFlowsGrouped$4"}, s = {"L$0", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$8", "L$9", "L$10", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$8", "L$9", "L$10", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
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
            return JobsNotificationService.this.getFlowsGrouped(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.services.JobsNotificationService$handleFlowMapping$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobsNotificationService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.services.JobsNotificationService", f = "JobsNotificationService.kt", i = {0, 0}, l = {299}, m = "handleFlowMapping", n = {"jobInfos", "newFailures"}, s = {"L$0", "L$1"}, v = 1)
    static final class C17191 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C17191(Continuation<? super C17191> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobsNotificationService.this.handleFlowMapping(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.services.JobsNotificationService$subscribeToJobs$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobsNotificationService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.services.JobsNotificationService", f = "JobsNotificationService.kt", i = {1, 1, 1}, l = {184, ContextualToolbar.DRAG_BUTTON_ALPHA}, m = "subscribeToJobs", n = {"uploadProgressFlows", "downloadProgressFlows", "offlineProgressFlows"}, s = {"L$0", "L$1", "L$2"}, v = 1)
    static final class C17221 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C17221(Continuation<? super C17221> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobsNotificationService.this.subscribeToJobs(this);
        }
    }

    public static /* synthetic */ void getCoroutineJob$annotations() {
    }

    public static /* synthetic */ void getKnownFailedJobsKey$annotations() {
    }

    @Inject
    public JobsNotificationService(JobManager jobManager, IJobService jobService, UserContextManager userContextManager, CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(jobManager, "jobManager");
        Intrinsics.checkNotNullParameter(jobService, "jobService");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "coroutineDispatcher");
        this.jobManager = jobManager;
        this.jobService = jobService;
        this.userContextManager = userContextManager;
        this.coroutineDispatcher = coroutineDispatcher;
        this.jobNotificationDataStore = PreferenceDataStoreDelegateKt.preferencesDataStore$default(JOB_NOTIF_DATA_STORE_NAME, null, null, null, 14, null);
        this.knownFailedJobs = LazyKt.lazy(new Function0() { // from class: com.box.android.services.JobsNotificationService$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return JobsNotificationService.knownFailedJobs_delegate$lambda$0(this.f$0);
            }
        });
        jobManager.setJobEnqueuedListener(this);
        userContextManager.addUserContextListener("JobNotifService", this);
        onCreate(userContextManager.getCurrentContextId());
        this.notificationTitleMap = MapsKt.mapOf(TuplesKt.to(new Pair(Reflection.getOrCreateKotlinClass(JobInfo.Status.Running.class), NotificationJobType.UPLOAD), Integer.valueOf(R.string.notif_upload_job_progress_title)), TuplesKt.to(new Pair(Reflection.getOrCreateKotlinClass(JobInfo.Status.Succeeded.class), NotificationJobType.UPLOAD), Integer.valueOf(R.string.notif_upload_job_success_title)), TuplesKt.to(new Pair(Reflection.getOrCreateKotlinClass(JobInfo.Status.Failed.class), NotificationJobType.UPLOAD), Integer.valueOf(R.string.notif_upload_job_failure_title)), TuplesKt.to(new Pair(Reflection.getOrCreateKotlinClass(JobInfo.Status.Running.class), NotificationJobType.DOWNLOAD), Integer.valueOf(R.string.notif_download_job_progress_title)), TuplesKt.to(new Pair(Reflection.getOrCreateKotlinClass(JobInfo.Status.Succeeded.class), NotificationJobType.DOWNLOAD), Integer.valueOf(R.string.notif_download_job_success_title)), TuplesKt.to(new Pair(Reflection.getOrCreateKotlinClass(JobInfo.Status.Failed.class), NotificationJobType.DOWNLOAD), Integer.valueOf(R.string.notif_download_job_failure_title)), TuplesKt.to(new Pair(Reflection.getOrCreateKotlinClass(JobInfo.Status.Running.class), NotificationJobType.OFFLINE), Integer.valueOf(R.string.notif_offline_job_progress_title)), TuplesKt.to(new Pair(Reflection.getOrCreateKotlinClass(JobInfo.Status.Succeeded.class), NotificationJobType.OFFLINE), Integer.valueOf(R.string.notif_offline_job_success_title)), TuplesKt.to(new Pair(Reflection.getOrCreateKotlinClass(JobInfo.Status.Failed.class), NotificationJobType.OFFLINE), Integer.valueOf(R.string.notif_offline_job_failure_title)));
    }

    public final Job getCoroutineJob() {
        return this.coroutineJob;
    }

    public final void setCoroutineJob(Job job) {
        this.coroutineJob = job;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DataStore<Preferences> getJobNotificationDataStore(Context context) {
        return (DataStore) this.jobNotificationDataStore.getValue(context, $$delegatedProperties[0]);
    }

    public final Preferences.Key<Set<String>> getKnownFailedJobsKey() {
        return PreferencesKeys.stringSetKey("known_failed_jobs_" + this.userContextManager.getCurrentContextId());
    }

    public final Set<String> getKnownFailedJobs() {
        return (Set) this.knownFailedJobs.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set knownFailedJobs_delegate$lambda$0(JobsNotificationService jobsNotificationService) {
        return (Set) BuildersKt__BuildersKt.runBlocking$default(null, new JobsNotificationService$knownFailedJobs$2$1(jobsNotificationService, null), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Application getContext() {
        return ApplicationProvider.getApplication();
    }

    /* JADX INFO: compiled from: JobsNotificationService.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/box/android/services/JobsNotificationService$MiniJobInfo;", "", JobWorker.JOB_ID_PARAM, "", "status", "Lcom/box/android/domain/models/JobInfo$Status;", "<init>", "(Ljava/lang/String;Lcom/box/android/domain/models/JobInfo$Status;)V", "getJobId", "()Ljava/lang/String;", "getStatus", "()Lcom/box/android/domain/models/JobInfo$Status;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class MiniJobInfo {
        public static final int $stable = 8;
        private final String jobId;
        private final JobInfo.Status status;

        public static /* synthetic */ MiniJobInfo copy$default(MiniJobInfo miniJobInfo, String str, JobInfo.Status status, int i, Object obj) {
            if ((i & 1) != 0) {
                str = miniJobInfo.jobId;
            }
            if ((i & 2) != 0) {
                status = miniJobInfo.status;
            }
            return miniJobInfo.copy(str, status);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getJobId() {
            return this.jobId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final JobInfo.Status getStatus() {
            return this.status;
        }

        public final MiniJobInfo copy(String jobId, JobInfo.Status status) {
            Intrinsics.checkNotNullParameter(jobId, "jobId");
            Intrinsics.checkNotNullParameter(status, "status");
            return new MiniJobInfo(jobId, status);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MiniJobInfo)) {
                return false;
            }
            MiniJobInfo miniJobInfo = (MiniJobInfo) other;
            return Intrinsics.areEqual(this.jobId, miniJobInfo.jobId) && Intrinsics.areEqual(this.status, miniJobInfo.status);
        }

        public int hashCode() {
            return (this.jobId.hashCode() * 31) + this.status.hashCode();
        }

        public String toString() {
            return "MiniJobInfo(jobId=" + this.jobId + ", status=" + this.status + ")";
        }

        public MiniJobInfo(String jobId, JobInfo.Status status) {
            Intrinsics.checkNotNullParameter(jobId, "jobId");
            Intrinsics.checkNotNullParameter(status, "status");
            this.jobId = jobId;
            this.status = status;
        }

        public final String getJobId() {
            return this.jobId;
        }

        public final JobInfo.Status getStatus() {
            return this.status;
        }
    }

    /* JADX INFO: compiled from: JobsNotificationService.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/box/android/services/JobsNotificationService$NotificationIdManager;", "", "<init>", "()V", "UPLOAD_NOTIF_PROGRESS_ID", "", "DOWNLOAD_NOTIF_PROGRESS_ID", "OFFLINE_NOTIF_PROGRESS_ID", "allIds", "", "getAllIds", "()Ljava/util/List;", "getCompletionId", BoxPushNotificationSQLData.NOTIF_ID_COLUMN_NAME, "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class NotificationIdManager {
        public static final int DOWNLOAD_NOTIF_PROGRESS_ID = 2000;
        public static final int OFFLINE_NOTIF_PROGRESS_ID = 3000;
        public static final int UPLOAD_NOTIF_PROGRESS_ID = 1000;
        public static final NotificationIdManager INSTANCE = new NotificationIdManager();
        private static final List<Integer> allIds = CollectionsKt.listOf((Object[]) new Integer[]{1000, 2000, 3000});
        public static final int $stable = 8;

        public final int getCompletionId(int notifId) {
            return notifId + 1;
        }

        private NotificationIdManager() {
        }

        public final List<Integer> getAllIds() {
            return allIds;
        }
    }

    public final boolean isNotificationNeeded(BoxJobCollection jobCollection) {
        Intrinsics.checkNotNullParameter(jobCollection, "jobCollection");
        return CollectionsKt.contains(jobCollectionsToBeNotified, jobCollection.getClass());
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0316  */
    /* JADX WARN: Code duplicated, block: B:103:0x0322  */
    /* JADX WARN: Code duplicated, block: B:61:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:70:0x0256  */
    /* JADX WARN: Code duplicated, block: B:73:0x026c  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:94:0x02ea  */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x023a, code lost:
    
        if (r1 == r3) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x02ad, code lost:
    
        if (r9 == r3) goto L75;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x023a -> B:64:0x023e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x02ad -> B:76:0x02b0). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getFlowsGrouped(kotlin.coroutines.Continuation<? super kotlin.Triple<? extends java.util.List<? extends kotlinx.coroutines.flow.Flow<com.box.android.services.JobsNotificationService.MiniJobInfo>>, ? extends java.util.List<? extends kotlinx.coroutines.flow.Flow<com.box.android.services.JobsNotificationService.MiniJobInfo>>, ? extends java.util.List<? extends kotlinx.coroutines.flow.Flow<com.box.android.services.JobsNotificationService.MiniJobInfo>>>> r17) {
        /*
            Method dump skipped, instruction units count: 852
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.services.JobsNotificationService.getFlowsGrouped(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getFlowsGrouped$lambda$4(Set set, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !set.contains(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getFlowsGrouped$lambda$5(Function1 function1, Object obj) {
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0089, code lost:
    
        if (kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r4, r0) == r1) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object subscribeToJobs(kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.box.android.services.JobsNotificationService.C17221
            if (r0 == 0) goto L14
            r0 = r11
            com.box.android.services.JobsNotificationService$subscribeToJobs$1 r0 = (com.box.android.services.JobsNotificationService.C17221) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            com.box.android.services.JobsNotificationService$subscribeToJobs$1 r0 = new com.box.android.services.JobsNotificationService$subscribeToJobs$1
            r0.<init>(r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L45
            if (r2 == r4) goto L41
            if (r2 != r3) goto L39
            java.lang.Object r10 = r0.L$2
            java.util.List r10 = (java.util.List) r10
            java.lang.Object r10 = r0.L$1
            java.util.List r10 = (java.util.List) r10
            java.lang.Object r10 = r0.L$0
            java.util.List r10 = (java.util.List) r10
            kotlin.ResultKt.throwOnFailure(r11)
            goto L8c
        L39:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L41:
            kotlin.ResultKt.throwOnFailure(r11)
            goto L51
        L45:
            kotlin.ResultKt.throwOnFailure(r11)
            r0.label = r4
            java.lang.Object r11 = r10.getFlowsGrouped(r0)
            if (r11 != r1) goto L51
            goto L8b
        L51:
            kotlin.Triple r11 = (kotlin.Triple) r11
            java.lang.Object r2 = r11.component1()
            r5 = r2
            java.util.List r5 = (java.util.List) r5
            java.lang.Object r2 = r11.component2()
            r7 = r2
            java.util.List r7 = (java.util.List) r7
            java.lang.Object r11 = r11.component3()
            r8 = r11
            java.util.List r8 = (java.util.List) r8
            com.box.android.services.JobsNotificationService$subscribeToJobs$2 r4 = new com.box.android.services.JobsNotificationService$subscribeToJobs$2
            r9 = 0
            r6 = r10
            r4.<init>(r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
            r0.L$0 = r10
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r0.L$1 = r10
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r0.L$2 = r10
            r0.label = r3
            java.lang.Object r10 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r4, r0)
            if (r10 != r1) goto L8c
        L8b:
            return r1
        L8c:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.services.JobsNotificationService.subscribeToJobs(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.box.android.services.JobsNotificationService$subscribeToJobs$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobsNotificationService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.services.JobsNotificationService$subscribeToJobs$2", f = "JobsNotificationService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C17232 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {
        final /* synthetic */ List<Flow<MiniJobInfo>> $downloadProgressFlows;
        final /* synthetic */ List<Flow<MiniJobInfo>> $offlineProgressFlows;
        final /* synthetic */ List<Flow<MiniJobInfo>> $uploadProgressFlows;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ JobsNotificationService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C17232(List<? extends Flow<MiniJobInfo>> list, JobsNotificationService jobsNotificationService, List<? extends Flow<MiniJobInfo>> list2, List<? extends Flow<MiniJobInfo>> list3, Continuation<? super C17232> continuation) {
            super(2, continuation);
            this.$uploadProgressFlows = list;
            this.this$0 = jobsNotificationService;
            this.$downloadProgressFlows = list2;
            this.$offlineProgressFlows = list3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C17232 c17232 = new C17232(this.$uploadProgressFlows, this.this$0, this.$downloadProgressFlows, this.$offlineProgressFlows, continuation);
            c17232.L$0 = obj;
            return c17232;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Job> continuation) {
            return ((C17232) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.box.android.services.JobsNotificationService$subscribeToJobs$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: JobsNotificationService.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.services.JobsNotificationService$subscribeToJobs$2$1", f = "JobsNotificationService.kt", i = {}, l = {192}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ List<Flow<MiniJobInfo>> $uploadProgressFlows;
            int label;
            final /* synthetic */ JobsNotificationService this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(List<? extends Flow<MiniJobInfo>> list, JobsNotificationService jobsNotificationService, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$uploadProgressFlows = list;
                this.this$0 = jobsNotificationService;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$uploadProgressFlows, this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    List<Flow<MiniJobInfo>> list = this.$uploadProgressFlows;
                    final JobsNotificationService jobsNotificationService = this.this$0;
                    final Flow[] flowArr = (Flow[]) CollectionsKt.toList(list).toArray(new Flow[0]);
                    Flow flowCancellable = FlowKt.cancellable(FlowKt.onEmpty(new Flow<JobInfo.Status>() { // from class: com.box.android.services.JobsNotificationService$subscribeToJobs$2$1$invokeSuspend$$inlined$combine$1
                        @Override // kotlinx.coroutines.flow.Flow
                        public Object collect(FlowCollector<? super JobInfo.Status> flowCollector, Continuation continuation) {
                            Flow[] flowArr2 = flowArr;
                            final Flow[] flowArr3 = flowArr;
                            Object objCombineInternal = CombineKt.combineInternal(flowCollector, flowArr2, new Function0<JobsNotificationService.MiniJobInfo[]>() { // from class: com.box.android.services.JobsNotificationService$subscribeToJobs$2$1$invokeSuspend$$inlined$combine$1.2
                                @Override // kotlin.jvm.functions.Function0
                                public final JobsNotificationService.MiniJobInfo[] invoke() {
                                    return new JobsNotificationService.MiniJobInfo[flowArr3.length];
                                }
                            }, new AnonymousClass3(null, jobsNotificationService), continuation);
                            return objCombineInternal == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCombineInternal : Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: com.box.android.services.JobsNotificationService$subscribeToJobs$2$1$invokeSuspend$$inlined$combine$1$3, reason: invalid class name */
                        /* JADX INFO: compiled from: Zip.kt */
                        @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0006\b\u0001\u0010\u0003\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0006H\n¨\u0006\u0007"}, d2 = {"<anonymous>", "", "R", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/FlowCollector;", "it", "", "kotlinx/coroutines/flow/FlowKt__ZipKt$combine$6$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
                        @DebugMetadata(c = "com.box.android.services.JobsNotificationService$subscribeToJobs$2$1$invokeSuspend$$inlined$combine$1$3", f = "JobsNotificationService.kt", i = {0, 0, 0, 0, 0, 1, 1}, l = {289, 288}, m = "invokeSuspend", n = {"$this$combineInternal", "it", "$completion", "jobInfos", "$i$a$-combine-JobsNotificationService$subscribeToJobs$2$1$1", "$this$combineInternal", "it"}, s = {"L$0", "L$1", "L$3", "L$4", "I$0", "L$0", "L$1"}, v = 1)
                        public static final class AnonymousClass3 extends SuspendLambda implements Function3<FlowCollector<? super JobInfo.Status>, JobsNotificationService.MiniJobInfo[], Continuation<? super Unit>, Object> {
                            int I$0;
                            private /* synthetic */ Object L$0;
                            /* synthetic */ Object L$1;
                            Object L$2;
                            Object L$3;
                            Object L$4;
                            int label;
                            final /* synthetic */ JobsNotificationService this$0;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            public AnonymousClass3(Continuation continuation, JobsNotificationService jobsNotificationService) {
                                super(3, continuation);
                                this.this$0 = jobsNotificationService;
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(FlowCollector<? super JobInfo.Status> flowCollector, JobsNotificationService.MiniJobInfo[] miniJobInfoArr, Continuation<? super Unit> continuation) {
                                AnonymousClass3 anonymousClass3 = new AnonymousClass3(continuation, this.this$0);
                                anonymousClass3.L$0 = flowCollector;
                                anonymousClass3.L$1 = miniJobInfoArr;
                                return anonymousClass3.invokeSuspend(Unit.INSTANCE);
                            }

                            /* JADX WARN: Code restructure failed: missing block: B:15:0x0095, code lost:
                            
                                if (r1.emit(r9, r8) == r0) goto L16;
                             */
                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                                To view partially-correct add '--show-bad-code' argument
                            */
                            public final java.lang.Object invokeSuspend(java.lang.Object r9) {
                                /*
                                    r8 = this;
                                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                    int r1 = r8.label
                                    r2 = 2
                                    r3 = 1
                                    if (r1 == 0) goto L3b
                                    if (r1 == r3) goto L23
                                    if (r1 != r2) goto L1b
                                    java.lang.Object r0 = r8.L$1
                                    java.lang.Object[] r0 = (java.lang.Object[]) r0
                                    java.lang.Object r8 = r8.L$0
                                    kotlinx.coroutines.flow.FlowCollector r8 = (kotlinx.coroutines.flow.FlowCollector) r8
                                    kotlin.ResultKt.throwOnFailure(r9)
                                    goto L98
                                L1b:
                                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                                    java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                                    r8.<init>(r9)
                                    throw r8
                                L23:
                                    java.lang.Object r1 = r8.L$4
                                    com.box.android.services.JobsNotificationService$MiniJobInfo[] r1 = (com.box.android.services.JobsNotificationService.MiniJobInfo[]) r1
                                    java.lang.Object r1 = r8.L$3
                                    kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                                    java.lang.Object r1 = r8.L$2
                                    kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                                    java.lang.Object r3 = r8.L$1
                                    java.lang.Object[] r3 = (java.lang.Object[]) r3
                                    java.lang.Object r4 = r8.L$0
                                    kotlinx.coroutines.flow.FlowCollector r4 = (kotlinx.coroutines.flow.FlowCollector) r4
                                    kotlin.ResultKt.throwOnFailure(r9)
                                    goto L79
                                L3b:
                                    kotlin.ResultKt.throwOnFailure(r9)
                                    java.lang.Object r9 = r8.L$0
                                    r1 = r9
                                    kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                                    java.lang.Object r9 = r8.L$1
                                    java.lang.Object[] r9 = (java.lang.Object[]) r9
                                    r4 = r8
                                    kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                                    r5 = r9
                                    com.box.android.services.JobsNotificationService$MiniJobInfo[] r5 = (com.box.android.services.JobsNotificationService.MiniJobInfo[]) r5
                                    com.box.android.services.JobsNotificationService r6 = r8.this$0
                                    java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
                                    r8.L$0 = r7
                                    java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
                                    r8.L$1 = r7
                                    r8.L$2 = r1
                                    java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r4)
                                    r8.L$3 = r4
                                    java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
                                    r8.L$4 = r4
                                    r4 = 0
                                    r8.I$0 = r4
                                    r8.label = r3
                                    java.lang.Object r3 = r6.handleFlowMapping(r5, r8)
                                    if (r3 != r0) goto L75
                                    goto L97
                                L75:
                                    r4 = r3
                                    r3 = r9
                                    r9 = r4
                                    r4 = r1
                                L79:
                                    r5 = r8
                                    kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                                    java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r4)
                                    r8.L$0 = r4
                                    java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3)
                                    r8.L$1 = r3
                                    r3 = 0
                                    r8.L$2 = r3
                                    r8.L$3 = r3
                                    r8.L$4 = r3
                                    r8.label = r2
                                    java.lang.Object r8 = r1.emit(r9, r5)
                                    if (r8 != r0) goto L98
                                L97:
                                    return r0
                                L98:
                                    kotlin.Unit r8 = kotlin.Unit.INSTANCE
                                    return r8
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.box.android.services.JobsNotificationService$subscribeToJobs$2$1$invokeSuspend$$inlined$combine$1.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
                            }
                        }
                    }, new C01862(null)));
                    final JobsNotificationService jobsNotificationService2 = this.this$0;
                    this.label = 1;
                    if (flowCancellable.collect(new FlowCollector() { // from class: com.box.android.services.JobsNotificationService.subscribeToJobs.2.1.3
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                            return emit((JobInfo.Status) obj2, (Continuation<? super Unit>) continuation);
                        }

                        public final Object emit(JobInfo.Status status, Continuation<? super Unit> continuation) {
                            jobsNotificationService2.handleFlowCollection(status, 1000, NotificationJobType.UPLOAD);
                            return Unit.INSTANCE;
                        }
                    }, this) == coroutine_suspended) {
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

            /* JADX INFO: renamed from: com.box.android.services.JobsNotificationService$subscribeToJobs$2$1$2, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: JobsNotificationService.kt */
            @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/models/JobInfo$Status;"}, k = 3, mv = {2, 2, 0}, xi = 48)
            @DebugMetadata(c = "com.box.android.services.JobsNotificationService$subscribeToJobs$2$1$2", f = "JobsNotificationService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            static final class C01862 extends SuspendLambda implements Function2<FlowCollector<? super JobInfo.Status>, Continuation<? super Unit>, Object> {
                int label;

                C01862(Continuation<? super C01862> continuation) {
                    super(2, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C01862(continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(FlowCollector<? super JobInfo.Status> flowCollector, Continuation<? super Unit> continuation) {
                    return ((C01862) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    BoxNotificationManager.cancel(1000);
                    return Unit.INSTANCE;
                }
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(this.$uploadProgressFlows, this.this$0, null), 3, null);
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C01872(this.$downloadProgressFlows, this.this$0, null), 3, null);
                return BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass3(this.$offlineProgressFlows, this.this$0, null), 3, null);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        /* JADX INFO: renamed from: com.box.android.services.JobsNotificationService$subscribeToJobs$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: JobsNotificationService.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.services.JobsNotificationService$subscribeToJobs$2$2", f = "JobsNotificationService.kt", i = {}, l = {206}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class C01872 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ List<Flow<MiniJobInfo>> $downloadProgressFlows;
            int label;
            final /* synthetic */ JobsNotificationService this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C01872(List<? extends Flow<MiniJobInfo>> list, JobsNotificationService jobsNotificationService, Continuation<? super C01872> continuation) {
                super(2, continuation);
                this.$downloadProgressFlows = list;
                this.this$0 = jobsNotificationService;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01872(this.$downloadProgressFlows, this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01872) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    List<Flow<MiniJobInfo>> list = this.$downloadProgressFlows;
                    final JobsNotificationService jobsNotificationService = this.this$0;
                    final Flow[] flowArr = (Flow[]) CollectionsKt.toList(list).toArray(new Flow[0]);
                    Flow flowCancellable = FlowKt.cancellable(FlowKt.onEmpty(new Flow<JobInfo.Status>() { // from class: com.box.android.services.JobsNotificationService$subscribeToJobs$2$2$invokeSuspend$$inlined$combine$1
                        @Override // kotlinx.coroutines.flow.Flow
                        public Object collect(FlowCollector<? super JobInfo.Status> flowCollector, Continuation continuation) {
                            Flow[] flowArr2 = flowArr;
                            final Flow[] flowArr3 = flowArr;
                            Object objCombineInternal = CombineKt.combineInternal(flowCollector, flowArr2, new Function0<JobsNotificationService.MiniJobInfo[]>() { // from class: com.box.android.services.JobsNotificationService$subscribeToJobs$2$2$invokeSuspend$$inlined$combine$1.2
                                @Override // kotlin.jvm.functions.Function0
                                public final JobsNotificationService.MiniJobInfo[] invoke() {
                                    return new JobsNotificationService.MiniJobInfo[flowArr3.length];
                                }
                            }, new AnonymousClass3(null, jobsNotificationService), continuation);
                            return objCombineInternal == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCombineInternal : Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: com.box.android.services.JobsNotificationService$subscribeToJobs$2$2$invokeSuspend$$inlined$combine$1$3, reason: invalid class name */
                        /* JADX INFO: compiled from: Zip.kt */
                        @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0006\b\u0001\u0010\u0003\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0006H\n¨\u0006\u0007"}, d2 = {"<anonymous>", "", "R", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/FlowCollector;", "it", "", "kotlinx/coroutines/flow/FlowKt__ZipKt$combine$6$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
                        @DebugMetadata(c = "com.box.android.services.JobsNotificationService$subscribeToJobs$2$2$invokeSuspend$$inlined$combine$1$3", f = "JobsNotificationService.kt", i = {0, 0, 0, 0, 0, 1, 1}, l = {289, 288}, m = "invokeSuspend", n = {"$this$combineInternal", "it", "$completion", "jobInfos", "$i$a$-combine-JobsNotificationService$subscribeToJobs$2$2$1", "$this$combineInternal", "it"}, s = {"L$0", "L$1", "L$3", "L$4", "I$0", "L$0", "L$1"}, v = 1)
                        public static final class AnonymousClass3 extends SuspendLambda implements Function3<FlowCollector<? super JobInfo.Status>, JobsNotificationService.MiniJobInfo[], Continuation<? super Unit>, Object> {
                            int I$0;
                            private /* synthetic */ Object L$0;
                            /* synthetic */ Object L$1;
                            Object L$2;
                            Object L$3;
                            Object L$4;
                            int label;
                            final /* synthetic */ JobsNotificationService this$0;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            public AnonymousClass3(Continuation continuation, JobsNotificationService jobsNotificationService) {
                                super(3, continuation);
                                this.this$0 = jobsNotificationService;
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(FlowCollector<? super JobInfo.Status> flowCollector, JobsNotificationService.MiniJobInfo[] miniJobInfoArr, Continuation<? super Unit> continuation) {
                                AnonymousClass3 anonymousClass3 = new AnonymousClass3(continuation, this.this$0);
                                anonymousClass3.L$0 = flowCollector;
                                anonymousClass3.L$1 = miniJobInfoArr;
                                return anonymousClass3.invokeSuspend(Unit.INSTANCE);
                            }

                            /* JADX WARN: Code restructure failed: missing block: B:15:0x0095, code lost:
                            
                                if (r1.emit(r9, r8) == r0) goto L16;
                             */
                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                                To view partially-correct add '--show-bad-code' argument
                            */
                            public final java.lang.Object invokeSuspend(java.lang.Object r9) {
                                /*
                                    r8 = this;
                                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                    int r1 = r8.label
                                    r2 = 2
                                    r3 = 1
                                    if (r1 == 0) goto L3b
                                    if (r1 == r3) goto L23
                                    if (r1 != r2) goto L1b
                                    java.lang.Object r0 = r8.L$1
                                    java.lang.Object[] r0 = (java.lang.Object[]) r0
                                    java.lang.Object r8 = r8.L$0
                                    kotlinx.coroutines.flow.FlowCollector r8 = (kotlinx.coroutines.flow.FlowCollector) r8
                                    kotlin.ResultKt.throwOnFailure(r9)
                                    goto L98
                                L1b:
                                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                                    java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                                    r8.<init>(r9)
                                    throw r8
                                L23:
                                    java.lang.Object r1 = r8.L$4
                                    com.box.android.services.JobsNotificationService$MiniJobInfo[] r1 = (com.box.android.services.JobsNotificationService.MiniJobInfo[]) r1
                                    java.lang.Object r1 = r8.L$3
                                    kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                                    java.lang.Object r1 = r8.L$2
                                    kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                                    java.lang.Object r3 = r8.L$1
                                    java.lang.Object[] r3 = (java.lang.Object[]) r3
                                    java.lang.Object r4 = r8.L$0
                                    kotlinx.coroutines.flow.FlowCollector r4 = (kotlinx.coroutines.flow.FlowCollector) r4
                                    kotlin.ResultKt.throwOnFailure(r9)
                                    goto L79
                                L3b:
                                    kotlin.ResultKt.throwOnFailure(r9)
                                    java.lang.Object r9 = r8.L$0
                                    r1 = r9
                                    kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                                    java.lang.Object r9 = r8.L$1
                                    java.lang.Object[] r9 = (java.lang.Object[]) r9
                                    r4 = r8
                                    kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                                    r5 = r9
                                    com.box.android.services.JobsNotificationService$MiniJobInfo[] r5 = (com.box.android.services.JobsNotificationService.MiniJobInfo[]) r5
                                    com.box.android.services.JobsNotificationService r6 = r8.this$0
                                    java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
                                    r8.L$0 = r7
                                    java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
                                    r8.L$1 = r7
                                    r8.L$2 = r1
                                    java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r4)
                                    r8.L$3 = r4
                                    java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
                                    r8.L$4 = r4
                                    r4 = 0
                                    r8.I$0 = r4
                                    r8.label = r3
                                    java.lang.Object r3 = r6.handleFlowMapping(r5, r8)
                                    if (r3 != r0) goto L75
                                    goto L97
                                L75:
                                    r4 = r3
                                    r3 = r9
                                    r9 = r4
                                    r4 = r1
                                L79:
                                    r5 = r8
                                    kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                                    java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r4)
                                    r8.L$0 = r4
                                    java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3)
                                    r8.L$1 = r3
                                    r3 = 0
                                    r8.L$2 = r3
                                    r8.L$3 = r3
                                    r8.L$4 = r3
                                    r8.label = r2
                                    java.lang.Object r8 = r1.emit(r9, r5)
                                    if (r8 != r0) goto L98
                                L97:
                                    return r0
                                L98:
                                    kotlin.Unit r8 = kotlin.Unit.INSTANCE
                                    return r8
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.box.android.services.JobsNotificationService$subscribeToJobs$2$2$invokeSuspend$$inlined$combine$1.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
                            }
                        }
                    }, new C01882(null)));
                    final JobsNotificationService jobsNotificationService2 = this.this$0;
                    this.label = 1;
                    if (flowCancellable.collect(new FlowCollector() { // from class: com.box.android.services.JobsNotificationService.subscribeToJobs.2.2.3
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                            return emit((JobInfo.Status) obj2, (Continuation<? super Unit>) continuation);
                        }

                        public final Object emit(JobInfo.Status status, Continuation<? super Unit> continuation) {
                            jobsNotificationService2.handleFlowCollection(status, 2000, NotificationJobType.DOWNLOAD);
                            return Unit.INSTANCE;
                        }
                    }, this) == coroutine_suspended) {
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

            /* JADX INFO: renamed from: com.box.android.services.JobsNotificationService$subscribeToJobs$2$2$2, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: JobsNotificationService.kt */
            @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/models/JobInfo$Status;"}, k = 3, mv = {2, 2, 0}, xi = 48)
            @DebugMetadata(c = "com.box.android.services.JobsNotificationService$subscribeToJobs$2$2$2", f = "JobsNotificationService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            static final class C01882 extends SuspendLambda implements Function2<FlowCollector<? super JobInfo.Status>, Continuation<? super Unit>, Object> {
                int label;

                C01882(Continuation<? super C01882> continuation) {
                    super(2, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C01882(continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(FlowCollector<? super JobInfo.Status> flowCollector, Continuation<? super Unit> continuation) {
                    return ((C01882) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    BoxNotificationManager.cancel(2000);
                    return Unit.INSTANCE;
                }
            }
        }

        /* JADX INFO: renamed from: com.box.android.services.JobsNotificationService$subscribeToJobs$2$3, reason: invalid class name */
        /* JADX INFO: compiled from: JobsNotificationService.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.services.JobsNotificationService$subscribeToJobs$2$3", f = "JobsNotificationService.kt", i = {}, l = {220}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ List<Flow<MiniJobInfo>> $offlineProgressFlows;
            int label;
            final /* synthetic */ JobsNotificationService this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass3(List<? extends Flow<MiniJobInfo>> list, JobsNotificationService jobsNotificationService, Continuation<? super AnonymousClass3> continuation) {
                super(2, continuation);
                this.$offlineProgressFlows = list;
                this.this$0 = jobsNotificationService;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass3(this.$offlineProgressFlows, this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    List<Flow<MiniJobInfo>> list = this.$offlineProgressFlows;
                    final JobsNotificationService jobsNotificationService = this.this$0;
                    final Flow[] flowArr = (Flow[]) CollectionsKt.toList(list).toArray(new Flow[0]);
                    Flow flowCancellable = FlowKt.cancellable(FlowKt.onEmpty(new Flow<JobInfo.Status>() { // from class: com.box.android.services.JobsNotificationService$subscribeToJobs$2$3$invokeSuspend$$inlined$combine$1
                        @Override // kotlinx.coroutines.flow.Flow
                        public Object collect(FlowCollector<? super JobInfo.Status> flowCollector, Continuation continuation) {
                            Flow[] flowArr2 = flowArr;
                            final Flow[] flowArr3 = flowArr;
                            Object objCombineInternal = CombineKt.combineInternal(flowCollector, flowArr2, new Function0<JobsNotificationService.MiniJobInfo[]>() { // from class: com.box.android.services.JobsNotificationService$subscribeToJobs$2$3$invokeSuspend$$inlined$combine$1.2
                                @Override // kotlin.jvm.functions.Function0
                                public final JobsNotificationService.MiniJobInfo[] invoke() {
                                    return new JobsNotificationService.MiniJobInfo[flowArr3.length];
                                }
                            }, new AnonymousClass3(null, jobsNotificationService), continuation);
                            return objCombineInternal == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCombineInternal : Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: com.box.android.services.JobsNotificationService$subscribeToJobs$2$3$invokeSuspend$$inlined$combine$1$3, reason: invalid class name */
                        /* JADX INFO: compiled from: Zip.kt */
                        @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0006\b\u0001\u0010\u0003\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0006H\n¨\u0006\u0007"}, d2 = {"<anonymous>", "", "R", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/FlowCollector;", "it", "", "kotlinx/coroutines/flow/FlowKt__ZipKt$combine$6$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
                        @DebugMetadata(c = "com.box.android.services.JobsNotificationService$subscribeToJobs$2$3$invokeSuspend$$inlined$combine$1$3", f = "JobsNotificationService.kt", i = {0, 0, 0, 0, 0, 1, 1}, l = {289, 288}, m = "invokeSuspend", n = {"$this$combineInternal", "it", "$completion", "jobInfos", "$i$a$-combine-JobsNotificationService$subscribeToJobs$2$3$1", "$this$combineInternal", "it"}, s = {"L$0", "L$1", "L$3", "L$4", "I$0", "L$0", "L$1"}, v = 1)
                        public static final class AnonymousClass3 extends SuspendLambda implements Function3<FlowCollector<? super JobInfo.Status>, JobsNotificationService.MiniJobInfo[], Continuation<? super Unit>, Object> {
                            int I$0;
                            private /* synthetic */ Object L$0;
                            /* synthetic */ Object L$1;
                            Object L$2;
                            Object L$3;
                            Object L$4;
                            int label;
                            final /* synthetic */ JobsNotificationService this$0;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            public AnonymousClass3(Continuation continuation, JobsNotificationService jobsNotificationService) {
                                super(3, continuation);
                                this.this$0 = jobsNotificationService;
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(FlowCollector<? super JobInfo.Status> flowCollector, JobsNotificationService.MiniJobInfo[] miniJobInfoArr, Continuation<? super Unit> continuation) {
                                AnonymousClass3 anonymousClass3 = new AnonymousClass3(continuation, this.this$0);
                                anonymousClass3.L$0 = flowCollector;
                                anonymousClass3.L$1 = miniJobInfoArr;
                                return anonymousClass3.invokeSuspend(Unit.INSTANCE);
                            }

                            /* JADX WARN: Code restructure failed: missing block: B:15:0x0095, code lost:
                            
                                if (r1.emit(r9, r8) == r0) goto L16;
                             */
                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                                To view partially-correct add '--show-bad-code' argument
                            */
                            public final java.lang.Object invokeSuspend(java.lang.Object r9) {
                                /*
                                    r8 = this;
                                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                    int r1 = r8.label
                                    r2 = 2
                                    r3 = 1
                                    if (r1 == 0) goto L3b
                                    if (r1 == r3) goto L23
                                    if (r1 != r2) goto L1b
                                    java.lang.Object r0 = r8.L$1
                                    java.lang.Object[] r0 = (java.lang.Object[]) r0
                                    java.lang.Object r8 = r8.L$0
                                    kotlinx.coroutines.flow.FlowCollector r8 = (kotlinx.coroutines.flow.FlowCollector) r8
                                    kotlin.ResultKt.throwOnFailure(r9)
                                    goto L98
                                L1b:
                                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                                    java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                                    r8.<init>(r9)
                                    throw r8
                                L23:
                                    java.lang.Object r1 = r8.L$4
                                    com.box.android.services.JobsNotificationService$MiniJobInfo[] r1 = (com.box.android.services.JobsNotificationService.MiniJobInfo[]) r1
                                    java.lang.Object r1 = r8.L$3
                                    kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                                    java.lang.Object r1 = r8.L$2
                                    kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                                    java.lang.Object r3 = r8.L$1
                                    java.lang.Object[] r3 = (java.lang.Object[]) r3
                                    java.lang.Object r4 = r8.L$0
                                    kotlinx.coroutines.flow.FlowCollector r4 = (kotlinx.coroutines.flow.FlowCollector) r4
                                    kotlin.ResultKt.throwOnFailure(r9)
                                    goto L79
                                L3b:
                                    kotlin.ResultKt.throwOnFailure(r9)
                                    java.lang.Object r9 = r8.L$0
                                    r1 = r9
                                    kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                                    java.lang.Object r9 = r8.L$1
                                    java.lang.Object[] r9 = (java.lang.Object[]) r9
                                    r4 = r8
                                    kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                                    r5 = r9
                                    com.box.android.services.JobsNotificationService$MiniJobInfo[] r5 = (com.box.android.services.JobsNotificationService.MiniJobInfo[]) r5
                                    com.box.android.services.JobsNotificationService r6 = r8.this$0
                                    java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
                                    r8.L$0 = r7
                                    java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
                                    r8.L$1 = r7
                                    r8.L$2 = r1
                                    java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r4)
                                    r8.L$3 = r4
                                    java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
                                    r8.L$4 = r4
                                    r4 = 0
                                    r8.I$0 = r4
                                    r8.label = r3
                                    java.lang.Object r3 = r6.handleFlowMapping(r5, r8)
                                    if (r3 != r0) goto L75
                                    goto L97
                                L75:
                                    r4 = r3
                                    r3 = r9
                                    r9 = r4
                                    r4 = r1
                                L79:
                                    r5 = r8
                                    kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                                    java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r4)
                                    r8.L$0 = r4
                                    java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3)
                                    r8.L$1 = r3
                                    r3 = 0
                                    r8.L$2 = r3
                                    r8.L$3 = r3
                                    r8.L$4 = r3
                                    r8.label = r2
                                    java.lang.Object r8 = r1.emit(r9, r5)
                                    if (r8 != r0) goto L98
                                L97:
                                    return r0
                                L98:
                                    kotlin.Unit r8 = kotlin.Unit.INSTANCE
                                    return r8
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.box.android.services.JobsNotificationService$subscribeToJobs$2$3$invokeSuspend$$inlined$combine$1.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
                            }
                        }
                    }, new C01892(null)));
                    final JobsNotificationService jobsNotificationService2 = this.this$0;
                    this.label = 1;
                    if (flowCancellable.collect(new FlowCollector() { // from class: com.box.android.services.JobsNotificationService.subscribeToJobs.2.3.3
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                            return emit((JobInfo.Status) obj2, (Continuation<? super Unit>) continuation);
                        }

                        public final Object emit(JobInfo.Status status, Continuation<? super Unit> continuation) {
                            jobsNotificationService2.handleFlowCollection(status, 3000, NotificationJobType.OFFLINE);
                            return Unit.INSTANCE;
                        }
                    }, this) == coroutine_suspended) {
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

            /* JADX INFO: renamed from: com.box.android.services.JobsNotificationService$subscribeToJobs$2$3$2, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: JobsNotificationService.kt */
            @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/models/JobInfo$Status;"}, k = 3, mv = {2, 2, 0}, xi = 48)
            @DebugMetadata(c = "com.box.android.services.JobsNotificationService$subscribeToJobs$2$3$2", f = "JobsNotificationService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            static final class C01892 extends SuspendLambda implements Function2<FlowCollector<? super JobInfo.Status>, Continuation<? super Unit>, Object> {
                int label;

                C01892(Continuation<? super C01892> continuation) {
                    super(2, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C01892(continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(FlowCollector<? super JobInfo.Status> flowCollector, Continuation<? super Unit> continuation) {
                    return ((C01892) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    BoxNotificationManager.cancel(3000);
                    return Unit.INSTANCE;
                }
            }
        }
    }

    public final void handleFlowCollection(JobInfo.Status status, int inProgressNotifId, NotificationJobType notificationJobType) {
        String string;
        Intrinsics.checkNotNullParameter(notificationJobType, "notificationJobType");
        Integer notificationTitle = getNotificationTitle(status, notificationJobType);
        if (notificationTitle != null) {
            string = getContext().getString(notificationTitle.intValue());
        } else {
            string = null;
        }
        if (string != null) {
            NotificationCompat.Builder builderBuildNotif = buildNotif();
            String str = string;
            builderBuildNotif.setContentTitle(str);
            builderBuildNotif.setSmallIcon(2131231969);
            builderBuildNotif.setTicker(str);
            if (status instanceof JobInfo.Status.Running) {
                JobInfo.Status.Running running = (JobInfo.Status.Running) status;
                JobInfo.Progress progress = running.getProgress();
                Intrinsics.checkNotNull(progress);
                int estimatedTotal = (int) progress.getEstimatedTotal();
                JobInfo.Progress progress2 = running.getProgress();
                Intrinsics.checkNotNull(progress2);
                builderBuildNotif.setProgress(estimatedTotal, (int) progress2.getDone(), false);
                builderBuildNotif.setOngoing(true);
                BoxNotificationManager.cancel(NotificationIdManager.INSTANCE.getCompletionId(inProgressNotifId));
                Notification notificationBuild = builderBuildNotif.build();
                Intrinsics.checkNotNullExpressionValue(notificationBuild, "build(...)");
                BoxNotificationManager.notify(inProgressNotifId, notificationBuild);
                return;
            }
            BoxNotificationManager.cancel(inProgressNotifId);
            int completionId = NotificationIdManager.INSTANCE.getCompletionId(inProgressNotifId);
            Notification notificationBuild2 = builderBuildNotif.build();
            Intrinsics.checkNotNullExpressionValue(notificationBuild2, "build(...)");
            BoxNotificationManager.notify(completionId, notificationBuild2);
            BoxPresentationUtils.displayToast(string, getContext());
            if (Intrinsics.areEqual(status, JobInfo.Status.Succeeded.INSTANCE)) {
                cancelSubscription();
                return;
            }
            return;
        }
        BoxNotificationManager.cancel(inProgressNotifId);
    }

    /* JADX INFO: renamed from: com.box.android.services.JobsNotificationService$saveKnownFailedJobs$2, reason: invalid class name */
    /* JADX INFO: compiled from: JobsNotificationService.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.services.JobsNotificationService$saveKnownFailedJobs$2", f = "JobsNotificationService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = JobsNotificationService.this.new AnonymousClass2(continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(MutablePreferences mutablePreferences, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(mutablePreferences, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MutablePreferences mutablePreferences = (MutablePreferences) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            mutablePreferences.set(JobsNotificationService.this.getKnownFailedJobsKey(), JobsNotificationService.this.getKnownFailedJobs());
            return Unit.INSTANCE;
        }
    }

    public final Object saveKnownFailedJobs(Continuation<? super Unit> continuation) {
        Object objEdit = PreferencesKt.edit(getJobNotificationDataStore(getContext()), new AnonymousClass2(null), continuation);
        return objEdit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEdit : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object handleFlowMapping(MiniJobInfo[] miniJobInfoArr, Continuation<? super JobInfo.Status> continuation) {
        C17191 c17191;
        List list;
        double d;
        double done;
        double estimatedTotal;
        JobInfo.Status status;
        if (continuation instanceof C17191) {
            c17191 = (C17191) continuation;
            if ((c17191.label & Integer.MIN_VALUE) != 0) {
                c17191.label -= Integer.MIN_VALUE;
            } else {
                c17191 = new C17191(continuation);
            }
        } else {
            c17191 = new C17191(continuation);
        }
        Object obj = c17191.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c17191.label;
        int i2 = 0;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (miniJobInfoArr.length == 0) {
                return null;
            }
            for (MiniJobInfo miniJobInfo : miniJobInfoArr) {
                if (!Intrinsics.areEqual(miniJobInfo.getStatus(), JobInfo.Status.Succeeded.INSTANCE) && !(miniJobInfo.getStatus() instanceof JobInfo.Status.Failed)) {
                    int length = miniJobInfoArr.length;
                    double d2 = 0.0d;
                    while (i2 < length) {
                        MiniJobInfo miniJobInfo2 = miniJobInfoArr[i2];
                        if (!(miniJobInfo2.getStatus() instanceof JobInfo.Status.Failed)) {
                            getKnownFailedJobs().remove(miniJobInfo2.getJobId());
                        }
                        JobInfo.Status status2 = miniJobInfo2.getStatus();
                        if (status2 instanceof JobInfo.Status.Paused) {
                            JobInfo.Progress progress = ((JobInfo.Status.Paused) status2).getProgress();
                            if (progress != null) {
                                done = progress.getDone();
                                estimatedTotal = progress.getEstimatedTotal();
                                d = done / estimatedTotal;
                            } else {
                                d = 0.0d;
                            }
                        } else {
                            if (status2 instanceof JobInfo.Status.Running) {
                                JobInfo.Progress progress2 = ((JobInfo.Status.Running) status2).getProgress();
                                if (progress2 != null) {
                                    done = progress2.getDone();
                                    estimatedTotal = progress2.getEstimatedTotal();
                                    d = done / estimatedTotal;
                                }
                            } else if (status2 instanceof JobInfo.Status.Succeeded) {
                                d = 1.0d;
                            }
                            d = 0.0d;
                        }
                        d2 += d;
                        i2++;
                    }
                    double d3 = 100;
                    return new JobInfo.Status.Running(new JobInfo.Progress(d2 * d3, ((double) miniJobInfoArr.length) * d3));
                }
            }
            ArrayList arrayList = new ArrayList();
            for (MiniJobInfo miniJobInfo3 : miniJobInfoArr) {
                if ((miniJobInfo3.getStatus() instanceof JobInfo.Status.Failed) && !getKnownFailedJobs().contains(miniJobInfo3.getJobId())) {
                    arrayList.add(miniJobInfo3);
                }
            }
            ArrayList arrayList2 = arrayList;
            Set<String> knownFailedJobs = getKnownFailedJobs();
            ArrayList arrayList3 = arrayList2;
            Collection<? extends String> arrayList4 = new ArrayList<>(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
            Iterator it = arrayList3.iterator();
            while (it.hasNext()) {
                arrayList4.add(((MiniJobInfo) it.next()).getJobId());
            }
            knownFailedJobs.addAll((List) arrayList4);
            c17191.L$0 = miniJobInfoArr;
            c17191.L$1 = arrayList2;
            c17191.label = 1;
            if (saveKnownFailedJobs(c17191) == coroutine_suspended) {
                return coroutine_suspended;
            }
            list = arrayList2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            list = (List) c17191.L$1;
            miniJobInfoArr = (MiniJobInfo[]) c17191.L$0;
            ResultKt.throwOnFailure(obj);
        }
        int length2 = miniJobInfoArr.length;
        while (true) {
            if (i2 < length2) {
                if (Intrinsics.areEqual(miniJobInfoArr[i2].getStatus(), JobInfo.Status.Succeeded.INSTANCE)) {
                    break;
                }
                i2++;
            } else {
                if (!list.isEmpty()) {
                    break;
                }
                return null;
            }
        }
        MiniJobInfo miniJobInfo4 = (MiniJobInfo) CollectionsKt.firstOrNull(list);
        return (miniJobInfo4 == null || (status = miniJobInfo4.getStatus()) == null) ? JobInfo.Status.Succeeded.INSTANCE : status;
    }

    public final NotificationCompat.Builder buildNotif() {
        Intent intent = new Intent(getContext(), (Class<?>) JobsUIActivity.class);
        intent.setFlags(805306368);
        NotificationCompat.Builder contentIntent = new NotificationCompat.Builder(getContext(), BoxNotificationManager.TRANSFERS_CHANNEL_ID).setSmallIcon(2131231969).setAutoCancel(true).setContentIntent(MAMPendingIntent.getActivity(BoxBaseApplication.getInstance(), 1, intent, 67108864));
        Intrinsics.checkNotNullExpressionValue(contentIntent, "setContentIntent(...)");
        return contentIntent;
    }

    private final void cancelSubscription() {
        Job job = this.coroutineJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.coroutineJob = null;
    }

    /* JADX INFO: renamed from: com.box.android.services.JobsNotificationService$refreshSubscription$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobsNotificationService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.services.JobsNotificationService$refreshSubscription$1", f = "JobsNotificationService.kt", i = {}, l = {362, 363}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C17211 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C17211(Continuation<? super C17211> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return JobsNotificationService.this.new C17211(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C17211) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x003a, code lost:
        
            if (r5.this$0.subscribeToJobs(r5) == r0) goto L15;
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
                goto L3d
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
                r6 = r5
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                r5.label = r3
                r3 = 500(0x1f4, double:2.47E-321)
                java.lang.Object r6 = kotlinx.coroutines.DelayKt.delay(r3, r6)
                if (r6 != r0) goto L2f
                goto L3c
            L2f:
                com.box.android.services.JobsNotificationService r6 = com.box.android.services.JobsNotificationService.this
                r1 = r5
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r5.label = r2
                java.lang.Object r5 = r6.subscribeToJobs(r1)
                if (r5 != r0) goto L3d
            L3c:
                return r0
            L3d:
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.services.JobsNotificationService.C17211.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // com.box.android.jobsui.IJobNotificationService
    public synchronized void refreshSubscription() {
        cancelSubscription();
        this.coroutineJob = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.coroutineDispatcher), null, null, new C17211(null), 3, null);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final NotificationJobType convertJobTypeToNotificationJobType(String jobType) {
        Intrinsics.checkNotNullParameter(jobType, "jobType");
        switch (jobType.hashCode()) {
            case -1688547876:
                if (!jobType.equals(JobType.UPLOAD_FILE_V2)) {
                    return null;
                }
                break;
            case -1456944423:
                if (jobType.equals(JobType.DOWNLOAD_FILE)) {
                    return NotificationJobType.DOWNLOAD;
                }
                return null;
            case -705838699:
                if (!jobType.equals(JobType.OFFLINE_FILE)) {
                    return null;
                }
                return NotificationJobType.OFFLINE;
            case -289892619:
                if (!jobType.equals(JobType.MARK_FOR_OFFLINE_FOLDER)) {
                    return null;
                }
                return NotificationJobType.OFFLINE;
            case 174752590:
                if (!jobType.equals(JobType.UPLOAD_FOLDER_V2)) {
                    return null;
                }
                break;
            case 1459562407:
                if (!jobType.equals(JobType.MARK_FOR_OFFLINE)) {
                    return null;
                }
                return NotificationJobType.OFFLINE;
            default:
                return null;
        }
        return NotificationJobType.UPLOAD;
    }

    public final NotificationJobType convertBoxJobCollectionToNotificationJobType(BoxJobCollection boxJobCollection) {
        Intrinsics.checkNotNullParameter(boxJobCollection, "boxJobCollection");
        if (boxJobCollection instanceof ExportBoxJobCollection) {
            return NotificationJobType.DOWNLOAD;
        }
        return null;
    }

    public final int getJobStartedTitle(NotificationJobType notificationJobType) {
        Intrinsics.checkNotNullParameter(notificationJobType, "notificationJobType");
        int i = WhenMappings.$EnumSwitchMapping$0[notificationJobType.ordinal()];
        if (i == 1) {
            return R.string.notif_upload_job_progress_title;
        }
        if (i == 2) {
            return R.string.notif_download_job_progress_title;
        }
        if (i == 3) {
            return R.string.notif_offline_job_progress_title;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.box.android.coreservices.utilities.JobEnqueuedListener
    public void reportJobEnqueued(BoxJobCollection boxJobCollection) {
        Intrinsics.checkNotNullParameter(boxJobCollection, "boxJobCollection");
        if (isNotificationNeeded(boxJobCollection)) {
            NotificationJobType notificationJobTypeConvertBoxJobCollectionToNotificationJobType = convertBoxJobCollectionToNotificationJobType(boxJobCollection);
            if (notificationJobTypeConvertBoxJobCollectionToNotificationJobType != null) {
                BoxPresentationUtils.displayToast(getContext().getString(getJobStartedTitle(notificationJobTypeConvertBoxJobCollectionToNotificationJobType)), getContext());
            }
            refreshSubscription();
        }
    }

    public final void handleJobEnqueuedEvent(IJobService.JobEnqueuedEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.userContextManager.getCurrentContextId() != null && event.getShowNotification()) {
            NotificationJobType notificationJobTypeConvertJobTypeToNotificationJobType = convertJobTypeToNotificationJobType(event.getJobType());
            if (notificationJobTypeConvertJobTypeToNotificationJobType != null) {
                BoxPresentationUtils.displayToast(getContext().getString(getJobStartedTitle(notificationJobTypeConvertJobTypeToNotificationJobType)), getContext());
            }
            refreshSubscription();
        }
    }

    /* JADX INFO: renamed from: com.box.android.services.JobsNotificationService$onCreate$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobsNotificationService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.services.JobsNotificationService$onCreate$1", f = "JobsNotificationService.kt", i = {}, l = {421}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C17201 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C17201(Continuation<? super C17201> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return JobsNotificationService.this.new C17201(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C17201) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SharedFlow<IJobService.JobEnqueuedEvent> jobEnqueuedFlow = JobsNotificationService.this.jobService.getJobEnqueuedFlow();
                final JobsNotificationService jobsNotificationService = JobsNotificationService.this;
                this.label = 1;
                if (jobEnqueuedFlow.collect(new FlowCollector() { // from class: com.box.android.services.JobsNotificationService.onCreate.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((IJobService.JobEnqueuedEvent) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(IJobService.JobEnqueuedEvent jobEnqueuedEvent, Continuation<? super Unit> continuation) {
                        jobsNotificationService.handleJobEnqueuedEvent(jobEnqueuedEvent);
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    @Override // com.box.android.domain.identity.IUserContextComponentListener
    public void onCreate(String contextId) {
        if (contextId == null) {
            return;
        }
        if (this.enqueuedEventsObserver == null) {
            this.enqueuedEventsObserver = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.coroutineDispatcher), null, null, new C17201(null), 3, null);
        }
        if (this.coroutineJob == null) {
            refreshSubscription();
        }
    }

    @Override // com.box.android.domain.identity.IUserContextComponentListener
    public void onSoftDestroy() {
        Job job = this.enqueuedEventsObserver;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.enqueuedEventsObserver = null;
        cancelSubscription();
        cancelAll();
    }

    @Override // com.box.android.domain.identity.IUserContextComponentListener
    public void onHardDestroy() {
        onSoftDestroy();
    }

    public final Integer getNotificationTitle(JobInfo.Status status, NotificationJobType notificationJobType) {
        Intrinsics.checkNotNullParameter(notificationJobType, "notificationJobType");
        if (status != null) {
            return this.notificationTitleMap.get(new Pair(Reflection.getOrCreateKotlinClass(status.getClass()), notificationJobType));
        }
        return null;
    }

    private final void cancelAll() {
        Iterator<T> it = NotificationIdManager.INSTANCE.getAllIds().iterator();
        while (it.hasNext()) {
            int iIntValue = ((Number) it.next()).intValue();
            BoxNotificationManager.cancel(iIntValue);
            BoxNotificationManager.cancel(NotificationIdManager.INSTANCE.getCompletionId(iIntValue));
        }
    }
}
