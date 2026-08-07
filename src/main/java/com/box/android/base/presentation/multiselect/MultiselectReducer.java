package com.box.android.base.presentation.multiselect;

import com.box.android.cpl.Effect;
import com.box.android.cpl.EffectKt;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import com.box.android.domain.models.hubs.HubModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.androidsdk.content.models.BoxItem;
import com.pspdfkit.analytics.Analytics;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: MultiselectReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0004\u001b\u001c\u001d\u001eB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0002J$\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00152\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0003H\u0016J$\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00152\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001aH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/box/android/base/presentation/multiselect/MultiselectReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/base/presentation/multiselect/MultiselectReducer$State;", "Lcom/box/android/base/presentation/multiselect/MultiselectReducer$Action;", "environment", "Lcom/box/android/base/presentation/multiselect/MultiselectEnvironment;", "<init>", "(Lcom/box/android/base/presentation/multiselect/MultiselectEnvironment;)V", "selectionManager", "Lcom/box/android/base/presentation/multiselect/SelectionManager;", "getSelectionManager", "()Lcom/box/android/base/presentation/multiselect/SelectionManager;", "selections", "", "Lcom/box/android/base/presentation/multiselect/SelectionId;", "", "getSelections", "()Ljava/util/Map;", "currentSelectionInfo", "Lcom/box/android/base/presentation/multiselect/MultiselectReducer$SelectionInfo;", "reduce", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "reduceToggle", "item", "Lcom/box/android/domain/models/DomainModel;", "SelectionInfo", "State", "Action", "Companion", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MultiselectReducer implements Reducable<State, Action> {
    private final MultiselectEnvironment environment;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: MultiselectReducer.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÆ\u0003J\t\u0010\u001d\u001a\u00020\u000bHÆ\u0003JQ\u0010\u001e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\u000b2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0006HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016¨\u0006$"}, d2 = {"Lcom/box/android/base/presentation/multiselect/MultiselectReducer$SelectionInfo;", "", "selectedIds", "", "Lcom/box/android/base/presentation/multiselect/SelectionId;", "numberOfflined", "", "numberNotOfflined", "cumulativePermissions", "Lcom/box/androidsdk/content/models/BoxItem$Permission;", "canExit", "", "allowFolderNavigation", "<init>", "(Ljava/util/Set;IILjava/util/Set;ZZ)V", "getSelectedIds", "()Ljava/util/Set;", "getNumberOfflined", "()I", "getNumberNotOfflined", "getCumulativePermissions", "getCanExit", "()Z", "getAllowFolderNavigation", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class SelectionInfo {
        public static final int $stable = 8;
        private final boolean allowFolderNavigation;
        private final boolean canExit;
        private final Set<BoxItem.Permission> cumulativePermissions;
        private final int numberNotOfflined;
        private final int numberOfflined;
        private final Set<SelectionId> selectedIds;

        public SelectionInfo() {
            this(null, 0, 0, null, false, false, 63, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SelectionInfo copy$default(SelectionInfo selectionInfo, Set set, int i, int i2, Set set2, boolean z, boolean z2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                set = selectionInfo.selectedIds;
            }
            if ((i3 & 2) != 0) {
                i = selectionInfo.numberOfflined;
            }
            if ((i3 & 4) != 0) {
                i2 = selectionInfo.numberNotOfflined;
            }
            if ((i3 & 8) != 0) {
                set2 = selectionInfo.cumulativePermissions;
            }
            if ((i3 & 16) != 0) {
                z = selectionInfo.canExit;
            }
            if ((i3 & 32) != 0) {
                z2 = selectionInfo.allowFolderNavigation;
            }
            boolean z3 = z;
            boolean z4 = z2;
            return selectionInfo.copy(set, i, i2, set2, z3, z4);
        }

        public final Set<SelectionId> component1() {
            return this.selectedIds;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getNumberOfflined() {
            return this.numberOfflined;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getNumberNotOfflined() {
            return this.numberNotOfflined;
        }

        public final Set<BoxItem.Permission> component4() {
            return this.cumulativePermissions;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getCanExit() {
            return this.canExit;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final boolean getAllowFolderNavigation() {
            return this.allowFolderNavigation;
        }

        public final SelectionInfo copy(Set<SelectionId> selectedIds, int numberOfflined, int numberNotOfflined, Set<? extends BoxItem.Permission> cumulativePermissions, boolean canExit, boolean allowFolderNavigation) {
            Intrinsics.checkNotNullParameter(selectedIds, "selectedIds");
            Intrinsics.checkNotNullParameter(cumulativePermissions, "cumulativePermissions");
            return new SelectionInfo(selectedIds, numberOfflined, numberNotOfflined, cumulativePermissions, canExit, allowFolderNavigation);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SelectionInfo)) {
                return false;
            }
            SelectionInfo selectionInfo = (SelectionInfo) other;
            return Intrinsics.areEqual(this.selectedIds, selectionInfo.selectedIds) && this.numberOfflined == selectionInfo.numberOfflined && this.numberNotOfflined == selectionInfo.numberNotOfflined && Intrinsics.areEqual(this.cumulativePermissions, selectionInfo.cumulativePermissions) && this.canExit == selectionInfo.canExit && this.allowFolderNavigation == selectionInfo.allowFolderNavigation;
        }

        public int hashCode() {
            return (((((((((this.selectedIds.hashCode() * 31) + Integer.hashCode(this.numberOfflined)) * 31) + Integer.hashCode(this.numberNotOfflined)) * 31) + this.cumulativePermissions.hashCode()) * 31) + Boolean.hashCode(this.canExit)) * 31) + Boolean.hashCode(this.allowFolderNavigation);
        }

        public String toString() {
            return "SelectionInfo(selectedIds=" + this.selectedIds + ", numberOfflined=" + this.numberOfflined + ", numberNotOfflined=" + this.numberNotOfflined + ", cumulativePermissions=" + this.cumulativePermissions + ", canExit=" + this.canExit + ", allowFolderNavigation=" + this.allowFolderNavigation + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public SelectionInfo(Set<SelectionId> selectedIds, int i, int i2, Set<? extends BoxItem.Permission> cumulativePermissions, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(selectedIds, "selectedIds");
            Intrinsics.checkNotNullParameter(cumulativePermissions, "cumulativePermissions");
            this.selectedIds = selectedIds;
            this.numberOfflined = i;
            this.numberNotOfflined = i2;
            this.cumulativePermissions = cumulativePermissions;
            this.canExit = z;
            this.allowFolderNavigation = z2;
        }

        public /* synthetic */ SelectionInfo(Set set, int i, int i2, Set set2, boolean z, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? SetsKt.emptySet() : set, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? 0 : i2, (i3 & 8) != 0 ? SetsKt.emptySet() : set2, (i3 & 16) != 0 ? true : z, (i3 & 32) != 0 ? false : z2);
        }

        public final Set<SelectionId> getSelectedIds() {
            return this.selectedIds;
        }

        public final int getNumberOfflined() {
            return this.numberOfflined;
        }

        public final int getNumberNotOfflined() {
            return this.numberNotOfflined;
        }

        public final Set<BoxItem.Permission> getCumulativePermissions() {
            return this.cumulativePermissions;
        }

        public final boolean getCanExit() {
            return this.canExit;
        }

        public final boolean getAllowFolderNavigation() {
            return this.allowFolderNavigation;
        }
    }

    public MultiselectReducer(MultiselectEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ Reducable<State, Action> getBuild() {
        return Reducable.DefaultImpls.getBuild(this);
    }

    /* JADX INFO: compiled from: MultiselectReducer.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/box/android/base/presentation/multiselect/MultiselectReducer$State;", "", "<init>", "()V", "Unavailable", "Available", "Selecting", "Lcom/box/android/base/presentation/multiselect/MultiselectReducer$State$Available;", "Lcom/box/android/base/presentation/multiselect/MultiselectReducer$State$Selecting;", "Lcom/box/android/base/presentation/multiselect/MultiselectReducer$State$Unavailable;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class State {
        public static final int $stable = 0;

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: MultiselectReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/base/presentation/multiselect/MultiselectReducer$State$Unavailable;", "Lcom/box/android/base/presentation/multiselect/MultiselectReducer$State;", "<init>", "()V", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Unavailable extends State {
            public static final int $stable = 0;
            public static final Unavailable INSTANCE = new Unavailable();

            private Unavailable() {
                super(null);
            }
        }

        private State() {
        }

        /* JADX INFO: compiled from: MultiselectReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/base/presentation/multiselect/MultiselectReducer$State$Available;", "Lcom/box/android/base/presentation/multiselect/MultiselectReducer$State;", "<init>", "()V", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Available extends State {
            public static final int $stable = 0;
            public static final Available INSTANCE = new Available();

            private Available() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: MultiselectReducer.kt */
        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u0011J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/box/android/base/presentation/multiselect/MultiselectReducer$State$Selecting;", "Lcom/box/android/base/presentation/multiselect/MultiselectReducer$State;", "selectionInfo", "Lcom/box/android/base/presentation/multiselect/MultiselectReducer$SelectionInfo;", "uniqueCancelEffectKey", "", "<init>", "(Lcom/box/android/base/presentation/multiselect/MultiselectReducer$SelectionInfo;Ljava/lang/String;)V", "getSelectionInfo", "()Lcom/box/android/base/presentation/multiselect/MultiselectReducer$SelectionInfo;", "getUniqueCancelEffectKey", "()Ljava/lang/String;", "isItemSelected", "", "selectionId", "Lcom/box/android/base/presentation/multiselect/SelectionId;", "itemCount", "", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "toString", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Selecting extends State {
            public static final int $stable = 8;
            private final SelectionInfo selectionInfo;
            private final String uniqueCancelEffectKey;

            /* JADX WARN: Multi-variable type inference failed */
            public Selecting() {
                this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
            }

            public static /* synthetic */ Selecting copy$default(Selecting selecting, SelectionInfo selectionInfo, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    selectionInfo = selecting.selectionInfo;
                }
                if ((i & 2) != 0) {
                    str = selecting.uniqueCancelEffectKey;
                }
                return selecting.copy(selectionInfo, str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final SelectionInfo getSelectionInfo() {
                return this.selectionInfo;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getUniqueCancelEffectKey() {
                return this.uniqueCancelEffectKey;
            }

            public final Selecting copy(SelectionInfo selectionInfo, String uniqueCancelEffectKey) {
                Intrinsics.checkNotNullParameter(selectionInfo, "selectionInfo");
                Intrinsics.checkNotNullParameter(uniqueCancelEffectKey, "uniqueCancelEffectKey");
                return new Selecting(selectionInfo, uniqueCancelEffectKey);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Selecting)) {
                    return false;
                }
                Selecting selecting = (Selecting) other;
                return Intrinsics.areEqual(this.selectionInfo, selecting.selectionInfo) && Intrinsics.areEqual(this.uniqueCancelEffectKey, selecting.uniqueCancelEffectKey);
            }

            public int hashCode() {
                return (this.selectionInfo.hashCode() * 31) + this.uniqueCancelEffectKey.hashCode();
            }

            public String toString() {
                return "Selecting(selectionInfo=" + this.selectionInfo + ", uniqueCancelEffectKey=" + this.uniqueCancelEffectKey + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Selecting(SelectionInfo selectionInfo, String uniqueCancelEffectKey) {
                super(null);
                Intrinsics.checkNotNullParameter(selectionInfo, "selectionInfo");
                Intrinsics.checkNotNullParameter(uniqueCancelEffectKey, "uniqueCancelEffectKey");
                this.selectionInfo = selectionInfo;
                this.uniqueCancelEffectKey = uniqueCancelEffectKey;
            }

            public /* synthetic */ Selecting(SelectionInfo selectionInfo, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                if ((i & 1) != 0) {
                    selectionInfo = new SelectionInfo(null, 0, 0, null, false, false, 63, null);
                }
                if ((i & 2) != 0) {
                    str = UUID.randomUUID().toString();
                    Intrinsics.checkNotNullExpressionValue(str, "toString(...)");
                }
                this(selectionInfo, str);
            }

            public final SelectionInfo getSelectionInfo() {
                return this.selectionInfo;
            }

            public final String getUniqueCancelEffectKey() {
                return this.uniqueCancelEffectKey;
            }

            public final boolean isItemSelected(SelectionId selectionId) {
                Intrinsics.checkNotNullParameter(selectionId, "selectionId");
                return this.selectionInfo.getSelectedIds().contains(selectionId);
            }

            public final int itemCount() {
                return this.selectionInfo.getSelectedIds().size();
            }
        }
    }

    /* JADX INFO: compiled from: MultiselectReducer.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\b\u0004\u0005\u0006\u0007\b\t\n\u000bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\b\f\r\u000e\u000f\u0010\u0011\u0012\u0013¨\u0006\u0014"}, d2 = {"Lcom/box/android/base/presentation/multiselect/MultiselectReducer$Action;", "", "<init>", "()V", "Toggle", "StartMultiSelectMode", "ExitMultiSelectMode", "MultiSelectModeChanged", "BatchSelect", "SelectionChanged", "DisableMultiSelectMode", "ToggleHub", "Lcom/box/android/base/presentation/multiselect/MultiselectReducer$Action$BatchSelect;", "Lcom/box/android/base/presentation/multiselect/MultiselectReducer$Action$DisableMultiSelectMode;", "Lcom/box/android/base/presentation/multiselect/MultiselectReducer$Action$ExitMultiSelectMode;", "Lcom/box/android/base/presentation/multiselect/MultiselectReducer$Action$MultiSelectModeChanged;", "Lcom/box/android/base/presentation/multiselect/MultiselectReducer$Action$SelectionChanged;", "Lcom/box/android/base/presentation/multiselect/MultiselectReducer$Action$StartMultiSelectMode;", "Lcom/box/android/base/presentation/multiselect/MultiselectReducer$Action$Toggle;", "Lcom/box/android/base/presentation/multiselect/MultiselectReducer$Action$ToggleHub;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: MultiselectReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/base/presentation/multiselect/MultiselectReducer$Action$Toggle;", "Lcom/box/android/base/presentation/multiselect/MultiselectReducer$Action;", "item", "Lcom/box/android/domain/models/item/ItemModel;", "<init>", "(Lcom/box/android/domain/models/item/ItemModel;)V", "getItem", "()Lcom/box/android/domain/models/item/ItemModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Toggle extends Action {
            public static final int $stable = 8;
            private final ItemModel item;

            public static /* synthetic */ Toggle copy$default(Toggle toggle, ItemModel itemModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    itemModel = toggle.item;
                }
                return toggle.copy(itemModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ItemModel getItem() {
                return this.item;
            }

            public final Toggle copy(ItemModel item) {
                Intrinsics.checkNotNullParameter(item, "item");
                return new Toggle(item);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Toggle) && Intrinsics.areEqual(this.item, ((Toggle) other).item);
            }

            public int hashCode() {
                return this.item.hashCode();
            }

            public String toString() {
                return "Toggle(item=" + this.item + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Toggle(ItemModel item) {
                super(null);
                Intrinsics.checkNotNullParameter(item, "item");
                this.item = item;
            }

            public final ItemModel getItem() {
                return this.item;
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: MultiselectReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/base/presentation/multiselect/MultiselectReducer$Action$StartMultiSelectMode;", "Lcom/box/android/base/presentation/multiselect/MultiselectReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class StartMultiSelectMode extends Action {
            public static final int $stable = 0;
            public static final StartMultiSelectMode INSTANCE = new StartMultiSelectMode();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof StartMultiSelectMode)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -392607210;
            }

            public String toString() {
                return "StartMultiSelectMode";
            }

            private StartMultiSelectMode() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: MultiselectReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/base/presentation/multiselect/MultiselectReducer$Action$ExitMultiSelectMode;", "Lcom/box/android/base/presentation/multiselect/MultiselectReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ExitMultiSelectMode extends Action {
            public static final int $stable = 0;
            public static final ExitMultiSelectMode INSTANCE = new ExitMultiSelectMode();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ExitMultiSelectMode)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1195311654;
            }

            public String toString() {
                return "ExitMultiSelectMode";
            }

            private ExitMultiSelectMode() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: MultiselectReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/base/presentation/multiselect/MultiselectReducer$Action$MultiSelectModeChanged;", "Lcom/box/android/base/presentation/multiselect/MultiselectReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class MultiSelectModeChanged extends Action {
            public static final int $stable = 0;
            public static final MultiSelectModeChanged INSTANCE = new MultiSelectModeChanged();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof MultiSelectModeChanged)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1338439868;
            }

            public String toString() {
                return "MultiSelectModeChanged";
            }

            private MultiSelectModeChanged() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: MultiselectReducer.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/base/presentation/multiselect/MultiselectReducer$Action$BatchSelect;", "Lcom/box/android/base/presentation/multiselect/MultiselectReducer$Action;", "selectedItems", "", "Lcom/box/android/domain/models/item/ItemModel;", "<init>", "(Ljava/util/Set;)V", "getSelectedItems", "()Ljava/util/Set;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class BatchSelect extends Action {
            public static final int $stable = 8;
            private final Set<ItemModel> selectedItems;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ BatchSelect copy$default(BatchSelect batchSelect, Set set, int i, Object obj) {
                if ((i & 1) != 0) {
                    set = batchSelect.selectedItems;
                }
                return batchSelect.copy(set);
            }

            public final Set<ItemModel> component1() {
                return this.selectedItems;
            }

            public final BatchSelect copy(Set<? extends ItemModel> selectedItems) {
                Intrinsics.checkNotNullParameter(selectedItems, "selectedItems");
                return new BatchSelect(selectedItems);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof BatchSelect) && Intrinsics.areEqual(this.selectedItems, ((BatchSelect) other).selectedItems);
            }

            public int hashCode() {
                return this.selectedItems.hashCode();
            }

            public String toString() {
                return "BatchSelect(selectedItems=" + this.selectedItems + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public BatchSelect(Set<? extends ItemModel> selectedItems) {
                super(null);
                Intrinsics.checkNotNullParameter(selectedItems, "selectedItems");
                this.selectedItems = selectedItems;
            }

            public final Set<ItemModel> getSelectedItems() {
                return this.selectedItems;
            }
        }

        /* JADX INFO: compiled from: MultiselectReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/base/presentation/multiselect/MultiselectReducer$Action$SelectionChanged;", "Lcom/box/android/base/presentation/multiselect/MultiselectReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SelectionChanged extends Action {
            public static final int $stable = 0;
            public static final SelectionChanged INSTANCE = new SelectionChanged();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SelectionChanged)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1603573640;
            }

            public String toString() {
                return "SelectionChanged";
            }

            private SelectionChanged() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: MultiselectReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/base/presentation/multiselect/MultiselectReducer$Action$DisableMultiSelectMode;", "Lcom/box/android/base/presentation/multiselect/MultiselectReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class DisableMultiSelectMode extends Action {
            public static final int $stable = 0;
            public static final DisableMultiSelectMode INSTANCE = new DisableMultiSelectMode();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof DisableMultiSelectMode)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 715083472;
            }

            public String toString() {
                return "DisableMultiSelectMode";
            }

            private DisableMultiSelectMode() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: MultiselectReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/base/presentation/multiselect/MultiselectReducer$Action$ToggleHub;", "Lcom/box/android/base/presentation/multiselect/MultiselectReducer$Action;", SelectionIdKt.HUB_TYPE, "Lcom/box/android/domain/models/hubs/HubModel;", "<init>", "(Lcom/box/android/domain/models/hubs/HubModel;)V", "getHub", "()Lcom/box/android/domain/models/hubs/HubModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ToggleHub extends Action {
            public static final int $stable = 8;
            private final HubModel hub;

            public static /* synthetic */ ToggleHub copy$default(ToggleHub toggleHub, HubModel hubModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    hubModel = toggleHub.hub;
                }
                return toggleHub.copy(hubModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final HubModel getHub() {
                return this.hub;
            }

            public final ToggleHub copy(HubModel hub) {
                Intrinsics.checkNotNullParameter(hub, "hub");
                return new ToggleHub(hub);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ToggleHub) && Intrinsics.areEqual(this.hub, ((ToggleHub) other).hub);
            }

            public int hashCode() {
                return this.hub.hashCode();
            }

            public String toString() {
                return "ToggleHub(hub=" + this.hub + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ToggleHub(HubModel hub) {
                super(null);
                Intrinsics.checkNotNullParameter(hub, "hub");
                this.hub = hub;
            }

            public final HubModel getHub() {
                return this.hub;
            }
        }
    }

    private final SelectionManager getSelectionManager() {
        return this.environment.getSelectionManager();
    }

    private final Map<SelectionId, Object> getSelections() {
        return getSelectionManager().getSelectionsFlow().getValue();
    }

    private final SelectionInfo currentSelectionInfo() {
        return new SelectionInfo(getSelections().keySet(), getSelectionManager().getNumberOfflined(), getSelectionManager().getNumberNotOfflined(), getSelectionManager().getCumulativePermissions(), getSelectionManager().getCanExit(), getSelectionManager().getAllowFolderNavigation());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.box.android.cpl.Reducable
    public ReducerResult<State, Action> reduce(State state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof Action.Toggle) {
            return reduceToggle(state, ((Action.Toggle) action).getItem());
        }
        if (action instanceof Action.ToggleHub) {
            return reduceToggle(state, ((Action.ToggleHub) action).getHub());
        }
        int i = 2;
        String str = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        if (action instanceof Action.StartMultiSelectMode) {
            State.Selecting selecting = new State.Selecting(currentSelectionInfo(), str, i, objArr3 == true ? 1 : 0);
            final StateFlow<Map<SelectionId, SelectionItemInfo>> selectionsFlow = getSelectionManager().getSelectionsFlow();
            Effect effectCancellable = EffectKt.toEffect(new Flow<Action.SelectionChanged>() { // from class: com.box.android.base.presentation.multiselect.MultiselectReducer$reduce$$inlined$map$1

                /* JADX INFO: renamed from: com.box.android.base.presentation.multiselect.MultiselectReducer$reduce$$inlined$map$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    /* JADX INFO: renamed from: com.box.android.base.presentation.multiselect.MultiselectReducer$reduce$$inlined$map$1$2$1, reason: invalid class name */
                    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                    @DebugMetadata(c = "com.box.android.base.presentation.multiselect.MultiselectReducer$reduce$$inlined$map$1$2", f = "MultiselectReducer.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
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
                            ResultKt.throwOnFailure(obj2);
                            FlowCollector flowCollector = this.$this_unsafeFlow;
                            MultiselectReducer.Action.SelectionChanged selectionChanged = MultiselectReducer.Action.SelectionChanged.INSTANCE;
                            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                            anonymousClass1.I$0 = 0;
                            anonymousClass1.label = 1;
                            if (flowCollector.emit(selectionChanged, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            int i2 = anonymousClass1.I$0;
                            Object obj3 = anonymousClass1.L$2;
                            Object obj4 = anonymousClass1.L$0;
                            ResultKt.throwOnFailure(obj2);
                        }
                        return Unit.INSTANCE;
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super MultiselectReducer.Action.SelectionChanged> flowCollector, Continuation continuation) {
                    Object objCollect = selectionsFlow.collect(new AnonymousClass2(flowCollector), continuation);
                    return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                }
            }).cancellable(INSTANCE.selectionFlowEffectId(selecting.getUniqueCancelEffectKey()), true);
            Intrinsics.checkNotNull(effectCancellable, "null cannot be cast to non-null type com.box.android.cpl.Effect<com.box.android.base.presentation.multiselect.MultiselectReducer.Action>");
            return new ReducerResult<>(selecting, Effect.INSTANCE.merge(new Effect(Action.MultiSelectModeChanged.INSTANCE), effectCancellable));
        }
        if (action instanceof Action.ExitMultiSelectMode) {
            Effect effectCancel = state instanceof State.Selecting ? Effect.INSTANCE.cancel(INSTANCE.selectionFlowEffectId(((State.Selecting) state).getUniqueCancelEffectKey())) : Effect.INSTANCE.none();
            getSelectionManager().clear();
            return new ReducerResult<>(State.Available.INSTANCE, Effect.INSTANCE.merge(new Effect(Action.MultiSelectModeChanged.INSTANCE), effectCancel));
        }
        if (!(action instanceof Action.BatchSelect)) {
            if (action instanceof Action.DisableMultiSelectMode) {
                return new ReducerResult<>(State.Unavailable.INSTANCE, null, 2, null);
            }
            if (action instanceof Action.SelectionChanged) {
                return state instanceof State.Selecting ? new ReducerResult<>(State.Selecting.copy$default((State.Selecting) state, currentSelectionInfo(), null, 2, null), null, 2, null) : new ReducerResult<>(state, null, 2, null);
            }
            return new ReducerResult<>(state, null, 2, null);
        }
        Iterator<T> it = ((Action.BatchSelect) action).getSelectedItems().iterator();
        while (it.hasNext()) {
            getSelectionManager().selectItem((ItemModel) it.next());
        }
        State.Selecting selecting2 = state instanceof State.Selecting ? (State.Selecting) state : null;
        if (selecting2 == null) {
            selecting2 = new State.Selecting(currentSelectionInfo(), objArr2 == true ? 1 : 0, i, objArr == true ? 1 : 0);
        }
        return new ReducerResult<>(State.Selecting.copy$default(selecting2, currentSelectionInfo(), null, 2, null), new Effect(Action.MultiSelectModeChanged.INSTANCE));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final ReducerResult<State, Action> reduceToggle(State state, DomainModel item) {
        int i = 2;
        String str = null;
        Object[] objArr = 0;
        if (Intrinsics.areEqual(state, State.Unavailable.INSTANCE)) {
            return new ReducerResult<>(state, null, 2, null);
        }
        if (Intrinsics.areEqual(state, State.Available.INSTANCE)) {
            getSelectionManager().selectItem(item);
            return new ReducerResult<>(new State.Selecting(currentSelectionInfo(), str, i, objArr == true ? 1 : 0), new Effect(Action.MultiSelectModeChanged.INSTANCE));
        }
        if (!(state instanceof State.Selecting)) {
            throw new NoWhenBranchMatchedException();
        }
        getSelectionManager().toggle(item);
        if (getSelections().isEmpty() && getSelectionManager().getCanExit()) {
            return new ReducerResult<>(State.Available.INSTANCE, new Effect(Action.ExitMultiSelectMode.INSTANCE));
        }
        return new ReducerResult<>(State.Selecting.copy$default((State.Selecting) state, currentSelectionInfo(), null, 2, null), new Effect(Action.MultiSelectModeChanged.INSTANCE));
    }

    /* JADX INFO: compiled from: MultiselectReducer.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\u0007"}, d2 = {"Lcom/box/android/base/presentation/multiselect/MultiselectReducer$Companion;", "", "<init>", "()V", "selectionFlowEffectId", "", "cancelKey", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String selectionFlowEffectId(String cancelKey) {
            Intrinsics.checkNotNullParameter(cancelKey, "cancelKey");
            String str = String.format("SELECTION_FLOW_EFFECT_ID:%s", Arrays.copyOf(new Object[]{cancelKey}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        }
    }
}
