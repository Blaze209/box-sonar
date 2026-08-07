package com.box.android.capture.cpl;

import com.box.android.domain.services.ICapturePreferencesService;
import com.box.android.domain.usecases.capture.LaunchIntoCaptureUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class CaptureSettingsEnvironment_Factory implements Factory<CaptureSettingsEnvironment> {
    private final Provider<ICapturePreferencesService> capturePreferencesServiceProvider;
    private final Provider<LaunchIntoCaptureUseCase> launchIntoCaptureUseCaseProvider;

    private CaptureSettingsEnvironment_Factory(Provider<LaunchIntoCaptureUseCase> provider, Provider<ICapturePreferencesService> provider2) {
        this.launchIntoCaptureUseCaseProvider = provider;
        this.capturePreferencesServiceProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CaptureSettingsEnvironment get() {
        return newInstance(this.launchIntoCaptureUseCaseProvider.get(), this.capturePreferencesServiceProvider.get());
    }

    public static CaptureSettingsEnvironment_Factory create(Provider<LaunchIntoCaptureUseCase> provider, Provider<ICapturePreferencesService> provider2) {
        return new CaptureSettingsEnvironment_Factory(provider, provider2);
    }

    public static CaptureSettingsEnvironment newInstance(LaunchIntoCaptureUseCase launchIntoCaptureUseCase, ICapturePreferencesService iCapturePreferencesService) {
        return new CaptureSettingsEnvironment(launchIntoCaptureUseCase, iCapturePreferencesService);
    }
}
