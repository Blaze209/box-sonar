package com.box.android.capture.audiorecording.cpl;

import android.app.Application;
import androidx.media3.common.MimeTypes;
import com.box.android.capture.audiorecording.IRecordManager;
import com.box.android.capture.audiorecording.RecordingFileManager;
import com.box.android.capture.audiorecording.logic.AudioRecordingHelper;
import com.box.android.capture.audiorecording.viewmodel.IRecorderServiceManager;
import com.box.android.common.utilities.ApplicationProvider;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AudioCaptureReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/box/android/capture/audiorecording/cpl/AudioCaptureEnvironment;", "", "recorderServiceManager", "Lcom/box/android/capture/audiorecording/viewmodel/IRecorderServiceManager;", "recordingFileManager", "Lcom/box/android/capture/audiorecording/RecordingFileManager;", "audioRecordingHelper", "Lcom/box/android/capture/audiorecording/logic/AudioRecordingHelper;", "<init>", "(Lcom/box/android/capture/audiorecording/viewmodel/IRecorderServiceManager;Lcom/box/android/capture/audiorecording/RecordingFileManager;Lcom/box/android/capture/audiorecording/logic/AudioRecordingHelper;)V", "getRecorderServiceManager", "()Lcom/box/android/capture/audiorecording/viewmodel/IRecorderServiceManager;", "getRecordingFileManager", "()Lcom/box/android/capture/audiorecording/RecordingFileManager;", "getAudioRecordingHelper", "()Lcom/box/android/capture/audiorecording/logic/AudioRecordingHelper;", "recordManager", "Lcom/box/android/capture/audiorecording/IRecordManager;", "getRecordManager", "()Lcom/box/android/capture/audiorecording/IRecordManager;", "setRecordManager", "(Lcom/box/android/capture/audiorecording/IRecordManager;)V", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "getApplication", "()Landroid/app/Application;", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AudioCaptureEnvironment {
    public static final int $stable = 8;
    private final Application application;
    private final AudioRecordingHelper audioRecordingHelper;
    private IRecordManager recordManager;
    private final IRecorderServiceManager recorderServiceManager;
    private final RecordingFileManager recordingFileManager;

    @Inject
    public AudioCaptureEnvironment(IRecorderServiceManager recorderServiceManager, RecordingFileManager recordingFileManager, AudioRecordingHelper audioRecordingHelper) {
        Intrinsics.checkNotNullParameter(recorderServiceManager, "recorderServiceManager");
        Intrinsics.checkNotNullParameter(recordingFileManager, "recordingFileManager");
        Intrinsics.checkNotNullParameter(audioRecordingHelper, "audioRecordingHelper");
        this.recorderServiceManager = recorderServiceManager;
        this.recordingFileManager = recordingFileManager;
        this.audioRecordingHelper = audioRecordingHelper;
        this.application = ApplicationProvider.getApplication();
    }

    public final IRecorderServiceManager getRecorderServiceManager() {
        return this.recorderServiceManager;
    }

    public final RecordingFileManager getRecordingFileManager() {
        return this.recordingFileManager;
    }

    public final AudioRecordingHelper getAudioRecordingHelper() {
        return this.audioRecordingHelper;
    }

    public final IRecordManager getRecordManager() {
        return this.recordManager;
    }

    public final void setRecordManager(IRecordManager iRecordManager) {
        this.recordManager = iRecordManager;
    }

    public final Application getApplication() {
        return this.application;
    }
}
