package com.box.android.data.mappers;

import com.box.android.data.api.models.items.mini.ItemIdDTO;
import com.box.android.domain.models.ItemId;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemIdMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toItemIdDTO", "Lcom/box/android/data/api/models/items/mini/ItemIdDTO;", "Lcom/box/android/domain/models/ItemId$Remote;", "data_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ItemIdMapperKt {
    public static final ItemIdDTO toItemIdDTO(ItemId.Remote remote) {
        Intrinsics.checkNotNullParameter(remote, "<this>");
        return new ItemIdDTO(remote.getBoxId(), remote.getType());
    }
}
