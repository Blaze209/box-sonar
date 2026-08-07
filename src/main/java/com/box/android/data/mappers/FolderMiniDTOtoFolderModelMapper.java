package com.box.android.data.mappers;

import com.box.android.data.api.models.items.mini.FolderMiniDTO;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FolderModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FolderMiniDTOtoFolderModelMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/data/mappers/FolderMiniDTOtoFolderModelMapper;", "", "<init>", "()V", "toDomain", "Lcom/box/android/domain/models/item/FolderModel;", "dataModel", "Lcom/box/android/data/api/models/items/mini/FolderMiniDTO;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FolderMiniDTOtoFolderModelMapper {
    public static final FolderMiniDTOtoFolderModelMapper INSTANCE = new FolderMiniDTOtoFolderModelMapper();

    private FolderMiniDTOtoFolderModelMapper() {
    }

    public final FolderModel toDomain(FolderMiniDTO dataModel) {
        Intrinsics.checkNotNullParameter(dataModel, "dataModel");
        ItemId itemIdCreateItemId = FolderModel.INSTANCE.createItemId(dataModel.getId());
        String name = dataModel.getName();
        if (name == null) {
            name = "";
        }
        return new FolderModel(itemIdCreateItemId, name, false, false, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, 393216, null);
    }
}
