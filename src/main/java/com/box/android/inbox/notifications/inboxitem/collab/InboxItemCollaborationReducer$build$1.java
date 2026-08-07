package com.box.android.inbox.notifications.inboxitem.collab;

import com.box.android.cpl.ReducerResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxItemCollaborationReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class InboxItemCollaborationReducer$build$1 extends FunctionReferenceImpl implements Function2<InboxItemCollaborationReducer.State, InboxItemCollaborationReducer.Action, ReducerResult<InboxItemCollaborationReducer.State, InboxItemCollaborationReducer.Action>> {
    InboxItemCollaborationReducer$build$1(Object obj) {
        super(2, obj, InboxItemCollaborationReducer.class, "reduceCollaboration", "reduceCollaboration(Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$State;Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$Action;)Lcom/box/android/cpl/ReducerResult;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final ReducerResult<InboxItemCollaborationReducer.State, InboxItemCollaborationReducer.Action> invoke(InboxItemCollaborationReducer.State p0, InboxItemCollaborationReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return ((InboxItemCollaborationReducer) this.receiver).reduceCollaboration(p0, p1);
    }
}
