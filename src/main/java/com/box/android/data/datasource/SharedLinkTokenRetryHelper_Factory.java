package com.box.android.data.datasource;

import com.box.android.data.api.requests.AuthRequest;
import com.box.android.data.service.impl.SessionManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class SharedLinkTokenRetryHelper_Factory implements Factory<SharedLinkTokenRetryHelper> {
    private final Provider<AuthRequest> authRequestProvider;
    private final Provider<SessionManager> sessionManagerProvider;

    private SharedLinkTokenRetryHelper_Factory(Provider<SessionManager> sessionManagerProvider, Provider<AuthRequest> authRequestProvider) {
        this.sessionManagerProvider = sessionManagerProvider;
        this.authRequestProvider = authRequestProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public SharedLinkTokenRetryHelper get() {
        return newInstance(this.sessionManagerProvider.get(), this.authRequestProvider.get());
    }

    public static SharedLinkTokenRetryHelper_Factory create(Provider<SessionManager> sessionManagerProvider, Provider<AuthRequest> authRequestProvider) {
        return new SharedLinkTokenRetryHelper_Factory(sessionManagerProvider, authRequestProvider);
    }

    public static SharedLinkTokenRetryHelper newInstance(SessionManager sessionManager, AuthRequest authRequest) {
        return new SharedLinkTokenRetryHelper(sessionManager, authRequest);
    }
}
