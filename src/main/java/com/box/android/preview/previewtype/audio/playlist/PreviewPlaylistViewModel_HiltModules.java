package com.box.android.preview.previewtype.audio.playlist;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.LazyClassKey;

/* JADX INFO: loaded from: classes12.dex */
public final class PreviewPlaylistViewModel_HiltModules {
    private PreviewPlaylistViewModel_HiltModules() {
    }

    @Module
    public static abstract class BindsModule {
        @LazyClassKey(PreviewPlaylistViewModel.class)
        @Binds
        @IntoMap
        public abstract Object bind(PreviewPlaylistViewModel.Factory factory);

        private BindsModule() {
        }
    }

    @Module
    public static final class KeyModule {
        @Provides
        @LazyClassKey(PreviewPlaylistViewModel.class)
        @IntoMap
        public static boolean provide() {
            return true;
        }

        private KeyModule() {
        }
    }
}
