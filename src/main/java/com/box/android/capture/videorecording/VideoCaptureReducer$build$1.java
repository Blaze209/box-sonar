package com.box.android.capture.videorecording;

import com.box.android.cpl.ReducerResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VideoCaptureReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class VideoCaptureReducer$build$1 extends FunctionReferenceImpl implements Function2<VideoCaptureReducer.State, VideoCaptureReducer.Action, ReducerResult<VideoCaptureReducer.State, VideoCaptureReducer.Action>> {
    VideoCaptureReducer$build$1(Object obj) {
        super(2, obj, VideoCaptureReducer.class, "reduceVideoCapture", "reduceVideoCapture(Lcom/box/android/capture/videorecording/VideoCaptureReducer$State;Lcom/box/android/capture/videorecording/VideoCaptureReducer$Action;)Lcom/box/android/cpl/ReducerResult;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final ReducerResult<VideoCaptureReducer.State, VideoCaptureReducer.Action> invoke(VideoCaptureReducer.State p0, VideoCaptureReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return ((VideoCaptureReducer) this.receiver).reduceVideoCapture(p0, p1);
    }
}
