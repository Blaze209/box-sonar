package com.box.android.preview.preview;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.box.android.base.cpl.IPreviewLauncher;
import com.box.android.base.presentation.activities.BoxFragmentActivity;
import com.box.android.base.presentation.utilities.EdgeToEdgeUtils;
import com.box.android.base.presentation.utilities.FTUXController;
import com.box.android.browse.utilities.CopyOrMoveHelper;
import com.box.android.common.utilities.ViewModelAssistedFactory;
import com.box.android.coreservices.models.CustomBoxSession;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.coreservices.services.NotificationServices;
import com.box.android.cpl.StoreKt;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.configuration.ConfigManager;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.preview.PreviewSource;
import com.box.android.domain.services.IdMappingService;
import com.box.android.fileactivity.presentation.FileActivitiesLauncher;
import com.box.android.preview.item.ItemState;
import com.box.android.preview.previewtype.audio.AudioPlayerService;
import com.box.android.preview.previewtype.audio.AudioPreviewReducer;
import com.box.android.preview.previewtype.audio.Media3AudioPlayerManager;
import com.box.android.preview.previewtype.document.DocumentPreviewEnvironment;
import com.box.android.preview.previewtype.video.VideoMediaSourceFactory;
import com.box.android.preview.previewtype.video.VideoPlayersProvider;
import com.box.android.preview.routing.PreviewRouter;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.swmansion.rnscreens.fragment.restoration.RNScreensFragmentFactory;
import dagger.hilt.android.AndroidEntryPoint;
import dagger.hilt.android.lifecycle.HiltViewModelExtensions;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: PreviewActivity.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u0000 f2\u00020\u00012\u00020\u0002:\u0001fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010T\u001a\u00020UH\u0016J\u0012\u0010\\\u001a\u00020]2\b\u0010^\u001a\u0004\u0018\u00010_H\u0014J\b\u0010`\u001a\u00020]H\u0016J\u000f\u0010a\u001a\u0004\u0018\u00010bH\u0014¢\u0006\u0002\u0010cJ\b\u0010d\u001a\u00020]H\u0016J\b\u0010e\u001a\u00020]H\u0016R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u00020\u001e8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010#\u001a\u00020$8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001e\u0010)\u001a\u00020*8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001e\u0010/\u001a\u0002008\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001e\u00105\u001a\u0002068\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R$\u0010;\u001a\u00020<8\u0006@\u0006X\u0087.¢\u0006\u0014\n\u0000\u0012\u0004\b=\u0010\u0004\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001e\u0010B\u001a\u00020C8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001e\u0010H\u001a\u00020I8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001e\u0010N\u001a\u00020O8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u001b\u0010V\u001a\u00020W8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bZ\u0010[\u001a\u0004\bX\u0010Y¨\u0006g"}, d2 = {"Lcom/box/android/preview/preview/PreviewActivity;", "Lcom/box/android/base/presentation/activities/BoxFragmentActivity;", "Lcom/facebook/react/modules/core/DefaultHardwareBackBtnHandler;", "<init>", "()V", "intentServices", "Lcom/box/android/coreservices/services/IntentServices;", "getIntentServices", "()Lcom/box/android/coreservices/services/IntentServices;", "setIntentServices", "(Lcom/box/android/coreservices/services/IntentServices;)V", "idMappingService", "Lcom/box/android/domain/services/IdMappingService;", "getIdMappingService", "()Lcom/box/android/domain/services/IdMappingService;", "setIdMappingService", "(Lcom/box/android/domain/services/IdMappingService;)V", "copyOrMoveHelper", "Lcom/box/android/browse/utilities/CopyOrMoveHelper;", "getCopyOrMoveHelper", "()Lcom/box/android/browse/utilities/CopyOrMoveHelper;", "setCopyOrMoveHelper", "(Lcom/box/android/browse/utilities/CopyOrMoveHelper;)V", "previewActivityIntentHandler", "Lcom/box/android/preview/preview/PreviewActivityIntentHandler;", "getPreviewActivityIntentHandler", "()Lcom/box/android/preview/preview/PreviewActivityIntentHandler;", "setPreviewActivityIntentHandler", "(Lcom/box/android/preview/preview/PreviewActivityIntentHandler;)V", "fileActivitiesLauncher", "Lcom/box/android/fileactivity/presentation/FileActivitiesLauncher;", "getFileActivitiesLauncher", "()Lcom/box/android/fileactivity/presentation/FileActivitiesLauncher;", "setFileActivitiesLauncher", "(Lcom/box/android/fileactivity/presentation/FileActivitiesLauncher;)V", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "getUserContextManager", "()Lcom/box/android/domain/identity/IUserContextManager;", "setUserContextManager", "(Lcom/box/android/domain/identity/IUserContextManager;)V", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "getFeatureFlips", "()Lcom/box/android/domain/configuration/FeatureFlips;", "setFeatureFlips", "(Lcom/box/android/domain/configuration/FeatureFlips;)V", "notificationServices", "Lcom/box/android/coreservices/services/NotificationServices;", "getNotificationServices", "()Lcom/box/android/coreservices/services/NotificationServices;", "setNotificationServices", "(Lcom/box/android/coreservices/services/NotificationServices;)V", "audioPlayerManager", "Lcom/box/android/preview/previewtype/audio/Media3AudioPlayerManager;", "getAudioPlayerManager", "()Lcom/box/android/preview/previewtype/audio/Media3AudioPlayerManager;", "setAudioPlayerManager", "(Lcom/box/android/preview/previewtype/audio/Media3AudioPlayerManager;)V", "uiDependencyProvider", "Lcom/box/android/preview/preview/PreviewUIDependencyProvider;", "getUiDependencyProvider$annotations", "getUiDependencyProvider", "()Lcom/box/android/preview/preview/PreviewUIDependencyProvider;", "setUiDependencyProvider", "(Lcom/box/android/preview/preview/PreviewUIDependencyProvider;)V", "ftuxController", "Lcom/box/android/base/presentation/utilities/FTUXController;", "getFtuxController", "()Lcom/box/android/base/presentation/utilities/FTUXController;", "setFtuxController", "(Lcom/box/android/base/presentation/utilities/FTUXController;)V", "videoPlayersProvider", "Lcom/box/android/preview/previewtype/video/VideoPlayersProvider;", "getVideoPlayersProvider", "()Lcom/box/android/preview/previewtype/video/VideoPlayersProvider;", "setVideoPlayersProvider", "(Lcom/box/android/preview/previewtype/video/VideoPlayersProvider;)V", "videoMediaSourceFactory", "Lcom/box/android/preview/previewtype/video/VideoMediaSourceFactory;", "getVideoMediaSourceFactory", "()Lcom/box/android/preview/previewtype/video/VideoMediaSourceFactory;", "setVideoMediaSourceFactory", "(Lcom/box/android/preview/previewtype/video/VideoMediaSourceFactory;)V", "amplitudeSetCurrentPage", "", "viewModel", "Lcom/box/android/preview/preview/PreviewViewModel;", "getViewModel", "()Lcom/box/android/preview/preview/PreviewViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onBoxResume", "getActivityLayoutId", "", "()Ljava/lang/Integer;", "invokeDefaultOnBackPressed", "onDestroy", "Companion", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class PreviewActivity extends Hilt_PreviewActivity implements DefaultHardwareBackBtnHandler {
    public static final String INITIAL_FILE_MODEL_KEY = "INITIAL_FILE_MODEL_KEY";
    public static final String IS_NEWLY_CREATED_FILE = "IS_NEWLY_CREATED_FILE";
    public static final String IS_OPENING_CREATED_OFFICE_FILE = "IS_OPENING_CREATED_OFFICE_FILE";
    public static final String NAVIGATION_TARGET = "NAVIGATION_TARGET";
    private static final String OBSERVABILITY_ID = "OBSERVABILITY_ID";
    public static final String PREVIEW_SOURCE = "PREVIEW_SOURCE";

    @Inject
    public Media3AudioPlayerManager audioPlayerManager;

    @Inject
    public CopyOrMoveHelper copyOrMoveHelper;

    @Inject
    public FeatureFlips featureFlips;

    @Inject
    public FileActivitiesLauncher fileActivitiesLauncher;

    @Inject
    public FTUXController ftuxController;

    @Inject
    public IdMappingService idMappingService;

    @Inject
    public IntentServices intentServices;

    @Inject
    public NotificationServices notificationServices;

    @Inject
    public PreviewActivityIntentHandler previewActivityIntentHandler;
    public PreviewUIDependencyProvider uiDependencyProvider;

    @Inject
    public IUserContextManager userContextManager;

    @Inject
    public VideoMediaSourceFactory videoMediaSourceFactory;

    @Inject
    public VideoPlayersProvider videoPlayersProvider;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public static /* synthetic */ void getUiDependencyProvider$annotations() {
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected Integer getActivityLayoutId() {
        return null;
    }

    public PreviewActivity() {
        final PreviewActivity previewActivity = this;
        final Function0<CreationExtras> function0 = new Function0<CreationExtras>() { // from class: com.box.android.preview.preview.PreviewActivity$special$$inlined$viewModelsWithArgs$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras defaultViewModelCreationExtras = previewActivity.getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "<get-defaultViewModelCreationExtras>(...)");
                final PreviewActivity previewActivity2 = this;
                return HiltViewModelExtensions.withCreationCallback(defaultViewModelCreationExtras, new Function1<ViewModelAssistedFactory<PreviewViewModel>, ViewModel>() { // from class: com.box.android.preview.preview.PreviewActivity$special$$inlined$viewModelsWithArgs$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final ViewModel invoke(ViewModelAssistedFactory<PreviewViewModel> factory) {
                        FileModel fileModel;
                        PreviewSource previewSource;
                        Intrinsics.checkNotNullParameter(factory, "factory");
                        Bundle bundle = new Bundle();
                        Intent intent = previewActivity2.getIntent();
                        Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
                        if (Build.VERSION.SDK_INT >= 33) {
                            fileModel = (Parcelable) intent.getParcelableExtra(PreviewActivity.INITIAL_FILE_MODEL_KEY, FileModel.class);
                        } else {
                            Parcelable parcelableExtra = intent.getParcelableExtra(PreviewActivity.INITIAL_FILE_MODEL_KEY);
                            if (!(parcelableExtra instanceof FileModel)) {
                                parcelableExtra = null;
                            }
                            fileModel = (FileModel) parcelableExtra;
                        }
                        bundle.putParcelable("VM_INITIAL_FILE_MODEL_KEY", fileModel);
                        Intent intent2 = previewActivity2.getIntent();
                        Intrinsics.checkNotNullExpressionValue(intent2, "getIntent(...)");
                        if (Build.VERSION.SDK_INT >= 33) {
                            previewSource = (Parcelable) intent2.getParcelableExtra("PREVIEW_SOURCE", PreviewSource.class);
                        } else {
                            Parcelable parcelableExtra2 = intent2.getParcelableExtra("PREVIEW_SOURCE");
                            previewSource = (PreviewSource) (parcelableExtra2 instanceof PreviewSource ? parcelableExtra2 : null);
                        }
                        bundle.putParcelable("PREVIEW_SOURCE", previewSource);
                        bundle.putString(PreviewViewModel.VM_OBSERVABILITY_ID, previewActivity2.getIntent().getStringExtra("OBSERVABILITY_ID"));
                        bundle.putString(PreviewViewModel.VM_SHARED_LINK_KEY, previewActivity2.getIntent().getStringExtra(BoxFragmentActivity.EXTRA_SHAREDLINK_URL));
                        bundle.putBoolean(PreviewViewModel.VM_IS_NEWLY_CREATED_FILE, previewActivity2.getIntent().getBooleanExtra(PreviewActivity.IS_NEWLY_CREATED_FILE, false));
                        return factory.create(bundle);
                    }
                });
            }
        };
        this.viewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(PreviewViewModel.class), new Function0<ViewModelStore>() { // from class: com.box.android.preview.preview.PreviewActivity$special$$inlined$viewModelsWithArgs$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return previewActivity.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.box.android.preview.preview.PreviewActivity$special$$inlined$viewModelsWithArgs$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return previewActivity.getDefaultViewModelProviderFactory();
            }
        }, new Function0<CreationExtras>() { // from class: com.box.android.preview.preview.PreviewActivity$special$$inlined$viewModelsWithArgs$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? previewActivity.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
    }

    public final IntentServices getIntentServices() {
        IntentServices intentServices = this.intentServices;
        if (intentServices != null) {
            return intentServices;
        }
        Intrinsics.throwUninitializedPropertyAccessException("intentServices");
        return null;
    }

    public final void setIntentServices(IntentServices intentServices) {
        Intrinsics.checkNotNullParameter(intentServices, "<set-?>");
        this.intentServices = intentServices;
    }

    public final IdMappingService getIdMappingService() {
        IdMappingService idMappingService = this.idMappingService;
        if (idMappingService != null) {
            return idMappingService;
        }
        Intrinsics.throwUninitializedPropertyAccessException("idMappingService");
        return null;
    }

    public final void setIdMappingService(IdMappingService idMappingService) {
        Intrinsics.checkNotNullParameter(idMappingService, "<set-?>");
        this.idMappingService = idMappingService;
    }

    public final CopyOrMoveHelper getCopyOrMoveHelper() {
        CopyOrMoveHelper copyOrMoveHelper = this.copyOrMoveHelper;
        if (copyOrMoveHelper != null) {
            return copyOrMoveHelper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("copyOrMoveHelper");
        return null;
    }

    public final void setCopyOrMoveHelper(CopyOrMoveHelper copyOrMoveHelper) {
        Intrinsics.checkNotNullParameter(copyOrMoveHelper, "<set-?>");
        this.copyOrMoveHelper = copyOrMoveHelper;
    }

    public final PreviewActivityIntentHandler getPreviewActivityIntentHandler() {
        PreviewActivityIntentHandler previewActivityIntentHandler = this.previewActivityIntentHandler;
        if (previewActivityIntentHandler != null) {
            return previewActivityIntentHandler;
        }
        Intrinsics.throwUninitializedPropertyAccessException("previewActivityIntentHandler");
        return null;
    }

    public final void setPreviewActivityIntentHandler(PreviewActivityIntentHandler previewActivityIntentHandler) {
        Intrinsics.checkNotNullParameter(previewActivityIntentHandler, "<set-?>");
        this.previewActivityIntentHandler = previewActivityIntentHandler;
    }

    public final FileActivitiesLauncher getFileActivitiesLauncher() {
        FileActivitiesLauncher fileActivitiesLauncher = this.fileActivitiesLauncher;
        if (fileActivitiesLauncher != null) {
            return fileActivitiesLauncher;
        }
        Intrinsics.throwUninitializedPropertyAccessException("fileActivitiesLauncher");
        return null;
    }

    public final void setFileActivitiesLauncher(FileActivitiesLauncher fileActivitiesLauncher) {
        Intrinsics.checkNotNullParameter(fileActivitiesLauncher, "<set-?>");
        this.fileActivitiesLauncher = fileActivitiesLauncher;
    }

    public final IUserContextManager getUserContextManager() {
        IUserContextManager iUserContextManager = this.userContextManager;
        if (iUserContextManager != null) {
            return iUserContextManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("userContextManager");
        return null;
    }

    public final void setUserContextManager(IUserContextManager iUserContextManager) {
        Intrinsics.checkNotNullParameter(iUserContextManager, "<set-?>");
        this.userContextManager = iUserContextManager;
    }

    public final FeatureFlips getFeatureFlips() {
        FeatureFlips featureFlips = this.featureFlips;
        if (featureFlips != null) {
            return featureFlips;
        }
        Intrinsics.throwUninitializedPropertyAccessException("featureFlips");
        return null;
    }

    public final void setFeatureFlips(FeatureFlips featureFlips) {
        Intrinsics.checkNotNullParameter(featureFlips, "<set-?>");
        this.featureFlips = featureFlips;
    }

    public final NotificationServices getNotificationServices() {
        NotificationServices notificationServices = this.notificationServices;
        if (notificationServices != null) {
            return notificationServices;
        }
        Intrinsics.throwUninitializedPropertyAccessException("notificationServices");
        return null;
    }

    public final void setNotificationServices(NotificationServices notificationServices) {
        Intrinsics.checkNotNullParameter(notificationServices, "<set-?>");
        this.notificationServices = notificationServices;
    }

    public final Media3AudioPlayerManager getAudioPlayerManager() {
        Media3AudioPlayerManager media3AudioPlayerManager = this.audioPlayerManager;
        if (media3AudioPlayerManager != null) {
            return media3AudioPlayerManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("audioPlayerManager");
        return null;
    }

    public final void setAudioPlayerManager(Media3AudioPlayerManager media3AudioPlayerManager) {
        Intrinsics.checkNotNullParameter(media3AudioPlayerManager, "<set-?>");
        this.audioPlayerManager = media3AudioPlayerManager;
    }

    public final PreviewUIDependencyProvider getUiDependencyProvider() {
        PreviewUIDependencyProvider previewUIDependencyProvider = this.uiDependencyProvider;
        if (previewUIDependencyProvider != null) {
            return previewUIDependencyProvider;
        }
        Intrinsics.throwUninitializedPropertyAccessException("uiDependencyProvider");
        return null;
    }

    public final void setUiDependencyProvider(PreviewUIDependencyProvider previewUIDependencyProvider) {
        Intrinsics.checkNotNullParameter(previewUIDependencyProvider, "<set-?>");
        this.uiDependencyProvider = previewUIDependencyProvider;
    }

    public final FTUXController getFtuxController() {
        FTUXController fTUXController = this.ftuxController;
        if (fTUXController != null) {
            return fTUXController;
        }
        Intrinsics.throwUninitializedPropertyAccessException("ftuxController");
        return null;
    }

    public final void setFtuxController(FTUXController fTUXController) {
        Intrinsics.checkNotNullParameter(fTUXController, "<set-?>");
        this.ftuxController = fTUXController;
    }

    public final VideoPlayersProvider getVideoPlayersProvider() {
        VideoPlayersProvider videoPlayersProvider = this.videoPlayersProvider;
        if (videoPlayersProvider != null) {
            return videoPlayersProvider;
        }
        Intrinsics.throwUninitializedPropertyAccessException("videoPlayersProvider");
        return null;
    }

    public final void setVideoPlayersProvider(VideoPlayersProvider videoPlayersProvider) {
        Intrinsics.checkNotNullParameter(videoPlayersProvider, "<set-?>");
        this.videoPlayersProvider = videoPlayersProvider;
    }

    public final VideoMediaSourceFactory getVideoMediaSourceFactory() {
        VideoMediaSourceFactory videoMediaSourceFactory = this.videoMediaSourceFactory;
        if (videoMediaSourceFactory != null) {
            return videoMediaSourceFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("videoMediaSourceFactory");
        return null;
    }

    public final void setVideoMediaSourceFactory(VideoMediaSourceFactory videoMediaSourceFactory) {
        Intrinsics.checkNotNullParameter(videoMediaSourceFactory, "<set-?>");
        this.videoMediaSourceFactory = videoMediaSourceFactory;
    }

    @Override // com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity
    public boolean amplitudeSetCurrentPage() {
        return BoxAmplitudeAnalytics.getInstance().setCurrentPage(BoxAnalyticsParams.PAGE_NAME_PREVIEW_PM23);
    }

    private final PreviewViewModel getViewModel() {
        return (PreviewViewModel) this.viewModel.getValue();
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        EdgeToEdgeUtils.INSTANCE.enableTransparentEdgeToEdge(this);
        getSupportFragmentManager().setFragmentFactory(new RNScreensFragmentFactory());
        super.onMAMCreate(bundle);
        PreviewActivity previewActivity = this;
        PreviewRouter previewRouter = new PreviewRouter(getIntentServices(), getNotificationServices(), getIdMappingService(), getCopyOrMoveHelper(), getUserContextManager(), getFileActivitiesLauncher(), getViewModel().getStore(), previewActivity, getFeatureFlips());
        getLifecycleRegistry().addObserver(previewRouter);
        CustomBoxSession mBoxSession = this.mBoxSession;
        Intrinsics.checkNotNullExpressionValue(mBoxSession, "mBoxSession");
        Media3AudioPlayerManager audioPlayerManager = getAudioPlayerManager();
        DocumentPreviewEnvironment documentPreviewEnvironment = getViewModel().getPreviewEnvironment().getItemPreviewEnvironment().getDocumentPreviewEnvironment();
        VideoPlayersProvider videoPlayersProvider = getVideoPlayersProvider();
        VideoMediaSourceFactory videoMediaSourceFactory = getVideoMediaSourceFactory();
        FeatureFlips featureFlips = getFeatureFlips();
        ConfigManager mConfigManager = this.mConfigManager;
        Intrinsics.checkNotNullExpressionValue(mConfigManager, "mConfigManager");
        setUiDependencyProvider(new PreviewUIDependencyProvider(this, mBoxSession, audioPlayerManager, documentPreviewEnvironment, videoPlayersProvider, videoMediaSourceFactory, featureFlips, mConfigManager));
        new PreviewActivityContent(previewActivity, getViewModel().getStore(), getIntentServices(), previewRouter, getPreviewActivityIntentHandler(), getUiDependencyProvider(), this.mBoxAccountSettings.isAxCenterEnabled() && getFeatureFlips().getBoxAiCenterForPreviewAndMultidoc().getEnabled());
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    public void onBoxResume() {
        super.onBoxResume();
        getViewModel().getStore().send(PreviewReducer.Action.Refresh.INSTANCE);
    }

    @Override // com.facebook.react.modules.core.DefaultHardwareBackBtnHandler
    public void invokeDefaultOnBackPressed() {
        getOnBackPressedDispatcher().onBackPressed();
    }

    /* JADX INFO: compiled from: PreviewActivity.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/box/android/preview/preview/PreviewActivity$Companion;", "", "<init>", "()V", PreviewActivity.INITIAL_FILE_MODEL_KEY, "", "PREVIEW_SOURCE", PreviewActivity.NAVIGATION_TARGET, PreviewActivity.OBSERVABILITY_ID, PreviewActivity.IS_OPENING_CREATED_OFFICE_FILE, PreviewActivity.IS_NEWLY_CREATED_FILE, "getIntent", "Landroid/content/Intent;", "data", "Lcom/box/android/base/cpl/IPreviewLauncher$NavigationData;", "observabilityId", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ Intent getIntent$default(Companion companion, IPreviewLauncher.NavigationData navigationData, String str, int i, Object obj) {
            if ((i & 2) != 0) {
                str = null;
            }
            return companion.getIntent(navigationData, str);
        }

        public final Intent getIntent(IPreviewLauncher.NavigationData data, String observabilityId) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intent intent = new Intent(data.getContext(), (Class<?>) PreviewActivity.class);
            intent.putExtra(PreviewActivity.INITIAL_FILE_MODEL_KEY, data.getFileModel());
            intent.putExtra("PREVIEW_SOURCE", data.getPreviewSource());
            intent.putExtra(BoxFragmentActivity.EXTRA_SHAREDLINK_URL, data.getSharedLink());
            intent.putExtra(PreviewActivity.NAVIGATION_TARGET, data.getPreviewNavigationTarget());
            intent.putExtra(PreviewActivity.OBSERVABILITY_ID, observabilityId);
            intent.putExtra(PreviewActivity.IS_OPENING_CREATED_OFFICE_FILE, data.isOpeningCreatedOfficeFile());
            intent.putExtra(PreviewActivity.IS_NEWLY_CREATED_FILE, data.isNewlyCreatedFile());
            return intent;
        }
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMDestroy() {
        AudioPreviewReducer.State state;
        super.onMAMDestroy();
        ItemState itemState = ((PreviewReducer.State) StoreKt.stateValue(getViewModel().getStore())).getPreviewItem().getItemState();
        ItemState.Audio audio = itemState instanceof ItemState.Audio ? (ItemState.Audio) itemState : null;
        if (audio != null && (state = audio.getState()) != null && state.isPaused()) {
            stopService(new Intent(this, (Class<?>) AudioPlayerService.class));
        }
        getFtuxController().evaluateTrigger(FTUXController.FTUXTrigger.PREVIEW_CLOSED);
    }
}
