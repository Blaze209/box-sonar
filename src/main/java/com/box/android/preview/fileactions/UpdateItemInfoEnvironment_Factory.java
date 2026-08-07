package com.box.android.preview.fileactions;

import com.box.android.base.cpl.IItemNameValidator;
import com.box.android.domain.services.IUpdateItemInfoService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class UpdateItemInfoEnvironment_Factory implements Factory<UpdateItemInfoEnvironment> {
    private final Provider<IItemNameValidator> itemNameValidatorProvider;
    private final Provider<IUpdateItemInfoService> updateItemInfoServiceProvider;

    private UpdateItemInfoEnvironment_Factory(Provider<IUpdateItemInfoService> provider, Provider<IItemNameValidator> provider2) {
        this.updateItemInfoServiceProvider = provider;
        this.itemNameValidatorProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public UpdateItemInfoEnvironment get() {
        return newInstance(this.updateItemInfoServiceProvider.get(), this.itemNameValidatorProvider.get());
    }

    public static UpdateItemInfoEnvironment_Factory create(Provider<IUpdateItemInfoService> provider, Provider<IItemNameValidator> provider2) {
        return new UpdateItemInfoEnvironment_Factory(provider, provider2);
    }

    public static UpdateItemInfoEnvironment newInstance(IUpdateItemInfoService iUpdateItemInfoService, IItemNameValidator iItemNameValidator) {
        return new UpdateItemInfoEnvironment(iUpdateItemInfoService, iItemNameValidator);
    }
}
