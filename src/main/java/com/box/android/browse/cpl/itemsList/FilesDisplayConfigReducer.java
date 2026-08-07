package com.box.android.browse.cpl.itemsList;

import com.box.android.browse.cpl.helpers.ItemsFilter;
import com.box.android.browse.utilities.BrowseAnalytics;
import com.box.android.capture.documentscanning.presentation.dialogs.FilterDialog;
import com.box.android.cpl.Effect;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.localrepo.LocalSortPreferences;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FilesDisplayConfigReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u000e\u000f\u0010B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/FilesDisplayConfigReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/browse/cpl/itemsList/FilesDisplayConfigReducer$State;", "Lcom/box/android/browse/cpl/itemsList/FilesDisplayConfigReducer$Action;", "localSortPreferences", "Lcom/box/android/domain/localrepo/LocalSortPreferences;", "analytics", "Lcom/box/android/browse/utilities/BrowseAnalytics;", "<init>", "(Lcom/box/android/domain/localrepo/LocalSortPreferences;Lcom/box/android/browse/utilities/BrowseAnalytics;)V", "build", "Lcom/box/android/cpl/Reduce;", "getBuild", "()Lcom/box/android/cpl/Reduce;", "State", "ConfigBarMode", "Action", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FilesDisplayConfigReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final BrowseAnalytics analytics;
    private final Reduce<State, Action> build;
    private final LocalSortPreferences localSortPreferences;

    /* JADX INFO: compiled from: FilesDisplayConfigReducer.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/FilesDisplayConfigReducer$ConfigBarMode;", "", "<init>", "(Ljava/lang/String;I)V", "FILTER", "SORT", "NONE", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum ConfigBarMode {
        FILTER,
        SORT,
        NONE;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<ConfigBarMode> getEntries() {
            return $ENTRIES;
        }
    }

    public FilesDisplayConfigReducer(LocalSortPreferences localSortPreferences, BrowseAnalytics analytics) {
        Intrinsics.checkNotNullParameter(localSortPreferences, "localSortPreferences");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.localSortPreferences = localSortPreferences;
        this.analytics = analytics;
        this.build = new Reduce<>(new Function2() { // from class: com.box.android.browse.cpl.itemsList.FilesDisplayConfigReducer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return FilesDisplayConfigReducer.build$lambda$0(this.f$0, (FilesDisplayConfigReducer.State) obj, (FilesDisplayConfigReducer.Action) obj2);
            }
        });
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: FilesDisplayConfigReducer.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/box/android/browse/cpl/itemsList/FilesDisplayConfigReducer$State;", "", "configBarMode", "Lcom/box/android/browse/cpl/itemsList/FilesDisplayConfigReducer$ConfigBarMode;", "selectedSortBy", "Lcom/box/android/domain/localrepo/LocalSortPreferences$SortBy;", "selectedSortOrder", "Lcom/box/android/domain/localrepo/LocalSortPreferences$SortOrder;", FilterDialog.SELECTED_FILTER, "Lcom/box/android/browse/cpl/helpers/ItemsFilter;", "<init>", "(Lcom/box/android/browse/cpl/itemsList/FilesDisplayConfigReducer$ConfigBarMode;Lcom/box/android/domain/localrepo/LocalSortPreferences$SortBy;Lcom/box/android/domain/localrepo/LocalSortPreferences$SortOrder;Lcom/box/android/browse/cpl/helpers/ItemsFilter;)V", "getConfigBarMode", "()Lcom/box/android/browse/cpl/itemsList/FilesDisplayConfigReducer$ConfigBarMode;", "getSelectedSortBy", "()Lcom/box/android/domain/localrepo/LocalSortPreferences$SortBy;", "getSelectedSortOrder", "()Lcom/box/android/domain/localrepo/LocalSortPreferences$SortOrder;", "getSelectedFilter", "()Lcom/box/android/browse/cpl/helpers/ItemsFilter;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 0;
        private final ConfigBarMode configBarMode;
        private final ItemsFilter selectedFilter;
        private final LocalSortPreferences.SortBy selectedSortBy;
        private final LocalSortPreferences.SortOrder selectedSortOrder;

        public State() {
            this(null, null, null, null, 15, null);
        }

        public static /* synthetic */ State copy$default(State state, ConfigBarMode configBarMode, LocalSortPreferences.SortBy sortBy, LocalSortPreferences.SortOrder sortOrder, ItemsFilter itemsFilter, int i, Object obj) {
            if ((i & 1) != 0) {
                configBarMode = state.configBarMode;
            }
            if ((i & 2) != 0) {
                sortBy = state.selectedSortBy;
            }
            if ((i & 4) != 0) {
                sortOrder = state.selectedSortOrder;
            }
            if ((i & 8) != 0) {
                itemsFilter = state.selectedFilter;
            }
            return state.copy(configBarMode, sortBy, sortOrder, itemsFilter);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ConfigBarMode getConfigBarMode() {
            return this.configBarMode;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final LocalSortPreferences.SortBy getSelectedSortBy() {
            return this.selectedSortBy;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final LocalSortPreferences.SortOrder getSelectedSortOrder() {
            return this.selectedSortOrder;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final ItemsFilter getSelectedFilter() {
            return this.selectedFilter;
        }

        public final State copy(ConfigBarMode configBarMode, LocalSortPreferences.SortBy selectedSortBy, LocalSortPreferences.SortOrder selectedSortOrder, ItemsFilter selectedFilter) {
            Intrinsics.checkNotNullParameter(configBarMode, "configBarMode");
            Intrinsics.checkNotNullParameter(selectedSortBy, "selectedSortBy");
            Intrinsics.checkNotNullParameter(selectedSortOrder, "selectedSortOrder");
            Intrinsics.checkNotNullParameter(selectedFilter, "selectedFilter");
            return new State(configBarMode, selectedSortBy, selectedSortOrder, selectedFilter);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return this.configBarMode == state.configBarMode && this.selectedSortBy == state.selectedSortBy && this.selectedSortOrder == state.selectedSortOrder && Intrinsics.areEqual(this.selectedFilter, state.selectedFilter);
        }

        public int hashCode() {
            return (((((this.configBarMode.hashCode() * 31) + this.selectedSortBy.hashCode()) * 31) + this.selectedSortOrder.hashCode()) * 31) + this.selectedFilter.hashCode();
        }

        public String toString() {
            return "State(configBarMode=" + this.configBarMode + ", selectedSortBy=" + this.selectedSortBy + ", selectedSortOrder=" + this.selectedSortOrder + ", selectedFilter=" + this.selectedFilter + ")";
        }

        public State(ConfigBarMode configBarMode, LocalSortPreferences.SortBy selectedSortBy, LocalSortPreferences.SortOrder selectedSortOrder, ItemsFilter selectedFilter) {
            Intrinsics.checkNotNullParameter(configBarMode, "configBarMode");
            Intrinsics.checkNotNullParameter(selectedSortBy, "selectedSortBy");
            Intrinsics.checkNotNullParameter(selectedSortOrder, "selectedSortOrder");
            Intrinsics.checkNotNullParameter(selectedFilter, "selectedFilter");
            this.configBarMode = configBarMode;
            this.selectedSortBy = selectedSortBy;
            this.selectedSortOrder = selectedSortOrder;
            this.selectedFilter = selectedFilter;
        }

        public /* synthetic */ State(ConfigBarMode configBarMode, LocalSortPreferences.SortBy sortBy, LocalSortPreferences.SortOrder sortOrder, ItemsFilter.AllRecents allRecents, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? ConfigBarMode.NONE : configBarMode, (i & 2) != 0 ? LocalSortPreferences.SortBy.NAME : sortBy, (i & 4) != 0 ? LocalSortPreferences.SortOrder.ASC : sortOrder, (i & 8) != 0 ? ItemsFilter.AllRecents.INSTANCE : allRecents);
        }

        public final ConfigBarMode getConfigBarMode() {
            return this.configBarMode;
        }

        public final LocalSortPreferences.SortBy getSelectedSortBy() {
            return this.selectedSortBy;
        }

        public final LocalSortPreferences.SortOrder getSelectedSortOrder() {
            return this.selectedSortOrder;
        }

        public final ItemsFilter getSelectedFilter() {
            return this.selectedFilter;
        }
    }

    /* JADX INFO: compiled from: FilesDisplayConfigReducer.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0006\n\u000b\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/FilesDisplayConfigReducer$Action;", "", "<init>", "()V", "Initialize", "SortingClicked", "SortByChanged", "SortDirectionToggled", "FilteringClicked", "FilterSelected", "Lcom/box/android/browse/cpl/itemsList/FilesDisplayConfigReducer$Action$FilterSelected;", "Lcom/box/android/browse/cpl/itemsList/FilesDisplayConfigReducer$Action$FilteringClicked;", "Lcom/box/android/browse/cpl/itemsList/FilesDisplayConfigReducer$Action$Initialize;", "Lcom/box/android/browse/cpl/itemsList/FilesDisplayConfigReducer$Action$SortByChanged;", "Lcom/box/android/browse/cpl/itemsList/FilesDisplayConfigReducer$Action$SortDirectionToggled;", "Lcom/box/android/browse/cpl/itemsList/FilesDisplayConfigReducer$Action$SortingClicked;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Action() {
        }

        /* JADX INFO: compiled from: FilesDisplayConfigReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/FilesDisplayConfigReducer$Action$Initialize;", "Lcom/box/android/browse/cpl/itemsList/FilesDisplayConfigReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
                return 247077989;
            }

            public String toString() {
                return "Initialize";
            }

            private Initialize() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FilesDisplayConfigReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/FilesDisplayConfigReducer$Action$SortingClicked;", "Lcom/box/android/browse/cpl/itemsList/FilesDisplayConfigReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SortingClicked extends Action {
            public static final int $stable = 0;
            public static final SortingClicked INSTANCE = new SortingClicked();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SortingClicked)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1186018392;
            }

            public String toString() {
                return "SortingClicked";
            }

            private SortingClicked() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FilesDisplayConfigReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/FilesDisplayConfigReducer$Action$SortByChanged;", "Lcom/box/android/browse/cpl/itemsList/FilesDisplayConfigReducer$Action;", "selectedSortBy", "Lcom/box/android/domain/localrepo/LocalSortPreferences$SortBy;", "<init>", "(Lcom/box/android/domain/localrepo/LocalSortPreferences$SortBy;)V", "getSelectedSortBy", "()Lcom/box/android/domain/localrepo/LocalSortPreferences$SortBy;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SortByChanged extends Action {
            public static final int $stable = 0;
            private final LocalSortPreferences.SortBy selectedSortBy;

            public static /* synthetic */ SortByChanged copy$default(SortByChanged sortByChanged, LocalSortPreferences.SortBy sortBy, int i, Object obj) {
                if ((i & 1) != 0) {
                    sortBy = sortByChanged.selectedSortBy;
                }
                return sortByChanged.copy(sortBy);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final LocalSortPreferences.SortBy getSelectedSortBy() {
                return this.selectedSortBy;
            }

            public final SortByChanged copy(LocalSortPreferences.SortBy selectedSortBy) {
                Intrinsics.checkNotNullParameter(selectedSortBy, "selectedSortBy");
                return new SortByChanged(selectedSortBy);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SortByChanged) && this.selectedSortBy == ((SortByChanged) other).selectedSortBy;
            }

            public int hashCode() {
                return this.selectedSortBy.hashCode();
            }

            public String toString() {
                return "SortByChanged(selectedSortBy=" + this.selectedSortBy + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SortByChanged(LocalSortPreferences.SortBy selectedSortBy) {
                super(null);
                Intrinsics.checkNotNullParameter(selectedSortBy, "selectedSortBy");
                this.selectedSortBy = selectedSortBy;
            }

            public final LocalSortPreferences.SortBy getSelectedSortBy() {
                return this.selectedSortBy;
            }
        }

        /* JADX INFO: compiled from: FilesDisplayConfigReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/FilesDisplayConfigReducer$Action$SortDirectionToggled;", "Lcom/box/android/browse/cpl/itemsList/FilesDisplayConfigReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SortDirectionToggled extends Action {
            public static final int $stable = 0;
            public static final SortDirectionToggled INSTANCE = new SortDirectionToggled();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SortDirectionToggled)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -19207324;
            }

            public String toString() {
                return "SortDirectionToggled";
            }

            private SortDirectionToggled() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FilesDisplayConfigReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/FilesDisplayConfigReducer$Action$FilteringClicked;", "Lcom/box/android/browse/cpl/itemsList/FilesDisplayConfigReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FilteringClicked extends Action {
            public static final int $stable = 0;
            public static final FilteringClicked INSTANCE = new FilteringClicked();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof FilteringClicked)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1224753038;
            }

            public String toString() {
                return "FilteringClicked";
            }

            private FilteringClicked() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FilesDisplayConfigReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/FilesDisplayConfigReducer$Action$FilterSelected;", "Lcom/box/android/browse/cpl/itemsList/FilesDisplayConfigReducer$Action;", ViewProps.FILTER, "Lcom/box/android/browse/cpl/helpers/ItemsFilter;", "<init>", "(Lcom/box/android/browse/cpl/helpers/ItemsFilter;)V", "getFilter", "()Lcom/box/android/browse/cpl/helpers/ItemsFilter;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FilterSelected extends Action {
            public static final int $stable = 0;
            private final ItemsFilter filter;

            public static /* synthetic */ FilterSelected copy$default(FilterSelected filterSelected, ItemsFilter itemsFilter, int i, Object obj) {
                if ((i & 1) != 0) {
                    itemsFilter = filterSelected.filter;
                }
                return filterSelected.copy(itemsFilter);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ItemsFilter getFilter() {
                return this.filter;
            }

            public final FilterSelected copy(ItemsFilter filter) {
                Intrinsics.checkNotNullParameter(filter, "filter");
                return new FilterSelected(filter);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof FilterSelected) && Intrinsics.areEqual(this.filter, ((FilterSelected) other).filter);
            }

            public int hashCode() {
                return this.filter.hashCode();
            }

            public String toString() {
                return "FilterSelected(filter=" + this.filter + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FilterSelected(ItemsFilter filter) {
                super(null);
                Intrinsics.checkNotNullParameter(filter, "filter");
                this.filter = filter;
            }

            public final ItemsFilter getFilter() {
                return this.filter;
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final ReducerResult build$lambda$0(FilesDisplayConfigReducer filesDisplayConfigReducer, State state, Action action) {
        LocalSortPreferences.SortOrder sortOrder;
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
        if (Intrinsics.areEqual(action, Action.Initialize.INSTANCE)) {
            LocalSortPreferences.SortBy sortBy = filesDisplayConfigReducer.localSortPreferences.getSortBy();
            LocalSortPreferences.SortOrder sortOrder2 = filesDisplayConfigReducer.localSortPreferences.getSortOrder();
            Intrinsics.checkNotNull(sortBy);
            Intrinsics.checkNotNull(sortOrder2);
            return new ReducerResult(State.copy$default(state, null, sortBy, sortOrder2, null, 9, null), effect, i, objArr7 == true ? 1 : 0);
        }
        if (Intrinsics.areEqual(action, Action.SortingClicked.INSTANCE)) {
            return new ReducerResult(state, Effect.INSTANCE.fireAndForget(new FilesDisplayConfigReducer$build$1$1(filesDisplayConfigReducer, null)));
        }
        if (action instanceof Action.SortByChanged) {
            LocalSortPreferences.SortBy selectedSortBy = ((Action.SortByChanged) action).getSelectedSortBy();
            filesDisplayConfigReducer.localSortPreferences.saveSortBy(selectedSortBy);
            return new ReducerResult(State.copy$default(state, null, selectedSortBy, null, null, 13, null), objArr6 == true ? 1 : 0, i, objArr5 == true ? 1 : 0);
        }
        if (Intrinsics.areEqual(action, Action.SortDirectionToggled.INSTANCE)) {
            if (state.getSelectedSortOrder() == LocalSortPreferences.SortOrder.ASC) {
                sortOrder = LocalSortPreferences.SortOrder.DESC;
            } else {
                sortOrder = LocalSortPreferences.SortOrder.ASC;
            }
            LocalSortPreferences.SortOrder sortOrder3 = sortOrder;
            filesDisplayConfigReducer.localSortPreferences.saveSortOrder(sortOrder3);
            return new ReducerResult(State.copy$default(state, null, null, sortOrder3, null, 11, null), objArr4 == true ? 1 : 0, i, objArr3 == true ? 1 : 0);
        }
        if (Intrinsics.areEqual(action, Action.FilteringClicked.INSTANCE)) {
            return new ReducerResult(state, Effect.INSTANCE.fireAndForget(new FilesDisplayConfigReducer$build$1$2(filesDisplayConfigReducer, null)));
        }
        if (!(action instanceof Action.FilterSelected)) {
            throw new NoWhenBranchMatchedException();
        }
        return new ReducerResult(State.copy$default(state, null, null, null, ((Action.FilterSelected) action).getFilter(), 7, null), objArr2 == true ? 1 : 0, i, objArr == true ? 1 : 0);
    }
}
