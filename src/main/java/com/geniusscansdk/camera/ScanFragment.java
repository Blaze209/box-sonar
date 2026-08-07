package com.geniusscansdk.camera;

import android.content.Context;
import android.os.Build;
import androidx.fragment.app.Fragment;
import com.geniusscansdk.camera.realtime.BorderDetector;
import com.geniusscansdk.core.GeniusScanSDK;
import com.geniusscansdk.core.LicenseKeyStorage;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public abstract class ScanFragment extends Fragment {

    public interface Callback {
        void onCameraFailure();

        void onCameraReady();

        void onPreviewFrame(byte[] bArr, int i, int i2, int i3);

        void onShutterTriggered();
    }

    public interface CameraCallbackProvider {
        Callback getCameraCallback();
    }

    public abstract List<FlashMode> getAvailableFlashModes();

    public abstract void initializeCamera();

    public abstract boolean isRealTimeBorderDetectionEnabled();

    public abstract void resetBorderDetection();

    public abstract void setAutoTriggerAnimationEnabled(boolean z);

    public abstract void setBorderDetectorListener(BorderDetector.BorderDetectorListener borderDetectorListener);

    public abstract void setDetectionMode(DetectionMode detectionMode);

    public abstract void setFlashMode(FlashMode flashMode);

    public abstract void setFocusIndicator(FocusIndicator focusIndicator);

    public abstract void setJpegQuality(int i);

    public abstract void setOverlayColor(int i);

    public abstract void setOverlayColorResource(int i);

    public abstract void setPreviewAspectFill(boolean z);

    public abstract void setPreviewEnabled(boolean z);

    public abstract void setReadableCodeDetectionCallback(ReadableCodeDetectionCallback readableCodeDetectionCallback);

    @Deprecated
    public abstract void setRealTimeDetectionEnabled(boolean z);

    public abstract boolean takePicture(ImageCaptureCallback imageCaptureCallback);

    public abstract boolean takePicture(ImageCaptureCallback imageCaptureCallback, boolean z);

    public abstract FlashMode toggleFlashMode();

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        context.getSharedPreferences(LicenseKeyStorage.PREFERENCES_NAME, 0).edit().putBoolean(LicenseKeyStorage.CAMERA_SCREEN_DISPLAYED_KEY, true).apply();
    }

    public static ScanFragment createBestForDevice() {
        GeniusScanSDK.getLogger().verbose("OS info: " + Build.VERSION.SDK_INT);
        GeniusScanSDK.getLogger().verbose("Device info: " + Build.MANUFACTURER + " " + Build.BRAND + " " + Build.MODEL + " " + Build.DEVICE);
        if (Build.MANUFACTURER.equals("samsung") && Build.DEVICE.equals("klte")) {
            GeniusScanSDK.getLogger().info("Choosing legacy Camera API");
            return new ScanFragmentLegacy();
        }
        GeniusScanSDK.getLogger().info("Choosing CameraX API");
        return new ScanFragmentX();
    }
}
