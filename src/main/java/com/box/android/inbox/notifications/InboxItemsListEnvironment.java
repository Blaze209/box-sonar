package com.box.android.inbox.notifications;

import com.box.android.base.presentation.components.topbar.component.inbox.InboxBadgeRepository;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.services.IInboxNotificationService;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: compiled from: InboxItemsListReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B3\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/box/android/inbox/notifications/InboxItemsListEnvironment;", "", "inboxItemEnvironment", "Lcom/box/android/inbox/notifications/InboxItemEnvironment;", "inboxNotificationService", "Lcom/box/android/domain/services/IInboxNotificationService;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "inboxBadgeRepository", "Lcom/box/android/base/presentation/components/topbar/component/inbox/InboxBadgeRepository;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/box/android/inbox/notifications/InboxItemEnvironment;Lcom/box/android/domain/services/IInboxNotificationService;Lcom/box/android/domain/identity/IUserContextManager;Lcom/box/android/base/presentation/components/topbar/component/inbox/InboxBadgeRepository;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getInboxItemEnvironment", "()Lcom/box/android/inbox/notifications/InboxItemEnvironment;", "getInboxNotificationService", "()Lcom/box/android/domain/services/IInboxNotificationService;", "getUserContextManager", "()Lcom/box/android/domain/identity/IUserContextManager;", "getInboxBadgeRepository", "()Lcom/box/android/base/presentation/components/topbar/component/inbox/InboxBadgeRepository;", "getDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class InboxItemsListEnvironment {
    public static final int $stable = 8;
    private final CoroutineDispatcher dispatcher;
    private final InboxBadgeRepository inboxBadgeRepository;
    private final InboxItemEnvironment inboxItemEnvironment;
    private final IInboxNotificationService inboxNotificationService;
    private final IUserContextManager userContextManager;

    @Inject
    public InboxItemsListEnvironment(InboxItemEnvironment inboxItemEnvironment, IInboxNotificationService inboxNotificationService, IUserContextManager userContextManager, InboxBadgeRepository inboxBadgeRepository, CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(inboxItemEnvironment, "inboxItemEnvironment");
        Intrinsics.checkNotNullParameter(inboxNotificationService, "inboxNotificationService");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(inboxBadgeRepository, "inboxBadgeRepository");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.inboxItemEnvironment = inboxItemEnvironment;
        this.inboxNotificationService = inboxNotificationService;
        this.userContextManager = userContextManager;
        this.inboxBadgeRepository = inboxBadgeRepository;
        this.dispatcher = dispatcher;
    }

    public final InboxItemEnvironment getInboxItemEnvironment() {
        return this.inboxItemEnvironment;
    }

    public final IInboxNotificationService getInboxNotificationService() {
        return this.inboxNotificationService;
    }

    public final IUserContextManager getUserContextManager() {
        return this.userContextManager;
    }

    public final InboxBadgeRepository getInboxBadgeRepository() {
        return this.inboxBadgeRepository;
    }

    public final CoroutineDispatcher getDispatcher() {
        return this.dispatcher;
    }
}
