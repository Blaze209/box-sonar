package com.box.android.data.service.impl;

import android.content.Context;
import com.box.android.domain.identity.IUserContextManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class SessionManager_Factory implements Factory<SessionManager> {
    private final Provider<Context> contextProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private SessionManager_Factory(Provider<IUserContextManager> userContextManagerProvider, Provider<Context> contextProvider) {
        this.userContextManagerProvider = userContextManagerProvider;
        this.contextProvider = contextProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public SessionManager get() {
        return newInstance(this.userContextManagerProvider.get(), this.contextProvider.get());
    }

    public static SessionManager_Factory create(Provider<IUserContextManager> userContextManagerProvider, Provider<Context> contextProvider) {
        return new SessionManager_Factory(userContextManagerProvider, contextProvider);
    }

    public static SessionManager newInstance(IUserContextManager userContextManager, Context context) {
        return new SessionManager(userContextManager, context);
    }
}
