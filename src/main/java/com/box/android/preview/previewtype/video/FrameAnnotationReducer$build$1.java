package com.box.android.preview.previewtype.video;

import com.box.android.cpl.ReducerResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FrameAnnotationReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class FrameAnnotationReducer$build$1 extends FunctionReferenceImpl implements Function2<FrameAnnotationReducer.State, FrameAnnotationReducer.Action, ReducerResult<FrameAnnotationReducer.State, FrameAnnotationReducer.Action>> {
    FrameAnnotationReducer$build$1(Object obj) {
        super(2, obj, FrameAnnotationReducer.class, "reduceFrameAnnotation", "reduceFrameAnnotation(Lcom/box/android/preview/previewtype/video/FrameAnnotationReducer$State;Lcom/box/android/preview/previewtype/video/FrameAnnotationReducer$Action;)Lcom/box/android/cpl/ReducerResult;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final ReducerResult<FrameAnnotationReducer.State, FrameAnnotationReducer.Action> invoke(FrameAnnotationReducer.State p0, FrameAnnotationReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return ((FrameAnnotationReducer) this.receiver).reduceFrameAnnotation(p0, p1);
    }
}
