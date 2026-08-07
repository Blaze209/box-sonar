package com.box.android.capture.documentscanning.logic;

import com.box.android.domain.services.IGeniusScanLicenseService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class GeniusScanLicenseInitializer_Factory implements Factory<GeniusScanLicenseInitializer> {
    private final Provider<IGeniusScanLicenseService> geniusScanLicenseServiceProvider;

    private GeniusScanLicenseInitializer_Factory(Provider<IGeniusScanLicenseService> provider) {
        this.geniusScanLicenseServiceProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GeniusScanLicenseInitializer get() {
        return newInstance(this.geniusScanLicenseServiceProvider.get());
    }

    public static GeniusScanLicenseInitializer_Factory create(Provider<IGeniusScanLicenseService> provider) {
        return new GeniusScanLicenseInitializer_Factory(provider);
    }

    public static GeniusScanLicenseInitializer newInstance(IGeniusScanLicenseService iGeniusScanLicenseService) {
        return new GeniusScanLicenseInitializer(iGeniusScanLicenseService);
    }
}
