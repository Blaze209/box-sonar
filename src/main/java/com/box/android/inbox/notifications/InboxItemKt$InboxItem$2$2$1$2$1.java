package com.box.android.inbox.notifications;

import com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxItem.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class InboxItemKt$InboxItem$2$2$1$2$1 extends FunctionReferenceImpl implements Function1<InboxItemCollaborationReducer.Action, InboxItemReducer.Action.CollaborationAction> {
    public static final InboxItemKt$InboxItem$2$2$1$2$1 INSTANCE = new InboxItemKt$InboxItem$2$2$1$2$1();

    InboxItemKt$InboxItem$2$2$1$2$1() {
        super(1, InboxItemReducer.Action.CollaborationAction.class, "<init>", "<init>(Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final InboxItemReducer.Action.CollaborationAction invoke(InboxItemCollaborationReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new InboxItemReducer.Action.CollaborationAction(p0);
    }
}
