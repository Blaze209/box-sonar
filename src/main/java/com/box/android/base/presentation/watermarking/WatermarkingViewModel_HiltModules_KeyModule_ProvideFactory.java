package com.box.android.base.presentation.watermarking;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes9.dex */
public final class WatermarkingViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provide());
    }

    public static WatermarkingViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return WatermarkingViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final WatermarkingViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new WatermarkingViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
