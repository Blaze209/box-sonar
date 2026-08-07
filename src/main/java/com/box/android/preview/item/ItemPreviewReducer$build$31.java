package com.box.android.preview.item;

import com.box.android.preview.item.labels.ItemPreviewLabelsReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemPreviewReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class ItemPreviewReducer$build$31 extends FunctionReferenceImpl implements Function1<ItemPreviewLabelsReducer.Action, ItemPreviewReducer.Action.Labels> {
    public static final ItemPreviewReducer$build$31 INSTANCE = new ItemPreviewReducer$build$31();

    ItemPreviewReducer$build$31() {
        super(1, ItemPreviewReducer.Action.Labels.class, "<init>", "<init>(Lcom/box/android/preview/item/labels/ItemPreviewLabelsReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final ItemPreviewReducer.Action.Labels invoke(ItemPreviewLabelsReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new ItemPreviewReducer.Action.Labels(p0);
    }
}
