package com.box.android.capture.cpl;

import com.box.android.capture.videorecording.VideoCaptureReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CaptureReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class CaptureReducer$build$6 extends FunctionReferenceImpl implements Function1<VideoCaptureReducer.Action, CaptureReducer.Action.Video> {
    public static final CaptureReducer$build$6 INSTANCE = new CaptureReducer$build$6();

    CaptureReducer$build$6() {
        super(1, CaptureReducer.Action.Video.class, "<init>", "<init>(Lcom/box/android/capture/videorecording/VideoCaptureReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final CaptureReducer.Action.Video invoke(VideoCaptureReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new CaptureReducer.Action.Video(p0);
    }
}
