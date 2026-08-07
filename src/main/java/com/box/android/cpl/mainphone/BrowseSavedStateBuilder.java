package com.box.android.cpl.mainphone;

import com.box.android.browse.cpl.CollectionReducer;
import com.box.android.browse.cpl.NestedViewState;
import com.box.android.browse.cpl.None;
import com.box.android.browse.cpl.browse.BrowseReducer;
import com.box.android.browse.cpl.browse.fab.FilesFabReducer;
import com.box.android.browse.cpl.itemsList.ActionableItemsListReducer;
import com.box.android.browse.cpl.itemsList.BottomSheetItemAction;
import com.box.android.browse.cpl.itemsList.ItemsListReducer;
import com.box.android.browse.utilities.BoxFeatureBanner;
import com.box.android.domain.mappers.FolderModelMapper;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModelKt;
import com.box.androidsdk.content.models.BoxFolder;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.events.ComposeIdentificationData;

/* JADX INFO: compiled from: BrowseSavedStateBuilder.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\u0006\u0010\b\u001a\u00020\tJ\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fH\u0002J\u001c\u0010\u0010\u001a\u00020\u00112\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u0013\u001a\u00020\u0014J \u0010\u0015\u001a\u0004\u0018\u00010\u00162\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u001e\u0010\u0017\u001a\u00020\u00182\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\f\u0010\u0019\u001a\u00020\u0006*\u00020\u001aH\u0002J\f\u0010\u0019\u001a\u00020\u0006*\u00020\u001bH\u0002¨\u0006\u001c"}, d2 = {"Lcom/box/android/cpl/mainphone/BrowseSavedStateBuilder;", "", "<init>", "()V", "getBrowsingHierarchy", "Ljava/util/ArrayList;", "Lcom/box/android/cpl/mainphone/MainPhoneReducer$HierarchyModel;", "Lkotlin/collections/ArrayList;", "state", "Lcom/box/android/browse/cpl/NestedViewState;", "addBrowseRouteFoldersToHierarchy", "", "route", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Route;", ComposeIdentificationData.HIERARCHY, "", "reconstructHierarchy", "Lcom/box/android/cpl/mainphone/MainPhoneReducer$State;", "", "mainPhoneEnvironment", "Lcom/box/android/cpl/mainphone/MainPhoneEnvironment;", "reconstructBrowseState", "Lcom/box/android/browse/cpl/browse/BrowseReducer$State;", "reconstructCollectionsState", "Lcom/box/android/browse/cpl/CollectionReducer$State;", "mapToHierarchyModel", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Route$Folder;", "Lcom/box/android/browse/cpl/CollectionReducer$Route$Folder;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BrowseSavedStateBuilder {
    public static final int $stable = 0;

    /* JADX INFO: compiled from: BrowseSavedStateBuilder.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MainPhoneReducer.HierarchyModelType.values().length];
            try {
                iArr[MainPhoneReducer.HierarchyModelType.FOLDER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MainPhoneReducer.HierarchyModelType.COLLECTION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public BrowseSavedStateBuilder() {
    }

    public final ArrayList<MainPhoneReducer.HierarchyModel> getBrowsingHierarchy(NestedViewState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        ArrayList arrayList = new ArrayList();
        if (state instanceof BrowseReducer.State) {
            BrowseReducer.State state2 = (BrowseReducer.State) state;
            FolderModel currentFolder = state2.getActionableItemsListState().getItemsListViewState().getCurrentFolder();
            arrayList.add(new MainPhoneReducer.HierarchyModel(ItemModelKt.toItemIdRemoteId(currentFolder).getBoxId(), currentFolder.getName(), MainPhoneReducer.HierarchyModelType.FOLDER));
            addBrowseRouteFoldersToHierarchy(state2.getNavigationRoute(), arrayList);
        } else if (state instanceof CollectionReducer.State) {
            CollectionReducer.State state3 = (CollectionReducer.State) state;
            arrayList.add(new MainPhoneReducer.HierarchyModel(state3.getCollectionId(), state3.getCollectionName(), MainPhoneReducer.HierarchyModelType.COLLECTION));
            CollectionReducer.Route navigationRoute = state3.getNavigationRoute();
            if (navigationRoute instanceof CollectionReducer.Route.Folder) {
                CollectionReducer.Route.Folder folder = (CollectionReducer.Route.Folder) navigationRoute;
                arrayList.add(mapToHierarchyModel(folder));
                addBrowseRouteFoldersToHierarchy(folder.getState().getNavigationRoute(), arrayList);
            }
        }
        return new ArrayList<>(arrayList);
    }

    private final void addBrowseRouteFoldersToHierarchy(BrowseReducer.Route route, List<MainPhoneReducer.HierarchyModel> hierarchy) {
        while (route instanceof BrowseReducer.Route.Folder) {
            BrowseReducer.Route.Folder folder = (BrowseReducer.Route.Folder) route;
            hierarchy.add(mapToHierarchyModel(folder));
            route = folder.getState().getNavigationRoute();
        }
    }

    public final MainPhoneReducer.State reconstructHierarchy(List<MainPhoneReducer.HierarchyModel> hierarchy, MainPhoneEnvironment mainPhoneEnvironment) {
        BrowseReducer.State stateReconstructBrowseState;
        Intrinsics.checkNotNullParameter(hierarchy, "hierarchy");
        Intrinsics.checkNotNullParameter(mainPhoneEnvironment, "mainPhoneEnvironment");
        if (hierarchy.isEmpty()) {
            return new MainPhoneReducer.State(None.INSTANCE, false, null, false, 14, null);
        }
        int i = WhenMappings.$EnumSwitchMapping$0[hierarchy.get(0).getType().ordinal()];
        if (i == 1) {
            stateReconstructBrowseState = reconstructBrowseState(hierarchy, mainPhoneEnvironment);
        } else if (i == 2) {
            stateReconstructBrowseState = reconstructCollectionsState(hierarchy, mainPhoneEnvironment);
        } else {
            stateReconstructBrowseState = None.INSTANCE;
        }
        if (stateReconstructBrowseState == null) {
            stateReconstructBrowseState = None.INSTANCE;
        }
        return new MainPhoneReducer.State(stateReconstructBrowseState, false, null, false, 14, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final BrowseReducer.State reconstructBrowseState(List<MainPhoneReducer.HierarchyModel> hierarchy, MainPhoneEnvironment mainPhoneEnvironment) {
        BoxFeatureBanner featureBanner = mainPhoneEnvironment.getBrowseEnvironment().getActionableItemsListEnvironment().getItemListViewEnvironment().getFeatureBannerUtils().getFeatureBanner(BoxFeatureBanner.CAPTURE.getId());
        BrowseReducer.State state = null;
        for (MainPhoneReducer.HierarchyModel hierarchyModel : CollectionsKt.reversed(hierarchy)) {
            if (hierarchyModel.getType() == MainPhoneReducer.HierarchyModelType.FOLDER) {
                BrowseReducer.Route.Folder folder = BrowseReducer.Route.None.INSTANCE;
                if (state != null) {
                    folder = new BrowseReducer.Route.Folder(state);
                }
                FolderModelMapper folderModelMapper = FolderModelMapper.INSTANCE;
                BoxFolder boxFolderCreateFromIdAndName = BoxFolder.createFromIdAndName(hierarchyModel.getId(), hierarchyModel.getName());
                Intrinsics.checkNotNullExpressionValue(boxFolderCreateFromIdAndName, "createFromIdAndName(...)");
                FolderModel folderModel$default = FolderModelMapper.toFolderModel$default(folderModelMapper, boxFolderCreateFromIdAndName, false, 1, null);
                DefaultConstructorMarker defaultConstructorMarker = null;
                Object[] objArr = 0 == true ? 1 : 0;
                Object[] objArr2 = 0 == true ? 1 : 0;
                boolean z = false;
                Object[] objArr3 = 0 == true ? 1 : 0;
                state = new BrowseReducer.State(new ActionableItemsListReducer.State(new ItemsListReducer.State(null, null, null, folderModel$default, false, null, featureBanner, true, null, null, null, null, null, null, true, false, 48951, null), null, null, CollectionsKt.listOf(BottomSheetItemAction.BoxAi), null, null, null, null, null, 502, defaultConstructorMarker), folder, objArr3, z, new FilesFabReducer.State(folderModel$default, false, false, null, false, false, false, objArr, objArr2, 510, defaultConstructorMarker), 12, null);
            }
        }
        return state;
    }

    private final CollectionReducer.State reconstructCollectionsState(List<MainPhoneReducer.HierarchyModel> hierarchy, MainPhoneEnvironment mainPhoneEnvironment) {
        CollectionReducer.Route.None folder;
        MainPhoneReducer.HierarchyModel hierarchyModel = hierarchy.get(0);
        String name = hierarchyModel.getName();
        if (name == null) {
            name = "";
        }
        String id = hierarchyModel.getId();
        String str = id != null ? id : "";
        BrowseReducer.State stateReconstructBrowseState = reconstructBrowseState(CollectionsKt.drop(hierarchy, 1), mainPhoneEnvironment);
        if (stateReconstructBrowseState != null) {
            folder = new CollectionReducer.Route.Folder(stateReconstructBrowseState);
        } else {
            folder = CollectionReducer.Route.None.INSTANCE;
        }
        return new CollectionReducer.State(name, str, folder);
    }

    private final MainPhoneReducer.HierarchyModel mapToHierarchyModel(BrowseReducer.Route.Folder folder) {
        FolderModel currentFolder = folder.getState().getActionableItemsListState().getItemsListViewState().getCurrentFolder();
        return new MainPhoneReducer.HierarchyModel(ItemModelKt.toItemIdRemoteId(currentFolder).getBoxId(), currentFolder.getName(), MainPhoneReducer.HierarchyModelType.FOLDER);
    }

    private final MainPhoneReducer.HierarchyModel mapToHierarchyModel(CollectionReducer.Route.Folder folder) {
        FolderModel currentFolder = folder.getState().getActionableItemsListState().getItemsListViewState().getCurrentFolder();
        return new MainPhoneReducer.HierarchyModel(ItemModelKt.toItemIdRemoteId(currentFolder).getBoxId(), currentFolder.getName(), MainPhoneReducer.HierarchyModelType.FOLDER);
    }
}
