package com.box.android.browse.cpl.itemsList;

import com.box.android.base.cpl.ItemThumbnailEnvironment;
import com.box.android.coreservices.models.BoxModelOfflineManagerWrapper;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class ItemEnvironment_Factory implements Factory<ItemEnvironment> {
    private final Provider<BoxModelOfflineManagerWrapper> boxModelOfflineManagerWrapperProvider;
    private final Provider<ItemThumbnailEnvironment> thumbnailEnvironmentProvider;

    private ItemEnvironment_Factory(Provider<ItemThumbnailEnvironment> provider, Provider<BoxModelOfflineManagerWrapper> provider2) {
        this.thumbnailEnvironmentProvider = provider;
        this.boxModelOfflineManagerWrapperProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ItemEnvironment get() {
        return newInstance(this.thumbnailEnvironmentProvider.get(), this.boxModelOfflineManagerWrapperProvider.get());
    }

    public static ItemEnvironment_Factory create(Provider<ItemThumbnailEnvironment> provider, Provider<BoxModelOfflineManagerWrapper> provider2) {
        return new ItemEnvironment_Factory(provider, provider2);
    }

    public static ItemEnvironment newInstance(ItemThumbnailEnvironment itemThumbnailEnvironment, BoxModelOfflineManagerWrapper boxModelOfflineManagerWrapper) {
        return new ItemEnvironment(itemThumbnailEnvironment, boxModelOfflineManagerWrapper);
    }
}
