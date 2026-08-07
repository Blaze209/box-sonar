package com.box.android.domain.mappers;

import com.box.android.domain.models.item.ItemModel;
import com.box.androidsdk.content.utils.BoxLogUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemModelMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toBoxItemId", "", "Lcom/box/android/domain/models/item/ItemModel;", "domain_prodRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ItemModelMapperKt {
    public static final String toBoxItemId(ItemModel itemModel) {
        Intrinsics.checkNotNullParameter(itemModel, "<this>");
        String strBoxIdOrNull = itemModel.boxIdOrNull();
        if (strBoxIdOrNull != null) {
            return strBoxIdOrNull;
        }
        BoxLogUtils.e("ItemModelMapper", "BoxItem is created from ItemModel with local id " + itemModel.getItemId() + ". This is logic error.");
        return itemModel.getItemId().toString();
    }
}
