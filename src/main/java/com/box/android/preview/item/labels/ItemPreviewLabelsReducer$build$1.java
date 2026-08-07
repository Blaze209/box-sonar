package com.box.android.preview.item.labels;

import com.box.android.cpl.ReducerResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemPreviewLabelsReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class ItemPreviewLabelsReducer$build$1 extends FunctionReferenceImpl implements Function2<ItemPreviewLabelsReducer.State, ItemPreviewLabelsReducer.Action, ReducerResult<ItemPreviewLabelsReducer.State, ItemPreviewLabelsReducer.Action>> {
    ItemPreviewLabelsReducer$build$1(Object obj) {
        super(2, obj, ItemPreviewLabelsReducer.class, "reduceLabels", "reduceLabels(Lcom/box/android/preview/item/labels/ItemPreviewLabelsReducer$State;Lcom/box/android/preview/item/labels/ItemPreviewLabelsReducer$Action;)Lcom/box/android/cpl/ReducerResult;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final ReducerResult<ItemPreviewLabelsReducer.State, ItemPreviewLabelsReducer.Action> invoke(ItemPreviewLabelsReducer.State p0, ItemPreviewLabelsReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return ((ItemPreviewLabelsReducer) this.receiver).reduceLabels(p0, p1);
    }
}
