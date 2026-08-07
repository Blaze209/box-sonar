package com.box.android.data.datasource.fileversions;

import com.box.android.data.api.requests.FileVersionRequest;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class FileVersionsRemoteDataSource_Factory implements Factory<FileVersionsRemoteDataSource> {
    private final Provider<FileVersionRequest> fileVersionRequestProvider;
    private final Provider<Moshi> moshiProvider;

    private FileVersionsRemoteDataSource_Factory(Provider<FileVersionRequest> fileVersionRequestProvider, Provider<Moshi> moshiProvider) {
        this.fileVersionRequestProvider = fileVersionRequestProvider;
        this.moshiProvider = moshiProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FileVersionsRemoteDataSource get() {
        return newInstance(this.fileVersionRequestProvider.get(), this.moshiProvider.get());
    }

    public static FileVersionsRemoteDataSource_Factory create(Provider<FileVersionRequest> fileVersionRequestProvider, Provider<Moshi> moshiProvider) {
        return new FileVersionsRemoteDataSource_Factory(fileVersionRequestProvider, moshiProvider);
    }

    public static FileVersionsRemoteDataSource newInstance(FileVersionRequest fileVersionRequest, Moshi moshi) {
        return new FileVersionsRemoteDataSource(fileVersionRequest, moshi);
    }
}
