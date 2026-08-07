package com.box.android.browse.cpl.recents;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.box.android.browse.R;
import com.box.android.browse.cpl.itemsList.ActionableItemsListReducer;
import com.box.android.browse.cpl.itemsList.BottomSheetItemAction;
import com.box.android.browse.cpl.itemsList.FilesDisplayConfigReducer;
import com.box.android.browse.cpl.itemsList.ItemsListReducer;
import com.box.android.browse.cpl.itemsList.multiselect.MultiselectMenuAction;
import com.box.android.browse.cpl.itemsList.multiselect.MultiselectMenuActionsVisibility;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.cpl.IStoreFactory;
import com.box.android.cpl.Store;
import com.box.android.domain.mappers.FolderModelMapper;
import com.box.androidsdk.content.models.BoxFolder;
import java.util.LinkedHashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: RecentsViewModel.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000e\u001a\u00020\nH\u0002J\u0013\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002¢\u0006\u0002\u0010\u0012R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/box/android/browse/cpl/recents/RecentsViewModel;", "Landroidx/lifecycle/ViewModel;", "recentsEnvironment", "Lcom/box/android/browse/cpl/recents/RecentsEnvironment;", "storeFactory", "Lcom/box/android/cpl/IStoreFactory;", "<init>", "(Lcom/box/android/browse/cpl/recents/RecentsEnvironment;Lcom/box/android/cpl/IStoreFactory;)V", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/browse/cpl/recents/RecentsReducer$State;", "Lcom/box/android/browse/cpl/recents/RecentsReducer$Action;", "getStore", "()Lcom/box/android/cpl/Store;", "getInitialState", "recentsValidActions", "", "Lcom/box/android/browse/cpl/itemsList/multiselect/MultiselectMenuAction;", "()[Lcom/box/android/browse/cpl/itemsList/multiselect/MultiselectMenuAction;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RecentsViewModel extends ViewModel {
    public static final int $stable = 8;
    private final Store<RecentsReducer.State, RecentsReducer.Action> store;

    @Inject
    public RecentsViewModel(RecentsEnvironment recentsEnvironment, IStoreFactory storeFactory) {
        Intrinsics.checkNotNullParameter(recentsEnvironment, "recentsEnvironment");
        Intrinsics.checkNotNullParameter(storeFactory, "storeFactory");
        this.store = storeFactory.create(getInitialState(), new RecentsReducer(recentsEnvironment), ViewModelKt.getViewModelScope(this));
    }

    public final Store<RecentsReducer.State, RecentsReducer.Action> getStore() {
        return this.store;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final RecentsReducer.State getInitialState() {
        FolderModelMapper folderModelMapper = FolderModelMapper.INSTANCE;
        BoxFolder boxFolderCreateFromIdAndName = BoxFolder.createFromIdAndName(BoxCommonConstants.RECENTS_ROOT_FOLDER_ID, CommonBoxUtil.LS(R.string.recents));
        Intrinsics.checkNotNullExpressionValue(boxFolderCreateFromIdAndName, "createFromIdAndName(...)");
        ItemsListReducer.State state = new ItemsListReducer.State(null, null, null, FolderModelMapper.toFolderModel$default(folderModelMapper, boxFolderCreateFromIdAndName, false, 1, null), false, null, null, false, null, null, new FilesDisplayConfigReducer.State(FilesDisplayConfigReducer.ConfigBarMode.FILTER, null, null, null, 14, null), null, null, null, false, false, 64503, null);
        MultiselectMenuAction[] multiselectMenuActionArrRecentsValidActions = recentsValidActions();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(multiselectMenuActionArrRecentsValidActions.length), 16));
        for (MultiselectMenuAction multiselectMenuAction : multiselectMenuActionArrRecentsValidActions) {
            linkedHashMap.put(multiselectMenuAction, true);
        }
        return new RecentsReducer.State(new ActionableItemsListReducer.State(state, new MultiselectMenuActionsVisibility(linkedHashMap), null, CollectionsKt.listOf((Object[]) new BottomSheetItemAction[]{BottomSheetItemAction.ViewContainingFolder, BottomSheetItemAction.BoxAi}), null, null, null, null, null, 500, null), null == true ? 1 : 0, false, 6, null);
    }

    private final MultiselectMenuAction[] recentsValidActions() {
        return new MultiselectMenuAction[]{MultiselectMenuAction.CopyMove, MultiselectMenuAction.SelectAll, MultiselectMenuAction.SaveOffline, MultiselectMenuAction.RemoveOffline, MultiselectMenuAction.Export, MultiselectMenuAction.DeselectAll};
    }
}
