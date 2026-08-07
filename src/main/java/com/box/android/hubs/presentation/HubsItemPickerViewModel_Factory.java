package com.box.android.hubs.presentation;

import com.box.android.coreservices.services.IntentServices;
import com.box.android.cpl.IStoreFactory;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class HubsItemPickerViewModel_Factory implements Factory<HubsItemPickerViewModel> {
    private final Provider<HubsEnvironment> hubsEnvironmentProvider;
    private final Provider<IntentServices> intentServicesProvider;
    private final Provider<IStoreFactory> storeFactoryProvider;

    private HubsItemPickerViewModel_Factory(Provider<HubsEnvironment> provider, Provider<IStoreFactory> provider2, Provider<IntentServices> provider3) {
        this.hubsEnvironmentProvider = provider;
        this.storeFactoryProvider = provider2;
        this.intentServicesProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public HubsItemPickerViewModel get() {
        return newInstance(this.hubsEnvironmentProvider.get(), this.storeFactoryProvider.get(), this.intentServicesProvider.get());
    }

    public static HubsItemPickerViewModel_Factory create(Provider<HubsEnvironment> provider, Provider<IStoreFactory> provider2, Provider<IntentServices> provider3) {
        return new HubsItemPickerViewModel_Factory(provider, provider2, provider3);
    }

    public static HubsItemPickerViewModel newInstance(HubsEnvironment hubsEnvironment, IStoreFactory iStoreFactory, IntentServices intentServices) {
        return new HubsItemPickerViewModel(hubsEnvironment, iStoreFactory, intentServices);
    }
}
