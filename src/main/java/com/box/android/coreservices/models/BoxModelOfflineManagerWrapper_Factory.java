package com.box.android.coreservices.models;

import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.services.IRemoteItemService;
import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes9.dex */
public final class BoxModelOfflineManagerWrapper_Factory implements Factory<BoxModelOfflineManagerWrapper> {
    private final Provider<CoroutineDispatcher> dispatcherProvider;
    private final Provider<IRemoteItemService> remoteItemServiceProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private BoxModelOfflineManagerWrapper_Factory(Provider<IUserContextManager> provider, Provider<IRemoteItemService> provider2, Provider<CoroutineDispatcher> provider3) {
        this.userContextManagerProvider = provider;
        this.remoteItemServiceProvider = provider2;
        this.dispatcherProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BoxModelOfflineManagerWrapper get() {
        return newInstance(this.userContextManagerProvider.get(), this.remoteItemServiceProvider.get(), this.dispatcherProvider.get());
    }

    public static BoxModelOfflineManagerWrapper_Factory create(Provider<IUserContextManager> provider, Provider<IRemoteItemService> provider2, Provider<CoroutineDispatcher> provider3) {
        return new BoxModelOfflineManagerWrapper_Factory(provider, provider2, provider3);
    }

    public static BoxModelOfflineManagerWrapper newInstance(IUserContextManager iUserContextManager, IRemoteItemService iRemoteItemService, CoroutineDispatcher coroutineDispatcher) {
        return new BoxModelOfflineManagerWrapper(iUserContextManager, iRemoteItemService, coroutineDispatcher);
    }
}
