package com.box.android.observability.appstart;

import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class AppStartDestinationPageHolder_Factory implements Factory<AppStartDestinationPageHolder> {
    private final Provider<AuthenticationAppStartDestinationPage> authenticationAppStartDestinationPageProvider;
    private final Provider<BrowseTabAppStartDestinationPage> browseTabAppStartDestinationPageProvider;

    private AppStartDestinationPageHolder_Factory(Provider<AuthenticationAppStartDestinationPage> provider, Provider<BrowseTabAppStartDestinationPage> provider2) {
        this.authenticationAppStartDestinationPageProvider = provider;
        this.browseTabAppStartDestinationPageProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AppStartDestinationPageHolder get() {
        return newInstance(this.authenticationAppStartDestinationPageProvider.get(), this.browseTabAppStartDestinationPageProvider.get());
    }

    public static AppStartDestinationPageHolder_Factory create(Provider<AuthenticationAppStartDestinationPage> provider, Provider<BrowseTabAppStartDestinationPage> provider2) {
        return new AppStartDestinationPageHolder_Factory(provider, provider2);
    }

    public static AppStartDestinationPageHolder newInstance(AuthenticationAppStartDestinationPage authenticationAppStartDestinationPage, BrowseTabAppStartDestinationPage browseTabAppStartDestinationPage) {
        return new AppStartDestinationPageHolder(authenticationAppStartDestinationPage, browseTabAppStartDestinationPage);
    }
}
