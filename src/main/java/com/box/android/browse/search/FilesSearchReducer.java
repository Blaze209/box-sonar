package com.box.android.browse.search;

import com.box.android.browse.models.BoxSearchFilters;
import com.box.android.cpl.Effect;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.pspdfkit.analytics.Analytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FilesSearchReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u0010\u0011\u0012B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/box/android/browse/search/FilesSearchReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/browse/search/FilesSearchReducer$State;", "Lcom/box/android/browse/search/FilesSearchReducer$Action;", "environment", "Lcom/box/android/browse/search/FilesSearchEnvironment;", "<init>", "(Lcom/box/android/browse/search/FilesSearchEnvironment;)V", "build", "Lcom/box/android/cpl/Reduce;", "getBuild", "()Lcom/box/android/cpl/Reduce;", "reduceFilesSearch", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "RecentSearchQueriesState", "State", "Action", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FilesSearchReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reduce<State, Action> build;
    private final FilesSearchEnvironment environment;

    public FilesSearchReducer(FilesSearchEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        this.build = new Reduce<>(new FilesSearchReducer$build$1(this));
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: FilesSearchReducer.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/box/android/browse/search/FilesSearchReducer$RecentSearchQueriesState;", "", "queries", "", "", "<init>", "(Ljava/util/List;)V", "getQueries", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class RecentSearchQueriesState {
        public static final int $stable = 8;
        private final List<String> queries;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ RecentSearchQueriesState copy$default(RecentSearchQueriesState recentSearchQueriesState, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = recentSearchQueriesState.queries;
            }
            return recentSearchQueriesState.copy(list);
        }

        public final List<String> component1() {
            return this.queries;
        }

        public final RecentSearchQueriesState copy(List<String> queries) {
            Intrinsics.checkNotNullParameter(queries, "queries");
            return new RecentSearchQueriesState(queries);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof RecentSearchQueriesState) && Intrinsics.areEqual(this.queries, ((RecentSearchQueriesState) other).queries);
        }

        public int hashCode() {
            return this.queries.hashCode();
        }

        public String toString() {
            return "RecentSearchQueriesState(queries=" + this.queries + ")";
        }

        public RecentSearchQueriesState(List<String> queries) {
            Intrinsics.checkNotNullParameter(queries, "queries");
            this.queries = queries;
        }

        public final List<String> getQueries() {
            return this.queries;
        }
    }

    /* JADX INFO: compiled from: FilesSearchReducer.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/box/android/browse/search/FilesSearchReducer$State;", "", "recentSearchQueriesState", "Lcom/box/android/browse/search/FilesSearchReducer$RecentSearchQueriesState;", "query", "", "filters", "Lcom/box/android/browse/models/BoxSearchFilters;", "<init>", "(Lcom/box/android/browse/search/FilesSearchReducer$RecentSearchQueriesState;Ljava/lang/String;Lcom/box/android/browse/models/BoxSearchFilters;)V", "getRecentSearchQueriesState", "()Lcom/box/android/browse/search/FilesSearchReducer$RecentSearchQueriesState;", "getQuery", "()Ljava/lang/String;", "getFilters", "()Lcom/box/android/browse/models/BoxSearchFilters;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final BoxSearchFilters filters;
        private final String query;
        private final RecentSearchQueriesState recentSearchQueriesState;

        public State() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ State copy$default(State state, RecentSearchQueriesState recentSearchQueriesState, String str, BoxSearchFilters boxSearchFilters, int i, Object obj) {
            if ((i & 1) != 0) {
                recentSearchQueriesState = state.recentSearchQueriesState;
            }
            if ((i & 2) != 0) {
                str = state.query;
            }
            if ((i & 4) != 0) {
                boxSearchFilters = state.filters;
            }
            return state.copy(recentSearchQueriesState, str, boxSearchFilters);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final RecentSearchQueriesState getRecentSearchQueriesState() {
            return this.recentSearchQueriesState;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getQuery() {
            return this.query;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final BoxSearchFilters getFilters() {
            return this.filters;
        }

        public final State copy(RecentSearchQueriesState recentSearchQueriesState, String query, BoxSearchFilters filters) {
            Intrinsics.checkNotNullParameter(query, "query");
            Intrinsics.checkNotNullParameter(filters, "filters");
            return new State(recentSearchQueriesState, query, filters);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.recentSearchQueriesState, state.recentSearchQueriesState) && Intrinsics.areEqual(this.query, state.query) && Intrinsics.areEqual(this.filters, state.filters);
        }

        public int hashCode() {
            RecentSearchQueriesState recentSearchQueriesState = this.recentSearchQueriesState;
            return ((((recentSearchQueriesState == null ? 0 : recentSearchQueriesState.hashCode()) * 31) + this.query.hashCode()) * 31) + this.filters.hashCode();
        }

        public String toString() {
            return "State(recentSearchQueriesState=" + this.recentSearchQueriesState + ", query=" + this.query + ", filters=" + this.filters + ")";
        }

        public State(RecentSearchQueriesState recentSearchQueriesState, String query, BoxSearchFilters filters) {
            Intrinsics.checkNotNullParameter(query, "query");
            Intrinsics.checkNotNullParameter(filters, "filters");
            this.recentSearchQueriesState = recentSearchQueriesState;
            this.query = query;
            this.filters = filters;
        }

        public final RecentSearchQueriesState getRecentSearchQueriesState() {
            return this.recentSearchQueriesState;
        }

        public /* synthetic */ State(RecentSearchQueriesState recentSearchQueriesState, String str, BoxSearchFilters boxSearchFilters, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : recentSearchQueriesState, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? new BoxSearchFilters() : boxSearchFilters);
        }

        public final String getQuery() {
            return this.query;
        }

        public final BoxSearchFilters getFilters() {
            return this.filters;
        }
    }

    /* JADX INFO: compiled from: FilesSearchReducer.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/box/android/browse/search/FilesSearchReducer$Action;", "", "<init>", "()V", "Initialize", "QueryChanged", "RecentQueryClicked", "AddSearchQueryToRecent", "DeleteRecentSearchQuery", "Lcom/box/android/browse/search/FilesSearchReducer$Action$AddSearchQueryToRecent;", "Lcom/box/android/browse/search/FilesSearchReducer$Action$DeleteRecentSearchQuery;", "Lcom/box/android/browse/search/FilesSearchReducer$Action$Initialize;", "Lcom/box/android/browse/search/FilesSearchReducer$Action$QueryChanged;", "Lcom/box/android/browse/search/FilesSearchReducer$Action$RecentQueryClicked;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: FilesSearchReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/search/FilesSearchReducer$Action$Initialize;", "Lcom/box/android/browse/search/FilesSearchReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Initialize extends Action {
            public static final int $stable = 0;
            public static final Initialize INSTANCE = new Initialize();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Initialize)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1591885928;
            }

            public String toString() {
                return "Initialize";
            }

            private Initialize() {
                super(null);
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: FilesSearchReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/browse/search/FilesSearchReducer$Action$QueryChanged;", "Lcom/box/android/browse/search/FilesSearchReducer$Action;", "query", "", "<init>", "(Ljava/lang/String;)V", "getQuery", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

        /* JADX INFO: compiled from: FilesSearchReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/browse/search/FilesSearchReducer$Action$RecentQueryClicked;", "Lcom/box/android/browse/search/FilesSearchReducer$Action;", "query", "", "<init>", "(Ljava/lang/String;)V", "getQuery", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class RecentQueryClicked extends Action {
            public static final int $stable = 0;
            private final String query;

            public static /* synthetic */ RecentQueryClicked copy$default(RecentQueryClicked recentQueryClicked, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = recentQueryClicked.query;
                }
                return recentQueryClicked.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getQuery() {
                return this.query;
            }

            public final RecentQueryClicked copy(String query) {
                Intrinsics.checkNotNullParameter(query, "query");
                return new RecentQueryClicked(query);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof RecentQueryClicked) && Intrinsics.areEqual(this.query, ((RecentQueryClicked) other).query);
            }

            public int hashCode() {
                return this.query.hashCode();
            }

            public String toString() {
                return "RecentQueryClicked(query=" + this.query + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RecentQueryClicked(String query) {
                super(null);
                Intrinsics.checkNotNullParameter(query, "query");
                this.query = query;
            }

            public final String getQuery() {
                return this.query;
            }
        }

        /* JADX INFO: compiled from: FilesSearchReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/search/FilesSearchReducer$Action$AddSearchQueryToRecent;", "Lcom/box/android/browse/search/FilesSearchReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class AddSearchQueryToRecent extends Action {
            public static final int $stable = 0;
            public static final AddSearchQueryToRecent INSTANCE = new AddSearchQueryToRecent();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof AddSearchQueryToRecent)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -788532611;
            }

            public String toString() {
                return "AddSearchQueryToRecent";
            }

            private AddSearchQueryToRecent() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FilesSearchReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/browse/search/FilesSearchReducer$Action$DeleteRecentSearchQuery;", "Lcom/box/android/browse/search/FilesSearchReducer$Action;", "query", "", "<init>", "(Ljava/lang/String;)V", "getQuery", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class DeleteRecentSearchQuery extends Action {
            public static final int $stable = 0;
            private final String query;

            public static /* synthetic */ DeleteRecentSearchQuery copy$default(DeleteRecentSearchQuery deleteRecentSearchQuery, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = deleteRecentSearchQuery.query;
                }
                return deleteRecentSearchQuery.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getQuery() {
                return this.query;
            }

            public final DeleteRecentSearchQuery copy(String query) {
                Intrinsics.checkNotNullParameter(query, "query");
                return new DeleteRecentSearchQuery(query);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof DeleteRecentSearchQuery) && Intrinsics.areEqual(this.query, ((DeleteRecentSearchQuery) other).query);
            }

            public int hashCode() {
                return this.query.hashCode();
            }

            public String toString() {
                return "DeleteRecentSearchQuery(query=" + this.query + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public DeleteRecentSearchQuery(String query) {
                super(null);
                Intrinsics.checkNotNullParameter(query, "query");
                this.query = query;
            }

            public final String getQuery() {
                return this.query;
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0084  */
    /* JADX WARN: Multi-variable type inference failed */
    public final ReducerResult<State, Action> reduceFilesSearch(State state, Action action) {
        List<String> queries;
        RecentSearchQueriesState recentSearchQueriesState;
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
        Object[] objArr8 = 0;
        Object[] objArr9 = 0;
        Object[] objArr10 = 0;
        Object[] objArr11 = 0;
        Object[] objArr12 = 0;
        Object[] objArr13 = 0;
        if (action instanceof Action.Initialize) {
            List<String> listLoadRecentSearchQueries = this.environment.getFilesSearchHelper().loadRecentSearchQueries();
            if (!listLoadRecentSearchQueries.isEmpty() && state.getQuery().length() == 0) {
                return new ReducerResult<>(State.copy$default(state, new RecentSearchQueriesState(listLoadRecentSearchQueries), null, null, 6, null), effect, i, objArr13 == true ? 1 : 0);
            }
            return new ReducerResult<>(state, objArr12 == true ? 1 : 0, i, objArr11 == true ? 1 : 0);
        }
        if (action instanceof Action.QueryChanged) {
            Action.QueryChanged queryChanged = (Action.QueryChanged) action;
            this.environment.getFilesSearchHelper().logSearch(queryChanged.getQuery());
            if (queryChanged.getQuery().length() == 0) {
                List<String> listLoadRecentSearchQueries2 = this.environment.getFilesSearchHelper().loadRecentSearchQueries();
                if (listLoadRecentSearchQueries2.isEmpty()) {
                    recentSearchQueriesState = null;
                } else {
                    recentSearchQueriesState = new RecentSearchQueriesState(listLoadRecentSearchQueries2);
                }
            } else {
                recentSearchQueriesState = null;
            }
            return new ReducerResult<>(State.copy$default(state, recentSearchQueriesState, queryChanged.getQuery(), null, 4, null), objArr10 == true ? 1 : 0, i, objArr9 == true ? 1 : 0);
        }
        if (action instanceof Action.RecentQueryClicked) {
            Action.RecentQueryClicked recentQueryClicked = (Action.RecentQueryClicked) action;
            this.environment.getFilesSearchHelper().logRecentSearchClick(recentQueryClicked.getQuery());
            return new ReducerResult<>(State.copy$default(state, null, recentQueryClicked.getQuery(), null, 4, null), objArr8 == true ? 1 : 0, i, objArr7 == true ? 1 : 0);
        }
        if (action instanceof Action.AddSearchQueryToRecent) {
            this.environment.getFilesSearchHelper().addRecentSearchQuery(state.getQuery());
            return new ReducerResult<>(state, objArr6 == true ? 1 : 0, i, objArr5 == true ? 1 : 0);
        }
        if (!(action instanceof Action.DeleteRecentSearchQuery)) {
            throw new NoWhenBranchMatchedException();
        }
        RecentSearchQueriesState recentSearchQueriesState2 = state.getRecentSearchQueriesState();
        Integer numValueOf = (recentSearchQueriesState2 == null || (queries = recentSearchQueriesState2.getQueries()) == null) ? null : Integer.valueOf(queries.indexOf(((Action.DeleteRecentSearchQuery) action).getQuery()));
        if (numValueOf != null && numValueOf.intValue() == -1) {
            numValueOf = null;
        }
        if (numValueOf == null) {
            return new ReducerResult<>(state, objArr4 == true ? 1 : 0, i, objArr3 == true ? 1 : 0);
        }
        List<String> listDeleteRecentSearchQuery = this.environment.getFilesSearchHelper().deleteRecentSearchQuery(numValueOf.intValue());
        return new ReducerResult<>(State.copy$default(state, !listDeleteRecentSearchQuery.isEmpty() ? new RecentSearchQueriesState(listDeleteRecentSearchQuery) : null, null, null, 6, null), objArr2 == true ? 1 : 0, i, objArr == true ? 1 : 0);
    }
}
