package com.box.android.capture.videorecording;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VideoCaptureReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class VideoCaptureReducer$build$3 extends FunctionReferenceImpl implements Function1<VideoRecordingReducer.Action, VideoCaptureReducer.Action.Recording> {
    public static final VideoCaptureReducer$build$3 INSTANCE = new VideoCaptureReducer$build$3();

    VideoCaptureReducer$build$3() {
        super(1, VideoCaptureReducer.Action.Recording.class, "<init>", "<init>(Lcom/box/android/capture/videorecording/VideoRecordingReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final VideoCaptureReducer.Action.Recording invoke(VideoRecordingReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new VideoCaptureReducer.Action.Recording(p0);
    }
}
