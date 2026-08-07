package com.box.android.updates.proposal.presentation;

import com.box.android.cpl.IStoreFactory;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes13.dex */
public final class AppUpdateProposalViewModel_Factory implements Factory<AppUpdateProposalViewModel> {
    private final Provider<AppUpdateProposalEnvironment> appUpdateProposalEnvironmentProvider;
    private final Provider<IStoreFactory> storeFactoryProvider;

    private AppUpdateProposalViewModel_Factory(Provider<AppUpdateProposalEnvironment> provider, Provider<IStoreFactory> provider2) {
        this.appUpdateProposalEnvironmentProvider = provider;
        this.storeFactoryProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AppUpdateProposalViewModel get() {
        return newInstance(this.appUpdateProposalEnvironmentProvider.get(), this.storeFactoryProvider.get());
    }

    public static AppUpdateProposalViewModel_Factory create(Provider<AppUpdateProposalEnvironment> provider, Provider<IStoreFactory> provider2) {
        return new AppUpdateProposalViewModel_Factory(provider, provider2);
    }

    public static AppUpdateProposalViewModel newInstance(AppUpdateProposalEnvironment appUpdateProposalEnvironment, IStoreFactory iStoreFactory) {
        return new AppUpdateProposalViewModel(appUpdateProposalEnvironment, iStoreFactory);
    }
}
