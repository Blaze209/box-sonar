package com.box.android.navigationmodernization;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes12.dex */
public final class MainNavigationViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provide());
    }

    public static MainNavigationViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return MainNavigationViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final MainNavigationViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new MainNavigationViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
