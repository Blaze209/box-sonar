package com.box.android.vm;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes13.dex */
public final class TaskCollaboratorsVM_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provide());
    }

    public static TaskCollaboratorsVM_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return TaskCollaboratorsVM_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final TaskCollaboratorsVM_HiltModules_KeyModule_ProvideFactory INSTANCE = new TaskCollaboratorsVM_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
