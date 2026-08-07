package com.box.android.browse.cpl.browse;

import com.box.android.cpl.IStoreFactory;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class AllFilesViewModel_Factory implements Factory<AllFilesViewModel> {
    private final Provider<BrowseEnvironment> browseEnvironmentProvider;
    private final Provider<IStoreFactory> storeFactoryProvider;

    private AllFilesViewModel_Factory(Provider<BrowseEnvironment> provider, Provider<IStoreFactory> provider2) {
        this.browseEnvironmentProvider = provider;
        this.storeFactoryProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AllFilesViewModel get() {
        return newInstance(this.browseEnvironmentProvider.get(), this.storeFactoryProvider.get());
    }

    public static AllFilesViewModel_Factory create(Provider<BrowseEnvironment> provider, Provider<IStoreFactory> provider2) {
        return new AllFilesViewModel_Factory(provider, provider2);
    }

    public static AllFilesViewModel newInstance(BrowseEnvironment browseEnvironment, IStoreFactory iStoreFactory) {
        return new AllFilesViewModel(browseEnvironment, iStoreFactory);
    }
}
