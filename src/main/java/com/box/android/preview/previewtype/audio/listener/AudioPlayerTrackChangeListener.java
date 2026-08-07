package com.box.android.preview.previewtype.audio.listener;

import androidx.media3.common.MediaItem;
import androidx.media3.common.Player;
import com.box.android.cpl.Store;
import com.box.android.cpl.StoreKt;
import com.box.android.preview.preview.PreviewNavigationMethod;
import com.box.android.preview.preview.PreviewReducer;
import com.box.android.preview.previewtype.audio.model.AudioTrack;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AudioPlayerTrackChangeListener.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/box/android/preview/previewtype/audio/listener/AudioPlayerTrackChangeListener;", "Landroidx/media3/common/Player$Listener;", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/preview/PreviewReducer$State;", "Lcom/box/android/preview/preview/PreviewReducer$Action;", "<init>", "(Lcom/box/android/cpl/Store;)V", "getStore", "()Lcom/box/android/cpl/Store;", "onMediaItemTransition", "", "mediaItem", "Landroidx/media3/common/MediaItem;", BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_REASON, "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AudioPlayerTrackChangeListener implements Player.Listener {
    public static final int $stable = 0;
    private final Store<PreviewReducer.State, PreviewReducer.Action> store;

    public AudioPlayerTrackChangeListener(Store<PreviewReducer.State, PreviewReducer.Action> store) {
        Intrinsics.checkNotNullParameter(store, "store");
        this.store = store;
    }

    public final Store<PreviewReducer.State, PreviewReducer.Action> getStore() {
        return this.store;
    }

    @Override // androidx.media3.common.Player.Listener
    public void onMediaItemTransition(MediaItem mediaItem, int reason) {
        Object obj;
        super.onMediaItemTransition(mediaItem, reason);
        Iterator<T> it = ((PreviewReducer.State) StoreKt.stateValue(this.store)).getPlaylist().iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (Intrinsics.areEqual(((AudioTrack) next).getFileModel().getItemId().toString(), mediaItem != null ? mediaItem.mediaId : null)) {
                obj = next;
                break;
            }
        }
        AudioTrack audioTrack = (AudioTrack) obj;
        if (audioTrack == null) {
            return;
        }
        this.store.send(new PreviewReducer.Action.SetSelectedItem(audioTrack.getFileModel(), PreviewNavigationMethod.PLAYLIST_VIEW));
    }
}
