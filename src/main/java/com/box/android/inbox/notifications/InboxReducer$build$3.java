package com.box.android.inbox.notifications;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class InboxReducer$build$3 extends FunctionReferenceImpl implements Function1<InboxItemsListReducer.Action, InboxReducer.Action.ItemsListAction> {
    public static final InboxReducer$build$3 INSTANCE = new InboxReducer$build$3();

    InboxReducer$build$3() {
        super(1, InboxReducer.Action.ItemsListAction.class, "<init>", "<init>(Lcom/box/android/inbox/notifications/InboxItemsListReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final InboxReducer.Action.ItemsListAction invoke(InboxItemsListReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new InboxReducer.Action.ItemsListAction(p0);
    }
}
