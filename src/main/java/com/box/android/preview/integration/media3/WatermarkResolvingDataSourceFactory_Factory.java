package com.box.android.preview.integration.media3;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes12.dex */
public final class WatermarkResolvingDataSourceFactory_Factory implements Factory<WatermarkResolvingDataSourceFactory> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public WatermarkResolvingDataSourceFactory get() {
        return newInstance();
    }

    public static WatermarkResolvingDataSourceFactory_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static WatermarkResolvingDataSourceFactory newInstance() {
        return new WatermarkResolvingDataSourceFactory();
    }

    private static final class InstanceHolder {
        static final WatermarkResolvingDataSourceFactory_Factory INSTANCE = new WatermarkResolvingDataSourceFactory_Factory();

        private InstanceHolder() {
        }
    }
}
