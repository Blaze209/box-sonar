package com.box.android.browse.cpl.itempicker;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes10.dex */
public final class ItemPickerViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provide());
    }

    public static ItemPickerViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return ItemPickerViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final ItemPickerViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new ItemPickerViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
