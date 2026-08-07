package com.box.android.notes.navigationmodernization.tabsscreen;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.LazyClassKey;

/* JADX INFO: loaded from: classes12.dex */
public final class NotesTabsViewModel_HiltModules {
    private NotesTabsViewModel_HiltModules() {
    }

    @Module
    public static abstract class BindsModule {
        @LazyClassKey(NotesTabsViewModel.class)
        @Binds
        @IntoMap
        public abstract ViewModel binds(NotesTabsViewModel notesTabsViewModel);

        private BindsModule() {
        }
    }

    @Module
    public static final class KeyModule {
        @Provides
        @LazyClassKey(NotesTabsViewModel.class)
        @IntoMap
        public static boolean provide() {
            return true;
        }

        private KeyModule() {
        }
    }
}
