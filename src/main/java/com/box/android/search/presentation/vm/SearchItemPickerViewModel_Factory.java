package com.box.android.search.presentation.vm;

import androidx.lifecycle.SavedStateHandle;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.cpl.IStoreFactory;
import com.box.android.search.presentation.cpl.SearchEnvironment;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes13.dex */
public final class SearchItemPickerViewModel_Factory implements Factory<SearchItemPickerViewModel> {
    private final Provider<IntentServices> intentServicesProvider;
    private final Provider<SavedStateHandle> savedStateHandleProvider;
    private final Provider<SearchEnvironment> searchEnvironmentProvider;
    private final Provider<IStoreFactory> storeFactoryProvider;

    private SearchItemPickerViewModel_Factory(Provider<IStoreFactory> provider, Provider<SearchEnvironment> provider2, Provider<IntentServices> provider3, Provider<SavedStateHandle> provider4) {
        this.storeFactoryProvider = provider;
        this.searchEnvironmentProvider = provider2;
        this.intentServicesProvider = provider3;
        this.savedStateHandleProvider = provider4;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public SearchItemPickerViewModel get() {
        return newInstance(this.storeFactoryProvider.get(), this.searchEnvironmentProvider.get(), this.intentServicesProvider.get(), this.savedStateHandleProvider.get());
    }

    public static SearchItemPickerViewModel_Factory create(Provider<IStoreFactory> provider, Provider<SearchEnvironment> provider2, Provider<IntentServices> provider3, Provider<SavedStateHandle> provider4) {
        return new SearchItemPickerViewModel_Factory(provider, provider2, provider3, provider4);
    }

    public static SearchItemPickerViewModel newInstance(IStoreFactory iStoreFactory, SearchEnvironment searchEnvironment, IntentServices intentServices, SavedStateHandle savedStateHandle) {
        return new SearchItemPickerViewModel(iStoreFactory, searchEnvironment, intentServices, savedStateHandle);
    }
}
