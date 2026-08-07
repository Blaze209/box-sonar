package com.box.android.preview.gallery;

import android.os.Bundle;
import com.box.android.cpl.IStoreFactory;
import dagger.internal.Provider;

/* JADX INFO: renamed from: com.box.android.preview.gallery.GalleryItemsViewModel_Factory, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes12.dex */
public final class C1675GalleryItemsViewModel_Factory {
    private final Provider<GalleryItemsEnvironment> environmentProvider;
    private final Provider<IStoreFactory> storeFactoryProvider;

    private C1675GalleryItemsViewModel_Factory(Provider<GalleryItemsEnvironment> provider, Provider<IStoreFactory> provider2) {
        this.environmentProvider = provider;
        this.storeFactoryProvider = provider2;
    }

    public GalleryItemsViewModel get(Bundle bundle) {
        return newInstance(bundle, this.environmentProvider.get(), this.storeFactoryProvider.get());
    }

    public static C1675GalleryItemsViewModel_Factory create(Provider<GalleryItemsEnvironment> provider, Provider<IStoreFactory> provider2) {
        return new C1675GalleryItemsViewModel_Factory(provider, provider2);
    }

    public static GalleryItemsViewModel newInstance(Bundle bundle, GalleryItemsEnvironment galleryItemsEnvironment, IStoreFactory iStoreFactory) {
        return new GalleryItemsViewModel(bundle, galleryItemsEnvironment, iStoreFactory);
    }
}
