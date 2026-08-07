package com.box.android.base.presentation.components.topbar.component.inbox;

import com.box.android.cpl.ReducerResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxCountReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class InboxCountReducer$build$1 extends FunctionReferenceImpl implements Function2<InboxCountReducer.State, InboxCountReducer.Action, ReducerResult<InboxCountReducer.State, InboxCountReducer.Action>> {
    InboxCountReducer$build$1(Object obj) {
        super(2, obj, InboxCountReducer.class, "reduceInboxCount", "reduceInboxCount(Lcom/box/android/base/presentation/components/topbar/component/inbox/InboxCountReducer$State;Lcom/box/android/base/presentation/components/topbar/component/inbox/InboxCountReducer$Action;)Lcom/box/android/cpl/ReducerResult;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final ReducerResult<InboxCountReducer.State, InboxCountReducer.Action> invoke(InboxCountReducer.State p0, InboxCountReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return ((InboxCountReducer) this.receiver).reduceInboxCount(p0, p1);
    }
}
