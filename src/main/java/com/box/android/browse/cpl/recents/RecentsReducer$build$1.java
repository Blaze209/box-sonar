package com.box.android.browse.cpl.recents;

import com.box.android.cpl.ReducerResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RecentsReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class RecentsReducer$build$1 extends FunctionReferenceImpl implements Function2<RecentsReducer.State, RecentsReducer.Action, ReducerResult<RecentsReducer.State, RecentsReducer.Action>> {
    RecentsReducer$build$1(Object obj) {
        super(2, obj, RecentsReducer.class, "reduceRecents", "reduceRecents(Lcom/box/android/browse/cpl/recents/RecentsReducer$State;Lcom/box/android/browse/cpl/recents/RecentsReducer$Action;)Lcom/box/android/cpl/ReducerResult;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final ReducerResult<RecentsReducer.State, RecentsReducer.Action> invoke(RecentsReducer.State p0, RecentsReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return ((RecentsReducer) this.receiver).reduceRecents(p0, p1);
    }
}
