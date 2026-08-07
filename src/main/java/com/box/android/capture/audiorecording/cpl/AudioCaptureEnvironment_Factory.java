package com.box.android.capture.audiorecording.cpl;

import com.box.android.capture.audiorecording.RecordingFileManager;
import com.box.android.capture.audiorecording.logic.AudioRecordingHelper;
import com.box.android.capture.audiorecording.viewmodel.IRecorderServiceManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class AudioCaptureEnvironment_Factory implements Factory<AudioCaptureEnvironment> {
    private final Provider<AudioRecordingHelper> audioRecordingHelperProvider;
    private final Provider<IRecorderServiceManager> recorderServiceManagerProvider;
    private final Provider<RecordingFileManager> recordingFileManagerProvider;

    private AudioCaptureEnvironment_Factory(Provider<IRecorderServiceManager> provider, Provider<RecordingFileManager> provider2, Provider<AudioRecordingHelper> provider3) {
        this.recorderServiceManagerProvider = provider;
        this.recordingFileManagerProvider = provider2;
        this.audioRecordingHelperProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AudioCaptureEnvironment get() {
        return newInstance(this.recorderServiceManagerProvider.get(), this.recordingFileManagerProvider.get(), this.audioRecordingHelperProvider.get());
    }

    public static AudioCaptureEnvironment_Factory create(Provider<IRecorderServiceManager> provider, Provider<RecordingFileManager> provider2, Provider<AudioRecordingHelper> provider3) {
        return new AudioCaptureEnvironment_Factory(provider, provider2, provider3);
    }

    public static AudioCaptureEnvironment newInstance(IRecorderServiceManager iRecorderServiceManager, RecordingFileManager recordingFileManager, AudioRecordingHelper audioRecordingHelper) {
        return new AudioCaptureEnvironment(iRecorderServiceManager, recordingFileManager, audioRecordingHelper);
    }
}
