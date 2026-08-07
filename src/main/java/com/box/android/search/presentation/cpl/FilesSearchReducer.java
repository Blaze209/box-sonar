package com.box.android.search.presentation.cpl;

import com.box.android.cpl.Effect;
import com.box.android.cpl.EffectKt;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.localrepo.LocalSortPreferences;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.search.FilesSearchFilters;
import com.box.android.domain.models.search.FilesSearchFiltersKt;
import com.box.android.domain.models.search.SearchResult;
import com.box.android.search.presentation.SearchConstants;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import com.pspdfkit.analytics.Analytics;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: FilesSearchReducer.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u000e\u000fB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0003H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/box/android/search/presentation/cpl/FilesSearchReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/search/presentation/cpl/FilesSearchReducer$State;", "Lcom/box/android/search/presentation/cpl/FilesSearchReducer$Action;", "environment", "Lcom/box/android/search/presentation/cpl/SearchEnvironment;", "<init>", "(Lcom/box/android/search/presentation/cpl/SearchEnvironment;)V", "getEnvironment", "()Lcom/box/android/search/presentation/cpl/SearchEnvironment;", "reduce", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "State", "Action", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FilesSearchReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final SearchEnvironment environment;

    public FilesSearchReducer(SearchEnvironment environment) {
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

    /* JADX INFO: compiled from: FilesSearchReducer.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J3\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/box/android/search/presentation/cpl/FilesSearchReducer$State;", "Lcom/box/android/search/presentation/cpl/SearchModeState;", "parentFolder", "Lcom/box/android/domain/models/item/FolderModel;", "localSortBy", "Lcom/box/android/domain/localrepo/LocalSortPreferences$SortBy;", "filters", "Lcom/box/android/domain/models/search/FilesSearchFilters;", "includeRecentSharedLinks", "", "<init>", "(Lcom/box/android/domain/models/item/FolderModel;Lcom/box/android/domain/localrepo/LocalSortPreferences$SortBy;Lcom/box/android/domain/models/search/FilesSearchFilters;Z)V", "getParentFolder", "()Lcom/box/android/domain/models/item/FolderModel;", "getLocalSortBy", "()Lcom/box/android/domain/localrepo/LocalSortPreferences$SortBy;", "getFilters", "()Lcom/box/android/domain/models/search/FilesSearchFilters;", "getIncludeRecentSharedLinks", "()Z", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State extends SearchModeState {
        public static final int $stable = 0;
        private final FilesSearchFilters filters;
        private final boolean includeRecentSharedLinks;
        private final LocalSortPreferences.SortBy localSortBy;
        private final FolderModel parentFolder;

        public State() {
            this(null, null, null, false, 15, null);
        }

        public static /* synthetic */ State copy$default(State state, FolderModel folderModel, LocalSortPreferences.SortBy sortBy, FilesSearchFilters filesSearchFilters, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                folderModel = state.parentFolder;
            }
            if ((i & 2) != 0) {
                sortBy = state.localSortBy;
            }
            if ((i & 4) != 0) {
                filesSearchFilters = state.filters;
            }
            if ((i & 8) != 0) {
                z = state.includeRecentSharedLinks;
            }
            return state.copy(folderModel, sortBy, filesSearchFilters, z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final FolderModel getParentFolder() {
            return this.parentFolder;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final LocalSortPreferences.SortBy getLocalSortBy() {
            return this.localSortBy;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final FilesSearchFilters getFilters() {
            return this.filters;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIncludeRecentSharedLinks() {
            return this.includeRecentSharedLinks;
        }

        public final State copy(FolderModel parentFolder, LocalSortPreferences.SortBy localSortBy, FilesSearchFilters filters, boolean includeRecentSharedLinks) {
            Intrinsics.checkNotNullParameter(parentFolder, "parentFolder");
            Intrinsics.checkNotNullParameter(localSortBy, "localSortBy");
            return new State(parentFolder, localSortBy, filters, includeRecentSharedLinks);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.parentFolder, state.parentFolder) && this.localSortBy == state.localSortBy && Intrinsics.areEqual(this.filters, state.filters) && this.includeRecentSharedLinks == state.includeRecentSharedLinks;
        }

        public int hashCode() {
            int iHashCode = ((this.parentFolder.hashCode() * 31) + this.localSortBy.hashCode()) * 31;
            FilesSearchFilters filesSearchFilters = this.filters;
            return ((iHashCode + (filesSearchFilters == null ? 0 : filesSearchFilters.hashCode())) * 31) + Boolean.hashCode(this.includeRecentSharedLinks);
        }

        public String toString() {
            return "State(parentFolder=" + this.parentFolder + ", localSortBy=" + this.localSortBy + ", filters=" + this.filters + ", includeRecentSharedLinks=" + this.includeRecentSharedLinks + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public State(FolderModel parentFolder, LocalSortPreferences.SortBy localSortBy, FilesSearchFilters filesSearchFilters, boolean z) {
            super(null);
            Intrinsics.checkNotNullParameter(parentFolder, "parentFolder");
            Intrinsics.checkNotNullParameter(localSortBy, "localSortBy");
            this.parentFolder = parentFolder;
            this.localSortBy = localSortBy;
            this.filters = filesSearchFilters;
            this.includeRecentSharedLinks = z;
        }

        public /* synthetic */ State(FolderModel folderModel, LocalSortPreferences.SortBy sortBy, FilesSearchFilters filesSearchFilters, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? FolderModel.Companion.createFromId$default(FolderModel.INSTANCE, "0", null, 2, null) : folderModel, (i & 2) != 0 ? LocalSortPreferences.SortBy.MODIFIED_AT : sortBy, (i & 4) != 0 ? null : filesSearchFilters, (i & 8) != 0 ? false : z);
        }

        public final FolderModel getParentFolder() {
            return this.parentFolder;
        }

        public final LocalSortPreferences.SortBy getLocalSortBy() {
            return this.localSortBy;
        }

        public final FilesSearchFilters getFilters() {
            return this.filters;
        }

        public final boolean getIncludeRecentSharedLinks() {
            return this.includeRecentSharedLinks;
        }
    }

    /* JADX INFO: compiled from: FilesSearchReducer.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\b\u0004\u0005\u0006\u0007\b\t\n\u000bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\b\f\r\u000e\u000f\u0010\u0011\u0012\u0013¨\u0006\u0014"}, d2 = {"Lcom/box/android/search/presentation/cpl/FilesSearchReducer$Action;", "", "<init>", "()V", "PerformSearch", "SearchResultsReceived", "Error", "FiltersButtonClicked", "UpdateFilters", "RemoveFilter", "ClearFilters", "OnFiltersUpdated", "Lcom/box/android/search/presentation/cpl/FilesSearchReducer$Action$ClearFilters;", "Lcom/box/android/search/presentation/cpl/FilesSearchReducer$Action$Error;", "Lcom/box/android/search/presentation/cpl/FilesSearchReducer$Action$FiltersButtonClicked;", "Lcom/box/android/search/presentation/cpl/FilesSearchReducer$Action$OnFiltersUpdated;", "Lcom/box/android/search/presentation/cpl/FilesSearchReducer$Action$PerformSearch;", "Lcom/box/android/search/presentation/cpl/FilesSearchReducer$Action$RemoveFilter;", "Lcom/box/android/search/presentation/cpl/FilesSearchReducer$Action$SearchResultsReceived;", "Lcom/box/android/search/presentation/cpl/FilesSearchReducer$Action$UpdateFilters;", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: FilesSearchReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/box/android/search/presentation/cpl/FilesSearchReducer$Action$PerformSearch;", "Lcom/box/android/search/presentation/cpl/FilesSearchReducer$Action;", "query", "", "offset", "", "<init>", "(Ljava/lang/String;I)V", "getQuery", "()Ljava/lang/String;", "getOffset", "()I", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

        /* JADX INFO: compiled from: FilesSearchReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/search/presentation/cpl/FilesSearchReducer$Action$SearchResultsReceived;", "Lcom/box/android/search/presentation/cpl/FilesSearchReducer$Action;", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "Lcom/box/android/domain/models/search/SearchResult$FileSearchResult;", "<init>", "(Lcom/box/android/domain/models/search/SearchResult$FileSearchResult;)V", "getResult", "()Lcom/box/android/domain/models/search/SearchResult$FileSearchResult;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SearchResultsReceived extends Action {
            public static final int $stable = 8;
            private final SearchResult.FileSearchResult result;

            public static /* synthetic */ SearchResultsReceived copy$default(SearchResultsReceived searchResultsReceived, SearchResult.FileSearchResult fileSearchResult, int i, Object obj) {
                if ((i & 1) != 0) {
                    fileSearchResult = searchResultsReceived.result;
                }
                return searchResultsReceived.copy(fileSearchResult);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final SearchResult.FileSearchResult getResult() {
                return this.result;
            }

            public final SearchResultsReceived copy(SearchResult.FileSearchResult result) {
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
            public SearchResultsReceived(SearchResult.FileSearchResult result) {
                super(null);
                Intrinsics.checkNotNullParameter(result, "result");
                this.result = result;
            }

            public final SearchResult.FileSearchResult getResult() {
                return this.result;
            }
        }

        /* JADX INFO: compiled from: FilesSearchReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/search/presentation/cpl/FilesSearchReducer$Action$Error;", "Lcom/box/android/search/presentation/cpl/FilesSearchReducer$Action;", "error", "Lcom/box/android/domain/models/DomainError;", "<init>", "(Lcom/box/android/domain/models/DomainError;)V", "getError", "()Lcom/box/android/domain/models/DomainError;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

        /* JADX INFO: compiled from: FilesSearchReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/search/presentation/cpl/FilesSearchReducer$Action$FiltersButtonClicked;", "Lcom/box/android/search/presentation/cpl/FilesSearchReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FiltersButtonClicked extends Action {
            public static final int $stable = 0;
            public static final FiltersButtonClicked INSTANCE = new FiltersButtonClicked();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof FiltersButtonClicked)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1691808317;
            }

            public String toString() {
                return "FiltersButtonClicked";
            }

            private FiltersButtonClicked() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FilesSearchReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/search/presentation/cpl/FilesSearchReducer$Action$UpdateFilters;", "Lcom/box/android/search/presentation/cpl/FilesSearchReducer$Action;", "newFilters", "Lcom/box/android/domain/models/search/FilesSearchFilters;", "<init>", "(Lcom/box/android/domain/models/search/FilesSearchFilters;)V", "getNewFilters", "()Lcom/box/android/domain/models/search/FilesSearchFilters;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class UpdateFilters extends Action {
            public static final int $stable = 8;
            private final FilesSearchFilters newFilters;

            public static /* synthetic */ UpdateFilters copy$default(UpdateFilters updateFilters, FilesSearchFilters filesSearchFilters, int i, Object obj) {
                if ((i & 1) != 0) {
                    filesSearchFilters = updateFilters.newFilters;
                }
                return updateFilters.copy(filesSearchFilters);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FilesSearchFilters getNewFilters() {
                return this.newFilters;
            }

            public final UpdateFilters copy(FilesSearchFilters newFilters) {
                Intrinsics.checkNotNullParameter(newFilters, "newFilters");
                return new UpdateFilters(newFilters);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof UpdateFilters) && Intrinsics.areEqual(this.newFilters, ((UpdateFilters) other).newFilters);
            }

            public int hashCode() {
                return this.newFilters.hashCode();
            }

            public String toString() {
                return "UpdateFilters(newFilters=" + this.newFilters + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public UpdateFilters(FilesSearchFilters newFilters) {
                super(null);
                Intrinsics.checkNotNullParameter(newFilters, "newFilters");
                this.newFilters = newFilters;
            }

            public final FilesSearchFilters getNewFilters() {
                return this.newFilters;
            }
        }

        /* JADX INFO: compiled from: FilesSearchReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/search/presentation/cpl/FilesSearchReducer$Action$RemoveFilter;", "Lcom/box/android/search/presentation/cpl/FilesSearchReducer$Action;", "chip", "Lcom/box/android/domain/models/search/FilesSearchFilters$FilterType;", "<init>", "(Lcom/box/android/domain/models/search/FilesSearchFilters$FilterType;)V", "getChip", "()Lcom/box/android/domain/models/search/FilesSearchFilters$FilterType;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class RemoveFilter extends Action {
            public static final int $stable = 8;
            private final FilesSearchFilters.FilterType chip;

            public static /* synthetic */ RemoveFilter copy$default(RemoveFilter removeFilter, FilesSearchFilters.FilterType filterType, int i, Object obj) {
                if ((i & 1) != 0) {
                    filterType = removeFilter.chip;
                }
                return removeFilter.copy(filterType);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FilesSearchFilters.FilterType getChip() {
                return this.chip;
            }

            public final RemoveFilter copy(FilesSearchFilters.FilterType chip) {
                Intrinsics.checkNotNullParameter(chip, "chip");
                return new RemoveFilter(chip);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof RemoveFilter) && Intrinsics.areEqual(this.chip, ((RemoveFilter) other).chip);
            }

            public int hashCode() {
                return this.chip.hashCode();
            }

            public String toString() {
                return "RemoveFilter(chip=" + this.chip + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RemoveFilter(FilesSearchFilters.FilterType chip) {
                super(null);
                Intrinsics.checkNotNullParameter(chip, "chip");
                this.chip = chip;
            }

            public final FilesSearchFilters.FilterType getChip() {
                return this.chip;
            }
        }

        /* JADX INFO: compiled from: FilesSearchReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/search/presentation/cpl/FilesSearchReducer$Action$ClearFilters;", "Lcom/box/android/search/presentation/cpl/FilesSearchReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ClearFilters extends Action {
            public static final int $stable = 0;
            public static final ClearFilters INSTANCE = new ClearFilters();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ClearFilters)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -570701359;
            }

            public String toString() {
                return "ClearFilters";
            }

            private ClearFilters() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FilesSearchReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/search/presentation/cpl/FilesSearchReducer$Action$OnFiltersUpdated;", "Lcom/box/android/search/presentation/cpl/FilesSearchReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class OnFiltersUpdated extends Action {
            public static final int $stable = 0;
            public static final OnFiltersUpdated INSTANCE = new OnFiltersUpdated();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof OnFiltersUpdated)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1716090722;
            }

            public String toString() {
                return "OnFiltersUpdated";
            }

            private OnFiltersUpdated() {
                super(null);
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
        if (action instanceof Action.SearchResultsReceived) {
            return new ReducerResult<>(state, null, 2, null);
        }
        if (action instanceof Action.UpdateFilters) {
            return new ReducerResult<>(State.copy$default(state, null, null, ((Action.UpdateFilters) action).getNewFilters(), false, 11, null), new Effect((Function1) new AnonymousClass2(null)));
        }
        if (action instanceof Action.RemoveFilter) {
            FilesSearchFilters filters = state.getFilters();
            return new ReducerResult<>(State.copy$default(state, null, null, filters != null ? FilesSearchFiltersKt.removed(filters, ((Action.RemoveFilter) action).getChip()) : null, false, 11, null), new Effect((Function1) new AnonymousClass3(null)));
        }
        if (action instanceof Action.ClearFilters) {
            return new ReducerResult<>(State.copy$default(state, null, null, state.getFilters() != null ? new FilesSearchFilters(null, null, null, 7, null) : null, false, 11, null), new Effect((Function1) new AnonymousClass5(null)));
        }
        if (!(action instanceof Action.Error) && !Intrinsics.areEqual(action, Action.OnFiltersUpdated.INSTANCE) && !Intrinsics.areEqual(action, Action.FiltersButtonClicked.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    /* JADX INFO: renamed from: com.box.android.search.presentation.cpl.FilesSearchReducer$reduce$1, reason: invalid class name */
    /* JADX INFO: compiled from: FilesSearchReducer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/search/presentation/cpl/FilesSearchReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.search.presentation.cpl.FilesSearchReducer$reduce$1", f = "FilesSearchReducer.kt", i = {0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {46, 53, 55}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "$this$onSuccess$iv", "it", "$i$f$onSuccess", "$i$a$-onSuccess-FilesSearchReducer$reduce$1$2", "$this$flow", "$this$onError$iv", "it", "$i$f$onError", "$i$a$-onError-FilesSearchReducer$reduce$1$3"}, s = {"L$0", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
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
            AnonymousClass1 anonymousClass1 = FilesSearchReducer.this.new AnonymousClass1(this.$action, this.$state, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Action> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:28:0x00c8  */
        /* JADX WARN: Code duplicated, block: B:30:0x00cc  */
        /* JADX WARN: Code duplicated, block: B:33:0x00f5  */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x00f2, code lost:
        
            if (r1.emit(r6, r18) == r2) goto L32;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r19) {
            /*
                Method dump skipped, instruction units count: 260
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.search.presentation.cpl.FilesSearchReducer.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.box.android.search.presentation.cpl.FilesSearchReducer$reduce$2, reason: invalid class name */
    /* JADX INFO: compiled from: FilesSearchReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/search/presentation/cpl/FilesSearchReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.search.presentation.cpl.FilesSearchReducer$reduce$2", f = "FilesSearchReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Action>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Action> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Action.OnFiltersUpdated.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.box.android.search.presentation.cpl.FilesSearchReducer$reduce$3, reason: invalid class name */
    /* JADX INFO: compiled from: FilesSearchReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/search/presentation/cpl/FilesSearchReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.search.presentation.cpl.FilesSearchReducer$reduce$3", f = "FilesSearchReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function1<Continuation<? super Action>, Object> {
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass3(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Action> continuation) {
            return ((AnonymousClass3) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Action.OnFiltersUpdated.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.box.android.search.presentation.cpl.FilesSearchReducer$reduce$5, reason: invalid class name */
    /* JADX INFO: compiled from: FilesSearchReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/search/presentation/cpl/FilesSearchReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.search.presentation.cpl.FilesSearchReducer$reduce$5", f = "FilesSearchReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass5 extends SuspendLambda implements Function1<Continuation<? super Action>, Object> {
        int label;

        AnonymousClass5(Continuation<? super AnonymousClass5> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass5(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Action> continuation) {
            return ((AnonymousClass5) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Action.OnFiltersUpdated.INSTANCE;
        }
    }
}
