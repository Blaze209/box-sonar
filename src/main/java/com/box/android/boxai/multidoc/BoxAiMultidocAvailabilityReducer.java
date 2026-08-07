package com.box.android.boxai.multidoc;

import com.box.android.boxai.BoxAiEnvironment;
import com.box.android.cpl.Effect;
import com.box.android.cpl.EffectKt;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.boxai.AiFileType;
import com.box.android.domain.models.boxai.AiItemAvailabilityStatus;
import com.box.android.domain.models.boxai.AiUnavailabilityReason;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.ItemModelKt;
import com.facebook.react.modules.dialog.AlertFragment;
import com.pspdfkit.analytics.Analytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: BoxAiMultidocAvailabilityReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0004\u0014\u0015\u0016\u0017B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/box/android/boxai/multidoc/BoxAiMultidocAvailabilityReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/boxai/multidoc/BoxAiMultidocAvailabilityReducer$State;", "Lcom/box/android/boxai/multidoc/BoxAiMultidocAvailabilityReducer$Action;", "environment", "Lcom/box/android/boxai/BoxAiEnvironment;", "<init>", "(Lcom/box/android/boxai/BoxAiEnvironment;)V", "getEnvironment", "()Lcom/box/android/boxai/BoxAiEnvironment;", "build", "getBuild", "()Lcom/box/android/cpl/Reducable;", "handleSetSelectedItems", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "Lcom/box/android/boxai/multidoc/BoxAiMultidocAvailabilityReducer$Action$SetSelectedItems;", "isBoxAiMultidocEnabled", "", "ItemsAvailability", "State", "Action", "Companion", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxAiMultidocAvailabilityReducer implements Reducable<State, Action> {
    public static final int MAX_SELECTED_FILES = 10;
    private final Reducable<State, Action> build;
    private final BoxAiEnvironment environment;
    public static final int $stable = 8;

    public BoxAiMultidocAvailabilityReducer(BoxAiEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        this.build = new Reduce(new Function2() { // from class: com.box.android.boxai.multidoc.BoxAiMultidocAvailabilityReducer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return BoxAiMultidocAvailabilityReducer.build$lambda$0(this.f$0, (BoxAiMultidocAvailabilityReducer.State) obj, (BoxAiMultidocAvailabilityReducer.Action) obj2);
            }
        });
    }

    public final BoxAiEnvironment getEnvironment() {
        return this.environment;
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: BoxAiMultidocAvailabilityReducer.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0003¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u001b\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0003HÆ\u0003J5\u0010\u0010\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u001a\b\u0002\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR#\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/box/android/boxai/multidoc/BoxAiMultidocAvailabilityReducer$ItemsAvailability;", "", "availableFiles", "", "Lcom/box/android/domain/models/item/FileModel;", "unavailableItemsWithReasons", "Lkotlin/Pair;", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/domain/models/boxai/AiUnavailabilityReason;", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getAvailableFiles", "()Ljava/util/List;", "getUnavailableItemsWithReasons", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ItemsAvailability {
        public static final int $stable = 8;
        private final List<FileModel> availableFiles;
        private final List<Pair<ItemModel, AiUnavailabilityReason>> unavailableItemsWithReasons;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ItemsAvailability copy$default(ItemsAvailability itemsAvailability, List list, List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = itemsAvailability.availableFiles;
            }
            if ((i & 2) != 0) {
                list2 = itemsAvailability.unavailableItemsWithReasons;
            }
            return itemsAvailability.copy(list, list2);
        }

        public final List<FileModel> component1() {
            return this.availableFiles;
        }

        public final List<Pair<ItemModel, AiUnavailabilityReason>> component2() {
            return this.unavailableItemsWithReasons;
        }

        public final ItemsAvailability copy(List<FileModel> availableFiles, List<? extends Pair<? extends ItemModel, ? extends AiUnavailabilityReason>> unavailableItemsWithReasons) {
            Intrinsics.checkNotNullParameter(availableFiles, "availableFiles");
            Intrinsics.checkNotNullParameter(unavailableItemsWithReasons, "unavailableItemsWithReasons");
            return new ItemsAvailability(availableFiles, unavailableItemsWithReasons);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ItemsAvailability)) {
                return false;
            }
            ItemsAvailability itemsAvailability = (ItemsAvailability) other;
            return Intrinsics.areEqual(this.availableFiles, itemsAvailability.availableFiles) && Intrinsics.areEqual(this.unavailableItemsWithReasons, itemsAvailability.unavailableItemsWithReasons);
        }

        public int hashCode() {
            return (this.availableFiles.hashCode() * 31) + this.unavailableItemsWithReasons.hashCode();
        }

        public String toString() {
            return "ItemsAvailability(availableFiles=" + this.availableFiles + ", unavailableItemsWithReasons=" + this.unavailableItemsWithReasons + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ItemsAvailability(List<FileModel> availableFiles, List<? extends Pair<? extends ItemModel, ? extends AiUnavailabilityReason>> unavailableItemsWithReasons) {
            Intrinsics.checkNotNullParameter(availableFiles, "availableFiles");
            Intrinsics.checkNotNullParameter(unavailableItemsWithReasons, "unavailableItemsWithReasons");
            this.availableFiles = availableFiles;
            this.unavailableItemsWithReasons = unavailableItemsWithReasons;
        }

        public final List<FileModel> getAvailableFiles() {
            return this.availableFiles;
        }

        public final List<Pair<ItemModel, AiUnavailabilityReason>> getUnavailableItemsWithReasons() {
            return this.unavailableItemsWithReasons;
        }
    }

    /* JADX INFO: compiled from: BoxAiMultidocAvailabilityReducer.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u001b\u001a\u00020\u001cJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u0015\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003JT\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020\u00032\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0002\u0010\u000eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0017\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006*"}, d2 = {"Lcom/box/android/boxai/multidoc/BoxAiMultidocAvailabilityReducer$State;", "", "isBoxAiMultidocEnabled", "", "selectedItems", "", "Lcom/box/android/domain/models/item/ItemModel;", "itemStatuses", "", "Lcom/box/android/domain/models/boxai/AiItemAvailabilityStatus;", "observabilityEventSent", "overrideWithAiCenter", "<init>", "(Ljava/lang/Boolean;Ljava/util/List;Ljava/util/Map;ZZ)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSelectedItems", "()Ljava/util/List;", "getItemStatuses", "()Ljava/util/Map;", "getObservabilityEventSent", "()Z", "getOverrideWithAiCenter", "availabilityStatus", "Lcom/box/android/boxai/multidoc/BoxAiMultidocStatus;", "getAvailabilityStatus", "()Lcom/box/android/boxai/multidoc/BoxAiMultidocStatus;", "getAvailableAndUnavailableItems", "Lcom/box/android/boxai/multidoc/BoxAiMultidocAvailabilityReducer$ItemsAvailability;", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/Boolean;Ljava/util/List;Ljava/util/Map;ZZ)Lcom/box/android/boxai/multidoc/BoxAiMultidocAvailabilityReducer$State;", "equals", "other", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final Boolean isBoxAiMultidocEnabled;
        private final Map<ItemModel, AiItemAvailabilityStatus> itemStatuses;
        private final boolean observabilityEventSent;
        private final boolean overrideWithAiCenter;
        private final List<ItemModel> selectedItems;

        public State() {
            this(null, null, null, false, false, 31, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, Boolean bool, List list, Map map, boolean z, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                bool = state.isBoxAiMultidocEnabled;
            }
            if ((i & 2) != 0) {
                list = state.selectedItems;
            }
            if ((i & 4) != 0) {
                map = state.itemStatuses;
            }
            if ((i & 8) != 0) {
                z = state.observabilityEventSent;
            }
            if ((i & 16) != 0) {
                z2 = state.overrideWithAiCenter;
            }
            boolean z3 = z2;
            Map map2 = map;
            return state.copy(bool, list, map2, z, z3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Boolean getIsBoxAiMultidocEnabled() {
            return this.isBoxAiMultidocEnabled;
        }

        public final List<ItemModel> component2() {
            return this.selectedItems;
        }

        public final Map<ItemModel, AiItemAvailabilityStatus> component3() {
            return this.itemStatuses;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getObservabilityEventSent() {
            return this.observabilityEventSent;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getOverrideWithAiCenter() {
            return this.overrideWithAiCenter;
        }

        public final State copy(Boolean isBoxAiMultidocEnabled, List<? extends ItemModel> selectedItems, Map<ItemModel, ? extends AiItemAvailabilityStatus> itemStatuses, boolean observabilityEventSent, boolean overrideWithAiCenter) {
            Intrinsics.checkNotNullParameter(selectedItems, "selectedItems");
            Intrinsics.checkNotNullParameter(itemStatuses, "itemStatuses");
            return new State(isBoxAiMultidocEnabled, selectedItems, itemStatuses, observabilityEventSent, overrideWithAiCenter);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.isBoxAiMultidocEnabled, state.isBoxAiMultidocEnabled) && Intrinsics.areEqual(this.selectedItems, state.selectedItems) && Intrinsics.areEqual(this.itemStatuses, state.itemStatuses) && this.observabilityEventSent == state.observabilityEventSent && this.overrideWithAiCenter == state.overrideWithAiCenter;
        }

        public int hashCode() {
            Boolean bool = this.isBoxAiMultidocEnabled;
            return ((((((((bool == null ? 0 : bool.hashCode()) * 31) + this.selectedItems.hashCode()) * 31) + this.itemStatuses.hashCode()) * 31) + Boolean.hashCode(this.observabilityEventSent)) * 31) + Boolean.hashCode(this.overrideWithAiCenter);
        }

        public String toString() {
            return "State(isBoxAiMultidocEnabled=" + this.isBoxAiMultidocEnabled + ", selectedItems=" + this.selectedItems + ", itemStatuses=" + this.itemStatuses + ", observabilityEventSent=" + this.observabilityEventSent + ", overrideWithAiCenter=" + this.overrideWithAiCenter + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public State(Boolean bool, List<? extends ItemModel> selectedItems, Map<ItemModel, ? extends AiItemAvailabilityStatus> itemStatuses, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(selectedItems, "selectedItems");
            Intrinsics.checkNotNullParameter(itemStatuses, "itemStatuses");
            this.isBoxAiMultidocEnabled = bool;
            this.selectedItems = selectedItems;
            this.itemStatuses = itemStatuses;
            this.observabilityEventSent = z;
            this.overrideWithAiCenter = z2;
        }

        public final Boolean isBoxAiMultidocEnabled() {
            return this.isBoxAiMultidocEnabled;
        }

        public /* synthetic */ State(Boolean bool, List list, Map map, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? MapsKt.emptyMap() : map, (i & 8) != 0 ? false : z, (i & 16) != 0 ? false : z2);
        }

        public final List<ItemModel> getSelectedItems() {
            return this.selectedItems;
        }

        public final Map<ItemModel, AiItemAvailabilityStatus> getItemStatuses() {
            return this.itemStatuses;
        }

        public final boolean getObservabilityEventSent() {
            return this.observabilityEventSent;
        }

        public final boolean getOverrideWithAiCenter() {
            return this.overrideWithAiCenter;
        }

        public final BoxAiMultidocStatus getAvailabilityStatus() {
            if (!Intrinsics.areEqual((Object) this.isBoxAiMultidocEnabled, (Object) true)) {
                return BoxAiMultidocStatus.DISABLED;
            }
            if (this.overrideWithAiCenter) {
                return BoxAiMultidocStatus.AVAILABLE;
            }
            if (this.selectedItems.size() > 10) {
                return BoxAiMultidocStatus.UNAVAILABLE;
            }
            List<ItemModel> list = this.selectedItems;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (this.itemStatuses.get((ItemModel) it.next()) == null) {
                        return BoxAiMultidocStatus.LOADING;
                    }
                }
            }
            List<ItemModel> list2 = this.selectedItems;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                Iterator<T> it2 = list2.iterator();
                while (it2.hasNext()) {
                    if (this.itemStatuses.get((ItemModel) it2.next()) instanceof AiItemAvailabilityStatus.Available) {
                        return BoxAiMultidocStatus.AVAILABLE;
                    }
                }
            }
            return BoxAiMultidocStatus.UNAVAILABLE;
        }

        /* JADX WARN: Code duplicated, block: B:69:0x00b5 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:72:0x007e A[SYNTHETIC] */
        public final ItemsAvailability getAvailableAndUnavailableItems() {
            Object next;
            Pair pair;
            AiUnavailabilityReason reason;
            List<ItemModel> list = this.selectedItems;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AiItemAvailabilityStatus aiItemAvailabilityStatus = this.itemStatuses.get((ItemModel) it.next());
                AiItemAvailabilityStatus.Available available = aiItemAvailabilityStatus instanceof AiItemAvailabilityStatus.Available ? (AiItemAvailabilityStatus.Available) aiItemAvailabilityStatus : null;
                AiFileType fileType = available != null ? available.getFileType() : null;
                if (fileType != null) {
                    arrayList.add(fileType);
                }
            }
            Iterator it2 = arrayList.iterator();
            if (it2.hasNext()) {
                next = it2.next();
                if (it2.hasNext()) {
                    int priority = ((AiFileType) next).getPriority();
                    do {
                        Object next2 = it2.next();
                        int priority2 = ((AiFileType) next2).getPriority();
                        if (priority < priority2) {
                            next = next2;
                            priority = priority2;
                        }
                    } while (it2.hasNext());
                }
            } else {
                next = null;
            }
            AiFileType aiFileType = (AiFileType) next;
            List<ItemModel> list2 = this.selectedItems;
            ArrayList arrayList2 = new ArrayList();
            for (ItemModel itemModel : list2) {
                AiItemAvailabilityStatus aiItemAvailabilityStatus2 = this.itemStatuses.get(itemModel);
                if (aiItemAvailabilityStatus2 instanceof AiItemAvailabilityStatus.Unavailable) {
                    reason = ((AiItemAvailabilityStatus.Unavailable) aiItemAvailabilityStatus2).getReason();
                } else {
                    if (aiItemAvailabilityStatus2 instanceof AiItemAvailabilityStatus.Available) {
                        if (((AiItemAvailabilityStatus.Available) aiItemAvailabilityStatus2).getFileType() != aiFileType) {
                            reason = AiUnavailabilityReason.FILE_TYPE_MIXING_NOT_ALLOWED;
                        }
                        if (pair != null) {
                            arrayList2.add(pair);
                        }
                    } else if (aiItemAvailabilityStatus2 != null) {
                        throw new NoWhenBranchMatchedException();
                    }
                    pair = null;
                    if (pair != null) {
                        arrayList2.add(pair);
                    }
                }
                pair = TuplesKt.to(itemModel, reason);
                if (pair != null) {
                    arrayList2.add(pair);
                }
            }
            ArrayList arrayList3 = arrayList2;
            ArrayList arrayList4 = arrayList3;
            ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, 10));
            Iterator it3 = arrayList4.iterator();
            while (it3.hasNext()) {
                arrayList5.add((ItemModel) ((Pair) it3.next()).component1());
            }
            Set set = CollectionsKt.toSet(arrayList5);
            List<ItemModel> list3 = this.selectedItems;
            ArrayList arrayList6 = new ArrayList();
            for (Object obj : list3) {
                ItemModel itemModel2 = (ItemModel) obj;
                if (!set.contains(itemModel2) && this.itemStatuses.get(itemModel2) != null) {
                    arrayList6.add(obj);
                }
            }
            ArrayList arrayList7 = new ArrayList();
            Iterator it4 = arrayList6.iterator();
            while (it4.hasNext()) {
                FileModel fileModel = ItemModelKt.fileModel((ItemModel) it4.next());
                if (fileModel != null) {
                    arrayList7.add(fileModel);
                }
            }
            return new ItemsAvailability(arrayList7, arrayList3);
        }
    }

    /* JADX INFO: compiled from: BoxAiMultidocAvailabilityReducer.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/boxai/multidoc/BoxAiMultidocAvailabilityReducer$Action;", "", "<init>", "()V", "SetSelectedItems", "EvaluateItem", "SetItemStatus", "AvailabilityUpdated", "Lcom/box/android/boxai/multidoc/BoxAiMultidocAvailabilityReducer$Action$AvailabilityUpdated;", "Lcom/box/android/boxai/multidoc/BoxAiMultidocAvailabilityReducer$Action$EvaluateItem;", "Lcom/box/android/boxai/multidoc/BoxAiMultidocAvailabilityReducer$Action$SetItemStatus;", "Lcom/box/android/boxai/multidoc/BoxAiMultidocAvailabilityReducer$Action$SetSelectedItems;", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: BoxAiMultidocAvailabilityReducer.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/boxai/multidoc/BoxAiMultidocAvailabilityReducer$Action$SetSelectedItems;", "Lcom/box/android/boxai/multidoc/BoxAiMultidocAvailabilityReducer$Action;", AlertFragment.ARG_ITEMS, "", "Lcom/box/android/domain/models/item/ItemModel;", "<init>", "(Ljava/util/List;)V", "getItems", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SetSelectedItems extends Action {
            public static final int $stable = 8;
            private final List<ItemModel> items;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ SetSelectedItems copy$default(SetSelectedItems setSelectedItems, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = setSelectedItems.items;
                }
                return setSelectedItems.copy(list);
            }

            public final List<ItemModel> component1() {
                return this.items;
            }

            public final SetSelectedItems copy(List<? extends ItemModel> items) {
                Intrinsics.checkNotNullParameter(items, "items");
                return new SetSelectedItems(items);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SetSelectedItems) && Intrinsics.areEqual(this.items, ((SetSelectedItems) other).items);
            }

            public int hashCode() {
                return this.items.hashCode();
            }

            public String toString() {
                return "SetSelectedItems(items=" + this.items + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public SetSelectedItems(List<? extends ItemModel> items) {
                super(null);
                Intrinsics.checkNotNullParameter(items, "items");
                this.items = items;
            }

            public final List<ItemModel> getItems() {
                return this.items;
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: BoxAiMultidocAvailabilityReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/boxai/multidoc/BoxAiMultidocAvailabilityReducer$Action$EvaluateItem;", "Lcom/box/android/boxai/multidoc/BoxAiMultidocAvailabilityReducer$Action;", "item", "Lcom/box/android/domain/models/item/ItemModel;", "<init>", "(Lcom/box/android/domain/models/item/ItemModel;)V", "getItem", "()Lcom/box/android/domain/models/item/ItemModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class EvaluateItem extends Action {
            public static final int $stable = 8;
            private final ItemModel item;

            public static /* synthetic */ EvaluateItem copy$default(EvaluateItem evaluateItem, ItemModel itemModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    itemModel = evaluateItem.item;
                }
                return evaluateItem.copy(itemModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ItemModel getItem() {
                return this.item;
            }

            public final EvaluateItem copy(ItemModel item) {
                Intrinsics.checkNotNullParameter(item, "item");
                return new EvaluateItem(item);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof EvaluateItem) && Intrinsics.areEqual(this.item, ((EvaluateItem) other).item);
            }

            public int hashCode() {
                return this.item.hashCode();
            }

            public String toString() {
                return "EvaluateItem(item=" + this.item + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public EvaluateItem(ItemModel item) {
                super(null);
                Intrinsics.checkNotNullParameter(item, "item");
                this.item = item;
            }

            public final ItemModel getItem() {
                return this.item;
            }
        }

        /* JADX INFO: compiled from: BoxAiMultidocAvailabilityReducer.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/box/android/boxai/multidoc/BoxAiMultidocAvailabilityReducer$Action$SetItemStatus;", "Lcom/box/android/boxai/multidoc/BoxAiMultidocAvailabilityReducer$Action;", "item", "Lcom/box/android/domain/models/item/ItemModel;", "status", "Lcom/box/android/domain/models/boxai/AiItemAvailabilityStatus;", "<init>", "(Lcom/box/android/domain/models/item/ItemModel;Lcom/box/android/domain/models/boxai/AiItemAvailabilityStatus;)V", "getItem", "()Lcom/box/android/domain/models/item/ItemModel;", "getStatus", "()Lcom/box/android/domain/models/boxai/AiItemAvailabilityStatus;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SetItemStatus extends Action {
            public static final int $stable = 8;
            private final ItemModel item;
            private final AiItemAvailabilityStatus status;

            public static /* synthetic */ SetItemStatus copy$default(SetItemStatus setItemStatus, ItemModel itemModel, AiItemAvailabilityStatus aiItemAvailabilityStatus, int i, Object obj) {
                if ((i & 1) != 0) {
                    itemModel = setItemStatus.item;
                }
                if ((i & 2) != 0) {
                    aiItemAvailabilityStatus = setItemStatus.status;
                }
                return setItemStatus.copy(itemModel, aiItemAvailabilityStatus);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ItemModel getItem() {
                return this.item;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final AiItemAvailabilityStatus getStatus() {
                return this.status;
            }

            public final SetItemStatus copy(ItemModel item, AiItemAvailabilityStatus status) {
                Intrinsics.checkNotNullParameter(item, "item");
                Intrinsics.checkNotNullParameter(status, "status");
                return new SetItemStatus(item, status);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SetItemStatus)) {
                    return false;
                }
                SetItemStatus setItemStatus = (SetItemStatus) other;
                return Intrinsics.areEqual(this.item, setItemStatus.item) && Intrinsics.areEqual(this.status, setItemStatus.status);
            }

            public int hashCode() {
                return (this.item.hashCode() * 31) + this.status.hashCode();
            }

            public String toString() {
                return "SetItemStatus(item=" + this.item + ", status=" + this.status + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SetItemStatus(ItemModel item, AiItemAvailabilityStatus status) {
                super(null);
                Intrinsics.checkNotNullParameter(item, "item");
                Intrinsics.checkNotNullParameter(status, "status");
                this.item = item;
                this.status = status;
            }

            public final ItemModel getItem() {
                return this.item;
            }

            public final AiItemAvailabilityStatus getStatus() {
                return this.status;
            }
        }

        /* JADX INFO: compiled from: BoxAiMultidocAvailabilityReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/boxai/multidoc/BoxAiMultidocAvailabilityReducer$Action$AvailabilityUpdated;", "Lcom/box/android/boxai/multidoc/BoxAiMultidocAvailabilityReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class AvailabilityUpdated extends Action {
            public static final int $stable = 0;
            public static final AvailabilityUpdated INSTANCE = new AvailabilityUpdated();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof AvailabilityUpdated)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -856878510;
            }

            public String toString() {
                return "AvailabilityUpdated";
            }

            private AvailabilityUpdated() {
                super(null);
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReducerResult build$lambda$0(BoxAiMultidocAvailabilityReducer boxAiMultidocAvailabilityReducer, State state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof Action.SetSelectedItems) {
            return boxAiMultidocAvailabilityReducer.handleSetSelectedItems(state, (Action.SetSelectedItems) action);
        }
        if (action instanceof Action.EvaluateItem) {
            return new ReducerResult(state, EffectKt.toEffect(FlowKt.flow(new BoxAiMultidocAvailabilityReducer$build$1$1(boxAiMultidocAvailabilityReducer, action, null))));
        }
        if (action instanceof Action.SetItemStatus) {
            Action.SetItemStatus setItemStatus = (Action.SetItemStatus) action;
            return new ReducerResult(State.copy$default(state, null, null, MapsKt.plus(state.getItemStatuses(), TuplesKt.to(setItemStatus.getItem(), setItemStatus.getStatus())), false, false, 27, null), new Effect(Action.AvailabilityUpdated.INSTANCE));
        }
        if (!(action instanceof Action.AvailabilityUpdated)) {
            throw new NoWhenBranchMatchedException();
        }
        if (state.getAvailabilityStatus() == BoxAiMultidocStatus.AVAILABLE && !state.getObservabilityEventSent()) {
            return new ReducerResult(State.copy$default(state, null, null, null, true, false, 23, null), Effect.INSTANCE.fireAndForget(new BoxAiMultidocAvailabilityReducer$build$1$2(boxAiMultidocAvailabilityReducer, null)));
        }
        return new ReducerResult(state, null, 2, null);
    }

    private final ReducerResult<State, Action> handleSetSelectedItems(State state, Action.SetSelectedItems action) {
        Effect effectNone;
        boolean zIsBoxAiMultidocEnabled = isBoxAiMultidocEnabled();
        List<ItemModel> items = action.getItems();
        boolean z = !action.getItems().isEmpty() && this.environment.getFeatureFlips().getBoxAiCenterForPreviewAndMultidoc().getEnabled() && this.environment.getBoxAccountSettings().isAxCenterEnabled();
        Boolean boolValueOf = Boolean.valueOf(state.getObservabilityEventSent());
        boolValueOf.booleanValue();
        if (action.getItems().isEmpty()) {
            boolValueOf = null;
        }
        State stateCopy$default = State.copy$default(state, Boolean.valueOf(zIsBoxAiMultidocEnabled), items, null, boolValueOf != null ? boolValueOf.booleanValue() : false, z, 4, null);
        if (zIsBoxAiMultidocEnabled) {
            Effect.Companion companion = Effect.INSTANCE;
            SpreadBuilder spreadBuilder = new SpreadBuilder(2);
            spreadBuilder.add(new Effect(Action.AvailabilityUpdated.INSTANCE));
            List listTake = CollectionsKt.take(action.getItems(), 10);
            ArrayList arrayList = new ArrayList();
            for (Object obj : listTake) {
                if (!state.getItemStatuses().containsKey((ItemModel) obj)) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList3.add(new Effect(new Action.EvaluateItem((ItemModel) it.next())));
            }
            spreadBuilder.addSpread(arrayList3.toArray(new Effect[0]));
            effectNone = companion.merge((Effect[]) spreadBuilder.toArray(new Effect[spreadBuilder.size()]));
        } else {
            effectNone = Effect.INSTANCE.none();
        }
        return new ReducerResult<>(stateCopy$default, effectNone);
    }

    private final boolean isBoxAiMultidocEnabled() {
        return this.environment.getGetBoxAiAvailabilityUseCase().isBoxAiEnabled() && this.environment.getFeatureFlips().getBoxAiMultidoc().getEnabled() && this.environment.getBoxAccountSettings().isBoxAiMultidocEnabled();
    }
}
