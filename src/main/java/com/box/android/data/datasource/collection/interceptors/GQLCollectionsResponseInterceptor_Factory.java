package com.box.android.data.datasource.collection.interceptors;

import com.box.android.data.datasource.collection.CollectionsRemoteDataSource;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class GQLCollectionsResponseInterceptor_Factory implements Factory<GQLCollectionsResponseInterceptor> {
    private final Provider<CollectionsRemoteDataSource> collectionsRemoteDataSourceProvider;
    private final Provider<Moshi> moshiProvider;

    private GQLCollectionsResponseInterceptor_Factory(Provider<CollectionsRemoteDataSource> collectionsRemoteDataSourceProvider, Provider<Moshi> moshiProvider) {
        this.collectionsRemoteDataSourceProvider = collectionsRemoteDataSourceProvider;
        this.moshiProvider = moshiProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GQLCollectionsResponseInterceptor get() {
        return newInstance(this.collectionsRemoteDataSourceProvider.get(), this.moshiProvider.get());
    }

    public static GQLCollectionsResponseInterceptor_Factory create(Provider<CollectionsRemoteDataSource> collectionsRemoteDataSourceProvider, Provider<Moshi> moshiProvider) {
        return new GQLCollectionsResponseInterceptor_Factory(collectionsRemoteDataSourceProvider, moshiProvider);
    }

    public static GQLCollectionsResponseInterceptor newInstance(CollectionsRemoteDataSource collectionsRemoteDataSource, Moshi moshi) {
        return new GQLCollectionsResponseInterceptor(collectionsRemoteDataSource, moshi);
    }
}
