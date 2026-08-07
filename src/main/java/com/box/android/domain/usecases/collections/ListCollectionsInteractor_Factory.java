package com.box.android.domain.usecases.collections;

import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.services.ICollectionsService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class ListCollectionsInteractor_Factory implements Factory<ListCollectionsInteractor> {
    private final Provider<ICollectionsService> collectionsServiceProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private ListCollectionsInteractor_Factory(Provider<ICollectionsService> provider, Provider<IUserContextManager> provider2) {
        this.collectionsServiceProvider = provider;
        this.userContextManagerProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ListCollectionsInteractor get() {
        return newInstance(this.collectionsServiceProvider.get(), this.userContextManagerProvider.get());
    }

    public static ListCollectionsInteractor_Factory create(Provider<ICollectionsService> provider, Provider<IUserContextManager> provider2) {
        return new ListCollectionsInteractor_Factory(provider, provider2);
    }

    public static ListCollectionsInteractor newInstance(ICollectionsService iCollectionsService, IUserContextManager iUserContextManager) {
        return new ListCollectionsInteractor(iCollectionsService, iUserContextManager);
    }
}
