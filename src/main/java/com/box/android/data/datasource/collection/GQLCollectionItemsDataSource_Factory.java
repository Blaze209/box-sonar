package com.box.android.data.datasource.collection;

import com.box.android.data.datasource.gql.BoxGraphQL;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class GQLCollectionItemsDataSource_Factory implements Factory<GQLCollectionItemsDataSource> {
    private final Provider<String> collectionIdProvider;
    private final Provider<BoxGraphQL> graphQLProvider;

    private GQLCollectionItemsDataSource_Factory(Provider<BoxGraphQL> graphQLProvider, Provider<String> collectionIdProvider) {
        this.graphQLProvider = graphQLProvider;
        this.collectionIdProvider = collectionIdProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GQLCollectionItemsDataSource get() {
        return newInstance(this.graphQLProvider.get(), this.collectionIdProvider.get());
    }

    public static GQLCollectionItemsDataSource_Factory create(Provider<BoxGraphQL> graphQLProvider, Provider<String> collectionIdProvider) {
        return new GQLCollectionItemsDataSource_Factory(graphQLProvider, collectionIdProvider);
    }

    public static GQLCollectionItemsDataSource newInstance(BoxGraphQL graphQL, String collectionId) {
        return new GQLCollectionItemsDataSource(graphQL, collectionId);
    }
}
