package com.box.cirrus.providers;

import com.box.android.domain.services.AuthTokenService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes13.dex */
public final class BoxAuthProvider_Factory implements Factory<BoxAuthProvider> {
    private final Provider<AuthTokenService> authTokenServiceProvider;

    private BoxAuthProvider_Factory(Provider<AuthTokenService> provider) {
        this.authTokenServiceProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BoxAuthProvider get() {
        return newInstance(this.authTokenServiceProvider.get());
    }

    public static BoxAuthProvider_Factory create(Provider<AuthTokenService> provider) {
        return new BoxAuthProvider_Factory(provider);
    }

    public static BoxAuthProvider newInstance(AuthTokenService authTokenService) {
        return new BoxAuthProvider(authTokenService);
    }
}
