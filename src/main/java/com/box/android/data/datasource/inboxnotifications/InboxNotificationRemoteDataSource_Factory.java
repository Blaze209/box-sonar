package com.box.android.data.datasource.inboxnotifications;

import com.box.android.data.api.requests.InboxNotificationRequest;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class InboxNotificationRemoteDataSource_Factory implements Factory<InboxNotificationRemoteDataSource> {
    private final Provider<InboxNotificationRequest> inboxNotificationRequestProvider;
    private final Provider<Moshi> moshiProvider;

    private InboxNotificationRemoteDataSource_Factory(Provider<InboxNotificationRequest> inboxNotificationRequestProvider, Provider<Moshi> moshiProvider) {
        this.inboxNotificationRequestProvider = inboxNotificationRequestProvider;
        this.moshiProvider = moshiProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public InboxNotificationRemoteDataSource get() {
        return newInstance(this.inboxNotificationRequestProvider.get(), this.moshiProvider.get());
    }

    public static InboxNotificationRemoteDataSource_Factory create(Provider<InboxNotificationRequest> inboxNotificationRequestProvider, Provider<Moshi> moshiProvider) {
        return new InboxNotificationRemoteDataSource_Factory(inboxNotificationRequestProvider, moshiProvider);
    }

    public static InboxNotificationRemoteDataSource newInstance(InboxNotificationRequest inboxNotificationRequest, Moshi moshi) {
        return new InboxNotificationRemoteDataSource(inboxNotificationRequest, moshi);
    }
}
