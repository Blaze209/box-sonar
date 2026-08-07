package com.box.android.inbox.notifications;

import com.box.android.base.presentation.components.topbar.component.inbox.InboxBadgeRepository;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.services.IInboxNotificationService;
import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes12.dex */
public final class InboxItemsListEnvironment_Factory implements Factory<InboxItemsListEnvironment> {
    private final Provider<CoroutineDispatcher> dispatcherProvider;
    private final Provider<InboxBadgeRepository> inboxBadgeRepositoryProvider;
    private final Provider<InboxItemEnvironment> inboxItemEnvironmentProvider;
    private final Provider<IInboxNotificationService> inboxNotificationServiceProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private InboxItemsListEnvironment_Factory(Provider<InboxItemEnvironment> provider, Provider<IInboxNotificationService> provider2, Provider<IUserContextManager> provider3, Provider<InboxBadgeRepository> provider4, Provider<CoroutineDispatcher> provider5) {
        this.inboxItemEnvironmentProvider = provider;
        this.inboxNotificationServiceProvider = provider2;
        this.userContextManagerProvider = provider3;
        this.inboxBadgeRepositoryProvider = provider4;
        this.dispatcherProvider = provider5;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public InboxItemsListEnvironment get() {
        return newInstance(this.inboxItemEnvironmentProvider.get(), this.inboxNotificationServiceProvider.get(), this.userContextManagerProvider.get(), this.inboxBadgeRepositoryProvider.get(), this.dispatcherProvider.get());
    }

    public static InboxItemsListEnvironment_Factory create(Provider<InboxItemEnvironment> provider, Provider<IInboxNotificationService> provider2, Provider<IUserContextManager> provider3, Provider<InboxBadgeRepository> provider4, Provider<CoroutineDispatcher> provider5) {
        return new InboxItemsListEnvironment_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static InboxItemsListEnvironment newInstance(InboxItemEnvironment inboxItemEnvironment, IInboxNotificationService iInboxNotificationService, IUserContextManager iUserContextManager, InboxBadgeRepository inboxBadgeRepository, CoroutineDispatcher coroutineDispatcher) {
        return new InboxItemsListEnvironment(inboxItemEnvironment, iInboxNotificationService, iUserContextManager, inboxBadgeRepository, coroutineDispatcher);
    }
}
