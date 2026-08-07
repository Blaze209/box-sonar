package com.box.android.preview.previewtype.gif;

import com.box.android.cpl.ReducerResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GifPreviewReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class GifPreviewReducer$build$1 extends FunctionReferenceImpl implements Function2<GifPreviewReducer.State, GifPreviewReducer.Action, ReducerResult<GifPreviewReducer.State, GifPreviewReducer.Action>> {
    GifPreviewReducer$build$1(Object obj) {
        super(2, obj, GifPreviewReducer.class, "reduceGifPreview", "reduceGifPreview(Lcom/box/android/preview/previewtype/gif/GifPreviewReducer$State;Lcom/box/android/preview/previewtype/gif/GifPreviewReducer$Action;)Lcom/box/android/cpl/ReducerResult;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final ReducerResult<GifPreviewReducer.State, GifPreviewReducer.Action> invoke(GifPreviewReducer.State p0, GifPreviewReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return ((GifPreviewReducer) this.receiver).reduceGifPreview(p0, p1);
    }
}
