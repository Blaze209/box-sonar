package com.box.android.browse.cpl.offlined;

import com.box.android.cpl.ReducerResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OfflinedReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class OfflinedReducer$build$1 extends FunctionReferenceImpl implements Function2<OfflinedReducer.State, OfflinedReducer.Action, ReducerResult<OfflinedReducer.State, OfflinedReducer.Action>> {
    OfflinedReducer$build$1(Object obj) {
        super(2, obj, OfflinedReducer.class, "reduceOfflined", "reduceOfflined(Lcom/box/android/browse/cpl/offlined/OfflinedReducer$State;Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Action;)Lcom/box/android/cpl/ReducerResult;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final ReducerResult<OfflinedReducer.State, OfflinedReducer.Action> invoke(OfflinedReducer.State p0, OfflinedReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return ((OfflinedReducer) this.receiver).reduceOfflined(p0, p1);
    }
}
