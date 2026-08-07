package com.box.android.data.service.impl;

import com.box.android.data.datasource.files.FileMetadataRemoteDataSource;
import com.box.android.data.datasource.files.MetadataTemplatesRemoteDataSource;
import com.box.android.domain.services.IdMappingService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class FileMetadataService_Factory implements Factory<FileMetadataService> {
    private final Provider<FileMetadataRemoteDataSource> fileMetadataRemoteDataSourceProvider;
    private final Provider<IdMappingService> idMappingServiceProvider;
    private final Provider<MetadataTemplatesRemoteDataSource> metadataTemplatesRemoteDataSourceProvider;

    private FileMetadataService_Factory(Provider<FileMetadataRemoteDataSource> fileMetadataRemoteDataSourceProvider, Provider<MetadataTemplatesRemoteDataSource> metadataTemplatesRemoteDataSourceProvider, Provider<IdMappingService> idMappingServiceProvider) {
        this.fileMetadataRemoteDataSourceProvider = fileMetadataRemoteDataSourceProvider;
        this.metadataTemplatesRemoteDataSourceProvider = metadataTemplatesRemoteDataSourceProvider;
        this.idMappingServiceProvider = idMappingServiceProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FileMetadataService get() {
        return newInstance(this.fileMetadataRemoteDataSourceProvider.get(), this.metadataTemplatesRemoteDataSourceProvider.get(), this.idMappingServiceProvider.get());
    }

    public static FileMetadataService_Factory create(Provider<FileMetadataRemoteDataSource> fileMetadataRemoteDataSourceProvider, Provider<MetadataTemplatesRemoteDataSource> metadataTemplatesRemoteDataSourceProvider, Provider<IdMappingService> idMappingServiceProvider) {
        return new FileMetadataService_Factory(fileMetadataRemoteDataSourceProvider, metadataTemplatesRemoteDataSourceProvider, idMappingServiceProvider);
    }

    public static FileMetadataService newInstance(FileMetadataRemoteDataSource fileMetadataRemoteDataSource, MetadataTemplatesRemoteDataSource metadataTemplatesRemoteDataSource, IdMappingService idMappingService) {
        return new FileMetadataService(fileMetadataRemoteDataSource, metadataTemplatesRemoteDataSource, idMappingService);
    }
}
