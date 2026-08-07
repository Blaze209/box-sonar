package com.box.android.data.datasource.hubs;

import com.box.android.data.api.requests.HubAssetDownloadRequest;
import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes11.dex */
public final class HubAssetRemoteDataSource_Factory implements Factory<HubAssetRemoteDataSource> {
    private final Provider<HubAssetDownloadRequest> hubAssetDownloadRequestProvider;
    private final Provider<CoroutineDispatcher> ioDispatcherProvider;

    private HubAssetRemoteDataSource_Factory(Provider<HubAssetDownloadRequest> hubAssetDownloadRequestProvider, Provider<CoroutineDispatcher> ioDispatcherProvider) {
        this.hubAssetDownloadRequestProvider = hubAssetDownloadRequestProvider;
        this.ioDispatcherProvider = ioDispatcherProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public HubAssetRemoteDataSource get() {
        return newInstance(this.hubAssetDownloadRequestProvider.get(), this.ioDispatcherProvider.get());
    }

    public static HubAssetRemoteDataSource_Factory create(Provider<HubAssetDownloadRequest> hubAssetDownloadRequestProvider, Provider<CoroutineDispatcher> ioDispatcherProvider) {
        return new HubAssetRemoteDataSource_Factory(hubAssetDownloadRequestProvider, ioDispatcherProvider);
    }

    public static HubAssetRemoteDataSource newInstance(HubAssetDownloadRequest hubAssetDownloadRequest, CoroutineDispatcher ioDispatcher) {
        return new HubAssetRemoteDataSource(hubAssetDownloadRequest, ioDispatcher);
    }
}
