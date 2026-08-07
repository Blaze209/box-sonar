package com.box.android.preview.previewtype.audio.playlist;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.box.android.common.utilities.ViewModelAssistedFactory;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.preview.PreviewSource;
import com.box.android.preview.preview.PreviewActivity;
import com.box.android.preview.previewtype.audio.Media3AudioPlayerManager;
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

/* JADX INFO: compiled from: PreviewPlaylistActivity.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014¢\u0006\u0002\u0010\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/box/android/preview/previewtype/audio/playlist/PreviewPlaylistActivity;", "Lcom/box/android/base/presentation/activities/BoxFragmentActivity;", "<init>", "()V", "audioPlayerManager", "Lcom/box/android/preview/previewtype/audio/Media3AudioPlayerManager;", "getAudioPlayerManager", "()Lcom/box/android/preview/previewtype/audio/Media3AudioPlayerManager;", "setAudioPlayerManager", "(Lcom/box/android/preview/previewtype/audio/Media3AudioPlayerManager;)V", "viewModel", "Lcom/box/android/preview/previewtype/audio/playlist/PreviewPlaylistViewModel;", "getViewModel", "()Lcom/box/android/preview/previewtype/audio/playlist/PreviewPlaylistViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getActivityLayoutId", "", "()Ljava/lang/Integer;", "Companion", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class PreviewPlaylistActivity extends Hilt_PreviewPlaylistActivity {
    private static final String INITIAL_FILE_MODEL_KEY = "INITIAL_FILE_MODEL_KEY";
    private static final String PLAYLIST_PREVIEW_SOURCE = "PLAYLIST_PREVIEW_SOURCE";
    public static final String RESULT_SELECTED_PLAYLIST_ITEM_MODEL = "SELECTED_PLAYLIST_ITEM_MODEL";

    @Inject
    public Media3AudioPlayerManager audioPlayerManager;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected Integer getActivityLayoutId() {
        return null;
    }

    public PreviewPlaylistActivity() {
        final PreviewPlaylistActivity previewPlaylistActivity = this;
        final Function0<CreationExtras> function0 = new Function0<CreationExtras>() { // from class: com.box.android.preview.previewtype.audio.playlist.PreviewPlaylistActivity$special$$inlined$viewModelsWithArgs$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras defaultViewModelCreationExtras = previewPlaylistActivity.getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "<get-defaultViewModelCreationExtras>(...)");
                final PreviewPlaylistActivity previewPlaylistActivity2 = this;
                return HiltViewModelExtensions.withCreationCallback(defaultViewModelCreationExtras, new Function1<ViewModelAssistedFactory<PreviewPlaylistViewModel>, ViewModel>() { // from class: com.box.android.preview.previewtype.audio.playlist.PreviewPlaylistActivity$special$$inlined$viewModelsWithArgs$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final ViewModel invoke(ViewModelAssistedFactory<PreviewPlaylistViewModel> factory) {
                        FileModel fileModel;
                        PreviewSource previewSource;
                        Intrinsics.checkNotNullParameter(factory, "factory");
                        Bundle bundle = new Bundle();
                        Intent intent = previewPlaylistActivity2.getIntent();
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
                        Intent intent2 = previewPlaylistActivity2.getIntent();
                        Intrinsics.checkNotNullExpressionValue(intent2, "getIntent(...)");
                        if (Build.VERSION.SDK_INT >= 33) {
                            previewSource = (Parcelable) intent2.getParcelableExtra("PLAYLIST_PREVIEW_SOURCE", PreviewSource.class);
                        } else {
                            Parcelable parcelableExtra2 = intent2.getParcelableExtra("PLAYLIST_PREVIEW_SOURCE");
                            previewSource = (PreviewSource) (parcelableExtra2 instanceof PreviewSource ? parcelableExtra2 : null);
                        }
                        bundle.putParcelable(PreviewPlaylistViewModel.VM_PLAYLIST_PREVIEW_SOURCE_KEY, previewSource);
                        return factory.create(bundle);
                    }
                });
            }
        };
        this.viewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(PreviewPlaylistViewModel.class), new Function0<ViewModelStore>() { // from class: com.box.android.preview.previewtype.audio.playlist.PreviewPlaylistActivity$special$$inlined$viewModelsWithArgs$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return previewPlaylistActivity.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.box.android.preview.previewtype.audio.playlist.PreviewPlaylistActivity$special$$inlined$viewModelsWithArgs$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return previewPlaylistActivity.getDefaultViewModelProviderFactory();
            }
        }, new Function0<CreationExtras>() { // from class: com.box.android.preview.previewtype.audio.playlist.PreviewPlaylistActivity$special$$inlined$viewModelsWithArgs$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? previewPlaylistActivity.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
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

    private final PreviewPlaylistViewModel getViewModel() {
        return (PreviewPlaylistViewModel) this.viewModel.getValue();
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        super.onMAMCreate(bundle);
        new PlaylistActivityContent(this, getViewModel().getStore(), getAudioPlayerManager());
    }

    /* JADX INFO: compiled from: PreviewPlaylistActivity.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/box/android/preview/previewtype/audio/playlist/PreviewPlaylistActivity$Companion;", "", "<init>", "()V", "RESULT_SELECTED_PLAYLIST_ITEM_MODEL", "", "INITIAL_FILE_MODEL_KEY", PreviewPlaylistActivity.PLAYLIST_PREVIEW_SOURCE, "getIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "initialFileModel", "Lcom/box/android/domain/models/item/FileModel;", "previewSource", "Lcom/box/android/domain/models/preview/PreviewSource;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Intent getIntent(Context context, FileModel initialFileModel, PreviewSource previewSource) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(initialFileModel, "initialFileModel");
            Intrinsics.checkNotNullParameter(previewSource, "previewSource");
            Intent intent = new Intent(context, (Class<?>) PreviewPlaylistActivity.class);
            intent.putExtra("INITIAL_FILE_MODEL_KEY", initialFileModel);
            intent.putExtra(PreviewPlaylistActivity.PLAYLIST_PREVIEW_SOURCE, previewSource);
            return intent;
        }
    }
}
