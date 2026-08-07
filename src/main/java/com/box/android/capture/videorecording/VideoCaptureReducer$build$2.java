package com.box.android.capture.videorecording;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VideoCaptureReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class VideoCaptureReducer$build$2 extends FunctionReferenceImpl implements Function1<VideoRecordingReducer.State, VideoCaptureReducer.State.Recording> {
    public static final VideoCaptureReducer$build$2 INSTANCE = new VideoCaptureReducer$build$2();

    VideoCaptureReducer$build$2() {
        super(1, VideoCaptureReducer.State.Recording.class, "<init>", "<init>(Lcom/box/android/capture/videorecording/VideoRecordingReducer$State;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final VideoCaptureReducer.State.Recording invoke(VideoRecordingReducer.State p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new VideoCaptureReducer.State.Recording(p0);
    }
}
