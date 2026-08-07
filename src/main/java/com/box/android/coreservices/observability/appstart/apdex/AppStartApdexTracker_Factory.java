package com.box.android.coreservices.observability.appstart.apdex;

import com.box.android.coreservices.observability.appstart.IAppStartDestinationPageHolder;
import com.box.android.domain.services.ApdexService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class AppStartApdexTracker_Factory implements Factory<AppStartApdexTracker> {
    private final Provider<ApdexService> apdexServiceProvider;
    private final Provider<IAppStartDestinationPageHolder> appStartDestinationPageHolderProvider;

    private AppStartApdexTracker_Factory(Provider<ApdexService> provider, Provider<IAppStartDestinationPageHolder> provider2) {
        this.apdexServiceProvider = provider;
        this.appStartDestinationPageHolderProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AppStartApdexTracker get() {
        return newInstance(this.apdexServiceProvider.get(), this.appStartDestinationPageHolderProvider.get());
    }

    public static AppStartApdexTracker_Factory create(Provider<ApdexService> provider, Provider<IAppStartDestinationPageHolder> provider2) {
        return new AppStartApdexTracker_Factory(provider, provider2);
    }

    public static AppStartApdexTracker newInstance(ApdexService apdexService, IAppStartDestinationPageHolder iAppStartDestinationPageHolder) {
        return new AppStartApdexTracker(apdexService, iAppStartDestinationPageHolder);
    }
}
