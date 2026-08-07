package com.box.android.data.service.impl;

import com.box.android.data.datasource.item.ItemCollaborationsRemoteDataSource;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.services.IdMappingService;
import com.box.androidsdk.content.BoxCache;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class ItemCollaborationsService_Factory implements Factory<ItemCollaborationsService> {
    private final Provider<BoxCache> boxCacheProvider;
    private final Provider<IdMappingService> idMappingServiceProvider;
    private final Provider<ItemCollaborationsRemoteDataSource> itemCollaborationsRemoteDataSourceProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private ItemCollaborationsService_Factory(Provider<ItemCollaborationsRemoteDataSource> itemCollaborationsRemoteDataSourceProvider, Provider<IdMappingService> idMappingServiceProvider, Provider<IUserContextManager> userContextManagerProvider, Provider<BoxCache> boxCacheProvider) {
        this.itemCollaborationsRemoteDataSourceProvider = itemCollaborationsRemoteDataSourceProvider;
        this.idMappingServiceProvider = idMappingServiceProvider;
        this.userContextManagerProvider = userContextManagerProvider;
        this.boxCacheProvider = boxCacheProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ItemCollaborationsService get() {
        return newInstance(this.itemCollaborationsRemoteDataSourceProvider.get(), this.idMappingServiceProvider.get(), this.userContextManagerProvider.get(), this.boxCacheProvider.get());
    }

    public static ItemCollaborationsService_Factory create(Provider<ItemCollaborationsRemoteDataSource> itemCollaborationsRemoteDataSourceProvider, Provider<IdMappingService> idMappingServiceProvider, Provider<IUserContextManager> userContextManagerProvider, Provider<BoxCache> boxCacheProvider) {
        return new ItemCollaborationsService_Factory(itemCollaborationsRemoteDataSourceProvider, idMappingServiceProvider, userContextManagerProvider, boxCacheProvider);
    }

    public static ItemCollaborationsService newInstance(ItemCollaborationsRemoteDataSource itemCollaborationsRemoteDataSource, IdMappingService idMappingService, IUserContextManager userContextManager, BoxCache boxCache) {
        return new ItemCollaborationsService(itemCollaborationsRemoteDataSource, idMappingService, userContextManager, boxCache);
    }
}
