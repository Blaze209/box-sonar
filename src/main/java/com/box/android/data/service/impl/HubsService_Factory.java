package com.box.android.data.service.impl;

import com.box.android.data.datasource.hubs.HubAssetLocalDataSource;
import com.box.android.data.datasource.hubs.HubAssetRemoteDataSource;
import com.box.android.data.datasource.hubs.HubsDataSource;
import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes11.dex */
public final class HubsService_Factory implements Factory<HubsService> {
    private final Provider<HubAssetLocalDataSource> hubAssetLocalDataSourceProvider;
    private final Provider<HubAssetRemoteDataSource> hubAssetRemoteDataSourceProvider;
    private final Provider<HubsDataSource> hubsDataSourceProvider;
    private final Provider<CoroutineDispatcher> ioDispatcherProvider;

    private HubsService_Factory(Provider<HubsDataSource> hubsDataSourceProvider, Provider<HubAssetLocalDataSource> hubAssetLocalDataSourceProvider, Provider<HubAssetRemoteDataSource> hubAssetRemoteDataSourceProvider, Provider<CoroutineDispatcher> ioDispatcherProvider) {
        this.hubsDataSourceProvider = hubsDataSourceProvider;
        this.hubAssetLocalDataSourceProvider = hubAssetLocalDataSourceProvider;
        this.hubAssetRemoteDataSourceProvider = hubAssetRemoteDataSourceProvider;
        this.ioDispatcherProvider = ioDispatcherProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public HubsService get() {
        return newInstance(this.hubsDataSourceProvider.get(), this.hubAssetLocalDataSourceProvider.get(), this.hubAssetRemoteDataSourceProvider.get(), this.ioDispatcherProvider.get());
    }

    public static HubsService_Factory create(Provider<HubsDataSource> hubsDataSourceProvider, Provider<HubAssetLocalDataSource> hubAssetLocalDataSourceProvider, Provider<HubAssetRemoteDataSource> hubAssetRemoteDataSourceProvider, Provider<CoroutineDispatcher> ioDispatcherProvider) {
        return new HubsService_Factory(hubsDataSourceProvider, hubAssetLocalDataSourceProvider, hubAssetRemoteDataSourceProvider, ioDispatcherProvider);
    }

    public static HubsService newInstance(HubsDataSource hubsDataSource, HubAssetLocalDataSource hubAssetLocalDataSource, HubAssetRemoteDataSource hubAssetRemoteDataSource, CoroutineDispatcher ioDispatcher) {
        return new HubsService(hubsDataSource, hubAssetLocalDataSource, hubAssetRemoteDataSource, ioDispatcher);
    }
}
