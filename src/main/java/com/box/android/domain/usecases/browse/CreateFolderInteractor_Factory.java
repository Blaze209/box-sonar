package com.box.android.domain.usecases.browse;

import com.box.android.domain.services.IRemoteItemService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class CreateFolderInteractor_Factory implements Factory<CreateFolderInteractor> {
    private final Provider<IRemoteItemService> itemServiceProvider;

    private CreateFolderInteractor_Factory(Provider<IRemoteItemService> provider) {
        this.itemServiceProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CreateFolderInteractor get() {
        return newInstance(this.itemServiceProvider.get());
    }

    public static CreateFolderInteractor_Factory create(Provider<IRemoteItemService> provider) {
        return new CreateFolderInteractor_Factory(provider);
    }

    public static CreateFolderInteractor newInstance(IRemoteItemService iRemoteItemService) {
        return new CreateFolderInteractor(iRemoteItemService);
    }
}
