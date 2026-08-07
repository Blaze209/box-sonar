package com.box.android.preview.previewtype.image;

import com.box.android.preview.annotations.cpl.CreateAnnotationReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImagePreviewScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class ImagePreviewScreenKt$ImagePreviewScreen$getCreateAnnotationStore$1$1$1$2 extends FunctionReferenceImpl implements Function1<CreateAnnotationReducer.Action, ImagePreviewReducer.Action.CreateAnnotation> {
    public static final ImagePreviewScreenKt$ImagePreviewScreen$getCreateAnnotationStore$1$1$1$2 INSTANCE = new ImagePreviewScreenKt$ImagePreviewScreen$getCreateAnnotationStore$1$1$1$2();

    ImagePreviewScreenKt$ImagePreviewScreen$getCreateAnnotationStore$1$1$1$2() {
        super(1, ImagePreviewReducer.Action.CreateAnnotation.class, "<init>", "<init>(Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final ImagePreviewReducer.Action.CreateAnnotation invoke(CreateAnnotationReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new ImagePreviewReducer.Action.CreateAnnotation(p0);
    }
}
