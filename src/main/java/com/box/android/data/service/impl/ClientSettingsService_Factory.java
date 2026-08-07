package com.box.android.data.service.impl;

import com.box.android.data.datasource.clientsettings.ClientSettingsCacheDataSource;
import com.box.android.data.datasource.clientsettings.ClientSettingsRemoteDataSource;
import com.box.android.domain.identity.IUserContextManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class ClientSettingsService_Factory implements Factory<ClientSettingsService> {
    private final Provider<ClientSettingsCacheDataSource> clientSettingsCacheDataSourceProvider;
    private final Provider<ClientSettingsRemoteDataSource> clientSettingsRemoteDataSourceProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private ClientSettingsService_Factory(Provider<IUserContextManager> userContextManagerProvider, Provider<ClientSettingsRemoteDataSource> clientSettingsRemoteDataSourceProvider, Provider<ClientSettingsCacheDataSource> clientSettingsCacheDataSourceProvider) {
        this.userContextManagerProvider = userContextManagerProvider;
        this.clientSettingsRemoteDataSourceProvider = clientSettingsRemoteDataSourceProvider;
        this.clientSettingsCacheDataSourceProvider = clientSettingsCacheDataSourceProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ClientSettingsService get() {
        return newInstance(this.userContextManagerProvider.get(), this.clientSettingsRemoteDataSourceProvider.get(), this.clientSettingsCacheDataSourceProvider.get());
    }

    public static ClientSettingsService_Factory create(Provider<IUserContextManager> userContextManagerProvider, Provider<ClientSettingsRemoteDataSource> clientSettingsRemoteDataSourceProvider, Provider<ClientSettingsCacheDataSource> clientSettingsCacheDataSourceProvider) {
        return new ClientSettingsService_Factory(userContextManagerProvider, clientSettingsRemoteDataSourceProvider, clientSettingsCacheDataSourceProvider);
    }

    public static ClientSettingsService newInstance(IUserContextManager userContextManager, ClientSettingsRemoteDataSource clientSettingsRemoteDataSource, ClientSettingsCacheDataSource clientSettingsCacheDataSource) {
        return new ClientSettingsService(userContextManager, clientSettingsRemoteDataSource, clientSettingsCacheDataSource);
    }
}
