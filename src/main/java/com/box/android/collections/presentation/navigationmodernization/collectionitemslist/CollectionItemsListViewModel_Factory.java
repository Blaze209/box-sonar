package com.box.android.collections.presentation.navigationmodernization.collectionitemslist;

import androidx.lifecycle.SavedStateHandle;
import com.box.android.cpl.IStoreFactory;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class CollectionItemsListViewModel_Factory implements Factory<CollectionItemsListViewModel> {
    private final Provider<CollectionItemsListEnvironment> environmentProvider;
    private final Provider<SavedStateHandle> savedStateHandleProvider;
    private final Provider<IStoreFactory> storeFactoryProvider;

    private CollectionItemsListViewModel_Factory(Provider<CollectionItemsListEnvironment> provider, Provider<IStoreFactory> provider2, Provider<SavedStateHandle> provider3) {
        this.environmentProvider = provider;
        this.storeFactoryProvider = provider2;
        this.savedStateHandleProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CollectionItemsListViewModel get() {
        return newInstance(this.environmentProvider.get(), this.storeFactoryProvider.get(), this.savedStateHandleProvider.get());
    }

    public static CollectionItemsListViewModel_Factory create(Provider<CollectionItemsListEnvironment> provider, Provider<IStoreFactory> provider2, Provider<SavedStateHandle> provider3) {
        return new CollectionItemsListViewModel_Factory(provider, provider2, provider3);
    }

    public static CollectionItemsListViewModel newInstance(CollectionItemsListEnvironment collectionItemsListEnvironment, IStoreFactory iStoreFactory, SavedStateHandle savedStateHandle) {
        return new CollectionItemsListViewModel(collectionItemsListEnvironment, iStoreFactory, savedStateHandle);
    }
}
