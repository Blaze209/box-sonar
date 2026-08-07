package com.box.android.data.datasource.items.interceptors;

import com.box.android.data.datasource.ItemRemoteDataSource;
import com.box.android.data.datasource.gql.GQLRequestParser;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class GQLGetItemResponseInterceptor_Factory implements Factory<GQLGetItemResponseInterceptor> {
    private final Provider<ItemRemoteDataSource> itemRemoteDataSourceProvider;
    private final Provider<Moshi> moshiProvider;
    private final Provider<GQLRequestParser> requestParserProvider;

    private GQLGetItemResponseInterceptor_Factory(Provider<ItemRemoteDataSource> itemRemoteDataSourceProvider, Provider<GQLRequestParser> requestParserProvider, Provider<Moshi> moshiProvider) {
        this.itemRemoteDataSourceProvider = itemRemoteDataSourceProvider;
        this.requestParserProvider = requestParserProvider;
        this.moshiProvider = moshiProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GQLGetItemResponseInterceptor get() {
        return newInstance(this.itemRemoteDataSourceProvider.get(), this.requestParserProvider.get(), this.moshiProvider.get());
    }

    public static GQLGetItemResponseInterceptor_Factory create(Provider<ItemRemoteDataSource> itemRemoteDataSourceProvider, Provider<GQLRequestParser> requestParserProvider, Provider<Moshi> moshiProvider) {
        return new GQLGetItemResponseInterceptor_Factory(itemRemoteDataSourceProvider, requestParserProvider, moshiProvider);
    }

    public static GQLGetItemResponseInterceptor newInstance(ItemRemoteDataSource itemRemoteDataSource, GQLRequestParser requestParser, Moshi moshi) {
        return new GQLGetItemResponseInterceptor(itemRemoteDataSource, requestParser, moshi);
    }
}
