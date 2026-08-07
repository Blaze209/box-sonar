package com.box.android.cpl;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.actions.configurations.GuideTransition;

/* JADX INFO: compiled from: Reducable.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u001d\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\r\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006HÆ\u0003J4\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0004\u001a\u00028\u00002\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/box/android/cpl/ReducerResult;", "State", "Action", "", "state", GuideTransition.GUIDE_TRANSITION_EFFECT_FIELD, "Lcom/box/android/cpl/Effect;", "(Ljava/lang/Object;Lcom/box/android/cpl/Effect;)V", "getEffect", "()Lcom/box/android/cpl/Effect;", "getState", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/Object;Lcom/box/android/cpl/Effect;)Lcom/box/android/cpl/ReducerResult;", "equals", "", "other", "hashCode", "", "toString", "", "cpl-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class ReducerResult<State, Action> {
    private final Effect<Action> effect;
    private final State state;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ReducerResult copy$default(ReducerResult reducerResult, Object obj, Effect effect, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = reducerResult.state;
        }
        if ((i & 2) != 0) {
            effect = reducerResult.effect;
        }
        return reducerResult.copy(obj, effect);
    }

    public final State component1() {
        return this.state;
    }

    public final Effect<Action> component2() {
        return this.effect;
    }

    public final ReducerResult<State, Action> copy(State state, Effect<Action> effect) {
        Intrinsics.checkNotNullParameter(effect, "effect");
        return new ReducerResult<>(state, effect);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReducerResult)) {
            return false;
        }
        ReducerResult reducerResult = (ReducerResult) other;
        return Intrinsics.areEqual(this.state, reducerResult.state) && Intrinsics.areEqual(this.effect, reducerResult.effect);
    }

    public int hashCode() {
        State state = this.state;
        return ((state == null ? 0 : state.hashCode()) * 31) + this.effect.hashCode();
    }

    public String toString() {
        return "ReducerResult(state=" + this.state + ", effect=" + this.effect + ')';
    }

    public ReducerResult(State state, Effect<Action> effect) {
        Intrinsics.checkNotNullParameter(effect, "effect");
        this.state = state;
        this.effect = effect;
    }

    public final State getState() {
        return this.state;
    }

    public /* synthetic */ ReducerResult(Object obj, Effect effect, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i & 2) != 0 ? Effect.INSTANCE.none() : effect);
    }

    public final Effect<Action> getEffect() {
        return this.effect;
    }
}
