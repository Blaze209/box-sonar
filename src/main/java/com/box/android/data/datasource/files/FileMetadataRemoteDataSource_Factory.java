package com.box.android.data.datasource.files;

import com.box.android.data.api.requests.FileMetadataRequest;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class FileMetadataRemoteDataSource_Factory implements Factory<FileMetadataRemoteDataSource> {
    private final Provider<FileMetadataRequest> fileMetadataRequestProvider;
    private final Provider<Moshi> moshiProvider;

    private FileMetadataRemoteDataSource_Factory(Provider<FileMetadataRequest> fileMetadataRequestProvider, Provider<Moshi> moshiProvider) {
        this.fileMetadataRequestProvider = fileMetadataRequestProvider;
        this.moshiProvider = moshiProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FileMetadataRemoteDataSource get() {
        return newInstance(this.fileMetadataRequestProvider.get(), this.moshiProvider.get());
    }

    public static FileMetadataRemoteDataSource_Factory create(Provider<FileMetadataRequest> fileMetadataRequestProvider, Provider<Moshi> moshiProvider) {
        return new FileMetadataRemoteDataSource_Factory(fileMetadataRequestProvider, moshiProvider);
    }

    public static FileMetadataRemoteDataSource newInstance(FileMetadataRequest fileMetadataRequest, Moshi moshi) {
        return new FileMetadataRemoteDataSource(fileMetadataRequest, moshi);
    }
}
