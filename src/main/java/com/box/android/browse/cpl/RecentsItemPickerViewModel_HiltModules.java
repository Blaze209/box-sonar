package com.box.android.browse.cpl;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.LazyClassKey;

/* JADX INFO: loaded from: classes10.dex */
public final class RecentsItemPickerViewModel_HiltModules {
    private RecentsItemPickerViewModel_HiltModules() {
    }

    @Module
    public static abstract class BindsModule {
        @LazyClassKey(RecentsItemPickerViewModel.class)
        @Binds
        @IntoMap
        public abstract ViewModel binds(RecentsItemPickerViewModel recentsItemPickerViewModel);

        private BindsModule() {
        }
    }

    @Module
    public static final class KeyModule {
        @Provides
        @LazyClassKey(RecentsItemPickerViewModel.class)
        @IntoMap
        public static boolean provide() {
            return true;
        }

        private KeyModule() {
        }
    }
}
