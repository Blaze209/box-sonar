package com.box.android.data.service.impl;

import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.data.datasource.LegacyCacheDataSource;
import com.box.android.data.datasource.gql.BoxGraphQL;
import com.box.android.data.datasource.gql.cache.partial.GQLPartialDataExtractor;
import com.box.android.data.utilities.GQLCacheHelper;
import com.box.android.domain.metrics.Gen204PerformanceLogger;
import com.box.android.domain.services.IdMappingService;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes11.dex */
public final class RemoteItemService_Factory implements Factory<RemoteItemService> {
    private final Provider<IBaseModelController> baseModelControllerProvider;
    private final Provider<BoxExtendedApiFolder> folderApiProvider;
    private final Provider<Gen204PerformanceLogger> gen204PerformanceLoggerProvider;
    private final Provider<GQLCacheHelper> gqlCacheHelperProvider;
    private final Provider<GQLPartialDataExtractor> gqlPartialDataExtractorProvider;
    private final Provider<BoxGraphQL> graphQLProvider;
    private final Provider<IdMappingService> idMappingServiceProvider;
    private final Provider<CoroutineDispatcher> ioDispatcherProvider;
    private final Provider<LegacyCacheDataSource> legacyCacheDataSourceProvider;

    private RemoteItemService_Factory(Provider<BoxGraphQL> graphQLProvider, Provider<LegacyCacheDataSource> legacyCacheDataSourceProvider, Provider<GQLCacheHelper> gqlCacheHelperProvider, Provider<Gen204PerformanceLogger> gen204PerformanceLoggerProvider, Provider<IBaseModelController> baseModelControllerProvider, Provider<BoxExtendedApiFolder> folderApiProvider, Provider<GQLPartialDataExtractor> gqlPartialDataExtractorProvider, Provider<IdMappingService> idMappingServiceProvider, Provider<CoroutineDispatcher> ioDispatcherProvider) {
        this.graphQLProvider = graphQLProvider;
        this.legacyCacheDataSourceProvider = legacyCacheDataSourceProvider;
        this.gqlCacheHelperProvider = gqlCacheHelperProvider;
        this.gen204PerformanceLoggerProvider = gen204PerformanceLoggerProvider;
        this.baseModelControllerProvider = baseModelControllerProvider;
        this.folderApiProvider = folderApiProvider;
        this.gqlPartialDataExtractorProvider = gqlPartialDataExtractorProvider;
        this.idMappingServiceProvider = idMappingServiceProvider;
        this.ioDispatcherProvider = ioDispatcherProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public RemoteItemService get() {
        return newInstance(this.graphQLProvider.get(), this.legacyCacheDataSourceProvider.get(), this.gqlCacheHelperProvider.get(), this.gen204PerformanceLoggerProvider.get(), this.baseModelControllerProvider.get(), this.folderApiProvider.get(), this.gqlPartialDataExtractorProvider.get(), this.idMappingServiceProvider.get(), this.ioDispatcherProvider.get());
    }

    public static RemoteItemService_Factory create(Provider<BoxGraphQL> graphQLProvider, Provider<LegacyCacheDataSource> legacyCacheDataSourceProvider, Provider<GQLCacheHelper> gqlCacheHelperProvider, Provider<Gen204PerformanceLogger> gen204PerformanceLoggerProvider, Provider<IBaseModelController> baseModelControllerProvider, Provider<BoxExtendedApiFolder> folderApiProvider, Provider<GQLPartialDataExtractor> gqlPartialDataExtractorProvider, Provider<IdMappingService> idMappingServiceProvider, Provider<CoroutineDispatcher> ioDispatcherProvider) {
        return new RemoteItemService_Factory(graphQLProvider, legacyCacheDataSourceProvider, gqlCacheHelperProvider, gen204PerformanceLoggerProvider, baseModelControllerProvider, folderApiProvider, gqlPartialDataExtractorProvider, idMappingServiceProvider, ioDispatcherProvider);
    }

    public static RemoteItemService newInstance(BoxGraphQL graphQL, LegacyCacheDataSource legacyCacheDataSource, GQLCacheHelper gqlCacheHelper, Gen204PerformanceLogger gen204PerformanceLogger, IBaseModelController baseModelController, BoxExtendedApiFolder folderApi, GQLPartialDataExtractor gqlPartialDataExtractor, IdMappingService idMappingService, CoroutineDispatcher ioDispatcher) {
        return new RemoteItemService(graphQL, legacyCacheDataSource, gqlCacheHelper, gen204PerformanceLogger, baseModelController, folderApi, gqlPartialDataExtractor, idMappingService, ioDispatcher);
    }
}
