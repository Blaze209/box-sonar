package com.box.android.di;

import com.box.android.coreservices.observability.appstart.IAppStartDestinationPageHolder;
import com.box.android.observability.appstart.AuthenticationAppStartDestinationPage;
import com.box.android.observability.appstart.BrowseTabAppStartDestinationPage;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class BoxModule_Companion_ProvidesAppStartTargetHolderFactory implements Factory<IAppStartDestinationPageHolder> {
    private final Provider<AuthenticationAppStartDestinationPage> authenticationAppStartDestinationPageProvider;
    private final Provider<BrowseTabAppStartDestinationPage> browseTabAppStartDestinationPageProvider;

    private BoxModule_Companion_ProvidesAppStartTargetHolderFactory(Provider<AuthenticationAppStartDestinationPage> provider, Provider<BrowseTabAppStartDestinationPage> provider2) {
        this.authenticationAppStartDestinationPageProvider = provider;
        this.browseTabAppStartDestinationPageProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public IAppStartDestinationPageHolder get() {
        return providesAppStartTargetHolder(this.authenticationAppStartDestinationPageProvider.get(), this.browseTabAppStartDestinationPageProvider.get());
    }

    public static BoxModule_Companion_ProvidesAppStartTargetHolderFactory create(Provider<AuthenticationAppStartDestinationPage> provider, Provider<BrowseTabAppStartDestinationPage> provider2) {
        return new BoxModule_Companion_ProvidesAppStartTargetHolderFactory(provider, provider2);
    }

    public static IAppStartDestinationPageHolder providesAppStartTargetHolder(AuthenticationAppStartDestinationPage authenticationAppStartDestinationPage, BrowseTabAppStartDestinationPage browseTabAppStartDestinationPage) {
        return (IAppStartDestinationPageHolder) Preconditions.checkNotNullFromProvides(BoxModule.INSTANCE.providesAppStartTargetHolder(authenticationAppStartDestinationPage, browseTabAppStartDestinationPage));
    }
}
