package com.box.android.preview.item;

import com.box.android.preview.previewtype.image.ImagePreviewReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemPreviewReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class ItemPreviewReducer$build$7 extends FunctionReferenceImpl implements Function1<ImagePreviewReducer.State, ItemState.Image> {
    public static final ItemPreviewReducer$build$7 INSTANCE = new ItemPreviewReducer$build$7();

    ItemPreviewReducer$build$7() {
        super(1, ItemState.Image.class, "<init>", "<init>(Lcom/box/android/preview/previewtype/image/ImagePreviewReducer$State;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final ItemState.Image invoke(ImagePreviewReducer.State p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new ItemState.Image(p0);
    }
}
