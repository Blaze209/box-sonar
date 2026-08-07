package com.box.android.capture;

import android.media.MediaActionSound;
import com.box.android.common.utilities.CommonBoxUtil;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CaptureShutterSoundHelper.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/box/android/capture/CaptureShutterSoundHelper;", "Lcom/box/android/capture/ICaptureShutterSoundHelper;", "mediaActionSound", "Landroid/media/MediaActionSound;", "<init>", "(Landroid/media/MediaActionSound;)V", "mustPlayShutterSound", "", "playShutterSoundIfRequired", "", "playVideoRecordingStartedSoundIfRequired", "playVideoRecordingStoppedSoundIfRequired", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CaptureShutterSoundHelper implements ICaptureShutterSoundHelper {
    public static final int $stable = 8;
    private final MediaActionSound mediaActionSound;

    @Inject
    public CaptureShutterSoundHelper(MediaActionSound mediaActionSound) {
        Intrinsics.checkNotNullParameter(mediaActionSound, "mediaActionSound");
        this.mediaActionSound = mediaActionSound;
        if (mustPlayShutterSound()) {
            mediaActionSound.load(0);
            mediaActionSound.load(2);
            mediaActionSound.load(3);
        }
    }

    @Override // com.box.android.capture.ICaptureShutterSoundHelper
    public boolean mustPlayShutterSound() {
        return CommonBoxUtil.isAtLeastVersion(33) && MediaActionSound.mustPlayShutterSound();
    }

    @Override // com.box.android.capture.ICaptureShutterSoundHelper
    public void playShutterSoundIfRequired() {
        if (mustPlayShutterSound()) {
            this.mediaActionSound.play(0);
        }
    }

    @Override // com.box.android.capture.ICaptureShutterSoundHelper
    public void playVideoRecordingStartedSoundIfRequired() {
        if (mustPlayShutterSound()) {
            this.mediaActionSound.play(2);
        }
    }

    @Override // com.box.android.capture.ICaptureShutterSoundHelper
    public void playVideoRecordingStoppedSoundIfRequired() {
        if (mustPlayShutterSound()) {
            this.mediaActionSound.play(3);
        }
    }
}
