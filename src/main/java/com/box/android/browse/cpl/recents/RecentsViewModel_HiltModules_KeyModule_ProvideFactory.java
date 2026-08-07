package com.box.android.browse.cpl.recents;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes10.dex */
public final class RecentsViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provide());
    }

    public static RecentsViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return RecentsViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final RecentsViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new RecentsViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
