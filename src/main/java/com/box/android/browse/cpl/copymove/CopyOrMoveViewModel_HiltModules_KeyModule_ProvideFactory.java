package com.box.android.browse.cpl.copymove;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes10.dex */
public final class CopyOrMoveViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provide());
    }

    public static CopyOrMoveViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return CopyOrMoveViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final CopyOrMoveViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new CopyOrMoveViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
