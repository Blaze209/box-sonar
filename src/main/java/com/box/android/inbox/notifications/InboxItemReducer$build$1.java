package com.box.android.inbox.notifications;

import com.box.android.cpl.ReducerResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxItemReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class InboxItemReducer$build$1 extends FunctionReferenceImpl implements Function2<InboxItemReducer.State, InboxItemReducer.Action, ReducerResult<InboxItemReducer.State, InboxItemReducer.Action>> {
    InboxItemReducer$build$1(Object obj) {
        super(2, obj, InboxItemReducer.class, "reduceItem", "reduceItem(Lcom/box/android/inbox/notifications/InboxItemReducer$State;Lcom/box/android/inbox/notifications/InboxItemReducer$Action;)Lcom/box/android/cpl/ReducerResult;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final ReducerResult<InboxItemReducer.State, InboxItemReducer.Action> invoke(InboxItemReducer.State p0, InboxItemReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return ((InboxItemReducer) this.receiver).reduceItem(p0, p1);
    }
}
