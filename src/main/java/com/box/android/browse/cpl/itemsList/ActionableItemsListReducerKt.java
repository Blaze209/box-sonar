package com.box.android.browse.cpl.itemsList;

import com.box.android.base.presentation.components.fileactions.DownloadFilesReducer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ActionableItemsListReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0014\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"loadItems", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action$ItemsListAction;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action$Companion;", "downloadToSelectedFolder", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action$DownloadAction;", "folderId", "", "browse_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ActionableItemsListReducerKt {
    public static final ActionableItemsListReducer.Action.ItemsListAction loadItems(ActionableItemsListReducer.Action.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return new ActionableItemsListReducer.Action.ItemsListAction(ItemsListReducer.Action.LoadItems.INSTANCE);
    }

    public static final ActionableItemsListReducer.Action.DownloadAction downloadToSelectedFolder(ActionableItemsListReducer.Action.Companion companion, String str) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return new ActionableItemsListReducer.Action.DownloadAction(new DownloadFilesReducer.Action.DownloadToFolder(str));
    }
}
