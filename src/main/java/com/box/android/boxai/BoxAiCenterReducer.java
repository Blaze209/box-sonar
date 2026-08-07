package com.box.android.boxai;

import com.box.android.cpl.Effect;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.item.ItemModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxAiCenterReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/box/android/boxai/BoxAiCenterReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/boxai/BoxAiCenterReducer$State;", "Lcom/box/android/boxai/BoxAiCenterReducer$Action;", "<init>", "()V", "build", "Lcom/box/android/cpl/Reduce;", "getBuild", "()Lcom/box/android/cpl/Reduce;", "State", "Action", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxAiCenterReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reduce<State, Action> build = new Reduce<>(new Function2() { // from class: com.box.android.boxai.BoxAiCenterReducer$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return BoxAiCenterReducer.build$lambda$0((BoxAiCenterReducer.State) obj, (BoxAiCenterReducer.Action) obj2);
        }
    });

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: BoxAiCenterReducer.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003J9\u0010\u0017\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\tHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/box/android/boxai/BoxAiCenterReducer$State;", "", "itemModels", "", "Lcom/box/android/domain/models/item/ItemModel;", "isMultidoc", "", "shouldLaunchAx", "sessionId", "", "<init>", "(Ljava/util/List;ZZLjava/lang/String;)V", "getItemModels", "()Ljava/util/List;", "()Z", "getShouldLaunchAx", "getSessionId", "()Ljava/lang/String;", "isSessionActive", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final boolean isMultidoc;
        private final List<ItemModel> itemModels;
        private final String sessionId;
        private final boolean shouldLaunchAx;

        public State() {
            this(null, false, false, null, 15, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, List list, boolean z, boolean z2, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                list = state.itemModels;
            }
            if ((i & 2) != 0) {
                z = state.isMultidoc;
            }
            if ((i & 4) != 0) {
                z2 = state.shouldLaunchAx;
            }
            if ((i & 8) != 0) {
                str = state.sessionId;
            }
            return state.copy(list, z, z2, str);
        }

        public final List<ItemModel> component1() {
            return this.itemModels;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsMultidoc() {
            return this.isMultidoc;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getShouldLaunchAx() {
            return this.shouldLaunchAx;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getSessionId() {
            return this.sessionId;
        }

        public final State copy(List<? extends ItemModel> itemModels, boolean isMultidoc, boolean shouldLaunchAx, String sessionId) {
            Intrinsics.checkNotNullParameter(itemModels, "itemModels");
            return new State(itemModels, isMultidoc, shouldLaunchAx, sessionId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.itemModels, state.itemModels) && this.isMultidoc == state.isMultidoc && this.shouldLaunchAx == state.shouldLaunchAx && Intrinsics.areEqual(this.sessionId, state.sessionId);
        }

        public int hashCode() {
            int iHashCode = ((((this.itemModels.hashCode() * 31) + Boolean.hashCode(this.isMultidoc)) * 31) + Boolean.hashCode(this.shouldLaunchAx)) * 31;
            String str = this.sessionId;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "State(itemModels=" + this.itemModels + ", isMultidoc=" + this.isMultidoc + ", shouldLaunchAx=" + this.shouldLaunchAx + ", sessionId=" + this.sessionId + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public State(List<? extends ItemModel> itemModels, boolean z, boolean z2, String str) {
            Intrinsics.checkNotNullParameter(itemModels, "itemModels");
            this.itemModels = itemModels;
            this.isMultidoc = z;
            this.shouldLaunchAx = z2;
            this.sessionId = str;
        }

        public /* synthetic */ State(List list, boolean z, boolean z2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? false : z, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? null : str);
        }

        public final List<ItemModel> getItemModels() {
            return this.itemModels;
        }

        public final boolean isMultidoc() {
            return this.isMultidoc;
        }

        public final boolean getShouldLaunchAx() {
            return this.shouldLaunchAx;
        }

        public final String getSessionId() {
            return this.sessionId;
        }

        public final boolean isSessionActive() {
            return this.sessionId != null;
        }
    }

    /* JADX INFO: compiled from: BoxAiCenterReducer.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/boxai/BoxAiCenterReducer$Action;", "", "<init>", "()V", "Show", "UpdateSession", "AxLaunchHandled", "ResetSession", "Lcom/box/android/boxai/BoxAiCenterReducer$Action$AxLaunchHandled;", "Lcom/box/android/boxai/BoxAiCenterReducer$Action$ResetSession;", "Lcom/box/android/boxai/BoxAiCenterReducer$Action$Show;", "Lcom/box/android/boxai/BoxAiCenterReducer$Action$UpdateSession;", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: BoxAiCenterReducer.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/boxai/BoxAiCenterReducer$Action$Show;", "Lcom/box/android/boxai/BoxAiCenterReducer$Action;", "itemModels", "", "Lcom/box/android/domain/models/item/ItemModel;", "<init>", "(Ljava/util/List;)V", "getItemModels", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Show extends Action {
            public static final int $stable = 8;
            private final List<ItemModel> itemModels;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Show copy$default(Show show, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = show.itemModels;
                }
                return show.copy(list);
            }

            public final List<ItemModel> component1() {
                return this.itemModels;
            }

            public final Show copy(List<? extends ItemModel> itemModels) {
                Intrinsics.checkNotNullParameter(itemModels, "itemModels");
                return new Show(itemModels);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Show) && Intrinsics.areEqual(this.itemModels, ((Show) other).itemModels);
            }

            public int hashCode() {
                return this.itemModels.hashCode();
            }

            public String toString() {
                return "Show(itemModels=" + this.itemModels + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Show(List<? extends ItemModel> itemModels) {
                super(null);
                Intrinsics.checkNotNullParameter(itemModels, "itemModels");
                this.itemModels = itemModels;
            }

            public final List<ItemModel> getItemModels() {
                return this.itemModels;
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: BoxAiCenterReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/boxai/BoxAiCenterReducer$Action$UpdateSession;", "Lcom/box/android/boxai/BoxAiCenterReducer$Action;", "sessionId", "", "<init>", "(Ljava/lang/String;)V", "getSessionId", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class UpdateSession extends Action {
            public static final int $stable = 0;
            private final String sessionId;

            public static /* synthetic */ UpdateSession copy$default(UpdateSession updateSession, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = updateSession.sessionId;
                }
                return updateSession.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getSessionId() {
                return this.sessionId;
            }

            public final UpdateSession copy(String sessionId) {
                return new UpdateSession(sessionId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof UpdateSession) && Intrinsics.areEqual(this.sessionId, ((UpdateSession) other).sessionId);
            }

            public int hashCode() {
                String str = this.sessionId;
                if (str == null) {
                    return 0;
                }
                return str.hashCode();
            }

            public String toString() {
                return "UpdateSession(sessionId=" + this.sessionId + ")";
            }

            public UpdateSession(String str) {
                super(null);
                this.sessionId = str;
            }

            public final String getSessionId() {
                return this.sessionId;
            }
        }

        /* JADX INFO: compiled from: BoxAiCenterReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/boxai/BoxAiCenterReducer$Action$AxLaunchHandled;", "Lcom/box/android/boxai/BoxAiCenterReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class AxLaunchHandled extends Action {
            public static final int $stable = 0;
            public static final AxLaunchHandled INSTANCE = new AxLaunchHandled();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof AxLaunchHandled)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1137311930;
            }

            public String toString() {
                return "AxLaunchHandled";
            }

            private AxLaunchHandled() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: BoxAiCenterReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/boxai/BoxAiCenterReducer$Action$ResetSession;", "Lcom/box/android/boxai/BoxAiCenterReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ResetSession extends Action {
            public static final int $stable = 0;
            public static final ResetSession INSTANCE = new ResetSession();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ResetSession)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 985421727;
            }

            public String toString() {
                return "ResetSession";
            }

            private ResetSession() {
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
        if (!(action instanceof Action.Show)) {
            if (action instanceof Action.ResetSession) {
                return new ReducerResult(State.copy$default(state, CollectionsKt.emptyList(), false, false, null, 6, null), null, 2, null);
            }
            if (action instanceof Action.UpdateSession) {
                return new ReducerResult(State.copy$default(state, null, false, false, ((Action.UpdateSession) action).getSessionId(), 7, null), null, 2, null);
            }
            if (action instanceof Action.AxLaunchHandled) {
                return new ReducerResult(State.copy$default(state, null, false, false, null, 11, null), null, 2, null);
            }
            throw new NoWhenBranchMatchedException();
        }
        Action.Show show = (Action.Show) action;
        State stateCopy$default = State.copy$default(state, show.getItemModels(), false, true, null, 10, null);
        List<ItemModel> itemModels = show.getItemModels();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(itemModels, 10));
        Iterator<T> it = itemModels.iterator();
        while (it.hasNext()) {
            arrayList.add(((ItemModel) it.next()).getItemId());
        }
        Set set = CollectionsKt.toSet(arrayList);
        List<ItemModel> itemModels2 = state.getItemModels();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(itemModels2, 10));
        Iterator<T> it2 = itemModels2.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((ItemModel) it2.next()).getItemId());
        }
        return new ReducerResult(stateCopy$default, Intrinsics.areEqual(set, CollectionsKt.toSet(arrayList2)) ? Effect.INSTANCE.none() : new Effect(new Action.UpdateSession(null)));
    }
}
