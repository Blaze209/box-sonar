package com.box.android.data.datasource.collection.interceptors;

import com.box.android.data.datasource.collection.CollectionItemsRemoteDataSource;
import com.box.android.data.datasource.gql.GQLRequestParser;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class GQLRemoveCollectionItemResponseInterceptor_Factory implements Factory<GQLRemoveCollectionItemResponseInterceptor> {
    private final Provider<CollectionItemsRemoteDataSource> collectionItemsRemoteDataSourceProvider;
    private final Provider<Moshi> moshiProvider;
    private final Provider<GQLRequestParser> requestParserProvider;

    private GQLRemoveCollectionItemResponseInterceptor_Factory(Provider<CollectionItemsRemoteDataSource> collectionItemsRemoteDataSourceProvider, Provider<GQLRequestParser> requestParserProvider, Provider<Moshi> moshiProvider) {
        this.collectionItemsRemoteDataSourceProvider = collectionItemsRemoteDataSourceProvider;
        this.requestParserProvider = requestParserProvider;
        this.moshiProvider = moshiProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GQLRemoveCollectionItemResponseInterceptor get() {
        return newInstance(this.collectionItemsRemoteDataSourceProvider.get(), this.requestParserProvider.get(), this.moshiProvider.get());
    }

    public static GQLRemoveCollectionItemResponseInterceptor_Factory create(Provider<CollectionItemsRemoteDataSource> collectionItemsRemoteDataSourceProvider, Provider<GQLRequestParser> requestParserProvider, Provider<Moshi> moshiProvider) {
        return new GQLRemoveCollectionItemResponseInterceptor_Factory(collectionItemsRemoteDataSourceProvider, requestParserProvider, moshiProvider);
    }

    public static GQLRemoveCollectionItemResponseInterceptor newInstance(CollectionItemsRemoteDataSource collectionItemsRemoteDataSource, GQLRequestParser requestParser, Moshi moshi) {
        return new GQLRemoveCollectionItemResponseInterceptor(collectionItemsRemoteDataSource, requestParser, moshi);
    }
}
