package com.box.android.preview.item;

import com.box.android.preview.previewtype.gif.GifPreviewReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemPreviewReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class ItemPreviewReducer$build$11 extends FunctionReferenceImpl implements Function1<GifPreviewReducer.State, ItemState.Gif> {
    public static final ItemPreviewReducer$build$11 INSTANCE = new ItemPreviewReducer$build$11();

    ItemPreviewReducer$build$11() {
        super(1, ItemState.Gif.class, "<init>", "<init>(Lcom/box/android/preview/previewtype/gif/GifPreviewReducer$State;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final ItemState.Gif invoke(GifPreviewReducer.State p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new ItemState.Gif(p0);
    }
}
