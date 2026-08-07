package com.box.android.collections.presentation.navigationmodernization.collectionitemslist;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes10.dex */
public final class CollectionItemsListViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provide());
    }

    public static CollectionItemsListViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return CollectionItemsListViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final CollectionItemsListViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new CollectionItemsListViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
