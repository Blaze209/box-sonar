package com.box.android.preview.previewtype.audio.playlist;

import com.box.android.domain.services.IAudioPlaylistItemsService;
import com.box.android.preview.previewtype.audio.Media3AudioPlayerManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class PreviewPlaylistEnvironment_Factory implements Factory<PreviewPlaylistEnvironment> {
    private final Provider<Media3AudioPlayerManager> audioPlayerManagerProvider;
    private final Provider<IAudioPlaylistItemsService> playlistServiceProvider;

    private PreviewPlaylistEnvironment_Factory(Provider<IAudioPlaylistItemsService> provider, Provider<Media3AudioPlayerManager> provider2) {
        this.playlistServiceProvider = provider;
        this.audioPlayerManagerProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public PreviewPlaylistEnvironment get() {
        return newInstance(this.playlistServiceProvider.get(), this.audioPlayerManagerProvider.get());
    }

    public static PreviewPlaylistEnvironment_Factory create(Provider<IAudioPlaylistItemsService> provider, Provider<Media3AudioPlayerManager> provider2) {
        return new PreviewPlaylistEnvironment_Factory(provider, provider2);
    }

    public static PreviewPlaylistEnvironment newInstance(IAudioPlaylistItemsService iAudioPlaylistItemsService, Media3AudioPlayerManager media3AudioPlayerManager) {
        return new PreviewPlaylistEnvironment(iAudioPlaylistItemsService, media3AudioPlayerManager);
    }
}
