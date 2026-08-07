package com.box.android.preview.previousversion;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.LazyClassKey;

/* JADX INFO: loaded from: classes12.dex */
public final class PreviousVersionViewModel_HiltModules {
    private PreviousVersionViewModel_HiltModules() {
    }

    @Module
    public static abstract class BindsModule {
        @LazyClassKey(PreviousVersionViewModel.class)
        @Binds
        @IntoMap
        public abstract Object bind(PreviousVersionViewModel.Factory factory);

        private BindsModule() {
        }
    }

    @Module
    public static final class KeyModule {
        @Provides
        @LazyClassKey(PreviousVersionViewModel.class)
        @IntoMap
        public static boolean provide() {
            return true;
        }

        private KeyModule() {
        }
    }
}
