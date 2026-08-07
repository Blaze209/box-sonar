package com.box.android.domain.usecases.observability;

import com.box.android.domain.identity.IUserContextManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class UserMetricDecorator_Factory implements Factory<UserMetricDecorator> {
    private final Provider<IUserContextManager> userContextManagerProvider;

    private UserMetricDecorator_Factory(Provider<IUserContextManager> provider) {
        this.userContextManagerProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public UserMetricDecorator get() {
        return newInstance(this.userContextManagerProvider.get());
    }

    public static UserMetricDecorator_Factory create(Provider<IUserContextManager> provider) {
        return new UserMetricDecorator_Factory(provider);
    }

    public static UserMetricDecorator newInstance(IUserContextManager iUserContextManager) {
        return new UserMetricDecorator(iUserContextManager);
    }
}
