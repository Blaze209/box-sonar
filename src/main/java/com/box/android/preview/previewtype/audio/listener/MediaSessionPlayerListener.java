package com.box.android.preview.previewtype.audio.listener;

import androidx.media3.common.MediaItem;
import androidx.media3.common.Player;
import com.box.android.preview.previewtype.audio.model.AudioTrack;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MediaSessionPlayerListener.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/box/android/preview/previewtype/audio/listener/MediaSessionPlayerListener;", "Landroidx/media3/common/Player$Listener;", "playlist", "", "Lcom/box/android/preview/previewtype/audio/model/AudioTrack;", "onAudioTrackChange", "Lkotlin/Function1;", "", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "onMediaItemTransition", "mediaItem", "Landroidx/media3/common/MediaItem;", BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_REASON, "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MediaSessionPlayerListener implements Player.Listener {
    public static final int $stable = 8;
    private final Function1<AudioTrack, Unit> onAudioTrackChange;
    private final List<AudioTrack> playlist;

    /* JADX WARN: Multi-variable type inference failed */
    public MediaSessionPlayerListener(List<AudioTrack> playlist, Function1<? super AudioTrack, Unit> onAudioTrackChange) {
        Intrinsics.checkNotNullParameter(playlist, "playlist");
        Intrinsics.checkNotNullParameter(onAudioTrackChange, "onAudioTrackChange");
        this.playlist = playlist;
        this.onAudioTrackChange = onAudioTrackChange;
    }

    @Override // androidx.media3.common.Player.Listener
    public void onMediaItemTransition(MediaItem mediaItem, int reason) {
        Object next;
        if (mediaItem != null) {
            Iterator<T> it = this.playlist.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.areEqual(((AudioTrack) next).getFileModel().getItemId().toString(), mediaItem.mediaId));
            AudioTrack audioTrack = (AudioTrack) next;
            if (audioTrack != null) {
                this.onAudioTrackChange.invoke(audioTrack);
            }
        }
    }
}
