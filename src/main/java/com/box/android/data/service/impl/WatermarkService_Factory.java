package com.box.android.data.service.impl;

import com.box.android.data.datasource.WatermarkRemoteDataSource;
import com.box.android.domain.services.IdMappingService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class WatermarkService_Factory implements Factory<WatermarkService> {
    private final Provider<IdMappingService> idMappingServiceProvider;
    private final Provider<WatermarkRemoteDataSource> watermarkRemoteDataSourceProvider;

    private WatermarkService_Factory(Provider<WatermarkRemoteDataSource> watermarkRemoteDataSourceProvider, Provider<IdMappingService> idMappingServiceProvider) {
        this.watermarkRemoteDataSourceProvider = watermarkRemoteDataSourceProvider;
        this.idMappingServiceProvider = idMappingServiceProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public WatermarkService get() {
        return newInstance(this.watermarkRemoteDataSourceProvider.get(), this.idMappingServiceProvider.get());
    }

    public static WatermarkService_Factory create(Provider<WatermarkRemoteDataSource> watermarkRemoteDataSourceProvider, Provider<IdMappingService> idMappingServiceProvider) {
        return new WatermarkService_Factory(watermarkRemoteDataSourceProvider, idMappingServiceProvider);
    }

    public static WatermarkService newInstance(WatermarkRemoteDataSource watermarkRemoteDataSource, IdMappingService idMappingService) {
        return new WatermarkService(watermarkRemoteDataSource, idMappingService);
    }
}
