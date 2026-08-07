package com.box.android.hubs.presentation;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes12.dex */
public final class HubsItemPickerViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provide());
    }

    public static HubsItemPickerViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return HubsItemPickerViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final HubsItemPickerViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new HubsItemPickerViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
