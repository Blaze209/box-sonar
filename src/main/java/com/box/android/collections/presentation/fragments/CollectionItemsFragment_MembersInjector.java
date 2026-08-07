package com.box.android.collections.presentation.fragments;

import com.box.android.base.cpl.ICollectionsHelper;
import com.box.android.base.presentation.ThumbnailManager;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContextManager;
import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class CollectionItemsFragment_MembersInjector implements MembersInjector<CollectionItemsFragment> {
    private final Provider<ICollectionsHelper> collectionsHelperProvider;
    private final Provider<FeatureFlips> featureFlipsProvider;
    private final Provider<ThumbnailManager> thumbnailManagerProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private CollectionItemsFragment_MembersInjector(Provider<IUserContextManager> provider, Provider<ThumbnailManager> provider2, Provider<FeatureFlips> provider3, Provider<ICollectionsHelper> provider4) {
        this.userContextManagerProvider = provider;
        this.thumbnailManagerProvider = provider2;
        this.featureFlipsProvider = provider3;
        this.collectionsHelperProvider = provider4;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(CollectionItemsFragment collectionItemsFragment) {
        injectUserContextManager(collectionItemsFragment, this.userContextManagerProvider.get());
        injectThumbnailManager(collectionItemsFragment, this.thumbnailManagerProvider.get());
        injectFeatureFlips(collectionItemsFragment, this.featureFlipsProvider.get());
        injectCollectionsHelper(collectionItemsFragment, this.collectionsHelperProvider.get());
    }

    public static MembersInjector<CollectionItemsFragment> create(Provider<IUserContextManager> provider, Provider<ThumbnailManager> provider2, Provider<FeatureFlips> provider3, Provider<ICollectionsHelper> provider4) {
        return new CollectionItemsFragment_MembersInjector(provider, provider2, provider3, provider4);
    }

    public static void injectUserContextManager(CollectionItemsFragment collectionItemsFragment, IUserContextManager iUserContextManager) {
        collectionItemsFragment.userContextManager = iUserContextManager;
    }

    public static void injectThumbnailManager(CollectionItemsFragment collectionItemsFragment, ThumbnailManager thumbnailManager) {
        collectionItemsFragment.thumbnailManager = thumbnailManager;
    }

    public static void injectFeatureFlips(CollectionItemsFragment collectionItemsFragment, FeatureFlips featureFlips) {
        collectionItemsFragment.featureFlips = featureFlips;
    }

    public static void injectCollectionsHelper(CollectionItemsFragment collectionItemsFragment, ICollectionsHelper iCollectionsHelper) {
        collectionItemsFragment.collectionsHelper = iCollectionsHelper;
    }
}
