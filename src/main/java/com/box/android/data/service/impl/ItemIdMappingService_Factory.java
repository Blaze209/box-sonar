package com.box.android.data.service.impl;

import com.box.android.data.datasource.localItems.LocalItemsDataSource;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class ItemIdMappingService_Factory implements Factory<ItemIdMappingService> {
    private final Provider<LocalItemsDataSource> localItemsDataSourceProvider;

    private ItemIdMappingService_Factory(Provider<LocalItemsDataSource> localItemsDataSourceProvider) {
        this.localItemsDataSourceProvider = localItemsDataSourceProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ItemIdMappingService get() {
        return newInstance(this.localItemsDataSourceProvider.get());
    }

    public static ItemIdMappingService_Factory create(Provider<LocalItemsDataSource> localItemsDataSourceProvider) {
        return new ItemIdMappingService_Factory(localItemsDataSourceProvider);
    }

    public static ItemIdMappingService newInstance(LocalItemsDataSource localItemsDataSource) {
        return new ItemIdMappingService(localItemsDataSource);
    }
}
