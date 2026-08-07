package com.box.android.preview.wopi;

import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.services.IClientSettingsService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class WopiService_Factory implements Factory<WopiService> {
    private final Provider<IClientSettingsService> clientSettingsServiceProvider;
    private final Provider<FeatureFlips> featureFlipsProvider;
    private final Provider<IOfficeAppDetector> officeAppDetectorProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private WopiService_Factory(Provider<IUserContextManager> provider, Provider<IOfficeAppDetector> provider2, Provider<FeatureFlips> provider3, Provider<IClientSettingsService> provider4) {
        this.userContextManagerProvider = provider;
        this.officeAppDetectorProvider = provider2;
        this.featureFlipsProvider = provider3;
        this.clientSettingsServiceProvider = provider4;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public WopiService get() {
        return newInstance(this.userContextManagerProvider.get(), this.officeAppDetectorProvider.get(), this.featureFlipsProvider.get(), this.clientSettingsServiceProvider.get());
    }

    public static WopiService_Factory create(Provider<IUserContextManager> provider, Provider<IOfficeAppDetector> provider2, Provider<FeatureFlips> provider3, Provider<IClientSettingsService> provider4) {
        return new WopiService_Factory(provider, provider2, provider3, provider4);
    }

    public static WopiService newInstance(IUserContextManager iUserContextManager, IOfficeAppDetector iOfficeAppDetector, FeatureFlips featureFlips, IClientSettingsService iClientSettingsService) {
        return new WopiService(iUserContextManager, iOfficeAppDetector, featureFlips, iClientSettingsService);
    }
}
