package com.box.android.browse.cpl.navigationmodernization.tabsscreen;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes10.dex */
public final class BrowseTabsViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provide());
    }

    public static BrowseTabsViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return BrowseTabsViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final BrowseTabsViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new BrowseTabsViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
