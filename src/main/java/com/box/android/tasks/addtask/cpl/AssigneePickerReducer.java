package com.box.android.tasks.addtask.cpl;

import com.box.android.base.models.UserMiniUIModel;
import com.box.android.cpl.Effect;
import com.box.android.cpl.EffectKt;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.ItemId;
import com.box.androidsdk.content.models.BoxCollaborator;
import com.facebook.react.uimanager.ViewProps;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: AssigneePickerReducer.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u001a\u001bB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u0002H\u0002J2\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0014\u0010\u0015\u001a\u00020\u0016*\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0014H\u0002J\u0018\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f*\b\u0012\u0004\u0012\u00020\u00190\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/box/android/tasks/addtask/cpl/AssigneePickerReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/tasks/addtask/cpl/AssigneePickerReducer$State;", "Lcom/box/android/tasks/addtask/cpl/AssigneePickerReducer$Action;", "environment", "Lcom/box/android/tasks/addtask/cpl/AssigneePickerEnvironment;", "<init>", "(Lcom/box/android/tasks/addtask/cpl/AssigneePickerEnvironment;)V", "build", "getBuild", "()Lcom/box/android/cpl/Reducable;", "handleLoad", "Lcom/box/android/cpl/ReducerResult;", "state", ViewProps.FILTER, "", "Lcom/box/android/base/models/UserMiniUIModel;", "all", "selected", "query", "", "matches", "", "needle", "toUserMiniModels", "Lcom/box/androidsdk/content/models/BoxCollaborator;", "State", "Action", "tasks_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AssigneePickerReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reducable<State, Action> build;
    private final AssigneePickerEnvironment environment;

    public AssigneePickerReducer(AssigneePickerEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        this.build = new Reduce(new Function2() { // from class: com.box.android.tasks.addtask.cpl.AssigneePickerReducer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AssigneePickerReducer.build$lambda$0(this.f$0, (AssigneePickerReducer.State) obj, (AssigneePickerReducer.Action) obj2);
            }
        });
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: AssigneePickerReducer.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bi\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u0010!\u001a\u00020\fHÆ\u0003J\t\u0010\"\u001a\u00020\fHÆ\u0003J\t\u0010#\u001a\u00020\fHÆ\u0003Jm\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\fHÆ\u0001J\u0013\u0010%\u001a\u00020\f2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0019R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\u000e\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019¨\u0006*"}, d2 = {"Lcom/box/android/tasks/addtask/cpl/AssigneePickerReducer$State;", "", "itemId", "Lcom/box/android/domain/models/ItemId;", "query", "", "allCollaborators", "", "Lcom/box/android/base/models/UserMiniUIModel;", "suggestions", "selected", "isLoading", "", "loadFailed", "invalidUser", "<init>", "(Lcom/box/android/domain/models/ItemId;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;ZZZ)V", "getItemId", "()Lcom/box/android/domain/models/ItemId;", "getQuery", "()Ljava/lang/String;", "getAllCollaborators", "()Ljava/util/List;", "getSuggestions", "getSelected", "()Z", "getLoadFailed", "getInvalidUser", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "tasks_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final List<UserMiniUIModel> allCollaborators;
        private final boolean invalidUser;
        private final boolean isLoading;
        private final ItemId itemId;
        private final boolean loadFailed;
        private final String query;
        private final List<UserMiniUIModel> selected;
        private final List<UserMiniUIModel> suggestions;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, ItemId itemId, String str, List list, List list2, List list3, boolean z, boolean z2, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                itemId = state.itemId;
            }
            if ((i & 2) != 0) {
                str = state.query;
            }
            if ((i & 4) != 0) {
                list = state.allCollaborators;
            }
            if ((i & 8) != 0) {
                list2 = state.suggestions;
            }
            if ((i & 16) != 0) {
                list3 = state.selected;
            }
            if ((i & 32) != 0) {
                z = state.isLoading;
            }
            if ((i & 64) != 0) {
                z2 = state.loadFailed;
            }
            if ((i & 128) != 0) {
                z3 = state.invalidUser;
            }
            boolean z4 = z2;
            boolean z5 = z3;
            List list4 = list3;
            boolean z6 = z;
            return state.copy(itemId, str, list, list2, list4, z6, z4, z5);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ItemId getItemId() {
            return this.itemId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getQuery() {
            return this.query;
        }

        public final List<UserMiniUIModel> component3() {
            return this.allCollaborators;
        }

        public final List<UserMiniUIModel> component4() {
            return this.suggestions;
        }

        public final List<UserMiniUIModel> component5() {
            return this.selected;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final boolean getIsLoading() {
            return this.isLoading;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final boolean getLoadFailed() {
            return this.loadFailed;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final boolean getInvalidUser() {
            return this.invalidUser;
        }

        public final State copy(ItemId itemId, String query, List<UserMiniUIModel> allCollaborators, List<UserMiniUIModel> suggestions, List<UserMiniUIModel> selected, boolean isLoading, boolean loadFailed, boolean invalidUser) {
            Intrinsics.checkNotNullParameter(itemId, "itemId");
            Intrinsics.checkNotNullParameter(query, "query");
            Intrinsics.checkNotNullParameter(suggestions, "suggestions");
            Intrinsics.checkNotNullParameter(selected, "selected");
            return new State(itemId, query, allCollaborators, suggestions, selected, isLoading, loadFailed, invalidUser);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.itemId, state.itemId) && Intrinsics.areEqual(this.query, state.query) && Intrinsics.areEqual(this.allCollaborators, state.allCollaborators) && Intrinsics.areEqual(this.suggestions, state.suggestions) && Intrinsics.areEqual(this.selected, state.selected) && this.isLoading == state.isLoading && this.loadFailed == state.loadFailed && this.invalidUser == state.invalidUser;
        }

        public int hashCode() {
            int iHashCode = ((this.itemId.hashCode() * 31) + this.query.hashCode()) * 31;
            List<UserMiniUIModel> list = this.allCollaborators;
            return ((((((((((iHashCode + (list == null ? 0 : list.hashCode())) * 31) + this.suggestions.hashCode()) * 31) + this.selected.hashCode()) * 31) + Boolean.hashCode(this.isLoading)) * 31) + Boolean.hashCode(this.loadFailed)) * 31) + Boolean.hashCode(this.invalidUser);
        }

        public String toString() {
            return "State(itemId=" + this.itemId + ", query=" + this.query + ", allCollaborators=" + this.allCollaborators + ", suggestions=" + this.suggestions + ", selected=" + this.selected + ", isLoading=" + this.isLoading + ", loadFailed=" + this.loadFailed + ", invalidUser=" + this.invalidUser + ")";
        }

        public State(ItemId itemId, String query, List<UserMiniUIModel> list, List<UserMiniUIModel> suggestions, List<UserMiniUIModel> selected, boolean z, boolean z2, boolean z3) {
            Intrinsics.checkNotNullParameter(itemId, "itemId");
            Intrinsics.checkNotNullParameter(query, "query");
            Intrinsics.checkNotNullParameter(suggestions, "suggestions");
            Intrinsics.checkNotNullParameter(selected, "selected");
            this.itemId = itemId;
            this.query = query;
            this.allCollaborators = list;
            this.suggestions = suggestions;
            this.selected = selected;
            this.isLoading = z;
            this.loadFailed = z2;
            this.invalidUser = z3;
        }

        public final ItemId getItemId() {
            return this.itemId;
        }

        public /* synthetic */ State(ItemId itemId, String str, List list, List list2, List list3, boolean z, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(itemId, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? null : list, (i & 8) != 0 ? CollectionsKt.emptyList() : list2, (i & 16) != 0 ? CollectionsKt.emptyList() : list3, (i & 32) != 0 ? false : z, (i & 64) != 0 ? false : z2, (i & 128) != 0 ? false : z3);
        }

        public final String getQuery() {
            return this.query;
        }

        public final List<UserMiniUIModel> getAllCollaborators() {
            return this.allCollaborators;
        }

        public final List<UserMiniUIModel> getSuggestions() {
            return this.suggestions;
        }

        public final List<UserMiniUIModel> getSelected() {
            return this.selected;
        }

        public final boolean isLoading() {
            return this.isLoading;
        }

        public final boolean getLoadFailed() {
            return this.loadFailed;
        }

        public final boolean getInvalidUser() {
            return this.invalidUser;
        }
    }

    /* JADX INFO: compiled from: AssigneePickerReducer.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0007\u0004\u0005\u0006\u0007\b\t\nB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0007\u000b\f\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/box/android/tasks/addtask/cpl/AssigneePickerReducer$Action;", "", "<init>", "()V", "Load", "Loaded", "LoadFailed", "QueryChanged", "AssigneeSelected", "AssigneeRemoved", "QueryFocusLost", "Lcom/box/android/tasks/addtask/cpl/AssigneePickerReducer$Action$AssigneeRemoved;", "Lcom/box/android/tasks/addtask/cpl/AssigneePickerReducer$Action$AssigneeSelected;", "Lcom/box/android/tasks/addtask/cpl/AssigneePickerReducer$Action$Load;", "Lcom/box/android/tasks/addtask/cpl/AssigneePickerReducer$Action$LoadFailed;", "Lcom/box/android/tasks/addtask/cpl/AssigneePickerReducer$Action$Loaded;", "Lcom/box/android/tasks/addtask/cpl/AssigneePickerReducer$Action$QueryChanged;", "Lcom/box/android/tasks/addtask/cpl/AssigneePickerReducer$Action$QueryFocusLost;", "tasks_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: AssigneePickerReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/tasks/addtask/cpl/AssigneePickerReducer$Action$Load;", "Lcom/box/android/tasks/addtask/cpl/AssigneePickerReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "tasks_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Load extends Action {
            public static final int $stable = 0;
            public static final Load INSTANCE = new Load();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Load)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1019835751;
            }

            public String toString() {
                return "Load";
            }

            private Load() {
                super(null);
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: AssigneePickerReducer.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/tasks/addtask/cpl/AssigneePickerReducer$Action$Loaded;", "Lcom/box/android/tasks/addtask/cpl/AssigneePickerReducer$Action;", "collaborators", "", "Lcom/box/android/base/models/UserMiniUIModel;", "<init>", "(Ljava/util/List;)V", "getCollaborators", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "tasks_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Loaded extends Action {
            public static final int $stable = 8;
            private final List<UserMiniUIModel> collaborators;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = loaded.collaborators;
                }
                return loaded.copy(list);
            }

            public final List<UserMiniUIModel> component1() {
                return this.collaborators;
            }

            public final Loaded copy(List<UserMiniUIModel> collaborators) {
                Intrinsics.checkNotNullParameter(collaborators, "collaborators");
                return new Loaded(collaborators);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Loaded) && Intrinsics.areEqual(this.collaborators, ((Loaded) other).collaborators);
            }

            public int hashCode() {
                return this.collaborators.hashCode();
            }

            public String toString() {
                return "Loaded(collaborators=" + this.collaborators + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(List<UserMiniUIModel> collaborators) {
                super(null);
                Intrinsics.checkNotNullParameter(collaborators, "collaborators");
                this.collaborators = collaborators;
            }

            public final List<UserMiniUIModel> getCollaborators() {
                return this.collaborators;
            }
        }

        /* JADX INFO: compiled from: AssigneePickerReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/tasks/addtask/cpl/AssigneePickerReducer$Action$LoadFailed;", "Lcom/box/android/tasks/addtask/cpl/AssigneePickerReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "tasks_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class LoadFailed extends Action {
            public static final int $stable = 0;
            public static final LoadFailed INSTANCE = new LoadFailed();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LoadFailed)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 960230454;
            }

            public String toString() {
                return "LoadFailed";
            }

            private LoadFailed() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: AssigneePickerReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/tasks/addtask/cpl/AssigneePickerReducer$Action$QueryChanged;", "Lcom/box/android/tasks/addtask/cpl/AssigneePickerReducer$Action;", "query", "", "<init>", "(Ljava/lang/String;)V", "getQuery", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "tasks_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class QueryChanged extends Action {
            public static final int $stable = 0;
            private final String query;

            public static /* synthetic */ QueryChanged copy$default(QueryChanged queryChanged, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = queryChanged.query;
                }
                return queryChanged.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getQuery() {
                return this.query;
            }

            public final QueryChanged copy(String query) {
                Intrinsics.checkNotNullParameter(query, "query");
                return new QueryChanged(query);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof QueryChanged) && Intrinsics.areEqual(this.query, ((QueryChanged) other).query);
            }

            public int hashCode() {
                return this.query.hashCode();
            }

            public String toString() {
                return "QueryChanged(query=" + this.query + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public QueryChanged(String query) {
                super(null);
                Intrinsics.checkNotNullParameter(query, "query");
                this.query = query;
            }

            public final String getQuery() {
                return this.query;
            }
        }

        /* JADX INFO: compiled from: AssigneePickerReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/tasks/addtask/cpl/AssigneePickerReducer$Action$AssigneeSelected;", "Lcom/box/android/tasks/addtask/cpl/AssigneePickerReducer$Action;", "assignee", "Lcom/box/android/base/models/UserMiniUIModel;", "<init>", "(Lcom/box/android/base/models/UserMiniUIModel;)V", "getAssignee", "()Lcom/box/android/base/models/UserMiniUIModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "tasks_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class AssigneeSelected extends Action {
            public static final int $stable = UserMiniUIModel.$stable;
            private final UserMiniUIModel assignee;

            public static /* synthetic */ AssigneeSelected copy$default(AssigneeSelected assigneeSelected, UserMiniUIModel userMiniUIModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    userMiniUIModel = assigneeSelected.assignee;
                }
                return assigneeSelected.copy(userMiniUIModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final UserMiniUIModel getAssignee() {
                return this.assignee;
            }

            public final AssigneeSelected copy(UserMiniUIModel assignee) {
                Intrinsics.checkNotNullParameter(assignee, "assignee");
                return new AssigneeSelected(assignee);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof AssigneeSelected) && Intrinsics.areEqual(this.assignee, ((AssigneeSelected) other).assignee);
            }

            public int hashCode() {
                return this.assignee.hashCode();
            }

            public String toString() {
                return "AssigneeSelected(assignee=" + this.assignee + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AssigneeSelected(UserMiniUIModel assignee) {
                super(null);
                Intrinsics.checkNotNullParameter(assignee, "assignee");
                this.assignee = assignee;
            }

            public final UserMiniUIModel getAssignee() {
                return this.assignee;
            }
        }

        /* JADX INFO: compiled from: AssigneePickerReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/tasks/addtask/cpl/AssigneePickerReducer$Action$AssigneeRemoved;", "Lcom/box/android/tasks/addtask/cpl/AssigneePickerReducer$Action;", "assignee", "Lcom/box/android/base/models/UserMiniUIModel;", "<init>", "(Lcom/box/android/base/models/UserMiniUIModel;)V", "getAssignee", "()Lcom/box/android/base/models/UserMiniUIModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "tasks_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class AssigneeRemoved extends Action {
            public static final int $stable = UserMiniUIModel.$stable;
            private final UserMiniUIModel assignee;

            public static /* synthetic */ AssigneeRemoved copy$default(AssigneeRemoved assigneeRemoved, UserMiniUIModel userMiniUIModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    userMiniUIModel = assigneeRemoved.assignee;
                }
                return assigneeRemoved.copy(userMiniUIModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final UserMiniUIModel getAssignee() {
                return this.assignee;
            }

            public final AssigneeRemoved copy(UserMiniUIModel assignee) {
                Intrinsics.checkNotNullParameter(assignee, "assignee");
                return new AssigneeRemoved(assignee);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof AssigneeRemoved) && Intrinsics.areEqual(this.assignee, ((AssigneeRemoved) other).assignee);
            }

            public int hashCode() {
                return this.assignee.hashCode();
            }

            public String toString() {
                return "AssigneeRemoved(assignee=" + this.assignee + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AssigneeRemoved(UserMiniUIModel assignee) {
                super(null);
                Intrinsics.checkNotNullParameter(assignee, "assignee");
                this.assignee = assignee;
            }

            public final UserMiniUIModel getAssignee() {
                return this.assignee;
            }
        }

        /* JADX INFO: compiled from: AssigneePickerReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/tasks/addtask/cpl/AssigneePickerReducer$Action$QueryFocusLost;", "Lcom/box/android/tasks/addtask/cpl/AssigneePickerReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "tasks_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class QueryFocusLost extends Action {
            public static final int $stable = 0;
            public static final QueryFocusLost INSTANCE = new QueryFocusLost();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof QueryFocusLost)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1884795353;
            }

            public String toString() {
                return "QueryFocusLost";
            }

            private QueryFocusLost() {
                super(null);
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReducerResult build$lambda$0(AssigneePickerReducer assigneePickerReducer, State state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (Intrinsics.areEqual(action, Action.Load.INSTANCE)) {
            return assigneePickerReducer.handleLoad(state);
        }
        if (action instanceof Action.Loaded) {
            Action.Loaded loaded = (Action.Loaded) action;
            return new ReducerResult(State.copy$default(state, null, null, loaded.getCollaborators(), assigneePickerReducer.filter(loaded.getCollaborators(), state.getSelected(), state.getQuery()), null, false, false, false, Token.DOTQUERY, null), null, 2, null);
        }
        if (Intrinsics.areEqual(action, Action.LoadFailed.INSTANCE)) {
            return new ReducerResult(State.copy$default(state, null, null, null, CollectionsKt.emptyList(), null, false, true, false, Token.TO_DOUBLE, null), null, 2, null);
        }
        if (action instanceof Action.QueryChanged) {
            List<UserMiniUIModel> allCollaborators = state.getAllCollaborators();
            if (allCollaborators == null) {
                allCollaborators = CollectionsKt.emptyList();
            }
            Action.QueryChanged queryChanged = (Action.QueryChanged) action;
            State stateCopy$default = State.copy$default(state, null, queryChanged.getQuery(), null, assigneePickerReducer.filter(allCollaborators, state.getSelected(), queryChanged.getQuery()), null, false, false, false, 117, null);
            if (state.getLoadFailed() && !state.isLoading()) {
                return new ReducerResult(stateCopy$default, new Effect(Action.Load.INSTANCE));
            }
            return new ReducerResult(stateCopy$default, null, 2, null);
        }
        if (action instanceof Action.AssigneeSelected) {
            List<UserMiniUIModel> selected = state.getSelected();
            if (!(selected instanceof Collection) || !selected.isEmpty()) {
                Iterator<T> it = selected.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.areEqual(((UserMiniUIModel) it.next()).getId(), ((Action.AssigneeSelected) action).getAssignee().getId())) {
                        return new ReducerResult(state, null, 2, null);
                    }
                }
            }
            List<UserMiniUIModel> listPlus = CollectionsKt.plus((Collection<? extends UserMiniUIModel>) state.getSelected(), ((Action.AssigneeSelected) action).getAssignee());
            List<UserMiniUIModel> allCollaborators2 = state.getAllCollaborators();
            if (allCollaborators2 == null) {
                allCollaborators2 = CollectionsKt.emptyList();
            }
            return new ReducerResult(State.copy$default(state, null, "", null, assigneePickerReducer.filter(allCollaborators2, listPlus, ""), listPlus, false, false, false, 101, null), null, 2, null);
        }
        if (action instanceof Action.AssigneeRemoved) {
            List<UserMiniUIModel> selected2 = state.getSelected();
            ArrayList arrayList = new ArrayList();
            for (Object obj : selected2) {
                if (!Intrinsics.areEqual(((UserMiniUIModel) obj).getId(), ((Action.AssigneeRemoved) action).getAssignee().getId())) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = arrayList;
            List<UserMiniUIModel> allCollaborators3 = state.getAllCollaborators();
            if (allCollaborators3 == null) {
                allCollaborators3 = CollectionsKt.emptyList();
            }
            return new ReducerResult(State.copy$default(state, null, null, null, assigneePickerReducer.filter(allCollaborators3, arrayList2, state.getQuery()), arrayList2, false, false, false, 231, null), null, 2, null);
        }
        if (!Intrinsics.areEqual(action, Action.QueryFocusLost.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        if (!StringsKt.isBlank(state.getQuery()) && state.getAllCollaborators() != null && assigneePickerReducer.filter(state.getAllCollaborators(), state.getSelected(), state.getQuery()).isEmpty()) {
            return new ReducerResult(State.copy$default(state, null, null, null, null, null, false, false, true, 127, null), null, 2, null);
        }
        return new ReducerResult(State.copy$default(state, null, "", null, null, null, false, false, false, 125, null), null, 2, null);
    }

    private final ReducerResult<State, Action> handleLoad(State state) {
        if (state.getAllCollaborators() != null || state.isLoading()) {
            return new ReducerResult<>(state, null, 2, null);
        }
        return new ReducerResult<>(State.copy$default(state, null, null, null, null, null, true, false, false, Token.LETEXPR, null), EffectKt.toEffect(FlowKt.flow(new AnonymousClass1(state, null))));
    }

    /* JADX INFO: renamed from: com.box.android.tasks.addtask.cpl.AssigneePickerReducer$handleLoad$1, reason: invalid class name */
    /* JADX INFO: compiled from: AssigneePickerReducer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/tasks/addtask/cpl/AssigneePickerReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.tasks.addtask.cpl.AssigneePickerReducer$handleLoad$1", f = "AssigneePickerReducer.kt", i = {0, 1, 1, 2, 2}, l = {Token.LOOP, 135, Token.SCRIPT}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "response", "$this$flow", "response"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Action>, Continuation<? super Unit>, Object> {
        final /* synthetic */ State $state;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(State state, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = AssigneePickerReducer.this.new AnonymousClass1(this.$state, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Action> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0085, code lost:
        
            if (r0.emit(new com.box.android.tasks.addtask.cpl.AssigneePickerReducer.Action.Loaded(r3.toUserMiniModels(r5)), r7) == r1) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x009f, code lost:
        
            if (r0.emit(com.box.android.tasks.addtask.cpl.AssigneePickerReducer.Action.LoadFailed.INSTANCE, r7) == r1) goto L22;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = r7.L$0
                kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r7.label
                r3 = 3
                r4 = 2
                r5 = 1
                if (r2 == 0) goto L2b
                if (r2 == r5) goto L27
                if (r2 == r4) goto L1e
                if (r2 != r3) goto L16
                goto L1e
            L16:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L1e:
                java.lang.Object r7 = r7.L$1
                com.box.androidsdk.content.requests.BoxResponse r7 = (com.box.androidsdk.content.requests.BoxResponse) r7
                kotlin.ResultKt.throwOnFailure(r8)
                goto La2
            L27:
                kotlin.ResultKt.throwOnFailure(r8)
                goto L4c
            L2b:
                kotlin.ResultKt.throwOnFailure(r8)
                com.box.android.tasks.addtask.cpl.AssigneePickerReducer r8 = com.box.android.tasks.addtask.cpl.AssigneePickerReducer.this
                com.box.android.tasks.addtask.cpl.AssigneePickerEnvironment r8 = com.box.android.tasks.addtask.cpl.AssigneePickerReducer.access$getEnvironment$p(r8)
                com.box.android.domain.controller.ICommentControllerBridge r8 = r8.getCommentControllerBridge()
                com.box.android.tasks.addtask.cpl.AssigneePickerReducer$State r2 = r7.$state
                com.box.android.domain.models.ItemId r2 = r2.getItemId()
                r6 = r7
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                r7.L$0 = r0
                r7.label = r5
                java.lang.Object r8 = r8.fetchCollaboratorsSync(r2, r6)
                if (r8 != r1) goto L4c
                goto La1
            L4c:
                com.box.androidsdk.content.requests.BoxResponse r8 = (com.box.androidsdk.content.requests.BoxResponse) r8
                boolean r2 = r8.isSuccess()
                if (r2 == 0) goto L88
                com.box.android.tasks.addtask.cpl.AssigneePickerReducer$Action$Loaded r2 = new com.box.android.tasks.addtask.cpl.AssigneePickerReducer$Action$Loaded
                com.box.android.tasks.addtask.cpl.AssigneePickerReducer r3 = com.box.android.tasks.addtask.cpl.AssigneePickerReducer.this
                com.box.androidsdk.content.models.BoxObject r5 = r8.getResult()
                com.box.androidsdk.content.models.BoxIteratorCollaborators r5 = (com.box.androidsdk.content.models.BoxIteratorCollaborators) r5
                java.util.ArrayList r5 = r5.getEntries()
                java.lang.String r6 = "getEntries(...)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
                java.util.List r5 = (java.util.List) r5
                java.util.List r3 = com.box.android.tasks.addtask.cpl.AssigneePickerReducer.access$toUserMiniModels(r3, r5)
                r2.<init>(r3)
                r3 = r7
                kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
                r7.L$0 = r5
                java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
                r7.L$1 = r8
                r7.label = r4
                java.lang.Object r7 = r0.emit(r2, r3)
                if (r7 != r1) goto La2
                goto La1
            L88:
                com.box.android.tasks.addtask.cpl.AssigneePickerReducer$Action$LoadFailed r2 = com.box.android.tasks.addtask.cpl.AssigneePickerReducer.Action.LoadFailed.INSTANCE
                r4 = r7
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
                r7.L$0 = r5
                java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
                r7.L$1 = r8
                r7.label = r3
                java.lang.Object r7 = r0.emit(r2, r4)
                if (r7 != r1) goto La2
            La1:
                return r1
            La2:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.tasks.addtask.cpl.AssigneePickerReducer.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final List<UserMiniUIModel> filter(List<UserMiniUIModel> all, List<UserMiniUIModel> selected, String query) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<T> it = selected.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(((UserMiniUIModel) it.next()).getId());
        }
        LinkedHashSet linkedHashSet2 = linkedHashSet;
        ArrayList arrayList = new ArrayList();
        for (Object obj : all) {
            if (!linkedHashSet2.contains(((UserMiniUIModel) obj).getId())) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        String str = query;
        if (StringsKt.isBlank(str)) {
            return arrayList2;
        }
        String string = StringsKt.trim((CharSequence) str).toString();
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : arrayList2) {
            if (matches((UserMiniUIModel) obj2, string)) {
                arrayList3.add(obj2);
            }
        }
        return arrayList3;
    }

    private final boolean matches(UserMiniUIModel userMiniUIModel, String str) {
        String str2 = str;
        boolean zContains = StringsKt.contains((CharSequence) userMiniUIModel.getName(), (CharSequence) str2, true);
        String login = userMiniUIModel.getLogin();
        return zContains || (login != null && StringsKt.contains((CharSequence) login, (CharSequence) str2, true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:15:0x0034  */
    /* JADX WARN: Code duplicated, block: B:20:0x0044  */
    /* JADX WARN: Code duplicated, block: B:23:0x0048 A[PHI: r3
      0x0048: PHI (r3v4 java.lang.String) = (r3v3 java.lang.String), (r3v5 java.lang.String) binds: [B:21:0x0045, B:14:0x0032] A[DONT_GENERATE, DONT_INLINE]] */
    public final List<UserMiniUIModel> toUserMiniModels(List<? extends BoxCollaborator> list) {
        ArrayList arrayList = new ArrayList();
        for (BoxCollaborator boxCollaborator : list) {
            String id = boxCollaborator.getUserId();
            UserMiniUIModel userMiniUIModel = null;
            if (id != null) {
                String userName = boxCollaborator.getUserName();
                if (userName == null) {
                    userName = boxCollaborator.getLogin();
                    if (userName != null || StringsKt.isBlank(userName)) {
                        userName = null;
                    }
                    if (userName != null) {
                        userMiniUIModel = new UserMiniUIModel(id, userName, boxCollaborator.getLogin());
                    }
                } else {
                    if (StringsKt.isBlank(userName)) {
                        userName = null;
                    }
                    if (userName == null) {
                        userName = boxCollaborator.getLogin();
                        if (userName != null) {
                            userName = null;
                        } else {
                            userName = null;
                        }
                        if (userName != null) {
                            userMiniUIModel = new UserMiniUIModel(id, userName, boxCollaborator.getLogin());
                        }
                    } else {
                        userMiniUIModel = new UserMiniUIModel(id, userName, boxCollaborator.getLogin());
                    }
                }
            }
            if (userMiniUIModel != null) {
                arrayList.add(userMiniUIModel);
            }
        }
        return arrayList;
    }
}
