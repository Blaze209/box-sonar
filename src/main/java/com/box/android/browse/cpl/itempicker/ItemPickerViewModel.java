package com.box.android.browse.cpl.itempicker;

import android.os.Bundle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.box.android.common.utilities.ViewModelAssistedFactory;
import com.box.android.cpl.IStoreFactory;
import com.box.android.cpl.Store;
import com.box.android.domain.models.item.FolderModel;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedFactory;
import dagger.assisted.AssistedInject;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemPickerViewModel.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0002\u0019\u001aB#\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/box/android/browse/cpl/itempicker/ItemPickerViewModel;", "Landroidx/lifecycle/ViewModel;", "args", "Landroid/os/Bundle;", "environment", "Lcom/box/android/browse/cpl/itempicker/FolderItemPickerEnvironment;", "storeFactory", "Lcom/box/android/cpl/IStoreFactory;", "<init>", "(Landroid/os/Bundle;Lcom/box/android/browse/cpl/itempicker/FolderItemPickerEnvironment;Lcom/box/android/cpl/IStoreFactory;)V", "getArgs", "()Landroid/os/Bundle;", "getEnvironment", "()Lcom/box/android/browse/cpl/itempicker/FolderItemPickerEnvironment;", "getStoreFactory", "()Lcom/box/android/cpl/IStoreFactory;", "initialState", "Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$State;", "getInitialState", "()Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$State;", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$Action;", "getStore", "()Lcom/box/android/cpl/Store;", "Factory", "Companion", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ItemPickerViewModel extends ViewModel {
    public static final String DISABLE_NON_FOLDER_ITEMS_VM_KEY = "disable_non_folder_items";
    public static final String SELECT_BUTTON_NAME_VM_KEY = "select_button_name";
    public static final String STARTING_FOLDER_ID_VM_KEY = "starting_folder_id";
    public static final String TITLE_VM_KEY = "title";
    private final Bundle args;
    private final FolderItemPickerEnvironment environment;
    private final ItemPickerReducer.State initialState;
    private final Store<ItemPickerReducer.State, ItemPickerReducer.Action> store;
    private final IStoreFactory storeFactory;
    public static final int $stable = 8;

    /* JADX INFO: compiled from: ItemPickerViewModel.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003À\u0006\u0003"}, d2 = {"Lcom/box/android/browse/cpl/itempicker/ItemPickerViewModel$Factory;", "Lcom/box/android/common/utilities/ViewModelAssistedFactory;", "Lcom/box/android/browse/cpl/itempicker/ItemPickerViewModel;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @AssistedFactory
    public interface Factory extends ViewModelAssistedFactory<ItemPickerViewModel> {
    }

    @AssistedInject
    public ItemPickerViewModel(@Assisted Bundle args, FolderItemPickerEnvironment environment, IStoreFactory storeFactory) {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(storeFactory, "storeFactory");
        this.args = args;
        this.environment = environment;
        this.storeFactory = storeFactory;
        ItemPickerReducer.State.Companion companion = ItemPickerReducer.State.INSTANCE;
        FolderModel.Companion companion2 = FolderModel.INSTANCE;
        String string = args.getString(STARTING_FOLDER_ID_VM_KEY, "0");
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        ItemPickerReducer.State stateCopy$default = ItemPickerReducer.State.copy$default(ItemPickerReducer.State.Companion.create$default(companion, FolderModel.Companion.createFromId$default(companion2, string, null, 2, null), null, args.getBoolean(DISABLE_NON_FOLDER_ITEMS_VM_KEY), null, 10, null), false, null, null, null, null, args.getString("title"), args.containsKey(SELECT_BUTTON_NAME_VM_KEY) ? Integer.valueOf(args.getInt(SELECT_BUTTON_NAME_VM_KEY)) : null, null, Token.LETEXPR, null);
        this.initialState = stateCopy$default;
        this.store = storeFactory.create(stateCopy$default, new ItemPickerReducer(environment), ViewModelKt.getViewModelScope(this));
    }

    public final Bundle getArgs() {
        return this.args;
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
