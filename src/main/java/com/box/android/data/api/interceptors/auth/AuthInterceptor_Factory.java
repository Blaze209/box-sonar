package com.box.android.data.api.interceptors.auth;

import com.box.android.domain.services.ISessionManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class AuthInterceptor_Factory implements Factory<AuthInterceptor> {
    private final Provider<ISessionManager> sessionManagerProvider;

    private AuthInterceptor_Factory(Provider<ISessionManager> sessionManagerProvider) {
        this.sessionManagerProvider = sessionManagerProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AuthInterceptor get() {
        return newInstance(this.sessionManagerProvider.get());
    }

    public static AuthInterceptor_Factory create(Provider<ISessionManager> sessionManagerProvider) {
        return new AuthInterceptor_Factory(sessionManagerProvider);
    }

    public static AuthInterceptor newInstance(ISessionManager sessionManager) {
        return new AuthInterceptor(sessionManager);
    }
}
