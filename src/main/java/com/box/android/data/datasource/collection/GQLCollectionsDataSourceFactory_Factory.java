package com.box.android.data.datasource.collection;

import com.box.android.data.datasource.gql.BoxGraphQL;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.models.CollectionModel;
import com.box.android.domain.models.CollectionType;
import dagger.internal.Factory;
import dagger.internal.Provider;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public final class GQLCollectionsDataSourceFactory_Factory implements Factory<GQLCollectionsDataSourceFactory> {
    private final Provider<List<? extends CollectionType>> collectionTypesProvider;
    private final Provider<Comparator<CollectionModel>> comparatorProvider;
    private final Provider<BoxGraphQL> graphQLProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private GQLCollectionsDataSourceFactory_Factory(Provider<BoxGraphQL> graphQLProvider, Provider<IUserContextManager> userContextManagerProvider, Provider<List<? extends CollectionType>> collectionTypesProvider, Provider<Comparator<CollectionModel>> comparatorProvider) {
        this.graphQLProvider = graphQLProvider;
        this.userContextManagerProvider = userContextManagerProvider;
        this.collectionTypesProvider = collectionTypesProvider;
        this.comparatorProvider = comparatorProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GQLCollectionsDataSourceFactory get() {
        return newInstance(this.graphQLProvider.get(), this.userContextManagerProvider.get(), this.collectionTypesProvider.get(), this.comparatorProvider.get());
    }

    public static GQLCollectionsDataSourceFactory_Factory create(Provider<BoxGraphQL> graphQLProvider, Provider<IUserContextManager> userContextManagerProvider, Provider<List<? extends CollectionType>> collectionTypesProvider, Provider<Comparator<CollectionModel>> comparatorProvider) {
        return new GQLCollectionsDataSourceFactory_Factory(graphQLProvider, userContextManagerProvider, collectionTypesProvider, comparatorProvider);
    }

    public static GQLCollectionsDataSourceFactory newInstance(BoxGraphQL graphQL, IUserContextManager userContextManager, List<? extends CollectionType> collectionTypes, Comparator<CollectionModel> comparator) {
        return new GQLCollectionsDataSourceFactory(graphQL, userContextManager, collectionTypes, comparator);
    }
}
