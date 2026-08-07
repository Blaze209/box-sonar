package com.box.android.base.presentation.watermarking;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.LazyClassKey;

/* JADX INFO: loaded from: classes9.dex */
public final class WatermarkingViewModel_HiltModules {
    private WatermarkingViewModel_HiltModules() {
    }

    @Module
    public static abstract class BindsModule {
        @LazyClassKey(WatermarkingViewModel.class)
        @Binds
        @IntoMap
        public abstract ViewModel binds(WatermarkingViewModel watermarkingViewModel);

        private BindsModule() {
        }
    }

    @Module
    public static final class KeyModule {
        @Provides
        @LazyClassKey(WatermarkingViewModel.class)
        @IntoMap
        public static boolean provide() {
            return true;
        }

        private KeyModule() {
        }
    }
}
