package com.box.android.clientadmin;

import com.box.android.data.service.impl.ClientSettingsService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class BoxAdminSettingsProvider_Factory implements Factory<BoxAdminSettingsProvider> {
    private final Provider<ClientSettingsService> clientSettingsServiceProvider;

    private BoxAdminSettingsProvider_Factory(Provider<ClientSettingsService> provider) {
        this.clientSettingsServiceProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BoxAdminSettingsProvider get() {
        return newInstance(this.clientSettingsServiceProvider.get());
    }

    public static BoxAdminSettingsProvider_Factory create(Provider<ClientSettingsService> provider) {
        return new BoxAdminSettingsProvider_Factory(provider);
    }

    public static BoxAdminSettingsProvider newInstance(ClientSettingsService clientSettingsService) {
        return new BoxAdminSettingsProvider(clientSettingsService);
    }
}
