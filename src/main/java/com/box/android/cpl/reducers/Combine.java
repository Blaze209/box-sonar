package com.box.android.cpl.reducers;

import com.box.android.cpl.Reducable;
import com.box.android.cpl.ReducableKt;
import com.box.android.cpl.ReducerResult;
import com.pspdfkit.analytics.Analytics;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Combine.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B1\u0012*\u0010\u0004\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00030\u0005\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003¢\u0006\u0002\u0010\u0006J)\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t2\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\fR\"\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00030\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/box/android/cpl/reducers/Combine;", "State", "Action", "Lcom/box/android/cpl/Reducable;", "reducers", "", "([Lcom/box/android/cpl/Reducable;)V", "[Lcom/box/android/cpl/Reducable;", "reduce", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "(Ljava/lang/Object;Ljava/lang/Object;)Lcom/box/android/cpl/ReducerResult;", "cpl-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Combine<State, Action> implements Reducable<State, Action> {
    private final Reducable<State, Action>[] reducers;

    public Combine(Reducable<State, Action>... reducers) {
        Intrinsics.checkNotNullParameter(reducers, "reducers");
        this.reducers = (Reducable[]) Arrays.copyOf(reducers, reducers.length);
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return Reducable.DefaultImpls.getBuild(this);
    }

    @Override // com.box.android.cpl.Reducable
    public ReducerResult<State, Action> reduce(State state, Action action) {
        Reducable<State, Action>[] reducableArr = this.reducers;
        ReducerResult<State, Action> reducerResult = new ReducerResult<>(state, null, 2, null);
        for (Reducable<State, Action> reducable : reducableArr) {
            reducerResult = ReducableKt.chainWith(reducerResult, reducable, action);
        }
        return reducerResult;
    }
}
