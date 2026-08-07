package com.box.android.data.service.impl;

import com.box.android.data.datasource.files.DownloadFileRemoteDataSource;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DownloadFileService_Factory implements Factory<DownloadFileService> {
    private final Provider<DownloadFileRemoteDataSource> downloadFileRemoteDataSourceProvider;

    private DownloadFileService_Factory(Provider<DownloadFileRemoteDataSource> downloadFileRemoteDataSourceProvider) {
        this.downloadFileRemoteDataSourceProvider = downloadFileRemoteDataSourceProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public DownloadFileService get() {
        return newInstance(this.downloadFileRemoteDataSourceProvider.get());
    }

    public static DownloadFileService_Factory create(Provider<DownloadFileRemoteDataSource> downloadFileRemoteDataSourceProvider) {
        return new DownloadFileService_Factory(downloadFileRemoteDataSourceProvider);
    }

    public static DownloadFileService newInstance(DownloadFileRemoteDataSource downloadFileRemoteDataSource) {
        return new DownloadFileService(downloadFileRemoteDataSource);
    }
}
