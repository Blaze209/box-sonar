package com.box.android.capture.viewmodel;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.LazyClassKey;

/* JADX INFO: loaded from: classes10.dex */
public final class CaptureHistoryButtonViewModel_HiltModules {
    private CaptureHistoryButtonViewModel_HiltModules() {
    }

    @Module
    public static abstract class BindsModule {
        @LazyClassKey(CaptureHistoryButtonViewModel.class)
        @Binds
        @IntoMap
        public abstract ViewModel binds(CaptureHistoryButtonViewModel captureHistoryButtonViewModel);

        private BindsModule() {
        }
    }

    @Module
    public static final class KeyModule {
        @Provides
        @LazyClassKey(CaptureHistoryButtonViewModel.class)
        @IntoMap
        public static boolean provide() {
            return true;
        }

        private KeyModule() {
        }
    }
}
