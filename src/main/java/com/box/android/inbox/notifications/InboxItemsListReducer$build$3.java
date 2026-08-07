package com.box.android.inbox.notifications;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxItemsListReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class InboxItemsListReducer$build$3 extends FunctionReferenceImpl implements Function2<String, InboxItemReducer.Action, InboxItemsListReducer.Action.ItemAction> {
    public static final InboxItemsListReducer$build$3 INSTANCE = new InboxItemsListReducer$build$3();

    InboxItemsListReducer$build$3() {
        super(2, InboxItemsListReducer.Action.ItemAction.class, "<init>", "<init>(Ljava/lang/String;Lcom/box/android/inbox/notifications/InboxItemReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final InboxItemsListReducer.Action.ItemAction invoke(String p0, InboxItemReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return new InboxItemsListReducer.Action.ItemAction(p0, p1);
    }
}
