package com.box.android.cpl.navigation;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes9.dex */
public final class NavigationViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provide());
    }

    public static NavigationViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return NavigationViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final NavigationViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new NavigationViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
