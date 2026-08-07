package com.box.android.boxai.clearchat;

import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxAiClearChatReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/box/android/boxai/clearchat/BoxAiClearChatReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/boxai/clearchat/BoxAiClearChatReducer$State;", "Lcom/box/android/boxai/clearchat/BoxAiClearChatReducer$Action;", "<init>", "()V", "build", "Lcom/box/android/cpl/Reduce;", "getBuild", "()Lcom/box/android/cpl/Reduce;", "State", "Action", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxAiClearChatReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reduce<State, Action> build = new Reduce<>(new Function2() { // from class: com.box.android.boxai.clearchat.BoxAiClearChatReducer$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return BoxAiClearChatReducer.build$lambda$0((BoxAiClearChatReducer.State) obj, (BoxAiClearChatReducer.Action) obj2);
        }
    });

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: BoxAiClearChatReducer.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/boxai/clearchat/BoxAiClearChatReducer$State;", "", "shouldShowConfirmationDialog", "", "shouldShowChatClearedInfo", "<init>", "(ZZ)V", "getShouldShowConfirmationDialog", "()Z", "getShouldShowChatClearedInfo", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 0;
        private final boolean shouldShowChatClearedInfo;
        private final boolean shouldShowConfirmationDialog;

        /* JADX WARN: Illegal instructions before constructor call */
        public State() {
            boolean z = false;
            this(z, z, 3, null);
        }

        public static /* synthetic */ State copy$default(State state, boolean z, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z = state.shouldShowConfirmationDialog;
            }
            if ((i & 2) != 0) {
                z2 = state.shouldShowChatClearedInfo;
            }
            return state.copy(z, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getShouldShowConfirmationDialog() {
            return this.shouldShowConfirmationDialog;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getShouldShowChatClearedInfo() {
            return this.shouldShowChatClearedInfo;
        }

        public final State copy(boolean shouldShowConfirmationDialog, boolean shouldShowChatClearedInfo) {
            return new State(shouldShowConfirmationDialog, shouldShowChatClearedInfo);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return this.shouldShowConfirmationDialog == state.shouldShowConfirmationDialog && this.shouldShowChatClearedInfo == state.shouldShowChatClearedInfo;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.shouldShowConfirmationDialog) * 31) + Boolean.hashCode(this.shouldShowChatClearedInfo);
        }

        public String toString() {
            return "State(shouldShowConfirmationDialog=" + this.shouldShowConfirmationDialog + ", shouldShowChatClearedInfo=" + this.shouldShowChatClearedInfo + ")";
        }

        public State(boolean z, boolean z2) {
            this.shouldShowConfirmationDialog = z;
            this.shouldShowChatClearedInfo = z2;
        }

        public /* synthetic */ State(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2);
        }

        public final boolean getShouldShowChatClearedInfo() {
            return this.shouldShowChatClearedInfo;
        }

        public final boolean getShouldShowConfirmationDialog() {
            return this.shouldShowConfirmationDialog;
        }
    }

    /* JADX INFO: compiled from: BoxAiClearChatReducer.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/boxai/clearchat/BoxAiClearChatReducer$Action;", "", "<init>", "()V", "ClearChatClicked", "ClearChatConfirmed", "ClearChatCancelled", "ChatClearedInfoShown", "Lcom/box/android/boxai/clearchat/BoxAiClearChatReducer$Action$ChatClearedInfoShown;", "Lcom/box/android/boxai/clearchat/BoxAiClearChatReducer$Action$ClearChatCancelled;", "Lcom/box/android/boxai/clearchat/BoxAiClearChatReducer$Action$ClearChatClicked;", "Lcom/box/android/boxai/clearchat/BoxAiClearChatReducer$Action$ClearChatConfirmed;", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: BoxAiClearChatReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/boxai/clearchat/BoxAiClearChatReducer$Action$ClearChatClicked;", "Lcom/box/android/boxai/clearchat/BoxAiClearChatReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ClearChatClicked extends Action {
            public static final int $stable = 0;
            public static final ClearChatClicked INSTANCE = new ClearChatClicked();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ClearChatClicked)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -2009695245;
            }

            public String toString() {
                return "ClearChatClicked";
            }

            private ClearChatClicked() {
                super(null);
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: BoxAiClearChatReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/boxai/clearchat/BoxAiClearChatReducer$Action$ClearChatConfirmed;", "Lcom/box/android/boxai/clearchat/BoxAiClearChatReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ClearChatConfirmed extends Action {
            public static final int $stable = 0;
            public static final ClearChatConfirmed INSTANCE = new ClearChatConfirmed();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ClearChatConfirmed)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1716360149;
            }

            public String toString() {
                return "ClearChatConfirmed";
            }

            private ClearChatConfirmed() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: BoxAiClearChatReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/boxai/clearchat/BoxAiClearChatReducer$Action$ClearChatCancelled;", "Lcom/box/android/boxai/clearchat/BoxAiClearChatReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ClearChatCancelled extends Action {
            public static final int $stable = 0;
            public static final ClearChatCancelled INSTANCE = new ClearChatCancelled();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ClearChatCancelled)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -435662307;
            }

            public String toString() {
                return "ClearChatCancelled";
            }

            private ClearChatCancelled() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: BoxAiClearChatReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/boxai/clearchat/BoxAiClearChatReducer$Action$ChatClearedInfoShown;", "Lcom/box/android/boxai/clearchat/BoxAiClearChatReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ChatClearedInfoShown extends Action {
            public static final int $stable = 0;
            public static final ChatClearedInfoShown INSTANCE = new ChatClearedInfoShown();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ChatClearedInfoShown)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1659980928;
            }

            public String toString() {
                return "ChatClearedInfoShown";
            }

            private ChatClearedInfoShown() {
                super(null);
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReducerResult build$lambda$0(State state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof Action.ClearChatClicked) {
            return new ReducerResult(State.copy$default(state, true, false, 2, null), null, 2, null);
        }
        if (action instanceof Action.ClearChatConfirmed) {
            return new ReducerResult(state.copy(false, true), null, 2, null);
        }
        if (action instanceof Action.ClearChatCancelled) {
            return new ReducerResult(State.copy$default(state, false, false, 2, null), null, 2, null);
        }
        if (!(action instanceof Action.ChatClearedInfoShown)) {
            throw new NoWhenBranchMatchedException();
        }
        return new ReducerResult(State.copy$default(state, false, false, 1, null), null, 2, null);
    }
}
