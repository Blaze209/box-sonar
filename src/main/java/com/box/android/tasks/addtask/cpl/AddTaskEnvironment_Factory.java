package com.box.android.tasks.addtask.cpl;

import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes13.dex */
public final class AddTaskEnvironment_Factory implements Factory<AddTaskEnvironment> {
    private final Provider<AddTaskFormEnvironment> formEnvironmentProvider;

    private AddTaskEnvironment_Factory(Provider<AddTaskFormEnvironment> provider) {
        this.formEnvironmentProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AddTaskEnvironment get() {
        return newInstance(this.formEnvironmentProvider.get());
    }

    public static AddTaskEnvironment_Factory create(Provider<AddTaskFormEnvironment> provider) {
        return new AddTaskEnvironment_Factory(provider);
    }

    public static AddTaskEnvironment newInstance(AddTaskFormEnvironment addTaskFormEnvironment) {
        return new AddTaskEnvironment(addTaskFormEnvironment);
    }
}
