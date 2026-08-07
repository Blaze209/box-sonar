package com.box.android.data.service.impl;

import android.content.SharedPreferences;
import com.box.android.domain.models.capture.CaptureMode;
import com.box.android.domain.models.capture.FlashMode;
import com.box.android.domain.models.capture.PhotoQuality;
import com.box.android.domain.models.capture.VideoQuality;
import com.box.android.domain.services.ICapturePreferencesService;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CapturePreferencesService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 '2\u00020\u0001:\u0001'B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u0016H\u0016J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\u0010\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\"H\u0016J\u0010\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020\u001aH\u0016J\b\u0010&\u001a\u00020\u001aH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006("}, d2 = {"Lcom/box/android/data/service/impl/CapturePreferencesService;", "Lcom/box/android/domain/services/ICapturePreferencesService;", "captureSharedPrefs", "Landroid/content/SharedPreferences;", "<init>", "(Landroid/content/SharedPreferences;)V", "getCaptureSharedPrefs", "()Landroid/content/SharedPreferences;", "getFlashModeOrDefault", "Lcom/box/android/domain/models/capture/FlashMode;", "default", "getFlashModeOrDefaultVideo", "saveFlashMode", "", "flashMode", "saveFlashModeVideo", "getUploadFolderId", "", "saveUploadFolderId", "folderId", "setLastUsedMode", "captureMode", "Lcom/box/android/domain/models/capture/CaptureMode;", "getLastUsedMode", "setReviewPhotoAfterCapture", "reviewAfterPhotoCapture", "", "getReviewPhotoAfterCapture", "setPhotoQuality", "photoQuality", "Lcom/box/android/domain/models/capture/PhotoQuality;", "getPhotoQuality", "setVideoQuality", "videoQuality", "Lcom/box/android/domain/models/capture/VideoQuality;", "getVideoQuality", "setSaveGpsLocation", "saveGpsLocation", "getSaveGpsLocation", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CapturePreferencesService implements ICapturePreferencesService {
    public static final String FOLDER_UPLOAD_KEY = "folderUploadKey";
    public static final String LAST_USED_MODE_KEY = "lastUsedModeKey";
    public static final String PHOTO_QUALITY_KEY = "photoQualityKey";
    public static final String REVIEW_PHOTO_AFTER_CAPTURE_KEY = "reviewPhotoAfterCaptureKey";
    public static final String SAVE_GPS_LOCATION_KEY = "saveGpsLocationKey";
    public static final String USER_FLASH_PREF_KEY = "captureFlashPrefKey";
    public static final String USER_FLASH_PREF_VIDEO_KEY = "captureFlashPrefVideoKey";
    public static final String VIDEO_QUALITY_KEY = "videoQualitykey";
    private final SharedPreferences captureSharedPrefs;

    @Inject
    public CapturePreferencesService(@Named("capture_shared_preferences") SharedPreferences captureSharedPrefs) {
        Intrinsics.checkNotNullParameter(captureSharedPrefs, "captureSharedPrefs");
        this.captureSharedPrefs = captureSharedPrefs;
    }

    public final SharedPreferences getCaptureSharedPrefs() {
        return this.captureSharedPrefs;
    }

    @Override // com.box.android.domain.services.ICapturePreferencesService
    public FlashMode getFlashModeOrDefault(FlashMode flashMode) {
        Intrinsics.checkNotNullParameter(flashMode, "default");
        return FlashMode.INSTANCE.from(this.captureSharedPrefs.getInt(USER_FLASH_PREF_KEY, flashMode.intValue()));
    }

    @Override // com.box.android.domain.services.ICapturePreferencesService
    public FlashMode getFlashModeOrDefaultVideo(FlashMode flashMode) {
        Intrinsics.checkNotNullParameter(flashMode, "default");
        return FlashMode.INSTANCE.from(this.captureSharedPrefs.getInt(USER_FLASH_PREF_VIDEO_KEY, flashMode.intValue()));
    }

    @Override // com.box.android.domain.services.ICapturePreferencesService
    public void saveFlashMode(FlashMode flashMode) {
        Intrinsics.checkNotNullParameter(flashMode, "flashMode");
        this.captureSharedPrefs.edit().putInt(USER_FLASH_PREF_KEY, flashMode.intValue()).apply();
    }

    @Override // com.box.android.domain.services.ICapturePreferencesService
    public void saveFlashModeVideo(FlashMode flashMode) {
        Intrinsics.checkNotNullParameter(flashMode, "flashMode");
        this.captureSharedPrefs.edit().putInt(USER_FLASH_PREF_VIDEO_KEY, flashMode.intValue()).apply();
    }

    @Override // com.box.android.domain.services.ICapturePreferencesService
    public String getUploadFolderId() {
        return this.captureSharedPrefs.getString(FOLDER_UPLOAD_KEY, null);
    }

    @Override // com.box.android.domain.services.ICapturePreferencesService
    public void saveUploadFolderId(String folderId) {
        Intrinsics.checkNotNullParameter(folderId, "folderId");
        this.captureSharedPrefs.edit().putString(FOLDER_UPLOAD_KEY, folderId).apply();
    }

    @Override // com.box.android.domain.services.ICapturePreferencesService
    public void setLastUsedMode(CaptureMode captureMode) {
        Intrinsics.checkNotNullParameter(captureMode, "captureMode");
        this.captureSharedPrefs.edit().putString(LAST_USED_MODE_KEY, captureMode.name()).apply();
    }

    @Override // com.box.android.domain.services.ICapturePreferencesService
    public CaptureMode getLastUsedMode(CaptureMode captureMode) {
        Intrinsics.checkNotNullParameter(captureMode, "default");
        String string = this.captureSharedPrefs.getString(LAST_USED_MODE_KEY, null);
        if (string == null) {
            return captureMode;
        }
        try {
            return CaptureMode.valueOf(string);
        } catch (IllegalArgumentException unused) {
            return captureMode;
        }
    }

    @Override // com.box.android.domain.services.ICapturePreferencesService
    public void setReviewPhotoAfterCapture(boolean reviewAfterPhotoCapture) {
        this.captureSharedPrefs.edit().putBoolean(REVIEW_PHOTO_AFTER_CAPTURE_KEY, reviewAfterPhotoCapture).apply();
    }

    @Override // com.box.android.domain.services.ICapturePreferencesService
    public boolean getReviewPhotoAfterCapture() {
        return this.captureSharedPrefs.getBoolean(REVIEW_PHOTO_AFTER_CAPTURE_KEY, true);
    }

    @Override // com.box.android.domain.services.ICapturePreferencesService
    public void setPhotoQuality(PhotoQuality photoQuality) {
        Intrinsics.checkNotNullParameter(photoQuality, "photoQuality");
        this.captureSharedPrefs.edit().putString(PHOTO_QUALITY_KEY, photoQuality.name()).apply();
    }

    @Override // com.box.android.domain.services.ICapturePreferencesService
    public PhotoQuality getPhotoQuality() {
        String string = this.captureSharedPrefs.getString(PHOTO_QUALITY_KEY, null);
        if (string != null) {
            return PhotoQuality.valueOf(string);
        }
        return PhotoQuality.ORIGINAL;
    }

    @Override // com.box.android.domain.services.ICapturePreferencesService
    public void setVideoQuality(VideoQuality videoQuality) {
        Intrinsics.checkNotNullParameter(videoQuality, "videoQuality");
        this.captureSharedPrefs.edit().putString(VIDEO_QUALITY_KEY, videoQuality.name()).apply();
    }

    @Override // com.box.android.domain.services.ICapturePreferencesService
    public VideoQuality getVideoQuality() {
        String string = this.captureSharedPrefs.getString(VIDEO_QUALITY_KEY, null);
        if (string != null) {
            return VideoQuality.valueOf(string);
        }
        return VideoQuality.QUALITY_1080P;
    }

    @Override // com.box.android.domain.services.ICapturePreferencesService
    public void setSaveGpsLocation(boolean saveGpsLocation) {
        this.captureSharedPrefs.edit().putBoolean(SAVE_GPS_LOCATION_KEY, saveGpsLocation).apply();
    }

    @Override // com.box.android.domain.services.ICapturePreferencesService
    public boolean getSaveGpsLocation() {
        return this.captureSharedPrefs.getBoolean(SAVE_GPS_LOCATION_KEY, false);
    }
}
