package com.box.android.base.cpl;

import com.box.android.domain.services.ILocalItemService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class DeleteEnvironment_Factory implements Factory<DeleteEnvironment> {
    private final Provider<ILocalItemService> localItemServiceProvider;

    private DeleteEnvironment_Factory(Provider<ILocalItemService> provider) {
        this.localItemServiceProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public DeleteEnvironment get() {
        return newInstance(this.localItemServiceProvider.get());
    }

    public static DeleteEnvironment_Factory create(Provider<ILocalItemService> provider) {
        return new DeleteEnvironment_Factory(provider);
    }

    public static DeleteEnvironment newInstance(ILocalItemService iLocalItemService) {
        return new DeleteEnvironment(iLocalItemService);
    }
}
