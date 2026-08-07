package com.box.android.domain.models.item;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WatermarkableItem.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toWatermarkableItem", "Lcom/box/android/domain/models/item/WatermarkableItem;", "Lcom/box/android/domain/models/item/ItemModel;", "domain_prodRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class WatermarkableItemKt {
    public static final WatermarkableItem toWatermarkableItem(ItemModel itemModel) {
        Intrinsics.checkNotNullParameter(itemModel, "<this>");
        if (itemModel instanceof FileModel) {
            return new WatermarkableItem.File((FileModel) itemModel);
        }
        if (itemModel instanceof FolderModel) {
            return new WatermarkableItem.Folder((FolderModel) itemModel);
        }
        return null;
    }
}
