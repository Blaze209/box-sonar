package com.box.android.data.service.impl;

import com.box.android.domain.services.ISessionManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class OAuthAccessTokenService_Factory implements Factory<OAuthAccessTokenService> {
    private final Provider<ISessionManager> sessionManagerProvider;

    private OAuthAccessTokenService_Factory(Provider<ISessionManager> sessionManagerProvider) {
        this.sessionManagerProvider = sessionManagerProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public OAuthAccessTokenService get() {
        return newInstance(this.sessionManagerProvider.get());
    }

    public static OAuthAccessTokenService_Factory create(Provider<ISessionManager> sessionManagerProvider) {
        return new OAuthAccessTokenService_Factory(sessionManagerProvider);
    }

    public static OAuthAccessTokenService newInstance(ISessionManager sessionManager) {
        return new OAuthAccessTokenService(sessionManager);
    }
}
