package com.box.android.data.service.impl;

import com.box.android.domain.configuration.IForceUpdateRepository;
import com.box.android.domain.services.IForceUpdateCoordinator;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class ForceUpdateConfigSynchronizer_Factory implements Factory<ForceUpdateConfigSynchronizer> {
    private final Provider<IForceUpdateCoordinator> forceUpdateCoordinatorProvider;
    private final Provider<IForceUpdateRepository> forceUpdateRepositoryProvider;
    private final Provider<Moshi> moshiProvider;

    private ForceUpdateConfigSynchronizer_Factory(Provider<IForceUpdateRepository> forceUpdateRepositoryProvider, Provider<IForceUpdateCoordinator> forceUpdateCoordinatorProvider, Provider<Moshi> moshiProvider) {
        this.forceUpdateRepositoryProvider = forceUpdateRepositoryProvider;
        this.forceUpdateCoordinatorProvider = forceUpdateCoordinatorProvider;
        this.moshiProvider = moshiProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ForceUpdateConfigSynchronizer get() {
        return newInstance(this.forceUpdateRepositoryProvider.get(), this.forceUpdateCoordinatorProvider.get(), this.moshiProvider.get());
    }

    public static ForceUpdateConfigSynchronizer_Factory create(Provider<IForceUpdateRepository> forceUpdateRepositoryProvider, Provider<IForceUpdateCoordinator> forceUpdateCoordinatorProvider, Provider<Moshi> moshiProvider) {
        return new ForceUpdateConfigSynchronizer_Factory(forceUpdateRepositoryProvider, forceUpdateCoordinatorProvider, moshiProvider);
    }

    public static ForceUpdateConfigSynchronizer newInstance(IForceUpdateRepository forceUpdateRepository, IForceUpdateCoordinator forceUpdateCoordinator, Moshi moshi) {
        return new ForceUpdateConfigSynchronizer(forceUpdateRepository, forceUpdateCoordinator, moshi);
    }
}
