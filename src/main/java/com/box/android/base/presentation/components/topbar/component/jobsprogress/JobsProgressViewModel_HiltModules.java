package com.box.android.base.presentation.components.topbar.component.jobsprogress;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.LazyClassKey;

/* JADX INFO: loaded from: classes9.dex */
public final class JobsProgressViewModel_HiltModules {
    private JobsProgressViewModel_HiltModules() {
    }

    @Module
    public static abstract class BindsModule {
        @LazyClassKey(JobsProgressViewModel.class)
        @Binds
        @IntoMap
        public abstract ViewModel binds(JobsProgressViewModel jobsProgressViewModel);

        private BindsModule() {
        }
    }

    @Module
    public static final class KeyModule {
        @Provides
        @LazyClassKey(JobsProgressViewModel.class)
        @IntoMap
        public static boolean provide() {
            return true;
        }

        private KeyModule() {
        }
    }
}
