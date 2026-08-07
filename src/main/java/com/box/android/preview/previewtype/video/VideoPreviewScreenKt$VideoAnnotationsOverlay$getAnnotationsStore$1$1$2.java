package com.box.android.preview.previewtype.video;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VideoPreviewScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class VideoPreviewScreenKt$VideoAnnotationsOverlay$getAnnotationsStore$1$1$2 extends FunctionReferenceImpl implements Function1<FrameAnnotationReducer.Action, VideoPreviewReducer.Action.FrameAnnotation> {
    public static final VideoPreviewScreenKt$VideoAnnotationsOverlay$getAnnotationsStore$1$1$2 INSTANCE = new VideoPreviewScreenKt$VideoAnnotationsOverlay$getAnnotationsStore$1$1$2();

    VideoPreviewScreenKt$VideoAnnotationsOverlay$getAnnotationsStore$1$1$2() {
        super(1, VideoPreviewReducer.Action.FrameAnnotation.class, "<init>", "<init>(Lcom/box/android/preview/previewtype/video/FrameAnnotationReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final VideoPreviewReducer.Action.FrameAnnotation invoke(FrameAnnotationReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new VideoPreviewReducer.Action.FrameAnnotation(p0);
    }
}
