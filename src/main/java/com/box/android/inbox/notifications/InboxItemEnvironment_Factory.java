package com.box.android.inbox.notifications;

import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.services.IInboxNotificationService;
import com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationEnvironment;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class InboxItemEnvironment_Factory implements Factory<InboxItemEnvironment> {
    private final Provider<InboxItemCollaborationEnvironment> inboxItemCollaborationEnvironmentProvider;
    private final Provider<IInboxNotificationService> inboxNotificationServiceProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private InboxItemEnvironment_Factory(Provider<IUserContextManager> provider, Provider<InboxItemCollaborationEnvironment> provider2, Provider<IInboxNotificationService> provider3) {
        this.userContextManagerProvider = provider;
        this.inboxItemCollaborationEnvironmentProvider = provider2;
        this.inboxNotificationServiceProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public InboxItemEnvironment get() {
        return newInstance(this.userContextManagerProvider.get(), this.inboxItemCollaborationEnvironmentProvider.get(), this.inboxNotificationServiceProvider.get());
    }

    public static InboxItemEnvironment_Factory create(Provider<IUserContextManager> provider, Provider<InboxItemCollaborationEnvironment> provider2, Provider<IInboxNotificationService> provider3) {
        return new InboxItemEnvironment_Factory(provider, provider2, provider3);
    }

    public static InboxItemEnvironment newInstance(IUserContextManager iUserContextManager, InboxItemCollaborationEnvironment inboxItemCollaborationEnvironment, IInboxNotificationService iInboxNotificationService) {
        return new InboxItemEnvironment(iUserContextManager, inboxItemCollaborationEnvironment, iInboxNotificationService);
    }
}
