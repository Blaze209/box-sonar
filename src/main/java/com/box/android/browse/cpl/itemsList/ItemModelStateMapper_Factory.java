package com.box.android.browse.cpl.itemsList;

import com.box.android.base.presentation.ThumbnailManager;
import com.box.android.coreservices.models.BoxModelOfflineManagerWrapper;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class ItemModelStateMapper_Factory implements Factory<ItemModelStateMapper> {
    private final Provider<BoxModelOfflineManagerWrapper> modelOfflineManagerWrapperProvider;
    private final Provider<ThumbnailManager> thumbnailManagerProvider;

    private ItemModelStateMapper_Factory(Provider<BoxModelOfflineManagerWrapper> provider, Provider<ThumbnailManager> provider2) {
        this.modelOfflineManagerWrapperProvider = provider;
        this.thumbnailManagerProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ItemModelStateMapper get() {
        return newInstance(this.modelOfflineManagerWrapperProvider.get(), this.thumbnailManagerProvider.get());
    }

    public static ItemModelStateMapper_Factory create(Provider<BoxModelOfflineManagerWrapper> provider, Provider<ThumbnailManager> provider2) {
        return new ItemModelStateMapper_Factory(provider, provider2);
    }

    public static ItemModelStateMapper newInstance(BoxModelOfflineManagerWrapper boxModelOfflineManagerWrapper, ThumbnailManager thumbnailManager) {
        return new ItemModelStateMapper(boxModelOfflineManagerWrapper, thumbnailManager);
    }
}
