package com.box.android.preview.previousversion;

import com.box.android.cpl.ReducerResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviousVersionReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class PreviousVersionReducer$build$1 extends FunctionReferenceImpl implements Function2<PreviousVersionReducer.State, PreviousVersionReducer.Action, ReducerResult<PreviousVersionReducer.State, PreviousVersionReducer.Action>> {
    PreviousVersionReducer$build$1(Object obj) {
        super(2, obj, PreviousVersionReducer.class, "reducePreviousVersion", "reducePreviousVersion(Lcom/box/android/preview/previousversion/PreviousVersionReducer$State;Lcom/box/android/preview/previousversion/PreviousVersionReducer$Action;)Lcom/box/android/cpl/ReducerResult;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final ReducerResult<PreviousVersionReducer.State, PreviousVersionReducer.Action> invoke(PreviousVersionReducer.State p0, PreviousVersionReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return ((PreviousVersionReducer) this.receiver).reducePreviousVersion(p0, p1);
    }
}
