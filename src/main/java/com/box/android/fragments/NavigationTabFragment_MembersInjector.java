package com.box.android.fragments;

import com.box.android.base.presentation.fragments.TabLayoutFragment_MembersInjector;
import com.box.android.browse.utilities.BrowseFragmentFactory;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContextManager;
import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class NavigationTabFragment_MembersInjector implements MembersInjector<NavigationTabFragment> {
    private final Provider<BrowseFragmentFactory> browseFragmentFactoryProvider;
    private final Provider<FeatureFlips> mFeatureFlipsProvider;
    private final Provider<IUserContextManager> mUserContextManagerProvider;

    private NavigationTabFragment_MembersInjector(Provider<IUserContextManager> provider, Provider<FeatureFlips> provider2, Provider<BrowseFragmentFactory> provider3) {
        this.mUserContextManagerProvider = provider;
        this.mFeatureFlipsProvider = provider2;
        this.browseFragmentFactoryProvider = provider3;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(NavigationTabFragment navigationTabFragment) {
        TabLayoutFragment_MembersInjector.injectMUserContextManager(navigationTabFragment, this.mUserContextManagerProvider.get());
        injectMFeatureFlips(navigationTabFragment, this.mFeatureFlipsProvider.get());
        injectBrowseFragmentFactory(navigationTabFragment, this.browseFragmentFactoryProvider.get());
    }

    public static MembersInjector<NavigationTabFragment> create(Provider<IUserContextManager> provider, Provider<FeatureFlips> provider2, Provider<BrowseFragmentFactory> provider3) {
        return new NavigationTabFragment_MembersInjector(provider, provider2, provider3);
    }

    public static void injectMFeatureFlips(NavigationTabFragment navigationTabFragment, FeatureFlips featureFlips) {
        navigationTabFragment.mFeatureFlips = featureFlips;
    }

    public static void injectBrowseFragmentFactory(NavigationTabFragment navigationTabFragment, BrowseFragmentFactory browseFragmentFactory) {
        navigationTabFragment.browseFragmentFactory = browseFragmentFactory;
    }
}
