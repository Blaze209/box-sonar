package com.box.android.preview.item;

import com.box.android.cpl.ReducerResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemPreviewReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class ItemPreviewReducer$build$1 extends FunctionReferenceImpl implements Function2<ItemPreviewReducer.State, ItemPreviewReducer.Action, ReducerResult<ItemPreviewReducer.State, ItemPreviewReducer.Action>> {
    ItemPreviewReducer$build$1(Object obj) {
        super(2, obj, ItemPreviewReducer.class, "reduceItemPreview", "reduceItemPreview(Lcom/box/android/preview/item/ItemPreviewReducer$State;Lcom/box/android/preview/item/ItemPreviewReducer$Action;)Lcom/box/android/cpl/ReducerResult;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final ReducerResult<ItemPreviewReducer.State, ItemPreviewReducer.Action> invoke(ItemPreviewReducer.State p0, ItemPreviewReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return ((ItemPreviewReducer) this.receiver).reduceItemPreview(p0, p1);
    }
}
