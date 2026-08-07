package com.box.android.domain.usecases.notes;

import com.box.android.domain.services.IFavoritesService;
import com.box.android.domain.services.IRecentNotesService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class NotesRecentsViewInteractor_Factory implements Factory<NotesRecentsViewInteractor> {
    private final Provider<IFavoritesService> favoritesServiceProvider;
    private final Provider<IRecentNotesService> recentNotesServiceProvider;

    private NotesRecentsViewInteractor_Factory(Provider<IRecentNotesService> provider, Provider<IFavoritesService> provider2) {
        this.recentNotesServiceProvider = provider;
        this.favoritesServiceProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public NotesRecentsViewInteractor get() {
        return newInstance(this.recentNotesServiceProvider.get(), this.favoritesServiceProvider.get());
    }

    public static NotesRecentsViewInteractor_Factory create(Provider<IRecentNotesService> provider, Provider<IFavoritesService> provider2) {
        return new NotesRecentsViewInteractor_Factory(provider, provider2);
    }

    public static NotesRecentsViewInteractor newInstance(IRecentNotesService iRecentNotesService, IFavoritesService iFavoritesService) {
        return new NotesRecentsViewInteractor(iRecentNotesService, iFavoritesService);
    }
}
