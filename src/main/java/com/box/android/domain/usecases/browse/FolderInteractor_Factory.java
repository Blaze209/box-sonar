package com.box.android.domain.usecases.browse;

import com.box.android.domain.services.IRemoteItemService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class FolderInteractor_Factory implements Factory<FolderInteractor> {
    private final Provider<IRemoteItemService> itemServiceProvider;

    private FolderInteractor_Factory(Provider<IRemoteItemService> provider) {
        this.itemServiceProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FolderInteractor get() {
        return newInstance(this.itemServiceProvider.get());
    }

    public static FolderInteractor_Factory create(Provider<IRemoteItemService> provider) {
        return new FolderInteractor_Factory(provider);
    }

    public static FolderInteractor newInstance(IRemoteItemService iRemoteItemService) {
        return new FolderInteractor(iRemoteItemService);
    }
}
