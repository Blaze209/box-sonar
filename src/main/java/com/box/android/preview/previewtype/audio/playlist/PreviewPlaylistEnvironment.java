package com.box.android.preview.previewtype.audio.playlist;

import com.box.android.domain.services.IAudioPlaylistItemsService;
import com.box.android.preview.previewtype.audio.Media3AudioPlayerManager;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviewPlaylistReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previewtype/audio/playlist/PreviewPlaylistEnvironment;", "", "playlistService", "Lcom/box/android/domain/services/IAudioPlaylistItemsService;", "audioPlayerManager", "Lcom/box/android/preview/previewtype/audio/Media3AudioPlayerManager;", "<init>", "(Lcom/box/android/domain/services/IAudioPlaylistItemsService;Lcom/box/android/preview/previewtype/audio/Media3AudioPlayerManager;)V", "getPlaylistService", "()Lcom/box/android/domain/services/IAudioPlaylistItemsService;", "getAudioPlayerManager", "()Lcom/box/android/preview/previewtype/audio/Media3AudioPlayerManager;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PreviewPlaylistEnvironment {
    public static final int $stable = 8;
    private final Media3AudioPlayerManager audioPlayerManager;
    private final IAudioPlaylistItemsService playlistService;

    @Inject
    public PreviewPlaylistEnvironment(IAudioPlaylistItemsService playlistService, Media3AudioPlayerManager audioPlayerManager) {
        Intrinsics.checkNotNullParameter(playlistService, "playlistService");
        Intrinsics.checkNotNullParameter(audioPlayerManager, "audioPlayerManager");
        this.playlistService = playlistService;
        this.audioPlayerManager = audioPlayerManager;
    }

    public final IAudioPlaylistItemsService getPlaylistService() {
        return this.playlistService;
    }

    public final Media3AudioPlayerManager getAudioPlayerManager() {
        return this.audioPlayerManager;
    }
}
