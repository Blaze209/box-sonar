package com.box.android.browse.cpl.itempicker;

import androidx.lifecycle.SavedStateHandle;
import com.box.android.common.utilities.ResourcesProvider;
import com.box.android.cpl.IStoreFactory;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class FolderItemPickerViewModel_Factory implements Factory<FolderItemPickerViewModel> {
    private final Provider<FolderItemPickerEnvironment> environmentProvider;
    private final Provider<ResourcesProvider> resourceProvider;
    private final Provider<SavedStateHandle> savedStateHandleProvider;
    private final Provider<IStoreFactory> storeFactoryProvider;

    private FolderItemPickerViewModel_Factory(Provider<FolderItemPickerEnvironment> provider, Provider<IStoreFactory> provider2, Provider<ResourcesProvider> provider3, Provider<SavedStateHandle> provider4) {
        this.environmentProvider = provider;
        this.storeFactoryProvider = provider2;
        this.resourceProvider = provider3;
        this.savedStateHandleProvider = provider4;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FolderItemPickerViewModel get() {
        return newInstance(this.environmentProvider.get(), this.storeFactoryProvider.get(), this.resourceProvider.get(), this.savedStateHandleProvider.get());
    }

    public static FolderItemPickerViewModel_Factory create(Provider<FolderItemPickerEnvironment> provider, Provider<IStoreFactory> provider2, Provider<ResourcesProvider> provider3, Provider<SavedStateHandle> provider4) {
        return new FolderItemPickerViewModel_Factory(provider, provider2, provider3, provider4);
    }

    public static FolderItemPickerViewModel newInstance(FolderItemPickerEnvironment folderItemPickerEnvironment, IStoreFactory iStoreFactory, ResourcesProvider resourcesProvider, SavedStateHandle savedStateHandle) {
        return new FolderItemPickerViewModel(folderItemPickerEnvironment, iStoreFactory, resourcesProvider, savedStateHandle);
    }
}
