package com.box.android.data.datasource.collection;

import com.box.android.data.api.requests.CollectionItemsRequest;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class CollectionItemsRemoteDataSource_Factory implements Factory<CollectionItemsRemoteDataSource> {
    private final Provider<CollectionItemsRequest> collectionItemsRequestProvider;
    private final Provider<Moshi> moshiProvider;

    private CollectionItemsRemoteDataSource_Factory(Provider<CollectionItemsRequest> collectionItemsRequestProvider, Provider<Moshi> moshiProvider) {
        this.collectionItemsRequestProvider = collectionItemsRequestProvider;
        this.moshiProvider = moshiProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CollectionItemsRemoteDataSource get() {
        return newInstance(this.collectionItemsRequestProvider.get(), this.moshiProvider.get());
    }

    public static CollectionItemsRemoteDataSource_Factory create(Provider<CollectionItemsRequest> collectionItemsRequestProvider, Provider<Moshi> moshiProvider) {
        return new CollectionItemsRemoteDataSource_Factory(collectionItemsRequestProvider, moshiProvider);
    }

    public static CollectionItemsRemoteDataSource newInstance(CollectionItemsRequest collectionItemsRequest, Moshi moshi) {
        return new CollectionItemsRemoteDataSource(collectionItemsRequest, moshi);
    }
}
