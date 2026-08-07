package com.box.android.fileactivity.presentation;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes11.dex */
public final class FileActivitiesViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provide());
    }

    public static FileActivitiesViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return FileActivitiesViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final FileActivitiesViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new FileActivitiesViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
