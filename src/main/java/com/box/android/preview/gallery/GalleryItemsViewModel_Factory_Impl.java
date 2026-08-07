package com.box.android.preview.gallery;

import android.os.Bundle;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class GalleryItemsViewModel_Factory_Impl implements GalleryItemsViewModel.Factory {
    private final C1675GalleryItemsViewModel_Factory delegateFactory;

    GalleryItemsViewModel_Factory_Impl(C1675GalleryItemsViewModel_Factory c1675GalleryItemsViewModel_Factory) {
        this.delegateFactory = c1675GalleryItemsViewModel_Factory;
    }

    @Override // com.box.android.common.utilities.ViewModelAssistedFactory
    public GalleryItemsViewModel create(Bundle bundle) {
        return this.delegateFactory.get(bundle);
    }

    public static Provider<GalleryItemsViewModel.Factory> create(C1675GalleryItemsViewModel_Factory c1675GalleryItemsViewModel_Factory) {
        return InstanceFactory.create(new GalleryItemsViewModel_Factory_Impl(c1675GalleryItemsViewModel_Factory));
    }

    public static dagger.internal.Provider<GalleryItemsViewModel.Factory> createFactoryProvider(C1675GalleryItemsViewModel_Factory c1675GalleryItemsViewModel_Factory) {
        return InstanceFactory.create(new GalleryItemsViewModel_Factory_Impl(c1675GalleryItemsViewModel_Factory));
    }
}
