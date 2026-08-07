package com.box.android.updates.proposal.presentation;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.LazyClassKey;

/* JADX INFO: loaded from: classes13.dex */
public final class AppUpdateProposalViewModel_HiltModules {
    private AppUpdateProposalViewModel_HiltModules() {
    }

    @Module
    public static abstract class BindsModule {
        @LazyClassKey(AppUpdateProposalViewModel.class)
        @Binds
        @IntoMap
        public abstract ViewModel binds(AppUpdateProposalViewModel appUpdateProposalViewModel);

        private BindsModule() {
        }
    }

    @Module
    public static final class KeyModule {
        @Provides
        @LazyClassKey(AppUpdateProposalViewModel.class)
        @IntoMap
        public static boolean provide() {
            return true;
        }

        private KeyModule() {
        }
    }
}
