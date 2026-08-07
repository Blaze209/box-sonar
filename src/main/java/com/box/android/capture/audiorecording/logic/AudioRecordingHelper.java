package com.box.android.capture.audiorecording.logic;

import android.content.Context;
import com.box.android.capture.R;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.AudioRecordingError;
import com.box.android.domain.models.DomainError;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AudioRecordingHelper.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0016J(\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0011"}, d2 = {"Lcom/box/android/capture/audiorecording/logic/AudioRecordingHelper;", "Lcom/box/android/capture/audiorecording/logic/IAudioRecordingHelper;", "<init>", "()V", "getMessageForError", "", "error", "Lcom/box/android/domain/models/DomainError;", "logEvent", "", "context", "Landroid/content/Context;", "eventName", "logAudioRecordingEvent", "recordedFileDurationInMinutes", "recordedFileSize", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AudioRecordingHelper implements IAudioRecordingHelper {
    public static final int $stable = 0;

    @Inject
    public AudioRecordingHelper() {
    }

    @Override // com.box.android.capture.audiorecording.logic.IAudioRecordingHelper
    public String getMessageForError(DomainError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        if (error instanceof AudioRecordingError.MicrophoneInUseError) {
            return CommonBoxUtil.LS(R.string.audio_recording_error_microphone_in_use);
        }
        return CommonBoxUtil.LS(R.string.audio_recording_error_generic);
    }

    @Override // com.box.android.capture.audiorecording.logic.IAudioRecordingHelper
    public void logEvent(Context context, String eventName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        BoxAmplitudeAnalytics.createEventBuilder().logEvent(eventName);
    }

    @Override // com.box.android.capture.audiorecording.logic.IAudioRecordingHelper
    public void logAudioRecordingEvent(Context context, String eventName, String recordedFileDurationInMinutes, long recordedFileSize) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(recordedFileDurationInMinutes, "recordedFileDurationInMinutes");
        BoxAmplitudeAnalytics.createAudioRecordingEventBuilder().setDurationInMinutes(recordedFileDurationInMinutes).setFileSize(recordedFileSize).logEvent(eventName);
    }
}
