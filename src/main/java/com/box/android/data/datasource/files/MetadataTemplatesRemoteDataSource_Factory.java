package com.box.android.data.datasource.files;

import com.box.android.data.api.requests.MetadataTemplatesRequest;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class MetadataTemplatesRemoteDataSource_Factory implements Factory<MetadataTemplatesRemoteDataSource> {
    private final Provider<MetadataTemplatesRequest> metadataTemplatesRequestProvider;
    private final Provider<Moshi> moshiProvider;

    private MetadataTemplatesRemoteDataSource_Factory(Provider<MetadataTemplatesRequest> metadataTemplatesRequestProvider, Provider<Moshi> moshiProvider) {
        this.metadataTemplatesRequestProvider = metadataTemplatesRequestProvider;
        this.moshiProvider = moshiProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public MetadataTemplatesRemoteDataSource get() {
        return newInstance(this.metadataTemplatesRequestProvider.get(), this.moshiProvider.get());
    }

    public static MetadataTemplatesRemoteDataSource_Factory create(Provider<MetadataTemplatesRequest> metadataTemplatesRequestProvider, Provider<Moshi> moshiProvider) {
        return new MetadataTemplatesRemoteDataSource_Factory(metadataTemplatesRequestProvider, moshiProvider);
    }

    public static MetadataTemplatesRemoteDataSource newInstance(MetadataTemplatesRequest metadataTemplatesRequest, Moshi moshi) {
        return new MetadataTemplatesRemoteDataSource(metadataTemplatesRequest, moshi);
    }
}
