package com.box.android.cpl.navigation;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.box.android.R;
import com.box.android.browse.cpl.browse.BrowseReducer;
import com.box.android.browse.cpl.itemsList.ActionableItemsListReducer;
import com.box.android.browse.cpl.itemsList.BottomSheetItemAction;
import com.box.android.browse.cpl.itemsList.ItemsListReducer;
import com.box.android.browse.cpl.itemsList.multiselect.MultiselectMenuAction;
import com.box.android.browse.cpl.itemsList.multiselect.MultiselectMenuActionsVisibility;
import com.box.android.browse.cpl.offlined.OfflinedReducer;
import com.box.android.browse.cpl.recents.RecentsReducer;
import com.box.android.browse.utilities.BoxFeatureBanner;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.cpl.IStoreFactory;
import com.box.android.cpl.Store;
import com.box.android.domain.mappers.FolderModelMapper;
import com.box.android.domain.models.item.FolderModel;
import com.box.androidsdk.content.models.BoxFolder;
import java.util.LinkedHashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: NavigationViewModel.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001f\u001a\u00020\nH\u0002J\u0013\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!H\u0002¢\u0006\u0002\u0010#R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR,\u0010\u000e\u001a\u001d\u0012\u0004\u0012\u00020\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u00130\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\rR,\u0010\u0015\u001a\u001d\u0012\u0004\u0012\u00020\u0016\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u00180\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\rR,\u0010\u001a\u001a\u001d\u0012\u0004\u0012\u00020\u001b\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001d0\t¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\r¨\u0006$"}, d2 = {"Lcom/box/android/cpl/navigation/NavigationViewModel;", "Landroidx/lifecycle/ViewModel;", "navigationEnvironment", "Lcom/box/android/cpl/navigation/NavigationEnvironment;", "storeFactory", "Lcom/box/android/cpl/IStoreFactory;", "<init>", "(Lcom/box/android/cpl/navigation/NavigationEnvironment;Lcom/box/android/cpl/IStoreFactory;)V", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/cpl/navigation/NavigationReducer$State;", "Lcom/box/android/cpl/navigation/NavigationReducer$Action;", "getStore", "()Lcom/box/android/cpl/Store;", "browseStore", "Lcom/box/android/browse/cpl/browse/BrowseReducer$State;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Action;", "Lkotlin/ParameterName;", "name", "browseAction", "getBrowseStore", "recentsStore", "Lcom/box/android/browse/cpl/recents/RecentsReducer$State;", "Lcom/box/android/browse/cpl/recents/RecentsReducer$Action;", "recentsAction", "getRecentsStore", "offlinedStore", "Lcom/box/android/browse/cpl/offlined/OfflinedReducer$State;", "Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Action;", "offlinedAction", "getOfflinedStore", "getInitialState", "recentsValidActions", "", "Lcom/box/android/browse/cpl/itemsList/multiselect/MultiselectMenuAction;", "()[Lcom/box/android/browse/cpl/itemsList/multiselect/MultiselectMenuAction;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NavigationViewModel extends ViewModel {
    public static final int $stable = 8;
    private final Store<BrowseReducer.State, BrowseReducer.Action> browseStore;
    private final NavigationEnvironment navigationEnvironment;
    private final Store<OfflinedReducer.State, OfflinedReducer.Action> offlinedStore;
    private final Store<RecentsReducer.State, RecentsReducer.Action> recentsStore;
    private final Store<NavigationReducer.State, NavigationReducer.Action> store;

    @Inject
    public NavigationViewModel(NavigationEnvironment navigationEnvironment, IStoreFactory storeFactory) {
        Intrinsics.checkNotNullParameter(navigationEnvironment, "navigationEnvironment");
        Intrinsics.checkNotNullParameter(storeFactory, "storeFactory");
        this.navigationEnvironment = navigationEnvironment;
        Store<NavigationReducer.State, NavigationReducer.Action> storeCreate = storeFactory.create(getInitialState(), new NavigationReducer(navigationEnvironment), ViewModelKt.getViewModelScope(this));
        this.store = storeCreate;
        this.browseStore = storeCreate.scope(new PropertyReference1Impl() { // from class: com.box.android.cpl.navigation.NavigationViewModel$browseStore$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((NavigationReducer.State) obj).getBrowseState();
            }
        }, NavigationViewModel$browseStore$2.INSTANCE);
        this.recentsStore = storeCreate.scope(new PropertyReference1Impl() { // from class: com.box.android.cpl.navigation.NavigationViewModel$recentsStore$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((NavigationReducer.State) obj).getRecentsState();
            }
        }, NavigationViewModel$recentsStore$2.INSTANCE);
        this.offlinedStore = storeCreate.scope(new PropertyReference1Impl() { // from class: com.box.android.cpl.navigation.NavigationViewModel$offlinedStore$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((NavigationReducer.State) obj).getOfflinedState();
            }
        }, NavigationViewModel$offlinedStore$2.INSTANCE);
    }

    public final Store<NavigationReducer.State, NavigationReducer.Action> getStore() {
        return this.store;
    }

    public final Store<BrowseReducer.State, BrowseReducer.Action> getBrowseStore() {
        return this.browseStore;
    }

    public final Store<RecentsReducer.State, RecentsReducer.Action> getRecentsStore() {
        return this.recentsStore;
    }

    public final Store<OfflinedReducer.State, OfflinedReducer.Action> getOfflinedStore() {
        return this.offlinedStore;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final NavigationReducer.State getInitialState() {
        BoxFeatureBanner featureBanner = this.navigationEnvironment.getBrowseEnvironment().getActionableItemsListEnvironment().getItemListViewEnvironment().getFeatureBannerUtils().getFeatureBanner(BoxFeatureBanner.CAPTURE.getId());
        FolderModelMapper folderModelMapper = FolderModelMapper.INSTANCE;
        BoxFolder boxFolderCreateFromId = BoxFolder.createFromId("0");
        Intrinsics.checkNotNullExpressionValue(boxFolderCreateFromId, "createFromId(...)");
        FolderModel folderModel$default = FolderModelMapper.toFolderModel$default(folderModelMapper, boxFolderCreateFromId, false, 1, null);
        BrowseReducer.State state = new BrowseReducer.State(new ActionableItemsListReducer.State(new ItemsListReducer.State(null, null, null, folderModel$default, false, null, featureBanner, true, null, null, null, null, null, null, false, false, 65335, null), null == true ? 1 : 0, null == true ? 1 : 0, CollectionsKt.listOf(BottomSheetItemAction.BoxAi), null == true ? 1 : 0, null == true ? 1 : 0, null, null, null, 502, null), null, null, false, null == true ? 1 : 0, 30, null);
        FolderModelMapper folderModelMapper2 = FolderModelMapper.INSTANCE;
        BoxFolder boxFolderCreateFromIdAndName = BoxFolder.createFromIdAndName(BoxCommonConstants.RECENTS_ROOT_FOLDER_ID, CommonBoxUtil.LS(R.string.recents));
        Intrinsics.checkNotNullExpressionValue(boxFolderCreateFromIdAndName, "createFromIdAndName(...)");
        ItemsListReducer.State state2 = new ItemsListReducer.State(null, null, null, FolderModelMapper.toFolderModel$default(folderModelMapper2, boxFolderCreateFromIdAndName, false, 1, null), false, null == true ? 1 : 0, null == true ? 1 : 0, false, null, null, null == true ? 1 : 0, null == true ? 1 : 0, null, null == true ? 1 : 0, false, false, 65527, null == true ? 1 : 0);
        MultiselectMenuAction[] multiselectMenuActionArrRecentsValidActions = recentsValidActions();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(multiselectMenuActionArrRecentsValidActions.length), 16));
        for (MultiselectMenuAction multiselectMenuAction : multiselectMenuActionArrRecentsValidActions) {
            linkedHashMap.put(multiselectMenuAction, true);
        }
        RecentsReducer.State state3 = new RecentsReducer.State(new ActionableItemsListReducer.State(state2, new MultiselectMenuActionsVisibility(linkedHashMap), null, CollectionsKt.listOf((Object[]) new BottomSheetItemAction[]{BottomSheetItemAction.ViewContainingFolder, BottomSheetItemAction.BoxAi}), null, null, null, null, null, 500, null), null == true ? 1 : 0, false, 6, null);
        FolderModelMapper folderModelMapper3 = FolderModelMapper.INSTANCE;
        BoxFolder boxFolderCreateFromId2 = BoxFolder.createFromId("-1");
        Intrinsics.checkNotNullExpressionValue(boxFolderCreateFromId2, "createFromId(...)");
        return new NavigationReducer.State(state, state3, new OfflinedReducer.State(new ActionableItemsListReducer.State(new ItemsListReducer.State(null, null, null, FolderModelMapper.toFolderModel$default(folderModelMapper3, boxFolderCreateFromId2, false, 1, null), false, null, null, false, null, null, null, null, null, null, false, false, 65527, null), null == true ? 1 : 0, null == true ? 1 : 0, CollectionsKt.listOf((Object[]) new BottomSheetItemAction[]{BottomSheetItemAction.ViewContainingFolder, BottomSheetItemAction.BoxAi}), null, null == true ? 1 : 0, null == true ? 1 : 0, null, null == true ? 1 : 0, 502, null == true ? 1 : 0), null, null, false, 14, null == true ? 1 : 0), null, 8, null == true ? 1 : 0);
    }

    private final MultiselectMenuAction[] recentsValidActions() {
        return new MultiselectMenuAction[]{MultiselectMenuAction.BoxAi, MultiselectMenuAction.CopyMove, MultiselectMenuAction.SelectAll, MultiselectMenuAction.SaveOffline, MultiselectMenuAction.RemoveOffline, MultiselectMenuAction.Export, MultiselectMenuAction.DeselectAll};
    }
}
