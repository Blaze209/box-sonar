package com.box.android.activities;

import com.box.android.base.presentation.activities.BoxFragmentActivity_MembersInjector;
import com.box.android.base.presentation.shake.BetaFeedbackManager;
import com.box.android.base.presentation.utilities.IItemActionHandler;
import com.box.android.browse.cpl.browse.fab.UploadHelper;
import com.box.android.browse.cpl.helpers.FabHelper;
import com.box.android.browse.fragments.SearchFragment;
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
import com.box.android.domain.controller.IBrowseController;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.initialisation.ClientSettingsInitialisation;
import com.box.android.domain.offline.IOfflineStateStorage;
import com.box.android.domain.services.IAppRestrictionsManager;
import com.box.android.domain.services.IForceUpdateCoordinator;
import com.box.android.domain.services.IJobService;
import com.box.android.domain.services.ILocalItemService;
import com.box.android.domain.services.IOfflineFilesPolicyEnforcer;
import com.box.android.domain.usecases.capture.LaunchIntoCaptureUseCase;
import com.box.android.jobsui.helpers.TransfersHelper;
import com.box.android.navigationmodernization.homescreen.helpers.FTUXMessageReceiverHelper;
import com.box.android.updates.proposal.AppUpdateProposalManager;
import com.box.androidsdk.content.BoxApiShare;
import com.box.androidsdk.content.BoxApiUser;
import com.box.androidsdk.content.BoxExtendedApiPreview;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiWeblink;
import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class MainParent_MembersInjector implements MembersInjector<MainParent> {
    private final Provider<AppUpdateProposalManager> appUpdateProposalManagerProvider;
    private final Provider<BetaFeedbackManager> betaFeedbackManagerProvider;
    private final Provider<BoxAdminSettingsProvider> boxAdminSettingsProvider;
    private final Provider<ClientSettingsInitialisation> clientSettingsInitialisationProvider;
    private final Provider<IForceUpdateCoordinator> forceUpdateCoordinatorProvider;
    private final Provider<FTUXMessageReceiverHelper> ftuxMessageReceiverHelperProvider;
    private final Provider<ILocalItemService> localItemServiceProvider;
    private final Provider<IMoCoAdminSettings> mAdminSettingsModelControllerProvider;
    private final Provider<BoxExtendedApiPreview> mApiPreviewPrivateProvider;
    private final Provider<IBaseModelController> mBaseMocoProvider;
    private final Provider<IBoxAccountSettings> mBoxAccountSettingsProvider;
    private final Provider<BoxExtendedApiWeblink> mBoxApiBookmarkProvider;
    private final Provider<BoxApiPrivate> mBoxApiPrivateProvider;
    private final Provider<BoxApiShare> mBoxApiShareProvider;
    private final Provider<BoxApiUser> mBoxApiUserProvider;
    private final Provider<BoxExtendedApiFile> mBoxExtendedApiFileProvider;
    private final Provider<BoxExtendedApiFolder> mBoxExtendedApiFolderProvider;
    private final Provider<IBrowseController> mBrowseControllerProvider;
    private final Provider<ConfigManager> mConfigManagerProvider;
    private final Provider<FabHelper.Factory> mFabHelperFactoryProvider;
    private final Provider<FeatureFlips> mFeatureFlipsProvider;
    private final Provider<IMoCoBoxGlobalSettings> mGlobalSettingsProvider;
    private final Provider<IntentServices> mIntentServicesProvider;
    private final Provider<IntentServices> mIntentServicesProvider2;
    private final Provider<IntuneAuthManager> mIntuneAuthManagerProvider;
    private final Provider<IItemActionHandler.Factory> mItemActionHandlerFactoryProvider;
    private final Provider<JobManager> mJobManagerProvider;
    private final Provider<IJobService> mJobServiceProvider;
    private final Provider<LaunchIntoCaptureUseCase> mLaunchIntoCaptureProvider;
    private final Provider<IUserContextMigration> mMigrationProvider;
    private final Provider<NotificationServices> mNotificationServicesProvider;
    private final Provider<IOfflineFilesPolicyEnforcer> mOfflineFilesPolicyEnforcerProvider;
    private final Provider<OfflineMigrationService> mOfflineMigrationServiceProvider;
    private final Provider<IOfflineStateStorage> mOfflineStateStorageProvider;
    private final Provider<IAppRestrictionsManager> mRestrictionsManagerProvider;
    private final Provider<SearchFragment.SearchActionLogHelper> mSearchActionLogHelperProvider;
    private final Provider<ISplitConfiguration> mSplitConfigurationProvider;
    private final Provider<TransfersHelper> mTransfersHelperProvider;
    private final Provider<IMoCoBoxTransfers> mTransfersModelControllerProvider;
    private final Provider<UploadHelper> mUploadHelperProvider;
    private final Provider<IUserContextManager> mUserContextManagerProvider;

    private MainParent_MembersInjector(Provider<IMoCoBoxTransfers> provider, Provider<BoxExtendedApiFile> provider2, Provider<BoxExtendedApiWeblink> provider3, Provider<BoxExtendedApiFolder> provider4, Provider<IBaseModelController> provider5, Provider<BoxApiShare> provider6, Provider<IAppRestrictionsManager> provider7, Provider<IUserContextManager> provider8, Provider<IMoCoBoxGlobalSettings> provider9, Provider<IUserContextMigration> provider10, Provider<BoxApiPrivate> provider11, Provider<FeatureFlips> provider12, Provider<IBoxAccountSettings> provider13, Provider<IntentServices> provider14, Provider<ISplitConfiguration> provider15, Provider<ConfigManager> provider16, Provider<IForceUpdateCoordinator> provider17, Provider<NotificationServices> provider18, Provider<IntuneAuthManager> provider19, Provider<LaunchIntoCaptureUseCase> provider20, Provider<ClientSettingsInitialisation> provider21, Provider<BetaFeedbackManager> provider22, Provider<IMoCoAdminSettings> provider23, Provider<BoxApiUser> provider24, Provider<IBrowseController> provider25, Provider<BoxExtendedApiPreview> provider26, Provider<JobManager> provider27, Provider<IJobService> provider28, Provider<TransfersHelper> provider29, Provider<FabHelper.Factory> provider30, Provider<ILocalItemService> provider31, Provider<BoxAdminSettingsProvider> provider32, Provider<UploadHelper> provider33, Provider<IntentServices> provider34, Provider<FTUXMessageReceiverHelper> provider35, Provider<AppUpdateProposalManager> provider36, Provider<OfflineMigrationService> provider37, Provider<IOfflineStateStorage> provider38, Provider<IOfflineFilesPolicyEnforcer> provider39, Provider<IItemActionHandler.Factory> provider40, Provider<SearchFragment.SearchActionLogHelper> provider41) {
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
        this.mAdminSettingsModelControllerProvider = provider23;
        this.mBoxApiUserProvider = provider24;
        this.mBrowseControllerProvider = provider25;
        this.mApiPreviewPrivateProvider = provider26;
        this.mJobManagerProvider = provider27;
        this.mJobServiceProvider = provider28;
        this.mTransfersHelperProvider = provider29;
        this.mFabHelperFactoryProvider = provider30;
        this.localItemServiceProvider = provider31;
        this.boxAdminSettingsProvider = provider32;
        this.mUploadHelperProvider = provider33;
        this.mIntentServicesProvider2 = provider34;
        this.ftuxMessageReceiverHelperProvider = provider35;
        this.appUpdateProposalManagerProvider = provider36;
        this.mOfflineMigrationServiceProvider = provider37;
        this.mOfflineStateStorageProvider = provider38;
        this.mOfflineFilesPolicyEnforcerProvider = provider39;
        this.mItemActionHandlerFactoryProvider = provider40;
        this.mSearchActionLogHelperProvider = provider41;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(MainParent mainParent) {
        BoxFragmentActivity_MembersInjector.injectMTransfersModelController(mainParent, this.mTransfersModelControllerProvider.get());
        BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(mainParent, this.mBoxExtendedApiFileProvider.get());
        BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(mainParent, this.mBoxApiBookmarkProvider.get());
        BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(mainParent, this.mBoxExtendedApiFolderProvider.get());
        BoxFragmentActivity_MembersInjector.injectMBaseMoco(mainParent, this.mBaseMocoProvider.get());
        BoxFragmentActivity_MembersInjector.injectMBoxApiShare(mainParent, this.mBoxApiShareProvider.get());
        BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(mainParent, this.mRestrictionsManagerProvider.get());
        BoxFragmentActivity_MembersInjector.injectMUserContextManager(mainParent, this.mUserContextManagerProvider.get());
        BoxFragmentActivity_MembersInjector.injectMGlobalSettings(mainParent, this.mGlobalSettingsProvider.get());
        BoxFragmentActivity_MembersInjector.injectMMigration(mainParent, this.mMigrationProvider.get());
        BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(mainParent, this.mBoxApiPrivateProvider.get());
        BoxFragmentActivity_MembersInjector.injectMFeatureFlips(mainParent, this.mFeatureFlipsProvider.get());
        BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(mainParent, this.mBoxAccountSettingsProvider.get());
        BoxFragmentActivity_MembersInjector.injectMIntentServices(mainParent, this.mIntentServicesProvider.get());
        BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(mainParent, this.mSplitConfigurationProvider.get());
        BoxFragmentActivity_MembersInjector.injectMConfigManager(mainParent, this.mConfigManagerProvider.get());
        BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(mainParent, this.forceUpdateCoordinatorProvider.get());
        BoxFragmentActivity_MembersInjector.injectMNotificationServices(mainParent, this.mNotificationServicesProvider.get());
        BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(mainParent, this.mIntuneAuthManagerProvider.get());
        BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(mainParent, this.mLaunchIntoCaptureProvider.get());
        BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(mainParent, this.clientSettingsInitialisationProvider.get());
        BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(mainParent, this.betaFeedbackManagerProvider.get());
        injectMAdminSettingsModelController(mainParent, this.mAdminSettingsModelControllerProvider.get());
        injectMBoxApiUser(mainParent, this.mBoxApiUserProvider.get());
        injectMBrowseController(mainParent, this.mBrowseControllerProvider.get());
        injectMApiPreviewPrivate(mainParent, this.mApiPreviewPrivateProvider.get());
        injectMJobManager(mainParent, this.mJobManagerProvider.get());
        injectMJobService(mainParent, this.mJobServiceProvider.get());
        injectMTransfersHelper(mainParent, this.mTransfersHelperProvider.get());
        injectMFabHelperFactory(mainParent, this.mFabHelperFactoryProvider.get());
        injectLocalItemService(mainParent, this.localItemServiceProvider.get());
        injectBoxAdminSettingsProvider(mainParent, this.boxAdminSettingsProvider.get());
        injectMUploadHelper(mainParent, this.mUploadHelperProvider.get());
        injectMIntentServices(mainParent, this.mIntentServicesProvider2.get());
        injectFtuxMessageReceiverHelper(mainParent, this.ftuxMessageReceiverHelperProvider.get());
        injectAppUpdateProposalManager(mainParent, this.appUpdateProposalManagerProvider.get());
        injectMOfflineMigrationService(mainParent, this.mOfflineMigrationServiceProvider.get());
        injectMOfflineStateStorage(mainParent, this.mOfflineStateStorageProvider.get());
        injectMOfflineFilesPolicyEnforcer(mainParent, this.mOfflineFilesPolicyEnforcerProvider.get());
        injectMItemActionHandlerFactory(mainParent, this.mItemActionHandlerFactoryProvider.get());
        injectMSearchActionLogHelper(mainParent, this.mSearchActionLogHelperProvider.get());
    }

    public static MembersInjector<MainParent> create(Provider<IMoCoBoxTransfers> provider, Provider<BoxExtendedApiFile> provider2, Provider<BoxExtendedApiWeblink> provider3, Provider<BoxExtendedApiFolder> provider4, Provider<IBaseModelController> provider5, Provider<BoxApiShare> provider6, Provider<IAppRestrictionsManager> provider7, Provider<IUserContextManager> provider8, Provider<IMoCoBoxGlobalSettings> provider9, Provider<IUserContextMigration> provider10, Provider<BoxApiPrivate> provider11, Provider<FeatureFlips> provider12, Provider<IBoxAccountSettings> provider13, Provider<IntentServices> provider14, Provider<ISplitConfiguration> provider15, Provider<ConfigManager> provider16, Provider<IForceUpdateCoordinator> provider17, Provider<NotificationServices> provider18, Provider<IntuneAuthManager> provider19, Provider<LaunchIntoCaptureUseCase> provider20, Provider<ClientSettingsInitialisation> provider21, Provider<BetaFeedbackManager> provider22, Provider<IMoCoAdminSettings> provider23, Provider<BoxApiUser> provider24, Provider<IBrowseController> provider25, Provider<BoxExtendedApiPreview> provider26, Provider<JobManager> provider27, Provider<IJobService> provider28, Provider<TransfersHelper> provider29, Provider<FabHelper.Factory> provider30, Provider<ILocalItemService> provider31, Provider<BoxAdminSettingsProvider> provider32, Provider<UploadHelper> provider33, Provider<IntentServices> provider34, Provider<FTUXMessageReceiverHelper> provider35, Provider<AppUpdateProposalManager> provider36, Provider<OfflineMigrationService> provider37, Provider<IOfflineStateStorage> provider38, Provider<IOfflineFilesPolicyEnforcer> provider39, Provider<IItemActionHandler.Factory> provider40, Provider<SearchFragment.SearchActionLogHelper> provider41) {
        return new MainParent_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19, provider20, provider21, provider22, provider23, provider24, provider25, provider26, provider27, provider28, provider29, provider30, provider31, provider32, provider33, provider34, provider35, provider36, provider37, provider38, provider39, provider40, provider41);
    }

    public static void injectMAdminSettingsModelController(MainParent mainParent, IMoCoAdminSettings iMoCoAdminSettings) {
        mainParent.mAdminSettingsModelController = iMoCoAdminSettings;
    }

    public static void injectMBoxApiUser(MainParent mainParent, BoxApiUser boxApiUser) {
        mainParent.mBoxApiUser = boxApiUser;
    }

    public static void injectMBrowseController(MainParent mainParent, IBrowseController iBrowseController) {
        mainParent.mBrowseController = iBrowseController;
    }

    public static void injectMApiPreviewPrivate(MainParent mainParent, BoxExtendedApiPreview boxExtendedApiPreview) {
        mainParent.mApiPreviewPrivate = boxExtendedApiPreview;
    }

    public static void injectMJobManager(MainParent mainParent, JobManager jobManager) {
        mainParent.mJobManager = jobManager;
    }

    public static void injectMJobService(MainParent mainParent, IJobService iJobService) {
        mainParent.mJobService = iJobService;
    }

    public static void injectMTransfersHelper(MainParent mainParent, TransfersHelper transfersHelper) {
        mainParent.mTransfersHelper = transfersHelper;
    }

    public static void injectMFabHelperFactory(MainParent mainParent, FabHelper.Factory factory) {
        mainParent.mFabHelperFactory = factory;
    }

    public static void injectLocalItemService(MainParent mainParent, ILocalItemService iLocalItemService) {
        mainParent.localItemService = iLocalItemService;
    }

    public static void injectBoxAdminSettingsProvider(MainParent mainParent, BoxAdminSettingsProvider boxAdminSettingsProvider) {
        mainParent.boxAdminSettingsProvider = boxAdminSettingsProvider;
    }

    public static void injectMUploadHelper(MainParent mainParent, UploadHelper uploadHelper) {
        mainParent.mUploadHelper = uploadHelper;
    }

    public static void injectMIntentServices(MainParent mainParent, IntentServices intentServices) {
        mainParent.mIntentServices = intentServices;
    }

    public static void injectFtuxMessageReceiverHelper(MainParent mainParent, FTUXMessageReceiverHelper fTUXMessageReceiverHelper) {
        mainParent.ftuxMessageReceiverHelper = fTUXMessageReceiverHelper;
    }

    public static void injectAppUpdateProposalManager(MainParent mainParent, AppUpdateProposalManager appUpdateProposalManager) {
        mainParent.appUpdateProposalManager = appUpdateProposalManager;
    }

    public static void injectMOfflineMigrationService(MainParent mainParent, OfflineMigrationService offlineMigrationService) {
        mainParent.mOfflineMigrationService = offlineMigrationService;
    }

    public static void injectMOfflineStateStorage(MainParent mainParent, IOfflineStateStorage iOfflineStateStorage) {
        mainParent.mOfflineStateStorage = iOfflineStateStorage;
    }

    public static void injectMOfflineFilesPolicyEnforcer(MainParent mainParent, IOfflineFilesPolicyEnforcer iOfflineFilesPolicyEnforcer) {
        mainParent.mOfflineFilesPolicyEnforcer = iOfflineFilesPolicyEnforcer;
    }

    public static void injectMItemActionHandlerFactory(MainParent mainParent, IItemActionHandler.Factory factory) {
        mainParent.mItemActionHandlerFactory = factory;
    }

    public static void injectMSearchActionLogHelper(MainParent mainParent, SearchFragment.SearchActionLogHelper searchActionLogHelper) {
        mainParent.mSearchActionLogHelper = searchActionLogHelper;
    }
}
