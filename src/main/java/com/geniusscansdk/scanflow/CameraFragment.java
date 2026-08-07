package com.geniusscansdk.scanflow;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.core.os.BundleCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.box.android.data.api.models.annotations.Location;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import com.geniusscansdk.R;
import com.geniusscansdk.camera.DetectionMode;
import com.geniusscansdk.camera.FileImageCaptureCallback;
import com.geniusscansdk.camera.FlashMode;
import com.geniusscansdk.camera.FocusIndicator;
import com.geniusscansdk.camera.ScanFragment;
import com.geniusscansdk.camera.ScanFragmentLegacy;
import com.geniusscansdk.camera.realtime.BorderDetector;
import com.geniusscansdk.core.GeniusScanSDK;
import com.geniusscansdk.core.LicenseException;
import com.geniusscansdk.core.ProcessingException;
import com.geniusscansdk.core.QuadStreamAnalyzer;
import com.geniusscansdk.core.RotationAngle;
import com.google.android.material.button.MaterialButton;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.io.File;
import java.io.IOException;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: CameraFragment.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 W2\u00020\u00012\u00020\u0002:\u0001WB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J&\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010/\u001a\u00020&H\u0016J\b\u00100\u001a\u00020&H\u0016J\b\u00101\u001a\u00020\u000eH\u0002J\b\u00102\u001a\u000203H\u0002J\u0016\u00102\u001a\u0002042\u0006\u00105\u001a\u000206H\u0082@¢\u0006\u0002\u00107J\b\u00108\u001a\u00020&H\u0002J\u0015\u00109\u001a\u00020&2\u0006\u0010:\u001a\u00020\"H\u0000¢\u0006\u0002\b;J\u0012\u0010<\u001a\u00020&2\b\u0010=\u001a\u0004\u0018\u00010>H\u0002J\f\u0010?\u001a\u00020@*\u00020>H\u0002J\b\u0010A\u001a\u00020&H\u0002J\b\u0010B\u001a\u00020&H\u0002J\b\u0010C\u001a\u00020&H\u0002J\b\u0010D\u001a\u00020&H\u0002J\u0012\u0010E\u001a\u00020&2\b\u0010F\u001a\u0004\u0018\u00010GH\u0002J\b\u0010H\u001a\u00020&H\u0002J\b\u0010I\u001a\u00020JH\u0016J\u001e\u0010K\u001a\u00020&2\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u000204H\u0082@¢\u0006\u0002\u0010OJ\r\u0010P\u001a\u00020&H\u0000¢\u0006\u0002\bQJ\b\u0010R\u001a\u00020&H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010S\u001a\u00020T8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bU\u0010V¨\u0006X"}, d2 = {"Lcom/geniusscansdk/scanflow/CameraFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/geniusscansdk/camera/ScanFragment$CameraCallbackProvider;", "<init>", "()V", "scanConfiguration", "Lcom/geniusscansdk/scanflow/ScanConfiguration;", "getScanConfiguration", "()Lcom/geniusscansdk/scanflow/ScanConfiguration;", "scanConfiguration$delegate", "Lkotlin/Lazy;", "imageStore", "Lcom/geniusscansdk/scanflow/ImageStore;", "scanFragment", "Lcom/geniusscansdk/camera/ScanFragment;", "captureButton", "Lcom/geniusscansdk/scanflow/ShutterButton;", "userGuidanceTextView", "Landroid/widget/TextView;", "flashButton", "Lcom/google/android/material/button/MaterialButton;", "validateButton", "cancelButton", "photoLibraryButton", "progressBar", "Landroid/widget/ProgressBar;", "flashMode", "Lcom/geniusscansdk/scanflow/ScanConfiguration$FlashMode;", "cameraPermissionManager", "Lcom/geniusscansdk/scanflow/CameraPermissionManager;", "pickMediaLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroidx/activity/result/PickVisualMediaRequest;", "isPreviewStopped", "", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "onResume", "onPause", "createScanFragment", "takePicture", "Lkotlinx/coroutines/Job;", "Lcom/geniusscansdk/core/RotationAngle;", "outputFile", "Ljava/io/File;", "(Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDoneButton", "setRealTimeDetectionEnabled", "enabled", "setRealTimeDetectionEnabled$gssdk_release", "updateUserGuidance", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "Lcom/geniusscansdk/core/QuadStreamAnalyzer$Result;", "getUserGuidanceResId", "", "updateCaptureButtonAnimation", "initializeFlash", "toggleFlash", "updateFlashButton", "onPhotoPicked", "uri", "Landroid/net/Uri;", "stopPreview", "getCameraCallback", "Lcom/geniusscansdk/camera/ScanFragment$Callback;", "rotatePageAndFinish", Location.TYPE_PAGE, "Lcom/geniusscansdk/scanflow/Page;", "rotationAngle", "(Lcom/geniusscansdk/scanflow/Page;Lcom/geniusscansdk/core/RotationAngle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetCamera", "resetCamera$gssdk_release", "applyCustomStyle", "scanActivity", "Lcom/geniusscansdk/scanflow/ScanActivity;", "getScanActivity", "()Lcom/geniusscansdk/scanflow/ScanActivity;", "Companion", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraFragment extends Fragment implements ScanFragment.CameraCallbackProvider {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private CameraPermissionManager cameraPermissionManager;
    private MaterialButton cancelButton;
    private ShutterButton captureButton;
    private MaterialButton flashButton;
    private ScanConfiguration.FlashMode flashMode;
    private ImageStore imageStore;
    private boolean isPreviewStopped;
    private MaterialButton photoLibraryButton;
    private ActivityResultLauncher<PickVisualMediaRequest> pickMediaLauncher;
    private ProgressBar progressBar;
    private ScanFragment scanFragment;
    private TextView userGuidanceTextView;
    private MaterialButton validateButton;

    /* JADX INFO: renamed from: scanConfiguration$delegate, reason: from kotlin metadata */
    private final Lazy scanConfiguration = LazyKt.lazy(new Function0() { // from class: com.geniusscansdk.scanflow.CameraFragment$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return CameraFragment.scanConfiguration_delegate$lambda$0(this.f$0);
        }
    });
    private final CoroutineExceptionHandler exceptionHandler = new CameraFragment$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE, this);

    /* JADX INFO: renamed from: com.geniusscansdk.scanflow.CameraFragment$rotatePageAndFinish$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CameraFragment.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.geniusscansdk.scanflow.CameraFragment", f = "CameraFragment.kt", i = {0, 0}, l = {301, 307}, m = "rotatePageAndFinish", n = {"this", Location.TYPE_PAGE}, s = {"L$0", "L$1"})
    static final class C17791 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C17791(Continuation<? super C17791> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CameraFragment.this.rotatePageAndFinish(null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ScanConfiguration getScanConfiguration() {
        return (ScanConfiguration) this.scanConfiguration.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScanConfiguration scanConfiguration_delegate$lambda$0(CameraFragment cameraFragment) {
        ScanConfiguration scanConfiguration = (ScanConfiguration) BundleCompat.getSerializable(cameraFragment.requireArguments(), "scanConfiguration", ScanConfiguration.class);
        if (scanConfiguration != null) {
            return scanConfiguration;
        }
        throw new NullPointerException("Impossible to retrieve scan scanConfiguration");
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        this.imageStore = new ImageStore(contextRequireContext);
        this.cameraPermissionManager = new CameraPermissionManager(this);
        this.pickMediaLauncher = registerForActivityResult(new CustomPickImageContract(ScanActivity.INSTANCE.getSUPPORTED_IMAGE_MIME_TYPES()), new ActivityResultCallback() { // from class: com.geniusscansdk.scanflow.CameraFragment$$ExternalSyntheticLambda0
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                this.f$0.onPhotoPicked((Uri) obj);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.camera_fragment, container, false);
        ShutterButton shutterButton = (ShutterButton) viewInflate.findViewById(R.id.capture_button);
        this.captureButton = shutterButton;
        CameraPermissionManager cameraPermissionManager = null;
        if (shutterButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("captureButton");
            shutterButton = null;
        }
        shutterButton.setOnClickListener(new View.OnClickListener() { // from class: com.geniusscansdk.scanflow.CameraFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.takePicture();
            }
        });
        MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(R.id.flash_button);
        this.flashButton = materialButton;
        if (materialButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("flashButton");
            materialButton = null;
        }
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.geniusscansdk.scanflow.CameraFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.toggleFlash();
            }
        });
        MaterialButton materialButton2 = (MaterialButton) viewInflate.findViewById(R.id.photo_library_button);
        this.photoLibraryButton = materialButton2;
        if (materialButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoLibraryButton");
            materialButton2 = null;
        }
        materialButton2.setVisibility(!getScanConfiguration().photoLibraryButtonHidden ? 0 : 8);
        MaterialButton materialButton3 = this.photoLibraryButton;
        if (materialButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoLibraryButton");
            materialButton3 = null;
        }
        materialButton3.setOnClickListener(new View.OnClickListener() { // from class: com.geniusscansdk.scanflow.CameraFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CameraFragment.onCreateView$lambda$5(this.f$0, view);
            }
        });
        this.validateButton = (MaterialButton) viewInflate.findViewById(R.id.validate_button);
        updateDoneButton();
        MaterialButton materialButton4 = this.validateButton;
        if (materialButton4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("validateButton");
            materialButton4 = null;
        }
        materialButton4.setOnClickListener(new View.OnClickListener() { // from class: com.geniusscansdk.scanflow.CameraFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CameraFragment.onCreateView$lambda$6(this.f$0, view);
            }
        });
        MaterialButton materialButton5 = (MaterialButton) viewInflate.findViewById(R.id.cancel_button);
        this.cancelButton = materialButton5;
        if (materialButton5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cancelButton");
            materialButton5 = null;
        }
        materialButton5.setOnClickListener(new View.OnClickListener() { // from class: com.geniusscansdk.scanflow.CameraFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CameraFragment.onCreateView$lambda$7(this.f$0, view);
            }
        });
        this.userGuidanceTextView = (TextView) viewInflate.findViewById(R.id.user_guidance);
        this.progressBar = (ProgressBar) viewInflate.findViewById(R.id.progress_bar);
        FocusIndicator focusIndicator = (FocusIndicator) viewInflate.findViewById(R.id.focus_indicator);
        this.scanFragment = createScanFragment();
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        FragmentTransaction fragmentTransactionBeginTransaction = childFragmentManager.beginTransaction();
        int i = R.id.scan_fragment_layout;
        ScanFragment scanFragment = this.scanFragment;
        if (scanFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanFragment");
            scanFragment = null;
        }
        fragmentTransactionBeginTransaction.replace(i, scanFragment);
        fragmentTransactionBeginTransaction.commit();
        ScanFragment scanFragment2 = this.scanFragment;
        if (scanFragment2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanFragment");
            scanFragment2 = null;
        }
        scanFragment2.setJpegQuality(getScanConfiguration().jpegQuality);
        ScanFragment scanFragment3 = this.scanFragment;
        if (scanFragment3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanFragment");
            scanFragment3 = null;
        }
        scanFragment3.setOverlayColor(getScanConfiguration().highlightColor);
        ScanFragment scanFragment4 = this.scanFragment;
        if (scanFragment4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanFragment");
            scanFragment4 = null;
        }
        scanFragment4.setPreviewAspectFill(false);
        ScanFragment scanFragment5 = this.scanFragment;
        if (scanFragment5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanFragment");
            scanFragment5 = null;
        }
        scanFragment5.setDetectionMode(DetectionMode.Document.INSTANCE);
        ScanFragment scanFragment6 = this.scanFragment;
        if (scanFragment6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanFragment");
            scanFragment6 = null;
        }
        scanFragment6.setFocusIndicator(focusIndicator);
        ScanFragment scanFragment7 = this.scanFragment;
        if (scanFragment7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanFragment");
            scanFragment7 = null;
        }
        scanFragment7.setAutoTriggerAnimationEnabled(true);
        ScanFragment scanFragment8 = this.scanFragment;
        if (scanFragment8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanFragment");
            scanFragment8 = null;
        }
        scanFragment8.setBorderDetectorListener(new BorderDetector.BorderDetectorListener() { // from class: com.geniusscansdk.scanflow.CameraFragment.onCreateView.7
            @Override // com.geniusscansdk.camera.realtime.BorderDetector.BorderDetectorListener
            public void onBorderDetectionResult(QuadStreamAnalyzer.Result result) {
                Intrinsics.checkNotNullParameter(result, "result");
                if (result.status == QuadStreamAnalyzer.Status.TRIGGER) {
                    CameraFragment.this.takePicture();
                }
                CameraFragment.this.updateUserGuidance(result);
            }

            @Override // com.geniusscansdk.camera.realtime.BorderDetector.BorderDetectorListener
            public void onBorderDetectionFailure(Exception e) {
                Intrinsics.checkNotNullParameter(e, "e");
                CameraFragment.this.getScanActivity().finishWithError$gssdk_release(e);
                CameraFragment.this.stopPreview();
            }
        });
        CameraPermissionManager cameraPermissionManager2 = this.cameraPermissionManager;
        if (cameraPermissionManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraPermissionManager");
        } else {
            cameraPermissionManager = cameraPermissionManager2;
        }
        cameraPermissionManager.checkPermissionGrantedAndRequestIfNeeded();
        applyCustomStyle();
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$5(CameraFragment cameraFragment, View view) {
        ActivityResultLauncher<PickVisualMediaRequest> activityResultLauncher = cameraFragment.pickMediaLauncher;
        if (activityResultLauncher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pickMediaLauncher");
            activityResultLauncher = null;
        }
        activityResultLauncher.launch(CustomPickImageContract.INSTANCE.createRequest());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$6(CameraFragment cameraFragment, View view) {
        cameraFragment.stopPreview();
        cameraFragment.getScanActivity().onScanFlowValidated$gssdk_release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$7(CameraFragment cameraFragment, View view) {
        cameraFragment.getScanActivity().confirmDiscard$gssdk_release();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.isPreviewStopped) {
            return;
        }
        CameraPermissionManager cameraPermissionManager = this.cameraPermissionManager;
        ScanFragment scanFragment = null;
        if (cameraPermissionManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraPermissionManager");
            cameraPermissionManager = null;
        }
        if (cameraPermissionManager.isPermissionGranted()) {
            ScanFragment scanFragment2 = this.scanFragment;
            if (scanFragment2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scanFragment");
            } else {
                scanFragment = scanFragment2;
            }
            scanFragment.initializeCamera();
        }
        initializeFlash();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        updateCaptureButtonAnimation();
    }

    private final ScanFragment createScanFragment() {
        if (getScanConfiguration().getUseLegacyCameraAPI$gssdk_release()) {
            GeniusScanSDK.getLogger().warn("Using the legacy Camera API as specified in the ScanConfiguration");
            return new ScanFragmentLegacy();
        }
        ScanFragment scanFragmentCreateBestForDevice = ScanFragment.createBestForDevice();
        Intrinsics.checkNotNull(scanFragmentCreateBestForDevice);
        return scanFragmentCreateBestForDevice;
    }

    /* JADX INFO: renamed from: com.geniusscansdk.scanflow.CameraFragment$takePicture$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CameraFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.geniusscansdk.scanflow.CameraFragment$takePicture$1", f = "CameraFragment.kt", i = {0}, l = {Token.ARROW, 168}, m = "invokeSuspend", n = {"outputFile"}, s = {"L$0"})
    static final class C17801 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        C17801(Continuation<? super C17801> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CameraFragment.this.new C17801(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C17801) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0064, code lost:
        
            if (r1.rotatePageAndFinish(r4, (com.geniusscansdk.core.RotationAngle) r7, r6) == r0) goto L18;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r6.label
                r2 = 0
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L23
                if (r1 == r4) goto L1b
                if (r1 != r3) goto L13
                kotlin.ResultKt.throwOnFailure(r7)
                goto L67
            L13:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L1b:
                java.lang.Object r1 = r6.L$0
                java.io.File r1 = (java.io.File) r1
                kotlin.ResultKt.throwOnFailure(r7)
                goto L4a
            L23:
                kotlin.ResultKt.throwOnFailure(r7)
                com.geniusscansdk.scanflow.CameraFragment r7 = com.geniusscansdk.scanflow.CameraFragment.this
                com.geniusscansdk.scanflow.ImageStore r7 = com.geniusscansdk.scanflow.CameraFragment.access$getImageStore$p(r7)
                if (r7 != 0) goto L34
                java.lang.String r7 = "imageStore"
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
                r7 = r2
            L34:
                java.lang.String r1 = "jpeg"
                java.io.File r1 = r7.generateImageFile(r1)
                com.geniusscansdk.scanflow.CameraFragment r7 = com.geniusscansdk.scanflow.CameraFragment.this
                r5 = r6
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                r6.L$0 = r1
                r6.label = r4
                java.lang.Object r7 = com.geniusscansdk.scanflow.CameraFragment.access$takePicture(r7, r1, r5)
                if (r7 != r0) goto L4a
                goto L66
            L4a:
                com.geniusscansdk.core.RotationAngle r7 = (com.geniusscansdk.core.RotationAngle) r7
                com.geniusscansdk.scanflow.Page r4 = new com.geniusscansdk.scanflow.Page
                com.geniusscansdk.scanflow.CameraFragment r5 = com.geniusscansdk.scanflow.CameraFragment.this
                com.geniusscansdk.scanflow.ScanConfiguration r5 = com.geniusscansdk.scanflow.CameraFragment.access$getScanConfiguration(r5)
                r4.<init>(r1, r5)
                com.geniusscansdk.scanflow.CameraFragment r1 = com.geniusscansdk.scanflow.CameraFragment.this
                r5 = r6
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                r6.L$0 = r2
                r6.label = r3
                java.lang.Object r6 = com.geniusscansdk.scanflow.CameraFragment.access$rotatePageAndFinish(r1, r4, r7, r5)
                if (r6 != r0) goto L67
            L66:
                return r0
            L67:
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.geniusscansdk.scanflow.CameraFragment.C17801.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Job takePicture() {
        return BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), this.exceptionHandler, null, new C17801(null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object takePicture(final File file, Continuation<? super RotationAngle> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        ScanFragment scanFragment = this.scanFragment;
        if (scanFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanFragment");
            scanFragment = null;
        }
        scanFragment.takePicture(new FileImageCaptureCallback(file) { // from class: com.geniusscansdk.scanflow.CameraFragment$takePicture$3$1
            @Override // com.geniusscansdk.camera.FileImageCaptureCallback
            public void onImageCaptured(RotationAngle imageOrientation) {
                Intrinsics.checkNotNullParameter(imageOrientation, "imageOrientation");
                Continuation<RotationAngle> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m14780constructorimpl(imageOrientation));
            }

            @Override // com.geniusscansdk.camera.ImageCaptureCallback
            public void onError(Exception e) {
                Intrinsics.checkNotNullParameter(e, "e");
                Continuation<RotationAngle> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m14780constructorimpl(ResultKt.createFailure(e)));
            }
        });
        updateCaptureButtonAnimation();
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    private final void updateDoneButton() {
        int pageCount$gssdk_release = getScanActivity().getPageCount$gssdk_release();
        boolean z = getScanConfiguration().multiPage && pageCount$gssdk_release > 0;
        MaterialButton materialButton = this.validateButton;
        MaterialButton materialButton2 = null;
        if (materialButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("validateButton");
            materialButton = null;
        }
        materialButton.setVisibility(z ? 0 : 8);
        MaterialButton materialButton3 = this.validateButton;
        if (materialButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("validateButton");
        } else {
            materialButton2 = materialButton3;
        }
        materialButton2.setText(getString(R.string.gssdk_flow_done, Integer.valueOf(pageCount$gssdk_release)));
    }

    public final void setRealTimeDetectionEnabled$gssdk_release(boolean enabled) {
        ScanFragment scanFragment = this.scanFragment;
        if (scanFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanFragment");
            scanFragment = null;
        }
        scanFragment.setDetectionMode(enabled ? DetectionMode.Document.INSTANCE : DetectionMode.Disabled.INSTANCE);
        if (enabled) {
            return;
        }
        updateUserGuidance(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateUserGuidance(QuadStreamAnalyzer.Result result) {
        int userGuidanceResId = result != null ? getUserGuidanceResId(result) : 0;
        TextView textView = null;
        if (userGuidanceResId == 0) {
            TextView textView2 = this.userGuidanceTextView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userGuidanceTextView");
            } else {
                textView = textView2;
            }
            textView.setVisibility(4);
            return;
        }
        TextView textView3 = this.userGuidanceTextView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userGuidanceTextView");
            textView3 = null;
        }
        textView3.setVisibility(0);
        TextView textView4 = this.userGuidanceTextView;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userGuidanceTextView");
        } else {
            textView = textView4;
        }
        textView.setText(userGuidanceResId);
    }

    private final int getUserGuidanceResId(QuadStreamAnalyzer.Result result) {
        if (result.status == QuadStreamAnalyzer.Status.NOT_FOUND || result.resultQuadrangle == null) {
            return R.string.gssdk_user_guidance_searching;
        }
        if (result.status == QuadStreamAnalyzer.Status.SEARCHING || result.status == QuadStreamAnalyzer.Status.ABOUT_TO_TRIGGER) {
            return R.string.gssdk_user_guidance_document_found;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateCaptureButtonAnimation() {
        ShutterButton shutterButton = this.captureButton;
        ScanFragment scanFragment = null;
        if (shutterButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("captureButton");
            shutterButton = null;
        }
        ScanFragment scanFragment2 = this.scanFragment;
        if (scanFragment2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanFragment");
        } else {
            scanFragment = scanFragment2;
        }
        shutterButton.setSearchAnimationEnabled(scanFragment.isRealTimeBorderDetectionEnabled());
    }

    private final void initializeFlash() {
        ScanFragment scanFragment = this.scanFragment;
        ScanFragment scanFragment2 = null;
        if (scanFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanFragment");
            scanFragment = null;
        }
        List<FlashMode> availableFlashModes = scanFragment.getAvailableFlashModes();
        Intrinsics.checkNotNullExpressionValue(availableFlashModes, "getAvailableFlashModes(...)");
        boolean zIsEmpty = availableFlashModes.isEmpty();
        boolean z = (zIsEmpty || getScanConfiguration().flashButtonHidden) ? false : true;
        MaterialButton materialButton = this.flashButton;
        if (materialButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("flashButton");
            materialButton = null;
        }
        materialButton.setVisibility(z ? 0 : 8);
        if (!zIsEmpty && this.flashMode == null) {
            this.flashMode = getScanConfiguration().defaultFlashMode;
        }
        ScanConfiguration.FlashMode flashMode = this.flashMode;
        if (flashMode != null) {
            updateFlashButton();
            ScanFragment scanFragment3 = this.scanFragment;
            if (scanFragment3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scanFragment");
            } else {
                scanFragment2 = scanFragment3;
            }
            scanFragment2.setFlashMode(flashMode.getInternalMode());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void toggleFlash() {
        ScanFragment scanFragment = this.scanFragment;
        if (scanFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanFragment");
            scanFragment = null;
        }
        FlashMode flashMode = scanFragment.toggleFlashMode();
        this.flashMode = flashMode != null ? EnumExtKt.toScanFlowFlashMode(flashMode) : null;
        updateFlashButton();
    }

    private final void updateFlashButton() {
        MaterialButton materialButton = this.flashButton;
        MaterialButton materialButton2 = null;
        if (materialButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("flashButton");
            materialButton = null;
        }
        ScanConfiguration.FlashMode flashMode = this.flashMode;
        Intrinsics.checkNotNull(flashMode);
        materialButton.setIconResource(flashMode.getIconResId());
        ScanConfiguration.FlashMode flashMode2 = this.flashMode;
        Intrinsics.checkNotNull(flashMode2);
        String string = getString(flashMode2.getLabel());
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        MaterialButton materialButton3 = this.flashButton;
        if (materialButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("flashButton");
            materialButton3 = null;
        }
        materialButton3.setContentDescription(getString(R.string.gssdk_flash_mode) + " " + string + "}");
        MaterialButton materialButton4 = this.flashButton;
        if (materialButton4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("flashButton");
        } else {
            materialButton2 = materialButton4;
        }
        ViewCompat.setAccessibilityDelegate(materialButton2, new AccessibilityDelegateCompat() { // from class: com.geniusscansdk.scanflow.CameraFragment.updateFlashButton.1
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(View v, AccessibilityNodeInfoCompat info) {
                Intrinsics.checkNotNullParameter(v, "v");
                Intrinsics.checkNotNullParameter(info, "info");
                super.onInitializeAccessibilityNodeInfo(v, info);
                ScanFragment scanFragment = CameraFragment.this.scanFragment;
                if (scanFragment == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("scanFragment");
                    scanFragment = null;
                }
                List<FlashMode> availableFlashModes = scanFragment.getAvailableFlashModes();
                Intrinsics.checkNotNullExpressionValue(availableFlashModes, "getAvailableFlashModes(...)");
                ScanConfiguration.FlashMode flashMode3 = CameraFragment.this.flashMode;
                Intrinsics.checkNotNull(flashMode3);
                FlashMode flashMode4 = availableFlashModes.get((availableFlashModes.indexOf(flashMode3.getInternalMode()) + 1) % availableFlashModes.size());
                Intrinsics.checkNotNullExpressionValue(flashMode4, "get(...)");
                info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, CameraFragment.this.getString(EnumExtKt.toScanFlowFlashMode(flashMode4).getLabel())));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onPhotoPicked(Uri uri) {
        LifecycleCoroutineScope lifecycleScope;
        if (uri == null) {
            return;
        }
        ProgressBar progressBar = this.progressBar;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
            progressBar = null;
        }
        progressBar.setVisibility(0);
        FragmentActivity activity = getActivity();
        if (activity == null || (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(activity)) == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(lifecycleScope, this.exceptionHandler, null, new C17781(uri, this, null), 2, null);
    }

    /* JADX INFO: renamed from: com.geniusscansdk.scanflow.CameraFragment$onPhotoPicked$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CameraFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.geniusscansdk.scanflow.CameraFragment$onPhotoPicked$1", f = "CameraFragment.kt", i = {}, l = {271, 273}, m = "invokeSuspend", n = {}, s = {})
    static final class C17781 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Uri $uri;
        int label;
        final /* synthetic */ CameraFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C17781(Uri uri, CameraFragment cameraFragment, Continuation<? super C17781> continuation) {
            super(2, continuation);
            this.$uri = uri;
            this.this$0 = cameraFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C17781(this.$uri, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C17781) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0057, code lost:
        
            if (r6.this$0.rotatePageAndFinish(r1, com.geniusscansdk.core.RotationAngle.ROTATION_0, r6) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r6.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.ResultKt.throwOnFailure(r7)
                goto L5a
            L12:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L1a:
                kotlin.ResultKt.throwOnFailure(r7)
                goto L3d
            L1e:
                kotlin.ResultKt.throwOnFailure(r7)
                com.geniusscansdk.scanflow.ImageImporter r7 = com.geniusscansdk.scanflow.ImageImporter.INSTANCE
                android.net.Uri r1 = r6.$uri
                com.geniusscansdk.scanflow.CameraFragment r4 = r6.this$0
                android.content.Context r4 = r4.requireContext()
                java.lang.String r5 = "requireContext(...)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
                r5 = r6
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                r6.label = r3
                java.lang.Object r7 = r7.copyImageToFile(r1, r4, r5)
                if (r7 != r0) goto L3d
                goto L59
            L3d:
                java.io.File r7 = (java.io.File) r7
                com.geniusscansdk.scanflow.Page r1 = new com.geniusscansdk.scanflow.Page
                com.geniusscansdk.scanflow.CameraFragment r3 = r6.this$0
                com.geniusscansdk.scanflow.ScanConfiguration r3 = com.geniusscansdk.scanflow.CameraFragment.access$getScanConfiguration(r3)
                r1.<init>(r7, r3)
                com.geniusscansdk.scanflow.CameraFragment r7 = r6.this$0
                com.geniusscansdk.core.RotationAngle r3 = com.geniusscansdk.core.RotationAngle.ROTATION_0
                r4 = r6
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                r6.label = r2
                java.lang.Object r6 = com.geniusscansdk.scanflow.CameraFragment.access$rotatePageAndFinish(r7, r1, r3, r4)
                if (r6 != r0) goto L5a
            L59:
                return r0
            L5a:
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.geniusscansdk.scanflow.CameraFragment.C17781.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopPreview() {
        ScanFragment scanFragment = this.scanFragment;
        ShutterButton shutterButton = null;
        if (scanFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanFragment");
            scanFragment = null;
        }
        scanFragment.setPreviewEnabled(false);
        this.isPreviewStopped = true;
        TextView textView = this.userGuidanceTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userGuidanceTextView");
            textView = null;
        }
        textView.setVisibility(4);
        ShutterButton shutterButton2 = this.captureButton;
        if (shutterButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("captureButton");
        } else {
            shutterButton = shutterButton2;
        }
        shutterButton.setSearchAnimationEnabled(false);
    }

    @Override // com.geniusscansdk.camera.ScanFragment.CameraCallbackProvider
    public ScanFragment.Callback getCameraCallback() {
        return new ScanFragment.Callback() { // from class: com.geniusscansdk.scanflow.CameraFragment.getCameraCallback.1
            @Override // com.geniusscansdk.camera.ScanFragment.Callback
            public void onPreviewFrame(byte[] frame, int width, int height, int format) {
                Intrinsics.checkNotNullParameter(frame, "frame");
            }

            @Override // com.geniusscansdk.camera.ScanFragment.Callback
            public void onShutterTriggered() {
            }

            @Override // com.geniusscansdk.camera.ScanFragment.Callback
            public void onCameraReady() {
                CameraFragment.this.updateCaptureButtonAnimation();
            }

            @Override // com.geniusscansdk.camera.ScanFragment.Callback
            public void onCameraFailure() {
                CameraFragment.this.getScanActivity().finishWithError$gssdk_release(new Exception("Error starting camera"));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x008a, code lost:
    
        if (r7.onPageScanned$gssdk_release(r8, r0) == r1) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object rotatePageAndFinish(com.geniusscansdk.scanflow.Page r8, com.geniusscansdk.core.RotationAngle r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.geniusscansdk.scanflow.CameraFragment.C17791
            if (r0 == 0) goto L14
            r0 = r10
            com.geniusscansdk.scanflow.CameraFragment$rotatePageAndFinish$1 r0 = (com.geniusscansdk.scanflow.CameraFragment.C17791) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            com.geniusscansdk.scanflow.CameraFragment$rotatePageAndFinish$1 r0 = new com.geniusscansdk.scanflow.CameraFragment$rotatePageAndFinish$1
            r0.<init>(r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            java.lang.String r3 = "progressBar"
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L46
            if (r2 == r5) goto L39
            if (r2 != r4) goto L31
            kotlin.ResultKt.throwOnFailure(r10)
            goto L8d
        L31:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L39:
            java.lang.Object r7 = r0.L$1
            r8 = r7
            com.geniusscansdk.scanflow.Page r8 = (com.geniusscansdk.scanflow.Page) r8
            java.lang.Object r7 = r0.L$0
            com.geniusscansdk.scanflow.CameraFragment r7 = (com.geniusscansdk.scanflow.CameraFragment) r7
            kotlin.ResultKt.throwOnFailure(r10)
            goto L6f
        L46:
            kotlin.ResultKt.throwOnFailure(r10)
            android.widget.ProgressBar r10 = r7.progressBar
            if (r10 != 0) goto L51
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r10 = r6
        L51:
            r2 = 0
            r10.setVisibility(r2)
            kotlinx.coroutines.CoroutineDispatcher r10 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r10 = (kotlin.coroutines.CoroutineContext) r10
            com.geniusscansdk.scanflow.CameraFragment$rotatePageAndFinish$2 r2 = new com.geniusscansdk.scanflow.CameraFragment$rotatePageAndFinish$2
            r2.<init>(r8, r9, r6)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r5
            java.lang.Object r9 = kotlinx.coroutines.BuildersKt.withContext(r10, r2, r0)
            if (r9 != r1) goto L6f
            goto L8c
        L6f:
            android.widget.ProgressBar r9 = r7.progressBar
            if (r9 != 0) goto L77
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r9 = r6
        L77:
            r10 = 8
            r9.setVisibility(r10)
            com.geniusscansdk.scanflow.ScanActivity r7 = r7.getScanActivity()
            r0.L$0 = r6
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r7 = r7.onPageScanned$gssdk_release(r8, r0)
            if (r7 != r1) goto L8d
        L8c:
            return r1
        L8d:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.geniusscansdk.scanflow.CameraFragment.rotatePageAndFinish(com.geniusscansdk.scanflow.Page, com.geniusscansdk.core.RotationAngle, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.geniusscansdk.scanflow.CameraFragment$rotatePageAndFinish$2, reason: invalid class name */
    /* JADX INFO: compiled from: CameraFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.geniusscansdk.scanflow.CameraFragment$rotatePageAndFinish$2", f = "CameraFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Page $page;
        final /* synthetic */ RotationAngle $rotationAngle;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Page page, RotationAngle rotationAngle, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$page = page;
            this.$rotationAngle = rotationAngle;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$page, this.$rotationAngle, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws LicenseException, ProcessingException, IOException {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            String absolutePath = this.$page.getOriginalImage().getAbsolutePath();
            Intrinsics.checkNotNull(absolutePath);
            GeniusScanSDK.rotateImage$default(absolutePath, absolutePath, this.$rotationAngle, false, 8, null);
            return Unit.INSTANCE;
        }
    }

    public final void resetCamera$gssdk_release() {
        ScanFragment scanFragment = this.scanFragment;
        if (scanFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanFragment");
            scanFragment = null;
        }
        scanFragment.setPreviewEnabled(true);
        updateCaptureButtonAnimation();
        updateDoneButton();
    }

    private final void applyCustomStyle() {
        ShutterButton shutterButton = this.captureButton;
        ProgressBar progressBar = null;
        if (shutterButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("captureButton");
            shutterButton = null;
        }
        shutterButton.setButtonArcColor(getScanConfiguration().foregroundColor);
        ShutterButton shutterButton2 = this.captureButton;
        if (shutterButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("captureButton");
            shutterButton2 = null;
        }
        shutterButton2.setInnerCircleColor(getScanConfiguration().foregroundColor);
        MaterialButton materialButton = this.flashButton;
        if (materialButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("flashButton");
            materialButton = null;
        }
        ViewUtils.applyColor(materialButton, getScanConfiguration().foregroundColor, getScanConfiguration().backgroundColor);
        ViewUtils viewUtils = ViewUtils.INSTANCE;
        MaterialButton materialButton2 = this.validateButton;
        if (materialButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("validateButton");
            materialButton2 = null;
        }
        viewUtils.applyColorForFilled(materialButton2, getScanConfiguration().foregroundColor, getScanConfiguration().backgroundColor);
        MaterialButton materialButton3 = this.cancelButton;
        if (materialButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cancelButton");
            materialButton3 = null;
        }
        ViewUtils.applyColor(materialButton3, getScanConfiguration().foregroundColor, getScanConfiguration().backgroundColor);
        MaterialButton materialButton4 = this.photoLibraryButton;
        if (materialButton4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoLibraryButton");
            materialButton4 = null;
        }
        ViewUtils.applyColor(materialButton4, getScanConfiguration().foregroundColor, getScanConfiguration().backgroundColor);
        ProgressBar progressBar2 = this.progressBar;
        if (progressBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        } else {
            progressBar = progressBar2;
        }
        ViewUtils.applyColor(progressBar, getScanConfiguration().foregroundColor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ScanActivity getScanActivity() {
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.geniusscansdk.scanflow.ScanActivity");
        return (ScanActivity) activity;
    }

    /* JADX INFO: compiled from: CameraFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/geniusscansdk/scanflow/CameraFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/geniusscansdk/scanflow/CameraFragment;", "scanConfiguration", "Lcom/geniusscansdk/scanflow/ScanConfiguration;", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CameraFragment newInstance(ScanConfiguration scanConfiguration) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("scanConfiguration", scanConfiguration);
            CameraFragment cameraFragment = new CameraFragment();
            cameraFragment.setArguments(bundle);
            return cameraFragment;
        }
    }
}
