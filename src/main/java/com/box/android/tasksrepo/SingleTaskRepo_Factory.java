package com.box.android.tasksrepo;

import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes13.dex */
public final class SingleTaskRepo_Factory implements Factory<SingleTaskRepo> {
    private final Provider<IBaseModelController> baseMoCoProvider;
    private final Provider<BoxApiPrivate> boxApiPrivateProvider;

    private SingleTaskRepo_Factory(Provider<IBaseModelController> provider, Provider<BoxApiPrivate> provider2) {
        this.baseMoCoProvider = provider;
        this.boxApiPrivateProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public SingleTaskRepo get() {
        return newInstance(this.baseMoCoProvider.get(), this.boxApiPrivateProvider.get());
    }

    public static SingleTaskRepo_Factory create(Provider<IBaseModelController> provider, Provider<BoxApiPrivate> provider2) {
        return new SingleTaskRepo_Factory(provider, provider2);
    }

    public static SingleTaskRepo newInstance(IBaseModelController iBaseModelController, BoxApiPrivate boxApiPrivate) {
        return new SingleTaskRepo(iBaseModelController, boxApiPrivate);
    }
}
