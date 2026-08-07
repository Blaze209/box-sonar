package com.box.cirrus.providers;

import com.box.android.domain.services.IClientSettingsService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes13.dex */
public final class BoxAccountSettingsProvider_Factory implements Factory<BoxAccountSettingsProvider> {
    private final Provider<IClientSettingsService> clientSettingsServiceProvider;

    private BoxAccountSettingsProvider_Factory(Provider<IClientSettingsService> provider) {
        this.clientSettingsServiceProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BoxAccountSettingsProvider get() {
        return newInstance(this.clientSettingsServiceProvider.get());
    }

    public static BoxAccountSettingsProvider_Factory create(Provider<IClientSettingsService> provider) {
        return new BoxAccountSettingsProvider_Factory(provider);
    }

    public static BoxAccountSettingsProvider newInstance(IClientSettingsService iClientSettingsService) {
        return new BoxAccountSettingsProvider(iClientSettingsService);
    }
}
