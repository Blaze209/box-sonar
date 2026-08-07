package com.box.android.capture.activities;

import com.box.android.base.presentation.activities.BoxFragmentActivity_MembersInjector;
import com.box.android.base.presentation.shake.BetaFeedbackManager;
import com.box.android.base.presentation.utilities.IItemActionHandler;
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

/* JADX INFO: loaded from: classes10.dex */
public final class CaptureActivity_MembersInjector implements MembersInjector<CaptureActivity> {
    private final Provider<BetaFeedbackManager> betaFeedbackManagerProvider;
    private final Provider<ClientSettingsInitialisation> clientSettingsInitialisationProvider;
    private final Provider<IForceUpdateCoordinator> forceUpdateCoordinatorProvider;
    private final Provider<IntentServices> intentServicesProvider;
    private final Provider<IItemActionHandler.Factory> itemActionHandlerFactoryProvider;
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

    private CaptureActivity_MembersInjector(Provider<IMoCoBoxTransfers> provider, Provider<BoxExtendedApiFile> provider2, Provider<BoxExtendedApiWeblink> provider3, Provider<BoxExtendedApiFolder> provider4, Provider<IBaseModelController> provider5, Provider<BoxApiShare> provider6, Provider<IAppRestrictionsManager> provider7, Provider<IUserContextManager> provider8, Provider<IMoCoBoxGlobalSettings> provider9, Provider<IUserContextMigration> provider10, Provider<BoxApiPrivate> provider11, Provider<FeatureFlips> provider12, Provider<IBoxAccountSettings> provider13, Provider<IntentServices> provider14, Provider<ISplitConfiguration> provider15, Provider<ConfigManager> provider16, Provider<IForceUpdateCoordinator> provider17, Provider<NotificationServices> provider18, Provider<IntuneAuthManager> provider19, Provider<LaunchIntoCaptureUseCase> provider20, Provider<ClientSettingsInitialisation> provider21, Provider<BetaFeedbackManager> provider22, Provider<IItemActionHandler.Factory> provider23, Provider<IntentServices> provider24) {
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
        this.itemActionHandlerFactoryProvider = provider23;
        this.intentServicesProvider = provider24;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(CaptureActivity captureActivity) {
        BoxFragmentActivity_MembersInjector.injectMTransfersModelController(captureActivity, this.mTransfersModelControllerProvider.get());
        BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(captureActivity, this.mBoxExtendedApiFileProvider.get());
        BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(captureActivity, this.mBoxApiBookmarkProvider.get());
        BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(captureActivity, this.mBoxExtendedApiFolderProvider.get());
        BoxFragmentActivity_MembersInjector.injectMBaseMoco(captureActivity, this.mBaseMocoProvider.get());
        BoxFragmentActivity_MembersInjector.injectMBoxApiShare(captureActivity, this.mBoxApiShareProvider.get());
        BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(captureActivity, this.mRestrictionsManagerProvider.get());
        BoxFragmentActivity_MembersInjector.injectMUserContextManager(captureActivity, this.mUserContextManagerProvider.get());
        BoxFragmentActivity_MembersInjector.injectMGlobalSettings(captureActivity, this.mGlobalSettingsProvider.get());
        BoxFragmentActivity_MembersInjector.injectMMigration(captureActivity, this.mMigrationProvider.get());
        BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(captureActivity, this.mBoxApiPrivateProvider.get());
        BoxFragmentActivity_MembersInjector.injectMFeatureFlips(captureActivity, this.mFeatureFlipsProvider.get());
        BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(captureActivity, this.mBoxAccountSettingsProvider.get());
        BoxFragmentActivity_MembersInjector.injectMIntentServices(captureActivity, this.mIntentServicesProvider.get());
        BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(captureActivity, this.mSplitConfigurationProvider.get());
        BoxFragmentActivity_MembersInjector.injectMConfigManager(captureActivity, this.mConfigManagerProvider.get());
        BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(captureActivity, this.forceUpdateCoordinatorProvider.get());
        BoxFragmentActivity_MembersInjector.injectMNotificationServices(captureActivity, this.mNotificationServicesProvider.get());
        BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(captureActivity, this.mIntuneAuthManagerProvider.get());
        BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(captureActivity, this.mLaunchIntoCaptureProvider.get());
        BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(captureActivity, this.clientSettingsInitialisationProvider.get());
        BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(captureActivity, this.betaFeedbackManagerProvider.get());
        injectItemActionHandlerFactory(captureActivity, this.itemActionHandlerFactoryProvider.get());
        injectIntentServices(captureActivity, this.intentServicesProvider.get());
    }

    public static MembersInjector<CaptureActivity> create(Provider<IMoCoBoxTransfers> provider, Provider<BoxExtendedApiFile> provider2, Provider<BoxExtendedApiWeblink> provider3, Provider<BoxExtendedApiFolder> provider4, Provider<IBaseModelController> provider5, Provider<BoxApiShare> provider6, Provider<IAppRestrictionsManager> provider7, Provider<IUserContextManager> provider8, Provider<IMoCoBoxGlobalSettings> provider9, Provider<IUserContextMigration> provider10, Provider<BoxApiPrivate> provider11, Provider<FeatureFlips> provider12, Provider<IBoxAccountSettings> provider13, Provider<IntentServices> provider14, Provider<ISplitConfiguration> provider15, Provider<ConfigManager> provider16, Provider<IForceUpdateCoordinator> provider17, Provider<NotificationServices> provider18, Provider<IntuneAuthManager> provider19, Provider<LaunchIntoCaptureUseCase> provider20, Provider<ClientSettingsInitialisation> provider21, Provider<BetaFeedbackManager> provider22, Provider<IItemActionHandler.Factory> provider23, Provider<IntentServices> provider24) {
        return new CaptureActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19, provider20, provider21, provider22, provider23, provider24);
    }

    public static void injectItemActionHandlerFactory(CaptureActivity captureActivity, IItemActionHandler.Factory factory) {
        captureActivity.itemActionHandlerFactory = factory;
    }

    public static void injectIntentServices(CaptureActivity captureActivity, IntentServices intentServices) {
        captureActivity.intentServices = intentServices;
    }
}
