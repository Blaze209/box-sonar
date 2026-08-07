package com.box.android.data.datasource.hubs;

import com.box.android.domain.identity.IUserContextManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class HubAssetLocalDataSource_Factory implements Factory<HubAssetLocalDataSource> {
    private final Provider<IUserContextManager> userContextManagerProvider;

    private HubAssetLocalDataSource_Factory(Provider<IUserContextManager> userContextManagerProvider) {
        this.userContextManagerProvider = userContextManagerProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public HubAssetLocalDataSource get() {
        return newInstance(this.userContextManagerProvider.get());
    }

    public static HubAssetLocalDataSource_Factory create(Provider<IUserContextManager> userContextManagerProvider) {
        return new HubAssetLocalDataSource_Factory(userContextManagerProvider);
    }

    public static HubAssetLocalDataSource newInstance(IUserContextManager userContextManager) {
        return new HubAssetLocalDataSource(userContextManager);
    }
}
