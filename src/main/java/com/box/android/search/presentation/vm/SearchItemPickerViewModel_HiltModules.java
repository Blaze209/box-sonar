package com.box.android.search.presentation.vm;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.LazyClassKey;

/* JADX INFO: loaded from: classes13.dex */
public final class SearchItemPickerViewModel_HiltModules {
    private SearchItemPickerViewModel_HiltModules() {
    }

    @Module
    public static abstract class BindsModule {
        @LazyClassKey(SearchItemPickerViewModel.class)
        @Binds
        @IntoMap
        public abstract ViewModel binds(SearchItemPickerViewModel searchItemPickerViewModel);

        private BindsModule() {
        }
    }

    @Module
    public static final class KeyModule {
        @Provides
        @LazyClassKey(SearchItemPickerViewModel.class)
        @IntoMap
        public static boolean provide() {
            return true;
        }

        private KeyModule() {
        }
    }
}
