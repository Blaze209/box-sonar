package com.box.android.domain.usecases.preview;

import com.box.android.domain.services.IRecentNotesService;
import com.box.android.domain.services.IRecentsService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class TrackRecentPreviewItemInteractor_Factory implements Factory<TrackRecentPreviewItemInteractor> {
    private final Provider<IRecentNotesService> recentNotesServiceProvider;
    private final Provider<IRecentsService> recentsServiceProvider;

    private TrackRecentPreviewItemInteractor_Factory(Provider<IRecentsService> provider, Provider<IRecentNotesService> provider2) {
        this.recentsServiceProvider = provider;
        this.recentNotesServiceProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public TrackRecentPreviewItemInteractor get() {
        return newInstance(this.recentsServiceProvider.get(), this.recentNotesServiceProvider.get());
    }

    public static TrackRecentPreviewItemInteractor_Factory create(Provider<IRecentsService> provider, Provider<IRecentNotesService> provider2) {
        return new TrackRecentPreviewItemInteractor_Factory(provider, provider2);
    }

    public static TrackRecentPreviewItemInteractor newInstance(IRecentsService iRecentsService, IRecentNotesService iRecentNotesService) {
        return new TrackRecentPreviewItemInteractor(iRecentsService, iRecentNotesService);
    }
}
