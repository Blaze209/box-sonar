package com.box.android.boxai.homescreen;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes9.dex */
public final class BoxAiHomeViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provide());
    }

    public static BoxAiHomeViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return BoxAiHomeViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final BoxAiHomeViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new BoxAiHomeViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
