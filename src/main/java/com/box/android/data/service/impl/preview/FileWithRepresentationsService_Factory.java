package com.box.android.data.service.impl.preview;

import com.box.android.data.datasource.LegacyCacheDataSource;
import com.box.android.data.datasource.representations.RepresentationsCacheDataSource;
import com.box.android.data.datasource.representations.RepresentationsRemoteDataSource;
import com.box.android.domain.services.ILocalItemService;
import com.box.android.domain.services.IdMappingService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class FileWithRepresentationsService_Factory implements Factory<FileWithRepresentationsService> {
    private final Provider<LegacyCacheDataSource> legacyCacheDataSourceProvider;
    private final Provider<ILocalItemService> localItemServiceProvider;
    private final Provider<IdMappingService> mappingServiceProvider;
    private final Provider<RepresentationsCacheDataSource> representationsCacheDataSourceProvider;
    private final Provider<RepresentationsRemoteDataSource> representationsRemoteDataSourceProvider;

    private FileWithRepresentationsService_Factory(Provider<RepresentationsRemoteDataSource> representationsRemoteDataSourceProvider, Provider<RepresentationsCacheDataSource> representationsCacheDataSourceProvider, Provider<LegacyCacheDataSource> legacyCacheDataSourceProvider, Provider<IdMappingService> mappingServiceProvider, Provider<ILocalItemService> localItemServiceProvider) {
        this.representationsRemoteDataSourceProvider = representationsRemoteDataSourceProvider;
        this.representationsCacheDataSourceProvider = representationsCacheDataSourceProvider;
        this.legacyCacheDataSourceProvider = legacyCacheDataSourceProvider;
        this.mappingServiceProvider = mappingServiceProvider;
        this.localItemServiceProvider = localItemServiceProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FileWithRepresentationsService get() {
        return newInstance(this.representationsRemoteDataSourceProvider.get(), this.representationsCacheDataSourceProvider.get(), this.legacyCacheDataSourceProvider.get(), this.mappingServiceProvider.get(), this.localItemServiceProvider.get());
    }

    public static FileWithRepresentationsService_Factory create(Provider<RepresentationsRemoteDataSource> representationsRemoteDataSourceProvider, Provider<RepresentationsCacheDataSource> representationsCacheDataSourceProvider, Provider<LegacyCacheDataSource> legacyCacheDataSourceProvider, Provider<IdMappingService> mappingServiceProvider, Provider<ILocalItemService> localItemServiceProvider) {
        return new FileWithRepresentationsService_Factory(representationsRemoteDataSourceProvider, representationsCacheDataSourceProvider, legacyCacheDataSourceProvider, mappingServiceProvider, localItemServiceProvider);
    }

    public static FileWithRepresentationsService newInstance(RepresentationsRemoteDataSource representationsRemoteDataSource, RepresentationsCacheDataSource representationsCacheDataSource, LegacyCacheDataSource legacyCacheDataSource, IdMappingService mappingService, ILocalItemService localItemService) {
        return new FileWithRepresentationsService(representationsRemoteDataSource, representationsCacheDataSource, legacyCacheDataSource, mappingService, localItemService);
    }
}
