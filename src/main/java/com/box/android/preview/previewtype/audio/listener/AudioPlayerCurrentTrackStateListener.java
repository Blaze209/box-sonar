package com.box.android.preview.previewtype.audio.listener;

import androidx.media3.common.PlaybackException;
import androidx.media3.common.Player;
import com.box.android.cpl.Store;
import com.box.android.cpl.StoreKt;
import com.box.android.domain.models.FilePreviewDomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.preview.previewtype.audio.AudioPreviewReducer;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationErrorResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AudioPlayerCurrentTrackStateListener.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/box/android/preview/previewtype/audio/listener/AudioPlayerCurrentTrackStateListener;", "Landroidx/media3/common/Player$Listener;", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/previewtype/audio/AudioPreviewReducer$State;", "Lcom/box/android/preview/previewtype/audio/AudioPreviewReducer$Action;", "<init>", "(Lcom/box/android/cpl/Store;)V", "getStore", "()Lcom/box/android/cpl/Store;", "itemId", "Lcom/box/android/domain/models/ItemId;", "getItemId", "()Lcom/box/android/domain/models/ItemId;", "loadedItemId", "onPlayerError", "", "error", "Landroidx/media3/common/PlaybackException;", "onPlaybackStateChanged", "playbackState", "", "onIsPlayingChanged", "isPlaying", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AudioPlayerCurrentTrackStateListener implements Player.Listener {
    public static final int $stable = 8;
    private final ItemId itemId;
    private ItemId loadedItemId;
    private final Store<AudioPreviewReducer.State, AudioPreviewReducer.Action> store;

    public AudioPlayerCurrentTrackStateListener(Store<AudioPreviewReducer.State, AudioPreviewReducer.Action> store) {
        Intrinsics.checkNotNullParameter(store, "store");
        this.store = store;
        this.itemId = ((AudioPreviewReducer.State) StoreKt.stateValue(store)).getFileModel().getItemId();
    }

    public final Store<AudioPreviewReducer.State, AudioPreviewReducer.Action> getStore() {
        return this.store;
    }

    public final ItemId getItemId() {
        return this.itemId;
    }

    @Override // androidx.media3.common.Player.Listener
    public void onPlayerError(PlaybackException error) {
        Intrinsics.checkNotNullParameter(error, "error");
        super.onPlayerError(error);
        Store<AudioPreviewReducer.State, AudioPreviewReducer.Action> store = this.store;
        String message = error.getMessage();
        if (message == null) {
            message = MicrosoftAuthorizationErrorResponse.UNKNOWN_ERROR;
        }
        store.send(new AudioPreviewReducer.Action.Error(new FilePreviewDomainError.AudioPlayError(message)));
    }

    @Override // androidx.media3.common.Player.Listener
    public void onPlaybackStateChanged(int playbackState) {
        if (playbackState != 3 || Intrinsics.areEqual(this.itemId, this.loadedItemId)) {
            return;
        }
        this.store.send(AudioPreviewReducer.Action.Loaded.INSTANCE);
        this.loadedItemId = this.itemId;
    }

    @Override // androidx.media3.common.Player.Listener
    public void onIsPlayingChanged(boolean isPlaying) {
        super.onIsPlayingChanged(isPlaying);
        if (isPlaying) {
            this.store.send(AudioPreviewReducer.Action.Playing.INSTANCE);
        } else {
            this.store.send(AudioPreviewReducer.Action.Paused.INSTANCE);
        }
    }
}
