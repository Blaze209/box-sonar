package com.box.android.boxai.homescreen;

import androidx.lifecycle.SavedStateHandle;
import com.box.android.cpl.IStoreFactory;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class BoxAiHomeViewModel_Factory implements Factory<BoxAiHomeViewModel> {
    private final Provider<BoxAiHomeEnvironment> environmentProvider;
    private final Provider<SavedStateHandle> savedStateHandleProvider;
    private final Provider<IStoreFactory> storeFactoryProvider;

    private BoxAiHomeViewModel_Factory(Provider<BoxAiHomeEnvironment> provider, Provider<IStoreFactory> provider2, Provider<SavedStateHandle> provider3) {
        this.environmentProvider = provider;
        this.storeFactoryProvider = provider2;
        this.savedStateHandleProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BoxAiHomeViewModel get() {
        return newInstance(this.environmentProvider.get(), this.storeFactoryProvider.get(), this.savedStateHandleProvider.get());
    }

    public static BoxAiHomeViewModel_Factory create(Provider<BoxAiHomeEnvironment> provider, Provider<IStoreFactory> provider2, Provider<SavedStateHandle> provider3) {
        return new BoxAiHomeViewModel_Factory(provider, provider2, provider3);
    }

    public static BoxAiHomeViewModel newInstance(BoxAiHomeEnvironment boxAiHomeEnvironment, IStoreFactory iStoreFactory, SavedStateHandle savedStateHandle) {
        return new BoxAiHomeViewModel(boxAiHomeEnvironment, iStoreFactory, savedStateHandle);
    }
}
