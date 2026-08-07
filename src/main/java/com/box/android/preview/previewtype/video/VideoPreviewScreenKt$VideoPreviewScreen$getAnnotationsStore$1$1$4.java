package com.box.android.preview.previewtype.video;

import com.box.android.preview.annotations.cpl.AnnotationsReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VideoPreviewScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class VideoPreviewScreenKt$VideoPreviewScreen$getAnnotationsStore$1$1$4 extends FunctionReferenceImpl implements Function1<AnnotationsReducer.Action, FrameAnnotationReducer.Action.Annotations> {
    public static final VideoPreviewScreenKt$VideoPreviewScreen$getAnnotationsStore$1$1$4 INSTANCE = new VideoPreviewScreenKt$VideoPreviewScreen$getAnnotationsStore$1$1$4();

    VideoPreviewScreenKt$VideoPreviewScreen$getAnnotationsStore$1$1$4() {
        super(1, FrameAnnotationReducer.Action.Annotations.class, "<init>", "<init>(Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FrameAnnotationReducer.Action.Annotations invoke(AnnotationsReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new FrameAnnotationReducer.Action.Annotations(p0);
    }
}
