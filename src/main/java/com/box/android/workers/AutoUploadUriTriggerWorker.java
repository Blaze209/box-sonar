package com.box.android.workers;

import android.content.Context;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.work.Constraints;
import androidx.work.CoroutineWorker;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkerParameters;
import com.box.android.application.BoxBaseApplication;
import com.box.android.domain.analytics.BoxAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.identity.IUserContext;
import com.box.android.domain.identity.IUserContextComponent;
import com.box.android.domain.identity.IUserContextComponentListener;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.services.ILocalItemService;
import com.box.android.domain.utils.FileScannerUtil;
import com.box.android.localrepo.LocalAutoContentUploadInformation;
import com.box.androidsdk.content.auth.BoxAuthentication;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.androidsdk.content.utils.SdkUtils;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AutoUploadUriTriggerWorker.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0011\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0001\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u000e\u0010\u0015\u001a\u00020\u0016H\u0096@¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/box/android/workers/AutoUploadUriTriggerWorker;", "Landroidx/work/CoroutineWorker;", "appContext", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "boxApiPrivate", "Lcom/box/boxandroidlibv2private/resourcemanagers/BoxApiPrivate;", "localItemService", "Lcom/box/android/domain/services/ILocalItemService;", "coroutineDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;Lcom/box/android/domain/identity/IUserContextManager;Lcom/box/boxandroidlibv2private/resourcemanagers/BoxApiPrivate;Lcom/box/android/domain/services/ILocalItemService;Lkotlinx/coroutines/CoroutineDispatcher;)V", "userContextListener", "com/box/android/workers/AutoUploadUriTriggerWorker$userContextListener$1", "Lcom/box/android/workers/AutoUploadUriTriggerWorker$userContextListener$1;", "createUser", "", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isSyncNeeded", "", "uploadInfo", "Lcom/box/android/localrepo/LocalAutoContentUploadInformation;", "Companion", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AutoUploadUriTriggerWorker extends CoroutineWorker {
    private final BoxApiPrivate boxApiPrivate;
    private final CoroutineDispatcher coroutineDispatcher;
    private final ILocalItemService localItemService;
    private final AutoUploadUriTriggerWorker$userContextListener$1 userContextListener;
    private final IUserContextManager userContextManager;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final String TAG = "AutoUploadUriTriggerWorker";
    private static final Lazy<Uri> ALL_FILES_EXTERNAL$delegate = LazyKt.lazy(new Function0() { // from class: com.box.android.workers.AutoUploadUriTriggerWorker$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return AutoUploadUriTriggerWorker.ALL_FILES_EXTERNAL_delegate$lambda$0();
        }
    });

    /* JADX INFO: renamed from: com.box.android.workers.AutoUploadUriTriggerWorker$doWork$1, reason: invalid class name */
    /* JADX INFO: compiled from: AutoUploadUriTriggerWorker.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.workers.AutoUploadUriTriggerWorker", f = "AutoUploadUriTriggerWorker.kt", i = {}, l = {58}, m = "doWork", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutoUploadUriTriggerWorker.this.doWork(this);
        }
    }

    @JvmStatic
    public static final void toggleServices(LocalAutoContentUploadInformation localAutoContentUploadInformation) {
        INSTANCE.toggleServices(localAutoContentUploadInformation);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.box.android.workers.AutoUploadUriTriggerWorker$userContextListener$1] */
    public AutoUploadUriTriggerWorker(Context appContext, WorkerParameters workerParams, IUserContextManager userContextManager, BoxApiPrivate boxApiPrivate, ILocalItemService localItemService, CoroutineDispatcher coroutineDispatcher) {
        super(appContext, workerParams);
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(workerParams, "workerParams");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(boxApiPrivate, "boxApiPrivate");
        Intrinsics.checkNotNullParameter(localItemService, "localItemService");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "coroutineDispatcher");
        this.userContextManager = userContextManager;
        this.boxApiPrivate = boxApiPrivate;
        this.localItemService = localItemService;
        this.coroutineDispatcher = coroutineDispatcher;
        ?? r2 = new IUserContextComponentListener() { // from class: com.box.android.workers.AutoUploadUriTriggerWorker$userContextListener$1
            @Override // com.box.android.domain.identity.IUserContextComponentListener
            public void onCreate(String contextId) {
                Intrinsics.checkNotNullParameter(contextId, "contextId");
            }

            @Override // com.box.android.domain.identity.IUserContextComponentListener
            public void onSoftDestroy() {
                onHardDestroy();
            }

            @Override // com.box.android.domain.identity.IUserContextComponentListener
            public void onHardDestroy() {
                WorkManager.Companion companion = WorkManager.INSTANCE;
                Context applicationContext = this.this$0.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                WorkManager companion2 = companion.getInstance(applicationContext);
                String str = AutoUploadUriTriggerWorker.TAG;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                companion2.cancelAllWorkByTag(str);
            }
        };
        this.userContextListener = r2;
        userContextManager.addUserContextListener(TAG, (IUserContextComponentListener) r2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void createUser() throws IUserContextComponent.UserContextComponentCreationException {
        String lastAuthenticatedUserId = BoxAuthentication.getInstance().getLastAuthenticatedUserId(getApplicationContext());
        if (SdkUtils.isBlank(lastAuthenticatedUserId) || this.userContextManager.hasValidUserId() || this.userContextManager.isSwitchingOrDestroyingUser()) {
            return;
        }
        this.userContextManager.createUser(lastAuthenticatedUserId, this.boxApiPrivate);
    }

    /* JADX INFO: renamed from: com.box.android.workers.AutoUploadUriTriggerWorker$doWork$2, reason: invalid class name */
    /* JADX INFO: compiled from: AutoUploadUriTriggerWorker.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\f0\u0001¢\u0006\u0002\b\u0002¢\u0006\u0002\b\u0003*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Landroidx/work/ListenableWorker$Result;", "Lorg/jspecify/annotations/NonNull;", "Lkotlin/jvm/internal/EnhancedNullability;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.workers.AutoUploadUriTriggerWorker$doWork$2", f = "AutoUploadUriTriggerWorker.kt", i = {0, 0}, l = {94}, m = "invokeSuspend", n = {"authInfo", "uploadInfo"}, s = {"L$0", "L$1"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ListenableWorker.Result>, Object> {
        Object L$0;
        Object L$1;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AutoUploadUriTriggerWorker.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ListenableWorker.Result> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    AutoUploadUriTriggerWorker.this.createUser();
                    BoxAuthentication.BoxAuthenticationInfo authInfo = AutoUploadUriTriggerWorker.this.userContextManager.getBoxSession(AutoUploadUriTriggerWorker.this.getApplicationContext()).getAuthInfo();
                    if (authInfo == null) {
                        ListenableWorker.Result resultFailure = ListenableWorker.Result.failure();
                        String str = AutoUploadUriTriggerWorker.TAG;
                        Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                        BoxLogUtils.e(str, "Auth info is null");
                        return resultFailure;
                    }
                    if (authInfo.getUser() == null) {
                        ListenableWorker.Result resultFailure2 = ListenableWorker.Result.failure();
                        String str2 = AutoUploadUriTriggerWorker.TAG;
                        Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$cp(...)");
                        BoxLogUtils.e(str2, "Authenticated user is null");
                        return resultFailure2;
                    }
                    IUserContextComponent userContextComponent = AutoUploadUriTriggerWorker.this.userContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.LOCAL_AUTO_CONTENT_UPLOAD_INFORMATION);
                    Intrinsics.checkNotNull(userContextComponent, "null cannot be cast to non-null type com.box.android.localrepo.LocalAutoContentUploadInformation");
                    LocalAutoContentUploadInformation localAutoContentUploadInformation = (LocalAutoContentUploadInformation) userContextComponent;
                    if (!localAutoContentUploadInformation.isSyncEnabled()) {
                        String str3 = AutoUploadUriTriggerWorker.TAG;
                        Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$cp(...)");
                        BoxLogUtils.w(str3, "Auto upload is disabled. Skipping work.");
                        return ListenableWorker.Result.failure();
                    }
                    WorkManager.Companion companion = WorkManager.INSTANCE;
                    Context applicationContext = AutoUploadUriTriggerWorker.this.getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                    companion.getInstance(applicationContext).enqueue(AutoUploadUriTriggerWorker.INSTANCE.getWorkRequestWithConstraints(localAutoContentUploadInformation));
                    if (!AutoUploadUriTriggerWorker.this.isSyncNeeded(localAutoContentUploadInformation)) {
                        String str4 = AutoUploadUriTriggerWorker.TAG;
                        Intrinsics.checkNotNullExpressionValue(str4, "access$getTAG$cp(...)");
                        BoxLogUtils.v(str4, "Auto upload Sync not needed.");
                        return ListenableWorker.Result.success();
                    }
                    BoxAnalytics.trackEvent$default(BoxAnalytics.INSTANCE, BoxAnalyticsParams.CATEGORY_GENERAL_STATS, "autoContentUploadWorkerStarted", null, null, 12, null);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(authInfo);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(localAutoContentUploadInformation);
                    this.label = 1;
                    if (AutoUploadUriTriggerWorker.this.localItemService.initiateAutoUpload(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return ListenableWorker.Result.success();
            } catch (Exception e) {
                String str5 = AutoUploadUriTriggerWorker.TAG;
                Intrinsics.checkNotNullExpressionValue(str5, "access$getTAG$cp(...)");
                BoxLogUtils.e(str5, "Auto upload sync failed", e);
                if (e instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
                return ListenableWorker.Result.failure();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // androidx.work.CoroutineWorker
    public Object doWork(Continuation<? super ListenableWorker.Result> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objWithContext = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objWithContext);
            CoroutineDispatcher coroutineDispatcher = this.coroutineDispatcher;
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(null);
            anonymousClass1.label = 1;
            objWithContext = BuildersKt.withContext(coroutineDispatcher, anonymousClass2, anonymousClass1);
            if (objWithContext == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objWithContext);
        }
        Intrinsics.checkNotNullExpressionValue(objWithContext, "withContext(...)");
        return objWithContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isSyncNeeded(LocalAutoContentUploadInformation uploadInfo) {
        String uploadFolder = uploadInfo.getUploadFolder();
        if (uploadFolder == null) {
            return true;
        }
        List<Uri> triggeredContentUris = getTriggeredContentUris();
        Intrinsics.checkNotNullExpressionValue(triggeredContentUris, "getTriggeredContentUris(...)");
        ArrayList arrayList = new ArrayList();
        for (Uri uri : triggeredContentUris) {
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments != null && pathSegments.size() == INSTANCE.getALL_FILES_EXTERNAL().getPathSegments().size() + 1) {
                String str = (String) CollectionsKt.last((List) pathSegments);
                if (str != null) {
                    arrayList.add(str);
                }
            } else {
                String TAG2 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                BoxLogUtils.e(TAG2, "Triggered uri with pathsegments.size != 3 " + uri);
                return true;
            }
        }
        ArrayList arrayList2 = arrayList;
        if (FileScannerUtil.INSTANCE.hasAnyFileModifiedAfter(uploadFolder, uploadInfo.getLastAutoUploadSyncTime())) {
            uploadInfo.setLastAutoUploadSyncTime();
            return true;
        }
        uploadInfo.setLastAutoUploadSyncTime();
        FileScannerUtil fileScannerUtil = FileScannerUtil.INSTANCE;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        return fileScannerUtil.isAnyDeviceFileInSourceDirectory(arrayList2, uploadFolder, applicationContext);
    }

    /* JADX INFO: compiled from: AutoUploadUriTriggerWorker.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/box/android/workers/AutoUploadUriTriggerWorker$Companion;", "", "<init>", "()V", "TAG", "", "kotlin.jvm.PlatformType", "ALL_FILES_EXTERNAL", "Landroid/net/Uri;", "getALL_FILES_EXTERNAL", "()Landroid/net/Uri;", "ALL_FILES_EXTERNAL$delegate", "Lkotlin/Lazy;", "toggleServices", "", "uploadInfo", "Lcom/box/android/localrepo/LocalAutoContentUploadInformation;", "getCommonConstraints", "Landroidx/work/Constraints;", "getWorkRequestWithConstraints", "Landroidx/work/OneTimeWorkRequest;", "periodicWork", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Uri getALL_FILES_EXTERNAL() {
            Object value = AutoUploadUriTriggerWorker.ALL_FILES_EXTERNAL$delegate.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (Uri) value;
        }

        @JvmStatic
        public final void toggleServices(LocalAutoContentUploadInformation uploadInfo) {
            if (uploadInfo == null) {
                return;
            }
            Context applicationContext = BoxBaseApplication.getInstance().getApplicationContext();
            WorkManager.Companion companion = WorkManager.INSTANCE;
            Intrinsics.checkNotNull(applicationContext);
            WorkManager companion2 = companion.getInstance(applicationContext);
            String str = AutoUploadUriTriggerWorker.TAG;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
            companion2.cancelAllWorkByTag(str);
            if (uploadInfo.isSyncEnabled()) {
                periodicWork(uploadInfo);
                WorkManager.INSTANCE.getInstance(applicationContext).enqueue(getWorkRequestWithConstraints(uploadInfo));
            }
        }

        private final Constraints getCommonConstraints(LocalAutoContentUploadInformation uploadInfo) {
            return new Constraints.Builder().setRequiredNetworkType(uploadInfo.shouldUploadOverWifiOnly() ? NetworkType.UNMETERED : NetworkType.CONNECTED).addContentUriTrigger(getALL_FILES_EXTERNAL(), true).build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final OneTimeWorkRequest getWorkRequestWithConstraints(LocalAutoContentUploadInformation uploadInfo) {
            OneTimeWorkRequest.Builder constraints = new OneTimeWorkRequest.Builder((Class<? extends ListenableWorker>) AutoUploadUriTriggerWorker.class).setConstraints(getCommonConstraints(uploadInfo));
            String str = AutoUploadUriTriggerWorker.TAG;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
            return constraints.addTag(str).build();
        }

        private final void periodicWork(LocalAutoContentUploadInformation uploadInfo) {
            PeriodicWorkRequest.Builder constraints = new PeriodicWorkRequest.Builder((Class<? extends ListenableWorker>) AutoUploadUriTriggerWorker.class, 30L, TimeUnit.MINUTES).setConstraints(getCommonConstraints(uploadInfo));
            String str = AutoUploadUriTriggerWorker.TAG;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
            PeriodicWorkRequest periodicWorkRequestBuild = constraints.addTag(str).build();
            WorkManager.Companion companion = WorkManager.INSTANCE;
            BoxBaseApplication boxBaseApplication = BoxBaseApplication.getInstance();
            Intrinsics.checkNotNullExpressionValue(boxBaseApplication, "getInstance(...)");
            WorkManager companion2 = companion.getInstance(boxBaseApplication);
            String str2 = AutoUploadUriTriggerWorker.TAG;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$cp(...)");
            companion2.enqueueUniquePeriodicWork(str2, ExistingPeriodicWorkPolicy.CANCEL_AND_REENQUEUE, periodicWorkRequestBuild);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Uri ALL_FILES_EXTERNAL_delegate$lambda$0() {
        return MediaStore.Files.getContentUri(BoxAnalyticsParams.REFERRER_EXTERNAL);
    }
}
