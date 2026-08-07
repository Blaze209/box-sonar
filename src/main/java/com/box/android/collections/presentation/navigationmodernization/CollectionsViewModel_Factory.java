package com.box.android.collections.presentation.navigationmodernization;

import com.box.android.cpl.IStoreFactory;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class CollectionsViewModel_Factory implements Factory<CollectionsViewModel> {
    private final Provider<CollectionsEnvironment> environmentProvider;
    private final Provider<IStoreFactory> storeFactoryProvider;

    private CollectionsViewModel_Factory(Provider<CollectionsEnvironment> provider, Provider<IStoreFactory> provider2) {
        this.environmentProvider = provider;
        this.storeFactoryProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CollectionsViewModel get() {
        return newInstance(this.environmentProvider.get(), this.storeFactoryProvider.get());
    }

    public static CollectionsViewModel_Factory create(Provider<CollectionsEnvironment> provider, Provider<IStoreFactory> provider2) {
        return new CollectionsViewModel_Factory(provider, provider2);
    }

    public static CollectionsViewModel newInstance(CollectionsEnvironment collectionsEnvironment, IStoreFactory iStoreFactory) {
        return new CollectionsViewModel(collectionsEnvironment, iStoreFactory);
    }
}
