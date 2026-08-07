package com.pspdfkit.ui.audio;

/* JADX INFO: loaded from: classes3.dex */
public interface AudioPlaybackController {

    public interface AudioPlaybackListener {
        void onError(AudioPlaybackController audioPlaybackController, Throwable th);

        void onPause(AudioPlaybackController audioPlaybackController);

        void onPlay(AudioPlaybackController audioPlaybackController);

        void onReady(AudioPlaybackController audioPlaybackController);

        void onStop(AudioPlaybackController audioPlaybackController);
    }

    void addAudioPlaybackListener(AudioPlaybackListener audioPlaybackListener);

    void exitAudioPlaybackMode();

    AudioModeManager getAudioModeManager();

    int getCurrentPosition();

    int getDuration();

    boolean isReady();

    boolean isResumed();

    void pause();

    void removeAudioPlaybackListener(AudioPlaybackListener audioPlaybackListener);

    void resume();

    void seekTo(int i);

    default void toggle() {
        if (isResumed()) {
            pause();
        } else {
            resume();
        }
    }
}
