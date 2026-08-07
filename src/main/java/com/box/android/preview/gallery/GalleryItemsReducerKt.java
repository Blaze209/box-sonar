package com.box.android.preview.gallery;

import com.box.android.base.cpl.ItemThumbnailReducer;
import com.box.android.base.cpl.ThumbnailSource;
import com.box.android.domain.models.item.ItemModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GalleryItemsReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"itemModel", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/base/cpl/ItemThumbnailReducer$State;", "preview_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class GalleryItemsReducerKt {
    public static final ItemModel itemModel(ItemThumbnailReducer.State state) {
        Intrinsics.checkNotNullParameter(state, "<this>");
        ThumbnailSource source = state.getSource();
        Intrinsics.checkNotNull(source, "null cannot be cast to non-null type com.box.android.base.cpl.ThumbnailSource.Item");
        return ((ThumbnailSource.Item) source).getItemModel();
    }
}
