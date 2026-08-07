package com.box.android.browse.cpl.itempicker;

import com.box.android.browse.cpl.createfolder.CreateFolderEnvironment;
import com.box.android.browse.cpl.recents.RecentsViewEnvironment;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FolderItemPickerEnvironment.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/itempicker/RecentItemPickerEnvironment;", "Lcom/box/android/browse/cpl/itempicker/ItemPickerEnvironment;", "itemsListViewEnvironment", "Lcom/box/android/browse/cpl/recents/RecentsViewEnvironment;", "createFolderEnvironment", "Lcom/box/android/browse/cpl/createfolder/CreateFolderEnvironment;", "<init>", "(Lcom/box/android/browse/cpl/recents/RecentsViewEnvironment;Lcom/box/android/browse/cpl/createfolder/CreateFolderEnvironment;)V", "getItemsListViewEnvironment", "()Lcom/box/android/browse/cpl/recents/RecentsViewEnvironment;", "getCreateFolderEnvironment", "()Lcom/box/android/browse/cpl/createfolder/CreateFolderEnvironment;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RecentItemPickerEnvironment implements ItemPickerEnvironment {
    public static final int $stable = 8;
    private final CreateFolderEnvironment createFolderEnvironment;
    private final RecentsViewEnvironment itemsListViewEnvironment;

    @Inject
    public RecentItemPickerEnvironment(RecentsViewEnvironment itemsListViewEnvironment, CreateFolderEnvironment createFolderEnvironment) {
        Intrinsics.checkNotNullParameter(itemsListViewEnvironment, "itemsListViewEnvironment");
        Intrinsics.checkNotNullParameter(createFolderEnvironment, "createFolderEnvironment");
        this.itemsListViewEnvironment = itemsListViewEnvironment;
        this.createFolderEnvironment = createFolderEnvironment;
    }

    @Override // com.box.android.browse.cpl.itempicker.ItemPickerEnvironment
    public RecentsViewEnvironment getItemsListViewEnvironment() {
        return this.itemsListViewEnvironment;
    }

    @Override // com.box.android.browse.cpl.itempicker.ItemPickerEnvironment
    public CreateFolderEnvironment getCreateFolderEnvironment() {
        return this.createFolderEnvironment;
    }
}
