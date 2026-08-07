package com.box.android.vm;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.LazyClassKey;

/* JADX INFO: loaded from: classes13.dex */
public final class PushRegistrationDialogVM_HiltModules {
    private PushRegistrationDialogVM_HiltModules() {
    }

    @Module
    public static abstract class BindsModule {
        @LazyClassKey(PushRegistrationDialogVM.class)
        @Binds
        @IntoMap
        public abstract ViewModel binds(PushRegistrationDialogVM pushRegistrationDialogVM);

        private BindsModule() {
        }
    }

    @Module
    public static final class KeyModule {
        @Provides
        @LazyClassKey(PushRegistrationDialogVM.class)
        @IntoMap
        public static boolean provide() {
            return true;
        }

        private KeyModule() {
        }
    }
}
