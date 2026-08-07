package com.box.android.browse.cpl.offlined;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes10.dex */
public final class OfflinedViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provide());
    }

    public static OfflinedViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return OfflinedViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final OfflinedViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new OfflinedViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
