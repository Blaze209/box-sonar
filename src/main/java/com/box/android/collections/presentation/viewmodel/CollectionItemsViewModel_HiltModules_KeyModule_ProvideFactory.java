package com.box.android.collections.presentation.viewmodel;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes10.dex */
public final class CollectionItemsViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provide());
    }

    public static CollectionItemsViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return CollectionItemsViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final CollectionItemsViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new CollectionItemsViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
