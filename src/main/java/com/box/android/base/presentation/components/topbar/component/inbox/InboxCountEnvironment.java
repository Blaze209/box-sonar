package com.box.android.base.presentation.components.topbar.component.inbox;

import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxCountReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/base/presentation/components/topbar/component/inbox/InboxCountEnvironment;", "", "inboxBadgeRepository", "Lcom/box/android/base/presentation/components/topbar/component/inbox/InboxBadgeRepository;", "<init>", "(Lcom/box/android/base/presentation/components/topbar/component/inbox/InboxBadgeRepository;)V", "getInboxBadgeRepository", "()Lcom/box/android/base/presentation/components/topbar/component/inbox/InboxBadgeRepository;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class InboxCountEnvironment {
    public static final int $stable = 8;
    private final InboxBadgeRepository inboxBadgeRepository;

    @Inject
    public InboxCountEnvironment(InboxBadgeRepository inboxBadgeRepository) {
        Intrinsics.checkNotNullParameter(inboxBadgeRepository, "inboxBadgeRepository");
        this.inboxBadgeRepository = inboxBadgeRepository;
    }

    public final InboxBadgeRepository getInboxBadgeRepository() {
        return this.inboxBadgeRepository;
    }
}
