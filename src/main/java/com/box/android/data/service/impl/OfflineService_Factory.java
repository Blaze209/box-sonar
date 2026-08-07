package com.box.android.data.service.impl;

import com.box.android.coreservices.jobmanager.JobManager;
import com.box.android.coreservices.models.BoxModelOfflineManagerWrapper;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.services.IJobManagerBridgeService;
import com.box.android.domain.services.IJobService;
import com.box.android.domain.services.ILocalItemService;
import com.box.android.domain.services.IRemoteItemService;
import com.box.android.domain.services.IdMappingService;
import com.box.android.domain.utils.ItemSorter;
import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes11.dex */
public final class OfflineService_Factory implements Factory<OfflineService> {
    private final Provider<FeatureFlips> featureFlipsProvider;
    private final Provider<CoroutineDispatcher> ioDispatcherProvider;
    private final Provider<IdMappingService> itemIdMappingServiceProvider;
    private final Provider<ItemSorter> itemSorterProvider;
    private final Provider<IJobManagerBridgeService> jobManagerBridgeServiceProvider;
    private final Provider<JobManager> jobManagerProvider;
    private final Provider<IJobService> jobServiceProvider;
    private final Provider<ILocalItemService> localItemServiceProvider;
    private final Provider<BoxModelOfflineManagerWrapper> modelOfflineManagerWrapperProvider;
    private final Provider<IRemoteItemService> remoteItemServiceProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private OfflineService_Factory(Provider<JobManager> jobManagerProvider, Provider<IJobManagerBridgeService> jobManagerBridgeServiceProvider, Provider<IdMappingService> itemIdMappingServiceProvider, Provider<BoxModelOfflineManagerWrapper> modelOfflineManagerWrapperProvider, Provider<ILocalItemService> localItemServiceProvider, Provider<IRemoteItemService> remoteItemServiceProvider, Provider<IUserContextManager> userContextManagerProvider, Provider<IJobService> jobServiceProvider, Provider<FeatureFlips> featureFlipsProvider, Provider<ItemSorter> itemSorterProvider, Provider<CoroutineDispatcher> ioDispatcherProvider) {
        this.jobManagerProvider = jobManagerProvider;
        this.jobManagerBridgeServiceProvider = jobManagerBridgeServiceProvider;
        this.itemIdMappingServiceProvider = itemIdMappingServiceProvider;
        this.modelOfflineManagerWrapperProvider = modelOfflineManagerWrapperProvider;
        this.localItemServiceProvider = localItemServiceProvider;
        this.remoteItemServiceProvider = remoteItemServiceProvider;
        this.userContextManagerProvider = userContextManagerProvider;
        this.jobServiceProvider = jobServiceProvider;
        this.featureFlipsProvider = featureFlipsProvider;
        this.itemSorterProvider = itemSorterProvider;
        this.ioDispatcherProvider = ioDispatcherProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public OfflineService get() {
        return newInstance(this.jobManagerProvider.get(), this.jobManagerBridgeServiceProvider.get(), this.itemIdMappingServiceProvider.get(), this.modelOfflineManagerWrapperProvider.get(), this.localItemServiceProvider.get(), this.remoteItemServiceProvider.get(), this.userContextManagerProvider.get(), this.jobServiceProvider.get(), this.featureFlipsProvider.get(), this.itemSorterProvider.get(), this.ioDispatcherProvider.get());
    }

    public static OfflineService_Factory create(Provider<JobManager> jobManagerProvider, Provider<IJobManagerBridgeService> jobManagerBridgeServiceProvider, Provider<IdMappingService> itemIdMappingServiceProvider, Provider<BoxModelOfflineManagerWrapper> modelOfflineManagerWrapperProvider, Provider<ILocalItemService> localItemServiceProvider, Provider<IRemoteItemService> remoteItemServiceProvider, Provider<IUserContextManager> userContextManagerProvider, Provider<IJobService> jobServiceProvider, Provider<FeatureFlips> featureFlipsProvider, Provider<ItemSorter> itemSorterProvider, Provider<CoroutineDispatcher> ioDispatcherProvider) {
        return new OfflineService_Factory(jobManagerProvider, jobManagerBridgeServiceProvider, itemIdMappingServiceProvider, modelOfflineManagerWrapperProvider, localItemServiceProvider, remoteItemServiceProvider, userContextManagerProvider, jobServiceProvider, featureFlipsProvider, itemSorterProvider, ioDispatcherProvider);
    }

    public static OfflineService newInstance(JobManager jobManager, IJobManagerBridgeService jobManagerBridgeService, IdMappingService itemIdMappingService, BoxModelOfflineManagerWrapper modelOfflineManagerWrapper, ILocalItemService localItemService, IRemoteItemService remoteItemService, IUserContextManager userContextManager, IJobService jobService, FeatureFlips featureFlips, ItemSorter itemSorter, CoroutineDispatcher ioDispatcher) {
        return new OfflineService(jobManager, jobManagerBridgeService, itemIdMappingService, modelOfflineManagerWrapper, localItemService, remoteItemService, userContextManager, jobService, featureFlips, itemSorter, ioDispatcher);
    }
}
