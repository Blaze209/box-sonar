package com.box.android.browse.cpl.offlined;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.box.android.boxai.BoxAiCenterReducer;
import com.box.android.browse.cpl.itemsList.ActionableItemsListReducer;
import com.box.android.browse.cpl.itemsList.BottomSheetItemAction;
import com.box.android.browse.cpl.itemsList.FilesDisplayConfigReducer;
import com.box.android.browse.cpl.itemsList.ItemsListReducer;
import com.box.android.cpl.IStoreFactory;
import com.box.android.cpl.Store;
import com.box.android.domain.mappers.FolderModelMapper;
import com.box.androidsdk.content.models.BoxFolder;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OfflinedViewModel.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000e\u001a\u00020\nH\u0002R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/box/android/browse/cpl/offlined/OfflinedViewModel;", "Landroidx/lifecycle/ViewModel;", "offlinedEnvironment", "Lcom/box/android/browse/cpl/offlined/OfflinedEnvironment;", "storeFactory", "Lcom/box/android/cpl/IStoreFactory;", "<init>", "(Lcom/box/android/browse/cpl/offlined/OfflinedEnvironment;Lcom/box/android/cpl/IStoreFactory;)V", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/browse/cpl/offlined/OfflinedReducer$State;", "Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Action;", "getStore", "()Lcom/box/android/cpl/Store;", "getInitialState", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class OfflinedViewModel extends ViewModel {
    public static final int $stable = 8;
    private final Store<OfflinedReducer.State, OfflinedReducer.Action> store;

    @Inject
    public OfflinedViewModel(OfflinedEnvironment offlinedEnvironment, IStoreFactory storeFactory) {
        Intrinsics.checkNotNullParameter(offlinedEnvironment, "offlinedEnvironment");
        Intrinsics.checkNotNullParameter(storeFactory, "storeFactory");
        this.store = storeFactory.create(getInitialState(), new OfflinedReducer(offlinedEnvironment), ViewModelKt.getViewModelScope(this));
    }

    public final Store<OfflinedReducer.State, OfflinedReducer.Action> getStore() {
        return this.store;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final OfflinedReducer.State getInitialState() {
        FolderModelMapper folderModelMapper = FolderModelMapper.INSTANCE;
        BoxFolder boxFolderCreateFromId = BoxFolder.createFromId("-1");
        Intrinsics.checkNotNullExpressionValue(boxFolderCreateFromId, "createFromId(...)");
        ItemsListReducer.State state = new ItemsListReducer.State(null, null, null, FolderModelMapper.toFolderModel$default(folderModelMapper, boxFolderCreateFromId, false, 1, null), false, null, null, false, null, null, new FilesDisplayConfigReducer.State(FilesDisplayConfigReducer.ConfigBarMode.SORT, null, null, null, 14, null), null, null, null, false, false, 64503, null);
        BottomSheetItemAction[] bottomSheetItemActionArr = {BottomSheetItemAction.ViewContainingFolder, BottomSheetItemAction.BoxAi};
        BoxAiCenterReducer.State state2 = null;
        return new OfflinedReducer.State(new ActionableItemsListReducer.State(state, null, null, CollectionsKt.listOf((Object[]) bottomSheetItemActionArr), null, null, 0 == true ? 1 : 0, 0 == true ? 1 : 0, state2, 502, 0 == true ? 1 : 0), null, 0 == true ? 1 : 0, false, 14, 0 == true ? 1 : 0);
    }
}
