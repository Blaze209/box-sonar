package com.box.android.capture.audiorecording.cpl;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AudioCaptureReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class AudioCaptureReducer$build$2 extends FunctionReferenceImpl implements Function1<AudioRecordingReducer.State, AudioCaptureReducer.State.Recording> {
    public static final AudioCaptureReducer$build$2 INSTANCE = new AudioCaptureReducer$build$2();

    AudioCaptureReducer$build$2() {
        super(1, AudioCaptureReducer.State.Recording.class, "<init>", "<init>(Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$State;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final AudioCaptureReducer.State.Recording invoke(AudioRecordingReducer.State p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new AudioCaptureReducer.State.Recording(p0);
    }
}
