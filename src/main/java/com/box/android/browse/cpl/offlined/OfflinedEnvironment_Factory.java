package com.box.android.browse.cpl.offlined;

import com.box.android.domain.usecases.browse.OfflinedViewInteractor;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class OfflinedEnvironment_Factory implements Factory<OfflinedEnvironment> {
    private final Provider<ActionableOfflinedViewEnvironment> actionableItemsListEnvironmentProvider;
    private final Provider<OfflinedViewInteractor> offlinedViewInteractorProvider;

    private OfflinedEnvironment_Factory(Provider<ActionableOfflinedViewEnvironment> provider, Provider<OfflinedViewInteractor> provider2) {
        this.actionableItemsListEnvironmentProvider = provider;
        this.offlinedViewInteractorProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public OfflinedEnvironment get() {
        return newInstance(this.actionableItemsListEnvironmentProvider.get(), this.offlinedViewInteractorProvider.get());
    }

    public static OfflinedEnvironment_Factory create(Provider<ActionableOfflinedViewEnvironment> provider, Provider<OfflinedViewInteractor> provider2) {
        return new OfflinedEnvironment_Factory(provider, provider2);
    }

    public static OfflinedEnvironment newInstance(ActionableOfflinedViewEnvironment actionableOfflinedViewEnvironment, OfflinedViewInteractor offlinedViewInteractor) {
        return new OfflinedEnvironment(actionableOfflinedViewEnvironment, offlinedViewInteractor);
    }
}
