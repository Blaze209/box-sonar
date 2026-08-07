package com.box.android.base.presentation.components.topbar.component.jobsprogress;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes9.dex */
public final class JobsProgressViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provide());
    }

    public static JobsProgressViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return JobsProgressViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final JobsProgressViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new JobsProgressViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
