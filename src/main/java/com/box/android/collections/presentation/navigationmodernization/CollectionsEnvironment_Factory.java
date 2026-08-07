package com.box.android.collections.presentation.navigationmodernization;

import com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListEnvironment;
import com.box.android.domain.usecases.collections.CreateCollectionInteractor;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class CollectionsEnvironment_Factory implements Factory<CollectionsEnvironment> {
    private final Provider<CollectionsAnalytics> analyticsProvider;
    private final Provider<CollectionsListEnvironment> collectionsListEnvironmentProvider;
    private final Provider<CreateCollectionInteractor> createCollectionUseCaseProvider;

    private CollectionsEnvironment_Factory(Provider<CollectionsListEnvironment> provider, Provider<CreateCollectionInteractor> provider2, Provider<CollectionsAnalytics> provider3) {
        this.collectionsListEnvironmentProvider = provider;
        this.createCollectionUseCaseProvider = provider2;
        this.analyticsProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CollectionsEnvironment get() {
        return newInstance(this.collectionsListEnvironmentProvider.get(), this.createCollectionUseCaseProvider.get(), this.analyticsProvider.get());
    }

    public static CollectionsEnvironment_Factory create(Provider<CollectionsListEnvironment> provider, Provider<CreateCollectionInteractor> provider2, Provider<CollectionsAnalytics> provider3) {
        return new CollectionsEnvironment_Factory(provider, provider2, provider3);
    }

    public static CollectionsEnvironment newInstance(CollectionsListEnvironment collectionsListEnvironment, CreateCollectionInteractor createCollectionInteractor, CollectionsAnalytics collectionsAnalytics) {
        return new CollectionsEnvironment(collectionsListEnvironment, createCollectionInteractor, collectionsAnalytics);
    }
}
