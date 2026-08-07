package com.box.android.collections.presentation.viewmodel;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.LazyClassKey;

/* JADX INFO: loaded from: classes10.dex */
public final class FavoritesCollectionItemsViewModel_HiltModules {
    private FavoritesCollectionItemsViewModel_HiltModules() {
    }

    @Module
    public static abstract class BindsModule {
        @LazyClassKey(FavoritesCollectionItemsViewModel.class)
        @Binds
        @IntoMap
        public abstract ViewModel binds(FavoritesCollectionItemsViewModel favoritesCollectionItemsViewModel);

        private BindsModule() {
        }
    }

    @Module
    public static final class KeyModule {
        @Provides
        @LazyClassKey(FavoritesCollectionItemsViewModel.class)
        @IntoMap
        public static boolean provide() {
            return true;
        }

        private KeyModule() {
        }
    }
}
