package com.box.android.preview.preview;

import com.box.android.preview.item.ItemPreviewReducer;
import com.box.android.preview.previewtype.gif.GifPreviewReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviewReducerScoping.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class PreviewReducerScopingKt$gifStore$2 extends FunctionReferenceImpl implements Function1<GifPreviewReducer.Action, ItemPreviewReducer.Action.GifPreview> {
    public static final PreviewReducerScopingKt$gifStore$2 INSTANCE = new PreviewReducerScopingKt$gifStore$2();

    PreviewReducerScopingKt$gifStore$2() {
        super(1, ItemPreviewReducer.Action.GifPreview.class, "<init>", "<init>(Lcom/box/android/preview/previewtype/gif/GifPreviewReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final ItemPreviewReducer.Action.GifPreview invoke(GifPreviewReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new ItemPreviewReducer.Action.GifPreview(p0);
    }
}
