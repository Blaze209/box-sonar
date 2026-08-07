package com.box.android.collections.presentation.navigationmodernization.collectionslist;

import com.box.android.domain.usecases.collections.ListCollectionsInteractor;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class CollectionsListEnvironment_Factory implements Factory<CollectionsListEnvironment> {
    private final Provider<ListCollectionsInteractor> listCollectionsUseCaseProvider;

    private CollectionsListEnvironment_Factory(Provider<ListCollectionsInteractor> provider) {
        this.listCollectionsUseCaseProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CollectionsListEnvironment get() {
        return newInstance(this.listCollectionsUseCaseProvider.get());
    }

    public static CollectionsListEnvironment_Factory create(Provider<ListCollectionsInteractor> provider) {
        return new CollectionsListEnvironment_Factory(provider);
    }

    public static CollectionsListEnvironment newInstance(ListCollectionsInteractor listCollectionsInteractor) {
        return new CollectionsListEnvironment(listCollectionsInteractor);
    }
}
