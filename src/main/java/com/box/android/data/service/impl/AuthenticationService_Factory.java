package com.box.android.data.service.impl;

import com.box.android.data.datasource.auth.AuthenticationRemoteDataSource;
import com.box.android.domain.services.IAuthenticationCredentialsProvider;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class AuthenticationService_Factory implements Factory<AuthenticationService> {
    private final Provider<IAuthenticationCredentialsProvider> authenticationCredentialsProvider;
    private final Provider<AuthenticationRemoteDataSource> authenticationRemoteDataSourceProvider;

    private AuthenticationService_Factory(Provider<AuthenticationRemoteDataSource> authenticationRemoteDataSourceProvider, Provider<IAuthenticationCredentialsProvider> authenticationCredentialsProvider) {
        this.authenticationRemoteDataSourceProvider = authenticationRemoteDataSourceProvider;
        this.authenticationCredentialsProvider = authenticationCredentialsProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AuthenticationService get() {
        return newInstance(this.authenticationRemoteDataSourceProvider.get(), this.authenticationCredentialsProvider.get());
    }

    public static AuthenticationService_Factory create(Provider<AuthenticationRemoteDataSource> authenticationRemoteDataSourceProvider, Provider<IAuthenticationCredentialsProvider> authenticationCredentialsProvider) {
        return new AuthenticationService_Factory(authenticationRemoteDataSourceProvider, authenticationCredentialsProvider);
    }

    public static AuthenticationService newInstance(AuthenticationRemoteDataSource authenticationRemoteDataSource, IAuthenticationCredentialsProvider authenticationCredentialsProvider) {
        return new AuthenticationService(authenticationRemoteDataSource, authenticationCredentialsProvider);
    }
}
