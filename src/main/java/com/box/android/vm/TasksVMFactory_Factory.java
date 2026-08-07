package com.box.android.vm;

import com.box.android.tasksrepo.TasksRepo;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes13.dex */
public final class TasksVMFactory_Factory implements Factory<TasksVMFactory> {
    private final Provider<TasksRepo> tasksRepoProvider;

    private TasksVMFactory_Factory(Provider<TasksRepo> provider) {
        this.tasksRepoProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public TasksVMFactory get() {
        return newInstance(this.tasksRepoProvider.get());
    }

    public static TasksVMFactory_Factory create(Provider<TasksRepo> provider) {
        return new TasksVMFactory_Factory(provider);
    }

    public static TasksVMFactory newInstance(TasksRepo tasksRepo) {
        return new TasksVMFactory(tasksRepo);
    }
}
