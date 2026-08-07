package com.box.android.inbox.notifications.inboxitem.collab;

import com.box.android.common.utilities.Clock;
import com.box.android.domain.services.IInboxCollaborationService;
import com.box.android.inbox.mfasetup.MfaSetupAnalytics;
import com.box.android.inbox.mfasetup.MfaSetupDialogEnvironment;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxItemCollaborationReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationEnvironment;", "", "mfaSetupAnalytics", "Lcom/box/android/inbox/mfasetup/MfaSetupAnalytics;", "inboxCollaborationService", "Lcom/box/android/domain/services/IInboxCollaborationService;", "mfaSetupDialogEnvironment", "Lcom/box/android/inbox/mfasetup/MfaSetupDialogEnvironment;", "clock", "Lcom/box/android/common/utilities/Clock;", "<init>", "(Lcom/box/android/inbox/mfasetup/MfaSetupAnalytics;Lcom/box/android/domain/services/IInboxCollaborationService;Lcom/box/android/inbox/mfasetup/MfaSetupDialogEnvironment;Lcom/box/android/common/utilities/Clock;)V", "getMfaSetupAnalytics", "()Lcom/box/android/inbox/mfasetup/MfaSetupAnalytics;", "getInboxCollaborationService", "()Lcom/box/android/domain/services/IInboxCollaborationService;", "getMfaSetupDialogEnvironment", "()Lcom/box/android/inbox/mfasetup/MfaSetupDialogEnvironment;", "getClock", "()Lcom/box/android/common/utilities/Clock;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class InboxItemCollaborationEnvironment {
    public static final int $stable = 8;
    private final Clock clock;
    private final IInboxCollaborationService inboxCollaborationService;
    private final MfaSetupAnalytics mfaSetupAnalytics;
    private final MfaSetupDialogEnvironment mfaSetupDialogEnvironment;

    @Inject
    public InboxItemCollaborationEnvironment(MfaSetupAnalytics mfaSetupAnalytics, IInboxCollaborationService inboxCollaborationService, MfaSetupDialogEnvironment mfaSetupDialogEnvironment, Clock clock) {
        Intrinsics.checkNotNullParameter(mfaSetupAnalytics, "mfaSetupAnalytics");
        Intrinsics.checkNotNullParameter(inboxCollaborationService, "inboxCollaborationService");
        Intrinsics.checkNotNullParameter(mfaSetupDialogEnvironment, "mfaSetupDialogEnvironment");
        Intrinsics.checkNotNullParameter(clock, "clock");
        this.mfaSetupAnalytics = mfaSetupAnalytics;
        this.inboxCollaborationService = inboxCollaborationService;
        this.mfaSetupDialogEnvironment = mfaSetupDialogEnvironment;
        this.clock = clock;
    }

    public final MfaSetupAnalytics getMfaSetupAnalytics() {
        return this.mfaSetupAnalytics;
    }

    public final IInboxCollaborationService getInboxCollaborationService() {
        return this.inboxCollaborationService;
    }

    public final MfaSetupDialogEnvironment getMfaSetupDialogEnvironment() {
        return this.mfaSetupDialogEnvironment;
    }

    public final Clock getClock() {
        return this.clock;
    }
}
