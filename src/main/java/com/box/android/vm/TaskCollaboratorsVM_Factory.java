package com.box.android.vm;

import com.box.android.tasksrepo.SingleTaskRepo;
import com.box.android.tasksrepo.TaskCollaboratorsRepo;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes13.dex */
public final class TaskCollaboratorsVM_Factory implements Factory<TaskCollaboratorsVM> {
    private final Provider<TaskCollaboratorsRepo> taskCollaboratorsRepoProvider;
    private final Provider<SingleTaskRepo> taskRepoProvider;

    private TaskCollaboratorsVM_Factory(Provider<TaskCollaboratorsRepo> provider, Provider<SingleTaskRepo> provider2) {
        this.taskCollaboratorsRepoProvider = provider;
        this.taskRepoProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public TaskCollaboratorsVM get() {
        return newInstance(this.taskCollaboratorsRepoProvider.get(), this.taskRepoProvider.get());
    }

    public static TaskCollaboratorsVM_Factory create(Provider<TaskCollaboratorsRepo> provider, Provider<SingleTaskRepo> provider2) {
        return new TaskCollaboratorsVM_Factory(provider, provider2);
    }

    public static TaskCollaboratorsVM newInstance(TaskCollaboratorsRepo taskCollaboratorsRepo, SingleTaskRepo singleTaskRepo) {
        return new TaskCollaboratorsVM(taskCollaboratorsRepo, singleTaskRepo);
    }
}
