package com.box.android.preview.previewtype.audio.playlist;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes12.dex */
public final class PreviewPlaylistViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provide());
    }

    public static PreviewPlaylistViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return PreviewPlaylistViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final PreviewPlaylistViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new PreviewPlaylistViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
