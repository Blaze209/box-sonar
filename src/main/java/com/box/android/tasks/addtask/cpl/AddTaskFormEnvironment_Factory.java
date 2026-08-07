package com.box.android.tasks.addtask.cpl;

import com.box.android.domain.services.ITaskService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes13.dex */
public final class AddTaskFormEnvironment_Factory implements Factory<AddTaskFormEnvironment> {
    private final Provider<AssigneePickerEnvironment> assigneePickerEnvironmentProvider;
    private final Provider<ITaskService> taskServiceProvider;

    private AddTaskFormEnvironment_Factory(Provider<ITaskService> provider, Provider<AssigneePickerEnvironment> provider2) {
        this.taskServiceProvider = provider;
        this.assigneePickerEnvironmentProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AddTaskFormEnvironment get() {
        return newInstance(this.taskServiceProvider.get(), this.assigneePickerEnvironmentProvider.get());
    }

    public static AddTaskFormEnvironment_Factory create(Provider<ITaskService> provider, Provider<AssigneePickerEnvironment> provider2) {
        return new AddTaskFormEnvironment_Factory(provider, provider2);
    }

    public static AddTaskFormEnvironment newInstance(ITaskService iTaskService, AssigneePickerEnvironment assigneePickerEnvironment) {
        return new AddTaskFormEnvironment(iTaskService, assigneePickerEnvironment);
    }
}
