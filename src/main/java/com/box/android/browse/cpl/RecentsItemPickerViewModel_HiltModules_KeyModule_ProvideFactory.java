package com.box.android.browse.cpl;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes10.dex */
public final class RecentsItemPickerViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provide());
    }

    public static RecentsItemPickerViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return RecentsItemPickerViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final RecentsItemPickerViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new RecentsItemPickerViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
