package com.box.android.capture.viewmodel;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.LazyClassKey;

/* JADX INFO: loaded from: classes10.dex */
public final class CaptureSettingsViewModel_HiltModules {
    private CaptureSettingsViewModel_HiltModules() {
    }

    @Module
    public static abstract class BindsModule {
        @LazyClassKey(CaptureSettingsViewModel.class)
        @Binds
        @IntoMap
        public abstract ViewModel binds(CaptureSettingsViewModel captureSettingsViewModel);

        private BindsModule() {
        }
    }

    @Module
    public static final class KeyModule {
        @Provides
        @LazyClassKey(CaptureSettingsViewModel.class)
        @IntoMap
        public static boolean provide() {
            return true;
        }

        private KeyModule() {
        }
    }
}
