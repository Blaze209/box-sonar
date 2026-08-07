package com.box.android.boxai.qa;

import com.box.android.cpl.ReducerResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxAiQaReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class BoxAiQaReducer$build$14 extends FunctionReferenceImpl implements Function2<BoxAiQaReducer.State, BoxAiQaReducer.Action, ReducerResult<BoxAiQaReducer.State, BoxAiQaReducer.Action>> {
    BoxAiQaReducer$build$14(Object obj) {
        super(2, obj, BoxAiQaReducer.class, "reduceAnalytics", "reduceAnalytics(Lcom/box/android/boxai/qa/BoxAiQaReducer$State;Lcom/box/android/boxai/qa/BoxAiQaReducer$Action;)Lcom/box/android/cpl/ReducerResult;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final ReducerResult<BoxAiQaReducer.State, BoxAiQaReducer.Action> invoke(BoxAiQaReducer.State p0, BoxAiQaReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return ((BoxAiQaReducer) this.receiver).reduceAnalytics(p0, p1);
    }
}
