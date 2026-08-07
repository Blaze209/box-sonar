package com.box.android.browse.cpl.navigationmodernization.tabsscreen;

import com.box.android.cpl.IStoreFactory;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class BrowseTabsViewModel_Factory implements Factory<BrowseTabsViewModel> {
    private final Provider<BrowseTabsEnvironment> environmentProvider;
    private final Provider<IStoreFactory> storeFactoryProvider;

    private BrowseTabsViewModel_Factory(Provider<BrowseTabsEnvironment> provider, Provider<IStoreFactory> provider2) {
        this.environmentProvider = provider;
        this.storeFactoryProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BrowseTabsViewModel get() {
        return newInstance(this.environmentProvider.get(), this.storeFactoryProvider.get());
    }

    public static BrowseTabsViewModel_Factory create(Provider<BrowseTabsEnvironment> provider, Provider<IStoreFactory> provider2) {
        return new BrowseTabsViewModel_Factory(provider, provider2);
    }

    public static BrowseTabsViewModel newInstance(BrowseTabsEnvironment browseTabsEnvironment, IStoreFactory iStoreFactory) {
        return new BrowseTabsViewModel(browseTabsEnvironment, iStoreFactory);
    }
}
