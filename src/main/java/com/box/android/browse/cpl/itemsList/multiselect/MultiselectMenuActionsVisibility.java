package com.box.android.browse.cpl.itemsList.multiselect;

import com.box.android.base.presentation.multiselect.MultiselectEnvironment;
import com.box.android.base.presentation.multiselect.MultiselectReducer;
import com.box.android.boxai.multidoc.BoxAiMultidocAvailabilityReducer;
import com.box.android.boxai.multidoc.BoxAiMultidocStatus;
import com.box.android.browse.cpl.itemsList.ItemsListReducer;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.PermissionsModel;
import com.box.androidsdk.content.models.BoxItem;
import com.pspdfkit.analytics.Analytics;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: MultiselectMenuAction.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u001d\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004J\b\u0010\f\u001a\u00020\rH\u0016J\u0015\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u001f\u0010\u000f\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/multiselect/MultiselectMenuActionsVisibility;", "", "visibility", "", "Lcom/box/android/browse/cpl/itemsList/multiselect/MultiselectMenuAction;", "", "<init>", "(Ljava/util/Map;)V", "getVisibility", "()Ljava/util/Map;", "isVisible", Analytics.Data.ACTION, "toString", "", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "Companion", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MultiselectMenuActionsVisibility {
    private final Map<MultiselectMenuAction, Boolean> visibility;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final Map<MultiselectMenuAction, BoxItem.Permission> menuActionToPermission = MapsKt.mapOf(TuplesKt.to(MultiselectMenuAction.CopyMove, BoxItem.Permission.CAN_DOWNLOAD), TuplesKt.to(MultiselectMenuAction.Delete, BoxItem.Permission.CAN_DELETE), TuplesKt.to(MultiselectMenuAction.Export, BoxItem.Permission.CAN_DOWNLOAD));

    /* JADX WARN: Multi-variable type inference failed */
    public MultiselectMenuActionsVisibility() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MultiselectMenuActionsVisibility copy$default(MultiselectMenuActionsVisibility multiselectMenuActionsVisibility, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = multiselectMenuActionsVisibility.visibility;
        }
        return multiselectMenuActionsVisibility.copy(map);
    }

    public final Map<MultiselectMenuAction, Boolean> component1() {
        return this.visibility;
    }

    public final MultiselectMenuActionsVisibility copy(Map<MultiselectMenuAction, Boolean> visibility) {
        Intrinsics.checkNotNullParameter(visibility, "visibility");
        return new MultiselectMenuActionsVisibility(visibility);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MultiselectMenuActionsVisibility) && Intrinsics.areEqual(this.visibility, ((MultiselectMenuActionsVisibility) other).visibility);
    }

    public int hashCode() {
        return this.visibility.hashCode();
    }

    public MultiselectMenuActionsVisibility(Map<MultiselectMenuAction, Boolean> visibility) {
        Intrinsics.checkNotNullParameter(visibility, "visibility");
        this.visibility = visibility;
    }

    public /* synthetic */ MultiselectMenuActionsVisibility(Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? INSTANCE.allMenuActionsVisible() : map);
    }

    public final Map<MultiselectMenuAction, Boolean> getVisibility() {
        return this.visibility;
    }

    public final boolean isVisible(MultiselectMenuAction action) {
        Boolean bool = this.visibility.get(action);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    /* JADX INFO: compiled from: MultiselectMenuAction.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J?\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\u0010\u0014J\u0014\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00160\u0005H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/multiselect/MultiselectMenuActionsVisibility$Companion;", "", "<init>", "()V", "menuActionToPermission", "", "Lcom/box/android/browse/cpl/itemsList/multiselect/MultiselectMenuAction;", "Lcom/box/androidsdk/content/models/BoxItem$Permission;", "generateFrom", "Lcom/box/android/browse/cpl/itemsList/multiselect/MultiselectMenuActionsVisibility;", "parentFolder", "Lcom/box/android/domain/models/item/FolderModel;", "itemsState", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$State;", "boxAiMultidocAvailabilityState", "Lcom/box/android/boxai/multidoc/BoxAiMultidocAvailabilityReducer$State;", "environment", "Lcom/box/android/base/presentation/multiselect/MultiselectEnvironment;", "validActions", "", "(Lcom/box/android/domain/models/item/FolderModel;Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$State;Lcom/box/android/boxai/multidoc/BoxAiMultidocAvailabilityReducer$State;Lcom/box/android/base/presentation/multiselect/MultiselectEnvironment;[Lcom/box/android/browse/cpl/itemsList/multiselect/MultiselectMenuAction;)Lcom/box/android/browse/cpl/itemsList/multiselect/MultiselectMenuActionsVisibility;", "allMenuActionsVisible", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: MultiselectMenuAction.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[MultiselectMenuAction.values().length];
                try {
                    iArr[MultiselectMenuAction.Export.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[MultiselectMenuAction.Delete.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ MultiselectMenuActionsVisibility generateFrom$default(Companion companion, FolderModel folderModel, ItemsListReducer.State state, BoxAiMultidocAvailabilityReducer.State state2, MultiselectEnvironment multiselectEnvironment, MultiselectMenuAction[] multiselectMenuActionArr, int i, Object obj) {
            if ((i & 1) != 0) {
                folderModel = null;
            }
            if ((i & 16) != 0) {
                multiselectMenuActionArr = MultiselectMenuAction.values();
            }
            return companion.generateFrom(folderModel, state, state2, multiselectEnvironment, multiselectMenuActionArr);
        }

        /* JADX WARN: Code duplicated, block: B:53:0x0113  */
        public final MultiselectMenuActionsVisibility generateFrom(FolderModel parentFolder, ItemsListReducer.State itemsState, BoxAiMultidocAvailabilityReducer.State boxAiMultidocAvailabilityState, MultiselectEnvironment environment, MultiselectMenuAction[] validActions) {
            boolean z;
            PermissionsModel permissions;
            Intrinsics.checkNotNullParameter(itemsState, "itemsState");
            Intrinsics.checkNotNullParameter(boxAiMultidocAvailabilityState, "boxAiMultidocAvailabilityState");
            Intrinsics.checkNotNullParameter(environment, "environment");
            Intrinsics.checkNotNullParameter(validActions, "validActions");
            MultiselectReducer.State multiselect = itemsState.getMultiselect();
            MultiselectReducer.State.Selecting selecting = multiselect instanceof MultiselectReducer.State.Selecting ? (MultiselectReducer.State.Selecting) multiselect : null;
            if (selecting != null) {
                MultiselectReducer.SelectionInfo selectionInfo = selecting.getSelectionInfo();
                LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(validActions.length), 16));
                for (MultiselectMenuAction multiselectMenuAction : validActions) {
                    linkedHashMap.put(multiselectMenuAction, true);
                }
                Map mutableMap = MapsKt.toMutableMap(linkedHashMap);
                mutableMap.put(MultiselectMenuAction.SelectAll, Boolean.valueOf(itemsState.getItems().size() > selecting.itemCount()));
                if (parentFolder != null && (permissions = parentFolder.getPermissions()) != null && !permissions.getCanDownload()) {
                    mutableMap.put(MultiselectMenuAction.SaveOffline, true);
                    mutableMap.put(MultiselectMenuAction.RemoveOffline, false);
                } else {
                    mutableMap.put(MultiselectMenuAction.SaveOffline, Boolean.valueOf(selectionInfo.getNumberNotOfflined() > 0));
                    mutableMap.put(MultiselectMenuAction.RemoveOffline, Boolean.valueOf(selectionInfo.getNumberOfflined() > 0));
                }
                for (MultiselectMenuAction multiselectMenuAction2 : validActions) {
                    BoxItem.Permission permission = (BoxItem.Permission) MultiselectMenuActionsVisibility.menuActionToPermission.get(multiselectMenuAction2);
                    if (permission != null) {
                        boolean zContains = selectionInfo.getCumulativePermissions().contains(permission);
                        int i = WhenMappings.$EnumSwitchMapping$0[multiselectMenuAction2.ordinal()];
                        if (i == 1) {
                            mutableMap.put(multiselectMenuAction2, Boolean.valueOf(zContains && environment.getBoxAccountManagerHelper().isMobileOpenInEnabled()));
                        } else if (i != 2) {
                            mutableMap.put(multiselectMenuAction2, Boolean.valueOf(zContains));
                        } else {
                            if (zContains) {
                                z = true;
                            } else if (parentFolder != null ? parentFolder.isRoot() : false) {
                                z = true;
                            } else {
                                z = false;
                            }
                            mutableMap.put(multiselectMenuAction2, Boolean.valueOf(z));
                        }
                    }
                }
                if (boxAiMultidocAvailabilityState.getAvailabilityStatus() == BoxAiMultidocStatus.DISABLED) {
                    mutableMap.put(MultiselectMenuAction.BoxAi, false);
                }
                return new MultiselectMenuActionsVisibility(mutableMap);
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(validActions.length), 16));
            for (MultiselectMenuAction multiselectMenuAction3 : validActions) {
                linkedHashMap2.put(multiselectMenuAction3, false);
            }
            return new MultiselectMenuActionsVisibility(linkedHashMap2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Map<MultiselectMenuAction, Boolean> allMenuActionsVisible() {
            MultiselectMenuAction[] multiselectMenuActionArrValues = MultiselectMenuAction.values();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(multiselectMenuActionArrValues.length), 16));
            for (MultiselectMenuAction multiselectMenuAction : multiselectMenuActionArrValues) {
                linkedHashMap.put(multiselectMenuAction, true);
            }
            return linkedHashMap;
        }
    }

    public String toString() {
        return CollectionsKt.joinToString$default(this.visibility.entrySet(), ",", null, null, 0, null, null, 62, null);
    }
}
