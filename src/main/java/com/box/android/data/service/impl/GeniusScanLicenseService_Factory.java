package com.box.android.data.service.impl;

import android.content.SharedPreferences;
import com.box.android.data.datasource.clientsettings.ClientSettingsRemoteDataSource;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class GeniusScanLicenseService_Factory implements Factory<GeniusScanLicenseService> {
    private final Provider<ClientSettingsRemoteDataSource> clientSettingsRemoteDataSourceProvider;
    private final Provider<SharedPreferences> localGeniusLicensePrefsProvider;

    private GeniusScanLicenseService_Factory(Provider<SharedPreferences> localGeniusLicensePrefsProvider, Provider<ClientSettingsRemoteDataSource> clientSettingsRemoteDataSourceProvider) {
        this.localGeniusLicensePrefsProvider = localGeniusLicensePrefsProvider;
        this.clientSettingsRemoteDataSourceProvider = clientSettingsRemoteDataSourceProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GeniusScanLicenseService get() {
        return newInstance(this.localGeniusLicensePrefsProvider.get(), this.clientSettingsRemoteDataSourceProvider.get());
    }

    public static GeniusScanLicenseService_Factory create(Provider<SharedPreferences> localGeniusLicensePrefsProvider, Provider<ClientSettingsRemoteDataSource> clientSettingsRemoteDataSourceProvider) {
        return new GeniusScanLicenseService_Factory(localGeniusLicensePrefsProvider, clientSettingsRemoteDataSourceProvider);
    }

    public static GeniusScanLicenseService newInstance(SharedPreferences localGeniusLicensePrefs, ClientSettingsRemoteDataSource clientSettingsRemoteDataSource) {
        return new GeniusScanLicenseService(localGeniusLicensePrefs, clientSettingsRemoteDataSource);
    }
}
