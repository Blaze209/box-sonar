package com.box.android.domain.usecases.notes;

import com.box.android.domain.services.ICollectionsService;
import com.box.android.domain.services.IFavoritesService;
import com.box.android.domain.usecases.collections.GetFavoritesCollectionIdUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class NotesFavoritesViewInteractor_Factory implements Factory<NotesFavoritesViewInteractor> {
    private final Provider<ICollectionsService> collectionsServiceProvider;
    private final Provider<IFavoritesService> favoritesServiceProvider;
    private final Provider<GetFavoritesCollectionIdUseCase> getFavoritesCollectionIdUseCaseProvider;

    private NotesFavoritesViewInteractor_Factory(Provider<ICollectionsService> provider, Provider<GetFavoritesCollectionIdUseCase> provider2, Provider<IFavoritesService> provider3) {
        this.collectionsServiceProvider = provider;
        this.getFavoritesCollectionIdUseCaseProvider = provider2;
        this.favoritesServiceProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public NotesFavoritesViewInteractor get() {
        return newInstance(this.collectionsServiceProvider.get(), this.getFavoritesCollectionIdUseCaseProvider.get(), this.favoritesServiceProvider.get());
    }

    public static NotesFavoritesViewInteractor_Factory create(Provider<ICollectionsService> provider, Provider<GetFavoritesCollectionIdUseCase> provider2, Provider<IFavoritesService> provider3) {
        return new NotesFavoritesViewInteractor_Factory(provider, provider2, provider3);
    }

    public static NotesFavoritesViewInteractor newInstance(ICollectionsService iCollectionsService, GetFavoritesCollectionIdUseCase getFavoritesCollectionIdUseCase, IFavoritesService iFavoritesService) {
        return new NotesFavoritesViewInteractor(iCollectionsService, getFavoritesCollectionIdUseCase, iFavoritesService);
    }
}
