package com.box.android.capture.audiorecording.cpl;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AudioCaptureReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class AudioCaptureReducer$build$6 extends FunctionReferenceImpl implements Function1<AudioReviewReducer.Action, AudioCaptureReducer.Action.Reviewing> {
    public static final AudioCaptureReducer$build$6 INSTANCE = new AudioCaptureReducer$build$6();

    AudioCaptureReducer$build$6() {
        super(1, AudioCaptureReducer.Action.Reviewing.class, "<init>", "<init>(Lcom/box/android/capture/audiorecording/cpl/AudioReviewReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final AudioCaptureReducer.Action.Reviewing invoke(AudioReviewReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new AudioCaptureReducer.Action.Reviewing(p0);
    }
}
