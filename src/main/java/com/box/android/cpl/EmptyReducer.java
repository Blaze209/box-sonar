package com.box.android.cpl;

import com.pspdfkit.analytics.Analytics;
import kotlin.Metadata;

/* JADX INFO: compiled from: Reducable.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J)\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00062\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\b\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/box/android/cpl/EmptyReducer;", "State", "Action", "Lcom/box/android/cpl/Reducable;", "()V", "reduce", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "(Ljava/lang/Object;Ljava/lang/Object;)Lcom/box/android/cpl/ReducerResult;", "cpl-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class EmptyReducer<State, Action> implements Reducable<State, Action> {
    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return Reducable.DefaultImpls.getBuild(this);
    }

    @Override // com.box.android.cpl.Reducable
    public ReducerResult<State, Action> reduce(State state, Action action) {
        return new ReducerResult<>(state, Effect.INSTANCE.none());
    }
}
