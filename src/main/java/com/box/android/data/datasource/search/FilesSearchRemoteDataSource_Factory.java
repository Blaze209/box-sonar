package com.box.android.data.datasource.search;

import com.box.android.data.api.requests.FilesSearchRequest;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class FilesSearchRemoteDataSource_Factory implements Factory<FilesSearchRemoteDataSource> {
    private final Provider<FilesSearchRequest> filesSearchRequestProvider;
    private final Provider<Moshi> moshiProvider;

    private FilesSearchRemoteDataSource_Factory(Provider<FilesSearchRequest> filesSearchRequestProvider, Provider<Moshi> moshiProvider) {
        this.filesSearchRequestProvider = filesSearchRequestProvider;
        this.moshiProvider = moshiProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FilesSearchRemoteDataSource get() {
        return newInstance(this.filesSearchRequestProvider.get(), this.moshiProvider.get());
    }

    public static FilesSearchRemoteDataSource_Factory create(Provider<FilesSearchRequest> filesSearchRequestProvider, Provider<Moshi> moshiProvider) {
        return new FilesSearchRemoteDataSource_Factory(filesSearchRequestProvider, moshiProvider);
    }

    public static FilesSearchRemoteDataSource newInstance(FilesSearchRequest filesSearchRequest, Moshi moshi) {
        return new FilesSearchRemoteDataSource(filesSearchRequest, moshi);
    }
}
