package com.box.android.data.service.impl;

import com.box.android.data.datasource.LegacyCacheDataSource;
import com.box.android.data.datasource.SharedLinkCredentialsCacheDatasource;
import com.box.android.data.datasource.item.UpdateItemInfoRemoteDataSource;
import com.box.android.domain.services.IdMappingService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class SharedLinkService_Factory implements Factory<SharedLinkService> {
    private final Provider<IdMappingService> idMappingServiceProvider;
    private final Provider<LegacyCacheDataSource> legacyCacheDataSourceProvider;
    private final Provider<SharedLinkCredentialsCacheDatasource> sharedLinkCredentialsCacheDatasourceProvider;
    private final Provider<UpdateItemInfoRemoteDataSource> updateItemInfoRemoteDataSourceProvider;

    private SharedLinkService_Factory(Provider<UpdateItemInfoRemoteDataSource> updateItemInfoRemoteDataSourceProvider, Provider<LegacyCacheDataSource> legacyCacheDataSourceProvider, Provider<IdMappingService> idMappingServiceProvider, Provider<SharedLinkCredentialsCacheDatasource> sharedLinkCredentialsCacheDatasourceProvider) {
        this.updateItemInfoRemoteDataSourceProvider = updateItemInfoRemoteDataSourceProvider;
        this.legacyCacheDataSourceProvider = legacyCacheDataSourceProvider;
        this.idMappingServiceProvider = idMappingServiceProvider;
        this.sharedLinkCredentialsCacheDatasourceProvider = sharedLinkCredentialsCacheDatasourceProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public SharedLinkService get() {
        return newInstance(this.updateItemInfoRemoteDataSourceProvider.get(), this.legacyCacheDataSourceProvider.get(), this.idMappingServiceProvider.get(), this.sharedLinkCredentialsCacheDatasourceProvider.get());
    }

    public static SharedLinkService_Factory create(Provider<UpdateItemInfoRemoteDataSource> updateItemInfoRemoteDataSourceProvider, Provider<LegacyCacheDataSource> legacyCacheDataSourceProvider, Provider<IdMappingService> idMappingServiceProvider, Provider<SharedLinkCredentialsCacheDatasource> sharedLinkCredentialsCacheDatasourceProvider) {
        return new SharedLinkService_Factory(updateItemInfoRemoteDataSourceProvider, legacyCacheDataSourceProvider, idMappingServiceProvider, sharedLinkCredentialsCacheDatasourceProvider);
    }

    public static SharedLinkService newInstance(UpdateItemInfoRemoteDataSource updateItemInfoRemoteDataSource, LegacyCacheDataSource legacyCacheDataSource, IdMappingService idMappingService, SharedLinkCredentialsCacheDatasource sharedLinkCredentialsCacheDatasource) {
        return new SharedLinkService(updateItemInfoRemoteDataSource, legacyCacheDataSource, idMappingService, sharedLinkCredentialsCacheDatasource);
    }
}
