package com.box.android.updates.proposal.presentation;

import androidx.appcompat.app.AppCompatActivity;
import com.box.android.cpl.Effect;
import com.box.android.cpl.EffectKt;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: AppUpdateProposalReducer.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u000b\f\rB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/box/android/updates/proposal/presentation/AppUpdateProposalReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/updates/proposal/presentation/AppUpdateProposalReducer$State;", "Lcom/box/android/updates/proposal/presentation/AppUpdateProposalReducer$Action;", "environment", "Lcom/box/android/updates/proposal/presentation/AppUpdateProposalEnvironment;", "<init>", "(Lcom/box/android/updates/proposal/presentation/AppUpdateProposalEnvironment;)V", "build", "getBuild", "()Lcom/box/android/cpl/Reducable;", "State", "ViewEffect", "Action", "app-updates_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AppUpdateProposalReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reducable<State, Action> build;
    private final AppUpdateProposalEnvironment environment;

    public AppUpdateProposalReducer(AppUpdateProposalEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        this.build = new Reduce(new Function2() { // from class: com.box.android.updates.proposal.presentation.AppUpdateProposalReducer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppUpdateProposalReducer.build$lambda$0(this.f$0, (AppUpdateProposalReducer.State) obj, (AppUpdateProposalReducer.Action) obj2);
            }
        });
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: AppUpdateProposalReducer.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/updates/proposal/presentation/AppUpdateProposalReducer$State;", "", "viewEffect", "Lcom/box/android/updates/proposal/presentation/AppUpdateProposalReducer$ViewEffect;", "<init>", "(Lcom/box/android/updates/proposal/presentation/AppUpdateProposalReducer$ViewEffect;)V", "getViewEffect", "()Lcom/box/android/updates/proposal/presentation/AppUpdateProposalReducer$ViewEffect;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "app-updates_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 0;
        private final ViewEffect viewEffect;

        /* JADX WARN: Multi-variable type inference failed */
        public State() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ State copy$default(State state, ViewEffect viewEffect, int i, Object obj) {
            if ((i & 1) != 0) {
                viewEffect = state.viewEffect;
            }
            return state.copy(viewEffect);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ViewEffect getViewEffect() {
            return this.viewEffect;
        }

        public final State copy(ViewEffect viewEffect) {
            Intrinsics.checkNotNullParameter(viewEffect, "viewEffect");
            return new State(viewEffect);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof State) && Intrinsics.areEqual(this.viewEffect, ((State) other).viewEffect);
        }

        public int hashCode() {
            return this.viewEffect.hashCode();
        }

        public String toString() {
            return "State(viewEffect=" + this.viewEffect + ")";
        }

        public State(ViewEffect viewEffect) {
            Intrinsics.checkNotNullParameter(viewEffect, "viewEffect");
            this.viewEffect = viewEffect;
        }

        public /* synthetic */ State(ViewEffect.None none, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? ViewEffect.None.INSTANCE : none);
        }

        public final ViewEffect getViewEffect() {
            return this.viewEffect;
        }
    }

    /* JADX INFO: compiled from: AppUpdateProposalReducer.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/box/android/updates/proposal/presentation/AppUpdateProposalReducer$ViewEffect;", "", "<init>", "()V", "DownloadStartedMessage", "DownloadCompletedMessage", "None", "Lcom/box/android/updates/proposal/presentation/AppUpdateProposalReducer$ViewEffect$DownloadCompletedMessage;", "Lcom/box/android/updates/proposal/presentation/AppUpdateProposalReducer$ViewEffect$DownloadStartedMessage;", "Lcom/box/android/updates/proposal/presentation/AppUpdateProposalReducer$ViewEffect$None;", "app-updates_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class ViewEffect {
        public static final int $stable = 0;

        public /* synthetic */ ViewEffect(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: AppUpdateProposalReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/updates/proposal/presentation/AppUpdateProposalReducer$ViewEffect$DownloadStartedMessage;", "Lcom/box/android/updates/proposal/presentation/AppUpdateProposalReducer$ViewEffect;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app-updates_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class DownloadStartedMessage extends ViewEffect {
            public static final int $stable = 0;
            public static final DownloadStartedMessage INSTANCE = new DownloadStartedMessage();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof DownloadStartedMessage)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 79790451;
            }

            public String toString() {
                return "DownloadStartedMessage";
            }

            private DownloadStartedMessage() {
                super(null);
            }
        }

        private ViewEffect() {
        }

        /* JADX INFO: compiled from: AppUpdateProposalReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/updates/proposal/presentation/AppUpdateProposalReducer$ViewEffect$DownloadCompletedMessage;", "Lcom/box/android/updates/proposal/presentation/AppUpdateProposalReducer$ViewEffect;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app-updates_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class DownloadCompletedMessage extends ViewEffect {
            public static final int $stable = 0;
            public static final DownloadCompletedMessage INSTANCE = new DownloadCompletedMessage();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof DownloadCompletedMessage)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1306852649;
            }

            public String toString() {
                return "DownloadCompletedMessage";
            }

            private DownloadCompletedMessage() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: AppUpdateProposalReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/updates/proposal/presentation/AppUpdateProposalReducer$ViewEffect$None;", "Lcom/box/android/updates/proposal/presentation/AppUpdateProposalReducer$ViewEffect;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app-updates_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class None extends ViewEffect {
            public static final int $stable = 0;
            public static final None INSTANCE = new None();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof None)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1027947773;
            }

            public String toString() {
                return "None";
            }

            private None() {
                super(null);
            }
        }
    }

    /* JADX INFO: compiled from: AppUpdateProposalReducer.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/box/android/updates/proposal/presentation/AppUpdateProposalReducer$Action;", "", "<init>", "()V", "Initialize", "UpdateDownloadStarted", "UpdateDownloaded", "OnCompleteActionClicked", "OnViewEffectProcessed", "Lcom/box/android/updates/proposal/presentation/AppUpdateProposalReducer$Action$Initialize;", "Lcom/box/android/updates/proposal/presentation/AppUpdateProposalReducer$Action$OnCompleteActionClicked;", "Lcom/box/android/updates/proposal/presentation/AppUpdateProposalReducer$Action$OnViewEffectProcessed;", "Lcom/box/android/updates/proposal/presentation/AppUpdateProposalReducer$Action$UpdateDownloadStarted;", "Lcom/box/android/updates/proposal/presentation/AppUpdateProposalReducer$Action$UpdateDownloaded;", "app-updates_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: AppUpdateProposalReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/updates/proposal/presentation/AppUpdateProposalReducer$Action$Initialize;", "Lcom/box/android/updates/proposal/presentation/AppUpdateProposalReducer$Action;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "(Landroidx/appcompat/app/AppCompatActivity;)V", "getActivity", "()Landroidx/appcompat/app/AppCompatActivity;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "app-updates_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Initialize extends Action {
            public static final int $stable = 8;
            private final AppCompatActivity activity;

            public static /* synthetic */ Initialize copy$default(Initialize initialize, AppCompatActivity appCompatActivity, int i, Object obj) {
                if ((i & 1) != 0) {
                    appCompatActivity = initialize.activity;
                }
                return initialize.copy(appCompatActivity);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final AppCompatActivity getActivity() {
                return this.activity;
            }

            public final Initialize copy(AppCompatActivity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                return new Initialize(activity);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Initialize) && Intrinsics.areEqual(this.activity, ((Initialize) other).activity);
            }

            public int hashCode() {
                return this.activity.hashCode();
            }

            public String toString() {
                return "Initialize(activity=" + this.activity + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Initialize(AppCompatActivity activity) {
                super(null);
                Intrinsics.checkNotNullParameter(activity, "activity");
                this.activity = activity;
            }

            public final AppCompatActivity getActivity() {
                return this.activity;
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: AppUpdateProposalReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/updates/proposal/presentation/AppUpdateProposalReducer$Action$UpdateDownloadStarted;", "Lcom/box/android/updates/proposal/presentation/AppUpdateProposalReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app-updates_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class UpdateDownloadStarted extends Action {
            public static final int $stable = 0;
            public static final UpdateDownloadStarted INSTANCE = new UpdateDownloadStarted();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof UpdateDownloadStarted)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1765882165;
            }

            public String toString() {
                return "UpdateDownloadStarted";
            }

            private UpdateDownloadStarted() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: AppUpdateProposalReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/updates/proposal/presentation/AppUpdateProposalReducer$Action$UpdateDownloaded;", "Lcom/box/android/updates/proposal/presentation/AppUpdateProposalReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app-updates_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class UpdateDownloaded extends Action {
            public static final int $stable = 0;
            public static final UpdateDownloaded INSTANCE = new UpdateDownloaded();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof UpdateDownloaded)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1991263221;
            }

            public String toString() {
                return "UpdateDownloaded";
            }

            private UpdateDownloaded() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: AppUpdateProposalReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/updates/proposal/presentation/AppUpdateProposalReducer$Action$OnCompleteActionClicked;", "Lcom/box/android/updates/proposal/presentation/AppUpdateProposalReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app-updates_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class OnCompleteActionClicked extends Action {
            public static final int $stable = 0;
            public static final OnCompleteActionClicked INSTANCE = new OnCompleteActionClicked();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof OnCompleteActionClicked)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1298206476;
            }

            public String toString() {
                return "OnCompleteActionClicked";
            }

            private OnCompleteActionClicked() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: AppUpdateProposalReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/updates/proposal/presentation/AppUpdateProposalReducer$Action$OnViewEffectProcessed;", "Lcom/box/android/updates/proposal/presentation/AppUpdateProposalReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app-updates_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class OnViewEffectProcessed extends Action {
            public static final int $stable = 0;
            public static final OnViewEffectProcessed INSTANCE = new OnViewEffectProcessed();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof OnViewEffectProcessed)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -602102028;
            }

            public String toString() {
                return "OnViewEffectProcessed";
            }

            private OnViewEffectProcessed() {
                super(null);
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final ReducerResult build$lambda$0(AppUpdateProposalReducer appUpdateProposalReducer, State state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        int i = 2;
        Effect effect = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        Object[] objArr5 = 0;
        Object[] objArr6 = 0;
        Object[] objArr7 = 0;
        if (action instanceof Action.Initialize) {
            appUpdateProposalReducer.environment.getUpdatesManager().handleUpdateProposal(((Action.Initialize) action).getActivity());
            return new ReducerResult(state, Effect.INSTANCE.merge(EffectKt.toEffect(FlowKt.flow(new AppUpdateProposalReducer$build$1$1(appUpdateProposalReducer, null))), EffectKt.toEffect(FlowKt.flow(new AppUpdateProposalReducer$build$1$2(appUpdateProposalReducer, null)))));
        }
        if (Intrinsics.areEqual(action, Action.UpdateDownloaded.INSTANCE)) {
            return new ReducerResult(state.copy(ViewEffect.DownloadCompletedMessage.INSTANCE), effect, i, objArr7 == true ? 1 : 0);
        }
        if (Intrinsics.areEqual(action, Action.UpdateDownloadStarted.INSTANCE)) {
            return new ReducerResult(state.copy(ViewEffect.DownloadStartedMessage.INSTANCE), objArr6 == true ? 1 : 0, i, objArr5 == true ? 1 : 0);
        }
        if (Intrinsics.areEqual(action, Action.OnCompleteActionClicked.INSTANCE)) {
            appUpdateProposalReducer.environment.getAppUpdateProposalManager().completeUpdate();
            return new ReducerResult(state, objArr4 == true ? 1 : 0, i, objArr3 == true ? 1 : 0);
        }
        if (Intrinsics.areEqual(action, Action.OnViewEffectProcessed.INSTANCE)) {
            return new ReducerResult(state.copy(ViewEffect.None.INSTANCE), objArr2 == true ? 1 : 0, i, objArr == true ? 1 : 0);
        }
        throw new NoWhenBranchMatchedException();
    }
}
