package com.box.android.data.api.models.items;

import com.box.android.data.api.models.WatermarkDTO;
import com.box.android.data.api.models.items.mini.IFolderMiniDTO;
import kotlin.Metadata;

/* JADX INFO: compiled from: FolderDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/box/android/data/api/models/items/IFolderDTO;", "Lcom/box/android/data/api/models/items/IItemDTO;", "Lcom/box/android/data/api/models/items/mini/IFolderMiniDTO;", "itemCollection", "Lcom/box/android/data/api/models/items/ItemsDTO;", "getItemCollection", "()Lcom/box/android/data/api/models/items/ItemsDTO;", "watermark", "Lcom/box/android/data/api/models/WatermarkDTO;", "getWatermark", "()Lcom/box/android/data/api/models/WatermarkDTO;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IFolderDTO extends IItemDTO, IFolderMiniDTO {
    ItemsDTO getItemCollection();

    WatermarkDTO getWatermark();
}
