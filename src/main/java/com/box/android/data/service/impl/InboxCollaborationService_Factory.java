package com.box.android.data.service.impl;

import com.box.android.data.datasource.collaboration.InboxCollaborationRemoteDataSource;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class InboxCollaborationService_Factory implements Factory<InboxCollaborationService> {
    private final Provider<InboxCollaborationRemoteDataSource> inboxCollaborationRemoteDataSourceProvider;

    private InboxCollaborationService_Factory(Provider<InboxCollaborationRemoteDataSource> inboxCollaborationRemoteDataSourceProvider) {
        this.inboxCollaborationRemoteDataSourceProvider = inboxCollaborationRemoteDataSourceProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public InboxCollaborationService get() {
        return newInstance(this.inboxCollaborationRemoteDataSourceProvider.get());
    }

    public static InboxCollaborationService_Factory create(Provider<InboxCollaborationRemoteDataSource> inboxCollaborationRemoteDataSourceProvider) {
        return new InboxCollaborationService_Factory(inboxCollaborationRemoteDataSourceProvider);
    }

    public static InboxCollaborationService newInstance(InboxCollaborationRemoteDataSource inboxCollaborationRemoteDataSource) {
        return new InboxCollaborationService(inboxCollaborationRemoteDataSource);
    }
}
