package com.box.android.data.service.impl;

import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.Preferences;
import com.box.android.data.datasource.search.FilesSearchRemoteDataSource;
import com.box.android.domain.services.IdMappingService;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class SearchService_Factory implements Factory<SearchService> {
    private final Provider<DataStore<Preferences>> dataStoreProvider;
    private final Provider<FilesSearchRemoteDataSource> filesSearchRemoteDataSourceProvider;
    private final Provider<HubsService> hubsServiceProvider;
    private final Provider<IdMappingService> idMappingServiceProvider;
    private final Provider<Moshi> moshiProvider;

    private SearchService_Factory(Provider<HubsService> hubsServiceProvider, Provider<FilesSearchRemoteDataSource> filesSearchRemoteDataSourceProvider, Provider<IdMappingService> idMappingServiceProvider, Provider<DataStore<Preferences>> dataStoreProvider, Provider<Moshi> moshiProvider) {
        this.hubsServiceProvider = hubsServiceProvider;
        this.filesSearchRemoteDataSourceProvider = filesSearchRemoteDataSourceProvider;
        this.idMappingServiceProvider = idMappingServiceProvider;
        this.dataStoreProvider = dataStoreProvider;
        this.moshiProvider = moshiProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public SearchService get() {
        return newInstance(this.hubsServiceProvider.get(), this.filesSearchRemoteDataSourceProvider.get(), this.idMappingServiceProvider.get(), this.dataStoreProvider.get(), this.moshiProvider.get());
    }

    public static SearchService_Factory create(Provider<HubsService> hubsServiceProvider, Provider<FilesSearchRemoteDataSource> filesSearchRemoteDataSourceProvider, Provider<IdMappingService> idMappingServiceProvider, Provider<DataStore<Preferences>> dataStoreProvider, Provider<Moshi> moshiProvider) {
        return new SearchService_Factory(hubsServiceProvider, filesSearchRemoteDataSourceProvider, idMappingServiceProvider, dataStoreProvider, moshiProvider);
    }

    public static SearchService newInstance(HubsService hubsService, FilesSearchRemoteDataSource filesSearchRemoteDataSource, IdMappingService idMappingService, DataStore<Preferences> dataStore, Moshi moshi) {
        return new SearchService(hubsService, filesSearchRemoteDataSource, idMappingService, dataStore, moshi);
    }
}
