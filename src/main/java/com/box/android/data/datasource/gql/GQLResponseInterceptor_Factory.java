package com.box.android.data.datasource.gql;

import com.box.android.data.datasource.collection.interceptors.GQLCollectionItemsResponseInterceptor;
import com.box.android.data.datasource.collection.interceptors.GQLCollectionsResponseInterceptor;
import com.box.android.data.datasource.collection.interceptors.GQLCollectionsWithItemResponseInterceptor;
import com.box.android.data.datasource.collection.interceptors.GQLCreateCollectionItemResponseInterceptor;
import com.box.android.data.datasource.collection.interceptors.GQLCreateCollectionResponseInterceptor;
import com.box.android.data.datasource.collection.interceptors.GQLRemoveCollectionItemResponseInterceptor;
import com.box.android.data.datasource.items.interceptors.GQLCopyItemResponseInterceptor;
import com.box.android.data.datasource.items.interceptors.GQLCreateFolderResponseInterceptor;
import com.box.android.data.datasource.items.interceptors.GQLGetFolderItemsResponseInterceptor;
import com.box.android.data.datasource.items.interceptors.GQLGetFolderMiniResponseInterceptor;
import com.box.android.data.datasource.items.interceptors.GQLGetFolderMiniWithParentResponseInterceptor;
import com.box.android.data.datasource.items.interceptors.GQLGetItemResponseInterceptor;
import com.box.android.data.datasource.items.interceptors.GQLGetItemWithWatermarkDataResponseInterceptor;
import com.box.android.data.datasource.items.interceptors.GQLMoveItemResponseInterceptor;
import com.box.android.domain.configuration.FeatureFlips;
import com.squareup.moshi.Moshi;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class GQLResponseInterceptor_Factory implements Factory<GQLResponseInterceptor> {
    private final Provider<GQLApolloClientConfigurator> apolloClientConfiguratorProvider;
    private final Provider<GQLCollectionItemsResponseInterceptor> collectionItemsResponseInterceptorProvider;
    private final Provider<GQLCollectionsResponseInterceptor> collectionsResponseInterceptorProvider;
    private final Provider<GQLCollectionsWithItemResponseInterceptor> collectionsWithItemResponseInterceptorProvider;
    private final Provider<GQLCopyItemResponseInterceptor> copyItemResponseInterceptorProvider;
    private final Provider<GQLCreateCollectionItemResponseInterceptor> createCollectionItemResponseInterceptorProvider;
    private final Provider<GQLCreateCollectionResponseInterceptor> createCollectionResponseInterceptorProvider;
    private final Provider<GQLCreateFolderResponseInterceptor> createFolderResponseInterceptorProvider;
    private final Provider<FeatureFlips> featureFlipsProvider;
    private final Provider<GQLGetFolderItemsResponseInterceptor> gqlGetFolderItemsResponseInterceptorProvider;
    private final Provider<GQLGetFolderMiniResponseInterceptor> gqlGetFolderMiniResponseInterceptorProvider;
    private final Provider<GQLGetFolderMiniWithParentResponseInterceptor> gqlGetFolderMiniWithParentResponseInterceptorProvider;
    private final Provider<GQLGetItemResponseInterceptor> gqlGetItemResponseInterceptorProvider;
    private final Provider<GQLGetItemWithWatermarkDataResponseInterceptor> gqlGetItemWithWatermarkDataResponseInterceptorProvider;
    private final Provider<Moshi> moshiProvider;
    private final Provider<GQLMoveItemResponseInterceptor> moveItemResponseInterceptorProvider;
    private final Provider<GQLRemoveCollectionItemResponseInterceptor> removeCollectionItemResponseInterceptorProvider;
    private final Provider<GQLRequestParser> requestParserProvider;

    private GQLResponseInterceptor_Factory(Provider<GQLApolloClientConfigurator> apolloClientConfiguratorProvider, Provider<GQLRequestParser> requestParserProvider, Provider<Moshi> moshiProvider, Provider<FeatureFlips> featureFlipsProvider, Provider<GQLCollectionsResponseInterceptor> collectionsResponseInterceptorProvider, Provider<GQLCollectionItemsResponseInterceptor> collectionItemsResponseInterceptorProvider, Provider<GQLCollectionsWithItemResponseInterceptor> collectionsWithItemResponseInterceptorProvider, Provider<GQLCreateCollectionResponseInterceptor> createCollectionResponseInterceptorProvider, Provider<GQLRemoveCollectionItemResponseInterceptor> removeCollectionItemResponseInterceptorProvider, Provider<GQLCreateCollectionItemResponseInterceptor> createCollectionItemResponseInterceptorProvider, Provider<GQLCreateFolderResponseInterceptor> createFolderResponseInterceptorProvider, Provider<GQLGetFolderItemsResponseInterceptor> gqlGetFolderItemsResponseInterceptorProvider, Provider<GQLCopyItemResponseInterceptor> copyItemResponseInterceptorProvider, Provider<GQLMoveItemResponseInterceptor> moveItemResponseInterceptorProvider, Provider<GQLGetItemResponseInterceptor> gqlGetItemResponseInterceptorProvider, Provider<GQLGetItemWithWatermarkDataResponseInterceptor> gqlGetItemWithWatermarkDataResponseInterceptorProvider, Provider<GQLGetFolderMiniResponseInterceptor> gqlGetFolderMiniResponseInterceptorProvider, Provider<GQLGetFolderMiniWithParentResponseInterceptor> gqlGetFolderMiniWithParentResponseInterceptorProvider) {
        this.apolloClientConfiguratorProvider = apolloClientConfiguratorProvider;
        this.requestParserProvider = requestParserProvider;
        this.moshiProvider = moshiProvider;
        this.featureFlipsProvider = featureFlipsProvider;
        this.collectionsResponseInterceptorProvider = collectionsResponseInterceptorProvider;
        this.collectionItemsResponseInterceptorProvider = collectionItemsResponseInterceptorProvider;
        this.collectionsWithItemResponseInterceptorProvider = collectionsWithItemResponseInterceptorProvider;
        this.createCollectionResponseInterceptorProvider = createCollectionResponseInterceptorProvider;
        this.removeCollectionItemResponseInterceptorProvider = removeCollectionItemResponseInterceptorProvider;
        this.createCollectionItemResponseInterceptorProvider = createCollectionItemResponseInterceptorProvider;
        this.createFolderResponseInterceptorProvider = createFolderResponseInterceptorProvider;
        this.gqlGetFolderItemsResponseInterceptorProvider = gqlGetFolderItemsResponseInterceptorProvider;
        this.copyItemResponseInterceptorProvider = copyItemResponseInterceptorProvider;
        this.moveItemResponseInterceptorProvider = moveItemResponseInterceptorProvider;
        this.gqlGetItemResponseInterceptorProvider = gqlGetItemResponseInterceptorProvider;
        this.gqlGetItemWithWatermarkDataResponseInterceptorProvider = gqlGetItemWithWatermarkDataResponseInterceptorProvider;
        this.gqlGetFolderMiniResponseInterceptorProvider = gqlGetFolderMiniResponseInterceptorProvider;
        this.gqlGetFolderMiniWithParentResponseInterceptorProvider = gqlGetFolderMiniWithParentResponseInterceptorProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GQLResponseInterceptor get() {
        return newInstance(this.apolloClientConfiguratorProvider.get(), this.requestParserProvider.get(), this.moshiProvider.get(), this.featureFlipsProvider.get(), DoubleCheck.lazy((Provider) this.collectionsResponseInterceptorProvider), DoubleCheck.lazy((Provider) this.collectionItemsResponseInterceptorProvider), DoubleCheck.lazy((Provider) this.collectionsWithItemResponseInterceptorProvider), DoubleCheck.lazy((Provider) this.createCollectionResponseInterceptorProvider), DoubleCheck.lazy((Provider) this.removeCollectionItemResponseInterceptorProvider), DoubleCheck.lazy((Provider) this.createCollectionItemResponseInterceptorProvider), DoubleCheck.lazy((Provider) this.createFolderResponseInterceptorProvider), DoubleCheck.lazy((Provider) this.gqlGetFolderItemsResponseInterceptorProvider), DoubleCheck.lazy((Provider) this.copyItemResponseInterceptorProvider), DoubleCheck.lazy((Provider) this.moveItemResponseInterceptorProvider), DoubleCheck.lazy((Provider) this.gqlGetItemResponseInterceptorProvider), DoubleCheck.lazy((Provider) this.gqlGetItemWithWatermarkDataResponseInterceptorProvider), DoubleCheck.lazy((Provider) this.gqlGetFolderMiniResponseInterceptorProvider), DoubleCheck.lazy((Provider) this.gqlGetFolderMiniWithParentResponseInterceptorProvider));
    }

    public static GQLResponseInterceptor_Factory create(Provider<GQLApolloClientConfigurator> apolloClientConfiguratorProvider, Provider<GQLRequestParser> requestParserProvider, Provider<Moshi> moshiProvider, Provider<FeatureFlips> featureFlipsProvider, Provider<GQLCollectionsResponseInterceptor> collectionsResponseInterceptorProvider, Provider<GQLCollectionItemsResponseInterceptor> collectionItemsResponseInterceptorProvider, Provider<GQLCollectionsWithItemResponseInterceptor> collectionsWithItemResponseInterceptorProvider, Provider<GQLCreateCollectionResponseInterceptor> createCollectionResponseInterceptorProvider, Provider<GQLRemoveCollectionItemResponseInterceptor> removeCollectionItemResponseInterceptorProvider, Provider<GQLCreateCollectionItemResponseInterceptor> createCollectionItemResponseInterceptorProvider, Provider<GQLCreateFolderResponseInterceptor> createFolderResponseInterceptorProvider, Provider<GQLGetFolderItemsResponseInterceptor> gqlGetFolderItemsResponseInterceptorProvider, Provider<GQLCopyItemResponseInterceptor> copyItemResponseInterceptorProvider, Provider<GQLMoveItemResponseInterceptor> moveItemResponseInterceptorProvider, Provider<GQLGetItemResponseInterceptor> gqlGetItemResponseInterceptorProvider, Provider<GQLGetItemWithWatermarkDataResponseInterceptor> gqlGetItemWithWatermarkDataResponseInterceptorProvider, Provider<GQLGetFolderMiniResponseInterceptor> gqlGetFolderMiniResponseInterceptorProvider, Provider<GQLGetFolderMiniWithParentResponseInterceptor> gqlGetFolderMiniWithParentResponseInterceptorProvider) {
        return new GQLResponseInterceptor_Factory(apolloClientConfiguratorProvider, requestParserProvider, moshiProvider, featureFlipsProvider, collectionsResponseInterceptorProvider, collectionItemsResponseInterceptorProvider, collectionsWithItemResponseInterceptorProvider, createCollectionResponseInterceptorProvider, removeCollectionItemResponseInterceptorProvider, createCollectionItemResponseInterceptorProvider, createFolderResponseInterceptorProvider, gqlGetFolderItemsResponseInterceptorProvider, copyItemResponseInterceptorProvider, moveItemResponseInterceptorProvider, gqlGetItemResponseInterceptorProvider, gqlGetItemWithWatermarkDataResponseInterceptorProvider, gqlGetFolderMiniResponseInterceptorProvider, gqlGetFolderMiniWithParentResponseInterceptorProvider);
    }

    public static GQLResponseInterceptor newInstance(GQLApolloClientConfigurator apolloClientConfigurator, GQLRequestParser requestParser, Moshi moshi, FeatureFlips featureFlips, Lazy<GQLCollectionsResponseInterceptor> collectionsResponseInterceptor, Lazy<GQLCollectionItemsResponseInterceptor> collectionItemsResponseInterceptor, Lazy<GQLCollectionsWithItemResponseInterceptor> collectionsWithItemResponseInterceptor, Lazy<GQLCreateCollectionResponseInterceptor> createCollectionResponseInterceptor, Lazy<GQLRemoveCollectionItemResponseInterceptor> removeCollectionItemResponseInterceptor, Lazy<GQLCreateCollectionItemResponseInterceptor> createCollectionItemResponseInterceptor, Lazy<GQLCreateFolderResponseInterceptor> createFolderResponseInterceptor, Lazy<GQLGetFolderItemsResponseInterceptor> gqlGetFolderItemsResponseInterceptor, Lazy<GQLCopyItemResponseInterceptor> copyItemResponseInterceptor, Lazy<GQLMoveItemResponseInterceptor> moveItemResponseInterceptor, Lazy<GQLGetItemResponseInterceptor> gqlGetItemResponseInterceptor, Lazy<GQLGetItemWithWatermarkDataResponseInterceptor> gqlGetItemWithWatermarkDataResponseInterceptor, Lazy<GQLGetFolderMiniResponseInterceptor> gqlGetFolderMiniResponseInterceptor, Lazy<GQLGetFolderMiniWithParentResponseInterceptor> gqlGetFolderMiniWithParentResponseInterceptor) {
        return new GQLResponseInterceptor(apolloClientConfigurator, requestParser, moshi, featureFlips, collectionsResponseInterceptor, collectionItemsResponseInterceptor, collectionsWithItemResponseInterceptor, createCollectionResponseInterceptor, removeCollectionItemResponseInterceptor, createCollectionItemResponseInterceptor, createFolderResponseInterceptor, gqlGetFolderItemsResponseInterceptor, copyItemResponseInterceptor, moveItemResponseInterceptor, gqlGetItemResponseInterceptor, gqlGetItemWithWatermarkDataResponseInterceptor, gqlGetFolderMiniResponseInterceptor, gqlGetFolderMiniWithParentResponseInterceptor);
    }
}
