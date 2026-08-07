package com.box.android.preview.previewtype.video;

import androidx.media3.common.PlaybackException;
import kotlin.Metadata;

/* JADX INFO: compiled from: VideoPlayerInteractor.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, d2 = {"isNetworkError", "", "Landroidx/media3/common/PlaybackException;", "preview_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class VideoPlayerInteractorKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isNetworkError(PlaybackException playbackException) {
        return playbackException.errorCode == 2001 || playbackException.errorCode == 2002;
    }
}
