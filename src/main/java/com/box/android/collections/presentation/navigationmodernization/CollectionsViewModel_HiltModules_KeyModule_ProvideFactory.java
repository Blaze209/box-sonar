package com.box.android.collections.presentation.navigationmodernization;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes10.dex */
public final class CollectionsViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provide());
    }

    public static CollectionsViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return CollectionsViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final CollectionsViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new CollectionsViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
