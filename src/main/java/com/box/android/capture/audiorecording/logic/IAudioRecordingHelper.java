package com.box.android.capture.audiorecording.logic;

import android.content.Context;
import com.box.android.domain.models.DomainError;
import kotlin.Metadata;

/* JADX INFO: compiled from: AudioRecordingHelper.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003H&J(\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lcom/box/android/capture/audiorecording/logic/IAudioRecordingHelper;", "", "getMessageForError", "", "error", "Lcom/box/android/domain/models/DomainError;", "logEvent", "", "context", "Landroid/content/Context;", "eventName", "logAudioRecordingEvent", "recordedFileDurationInMinutes", "recordedFileSize", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IAudioRecordingHelper {
    String getMessageForError(DomainError error);

    void logAudioRecordingEvent(Context context, String eventName, String recordedFileDurationInMinutes, long recordedFileSize);

    void logEvent(Context context, String eventName);
}
