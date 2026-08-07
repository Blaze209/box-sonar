package com.box.android.tasksrepo;

import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.domain.identity.IUserContextManager;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes13.dex */
public final class TasksRepo_Factory implements Factory<TasksRepo> {
    private final Provider<IBaseModelController> baseMoCoProvider;
    private final Provider<BoxApiPrivate> boxApiPrivateProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private TasksRepo_Factory(Provider<IBaseModelController> provider, Provider<BoxApiPrivate> provider2, Provider<IUserContextManager> provider3) {
        this.baseMoCoProvider = provider;
        this.boxApiPrivateProvider = provider2;
        this.userContextManagerProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public TasksRepo get() {
        return newInstance(this.baseMoCoProvider.get(), this.boxApiPrivateProvider.get(), this.userContextManagerProvider.get());
    }

    public static TasksRepo_Factory create(Provider<IBaseModelController> provider, Provider<BoxApiPrivate> provider2, Provider<IUserContextManager> provider3) {
        return new TasksRepo_Factory(provider, provider2, provider3);
    }

    public static TasksRepo newInstance(IBaseModelController iBaseModelController, BoxApiPrivate boxApiPrivate, IUserContextManager iUserContextManager) {
        return new TasksRepo(iBaseModelController, boxApiPrivate, iUserContextManager);
    }
}
