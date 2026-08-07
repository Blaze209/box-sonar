package com.box.android.data.service.impl;

import com.box.android.data.datasource.PushNotificationSettingsRemoteDataSource;
import com.box.android.domain.identity.IUserContextManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class PushNotificationSettingsService_Factory implements Factory<PushNotificationSettingsService> {
    private final Provider<PushNotificationSettingsRemoteDataSource> pushNotificationSettingsRemoteDataSourceProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private PushNotificationSettingsService_Factory(Provider<PushNotificationSettingsRemoteDataSource> pushNotificationSettingsRemoteDataSourceProvider, Provider<IUserContextManager> userContextManagerProvider) {
        this.pushNotificationSettingsRemoteDataSourceProvider = pushNotificationSettingsRemoteDataSourceProvider;
        this.userContextManagerProvider = userContextManagerProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public PushNotificationSettingsService get() {
        return newInstance(this.pushNotificationSettingsRemoteDataSourceProvider.get(), this.userContextManagerProvider.get());
    }

    public static PushNotificationSettingsService_Factory create(Provider<PushNotificationSettingsRemoteDataSource> pushNotificationSettingsRemoteDataSourceProvider, Provider<IUserContextManager> userContextManagerProvider) {
        return new PushNotificationSettingsService_Factory(pushNotificationSettingsRemoteDataSourceProvider, userContextManagerProvider);
    }

    public static PushNotificationSettingsService newInstance(PushNotificationSettingsRemoteDataSource pushNotificationSettingsRemoteDataSource, IUserContextManager userContextManager) {
        return new PushNotificationSettingsService(pushNotificationSettingsRemoteDataSource, userContextManager);
    }
}
