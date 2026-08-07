package com.box.android.auth;

import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class AuthenticationCredentialsProvider_Factory implements Factory<AuthenticationCredentialsProvider> {
    private final Provider<String> clientIdProvider;
    private final Provider<String> secretProvider;

    private AuthenticationCredentialsProvider_Factory(Provider<String> provider, Provider<String> provider2) {
        this.clientIdProvider = provider;
        this.secretProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AuthenticationCredentialsProvider get() {
        return newInstance(this.clientIdProvider.get(), this.secretProvider.get());
    }

    public static AuthenticationCredentialsProvider_Factory create(Provider<String> provider, Provider<String> provider2) {
        return new AuthenticationCredentialsProvider_Factory(provider, provider2);
    }

    public static AuthenticationCredentialsProvider newInstance(String str, String str2) {
        return new AuthenticationCredentialsProvider(str, str2);
    }
}
