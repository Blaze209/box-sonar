package com.box.android.coreservices.models;

import com.box.android.domain.identity.IUserContextManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class BoxModelOfflineManager_Manager_Factory implements Factory<BoxModelOfflineManager.Manager> {
    private final Provider<IUserContextManager> userContextManagerProvider;

    private BoxModelOfflineManager_Manager_Factory(Provider<IUserContextManager> provider) {
        this.userContextManagerProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BoxModelOfflineManager.Manager get() {
        return newInstance(this.userContextManagerProvider.get());
    }

    public static BoxModelOfflineManager_Manager_Factory create(Provider<IUserContextManager> provider) {
        return new BoxModelOfflineManager_Manager_Factory(provider);
    }

    public static BoxModelOfflineManager.Manager newInstance(IUserContextManager iUserContextManager) {
        return new BoxModelOfflineManager.Manager(iUserContextManager);
    }
}
