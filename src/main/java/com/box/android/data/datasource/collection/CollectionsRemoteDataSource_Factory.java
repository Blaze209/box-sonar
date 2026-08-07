package com.box.android.data.datasource.collection;

import com.box.android.data.api.requests.CollectionsRequest;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class CollectionsRemoteDataSource_Factory implements Factory<CollectionsRemoteDataSource> {
    private final Provider<CollectionsRequest> collectionsRequestProvider;
    private final Provider<Moshi> moshiProvider;

    private CollectionsRemoteDataSource_Factory(Provider<CollectionsRequest> collectionsRequestProvider, Provider<Moshi> moshiProvider) {
        this.collectionsRequestProvider = collectionsRequestProvider;
        this.moshiProvider = moshiProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CollectionsRemoteDataSource get() {
        return newInstance(this.collectionsRequestProvider.get(), this.moshiProvider.get());
    }

    public static CollectionsRemoteDataSource_Factory create(Provider<CollectionsRequest> collectionsRequestProvider, Provider<Moshi> moshiProvider) {
        return new CollectionsRemoteDataSource_Factory(collectionsRequestProvider, moshiProvider);
    }

    public static CollectionsRemoteDataSource newInstance(CollectionsRequest collectionsRequest, Moshi moshi) {
        return new CollectionsRemoteDataSource(collectionsRequest, moshi);
    }
}
