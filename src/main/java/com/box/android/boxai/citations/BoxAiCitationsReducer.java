package com.box.android.boxai.citations;

import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.boxai.AiCitationModel;
import com.facebook.react.uimanager.ViewProps;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxAiCitationsReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\t\nB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/box/android/boxai/citations/BoxAiCitationsReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/boxai/citations/BoxAiCitationsReducer$State;", "Lcom/box/android/boxai/citations/BoxAiCitationsReducer$Action;", "<init>", "()V", "build", "getBuild", "()Lcom/box/android/cpl/Reducable;", "State", "Action", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxAiCitationsReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reducable<State, Action> build = new Reduce(new Function2() { // from class: com.box.android.boxai.citations.BoxAiCitationsReducer$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return BoxAiCitationsReducer.build$lambda$0((BoxAiCitationsReducer.State) obj, (BoxAiCitationsReducer.Action) obj2);
        }
    });

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: BoxAiCitationsReducer.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/box/android/boxai/citations/BoxAiCitationsReducer$State;", "", "citationHighlightEnabled", "", ViewProps.VISIBLE, "citations", "", "Lcom/box/android/domain/models/boxai/AiCitationModel;", "<init>", "(ZZLjava/util/List;)V", "getCitationHighlightEnabled", "()Z", "getVisible", "getCitations", "()Ljava/util/List;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final boolean citationHighlightEnabled;
        private final List<AiCitationModel> citations;
        private final boolean visible;

        public State() {
            this(false, false, null, 7, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, boolean z, boolean z2, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                z = state.citationHighlightEnabled;
            }
            if ((i & 2) != 0) {
                z2 = state.visible;
            }
            if ((i & 4) != 0) {
                list = state.citations;
            }
            return state.copy(z, z2, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getCitationHighlightEnabled() {
            return this.citationHighlightEnabled;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getVisible() {
            return this.visible;
        }

        public final List<AiCitationModel> component3() {
            return this.citations;
        }

        public final State copy(boolean citationHighlightEnabled, boolean visible, List<AiCitationModel> citations) {
            Intrinsics.checkNotNullParameter(citations, "citations");
            return new State(citationHighlightEnabled, visible, citations);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return this.citationHighlightEnabled == state.citationHighlightEnabled && this.visible == state.visible && Intrinsics.areEqual(this.citations, state.citations);
        }

        public int hashCode() {
            return (((Boolean.hashCode(this.citationHighlightEnabled) * 31) + Boolean.hashCode(this.visible)) * 31) + this.citations.hashCode();
        }

        public String toString() {
            return "State(citationHighlightEnabled=" + this.citationHighlightEnabled + ", visible=" + this.visible + ", citations=" + this.citations + ")";
        }

        public State(boolean z, boolean z2, List<AiCitationModel> citations) {
            Intrinsics.checkNotNullParameter(citations, "citations");
            this.citationHighlightEnabled = z;
            this.visible = z2;
            this.citations = citations;
        }

        public final boolean getCitationHighlightEnabled() {
            return this.citationHighlightEnabled;
        }

        public final boolean getVisible() {
            return this.visible;
        }

        public /* synthetic */ State(boolean z, boolean z2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? CollectionsKt.emptyList() : list);
        }

        public final List<AiCitationModel> getCitations() {
            return this.citations;
        }
    }

    /* JADX INFO: compiled from: BoxAiCitationsReducer.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/box/android/boxai/citations/BoxAiCitationsReducer$Action;", "", "<init>", "()V", "ShowCitations", "EnableCitationHighlight", "HideCitations", "Lcom/box/android/boxai/citations/BoxAiCitationsReducer$Action$EnableCitationHighlight;", "Lcom/box/android/boxai/citations/BoxAiCitationsReducer$Action$HideCitations;", "Lcom/box/android/boxai/citations/BoxAiCitationsReducer$Action$ShowCitations;", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: BoxAiCitationsReducer.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/boxai/citations/BoxAiCitationsReducer$Action$ShowCitations;", "Lcom/box/android/boxai/citations/BoxAiCitationsReducer$Action;", "citations", "", "Lcom/box/android/domain/models/boxai/AiCitationModel;", "<init>", "(Ljava/util/List;)V", "getCitations", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ShowCitations extends Action {
            public static final int $stable = 8;
            private final List<AiCitationModel> citations;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ ShowCitations copy$default(ShowCitations showCitations, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = showCitations.citations;
                }
                return showCitations.copy(list);
            }

            public final List<AiCitationModel> component1() {
                return this.citations;
            }

            public final ShowCitations copy(List<AiCitationModel> citations) {
                Intrinsics.checkNotNullParameter(citations, "citations");
                return new ShowCitations(citations);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ShowCitations) && Intrinsics.areEqual(this.citations, ((ShowCitations) other).citations);
            }

            public int hashCode() {
                return this.citations.hashCode();
            }

            public String toString() {
                return "ShowCitations(citations=" + this.citations + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowCitations(List<AiCitationModel> citations) {
                super(null);
                Intrinsics.checkNotNullParameter(citations, "citations");
                this.citations = citations;
            }

            public final List<AiCitationModel> getCitations() {
                return this.citations;
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: BoxAiCitationsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/boxai/citations/BoxAiCitationsReducer$Action$EnableCitationHighlight;", "Lcom/box/android/boxai/citations/BoxAiCitationsReducer$Action;", "enabled", "", "<init>", "(Z)V", "getEnabled", "()Z", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class EnableCitationHighlight extends Action {
            public static final int $stable = 0;
            private final boolean enabled;

            public static /* synthetic */ EnableCitationHighlight copy$default(EnableCitationHighlight enableCitationHighlight, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = enableCitationHighlight.enabled;
                }
                return enableCitationHighlight.copy(z);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getEnabled() {
                return this.enabled;
            }

            public final EnableCitationHighlight copy(boolean enabled) {
                return new EnableCitationHighlight(enabled);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof EnableCitationHighlight) && this.enabled == ((EnableCitationHighlight) other).enabled;
            }

            public int hashCode() {
                return Boolean.hashCode(this.enabled);
            }

            public String toString() {
                return "EnableCitationHighlight(enabled=" + this.enabled + ")";
            }

            public EnableCitationHighlight(boolean z) {
                super(null);
                this.enabled = z;
            }

            public final boolean getEnabled() {
                return this.enabled;
            }
        }

        /* JADX INFO: compiled from: BoxAiCitationsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/boxai/citations/BoxAiCitationsReducer$Action$HideCitations;", "Lcom/box/android/boxai/citations/BoxAiCitationsReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class HideCitations extends Action {
            public static final int $stable = 0;
            public static final HideCitations INSTANCE = new HideCitations();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof HideCitations)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 415990553;
            }

            public String toString() {
                return "HideCitations";
            }

            private HideCitations() {
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
        if (action instanceof Action.ShowCitations) {
            return new ReducerResult(State.copy$default(state, false, true, ((Action.ShowCitations) action).getCitations(), 1, null), null, 2, null);
        }
        if (action instanceof Action.HideCitations) {
            return new ReducerResult(State.copy$default(state, false, false, CollectionsKt.emptyList(), 1, null), null, 2, null);
        }
        if (!(action instanceof Action.EnableCitationHighlight)) {
            throw new NoWhenBranchMatchedException();
        }
        return new ReducerResult(State.copy$default(state, ((Action.EnableCitationHighlight) action).getEnabled(), false, null, 6, null), null, 2, null);
    }
}
