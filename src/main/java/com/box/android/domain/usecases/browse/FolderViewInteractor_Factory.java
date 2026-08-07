package com.box.android.domain.usecases.browse;

import com.box.android.domain.services.IRemoteItemService;
import com.box.android.domain.utils.ItemSorter;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class FolderViewInteractor_Factory implements Factory<FolderViewInteractor> {
    private final Provider<IRemoteItemService> itemServiceProvider;
    private final Provider<ItemSorter> itemSorterProvider;

    private FolderViewInteractor_Factory(Provider<IRemoteItemService> provider, Provider<ItemSorter> provider2) {
        this.itemServiceProvider = provider;
        this.itemSorterProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FolderViewInteractor get() {
        return newInstance(this.itemServiceProvider.get(), this.itemSorterProvider.get());
    }

    public static FolderViewInteractor_Factory create(Provider<IRemoteItemService> provider, Provider<ItemSorter> provider2) {
        return new FolderViewInteractor_Factory(provider, provider2);
    }

    public static FolderViewInteractor newInstance(IRemoteItemService iRemoteItemService, ItemSorter itemSorter) {
        return new FolderViewInteractor(iRemoteItemService, itemSorter);
    }
}
