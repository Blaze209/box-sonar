package com.box.android.preview.previewtype.video;

import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class FrameExporter_Factory implements Factory<FrameExporter> {
    private final Provider<VideoMediaSourceFactory> videoMediaSourceFactoryProvider;
    private final Provider<VideoPlayersProvider> videoPlayersProvider;

    private FrameExporter_Factory(Provider<VideoPlayersProvider> provider, Provider<VideoMediaSourceFactory> provider2) {
        this.videoPlayersProvider = provider;
        this.videoMediaSourceFactoryProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FrameExporter get() {
        return newInstance(this.videoPlayersProvider.get(), this.videoMediaSourceFactoryProvider.get());
    }

    public static FrameExporter_Factory create(Provider<VideoPlayersProvider> provider, Provider<VideoMediaSourceFactory> provider2) {
        return new FrameExporter_Factory(provider, provider2);
    }

    public static FrameExporter newInstance(VideoPlayersProvider videoPlayersProvider, VideoMediaSourceFactory videoMediaSourceFactory) {
        return new FrameExporter(videoPlayersProvider, videoMediaSourceFactory);
    }
}
