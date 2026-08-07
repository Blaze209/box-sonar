package com.box.android.data.service.impl;

import com.box.android.domain.identity.IUserContextManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class PreviewSettingsService_Factory implements Factory<PreviewSettingsService> {
    private final Provider<IUserContextManager> userContextManagerProvider;

    private PreviewSettingsService_Factory(Provider<IUserContextManager> userContextManagerProvider) {
        this.userContextManagerProvider = userContextManagerProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public PreviewSettingsService get() {
        return newInstance(this.userContextManagerProvider.get());
    }

    public static PreviewSettingsService_Factory create(Provider<IUserContextManager> userContextManagerProvider) {
        return new PreviewSettingsService_Factory(userContextManagerProvider);
    }

    public static PreviewSettingsService newInstance(IUserContextManager userContextManager) {
        return new PreviewSettingsService(userContextManager);
    }
}
