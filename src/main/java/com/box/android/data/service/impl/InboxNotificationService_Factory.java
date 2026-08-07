package com.box.android.data.service.impl;

import com.box.android.data.datasource.inboxnotifications.InboxNotificationLocalDataSource;
import com.box.android.data.datasource.inboxnotifications.InboxNotificationRemoteDataSource;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class InboxNotificationService_Factory implements Factory<InboxNotificationService> {
    private final Provider<InboxNotificationLocalDataSource> inboxNotificationLocalDataSourceProvider;
    private final Provider<InboxNotificationRemoteDataSource> inboxNotificationRemoteDataSourceProvider;

    private InboxNotificationService_Factory(Provider<InboxNotificationRemoteDataSource> inboxNotificationRemoteDataSourceProvider, Provider<InboxNotificationLocalDataSource> inboxNotificationLocalDataSourceProvider) {
        this.inboxNotificationRemoteDataSourceProvider = inboxNotificationRemoteDataSourceProvider;
        this.inboxNotificationLocalDataSourceProvider = inboxNotificationLocalDataSourceProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public InboxNotificationService get() {
        return newInstance(this.inboxNotificationRemoteDataSourceProvider.get(), this.inboxNotificationLocalDataSourceProvider.get());
    }

    public static InboxNotificationService_Factory create(Provider<InboxNotificationRemoteDataSource> inboxNotificationRemoteDataSourceProvider, Provider<InboxNotificationLocalDataSource> inboxNotificationLocalDataSourceProvider) {
        return new InboxNotificationService_Factory(inboxNotificationRemoteDataSourceProvider, inboxNotificationLocalDataSourceProvider);
    }

    public static InboxNotificationService newInstance(InboxNotificationRemoteDataSource inboxNotificationRemoteDataSource, InboxNotificationLocalDataSource inboxNotificationLocalDataSource) {
        return new InboxNotificationService(inboxNotificationRemoteDataSource, inboxNotificationLocalDataSource);
    }
}
