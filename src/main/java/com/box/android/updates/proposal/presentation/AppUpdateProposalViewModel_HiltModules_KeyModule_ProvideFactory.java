package com.box.android.updates.proposal.presentation;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes13.dex */
public final class AppUpdateProposalViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provide());
    }

    public static AppUpdateProposalViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return AppUpdateProposalViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final AppUpdateProposalViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new AppUpdateProposalViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
