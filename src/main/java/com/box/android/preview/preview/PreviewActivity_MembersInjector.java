package com.box.android.preview.preview;

import com.box.android.base.presentation.activities.BoxFragmentActivity_MembersInjector;
import com.box.android.base.presentation.shake.BetaFeedbackManager;
import com.box.android.base.presentation.utilities.FTUXController;
import com.box.android.browse.utilities.CopyOrMoveHelper;
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
import com.box.android.domain.services.IdMappingService;
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
public final class PreviewActivity_MembersInjector implements MembersInjector<PreviewActivity> {
    private final Provider<Media3AudioPlayerManager> audioPlayerManagerProvider;
    private final Provider<BetaFeedbackManager> betaFeedbackManagerProvider;
    private final Provider<ClientSettingsInitialisation> clientSettingsInitialisationProvider;
    private final Provider<CopyOrMoveHelper> copyOrMoveHelperProvider;
    private final Provider<FeatureFlips> featureFlipsProvider;
    private final Provider<FileActivitiesLauncher> fileActivitiesLauncherProvider;
    private final Provider<IForceUpdateCoordinator> forceUpdateCoordinatorProvider;
    private final Provider<FTUXController> ftuxControllerProvider;
    private final Provider<IdMappingService> idMappingServiceProvider;
    private final Provider<IntentServices> intentServicesProvider;
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
    private final Provider<NotificationServices> notificationServicesProvider;
    private final Provider<PreviewActivityIntentHandler> previewActivityIntentHandlerProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;
    private final Provider<VideoMediaSourceFactory> videoMediaSourceFactoryProvider;
    private final Provider<VideoPlayersProvider> videoPlayersProvider;

    private PreviewActivity_MembersInjector(Provider<IMoCoBoxTransfers> provider, Provider<BoxExtendedApiFile> provider2, Provider<BoxExtendedApiWeblink> provider3, Provider<BoxExtendedApiFolder> provider4, Provider<IBaseModelController> provider5, Provider<BoxApiShare> provider6, Provider<IAppRestrictionsManager> provider7, Provider<IUserContextManager> provider8, Provider<IMoCoBoxGlobalSettings> provider9, Provider<IUserContextMigration> provider10, Provider<BoxApiPrivate> provider11, Provider<FeatureFlips> provider12, Provider<IBoxAccountSettings> provider13, Provider<IntentServices> provider14, Provider<ISplitConfiguration> provider15, Provider<ConfigManager> provider16, Provider<IForceUpdateCoordinator> provider17, Provider<NotificationServices> provider18, Provider<IntuneAuthManager> provider19, Provider<LaunchIntoCaptureUseCase> provider20, Provider<ClientSettingsInitialisation> provider21, Provider<BetaFeedbackManager> provider22, Provider<IntentServices> provider23, Provider<IdMappingService> provider24, Provider<CopyOrMoveHelper> provider25, Provider<PreviewActivityIntentHandler> provider26, Provider<FileActivitiesLauncher> provider27, Provider<IUserContextManager> provider28, Provider<FeatureFlips> provider29, Provider<NotificationServices> provider30, Provider<Media3AudioPlayerManager> provider31, Provider<FTUXController> provider32, Provider<VideoPlayersProvider> provider33, Provider<VideoMediaSourceFactory> provider34) {
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
        this.intentServicesProvider = provider23;
        this.idMappingServiceProvider = provider24;
        this.copyOrMoveHelperProvider = provider25;
        this.previewActivityIntentHandlerProvider = provider26;
        this.fileActivitiesLauncherProvider = provider27;
        this.userContextManagerProvider = provider28;
        this.featureFlipsProvider = provider29;
        this.notificationServicesProvider = provider30;
        this.audioPlayerManagerProvider = provider31;
        this.ftuxControllerProvider = provider32;
        this.videoPlayersProvider = provider33;
        this.videoMediaSourceFactoryProvider = provider34;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(PreviewActivity previewActivity) {
        BoxFragmentActivity_MembersInjector.injectMTransfersModelController(previewActivity, this.mTransfersModelControllerProvider.get());
        BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(previewActivity, this.mBoxExtendedApiFileProvider.get());
        BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(previewActivity, this.mBoxApiBookmarkProvider.get());
        BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(previewActivity, this.mBoxExtendedApiFolderProvider.get());
        BoxFragmentActivity_MembersInjector.injectMBaseMoco(previewActivity, this.mBaseMocoProvider.get());
        BoxFragmentActivity_MembersInjector.injectMBoxApiShare(previewActivity, this.mBoxApiShareProvider.get());
        BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(previewActivity, this.mRestrictionsManagerProvider.get());
        BoxFragmentActivity_MembersInjector.injectMUserContextManager(previewActivity, this.mUserContextManagerProvider.get());
        BoxFragmentActivity_MembersInjector.injectMGlobalSettings(previewActivity, this.mGlobalSettingsProvider.get());
        BoxFragmentActivity_MembersInjector.injectMMigration(previewActivity, this.mMigrationProvider.get());
        BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(previewActivity, this.mBoxApiPrivateProvider.get());
        BoxFragmentActivity_MembersInjector.injectMFeatureFlips(previewActivity, this.mFeatureFlipsProvider.get());
        BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(previewActivity, this.mBoxAccountSettingsProvider.get());
        BoxFragmentActivity_MembersInjector.injectMIntentServices(previewActivity, this.mIntentServicesProvider.get());
        BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(previewActivity, this.mSplitConfigurationProvider.get());
        BoxFragmentActivity_MembersInjector.injectMConfigManager(previewActivity, this.mConfigManagerProvider.get());
        BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(previewActivity, this.forceUpdateCoordinatorProvider.get());
        BoxFragmentActivity_MembersInjector.injectMNotificationServices(previewActivity, this.mNotificationServicesProvider.get());
        BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(previewActivity, this.mIntuneAuthManagerProvider.get());
        BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(previewActivity, this.mLaunchIntoCaptureProvider.get());
        BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(previewActivity, this.clientSettingsInitialisationProvider.get());
        BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(previewActivity, this.betaFeedbackManagerProvider.get());
        injectIntentServices(previewActivity, this.intentServicesProvider.get());
        injectIdMappingService(previewActivity, this.idMappingServiceProvider.get());
        injectCopyOrMoveHelper(previewActivity, this.copyOrMoveHelperProvider.get());
        injectPreviewActivityIntentHandler(previewActivity, this.previewActivityIntentHandlerProvider.get());
        injectFileActivitiesLauncher(previewActivity, this.fileActivitiesLauncherProvider.get());
        injectUserContextManager(previewActivity, this.userContextManagerProvider.get());
        injectFeatureFlips(previewActivity, this.featureFlipsProvider.get());
        injectNotificationServices(previewActivity, this.notificationServicesProvider.get());
        injectAudioPlayerManager(previewActivity, this.audioPlayerManagerProvider.get());
        injectFtuxController(previewActivity, this.ftuxControllerProvider.get());
        injectVideoPlayersProvider(previewActivity, this.videoPlayersProvider.get());
        injectVideoMediaSourceFactory(previewActivity, this.videoMediaSourceFactoryProvider.get());
    }

    public static MembersInjector<PreviewActivity> create(Provider<IMoCoBoxTransfers> provider, Provider<BoxExtendedApiFile> provider2, Provider<BoxExtendedApiWeblink> provider3, Provider<BoxExtendedApiFolder> provider4, Provider<IBaseModelController> provider5, Provider<BoxApiShare> provider6, Provider<IAppRestrictionsManager> provider7, Provider<IUserContextManager> provider8, Provider<IMoCoBoxGlobalSettings> provider9, Provider<IUserContextMigration> provider10, Provider<BoxApiPrivate> provider11, Provider<FeatureFlips> provider12, Provider<IBoxAccountSettings> provider13, Provider<IntentServices> provider14, Provider<ISplitConfiguration> provider15, Provider<ConfigManager> provider16, Provider<IForceUpdateCoordinator> provider17, Provider<NotificationServices> provider18, Provider<IntuneAuthManager> provider19, Provider<LaunchIntoCaptureUseCase> provider20, Provider<ClientSettingsInitialisation> provider21, Provider<BetaFeedbackManager> provider22, Provider<IntentServices> provider23, Provider<IdMappingService> provider24, Provider<CopyOrMoveHelper> provider25, Provider<PreviewActivityIntentHandler> provider26, Provider<FileActivitiesLauncher> provider27, Provider<IUserContextManager> provider28, Provider<FeatureFlips> provider29, Provider<NotificationServices> provider30, Provider<Media3AudioPlayerManager> provider31, Provider<FTUXController> provider32, Provider<VideoPlayersProvider> provider33, Provider<VideoMediaSourceFactory> provider34) {
        return new PreviewActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19, provider20, provider21, provider22, provider23, provider24, provider25, provider26, provider27, provider28, provider29, provider30, provider31, provider32, provider33, provider34);
    }

    public static void injectIntentServices(PreviewActivity previewActivity, IntentServices intentServices) {
        previewActivity.intentServices = intentServices;
    }

    public static void injectIdMappingService(PreviewActivity previewActivity, IdMappingService idMappingService) {
        previewActivity.idMappingService = idMappingService;
    }

    public static void injectCopyOrMoveHelper(PreviewActivity previewActivity, CopyOrMoveHelper copyOrMoveHelper) {
        previewActivity.copyOrMoveHelper = copyOrMoveHelper;
    }

    public static void injectPreviewActivityIntentHandler(PreviewActivity previewActivity, PreviewActivityIntentHandler previewActivityIntentHandler) {
        previewActivity.previewActivityIntentHandler = previewActivityIntentHandler;
    }

    public static void injectFileActivitiesLauncher(PreviewActivity previewActivity, FileActivitiesLauncher fileActivitiesLauncher) {
        previewActivity.fileActivitiesLauncher = fileActivitiesLauncher;
    }

    public static void injectUserContextManager(PreviewActivity previewActivity, IUserContextManager iUserContextManager) {
        previewActivity.userContextManager = iUserContextManager;
    }

    public static void injectFeatureFlips(PreviewActivity previewActivity, FeatureFlips featureFlips) {
        previewActivity.featureFlips = featureFlips;
    }

    public static void injectNotificationServices(PreviewActivity previewActivity, NotificationServices notificationServices) {
        previewActivity.notificationServices = notificationServices;
    }

    public static void injectAudioPlayerManager(PreviewActivity previewActivity, Media3AudioPlayerManager media3AudioPlayerManager) {
        previewActivity.audioPlayerManager = media3AudioPlayerManager;
    }

    public static void injectFtuxController(PreviewActivity previewActivity, FTUXController fTUXController) {
        previewActivity.ftuxController = fTUXController;
    }

    public static void injectVideoPlayersProvider(PreviewActivity previewActivity, VideoPlayersProvider videoPlayersProvider) {
        previewActivity.videoPlayersProvider = videoPlayersProvider;
    }

    public static void injectVideoMediaSourceFactory(PreviewActivity previewActivity, VideoMediaSourceFactory videoMediaSourceFactory) {
        previewActivity.videoMediaSourceFactory = videoMediaSourceFactory;
    }
}
