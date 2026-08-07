package com.box.android.preview.previousversion;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes12.dex */
public final class PreviousVersionViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provide());
    }

    public static PreviousVersionViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return PreviousVersionViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final PreviousVersionViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new PreviousVersionViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
