package com.box.android.hubs.hubDetails.presentation;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes12.dex */
public final class HubDetailsViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provide());
    }

    public static HubDetailsViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return HubDetailsViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final HubDetailsViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new HubDetailsViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
