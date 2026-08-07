package com.box.android.browse.cpl.itempicker;

import com.box.android.browse.cpl.createfolder.CreateFolderEnvironment;
import com.box.android.browse.cpl.itemsList.IItemsListViewEnvironment;
import kotlin.Metadata;

/* JADX INFO: compiled from: FolderItemPickerEnvironment.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/box/android/browse/cpl/itempicker/ItemPickerEnvironment;", "", "itemsListViewEnvironment", "Lcom/box/android/browse/cpl/itemsList/IItemsListViewEnvironment;", "getItemsListViewEnvironment", "()Lcom/box/android/browse/cpl/itemsList/IItemsListViewEnvironment;", "createFolderEnvironment", "Lcom/box/android/browse/cpl/createfolder/CreateFolderEnvironment;", "getCreateFolderEnvironment", "()Lcom/box/android/browse/cpl/createfolder/CreateFolderEnvironment;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ItemPickerEnvironment {
    CreateFolderEnvironment getCreateFolderEnvironment();

    IItemsListViewEnvironment getItemsListViewEnvironment();
}
