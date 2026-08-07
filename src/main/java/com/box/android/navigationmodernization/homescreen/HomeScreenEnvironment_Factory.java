package com.box.android.navigationmodernization.homescreen;

import com.box.android.domain.services.ITabPersistenceService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class HomeScreenEnvironment_Factory implements Factory<HomeScreenEnvironment> {
    private final Provider<ITabPersistenceService> tabPersistenceServiceProvider;

    private HomeScreenEnvironment_Factory(Provider<ITabPersistenceService> provider) {
        this.tabPersistenceServiceProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public HomeScreenEnvironment get() {
        return newInstance(this.tabPersistenceServiceProvider.get());
    }

    public static HomeScreenEnvironment_Factory create(Provider<ITabPersistenceService> provider) {
        return new HomeScreenEnvironment_Factory(provider);
    }

    public static HomeScreenEnvironment newInstance(ITabPersistenceService iTabPersistenceService) {
        return new HomeScreenEnvironment(iTabPersistenceService);
    }
}
