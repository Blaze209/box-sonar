package com.box.android.data.datasource.auth;

import com.box.android.data.api.requests.AuthRequest;
import com.box.android.data.service.impl.AppRestrictionsManager;
import com.box.android.domain.services.IBVEManager;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class AuthenticationRemoteDataSource_Factory implements Factory<AuthenticationRemoteDataSource> {
    private final Provider<AppRestrictionsManager> appRestrictionsManagerProvider;
    private final Provider<AuthRequest> authRequestProvider;
    private final Provider<IBVEManager> bveManagerProvider;
    private final Provider<Moshi> moshiProvider;

    private AuthenticationRemoteDataSource_Factory(Provider<AuthRequest> authRequestProvider, Provider<Moshi> moshiProvider, Provider<AppRestrictionsManager> appRestrictionsManagerProvider, Provider<IBVEManager> bveManagerProvider) {
        this.authRequestProvider = authRequestProvider;
        this.moshiProvider = moshiProvider;
        this.appRestrictionsManagerProvider = appRestrictionsManagerProvider;
        this.bveManagerProvider = bveManagerProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AuthenticationRemoteDataSource get() {
        return newInstance(this.authRequestProvider.get(), this.moshiProvider.get(), this.appRestrictionsManagerProvider.get(), this.bveManagerProvider.get());
    }

    public static AuthenticationRemoteDataSource_Factory create(Provider<AuthRequest> authRequestProvider, Provider<Moshi> moshiProvider, Provider<AppRestrictionsManager> appRestrictionsManagerProvider, Provider<IBVEManager> bveManagerProvider) {
        return new AuthenticationRemoteDataSource_Factory(authRequestProvider, moshiProvider, appRestrictionsManagerProvider, bveManagerProvider);
    }

    public static AuthenticationRemoteDataSource newInstance(AuthRequest authRequest, Moshi moshi, AppRestrictionsManager appRestrictionsManager, IBVEManager bveManager) {
        return new AuthenticationRemoteDataSource(authRequest, moshi, appRestrictionsManager, bveManager);
    }
}
