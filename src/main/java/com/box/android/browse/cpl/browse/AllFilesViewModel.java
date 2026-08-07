package com.box.android.browse.cpl.browse;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.box.android.base.presentation.multiselect.MultiselectReducer;
import com.box.android.boxai.BoxAiCenterReducer;
import com.box.android.boxai.BoxAiReducer;
import com.box.android.boxai.multidoc.BoxAiMultidocAvailabilityReducer;
import com.box.android.browse.cpl.browse.fab.FilesFabReducer;
import com.box.android.browse.cpl.itemsList.ActionableItemsListReducer;
import com.box.android.browse.cpl.itemsList.BottomSheetItemAction;
import com.box.android.browse.cpl.itemsList.FilesDisplayConfigReducer;
import com.box.android.browse.cpl.itemsList.ItemsListReducer;
import com.box.android.browse.utilities.BoxFeatureBanner;
import com.box.android.cpl.IStoreFactory;
import com.box.android.cpl.IdentifiedList;
import com.box.android.cpl.Store;
import com.box.android.domain.mappers.FolderModelMapper;
import com.box.android.domain.models.item.FolderModel;
import com.box.androidsdk.content.models.BoxFolder;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AllFilesViewModel.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000e\u001a\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/box/android/browse/cpl/browse/AllFilesViewModel;", "Landroidx/lifecycle/ViewModel;", "browseEnvironment", "Lcom/box/android/browse/cpl/browse/BrowseEnvironment;", "storeFactory", "Lcom/box/android/cpl/IStoreFactory;", "<init>", "(Lcom/box/android/browse/cpl/browse/BrowseEnvironment;Lcom/box/android/cpl/IStoreFactory;)V", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$State;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Action;", "getStore", "()Lcom/box/android/cpl/Store;", "getInitialState", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AllFilesViewModel extends ViewModel {
    public static final int $stable = 8;
    private final BrowseEnvironment browseEnvironment;
    private final Store<BrowseReducer.State, BrowseReducer.Action> store;

    @Inject
    public AllFilesViewModel(BrowseEnvironment browseEnvironment, IStoreFactory storeFactory) {
        Intrinsics.checkNotNullParameter(browseEnvironment, "browseEnvironment");
        Intrinsics.checkNotNullParameter(storeFactory, "storeFactory");
        this.browseEnvironment = browseEnvironment;
        this.store = storeFactory.create(getInitialState(), new BrowseReducer(browseEnvironment), ViewModelKt.getViewModelScope(this));
    }

    public final Store<BrowseReducer.State, BrowseReducer.Action> getStore() {
        return this.store;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final BrowseReducer.State getInitialState() {
        BoxFeatureBanner featureBanner = this.browseEnvironment.getActionableItemsListEnvironment().getItemListViewEnvironment().getFeatureBannerUtils().getFeatureBanner(BoxFeatureBanner.CAPTURE.getId());
        FolderModelMapper folderModelMapper = FolderModelMapper.INSTANCE;
        BoxFolder boxFolderCreateFromId = BoxFolder.createFromId("0");
        Intrinsics.checkNotNullExpressionValue(boxFolderCreateFromId, "createFromId(...)");
        FolderModel folderModel$default = FolderModelMapper.toFolderModel$default(folderModelMapper, boxFolderCreateFromId, false, 1, null);
        IdentifiedList identifiedList = null;
        Integer num = null;
        boolean z = false;
        Set set = null;
        boolean z2 = true;
        MultiselectReducer.State state = null;
        ItemsListReducer.RefreshState refreshState = null;
        boolean z3 = false;
        boolean z4 = false;
        Object[] objArr = 0 == true ? 1 : 0;
        Object[] objArr2 = 0 == true ? 1 : 0;
        Object[] objArr3 = 0 == true ? 1 : 0;
        DefaultConstructorMarker defaultConstructorMarker = null;
        ActionableItemsListReducer.State.PermissionRequest permissionRequest = null;
        BoxAiMultidocAvailabilityReducer.State state2 = null;
        BoxAiReducer.State state3 = null;
        BoxAiCenterReducer.State state4 = null;
        Object[] objArr4 = 0 == true ? 1 : 0;
        Object[] objArr5 = 0 == true ? 1 : 0;
        Object[] objArr6 = 0 == true ? 1 : 0;
        return new BrowseReducer.State(new ActionableItemsListReducer.State(new ItemsListReducer.State(null, identifiedList, num, folderModel$default, z, set, featureBanner, z2, state, objArr2, new FilesDisplayConfigReducer.State(FilesDisplayConfigReducer.ConfigBarMode.SORT, null, null, null, 14, null), objArr3, refreshState, objArr, z3, z4, 64311, null), objArr5, permissionRequest, CollectionsKt.listOf(BottomSheetItemAction.BoxAi), objArr6, objArr4, state2, state3, state4, 502, defaultConstructorMarker), null, null, false, new FilesFabReducer.State(folderModel$default, false, false, null, false, false, false, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 510, defaultConstructorMarker), 14, null);
    }
}
