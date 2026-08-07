package com.box.android.data.service.impl;

import com.box.android.domain.identity.IUserContextManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class CaptureThumbnailService_Factory implements Factory<CaptureThumbnailService> {
    private final Provider<IUserContextManager> userContextManagerProvider;

    private CaptureThumbnailService_Factory(Provider<IUserContextManager> userContextManagerProvider) {
        this.userContextManagerProvider = userContextManagerProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CaptureThumbnailService get() {
        return newInstance(this.userContextManagerProvider.get());
    }

    public static CaptureThumbnailService_Factory create(Provider<IUserContextManager> userContextManagerProvider) {
        return new CaptureThumbnailService_Factory(userContextManagerProvider);
    }

    public static CaptureThumbnailService newInstance(IUserContextManager userContextManager) {
        return new CaptureThumbnailService(userContextManager);
    }
}
