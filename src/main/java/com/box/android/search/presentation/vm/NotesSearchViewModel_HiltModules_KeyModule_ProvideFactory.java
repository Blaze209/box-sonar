package com.box.android.search.presentation.vm;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes13.dex */
public final class NotesSearchViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provide());
    }

    public static NotesSearchViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return NotesSearchViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final NotesSearchViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new NotesSearchViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
