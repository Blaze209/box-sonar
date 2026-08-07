package com.box.android.inbox.notifications;

import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class InboxEnvironment_Factory implements Factory<InboxEnvironment> {
    private final Provider<InboxItemsListEnvironment> inboxItemsListEnvironmentProvider;

    private InboxEnvironment_Factory(Provider<InboxItemsListEnvironment> provider) {
        this.inboxItemsListEnvironmentProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public InboxEnvironment get() {
        return newInstance(this.inboxItemsListEnvironmentProvider.get());
    }

    public static InboxEnvironment_Factory create(Provider<InboxItemsListEnvironment> provider) {
        return new InboxEnvironment_Factory(provider);
    }

    public static InboxEnvironment newInstance(InboxItemsListEnvironment inboxItemsListEnvironment) {
        return new InboxEnvironment(inboxItemsListEnvironment);
    }
}
