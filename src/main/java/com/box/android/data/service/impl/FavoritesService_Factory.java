package com.box.android.data.service.impl;

import com.box.android.domain.services.ICollectionsService;
import com.box.android.domain.usecases.collections.GetFavoritesCollectionIdUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes11.dex */
public final class FavoritesService_Factory implements Factory<FavoritesService> {
    private final Provider<ICollectionsService> collectionsServiceProvider;
    private final Provider<GetFavoritesCollectionIdUseCase> getFavoritesCollectionIdUseCaseProvider;
    private final Provider<CoroutineDispatcher> ioDispatcherProvider;

    private FavoritesService_Factory(Provider<ICollectionsService> collectionsServiceProvider, Provider<GetFavoritesCollectionIdUseCase> getFavoritesCollectionIdUseCaseProvider, Provider<CoroutineDispatcher> ioDispatcherProvider) {
        this.collectionsServiceProvider = collectionsServiceProvider;
        this.getFavoritesCollectionIdUseCaseProvider = getFavoritesCollectionIdUseCaseProvider;
        this.ioDispatcherProvider = ioDispatcherProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FavoritesService get() {
        return newInstance(this.collectionsServiceProvider.get(), this.getFavoritesCollectionIdUseCaseProvider.get(), this.ioDispatcherProvider.get());
    }

    public static FavoritesService_Factory create(Provider<ICollectionsService> collectionsServiceProvider, Provider<GetFavoritesCollectionIdUseCase> getFavoritesCollectionIdUseCaseProvider, Provider<CoroutineDispatcher> ioDispatcherProvider) {
        return new FavoritesService_Factory(collectionsServiceProvider, getFavoritesCollectionIdUseCaseProvider, ioDispatcherProvider);
    }

    public static FavoritesService newInstance(ICollectionsService collectionsService, GetFavoritesCollectionIdUseCase getFavoritesCollectionIdUseCase, CoroutineDispatcher ioDispatcher) {
        return new FavoritesService(collectionsService, getFavoritesCollectionIdUseCase, ioDispatcher);
    }
}
