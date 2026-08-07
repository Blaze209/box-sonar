package com.box.android.data.webBridgeAuth;

import com.box.android.domain.services.AuthTokenService;
import com.box.android.domain.webBridgeAuth.IBoxCsrfTokenManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class BoxWebBridgeAuthenticator_Factory implements Factory<BoxWebBridgeAuthenticator> {
    private final Provider<AuthTokenService> authTokenServiceProvider;
    private final Provider<IBoxCsrfTokenManager> validatorProvider;

    private BoxWebBridgeAuthenticator_Factory(Provider<IBoxCsrfTokenManager> validatorProvider, Provider<AuthTokenService> authTokenServiceProvider) {
        this.validatorProvider = validatorProvider;
        this.authTokenServiceProvider = authTokenServiceProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BoxWebBridgeAuthenticator get() {
        return newInstance(this.validatorProvider.get(), this.authTokenServiceProvider.get());
    }

    public static BoxWebBridgeAuthenticator_Factory create(Provider<IBoxCsrfTokenManager> validatorProvider, Provider<AuthTokenService> authTokenServiceProvider) {
        return new BoxWebBridgeAuthenticator_Factory(validatorProvider, authTokenServiceProvider);
    }

    public static BoxWebBridgeAuthenticator newInstance(IBoxCsrfTokenManager validator, AuthTokenService authTokenService) {
        return new BoxWebBridgeAuthenticator(validator, authTokenService);
    }
}
