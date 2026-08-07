package com.box.android.preview.previewtype.audio;

import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class AudioPlayerService_MembersInjector implements MembersInjector<AudioPlayerService> {
    private final Provider<Media3AudioPlayerManager> audioPlayerManagerProvider;

    private AudioPlayerService_MembersInjector(Provider<Media3AudioPlayerManager> provider) {
        this.audioPlayerManagerProvider = provider;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(AudioPlayerService audioPlayerService) {
        injectAudioPlayerManager(audioPlayerService, this.audioPlayerManagerProvider.get());
    }

    public static MembersInjector<AudioPlayerService> create(Provider<Media3AudioPlayerManager> provider) {
        return new AudioPlayerService_MembersInjector(provider);
    }

    public static void injectAudioPlayerManager(AudioPlayerService audioPlayerService, Media3AudioPlayerManager media3AudioPlayerManager) {
        audioPlayerService.audioPlayerManager = media3AudioPlayerManager;
    }
}
