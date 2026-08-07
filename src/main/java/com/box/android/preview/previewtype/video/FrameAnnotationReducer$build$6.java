package com.box.android.preview.previewtype.video;

import com.box.android.preview.annotations.cpl.AnnotationsReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FrameAnnotationReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class FrameAnnotationReducer$build$6 extends FunctionReferenceImpl implements Function1<AnnotationsReducer.Action, FrameAnnotationReducer.Action.Annotations> {
    public static final FrameAnnotationReducer$build$6 INSTANCE = new FrameAnnotationReducer$build$6();

    FrameAnnotationReducer$build$6() {
        super(1, FrameAnnotationReducer.Action.Annotations.class, "<init>", "<init>(Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FrameAnnotationReducer.Action.Annotations invoke(AnnotationsReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new FrameAnnotationReducer.Action.Annotations(p0);
    }
}
