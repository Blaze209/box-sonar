package com.box.android.base.presentation.components.commentbar.mentions;

import com.box.android.cpl.EffectKt;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.ItemId;
import com.box.androidsdk.content.models.BoxCollaborator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: CollaboratorsMentionsReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0015\u0016B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013*\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/box/android/base/presentation/components/commentbar/mentions/CollaboratorsMentionsReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/base/presentation/components/commentbar/mentions/CollaboratorsMentionsReducer$State;", "Lcom/box/android/base/presentation/components/commentbar/mentions/CollaboratorsMentionsReducer$Action;", "environment", "Lcom/box/android/base/presentation/components/commentbar/mentions/CollaboratorsMentionsEnvironment;", "<init>", "(Lcom/box/android/base/presentation/components/commentbar/mentions/CollaboratorsMentionsEnvironment;)V", "getEnvironment", "()Lcom/box/android/base/presentation/components/commentbar/mentions/CollaboratorsMentionsEnvironment;", "build", "getBuild", "()Lcom/box/android/cpl/Reducable;", "handleLoadCollaborators", "Lcom/box/android/cpl/ReducerResult;", "state", "prefix", "", "performFiltering", "", "Lcom/box/androidsdk/content/models/BoxCollaborator;", "State", "Action", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CollaboratorsMentionsReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reducable<State, Action> build;
    private final CollaboratorsMentionsEnvironment environment;

    public CollaboratorsMentionsReducer(CollaboratorsMentionsEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        this.build = new Reduce(new Function2() { // from class: com.box.android.base.presentation.components.commentbar.mentions.CollaboratorsMentionsReducer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return CollaboratorsMentionsReducer.build$lambda$0(this.f$0, (CollaboratorsMentionsReducer.State) obj, (CollaboratorsMentionsReducer.Action) obj2);
            }
        });
    }

    public final CollaboratorsMentionsEnvironment getEnvironment() {
        return this.environment;
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: CollaboratorsMentionsReducer.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J7\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/box/android/base/presentation/components/commentbar/mentions/CollaboratorsMentionsReducer$State;", "", "itemId", "Lcom/box/android/domain/models/ItemId;", "cachedCollaborators", "", "Lcom/box/androidsdk/content/models/BoxCollaborator;", "filteredCollaborators", "<init>", "(Lcom/box/android/domain/models/ItemId;Ljava/util/List;Ljava/util/List;)V", "getItemId", "()Lcom/box/android/domain/models/ItemId;", "getCachedCollaborators", "()Ljava/util/List;", "getFilteredCollaborators", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final List<BoxCollaborator> cachedCollaborators;
        private final List<BoxCollaborator> filteredCollaborators;
        private final ItemId itemId;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, ItemId itemId, List list, List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                itemId = state.itemId;
            }
            if ((i & 2) != 0) {
                list = state.cachedCollaborators;
            }
            if ((i & 4) != 0) {
                list2 = state.filteredCollaborators;
            }
            return state.copy(itemId, list, list2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ItemId getItemId() {
            return this.itemId;
        }

        public final List<BoxCollaborator> component2() {
            return this.cachedCollaborators;
        }

        public final List<BoxCollaborator> component3() {
            return this.filteredCollaborators;
        }

        public final State copy(ItemId itemId, List<? extends BoxCollaborator> cachedCollaborators, List<? extends BoxCollaborator> filteredCollaborators) {
            Intrinsics.checkNotNullParameter(itemId, "itemId");
            return new State(itemId, cachedCollaborators, filteredCollaborators);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.itemId, state.itemId) && Intrinsics.areEqual(this.cachedCollaborators, state.cachedCollaborators) && Intrinsics.areEqual(this.filteredCollaborators, state.filteredCollaborators);
        }

        public int hashCode() {
            int iHashCode = this.itemId.hashCode() * 31;
            List<BoxCollaborator> list = this.cachedCollaborators;
            int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
            List<BoxCollaborator> list2 = this.filteredCollaborators;
            return iHashCode2 + (list2 != null ? list2.hashCode() : 0);
        }

        public String toString() {
            return "State(itemId=" + this.itemId + ", cachedCollaborators=" + this.cachedCollaborators + ", filteredCollaborators=" + this.filteredCollaborators + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public State(ItemId itemId, List<? extends BoxCollaborator> list, List<? extends BoxCollaborator> list2) {
            Intrinsics.checkNotNullParameter(itemId, "itemId");
            this.itemId = itemId;
            this.cachedCollaborators = list;
            this.filteredCollaborators = list2;
        }

        public /* synthetic */ State(ItemId itemId, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(itemId, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : list2);
        }

        public final ItemId getItemId() {
            return this.itemId;
        }

        public final List<BoxCollaborator> getCachedCollaborators() {
            return this.cachedCollaborators;
        }

        public final List<BoxCollaborator> getFilteredCollaborators() {
            return this.filteredCollaborators;
        }
    }

    /* JADX INFO: compiled from: CollaboratorsMentionsReducer.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0007\u0004\u0005\u0006\u0007\b\t\nB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0007\u000b\f\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/box/android/base/presentation/components/commentbar/mentions/CollaboratorsMentionsReducer$Action;", "", "<init>", "()V", "LoadCollaborators", "LoadingCollaboratorsFailed", "ShowCollaborators", "CollaboratorsLoaded", "HideCollaborators", "OnMentionOptionClicked", "DismissRequested", "Lcom/box/android/base/presentation/components/commentbar/mentions/CollaboratorsMentionsReducer$Action$CollaboratorsLoaded;", "Lcom/box/android/base/presentation/components/commentbar/mentions/CollaboratorsMentionsReducer$Action$DismissRequested;", "Lcom/box/android/base/presentation/components/commentbar/mentions/CollaboratorsMentionsReducer$Action$HideCollaborators;", "Lcom/box/android/base/presentation/components/commentbar/mentions/CollaboratorsMentionsReducer$Action$LoadCollaborators;", "Lcom/box/android/base/presentation/components/commentbar/mentions/CollaboratorsMentionsReducer$Action$LoadingCollaboratorsFailed;", "Lcom/box/android/base/presentation/components/commentbar/mentions/CollaboratorsMentionsReducer$Action$OnMentionOptionClicked;", "Lcom/box/android/base/presentation/components/commentbar/mentions/CollaboratorsMentionsReducer$Action$ShowCollaborators;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: CollaboratorsMentionsReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/base/presentation/components/commentbar/mentions/CollaboratorsMentionsReducer$Action$LoadCollaborators;", "Lcom/box/android/base/presentation/components/commentbar/mentions/CollaboratorsMentionsReducer$Action;", "prefix", "", "<init>", "(Ljava/lang/String;)V", "getPrefix", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class LoadCollaborators extends Action {
            public static final int $stable = 0;
            private final String prefix;

            public static /* synthetic */ LoadCollaborators copy$default(LoadCollaborators loadCollaborators, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = loadCollaborators.prefix;
                }
                return loadCollaborators.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getPrefix() {
                return this.prefix;
            }

            public final LoadCollaborators copy(String prefix) {
                Intrinsics.checkNotNullParameter(prefix, "prefix");
                return new LoadCollaborators(prefix);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof LoadCollaborators) && Intrinsics.areEqual(this.prefix, ((LoadCollaborators) other).prefix);
            }

            public int hashCode() {
                return this.prefix.hashCode();
            }

            public String toString() {
                return "LoadCollaborators(prefix=" + this.prefix + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public LoadCollaborators(String prefix) {
                super(null);
                Intrinsics.checkNotNullParameter(prefix, "prefix");
                this.prefix = prefix;
            }

            public final String getPrefix() {
                return this.prefix;
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: CollaboratorsMentionsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/base/presentation/components/commentbar/mentions/CollaboratorsMentionsReducer$Action$LoadingCollaboratorsFailed;", "Lcom/box/android/base/presentation/components/commentbar/mentions/CollaboratorsMentionsReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class LoadingCollaboratorsFailed extends Action {
            public static final int $stable = 0;
            public static final LoadingCollaboratorsFailed INSTANCE = new LoadingCollaboratorsFailed();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LoadingCollaboratorsFailed)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1262186357;
            }

            public String toString() {
                return "LoadingCollaboratorsFailed";
            }

            private LoadingCollaboratorsFailed() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: CollaboratorsMentionsReducer.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/base/presentation/components/commentbar/mentions/CollaboratorsMentionsReducer$Action$ShowCollaborators;", "Lcom/box/android/base/presentation/components/commentbar/mentions/CollaboratorsMentionsReducer$Action;", "collaborators", "", "Lcom/box/androidsdk/content/models/BoxCollaborator;", "<init>", "(Ljava/util/List;)V", "getCollaborators", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ShowCollaborators extends Action {
            public static final int $stable = 8;
            private final List<BoxCollaborator> collaborators;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ ShowCollaborators copy$default(ShowCollaborators showCollaborators, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = showCollaborators.collaborators;
                }
                return showCollaborators.copy(list);
            }

            public final List<BoxCollaborator> component1() {
                return this.collaborators;
            }

            public final ShowCollaborators copy(List<? extends BoxCollaborator> collaborators) {
                Intrinsics.checkNotNullParameter(collaborators, "collaborators");
                return new ShowCollaborators(collaborators);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ShowCollaborators) && Intrinsics.areEqual(this.collaborators, ((ShowCollaborators) other).collaborators);
            }

            public int hashCode() {
                return this.collaborators.hashCode();
            }

            public String toString() {
                return "ShowCollaborators(collaborators=" + this.collaborators + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public ShowCollaborators(List<? extends BoxCollaborator> collaborators) {
                super(null);
                Intrinsics.checkNotNullParameter(collaborators, "collaborators");
                this.collaborators = collaborators;
            }

            public final List<BoxCollaborator> getCollaborators() {
                return this.collaborators;
            }
        }

        /* JADX INFO: compiled from: CollaboratorsMentionsReducer.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/base/presentation/components/commentbar/mentions/CollaboratorsMentionsReducer$Action$CollaboratorsLoaded;", "Lcom/box/android/base/presentation/components/commentbar/mentions/CollaboratorsMentionsReducer$Action;", "collaborators", "", "Lcom/box/androidsdk/content/models/BoxCollaborator;", "<init>", "(Ljava/util/List;)V", "getCollaborators", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CollaboratorsLoaded extends Action {
            public static final int $stable = 8;
            private final List<BoxCollaborator> collaborators;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ CollaboratorsLoaded copy$default(CollaboratorsLoaded collaboratorsLoaded, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = collaboratorsLoaded.collaborators;
                }
                return collaboratorsLoaded.copy(list);
            }

            public final List<BoxCollaborator> component1() {
                return this.collaborators;
            }

            public final CollaboratorsLoaded copy(List<? extends BoxCollaborator> collaborators) {
                Intrinsics.checkNotNullParameter(collaborators, "collaborators");
                return new CollaboratorsLoaded(collaborators);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof CollaboratorsLoaded) && Intrinsics.areEqual(this.collaborators, ((CollaboratorsLoaded) other).collaborators);
            }

            public int hashCode() {
                return this.collaborators.hashCode();
            }

            public String toString() {
                return "CollaboratorsLoaded(collaborators=" + this.collaborators + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public CollaboratorsLoaded(List<? extends BoxCollaborator> collaborators) {
                super(null);
                Intrinsics.checkNotNullParameter(collaborators, "collaborators");
                this.collaborators = collaborators;
            }

            public final List<BoxCollaborator> getCollaborators() {
                return this.collaborators;
            }
        }

        /* JADX INFO: compiled from: CollaboratorsMentionsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/base/presentation/components/commentbar/mentions/CollaboratorsMentionsReducer$Action$HideCollaborators;", "Lcom/box/android/base/presentation/components/commentbar/mentions/CollaboratorsMentionsReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class HideCollaborators extends Action {
            public static final int $stable = 0;
            public static final HideCollaborators INSTANCE = new HideCollaborators();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof HideCollaborators)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -295617842;
            }

            public String toString() {
                return "HideCollaborators";
            }

            private HideCollaborators() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: CollaboratorsMentionsReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/base/presentation/components/commentbar/mentions/CollaboratorsMentionsReducer$Action$OnMentionOptionClicked;", "Lcom/box/android/base/presentation/components/commentbar/mentions/CollaboratorsMentionsReducer$Action;", "user", "Lcom/box/androidsdk/content/models/BoxCollaborator;", "<init>", "(Lcom/box/androidsdk/content/models/BoxCollaborator;)V", "getUser", "()Lcom/box/androidsdk/content/models/BoxCollaborator;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class OnMentionOptionClicked extends Action {
            public static final int $stable = 8;
            private final BoxCollaborator user;

            public static /* synthetic */ OnMentionOptionClicked copy$default(OnMentionOptionClicked onMentionOptionClicked, BoxCollaborator boxCollaborator, int i, Object obj) {
                if ((i & 1) != 0) {
                    boxCollaborator = onMentionOptionClicked.user;
                }
                return onMentionOptionClicked.copy(boxCollaborator);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final BoxCollaborator getUser() {
                return this.user;
            }

            public final OnMentionOptionClicked copy(BoxCollaborator user) {
                Intrinsics.checkNotNullParameter(user, "user");
                return new OnMentionOptionClicked(user);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof OnMentionOptionClicked) && Intrinsics.areEqual(this.user, ((OnMentionOptionClicked) other).user);
            }

            public int hashCode() {
                return this.user.hashCode();
            }

            public String toString() {
                return "OnMentionOptionClicked(user=" + this.user + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public OnMentionOptionClicked(BoxCollaborator user) {
                super(null);
                Intrinsics.checkNotNullParameter(user, "user");
                this.user = user;
            }

            public final BoxCollaborator getUser() {
                return this.user;
            }
        }

        /* JADX INFO: compiled from: CollaboratorsMentionsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/base/presentation/components/commentbar/mentions/CollaboratorsMentionsReducer$Action$DismissRequested;", "Lcom/box/android/base/presentation/components/commentbar/mentions/CollaboratorsMentionsReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class DismissRequested extends Action {
            public static final int $stable = 0;
            public static final DismissRequested INSTANCE = new DismissRequested();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof DismissRequested)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 185630689;
            }

            public String toString() {
                return "DismissRequested";
            }

            private DismissRequested() {
                super(null);
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReducerResult build$lambda$0(CollaboratorsMentionsReducer collaboratorsMentionsReducer, State state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof Action.LoadCollaborators) {
            return collaboratorsMentionsReducer.handleLoadCollaborators(state, ((Action.LoadCollaborators) action).getPrefix());
        }
        if (action instanceof Action.ShowCollaborators) {
            return new ReducerResult(State.copy$default(state, null, null, ((Action.ShowCollaborators) action).getCollaborators(), 3, null), null, 2, null);
        }
        if (action instanceof Action.CollaboratorsLoaded) {
            return new ReducerResult(State.copy$default(state, null, ((Action.CollaboratorsLoaded) action).getCollaborators(), null, 5, null), null, 2, null);
        }
        if (action instanceof Action.LoadingCollaboratorsFailed) {
            return new ReducerResult(State.copy$default(state, null, null, null, 3, null), null, 2, null);
        }
        if (action instanceof Action.HideCollaborators) {
            return new ReducerResult(State.copy$default(state, null, null, null, 3, null), null, 2, null);
        }
        if (action instanceof Action.OnMentionOptionClicked) {
            return new ReducerResult(State.copy$default(state, null, null, null, 3, null), null, 2, null);
        }
        if (!(action instanceof Action.DismissRequested)) {
            throw new NoWhenBranchMatchedException();
        }
        return new ReducerResult(State.copy$default(state, null, null, null, 3, null), null, 2, null);
    }

    private final ReducerResult<State, Action> handleLoadCollaborators(State state, String prefix) {
        return new ReducerResult<>(state, EffectKt.toEffect(FlowKt.flow(new AnonymousClass1(state, this, prefix, null))));
    }

    /* JADX INFO: renamed from: com.box.android.base.presentation.components.commentbar.mentions.CollaboratorsMentionsReducer$handleLoadCollaborators$1, reason: invalid class name */
    /* JADX INFO: compiled from: CollaboratorsMentionsReducer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/base/presentation/components/commentbar/mentions/CollaboratorsMentionsReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.base.presentation.components.commentbar.mentions.CollaboratorsMentionsReducer$handleLoadCollaborators$1", f = "CollaboratorsMentionsReducer.kt", i = {0, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 5, 5, 6}, l = {69, 71, 73, 74, 76, 80, 83}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "response", "$this$flow", "response", "collaborators", "$this$flow", "response", "collaborators", "$this$flow", "response", "$this$flow", "response", "$this$flow"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$0", "L$1", "L$0"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Action>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $prefix;
        final /* synthetic */ State $state;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ CollaboratorsMentionsReducer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(State state, CollaboratorsMentionsReducer collaboratorsMentionsReducer, String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$state = state;
            this.this$0 = collaboratorsMentionsReducer;
            this.$prefix = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$state, this.this$0, this.$prefix, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Action> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code duplicated, block: B:12:0x0040 A[PHI: r2
          0x0040: PHI (r2v9 com.box.androidsdk.content.requests.BoxResponse) = (r2v8 com.box.androidsdk.content.requests.BoxResponse), (r2v12 com.box.androidsdk.content.requests.BoxResponse) binds: [B:28:0x00c6, B:11:0x0039] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:27:0x00ae  */
        /* JADX WARN: Code duplicated, block: B:33:0x00f6 A[PHI: r2 r3
          0x00f6: PHI (r2v13 java.util.List) = (r2v10 java.util.List), (r2v17 java.util.List) binds: [B:31:0x00f3, B:10:0x002c] A[DONT_GENERATE, DONT_INLINE]
          0x00f6: PHI (r3v8 com.box.androidsdk.content.requests.BoxResponse) = (r3v7 com.box.androidsdk.content.requests.BoxResponse), (r3v11 com.box.androidsdk.content.requests.BoxResponse) binds: [B:31:0x00f3, B:10:0x002c] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:36:0x0128  */
        /* JADX WARN: Code duplicated, block: B:39:0x014f A[PHI: r2
          0x014f: PHI (r2v18 com.box.androidsdk.content.requests.BoxResponse) = (r2v8 com.box.androidsdk.content.requests.BoxResponse), (r2v22 com.box.androidsdk.content.requests.BoxResponse) binds: [B:37:0x014c, B:7:0x001a] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x007e, code lost:
        
            if (r0.emit(new com.box.android.base.presentation.components.commentbar.mentions.CollaboratorsMentionsReducer.Action.ShowCollaborators(r7.this$0.performFiltering(r7.$state.getCachedCollaborators(), r7.$prefix)), r7) == r1) goto L41;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0125, code lost:
        
            if (r0.emit(new com.box.android.base.presentation.components.commentbar.mentions.CollaboratorsMentionsReducer.Action.ShowCollaborators(r4.performFiltering(r2, r7.$prefix)), r7) == r1) goto L41;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x0167, code lost:
        
            if (r0.emit(com.box.android.base.presentation.components.commentbar.mentions.CollaboratorsMentionsReducer.Action.LoadingCollaboratorsFailed.INSTANCE, r7) == r1) goto L41;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                Method dump skipped, instruction units count: 386
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.base.presentation.components.commentbar.mentions.CollaboratorsMentionsReducer.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:10:0x0035  */
    public final List<BoxCollaborator> performFiltering(List<? extends BoxCollaborator> list, String str) {
        boolean zStartsWith;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            BoxCollaborator boxCollaborator = (BoxCollaborator) obj;
            String userName = boxCollaborator.getUserName();
            boolean z = true;
            if (userName != null) {
                String lowerCase = userName.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (lowerCase != null) {
                    zStartsWith = StringsKt.startsWith(lowerCase, str, true);
                } else {
                    zStartsWith = false;
                }
            } else {
                zStartsWith = false;
            }
            if (!zStartsWith) {
                String login = boxCollaborator.getLogin();
                if (!(login != null ? StringsKt.startsWith(login, str, true) : false)) {
                    z = false;
                }
            }
            if (z) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
