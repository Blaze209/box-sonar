package com.box.android.capture.audiorecording;

import com.box.android.capture.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: RecorderService.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001d\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/box/android/capture/audiorecording/RecordingFileState;", "", "messageId", "", "messageElapsedTimeId", "<init>", "(Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/Integer;)V", "getMessageId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMessageElapsedTimeId", "RECORDING", "PAUSED", "NOT_RECORDING", "AUTO_PAUSED", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum RecordingFileState {
    RECORDING(Integer.valueOf(R.string.audio_recording_recording), Integer.valueOf(R.string.audio_recording_recording_elapsed_time)),
    PAUSED(Integer.valueOf(R.string.audio_recording_paused), Integer.valueOf(R.string.audio_recording_paused_elapsed_time)),
    NOT_RECORDING(Integer.valueOf(R.string.audio_recording_ready_to_record), null),
    AUTO_PAUSED(Integer.valueOf(R.string.audio_recording_paused), Integer.valueOf(R.string.audio_recording_paused_elapsed_time));

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final Integer messageElapsedTimeId;
    private final Integer messageId;

    public static EnumEntries<RecordingFileState> getEntries() {
        return $ENTRIES;
    }

    RecordingFileState(Integer num, Integer num2) {
        this.messageId = num;
        this.messageElapsedTimeId = num2;
    }

    public final Integer getMessageElapsedTimeId() {
        return this.messageElapsedTimeId;
    }

    public final Integer getMessageId() {
        return this.messageId;
    }
}
