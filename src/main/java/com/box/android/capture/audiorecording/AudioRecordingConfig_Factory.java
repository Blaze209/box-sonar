package com.box.android.capture.audiorecording;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes10.dex */
public final class AudioRecordingConfig_Factory implements Factory<AudioRecordingConfig> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AudioRecordingConfig get() {
        return newInstance();
    }

    public static AudioRecordingConfig_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static AudioRecordingConfig newInstance() {
        return new AudioRecordingConfig();
    }

    private static final class InstanceHolder {
        static final AudioRecordingConfig_Factory INSTANCE = new AudioRecordingConfig_Factory();

        private InstanceHolder() {
        }
    }
}
