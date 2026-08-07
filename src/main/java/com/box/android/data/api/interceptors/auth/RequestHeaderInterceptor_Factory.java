package com.box.android.data.api.interceptors.auth;

import com.box.android.domain.services.ISessionManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class RequestHeaderInterceptor_Factory implements Factory<RequestHeaderInterceptor> {
    private final Provider<ISessionManager> sessionManagerProvider;

    private RequestHeaderInterceptor_Factory(Provider<ISessionManager> sessionManagerProvider) {
        this.sessionManagerProvider = sessionManagerProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public RequestHeaderInterceptor get() {
        return newInstance(this.sessionManagerProvider.get());
    }

    public static RequestHeaderInterceptor_Factory create(Provider<ISessionManager> sessionManagerProvider) {
        return new RequestHeaderInterceptor_Factory(sessionManagerProvider);
    }

    public static RequestHeaderInterceptor newInstance(ISessionManager sessionManager) {
        return new RequestHeaderInterceptor(sessionManager);
    }
}
