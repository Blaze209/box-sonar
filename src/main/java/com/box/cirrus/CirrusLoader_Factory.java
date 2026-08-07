package com.box.cirrus;

import com.box.cirrus.providers.BoxAccountSettingsProvider;
import com.box.cirrus.providers.BoxAnalyticsProvider;
import com.box.cirrus.providers.BoxAuthProvider;
import com.box.cirrus.providers.BoxConfigProvider;
import com.box.cirrus.providers.BoxContentUploadService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes13.dex */
public final class CirrusLoader_Factory implements Factory<CirrusLoader> {
    private final Provider<BoxAccountSettingsProvider> accountSettingsProvider;
    private final Provider<BoxAnalyticsProvider> analyticsProvider;
    private final Provider<BoxAuthProvider> authProvider;
    private final Provider<BoxContentUploadService> boxContentUploadServiceProvider;
    private final Provider<BoxConfigProvider> configProvider;

    private CirrusLoader_Factory(Provider<BoxAuthProvider> provider, Provider<BoxConfigProvider> provider2, Provider<BoxAnalyticsProvider> provider3, Provider<BoxContentUploadService> provider4, Provider<BoxAccountSettingsProvider> provider5) {
        this.authProvider = provider;
        this.configProvider = provider2;
        this.analyticsProvider = provider3;
        this.boxContentUploadServiceProvider = provider4;
        this.accountSettingsProvider = provider5;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CirrusLoader get() {
        return newInstance(this.authProvider.get(), this.configProvider.get(), this.analyticsProvider.get(), this.boxContentUploadServiceProvider.get(), this.accountSettingsProvider.get());
    }

    public static CirrusLoader_Factory create(Provider<BoxAuthProvider> provider, Provider<BoxConfigProvider> provider2, Provider<BoxAnalyticsProvider> provider3, Provider<BoxContentUploadService> provider4, Provider<BoxAccountSettingsProvider> provider5) {
        return new CirrusLoader_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static CirrusLoader newInstance(BoxAuthProvider boxAuthProvider, BoxConfigProvider boxConfigProvider, BoxAnalyticsProvider boxAnalyticsProvider, BoxContentUploadService boxContentUploadService, BoxAccountSettingsProvider boxAccountSettingsProvider) {
        return new CirrusLoader(boxAuthProvider, boxConfigProvider, boxAnalyticsProvider, boxContentUploadService, boxAccountSettingsProvider);
    }
}
