package com.box.android.data.service.impl;

import com.box.android.data.datasource.ItemRemoteDataSource;
import com.box.android.domain.services.IdMappingService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class CreateFolderService_Factory implements Factory<CreateFolderService> {
    private final Provider<CommonServiceUtils> commonServiceUtilsProvider;
    private final Provider<IdMappingService> idMappingServiceProvider;
    private final Provider<ItemRemoteDataSource> itemRemoteDataSourceProvider;

    private CreateFolderService_Factory(Provider<ItemRemoteDataSource> itemRemoteDataSourceProvider, Provider<CommonServiceUtils> commonServiceUtilsProvider, Provider<IdMappingService> idMappingServiceProvider) {
        this.itemRemoteDataSourceProvider = itemRemoteDataSourceProvider;
        this.commonServiceUtilsProvider = commonServiceUtilsProvider;
        this.idMappingServiceProvider = idMappingServiceProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CreateFolderService get() {
        return newInstance(this.itemRemoteDataSourceProvider.get(), this.commonServiceUtilsProvider.get(), this.idMappingServiceProvider.get());
    }

    public static CreateFolderService_Factory create(Provider<ItemRemoteDataSource> itemRemoteDataSourceProvider, Provider<CommonServiceUtils> commonServiceUtilsProvider, Provider<IdMappingService> idMappingServiceProvider) {
        return new CreateFolderService_Factory(itemRemoteDataSourceProvider, commonServiceUtilsProvider, idMappingServiceProvider);
    }

    public static CreateFolderService newInstance(ItemRemoteDataSource itemRemoteDataSource, CommonServiceUtils commonServiceUtils, IdMappingService idMappingService) {
        return new CreateFolderService(itemRemoteDataSource, commonServiceUtils, idMappingService);
    }
}
