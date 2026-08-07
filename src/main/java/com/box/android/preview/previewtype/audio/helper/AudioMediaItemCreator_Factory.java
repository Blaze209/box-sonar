package com.box.android.preview.previewtype.audio.helper;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes12.dex */
public final class AudioMediaItemCreator_Factory implements Factory<AudioMediaItemCreator> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AudioMediaItemCreator get() {
        return newInstance();
    }

    public static AudioMediaItemCreator_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static AudioMediaItemCreator newInstance() {
        return new AudioMediaItemCreator();
    }

    private static final class InstanceHolder {
        static final AudioMediaItemCreator_Factory INSTANCE = new AudioMediaItemCreator_Factory();

        private InstanceHolder() {
        }
    }
}
