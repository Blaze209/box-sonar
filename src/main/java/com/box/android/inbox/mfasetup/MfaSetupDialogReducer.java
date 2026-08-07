package com.box.android.inbox.mfasetup;

import android.content.Context;
import com.box.android.cpl.Effect;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MfaSetupDialogReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\f\rB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/box/android/inbox/mfasetup/MfaSetupDialogReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/inbox/mfasetup/MfaSetupDialogReducer$State;", "Lcom/box/android/inbox/mfasetup/MfaSetupDialogReducer$Action;", "environment", "Lcom/box/android/inbox/mfasetup/MfaSetupDialogEnvironment;", "<init>", "(Lcom/box/android/inbox/mfasetup/MfaSetupDialogEnvironment;)V", "build", "Lcom/box/android/cpl/Reduce;", "getBuild", "()Lcom/box/android/cpl/Reduce;", "State", "Action", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MfaSetupDialogReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reduce<State, Action> build;
    private final MfaSetupDialogEnvironment environment;

    public MfaSetupDialogReducer(MfaSetupDialogEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        this.build = new Reduce<>(new Function2() { // from class: com.box.android.inbox.mfasetup.MfaSetupDialogReducer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return MfaSetupDialogReducer.build$lambda$0(this.f$0, (MfaSetupDialogReducer.State) obj, (MfaSetupDialogReducer.Action) obj2);
            }
        });
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: MfaSetupDialogReducer.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001a\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/box/android/inbox/mfasetup/MfaSetupDialogReducer$State;", "", "mobileSessionId", "", "<init>", "(Ljava/lang/Long;)V", "getMobileSessionId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/Long;)Lcom/box/android/inbox/mfasetup/MfaSetupDialogReducer$State;", "equals", "", "other", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 0;
        private final Long mobileSessionId;

        /* JADX WARN: Multi-variable type inference failed */
        public State() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ State copy$default(State state, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                l = state.mobileSessionId;
            }
            return state.copy(l);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Long getMobileSessionId() {
            return this.mobileSessionId;
        }

        public final State copy(Long mobileSessionId) {
            return new State(mobileSessionId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof State) && Intrinsics.areEqual(this.mobileSessionId, ((State) other).mobileSessionId);
        }

        public int hashCode() {
            Long l = this.mobileSessionId;
            if (l == null) {
                return 0;
            }
            return l.hashCode();
        }

        public String toString() {
            return "State(mobileSessionId=" + this.mobileSessionId + ")";
        }

        public State(Long l) {
            this.mobileSessionId = l;
        }

        public /* synthetic */ State(Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : l);
        }

        public final Long getMobileSessionId() {
            return this.mobileSessionId;
        }
    }

    /* JADX INFO: compiled from: MfaSetupDialogReducer.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/inbox/mfasetup/MfaSetupDialogReducer$Action;", "", "<init>", "()V", "OnAppear", "Dismiss", "Cancel", "NavigateToBrowser", "Lcom/box/android/inbox/mfasetup/MfaSetupDialogReducer$Action$Cancel;", "Lcom/box/android/inbox/mfasetup/MfaSetupDialogReducer$Action$Dismiss;", "Lcom/box/android/inbox/mfasetup/MfaSetupDialogReducer$Action$NavigateToBrowser;", "Lcom/box/android/inbox/mfasetup/MfaSetupDialogReducer$Action$OnAppear;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: MfaSetupDialogReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/inbox/mfasetup/MfaSetupDialogReducer$Action$OnAppear;", "Lcom/box/android/inbox/mfasetup/MfaSetupDialogReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class OnAppear extends Action {
            public static final int $stable = 0;
            public static final OnAppear INSTANCE = new OnAppear();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof OnAppear)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 99407851;
            }

            public String toString() {
                return "OnAppear";
            }

            private OnAppear() {
                super(null);
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: MfaSetupDialogReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/inbox/mfasetup/MfaSetupDialogReducer$Action$Dismiss;", "Lcom/box/android/inbox/mfasetup/MfaSetupDialogReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Dismiss extends Action {
            public static final int $stable = 0;
            public static final Dismiss INSTANCE = new Dismiss();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Dismiss)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 673198099;
            }

            public String toString() {
                return "Dismiss";
            }

            private Dismiss() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: MfaSetupDialogReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/inbox/mfasetup/MfaSetupDialogReducer$Action$Cancel;", "Lcom/box/android/inbox/mfasetup/MfaSetupDialogReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Cancel extends Action {
            public static final int $stable = 0;
            public static final Cancel INSTANCE = new Cancel();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Cancel)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -14459951;
            }

            public String toString() {
                return "Cancel";
            }

            private Cancel() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: MfaSetupDialogReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/inbox/mfasetup/MfaSetupDialogReducer$Action$NavigateToBrowser;", "Lcom/box/android/inbox/mfasetup/MfaSetupDialogReducer$Action;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class NavigateToBrowser extends Action {
            public static final int $stable = 8;
            private final Context context;

            public static /* synthetic */ NavigateToBrowser copy$default(NavigateToBrowser navigateToBrowser, Context context, int i, Object obj) {
                if ((i & 1) != 0) {
                    context = navigateToBrowser.context;
                }
                return navigateToBrowser.copy(context);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Context getContext() {
                return this.context;
            }

            public final NavigateToBrowser copy(Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                return new NavigateToBrowser(context);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof NavigateToBrowser) && Intrinsics.areEqual(this.context, ((NavigateToBrowser) other).context);
            }

            public int hashCode() {
                return this.context.hashCode();
            }

            public String toString() {
                return "NavigateToBrowser(context=" + this.context + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NavigateToBrowser(Context context) {
                super(null);
                Intrinsics.checkNotNullParameter(context, "context");
                this.context = context;
            }

            public final Context getContext() {
                return this.context;
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReducerResult build$lambda$0(MfaSetupDialogReducer mfaSetupDialogReducer, State state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof Action.OnAppear) {
            Long mobileSessionId = state.getMobileSessionId();
            long jLongValue = mobileSessionId != null ? mobileSessionId.longValue() : mfaSetupDialogReducer.environment.getClock().currentTimeMillis();
            return new ReducerResult(state.copy(Long.valueOf(jLongValue)), Effect.INSTANCE.fireAndForget(new MfaSetupDialogReducer$build$1$1(mfaSetupDialogReducer, jLongValue, null)));
        }
        if (action instanceof Action.Cancel) {
            return new ReducerResult(state, Effect.INSTANCE.merge(Effect.INSTANCE.fireAndForget(new MfaSetupDialogReducer$build$1$2(mfaSetupDialogReducer, state, null)), new Effect(Action.Dismiss.INSTANCE)));
        }
        if (action instanceof Action.Dismiss) {
            return new ReducerResult(state.copy(null), null, 2, null);
        }
        if (!(action instanceof Action.NavigateToBrowser)) {
            throw new NoWhenBranchMatchedException();
        }
        return new ReducerResult(state, Effect.INSTANCE.merge(Effect.INSTANCE.fireAndForget(new MfaSetupDialogReducer$build$1$3(action, mfaSetupDialogReducer.environment.getMfaSetupUrlBuilder().generateMfaSetupUrl(state.getMobileSessionId()), null)), Effect.INSTANCE.fireAndForget(new MfaSetupDialogReducer$build$1$4(mfaSetupDialogReducer, state, null)), new Effect(Action.Dismiss.INSTANCE)));
    }
}
