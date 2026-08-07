package com.pspdfkit.ui.audio;

import io.reactivex.rxjava3.core.Flowable;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public interface AudioRecordingController {

    public interface AudioRecordingListener {
        void onError(AudioRecordingController audioRecordingController, Throwable th);

        void onPause(AudioRecordingController audioRecordingController);

        void onReady(AudioRecordingController audioRecordingController);

        void onRecord(AudioRecordingController audioRecordingController);

        void onSave(AudioRecordingController audioRecordingController);

        void onStop(AudioRecordingController audioRecordingController);
    }

    void addAudioRecordingListener(AudioRecordingListener audioRecordingListener);

    void discardRecording();

    default void exitAudioRecordingMode() {
        exitAudioRecordingMode(false);
    }

    void exitAudioRecordingMode(boolean z);

    AudioModeManager getAudioModeManager();

    int getCurrentPosition();

    int getRecordingTimeLimit();

    Flowable<ByteBuffer> getVisualizerFlowable();

    boolean isReady();

    boolean isResumed();

    void pause();

    void removeAudioRecordingListener(AudioRecordingListener audioRecordingListener);

    void resume();

    default void toggle() {
        if (isResumed()) {
            pause();
        } else {
            resume();
        }
    }
}
