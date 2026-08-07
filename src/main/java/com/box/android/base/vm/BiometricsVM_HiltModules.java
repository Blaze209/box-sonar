package com.box.android.base.vm;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.LazyClassKey;

/* JADX INFO: loaded from: classes9.dex */
public final class BiometricsVM_HiltModules {
    private BiometricsVM_HiltModules() {
    }

    @Module
    public static abstract class BindsModule {
        @LazyClassKey(BiometricsVM.class)
        @Binds
        @IntoMap
        public abstract ViewModel binds(BiometricsVM biometricsVM);

        private BindsModule() {
        }
    }

    @Module
    public static final class KeyModule {
        @Provides
        @LazyClassKey(BiometricsVM.class)
        @IntoMap
        public static boolean provide() {
            return true;
        }

        private KeyModule() {
        }
    }
}
