package com.pspdfkit.ui.audio;

import com.pspdfkit.annotations.SoundAnnotation;

/* JADX INFO: loaded from: classes3.dex */
public interface AudioModeManager extends AudioModeListeners {
    boolean canPlay(SoundAnnotation soundAnnotation);

    boolean canRecord(SoundAnnotation soundAnnotation);

    void enterAudioPlaybackMode(SoundAnnotation soundAnnotation);

    void enterAudioRecordingMode(SoundAnnotation soundAnnotation);

    void exitActiveAudioMode();
}
