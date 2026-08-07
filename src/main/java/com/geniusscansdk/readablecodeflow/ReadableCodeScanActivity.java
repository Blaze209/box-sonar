package com.geniusscansdk.readablecodeflow;

import android.content.Intent;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.IntentCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import com.geniusscansdk.R;
import com.geniusscansdk.camera.DetectionMode;
import com.geniusscansdk.camera.ReadableCodeDetectionCallback;
import com.geniusscansdk.camera.ScanFragment;
import com.geniusscansdk.camera.ScanFragmentX;
import com.geniusscansdk.camera.SpatialReadableCode;
import com.geniusscansdk.camera.SpatialReadableCodeKt;
import com.geniusscansdk.core.GeniusScanSDK;
import com.geniusscansdk.core.LicenseException;
import com.geniusscansdk.scanflow.ActivityExtKt;
import com.geniusscansdk.scanflow.ViewUtils;
import com.geniusscansdk.structureddata.ReadableCode;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: ReadableCodeScanActivity.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 ;2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001;B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0014J\b\u0010$\u001a\u00020!H\u0014J\b\u0010%\u001a\u00020!H\u0014J\b\u0010&\u001a\u00020!H\u0002J\b\u0010'\u001a\u00020!H\u0002J\b\u0010(\u001a\u00020!H\u0002J\b\u0010)\u001a\u00020!H\u0002J\b\u0010*\u001a\u00020+H\u0002J\b\u0010,\u001a\u00020!H\u0002J\b\u0010-\u001a\u00020!H\u0002J\u0010\u0010.\u001a\u00020!2\u0006\u0010/\u001a\u000200H\u0002J\b\u00101\u001a\u000202H\u0016J\u0016\u00103\u001a\u00020!2\f\u00104\u001a\b\u0012\u0004\u0012\u00020605H\u0016J\u0014\u00107\u001a\u00020!2\n\u00108\u001a\u000609j\u0002`:H\u0016R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/geniusscansdk/readablecodeflow/ReadableCodeScanActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/geniusscansdk/camera/ScanFragment$CameraCallbackProvider;", "Lcom/geniusscansdk/camera/ReadableCodeDetectionCallback;", "<init>", "()V", "configuration", "Lcom/geniusscansdk/readablecodeflow/ReadableCodeConfiguration;", "getConfiguration", "()Lcom/geniusscansdk/readablecodeflow/ReadableCodeConfiguration;", "configuration$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/geniusscansdk/readablecodeflow/ReadableCodeScanViewModel;", "getViewModel", "()Lcom/geniusscansdk/readablecodeflow/ReadableCodeScanViewModel;", "viewModel$delegate", "scanFragment", "Lcom/geniusscansdk/camera/ScanFragment;", "vibrator", "Landroid/os/Vibrator;", "overlayView", "Lcom/geniusscansdk/readablecodeflow/ReadableCodeOverlayView;", "bottomSheetBehavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/view/View;", "bottomSheetView", "bottomSheetAdapter", "Lcom/geniusscansdk/readablecodeflow/ReadableCodeAdapter;", "cameraPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onDestroy", "setupUI", "setupBottomSheet", "setupViewModel", "setupScanFragment", "isCameraPermissionGranted", "", "showBatchModeBottomSheet", "cancelScanningSession", "finishWithResult", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "Lcom/geniusscansdk/readablecodeflow/ReadableCodeFlowResult;", "getCameraCallback", "Lcom/geniusscansdk/camera/ScanFragment$Callback;", "onReadableCodesDetected", "codes", "", "Lcom/geniusscansdk/camera/SpatialReadableCode;", "onDetectorInitializationFailed", "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Companion", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReadableCodeScanActivity extends AppCompatActivity implements ScanFragment.CameraCallbackProvider, ReadableCodeDetectionCallback {
    public static final String CONFIGURATION_KEY = "readableCodeConfiguration";
    public static final String RESULT_KEY = "readableCodeFlowResult";
    private ReadableCodeAdapter bottomSheetAdapter;
    private BottomSheetBehavior<View> bottomSheetBehavior;
    private View bottomSheetView;
    private ReadableCodeOverlayView overlayView;
    private ScanFragment scanFragment;
    private Vibrator vibrator;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: configuration$delegate, reason: from kotlin metadata */
    private final Lazy configuration = LazyKt.lazy(new Function0() { // from class: com.geniusscansdk.readablecodeflow.ReadableCodeScanActivity$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ReadableCodeScanActivity.configuration_delegate$lambda$0(this.f$0);
        }
    });
    private final ActivityResultLauncher<String> cameraPermissionLauncher = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback() { // from class: com.geniusscansdk.readablecodeflow.ReadableCodeScanActivity$$ExternalSyntheticLambda3
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            ReadableCodeScanActivity.cameraPermissionLauncher$lambda$1(this.f$0, ((Boolean) obj).booleanValue());
        }
    });

    public ReadableCodeScanActivity() {
        final ReadableCodeScanActivity readableCodeScanActivity = this;
        final Function0 function0 = null;
        this.viewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(ReadableCodeScanViewModel.class), new Function0<ViewModelStore>() { // from class: com.geniusscansdk.readablecodeflow.ReadableCodeScanActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return readableCodeScanActivity.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.geniusscansdk.readablecodeflow.ReadableCodeScanActivity$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return readableCodeScanActivity.getDefaultViewModelProviderFactory();
            }
        }, new Function0<CreationExtras>() { // from class: com.geniusscansdk.readablecodeflow.ReadableCodeScanActivity$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? readableCodeScanActivity.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReadableCodeConfiguration getConfiguration() {
        return (ReadableCodeConfiguration) this.configuration.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReadableCodeConfiguration configuration_delegate$lambda$0(ReadableCodeScanActivity readableCodeScanActivity) {
        ReadableCodeConfiguration readableCodeConfiguration = (ReadableCodeConfiguration) IntentCompat.getParcelableExtra(readableCodeScanActivity.getIntent(), CONFIGURATION_KEY, ReadableCodeConfiguration.class);
        if (readableCodeConfiguration != null) {
            return readableCodeConfiguration;
        }
        throw new IllegalArgumentException("ReadableCodeConfiguration is required");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReadableCodeScanViewModel getViewModel() {
        return (ReadableCodeScanViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cameraPermissionLauncher$lambda$1(ReadableCodeScanActivity readableCodeScanActivity, boolean z) {
        if (z) {
            return;
        }
        readableCodeScanActivity.finishWithResult(new ReadableCodeFlowResult.Error(ErrorType.PERMISSION_DENIED, "Camera permission denied"));
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        super.onMAMCreate(bundle);
        ReadableCodeOverlayView readableCodeOverlayView = null;
        EdgeToEdge.enable$default(this, null, null, 3, null);
        try {
            GeniusScanSDK.checkInitialization();
        } catch (LicenseException e) {
            String message = e.getMessage();
            if (message == null) {
                message = "License exception";
            }
            finishWithResult(new ReadableCodeFlowResult.Error(ErrorType.INITIALIZATION_FAILURE, message));
        }
        ActivityExtKt.lockOrientationToPortraitOnPhones(this);
        setContentView(R.layout.readable_code_scan_activity);
        this.vibrator = (Vibrator) ContextCompat.getSystemService(this, Vibrator.class);
        ReadableCodeOverlayView readableCodeOverlayView2 = (ReadableCodeOverlayView) findViewById(R.id.readable_code_overlay);
        this.overlayView = readableCodeOverlayView2;
        if (readableCodeOverlayView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("overlayView");
        } else {
            readableCodeOverlayView = readableCodeOverlayView2;
        }
        readableCodeOverlayView.setOverlayColor(getConfiguration().getHighlightColor());
        setupUI();
        setupScanFragment();
        setupViewModel();
        if (isCameraPermissionGranted()) {
            return;
        }
        this.cameraPermissionLauncher.launch("android.permission.CAMERA");
    }

    @Override // androidx.fragment.app.FragmentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMResume() {
        super.onMAMResume();
        if (isCameraPermissionGranted()) {
            ScanFragment scanFragment = this.scanFragment;
            if (scanFragment == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scanFragment");
                scanFragment = null;
            }
            scanFragment.initializeCamera();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMDestroy() {
        super.onMAMDestroy();
        ScanFragment scanFragment = this.scanFragment;
        if (scanFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanFragment");
            scanFragment = null;
        }
        scanFragment.setReadableCodeDetectionCallback(null);
        this.vibrator = null;
    }

    private final void setupUI() {
        findViewById(R.id.cancel_button).setOnClickListener(new View.OnClickListener() { // from class: com.geniusscansdk.readablecodeflow.ReadableCodeScanActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.cancelScanningSession();
            }
        });
        if (getConfiguration().isBatchModeEnabled()) {
            setupBottomSheet();
        }
    }

    private final void setupBottomSheet() {
        View viewFindViewById = findViewById(R.id.batch_mode_bottom_sheet);
        this.bottomSheetView = viewFindViewById;
        final BottomSheetBehavior<View> bottomSheetBehaviorFrom = BottomSheetBehavior.from(viewFindViewById);
        this.bottomSheetBehavior = bottomSheetBehaviorFrom;
        if (bottomSheetBehaviorFrom != null) {
            bottomSheetBehaviorFrom.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() { // from class: com.geniusscansdk.readablecodeflow.ReadableCodeScanActivity$setupBottomSheet$1$1
                @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
                public void onSlide(View bottomSheet, float slideOffset) {
                    Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
                }

                @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
                public void onStateChanged(View bottomSheet, int newState) {
                    Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
                    if (newState == 5 && this.this$0.getViewModel().isBatchModeEnabled()) {
                        bottomSheetBehaviorFrom.setState(4);
                    }
                }
            });
        }
        RecyclerView recyclerView = (RecyclerView) viewFindViewById.findViewById(R.id.codes_recycler_view);
        ReadableCodeAdapter readableCodeAdapter = new ReadableCodeAdapter();
        this.bottomSheetAdapter = readableCodeAdapter;
        recyclerView.setAdapter(readableCodeAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MaterialButton materialButton = (MaterialButton) viewFindViewById.findViewById(R.id.done_button);
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.geniusscansdk.readablecodeflow.ReadableCodeScanActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadableCodeScanActivity.setupBottomSheet$lambda$4(this.f$0, view);
            }
        });
        ViewUtils viewUtils = ViewUtils.INSTANCE;
        Intrinsics.checkNotNull(materialButton);
        viewUtils.applyColorForFilled(materialButton, getConfiguration().getMenuColor(), -1);
        TextView textView = (TextView) viewFindViewById.findViewById(R.id.title_text);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass3(materialButton, (TextView) viewFindViewById.findViewById(R.id.empty_state_text), recyclerView, textView, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupBottomSheet$lambda$4(ReadableCodeScanActivity readableCodeScanActivity, View view) {
        readableCodeScanActivity.getViewModel().finishBatchScanning();
    }

    /* JADX INFO: renamed from: com.geniusscansdk.readablecodeflow.ReadableCodeScanActivity$setupBottomSheet$3, reason: invalid class name */
    /* JADX INFO: compiled from: ReadableCodeScanActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.geniusscansdk.readablecodeflow.ReadableCodeScanActivity$setupBottomSheet$3", f = "ReadableCodeScanActivity.kt", i = {}, l = {Token.METHOD}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MaterialButton $doneButton;
        final /* synthetic */ TextView $emptyStateText;
        final /* synthetic */ RecyclerView $recyclerView;
        final /* synthetic */ TextView $titleText;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(MaterialButton materialButton, TextView textView, RecyclerView recyclerView, TextView textView2, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$doneButton = materialButton;
            this.$emptyStateText = textView;
            this.$recyclerView = recyclerView;
            this.$titleText = textView2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ReadableCodeScanActivity.this.new AnonymousClass3(this.$doneButton, this.$emptyStateText, this.$recyclerView, this.$titleText, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<List<ReadableCode>> detectedCodes = ReadableCodeScanActivity.this.getViewModel().getDetectedCodes();
                final ReadableCodeScanActivity readableCodeScanActivity = ReadableCodeScanActivity.this;
                final MaterialButton materialButton = this.$doneButton;
                final TextView textView = this.$emptyStateText;
                final RecyclerView recyclerView = this.$recyclerView;
                final TextView textView2 = this.$titleText;
                this.label = 1;
                if (detectedCodes.collect(new FlowCollector() { // from class: com.geniusscansdk.readablecodeflow.ReadableCodeScanActivity.setupBottomSheet.3.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((List<ReadableCode>) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(List<ReadableCode> list, Continuation<? super Unit> continuation) {
                        String string;
                        ReadableCodeAdapter readableCodeAdapter = readableCodeScanActivity.bottomSheetAdapter;
                        if (readableCodeAdapter != null) {
                            readableCodeAdapter.submitList(list);
                        }
                        List<ReadableCode> list2 = list;
                        materialButton.setEnabled(!list2.isEmpty());
                        if (list.isEmpty()) {
                            textView.setVisibility(0);
                            recyclerView.setVisibility(8);
                        } else {
                            textView.setVisibility(8);
                            recyclerView.setVisibility(0);
                        }
                        TextView textView3 = textView2;
                        if (!list2.isEmpty()) {
                            string = readableCodeScanActivity.getResources().getQuantityString(R.plurals.gssdk_batch_mode_codes_detected, list.size(), Boxing.boxInt(list.size()));
                        } else {
                            string = readableCodeScanActivity.getString(R.string.gssdk_batch_mode_title);
                        }
                        textView3.setText(string);
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    private final void setupViewModel() {
        getViewModel().initialize(getConfiguration());
        ReadableCodeScanActivity readableCodeScanActivity = this;
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(readableCodeScanActivity), null, null, new C17741(null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(readableCodeScanActivity), null, null, new AnonymousClass2(null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(readableCodeScanActivity), null, null, new C17753(null), 3, null);
    }

    /* JADX INFO: renamed from: com.geniusscansdk.readablecodeflow.ReadableCodeScanActivity$setupViewModel$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ReadableCodeScanActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.geniusscansdk.readablecodeflow.ReadableCodeScanActivity$setupViewModel$1", f = "ReadableCodeScanActivity.kt", i = {}, l = {190}, m = "invokeSuspend", n = {}, s = {})
    static final class C17741 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C17741(Continuation<? super C17741> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ReadableCodeScanActivity.this.new C17741(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C17741) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<ReadableCodeScanViewModel.ScanState> scanResult = ReadableCodeScanActivity.this.getViewModel().getScanResult();
                final ReadableCodeScanActivity readableCodeScanActivity = ReadableCodeScanActivity.this;
                this.label = 1;
                if (scanResult.collect(new FlowCollector() { // from class: com.geniusscansdk.readablecodeflow.ReadableCodeScanActivity.setupViewModel.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((ReadableCodeScanViewModel.ScanState) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(ReadableCodeScanViewModel.ScanState scanState, Continuation<? super Unit> continuation) {
                        if (scanState instanceof ReadableCodeScanViewModel.ScanState.Success) {
                            readableCodeScanActivity.finishWithResult(new ReadableCodeFlowResult.Success(((ReadableCodeScanViewModel.ScanState.Success) scanState).getCodes()));
                        } else if (scanState instanceof ReadableCodeScanViewModel.ScanState.Error) {
                            ReadableCodeScanViewModel.ScanState.Error error = (ReadableCodeScanViewModel.ScanState.Error) scanState;
                            readableCodeScanActivity.finishWithResult(new ReadableCodeFlowResult.Error(error.getErrorType(), error.getMessage()));
                        }
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: renamed from: com.geniusscansdk.readablecodeflow.ReadableCodeScanActivity$setupViewModel$2, reason: invalid class name */
    /* JADX INFO: compiled from: ReadableCodeScanActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.geniusscansdk.readablecodeflow.ReadableCodeScanActivity$setupViewModel$2", f = "ReadableCodeScanActivity.kt", i = {}, l = {204}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ReadableCodeScanActivity.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<Boolean> shouldShowBatchBottomSheet = ReadableCodeScanActivity.this.getViewModel().getShouldShowBatchBottomSheet();
                final ReadableCodeScanActivity readableCodeScanActivity = ReadableCodeScanActivity.this;
                this.label = 1;
                if (shouldShowBatchBottomSheet.collect(new FlowCollector() { // from class: com.geniusscansdk.readablecodeflow.ReadableCodeScanActivity.setupViewModel.2.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit(((Boolean) obj2).booleanValue(), (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(boolean z, Continuation<? super Unit> continuation) {
                        if (z && readableCodeScanActivity.getConfiguration().isBatchModeEnabled()) {
                            readableCodeScanActivity.showBatchModeBottomSheet();
                        }
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: renamed from: com.geniusscansdk.readablecodeflow.ReadableCodeScanActivity$setupViewModel$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ReadableCodeScanActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.geniusscansdk.readablecodeflow.ReadableCodeScanActivity$setupViewModel$3", f = "ReadableCodeScanActivity.kt", i = {}, l = {BoxCommonConstants.REQUEST_RENAME}, m = "invokeSuspend", n = {}, s = {})
    static final class C17753 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C17753(Continuation<? super C17753> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ReadableCodeScanActivity.this.new C17753(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C17753) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<Boolean> shouldVibrate = ReadableCodeScanActivity.this.getViewModel().getShouldVibrate();
                final ReadableCodeScanActivity readableCodeScanActivity = ReadableCodeScanActivity.this;
                this.label = 1;
                if (shouldVibrate.collect(new FlowCollector() { // from class: com.geniusscansdk.readablecodeflow.ReadableCodeScanActivity.setupViewModel.3.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit(((Boolean) obj2).booleanValue(), (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(boolean z, Continuation<? super Unit> continuation) {
                        Vibrator vibrator;
                        if (z && (vibrator = readableCodeScanActivity.vibrator) != null) {
                            vibrator.vibrate(VibrationEffect.createOneShot(100L, -1));
                        }
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    private final void setupScanFragment() {
        ScanFragmentX scanFragmentX = new ScanFragmentX();
        scanFragmentX.setPreviewAspectFill(true);
        scanFragmentX.setDetectionMode(new DetectionMode.ReadableCode(getConfiguration()));
        scanFragmentX.setReadableCodeDetectionCallback(this);
        this.scanFragment = scanFragmentX;
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        int i = R.id.scan_fragment_container;
        ScanFragment scanFragment = this.scanFragment;
        if (scanFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanFragment");
            scanFragment = null;
        }
        fragmentTransactionBeginTransaction.replace(i, scanFragment).commitNow();
    }

    private final boolean isCameraPermissionGranted() {
        return ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showBatchModeBottomSheet() {
        View view = this.bottomSheetView;
        if (view != null) {
            view.setVisibility(0);
            BottomSheetBehavior<View> bottomSheetBehavior = this.bottomSheetBehavior;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.setState(4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cancelScanningSession() {
        finishWithResult(ReadableCodeFlowResult.Canceled.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finishWithResult(ReadableCodeFlowResult result) {
        Intent intentPutExtra = new Intent().putExtra(RESULT_KEY, result);
        Intrinsics.checkNotNullExpressionValue(intentPutExtra, "putExtra(...)");
        setResult(-1, intentPutExtra);
        finish();
    }

    @Override // com.geniusscansdk.camera.ScanFragment.CameraCallbackProvider
    public ScanFragment.Callback getCameraCallback() {
        return new ScanFragment.Callback() { // from class: com.geniusscansdk.readablecodeflow.ReadableCodeScanActivity.getCameraCallback.1
            @Override // com.geniusscansdk.camera.ScanFragment.Callback
            public void onPreviewFrame(byte[] frame, int width, int height, int format) {
            }

            @Override // com.geniusscansdk.camera.ScanFragment.Callback
            public void onShutterTriggered() {
            }

            @Override // com.geniusscansdk.camera.ScanFragment.Callback
            public void onCameraReady() {
                GeniusScanSDK.getLogger().debug("ReadableCodeScanActivity: Camera ready");
            }

            @Override // com.geniusscansdk.camera.ScanFragment.Callback
            public void onCameraFailure() {
                GeniusScanSDK.getLogger().error("ReadableCodeScanActivity: Camera failure");
                ReadableCodeScanActivity.this.finishWithResult(new ReadableCodeFlowResult.Error(ErrorType.INITIALIZATION_FAILURE, "Camera initialization failed"));
            }
        };
    }

    @Override // com.geniusscansdk.camera.ReadableCodeDetectionCallback
    public void onReadableCodesDetected(List<SpatialReadableCode> codes) {
        Intrinsics.checkNotNullParameter(codes, "codes");
        ReadableCodeScanViewModel viewModel = getViewModel();
        List<SpatialReadableCode> list = codes;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(SpatialReadableCodeKt.toReadableCode((SpatialReadableCode) it.next()));
        }
        viewModel.onCodesDetected(arrayList);
        ReadableCodeOverlayView readableCodeOverlayView = this.overlayView;
        if (readableCodeOverlayView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("overlayView");
            readableCodeOverlayView = null;
        }
        readableCodeOverlayView.updateDetectedCodes(codes);
    }

    @Override // com.geniusscansdk.camera.ReadableCodeDetectionCallback
    public void onDetectorInitializationFailed(Exception error) {
        Intrinsics.checkNotNullParameter(error, "error");
        GeniusScanSDK.getLogger().error("ReadableCodeScanActivity: Detector initialization failed: " + error.getMessage());
        finishWithResult(new ReadableCodeFlowResult.Error(ErrorType.INITIALIZATION_FAILURE, "Barcode detector initialization failed: " + error.getMessage()));
    }
}
