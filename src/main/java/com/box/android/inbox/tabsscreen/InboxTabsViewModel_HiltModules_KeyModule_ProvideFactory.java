package com.box.android.inbox.tabsscreen;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes12.dex */
public final class InboxTabsViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provide());
    }

    public static InboxTabsViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return InboxTabsViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final InboxTabsViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new InboxTabsViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
