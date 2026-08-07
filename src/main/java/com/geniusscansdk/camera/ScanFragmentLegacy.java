package com.geniusscansdk.camera;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import com.geniusscansdk.R;
import com.geniusscansdk.camera.realtime.BorderDetector;
import com.geniusscansdk.camera.realtime.OverlayView;
import com.geniusscansdk.core.DocumentDetector;
import com.geniusscansdk.core.QuadStreamAnalyzer;
import com.geniusscansdk.core.RotationAngle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
@Deprecated
public class ScanFragmentLegacy extends ScanFragment {
    private BorderDetector borderDetector;
    private BorderDetector.BorderDetectorListener borderDetectorListener;
    private ScanFragment.Callback cameraCallback;
    private CameraManager cameraManager;
    private FocusIndicator focusIndicator;
    private Integer jpegQuality;
    private Integer overlayColor;
    private OverlayView overlayView;
    private PreviewSurfaceView previewSurfaceView;
    private boolean autoTriggerAnimationEnabled = false;
    private boolean realTimeDetectionEnabled = true;
    private boolean isAspectFill = false;
    private boolean cameraReady = false;
    private boolean surfaceViewReady = false;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.geniusscansdk.camera.ScanFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        ScanFragment.CameraCallbackProvider cameraCallbackProvider;
        super.onAttach(context);
        BorderDetector borderDetector = new BorderDetector(DocumentDetector.create(context, DocumentDetector.Mode.FAST));
        this.borderDetector = borderDetector;
        borderDetector.setAutoTriggerListener(new AutoTriggerListener());
        if (context instanceof ScanFragment.CameraCallbackProvider) {
            cameraCallbackProvider = (ScanFragment.CameraCallbackProvider) context;
        } else if (getParentFragment() != null && (getParentFragment() instanceof ScanFragment.CameraCallbackProvider)) {
            cameraCallbackProvider = (ScanFragment.CameraCallbackProvider) getParentFragment();
        } else {
            throw new ClassCastException("Parent activity or parent fragment must implement " + ScanFragment.CameraCallbackProvider.class.getSimpleName());
        }
        this.cameraCallback = cameraCallbackProvider.getCameraCallback();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.scan_fragment, viewGroup, false);
        PreviewSurfaceView previewSurfaceView = (PreviewSurfaceView) viewInflate.findViewById(R.id.preview_surface_view);
        this.previewSurfaceView = previewSurfaceView;
        previewSurfaceView.getHolder().addCallback(new PreviewSurfaceViewCallback());
        this.previewSurfaceView.setAspectFill(this.isAspectFill);
        OverlayView overlayView = (OverlayView) viewInflate.findViewById(R.id.overlay_surface);
        this.overlayView = overlayView;
        Integer num = this.overlayColor;
        if (num != null) {
            overlayView.setOverlayColor(num.intValue());
        }
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.cameraManager == null) {
            CameraManager cameraManager = new CameraManager(requireActivity(), new CameraCallback());
            this.cameraManager = cameraManager;
            Integer num = this.jpegQuality;
            if (num != null) {
                cameraManager.setJpegQuality(num.intValue());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.cameraReady = false;
        PreviewSurfaceView previewSurfaceView = this.previewSurfaceView;
        if (previewSurfaceView != null) {
            previewSurfaceView.setOnTouchListener(null);
        }
        setPreviewEnabled(false);
        this.cameraManager.releaseCamera();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.borderDetector.removeListener();
    }

    @Override // com.geniusscansdk.camera.ScanFragment
    public void initializeCamera() {
        this.cameraManager.initializeCamera();
    }

    @Override // com.geniusscansdk.camera.ScanFragment
    public void setPreviewEnabled(boolean z) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            throw new RuntimeException("This method must be called from the main thread");
        }
        if (z) {
            if (this.cameraReady && this.surfaceViewReady) {
                this.cameraManager.startPreview(this.previewSurfaceView);
            }
        } else {
            this.cameraManager.stopPreview();
        }
        enableBorderDetection(z && this.realTimeDetectionEnabled);
    }

    @Override // com.geniusscansdk.camera.ScanFragment
    public void setPreviewAspectFill(boolean z) {
        this.isAspectFill = z;
        PreviewSurfaceView previewSurfaceView = this.previewSurfaceView;
        if (previewSurfaceView != null) {
            previewSurfaceView.setAspectFill(z);
        }
    }

    @Override // com.geniusscansdk.camera.ScanFragment
    public boolean takePicture(ImageCaptureCallback imageCaptureCallback) {
        return takePicture(imageCaptureCallback, true);
    }

    @Override // com.geniusscansdk.camera.ScanFragment
    public boolean takePicture(final ImageCaptureCallback imageCaptureCallback, boolean z) {
        enableBorderDetection(false);
        return this.cameraManager.takePhoto(new ImageCaptureCallback() { // from class: com.geniusscansdk.camera.ScanFragmentLegacy.1
            @Override // com.geniusscansdk.camera.ImageCaptureCallback
            public void onImageCaptured(byte[] bArr, RotationAngle rotationAngle) {
                ScanFragmentLegacy.this.setPreviewEnabled(false);
                imageCaptureCallback.onImageCaptured(bArr, rotationAngle);
            }

            @Override // com.geniusscansdk.camera.ImageCaptureCallback
            public void onError(Exception exc) {
                imageCaptureCallback.onError(exc);
            }
        }, z);
    }

    private void enableBorderDetection(boolean z) {
        BorderDetector borderDetector = this.borderDetector;
        if (borderDetector != null) {
            borderDetector.setEnabled(z);
            this.overlayView.setDisplayQuad(z);
        }
    }

    @Override // com.geniusscansdk.camera.ScanFragment
    public void setDetectionMode(DetectionMode detectionMode) {
        if (detectionMode instanceof DetectionMode.ReadableCode) {
            throw new UnsupportedOperationException("Readable code detection is not supported in legacy camera implementation. Use ScanFragmentX instead.");
        }
        setRealTimeDetectionEnabled(detectionMode instanceof DetectionMode.Document);
    }

    @Override // com.geniusscansdk.camera.ScanFragment
    public void setRealTimeDetectionEnabled(boolean z) {
        this.realTimeDetectionEnabled = z;
        enableBorderDetection(z);
    }

    @Override // com.geniusscansdk.camera.ScanFragment
    public void setOverlayColor(int i) {
        this.overlayColor = Integer.valueOf(i);
        OverlayView overlayView = this.overlayView;
        if (overlayView != null) {
            overlayView.setOverlayColor(i);
        }
    }

    @Override // com.geniusscansdk.camera.ScanFragment
    public void setOverlayColorResource(int i) {
        setOverlayColor(ContextCompat.getColor(requireContext(), i));
    }

    /* JADX INFO: renamed from: com.geniusscansdk.camera.ScanFragmentLegacy$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$geniusscansdk$camera$FlashMode;

        static {
            int[] iArr = new int[FlashMode.values().length];
            $SwitchMap$com$geniusscansdk$camera$FlashMode = iArr;
            try {
                iArr[FlashMode.AUTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$geniusscansdk$camera$FlashMode[FlashMode.ON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$geniusscansdk$camera$FlashMode[FlashMode.OFF.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private String fromFlashMode(FlashMode flashMode) {
        int i = AnonymousClass2.$SwitchMap$com$geniusscansdk$camera$FlashMode[flashMode.ordinal()];
        if (i == 1) {
            return "auto";
        }
        if (i == 2) {
            return "on";
        }
        if (i == 3) {
            return "off";
        }
        throw new IllegalArgumentException("Unknown flash mode " + flashMode);
    }

    private FlashMode toFlashMode(String str) {
        if (str == null) {
            return null;
        }
        str.hashCode();
        switch (str) {
            case "on":
                return FlashMode.ON;
            case "off":
                return FlashMode.OFF;
            case "auto":
                return FlashMode.AUTO;
            default:
                return null;
        }
    }

    @Override // com.geniusscansdk.camera.ScanFragment
    public List<FlashMode> getAvailableFlashModes() {
        List<String> availableFlashModes = this.cameraManager.getAvailableFlashModes();
        ArrayList arrayList = new ArrayList();
        if (availableFlashModes != null) {
            Iterator<String> it = availableFlashModes.iterator();
            while (it.hasNext()) {
                FlashMode flashMode = toFlashMode(it.next());
                if (flashMode != null) {
                    arrayList.add(flashMode);
                }
            }
        }
        return arrayList;
    }

    @Override // com.geniusscansdk.camera.ScanFragment
    public void setFlashMode(FlashMode flashMode) {
        this.cameraManager.setFlashMode(fromFlashMode(flashMode));
    }

    @Override // com.geniusscansdk.camera.ScanFragment
    public FlashMode toggleFlashMode() {
        return toFlashMode(this.cameraManager.toggleFlashMode());
    }

    @Override // com.geniusscansdk.camera.ScanFragment
    public void setJpegQuality(int i) {
        this.jpegQuality = Integer.valueOf(i);
        CameraManager cameraManager = this.cameraManager;
        if (cameraManager != null) {
            cameraManager.setJpegQuality(i);
        }
    }

    @Override // com.geniusscansdk.camera.ScanFragment
    public void setFocusIndicator(FocusIndicator focusIndicator) {
        this.focusIndicator = focusIndicator;
    }

    @Override // com.geniusscansdk.camera.ScanFragment
    public void setBorderDetectorListener(BorderDetector.BorderDetectorListener borderDetectorListener) {
        this.borderDetectorListener = borderDetectorListener;
    }

    @Override // com.geniusscansdk.camera.ScanFragment
    public void setAutoTriggerAnimationEnabled(boolean z) {
        this.autoTriggerAnimationEnabled = z;
    }

    @Override // com.geniusscansdk.camera.ScanFragment
    public boolean isRealTimeBorderDetectionEnabled() {
        return this.borderDetector.isEnabled();
    }

    @Override // com.geniusscansdk.camera.ScanFragment
    public void resetBorderDetection() {
        this.borderDetector.reset();
    }

    @Override // com.geniusscansdk.camera.ScanFragment
    public void setReadableCodeDetectionCallback(ReadableCodeDetectionCallback readableCodeDetectionCallback) {
        throw new UnsupportedOperationException("Readable code detection is not supported in legacy camera implementation. Use ScanFragmentX instead.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    class CameraCallback implements ScanFragment.Callback {
        private CameraCallback() {
        }

        @Override // com.geniusscansdk.camera.ScanFragment.Callback
        public void onCameraReady() {
            ScanFragmentLegacy.this.cameraReady = true;
            ScanFragmentLegacy.this.overlayView.setQuadrangleRotationAngle(RotationAngle.fromDegrees(ScanFragmentLegacy.this.cameraManager.getCameraDisplayOrientation()));
            ScanFragmentLegacy.this.previewSurfaceView.setOnTouchListener(new View.OnTouchListener() { // from class: com.geniusscansdk.camera.ScanFragmentLegacy$CameraCallback$$ExternalSyntheticLambda0
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return this.f$0.lambda$onCameraReady$0(view, motionEvent);
                }
            });
            ScanFragmentLegacy.this.setPreviewEnabled(true);
            if (ScanFragmentLegacy.this.cameraCallback != null) {
                ScanFragmentLegacy.this.cameraCallback.onCameraReady();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean lambda$onCameraReady$0(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                float x = motionEvent.getX() / ScanFragmentLegacy.this.previewSurfaceView.getWidth();
                float y = motionEvent.getY() / ScanFragmentLegacy.this.previewSurfaceView.getHeight();
                if (ScanFragmentLegacy.this.focusIndicator != null) {
                    ScanFragmentLegacy.this.focusIndicator.setPosition((int) motionEvent.getX(), (int) motionEvent.getY());
                }
                ScanFragmentLegacy.this.cameraManager.triggerAutoFocus(x, y, ScanFragmentLegacy.this.focusIndicator);
            }
            return true;
        }

        @Override // com.geniusscansdk.camera.ScanFragment.Callback
        public void onCameraFailure() {
            if (ScanFragmentLegacy.this.cameraCallback != null) {
                ScanFragmentLegacy.this.cameraCallback.onCameraFailure();
            }
        }

        @Override // com.geniusscansdk.camera.ScanFragment.Callback
        public void onShutterTriggered() {
            if (ScanFragmentLegacy.this.cameraCallback != null) {
                ScanFragmentLegacy.this.cameraCallback.onShutterTriggered();
            }
        }

        @Override // com.geniusscansdk.camera.ScanFragment.Callback
        public void onPreviewFrame(byte[] bArr, int i, int i2, int i3) {
            ScanFragmentLegacy.this.borderDetector.onPreviewFrame(bArr, i, i2, i, i3);
            if (ScanFragmentLegacy.this.cameraCallback != null) {
                ScanFragmentLegacy.this.cameraCallback.onPreviewFrame(bArr, i, i2, i3);
            }
        }
    }

    private class AutoTriggerListener implements BorderDetector.BorderDetectorListener {
        private AutoTriggerListener() {
        }

        @Override // com.geniusscansdk.camera.realtime.BorderDetector.BorderDetectorListener
        public void onBorderDetectionResult(QuadStreamAnalyzer.Result result) {
            ScanFragmentLegacy.this.overlayView.updateBorder(result, ScanFragmentLegacy.this.autoTriggerAnimationEnabled);
            if (ScanFragmentLegacy.this.borderDetectorListener != null) {
                ScanFragmentLegacy.this.borderDetectorListener.onBorderDetectionResult(result);
            }
        }

        @Override // com.geniusscansdk.camera.realtime.BorderDetector.BorderDetectorListener
        public void onBorderDetectionFailure(Exception exc) {
            if (ScanFragmentLegacy.this.borderDetectorListener != null) {
                ScanFragmentLegacy.this.borderDetectorListener.onBorderDetectionFailure(exc);
            }
        }
    }

    private class PreviewSurfaceViewCallback implements SurfaceHolder.Callback {
        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        private PreviewSurfaceViewCallback() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            ScanFragmentLegacy.this.surfaceViewReady = true;
            ScanFragmentLegacy.this.setPreviewEnabled(true);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            ScanFragmentLegacy.this.surfaceViewReady = false;
            ScanFragmentLegacy.this.setPreviewEnabled(false);
        }
    }
}
