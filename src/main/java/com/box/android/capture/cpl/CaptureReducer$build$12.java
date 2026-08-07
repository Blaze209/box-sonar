package com.box.android.capture.cpl;

import com.box.android.capture.audiorecording.cpl.AudioCaptureReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CaptureReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class CaptureReducer$build$12 extends FunctionReferenceImpl implements Function1<AudioCaptureReducer.Action, CaptureReducer.Action.AudioRecording> {
    public static final CaptureReducer$build$12 INSTANCE = new CaptureReducer$build$12();

    CaptureReducer$build$12() {
        super(1, CaptureReducer.Action.AudioRecording.class, "<init>", "<init>(Lcom/box/android/capture/audiorecording/cpl/AudioCaptureReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final CaptureReducer.Action.AudioRecording invoke(AudioCaptureReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new CaptureReducer.Action.AudioRecording(p0);
    }
}
