package com.box.android.preview.item;

import com.box.android.preview.previewtype.image.ImagePreviewReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemPreviewReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class ItemPreviewReducer$build$8 extends FunctionReferenceImpl implements Function1<ImagePreviewReducer.Action, ItemPreviewReducer.Action.ImagePreview> {
    public static final ItemPreviewReducer$build$8 INSTANCE = new ItemPreviewReducer$build$8();

    ItemPreviewReducer$build$8() {
        super(1, ItemPreviewReducer.Action.ImagePreview.class, "<init>", "<init>(Lcom/box/android/preview/previewtype/image/ImagePreviewReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final ItemPreviewReducer.Action.ImagePreview invoke(ImagePreviewReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new ItemPreviewReducer.Action.ImagePreview(p0);
    }
}
