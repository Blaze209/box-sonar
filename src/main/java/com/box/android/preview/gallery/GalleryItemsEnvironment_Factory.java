package com.box.android.preview.gallery;

import com.box.android.base.cpl.ItemThumbnailEnvironment;
import com.box.android.domain.services.IGalleryItemsService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class GalleryItemsEnvironment_Factory implements Factory<GalleryItemsEnvironment> {
    private final Provider<IGalleryItemsService> galleryItemsServiceProvider;
    private final Provider<ItemThumbnailEnvironment> itemThumbnailEnvironmentProvider;

    private GalleryItemsEnvironment_Factory(Provider<IGalleryItemsService> provider, Provider<ItemThumbnailEnvironment> provider2) {
        this.galleryItemsServiceProvider = provider;
        this.itemThumbnailEnvironmentProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GalleryItemsEnvironment get() {
        return newInstance(this.galleryItemsServiceProvider.get(), this.itemThumbnailEnvironmentProvider.get());
    }

    public static GalleryItemsEnvironment_Factory create(Provider<IGalleryItemsService> provider, Provider<ItemThumbnailEnvironment> provider2) {
        return new GalleryItemsEnvironment_Factory(provider, provider2);
    }

    public static GalleryItemsEnvironment newInstance(IGalleryItemsService iGalleryItemsService, ItemThumbnailEnvironment itemThumbnailEnvironment) {
        return new GalleryItemsEnvironment(iGalleryItemsService, itemThumbnailEnvironment);
    }
}
