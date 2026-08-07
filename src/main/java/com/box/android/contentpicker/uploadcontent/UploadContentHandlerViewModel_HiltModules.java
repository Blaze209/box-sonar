package com.box.android.contentpicker.uploadcontent;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.LazyClassKey;

/* JADX INFO: loaded from: classes10.dex */
public final class UploadContentHandlerViewModel_HiltModules {
    private UploadContentHandlerViewModel_HiltModules() {
    }

    @Module
    public static abstract class BindsModule {
        @LazyClassKey(UploadContentHandlerViewModel.class)
        @Binds
        @IntoMap
        public abstract ViewModel binds(UploadContentHandlerViewModel uploadContentHandlerViewModel);

        private BindsModule() {
        }
    }

    @Module
    public static final class KeyModule {
        @Provides
        @LazyClassKey(UploadContentHandlerViewModel.class)
        @IntoMap
        public static boolean provide() {
            return true;
        }

        private KeyModule() {
        }
    }
}
