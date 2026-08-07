package com.box.android.vm;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes13.dex */
public final class PushRegistrationDialogVM_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provide());
    }

    public static PushRegistrationDialogVM_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return PushRegistrationDialogVM_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final PushRegistrationDialogVM_HiltModules_KeyModule_ProvideFactory INSTANCE = new PushRegistrationDialogVM_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
