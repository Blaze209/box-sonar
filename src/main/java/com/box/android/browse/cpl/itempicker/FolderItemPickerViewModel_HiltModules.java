package com.box.android.browse.cpl.itempicker;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.LazyClassKey;

/* JADX INFO: loaded from: classes10.dex */
public final class FolderItemPickerViewModel_HiltModules {
    private FolderItemPickerViewModel_HiltModules() {
    }

    @Module
    public static abstract class BindsModule {
        @LazyClassKey(FolderItemPickerViewModel.class)
        @Binds
        @IntoMap
        public abstract ViewModel binds(FolderItemPickerViewModel folderItemPickerViewModel);

        private BindsModule() {
        }
    }

    @Module
    public static final class KeyModule {
        @Provides
        @LazyClassKey(FolderItemPickerViewModel.class)
        @IntoMap
        public static boolean provide() {
            return true;
        }

        private KeyModule() {
        }
    }
}
