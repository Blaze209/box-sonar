package com.geniusscansdk.camera;

import android.app.Activity;
import android.graphics.Point;
import android.hardware.Camera;
import android.os.AsyncTask;
import android.view.Display;
import com.geniusscansdk.core.GeniusScanSDK;
import com.geniusscansdk.core.Logger;
import com.geniusscansdk.core.RotationAngle;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
class CameraManager {
    private final ScanFragment.Callback callback;
    private Camera camera;
    private int cameraDisplayOrientation;
    private int cameraOrientation;
    private final Display deviceDisplay;
    private ImageCaptureCallback imageCaptureCallback;
    private int previewFormat;
    private Camera.Size previewSize;
    private SetupCameraTask setupCameraTask;
    private final Object cameraLock = new Object();
    private String currentFlashMode = "off";
    private Integer jpegQuality = null;
    private boolean canTakePicture = false;
    private final FocusManager focusManager = new FocusManager(new FocusManager.Callback() { // from class: com.geniusscansdk.camera.CameraManager$$ExternalSyntheticLambda1
        @Override // com.geniusscansdk.camera.FocusManager.Callback
        public final void onAutofocusFinished(boolean z) {
            this.f$0.lambda$new$0(z);
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(boolean z) {
        takePicture();
    }

    public CameraManager(Activity activity, ScanFragment.Callback callback) {
        this.callback = callback;
        this.deviceDisplay = activity.getWindowManager().getDefaultDisplay();
    }

    public void initializeCamera() {
        SetupCameraTask setupCameraTask = new SetupCameraTask();
        this.setupCameraTask = setupCameraTask;
        setupCameraTask.execute(new Void[0]);
    }

    /* JADX WARN: Type inference failed for: r3v5, types: [com.geniusscansdk.camera.CameraManager$1] */
    public void startPreview(PreviewSurfaceView previewSurfaceView) {
        if (needToSwapPreviewDimensions()) {
            previewSurfaceView.setAspectRatio(this.previewSize.height, this.previewSize.width);
        } else {
            previewSurfaceView.setAspectRatio(this.previewSize.width, this.previewSize.height);
        }
        try {
            this.camera.setPreviewDisplay(previewSurfaceView.getHolder());
            this.camera.setPreviewCallback(new Camera.PreviewCallback() { // from class: com.geniusscansdk.camera.CameraManager$$ExternalSyntheticLambda0
                @Override // android.hardware.Camera.PreviewCallback
                public final void onPreviewFrame(byte[] bArr, Camera camera) {
                    this.f$0.lambda$startPreview$1(bArr, camera);
                }
            });
            this.focusManager.initialize();
            new AsyncTask<Void, Void, Void>() { // from class: com.geniusscansdk.camera.CameraManager.1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public Void doInBackground(Void... voidArr) {
                    CameraManager.this.camera.startPreview();
                    CameraManager.this.canTakePicture = true;
                    return null;
                }
            }.execute(new Void[0]);
        } catch (Exception e) {
            GeniusScanSDK.getLogger().log(e.getMessage(), Logger.Severity.Error);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startPreview$1(byte[] bArr, Camera camera) {
        this.callback.onPreviewFrame(bArr, this.previewSize.width, this.previewSize.height, this.previewFormat);
    }

    public void stopPreview() {
        this.canTakePicture = false;
        try {
            this.camera.stopPreview();
            this.camera.setPreviewCallback(null);
            this.camera.setPreviewDisplay(null);
        } catch (Exception unused) {
        }
    }

    public void releaseCamera() {
        SetupCameraTask setupCameraTask = this.setupCameraTask;
        if (setupCameraTask != null) {
            setupCameraTask.cancel(false);
            this.setupCameraTask = null;
        }
        this.focusManager.setCamera(null);
        new ReleaseCameraTask().execute(new Void[0]);
    }

    public boolean takePhoto(ImageCaptureCallback imageCaptureCallback, boolean z) {
        if (!this.canTakePicture) {
            return false;
        }
        this.canTakePicture = false;
        this.imageCaptureCallback = imageCaptureCallback;
        if (z) {
            this.focusManager.autofocusBeforeTrigger();
            return true;
        }
        takePicture();
        return true;
    }

    private void takePicture() {
        System.gc();
        Camera camera = this.camera;
        if (camera == null) {
            return;
        }
        try {
            camera.takePicture(new ShutterCallback(), null, new PictureCallback());
        } catch (RuntimeException e) {
            GeniusScanSDK.getLogger().log(e.getMessage(), Logger.Severity.Error);
        }
    }

    public void setJpegQuality(int i) {
        this.jpegQuality = Integer.valueOf(i);
        Camera camera = this.camera;
        if (camera != null) {
            Camera.Parameters parameters = camera.getParameters();
            parameters.setJpegQuality(i);
            this.camera.setParameters(parameters);
        }
    }

    public List<String> getAvailableFlashModes() {
        Camera camera = this.camera;
        if (camera == null) {
            return null;
        }
        return camera.getParameters().getSupportedFlashModes();
    }

    public void setFlashMode(String str) {
        this.currentFlashMode = str;
        Camera camera = this.camera;
        if (camera != null) {
            Camera.Parameters parameters = camera.getParameters();
            parameters.setFlashMode(str);
            this.camera.setParameters(parameters);
        }
    }

    public String toggleFlashMode() {
        List<String> supportedFlashModes;
        Camera camera = this.camera;
        if (camera == null || (supportedFlashModes = camera.getParameters().getSupportedFlashModes()) == null) {
            return null;
        }
        int iIndexOf = supportedFlashModes.indexOf(this.currentFlashMode);
        for (int i = iIndexOf + 1; i < supportedFlashModes.size() + iIndexOf; i++) {
            String str = supportedFlashModes.get(i % supportedFlashModes.size());
            if ("on".equals(str) || "off".equals(str) || "auto".equals(str)) {
                this.currentFlashMode = str;
                break;
            }
        }
        setFlashMode(this.currentFlashMode);
        return this.currentFlashMode;
    }

    public void triggerAutoFocus(float f, float f2, FocusIndicator focusIndicator) {
        this.focusManager.localizedAutofocus(f, f2, this.cameraDisplayOrientation, focusIndicator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    class SetupCameraTask extends AsyncTask<Void, Void, Void> {
        private SetupCameraTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Void doInBackground(Void... voidArr) {
            GeniusScanSDK.getLogger().log("Getting camera", Logger.Severity.Debug);
            synchronized (CameraManager.this.cameraLock) {
                CameraManager cameraManager = CameraManager.this;
                cameraManager.camera = cameraManager.openCamera();
                if (CameraManager.this.camera == null) {
                    GeniusScanSDK.getLogger().log("Could not get camera instance", Logger.Severity.Error);
                    return null;
                }
                CameraManager.this.camera.setErrorCallback(new Camera.ErrorCallback() { // from class: com.geniusscansdk.camera.CameraManager$SetupCameraTask$$ExternalSyntheticLambda0
                    @Override // android.hardware.Camera.ErrorCallback
                    public final void onError(int i, Camera camera) {
                        this.f$0.lambda$doInBackground$0(i, camera);
                    }
                });
                GeniusScanSDK.getLogger().log("Got camera - cancelled:" + isCancelled(), Logger.Severity.Debug);
                if (isCancelled()) {
                    GeniusScanSDK.getLogger().log("Camera released by task doInBackground()", Logger.Severity.Debug);
                    CameraManager.this.camera.release();
                    CameraManager.this.camera = null;
                }
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$doInBackground$0(int i, Camera camera) {
            if (i == 100) {
                GeniusScanSDK.getLogger().log("Camera server died (100)", Logger.Severity.Error);
                CameraManager.this.releaseCamera();
                CameraManager.this.initializeCamera();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Void r2) {
            if (CameraManager.this.camera == null) {
                CameraManager.this.callback.onCameraFailure();
                return;
            }
            CameraManager.this.focusManager.setCamera(CameraManager.this.camera);
            CameraManager.this.configureCamera();
            CameraManager.this.callback.onCameraReady();
        }

        @Override // android.os.AsyncTask
        protected void onCancelled() {
            CameraManager.this.releaseCamera();
        }
    }

    private class ReleaseCameraTask extends AsyncTask<Void, Void, Void> {
        private ReleaseCameraTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Void doInBackground(Void... voidArr) {
            synchronized (CameraManager.this.cameraLock) {
                if (CameraManager.this.camera != null) {
                    Camera camera = CameraManager.this.camera;
                    CameraManager.this.camera = null;
                    camera.release();
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Camera openCamera() {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        GeniusScanSDK.getLogger().log("Number of cameras available : " + numberOfCameras, Logger.Severity.Debug);
        int i = 0;
        int i2 = -1;
        while (true) {
            if (i >= numberOfCameras) {
                i = i2;
                break;
            }
            Camera.getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing == 0) {
                break;
            }
            if (i2 == -1) {
                i2 = i;
            }
            i++;
        }
        GeniusScanSDK.getLogger().log("Camera selected : " + i, Logger.Severity.Info);
        Camera cameraOpen = null;
        if (i != -1) {
            try {
                cameraOpen = Camera.open(i);
                if (cameraOpen != null) {
                    setCameraDisplayOrientation(i, cameraOpen);
                    muteShutterSound(i, cameraOpen);
                }
                return cameraOpen;
            } catch (RuntimeException e) {
                e.printStackTrace();
                GeniusScanSDK.getLogger().log(e.getMessage(), Logger.Severity.Error);
            }
        }
        return cameraOpen;
    }

    private void setCameraDisplayOrientation(int i, Camera camera) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i, cameraInfo);
        this.cameraOrientation = cameraInfo.orientation;
        int rotation = this.deviceDisplay.getRotation();
        int i2 = 0;
        if (rotation != 0) {
            if (rotation == 1) {
                i2 = 90;
            } else if (rotation == 2) {
                i2 = 180;
            } else if (rotation == 3) {
                i2 = 270;
            }
        }
        if (cameraInfo.facing == 1) {
            int i3 = (this.cameraOrientation + i2) % 360;
            this.cameraDisplayOrientation = i3;
            this.cameraDisplayOrientation = (360 - i3) % 360;
        } else {
            this.cameraDisplayOrientation = ((this.cameraOrientation - i2) + 360) % 360;
        }
        camera.setDisplayOrientation(this.cameraDisplayOrientation);
    }

    private void muteShutterSound(int i, Camera camera) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i, cameraInfo);
        if (cameraInfo.canDisableShutterSound) {
            camera.enableShutterSound(false);
        }
    }

    public int getCameraDisplayOrientation() {
        return this.cameraDisplayOrientation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void configureCamera() {
        Camera.Parameters parameters = this.camera.getParameters();
        pickPreviewAndPictureSize(parameters);
        this.previewFormat = parameters.getPreviewFormat();
        if (this.currentFlashMode != null) {
            GeniusScanSDK.getLogger().log("Setting flash mode: " + this.currentFlashMode, Logger.Severity.Debug);
            parameters.setFlashMode(this.currentFlashMode);
        } else {
            GeniusScanSDK.getLogger().log("Flash mode null", Logger.Severity.Debug);
        }
        Integer num = this.jpegQuality;
        if (num != null) {
            parameters.setJpegQuality(num.intValue());
        }
        this.camera.setParameters(parameters);
    }

    private String printSize(Camera.Size size) {
        if (size == null) {
            return null;
        }
        return size.width + "x" + size.height;
    }

    private void pickPreviewAndPictureSize(Camera.Parameters parameters) {
        CameraSizeChooser.CameraSizes cameraSizesPickBestSizes = new CameraSizeChooser().pickBestSizes(parameters.getSupportedPictureSizes(), parameters.getSupportedPreviewSizes(), parameters.getPictureSize(), getTargetPreviewHeight());
        GeniusScanSDK.getLogger().log("Selected preview size: " + printSize(cameraSizesPickBestSizes.previewSize), Logger.Severity.Debug);
        GeniusScanSDK.getLogger().log("Selected picture size: " + printSize(cameraSizesPickBestSizes.pictureSize), Logger.Severity.Debug);
        this.previewSize = cameraSizesPickBestSizes.previewSize;
        parameters.setPictureSize(cameraSizesPickBestSizes.pictureSize.width, cameraSizesPickBestSizes.pictureSize.height);
        parameters.setPreviewSize(this.previewSize.width, this.previewSize.height);
    }

    private int getTargetPreviewHeight() {
        Point point = new Point();
        this.deviceDisplay.getSize(point);
        return needToSwapPreviewDimensions() ? point.x : point.y;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0034  */
    private boolean needToSwapPreviewDimensions() {
        int i;
        int rotation = this.deviceDisplay.getRotation();
        if (rotation == 0) {
            i = this.cameraOrientation;
            if (i != 90 || i == 270) {
                return true;
            }
        } else {
            if (rotation != 1) {
                if (rotation == 2) {
                    i = this.cameraOrientation;
                    if (i != 90) {
                    }
                    return true;
                }
                if (rotation != 3) {
                    GeniusScanSDK.getLogger().log("Display rotation is invalid: " + rotation, Logger.Severity.Warn);
                    return false;
                }
            }
            int i2 = this.cameraOrientation;
            if (i2 == 0 || i2 == 180) {
                return true;
            }
        }
        return false;
    }

    private class PictureCallback implements Camera.PictureCallback {
        private PictureCallback() {
        }

        @Override // android.hardware.Camera.PictureCallback
        public void onPictureTaken(byte[] bArr, Camera camera) {
            if (CameraManager.this.imageCaptureCallback != null) {
                CameraManager.this.imageCaptureCallback.onImageCaptured(bArr, RotationAngle.fromDegrees(CameraManager.this.cameraOrientation));
                CameraManager.this.imageCaptureCallback = null;
            }
        }
    }

    private class ShutterCallback implements Camera.ShutterCallback {
        private ShutterCallback() {
        }

        @Override // android.hardware.Camera.ShutterCallback
        public void onShutter() {
            CameraManager.this.callback.onShutterTriggered();
        }
    }
}
