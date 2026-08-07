package com.box.android.inbox.notifications.inboxitem.collab;

import com.box.android.inbox.mfasetup.MfaSetupDialogReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxItemCollaboration.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class InboxItemCollaborationKt$InboxItemCollaboration$6$6$1 extends FunctionReferenceImpl implements Function1<MfaSetupDialogReducer.Action, InboxItemCollaborationReducer.Action.MfaSetupDialogAction> {
    public static final InboxItemCollaborationKt$InboxItemCollaboration$6$6$1 INSTANCE = new InboxItemCollaborationKt$InboxItemCollaboration$6$6$1();

    InboxItemCollaborationKt$InboxItemCollaboration$6$6$1() {
        super(1, InboxItemCollaborationReducer.Action.MfaSetupDialogAction.class, "<init>", "<init>(Lcom/box/android/inbox/mfasetup/MfaSetupDialogReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final InboxItemCollaborationReducer.Action.MfaSetupDialogAction invoke(MfaSetupDialogReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new InboxItemCollaborationReducer.Action.MfaSetupDialogAction(p0);
    }
}
