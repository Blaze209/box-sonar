package com.box.android.data.datasource.representations;

import com.box.android.data.api.requests.FileRepresentationsRequest;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class RepresentationsRemoteDataSource_Factory implements Factory<RepresentationsRemoteDataSource> {
    private final Provider<FileRepresentationsRequest> fileRepresentationsRequestProvider;
    private final Provider<Moshi> moshiProvider;

    private RepresentationsRemoteDataSource_Factory(Provider<FileRepresentationsRequest> fileRepresentationsRequestProvider, Provider<Moshi> moshiProvider) {
        this.fileRepresentationsRequestProvider = fileRepresentationsRequestProvider;
        this.moshiProvider = moshiProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public RepresentationsRemoteDataSource get() {
        return newInstance(this.fileRepresentationsRequestProvider.get(), this.moshiProvider.get());
    }

    public static RepresentationsRemoteDataSource_Factory create(Provider<FileRepresentationsRequest> fileRepresentationsRequestProvider, Provider<Moshi> moshiProvider) {
        return new RepresentationsRemoteDataSource_Factory(fileRepresentationsRequestProvider, moshiProvider);
    }

    public static RepresentationsRemoteDataSource newInstance(FileRepresentationsRequest fileRepresentationsRequest, Moshi moshi) {
        return new RepresentationsRemoteDataSource(fileRepresentationsRequest, moshi);
    }
}
