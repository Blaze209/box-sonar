package com.box.android.collections.presentation.navigationmodernization.collectionitemslist;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.LazyClassKey;

/* JADX INFO: loaded from: classes10.dex */
public final class CollectionItemsListViewModel_HiltModules {
    private CollectionItemsListViewModel_HiltModules() {
    }

    @Module
    public static abstract class BindsModule {
        @LazyClassKey(CollectionItemsListViewModel.class)
        @Binds
        @IntoMap
        public abstract ViewModel binds(CollectionItemsListViewModel collectionItemsListViewModel);

        private BindsModule() {
        }
    }

    @Module
    public static final class KeyModule {
        @Provides
        @LazyClassKey(CollectionItemsListViewModel.class)
        @IntoMap
        public static boolean provide() {
            return true;
        }

        private KeyModule() {
        }
    }
}
