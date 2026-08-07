package com.box.android.preview.iteminformation;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.box.android.common.utilities.ViewModelAssistedFactory;
import com.box.android.cpl.IStoreFactory;
import com.box.android.cpl.Store;
import com.box.android.domain.models.item.ItemModel;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedFactory;
import dagger.assisted.AssistedInject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemInformationViewModel.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0002\u0010\u0011B#\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/iteminformation/ItemInformationViewModel;", "Landroidx/lifecycle/ViewModel;", "args", "Landroid/os/Bundle;", "environment", "Lcom/box/android/preview/iteminformation/ItemInformationEnvironment;", "storeFactory", "Lcom/box/android/cpl/IStoreFactory;", "<init>", "(Landroid/os/Bundle;Lcom/box/android/preview/iteminformation/ItemInformationEnvironment;Lcom/box/android/cpl/IStoreFactory;)V", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$State;", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action;", "getStore", "()Lcom/box/android/cpl/Store;", "Factory", "Companion", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ItemInformationViewModel extends ViewModel {
    public static final String VM_INITIAL_ITEM_MODEL_KEY = "VM_INITIAL_ITEM_MODEL_KEY";
    private final Store<ItemInformationReducer.State, ItemInformationReducer.Action> store;
    public static final int $stable = 8;

    /* JADX INFO: compiled from: ItemInformationViewModel.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003À\u0006\u0003"}, d2 = {"Lcom/box/android/preview/iteminformation/ItemInformationViewModel$Factory;", "Lcom/box/android/common/utilities/ViewModelAssistedFactory;", "Lcom/box/android/preview/iteminformation/ItemInformationViewModel;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @AssistedFactory
    public interface Factory extends ViewModelAssistedFactory<ItemInformationViewModel> {
    }

    @AssistedInject
    public ItemInformationViewModel(@Assisted Bundle args, ItemInformationEnvironment environment, IStoreFactory storeFactory) {
        Parcelable parcelable;
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(storeFactory, "storeFactory");
        if (Build.VERSION.SDK_INT >= 33) {
            parcelable = (Parcelable) args.getParcelable(VM_INITIAL_ITEM_MODEL_KEY, ItemModel.class);
        } else {
            Parcelable parcelable2 = args.getParcelable(VM_INITIAL_ITEM_MODEL_KEY);
            parcelable = (ItemModel) (parcelable2 instanceof ItemModel ? parcelable2 : null);
        }
        if (parcelable != null) {
            this.store = storeFactory.create(new ItemInformationReducer.State((ItemModel) parcelable, null, null, null, null, false, null, null, null, 510, null), new ItemInformationReducer(environment), ViewModelKt.getViewModelScope(this));
            return;
        }
        throw new IllegalArgumentException("Parcelable with key VM_INITIAL_ITEM_MODEL_KEY not found in Bundle".toString());
    }

    public final Store<ItemInformationReducer.State, ItemInformationReducer.Action> getStore() {
        return this.store;
    }
}
