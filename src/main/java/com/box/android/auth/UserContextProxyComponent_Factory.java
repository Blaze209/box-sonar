package com.box.android.auth;

import com.box.android.domain.usecases.UserInteractor;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class UserContextProxyComponent_Factory implements Factory<UserContextProxyComponent> {
    private final Provider<UserInteractor> userInteractorProvider;

    private UserContextProxyComponent_Factory(Provider<UserInteractor> provider) {
        this.userInteractorProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public UserContextProxyComponent get() {
        return newInstance(this.userInteractorProvider.get());
    }

    public static UserContextProxyComponent_Factory create(Provider<UserInteractor> provider) {
        return new UserContextProxyComponent_Factory(provider);
    }

    public static UserContextProxyComponent newInstance(UserInteractor userInteractor) {
        return new UserContextProxyComponent(userInteractor);
    }
}
