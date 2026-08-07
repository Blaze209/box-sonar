package com.box.android.base.presentation.activities;

import com.box.android.base.presentation.shake.BetaFeedbackManager;
import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings;
import com.box.android.coreservices.modelcontroller.IMoCoBoxTransfers;
import com.box.android.coreservices.services.IUserContextMigration;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.coreservices.services.NotificationServices;
import com.box.android.coreservices.utilities.intune.IntuneAuthManager;
import com.box.android.domain.configuration.ConfigManager;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.configuration.IBoxAccountSettings;
import com.box.android.domain.configuration.ISplitConfiguration;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.initialisation.ClientSettingsInitialisation;
import com.box.android.domain.services.IAppRestrictionsManager;
import com.box.android.domain.services.IForceUpdateCoordinator;
import com.box.android.domain.usecases.capture.LaunchIntoCaptureUseCase;
import com.box.androidsdk.content.BoxApiShare;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiWeblink;
import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class BoxFragmentActivity_MembersInjector implements MembersInjector<BoxFragmentActivity> {
    private final Provider<BetaFeedbackManager> betaFeedbackManagerProvider;
    private final Provider<ClientSettingsInitialisation> clientSettingsInitialisationProvider;
    private final Provider<IForceUpdateCoordinator> forceUpdateCoordinatorProvider;
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

    private BoxFragmentActivity_MembersInjector(Provider<IMoCoBoxTransfers> provider, Provider<BoxExtendedApiFile> provider2, Provider<BoxExtendedApiWeblink> provider3, Provider<BoxExtendedApiFolder> provider4, Provider<IBaseModelController> provider5, Provider<BoxApiShare> provider6, Provider<IAppRestrictionsManager> provider7, Provider<IUserContextManager> provider8, Provider<IMoCoBoxGlobalSettings> provider9, Provider<IUserContextMigration> provider10, Provider<BoxApiPrivate> provider11, Provider<FeatureFlips> provider12, Provider<IBoxAccountSettings> provider13, Provider<IntentServices> provider14, Provider<ISplitConfiguration> provider15, Provider<ConfigManager> provider16, Provider<IForceUpdateCoordinator> provider17, Provider<NotificationServices> provider18, Provider<IntuneAuthManager> provider19, Provider<LaunchIntoCaptureUseCase> provider20, Provider<ClientSettingsInitialisation> provider21, Provider<BetaFeedbackManager> provider22) {
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
    }

    @Override // dagger.MembersInjector
    public void injectMembers(BoxFragmentActivity boxFragmentActivity) {
        injectMTransfersModelController(boxFragmentActivity, this.mTransfersModelControllerProvider.get());
        injectMBoxExtendedApiFile(boxFragmentActivity, this.mBoxExtendedApiFileProvider.get());
        injectMBoxApiBookmark(boxFragmentActivity, this.mBoxApiBookmarkProvider.get());
        injectMBoxExtendedApiFolder(boxFragmentActivity, this.mBoxExtendedApiFolderProvider.get());
        injectMBaseMoco(boxFragmentActivity, this.mBaseMocoProvider.get());
        injectMBoxApiShare(boxFragmentActivity, this.mBoxApiShareProvider.get());
        injectMRestrictionsManager(boxFragmentActivity, this.mRestrictionsManagerProvider.get());
        injectMUserContextManager(boxFragmentActivity, this.mUserContextManagerProvider.get());
        injectMGlobalSettings(boxFragmentActivity, this.mGlobalSettingsProvider.get());
        injectMMigration(boxFragmentActivity, this.mMigrationProvider.get());
        injectMBoxApiPrivate(boxFragmentActivity, this.mBoxApiPrivateProvider.get());
        injectMFeatureFlips(boxFragmentActivity, this.mFeatureFlipsProvider.get());
        injectMBoxAccountSettings(boxFragmentActivity, this.mBoxAccountSettingsProvider.get());
        injectMIntentServices(boxFragmentActivity, this.mIntentServicesProvider.get());
        injectMSplitConfiguration(boxFragmentActivity, this.mSplitConfigurationProvider.get());
        injectMConfigManager(boxFragmentActivity, this.mConfigManagerProvider.get());
        injectForceUpdateCoordinator(boxFragmentActivity, this.forceUpdateCoordinatorProvider.get());
        injectMNotificationServices(boxFragmentActivity, this.mNotificationServicesProvider.get());
        injectMIntuneAuthManager(boxFragmentActivity, this.mIntuneAuthManagerProvider.get());
        injectMLaunchIntoCapture(boxFragmentActivity, this.mLaunchIntoCaptureProvider.get());
        injectClientSettingsInitialisation(boxFragmentActivity, this.clientSettingsInitialisationProvider.get());
        injectBetaFeedbackManager(boxFragmentActivity, this.betaFeedbackManagerProvider.get());
    }

    public static MembersInjector<BoxFragmentActivity> create(Provider<IMoCoBoxTransfers> provider, Provider<BoxExtendedApiFile> provider2, Provider<BoxExtendedApiWeblink> provider3, Provider<BoxExtendedApiFolder> provider4, Provider<IBaseModelController> provider5, Provider<BoxApiShare> provider6, Provider<IAppRestrictionsManager> provider7, Provider<IUserContextManager> provider8, Provider<IMoCoBoxGlobalSettings> provider9, Provider<IUserContextMigration> provider10, Provider<BoxApiPrivate> provider11, Provider<FeatureFlips> provider12, Provider<IBoxAccountSettings> provider13, Provider<IntentServices> provider14, Provider<ISplitConfiguration> provider15, Provider<ConfigManager> provider16, Provider<IForceUpdateCoordinator> provider17, Provider<NotificationServices> provider18, Provider<IntuneAuthManager> provider19, Provider<LaunchIntoCaptureUseCase> provider20, Provider<ClientSettingsInitialisation> provider21, Provider<BetaFeedbackManager> provider22) {
        return new BoxFragmentActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19, provider20, provider21, provider22);
    }

    public static void injectMTransfersModelController(BoxFragmentActivity boxFragmentActivity, IMoCoBoxTransfers iMoCoBoxTransfers) {
        boxFragmentActivity.mTransfersModelController = iMoCoBoxTransfers;
    }

    public static void injectMBoxExtendedApiFile(BoxFragmentActivity boxFragmentActivity, BoxExtendedApiFile boxExtendedApiFile) {
        boxFragmentActivity.mBoxExtendedApiFile = boxExtendedApiFile;
    }

    public static void injectMBoxApiBookmark(BoxFragmentActivity boxFragmentActivity, BoxExtendedApiWeblink boxExtendedApiWeblink) {
        boxFragmentActivity.mBoxApiBookmark = boxExtendedApiWeblink;
    }

    public static void injectMBoxExtendedApiFolder(BoxFragmentActivity boxFragmentActivity, BoxExtendedApiFolder boxExtendedApiFolder) {
        boxFragmentActivity.mBoxExtendedApiFolder = boxExtendedApiFolder;
    }

    public static void injectMBaseMoco(BoxFragmentActivity boxFragmentActivity, IBaseModelController iBaseModelController) {
        boxFragmentActivity.mBaseMoco = iBaseModelController;
    }

    public static void injectMBoxApiShare(BoxFragmentActivity boxFragmentActivity, BoxApiShare boxApiShare) {
        boxFragmentActivity.mBoxApiShare = boxApiShare;
    }

    public static void injectMRestrictionsManager(BoxFragmentActivity boxFragmentActivity, IAppRestrictionsManager iAppRestrictionsManager) {
        boxFragmentActivity.mRestrictionsManager = iAppRestrictionsManager;
    }

    public static void injectMUserContextManager(BoxFragmentActivity boxFragmentActivity, IUserContextManager iUserContextManager) {
        boxFragmentActivity.mUserContextManager = iUserContextManager;
    }

    public static void injectMGlobalSettings(BoxFragmentActivity boxFragmentActivity, IMoCoBoxGlobalSettings iMoCoBoxGlobalSettings) {
        boxFragmentActivity.mGlobalSettings = iMoCoBoxGlobalSettings;
    }

    public static void injectMMigration(BoxFragmentActivity boxFragmentActivity, IUserContextMigration iUserContextMigration) {
        boxFragmentActivity.mMigration = iUserContextMigration;
    }

    public static void injectMBoxApiPrivate(BoxFragmentActivity boxFragmentActivity, BoxApiPrivate boxApiPrivate) {
        boxFragmentActivity.mBoxApiPrivate = boxApiPrivate;
    }

    public static void injectMFeatureFlips(BoxFragmentActivity boxFragmentActivity, FeatureFlips featureFlips) {
        boxFragmentActivity.mFeatureFlips = featureFlips;
    }

    public static void injectMBoxAccountSettings(BoxFragmentActivity boxFragmentActivity, IBoxAccountSettings iBoxAccountSettings) {
        boxFragmentActivity.mBoxAccountSettings = iBoxAccountSettings;
    }

    public static void injectMIntentServices(BoxFragmentActivity boxFragmentActivity, IntentServices intentServices) {
        boxFragmentActivity.mIntentServices = intentServices;
    }

    public static void injectMSplitConfiguration(BoxFragmentActivity boxFragmentActivity, ISplitConfiguration iSplitConfiguration) {
        boxFragmentActivity.mSplitConfiguration = iSplitConfiguration;
    }

    public static void injectMConfigManager(BoxFragmentActivity boxFragmentActivity, ConfigManager configManager) {
        boxFragmentActivity.mConfigManager = configManager;
    }

    public static void injectForceUpdateCoordinator(BoxFragmentActivity boxFragmentActivity, IForceUpdateCoordinator iForceUpdateCoordinator) {
        boxFragmentActivity.forceUpdateCoordinator = iForceUpdateCoordinator;
    }

    public static void injectMNotificationServices(BoxFragmentActivity boxFragmentActivity, NotificationServices notificationServices) {
        boxFragmentActivity.mNotificationServices = notificationServices;
    }

    public static void injectMIntuneAuthManager(BoxFragmentActivity boxFragmentActivity, IntuneAuthManager intuneAuthManager) {
        boxFragmentActivity.mIntuneAuthManager = intuneAuthManager;
    }

    public static void injectMLaunchIntoCapture(BoxFragmentActivity boxFragmentActivity, LaunchIntoCaptureUseCase launchIntoCaptureUseCase) {
        boxFragmentActivity.mLaunchIntoCapture = launchIntoCaptureUseCase;
    }

    public static void injectClientSettingsInitialisation(BoxFragmentActivity boxFragmentActivity, ClientSettingsInitialisation clientSettingsInitialisation) {
        boxFragmentActivity.clientSettingsInitialisation = clientSettingsInitialisation;
    }

    public static void injectBetaFeedbackManager(BoxFragmentActivity boxFragmentActivity, BetaFeedbackManager betaFeedbackManager) {
        boxFragmentActivity.betaFeedbackManager = betaFeedbackManager;
    }
}
