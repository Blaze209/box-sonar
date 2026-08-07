package com.box.android.data.datasource.files;

import com.box.android.data.api.requests.DownloadFileRequest;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes11.dex */
public final class DownloadFileRemoteDataSource_Factory implements Factory<DownloadFileRemoteDataSource> {
    private final Provider<DownloadFileRequest> downloadFileRequestProvider;
    private final Provider<CoroutineDispatcher> ioDispatcherProvider;
    private final Provider<Moshi> moshiProvider;

    private DownloadFileRemoteDataSource_Factory(Provider<DownloadFileRequest> downloadFileRequestProvider, Provider<Moshi> moshiProvider, Provider<CoroutineDispatcher> ioDispatcherProvider) {
        this.downloadFileRequestProvider = downloadFileRequestProvider;
        this.moshiProvider = moshiProvider;
        this.ioDispatcherProvider = ioDispatcherProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public DownloadFileRemoteDataSource get() {
        return newInstance(this.downloadFileRequestProvider.get(), this.moshiProvider.get(), this.ioDispatcherProvider.get());
    }

    public static DownloadFileRemoteDataSource_Factory create(Provider<DownloadFileRequest> downloadFileRequestProvider, Provider<Moshi> moshiProvider, Provider<CoroutineDispatcher> ioDispatcherProvider) {
        return new DownloadFileRemoteDataSource_Factory(downloadFileRequestProvider, moshiProvider, ioDispatcherProvider);
    }

    public static DownloadFileRemoteDataSource newInstance(DownloadFileRequest downloadFileRequest, Moshi moshi, CoroutineDispatcher ioDispatcher) {
        return new DownloadFileRemoteDataSource(downloadFileRequest, moshi, ioDispatcher);
    }
}
