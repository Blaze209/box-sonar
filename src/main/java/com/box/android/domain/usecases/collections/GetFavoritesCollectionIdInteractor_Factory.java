package com.box.android.domain.usecases.collections;

import com.box.android.domain.identity.IUserContextManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class GetFavoritesCollectionIdInteractor_Factory implements Factory<GetFavoritesCollectionIdInteractor> {
    private final Provider<ListCollectionsInteractor> listCollectionsInteractorProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private GetFavoritesCollectionIdInteractor_Factory(Provider<ListCollectionsInteractor> provider, Provider<IUserContextManager> provider2) {
        this.listCollectionsInteractorProvider = provider;
        this.userContextManagerProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GetFavoritesCollectionIdInteractor get() {
        return newInstance(this.listCollectionsInteractorProvider.get(), this.userContextManagerProvider.get());
    }

    public static GetFavoritesCollectionIdInteractor_Factory create(Provider<ListCollectionsInteractor> provider, Provider<IUserContextManager> provider2) {
        return new GetFavoritesCollectionIdInteractor_Factory(provider, provider2);
    }

    public static GetFavoritesCollectionIdInteractor newInstance(ListCollectionsInteractor listCollectionsInteractor, IUserContextManager iUserContextManager) {
        return new GetFavoritesCollectionIdInteractor(listCollectionsInteractor, iUserContextManager);
    }
}
