package com.box.android.base.presentation.components.topbar.component.inbox;

import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class InboxCountEnvironment_Factory implements Factory<InboxCountEnvironment> {
    private final Provider<InboxBadgeRepository> inboxBadgeRepositoryProvider;

    private InboxCountEnvironment_Factory(Provider<InboxBadgeRepository> provider) {
        this.inboxBadgeRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public InboxCountEnvironment get() {
        return newInstance(this.inboxBadgeRepositoryProvider.get());
    }

    public static InboxCountEnvironment_Factory create(Provider<InboxBadgeRepository> provider) {
        return new InboxCountEnvironment_Factory(provider);
    }

    public static InboxCountEnvironment newInstance(InboxBadgeRepository inboxBadgeRepository) {
        return new InboxCountEnvironment(inboxBadgeRepository);
    }
}
