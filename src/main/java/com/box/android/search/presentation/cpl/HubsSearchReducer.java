package com.box.android.search.presentation.cpl;

import com.box.android.cpl.EffectKt;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.hubs.HubsDirection;
import com.box.android.domain.models.hubs.HubsSort;
import com.box.android.domain.models.search.SearchResult;
import com.box.android.search.presentation.SearchConstants;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import com.pspdfkit.analytics.Analytics;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: HubsSearchReducer.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u000e\u000fB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0003H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/box/android/search/presentation/cpl/HubsSearchReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/search/presentation/cpl/HubsSearchReducer$State;", "Lcom/box/android/search/presentation/cpl/HubsSearchReducer$Action;", "environment", "Lcom/box/android/search/presentation/cpl/SearchEnvironment;", "<init>", "(Lcom/box/android/search/presentation/cpl/SearchEnvironment;)V", "getEnvironment", "()Lcom/box/android/search/presentation/cpl/SearchEnvironment;", "reduce", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "State", "Action", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class HubsSearchReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final SearchEnvironment environment;

    public HubsSearchReducer(SearchEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ Reducable<State, Action> getBuild() {
        return Reducable.DefaultImpls.getBuild(this);
    }

    public final SearchEnvironment getEnvironment() {
        return this.environment;
    }

    /* JADX INFO: compiled from: HubsSearchReducer.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/box/android/search/presentation/cpl/HubsSearchReducer$State;", "Lcom/box/android/search/presentation/cpl/SearchModeState;", "hubsSort", "Lcom/box/android/domain/models/hubs/HubsSort;", "hubsDirection", "Lcom/box/android/domain/models/hubs/HubsDirection;", "<init>", "(Lcom/box/android/domain/models/hubs/HubsSort;Lcom/box/android/domain/models/hubs/HubsDirection;)V", "getHubsSort", "()Lcom/box/android/domain/models/hubs/HubsSort;", "getHubsDirection", "()Lcom/box/android/domain/models/hubs/HubsDirection;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State extends SearchModeState {
        public static final int $stable = 0;
        private final HubsDirection hubsDirection;
        private final HubsSort hubsSort;

        /* JADX WARN: Multi-variable type inference failed */
        public State() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ State copy$default(State state, HubsSort hubsSort, HubsDirection hubsDirection, int i, Object obj) {
            if ((i & 1) != 0) {
                hubsSort = state.hubsSort;
            }
            if ((i & 2) != 0) {
                hubsDirection = state.hubsDirection;
            }
            return state.copy(hubsSort, hubsDirection);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final HubsSort getHubsSort() {
            return this.hubsSort;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final HubsDirection getHubsDirection() {
            return this.hubsDirection;
        }

        public final State copy(HubsSort hubsSort, HubsDirection hubsDirection) {
            Intrinsics.checkNotNullParameter(hubsSort, "hubsSort");
            Intrinsics.checkNotNullParameter(hubsDirection, "hubsDirection");
            return new State(hubsSort, hubsDirection);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return this.hubsSort == state.hubsSort && this.hubsDirection == state.hubsDirection;
        }

        public int hashCode() {
            return (this.hubsSort.hashCode() * 31) + this.hubsDirection.hashCode();
        }

        public String toString() {
            return "State(hubsSort=" + this.hubsSort + ", hubsDirection=" + this.hubsDirection + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public State(HubsSort hubsSort, HubsDirection hubsDirection) {
            super(null);
            Intrinsics.checkNotNullParameter(hubsSort, "hubsSort");
            Intrinsics.checkNotNullParameter(hubsDirection, "hubsDirection");
            this.hubsSort = hubsSort;
            this.hubsDirection = hubsDirection;
        }

        public /* synthetic */ State(HubsSort hubsSort, HubsDirection hubsDirection, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? HubsSort.DateUpdated : hubsSort, (i & 2) != 0 ? HubsDirection.DESC : hubsDirection);
        }

        public final HubsDirection getHubsDirection() {
            return this.hubsDirection;
        }

        public final HubsSort getHubsSort() {
            return this.hubsSort;
        }
    }

    /* JADX INFO: compiled from: HubsSearchReducer.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/box/android/search/presentation/cpl/HubsSearchReducer$Action;", "", "<init>", "()V", "PerformSearch", "SearchResultsReceived", "Error", "Lcom/box/android/search/presentation/cpl/HubsSearchReducer$Action$Error;", "Lcom/box/android/search/presentation/cpl/HubsSearchReducer$Action$PerformSearch;", "Lcom/box/android/search/presentation/cpl/HubsSearchReducer$Action$SearchResultsReceived;", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: HubsSearchReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/box/android/search/presentation/cpl/HubsSearchReducer$Action$PerformSearch;", "Lcom/box/android/search/presentation/cpl/HubsSearchReducer$Action;", "query", "", "offset", "", "<init>", "(Ljava/lang/String;I)V", "getQuery", "()Ljava/lang/String;", "getOffset", "()I", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class PerformSearch extends Action {
            public static final int $stable = 0;
            private final int offset;
            private final String query;

            public static /* synthetic */ PerformSearch copy$default(PerformSearch performSearch, String str, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    str = performSearch.query;
                }
                if ((i2 & 2) != 0) {
                    i = performSearch.offset;
                }
                return performSearch.copy(str, i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getQuery() {
                return this.query;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final int getOffset() {
                return this.offset;
            }

            public final PerformSearch copy(String query, int offset) {
                Intrinsics.checkNotNullParameter(query, "query");
                return new PerformSearch(query, offset);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PerformSearch)) {
                    return false;
                }
                PerformSearch performSearch = (PerformSearch) other;
                return Intrinsics.areEqual(this.query, performSearch.query) && this.offset == performSearch.offset;
            }

            public int hashCode() {
                return (this.query.hashCode() * 31) + Integer.hashCode(this.offset);
            }

            public String toString() {
                return "PerformSearch(query=" + this.query + ", offset=" + this.offset + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public PerformSearch(String query, int i) {
                super(null);
                Intrinsics.checkNotNullParameter(query, "query");
                this.query = query;
                this.offset = i;
            }

            public final int getOffset() {
                return this.offset;
            }

            public final String getQuery() {
                return this.query;
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: HubsSearchReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/search/presentation/cpl/HubsSearchReducer$Action$SearchResultsReceived;", "Lcom/box/android/search/presentation/cpl/HubsSearchReducer$Action;", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "Lcom/box/android/domain/models/search/SearchResult$HubSearchResult;", "<init>", "(Lcom/box/android/domain/models/search/SearchResult$HubSearchResult;)V", "getResult", "()Lcom/box/android/domain/models/search/SearchResult$HubSearchResult;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SearchResultsReceived extends Action {
            public static final int $stable = 8;
            private final SearchResult.HubSearchResult result;

            public static /* synthetic */ SearchResultsReceived copy$default(SearchResultsReceived searchResultsReceived, SearchResult.HubSearchResult hubSearchResult, int i, Object obj) {
                if ((i & 1) != 0) {
                    hubSearchResult = searchResultsReceived.result;
                }
                return searchResultsReceived.copy(hubSearchResult);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final SearchResult.HubSearchResult getResult() {
                return this.result;
            }

            public final SearchResultsReceived copy(SearchResult.HubSearchResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                return new SearchResultsReceived(result);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SearchResultsReceived) && Intrinsics.areEqual(this.result, ((SearchResultsReceived) other).result);
            }

            public int hashCode() {
                return this.result.hashCode();
            }

            public String toString() {
                return "SearchResultsReceived(result=" + this.result + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SearchResultsReceived(SearchResult.HubSearchResult result) {
                super(null);
                Intrinsics.checkNotNullParameter(result, "result");
                this.result = result;
            }

            public final SearchResult.HubSearchResult getResult() {
                return this.result;
            }
        }

        /* JADX INFO: compiled from: HubsSearchReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/search/presentation/cpl/HubsSearchReducer$Action$Error;", "Lcom/box/android/search/presentation/cpl/HubsSearchReducer$Action;", "error", "Lcom/box/android/domain/models/DomainError;", "<init>", "(Lcom/box/android/domain/models/DomainError;)V", "getError", "()Lcom/box/android/domain/models/DomainError;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Error extends Action {
            public static final int $stable = 8;
            private final DomainError error;

            public static /* synthetic */ Error copy$default(Error error, DomainError domainError, int i, Object obj) {
                if ((i & 1) != 0) {
                    domainError = error.error;
                }
                return error.copy(domainError);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final DomainError getError() {
                return this.error;
            }

            public final Error copy(DomainError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                return new Error(error);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Error) && Intrinsics.areEqual(this.error, ((Error) other).error);
            }

            public int hashCode() {
                return this.error.hashCode();
            }

            public String toString() {
                return "Error(error=" + this.error + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Error(DomainError error) {
                super(null);
                Intrinsics.checkNotNullParameter(error, "error");
                this.error = error;
            }

            public final DomainError getError() {
                return this.error;
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public ReducerResult<State, Action> reduce(State state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof Action.PerformSearch) {
            return new ReducerResult<>(state, EffectKt.toEffect(FlowKt.flow(new AnonymousClass1(action, state, null))).cancellable(SearchConstants.SEARCH_CANCEL_EFFECT_KEY, true));
        }
        if (!(action instanceof Action.SearchResultsReceived) && !(action instanceof Action.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    /* JADX INFO: renamed from: com.box.android.search.presentation.cpl.HubsSearchReducer$reduce$1, reason: invalid class name */
    /* JADX INFO: compiled from: HubsSearchReducer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/search/presentation/cpl/HubsSearchReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.search.presentation.cpl.HubsSearchReducer$reduce$1", f = "HubsSearchReducer.kt", i = {0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {33, 39, 41}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "$this$onSuccess$iv", "it", "$i$f$onSuccess", "$i$a$-onSuccess-HubsSearchReducer$reduce$1$1", "$this$flow", "$this$onError$iv", "it", "$i$f$onError", "$i$a$-onError-HubsSearchReducer$reduce$1$2"}, s = {"L$0", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Action>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Action $action;
        final /* synthetic */ State $state;
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Action action, State state, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$action = action;
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = HubsSearchReducer.this.new AnonymousClass1(this.$action, this.$state, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Action> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:24:0x00a6  */
        /* JADX WARN: Code duplicated, block: B:26:0x00aa  */
        /* JADX WARN: Code duplicated, block: B:29:0x00d3  */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x00d0, code lost:
        
            if (r0.emit(r4, r13) == r1) goto L28;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                Method dump skipped, instruction units count: 226
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.search.presentation.cpl.HubsSearchReducer.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }
}
