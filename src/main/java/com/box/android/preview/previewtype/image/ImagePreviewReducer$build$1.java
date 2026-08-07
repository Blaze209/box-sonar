package com.box.android.preview.previewtype.image;

import com.box.android.cpl.ReducerResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImagePreviewReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class ImagePreviewReducer$build$1 extends FunctionReferenceImpl implements Function2<ImagePreviewReducer.State, ImagePreviewReducer.Action, ReducerResult<ImagePreviewReducer.State, ImagePreviewReducer.Action>> {
    ImagePreviewReducer$build$1(Object obj) {
        super(2, obj, ImagePreviewReducer.class, "reduceImagePreview", "reduceImagePreview(Lcom/box/android/preview/previewtype/image/ImagePreviewReducer$State;Lcom/box/android/preview/previewtype/image/ImagePreviewReducer$Action;)Lcom/box/android/cpl/ReducerResult;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final ReducerResult<ImagePreviewReducer.State, ImagePreviewReducer.Action> invoke(ImagePreviewReducer.State p0, ImagePreviewReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return ((ImagePreviewReducer) this.receiver).reduceImagePreview(p0, p1);
    }
}
