package com.box.android.inbox.notifications;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxContent.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class InboxContentKt$InboxContent$1$2$1 extends FunctionReferenceImpl implements Function1<InboxItemsListReducer.Action, InboxReducer.Action.ItemsListAction> {
    public static final InboxContentKt$InboxContent$1$2$1 INSTANCE = new InboxContentKt$InboxContent$1$2$1();

    InboxContentKt$InboxContent$1$2$1() {
        super(1, InboxReducer.Action.ItemsListAction.class, "<init>", "<init>(Lcom/box/android/inbox/notifications/InboxItemsListReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final InboxReducer.Action.ItemsListAction invoke(InboxItemsListReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new InboxReducer.Action.ItemsListAction(p0);
    }
}
