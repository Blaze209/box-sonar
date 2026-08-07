package com.box.android.capture.di;

import android.media.MediaActionSound;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes10.dex */
public final class CaptureModule_Companion_ProvideMediaActionSoundFactory implements Factory<MediaActionSound> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public MediaActionSound get() {
        return provideMediaActionSound();
    }

    public static CaptureModule_Companion_ProvideMediaActionSoundFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static MediaActionSound provideMediaActionSound() {
        return (MediaActionSound) Preconditions.checkNotNullFromProvides(CaptureModule.INSTANCE.provideMediaActionSound());
    }

    private static final class InstanceHolder {
        static final CaptureModule_Companion_ProvideMediaActionSoundFactory INSTANCE = new CaptureModule_Companion_ProvideMediaActionSoundFactory();

        private InstanceHolder() {
        }
    }
}
