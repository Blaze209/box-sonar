package com.box.android.capture.audiorecording.cpl;

import com.box.android.cpl.ReducerResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AudioCaptureReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class AudioCaptureReducer$build$1 extends FunctionReferenceImpl implements Function2<AudioCaptureReducer.State, AudioCaptureReducer.Action, ReducerResult<AudioCaptureReducer.State, AudioCaptureReducer.Action>> {
    AudioCaptureReducer$build$1(Object obj) {
        super(2, obj, AudioCaptureReducer.class, "reduceAudioCapture", "reduceAudioCapture(Lcom/box/android/capture/audiorecording/cpl/AudioCaptureReducer$State;Lcom/box/android/capture/audiorecording/cpl/AudioCaptureReducer$Action;)Lcom/box/android/cpl/ReducerResult;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final ReducerResult<AudioCaptureReducer.State, AudioCaptureReducer.Action> invoke(AudioCaptureReducer.State p0, AudioCaptureReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return ((AudioCaptureReducer) this.receiver).reduceAudioCapture(p0, p1);
    }
}
