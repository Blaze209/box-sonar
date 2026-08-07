package com.box.android.preview.iteminformation;

import com.box.android.base.cpl.ItemThumbnailEnvironment;
import com.box.android.domain.services.IFileMetadataService;
import com.box.android.domain.services.IItemCollaborationsService;
import com.box.android.domain.services.IRemoteItemService;
import com.box.android.preview.fileactions.UpdateItemInfoEnvironment;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class ItemInformationEnvironment_Factory implements Factory<ItemInformationEnvironment> {
    private final Provider<ItemInformationAnalytics> analyticsProvider;
    private final Provider<IFileMetadataService> fileMetadataServiceProvider;
    private final Provider<IItemCollaborationsService> itemCollaborationsServiceProvider;
    private final Provider<IRemoteItemService> itemServiceProvider;
    private final Provider<ItemThumbnailEnvironment> itemThumbnailEnvironmentProvider;
    private final Provider<UpdateItemInfoEnvironment> updateItemInfoEnvironmentProvider;

    private ItemInformationEnvironment_Factory(Provider<IItemCollaborationsService> provider, Provider<UpdateItemInfoEnvironment> provider2, Provider<ItemThumbnailEnvironment> provider3, Provider<IRemoteItemService> provider4, Provider<IFileMetadataService> provider5, Provider<ItemInformationAnalytics> provider6) {
        this.itemCollaborationsServiceProvider = provider;
        this.updateItemInfoEnvironmentProvider = provider2;
        this.itemThumbnailEnvironmentProvider = provider3;
        this.itemServiceProvider = provider4;
        this.fileMetadataServiceProvider = provider5;
        this.analyticsProvider = provider6;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ItemInformationEnvironment get() {
        return newInstance(this.itemCollaborationsServiceProvider.get(), this.updateItemInfoEnvironmentProvider.get(), this.itemThumbnailEnvironmentProvider.get(), this.itemServiceProvider.get(), this.fileMetadataServiceProvider.get(), this.analyticsProvider.get());
    }

    public static ItemInformationEnvironment_Factory create(Provider<IItemCollaborationsService> provider, Provider<UpdateItemInfoEnvironment> provider2, Provider<ItemThumbnailEnvironment> provider3, Provider<IRemoteItemService> provider4, Provider<IFileMetadataService> provider5, Provider<ItemInformationAnalytics> provider6) {
        return new ItemInformationEnvironment_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static ItemInformationEnvironment newInstance(IItemCollaborationsService iItemCollaborationsService, UpdateItemInfoEnvironment updateItemInfoEnvironment, ItemThumbnailEnvironment itemThumbnailEnvironment, IRemoteItemService iRemoteItemService, IFileMetadataService iFileMetadataService, ItemInformationAnalytics itemInformationAnalytics) {
        return new ItemInformationEnvironment(iItemCollaborationsService, updateItemInfoEnvironment, itemThumbnailEnvironment, iRemoteItemService, iFileMetadataService, itemInformationAnalytics);
    }
}
