package com.box.android.capture;

import android.media.MediaActionSound;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class CaptureShutterSoundHelper_Factory implements Factory<CaptureShutterSoundHelper> {
    private final Provider<MediaActionSound> mediaActionSoundProvider;

    private CaptureShutterSoundHelper_Factory(Provider<MediaActionSound> provider) {
        this.mediaActionSoundProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CaptureShutterSoundHelper get() {
        return newInstance(this.mediaActionSoundProvider.get());
    }

    public static CaptureShutterSoundHelper_Factory create(Provider<MediaActionSound> provider) {
        return new CaptureShutterSoundHelper_Factory(provider);
    }

    public static CaptureShutterSoundHelper newInstance(MediaActionSound mediaActionSound) {
        return new CaptureShutterSoundHelper(mediaActionSound);
    }
}
