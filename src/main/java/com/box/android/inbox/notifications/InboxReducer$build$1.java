package com.box.android.inbox.notifications;

import com.box.android.cpl.ReducerResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class InboxReducer$build$1 extends FunctionReferenceImpl implements Function2<InboxReducer.State, InboxReducer.Action, ReducerResult<InboxReducer.State, InboxReducer.Action>> {
    InboxReducer$build$1(Object obj) {
        super(2, obj, InboxReducer.class, "reduceInbox", "reduceInbox(Lcom/box/android/inbox/notifications/InboxReducer$State;Lcom/box/android/inbox/notifications/InboxReducer$Action;)Lcom/box/android/cpl/ReducerResult;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final ReducerResult<InboxReducer.State, InboxReducer.Action> invoke(InboxReducer.State p0, InboxReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return ((InboxReducer) this.receiver).reduceInbox(p0, p1);
    }
}
