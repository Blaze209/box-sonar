package com.box.android.data.datasource;

import com.box.android.data.api.requests.CreateFolderRequest;
import com.box.android.data.api.requests.FolderItemsRequest;
import com.box.android.data.api.requests.ItemInfoRequest;
import com.box.android.data.api.requests.UpdateItemRequest;
import com.box.android.domain.localrepo.LocalSortPreferences;
import com.box.android.domain.metrics.Gen204FolderItemsEventLogger;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class ItemRemoteDataSource_Factory implements Factory<ItemRemoteDataSource> {
    private final Provider<CreateFolderRequest> createFolderRequestProvider;
    private final Provider<FolderItemsRequest> folderItemsRequestProvider;
    private final Provider<Gen204FolderItemsEventLogger> gen204FolderItemsEventLoggerProvider;
    private final Provider<ItemInfoRequest> getItemRequestProvider;
    private final Provider<LocalSortPreferences> localSortPreferencesProvider;
    private final Provider<Moshi> moshiProvider;
    private final Provider<UpdateItemRequest> updateItemRequestProvider;

    private ItemRemoteDataSource_Factory(Provider<CreateFolderRequest> createFolderRequestProvider, Provider<FolderItemsRequest> folderItemsRequestProvider, Provider<UpdateItemRequest> updateItemRequestProvider, Provider<ItemInfoRequest> getItemRequestProvider, Provider<LocalSortPreferences> localSortPreferencesProvider, Provider<Moshi> moshiProvider, Provider<Gen204FolderItemsEventLogger> gen204FolderItemsEventLoggerProvider) {
        this.createFolderRequestProvider = createFolderRequestProvider;
        this.folderItemsRequestProvider = folderItemsRequestProvider;
        this.updateItemRequestProvider = updateItemRequestProvider;
        this.getItemRequestProvider = getItemRequestProvider;
        this.localSortPreferencesProvider = localSortPreferencesProvider;
        this.moshiProvider = moshiProvider;
        this.gen204FolderItemsEventLoggerProvider = gen204FolderItemsEventLoggerProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ItemRemoteDataSource get() {
        return newInstance(this.createFolderRequestProvider.get(), this.folderItemsRequestProvider.get(), this.updateItemRequestProvider.get(), this.getItemRequestProvider.get(), this.localSortPreferencesProvider.get(), this.moshiProvider.get(), this.gen204FolderItemsEventLoggerProvider.get());
    }

    public static ItemRemoteDataSource_Factory create(Provider<CreateFolderRequest> createFolderRequestProvider, Provider<FolderItemsRequest> folderItemsRequestProvider, Provider<UpdateItemRequest> updateItemRequestProvider, Provider<ItemInfoRequest> getItemRequestProvider, Provider<LocalSortPreferences> localSortPreferencesProvider, Provider<Moshi> moshiProvider, Provider<Gen204FolderItemsEventLogger> gen204FolderItemsEventLoggerProvider) {
        return new ItemRemoteDataSource_Factory(createFolderRequestProvider, folderItemsRequestProvider, updateItemRequestProvider, getItemRequestProvider, localSortPreferencesProvider, moshiProvider, gen204FolderItemsEventLoggerProvider);
    }

    public static ItemRemoteDataSource newInstance(CreateFolderRequest createFolderRequest, FolderItemsRequest folderItemsRequest, UpdateItemRequest updateItemRequest, ItemInfoRequest getItemRequest, LocalSortPreferences localSortPreferences, Moshi moshi, Gen204FolderItemsEventLogger gen204FolderItemsEventLogger) {
        return new ItemRemoteDataSource(createFolderRequest, folderItemsRequest, updateItemRequest, getItemRequest, localSortPreferences, moshi, gen204FolderItemsEventLogger);
    }
}
