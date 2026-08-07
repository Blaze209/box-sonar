package com.box.android.cpl;

import com.pspdfkit.analytics.Analytics;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Reducable.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B+\u0012$\u0010\u0004\u001a \u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0005¢\u0006\u0002\u0010\u0007J)\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00062\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\n\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000bR,\u0010\u0004\u001a \u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/box/android/cpl/Reduce;", "State", "Action", "Lcom/box/android/cpl/Reducable;", "reducer", "Lkotlin/Function2;", "Lcom/box/android/cpl/ReducerResult;", "(Lkotlin/jvm/functions/Function2;)V", "reduce", "state", Analytics.Data.ACTION, "(Ljava/lang/Object;Ljava/lang/Object;)Lcom/box/android/cpl/ReducerResult;", "cpl-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Reduce<State, Action> implements Reducable<State, Action> {
    private final Function2<State, Action, ReducerResult<State, Action>> reducer;

    /* JADX WARN: Multi-variable type inference failed */
    public Reduce(Function2<? super State, ? super Action, ReducerResult<State, Action>> reducer) {
        Intrinsics.checkNotNullParameter(reducer, "reducer");
        this.reducer = reducer;
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return Reducable.DefaultImpls.getBuild(this);
    }

    @Override // com.box.android.cpl.Reducable
    public ReducerResult<State, Action> reduce(State state, Action action) {
        return this.reducer.invoke(state, action);
    }
}
