package com.box.android.browse.cpl.offlined;

import com.box.android.cpl.IStoreFactory;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class OfflinedViewModel_Factory implements Factory<OfflinedViewModel> {
    private final Provider<OfflinedEnvironment> offlinedEnvironmentProvider;
    private final Provider<IStoreFactory> storeFactoryProvider;

    private OfflinedViewModel_Factory(Provider<OfflinedEnvironment> provider, Provider<IStoreFactory> provider2) {
        this.offlinedEnvironmentProvider = provider;
        this.storeFactoryProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public OfflinedViewModel get() {
        return newInstance(this.offlinedEnvironmentProvider.get(), this.storeFactoryProvider.get());
    }

    public static OfflinedViewModel_Factory create(Provider<OfflinedEnvironment> provider, Provider<IStoreFactory> provider2) {
        return new OfflinedViewModel_Factory(provider, provider2);
    }

    public static OfflinedViewModel newInstance(OfflinedEnvironment offlinedEnvironment, IStoreFactory iStoreFactory) {
        return new OfflinedViewModel(offlinedEnvironment, iStoreFactory);
    }
}
