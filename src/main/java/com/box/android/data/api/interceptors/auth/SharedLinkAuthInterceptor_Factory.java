package com.box.android.data.api.interceptors.auth;

import com.box.android.data.service.impl.SessionManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class SharedLinkAuthInterceptor_Factory implements Factory<SharedLinkAuthInterceptor> {
    private final Provider<SessionManager> sessionManagerProvider;

    private SharedLinkAuthInterceptor_Factory(Provider<SessionManager> sessionManagerProvider) {
        this.sessionManagerProvider = sessionManagerProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public SharedLinkAuthInterceptor get() {
        return newInstance(this.sessionManagerProvider.get());
    }

    public static SharedLinkAuthInterceptor_Factory create(Provider<SessionManager> sessionManagerProvider) {
        return new SharedLinkAuthInterceptor_Factory(sessionManagerProvider);
    }

    public static SharedLinkAuthInterceptor newInstance(SessionManager sessionManager) {
        return new SharedLinkAuthInterceptor(sessionManager);
    }
}
