package com.box.android.collections.presentation.viewmodel;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes10.dex */
public final class CollectionMembershipsViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provide());
    }

    public static CollectionMembershipsViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return CollectionMembershipsViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final CollectionMembershipsViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new CollectionMembershipsViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
