package com.box.android.collections.presentation.viewmodel;

import android.os.Bundle;
import com.box.android.domain.usecases.collections.ListCollectionItemsInteractor;
import com.box.android.domain.usecases.collections.ListCollectionsInteractor;
import dagger.internal.Provider;

/* JADX INFO: renamed from: com.box.android.collections.presentation.viewmodel.CollectionItemsViewModel_Factory, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C1003CollectionItemsViewModel_Factory {
    private final Provider<ListCollectionItemsInteractor> listCollectionItemsInteractorProvider;
    private final Provider<ListCollectionsInteractor> listCollectionsInteractorProvider;

    private C1003CollectionItemsViewModel_Factory(Provider<ListCollectionItemsInteractor> provider, Provider<ListCollectionsInteractor> provider2) {
        this.listCollectionItemsInteractorProvider = provider;
        this.listCollectionsInteractorProvider = provider2;
    }

    public CollectionItemsViewModel get(Bundle bundle) {
        return newInstance(bundle, this.listCollectionItemsInteractorProvider.get(), this.listCollectionsInteractorProvider.get());
    }

    public static C1003CollectionItemsViewModel_Factory create(Provider<ListCollectionItemsInteractor> provider, Provider<ListCollectionsInteractor> provider2) {
        return new C1003CollectionItemsViewModel_Factory(provider, provider2);
    }

    public static CollectionItemsViewModel newInstance(Bundle bundle, ListCollectionItemsInteractor listCollectionItemsInteractor, ListCollectionsInteractor listCollectionsInteractor) {
        return new CollectionItemsViewModel(bundle, listCollectionItemsInteractor, listCollectionsInteractor);
    }
}
