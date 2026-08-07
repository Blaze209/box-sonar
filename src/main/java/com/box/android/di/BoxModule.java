package com.box.android.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.media3.common.MimeTypes;
import com.box.android.activities.settings.FilesAndFoldersSettingsStoreFactory;
import com.box.android.activities.settings.IFilesAndFoldersSettingsStoreFactory;
import com.box.android.application.ProductFlavorConfigProvider;
import com.box.android.application.UserContextMigration;
import com.box.android.auth.AuthenticationCredentialsProvider;
import com.box.android.base.cpl.ICollectionsHelper;
import com.box.android.base.cpl.IPreviewLauncher;
import com.box.android.base.presentation.utilities.IItemActionHandler;
import com.box.android.base.presentation.utilities.IItemClickHandler;
import com.box.android.base.presentation.utilities.IItemMoreActionsHandler;
import com.box.android.base.routing.preview.PreviewRouter;
import com.box.android.base.routing.utilities.IPresentationRouter;
import com.box.android.browse.utilities.CollectionsHelper;
import com.box.android.capture.audiorecording.AudioRecordingConfig;
import com.box.android.capture.audiorecording.IAudioRecordingConfig;
import com.box.android.clientadmin.integrity.IntegrityAPICaller;
import com.box.android.common.utilities.threading.NamingThreadFactory;
import com.box.android.controller.ExecutorPool;
import com.box.android.controller.PriorityThreadPoolExecutor;
import com.box.android.coreservices.jobmanager.IJobManagerNotificationCenter;
import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings;
import com.box.android.coreservices.modelcontroller.MoCoBoxGlobalSettings;
import com.box.android.coreservices.modelcontroller.PriorityFutureTask;
import com.box.android.coreservices.models.BoxAccountSettings;
import com.box.android.coreservices.observability.appstart.IAppStartDestinationPageHolder;
import com.box.android.coreservices.services.IUserContextMigration;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.coreservices.services.NotificationServices;
import com.box.android.domain.configuration.BoxConfigConstants;
import com.box.android.domain.configuration.ConfigManager;
import com.box.android.domain.configuration.IBoxAccountSettings;
import com.box.android.domain.configuration.IProductFlavorConfig;
import com.box.android.domain.configuration.ISplitConfiguration;
import com.box.android.domain.configuration.SplitConfiguration;
import com.box.android.domain.identity.IUserContext;
import com.box.android.domain.identity.IUserContextComponent;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.localrepo.IBoxStorage;
import com.box.android.domain.localrepo.ILocalSharedPreferences;
import com.box.android.domain.services.IAppInBackgroundService;
import com.box.android.domain.services.IAppInfoService;
import com.box.android.domain.services.IAuthenticationCredentialsProvider;
import com.box.android.jobmanager.JobManagerNotificationCenter;
import com.box.android.jobsui.IJobNotificationService;
import com.box.android.localrepo.BoxStorage;
import com.box.android.localrepo.LevelDBKeyValueStore;
import com.box.android.localrepo.LocalSharedPreferences;
import com.box.android.observability.appstart.AppStartDestinationPageHolder;
import com.box.android.observability.appstart.AuthenticationAppStartDestinationPage;
import com.box.android.observability.appstart.BrowseTabAppStartDestinationPage;
import com.box.android.preview.utils.PreviewLauncher;
import com.box.android.routers.BoxPreviewRouter;
import com.box.android.services.AppIntentServices;
import com.box.android.services.AppNotificationServices;
import com.box.android.services.JobsNotificationService;
import com.box.android.tasksrepo.TasksRepo;
import com.box.android.usercontext.UserContextManager;
import com.box.android.utilities.AppInBackgroundService;
import com.box.android.utilities.AppInfoService;
import com.box.android.utilities.ISystemInfo;
import com.box.android.utilities.ItemActionHandler;
import com.box.android.utilities.ItemClickHandler;
import com.box.android.utilities.ItemMoreActionsHandler;
import com.box.android.utilities.PresentationRouter;
import com.box.android.utilities.SystemInfo;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;

/* JADX INFO: compiled from: BoxModule.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0094\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 [2\u00020\u0001:\u0001[B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH'J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH'J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H'J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H'J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH'J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH'J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H'J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H'J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H'J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H'J\u0010\u00100\u001a\u0002012\u0006\u00100\u001a\u000202H'J\u0010\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H'J\u0010\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H'J\u0010\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H'J\u0010\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020BH'J\u0010\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020FH'J\u0010\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020JH'J\u0010\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020NH'J\u0010\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020RH'J\u0010\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020VH'J\u0010\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020ZH'¨\u0006\\"}, d2 = {"Lcom/box/android/di/BoxModule;", "", "<init>", "()V", "provideUserContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "userContextManager", "Lcom/box/android/usercontext/UserContextManager;", "providesSplitConfiguration", "Lcom/box/android/domain/configuration/ISplitConfiguration;", "splitConfiguration", "Lcom/box/android/domain/configuration/SplitConfiguration;", "providesItemActionHandlerFactory", "Lcom/box/android/base/presentation/utilities/IItemActionHandler$Factory;", "itemActionHandlerFactory", "Lcom/box/android/utilities/ItemActionHandler$Factory;", "providesItemClickHandlerFactory", "Lcom/box/android/base/presentation/utilities/IItemClickHandler$Factory;", "itemClickHandlerFactory", "Lcom/box/android/utilities/ItemClickHandler$Factory;", "providesItemMoreActionsHandlerFactory", "Lcom/box/android/base/presentation/utilities/IItemMoreActionsHandler$Factory;", "itemMoreActionsHandlerFactory", "Lcom/box/android/utilities/ItemMoreActionsHandler$Factory;", "providesAudioRecordingConfig", "Lcom/box/android/capture/audiorecording/IAudioRecordingConfig;", "audioRecordingConfig", "Lcom/box/android/capture/audiorecording/AudioRecordingConfig;", "providesIAuthenticationCredentialsProvider", "Lcom/box/android/domain/services/IAuthenticationCredentialsProvider;", "authenticationCredentialsProvider", "Lcom/box/android/auth/AuthenticationCredentialsProvider;", "providePreviewRouter", "Lcom/box/android/base/routing/preview/PreviewRouter;", "previewRouter", "Lcom/box/android/routers/BoxPreviewRouter;", "provideBoxAccountSettings", "Lcom/box/android/domain/configuration/IBoxAccountSettings;", "boxAccountSettings", "Lcom/box/android/coreservices/models/BoxAccountSettings;", "provideProductFlavorConfig", "Lcom/box/android/domain/configuration/IProductFlavorConfig;", "productFlavorConfigProvider", "Lcom/box/android/application/ProductFlavorConfigProvider;", "provideLocalSharedPreferences", "Lcom/box/android/domain/localrepo/ILocalSharedPreferences;", "localSharedPreferences", "Lcom/box/android/localrepo/LocalSharedPreferences;", "appInfoService", "Lcom/box/android/domain/services/IAppInfoService;", "Lcom/box/android/utilities/AppInfoService;", "provideIntentServices", "Lcom/box/android/coreservices/services/IntentServices;", "appIntentServices", "Lcom/box/android/services/AppIntentServices;", "provideNotificationServices", "Lcom/box/android/coreservices/services/NotificationServices;", "appNotificationServices", "Lcom/box/android/services/AppNotificationServices;", "provideJobManagerNotificationCenter", "Lcom/box/android/coreservices/jobmanager/IJobManagerNotificationCenter;", "jobManagerNotificationCenter", "Lcom/box/android/jobmanager/JobManagerNotificationCenter;", "provideUserContextMigration", "Lcom/box/android/coreservices/services/IUserContextMigration;", "userContextMigration", "Lcom/box/android/application/UserContextMigration;", "providePresentationRouter", "Lcom/box/android/base/routing/utilities/IPresentationRouter;", "presentationRouter", "Lcom/box/android/utilities/PresentationRouter;", "providesCollectionHelper", "Lcom/box/android/base/cpl/ICollectionsHelper;", "collectionsHelper", "Lcom/box/android/browse/utilities/CollectionsHelper;", "providesPreviewLauncher", "Lcom/box/android/base/cpl/IPreviewLauncher;", "previewLauncher", "Lcom/box/android/preview/utils/PreviewLauncher;", "provideJobNotificationService", "Lcom/box/android/jobsui/IJobNotificationService;", "jobsNotificationService", "Lcom/box/android/services/JobsNotificationService;", "provideFilesAndFoldersSettingsStoreFactory", "Lcom/box/android/activities/settings/IFilesAndFoldersSettingsStoreFactory;", "factory", "Lcom/box/android/activities/settings/FilesAndFoldersSettingsStoreFactory;", "provideSystemInfo", "Lcom/box/android/utilities/ISystemInfo;", "systemInfo", "Lcom/box/android/utilities/SystemInfo;", "Companion", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module
public abstract class BoxModule {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Binds
    public abstract IAppInfoService appInfoService(AppInfoService appInfoService);

    @Binds
    public abstract IBoxAccountSettings provideBoxAccountSettings(BoxAccountSettings boxAccountSettings);

    @Binds
    public abstract IFilesAndFoldersSettingsStoreFactory provideFilesAndFoldersSettingsStoreFactory(FilesAndFoldersSettingsStoreFactory factory);

    @Binds
    public abstract IntentServices provideIntentServices(AppIntentServices appIntentServices);

    @Binds
    public abstract IJobManagerNotificationCenter provideJobManagerNotificationCenter(JobManagerNotificationCenter jobManagerNotificationCenter);

    @Binds
    public abstract IJobNotificationService provideJobNotificationService(JobsNotificationService jobsNotificationService);

    @Binds
    public abstract ILocalSharedPreferences provideLocalSharedPreferences(LocalSharedPreferences localSharedPreferences);

    @Binds
    public abstract NotificationServices provideNotificationServices(AppNotificationServices appNotificationServices);

    @Binds
    public abstract IPresentationRouter providePresentationRouter(PresentationRouter presentationRouter);

    @Binds
    public abstract PreviewRouter providePreviewRouter(BoxPreviewRouter previewRouter);

    @Binds
    public abstract IProductFlavorConfig provideProductFlavorConfig(ProductFlavorConfigProvider productFlavorConfigProvider);

    @Binds
    public abstract ISystemInfo provideSystemInfo(SystemInfo systemInfo);

    @Binds
    public abstract IUserContextManager provideUserContextManager(UserContextManager userContextManager);

    @Binds
    public abstract IUserContextMigration provideUserContextMigration(UserContextMigration userContextMigration);

    @Binds
    public abstract IAudioRecordingConfig providesAudioRecordingConfig(AudioRecordingConfig audioRecordingConfig);

    @Binds
    public abstract ICollectionsHelper providesCollectionHelper(CollectionsHelper collectionsHelper);

    @Binds
    public abstract IAuthenticationCredentialsProvider providesIAuthenticationCredentialsProvider(AuthenticationCredentialsProvider authenticationCredentialsProvider);

    @Binds
    public abstract IItemActionHandler.Factory providesItemActionHandlerFactory(ItemActionHandler.Factory itemActionHandlerFactory);

    @Binds
    public abstract IItemClickHandler.Factory providesItemClickHandlerFactory(ItemClickHandler.Factory itemClickHandlerFactory);

    @Binds
    public abstract IItemMoreActionsHandler.Factory providesItemMoreActionsHandlerFactory(ItemMoreActionsHandler.Factory itemMoreActionsHandlerFactory);

    @Binds
    public abstract IPreviewLauncher providesPreviewLauncher(PreviewLauncher previewLauncher);

    @Binds
    public abstract ISplitConfiguration providesSplitConfiguration(SplitConfiguration splitConfiguration);

    /* JADX INFO: compiled from: BoxModule.kt */
    @Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0005J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u0005H\u0007J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000eH\u0007J\b\u0010\u0015\u001a\u00020\u0016H\u0007J\b\u0010\u0017\u001a\u00020\u0016H\u0007J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000eH\u0007J\b\u0010\u0019\u001a\u00020\u0016H\u0007J\b\u0010\u001a\u001a\u00020\u0016H\u0007J\b\u0010\u001b\u001a\u00020\u0016H\u0007J\b\u0010\u001c\u001a\u00020\u001dH\u0007J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0007J\u0018\u0010\"\u001a\u00020#2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0007J\b\u0010(\u001a\u00020)H\u0007J\b\u0010*\u001a\u00020+H\u0007J\u0018\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0007J\b\u00102\u001a\u00020/H\u0007J\u0010\u00103\u001a\u0002012\u0006\u0010\r\u001a\u00020\u000eH\u0007J\b\u00104\u001a\u000205H\u0007J\b\u00106\u001a\u000207H\u0007¨\u00068"}, d2 = {"Lcom/box/android/di/BoxModule$Companion;", "", "<init>", "()V", "provideApplicationContext", "Landroid/content/Context;", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "provideLevelDBKeyValueStore", "Lcom/box/android/localrepo/LevelDBKeyValueStore;", "context", "provideBoxApiFile", "Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiFile;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "provideTasksRepo", "Lcom/box/android/tasksrepo/TasksRepo;", "baseMoCo", "Lcom/box/android/coreservices/modelcontroller/IBaseModelController;", "boxApiPrivate", "Lcom/box/boxandroidlibv2private/resourcemanagers/BoxApiPrivate;", "provideJobManagerExecutor", "Ljava/util/concurrent/ThreadPoolExecutor;", "provideFileTransferExecutor", "provideThumbnailExecutor", "provideApiExecutor", "provideLocalModelExecutor", "provideGlobalExecutor", "provideAuthorizerOkHttpClient", "Lokhttp3/OkHttpClient;", "providesIMoCoBoxGlobalSettings", "Lcom/box/android/coreservices/modelcontroller/IMoCoBoxGlobalSettings;", "moco", "Lcom/box/android/coreservices/modelcontroller/MoCoBoxGlobalSettings;", "providesBoxStorage", "Lcom/box/android/domain/localrepo/IBoxStorage;", "providesAuthenticationCredentialsProvider", "Lcom/box/android/auth/AuthenticationCredentialsProvider;", "configManager", "Lcom/box/android/domain/configuration/ConfigManager;", "provideGlobalSharedPreferences", "Landroid/content/SharedPreferences;", "appInBackgroundService", "Lcom/box/android/domain/services/IAppInBackgroundService;", "providesAppStartTargetHolder", "Lcom/box/android/coreservices/observability/appstart/IAppStartDestinationPageHolder;", "authenticationAppStartDestinationPage", "Lcom/box/android/observability/appstart/AuthenticationAppStartDestinationPage;", "browseTabAppStartDestinationPage", "Lcom/box/android/observability/appstart/BrowseTabAppStartDestinationPage;", "providesSplashScreenAppStartIntermediatePage", "providesBrowseTabAppStartDestinationPage", "provideAppFlavorString", "", "provideIntegrityAPICaller", "Lcom/box/android/clientadmin/integrity/IntegrityAPICaller;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Provides
        @Singleton
        public final Context provideApplicationContext(Application application) {
            Intrinsics.checkNotNullParameter(application, "application");
            Context applicationContext = application.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            return applicationContext;
        }

        @Provides
        @Singleton
        @Deprecated(level = DeprecationLevel.WARNING, message = "Do not inject LevelDB directly. Use IUserContext.getKVStore(). This binding will be removed.")
        protected final LevelDBKeyValueStore provideLevelDBKeyValueStore(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new LevelDBKeyValueStore(context);
        }

        @Provides
        @Singleton
        public final BoxExtendedApiFile provideBoxApiFile(IUserContextManager userContextManager, Context context) {
            Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
            Intrinsics.checkNotNullParameter(context, "context");
            return new BoxExtendedApiFile(userContextManager.getBoxSession(context));
        }

        @Provides
        @Singleton
        public final TasksRepo provideTasksRepo(IBaseModelController baseMoCo, BoxApiPrivate boxApiPrivate, IUserContextManager userContextManager) {
            Intrinsics.checkNotNullParameter(baseMoCo, "baseMoCo");
            Intrinsics.checkNotNullParameter(boxApiPrivate, "boxApiPrivate");
            Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
            return new TasksRepo(baseMoCo, boxApiPrivate, userContextManager);
        }

        @Provides
        @Named("job-manager")
        public final ThreadPoolExecutor provideJobManagerExecutor() {
            return new ThreadPoolExecutor(2, 2, 600L, TimeUnit.SECONDS, new LinkedBlockingQueue(10000), new NamingThreadFactory("JobManagerExecutor"));
        }

        @Provides
        @Named("file-transfer-executor")
        public final ThreadPoolExecutor provideFileTransferExecutor() {
            return new ThreadPoolExecutor(2, 2, 600L, TimeUnit.SECONDS, new LinkedBlockingQueue(10000), new NamingThreadFactory("fileTransferServiceExecutor"));
        }

        @Provides
        @Named("thumbnail-executor")
        public final ThreadPoolExecutor provideThumbnailExecutor(IUserContextManager userContextManager) {
            Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
            IUserContextComponent userContextComponent = userContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.EXECUTOR_POOL);
            Intrinsics.checkNotNull(userContextComponent, "null cannot be cast to non-null type com.box.android.controller.ExecutorPool");
            ThreadPoolExecutor apiExecutor = ((ExecutorPool) userContextComponent).getApiExecutor();
            Intrinsics.checkNotNullExpressionValue(apiExecutor, "getApiExecutor(...)");
            return apiExecutor;
        }

        @Provides
        @Named("api-executor")
        public final ThreadPoolExecutor provideApiExecutor() {
            return new PriorityThreadPoolExecutor(3, 3, 3600L, TimeUnit.SECONDS, new PriorityBlockingQueue(11, new PriorityFutureTask.PriorityFutureTaskComparator()), new NamingThreadFactory("apiExecutor"));
        }

        @Provides
        @Named("local-model-executor")
        public final ThreadPoolExecutor provideLocalModelExecutor() {
            return new ThreadPoolExecutor(20, 20, 3600L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamingThreadFactory("localModelExecutor"));
        }

        @Provides
        @Singleton
        @Named("global")
        public final ThreadPoolExecutor provideGlobalExecutor() {
            return new ThreadPoolExecutor(20, 20, 3600L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamingThreadFactory("GlobalExecutor"));
        }

        @Provides
        @Named("canvas-authorizer-http-client")
        public final OkHttpClient provideAuthorizerOkHttpClient() {
            return new OkHttpClient().newBuilder().followRedirects(false).build();
        }

        @Provides
        @Singleton
        public final IMoCoBoxGlobalSettings providesIMoCoBoxGlobalSettings(MoCoBoxGlobalSettings moco) {
            Intrinsics.checkNotNullParameter(moco, "moco");
            return moco;
        }

        @Provides
        @Singleton
        public final IBoxStorage providesBoxStorage(Context context, IUserContextManager userContextManager) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
            return new BoxStorage(userContextManager.getBoxSession(context), userContextManager);
        }

        @Provides
        @Singleton
        public final AuthenticationCredentialsProvider providesAuthenticationCredentialsProvider(ConfigManager configManager) {
            Intrinsics.checkNotNullParameter(configManager, "configManager");
            String string = configManager.getString(BoxConfigConstants.CONFIG_KEY_CLIENT_ID);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String string2 = configManager.getString(BoxConfigConstants.CONFIG_KEY_CLIENT_SECRET);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return new AuthenticationCredentialsProvider(string, string2);
        }

        @Provides
        @Singleton
        @Named("global-shared-preference")
        public final SharedPreferences provideGlobalSharedPreferences() {
            SharedPreferences sharedPreferences = new LocalSharedPreferences().getSharedPreferences(ILocalSharedPreferences.PreferenceName.GLOBAL);
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
            return sharedPreferences;
        }

        @Provides
        @Singleton
        public final IAppInBackgroundService appInBackgroundService() {
            return AppInBackgroundService.INSTANCE;
        }

        @Provides
        @Singleton
        public final IAppStartDestinationPageHolder providesAppStartTargetHolder(AuthenticationAppStartDestinationPage authenticationAppStartDestinationPage, BrowseTabAppStartDestinationPage browseTabAppStartDestinationPage) {
            Intrinsics.checkNotNullParameter(authenticationAppStartDestinationPage, "authenticationAppStartDestinationPage");
            Intrinsics.checkNotNullParameter(browseTabAppStartDestinationPage, "browseTabAppStartDestinationPage");
            return new AppStartDestinationPageHolder(authenticationAppStartDestinationPage, browseTabAppStartDestinationPage);
        }

        @Provides
        @Singleton
        public final AuthenticationAppStartDestinationPage providesSplashScreenAppStartIntermediatePage() {
            return new AuthenticationAppStartDestinationPage();
        }

        @Provides
        @Singleton
        public final BrowseTabAppStartDestinationPage providesBrowseTabAppStartDestinationPage(IUserContextManager userContextManager) {
            Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
            return new BrowseTabAppStartDestinationPage(userContextManager);
        }

        @Provides
        @Singleton
        @Named("app-flavor")
        public final String provideAppFlavorString() {
            return "generalProd";
        }

        @Provides
        public final IntegrityAPICaller provideIntegrityAPICaller() {
            return new IntegrityAPICaller();
        }
    }
}
