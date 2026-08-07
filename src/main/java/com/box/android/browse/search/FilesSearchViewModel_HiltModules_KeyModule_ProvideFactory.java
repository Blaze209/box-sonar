package com.box.android.browse.search;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes10.dex */
public final class FilesSearchViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provide());
    }

    public static FilesSearchViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return FilesSearchViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final FilesSearchViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new FilesSearchViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
