package com.box.android.preview.previewtype.video;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes12.dex */
public final class VideoPlayersProvider_Factory implements Factory<VideoPlayersProvider> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public VideoPlayersProvider get() {
        return newInstance();
    }

    public static VideoPlayersProvider_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static VideoPlayersProvider newInstance() {
        return new VideoPlayersProvider();
    }

    private static final class InstanceHolder {
        static final VideoPlayersProvider_Factory INSTANCE = new VideoPlayersProvider_Factory();

        private InstanceHolder() {
        }
    }
}
