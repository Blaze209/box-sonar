package com.box.android.preview.preview;

import com.box.android.domain.models.ItemId;
import com.box.android.preview.item.ItemPreviewReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviewReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class PreviewReducer$build$5 extends FunctionReferenceImpl implements Function2<ItemId, ItemPreviewReducer.Action, PreviewReducer.Action.Items> {
    public static final PreviewReducer$build$5 INSTANCE = new PreviewReducer$build$5();

    PreviewReducer$build$5() {
        super(2, PreviewReducer.Action.Items.class, "<init>", "<init>(Lcom/box/android/domain/models/ItemId;Lcom/box/android/preview/item/ItemPreviewReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final PreviewReducer.Action.Items invoke(ItemId p0, ItemPreviewReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return new PreviewReducer.Action.Items(p0, p1);
    }
}
