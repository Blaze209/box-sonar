package com.pspdfkit.internal;

import com.pspdfkit.ui.audio.AudioModeListeners;

/* JADX INFO: loaded from: classes3.dex */
public final class x5 implements AudioModeListeners {
    public final go<AudioModeListeners.AudioPlaybackModeChangeListener> a = new go<>();
    public final go<AudioModeListeners.AudioRecordingModeChangeListener> b = new go<>();

    @Override // com.pspdfkit.ui.audio.AudioModeListeners
    public final void addAudioPlaybackModeChangeListener(AudioModeListeners.AudioPlaybackModeChangeListener audioPlaybackModeChangeListener) {
        audioPlaybackModeChangeListener.getClass();
        this.a.a(audioPlaybackModeChangeListener);
    }

    @Override // com.pspdfkit.ui.audio.AudioModeListeners
    public final void addAudioRecordingModeChangeListener(AudioModeListeners.AudioRecordingModeChangeListener audioRecordingModeChangeListener) {
        audioRecordingModeChangeListener.getClass();
        this.b.a(audioRecordingModeChangeListener);
    }

    @Override // com.pspdfkit.ui.audio.AudioModeListeners
    public final void removeAudioPlaybackModeChangeListener(AudioModeListeners.AudioPlaybackModeChangeListener audioPlaybackModeChangeListener) {
        audioPlaybackModeChangeListener.getClass();
        this.a.b(audioPlaybackModeChangeListener);
    }

    @Override // com.pspdfkit.ui.audio.AudioModeListeners
    public final void removeAudioRecordingModeChangeListener(AudioModeListeners.AudioRecordingModeChangeListener audioRecordingModeChangeListener) {
        audioRecordingModeChangeListener.getClass();
        this.b.b(audioRecordingModeChangeListener);
    }
}
