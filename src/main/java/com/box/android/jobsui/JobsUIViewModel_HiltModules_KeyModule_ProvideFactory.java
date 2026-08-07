package com.box.android.jobsui;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes12.dex */
public final class JobsUIViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provide());
    }

    public static JobsUIViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return JobsUIViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final JobsUIViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new JobsUIViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
