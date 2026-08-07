package com.box.android.capture.videorecording;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VideoCaptureReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class VideoCaptureReducer$build$5 extends FunctionReferenceImpl implements Function1<VideoReviewReducer.State, VideoCaptureReducer.State.Reviewing> {
    public static final VideoCaptureReducer$build$5 INSTANCE = new VideoCaptureReducer$build$5();

    VideoCaptureReducer$build$5() {
        super(1, VideoCaptureReducer.State.Reviewing.class, "<init>", "<init>(Lcom/box/android/capture/videorecording/VideoReviewReducer$State;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final VideoCaptureReducer.State.Reviewing invoke(VideoReviewReducer.State p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new VideoCaptureReducer.State.Reviewing(p0);
    }
}
