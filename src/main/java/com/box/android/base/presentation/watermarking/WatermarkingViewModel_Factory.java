package com.box.android.base.presentation.watermarking;

import androidx.lifecycle.SavedStateHandle;
import com.box.android.cpl.IStoreFactory;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class WatermarkingViewModel_Factory implements Factory<WatermarkingViewModel> {
    private final Provider<WatermarkingEnvironment> environmentProvider;
    private final Provider<SavedStateHandle> savedStateHandleProvider;
    private final Provider<IStoreFactory> storeFactoryProvider;

    private WatermarkingViewModel_Factory(Provider<WatermarkingEnvironment> provider, Provider<IStoreFactory> provider2, Provider<SavedStateHandle> provider3) {
        this.environmentProvider = provider;
        this.storeFactoryProvider = provider2;
        this.savedStateHandleProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public WatermarkingViewModel get() {
        return newInstance(this.environmentProvider.get(), this.storeFactoryProvider.get(), this.savedStateHandleProvider.get());
    }

    public static WatermarkingViewModel_Factory create(Provider<WatermarkingEnvironment> provider, Provider<IStoreFactory> provider2, Provider<SavedStateHandle> provider3) {
        return new WatermarkingViewModel_Factory(provider, provider2, provider3);
    }

    public static WatermarkingViewModel newInstance(WatermarkingEnvironment watermarkingEnvironment, IStoreFactory iStoreFactory, SavedStateHandle savedStateHandle) {
        return new WatermarkingViewModel(watermarkingEnvironment, iStoreFactory, savedStateHandle);
    }
}
