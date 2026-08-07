package com.box.android.base.presentation.components.topbar.component.settings;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.LazyClassKey;

/* JADX INFO: loaded from: classes9.dex */
public final class UserAvatarViewModel_HiltModules {
    private UserAvatarViewModel_HiltModules() {
    }

    @Module
    public static abstract class BindsModule {
        @LazyClassKey(UserAvatarViewModel.class)
        @Binds
        @IntoMap
        public abstract ViewModel binds(UserAvatarViewModel userAvatarViewModel);

        private BindsModule() {
        }
    }

    @Module
    public static final class KeyModule {
        @Provides
        @LazyClassKey(UserAvatarViewModel.class)
        @IntoMap
        public static boolean provide() {
            return true;
        }

        private KeyModule() {
        }
    }
}
