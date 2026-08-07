package com.box.android.data.service.impl;

import com.box.android.data.datasource.LegacyCacheDataSource;
import com.box.android.data.datasource.item.UpdateItemInfoRemoteDataSource;
import com.box.android.domain.services.IdMappingService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class UpdateItemInfoService_Factory implements Factory<UpdateItemInfoService> {
    private final Provider<IdMappingService> idMappingServiceProvider;
    private final Provider<LegacyCacheDataSource> legacyCacheDataSourceProvider;
    private final Provider<UpdateItemInfoRemoteDataSource> updateItemInfoRemoteDataSourceProvider;

    private UpdateItemInfoService_Factory(Provider<UpdateItemInfoRemoteDataSource> updateItemInfoRemoteDataSourceProvider, Provider<LegacyCacheDataSource> legacyCacheDataSourceProvider, Provider<IdMappingService> idMappingServiceProvider) {
        this.updateItemInfoRemoteDataSourceProvider = updateItemInfoRemoteDataSourceProvider;
        this.legacyCacheDataSourceProvider = legacyCacheDataSourceProvider;
        this.idMappingServiceProvider = idMappingServiceProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public UpdateItemInfoService get() {
        return newInstance(this.updateItemInfoRemoteDataSourceProvider.get(), this.legacyCacheDataSourceProvider.get(), this.idMappingServiceProvider.get());
    }

    public static UpdateItemInfoService_Factory create(Provider<UpdateItemInfoRemoteDataSource> updateItemInfoRemoteDataSourceProvider, Provider<LegacyCacheDataSource> legacyCacheDataSourceProvider, Provider<IdMappingService> idMappingServiceProvider) {
        return new UpdateItemInfoService_Factory(updateItemInfoRemoteDataSourceProvider, legacyCacheDataSourceProvider, idMappingServiceProvider);
    }

    public static UpdateItemInfoService newInstance(UpdateItemInfoRemoteDataSource updateItemInfoRemoteDataSource, LegacyCacheDataSource legacyCacheDataSource, IdMappingService idMappingService) {
        return new UpdateItemInfoService(updateItemInfoRemoteDataSource, legacyCacheDataSource, idMappingService);
    }
}
