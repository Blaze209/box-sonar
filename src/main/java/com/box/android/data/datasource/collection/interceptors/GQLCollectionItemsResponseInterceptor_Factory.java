package com.box.android.data.datasource.collection.interceptors;

import com.box.android.data.datasource.collection.CollectionItemsRemoteDataSource;
import com.box.android.data.datasource.gql.GQLRequestParser;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class GQLCollectionItemsResponseInterceptor_Factory implements Factory<GQLCollectionItemsResponseInterceptor> {
    private final Provider<CollectionItemsRemoteDataSource> collectionItemsRemoteDataSourceProvider;
    private final Provider<Moshi> moshiProvider;
    private final Provider<GQLRequestParser> requestParserProvider;

    private GQLCollectionItemsResponseInterceptor_Factory(Provider<CollectionItemsRemoteDataSource> collectionItemsRemoteDataSourceProvider, Provider<GQLRequestParser> requestParserProvider, Provider<Moshi> moshiProvider) {
        this.collectionItemsRemoteDataSourceProvider = collectionItemsRemoteDataSourceProvider;
        this.requestParserProvider = requestParserProvider;
        this.moshiProvider = moshiProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GQLCollectionItemsResponseInterceptor get() {
        return newInstance(this.collectionItemsRemoteDataSourceProvider.get(), this.requestParserProvider.get(), this.moshiProvider.get());
    }

    public static GQLCollectionItemsResponseInterceptor_Factory create(Provider<CollectionItemsRemoteDataSource> collectionItemsRemoteDataSourceProvider, Provider<GQLRequestParser> requestParserProvider, Provider<Moshi> moshiProvider) {
        return new GQLCollectionItemsResponseInterceptor_Factory(collectionItemsRemoteDataSourceProvider, requestParserProvider, moshiProvider);
    }

    public static GQLCollectionItemsResponseInterceptor newInstance(CollectionItemsRemoteDataSource collectionItemsRemoteDataSource, GQLRequestParser requestParser, Moshi moshi) {
        return new GQLCollectionItemsResponseInterceptor(collectionItemsRemoteDataSource, requestParser, moshi);
    }
}
