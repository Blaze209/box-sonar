package com.box.android.notes.navigationmodernization.tabsscreen;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes12.dex */
public final class NotesTabsViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provide());
    }

    public static NotesTabsViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return NotesTabsViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final NotesTabsViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new NotesTabsViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
