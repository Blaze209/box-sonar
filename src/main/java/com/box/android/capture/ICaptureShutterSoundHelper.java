package com.box.android.capture;

import kotlin.Metadata;

/* JADX INFO: compiled from: CaptureShutterSoundHelper.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0007H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/box/android/capture/ICaptureShutterSoundHelper;", "", "playShutterSoundIfRequired", "", "playVideoRecordingStartedSoundIfRequired", "playVideoRecordingStoppedSoundIfRequired", "mustPlayShutterSound", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ICaptureShutterSoundHelper {
    boolean mustPlayShutterSound();

    void playShutterSoundIfRequired();

    void playVideoRecordingStartedSoundIfRequired();

    void playVideoRecordingStoppedSoundIfRequired();
}
