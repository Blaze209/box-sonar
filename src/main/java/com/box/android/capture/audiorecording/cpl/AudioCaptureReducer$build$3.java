package com.box.android.capture.audiorecording.cpl;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AudioCaptureReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class AudioCaptureReducer$build$3 extends FunctionReferenceImpl implements Function1<AudioRecordingReducer.Action, AudioCaptureReducer.Action.Recording> {
    public static final AudioCaptureReducer$build$3 INSTANCE = new AudioCaptureReducer$build$3();

    AudioCaptureReducer$build$3() {
        super(1, AudioCaptureReducer.Action.Recording.class, "<init>", "<init>(Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final AudioCaptureReducer.Action.Recording invoke(AudioRecordingReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new AudioCaptureReducer.Action.Recording(p0);
    }
}
