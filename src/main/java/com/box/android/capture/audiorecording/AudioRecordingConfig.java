package com.box.android.capture.audiorecording;

import javax.inject.Inject;
import kotlin.Metadata;

/* JADX INFO: compiled from: AudioRecordingConstants.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/box/android/capture/audiorecording/AudioRecordingConfig;", "Lcom/box/android/capture/audiorecording/IAudioRecordingConfig;", "<init>", "()V", "getElapsedTimeDelay", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AudioRecordingConfig implements IAudioRecordingConfig {
    public static final int $stable = 0;

    @Override // com.box.android.capture.audiorecording.IAudioRecordingConfig
    public long getElapsedTimeDelay() {
        return 50L;
    }

    @Inject
    public AudioRecordingConfig() {
    }
}
