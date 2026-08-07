package com.box.android.base.presentation.components.topbar.component.inbox;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes9.dex */
public final class InboxCountViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provide());
    }

    public static InboxCountViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return InboxCountViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final InboxCountViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new InboxCountViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
