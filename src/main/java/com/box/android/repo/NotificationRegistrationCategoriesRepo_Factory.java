package com.box.android.repo;

import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.domain.identity.IUserContextManager;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class NotificationRegistrationCategoriesRepo_Factory implements Factory<NotificationRegistrationCategoriesRepo> {
    private final Provider<IBaseModelController> baseMoCoProvider;
    private final Provider<BoxApiPrivate> boxApiPrivateProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private NotificationRegistrationCategoriesRepo_Factory(Provider<IBaseModelController> provider, Provider<BoxApiPrivate> provider2, Provider<IUserContextManager> provider3) {
        this.baseMoCoProvider = provider;
        this.boxApiPrivateProvider = provider2;
        this.userContextManagerProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public NotificationRegistrationCategoriesRepo get() {
        return newInstance(this.baseMoCoProvider.get(), this.boxApiPrivateProvider.get(), this.userContextManagerProvider.get());
    }

    public static NotificationRegistrationCategoriesRepo_Factory create(Provider<IBaseModelController> provider, Provider<BoxApiPrivate> provider2, Provider<IUserContextManager> provider3) {
        return new NotificationRegistrationCategoriesRepo_Factory(provider, provider2, provider3);
    }

    public static NotificationRegistrationCategoriesRepo newInstance(IBaseModelController iBaseModelController, BoxApiPrivate boxApiPrivate, IUserContextManager iUserContextManager) {
        return new NotificationRegistrationCategoriesRepo(iBaseModelController, boxApiPrivate, iUserContextManager);
    }
}
