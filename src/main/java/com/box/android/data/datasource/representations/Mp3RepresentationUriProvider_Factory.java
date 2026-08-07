package com.box.android.data.datasource.representations;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes11.dex */
public final class Mp3RepresentationUriProvider_Factory implements Factory<Mp3RepresentationUriProvider> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Mp3RepresentationUriProvider get() {
        return newInstance();
    }

    public static Mp3RepresentationUriProvider_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Mp3RepresentationUriProvider newInstance() {
        return new Mp3RepresentationUriProvider();
    }

    private static final class InstanceHolder {
        static final Mp3RepresentationUriProvider_Factory INSTANCE = new Mp3RepresentationUriProvider_Factory();

        private InstanceHolder() {
        }
    }
}
