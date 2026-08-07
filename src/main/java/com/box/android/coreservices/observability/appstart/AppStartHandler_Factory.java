package com.box.android.coreservices.observability.appstart;

import com.box.android.coreservices.observability.appstart.helpers.ColdStartCalculation;
import com.box.android.domain.services.IAppInBackgroundService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class AppStartHandler_Factory implements Factory<AppStartHandler> {
    private final Provider<IAppInBackgroundService> appInBackgroundServiceProvider;
    private final Provider<ColdStartCalculation> coldStartCalculationProvider;

    private AppStartHandler_Factory(Provider<IAppInBackgroundService> provider, Provider<ColdStartCalculation> provider2) {
        this.appInBackgroundServiceProvider = provider;
        this.coldStartCalculationProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AppStartHandler get() {
        return newInstance(this.appInBackgroundServiceProvider.get(), this.coldStartCalculationProvider.get());
    }

    public static AppStartHandler_Factory create(Provider<IAppInBackgroundService> provider, Provider<ColdStartCalculation> provider2) {
        return new AppStartHandler_Factory(provider, provider2);
    }

    public static AppStartHandler newInstance(IAppInBackgroundService iAppInBackgroundService, ColdStartCalculation coldStartCalculation) {
        return new AppStartHandler(iAppInBackgroundService, coldStartCalculation);
    }
}
