package com.box.android.capture.viewmodel;

import com.box.android.capture.cpl.CaptureSettingsEnvironment;
import com.box.android.cpl.IStoreFactory;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class CaptureSettingsViewModel_Factory implements Factory<CaptureSettingsViewModel> {
    private final Provider<CaptureSettingsEnvironment> captureSettingsEnvironmentProvider;
    private final Provider<IStoreFactory> storeFactoryProvider;

    private CaptureSettingsViewModel_Factory(Provider<CaptureSettingsEnvironment> provider, Provider<IStoreFactory> provider2) {
        this.captureSettingsEnvironmentProvider = provider;
        this.storeFactoryProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CaptureSettingsViewModel get() {
        return newInstance(this.captureSettingsEnvironmentProvider.get(), this.storeFactoryProvider.get());
    }

    public static CaptureSettingsViewModel_Factory create(Provider<CaptureSettingsEnvironment> provider, Provider<IStoreFactory> provider2) {
        return new CaptureSettingsViewModel_Factory(provider, provider2);
    }

    public static CaptureSettingsViewModel newInstance(CaptureSettingsEnvironment captureSettingsEnvironment, IStoreFactory iStoreFactory) {
        return new CaptureSettingsViewModel(captureSettingsEnvironment, iStoreFactory);
    }
}
