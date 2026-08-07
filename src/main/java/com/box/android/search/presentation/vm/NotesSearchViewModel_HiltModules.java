package com.box.android.search.presentation.vm;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.LazyClassKey;

/* JADX INFO: loaded from: classes13.dex */
public final class NotesSearchViewModel_HiltModules {
    private NotesSearchViewModel_HiltModules() {
    }

    @Module
    public static abstract class BindsModule {
        @LazyClassKey(NotesSearchViewModel.class)
        @Binds
        @IntoMap
        public abstract ViewModel binds(NotesSearchViewModel notesSearchViewModel);

        private BindsModule() {
        }
    }

    @Module
    public static final class KeyModule {
        @Provides
        @LazyClassKey(NotesSearchViewModel.class)
        @IntoMap
        public static boolean provide() {
            return true;
        }

        private KeyModule() {
        }
    }
}
