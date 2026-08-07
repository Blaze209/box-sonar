package com.box.android.capture.viewmodel;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes10.dex */
public final class CaptureSettingsViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provide());
    }

    public static CaptureSettingsViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return CaptureSettingsViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final CaptureSettingsViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new CaptureSettingsViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
