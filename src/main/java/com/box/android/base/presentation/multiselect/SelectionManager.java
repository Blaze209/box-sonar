package com.box.android.base.presentation.multiselect;

import com.box.android.coreservices.models.BoxAccountManager;
import com.box.android.coreservices.models.BoxModelOfflineManager;
import com.box.android.domain.mappers.ItemModelMapper;
import com.box.android.domain.models.DomainModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.observability.DiagnosisParams;
import com.box.androidsdk.content.models.BoxItem;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: SelectionManager.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200J\u000e\u00101\u001a\u00020.2\u0006\u0010/\u001a\u000200J\u000e\u00102\u001a\u00020.2\u0006\u0010/\u001a\u000200J\u0006\u00103\u001a\u00020.R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u000e0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u00064"}, d2 = {"Lcom/box/android/base/presentation/multiselect/SelectionManager;", "", "offlineManager", "Lcom/box/android/coreservices/models/BoxModelOfflineManager$Manager;", "permissionsManager", "Lcom/box/android/coreservices/models/BoxAccountManager$Manager;", "<init>", "(Lcom/box/android/coreservices/models/BoxModelOfflineManager$Manager;Lcom/box/android/coreservices/models/BoxAccountManager$Manager;)V", "selectionsMap", "", "Lcom/box/android/base/presentation/multiselect/SelectionId;", "Lcom/box/android/base/presentation/multiselect/SelectionItemInfo;", "_selectionsFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "selectionsFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getSelectionsFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "numberOfflined", "", "getNumberOfflined", "()I", "numberNotOfflined", "getNumberNotOfflined", "cumulativePermissions", "", "Lcom/box/androidsdk/content/models/BoxItem$Permission;", "getCumulativePermissions", "()Ljava/util/Set;", "allowFolderNavigation", "", "getAllowFolderNavigation", "()Z", "setAllowFolderNavigation", "(Z)V", "canExit", "getCanExit", "setCanExit", "activeSelectionScreen", "", "getActiveSelectionScreen", "()Ljava/lang/String;", "setActiveSelectionScreen", "(Ljava/lang/String;)V", "toggle", "", "item", "Lcom/box/android/domain/models/DomainModel;", "unselectItem", "selectItem", DiagnosisParams.CLEAR_ON_LOGOUT, "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class SelectionManager {
    public static final int $stable = 8;
    private final MutableStateFlow<Map<SelectionId, SelectionItemInfo>> _selectionsFlow;
    private String activeSelectionScreen;
    private boolean allowFolderNavigation;
    private boolean canExit;
    private final BoxModelOfflineManager.Manager offlineManager;
    private final BoxAccountManager.Manager permissionsManager;
    private final StateFlow<Map<SelectionId, SelectionItemInfo>> selectionsFlow;
    private final Map<SelectionId, SelectionItemInfo> selectionsMap;

    @Inject
    public SelectionManager(BoxModelOfflineManager.Manager offlineManager, BoxAccountManager.Manager permissionsManager) {
        Intrinsics.checkNotNullParameter(offlineManager, "offlineManager");
        Intrinsics.checkNotNullParameter(permissionsManager, "permissionsManager");
        this.offlineManager = offlineManager;
        this.permissionsManager = permissionsManager;
        this.selectionsMap = new LinkedHashMap();
        MutableStateFlow<Map<SelectionId, SelectionItemInfo>> MutableStateFlow = StateFlowKt.MutableStateFlow(MapsKt.emptyMap());
        this._selectionsFlow = MutableStateFlow;
        this.selectionsFlow = FlowKt.asStateFlow(MutableStateFlow);
        this.canExit = true;
    }

    public final StateFlow<Map<SelectionId, SelectionItemInfo>> getSelectionsFlow() {
        return this.selectionsFlow;
    }

    public final int getNumberOfflined() {
        return this.offlineManager.getNumberOfflined();
    }

    public final int getNumberNotOfflined() {
        return this.offlineManager.getNumberNotOfflined();
    }

    public final Set<BoxItem.Permission> getCumulativePermissions() {
        Set<BoxItem.Permission> cumulativePermissions = this.permissionsManager.getCumulativePermissions();
        Intrinsics.checkNotNullExpressionValue(cumulativePermissions, "getCumulativePermissions(...)");
        return cumulativePermissions;
    }

    public final boolean getAllowFolderNavigation() {
        return this.allowFolderNavigation;
    }

    public final void setAllowFolderNavigation(boolean z) {
        this.allowFolderNavigation = z;
    }

    public final boolean getCanExit() {
        return this.canExit;
    }

    public final void setCanExit(boolean z) {
        this.canExit = z;
    }

    public final String getActiveSelectionScreen() {
        return this.activeSelectionScreen;
    }

    public final void setActiveSelectionScreen(String str) {
        this.activeSelectionScreen = str;
    }

    public final void toggle(DomainModel item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (this.selectionsMap.containsKey(SelectionIdKt.toSelectionId(item))) {
            unselectItem(item);
        } else {
            selectItem(item);
        }
    }

    public final void unselectItem(DomainModel item) {
        Intrinsics.checkNotNullParameter(item, "item");
        SelectionId selectionId = SelectionIdKt.toSelectionId(item);
        if (item instanceof ItemModel) {
            BoxItem boxItem$default = ItemModelMapper.toBoxItem$default(ItemModelMapper.INSTANCE, (ItemModel) item, false, 1, null);
            this.offlineManager.removeItem(boxItem$default);
            this.permissionsManager.removeItem(boxItem$default);
        }
        this.selectionsMap.remove(selectionId);
        this._selectionsFlow.setValue(MapsKt.toMap(this.selectionsMap));
    }

    public final void selectItem(DomainModel item) {
        Intrinsics.checkNotNullParameter(item, "item");
        SelectionId selectionId = SelectionIdKt.toSelectionId(item);
        if (item instanceof ItemModel) {
            BoxItem boxItem$default = ItemModelMapper.toBoxItem$default(ItemModelMapper.INSTANCE, (ItemModel) item, false, 1, null);
            this.offlineManager.addItem(boxItem$default);
            this.permissionsManager.addItem(boxItem$default);
        }
        this.selectionsMap.put(selectionId, SelectionManagerKt.toSelectionItemInfo(item, selectionId, this.activeSelectionScreen));
        this._selectionsFlow.setValue(MapsKt.toMap(this.selectionsMap));
    }

    public final void clear() {
        this.offlineManager.clear();
        this.permissionsManager.clear();
        this.selectionsMap.clear();
        this._selectionsFlow.setValue(MapsKt.emptyMap());
    }
}
