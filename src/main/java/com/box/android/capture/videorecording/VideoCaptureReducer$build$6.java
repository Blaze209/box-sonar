package com.box.android.capture.videorecording;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VideoCaptureReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class VideoCaptureReducer$build$6 extends FunctionReferenceImpl implements Function1<VideoReviewReducer.Action, VideoCaptureReducer.Action.Reviewing> {
    public static final VideoCaptureReducer$build$6 INSTANCE = new VideoCaptureReducer$build$6();

    VideoCaptureReducer$build$6() {
        super(1, VideoCaptureReducer.Action.Reviewing.class, "<init>", "<init>(Lcom/box/android/capture/videorecording/VideoReviewReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final VideoCaptureReducer.Action.Reviewing invoke(VideoReviewReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new VideoCaptureReducer.Action.Reviewing(p0);
    }
}
