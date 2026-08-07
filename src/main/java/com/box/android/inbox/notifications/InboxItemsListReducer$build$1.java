package com.box.android.inbox.notifications;

import com.box.android.cpl.ReducerResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxItemsListReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class InboxItemsListReducer$build$1 extends FunctionReferenceImpl implements Function2<InboxItemsListReducer.State, InboxItemsListReducer.Action, ReducerResult<InboxItemsListReducer.State, InboxItemsListReducer.Action>> {
    InboxItemsListReducer$build$1(Object obj) {
        super(2, obj, InboxItemsListReducer.class, "reduceItemsList", "reduceItemsList(Lcom/box/android/inbox/notifications/InboxItemsListReducer$State;Lcom/box/android/inbox/notifications/InboxItemsListReducer$Action;)Lcom/box/android/cpl/ReducerResult;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final ReducerResult<InboxItemsListReducer.State, InboxItemsListReducer.Action> invoke(InboxItemsListReducer.State p0, InboxItemsListReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return ((InboxItemsListReducer) this.receiver).reduceItemsList(p0, p1);
    }
}
