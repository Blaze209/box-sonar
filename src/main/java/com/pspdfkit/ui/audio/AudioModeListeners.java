package com.pspdfkit.ui.audio;

/* JADX INFO: loaded from: classes3.dex */
public interface AudioModeListeners {

    public interface AudioPlaybackModeChangeListener {
        void onChangeAudioPlaybackMode(AudioPlaybackController audioPlaybackController);

        void onEnterAudioPlaybackMode(AudioPlaybackController audioPlaybackController);

        void onExitAudioPlaybackMode(AudioPlaybackController audioPlaybackController);
    }

    public interface AudioRecordingModeChangeListener {
        void onChangeAudioRecordingMode(AudioRecordingController audioRecordingController);

        void onEnterAudioRecordingMode(AudioRecordingController audioRecordingController);

        void onExitAudioRecordingMode(AudioRecordingController audioRecordingController);
    }

    void addAudioPlaybackModeChangeListener(AudioPlaybackModeChangeListener audioPlaybackModeChangeListener);

    void addAudioRecordingModeChangeListener(AudioRecordingModeChangeListener audioRecordingModeChangeListener);

    void removeAudioPlaybackModeChangeListener(AudioPlaybackModeChangeListener audioPlaybackModeChangeListener);

    void removeAudioRecordingModeChangeListener(AudioRecordingModeChangeListener audioRecordingModeChangeListener);
}
