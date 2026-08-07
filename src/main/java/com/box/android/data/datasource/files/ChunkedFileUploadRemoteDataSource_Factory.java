package com.box.android.data.datasource.files;

import com.box.android.data.api.requests.ChunkedFileUploadRequest;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class ChunkedFileUploadRemoteDataSource_Factory implements Factory<ChunkedFileUploadRemoteDataSource> {
    private final Provider<ChunkedFileUploadRequest> chunkedFileUploadRequestProvider;
    private final Provider<Moshi> moshiProvider;

    private ChunkedFileUploadRemoteDataSource_Factory(Provider<ChunkedFileUploadRequest> chunkedFileUploadRequestProvider, Provider<Moshi> moshiProvider) {
        this.chunkedFileUploadRequestProvider = chunkedFileUploadRequestProvider;
        this.moshiProvider = moshiProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ChunkedFileUploadRemoteDataSource get() {
        return newInstance(this.chunkedFileUploadRequestProvider.get(), this.moshiProvider.get());
    }

    public static ChunkedFileUploadRemoteDataSource_Factory create(Provider<ChunkedFileUploadRequest> chunkedFileUploadRequestProvider, Provider<Moshi> moshiProvider) {
        return new ChunkedFileUploadRemoteDataSource_Factory(chunkedFileUploadRequestProvider, moshiProvider);
    }

    public static ChunkedFileUploadRemoteDataSource newInstance(ChunkedFileUploadRequest chunkedFileUploadRequest, Moshi moshi) {
        return new ChunkedFileUploadRemoteDataSource(chunkedFileUploadRequest, moshi);
    }
}
