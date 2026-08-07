package com.box.android.navigationmodernization;

import com.box.android.base.presentation.activities.BoxFragmentActivity_MembersInjector;
import com.box.android.base.presentation.message.BoxMessageDispatcher;
import com.box.android.base.presentation.shake.BetaFeedbackManager;
import com.box.android.base.presentation.utilities.IItemMoreActionsHandler;
import com.box.android.clientadmin.BoxAdminSettingsProvider;
import com.box.android.coreservices.jobmanager.JobManager;
import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.coreservices.modelcontroller.IMoCoAdminSettings;
import com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings;
import com.box.android.coreservices.modelcontroller.IMoCoBoxTransfers;
import com.box.android.coreservices.services.IUserContextMigration;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.coreservices.services.NotificationServices;
import com.box.android.coreservices.utilities.intune.IntuneAuthManager;
import com.box.android.data.persistence.offline.OfflineMigrationService;
import com.box.android.domain.configuration.ConfigManager;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.configuration.IBoxAccountSettings;
import com.box.android.domain.configuration.ISplitConfiguration;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.initialisation.ClientSettingsInitialisation;
import com.box.android.domain.offline.IOfflineStateStorage;
import com.box.android.domain.services.IAppRestrictionsManager;
import com.box.android.domain.services.IForceUpdateCoordinator;
import com.box.android.domain.services.IJobService;
import com.box.android.domain.services.ILocalItemService;
import com.box.android.domain.services.IOfflineFilesPolicyEnforcer;
import com.box.android.domain.usecases.capture.LaunchIntoCaptureUseCase;
import com.box.android.navigationmodernization.homescreen.helpers.FTUXMessageReceiverHelper;
import com.box.androidsdk.content.BoxApiShare;
import com.box.androidsdk.content.BoxApiUser;
import com.box.androidsdk.content.BoxExtendedApiPreview;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiWeblink;
import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class MainBaseActivity_MembersInjector implements MembersInjector<MainBaseActivity> {
    private final Provider<IMoCoAdminSettings> adminSettingsModelControllerProvider;
    private final Provider<BoxExtendedApiPreview> apiPreviewPrivateProvider;
    private final Provider<BetaFeedbackManager> betaFeedbackManagerProvider;
    private final Provider<IBoxAccountSettings> boxAccountSettingsProvider;
    private final Provider<BoxAdminSettingsProvider> boxAdminSettingsProvider;
    private final Provider<BoxApiUser> boxApiUserProvider;
    private final Provider<BoxMessageDispatcher> boxMessageDispatcherProvider;
    private final Provider<ClientSettingsInitialisation> clientSettingsInitialisationProvider;
    private final Provider<IForceUpdateCoordinator> forceUpdateCoordinatorProvider;
    private final Provider<FTUXMessageReceiverHelper> ftuxMessageReceiverHelperProvider;
    private final Provider<IntentServices> intentServicesProvider;
    private final Provider<IItemMoreActionsHandler.Factory> itemMoreActionsHandlerFactoryProvider;
    private final Provider<JobManager> jobManagerProvider;
    private final Provider<IJobService> jobServiceProvider;
    private final Provider<ILocalItemService> localItemServiceProvider;
    private final Provider<IBaseModelController> mBaseMocoProvider;
    private final Provider<IBoxAccountSettings> mBoxAccountSettingsProvider;
    private final Provider<BoxExtendedApiWeblink> mBoxApiBookmarkProvider;
    private final Provider<BoxApiPrivate> mBoxApiPrivateProvider;
    private final Provider<BoxApiShare> mBoxApiShareProvider;
    private final Provider<BoxExtendedApiFile> mBoxExtendedApiFileProvider;
    private final Provider<BoxExtendedApiFolder> mBoxExtendedApiFolderProvider;
    private final Provider<ConfigManager> mConfigManagerProvider;
    private final Provider<FeatureFlips> mFeatureFlipsProvider;
    private final Provider<IMoCoBoxGlobalSettings> mGlobalSettingsProvider;
    private final Provider<IntentServices> mIntentServicesProvider;
    private final Provider<IntuneAuthManager> mIntuneAuthManagerProvider;
    private final Provider<LaunchIntoCaptureUseCase> mLaunchIntoCaptureProvider;
    private final Provider<IUserContextMigration> mMigrationProvider;
    private final Provider<NotificationServices> mNotificationServicesProvider;
    private final Provider<IAppRestrictionsManager> mRestrictionsManagerProvider;
    private final Provider<ISplitConfiguration> mSplitConfigurationProvider;
    private final Provider<IMoCoBoxTransfers> mTransfersModelControllerProvider;
    private final Provider<IUserContextManager> mUserContextManagerProvider;
    private final Provider<IOfflineFilesPolicyEnforcer> offlineFilesPolicyEnforcerProvider;
    private final Provider<OfflineMigrationService> offlineMigrationServiceProvider;
    private final Provider<IOfflineStateStorage> offlineStateStorageProvider;

    private MainBaseActivity_MembersInjector(Provider<IMoCoBoxTransfers> provider, Provider<BoxExtendedApiFile> provider2, Provider<BoxExtendedApiWeblink> provider3, Provider<BoxExtendedApiFolder> provider4, Provider<IBaseModelController> provider5, Provider<BoxApiShare> provider6, Provider<IAppRestrictionsManager> provider7, Provider<IUserContextManager> provider8, Provider<IMoCoBoxGlobalSettings> provider9, Provider<IUserContextMigration> provider10, Provider<BoxApiPrivate> provider11, Provider<FeatureFlips> provider12, Provider<IBoxAccountSettings> provider13, Provider<IntentServices> provider14, Provider<ISplitConfiguration> provider15, Provider<ConfigManager> provider16, Provider<IForceUpdateCoordinator> provider17, Provider<NotificationServices> provider18, Provider<IntuneAuthManager> provider19, Provider<LaunchIntoCaptureUseCase> provider20, Provider<ClientSettingsInitialisation> provider21, Provider<BetaFeedbackManager> provider22, Provider<IItemMoreActionsHandler.Factory> provider23, Provider<JobManager> provider24, Provider<IJobService> provider25, Provider<IntentServices> provider26, Provider<BoxExtendedApiPreview> provider27, Provider<BoxMessageDispatcher> provider28, Provider<FTUXMessageReceiverHelper> provider29, Provider<IOfflineStateStorage> provider30, Provider<OfflineMigrationService> provider31, Provider<BoxAdminSettingsProvider> provider32, Provider<IMoCoAdminSettings> provider33, Provider<BoxApiUser> provider34, Provider<ILocalItemService> provider35, Provider<IBoxAccountSettings> provider36, Provider<IOfflineFilesPolicyEnforcer> provider37) {
        this.mTransfersModelControllerProvider = provider;
        this.mBoxExtendedApiFileProvider = provider2;
        this.mBoxApiBookmarkProvider = provider3;
        this.mBoxExtendedApiFolderProvider = provider4;
        this.mBaseMocoProvider = provider5;
        this.mBoxApiShareProvider = provider6;
        this.mRestrictionsManagerProvider = provider7;
        this.mUserContextManagerProvider = provider8;
        this.mGlobalSettingsProvider = provider9;
        this.mMigrationProvider = provider10;
        this.mBoxApiPrivateProvider = provider11;
        this.mFeatureFlipsProvider = provider12;
        this.mBoxAccountSettingsProvider = provider13;
        this.mIntentServicesProvider = provider14;
        this.mSplitConfigurationProvider = provider15;
        this.mConfigManagerProvider = provider16;
        this.forceUpdateCoordinatorProvider = provider17;
        this.mNotificationServicesProvider = provider18;
        this.mIntuneAuthManagerProvider = provider19;
        this.mLaunchIntoCaptureProvider = provider20;
        this.clientSettingsInitialisationProvider = provider21;
        this.betaFeedbackManagerProvider = provider22;
        this.itemMoreActionsHandlerFactoryProvider = provider23;
        this.jobManagerProvider = provider24;
        this.jobServiceProvider = provider25;
        this.intentServicesProvider = provider26;
        this.apiPreviewPrivateProvider = provider27;
        this.boxMessageDispatcherProvider = provider28;
        this.ftuxMessageReceiverHelperProvider = provider29;
        this.offlineStateStorageProvider = provider30;
        this.offlineMigrationServiceProvider = provider31;
        this.boxAdminSettingsProvider = provider32;
        this.adminSettingsModelControllerProvider = provider33;
        this.boxApiUserProvider = provider34;
        this.localItemServiceProvider = provider35;
        this.boxAccountSettingsProvider = provider36;
        this.offlineFilesPolicyEnforcerProvider = provider37;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(MainBaseActivity mainBaseActivity) {
        BoxFragmentActivity_MembersInjector.injectMTransfersModelController(mainBaseActivity, this.mTransfersModelControllerProvider.get());
        BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(mainBaseActivity, this.mBoxExtendedApiFileProvider.get());
        BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(mainBaseActivity, this.mBoxApiBookmarkProvider.get());
        BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(mainBaseActivity, this.mBoxExtendedApiFolderProvider.get());
        BoxFragmentActivity_MembersInjector.injectMBaseMoco(mainBaseActivity, this.mBaseMocoProvider.get());
        BoxFragmentActivity_MembersInjector.injectMBoxApiShare(mainBaseActivity, this.mBoxApiShareProvider.get());
        BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(mainBaseActivity, this.mRestrictionsManagerProvider.get());
        BoxFragmentActivity_MembersInjector.injectMUserContextManager(mainBaseActivity, this.mUserContextManagerProvider.get());
        BoxFragmentActivity_MembersInjector.injectMGlobalSettings(mainBaseActivity, this.mGlobalSettingsProvider.get());
        BoxFragmentActivity_MembersInjector.injectMMigration(mainBaseActivity, this.mMigrationProvider.get());
        BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(mainBaseActivity, this.mBoxApiPrivateProvider.get());
        BoxFragmentActivity_MembersInjector.injectMFeatureFlips(mainBaseActivity, this.mFeatureFlipsProvider.get());
        BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(mainBaseActivity, this.mBoxAccountSettingsProvider.get());
        BoxFragmentActivity_MembersInjector.injectMIntentServices(mainBaseActivity, this.mIntentServicesProvider.get());
        BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(mainBaseActivity, this.mSplitConfigurationProvider.get());
        BoxFragmentActivity_MembersInjector.injectMConfigManager(mainBaseActivity, this.mConfigManagerProvider.get());
        BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(mainBaseActivity, this.forceUpdateCoordinatorProvider.get());
        BoxFragmentActivity_MembersInjector.injectMNotificationServices(mainBaseActivity, this.mNotificationServicesProvider.get());
        BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(mainBaseActivity, this.mIntuneAuthManagerProvider.get());
        BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(mainBaseActivity, this.mLaunchIntoCaptureProvider.get());
        BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(mainBaseActivity, this.clientSettingsInitialisationProvider.get());
        BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(mainBaseActivity, this.betaFeedbackManagerProvider.get());
        injectItemMoreActionsHandlerFactory(mainBaseActivity, this.itemMoreActionsHandlerFactoryProvider.get());
        injectJobManager(mainBaseActivity, this.jobManagerProvider.get());
        injectJobService(mainBaseActivity, this.jobServiceProvider.get());
        injectIntentServices(mainBaseActivity, this.intentServicesProvider.get());
        injectApiPreviewPrivate(mainBaseActivity, this.apiPreviewPrivateProvider.get());
        injectBoxMessageDispatcher(mainBaseActivity, this.boxMessageDispatcherProvider.get());
        injectFtuxMessageReceiverHelper(mainBaseActivity, this.ftuxMessageReceiverHelperProvider.get());
        injectOfflineStateStorage(mainBaseActivity, this.offlineStateStorageProvider.get());
        injectOfflineMigrationService(mainBaseActivity, this.offlineMigrationServiceProvider.get());
        injectBoxAdminSettingsProvider(mainBaseActivity, this.boxAdminSettingsProvider.get());
        injectAdminSettingsModelController(mainBaseActivity, this.adminSettingsModelControllerProvider.get());
        injectBoxApiUser(mainBaseActivity, this.boxApiUserProvider.get());
        injectLocalItemService(mainBaseActivity, this.localItemServiceProvider.get());
        injectBoxAccountSettings(mainBaseActivity, this.boxAccountSettingsProvider.get());
        injectOfflineFilesPolicyEnforcer(mainBaseActivity, this.offlineFilesPolicyEnforcerProvider.get());
    }

    public static MembersInjector<MainBaseActivity> create(Provider<IMoCoBoxTransfers> provider, Provider<BoxExtendedApiFile> provider2, Provider<BoxExtendedApiWeblink> provider3, Provider<BoxExtendedApiFolder> provider4, Provider<IBaseModelController> provider5, Provider<BoxApiShare> provider6, Provider<IAppRestrictionsManager> provider7, Provider<IUserContextManager> provider8, Provider<IMoCoBoxGlobalSettings> provider9, Provider<IUserContextMigration> provider10, Provider<BoxApiPrivate> provider11, Provider<FeatureFlips> provider12, Provider<IBoxAccountSettings> provider13, Provider<IntentServices> provider14, Provider<ISplitConfiguration> provider15, Provider<ConfigManager> provider16, Provider<IForceUpdateCoordinator> provider17, Provider<NotificationServices> provider18, Provider<IntuneAuthManager> provider19, Provider<LaunchIntoCaptureUseCase> provider20, Provider<ClientSettingsInitialisation> provider21, Provider<BetaFeedbackManager> provider22, Provider<IItemMoreActionsHandler.Factory> provider23, Provider<JobManager> provider24, Provider<IJobService> provider25, Provider<IntentServices> provider26, Provider<BoxExtendedApiPreview> provider27, Provider<BoxMessageDispatcher> provider28, Provider<FTUXMessageReceiverHelper> provider29, Provider<IOfflineStateStorage> provider30, Provider<OfflineMigrationService> provider31, Provider<BoxAdminSettingsProvider> provider32, Provider<IMoCoAdminSettings> provider33, Provider<BoxApiUser> provider34, Provider<ILocalItemService> provider35, Provider<IBoxAccountSettings> provider36, Provider<IOfflineFilesPolicyEnforcer> provider37) {
        return new MainBaseActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19, provider20, provider21, provider22, provider23, provider24, provider25, provider26, provider27, provider28, provider29, provider30, provider31, provider32, provider33, provider34, provider35, provider36, provider37);
    }

    public static void injectItemMoreActionsHandlerFactory(MainBaseActivity mainBaseActivity, IItemMoreActionsHandler.Factory factory) {
        mainBaseActivity.itemMoreActionsHandlerFactory = factory;
    }

    public static void injectJobManager(MainBaseActivity mainBaseActivity, JobManager jobManager) {
        mainBaseActivity.jobManager = jobManager;
    }

    public static void injectJobService(MainBaseActivity mainBaseActivity, IJobService iJobService) {
        mainBaseActivity.jobService = iJobService;
    }

    public static void injectIntentServices(MainBaseActivity mainBaseActivity, IntentServices intentServices) {
        mainBaseActivity.intentServices = intentServices;
    }

    public static void injectApiPreviewPrivate(MainBaseActivity mainBaseActivity, BoxExtendedApiPreview boxExtendedApiPreview) {
        mainBaseActivity.apiPreviewPrivate = boxExtendedApiPreview;
    }

    public static void injectBoxMessageDispatcher(MainBaseActivity mainBaseActivity, BoxMessageDispatcher boxMessageDispatcher) {
        mainBaseActivity.boxMessageDispatcher = boxMessageDispatcher;
    }

    public static void injectFtuxMessageReceiverHelper(MainBaseActivity mainBaseActivity, FTUXMessageReceiverHelper fTUXMessageReceiverHelper) {
        mainBaseActivity.ftuxMessageReceiverHelper = fTUXMessageReceiverHelper;
    }

    public static void injectOfflineStateStorage(MainBaseActivity mainBaseActivity, IOfflineStateStorage iOfflineStateStorage) {
        mainBaseActivity.offlineStateStorage = iOfflineStateStorage;
    }

    public static void injectOfflineMigrationService(MainBaseActivity mainBaseActivity, OfflineMigrationService offlineMigrationService) {
        mainBaseActivity.offlineMigrationService = offlineMigrationService;
    }

    public static void injectBoxAdminSettingsProvider(MainBaseActivity mainBaseActivity, BoxAdminSettingsProvider boxAdminSettingsProvider) {
        mainBaseActivity.boxAdminSettingsProvider = boxAdminSettingsProvider;
    }

    public static void injectAdminSettingsModelController(MainBaseActivity mainBaseActivity, IMoCoAdminSettings iMoCoAdminSettings) {
        mainBaseActivity.adminSettingsModelController = iMoCoAdminSettings;
    }

    public static void injectBoxApiUser(MainBaseActivity mainBaseActivity, BoxApiUser boxApiUser) {
        mainBaseActivity.boxApiUser = boxApiUser;
    }

    public static void injectLocalItemService(MainBaseActivity mainBaseActivity, ILocalItemService iLocalItemService) {
        mainBaseActivity.localItemService = iLocalItemService;
    }

    public static void injectBoxAccountSettings(MainBaseActivity mainBaseActivity, IBoxAccountSettings iBoxAccountSettings) {
        mainBaseActivity.boxAccountSettings = iBoxAccountSettings;
    }

    public static void injectOfflineFilesPolicyEnforcer(MainBaseActivity mainBaseActivity, IOfflineFilesPolicyEnforcer iOfflineFilesPolicyEnforcer) {
        mainBaseActivity.offlineFilesPolicyEnforcer = iOfflineFilesPolicyEnforcer;
    }
}
