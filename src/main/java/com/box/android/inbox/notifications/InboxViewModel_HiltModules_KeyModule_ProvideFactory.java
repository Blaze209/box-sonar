package com.box.android.inbox.notifications;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes12.dex */
public final class InboxViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provide());
    }

    public static InboxViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return InboxViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final InboxViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new InboxViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
