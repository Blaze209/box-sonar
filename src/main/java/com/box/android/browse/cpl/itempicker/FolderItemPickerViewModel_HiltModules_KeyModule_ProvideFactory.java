package com.box.android.browse.cpl.itempicker;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes10.dex */
public final class FolderItemPickerViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provide());
    }

    public static FolderItemPickerViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return FolderItemPickerViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final FolderItemPickerViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new FolderItemPickerViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
