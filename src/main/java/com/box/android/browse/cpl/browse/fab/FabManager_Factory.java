package com.box.android.browse.cpl.browse.fab;

import com.box.android.coreservices.services.IntentServices;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.usecases.notes.ResolveNewNoteDataUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class FabManager_Factory implements Factory<FabManager> {
    private final Provider<FeatureFlips> featureFlipsProvider;
    private final Provider<IntentServices> intentServicesProvider;
    private final Provider<ResolveNewNoteDataUseCase> resolveNewNoteDataUseCaseProvider;

    private FabManager_Factory(Provider<IntentServices> provider, Provider<FeatureFlips> provider2, Provider<ResolveNewNoteDataUseCase> provider3) {
        this.intentServicesProvider = provider;
        this.featureFlipsProvider = provider2;
        this.resolveNewNoteDataUseCaseProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FabManager get() {
        return newInstance(this.intentServicesProvider.get(), this.featureFlipsProvider.get(), this.resolveNewNoteDataUseCaseProvider.get());
    }

    public static FabManager_Factory create(Provider<IntentServices> provider, Provider<FeatureFlips> provider2, Provider<ResolveNewNoteDataUseCase> provider3) {
        return new FabManager_Factory(provider, provider2, provider3);
    }

    public static FabManager newInstance(IntentServices intentServices, FeatureFlips featureFlips, ResolveNewNoteDataUseCase resolveNewNoteDataUseCase) {
        return new FabManager(intentServices, featureFlips, resolveNewNoteDataUseCase);
    }
}
