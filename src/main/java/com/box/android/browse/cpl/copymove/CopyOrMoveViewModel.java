package com.box.android.browse.cpl.copymove;

import android.os.Build;
import android.os.Bundle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.box.android.browse.cpl.itemsList.ItemsListReducerKt;
import com.box.android.browse.utilities.CopyOrMoveHelper;
import com.box.android.common.utilities.ViewModelAssistedFactory;
import com.box.android.cpl.IStoreFactory;
import com.box.android.cpl.Store;
import com.box.android.domain.models.item.ItemModel;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedFactory;
import dagger.assisted.AssistedInject;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CopyOrMoveViewModel.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0010B#\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/box/android/browse/cpl/copymove/CopyOrMoveViewModel;", "Landroidx/lifecycle/ViewModel;", "args", "Landroid/os/Bundle;", "environment", "Lcom/box/android/browse/cpl/copymove/CopyOrMoveEnvironment;", "storeFactory", "Lcom/box/android/cpl/IStoreFactory;", "<init>", "(Landroid/os/Bundle;Lcom/box/android/browse/cpl/copymove/CopyOrMoveEnvironment;Lcom/box/android/cpl/IStoreFactory;)V", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/browse/cpl/copymove/CopyOrMoveReducer$State;", "Lcom/box/android/browse/cpl/copymove/CopyOrMoveReducer$Action;", "getStore", "()Lcom/box/android/cpl/Store;", "Factory", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CopyOrMoveViewModel extends ViewModel {
    public static final int $stable = 8;
    private final Store<CopyOrMoveReducer.State, CopyOrMoveReducer.Action> store;

    /* JADX INFO: compiled from: CopyOrMoveViewModel.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003À\u0006\u0003"}, d2 = {"Lcom/box/android/browse/cpl/copymove/CopyOrMoveViewModel$Factory;", "Lcom/box/android/common/utilities/ViewModelAssistedFactory;", "Lcom/box/android/browse/cpl/copymove/CopyOrMoveViewModel;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @AssistedFactory
    public interface Factory extends ViewModelAssistedFactory<CopyOrMoveViewModel> {
    }

    @AssistedInject
    public CopyOrMoveViewModel(@Assisted Bundle args, CopyOrMoveEnvironment environment, IStoreFactory storeFactory) {
        ArrayList parcelableArrayList;
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(storeFactory, "storeFactory");
        CopyOrMoveHelper.Companion companion = CopyOrMoveHelper.INSTANCE;
        ArrayList parcelableArrayList2 = null;
        if (Build.VERSION.SDK_INT >= 33) {
            parcelableArrayList = args.getParcelableArrayList(ItemsListReducerKt.FOLDER_HIERARCHY, ItemModel.class);
        } else {
            ArrayList parcelableArrayList3 = args.getParcelableArrayList(ItemsListReducerKt.FOLDER_HIERARCHY);
            parcelableArrayList = parcelableArrayList3 instanceof List ? parcelableArrayList3 : null;
        }
        if (parcelableArrayList == null) {
            throw new IllegalArgumentException("List of parcelables with key FOLDER_HIERARCHY not found in Bundle".toString());
        }
        if (Build.VERSION.SDK_INT >= 33) {
            parcelableArrayList2 = args.getParcelableArrayList(ItemsListReducerKt.ITEMS_TO_COPY, ItemModel.class);
        } else {
            ArrayList parcelableArrayList4 = args.getParcelableArrayList(ItemsListReducerKt.ITEMS_TO_COPY);
            if (parcelableArrayList4 instanceof List) {
                parcelableArrayList2 = parcelableArrayList4;
            }
        }
        if (parcelableArrayList2 != null) {
            this.store = storeFactory.create(companion.createInitialState(parcelableArrayList, parcelableArrayList2), new CopyOrMoveReducer(environment), ViewModelKt.getViewModelScope(this));
            return;
        }
        throw new IllegalArgumentException("List of parcelables with key ITEMS_TO_COPY not found in Bundle".toString());
    }

    public final Store<CopyOrMoveReducer.State, CopyOrMoveReducer.Action> getStore() {
        return this.store;
    }
}
