package com.box.android.hubs.presentation;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes12.dex */
public final class HubsViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provide());
    }

    public static HubsViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return HubsViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final HubsViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new HubsViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
