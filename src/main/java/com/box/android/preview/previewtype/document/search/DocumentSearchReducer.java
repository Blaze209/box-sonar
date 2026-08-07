package com.box.android.preview.previewtype.document.search;

import com.box.android.base.compose.ImmutableWrapper;
import com.box.android.base.compose.ImmutableWrapperKt;
import com.box.android.base.models.ButtonState;
import com.box.android.cpl.Effect;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.pspdfkit.document.search.SearchResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DocumentSearchReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0005\u0012\u0013\u0014\u0015\u0016B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$State;", "Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$Action;", "environment", "Lcom/box/android/preview/previewtype/document/search/DocumentSearchEnvironment;", "<init>", "(Lcom/box/android/preview/previewtype/document/search/DocumentSearchEnvironment;)V", "getEnvironment", "()Lcom/box/android/preview/previewtype/document/search/DocumentSearchEnvironment;", "build", "getBuild", "()Lcom/box/android/cpl/Reducable;", "getLaunchSearchEffect", "Lcom/box/android/cpl/Effect;", "searchQuery", "", "state", "State", "SearchState", "Action", "SearchResultsNavigationDirection", "Companion", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DocumentSearchReducer implements Reducable<State, Action> {
    private final Reducable<State, Action> build;
    private final DocumentSearchEnvironment environment;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final String SEARCH_RUNNING_ID = "SEARCH_RUNNING_ID";

    /* JADX INFO: compiled from: DocumentSearchReducer.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$SearchResultsNavigationDirection;", "", "<init>", "(Ljava/lang/String;I)V", "UP", "DOWN", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum SearchResultsNavigationDirection {
        UP,
        DOWN;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<SearchResultsNavigationDirection> getEntries() {
            return $ENTRIES;
        }
    }

    public DocumentSearchReducer(DocumentSearchEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        this.build = new Reduce(new Function2() { // from class: com.box.android.preview.previewtype.document.search.DocumentSearchReducer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return DocumentSearchReducer.build$lambda$0(this.f$0, (DocumentSearchReducer.State) obj, (DocumentSearchReducer.Action) obj2);
            }
        });
    }

    public final DocumentSearchEnvironment getEnvironment() {
        return this.environment;
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: DocumentSearchReducer.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003J;\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$State;", "", "pagesCount", "", "currentPageNumber", "searchQuery", "", "searchState", "Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$SearchState;", "navigationButtonsState", "Lcom/box/android/base/models/ButtonState;", "<init>", "(IILjava/lang/String;Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$SearchState;Lcom/box/android/base/models/ButtonState;)V", "getPagesCount", "()I", "getCurrentPageNumber", "getSearchQuery", "()Ljava/lang/String;", "getSearchState", "()Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$SearchState;", "getNavigationButtonsState", "()Lcom/box/android/base/models/ButtonState;", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 0;
        private final int currentPageNumber;
        private final ButtonState navigationButtonsState;
        private final int pagesCount;
        private final String searchQuery;
        private final SearchState searchState;

        public static /* synthetic */ State copy$default(State state, int i, int i2, String str, SearchState searchState, ButtonState buttonState, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = state.pagesCount;
            }
            if ((i3 & 2) != 0) {
                i2 = state.currentPageNumber;
            }
            if ((i3 & 4) != 0) {
                str = state.searchQuery;
            }
            if ((i3 & 8) != 0) {
                searchState = state.searchState;
            }
            if ((i3 & 16) != 0) {
                buttonState = state.navigationButtonsState;
            }
            ButtonState buttonState2 = buttonState;
            String str2 = str;
            return state.copy(i, i2, str2, searchState, buttonState2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getPagesCount() {
            return this.pagesCount;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getCurrentPageNumber() {
            return this.currentPageNumber;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getSearchQuery() {
            return this.searchQuery;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final SearchState getSearchState() {
            return this.searchState;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final ButtonState getNavigationButtonsState() {
            return this.navigationButtonsState;
        }

        public final State copy(int pagesCount, int currentPageNumber, String searchQuery, SearchState searchState, ButtonState navigationButtonsState) {
            Intrinsics.checkNotNullParameter(searchQuery, "searchQuery");
            Intrinsics.checkNotNullParameter(searchState, "searchState");
            Intrinsics.checkNotNullParameter(navigationButtonsState, "navigationButtonsState");
            return new State(pagesCount, currentPageNumber, searchQuery, searchState, navigationButtonsState);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return this.pagesCount == state.pagesCount && this.currentPageNumber == state.currentPageNumber && Intrinsics.areEqual(this.searchQuery, state.searchQuery) && Intrinsics.areEqual(this.searchState, state.searchState) && this.navigationButtonsState == state.navigationButtonsState;
        }

        public int hashCode() {
            return (((((((Integer.hashCode(this.pagesCount) * 31) + Integer.hashCode(this.currentPageNumber)) * 31) + this.searchQuery.hashCode()) * 31) + this.searchState.hashCode()) * 31) + this.navigationButtonsState.hashCode();
        }

        public String toString() {
            return "State(pagesCount=" + this.pagesCount + ", currentPageNumber=" + this.currentPageNumber + ", searchQuery=" + this.searchQuery + ", searchState=" + this.searchState + ", navigationButtonsState=" + this.navigationButtonsState + ")";
        }

        public State(int i, int i2, String searchQuery, SearchState searchState, ButtonState navigationButtonsState) {
            Intrinsics.checkNotNullParameter(searchQuery, "searchQuery");
            Intrinsics.checkNotNullParameter(searchState, "searchState");
            Intrinsics.checkNotNullParameter(navigationButtonsState, "navigationButtonsState");
            this.pagesCount = i;
            this.currentPageNumber = i2;
            this.searchQuery = searchQuery;
            this.searchState = searchState;
            this.navigationButtonsState = navigationButtonsState;
        }

        public final int getPagesCount() {
            return this.pagesCount;
        }

        public final int getCurrentPageNumber() {
            return this.currentPageNumber;
        }

        public /* synthetic */ State(int i, int i2, String str, SearchState.NotStarted notStarted, ButtonState buttonState, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, i2, (i3 & 4) != 0 ? "" : str, (i3 & 8) != 0 ? SearchState.NotStarted.INSTANCE : notStarted, (i3 & 16) != 0 ? ButtonState.DISABLED : buttonState);
        }

        public final String getSearchQuery() {
            return this.searchQuery;
        }

        public final SearchState getSearchState() {
            return this.searchState;
        }

        public final ButtonState getNavigationButtonsState() {
            return this.navigationButtonsState;
        }
    }

    /* JADX INFO: compiled from: DocumentSearchReducer.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$SearchState;", "", "<init>", "()V", "NotStarted", "InProgress", "NothingFound", "Results", "Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$SearchState$InProgress;", "Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$SearchState$NotStarted;", "Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$SearchState$NothingFound;", "Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$SearchState$Results;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class SearchState {
        public static final int $stable = 0;

        public /* synthetic */ SearchState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: DocumentSearchReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$SearchState$NotStarted;", "Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$SearchState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class NotStarted extends SearchState {
            public static final int $stable = 0;
            public static final NotStarted INSTANCE = new NotStarted();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof NotStarted)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 284621676;
            }

            public String toString() {
                return "NotStarted";
            }

            private NotStarted() {
                super(null);
            }
        }

        private SearchState() {
        }

        /* JADX INFO: compiled from: DocumentSearchReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$SearchState$InProgress;", "Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$SearchState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class InProgress extends SearchState {
            public static final int $stable = 0;
            public static final InProgress INSTANCE = new InProgress();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof InProgress)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 2068205488;
            }

            public String toString() {
                return "InProgress";
            }

            private InProgress() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: DocumentSearchReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$SearchState$NothingFound;", "Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$SearchState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class NothingFound extends SearchState {
            public static final int $stable = 0;
            public static final NothingFound INSTANCE = new NothingFound();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof NothingFound)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -58830477;
            }

            public String toString() {
                return "NothingFound";
            }

            private NothingFound() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: DocumentSearchReducer.kt */
        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0007HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$SearchState$Results;", "Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$SearchState;", "results", "Lcom/box/android/base/compose/ImmutableWrapper;", "", "Lcom/pspdfkit/document/search/SearchResult;", "selectedResultIndex", "", "<init>", "(Lcom/box/android/base/compose/ImmutableWrapper;I)V", "getResults", "()Lcom/box/android/base/compose/ImmutableWrapper;", "getSelectedResultIndex", "()I", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Results extends SearchState {
            public static final int $stable = 0;
            private final ImmutableWrapper<List<SearchResult>> results;
            private final int selectedResultIndex;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Results copy$default(Results results, ImmutableWrapper immutableWrapper, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    immutableWrapper = results.results;
                }
                if ((i2 & 2) != 0) {
                    i = results.selectedResultIndex;
                }
                return results.copy(immutableWrapper, i);
            }

            public final ImmutableWrapper<List<SearchResult>> component1() {
                return this.results;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final int getSelectedResultIndex() {
                return this.selectedResultIndex;
            }

            public final Results copy(ImmutableWrapper<List<SearchResult>> results, int selectedResultIndex) {
                Intrinsics.checkNotNullParameter(results, "results");
                return new Results(results, selectedResultIndex);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Results)) {
                    return false;
                }
                Results results = (Results) other;
                return Intrinsics.areEqual(this.results, results.results) && this.selectedResultIndex == results.selectedResultIndex;
            }

            public int hashCode() {
                return (this.results.hashCode() * 31) + Integer.hashCode(this.selectedResultIndex);
            }

            public String toString() {
                return "Results(results=" + this.results + ", selectedResultIndex=" + this.selectedResultIndex + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Results(ImmutableWrapper<List<SearchResult>> results, int i) {
                super(null);
                Intrinsics.checkNotNullParameter(results, "results");
                this.results = results;
                this.selectedResultIndex = i;
            }

            public final ImmutableWrapper<List<SearchResult>> getResults() {
                return this.results;
            }

            public final int getSelectedResultIndex() {
                return this.selectedResultIndex;
            }
        }
    }

    /* JADX INFO: compiled from: DocumentSearchReducer.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0006\n\u000b\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$Action;", "", "<init>", "()V", "SearchQueryChanged", "SearchResultsUpdated", "NavigateClicked", "ClearClicked", "CloseSearchClicked", "PageNumberUpdated", "Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$Action$ClearClicked;", "Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$Action$CloseSearchClicked;", "Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$Action$NavigateClicked;", "Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$Action$PageNumberUpdated;", "Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$Action$SearchQueryChanged;", "Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$Action$SearchResultsUpdated;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: DocumentSearchReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$Action$SearchQueryChanged;", "Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$Action;", "newQuery", "", "<init>", "(Ljava/lang/String;)V", "getNewQuery", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SearchQueryChanged extends Action {
            public static final int $stable = 0;
            private final String newQuery;

            public static /* synthetic */ SearchQueryChanged copy$default(SearchQueryChanged searchQueryChanged, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = searchQueryChanged.newQuery;
                }
                return searchQueryChanged.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getNewQuery() {
                return this.newQuery;
            }

            public final SearchQueryChanged copy(String newQuery) {
                Intrinsics.checkNotNullParameter(newQuery, "newQuery");
                return new SearchQueryChanged(newQuery);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SearchQueryChanged) && Intrinsics.areEqual(this.newQuery, ((SearchQueryChanged) other).newQuery);
            }

            public int hashCode() {
                return this.newQuery.hashCode();
            }

            public String toString() {
                return "SearchQueryChanged(newQuery=" + this.newQuery + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SearchQueryChanged(String newQuery) {
                super(null);
                Intrinsics.checkNotNullParameter(newQuery, "newQuery");
                this.newQuery = newQuery;
            }

            public final String getNewQuery() {
                return this.newQuery;
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: DocumentSearchReducer.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$Action$SearchResultsUpdated;", "Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$Action;", "results", "", "Lcom/pspdfkit/document/search/SearchResult;", "<init>", "(Ljava/util/List;)V", "getResults", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SearchResultsUpdated extends Action {
            public static final int $stable = 8;
            private final List<SearchResult> results;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ SearchResultsUpdated copy$default(SearchResultsUpdated searchResultsUpdated, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = searchResultsUpdated.results;
                }
                return searchResultsUpdated.copy(list);
            }

            public final List<SearchResult> component1() {
                return this.results;
            }

            public final SearchResultsUpdated copy(List<SearchResult> results) {
                Intrinsics.checkNotNullParameter(results, "results");
                return new SearchResultsUpdated(results);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SearchResultsUpdated) && Intrinsics.areEqual(this.results, ((SearchResultsUpdated) other).results);
            }

            public int hashCode() {
                return this.results.hashCode();
            }

            public String toString() {
                return "SearchResultsUpdated(results=" + this.results + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SearchResultsUpdated(List<SearchResult> results) {
                super(null);
                Intrinsics.checkNotNullParameter(results, "results");
                this.results = results;
            }

            public final List<SearchResult> getResults() {
                return this.results;
            }
        }

        /* JADX INFO: compiled from: DocumentSearchReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$Action$NavigateClicked;", "Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$Action;", "direction", "Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$SearchResultsNavigationDirection;", "<init>", "(Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$SearchResultsNavigationDirection;)V", "getDirection", "()Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$SearchResultsNavigationDirection;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class NavigateClicked extends Action {
            public static final int $stable = 0;
            private final SearchResultsNavigationDirection direction;

            public static /* synthetic */ NavigateClicked copy$default(NavigateClicked navigateClicked, SearchResultsNavigationDirection searchResultsNavigationDirection, int i, Object obj) {
                if ((i & 1) != 0) {
                    searchResultsNavigationDirection = navigateClicked.direction;
                }
                return navigateClicked.copy(searchResultsNavigationDirection);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final SearchResultsNavigationDirection getDirection() {
                return this.direction;
            }

            public final NavigateClicked copy(SearchResultsNavigationDirection direction) {
                Intrinsics.checkNotNullParameter(direction, "direction");
                return new NavigateClicked(direction);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof NavigateClicked) && this.direction == ((NavigateClicked) other).direction;
            }

            public int hashCode() {
                return this.direction.hashCode();
            }

            public String toString() {
                return "NavigateClicked(direction=" + this.direction + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NavigateClicked(SearchResultsNavigationDirection direction) {
                super(null);
                Intrinsics.checkNotNullParameter(direction, "direction");
                this.direction = direction;
            }

            public final SearchResultsNavigationDirection getDirection() {
                return this.direction;
            }
        }

        /* JADX INFO: compiled from: DocumentSearchReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$Action$ClearClicked;", "Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ClearClicked extends Action {
            public static final int $stable = 0;
            public static final ClearClicked INSTANCE = new ClearClicked();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ClearClicked)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -554984775;
            }

            public String toString() {
                return "ClearClicked";
            }

            private ClearClicked() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: DocumentSearchReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$Action$CloseSearchClicked;", "Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CloseSearchClicked extends Action {
            public static final int $stable = 0;
            public static final CloseSearchClicked INSTANCE = new CloseSearchClicked();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CloseSearchClicked)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 52351142;
            }

            public String toString() {
                return "CloseSearchClicked";
            }

            private CloseSearchClicked() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: DocumentSearchReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$Action$PageNumberUpdated;", "Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$Action;", "newPage", "", "<init>", "(I)V", "getNewPage", "()I", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class PageNumberUpdated extends Action {
            public static final int $stable = 0;
            private final int newPage;

            public static /* synthetic */ PageNumberUpdated copy$default(PageNumberUpdated pageNumberUpdated, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = pageNumberUpdated.newPage;
                }
                return pageNumberUpdated.copy(i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getNewPage() {
                return this.newPage;
            }

            public final PageNumberUpdated copy(int newPage) {
                return new PageNumberUpdated(newPage);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof PageNumberUpdated) && this.newPage == ((PageNumberUpdated) other).newPage;
            }

            public int hashCode() {
                return Integer.hashCode(this.newPage);
            }

            public String toString() {
                return "PageNumberUpdated(newPage=" + this.newPage + ")";
            }

            public PageNumberUpdated(int i) {
                super(null);
                this.newPage = i;
            }

            public final int getNewPage() {
                return this.newPage;
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReducerResult build$lambda$0(DocumentSearchReducer documentSearchReducer, State state, Action action) {
        State stateCopy$default;
        Effect<Action> effectCancel;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof Action.SearchQueryChanged) {
            Action.SearchQueryChanged searchQueryChanged = (Action.SearchQueryChanged) action;
            boolean zIsBlank = StringsKt.isBlank(searchQueryChanged.getNewQuery());
            State stateCopy$default2 = State.copy$default(state, 0, 0, searchQueryChanged.getNewQuery(), !zIsBlank ? SearchState.InProgress.INSTANCE : SearchState.NotStarted.INSTANCE, !zIsBlank ? state.getNavigationButtonsState() : ButtonState.HIDDEN, 3, null);
            if (!zIsBlank) {
                effectCancel = documentSearchReducer.getLaunchSearchEffect(searchQueryChanged.getNewQuery(), state);
            } else {
                effectCancel = Effect.INSTANCE.cancel(SEARCH_RUNNING_ID);
            }
            return new ReducerResult(stateCopy$default2, effectCancel);
        }
        if (action instanceof Action.SearchResultsUpdated) {
            Action.SearchResultsUpdated searchResultsUpdated = (Action.SearchResultsUpdated) action;
            if (searchResultsUpdated.getResults().isEmpty()) {
                stateCopy$default = State.copy$default(state, 0, 0, null, SearchState.NothingFound.INSTANCE, ButtonState.HIDDEN, 7, null);
            } else {
                stateCopy$default = State.copy$default(state, 0, 0, null, new SearchState.Results(ImmutableWrapperKt.toImmutable(searchResultsUpdated.getResults()), 0), ButtonState.ENABLED, 7, null);
            }
            return new ReducerResult(stateCopy$default, null, 2, null);
        }
        if (action instanceof Action.NavigateClicked) {
            if (!(state.getSearchState() instanceof SearchState.Results)) {
                return new ReducerResult(state, null, 2, null);
            }
            return new ReducerResult(State.copy$default(state, 0, 0, null, SearchState.Results.copy$default((SearchState.Results) state.getSearchState(), null, DocumentSearchUtilsKt.getNextIndex((SearchState.Results) state.getSearchState(), ((Action.NavigateClicked) action).getDirection()), 1, null), null, 23, null), null, 2, null);
        }
        if (action instanceof Action.ClearClicked) {
            return new ReducerResult(State.copy$default(state, 0, 0, "", SearchState.NotStarted.INSTANCE, ButtonState.HIDDEN, 3, null), Effect.INSTANCE.cancel(SEARCH_RUNNING_ID));
        }
        if (action instanceof Action.CloseSearchClicked) {
            return new ReducerResult(state, Effect.INSTANCE.cancel(SEARCH_RUNNING_ID));
        }
        if (action instanceof Action.PageNumberUpdated) {
            return new ReducerResult(State.copy$default(state, 0, ((Action.PageNumberUpdated) action).getNewPage(), null, null, null, 29, null), null, 2, null);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: renamed from: com.box.android.preview.previewtype.document.search.DocumentSearchReducer$getLaunchSearchEffect$1, reason: invalid class name */
    /* JADX INFO: compiled from: DocumentSearchReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.previewtype.document.search.DocumentSearchReducer$getLaunchSearchEffect$1", f = "DocumentSearchReducer.kt", i = {}, l = {111}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Action>, Object> {
        final /* synthetic */ String $searchQuery;
        final /* synthetic */ State $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, State state, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$searchQuery = str;
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return DocumentSearchReducer.this.new AnonymousClass1(this.$searchQuery, this.$state, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Action> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = DocumentSearchReducer.this.getEnvironment().getTextSearchManager().search(this.$searchQuery, this.$state.getCurrentPageNumber() - 1, this.$state.getPagesCount(), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return new Action.SearchResultsUpdated((List) obj);
        }
    }

    private final Effect<Action> getLaunchSearchEffect(String searchQuery, State state) {
        return new Effect((Function1) new AnonymousClass1(searchQuery, state, null)).cancellable(SEARCH_RUNNING_ID, true);
    }

    /* JADX INFO: compiled from: DocumentSearchReducer.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$Companion;", "", "<init>", "()V", "SEARCH_RUNNING_ID", "", "getSEARCH_RUNNING_ID", "()Ljava/lang/String;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getSEARCH_RUNNING_ID() {
            return DocumentSearchReducer.SEARCH_RUNNING_ID;
        }
    }
}
