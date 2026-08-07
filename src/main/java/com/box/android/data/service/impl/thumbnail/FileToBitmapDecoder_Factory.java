package com.box.android.data.service.impl.thumbnail;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes11.dex */
public final class FileToBitmapDecoder_Factory implements Factory<FileToBitmapDecoder> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FileToBitmapDecoder get() {
        return newInstance();
    }

    public static FileToBitmapDecoder_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static FileToBitmapDecoder newInstance() {
        return new FileToBitmapDecoder();
    }

    private static final class InstanceHolder {
        static final FileToBitmapDecoder_Factory INSTANCE = new FileToBitmapDecoder_Factory();

        private InstanceHolder() {
        }
    }
}
