package com.box.android.data.service.impl;

import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.data.datasource.LegacyCacheDataSource;
import com.box.android.data.datasource.localItems.LocalItemsDataSource;
import com.box.android.data.jobs.JobService;
import com.box.android.data.utilities.LocalItemServiceItemsCreator;
import com.box.android.domain.identity.IUserContextManager;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes11.dex */
public final class LocalItemService_Factory implements Factory<LocalItemService> {
    private final Provider<IBaseModelController> baseModelControllerProvider;
    private final Provider<CoroutineDispatcher> coroutineDispatcherProvider;
    private final Provider<BoxExtendedApiFile> fileApiProvider;
    private final Provider<ItemIdMappingService> idMappingServiceProvider;
    private final Provider<LocalItemServiceItemsCreator> itemsCreatorProvider;
    private final Provider<JobService> jobServiceProvider;
    private final Provider<LegacyCacheDataSource> legacyCacheDataSourceProvider;
    private final Provider<LocalItemsDataSource> localItemsDataSourceProvider;
    private final Provider<RemoteItemService> remoteItemServiceProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private LocalItemService_Factory(Provider<LocalItemsDataSource> localItemsDataSourceProvider, Provider<LocalItemServiceItemsCreator> itemsCreatorProvider, Provider<LegacyCacheDataSource> legacyCacheDataSourceProvider, Provider<JobService> jobServiceProvider, Provider<RemoteItemService> remoteItemServiceProvider, Provider<ItemIdMappingService> idMappingServiceProvider, Provider<IBaseModelController> baseModelControllerProvider, Provider<BoxExtendedApiFile> fileApiProvider, Provider<IUserContextManager> userContextManagerProvider, Provider<CoroutineDispatcher> coroutineDispatcherProvider) {
        this.localItemsDataSourceProvider = localItemsDataSourceProvider;
        this.itemsCreatorProvider = itemsCreatorProvider;
        this.legacyCacheDataSourceProvider = legacyCacheDataSourceProvider;
        this.jobServiceProvider = jobServiceProvider;
        this.remoteItemServiceProvider = remoteItemServiceProvider;
        this.idMappingServiceProvider = idMappingServiceProvider;
        this.baseModelControllerProvider = baseModelControllerProvider;
        this.fileApiProvider = fileApiProvider;
        this.userContextManagerProvider = userContextManagerProvider;
        this.coroutineDispatcherProvider = coroutineDispatcherProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public LocalItemService get() {
        return newInstance(this.localItemsDataSourceProvider.get(), this.itemsCreatorProvider.get(), this.legacyCacheDataSourceProvider.get(), this.jobServiceProvider.get(), this.remoteItemServiceProvider.get(), this.idMappingServiceProvider.get(), this.baseModelControllerProvider.get(), this.fileApiProvider.get(), this.userContextManagerProvider.get(), this.coroutineDispatcherProvider.get());
    }

    public static LocalItemService_Factory create(Provider<LocalItemsDataSource> localItemsDataSourceProvider, Provider<LocalItemServiceItemsCreator> itemsCreatorProvider, Provider<LegacyCacheDataSource> legacyCacheDataSourceProvider, Provider<JobService> jobServiceProvider, Provider<RemoteItemService> remoteItemServiceProvider, Provider<ItemIdMappingService> idMappingServiceProvider, Provider<IBaseModelController> baseModelControllerProvider, Provider<BoxExtendedApiFile> fileApiProvider, Provider<IUserContextManager> userContextManagerProvider, Provider<CoroutineDispatcher> coroutineDispatcherProvider) {
        return new LocalItemService_Factory(localItemsDataSourceProvider, itemsCreatorProvider, legacyCacheDataSourceProvider, jobServiceProvider, remoteItemServiceProvider, idMappingServiceProvider, baseModelControllerProvider, fileApiProvider, userContextManagerProvider, coroutineDispatcherProvider);
    }

    public static LocalItemService newInstance(LocalItemsDataSource localItemsDataSource, LocalItemServiceItemsCreator itemsCreator, LegacyCacheDataSource legacyCacheDataSource, JobService jobService, RemoteItemService remoteItemService, ItemIdMappingService idMappingService, IBaseModelController baseModelController, BoxExtendedApiFile fileApi, IUserContextManager userContextManager, CoroutineDispatcher coroutineDispatcher) {
        return new LocalItemService(localItemsDataSource, itemsCreator, legacyCacheDataSource, jobService, remoteItemService, idMappingService, baseModelController, fileApi, userContextManager, coroutineDispatcher);
    }
}
