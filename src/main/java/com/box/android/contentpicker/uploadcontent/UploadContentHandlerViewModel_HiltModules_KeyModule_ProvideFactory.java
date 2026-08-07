package com.box.android.contentpicker.uploadcontent;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes10.dex */
public final class UploadContentHandlerViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provide());
    }

    public static UploadContentHandlerViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return UploadContentHandlerViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final UploadContentHandlerViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new UploadContentHandlerViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
