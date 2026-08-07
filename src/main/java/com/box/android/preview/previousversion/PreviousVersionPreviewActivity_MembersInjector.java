package com.box.android.preview.previousversion;

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
import com.box.android.fileactivity.presentation.FileActivitiesLauncher;
import com.box.android.preview.previewtype.audio.Media3AudioPlayerManager;
import com.box.android.preview.previewtype.video.VideoMediaSourceFactory;
import com.box.android.preview.previewtype.video.VideoPlayersProvider;
import com.box.androidsdk.content.BoxApiShare;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiWeblink;
import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class PreviousVersionPreviewActivity_MembersInjector implements MembersInjector<PreviousVersionPreviewActivity> {
    private final Provider<Media3AudioPlayerManager> audioPlayerManagerProvider;
    private final Provider<BetaFeedbackManager> betaFeedbackManagerProvider;
    private final Provider<ClientSettingsInitialisation> clientSettingsInitialisationProvider;
    private final Provider<FeatureFlips> featureFlipsProvider;
    private final Provider<FileActivitiesLauncher> fileActivitiesLauncherProvider;
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
    private final Provider<IUserContextManager> userContextManagerProvider;
    private final Provider<VideoMediaSourceFactory> videoMediaSourceFactoryProvider;
    private final Provider<VideoPlayersProvider> videoPlayersProvider;

    private PreviousVersionPreviewActivity_MembersInjector(Provider<IMoCoBoxTransfers> provider, Provider<BoxExtendedApiFile> provider2, Provider<BoxExtendedApiWeblink> provider3, Provider<BoxExtendedApiFolder> provider4, Provider<IBaseModelController> provider5, Provider<BoxApiShare> provider6, Provider<IAppRestrictionsManager> provider7, Provider<IUserContextManager> provider8, Provider<IMoCoBoxGlobalSettings> provider9, Provider<IUserContextMigration> provider10, Provider<BoxApiPrivate> provider11, Provider<FeatureFlips> provider12, Provider<IBoxAccountSettings> provider13, Provider<IntentServices> provider14, Provider<ISplitConfiguration> provider15, Provider<ConfigManager> provider16, Provider<IForceUpdateCoordinator> provider17, Provider<NotificationServices> provider18, Provider<IntuneAuthManager> provider19, Provider<LaunchIntoCaptureUseCase> provider20, Provider<ClientSettingsInitialisation> provider21, Provider<BetaFeedbackManager> provider22, Provider<FileActivitiesLauncher> provider23, Provider<IUserContextManager> provider24, Provider<Media3AudioPlayerManager> provider25, Provider<FeatureFlips> provider26, Provider<VideoPlayersProvider> provider27, Provider<VideoMediaSourceFactory> provider28) {
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
        this.fileActivitiesLauncherProvider = provider23;
        this.userContextManagerProvider = provider24;
        this.audioPlayerManagerProvider = provider25;
        this.featureFlipsProvider = provider26;
        this.videoPlayersProvider = provider27;
        this.videoMediaSourceFactoryProvider = provider28;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(PreviousVersionPreviewActivity previousVersionPreviewActivity) {
        BoxFragmentActivity_MembersInjector.injectMTransfersModelController(previousVersionPreviewActivity, this.mTransfersModelControllerProvider.get());
        BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(previousVersionPreviewActivity, this.mBoxExtendedApiFileProvider.get());
        BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(previousVersionPreviewActivity, this.mBoxApiBookmarkProvider.get());
        BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(previousVersionPreviewActivity, this.mBoxExtendedApiFolderProvider.get());
        BoxFragmentActivity_MembersInjector.injectMBaseMoco(previousVersionPreviewActivity, this.mBaseMocoProvider.get());
        BoxFragmentActivity_MembersInjector.injectMBoxApiShare(previousVersionPreviewActivity, this.mBoxApiShareProvider.get());
        BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(previousVersionPreviewActivity, this.mRestrictionsManagerProvider.get());
        BoxFragmentActivity_MembersInjector.injectMUserContextManager(previousVersionPreviewActivity, this.mUserContextManagerProvider.get());
        BoxFragmentActivity_MembersInjector.injectMGlobalSettings(previousVersionPreviewActivity, this.mGlobalSettingsProvider.get());
        BoxFragmentActivity_MembersInjector.injectMMigration(previousVersionPreviewActivity, this.mMigrationProvider.get());
        BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(previousVersionPreviewActivity, this.mBoxApiPrivateProvider.get());
        BoxFragmentActivity_MembersInjector.injectMFeatureFlips(previousVersionPreviewActivity, this.mFeatureFlipsProvider.get());
        BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(previousVersionPreviewActivity, this.mBoxAccountSettingsProvider.get());
        BoxFragmentActivity_MembersInjector.injectMIntentServices(previousVersionPreviewActivity, this.mIntentServicesProvider.get());
        BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(previousVersionPreviewActivity, this.mSplitConfigurationProvider.get());
        BoxFragmentActivity_MembersInjector.injectMConfigManager(previousVersionPreviewActivity, this.mConfigManagerProvider.get());
        BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(previousVersionPreviewActivity, this.forceUpdateCoordinatorProvider.get());
        BoxFragmentActivity_MembersInjector.injectMNotificationServices(previousVersionPreviewActivity, this.mNotificationServicesProvider.get());
        BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(previousVersionPreviewActivity, this.mIntuneAuthManagerProvider.get());
        BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(previousVersionPreviewActivity, this.mLaunchIntoCaptureProvider.get());
        BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(previousVersionPreviewActivity, this.clientSettingsInitialisationProvider.get());
        BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(previousVersionPreviewActivity, this.betaFeedbackManagerProvider.get());
        injectFileActivitiesLauncher(previousVersionPreviewActivity, this.fileActivitiesLauncherProvider.get());
        injectUserContextManager(previousVersionPreviewActivity, this.userContextManagerProvider.get());
        injectAudioPlayerManager(previousVersionPreviewActivity, this.audioPlayerManagerProvider.get());
        injectFeatureFlips(previousVersionPreviewActivity, this.featureFlipsProvider.get());
        injectVideoPlayersProvider(previousVersionPreviewActivity, this.videoPlayersProvider.get());
        injectVideoMediaSourceFactory(previousVersionPreviewActivity, this.videoMediaSourceFactoryProvider.get());
    }

    public static MembersInjector<PreviousVersionPreviewActivity> create(Provider<IMoCoBoxTransfers> provider, Provider<BoxExtendedApiFile> provider2, Provider<BoxExtendedApiWeblink> provider3, Provider<BoxExtendedApiFolder> provider4, Provider<IBaseModelController> provider5, Provider<BoxApiShare> provider6, Provider<IAppRestrictionsManager> provider7, Provider<IUserContextManager> provider8, Provider<IMoCoBoxGlobalSettings> provider9, Provider<IUserContextMigration> provider10, Provider<BoxApiPrivate> provider11, Provider<FeatureFlips> provider12, Provider<IBoxAccountSettings> provider13, Provider<IntentServices> provider14, Provider<ISplitConfiguration> provider15, Provider<ConfigManager> provider16, Provider<IForceUpdateCoordinator> provider17, Provider<NotificationServices> provider18, Provider<IntuneAuthManager> provider19, Provider<LaunchIntoCaptureUseCase> provider20, Provider<ClientSettingsInitialisation> provider21, Provider<BetaFeedbackManager> provider22, Provider<FileActivitiesLauncher> provider23, Provider<IUserContextManager> provider24, Provider<Media3AudioPlayerManager> provider25, Provider<FeatureFlips> provider26, Provider<VideoPlayersProvider> provider27, Provider<VideoMediaSourceFactory> provider28) {
        return new PreviousVersionPreviewActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19, provider20, provider21, provider22, provider23, provider24, provider25, provider26, provider27, provider28);
    }

    public static void injectFileActivitiesLauncher(PreviousVersionPreviewActivity previousVersionPreviewActivity, FileActivitiesLauncher fileActivitiesLauncher) {
        previousVersionPreviewActivity.fileActivitiesLauncher = fileActivitiesLauncher;
    }

    public static void injectUserContextManager(PreviousVersionPreviewActivity previousVersionPreviewActivity, IUserContextManager iUserContextManager) {
        previousVersionPreviewActivity.userContextManager = iUserContextManager;
    }

    public static void injectAudioPlayerManager(PreviousVersionPreviewActivity previousVersionPreviewActivity, Media3AudioPlayerManager media3AudioPlayerManager) {
        previousVersionPreviewActivity.audioPlayerManager = media3AudioPlayerManager;
    }

    public static void injectFeatureFlips(PreviousVersionPreviewActivity previousVersionPreviewActivity, FeatureFlips featureFlips) {
        previousVersionPreviewActivity.featureFlips = featureFlips;
    }

    public static void injectVideoPlayersProvider(PreviousVersionPreviewActivity previousVersionPreviewActivity, VideoPlayersProvider videoPlayersProvider) {
        previousVersionPreviewActivity.videoPlayersProvider = videoPlayersProvider;
    }

    public static void injectVideoMediaSourceFactory(PreviousVersionPreviewActivity previousVersionPreviewActivity, VideoMediaSourceFactory videoMediaSourceFactory) {
        previousVersionPreviewActivity.videoMediaSourceFactory = videoMediaSourceFactory;
    }
}
