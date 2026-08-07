package com.box.android.data.service.impl;

import com.box.android.data.datasource.fileversions.FileVersionsRemoteDataSource;
import com.box.android.domain.services.IdMappingService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class FileVersionService_Factory implements Factory<FileVersionService> {
    private final Provider<FileVersionsRemoteDataSource> fileVersionsRemoteDataSourceProvider;
    private final Provider<IdMappingService> idMappingServiceProvider;

    private FileVersionService_Factory(Provider<FileVersionsRemoteDataSource> fileVersionsRemoteDataSourceProvider, Provider<IdMappingService> idMappingServiceProvider) {
        this.fileVersionsRemoteDataSourceProvider = fileVersionsRemoteDataSourceProvider;
        this.idMappingServiceProvider = idMappingServiceProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FileVersionService get() {
        return newInstance(this.fileVersionsRemoteDataSourceProvider.get(), this.idMappingServiceProvider.get());
    }

    public static FileVersionService_Factory create(Provider<FileVersionsRemoteDataSource> fileVersionsRemoteDataSourceProvider, Provider<IdMappingService> idMappingServiceProvider) {
        return new FileVersionService_Factory(fileVersionsRemoteDataSourceProvider, idMappingServiceProvider);
    }

    public static FileVersionService newInstance(FileVersionsRemoteDataSource fileVersionsRemoteDataSource, IdMappingService idMappingService) {
        return new FileVersionService(fileVersionsRemoteDataSource, idMappingService);
    }
}
