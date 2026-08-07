package com.box.android.cpl.navigation;

import com.box.android.cpl.IStoreFactory;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class NavigationViewModel_Factory implements Factory<NavigationViewModel> {
    private final Provider<NavigationEnvironment> navigationEnvironmentProvider;
    private final Provider<IStoreFactory> storeFactoryProvider;

    private NavigationViewModel_Factory(Provider<NavigationEnvironment> provider, Provider<IStoreFactory> provider2) {
        this.navigationEnvironmentProvider = provider;
        this.storeFactoryProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public NavigationViewModel get() {
        return newInstance(this.navigationEnvironmentProvider.get(), this.storeFactoryProvider.get());
    }

    public static NavigationViewModel_Factory create(Provider<NavigationEnvironment> provider, Provider<IStoreFactory> provider2) {
        return new NavigationViewModel_Factory(provider, provider2);
    }

    public static NavigationViewModel newInstance(NavigationEnvironment navigationEnvironment, IStoreFactory iStoreFactory) {
        return new NavigationViewModel(navigationEnvironment, iStoreFactory);
    }
}
