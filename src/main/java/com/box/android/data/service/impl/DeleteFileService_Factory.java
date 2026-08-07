package com.box.android.data.service.impl;

import com.box.android.data.datasource.files.DeleteFileRemoteDataSource;
import com.box.android.domain.services.IdMappingService;
import com.box.androidsdk.content.BoxCache;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DeleteFileService_Factory implements Factory<DeleteFileService> {
    private final Provider<BoxCache> boxCacheProvider;
    private final Provider<DeleteFileRemoteDataSource> deleteFileRemoteDataSourceProvider;
    private final Provider<IdMappingService> idMappingServiceProvider;

    private DeleteFileService_Factory(Provider<DeleteFileRemoteDataSource> deleteFileRemoteDataSourceProvider, Provider<BoxCache> boxCacheProvider, Provider<IdMappingService> idMappingServiceProvider) {
        this.deleteFileRemoteDataSourceProvider = deleteFileRemoteDataSourceProvider;
        this.boxCacheProvider = boxCacheProvider;
        this.idMappingServiceProvider = idMappingServiceProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public DeleteFileService get() {
        return newInstance(this.deleteFileRemoteDataSourceProvider.get(), this.boxCacheProvider.get(), this.idMappingServiceProvider.get());
    }

    public static DeleteFileService_Factory create(Provider<DeleteFileRemoteDataSource> deleteFileRemoteDataSourceProvider, Provider<BoxCache> boxCacheProvider, Provider<IdMappingService> idMappingServiceProvider) {
        return new DeleteFileService_Factory(deleteFileRemoteDataSourceProvider, boxCacheProvider, idMappingServiceProvider);
    }

    public static DeleteFileService newInstance(DeleteFileRemoteDataSource deleteFileRemoteDataSource, BoxCache boxCache, IdMappingService idMappingService) {
        return new DeleteFileService(deleteFileRemoteDataSource, boxCache, idMappingService);
    }
}
