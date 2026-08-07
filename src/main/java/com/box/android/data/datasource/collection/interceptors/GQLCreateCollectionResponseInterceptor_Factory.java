package com.box.android.data.datasource.collection.interceptors;

import com.box.android.data.datasource.collection.CollectionsRemoteDataSource;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class GQLCreateCollectionResponseInterceptor_Factory implements Factory<GQLCreateCollectionResponseInterceptor> {
    private final Provider<CollectionsRemoteDataSource> collectionsRemoteDataSourceProvider;
    private final Provider<Moshi> moshiProvider;

    private GQLCreateCollectionResponseInterceptor_Factory(Provider<CollectionsRemoteDataSource> collectionsRemoteDataSourceProvider, Provider<Moshi> moshiProvider) {
        this.collectionsRemoteDataSourceProvider = collectionsRemoteDataSourceProvider;
        this.moshiProvider = moshiProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GQLCreateCollectionResponseInterceptor get() {
        return newInstance(this.collectionsRemoteDataSourceProvider.get(), this.moshiProvider.get());
    }

    public static GQLCreateCollectionResponseInterceptor_Factory create(Provider<CollectionsRemoteDataSource> collectionsRemoteDataSourceProvider, Provider<Moshi> moshiProvider) {
        return new GQLCreateCollectionResponseInterceptor_Factory(collectionsRemoteDataSourceProvider, moshiProvider);
    }

    public static GQLCreateCollectionResponseInterceptor newInstance(CollectionsRemoteDataSource collectionsRemoteDataSource, Moshi moshi) {
        return new GQLCreateCollectionResponseInterceptor(collectionsRemoteDataSource, moshi);
    }
}
