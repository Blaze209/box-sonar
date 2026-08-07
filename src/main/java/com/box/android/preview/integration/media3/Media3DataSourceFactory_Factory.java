package com.box.android.preview.integration.media3;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes12.dex */
public final class Media3DataSourceFactory_Factory implements Factory<Media3DataSourceFactory> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Media3DataSourceFactory get() {
        return newInstance();
    }

    public static Media3DataSourceFactory_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Media3DataSourceFactory newInstance() {
        return new Media3DataSourceFactory();
    }

    private static final class InstanceHolder {
        static final Media3DataSourceFactory_Factory INSTANCE = new Media3DataSourceFactory_Factory();

        private InstanceHolder() {
        }
    }
}
