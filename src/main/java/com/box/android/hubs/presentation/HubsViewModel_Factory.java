package com.box.android.hubs.presentation;

import com.box.android.cpl.IStoreFactory;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class HubsViewModel_Factory implements Factory<HubsViewModel> {
    private final Provider<HubsEnvironment> hubsEnvironmentProvider;
    private final Provider<IStoreFactory> storeFactoryProvider;

    private HubsViewModel_Factory(Provider<HubsEnvironment> provider, Provider<IStoreFactory> provider2) {
        this.hubsEnvironmentProvider = provider;
        this.storeFactoryProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public HubsViewModel get() {
        return newInstance(this.hubsEnvironmentProvider.get(), this.storeFactoryProvider.get());
    }

    public static HubsViewModel_Factory create(Provider<HubsEnvironment> provider, Provider<IStoreFactory> provider2) {
        return new HubsViewModel_Factory(provider, provider2);
    }

    public static HubsViewModel newInstance(HubsEnvironment hubsEnvironment, IStoreFactory iStoreFactory) {
        return new HubsViewModel(hubsEnvironment, iStoreFactory);
    }
}
