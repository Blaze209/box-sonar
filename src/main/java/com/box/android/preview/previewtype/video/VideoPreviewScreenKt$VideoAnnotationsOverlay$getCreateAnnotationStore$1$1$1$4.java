package com.box.android.preview.previewtype.video;

import com.box.android.preview.annotations.cpl.CreateAnnotationReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VideoPreviewScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class VideoPreviewScreenKt$VideoAnnotationsOverlay$getCreateAnnotationStore$1$1$1$4 extends FunctionReferenceImpl implements Function1<CreateAnnotationReducer.Action, FrameAnnotationReducer.Action.CreateAnnotation> {
    public static final VideoPreviewScreenKt$VideoAnnotationsOverlay$getCreateAnnotationStore$1$1$1$4 INSTANCE = new VideoPreviewScreenKt$VideoAnnotationsOverlay$getCreateAnnotationStore$1$1$1$4();

    VideoPreviewScreenKt$VideoAnnotationsOverlay$getCreateAnnotationStore$1$1$1$4() {
        super(1, FrameAnnotationReducer.Action.CreateAnnotation.class, "<init>", "<init>(Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FrameAnnotationReducer.Action.CreateAnnotation invoke(CreateAnnotationReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new FrameAnnotationReducer.Action.CreateAnnotation(p0);
    }
}
