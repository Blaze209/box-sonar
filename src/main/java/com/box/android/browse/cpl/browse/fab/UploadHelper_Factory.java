package com.box.android.browse.cpl.browse.fab;

import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.services.ILocalItemService;
import com.box.android.domain.services.IRemoteItemService;
import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes10.dex */
public final class UploadHelper_Factory implements Factory<UploadHelper> {
    private final Provider<CoroutineDispatcher> defaultDispatcherProvider;
    private final Provider<ILocalItemService> localItemServiceProvider;
    private final Provider<CoroutineDispatcher> mainDispatcherProvider;
    private final Provider<IRemoteItemService> remoteItemServiceProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private UploadHelper_Factory(Provider<IRemoteItemService> provider, Provider<ILocalItemService> provider2, Provider<IUserContextManager> provider3, Provider<CoroutineDispatcher> provider4, Provider<CoroutineDispatcher> provider5) {
        this.remoteItemServiceProvider = provider;
        this.localItemServiceProvider = provider2;
        this.userContextManagerProvider = provider3;
        this.defaultDispatcherProvider = provider4;
        this.mainDispatcherProvider = provider5;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public UploadHelper get() {
        return newInstance(this.remoteItemServiceProvider.get(), this.localItemServiceProvider.get(), this.userContextManagerProvider.get(), this.defaultDispatcherProvider.get(), this.mainDispatcherProvider.get());
    }

    public static UploadHelper_Factory create(Provider<IRemoteItemService> provider, Provider<ILocalItemService> provider2, Provider<IUserContextManager> provider3, Provider<CoroutineDispatcher> provider4, Provider<CoroutineDispatcher> provider5) {
        return new UploadHelper_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static UploadHelper newInstance(IRemoteItemService iRemoteItemService, ILocalItemService iLocalItemService, IUserContextManager iUserContextManager, CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2) {
        return new UploadHelper(iRemoteItemService, iLocalItemService, iUserContextManager, coroutineDispatcher, coroutineDispatcher2);
    }
}
