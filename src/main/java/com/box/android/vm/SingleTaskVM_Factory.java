package com.box.android.vm;

import com.box.android.tasksrepo.SingleTaskRepo;
import com.box.android.tasksrepo.TasksRepo;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes13.dex */
public final class SingleTaskVM_Factory implements Factory<SingleTaskVM> {
    private final Provider<SingleTaskRepo> singleTaskRepoProvider;
    private final Provider<TasksRepo> tasksRepoProvider;

    private SingleTaskVM_Factory(Provider<TasksRepo> provider, Provider<SingleTaskRepo> provider2) {
        this.tasksRepoProvider = provider;
        this.singleTaskRepoProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public SingleTaskVM get() {
        return newInstance(this.tasksRepoProvider.get(), this.singleTaskRepoProvider.get());
    }

    public static SingleTaskVM_Factory create(Provider<TasksRepo> provider, Provider<SingleTaskRepo> provider2) {
        return new SingleTaskVM_Factory(provider, provider2);
    }

    public static SingleTaskVM newInstance(TasksRepo tasksRepo, SingleTaskRepo singleTaskRepo) {
        return new SingleTaskVM(tasksRepo, singleTaskRepo);
    }
}
