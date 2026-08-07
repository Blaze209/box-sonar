package com.box.android.preview.preview;

import com.box.android.preview.item.ItemPreviewReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviewScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class PreviewScreenKt$PreviewScreenContent$3$itemStore$2$1 extends FunctionReferenceImpl implements Function1<ItemPreviewReducer.Action, PreviewReducer.Action.SelectedItem> {
    public static final PreviewScreenKt$PreviewScreenContent$3$itemStore$2$1 INSTANCE = new PreviewScreenKt$PreviewScreenContent$3$itemStore$2$1();

    PreviewScreenKt$PreviewScreenContent$3$itemStore$2$1() {
        super(1, PreviewReducer.Action.SelectedItem.class, "<init>", "<init>(Lcom/box/android/preview/item/ItemPreviewReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final PreviewReducer.Action.SelectedItem invoke(ItemPreviewReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new PreviewReducer.Action.SelectedItem(p0);
    }
}
