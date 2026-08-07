package com.box.android.activities.login;

import com.box.android.base.presentation.activities.BoxFragmentActivity_MembersInjector;
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
import com.box.android.observability.ObservabilitySettingsManager;
import com.box.androidsdk.content.BoxApiShare;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiWeblink;
import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class StartScreenActivity_MembersInjector implements MembersInjector<StartScreenActivity> {
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
    private final Provider<ObservabilitySettingsManager> mObservabilityManagerProvider;
    private final Provider<IAppRestrictionsManager> mRestrictionsManagerProvider;
    private final Provider<ISplitConfiguration> mSplitConfigurationProvider;
    private final Provider<IMoCoBoxTransfers> mTransfersModelControllerProvider;
    private final Provider<IUserContextManager> mUserContextManagerProvider;

    private StartScreenActivity_MembersInjector(Provider<IMoCoBoxTransfers> provider, Provider<BoxExtendedApiFile> provider2, Provider<BoxExtendedApiWeblink> provider3, Provider<BoxExtendedApiFolder> provider4, Provider<IBaseModelController> provider5, Provider<BoxApiShare> provider6, Provider<IAppRestrictionsManager> provider7, Provider<IUserContextManager> provider8, Provider<IMoCoBoxGlobalSettings> provider9, Provider<IUserContextMigration> provider10, Provider<BoxApiPrivate> provider11, Provider<FeatureFlips> provider12, Provider<IBoxAccountSettings> provider13, Provider<IntentServices> provider14, Provider<ISplitConfiguration> provider15, Provider<ConfigManager> provider16, Provider<IForceUpdateCoordinator> provider17, Provider<NotificationServices> provider18, Provider<IntuneAuthManager> provider19, Provider<LaunchIntoCaptureUseCase> provider20, Provider<ClientSettingsInitialisation> provider21, Provider<BetaFeedbackManager> provider22, Provider<ObservabilitySettingsManager> provider23) {
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
        this.mObservabilityManagerProvider = provider23;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(StartScreenActivity startScreenActivity) {
        BoxFragmentActivity_MembersInjector.injectMTransfersModelController(startScreenActivity, this.mTransfersModelControllerProvider.get());
        BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(startScreenActivity, this.mBoxExtendedApiFileProvider.get());
        BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(startScreenActivity, this.mBoxApiBookmarkProvider.get());
        BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(startScreenActivity, this.mBoxExtendedApiFolderProvider.get());
        BoxFragmentActivity_MembersInjector.injectMBaseMoco(startScreenActivity, this.mBaseMocoProvider.get());
        BoxFragmentActivity_MembersInjector.injectMBoxApiShare(startScreenActivity, this.mBoxApiShareProvider.get());
        BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(startScreenActivity, this.mRestrictionsManagerProvider.get());
        BoxFragmentActivity_MembersInjector.injectMUserContextManager(startScreenActivity, this.mUserContextManagerProvider.get());
        BoxFragmentActivity_MembersInjector.injectMGlobalSettings(startScreenActivity, this.mGlobalSettingsProvider.get());
        BoxFragmentActivity_MembersInjector.injectMMigration(startScreenActivity, this.mMigrationProvider.get());
        BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(startScreenActivity, this.mBoxApiPrivateProvider.get());
        BoxFragmentActivity_MembersInjector.injectMFeatureFlips(startScreenActivity, this.mFeatureFlipsProvider.get());
        BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(startScreenActivity, this.mBoxAccountSettingsProvider.get());
        BoxFragmentActivity_MembersInjector.injectMIntentServices(startScreenActivity, this.mIntentServicesProvider.get());
        BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(startScreenActivity, this.mSplitConfigurationProvider.get());
        BoxFragmentActivity_MembersInjector.injectMConfigManager(startScreenActivity, this.mConfigManagerProvider.get());
        BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(startScreenActivity, this.forceUpdateCoordinatorProvider.get());
        BoxFragmentActivity_MembersInjector.injectMNotificationServices(startScreenActivity, this.mNotificationServicesProvider.get());
        BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(startScreenActivity, this.mIntuneAuthManagerProvider.get());
        BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(startScreenActivity, this.mLaunchIntoCaptureProvider.get());
        BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(startScreenActivity, this.clientSettingsInitialisationProvider.get());
        BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(startScreenActivity, this.betaFeedbackManagerProvider.get());
        injectMObservabilityManager(startScreenActivity, this.mObservabilityManagerProvider.get());
    }

    public static MembersInjector<StartScreenActivity> create(Provider<IMoCoBoxTransfers> provider, Provider<BoxExtendedApiFile> provider2, Provider<BoxExtendedApiWeblink> provider3, Provider<BoxExtendedApiFolder> provider4, Provider<IBaseModelController> provider5, Provider<BoxApiShare> provider6, Provider<IAppRestrictionsManager> provider7, Provider<IUserContextManager> provider8, Provider<IMoCoBoxGlobalSettings> provider9, Provider<IUserContextMigration> provider10, Provider<BoxApiPrivate> provider11, Provider<FeatureFlips> provider12, Provider<IBoxAccountSettings> provider13, Provider<IntentServices> provider14, Provider<ISplitConfiguration> provider15, Provider<ConfigManager> provider16, Provider<IForceUpdateCoordinator> provider17, Provider<NotificationServices> provider18, Provider<IntuneAuthManager> provider19, Provider<LaunchIntoCaptureUseCase> provider20, Provider<ClientSettingsInitialisation> provider21, Provider<BetaFeedbackManager> provider22, Provider<ObservabilitySettingsManager> provider23) {
        return new StartScreenActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19, provider20, provider21, provider22, provider23);
    }

    public static void injectMObservabilityManager(StartScreenActivity startScreenActivity, ObservabilitySettingsManager observabilitySettingsManager) {
        startScreenActivity.mObservabilityManager = observabilitySettingsManager;
    }
}
