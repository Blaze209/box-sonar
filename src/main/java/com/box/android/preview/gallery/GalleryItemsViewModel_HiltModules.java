package com.box.android.preview.gallery;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.LazyClassKey;

/* JADX INFO: loaded from: classes12.dex */
public final class GalleryItemsViewModel_HiltModules {
    private GalleryItemsViewModel_HiltModules() {
    }

    @Module
    public static abstract class BindsModule {
        @LazyClassKey(GalleryItemsViewModel.class)
        @Binds
        @IntoMap
        public abstract Object bind(GalleryItemsViewModel.Factory factory);

        private BindsModule() {
        }
    }

    @Module
    public static final class KeyModule {
        @Provides
        @LazyClassKey(GalleryItemsViewModel.class)
        @IntoMap
        public static boolean provide() {
            return true;
        }

        private KeyModule() {
        }
    }
}
