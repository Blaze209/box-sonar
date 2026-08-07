package com.box.android.data.service.impl;

import com.box.android.data.datasource.VersionsPreviewCache;
import com.box.android.data.datasource.representations.RepresentationsCacheDataSource;
import com.box.android.data.datasource.representations.RepresentationsRemoteDataSource;
import com.box.android.domain.controller.IPreviewController;
import com.box.android.domain.services.IdMappingService;
import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes11.dex */
public final class RepresentationsService_Factory implements Factory<RepresentationsService> {
    private final Provider<CoroutineDispatcher> ioDispatcherProvider;
    private final Provider<IPreviewController> legacyPreviewControllerProvider;
    private final Provider<IdMappingService> mappingServiceProvider;
    private final Provider<RepresentationsCacheDataSource> representationsCacheDataSourceProvider;
    private final Provider<RepresentationsRemoteDataSource> representationsRemoteDataSourceProvider;
    private final Provider<VersionsPreviewCache> versionsPreviewCacheProvider;

    private RepresentationsService_Factory(Provider<RepresentationsRemoteDataSource> representationsRemoteDataSourceProvider, Provider<RepresentationsCacheDataSource> representationsCacheDataSourceProvider, Provider<VersionsPreviewCache> versionsPreviewCacheProvider, Provider<IdMappingService> mappingServiceProvider, Provider<IPreviewController> legacyPreviewControllerProvider, Provider<CoroutineDispatcher> ioDispatcherProvider) {
        this.representationsRemoteDataSourceProvider = representationsRemoteDataSourceProvider;
        this.representationsCacheDataSourceProvider = representationsCacheDataSourceProvider;
        this.versionsPreviewCacheProvider = versionsPreviewCacheProvider;
        this.mappingServiceProvider = mappingServiceProvider;
        this.legacyPreviewControllerProvider = legacyPreviewControllerProvider;
        this.ioDispatcherProvider = ioDispatcherProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public RepresentationsService get() {
        return newInstance(this.representationsRemoteDataSourceProvider.get(), this.representationsCacheDataSourceProvider.get(), this.versionsPreviewCacheProvider.get(), this.mappingServiceProvider.get(), this.legacyPreviewControllerProvider.get(), this.ioDispatcherProvider.get());
    }

    public static RepresentationsService_Factory create(Provider<RepresentationsRemoteDataSource> representationsRemoteDataSourceProvider, Provider<RepresentationsCacheDataSource> representationsCacheDataSourceProvider, Provider<VersionsPreviewCache> versionsPreviewCacheProvider, Provider<IdMappingService> mappingServiceProvider, Provider<IPreviewController> legacyPreviewControllerProvider, Provider<CoroutineDispatcher> ioDispatcherProvider) {
        return new RepresentationsService_Factory(representationsRemoteDataSourceProvider, representationsCacheDataSourceProvider, versionsPreviewCacheProvider, mappingServiceProvider, legacyPreviewControllerProvider, ioDispatcherProvider);
    }

    public static RepresentationsService newInstance(RepresentationsRemoteDataSource representationsRemoteDataSource, RepresentationsCacheDataSource representationsCacheDataSource, VersionsPreviewCache versionsPreviewCache, IdMappingService mappingService, IPreviewController legacyPreviewController, CoroutineDispatcher ioDispatcher) {
        return new RepresentationsService(representationsRemoteDataSource, representationsCacheDataSource, versionsPreviewCache, mappingService, legacyPreviewController, ioDispatcher);
    }
}
