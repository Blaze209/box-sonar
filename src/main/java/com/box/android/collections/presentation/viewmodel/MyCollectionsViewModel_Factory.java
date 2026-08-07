package com.box.android.collections.presentation.viewmodel;

import com.box.android.domain.usecases.collections.CreateCollectionInteractor;
import com.box.android.domain.usecases.collections.ListCollectionsInteractor;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class MyCollectionsViewModel_Factory implements Factory<MyCollectionsViewModel> {
    private final Provider<CreateCollectionInteractor> createCollectionInteractorProvider;
    private final Provider<ListCollectionsInteractor> listCollectionsInteractorProvider;

    private MyCollectionsViewModel_Factory(Provider<ListCollectionsInteractor> provider, Provider<CreateCollectionInteractor> provider2) {
        this.listCollectionsInteractorProvider = provider;
        this.createCollectionInteractorProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public MyCollectionsViewModel get() {
        return newInstance(this.listCollectionsInteractorProvider.get(), this.createCollectionInteractorProvider.get());
    }

    public static MyCollectionsViewModel_Factory create(Provider<ListCollectionsInteractor> provider, Provider<CreateCollectionInteractor> provider2) {
        return new MyCollectionsViewModel_Factory(provider, provider2);
    }

    public static MyCollectionsViewModel newInstance(ListCollectionsInteractor listCollectionsInteractor, CreateCollectionInteractor createCollectionInteractor) {
        return new MyCollectionsViewModel(listCollectionsInteractor, createCollectionInteractor);
    }
}
