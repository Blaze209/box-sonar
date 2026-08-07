package com.box.android.data.di;

import android.content.Context;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.Preferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DataProvidesModule_ProvidePreferencesDataStoreFactory implements Factory<DataStore<Preferences>> {
    private final Provider<Context> contextProvider;
    private final DataProvidesModule module;

    private DataProvidesModule_ProvidePreferencesDataStoreFactory(DataProvidesModule module, Provider<Context> contextProvider) {
        this.module = module;
        this.contextProvider = contextProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public DataStore<Preferences> get() {
        return providePreferencesDataStore(this.module, this.contextProvider.get());
    }

    public static DataProvidesModule_ProvidePreferencesDataStoreFactory create(DataProvidesModule module, Provider<Context> contextProvider) {
        return new DataProvidesModule_ProvidePreferencesDataStoreFactory(module, contextProvider);
    }

    public static DataStore<Preferences> providePreferencesDataStore(DataProvidesModule instance, Context context) {
        return (DataStore) Preconditions.checkNotNullFromProvides(instance.providePreferencesDataStore(context));
    }
}
