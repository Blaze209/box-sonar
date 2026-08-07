package com.box.android.cpl.mainphone;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.box.android.base.presentation.components.fileactions.OfflineFilesReducer;
import com.box.android.boxai.BoxAiCenterReducer;
import com.box.android.browse.cpl.CollectionReducer;
import com.box.android.browse.cpl.browse.BrowseReducer;
import com.box.android.browse.cpl.browse.fab.FilesFabReducer;
import com.box.android.browse.cpl.itemsList.ActionableItemsListReducer;
import com.box.android.browse.cpl.itemsList.BottomSheetItemAction;
import com.box.android.browse.cpl.itemsList.ItemsListReducer;
import com.box.android.browse.cpl.itemsList.multiselect.MultiselectMenuActionsVisibility;
import com.box.android.browse.utilities.BoxFeatureBanner;
import com.box.android.common.utilities.ViewModelAssistedFactoryLegacy;
import com.box.android.cpl.IStoreFactory;
import com.box.android.cpl.Store;
import com.box.android.domain.mappers.FolderModelMapper;
import com.box.android.domain.models.item.FolderModel;
import com.box.androidsdk.content.models.BoxFolder;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.events.ComposeIdentificationData;

/* JADX INFO: compiled from: MainPhoneViewModel.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001aB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u0015J\u0018\u0010\u0016\u001a\u00020\u000e2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018H\u0007J\b\u0010\u0019\u001a\u00020\u000eH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/box/android/cpl/mainphone/MainPhoneViewModel;", "Landroidx/lifecycle/ViewModel;", "stateHandle", "Landroidx/lifecycle/SavedStateHandle;", "mainPhoneEnvironment", "Lcom/box/android/cpl/mainphone/MainPhoneEnvironment;", "browseSavedStateBuilder", "Lcom/box/android/cpl/mainphone/BrowseSavedStateBuilder;", "storeFactory", "Lcom/box/android/cpl/IStoreFactory;", "<init>", "(Landroidx/lifecycle/SavedStateHandle;Lcom/box/android/cpl/mainphone/MainPhoneEnvironment;Lcom/box/android/cpl/mainphone/BrowseSavedStateBuilder;Lcom/box/android/cpl/IStoreFactory;)V", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/cpl/mainphone/MainPhoneReducer$State;", "Lcom/box/android/cpl/mainphone/MainPhoneReducer$Action;", "getStore", "()Lcom/box/android/cpl/Store;", "getBrowsingHierarchy", "Ljava/util/ArrayList;", "Lcom/box/android/cpl/mainphone/MainPhoneReducer$HierarchyModel;", "Lkotlin/collections/ArrayList;", "reconstructState", ComposeIdentificationData.HIERARCHY, "", "getFreshState", "Factory", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MainPhoneViewModel extends ViewModel {
    public static final int $stable = 8;
    private final BrowseSavedStateBuilder browseSavedStateBuilder;
    private final MainPhoneEnvironment mainPhoneEnvironment;
    private final SavedStateHandle stateHandle;
    private final Store<MainPhoneReducer.State, MainPhoneReducer.Action> store;

    public MainPhoneViewModel(SavedStateHandle stateHandle, MainPhoneEnvironment mainPhoneEnvironment, BrowseSavedStateBuilder browseSavedStateBuilder, IStoreFactory storeFactory) {
        Intrinsics.checkNotNullParameter(stateHandle, "stateHandle");
        Intrinsics.checkNotNullParameter(mainPhoneEnvironment, "mainPhoneEnvironment");
        Intrinsics.checkNotNullParameter(browseSavedStateBuilder, "browseSavedStateBuilder");
        Intrinsics.checkNotNullParameter(storeFactory, "storeFactory");
        this.stateHandle = stateHandle;
        this.mainPhoneEnvironment = mainPhoneEnvironment;
        this.browseSavedStateBuilder = browseSavedStateBuilder;
        Store<MainPhoneReducer.State, MainPhoneReducer.Action> storeCreate = storeFactory.create(reconstructState((List) stateHandle.get(MainPhoneViewModelKt.RESTORE_STATE_KEY)), new MainPhoneReducer(mainPhoneEnvironment), ViewModelKt.getViewModelScope(this));
        this.store = storeCreate;
        storeCreate.send(MainPhoneReducer.Action.Initialize.INSTANCE);
    }

    public final Store<MainPhoneReducer.State, MainPhoneReducer.Action> getStore() {
        return this.store;
    }

    public final ArrayList<MainPhoneReducer.HierarchyModel> getBrowsingHierarchy() {
        return this.browseSavedStateBuilder.getBrowsingHierarchy(this.store.getState().getValue().getNestedViewState());
    }

    public final MainPhoneReducer.State reconstructState(List<MainPhoneReducer.HierarchyModel> hierarchy) {
        List<MainPhoneReducer.HierarchyModel> list = hierarchy;
        if (list == null || list.isEmpty() || hierarchy.get(0).getType() == MainPhoneReducer.HierarchyModelType.MY_COLLECTIONS) {
            return getFreshState();
        }
        return this.browseSavedStateBuilder.reconstructHierarchy(hierarchy, this.mainPhoneEnvironment);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final MainPhoneReducer.State getFreshState() {
        String str = (String) this.stateHandle.get(MainPhoneReducer.BROWSE_INITIAL_FOLDER_ID);
        String str2 = (String) this.stateHandle.get(MainPhoneReducer.BROWSE_INITIAL_FOLDER_NAME);
        String str3 = (String) this.stateHandle.get(MainPhoneReducer.BROWSE_INITIAL_COLLECTION_ID);
        BoxFeatureBanner featureBanner = this.mainPhoneEnvironment.getBrowseEnvironment().getActionableItemsListEnvironment().getItemListViewEnvironment().getFeatureBannerUtils().getFeatureBanner(BoxFeatureBanner.CAPTURE.getId());
        if (str != null) {
            FolderModelMapper folderModelMapper = FolderModelMapper.INSTANCE;
            BoxFolder boxFolderCreateFromIdAndName = BoxFolder.createFromIdAndName(str, str2);
            Intrinsics.checkNotNullExpressionValue(boxFolderCreateFromIdAndName, "createFromIdAndName(...)");
            FolderModel folderModel$default = FolderModelMapper.toFolderModel$default(folderModelMapper, boxFolderCreateFromIdAndName, false, 1, null);
            MultiselectMenuActionsVisibility multiselectMenuActionsVisibility = null;
            ActionableItemsListReducer.State.PermissionRequest permissionRequest = null;
            OfflineFilesReducer.State state = null;
            BoxAiCenterReducer.State state2 = null;
            Object[] objArr = 0 == true ? 1 : 0;
            Object[] objArr2 = 0 == true ? 1 : 0;
            Object[] objArr3 = 0 == true ? 1 : 0;
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            FilesFabReducer.CreateNewDocumentMenuState createNewDocumentMenuState = null;
            FilesFabReducer.ViewEffect viewEffect = null;
            return new MainPhoneReducer.State(new BrowseReducer.State(new ActionableItemsListReducer.State(new ItemsListReducer.State(null, null, null, folderModel$default, false, null, featureBanner, true, null, null, null, null, null, null, true, false, 48951, null), multiselectMenuActionsVisibility, permissionRequest, CollectionsKt.listOf(BottomSheetItemAction.BoxAi), state, objArr, objArr2, objArr3, state2, 502, 0 == true ? 1 : 0), null, null, false, new FilesFabReducer.State(folderModel$default, false, false, 0 == true ? 1 : 0, z, z2, z3, createNewDocumentMenuState, viewEffect, 510, null), 14, null), false, null, false, 14, null);
        }
        if (str2 == null) {
            str2 = "";
        }
        Intrinsics.checkNotNull(str3);
        return new MainPhoneReducer.State(new CollectionReducer.State(str2, str3, null, 4, null), false, null, false, 14, null);
    }

    /* JADX INFO: compiled from: MainPhoneViewModel.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/box/android/cpl/mainphone/MainPhoneViewModel$Factory;", "Lcom/box/android/common/utilities/ViewModelAssistedFactoryLegacy;", "Lcom/box/android/cpl/mainphone/MainPhoneViewModel;", "mainPhoneEnvironment", "Lcom/box/android/cpl/mainphone/MainPhoneEnvironment;", "browseSavedStateBuilder", "Lcom/box/android/cpl/mainphone/BrowseSavedStateBuilder;", "storeFactory", "Lcom/box/android/cpl/IStoreFactory;", "<init>", "(Lcom/box/android/cpl/mainphone/MainPhoneEnvironment;Lcom/box/android/cpl/mainphone/BrowseSavedStateBuilder;Lcom/box/android/cpl/IStoreFactory;)V", PasskeyWebListener.CREATE_UNIQUE_KEY, "handle", "Landroidx/lifecycle/SavedStateHandle;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Factory implements ViewModelAssistedFactoryLegacy<MainPhoneViewModel> {
        public static final int $stable = 8;
        private final BrowseSavedStateBuilder browseSavedStateBuilder;
        private final MainPhoneEnvironment mainPhoneEnvironment;
        private final IStoreFactory storeFactory;

        @Inject
        public Factory(MainPhoneEnvironment mainPhoneEnvironment, BrowseSavedStateBuilder browseSavedStateBuilder, IStoreFactory storeFactory) {
            Intrinsics.checkNotNullParameter(mainPhoneEnvironment, "mainPhoneEnvironment");
            Intrinsics.checkNotNullParameter(browseSavedStateBuilder, "browseSavedStateBuilder");
            Intrinsics.checkNotNullParameter(storeFactory, "storeFactory");
            this.mainPhoneEnvironment = mainPhoneEnvironment;
            this.browseSavedStateBuilder = browseSavedStateBuilder;
            this.storeFactory = storeFactory;
        }

        @Override // com.box.android.common.utilities.ViewModelAssistedFactoryLegacy
        public MainPhoneViewModel create(SavedStateHandle handle) {
            Intrinsics.checkNotNullParameter(handle, "handle");
            return new MainPhoneViewModel(handle, this.mainPhoneEnvironment, this.browseSavedStateBuilder, this.storeFactory);
        }
    }
}
