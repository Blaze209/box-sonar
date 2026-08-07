package com.box.android.tasks.addtask.viewmodel;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes13.dex */
public final class AddTaskViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provide());
    }

    public static AddTaskViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return AddTaskViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final AddTaskViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new AddTaskViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
