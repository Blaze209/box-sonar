package com.box.android.cpl;

import com.pspdfkit.analytics.Analytics;
import kotlin.Metadata;

/* JADX INFO: compiled from: Reducable.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003J)\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b2\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\n\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000bR \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/box/android/cpl/Reducable;", "State", "Action", "", "build", "getBuild", "()Lcom/box/android/cpl/Reducable;", "reduce", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "(Ljava/lang/Object;Ljava/lang/Object;)Lcom/box/android/cpl/ReducerResult;", "cpl-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface Reducable<State, Action> {
    Reducable<State, Action> getBuild();

    ReducerResult<State, Action> reduce(State state, Action action);

    /* JADX INFO: compiled from: Reducable.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <State, Action> ReducerResult<State, Action> reduce(Reducable<State, Action> reducable, State state, Action action) {
            return reducable.getBuild().reduce(state, action);
        }

        public static <State, Action> Reducable<State, Action> getBuild(Reducable<State, Action> reducable) {
            return new EmptyReducer();
        }
    }
}
