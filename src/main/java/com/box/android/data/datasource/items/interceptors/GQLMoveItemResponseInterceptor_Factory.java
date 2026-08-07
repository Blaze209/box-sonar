package com.box.android.data.datasource.items.interceptors;

import com.box.android.data.datasource.ItemRemoteDataSource;
import com.box.android.data.datasource.gql.GQLRequestParser;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class GQLMoveItemResponseInterceptor_Factory implements Factory<GQLMoveItemResponseInterceptor> {
    private final Provider<ItemRemoteDataSource> itemRemoteDataSourceProvider;
    private final Provider<Moshi> moshiProvider;
    private final Provider<GQLRequestParser> requestParserProvider;

    private GQLMoveItemResponseInterceptor_Factory(Provider<ItemRemoteDataSource> itemRemoteDataSourceProvider, Provider<GQLRequestParser> requestParserProvider, Provider<Moshi> moshiProvider) {
        this.itemRemoteDataSourceProvider = itemRemoteDataSourceProvider;
        this.requestParserProvider = requestParserProvider;
        this.moshiProvider = moshiProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GQLMoveItemResponseInterceptor get() {
        return newInstance(this.itemRemoteDataSourceProvider.get(), this.requestParserProvider.get(), this.moshiProvider.get());
    }

    public static GQLMoveItemResponseInterceptor_Factory create(Provider<ItemRemoteDataSource> itemRemoteDataSourceProvider, Provider<GQLRequestParser> requestParserProvider, Provider<Moshi> moshiProvider) {
        return new GQLMoveItemResponseInterceptor_Factory(itemRemoteDataSourceProvider, requestParserProvider, moshiProvider);
    }

    public static GQLMoveItemResponseInterceptor newInstance(ItemRemoteDataSource itemRemoteDataSource, GQLRequestParser requestParser, Moshi moshi) {
        return new GQLMoveItemResponseInterceptor(itemRemoteDataSource, requestParser, moshi);
    }
}
