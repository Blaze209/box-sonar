package com.box.android.vm;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.LazyClassKey;

/* JADX INFO: loaded from: classes13.dex */
public final class SingleTaskVM_HiltModules {
    private SingleTaskVM_HiltModules() {
    }

    @Module
    public static abstract class BindsModule {
        @LazyClassKey(SingleTaskVM.class)
        @Binds
        @IntoMap
        public abstract ViewModel binds(SingleTaskVM singleTaskVM);

        private BindsModule() {
        }
    }

    @Module
    public static final class KeyModule {
        @Provides
        @LazyClassKey(SingleTaskVM.class)
        @IntoMap
        public static boolean provide() {
            return true;
        }

        private KeyModule() {
        }
    }
}
