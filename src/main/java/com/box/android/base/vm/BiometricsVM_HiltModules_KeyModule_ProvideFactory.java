package com.box.android.base.vm;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes9.dex */
public final class BiometricsVM_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provide());
    }

    public static BiometricsVM_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return BiometricsVM_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final BiometricsVM_HiltModules_KeyModule_ProvideFactory INSTANCE = new BiometricsVM_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
