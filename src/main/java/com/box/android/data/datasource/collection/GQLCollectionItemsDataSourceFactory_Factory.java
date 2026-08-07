package com.box.android.data.datasource.collection;

import com.box.android.data.datasource.gql.BoxGraphQL;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class GQLCollectionItemsDataSourceFactory_Factory implements Factory<GQLCollectionItemsDataSourceFactory> {
    private final Provider<String> collectionIdProvider;
    private final Provider<BoxGraphQL> graphQLProvider;

    private GQLCollectionItemsDataSourceFactory_Factory(Provider<BoxGraphQL> graphQLProvider, Provider<String> collectionIdProvider) {
        this.graphQLProvider = graphQLProvider;
        this.collectionIdProvider = collectionIdProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GQLCollectionItemsDataSourceFactory get() {
        return newInstance(this.graphQLProvider.get(), this.collectionIdProvider.get());
    }

    public static GQLCollectionItemsDataSourceFactory_Factory create(Provider<BoxGraphQL> graphQLProvider, Provider<String> collectionIdProvider) {
        return new GQLCollectionItemsDataSourceFactory_Factory(graphQLProvider, collectionIdProvider);
    }

    public static GQLCollectionItemsDataSourceFactory newInstance(BoxGraphQL graphQL, String collectionId) {
        return new GQLCollectionItemsDataSourceFactory(graphQL, collectionId);
    }
}
