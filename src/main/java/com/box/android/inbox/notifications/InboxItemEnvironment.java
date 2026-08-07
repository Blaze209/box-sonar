package com.box.android.inbox.notifications;

import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.services.IInboxNotificationService;
import com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationEnvironment;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxItemReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/box/android/inbox/notifications/InboxItemEnvironment;", "", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "inboxItemCollaborationEnvironment", "Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationEnvironment;", "inboxNotificationService", "Lcom/box/android/domain/services/IInboxNotificationService;", "<init>", "(Lcom/box/android/domain/identity/IUserContextManager;Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationEnvironment;Lcom/box/android/domain/services/IInboxNotificationService;)V", "getUserContextManager", "()Lcom/box/android/domain/identity/IUserContextManager;", "getInboxItemCollaborationEnvironment", "()Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationEnvironment;", "getInboxNotificationService", "()Lcom/box/android/domain/services/IInboxNotificationService;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class InboxItemEnvironment {
    public static final int $stable = 8;
    private final InboxItemCollaborationEnvironment inboxItemCollaborationEnvironment;
    private final IInboxNotificationService inboxNotificationService;
    private final IUserContextManager userContextManager;

    @Inject
    public InboxItemEnvironment(IUserContextManager userContextManager, InboxItemCollaborationEnvironment inboxItemCollaborationEnvironment, IInboxNotificationService inboxNotificationService) {
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(inboxItemCollaborationEnvironment, "inboxItemCollaborationEnvironment");
        Intrinsics.checkNotNullParameter(inboxNotificationService, "inboxNotificationService");
        this.userContextManager = userContextManager;
        this.inboxItemCollaborationEnvironment = inboxItemCollaborationEnvironment;
        this.inboxNotificationService = inboxNotificationService;
    }

    public final IUserContextManager getUserContextManager() {
        return this.userContextManager;
    }

    public final InboxItemCollaborationEnvironment getInboxItemCollaborationEnvironment() {
        return this.inboxItemCollaborationEnvironment;
    }

    public final IInboxNotificationService getInboxNotificationService() {
        return this.inboxNotificationService;
    }
}
