package com.box.android.domain.initialisation;

import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.services.IClientSettingsService;
import com.box.android.domain.services.IGeniusScanLicenseService;
import com.box.android.domain.services.RumService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class ClientSettingsInitialisation_Factory implements Factory<ClientSettingsInitialisation> {
    private final Provider<IClientSettingsService> clientSettingsServiceProvider;
    private final Provider<FeatureFlips> featureFlipsProvider;
    private final Provider<IGeniusScanLicenseService> geniusScanLicenseServiceProvider;
    private final Provider<RumService> rumServiceProvider;

    private ClientSettingsInitialisation_Factory(Provider<IClientSettingsService> provider, Provider<IGeniusScanLicenseService> provider2, Provider<RumService> provider3, Provider<FeatureFlips> provider4) {
        this.clientSettingsServiceProvider = provider;
        this.geniusScanLicenseServiceProvider = provider2;
        this.rumServiceProvider = provider3;
        this.featureFlipsProvider = provider4;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ClientSettingsInitialisation get() {
        return newInstance(this.clientSettingsServiceProvider.get(), this.geniusScanLicenseServiceProvider.get(), this.rumServiceProvider.get(), this.featureFlipsProvider.get());
    }

    public static ClientSettingsInitialisation_Factory create(Provider<IClientSettingsService> provider, Provider<IGeniusScanLicenseService> provider2, Provider<RumService> provider3, Provider<FeatureFlips> provider4) {
        return new ClientSettingsInitialisation_Factory(provider, provider2, provider3, provider4);
    }

    public static ClientSettingsInitialisation newInstance(IClientSettingsService iClientSettingsService, IGeniusScanLicenseService iGeniusScanLicenseService, RumService rumService, FeatureFlips featureFlips) {
        return new ClientSettingsInitialisation(iClientSettingsService, iGeniusScanLicenseService, rumService, featureFlips);
    }
}
