package com.box.android.domain.usecases.collections;

import com.box.android.domain.services.ICollectionsService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class ListCollectionItemsInteractor_Factory implements Factory<ListCollectionItemsInteractor> {
    private final Provider<ICollectionsService> collectionsServiceProvider;

    private ListCollectionItemsInteractor_Factory(Provider<ICollectionsService> provider) {
        this.collectionsServiceProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ListCollectionItemsInteractor get() {
        return newInstance(this.collectionsServiceProvider.get());
    }

    public static ListCollectionItemsInteractor_Factory create(Provider<ICollectionsService> provider) {
        return new ListCollectionItemsInteractor_Factory(provider);
    }

    public static ListCollectionItemsInteractor newInstance(ICollectionsService iCollectionsService) {
        return new ListCollectionItemsInteractor(iCollectionsService);
    }
}
