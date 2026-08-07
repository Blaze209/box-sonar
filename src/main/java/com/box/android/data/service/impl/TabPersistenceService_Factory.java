package com.box.android.data.service.impl;

import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.Preferences;
import com.box.android.domain.identity.IUserContextManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class TabPersistenceService_Factory implements Factory<TabPersistenceService> {
    private final Provider<DataStore<Preferences>> dataStoreProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private TabPersistenceService_Factory(Provider<DataStore<Preferences>> dataStoreProvider, Provider<IUserContextManager> userContextManagerProvider) {
        this.dataStoreProvider = dataStoreProvider;
        this.userContextManagerProvider = userContextManagerProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public TabPersistenceService get() {
        return newInstance(this.dataStoreProvider.get(), this.userContextManagerProvider.get());
    }

    public static TabPersistenceService_Factory create(Provider<DataStore<Preferences>> dataStoreProvider, Provider<IUserContextManager> userContextManagerProvider) {
        return new TabPersistenceService_Factory(dataStoreProvider, userContextManagerProvider);
    }

    public static TabPersistenceService newInstance(DataStore<Preferences> dataStore, IUserContextManager userContextManager) {
        return new TabPersistenceService(dataStore, userContextManager);
    }
}
