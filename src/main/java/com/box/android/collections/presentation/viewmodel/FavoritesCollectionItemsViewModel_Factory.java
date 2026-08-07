package com.box.android.collections.presentation.viewmodel;

import com.box.android.domain.usecases.collections.GetFavoritesCollectionIdUseCase;
import com.box.android.domain.usecases.collections.ListCollectionItemsInteractor;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class FavoritesCollectionItemsViewModel_Factory implements Factory<FavoritesCollectionItemsViewModel> {
    private final Provider<GetFavoritesCollectionIdUseCase> getFavoritesCollectionIdUseCaseProvider;
    private final Provider<ListCollectionItemsInteractor> listCollectionItemsInteractorProvider;

    private FavoritesCollectionItemsViewModel_Factory(Provider<ListCollectionItemsInteractor> provider, Provider<GetFavoritesCollectionIdUseCase> provider2) {
        this.listCollectionItemsInteractorProvider = provider;
        this.getFavoritesCollectionIdUseCaseProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FavoritesCollectionItemsViewModel get() {
        return newInstance(this.listCollectionItemsInteractorProvider.get(), this.getFavoritesCollectionIdUseCaseProvider.get());
    }

    public static FavoritesCollectionItemsViewModel_Factory create(Provider<ListCollectionItemsInteractor> provider, Provider<GetFavoritesCollectionIdUseCase> provider2) {
        return new FavoritesCollectionItemsViewModel_Factory(provider, provider2);
    }

    public static FavoritesCollectionItemsViewModel newInstance(ListCollectionItemsInteractor listCollectionItemsInteractor, GetFavoritesCollectionIdUseCase getFavoritesCollectionIdUseCase) {
        return new FavoritesCollectionItemsViewModel(listCollectionItemsInteractor, getFavoritesCollectionIdUseCase);
    }
}
