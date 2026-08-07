package com.box.android.base.cpl;

import com.box.android.base.presentation.ThumbnailManager;
import com.box.android.domain.services.IHubsService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class ItemThumbnailEnvironment_Factory implements Factory<ItemThumbnailEnvironment> {
    private final Provider<IHubsService> hubsServiceProvider;
    private final Provider<ThumbnailManager> thumbnailManagerProvider;

    private ItemThumbnailEnvironment_Factory(Provider<ThumbnailManager> provider, Provider<IHubsService> provider2) {
        this.thumbnailManagerProvider = provider;
        this.hubsServiceProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ItemThumbnailEnvironment get() {
        return newInstance(this.thumbnailManagerProvider.get(), this.hubsServiceProvider.get());
    }

    public static ItemThumbnailEnvironment_Factory create(Provider<ThumbnailManager> provider, Provider<IHubsService> provider2) {
        return new ItemThumbnailEnvironment_Factory(provider, provider2);
    }

    public static ItemThumbnailEnvironment newInstance(ThumbnailManager thumbnailManager, IHubsService iHubsService) {
        return new ItemThumbnailEnvironment(thumbnailManager, iHubsService);
    }
}
