package com.box.android.data.datasource.items.interceptors;

import com.box.android.data.datasource.ItemRemoteDataSource;
import com.box.android.data.datasource.gql.GQLRequestParser;
import com.box.android.data.utilities.GQLCacheHelper;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class GQLGetFolderItemsResponseInterceptor_Factory implements Factory<GQLGetFolderItemsResponseInterceptor> {
    private final Provider<GQLCacheHelper> gqlCacheHelperProvider;
    private final Provider<ItemRemoteDataSource> itemRemoteDataSourceProvider;
    private final Provider<Moshi> moshiProvider;
    private final Provider<GQLRequestParser> requestParserProvider;

    private GQLGetFolderItemsResponseInterceptor_Factory(Provider<ItemRemoteDataSource> itemRemoteDataSourceProvider, Provider<GQLRequestParser> requestParserProvider, Provider<Moshi> moshiProvider, Provider<GQLCacheHelper> gqlCacheHelperProvider) {
        this.itemRemoteDataSourceProvider = itemRemoteDataSourceProvider;
        this.requestParserProvider = requestParserProvider;
        this.moshiProvider = moshiProvider;
        this.gqlCacheHelperProvider = gqlCacheHelperProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GQLGetFolderItemsResponseInterceptor get() {
        return newInstance(this.itemRemoteDataSourceProvider.get(), this.requestParserProvider.get(), this.moshiProvider.get(), this.gqlCacheHelperProvider.get());
    }

    public static GQLGetFolderItemsResponseInterceptor_Factory create(Provider<ItemRemoteDataSource> itemRemoteDataSourceProvider, Provider<GQLRequestParser> requestParserProvider, Provider<Moshi> moshiProvider, Provider<GQLCacheHelper> gqlCacheHelperProvider) {
        return new GQLGetFolderItemsResponseInterceptor_Factory(itemRemoteDataSourceProvider, requestParserProvider, moshiProvider, gqlCacheHelperProvider);
    }

    public static GQLGetFolderItemsResponseInterceptor newInstance(ItemRemoteDataSource itemRemoteDataSource, GQLRequestParser requestParser, Moshi moshi, GQLCacheHelper gqlCacheHelper) {
        return new GQLGetFolderItemsResponseInterceptor(itemRemoteDataSource, requestParser, moshi, gqlCacheHelper);
    }
}
