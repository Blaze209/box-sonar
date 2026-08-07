package com.box.android.domain.usecases.collections;

import com.box.android.domain.services.ICollectionsService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class CreateCollectionInteractor_Factory implements Factory<CreateCollectionInteractor> {
    private final Provider<ICollectionsService> collectionServiceProvider;

    private CreateCollectionInteractor_Factory(Provider<ICollectionsService> provider) {
        this.collectionServiceProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CreateCollectionInteractor get() {
        return newInstance(this.collectionServiceProvider.get());
    }

    public static CreateCollectionInteractor_Factory create(Provider<ICollectionsService> provider) {
        return new CreateCollectionInteractor_Factory(provider);
    }

    public static CreateCollectionInteractor newInstance(ICollectionsService iCollectionsService) {
        return new CreateCollectionInteractor(iCollectionsService);
    }
}
