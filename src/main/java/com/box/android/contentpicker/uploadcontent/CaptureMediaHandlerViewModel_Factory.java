package com.box.android.contentpicker.uploadcontent;

import com.box.android.cpl.IStoreFactory;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class CaptureMediaHandlerViewModel_Factory implements Factory<CaptureMediaHandlerViewModel> {
    private final Provider<CaptureMediaEnvironment> environmentProvider;
    private final Provider<IStoreFactory> storeFactoryProvider;

    private CaptureMediaHandlerViewModel_Factory(Provider<CaptureMediaEnvironment> provider, Provider<IStoreFactory> provider2) {
        this.environmentProvider = provider;
        this.storeFactoryProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CaptureMediaHandlerViewModel get() {
        return newInstance(this.environmentProvider.get(), this.storeFactoryProvider.get());
    }

    public static CaptureMediaHandlerViewModel_Factory create(Provider<CaptureMediaEnvironment> provider, Provider<IStoreFactory> provider2) {
        return new CaptureMediaHandlerViewModel_Factory(provider, provider2);
    }

    public static CaptureMediaHandlerViewModel newInstance(CaptureMediaEnvironment captureMediaEnvironment, IStoreFactory iStoreFactory) {
        return new CaptureMediaHandlerViewModel(captureMediaEnvironment, iStoreFactory);
    }
}
