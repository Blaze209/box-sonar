package com.box.android.base.presentation.components.topbar.component.settings;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes9.dex */
public final class UserAvatarViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provide());
    }

    public static UserAvatarViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return UserAvatarViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final UserAvatarViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new UserAvatarViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
