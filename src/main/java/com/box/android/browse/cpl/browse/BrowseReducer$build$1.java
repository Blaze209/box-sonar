package com.box.android.browse.cpl.browse;

import com.box.android.cpl.ReducerResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BrowseReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class BrowseReducer$build$1 extends FunctionReferenceImpl implements Function2<BrowseReducer.State, BrowseReducer.Action, ReducerResult<BrowseReducer.State, BrowseReducer.Action>> {
    BrowseReducer$build$1(Object obj) {
        super(2, obj, BrowseReducer.class, "reduceBrowse", "reduceBrowse(Lcom/box/android/browse/cpl/browse/BrowseReducer$State;Lcom/box/android/browse/cpl/browse/BrowseReducer$Action;)Lcom/box/android/cpl/ReducerResult;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final ReducerResult<BrowseReducer.State, BrowseReducer.Action> invoke(BrowseReducer.State p0, BrowseReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return ((BrowseReducer) this.receiver).reduceBrowse(p0, p1);
    }
}
