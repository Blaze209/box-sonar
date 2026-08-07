package com.box.android.preview.previewtype.video;

import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class VideoPlayerInteractor_Factory implements Factory<VideoPlayerInteractor> {
    private final Provider<VideoPlayersProvider> videoPlayersProvider;

    private VideoPlayerInteractor_Factory(Provider<VideoPlayersProvider> provider) {
        this.videoPlayersProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public VideoPlayerInteractor get() {
        return newInstance(this.videoPlayersProvider.get());
    }

    public static VideoPlayerInteractor_Factory create(Provider<VideoPlayersProvider> provider) {
        return new VideoPlayerInteractor_Factory(provider);
    }

    public static VideoPlayerInteractor newInstance(VideoPlayersProvider videoPlayersProvider) {
        return new VideoPlayerInteractor(videoPlayersProvider);
    }
}
