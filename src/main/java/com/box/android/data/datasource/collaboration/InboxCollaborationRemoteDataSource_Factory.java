package com.box.android.data.datasource.collaboration;

import com.box.android.data.api.requests.InboxCollaborationRequest;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class InboxCollaborationRemoteDataSource_Factory implements Factory<InboxCollaborationRemoteDataSource> {
    private final Provider<InboxCollaborationRequest> inboxCollaborationRequestProvider;
    private final Provider<Moshi> moshiProvider;

    private InboxCollaborationRemoteDataSource_Factory(Provider<InboxCollaborationRequest> inboxCollaborationRequestProvider, Provider<Moshi> moshiProvider) {
        this.inboxCollaborationRequestProvider = inboxCollaborationRequestProvider;
        this.moshiProvider = moshiProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public InboxCollaborationRemoteDataSource get() {
        return newInstance(this.inboxCollaborationRequestProvider.get(), this.moshiProvider.get());
    }

    public static InboxCollaborationRemoteDataSource_Factory create(Provider<InboxCollaborationRequest> inboxCollaborationRequestProvider, Provider<Moshi> moshiProvider) {
        return new InboxCollaborationRemoteDataSource_Factory(inboxCollaborationRequestProvider, moshiProvider);
    }

    public static InboxCollaborationRemoteDataSource newInstance(InboxCollaborationRequest inboxCollaborationRequest, Moshi moshi) {
        return new InboxCollaborationRemoteDataSource(inboxCollaborationRequest, moshi);
    }
}
