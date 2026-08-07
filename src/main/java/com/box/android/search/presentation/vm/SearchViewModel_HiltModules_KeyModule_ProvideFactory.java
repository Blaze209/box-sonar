package com.box.android.search.presentation.vm;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes13.dex */
public final class SearchViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provide());
    }

    public static SearchViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return SearchViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final SearchViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new SearchViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
