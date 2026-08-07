package com.box.android.data.datasource.collection;

import com.box.android.data.datasource.gql.BoxGraphQL;
import com.box.android.domain.models.CollectionModel;
import com.box.android.domain.models.CollectionType;
import dagger.internal.Factory;
import dagger.internal.Provider;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public final class GQLCollectionsDataSource_Factory implements Factory<GQLCollectionsDataSource> {
    private final Provider<List<? extends CollectionType>> collectionTypesProvider;
    private final Provider<Comparator<CollectionModel>> comparatorProvider;
    private final Provider<BoxGraphQL> graphQLProvider;

    private GQLCollectionsDataSource_Factory(Provider<BoxGraphQL> graphQLProvider, Provider<List<? extends CollectionType>> collectionTypesProvider, Provider<Comparator<CollectionModel>> comparatorProvider) {
        this.graphQLProvider = graphQLProvider;
        this.collectionTypesProvider = collectionTypesProvider;
        this.comparatorProvider = comparatorProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GQLCollectionsDataSource get() {
        return newInstance(this.graphQLProvider.get(), this.collectionTypesProvider.get(), this.comparatorProvider.get());
    }

    public static GQLCollectionsDataSource_Factory create(Provider<BoxGraphQL> graphQLProvider, Provider<List<? extends CollectionType>> collectionTypesProvider, Provider<Comparator<CollectionModel>> comparatorProvider) {
        return new GQLCollectionsDataSource_Factory(graphQLProvider, collectionTypesProvider, comparatorProvider);
    }

    public static GQLCollectionsDataSource newInstance(BoxGraphQL graphQL, List<? extends CollectionType> collectionTypes, Comparator<CollectionModel> comparator) {
        return new GQLCollectionsDataSource(graphQL, collectionTypes, comparator);
    }
}
