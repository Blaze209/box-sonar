package com.box.android.data.datasource;

import com.box.android.data.api.requests.PreviewDownloadRequest;
import com.box.android.domain.controller.IPreviewController;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes11.dex */
public final class PreviewDownloadRemoteDataSource_Factory implements Factory<PreviewDownloadRemoteDataSource> {
    private final Provider<CoroutineDispatcher> ioDispatcherProvider;
    private final Provider<IPreviewController> legacyPreviewControllerProvider;
    private final Provider<Moshi> moshiProvider;
    private final Provider<PreviewDownloadRequest> previewDownloadRequestProvider;

    private PreviewDownloadRemoteDataSource_Factory(Provider<PreviewDownloadRequest> previewDownloadRequestProvider, Provider<Moshi> moshiProvider, Provider<IPreviewController> legacyPreviewControllerProvider, Provider<CoroutineDispatcher> ioDispatcherProvider) {
        this.previewDownloadRequestProvider = previewDownloadRequestProvider;
        this.moshiProvider = moshiProvider;
        this.legacyPreviewControllerProvider = legacyPreviewControllerProvider;
        this.ioDispatcherProvider = ioDispatcherProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public PreviewDownloadRemoteDataSource get() {
        return newInstance(this.previewDownloadRequestProvider.get(), this.moshiProvider.get(), this.legacyPreviewControllerProvider.get(), this.ioDispatcherProvider.get());
    }

    public static PreviewDownloadRemoteDataSource_Factory create(Provider<PreviewDownloadRequest> previewDownloadRequestProvider, Provider<Moshi> moshiProvider, Provider<IPreviewController> legacyPreviewControllerProvider, Provider<CoroutineDispatcher> ioDispatcherProvider) {
        return new PreviewDownloadRemoteDataSource_Factory(previewDownloadRequestProvider, moshiProvider, legacyPreviewControllerProvider, ioDispatcherProvider);
    }

    public static PreviewDownloadRemoteDataSource newInstance(PreviewDownloadRequest previewDownloadRequest, Moshi moshi, IPreviewController legacyPreviewController, CoroutineDispatcher ioDispatcher) {
        return new PreviewDownloadRemoteDataSource(previewDownloadRequest, moshi, legacyPreviewController, ioDispatcher);
    }
}
