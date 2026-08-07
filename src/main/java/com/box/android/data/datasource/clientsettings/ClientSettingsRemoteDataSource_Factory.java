package com.box.android.data.datasource.clientsettings;

import com.box.android.data.api.requests.ClientSettingsRequest;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class ClientSettingsRemoteDataSource_Factory implements Factory<ClientSettingsRemoteDataSource> {
    private final Provider<ClientSettingsRequest> clientSettingsRequestProvider;
    private final Provider<Moshi> moshiProvider;

    private ClientSettingsRemoteDataSource_Factory(Provider<ClientSettingsRequest> clientSettingsRequestProvider, Provider<Moshi> moshiProvider) {
        this.clientSettingsRequestProvider = clientSettingsRequestProvider;
        this.moshiProvider = moshiProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ClientSettingsRemoteDataSource get() {
        return newInstance(this.clientSettingsRequestProvider.get(), this.moshiProvider.get());
    }

    public static ClientSettingsRemoteDataSource_Factory create(Provider<ClientSettingsRequest> clientSettingsRequestProvider, Provider<Moshi> moshiProvider) {
        return new ClientSettingsRemoteDataSource_Factory(clientSettingsRequestProvider, moshiProvider);
    }

    public static ClientSettingsRemoteDataSource newInstance(ClientSettingsRequest clientSettingsRequest, Moshi moshi) {
        return new ClientSettingsRemoteDataSource(clientSettingsRequest, moshi);
    }
}
