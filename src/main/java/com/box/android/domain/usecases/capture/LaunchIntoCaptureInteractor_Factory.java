package com.box.android.domain.usecases.capture;

import com.box.android.domain.localrepo.ILocalSharedPreferences;
import com.box.android.domain.services.IAppInBackgroundService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class LaunchIntoCaptureInteractor_Factory implements Factory<LaunchIntoCaptureInteractor> {
    private final Provider<IAppInBackgroundService> appInBackgroundServiceProvider;
    private final Provider<ILocalSharedPreferences> prefsProvider;

    private LaunchIntoCaptureInteractor_Factory(Provider<ILocalSharedPreferences> provider, Provider<IAppInBackgroundService> provider2) {
        this.prefsProvider = provider;
        this.appInBackgroundServiceProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public LaunchIntoCaptureInteractor get() {
        return newInstance(this.prefsProvider.get(), this.appInBackgroundServiceProvider.get());
    }

    public static LaunchIntoCaptureInteractor_Factory create(Provider<ILocalSharedPreferences> provider, Provider<IAppInBackgroundService> provider2) {
        return new LaunchIntoCaptureInteractor_Factory(provider, provider2);
    }

    public static LaunchIntoCaptureInteractor newInstance(ILocalSharedPreferences iLocalSharedPreferences, IAppInBackgroundService iAppInBackgroundService) {
        return new LaunchIntoCaptureInteractor(iLocalSharedPreferences, iAppInBackgroundService);
    }
}
