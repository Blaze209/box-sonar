package com.box.android.data.di;

import com.box.android.data.service.impl.ItemIdMappingService;
import com.box.android.domain.services.IdMappingService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DataProvidesModule_ProvidesIdMappingServiceFactory implements Factory<IdMappingService> {
    private final Provider<ItemIdMappingService> itemIdMappingServiceProvider;
    private final DataProvidesModule module;

    private DataProvidesModule_ProvidesIdMappingServiceFactory(DataProvidesModule module, Provider<ItemIdMappingService> itemIdMappingServiceProvider) {
        this.module = module;
        this.itemIdMappingServiceProvider = itemIdMappingServiceProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public IdMappingService get() {
        return providesIdMappingService(this.module, this.itemIdMappingServiceProvider.get());
    }

    public static DataProvidesModule_ProvidesIdMappingServiceFactory create(DataProvidesModule module, Provider<ItemIdMappingService> itemIdMappingServiceProvider) {
        return new DataProvidesModule_ProvidesIdMappingServiceFactory(module, itemIdMappingServiceProvider);
    }

    public static IdMappingService providesIdMappingService(DataProvidesModule instance, ItemIdMappingService itemIdMappingService) {
        return (IdMappingService) Preconditions.checkNotNullFromProvides(instance.providesIdMappingService(itemIdMappingService));
    }
}
