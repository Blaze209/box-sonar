package com.box.android.preview.gallery;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes12.dex */
public final class GalleryItemsViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provide());
    }

    public static GalleryItemsViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return GalleryItemsViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final GalleryItemsViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new GalleryItemsViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
