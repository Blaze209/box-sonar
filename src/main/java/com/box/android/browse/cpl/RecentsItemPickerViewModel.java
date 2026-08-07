package com.box.android.browse.cpl;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.box.android.browse.cpl.itempicker.ItemPickerMode;
import com.box.android.browse.cpl.itempicker.ItemPickerReducer;
import com.box.android.browse.cpl.itempicker.RecentItemPickerEnvironment;
import com.box.android.browse.cpl.itemsList.FilesDisplayConfigReducer;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.cpl.IStoreFactory;
import com.box.android.cpl.Store;
import com.box.android.domain.models.item.FolderModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RecentsItemPickerViewModel.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/box/android/browse/cpl/RecentsItemPickerViewModel;", "Landroidx/lifecycle/ViewModel;", "environment", "Lcom/box/android/browse/cpl/itempicker/RecentItemPickerEnvironment;", "storeFactory", "Lcom/box/android/cpl/IStoreFactory;", "<init>", "(Lcom/box/android/browse/cpl/itempicker/RecentItemPickerEnvironment;Lcom/box/android/cpl/IStoreFactory;)V", "getEnvironment", "()Lcom/box/android/browse/cpl/itempicker/RecentItemPickerEnvironment;", "getStoreFactory", "()Lcom/box/android/cpl/IStoreFactory;", "initialState", "Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$State;", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$Action;", "getStore", "()Lcom/box/android/cpl/Store;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RecentsItemPickerViewModel extends ViewModel {
    public static final int $stable = 8;
    private final RecentItemPickerEnvironment environment;
    private final ItemPickerReducer.State initialState;
    private final Store<ItemPickerReducer.State, ItemPickerReducer.Action> store;
    private final IStoreFactory storeFactory;

    @Inject
    public RecentsItemPickerViewModel(RecentItemPickerEnvironment environment, IStoreFactory storeFactory) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(storeFactory, "storeFactory");
        this.environment = environment;
        this.storeFactory = storeFactory;
        ItemPickerReducer.State stateCreate = ItemPickerReducer.State.INSTANCE.create(FolderModel.Companion.createFromId$default(FolderModel.INSTANCE, BoxCommonConstants.RECENTS_ROOT_FOLDER_ID, null, 2, null), ItemPickerMode.Multi.INSTANCE, false, FilesDisplayConfigReducer.ConfigBarMode.FILTER);
        this.initialState = stateCreate;
        this.store = storeFactory.create(stateCreate, new ItemPickerReducer(environment), ViewModelKt.getViewModelScope(this));
    }

    public final RecentItemPickerEnvironment getEnvironment() {
        return this.environment;
    }

    public final IStoreFactory getStoreFactory() {
        return this.storeFactory;
    }

    public final Store<ItemPickerReducer.State, ItemPickerReducer.Action> getStore() {
        return this.store;
    }
}
