package com.box.android.cpl.mainphone;

import com.box.android.cpl.IStoreFactory;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class MainPhoneViewModel_Factory_Factory implements Factory<MainPhoneViewModel.Factory> {
    private final Provider<BrowseSavedStateBuilder> browseSavedStateBuilderProvider;
    private final Provider<MainPhoneEnvironment> mainPhoneEnvironmentProvider;
    private final Provider<IStoreFactory> storeFactoryProvider;

    private MainPhoneViewModel_Factory_Factory(Provider<MainPhoneEnvironment> provider, Provider<BrowseSavedStateBuilder> provider2, Provider<IStoreFactory> provider3) {
        this.mainPhoneEnvironmentProvider = provider;
        this.browseSavedStateBuilderProvider = provider2;
        this.storeFactoryProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public MainPhoneViewModel.Factory get() {
        return newInstance(this.mainPhoneEnvironmentProvider.get(), this.browseSavedStateBuilderProvider.get(), this.storeFactoryProvider.get());
    }

    public static MainPhoneViewModel_Factory_Factory create(Provider<MainPhoneEnvironment> provider, Provider<BrowseSavedStateBuilder> provider2, Provider<IStoreFactory> provider3) {
        return new MainPhoneViewModel_Factory_Factory(provider, provider2, provider3);
    }

    public static MainPhoneViewModel.Factory newInstance(MainPhoneEnvironment mainPhoneEnvironment, BrowseSavedStateBuilder browseSavedStateBuilder, IStoreFactory iStoreFactory) {
        return new MainPhoneViewModel.Factory(mainPhoneEnvironment, browseSavedStateBuilder, iStoreFactory);
    }
}
