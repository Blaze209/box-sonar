package com.box.android.data.datasource;

import com.box.android.data.api.requests.WatermarkRequest;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class WatermarkRemoteDataSource_Factory implements Factory<WatermarkRemoteDataSource> {
    private final Provider<WatermarkRequest> watermarkRequestProvider;

    private WatermarkRemoteDataSource_Factory(Provider<WatermarkRequest> watermarkRequestProvider) {
        this.watermarkRequestProvider = watermarkRequestProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public WatermarkRemoteDataSource get() {
        return newInstance(this.watermarkRequestProvider.get());
    }

    public static WatermarkRemoteDataSource_Factory create(Provider<WatermarkRequest> watermarkRequestProvider) {
        return new WatermarkRemoteDataSource_Factory(watermarkRequestProvider);
    }

    public static WatermarkRemoteDataSource newInstance(WatermarkRequest watermarkRequest) {
        return new WatermarkRemoteDataSource(watermarkRequest);
    }
}
