package com.box.android.data.datasource.clientsettings;

import com.box.android.domain.identity.IUserContextManager;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class ClientSettingsCacheDataSource_Factory implements Factory<ClientSettingsCacheDataSource> {
    private final Provider<Moshi> moshiProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private ClientSettingsCacheDataSource_Factory(Provider<IUserContextManager> userContextManagerProvider, Provider<Moshi> moshiProvider) {
        this.userContextManagerProvider = userContextManagerProvider;
        this.moshiProvider = moshiProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ClientSettingsCacheDataSource get() {
        return newInstance(this.userContextManagerProvider.get(), this.moshiProvider.get());
    }

    public static ClientSettingsCacheDataSource_Factory create(Provider<IUserContextManager> userContextManagerProvider, Provider<Moshi> moshiProvider) {
        return new ClientSettingsCacheDataSource_Factory(userContextManagerProvider, moshiProvider);
    }

    public static ClientSettingsCacheDataSource newInstance(IUserContextManager userContextManager, Moshi moshi) {
        return new ClientSettingsCacheDataSource(userContextManager, moshi);
    }
}
