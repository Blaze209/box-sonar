package com.box.android.vm;

import com.box.android.base.presentation.components.topbar.component.inbox.InboxBadgeRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes13.dex */
public final class InboxBadgeVM_Factory implements Factory<InboxBadgeVM> {
    private final Provider<InboxBadgeRepository> badgeRepoProvider;

    private InboxBadgeVM_Factory(Provider<InboxBadgeRepository> provider) {
        this.badgeRepoProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public InboxBadgeVM get() {
        return newInstance(this.badgeRepoProvider.get());
    }

    public static InboxBadgeVM_Factory create(Provider<InboxBadgeRepository> provider) {
        return new InboxBadgeVM_Factory(provider);
    }

    public static InboxBadgeVM newInstance(InboxBadgeRepository inboxBadgeRepository) {
        return new InboxBadgeVM(inboxBadgeRepository);
    }
}
