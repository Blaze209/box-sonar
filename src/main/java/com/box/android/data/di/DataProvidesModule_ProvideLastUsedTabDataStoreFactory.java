package com.box.android.data.di;

import android.content.Context;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.Preferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DataProvidesModule_ProvideLastUsedTabDataStoreFactory implements Factory<DataStore<Preferences>> {
    private final Provider<Context> contextProvider;
    private final DataProvidesModule module;

    private DataProvidesModule_ProvideLastUsedTabDataStoreFactory(DataProvidesModule module, Provider<Context> contextProvider) {
        this.module = module;
        this.contextProvider = contextProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public DataStore<Preferences> get() {
        return provideLastUsedTabDataStore(this.module, this.contextProvider.get());
    }

    public static DataProvidesModule_ProvideLastUsedTabDataStoreFactory create(DataProvidesModule module, Provider<Context> contextProvider) {
        return new DataProvidesModule_ProvideLastUsedTabDataStoreFactory(module, contextProvider);
    }

    public static DataStore<Preferences> provideLastUsedTabDataStore(DataProvidesModule instance, Context context) {
        return (DataStore) Preconditions.checkNotNullFromProvides(instance.provideLastUsedTabDataStore(context));
    }
}
