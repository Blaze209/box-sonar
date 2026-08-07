package com.box.android.contentpicker.uploadcontent;

import com.box.android.cpl.IStoreFactory;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class UploadContentHandlerViewModel_Factory implements Factory<UploadContentHandlerViewModel> {
    private final Provider<UploadContentEnvironment> environmentProvider;
    private final Provider<IStoreFactory> storeFactoryProvider;

    private UploadContentHandlerViewModel_Factory(Provider<UploadContentEnvironment> provider, Provider<IStoreFactory> provider2) {
        this.environmentProvider = provider;
        this.storeFactoryProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public UploadContentHandlerViewModel get() {
        return newInstance(this.environmentProvider.get(), this.storeFactoryProvider.get());
    }

    public static UploadContentHandlerViewModel_Factory create(Provider<UploadContentEnvironment> provider, Provider<IStoreFactory> provider2) {
        return new UploadContentHandlerViewModel_Factory(provider, provider2);
    }

    public static UploadContentHandlerViewModel newInstance(UploadContentEnvironment uploadContentEnvironment, IStoreFactory iStoreFactory) {
        return new UploadContentHandlerViewModel(uploadContentEnvironment, iStoreFactory);
    }
}
