package com.box.android.preview.previewtype.audio.playlist;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.box.android.common.utilities.ViewModelAssistedFactory;
import com.box.android.cpl.IStoreFactory;
import com.box.android.cpl.Store;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.preview.PreviewSource;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedFactory;
import dagger.assisted.AssistedInject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviewPlaylistViewModel.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0002\u0010\u0011B#\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/previewtype/audio/playlist/PreviewPlaylistViewModel;", "Landroidx/lifecycle/ViewModel;", "args", "Landroid/os/Bundle;", "storeFactory", "Lcom/box/android/cpl/IStoreFactory;", "environment", "Lcom/box/android/preview/previewtype/audio/playlist/PreviewPlaylistEnvironment;", "<init>", "(Landroid/os/Bundle;Lcom/box/android/cpl/IStoreFactory;Lcom/box/android/preview/previewtype/audio/playlist/PreviewPlaylistEnvironment;)V", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/previewtype/audio/playlist/PreviewPlaylistReducer$State;", "Lcom/box/android/preview/previewtype/audio/playlist/PreviewPlaylistReducer$Action;", "getStore", "()Lcom/box/android/cpl/Store;", "Factory", "Companion", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PreviewPlaylistViewModel extends ViewModel {
    public static final String VM_INITIAL_AUDIO_FILE_MODEL_KEY = "VM_INITIAL_FILE_MODEL_KEY";
    public static final String VM_PLAYLIST_PREVIEW_SOURCE_KEY = "VM_PLAYLIST_PREVIEW_SOURCE_KEY";
    private final Store<PreviewPlaylistReducer.State, PreviewPlaylistReducer.Action> store;
    public static final int $stable = 8;

    /* JADX INFO: compiled from: PreviewPlaylistViewModel.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003À\u0006\u0003"}, d2 = {"Lcom/box/android/preview/previewtype/audio/playlist/PreviewPlaylistViewModel$Factory;", "Lcom/box/android/common/utilities/ViewModelAssistedFactory;", "Lcom/box/android/preview/previewtype/audio/playlist/PreviewPlaylistViewModel;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @AssistedFactory
    public interface Factory extends ViewModelAssistedFactory<PreviewPlaylistViewModel> {
    }

    @AssistedInject
    public PreviewPlaylistViewModel(@Assisted Bundle args, IStoreFactory storeFactory, PreviewPlaylistEnvironment environment) {
        Parcelable parcelable;
        Parcelable parcelable2;
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(storeFactory, "storeFactory");
        Intrinsics.checkNotNullParameter(environment, "environment");
        if (Build.VERSION.SDK_INT >= 33) {
            parcelable = (Parcelable) args.getParcelable("VM_INITIAL_FILE_MODEL_KEY", FileModel.class);
        } else {
            Parcelable parcelable3 = args.getParcelable("VM_INITIAL_FILE_MODEL_KEY");
            parcelable = (FileModel) (parcelable3 instanceof FileModel ? parcelable3 : null);
        }
        if (parcelable == null) {
            throw new IllegalArgumentException("Parcelable with key VM_INITIAL_FILE_MODEL_KEY not found in Bundle".toString());
        }
        FileModel fileModel = (FileModel) parcelable;
        if (Build.VERSION.SDK_INT >= 33) {
            parcelable2 = (Parcelable) args.getParcelable(VM_PLAYLIST_PREVIEW_SOURCE_KEY, PreviewSource.class);
        } else {
            Parcelable parcelable4 = args.getParcelable(VM_PLAYLIST_PREVIEW_SOURCE_KEY);
            parcelable2 = (PreviewSource) (parcelable4 instanceof PreviewSource ? parcelable4 : null);
        }
        if (parcelable2 != null) {
            this.store = storeFactory.create(new PreviewPlaylistReducer.State(fileModel, (PreviewSource) parcelable2, null, null, null, 28, null), new PreviewPlaylistReducer(environment), ViewModelKt.getViewModelScope(this));
            return;
        }
        throw new IllegalArgumentException("Parcelable with key VM_PLAYLIST_PREVIEW_SOURCE_KEY not found in Bundle".toString());
    }

    public final Store<PreviewPlaylistReducer.State, PreviewPlaylistReducer.Action> getStore() {
        return this.store;
    }
}
