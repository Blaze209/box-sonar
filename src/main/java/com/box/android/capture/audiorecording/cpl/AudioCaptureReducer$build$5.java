package com.box.android.capture.audiorecording.cpl;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AudioCaptureReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class AudioCaptureReducer$build$5 extends FunctionReferenceImpl implements Function1<AudioReviewReducer.State, AudioCaptureReducer.State.Review> {
    public static final AudioCaptureReducer$build$5 INSTANCE = new AudioCaptureReducer$build$5();

    AudioCaptureReducer$build$5() {
        super(1, AudioCaptureReducer.State.Review.class, "<init>", "<init>(Lcom/box/android/capture/audiorecording/cpl/AudioReviewReducer$State;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final AudioCaptureReducer.State.Review invoke(AudioReviewReducer.State p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new AudioCaptureReducer.State.Review(p0);
    }
}
