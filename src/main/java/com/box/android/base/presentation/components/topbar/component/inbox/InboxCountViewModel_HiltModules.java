package com.box.android.base.presentation.components.topbar.component.inbox;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.LazyClassKey;

/* JADX INFO: loaded from: classes9.dex */
public final class InboxCountViewModel_HiltModules {
    private InboxCountViewModel_HiltModules() {
    }

    @Module
    public static abstract class BindsModule {
        @LazyClassKey(InboxCountViewModel.class)
        @Binds
        @IntoMap
        public abstract ViewModel binds(InboxCountViewModel inboxCountViewModel);

        private BindsModule() {
        }
    }

    @Module
    public static final class KeyModule {
        @Provides
        @LazyClassKey(InboxCountViewModel.class)
        @IntoMap
        public static boolean provide() {
            return true;
        }

        private KeyModule() {
        }
    }
}
