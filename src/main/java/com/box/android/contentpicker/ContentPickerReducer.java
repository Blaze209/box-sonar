package com.box.android.contentpicker;

import com.box.android.base.presentation.multiselect.SelectionId;
import com.box.android.base.presentation.multiselect.SelectionItemInfo;
import com.box.android.contentpicker.multitabitempicker.ItemPickerTab;
import com.box.android.cpl.Effect;
import com.box.android.cpl.EffectKt;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.ClientSettingsModel;
import com.box.android.domain.utils.result.ResultKt;
import com.pspdfkit.analytics.Analytics;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: ContentPickerReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00122\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u0010\u0011\u0012B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0003H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/box/android/contentpicker/ContentPickerReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/contentpicker/ContentPickerReducer$State;", "Lcom/box/android/contentpicker/ContentPickerReducer$Action;", "environment", "Lcom/box/android/contentpicker/ContentPickerEnvironment;", "<init>", "(Lcom/box/android/contentpicker/ContentPickerEnvironment;)V", "build", "Lcom/box/android/cpl/Reduce;", "getBuild", "()Lcom/box/android/cpl/Reduce;", "reduceContentPicker", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "State", "Action", "Companion", "content-picker_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ContentPickerReducer implements Reducable<State, Action> {
    private static final String OBSERVE_SELECTION_COUNT_ID = "multi_tab_observe_selection_count";
    private final Reduce<State, Action> build;
    private final ContentPickerEnvironment environment;
    public static final int $stable = 8;

    public ContentPickerReducer(ContentPickerEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        this.build = new Reduce<>(new ContentPickerReducer$build$1(this));
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: ContentPickerReducer.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J+\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\rHÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/box/android/contentpicker/ContentPickerReducer$State;", "", "selectedItems", "", "Lcom/box/android/base/presentation/multiselect/SelectionItemInfo;", "enabledTabs", "Lcom/box/android/contentpicker/multitabitempicker/ItemPickerTab;", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getSelectedItems", "()Ljava/util/List;", "getEnabledTabs", "globalSelectionCount", "", "getGlobalSelectionCount", "()I", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "", "content-picker_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final List<ItemPickerTab> enabledTabs;
        private final int globalSelectionCount;
        private final List<SelectionItemInfo> selectedItems;

        /* JADX WARN: Multi-variable type inference failed */
        public State() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, List list, List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = state.selectedItems;
            }
            if ((i & 2) != 0) {
                list2 = state.enabledTabs;
            }
            return state.copy(list, list2);
        }

        public final List<SelectionItemInfo> component1() {
            return this.selectedItems;
        }

        public final List<ItemPickerTab> component2() {
            return this.enabledTabs;
        }

        public final State copy(List<SelectionItemInfo> selectedItems, List<? extends ItemPickerTab> enabledTabs) {
            Intrinsics.checkNotNullParameter(selectedItems, "selectedItems");
            return new State(selectedItems, enabledTabs);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.selectedItems, state.selectedItems) && Intrinsics.areEqual(this.enabledTabs, state.enabledTabs);
        }

        public int hashCode() {
            int iHashCode = this.selectedItems.hashCode() * 31;
            List<ItemPickerTab> list = this.enabledTabs;
            return iHashCode + (list == null ? 0 : list.hashCode());
        }

        public String toString() {
            return "State(selectedItems=" + this.selectedItems + ", enabledTabs=" + this.enabledTabs + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public State(List<SelectionItemInfo> selectedItems, List<? extends ItemPickerTab> list) {
            Intrinsics.checkNotNullParameter(selectedItems, "selectedItems");
            this.selectedItems = selectedItems;
            this.enabledTabs = list;
            this.globalSelectionCount = selectedItems.size();
        }

        public /* synthetic */ State(List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? null : list2);
        }

        public final List<ItemPickerTab> getEnabledTabs() {
            return this.enabledTabs;
        }

        public final List<SelectionItemInfo> getSelectedItems() {
            return this.selectedItems;
        }

        public final int getGlobalSelectionCount() {
            return this.globalSelectionCount;
        }
    }

    /* JADX INFO: compiled from: ContentPickerReducer.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/box/android/contentpicker/ContentPickerReducer$Action;", "", "<init>", "()V", "Initialize", "ObserveSelectionChanges", "ClearSelection", "SelectedItemsChange", "ActiveSelectionScreenChanged", "Lcom/box/android/contentpicker/ContentPickerReducer$Action$ActiveSelectionScreenChanged;", "Lcom/box/android/contentpicker/ContentPickerReducer$Action$ClearSelection;", "Lcom/box/android/contentpicker/ContentPickerReducer$Action$Initialize;", "Lcom/box/android/contentpicker/ContentPickerReducer$Action$ObserveSelectionChanges;", "Lcom/box/android/contentpicker/ContentPickerReducer$Action$SelectedItemsChange;", "content-picker_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: ContentPickerReducer.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/contentpicker/ContentPickerReducer$Action$Initialize;", "Lcom/box/android/contentpicker/ContentPickerReducer$Action;", "requestedTabs", "", "Lcom/box/android/contentpicker/multitabitempicker/ItemPickerTab;", "<init>", "(Ljava/util/List;)V", "getRequestedTabs", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "content-picker_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Initialize extends Action {
            public static final int $stable = 8;
            private final List<ItemPickerTab> requestedTabs;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Initialize copy$default(Initialize initialize, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = initialize.requestedTabs;
                }
                return initialize.copy(list);
            }

            public final List<ItemPickerTab> component1() {
                return this.requestedTabs;
            }

            public final Initialize copy(List<? extends ItemPickerTab> requestedTabs) {
                Intrinsics.checkNotNullParameter(requestedTabs, "requestedTabs");
                return new Initialize(requestedTabs);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Initialize) && Intrinsics.areEqual(this.requestedTabs, ((Initialize) other).requestedTabs);
            }

            public int hashCode() {
                return this.requestedTabs.hashCode();
            }

            public String toString() {
                return "Initialize(requestedTabs=" + this.requestedTabs + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Initialize(List<? extends ItemPickerTab> requestedTabs) {
                super(null);
                Intrinsics.checkNotNullParameter(requestedTabs, "requestedTabs");
                this.requestedTabs = requestedTabs;
            }

            public final List<ItemPickerTab> getRequestedTabs() {
                return this.requestedTabs;
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: ContentPickerReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/contentpicker/ContentPickerReducer$Action$ObserveSelectionChanges;", "Lcom/box/android/contentpicker/ContentPickerReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "content-picker_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ObserveSelectionChanges extends Action {
            public static final int $stable = 0;
            public static final ObserveSelectionChanges INSTANCE = new ObserveSelectionChanges();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ObserveSelectionChanges)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1604607826;
            }

            public String toString() {
                return "ObserveSelectionChanges";
            }

            private ObserveSelectionChanges() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ContentPickerReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/contentpicker/ContentPickerReducer$Action$ClearSelection;", "Lcom/box/android/contentpicker/ContentPickerReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "content-picker_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ClearSelection extends Action {
            public static final int $stable = 0;
            public static final ClearSelection INSTANCE = new ClearSelection();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ClearSelection)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -55443580;
            }

            public String toString() {
                return "ClearSelection";
            }

            private ClearSelection() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ContentPickerReducer.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/contentpicker/ContentPickerReducer$Action$SelectedItemsChange;", "Lcom/box/android/contentpicker/ContentPickerReducer$Action;", "selectedItem", "", "Lcom/box/android/base/presentation/multiselect/SelectionItemInfo;", "<init>", "(Ljava/util/List;)V", "getSelectedItem", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "content-picker_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SelectedItemsChange extends Action {
            public static final int $stable = 8;
            private final List<SelectionItemInfo> selectedItem;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ SelectedItemsChange copy$default(SelectedItemsChange selectedItemsChange, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = selectedItemsChange.selectedItem;
                }
                return selectedItemsChange.copy(list);
            }

            public final List<SelectionItemInfo> component1() {
                return this.selectedItem;
            }

            public final SelectedItemsChange copy(List<SelectionItemInfo> selectedItem) {
                Intrinsics.checkNotNullParameter(selectedItem, "selectedItem");
                return new SelectedItemsChange(selectedItem);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SelectedItemsChange) && Intrinsics.areEqual(this.selectedItem, ((SelectedItemsChange) other).selectedItem);
            }

            public int hashCode() {
                return this.selectedItem.hashCode();
            }

            public String toString() {
                return "SelectedItemsChange(selectedItem=" + this.selectedItem + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SelectedItemsChange(List<SelectionItemInfo> selectedItem) {
                super(null);
                Intrinsics.checkNotNullParameter(selectedItem, "selectedItem");
                this.selectedItem = selectedItem;
            }

            public final List<SelectionItemInfo> getSelectedItem() {
                return this.selectedItem;
            }
        }

        /* JADX INFO: compiled from: ContentPickerReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/contentpicker/ContentPickerReducer$Action$ActiveSelectionScreenChanged;", "Lcom/box/android/contentpicker/ContentPickerReducer$Action;", "screen", "", "<init>", "(Ljava/lang/String;)V", "getScreen", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "content-picker_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ActiveSelectionScreenChanged extends Action {
            public static final int $stable = 0;
            private final String screen;

            public static /* synthetic */ ActiveSelectionScreenChanged copy$default(ActiveSelectionScreenChanged activeSelectionScreenChanged, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = activeSelectionScreenChanged.screen;
                }
                return activeSelectionScreenChanged.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getScreen() {
                return this.screen;
            }

            public final ActiveSelectionScreenChanged copy(String screen) {
                Intrinsics.checkNotNullParameter(screen, "screen");
                return new ActiveSelectionScreenChanged(screen);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ActiveSelectionScreenChanged) && Intrinsics.areEqual(this.screen, ((ActiveSelectionScreenChanged) other).screen);
            }

            public int hashCode() {
                return this.screen.hashCode();
            }

            public String toString() {
                return "ActiveSelectionScreenChanged(screen=" + this.screen + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ActiveSelectionScreenChanged(String screen) {
                super(null);
                Intrinsics.checkNotNullParameter(screen, "screen");
                this.screen = screen;
            }

            public final String getScreen() {
                return this.screen;
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final ReducerResult<State, Action> reduceContentPicker(State state, Action action) {
        ArrayList requestedTabs;
        int i = 2;
        Effect effect = null;
        if (action instanceof Action.Initialize) {
            ClientSettingsModel clientSettingsModel = (ClientSettingsModel) ResultKt.getOrNull(this.environment.getClientSettingsService().getClientSettingsLocal());
            if (clientSettingsModel != null ? Intrinsics.areEqual((Object) clientSettingsModel.isHubsAIEnabled(), (Object) true) : false) {
                requestedTabs = ((Action.Initialize) action).getRequestedTabs();
            } else {
                List<ItemPickerTab> requestedTabs2 = ((Action.Initialize) action).getRequestedTabs();
                ArrayList arrayList = new ArrayList();
                for (Object obj : requestedTabs2) {
                    if ((((ItemPickerTab) obj) != ItemPickerTab.HUBS) != false) {
                        arrayList.add(obj);
                    }
                }
                requestedTabs = arrayList;
            }
            return new ReducerResult<>(State.copy$default(state, null, requestedTabs, 1, null), effect, i, null == true ? 1 : 0);
        }
        if (Intrinsics.areEqual(action, Action.ObserveSelectionChanges.INSTANCE)) {
            final StateFlow<Map<SelectionId, SelectionItemInfo>> selectionsFlow = this.environment.getSelectionManager().getSelectionsFlow();
            return new ReducerResult<>(state, EffectKt.toEffect(new Flow<Action.SelectedItemsChange>() { // from class: com.box.android.contentpicker.ContentPickerReducer$reduceContentPicker$$inlined$map$1

                /* JADX INFO: renamed from: com.box.android.contentpicker.ContentPickerReducer$reduceContentPicker$$inlined$map$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    /* JADX INFO: renamed from: com.box.android.contentpicker.ContentPickerReducer$reduceContentPicker$$inlined$map$1$2$1, reason: invalid class name */
                    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                    @DebugMetadata(c = "com.box.android.contentpicker.ContentPickerReducer$reduceContentPicker$$inlined$map$1$2", f = "ContentPickerReducer.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        int I$0;
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector) {
                        this.$this_unsafeFlow = flowCollector;
                    }

                    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object obj, Continuation continuation) {
                        AnonymousClass1 anonymousClass1;
                        if (continuation instanceof AnonymousClass1) {
                            anonymousClass1 = (AnonymousClass1) continuation;
                            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                                anonymousClass1.label -= Integer.MIN_VALUE;
                            } else {
                                anonymousClass1 = new AnonymousClass1(continuation);
                            }
                        } else {
                            anonymousClass1 = new AnonymousClass1(continuation);
                        }
                        Object obj2 = anonymousClass1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = anonymousClass1.label;
                        if (i == 0) {
                            kotlin.ResultKt.throwOnFailure(obj2);
                            FlowCollector flowCollector = this.$this_unsafeFlow;
                            ContentPickerReducer.Action.SelectedItemsChange selectedItemsChange = new ContentPickerReducer.Action.SelectedItemsChange(CollectionsKt.toList(((Map) obj).values()));
                            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                            anonymousClass1.I$0 = 0;
                            anonymousClass1.label = 1;
                            if (flowCollector.emit(selectedItemsChange, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            int i2 = anonymousClass1.I$0;
                            Object obj3 = anonymousClass1.L$2;
                            Object obj4 = anonymousClass1.L$0;
                            kotlin.ResultKt.throwOnFailure(obj2);
                        }
                        return Unit.INSTANCE;
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super ContentPickerReducer.Action.SelectedItemsChange> flowCollector, Continuation continuation) {
                    Object objCollect = selectionsFlow.collect(new AnonymousClass2(flowCollector), continuation);
                    return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                }
            }).cancellable(OBSERVE_SELECTION_COUNT_ID, true));
        }
        if (Intrinsics.areEqual(action, Action.ClearSelection.INSTANCE)) {
            this.environment.getSelectionManager().clear();
            return new ReducerResult<>(state, null == true ? 1 : 0, i, null == true ? 1 : 0);
        }
        if (action instanceof Action.SelectedItemsChange) {
            return new ReducerResult<>(State.copy$default(state, ((Action.SelectedItemsChange) action).getSelectedItem(), null, 2, null), null == true ? 1 : 0, i, null == true ? 1 : 0);
        }
        if (!(action instanceof Action.ActiveSelectionScreenChanged)) {
            throw new NoWhenBranchMatchedException();
        }
        this.environment.getSelectionManager().setActiveSelectionScreen(((Action.ActiveSelectionScreenChanged) action).getScreen());
        return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new AnonymousClass2(action, null)));
    }

    /* JADX INFO: renamed from: com.box.android.contentpicker.ContentPickerReducer$reduceContentPicker$2, reason: invalid class name */
    /* JADX INFO: compiled from: ContentPickerReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.contentpicker.ContentPickerReducer$reduceContentPicker$2", f = "ContentPickerReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Action $action;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Action action, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.$action = action;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ContentPickerReducer.this.new AnonymousClass2(this.$action, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                kotlin.ResultKt.throwOnFailure(obj);
                ContentPickerReducer.this.environment.getContentPickerAnalytics().logViewChanged(((Action.ActiveSelectionScreenChanged) this.$action).getScreen());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
