package com.box.android.browse.cpl.navigationmodernization.tabsscreen;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.LazyClassKey;

/* JADX INFO: loaded from: classes10.dex */
public final class BrowseTabsViewModel_HiltModules {
    private BrowseTabsViewModel_HiltModules() {
    }

    @Module
    public static abstract class BindsModule {
        @LazyClassKey(BrowseTabsViewModel.class)
        @Binds
        @IntoMap
        public abstract ViewModel binds(BrowseTabsViewModel browseTabsViewModel);

        private BindsModule() {
        }
    }

    @Module
    public static final class KeyModule {
        @Provides
        @LazyClassKey(BrowseTabsViewModel.class)
        @IntoMap
        public static boolean provide() {
            return true;
        }

        private KeyModule() {
        }
    }
}
