package com.box.android.di;

import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.tasksrepo.TasksRepo;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class BoxModule_Companion_ProvideTasksRepoFactory implements Factory<TasksRepo> {
    private final Provider<IBaseModelController> baseMoCoProvider;
    private final Provider<BoxApiPrivate> boxApiPrivateProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private BoxModule_Companion_ProvideTasksRepoFactory(Provider<IBaseModelController> provider, Provider<BoxApiPrivate> provider2, Provider<IUserContextManager> provider3) {
        this.baseMoCoProvider = provider;
        this.boxApiPrivateProvider = provider2;
        this.userContextManagerProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public TasksRepo get() {
        return provideTasksRepo(this.baseMoCoProvider.get(), this.boxApiPrivateProvider.get(), this.userContextManagerProvider.get());
    }

    public static BoxModule_Companion_ProvideTasksRepoFactory create(Provider<IBaseModelController> provider, Provider<BoxApiPrivate> provider2, Provider<IUserContextManager> provider3) {
        return new BoxModule_Companion_ProvideTasksRepoFactory(provider, provider2, provider3);
    }

    public static TasksRepo provideTasksRepo(IBaseModelController iBaseModelController, BoxApiPrivate boxApiPrivate, IUserContextManager iUserContextManager) {
        return (TasksRepo) Preconditions.checkNotNullFromProvides(BoxModule.INSTANCE.provideTasksRepo(iBaseModelController, boxApiPrivate, iUserContextManager));
    }
}
