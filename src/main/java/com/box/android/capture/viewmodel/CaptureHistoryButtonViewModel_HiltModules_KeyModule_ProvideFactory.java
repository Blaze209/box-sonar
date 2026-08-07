package com.box.android.capture.viewmodel;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes10.dex */
public final class CaptureHistoryButtonViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provide());
    }

    public static CaptureHistoryButtonViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return CaptureHistoryButtonViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final CaptureHistoryButtonViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new CaptureHistoryButtonViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
