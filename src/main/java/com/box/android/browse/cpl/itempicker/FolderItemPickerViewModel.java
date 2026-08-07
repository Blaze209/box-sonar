package com.box.android.browse.cpl.itempicker;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.box.android.base.R;
import com.box.android.browse.cpl.itemsList.FilesDisplayConfigReducer;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.common.utilities.ResourcesProvider;
import com.box.android.cpl.IStoreFactory;
import com.box.android.cpl.Store;
import com.box.android.domain.models.item.FolderModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FolderItemPickerViewModel.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00190\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/box/android/browse/cpl/itempicker/FolderItemPickerViewModel;", "Landroidx/lifecycle/ViewModel;", "environment", "Lcom/box/android/browse/cpl/itempicker/FolderItemPickerEnvironment;", "storeFactory", "Lcom/box/android/cpl/IStoreFactory;", "resourceProvider", "Lcom/box/android/common/utilities/ResourcesProvider;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "<init>", "(Lcom/box/android/browse/cpl/itempicker/FolderItemPickerEnvironment;Lcom/box/android/cpl/IStoreFactory;Lcom/box/android/common/utilities/ResourcesProvider;Landroidx/lifecycle/SavedStateHandle;)V", "getEnvironment", "()Lcom/box/android/browse/cpl/itempicker/FolderItemPickerEnvironment;", "getStoreFactory", "()Lcom/box/android/cpl/IStoreFactory;", "folderId", "", BoxCommonConstants.EXTRA_FOLDER_NAME, "initialState", "Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$State;", "getInitialState", "()Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$State;", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$Action;", "getStore", "()Lcom/box/android/cpl/Store;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FolderItemPickerViewModel extends ViewModel {
    public static final int $stable = 8;
    private final FolderItemPickerEnvironment environment;
    private final String folderId;
    private final String folderName;
    private final ItemPickerReducer.State initialState;
    private final Store<ItemPickerReducer.State, ItemPickerReducer.Action> store;
    private final IStoreFactory storeFactory;

    @Inject
    public FolderItemPickerViewModel(FolderItemPickerEnvironment environment, IStoreFactory storeFactory, ResourcesProvider resourceProvider, SavedStateHandle savedStateHandle) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(storeFactory, "storeFactory");
        Intrinsics.checkNotNullParameter(resourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        this.environment = environment;
        this.storeFactory = storeFactory;
        String str = (String) savedStateHandle.get("folderId");
        str = str == null ? "0" : str;
        this.folderId = str;
        String string = (String) savedStateHandle.get(BoxCommonConstants.EXTRA_FOLDER_NAME);
        string = string == null ? resourceProvider.getString(R.string.files) : string;
        this.folderName = string;
        ItemPickerReducer.State stateCreate = ItemPickerReducer.State.INSTANCE.create(FolderModel.INSTANCE.createFromId(str, string), ItemPickerMode.Multi.INSTANCE, false, FilesDisplayConfigReducer.ConfigBarMode.SORT);
        this.initialState = stateCreate;
        this.store = storeFactory.create(stateCreate, new ItemPickerReducer(environment), ViewModelKt.getViewModelScope(this));
    }

    public final FolderItemPickerEnvironment getEnvironment() {
        return this.environment;
    }

    public final IStoreFactory getStoreFactory() {
        return this.storeFactory;
    }

    public final ItemPickerReducer.State getInitialState() {
        return this.initialState;
    }

    public final Store<ItemPickerReducer.State, ItemPickerReducer.Action> getStore() {
        return this.store;
    }
}
