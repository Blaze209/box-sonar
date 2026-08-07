package com.box.android.preview.previousversion;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.activity.EdgeToEdge;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.box.android.common.utilities.ViewModelAssistedFactory;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.models.item.FileModel;
import com.box.android.fileactivity.presentation.FileActivitiesLauncher;
import com.box.android.preview.previewtype.audio.Media3AudioPlayerManager;
import com.box.android.preview.previewtype.video.VideoMediaSourceFactory;
import com.box.android.preview.previewtype.video.VideoPlayersProvider;
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

/* JADX INFO: compiled from: PreviousVersionPreviewActivity.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 ;2\u00020\u0001:\u0001;B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u000107H\u0014J\u000f\u00108\u001a\u0004\u0018\u000109H\u0014¢\u0006\u0002\u0010:R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u00020\u001d8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\"\u001a\u00020#8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020)X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001b\u0010.\u001a\u00020/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b0\u00101¨\u0006<"}, d2 = {"Lcom/box/android/preview/previousversion/PreviousVersionPreviewActivity;", "Lcom/box/android/base/presentation/activities/BoxFragmentActivity;", "<init>", "()V", "fileActivitiesLauncher", "Lcom/box/android/fileactivity/presentation/FileActivitiesLauncher;", "getFileActivitiesLauncher", "()Lcom/box/android/fileactivity/presentation/FileActivitiesLauncher;", "setFileActivitiesLauncher", "(Lcom/box/android/fileactivity/presentation/FileActivitiesLauncher;)V", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "getUserContextManager", "()Lcom/box/android/domain/identity/IUserContextManager;", "setUserContextManager", "(Lcom/box/android/domain/identity/IUserContextManager;)V", "audioPlayerManager", "Lcom/box/android/preview/previewtype/audio/Media3AudioPlayerManager;", "getAudioPlayerManager", "()Lcom/box/android/preview/previewtype/audio/Media3AudioPlayerManager;", "setAudioPlayerManager", "(Lcom/box/android/preview/previewtype/audio/Media3AudioPlayerManager;)V", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "getFeatureFlips", "()Lcom/box/android/domain/configuration/FeatureFlips;", "setFeatureFlips", "(Lcom/box/android/domain/configuration/FeatureFlips;)V", "videoPlayersProvider", "Lcom/box/android/preview/previewtype/video/VideoPlayersProvider;", "getVideoPlayersProvider", "()Lcom/box/android/preview/previewtype/video/VideoPlayersProvider;", "setVideoPlayersProvider", "(Lcom/box/android/preview/previewtype/video/VideoPlayersProvider;)V", "videoMediaSourceFactory", "Lcom/box/android/preview/previewtype/video/VideoMediaSourceFactory;", "getVideoMediaSourceFactory", "()Lcom/box/android/preview/previewtype/video/VideoMediaSourceFactory;", "setVideoMediaSourceFactory", "(Lcom/box/android/preview/previewtype/video/VideoMediaSourceFactory;)V", "uiDependencyProvider", "Lcom/box/android/preview/previousversion/PreviousVersionUIDependencyProvider;", "getUiDependencyProvider", "()Lcom/box/android/preview/previousversion/PreviousVersionUIDependencyProvider;", "setUiDependencyProvider", "(Lcom/box/android/preview/previousversion/PreviousVersionUIDependencyProvider;)V", "viewModel", "Lcom/box/android/preview/previousversion/PreviousVersionViewModel;", "getViewModel", "()Lcom/box/android/preview/previousversion/PreviousVersionViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getActivityLayoutId", "", "()Ljava/lang/Integer;", "Companion", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class PreviousVersionPreviewActivity extends Hilt_PreviousVersionPreviewActivity {
    public static final String ANNOTATION_ID_KEY = "ANNOTATION_ID_KEY";
    public static final String FILE_MODEL_KEY = "FILE_MODEL_KEY";
    public static final String FILE_VERSION_ID_KEY = "FILE_VERSION_ID_KEY";
    public static final String OBSERVABILITY_ID_KEY = "OBSERVABILITY_ID_KEY";

    @Inject
    public Media3AudioPlayerManager audioPlayerManager;

    @Inject
    public FeatureFlips featureFlips;

    @Inject
    public FileActivitiesLauncher fileActivitiesLauncher;
    public PreviousVersionUIDependencyProvider uiDependencyProvider;

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

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected Integer getActivityLayoutId() {
        return null;
    }

    public PreviousVersionPreviewActivity() {
        final PreviousVersionPreviewActivity previousVersionPreviewActivity = this;
        final Function0<CreationExtras> function0 = new Function0<CreationExtras>() { // from class: com.box.android.preview.previousversion.PreviousVersionPreviewActivity$special$$inlined$viewModelsWithArgs$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras defaultViewModelCreationExtras = previousVersionPreviewActivity.getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "<get-defaultViewModelCreationExtras>(...)");
                final PreviousVersionPreviewActivity previousVersionPreviewActivity2 = this;
                return HiltViewModelExtensions.withCreationCallback(defaultViewModelCreationExtras, new Function1<ViewModelAssistedFactory<PreviousVersionViewModel>, ViewModel>() { // from class: com.box.android.preview.previousversion.PreviousVersionPreviewActivity$special$$inlined$viewModelsWithArgs$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final ViewModel invoke(ViewModelAssistedFactory<PreviousVersionViewModel> factory) {
                        FileModel fileModel;
                        Intrinsics.checkNotNullParameter(factory, "factory");
                        Bundle bundle = new Bundle();
                        Intent intent = previousVersionPreviewActivity2.getIntent();
                        Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
                        if (Build.VERSION.SDK_INT >= 33) {
                            fileModel = (Parcelable) intent.getParcelableExtra("FILE_MODEL_KEY", FileModel.class);
                        } else {
                            Parcelable parcelableExtra = intent.getParcelableExtra("FILE_MODEL_KEY");
                            if (!(parcelableExtra instanceof FileModel)) {
                                parcelableExtra = null;
                            }
                            fileModel = (FileModel) parcelableExtra;
                        }
                        bundle.putParcelable("VM_INITIAL_FILE_MODEL_KEY", fileModel);
                        bundle.putString(PreviousVersionViewModel.VM_PREVIOUS_VERSION_ID_KEY, previousVersionPreviewActivity2.getIntent().getStringExtra(PreviousVersionPreviewActivity.FILE_VERSION_ID_KEY));
                        bundle.putString(PreviousVersionViewModel.VM_ANNOTATION_ID_KEY, previousVersionPreviewActivity2.getIntent().getStringExtra(PreviousVersionPreviewActivity.ANNOTATION_ID_KEY));
                        bundle.putString(PreviousVersionViewModel.VM_OBSERVABILITY_ID_KEY, previousVersionPreviewActivity2.getIntent().getStringExtra(PreviousVersionPreviewActivity.OBSERVABILITY_ID_KEY));
                        return factory.create(bundle);
                    }
                });
            }
        };
        this.viewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(PreviousVersionViewModel.class), new Function0<ViewModelStore>() { // from class: com.box.android.preview.previousversion.PreviousVersionPreviewActivity$special$$inlined$viewModelsWithArgs$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return previousVersionPreviewActivity.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.box.android.preview.previousversion.PreviousVersionPreviewActivity$special$$inlined$viewModelsWithArgs$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return previousVersionPreviewActivity.getDefaultViewModelProviderFactory();
            }
        }, new Function0<CreationExtras>() { // from class: com.box.android.preview.previousversion.PreviousVersionPreviewActivity$special$$inlined$viewModelsWithArgs$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? previousVersionPreviewActivity.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
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

    public final PreviousVersionUIDependencyProvider getUiDependencyProvider() {
        PreviousVersionUIDependencyProvider previousVersionUIDependencyProvider = this.uiDependencyProvider;
        if (previousVersionUIDependencyProvider != null) {
            return previousVersionUIDependencyProvider;
        }
        Intrinsics.throwUninitializedPropertyAccessException("uiDependencyProvider");
        return null;
    }

    public final void setUiDependencyProvider(PreviousVersionUIDependencyProvider previousVersionUIDependencyProvider) {
        Intrinsics.checkNotNullParameter(previousVersionUIDependencyProvider, "<set-?>");
        this.uiDependencyProvider = previousVersionUIDependencyProvider;
    }

    private final PreviousVersionViewModel getViewModel() {
        return (PreviousVersionViewModel) this.viewModel.getValue();
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        EdgeToEdge.enable$default(this, null, null, 3, null);
        super.onMAMCreate(bundle);
        setUiDependencyProvider(new PreviousVersionUIDependencyProvider(this, getViewModel().getEnvironment().getDocumentPreviewEnvironment(), getVideoPlayersProvider(), getVideoMediaSourceFactory()));
        PreviousVersionPreviewActivity previousVersionPreviewActivity = this;
        new PreviousVersionPreviewActivityContent(previousVersionPreviewActivity, getViewModel().getStore(), new PreviousVersionRouter(getViewModel().getStore(), previousVersionPreviewActivity, getFileActivitiesLauncher()), getUiDependencyProvider());
    }

    /* JADX INFO: compiled from: PreviousVersionPreviewActivity.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/previousversion/PreviousVersionPreviewActivity$Companion;", "", "<init>", "()V", "FILE_MODEL_KEY", "", PreviousVersionPreviewActivity.FILE_VERSION_ID_KEY, PreviousVersionPreviewActivity.ANNOTATION_ID_KEY, PreviousVersionPreviewActivity.OBSERVABILITY_ID_KEY, "getIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "fileVersionId", "annotationId", "observabilityId", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Intent getIntent(Context context, FileModel fileModel, String fileVersionId, String annotationId, String observabilityId) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(fileModel, "fileModel");
            Intrinsics.checkNotNullParameter(fileVersionId, "fileVersionId");
            Intrinsics.checkNotNullParameter(annotationId, "annotationId");
            Intrinsics.checkNotNullParameter(observabilityId, "observabilityId");
            Intent intent = new Intent(context, (Class<?>) PreviousVersionPreviewActivity.class);
            intent.putExtra("FILE_MODEL_KEY", fileModel);
            intent.putExtra(PreviousVersionPreviewActivity.FILE_VERSION_ID_KEY, fileVersionId);
            intent.putExtra(PreviousVersionPreviewActivity.ANNOTATION_ID_KEY, annotationId);
            intent.putExtra(PreviousVersionPreviewActivity.OBSERVABILITY_ID_KEY, observabilityId);
            return intent;
        }
    }
}
