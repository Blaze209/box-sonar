package com.box.android.cpl;

import com.pspdfkit.analytics.Analytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Reducable.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aO\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u0006\u0010\u0006\u001a\u0002H\u0003¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"chainWith", "Lcom/box/android/cpl/ReducerResult;", "State", "Action", "reducer", "Lcom/box/android/cpl/Reducable;", Analytics.Data.ACTION, "(Lcom/box/android/cpl/ReducerResult;Lcom/box/android/cpl/Reducable;Ljava/lang/Object;)Lcom/box/android/cpl/ReducerResult;", "cpl-core_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ReducableKt {
    public static final <State, Action> ReducerResult<State, Action> chainWith(ReducerResult<State, Action> reducerResult, Reducable<State, Action> reducer, Action action) {
        Intrinsics.checkNotNullParameter(reducerResult, "<this>");
        Intrinsics.checkNotNullParameter(reducer, "reducer");
        ReducerResult<State, Action> reducerResultReduce = reducer.reduce(reducerResult.getState(), action);
        return new ReducerResult<>(reducerResultReduce.component1(), Effect.INSTANCE.merge((Effect[]) new Effect[]{reducerResult.getEffect(), reducerResultReduce.component2()}));
    }
}
