package com.box.android.updates.proposal.presentation;

import com.box.android.updates.UpdatesManager;
import com.box.android.updates.proposal.AppUpdateProposalManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes13.dex */
public final class AppUpdateProposalEnvironment_Factory implements Factory<AppUpdateProposalEnvironment> {
    private final Provider<AppUpdateProposalManager> appUpdateProposalManagerProvider;
    private final Provider<UpdatesManager> updatesManagerProvider;

    private AppUpdateProposalEnvironment_Factory(Provider<UpdatesManager> provider, Provider<AppUpdateProposalManager> provider2) {
        this.updatesManagerProvider = provider;
        this.appUpdateProposalManagerProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AppUpdateProposalEnvironment get() {
        return newInstance(this.updatesManagerProvider.get(), this.appUpdateProposalManagerProvider.get());
    }

    public static AppUpdateProposalEnvironment_Factory create(Provider<UpdatesManager> provider, Provider<AppUpdateProposalManager> provider2) {
        return new AppUpdateProposalEnvironment_Factory(provider, provider2);
    }

    public static AppUpdateProposalEnvironment newInstance(UpdatesManager updatesManager, AppUpdateProposalManager appUpdateProposalManager) {
        return new AppUpdateProposalEnvironment(updatesManager, appUpdateProposalManager);
    }
}
