package com.box.android.navigationmodernization;

import com.box.android.base.cpl.IPreviewLauncher;
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
import com.box.android.domain.services.ITabPersistenceService;
import com.box.android.domain.usecases.capture.LaunchIntoCaptureUseCase;
import com.box.android.navigationmodernization.homescreen.helpers.FTUXMessageReceiverHelper;
import com.box.android.navigationmodernization.homescreen.navigation.compose.HomeScreenInnerNavigatorsProviderFactory;
import com.box.android.navigationmodernization.navigation.configuration.MainNavigationTargetConfigFactory;
import com.box.android.navigationmodernization.navigation.navigator.RootInnerNavigatorsProviderFactory;
import com.box.android.utilities.ItemClickHandler;
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
public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
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
    private final Provider<HomeScreenInnerNavigatorsProviderFactory.Factory> homeScreenInnerNavigatorsProviderFactoryProvider;
    private final Provider<IntentServices> intentServicesProvider;
    private final Provider<ItemClickHandler.Factory> itemClickHandlerFactoryProvider;
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
    private final Provider<MainNavigationTargetConfigFactory> mainNavigationTargetConfigFactoryProvider;
    private final Provider<IOfflineFilesPolicyEnforcer> offlineFilesPolicyEnforcerProvider;
    private final Provider<OfflineMigrationService> offlineMigrationServiceProvider;
    private final Provider<IOfflineStateStorage> offlineStateStorageProvider;
    private final Provider<IPreviewLauncher> previewLauncherProvider;
    private final Provider<RootInnerNavigatorsProviderFactory.Factory> rootInnerNavigatorsProviderFactoryProvider;
    private final Provider<ITabPersistenceService> tabPersistenceServiceProvider;

    private MainActivity_MembersInjector(Provider<IMoCoBoxTransfers> provider, Provider<BoxExtendedApiFile> provider2, Provider<BoxExtendedApiWeblink> provider3, Provider<BoxExtendedApiFolder> provider4, Provider<IBaseModelController> provider5, Provider<BoxApiShare> provider6, Provider<IAppRestrictionsManager> provider7, Provider<IUserContextManager> provider8, Provider<IMoCoBoxGlobalSettings> provider9, Provider<IUserContextMigration> provider10, Provider<BoxApiPrivate> provider11, Provider<FeatureFlips> provider12, Provider<IBoxAccountSettings> provider13, Provider<IntentServices> provider14, Provider<ISplitConfiguration> provider15, Provider<ConfigManager> provider16, Provider<IForceUpdateCoordinator> provider17, Provider<NotificationServices> provider18, Provider<IntuneAuthManager> provider19, Provider<LaunchIntoCaptureUseCase> provider20, Provider<ClientSettingsInitialisation> provider21, Provider<BetaFeedbackManager> provider22, Provider<IItemMoreActionsHandler.Factory> provider23, Provider<JobManager> provider24, Provider<IJobService> provider25, Provider<IntentServices> provider26, Provider<BoxExtendedApiPreview> provider27, Provider<BoxMessageDispatcher> provider28, Provider<FTUXMessageReceiverHelper> provider29, Provider<IOfflineStateStorage> provider30, Provider<OfflineMigrationService> provider31, Provider<BoxAdminSettingsProvider> provider32, Provider<IMoCoAdminSettings> provider33, Provider<BoxApiUser> provider34, Provider<ILocalItemService> provider35, Provider<IBoxAccountSettings> provider36, Provider<IOfflineFilesPolicyEnforcer> provider37, Provider<ItemClickHandler.Factory> provider38, Provider<RootInnerNavigatorsProviderFactory.Factory> provider39, Provider<HomeScreenInnerNavigatorsProviderFactory.Factory> provider40, Provider<ITabPersistenceService> provider41, Provider<IPreviewLauncher> provider42, Provider<MainNavigationTargetConfigFactory> provider43) {
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
        this.itemClickHandlerFactoryProvider = provider38;
        this.rootInnerNavigatorsProviderFactoryProvider = provider39;
        this.homeScreenInnerNavigatorsProviderFactoryProvider = provider40;
        this.tabPersistenceServiceProvider = provider41;
        this.previewLauncherProvider = provider42;
        this.mainNavigationTargetConfigFactoryProvider = provider43;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(MainActivity mainActivity) {
        BoxFragmentActivity_MembersInjector.injectMTransfersModelController(mainActivity, this.mTransfersModelControllerProvider.get());
        BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(mainActivity, this.mBoxExtendedApiFileProvider.get());
        BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(mainActivity, this.mBoxApiBookmarkProvider.get());
        BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(mainActivity, this.mBoxExtendedApiFolderProvider.get());
        BoxFragmentActivity_MembersInjector.injectMBaseMoco(mainActivity, this.mBaseMocoProvider.get());
        BoxFragmentActivity_MembersInjector.injectMBoxApiShare(mainActivity, this.mBoxApiShareProvider.get());
        BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(mainActivity, this.mRestrictionsManagerProvider.get());
        BoxFragmentActivity_MembersInjector.injectMUserContextManager(mainActivity, this.mUserContextManagerProvider.get());
        BoxFragmentActivity_MembersInjector.injectMGlobalSettings(mainActivity, this.mGlobalSettingsProvider.get());
        BoxFragmentActivity_MembersInjector.injectMMigration(mainActivity, this.mMigrationProvider.get());
        BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(mainActivity, this.mBoxApiPrivateProvider.get());
        BoxFragmentActivity_MembersInjector.injectMFeatureFlips(mainActivity, this.mFeatureFlipsProvider.get());
        BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(mainActivity, this.mBoxAccountSettingsProvider.get());
        BoxFragmentActivity_MembersInjector.injectMIntentServices(mainActivity, this.mIntentServicesProvider.get());
        BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(mainActivity, this.mSplitConfigurationProvider.get());
        BoxFragmentActivity_MembersInjector.injectMConfigManager(mainActivity, this.mConfigManagerProvider.get());
        BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(mainActivity, this.forceUpdateCoordinatorProvider.get());
        BoxFragmentActivity_MembersInjector.injectMNotificationServices(mainActivity, this.mNotificationServicesProvider.get());
        BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(mainActivity, this.mIntuneAuthManagerProvider.get());
        BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(mainActivity, this.mLaunchIntoCaptureProvider.get());
        BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(mainActivity, this.clientSettingsInitialisationProvider.get());
        BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(mainActivity, this.betaFeedbackManagerProvider.get());
        MainBaseActivity_MembersInjector.injectItemMoreActionsHandlerFactory(mainActivity, this.itemMoreActionsHandlerFactoryProvider.get());
        MainBaseActivity_MembersInjector.injectJobManager(mainActivity, this.jobManagerProvider.get());
        MainBaseActivity_MembersInjector.injectJobService(mainActivity, this.jobServiceProvider.get());
        MainBaseActivity_MembersInjector.injectIntentServices(mainActivity, this.intentServicesProvider.get());
        MainBaseActivity_MembersInjector.injectApiPreviewPrivate(mainActivity, this.apiPreviewPrivateProvider.get());
        MainBaseActivity_MembersInjector.injectBoxMessageDispatcher(mainActivity, this.boxMessageDispatcherProvider.get());
        MainBaseActivity_MembersInjector.injectFtuxMessageReceiverHelper(mainActivity, this.ftuxMessageReceiverHelperProvider.get());
        MainBaseActivity_MembersInjector.injectOfflineStateStorage(mainActivity, this.offlineStateStorageProvider.get());
        MainBaseActivity_MembersInjector.injectOfflineMigrationService(mainActivity, this.offlineMigrationServiceProvider.get());
        MainBaseActivity_MembersInjector.injectBoxAdminSettingsProvider(mainActivity, this.boxAdminSettingsProvider.get());
        MainBaseActivity_MembersInjector.injectAdminSettingsModelController(mainActivity, this.adminSettingsModelControllerProvider.get());
        MainBaseActivity_MembersInjector.injectBoxApiUser(mainActivity, this.boxApiUserProvider.get());
        MainBaseActivity_MembersInjector.injectLocalItemService(mainActivity, this.localItemServiceProvider.get());
        MainBaseActivity_MembersInjector.injectBoxAccountSettings(mainActivity, this.boxAccountSettingsProvider.get());
        MainBaseActivity_MembersInjector.injectOfflineFilesPolicyEnforcer(mainActivity, this.offlineFilesPolicyEnforcerProvider.get());
        injectItemClickHandlerFactory(mainActivity, this.itemClickHandlerFactoryProvider.get());
        injectRootInnerNavigatorsProviderFactory(mainActivity, this.rootInnerNavigatorsProviderFactoryProvider.get());
        injectHomeScreenInnerNavigatorsProviderFactory(mainActivity, this.homeScreenInnerNavigatorsProviderFactoryProvider.get());
        injectTabPersistenceService(mainActivity, this.tabPersistenceServiceProvider.get());
        injectPreviewLauncher(mainActivity, this.previewLauncherProvider.get());
        injectMainNavigationTargetConfigFactory(mainActivity, this.mainNavigationTargetConfigFactoryProvider.get());
    }

    public static MembersInjector<MainActivity> create(Provider<IMoCoBoxTransfers> provider, Provider<BoxExtendedApiFile> provider2, Provider<BoxExtendedApiWeblink> provider3, Provider<BoxExtendedApiFolder> provider4, Provider<IBaseModelController> provider5, Provider<BoxApiShare> provider6, Provider<IAppRestrictionsManager> provider7, Provider<IUserContextManager> provider8, Provider<IMoCoBoxGlobalSettings> provider9, Provider<IUserContextMigration> provider10, Provider<BoxApiPrivate> provider11, Provider<FeatureFlips> provider12, Provider<IBoxAccountSettings> provider13, Provider<IntentServices> provider14, Provider<ISplitConfiguration> provider15, Provider<ConfigManager> provider16, Provider<IForceUpdateCoordinator> provider17, Provider<NotificationServices> provider18, Provider<IntuneAuthManager> provider19, Provider<LaunchIntoCaptureUseCase> provider20, Provider<ClientSettingsInitialisation> provider21, Provider<BetaFeedbackManager> provider22, Provider<IItemMoreActionsHandler.Factory> provider23, Provider<JobManager> provider24, Provider<IJobService> provider25, Provider<IntentServices> provider26, Provider<BoxExtendedApiPreview> provider27, Provider<BoxMessageDispatcher> provider28, Provider<FTUXMessageReceiverHelper> provider29, Provider<IOfflineStateStorage> provider30, Provider<OfflineMigrationService> provider31, Provider<BoxAdminSettingsProvider> provider32, Provider<IMoCoAdminSettings> provider33, Provider<BoxApiUser> provider34, Provider<ILocalItemService> provider35, Provider<IBoxAccountSettings> provider36, Provider<IOfflineFilesPolicyEnforcer> provider37, Provider<ItemClickHandler.Factory> provider38, Provider<RootInnerNavigatorsProviderFactory.Factory> provider39, Provider<HomeScreenInnerNavigatorsProviderFactory.Factory> provider40, Provider<ITabPersistenceService> provider41, Provider<IPreviewLauncher> provider42, Provider<MainNavigationTargetConfigFactory> provider43) {
        return new MainActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19, provider20, provider21, provider22, provider23, provider24, provider25, provider26, provider27, provider28, provider29, provider30, provider31, provider32, provider33, provider34, provider35, provider36, provider37, provider38, provider39, provider40, provider41, provider42, provider43);
    }

    public static void injectItemClickHandlerFactory(MainActivity mainActivity, ItemClickHandler.Factory factory) {
        mainActivity.itemClickHandlerFactory = factory;
    }

    public static void injectRootInnerNavigatorsProviderFactory(MainActivity mainActivity, RootInnerNavigatorsProviderFactory.Factory factory) {
        mainActivity.rootInnerNavigatorsProviderFactory = factory;
    }

    public static void injectHomeScreenInnerNavigatorsProviderFactory(MainActivity mainActivity, HomeScreenInnerNavigatorsProviderFactory.Factory factory) {
        mainActivity.homeScreenInnerNavigatorsProviderFactory = factory;
    }

    public static void injectTabPersistenceService(MainActivity mainActivity, ITabPersistenceService iTabPersistenceService) {
        mainActivity.tabPersistenceService = iTabPersistenceService;
    }

    public static void injectPreviewLauncher(MainActivity mainActivity, IPreviewLauncher iPreviewLauncher) {
        mainActivity.previewLauncher = iPreviewLauncher;
    }

    public static void injectMainNavigationTargetConfigFactory(MainActivity mainActivity, MainNavigationTargetConfigFactory mainNavigationTargetConfigFactory) {
        mainActivity.mainNavigationTargetConfigFactory = mainNavigationTargetConfigFactory;
    }
}
