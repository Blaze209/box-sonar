package com.box.android.updates;

import com.box.android.updates.force.ForceUpdateEvaluator;
import com.box.android.updates.proposal.AppUpdateProposalManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes13.dex */
public final class UpdatesManager_Factory implements Factory<UpdatesManager> {
    private final Provider<AppUpdateProposalManager> appUpdateProposalManagerProvider;
    private final Provider<ForceUpdateEvaluator> forceUpdateEvaluatorProvider;

    private UpdatesManager_Factory(Provider<ForceUpdateEvaluator> provider, Provider<AppUpdateProposalManager> provider2) {
        this.forceUpdateEvaluatorProvider = provider;
        this.appUpdateProposalManagerProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public UpdatesManager get() {
        return newInstance(this.forceUpdateEvaluatorProvider.get(), this.appUpdateProposalManagerProvider.get());
    }

    public static UpdatesManager_Factory create(Provider<ForceUpdateEvaluator> provider, Provider<AppUpdateProposalManager> provider2) {
        return new UpdatesManager_Factory(provider, provider2);
    }

    public static UpdatesManager newInstance(ForceUpdateEvaluator forceUpdateEvaluator, AppUpdateProposalManager appUpdateProposalManager) {
        return new UpdatesManager(forceUpdateEvaluator, appUpdateProposalManager);
    }
}
