package com.box.android.collections.presentation.fragments;

import com.box.android.base.presentation.ThumbnailManager;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContextManager;
import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class FavoritesCollectionItemsFragment_MembersInjector implements MembersInjector<FavoritesCollectionItemsFragment> {
    private final Provider<FeatureFlips> featureFlipsProvider;
    private final Provider<ThumbnailManager> thumbnailManagerProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private FavoritesCollectionItemsFragment_MembersInjector(Provider<IUserContextManager> provider, Provider<ThumbnailManager> provider2, Provider<FeatureFlips> provider3) {
        this.userContextManagerProvider = provider;
        this.thumbnailManagerProvider = provider2;
        this.featureFlipsProvider = provider3;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(FavoritesCollectionItemsFragment favoritesCollectionItemsFragment) {
        injectUserContextManager(favoritesCollectionItemsFragment, this.userContextManagerProvider.get());
        injectThumbnailManager(favoritesCollectionItemsFragment, this.thumbnailManagerProvider.get());
        injectFeatureFlips(favoritesCollectionItemsFragment, this.featureFlipsProvider.get());
    }

    public static MembersInjector<FavoritesCollectionItemsFragment> create(Provider<IUserContextManager> provider, Provider<ThumbnailManager> provider2, Provider<FeatureFlips> provider3) {
        return new FavoritesCollectionItemsFragment_MembersInjector(provider, provider2, provider3);
    }

    public static void injectUserContextManager(FavoritesCollectionItemsFragment favoritesCollectionItemsFragment, IUserContextManager iUserContextManager) {
        favoritesCollectionItemsFragment.userContextManager = iUserContextManager;
    }

    public static void injectThumbnailManager(FavoritesCollectionItemsFragment favoritesCollectionItemsFragment, ThumbnailManager thumbnailManager) {
        favoritesCollectionItemsFragment.thumbnailManager = thumbnailManager;
    }

    public static void injectFeatureFlips(FavoritesCollectionItemsFragment favoritesCollectionItemsFragment, FeatureFlips featureFlips) {
        favoritesCollectionItemsFragment.featureFlips = featureFlips;
    }
}
