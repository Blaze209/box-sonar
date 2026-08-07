package com.box.android.inbox.notifications;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxItemsList.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class InboxItemsListKt$NotificationsList$2$1$scopedStoreProvider$1$2 extends FunctionReferenceImpl implements Function2<String, InboxItemReducer.Action, InboxItemsListReducer.Action.ItemAction> {
    public static final InboxItemsListKt$NotificationsList$2$1$scopedStoreProvider$1$2 INSTANCE = new InboxItemsListKt$NotificationsList$2$1$scopedStoreProvider$1$2();

    InboxItemsListKt$NotificationsList$2$1$scopedStoreProvider$1$2() {
        super(2, InboxItemsListReducer.Action.ItemAction.class, "<init>", "<init>(Ljava/lang/String;Lcom/box/android/inbox/notifications/InboxItemReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final InboxItemsListReducer.Action.ItemAction invoke(String p0, InboxItemReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return new InboxItemsListReducer.Action.ItemAction(p0, p1);
    }
}
