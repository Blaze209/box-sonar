package com.box.android.data.datasource.gql;

import android.content.Context;
import com.box.android.data.api.interceptors.GQLClientRequestInterceptor;
import com.box.android.data.api.interceptors.GQLForceUpdateInterceptor;
import com.box.android.data.api.interceptors.auth.AuthInterceptor;
import com.box.android.data.api.interceptors.auth.SharedLinkAuthInterceptor;
import com.box.android.data.user.UserData;
import com.box.android.domain.services.IBVEManager;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class GQLApolloClientConfigurator_Factory implements Factory<GQLApolloClientConfigurator> {
    private final Provider<AuthInterceptor> authInterceptorProvider;
    private final Provider<IBVEManager> bveManagerProvider;
    private final Provider<Context> contextProvider;
    private final Provider<GQLClientRequestInterceptor> gqlClientRequestInterceptorProvider;
    private final Provider<GQLForceUpdateInterceptor> gqlForceUpdateInterceptorProvider;
    private final Provider<GQLResponseInterceptor> gqlResponseInterceptorProvider;
    private final Provider<SharedLinkAuthInterceptor> sharedLinkAuthInterceptorProvider;
    private final Provider<UserData> userDataProvider;

    private GQLApolloClientConfigurator_Factory(Provider<Context> contextProvider, Provider<UserData> userDataProvider, Provider<AuthInterceptor> authInterceptorProvider, Provider<SharedLinkAuthInterceptor> sharedLinkAuthInterceptorProvider, Provider<GQLClientRequestInterceptor> gqlClientRequestInterceptorProvider, Provider<IBVEManager> bveManagerProvider, Provider<GQLResponseInterceptor> gqlResponseInterceptorProvider, Provider<GQLForceUpdateInterceptor> gqlForceUpdateInterceptorProvider) {
        this.contextProvider = contextProvider;
        this.userDataProvider = userDataProvider;
        this.authInterceptorProvider = authInterceptorProvider;
        this.sharedLinkAuthInterceptorProvider = sharedLinkAuthInterceptorProvider;
        this.gqlClientRequestInterceptorProvider = gqlClientRequestInterceptorProvider;
        this.bveManagerProvider = bveManagerProvider;
        this.gqlResponseInterceptorProvider = gqlResponseInterceptorProvider;
        this.gqlForceUpdateInterceptorProvider = gqlForceUpdateInterceptorProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GQLApolloClientConfigurator get() {
        return newInstance(this.contextProvider.get(), this.userDataProvider.get(), this.authInterceptorProvider.get(), this.sharedLinkAuthInterceptorProvider.get(), this.gqlClientRequestInterceptorProvider.get(), this.bveManagerProvider.get(), DoubleCheck.lazy((Provider) this.gqlResponseInterceptorProvider), DoubleCheck.lazy((Provider) this.gqlForceUpdateInterceptorProvider));
    }

    public static GQLApolloClientConfigurator_Factory create(Provider<Context> contextProvider, Provider<UserData> userDataProvider, Provider<AuthInterceptor> authInterceptorProvider, Provider<SharedLinkAuthInterceptor> sharedLinkAuthInterceptorProvider, Provider<GQLClientRequestInterceptor> gqlClientRequestInterceptorProvider, Provider<IBVEManager> bveManagerProvider, Provider<GQLResponseInterceptor> gqlResponseInterceptorProvider, Provider<GQLForceUpdateInterceptor> gqlForceUpdateInterceptorProvider) {
        return new GQLApolloClientConfigurator_Factory(contextProvider, userDataProvider, authInterceptorProvider, sharedLinkAuthInterceptorProvider, gqlClientRequestInterceptorProvider, bveManagerProvider, gqlResponseInterceptorProvider, gqlForceUpdateInterceptorProvider);
    }

    public static GQLApolloClientConfigurator newInstance(Context context, UserData userData, AuthInterceptor authInterceptor, SharedLinkAuthInterceptor sharedLinkAuthInterceptor, GQLClientRequestInterceptor gqlClientRequestInterceptor, IBVEManager bveManager, Lazy<GQLResponseInterceptor> gqlResponseInterceptor, Lazy<GQLForceUpdateInterceptor> gqlForceUpdateInterceptor) {
        return new GQLApolloClientConfigurator(context, userData, authInterceptor, sharedLinkAuthInterceptor, gqlClientRequestInterceptor, bveManager, gqlResponseInterceptor, gqlForceUpdateInterceptor);
    }
}
