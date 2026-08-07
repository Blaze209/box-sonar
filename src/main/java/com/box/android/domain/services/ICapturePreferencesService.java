package com.box.android.domain.services;

import com.box.android.domain.models.capture.CaptureMode;
import com.box.android.domain.models.capture.FlashMode;
import com.box.android.domain.models.capture.PhotoQuality;
import com.box.android.domain.models.capture.VideoQuality;
import kotlin.Metadata;

/* JADX INFO: compiled from: ICapturePreferencesService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000bH&J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0010H&J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014H&J\b\u0010\u0015\u001a\u00020\u0014H&J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0018H&J\b\u0010\u0019\u001a\u00020\u0018H&J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001cH&J\b\u0010\u001d\u001a\u00020\u001cH&J\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0014H&J\b\u0010 \u001a\u00020\u0014H&¨\u0006!À\u0006\u0003"}, d2 = {"Lcom/box/android/domain/services/ICapturePreferencesService;", "", "getFlashModeOrDefault", "Lcom/box/android/domain/models/capture/FlashMode;", "default", "getFlashModeOrDefaultVideo", "saveFlashMode", "", "flashMode", "saveFlashModeVideo", "getUploadFolderId", "", "saveUploadFolderId", "folderId", "setLastUsedMode", "captureMode", "Lcom/box/android/domain/models/capture/CaptureMode;", "getLastUsedMode", "setReviewPhotoAfterCapture", "reviewAfterPhotoCapture", "", "getReviewPhotoAfterCapture", "setPhotoQuality", "photoQuality", "Lcom/box/android/domain/models/capture/PhotoQuality;", "getPhotoQuality", "setVideoQuality", "videoQuality", "Lcom/box/android/domain/models/capture/VideoQuality;", "getVideoQuality", "setSaveGpsLocation", "saveGpsLocation", "getSaveGpsLocation", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ICapturePreferencesService {
    FlashMode getFlashModeOrDefault(FlashMode flashMode);

    FlashMode getFlashModeOrDefaultVideo(FlashMode flashMode);

    CaptureMode getLastUsedMode(CaptureMode captureMode);

    PhotoQuality getPhotoQuality();

    boolean getReviewPhotoAfterCapture();

    boolean getSaveGpsLocation();

    String getUploadFolderId();

    VideoQuality getVideoQuality();

    void saveFlashMode(FlashMode flashMode);

    void saveFlashModeVideo(FlashMode flashMode);

    void saveUploadFolderId(String folderId);

    void setLastUsedMode(CaptureMode captureMode);

    void setPhotoQuality(PhotoQuality photoQuality);

    void setReviewPhotoAfterCapture(boolean reviewAfterPhotoCapture);

    void setSaveGpsLocation(boolean saveGpsLocation);

    void setVideoQuality(VideoQuality videoQuality);
}
