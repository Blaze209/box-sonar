package com.box.android.domain.usecases;

import com.box.android.domain.services.IUserService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class UserInteractor_Factory implements Factory<UserInteractor> {
    private final Provider<IUserService> userServiceProvider;

    private UserInteractor_Factory(Provider<IUserService> provider) {
        this.userServiceProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public UserInteractor get() {
        return newInstance(this.userServiceProvider.get());
    }

    public static UserInteractor_Factory create(Provider<IUserService> provider) {
        return new UserInteractor_Factory(provider);
    }

    public static UserInteractor newInstance(IUserService iUserService) {
        return new UserInteractor(iUserService);
    }
}
