package com.box.android.tasksrepo;

import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes13.dex */
public final class TaskCollaboratorsRepo_Factory implements Factory<TaskCollaboratorsRepo> {
    private final Provider<IBaseModelController> baseMoCoProvider;
    private final Provider<BoxApiPrivate> boxApiPrivateProvider;

    private TaskCollaboratorsRepo_Factory(Provider<IBaseModelController> provider, Provider<BoxApiPrivate> provider2) {
        this.baseMoCoProvider = provider;
        this.boxApiPrivateProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public TaskCollaboratorsRepo get() {
        return newInstance(this.baseMoCoProvider.get(), this.boxApiPrivateProvider.get());
    }

    public static TaskCollaboratorsRepo_Factory create(Provider<IBaseModelController> provider, Provider<BoxApiPrivate> provider2) {
        return new TaskCollaboratorsRepo_Factory(provider, provider2);
    }

    public static TaskCollaboratorsRepo newInstance(IBaseModelController iBaseModelController, BoxApiPrivate boxApiPrivate) {
        return new TaskCollaboratorsRepo(iBaseModelController, boxApiPrivate);
    }
}
