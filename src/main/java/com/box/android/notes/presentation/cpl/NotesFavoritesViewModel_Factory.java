package com.box.android.notes.presentation.cpl;

import com.box.android.cpl.IStoreFactory;
import com.box.android.domain.services.IFavoritesService;
import com.box.android.notes.navigationmodernization.NotesAnalytics;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class NotesFavoritesViewModel_Factory implements Factory<NotesFavoritesViewModel> {
    private final Provider<NotesFavoritesListEnvironment> environmentProvider;
    private final Provider<IFavoritesService> favoritesServiceProvider;
    private final Provider<NotesAnalytics> notesAnalyticsProvider;
    private final Provider<IStoreFactory> storeFactoryProvider;

    private NotesFavoritesViewModel_Factory(Provider<NotesFavoritesListEnvironment> provider, Provider<IFavoritesService> provider2, Provider<NotesAnalytics> provider3, Provider<IStoreFactory> provider4) {
        this.environmentProvider = provider;
        this.favoritesServiceProvider = provider2;
        this.notesAnalyticsProvider = provider3;
        this.storeFactoryProvider = provider4;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public NotesFavoritesViewModel get() {
        return newInstance(this.environmentProvider.get(), this.favoritesServiceProvider.get(), this.notesAnalyticsProvider.get(), this.storeFactoryProvider.get());
    }

    public static NotesFavoritesViewModel_Factory create(Provider<NotesFavoritesListEnvironment> provider, Provider<IFavoritesService> provider2, Provider<NotesAnalytics> provider3, Provider<IStoreFactory> provider4) {
        return new NotesFavoritesViewModel_Factory(provider, provider2, provider3, provider4);
    }

    public static NotesFavoritesViewModel newInstance(NotesFavoritesListEnvironment notesFavoritesListEnvironment, IFavoritesService iFavoritesService, NotesAnalytics notesAnalytics, IStoreFactory iStoreFactory) {
        return new NotesFavoritesViewModel(notesFavoritesListEnvironment, iFavoritesService, notesAnalytics, iStoreFactory);
    }
}
