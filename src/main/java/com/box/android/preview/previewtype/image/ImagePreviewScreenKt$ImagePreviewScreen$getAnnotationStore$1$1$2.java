package com.box.android.preview.previewtype.image;

import com.box.android.preview.annotations.cpl.AnnotationsReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImagePreviewScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class ImagePreviewScreenKt$ImagePreviewScreen$getAnnotationStore$1$1$2 extends FunctionReferenceImpl implements Function1<AnnotationsReducer.Action, ImagePreviewReducer.Action.Annotations> {
    public static final ImagePreviewScreenKt$ImagePreviewScreen$getAnnotationStore$1$1$2 INSTANCE = new ImagePreviewScreenKt$ImagePreviewScreen$getAnnotationStore$1$1$2();

    ImagePreviewScreenKt$ImagePreviewScreen$getAnnotationStore$1$1$2() {
        super(1, ImagePreviewReducer.Action.Annotations.class, "<init>", "<init>(Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final ImagePreviewReducer.Action.Annotations invoke(AnnotationsReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new ImagePreviewReducer.Action.Annotations(p0);
    }
}
