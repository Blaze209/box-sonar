package com.geniusscansdk.camera;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.util.Size;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.DisplayOrientedMeteringPointFactory;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.FocusMeteringResult;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Preview;
import androidx.camera.core.ResolutionInfo;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.resolutionselector.AspectRatioStrategy;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.core.content.ContextCompat;
import androidx.core.util.Consumer;
import androidx.fragment.app.FragmentActivity;
import com.geniusscansdk.R;
import com.geniusscansdk.camera.realtime.BorderDetector;
import com.geniusscansdk.camera.realtime.OverlayView;
import com.geniusscansdk.core.DocumentDetector;
import com.geniusscansdk.core.GeniusScanSDK;
import com.geniusscansdk.core.QuadStreamAnalyzer;
import com.geniusscansdk.core.RotationAngle;
import com.geniusscansdk.structureddata.ReadableCode;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.vision.barcode.BarcodeScanner;
import com.google.mlkit.vision.barcode.BarcodeScannerOptions;
import com.google.mlkit.vision.barcode.BarcodeScanning;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.common.InputImage;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes13.dex */
public class ScanFragmentX extends ScanFragment {
    private static final long ANALYSIS_THROTTLE_MS = 250;
    private static final String TAG = "ScanFragmentX";
    private ReadableCodeDetectionCallback barcodeDetectionCallback;
    private BarcodeScanner barcodeScanner;
    private BorderDetector borderDetector;
    private BorderDetector.BorderDetectorListener borderDetectorListener;
    private ScanFragment.Callback cameraCallback;
    private CameraControl cameraControl;
    private CameraInfo cameraInfo;
    private ProcessCameraProvider cameraProvider;
    private FocusIndicator focusIndicator;
    private OverlayView overlayView;
    private PreviewSurfaceView previewSurfaceView;
    private Integer realTimeDetectionColor;
    private static final List<FlashMode> SUPPORTED_FLASH_MODES = Arrays.asList(FlashMode.AUTO, FlashMode.OFF, FlashMode.ON);
    private static final Map<Integer, ReadableCode.Type> MLKIT_FORMAT_TO_TYPE_MAP = new HashMap();
    private boolean autoTriggerAnimationEnabled = false;
    private boolean isAspectFill = false;
    private FlashMode flashMode = FlashMode.AUTO;
    private Integer jpegQuality = null;
    private final Executor backgroundExecutor = Executors.newSingleThreadExecutor();
    private DetectionMode detectionMode = DetectionMode.Document.INSTANCE;
    private long lastReadableCodeAnalysisTime = 0;
    private ImageCapture imageCapture = null;
    private boolean canTakePicture = false;
    private final Preview.SurfaceProvider surfaceProvider = new AnonymousClass2();
    private final SurfaceRequestCallback surfaceRequestCallback = new SurfaceRequestCallback();

    static {
        for (ReadableCode.Type type : ReadableCode.Type.values()) {
            MLKIT_FORMAT_TO_TYPE_MAP.put(Integer.valueOf(type.getMlkitFormat()), type);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.geniusscansdk.camera.ScanFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        ScanFragment.CameraCallbackProvider cameraCallbackProvider;
        super.onAttach(context);
        GeniusScanSDK.getLogger().info("ScanFragmentX.onAttach");
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
        GeniusScanSDK.getLogger().info("ScanFragmentX.onCreateView");
        View viewInflate = layoutInflater.inflate(R.layout.scan_fragment, viewGroup, false);
        PreviewSurfaceView previewSurfaceView = (PreviewSurfaceView) viewInflate.findViewById(R.id.preview_surface_view);
        this.previewSurfaceView = previewSurfaceView;
        previewSurfaceView.getHolder().addCallback(this.surfaceRequestCallback);
        this.previewSurfaceView.setAspectFill(this.isAspectFill);
        OverlayView overlayView = (OverlayView) viewInflate.findViewById(R.id.overlay_surface);
        this.overlayView = overlayView;
        Integer num = this.realTimeDetectionColor;
        if (num != null) {
            overlayView.setOverlayColor(num.intValue());
        }
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        GeniusScanSDK.getLogger().info("ScanFragmentX.onViewCreated");
        applyDetectionMode();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        PreviewSurfaceView previewSurfaceView = this.previewSurfaceView;
        if (previewSurfaceView != null) {
            previewSurfaceView.setOnTouchListener(null);
        }
        setPreviewEnabled(false);
    }

    @Override // com.geniusscansdk.camera.ScanFragment
    public void initializeCamera() {
        final ListenableFuture<ProcessCameraProvider> processCameraProvider = ProcessCameraProvider.getInstance(requireContext());
        processCameraProvider.addListener(new Runnable() { // from class: com.geniusscansdk.camera.ScanFragmentX$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$initializeCamera$1(processCameraProvider);
            }
        }, ContextCompat.getMainExecutor(requireContext()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$initializeCamera$1(ListenableFuture listenableFuture) {
        try {
            this.cameraProvider = (ProcessCameraProvider) listenableFuture.get();
            this.previewSurfaceView.post(new Runnable() { // from class: com.geniusscansdk.camera.ScanFragmentX$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$initializeCamera$0();
                }
            });
        } catch (InterruptedException | ExecutionException e) {
            this.cameraCallback.onCameraFailure();
            GeniusScanSDK.getLogger().error("Error opening camera: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializeCamera$0() {
        try {
            setupFocusListener();
            setPreviewEnabled(true);
            this.cameraCallback.onCameraReady();
        } catch (IllegalArgumentException e) {
            this.cameraCallback.onCameraFailure();
            GeniusScanSDK.getLogger().error("Error starting preview: " + e.getMessage());
        }
    }

    private void bindCameraUseCases() {
        GeniusScanSDK.getLogger().debug("Beginning of bindCameraUseCases");
        if (this.cameraProvider == null) {
            return;
        }
        Display display = this.previewSurfaceView.getDisplay();
        if (display == null) {
            GeniusScanSDK.getLogger().warn("Display is null, canceling camera use cases binding.");
            return;
        }
        int rotation = display.getRotation();
        ResolutionSelector resolutionSelectorBuild = new ResolutionSelector.Builder().setAspectRatioStrategy(this.isAspectFill ? AspectRatioStrategy.RATIO_16_9_FALLBACK_AUTO_STRATEGY : AspectRatioStrategy.RATIO_4_3_FALLBACK_AUTO_STRATEGY).build();
        Preview previewBuild = new Preview.Builder().setResolutionSelector(resolutionSelectorBuild).setTargetRotation(rotation).build();
        previewBuild.setSurfaceProvider(this.surfaceProvider);
        ImageCapture.Builder resolutionSelector = new ImageCapture.Builder().setTargetRotation(rotation).setFlashMode(toFlashCode(this.flashMode)).setResolutionSelector(new ResolutionSelector.Builder().setAllowedResolutionMode(1).build());
        Integer num = this.jpegQuality;
        if (num != null) {
            resolutionSelector.setJpegQuality(num.intValue());
        }
        this.imageCapture = resolutionSelector.build();
        ImageAnalysis imageAnalysisBuild = new ImageAnalysis.Builder().setResolutionSelector(resolutionSelectorBuild).setTargetRotation(rotation).setBackpressureStrategy(0).build();
        imageAnalysisBuild.setAnalyzer(this.backgroundExecutor, new ImageAnalysis.Analyzer() { // from class: com.geniusscansdk.camera.ScanFragmentX$$ExternalSyntheticLambda1
            @Override // androidx.camera.core.ImageAnalysis.Analyzer
            public final void analyze(ImageProxy imageProxy) {
                this.f$0.lambda$bindCameraUseCases$2(imageProxy);
            }
        });
        CameraSelector cameraSelectorBuild = new CameraSelector.Builder().requireLensFacing(1).build();
        this.cameraProvider.unbindAll();
        Camera cameraBindToLifecycle = this.cameraProvider.bindToLifecycle(this, cameraSelectorBuild, this.imageCapture, previewBuild, imageAnalysisBuild);
        GeniusScanSDK.getLogger().info("Preview use case: " + resolutionInfoToString(previewBuild.getResolutionInfo()));
        GeniusScanSDK.getLogger().info("Analysis use case: " + resolutionInfoToString(imageAnalysisBuild.getResolutionInfo()));
        GeniusScanSDK.getLogger().info("Capture use case: " + resolutionInfoToString(this.imageCapture.getResolutionInfo()));
        this.cameraControl = cameraBindToLifecycle.getCameraControl();
        this.cameraInfo = cameraBindToLifecycle.getCameraInfo();
        GeniusScanSDK.getLogger().debug("End of bindCameraUseCases");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bindCameraUseCases$2(ImageProxy imageProxy) {
        DetectionMode detectionMode = this.detectionMode;
        if (detectionMode instanceof DetectionMode.ReadableCode) {
            processReadableCodeDetection(imageProxy);
        } else if (detectionMode instanceof DetectionMode.Document) {
            this.overlayView.setQuadrangleRotationAngle(RotationAngle.fromDegrees(imageProxy.getImageInfo().getRotationDegrees()));
            processQuadrangleDetection(imageProxy);
        } else {
            imageProxy.close();
        }
    }

    private void rebindCameraUseCasesIfNeeded() {
        if (this.cameraControl != null) {
            bindCameraUseCases();
        }
    }

    private String resolutionInfoToString(ResolutionInfo resolutionInfo) {
        if (resolutionInfo == null) {
            return null;
        }
        return "Resolution: " + resolutionInfo.getResolution() + ", CropRect: " + resolutionInfo.getCropRect() + ", RotationDegrees: " + resolutionInfo.getRotationDegrees();
    }

    private static byte[] yuv_420_888toNv21(ImageProxy imageProxy) {
        ImageProxy.PlaneProxy planeProxy = imageProxy.getPlanes()[0];
        ImageProxy.PlaneProxy planeProxy2 = imageProxy.getPlanes()[1];
        ImageProxy.PlaneProxy planeProxy3 = imageProxy.getPlanes()[2];
        ByteBuffer buffer = planeProxy.getBuffer();
        ByteBuffer buffer2 = planeProxy2.getBuffer();
        ByteBuffer buffer3 = planeProxy3.getBuffer();
        buffer.rewind();
        buffer2.rewind();
        buffer3.rewind();
        int iRemaining = buffer.remaining();
        byte[] bArr = new byte[((imageProxy.getWidth() * imageProxy.getHeight()) / 2) + iRemaining];
        int width = 0;
        for (int i = 0; i < imageProxy.getHeight(); i++) {
            buffer.get(bArr, width, imageProxy.getWidth());
            width += imageProxy.getWidth();
            buffer.position(Math.min(iRemaining, (buffer.position() - imageProxy.getWidth()) + planeProxy.getRowStride()));
        }
        int height = imageProxy.getHeight() / 2;
        int width2 = imageProxy.getWidth() / 2;
        int rowStride = planeProxy3.getRowStride();
        int rowStride2 = planeProxy2.getRowStride();
        int pixelStride = planeProxy3.getPixelStride();
        int pixelStride2 = planeProxy2.getPixelStride();
        byte[] bArr2 = new byte[rowStride];
        byte[] bArr3 = new byte[rowStride2];
        for (int i2 = 0; i2 < height; i2++) {
            buffer3.get(bArr2, 0, Math.min(rowStride, buffer3.remaining()));
            buffer2.get(bArr3, 0, Math.min(rowStride2, buffer2.remaining()));
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < width2; i5++) {
                int i6 = width + 1;
                bArr[width] = bArr2[i3];
                width += 2;
                bArr[i6] = bArr3[i4];
                i3 += pixelStride;
                i4 += pixelStride2;
            }
        }
        return bArr;
    }

    private void setupFocusListener() {
        this.previewSurfaceView.setOnTouchListener(new View.OnTouchListener() { // from class: com.geniusscansdk.camera.ScanFragmentX$$ExternalSyntheticLambda11
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.f$0.lambda$setupFocusListener$5(view, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$setupFocusListener$5(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            FocusIndicator focusIndicator = this.focusIndicator;
            if (focusIndicator != null) {
                focusIndicator.setPosition((int) motionEvent.getX(), (int) motionEvent.getY());
                this.focusIndicator.showStart();
            }
            final ListenableFuture<FocusMeteringResult> listenableFutureStartFocusAndMetering = this.cameraControl.startFocusAndMetering(new FocusMeteringAction.Builder(new DisplayOrientedMeteringPointFactory(requireActivity().getWindowManager().getDefaultDisplay(), this.cameraInfo, this.previewSurfaceView.getWidth(), this.previewSurfaceView.getHeight()).createPoint(motionEvent.getX(), motionEvent.getY()), 1).setAutoCancelDuration(3000L, TimeUnit.MILLISECONDS).build());
            listenableFutureStartFocusAndMetering.addListener(new Runnable() { // from class: com.geniusscansdk.camera.ScanFragmentX$$ExternalSyntheticLambda9
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setupFocusListener$4(listenableFutureStartFocusAndMetering);
                }
            }, ContextCompat.getMainExecutor(requireContext()));
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$setupFocusListener$4(ListenableFuture listenableFuture) {
        try {
            if (this.focusIndicator != null) {
                this.focusIndicator.showFinished(((FocusMeteringResult) listenableFuture.get()).isFocusSuccessful());
                this.previewSurfaceView.postDelayed(new Runnable() { // from class: com.geniusscansdk.camera.ScanFragmentX$$ExternalSyntheticLambda8
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$setupFocusListener$3();
                    }
                }, 3000L);
            }
        } catch (InterruptedException | ExecutionException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupFocusListener$3() {
        this.focusIndicator.hide();
    }

    @Override // com.geniusscansdk.camera.ScanFragment
    public void setPreviewEnabled(boolean z) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            throw new RuntimeException("This method must be called from the main thread");
        }
        this.canTakePicture = z;
        if (z) {
            bindCameraUseCases();
        } else {
            ProcessCameraProvider processCameraProvider = this.cameraProvider;
            if (processCameraProvider != null) {
                processCameraProvider.unbindAll();
            }
        }
        enableBorderDetection(z && (this.detectionMode instanceof DetectionMode.Document));
    }

    @Override // com.geniusscansdk.camera.ScanFragment
    public void setPreviewAspectFill(boolean z) {
        this.isAspectFill = z;
        PreviewSurfaceView previewSurfaceView = this.previewSurfaceView;
        if (previewSurfaceView != null) {
            previewSurfaceView.setAspectFill(z);
        }
        GeniusScanSDK.getLogger().debug("Setting new preview aspect, isAspectFill = " + z);
        rebindCameraUseCasesIfNeeded();
    }

    @Override // com.geniusscansdk.camera.ScanFragment
    public boolean takePicture(ImageCaptureCallback imageCaptureCallback) {
        return takePicture(imageCaptureCallback, true);
    }

    @Override // com.geniusscansdk.camera.ScanFragment
    public boolean takePicture(final ImageCaptureCallback imageCaptureCallback, boolean z) {
        if (!this.canTakePicture) {
            return false;
        }
        this.canTakePicture = false;
        enableBorderDetection(false);
        this.imageCapture.m145lambda$takePicture$1$androidxcameracoreImageCapture(ContextCompat.getMainExecutor(requireContext()), new ImageCapture.OnImageCapturedCallback() { // from class: com.geniusscansdk.camera.ScanFragmentX.1
            @Override // androidx.camera.core.ImageCapture.OnImageCapturedCallback
            public void onCaptureSuccess(ImageProxy imageProxy) {
                ScanFragmentX.this.setPreviewEnabled(false);
                imageCaptureCallback.onImageCaptured(ScanFragmentX.jpegImageToJpegByteArray(imageProxy), RotationAngle.ROTATION_0);
            }

            @Override // androidx.camera.core.ImageCapture.OnImageCapturedCallback
            public void onError(ImageCaptureException imageCaptureException) {
                imageCaptureCallback.onError(imageCaptureException);
            }
        });
        this.cameraCallback.onShutterTriggered();
        return true;
    }

    public static byte[] jpegImageToJpegByteArray(ImageProxy imageProxy) {
        if (imageProxy.getFormat() != 256) {
            throw new IllegalArgumentException("Incorrect image format of the input image proxy: " + imageProxy.getFormat());
        }
        ByteBuffer buffer = imageProxy.getPlanes()[0].getBuffer();
        byte[] bArr = new byte[buffer.capacity()];
        buffer.rewind();
        buffer.get(bArr);
        return bArr;
    }

    private void enableBorderDetection(boolean z) {
        BorderDetector borderDetector = this.borderDetector;
        if (borderDetector == null) {
            return;
        }
        borderDetector.setEnabled(z);
        OverlayView overlayView = this.overlayView;
        if (overlayView == null) {
            return;
        }
        overlayView.setDisplayQuad(z);
    }

    private void initializeBarcodeScanner() {
        if (this.barcodeScanner != null) {
            return;
        }
        try {
            int[] supportedBarcodeFormats = getSupportedBarcodeFormats();
            if (supportedBarcodeFormats.length == 0) {
                GeniusScanSDK.getLogger().error("No barcode formats configured for scanning");
                ReadableCodeDetectionCallback readableCodeDetectionCallback = this.barcodeDetectionCallback;
                if (readableCodeDetectionCallback != null) {
                    readableCodeDetectionCallback.onDetectorInitializationFailed(new IllegalArgumentException("No barcode formats configured"));
                    return;
                }
                return;
            }
            BarcodeScannerOptions.Builder builder = new BarcodeScannerOptions.Builder();
            if (supportedBarcodeFormats.length == 1) {
                builder.setBarcodeFormats(supportedBarcodeFormats[0], new int[0]);
            } else {
                builder.setBarcodeFormats(supportedBarcodeFormats[0], Arrays.copyOfRange(supportedBarcodeFormats, 1, supportedBarcodeFormats.length));
            }
            this.barcodeScanner = BarcodeScanning.getClient(builder.build());
        } catch (Exception e) {
            GeniusScanSDK.getLogger().error("Failed to initialize barcode scanner: " + e.getMessage());
            ReadableCodeDetectionCallback readableCodeDetectionCallback2 = this.barcodeDetectionCallback;
            if (readableCodeDetectionCallback2 != null) {
                readableCodeDetectionCallback2.onDetectorInitializationFailed(e);
            }
        }
    }

    private int[] getSupportedBarcodeFormats() {
        DetectionMode detectionMode = this.detectionMode;
        int i = 0;
        if (!(detectionMode instanceof DetectionMode.ReadableCode)) {
            return new int[0];
        }
        Set<ReadableCode.Type> supportedCodeTypes = ((DetectionMode.ReadableCode) detectionMode).getConfiguration().getSupportedCodeTypes();
        if (supportedCodeTypes.isEmpty()) {
            return new int[0];
        }
        int[] iArr = new int[supportedCodeTypes.size()];
        Iterator<ReadableCode.Type> it = supportedCodeTypes.iterator();
        while (it.hasNext()) {
            iArr[i] = it.next().getMlkitFormat();
            i++;
        }
        return iArr;
    }

    private void processQuadrangleDetection(ImageProxy imageProxy) {
        this.borderDetector.onPreviewFrame(yuv_420_888toNv21(imageProxy), imageProxy.getWidth(), imageProxy.getHeight(), imageProxy.getWidth(), 17);
        imageProxy.close();
    }

    private boolean shouldThrottleReadableCodeAnalysis() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.lastReadableCodeAnalysisTime < ANALYSIS_THROTTLE_MS) {
            return true;
        }
        this.lastReadableCodeAnalysisTime = jCurrentTimeMillis;
        return false;
    }

    private void processReadableCodeDetection(final ImageProxy imageProxy) {
        if (this.barcodeScanner == null) {
            imageProxy.close();
            return;
        }
        if (shouldThrottleReadableCodeAnalysis()) {
            imageProxy.close();
            return;
        }
        try {
            final InputImage inputImageFromMediaImage = InputImage.fromMediaImage(imageProxy.getImage(), imageProxy.getImageInfo().getRotationDegrees());
            this.barcodeScanner.process(inputImageFromMediaImage).addOnSuccessListener(new OnSuccessListener() { // from class: com.geniusscansdk.camera.ScanFragmentX$$ExternalSyntheticLambda3
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    this.f$0.lambda$processReadableCodeDetection$7(inputImageFromMediaImage, (List) obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: com.geniusscansdk.camera.ScanFragmentX$$ExternalSyntheticLambda4
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    this.f$0.lambda$processReadableCodeDetection$9(exc);
                }
            }).addOnCompleteListener(new OnCompleteListener() { // from class: com.geniusscansdk.camera.ScanFragmentX$$ExternalSyntheticLambda5
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    imageProxy.close();
                }
            });
        } catch (Exception e) {
            GeniusScanSDK.getLogger().error("Failed to process barcode detection: " + e.getMessage());
            imageProxy.close();
            requireActivity().runOnUiThread(new Runnable() { // from class: com.geniusscansdk.camera.ScanFragmentX$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processReadableCodeDetection$11(e);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processReadableCodeDetection$7(InputImage inputImage, List list) {
        ReadableCode.Type type;
        final ArrayList arrayList = new ArrayList();
        boolean z = inputImage.getRotationDegrees() == 90 || inputImage.getRotationDegrees() == 270;
        int height = z ? inputImage.getHeight() : inputImage.getWidth();
        int width = z ? inputImage.getWidth() : inputImage.getHeight();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Barcode barcode = (Barcode) it.next();
            if (barcode.getRawValue() != null && (type = MLKIT_FORMAT_TO_TYPE_MAP.get(Integer.valueOf(barcode.getFormat()))) != null) {
                arrayList.add(new SpatialReadableCode(barcode.getRawValue(), type, barcode.getBoundingBox(), height, width));
            }
        }
        FragmentActivity activity = getActivity();
        if (activity == null || this.barcodeDetectionCallback == null) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.geniusscansdk.camera.ScanFragmentX$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processReadableCodeDetection$6(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processReadableCodeDetection$6(List list) {
        this.barcodeDetectionCallback.onReadableCodesDetected(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processReadableCodeDetection$9(final Exception exc) {
        GeniusScanSDK.getLogger().error("BarcodeDetection: MLKit processing failed: " + exc.getMessage());
        FragmentActivity activity = getActivity();
        if (activity == null || this.barcodeDetectionCallback == null) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.geniusscansdk.camera.ScanFragmentX$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processReadableCodeDetection$8(exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processReadableCodeDetection$8(Exception exc) {
        String str;
        if (!(exc instanceof MlKitException)) {
            str = "Barcode detection failed";
        } else {
            MlKitException mlKitException = (MlKitException) exc;
            if (mlKitException.getErrorCode() == 14) {
                str = "Barcode detector is unavailable. Please check your internet connection for model download.";
            } else {
                str = "Barcode detection error: " + mlKitException.getMessage();
            }
        }
        this.barcodeDetectionCallback.onDetectorInitializationFailed(new Exception(str, exc));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processReadableCodeDetection$11(Exception exc) {
        ReadableCodeDetectionCallback readableCodeDetectionCallback = this.barcodeDetectionCallback;
        if (readableCodeDetectionCallback != null) {
            readableCodeDetectionCallback.onDetectorInitializationFailed(new Exception("Failed to process image for barcode detection", exc));
        }
    }

    @Override // com.geniusscansdk.camera.ScanFragment
    public void setDetectionMode(DetectionMode detectionMode) {
        this.detectionMode = detectionMode;
        applyDetectionMode();
    }

    private void applyDetectionMode() {
        DetectionMode detectionMode = this.detectionMode;
        if (detectionMode instanceof DetectionMode.ReadableCode) {
            initializeBarcodeScanner();
            enableBorderDetection(false);
        } else if (detectionMode instanceof DetectionMode.Document) {
            enableBorderDetection(true);
        } else if (detectionMode == DetectionMode.Disabled.INSTANCE) {
            enableBorderDetection(false);
        }
    }

    @Override // com.geniusscansdk.camera.ScanFragment
    public void setRealTimeDetectionEnabled(boolean z) {
        setDetectionMode(z ? DetectionMode.Document.INSTANCE : DetectionMode.Disabled.INSTANCE);
    }

    @Override // com.geniusscansdk.camera.ScanFragment
    public void setOverlayColor(int i) {
        this.realTimeDetectionColor = Integer.valueOf(i);
        OverlayView overlayView = this.overlayView;
        if (overlayView != null) {
            overlayView.setOverlayColor(i);
        }
    }

    @Override // com.geniusscansdk.camera.ScanFragment
    public void setOverlayColorResource(int i) {
        setOverlayColor(ContextCompat.getColor(requireContext(), i));
    }

    @Override // com.geniusscansdk.camera.ScanFragment
    public void setFlashMode(FlashMode flashMode) {
        this.flashMode = flashMode;
        GeniusScanSDK.getLogger().debug("Setting new flash mode: " + flashMode);
        rebindCameraUseCasesIfNeeded();
    }

    /* JADX INFO: renamed from: com.geniusscansdk.camera.ScanFragmentX$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
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

    private int toFlashCode(FlashMode flashMode) {
        int i = AnonymousClass3.$SwitchMap$com$geniusscansdk$camera$FlashMode[flashMode.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        if (i == 3) {
            return 2;
        }
        throw new IncompatibleClassChangeError();
    }

    @Override // com.geniusscansdk.camera.ScanFragment
    public FlashMode toggleFlashMode() {
        List<FlashMode> list = SUPPORTED_FLASH_MODES;
        setFlashMode(list.get((list.indexOf(this.flashMode) + 1) % list.size()));
        return this.flashMode;
    }

    @Override // com.geniusscansdk.camera.ScanFragment
    public List<FlashMode> getAvailableFlashModes() {
        return SUPPORTED_FLASH_MODES;
    }

    @Override // com.geniusscansdk.camera.ScanFragment
    public void setJpegQuality(int i) {
        this.jpegQuality = Integer.valueOf(i);
        GeniusScanSDK.getLogger().debug("Setting jpeg quality: " + i);
        rebindCameraUseCasesIfNeeded();
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
        this.barcodeDetectionCallback = readableCodeDetectionCallback;
    }

    private class AutoTriggerListener implements BorderDetector.BorderDetectorListener {
        private AutoTriggerListener() {
        }

        @Override // com.geniusscansdk.camera.realtime.BorderDetector.BorderDetectorListener
        public void onBorderDetectionResult(QuadStreamAnalyzer.Result result) {
            ScanFragmentX.this.overlayView.updateBorder(result, ScanFragmentX.this.autoTriggerAnimationEnabled);
            if (ScanFragmentX.this.borderDetectorListener != null) {
                ScanFragmentX.this.borderDetectorListener.onBorderDetectionResult(result);
            }
        }

        @Override // com.geniusscansdk.camera.realtime.BorderDetector.BorderDetectorListener
        public void onBorderDetectionFailure(Exception exc) {
            if (ScanFragmentX.this.borderDetectorListener != null) {
                ScanFragmentX.this.borderDetectorListener.onBorderDetectionFailure(exc);
            }
        }
    }

    /* JADX INFO: renamed from: com.geniusscansdk.camera.ScanFragmentX$2, reason: invalid class name */
    class AnonymousClass2 implements Preview.SurfaceProvider {
        AnonymousClass2() {
        }

        @Override // androidx.camera.core.Preview.SurfaceProvider
        public void onSurfaceRequested(final SurfaceRequest surfaceRequest) {
            final Size resolution = surfaceRequest.getResolution();
            Context context = ScanFragmentX.this.getContext();
            if (context == null) {
                return;
            }
            surfaceRequest.setTransformationInfoListener(ContextCompat.getMainExecutor(context), new SurfaceRequest.TransformationInfoListener() { // from class: com.geniusscansdk.camera.ScanFragmentX$2$$ExternalSyntheticLambda1
                @Override // androidx.camera.core.SurfaceRequest.TransformationInfoListener
                public final void onTransformationInfoUpdate(SurfaceRequest.TransformationInfo transformationInfo) {
                    this.f$0.lambda$onSurfaceRequested$1(resolution, surfaceRequest, transformationInfo);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSurfaceRequested$1(Size size, final SurfaceRequest surfaceRequest, SurfaceRequest.TransformationInfo transformationInfo) {
            int rotationDegrees = transformationInfo.getRotationDegrees();
            if (rotationDegrees == 0 || rotationDegrees == 180) {
                ScanFragmentX.this.previewSurfaceView.setAspectRatio(size.getWidth(), size.getHeight());
            } else if (rotationDegrees == 90 || rotationDegrees == 270) {
                ScanFragmentX.this.previewSurfaceView.setAspectRatio(size.getHeight(), size.getWidth());
            }
            ScanFragmentX.this.previewSurfaceView.post(new Runnable() { // from class: com.geniusscansdk.camera.ScanFragmentX$2$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onSurfaceRequested$0(surfaceRequest);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSurfaceRequested$0(SurfaceRequest surfaceRequest) {
            ScanFragmentX.this.surfaceRequestCallback.setSurfaceRequest(surfaceRequest);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class SurfaceRequestCallback implements SurfaceHolder.Callback {
        private Size mCurrentSurfaceSize;
        private SurfaceRequest mSurfaceRequest;
        private Size mTargetSize;
        private boolean mWasSurfaceProvided;

        private SurfaceRequestCallback() {
            this.mWasSurfaceProvided = false;
        }

        void setSurfaceRequest(SurfaceRequest surfaceRequest) {
            cancelPreviousRequest();
            this.mSurfaceRequest = surfaceRequest;
            Size resolution = surfaceRequest.getResolution();
            this.mTargetSize = resolution;
            this.mWasSurfaceProvided = false;
            if (tryToComplete()) {
                return;
            }
            Log.d(ScanFragmentX.TAG, "Wait for new Surface creation.");
            ScanFragmentX.this.previewSurfaceView.getHolder().setFixedSize(resolution.getWidth(), resolution.getHeight());
        }

        private boolean tryToComplete() {
            Surface surface = ScanFragmentX.this.previewSurfaceView.getHolder().getSurface();
            if (!canProvideSurface() || this.mSurfaceRequest == null) {
                return false;
            }
            Log.d(ScanFragmentX.TAG, "Surface set on Preview.");
            this.mSurfaceRequest.provideSurface(surface, ContextCompat.getMainExecutor(ScanFragmentX.this.previewSurfaceView.getContext()), new Consumer() { // from class: com.geniusscansdk.camera.ScanFragmentX$SurfaceRequestCallback$$ExternalSyntheticLambda0
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    Log.d(ScanFragmentX.TAG, "Safe to release surface.");
                }
            });
            this.mWasSurfaceProvided = true;
            return true;
        }

        private boolean canProvideSurface() {
            Size size;
            return (this.mWasSurfaceProvided || this.mSurfaceRequest == null || (size = this.mTargetSize) == null || !size.equals(this.mCurrentSurfaceSize)) ? false : true;
        }

        private void cancelPreviousRequest() {
            if (this.mSurfaceRequest != null) {
                Log.d(ScanFragmentX.TAG, "Request canceled: " + this.mSurfaceRequest);
                this.mSurfaceRequest.willNotProvideSurface();
            }
        }

        private void invalidateSurface() {
            if (this.mSurfaceRequest != null) {
                Log.d(ScanFragmentX.TAG, "Surface invalidated " + this.mSurfaceRequest);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            Log.d(ScanFragmentX.TAG, "Surface created.");
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            Log.d(ScanFragmentX.TAG, "Surface changed. Size: " + i2 + "x" + i3);
            this.mCurrentSurfaceSize = new Size(i2, i3);
            tryToComplete();
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            Log.d(ScanFragmentX.TAG, "Surface destroyed.");
            if (this.mWasSurfaceProvided) {
                invalidateSurface();
            } else {
                cancelPreviousRequest();
            }
            this.mWasSurfaceProvided = false;
            this.mSurfaceRequest = null;
            this.mCurrentSurfaceSize = null;
            this.mTargetSize = null;
        }
    }
}
