package com.box.android.capture.audiorecording.viewmodel;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes10.dex */
public final class RecorderServiceViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provide());
    }

    public static RecorderServiceViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return RecorderServiceViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final RecorderServiceViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new RecorderServiceViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
