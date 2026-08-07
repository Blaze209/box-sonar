package com.box.android.capture.audiorecording.logic;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes10.dex */
public final class AudioRecordingHelper_Factory implements Factory<AudioRecordingHelper> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AudioRecordingHelper get() {
        return newInstance();
    }

    public static AudioRecordingHelper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static AudioRecordingHelper newInstance() {
        return new AudioRecordingHelper();
    }

    private static final class InstanceHolder {
        static final AudioRecordingHelper_Factory INSTANCE = new AudioRecordingHelper_Factory();

        private InstanceHolder() {
        }
    }
}
