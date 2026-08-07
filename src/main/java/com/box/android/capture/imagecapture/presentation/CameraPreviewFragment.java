package com.box.android.capture.imagecapture.presentation;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.Preview;
import androidx.camera.core.resolutionselector.AspectRatioStrategy;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.content.ContextCompat;
import androidx.core.view.KeyEventDispatcher;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.box.android.capture.CameraUtils;
import com.box.android.capture.ICaptureActivity;
import com.box.android.capture.R;
import com.box.android.capture.cpl.ImageCaptureReducer;
import com.box.android.capture.databinding.FragmentCameraPreviewBinding;
import com.box.android.capture.imagecapture.logic.ImageMetadataHelper;
import com.box.android.capture.viewmodel.CaptureViewModel;
import com.box.android.cpl.Store;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.android.utilities.FlowExtensionsKt;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.common.util.concurrent.ListenableFuture;
import dagger.hilt.android.AndroidEntryPoint;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: CameraPreviewFragment.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000w\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u001d\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J$\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u001a\u0010+\u001a\u00020\"2\u0006\u0010,\u001a\u00020&2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010-\u001a\u00020\"H\u0002J\u0018\u0010.\u001a\u00020\"2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0002J\b\u00103\u001a\u00020\"H\u0016J\b\u00104\u001a\u00020\"H\u0016J\b\u00105\u001a\u00020\"H\u0002J\b\u00106\u001a\u00020\"H\u0002J\u000e\u00107\u001a\u00020\"H\u0082@¢\u0006\u0002\u00108R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0019\u001a\u0004\b\u001e\u0010\u001f¨\u00069"}, d2 = {"Lcom/box/android/capture/imagecapture/presentation/CameraPreviewFragment;", "Lcom/box/android/base/presentation/fragments/BoxFragment;", "cameraStore", "Lcom/box/android/cpl/Store;", "Lcom/box/android/capture/cpl/ImageCaptureReducer$State$Camera;", "Lcom/box/android/capture/cpl/ImageCaptureReducer$Action;", "<init>", "(Lcom/box/android/cpl/Store;)V", "binding", "Lcom/box/android/capture/databinding/FragmentCameraPreviewBinding;", "getBinding", "()Lcom/box/android/capture/databinding/FragmentCameraPreviewBinding;", "setBinding", "(Lcom/box/android/capture/databinding/FragmentCameraPreviewBinding;)V", "camera", "Landroidx/camera/core/Camera;", "cameraExecutor", "Ljava/util/concurrent/Executor;", "fusedLocationClient", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "captureViewModel", "Lcom/box/android/capture/viewmodel/CaptureViewModel;", "getCaptureViewModel", "()Lcom/box/android/capture/viewmodel/CaptureViewModel;", "captureViewModel$delegate", "Lkotlin/Lazy;", "imageCapture", "Landroidx/camera/core/ImageCapture;", "orientationEventListener", "com/box/android/capture/imagecapture/presentation/CameraPreviewFragment$orientationEventListener$2$1", "getOrientationEventListener", "()Lcom/box/android/capture/imagecapture/presentation/CameraPreviewFragment$orientationEventListener$2$1;", "orientationEventListener$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "setupUI", "startCamera", "cameraSelector", "Landroidx/camera/core/CameraSelector;", "flashMode", "", "onStart", "onStop", "setupOnClickEvents", "showCaptureHistory", "captureImage", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class CameraPreviewFragment extends Hilt_CameraPreviewFragment {
    public static final int $stable = 8;
    public FragmentCameraPreviewBinding binding;
    private Camera camera;
    private Executor cameraExecutor;
    private final Store<ImageCaptureReducer.State.Camera, ImageCaptureReducer.Action> cameraStore;

    /* JADX INFO: renamed from: captureViewModel$delegate, reason: from kotlin metadata */
    private final Lazy captureViewModel;
    private FusedLocationProviderClient fusedLocationClient;
    private ImageCapture imageCapture;

    /* JADX INFO: renamed from: orientationEventListener$delegate, reason: from kotlin metadata */
    private final Lazy orientationEventListener;

    /* JADX INFO: renamed from: com.box.android.capture.imagecapture.presentation.CameraPreviewFragment$captureImage$1, reason: invalid class name */
    /* JADX INFO: compiled from: CameraPreviewFragment.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.imagecapture.presentation.CameraPreviewFragment", f = "CameraPreviewFragment.kt", i = {0}, l = {202}, m = "captureImage", n = {"outputFile"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CameraPreviewFragment.this.captureImage(this);
        }
    }

    public CameraPreviewFragment(Store<ImageCaptureReducer.State.Camera, ImageCaptureReducer.Action> cameraStore) {
        Intrinsics.checkNotNullParameter(cameraStore, "cameraStore");
        this.cameraStore = cameraStore;
        final CameraPreviewFragment cameraPreviewFragment = this;
        final Function0 function0 = null;
        this.captureViewModel = FragmentViewModelLazyKt.createViewModelLazy(cameraPreviewFragment, Reflection.getOrCreateKotlinClass(CaptureViewModel.class), new Function0<ViewModelStore>() { // from class: com.box.android.capture.imagecapture.presentation.CameraPreviewFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return cameraPreviewFragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.box.android.capture.imagecapture.presentation.CameraPreviewFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? cameraPreviewFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.box.android.capture.imagecapture.presentation.CameraPreviewFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return cameraPreviewFragment.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
        this.orientationEventListener = LazyKt.lazy(new Function0() { // from class: com.box.android.capture.imagecapture.presentation.CameraPreviewFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CameraPreviewFragment.orientationEventListener_delegate$lambda$0(this.f$0);
            }
        });
    }

    public final FragmentCameraPreviewBinding getBinding() {
        FragmentCameraPreviewBinding fragmentCameraPreviewBinding = this.binding;
        if (fragmentCameraPreviewBinding != null) {
            return fragmentCameraPreviewBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(FragmentCameraPreviewBinding fragmentCameraPreviewBinding) {
        Intrinsics.checkNotNullParameter(fragmentCameraPreviewBinding, "<set-?>");
        this.binding = fragmentCameraPreviewBinding;
    }

    private final CaptureViewModel getCaptureViewModel() {
        return (CaptureViewModel) this.captureViewModel.getValue();
    }

    private final CameraPreviewFragment$orientationEventListener$2$1 getOrientationEventListener() {
        return (CameraPreviewFragment$orientationEventListener$2$1) this.orientationEventListener.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.box.android.capture.imagecapture.presentation.CameraPreviewFragment$orientationEventListener$2$1] */
    public static final CameraPreviewFragment$orientationEventListener$2$1 orientationEventListener_delegate$lambda$0(final CameraPreviewFragment cameraPreviewFragment) {
        final Context contextRequireContext = cameraPreviewFragment.requireContext();
        return new OrientationEventListener(contextRequireContext) { // from class: com.box.android.capture.imagecapture.presentation.CameraPreviewFragment$orientationEventListener$2$1
            @Override // android.view.OrientationEventListener
            public void onOrientationChanged(int orientation) {
                int i;
                if (orientation == -1) {
                    return;
                }
                if (45 <= orientation && orientation < 135) {
                    i = 3;
                } else if (135 > orientation || orientation >= 225) {
                    i = (225 > orientation || orientation >= 315) ? 0 : 1;
                } else {
                    i = 2;
                }
                ImageCapture imageCapture = this.this$0.imageCapture;
                if (imageCapture != null) {
                    imageCapture.setTargetRotation(i);
                }
            }
        };
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(requireContext());
        Intrinsics.checkNotNullExpressionValue(fusedLocationProviderClient, "getFusedLocationProviderClient(...)");
        this.fusedLocationClient = fusedLocationProviderClient;
        Executor mainExecutor = ContextCompat.getMainExecutor(requireActivity());
        Intrinsics.checkNotNullExpressionValue(mainExecutor, "getMainExecutor(...)");
        this.cameraExecutor = mainExecutor;
    }

    /* JADX INFO: renamed from: com.box.android.capture.imagecapture.presentation.CameraPreviewFragment$onCreateView$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CameraPreviewFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.imagecapture.presentation.CameraPreviewFragment$onCreateView$1", f = "CameraPreviewFragment.kt", i = {}, l = {87}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C09931 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C09931(Continuation<? super C09931> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CameraPreviewFragment.this.new C09931(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09931) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.box.android.capture.imagecapture.presentation.CameraPreviewFragment$onCreateView$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: CameraPreviewFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.capture.imagecapture.presentation.CameraPreviewFragment$onCreateView$1$1", f = "CameraPreviewFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class C01481 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ CameraPreviewFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01481(CameraPreviewFragment cameraPreviewFragment, Continuation<? super C01481> continuation) {
                super(2, continuation);
                this.this$0 = cameraPreviewFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C01481 c01481 = new C01481(this.this$0, continuation);
                c01481.L$0 = obj;
                return c01481;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01481) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                FlowKt.launchIn(FlowKt.onEach(FlowExtensionsKt.observeAndReturnState(this.this$0.cameraStore.getState(), new PropertyReference1Impl() { // from class: com.box.android.capture.imagecapture.presentation.CameraPreviewFragment.onCreateView.1.1.1
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj2) {
                        return ((ImageCaptureReducer.State.Camera) obj2).getCameraSelector();
                    }
                }), new AnonymousClass2(this.this$0, null)), coroutineScope);
                FlowKt.launchIn(FlowKt.onEach(this.this$0.cameraStore.getState(), new AnonymousClass3(this.this$0, null)), coroutineScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: com.box.android.capture.imagecapture.presentation.CameraPreviewFragment$onCreateView$1$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: CameraPreviewFragment.kt */
            @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Lcom/box/android/capture/cpl/ImageCaptureReducer$State$Camera;"}, k = 3, mv = {2, 2, 0}, xi = 48)
            @DebugMetadata(c = "com.box.android.capture.imagecapture.presentation.CameraPreviewFragment$onCreateView$1$1$2", f = "CameraPreviewFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            static final class AnonymousClass2 extends SuspendLambda implements Function2<ImageCaptureReducer.State.Camera, Continuation<? super Unit>, Object> {
                /* synthetic */ Object L$0;
                int label;
                final /* synthetic */ CameraPreviewFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass2(CameraPreviewFragment cameraPreviewFragment, Continuation<? super AnonymousClass2> continuation) {
                    super(2, continuation);
                    this.this$0 = cameraPreviewFragment;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, continuation);
                    anonymousClass2.L$0 = obj;
                    return anonymousClass2;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(ImageCaptureReducer.State.Camera camera, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass2) create(camera, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    ImageCaptureReducer.State.Camera camera = (ImageCaptureReducer.State.Camera) this.L$0;
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    if (Intrinsics.areEqual(camera.getCameraSelector(), CameraSelector.DEFAULT_BACK_CAMERA)) {
                        this.this$0.getBinding().captureCameraSwitchButton.setImageResource(R.drawable.ic_front_camera_24);
                    } else if (Intrinsics.areEqual(camera.getCameraSelector(), CameraSelector.DEFAULT_FRONT_CAMERA)) {
                        this.this$0.getBinding().captureCameraSwitchButton.setImageResource(R.drawable.ic_back_camera_24);
                    }
                    this.this$0.startCamera(camera.getCameraSelector(), camera.getFlashMode().intValue());
                    return Unit.INSTANCE;
                }
            }

            /* JADX INFO: renamed from: com.box.android.capture.imagecapture.presentation.CameraPreviewFragment$onCreateView$1$1$3, reason: invalid class name */
            /* JADX INFO: compiled from: CameraPreviewFragment.kt */
            @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Lcom/box/android/capture/cpl/ImageCaptureReducer$State$Camera;"}, k = 3, mv = {2, 2, 0}, xi = 48)
            @DebugMetadata(c = "com.box.android.capture.imagecapture.presentation.CameraPreviewFragment$onCreateView$1$1$3", f = "CameraPreviewFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            static final class AnonymousClass3 extends SuspendLambda implements Function2<ImageCaptureReducer.State.Camera, Continuation<? super Unit>, Object> {
                /* synthetic */ Object L$0;
                int label;
                final /* synthetic */ CameraPreviewFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass3(CameraPreviewFragment cameraPreviewFragment, Continuation<? super AnonymousClass3> continuation) {
                    super(2, continuation);
                    this.this$0 = cameraPreviewFragment;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.this$0, continuation);
                    anonymousClass3.L$0 = obj;
                    return anonymousClass3;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(ImageCaptureReducer.State.Camera camera, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass3) create(camera, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    ImageCaptureReducer.State.Camera camera = (ImageCaptureReducer.State.Camera) this.L$0;
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label == 0) {
                        ResultKt.throwOnFailure(obj);
                        ImageCapture imageCapture = this.this$0.imageCapture;
                        if (imageCapture != null) {
                            imageCapture.setFlashMode(camera.getFlashMode().intValue());
                        }
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LifecycleOwner viewLifecycleOwner = CameraPreviewFragment.this.getViewLifecycleOwner();
                Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(viewLifecycleOwner, Lifecycle.State.STARTED, new C01481(CameraPreviewFragment.this, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C09931(null), 3, null);
        OnBackPressedDispatcherKt.addCallback$default(requireActivity().getOnBackPressedDispatcher(), getViewLifecycleOwner(), false, new Function1() { // from class: com.box.android.capture.imagecapture.presentation.CameraPreviewFragment$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CameraPreviewFragment.onCreateView$lambda$0(this.f$0, (OnBackPressedCallback) obj);
            }
        }, 2, null);
        FragmentCameraPreviewBinding fragmentCameraPreviewBindingInflate = FragmentCameraPreviewBinding.inflate(getLayoutInflater(), container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentCameraPreviewBindingInflate, "inflate(...)");
        setBinding(fragmentCameraPreviewBindingInflate);
        ConstraintLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0(CameraPreviewFragment cameraPreviewFragment, OnBackPressedCallback addCallback) {
        Intrinsics.checkNotNullParameter(addCallback, "$this$addCallback");
        cameraPreviewFragment.cameraStore.send(ImageCaptureReducer.Action.CloseCamera.INSTANCE);
        return Unit.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setupUI();
    }

    private final void setupUI() {
        getBinding().captureHistoryButton.initView(this);
        final Guideline guidelineBottomInset = getBinding().guidelineBottomInset;
        Intrinsics.checkNotNullExpressionValue(guidelineBottomInset, "guidelineBottomInset");
        ConstraintLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        ViewCompat.setOnApplyWindowInsetsListener(root, new OnApplyWindowInsetsListener() { // from class: com.box.android.capture.imagecapture.presentation.CameraPreviewFragment$$ExternalSyntheticLambda5
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return CameraPreviewFragment.setupUI$lambda$0(guidelineBottomInset, view, windowInsetsCompat);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat setupUI$lambda$0(Guideline guideline, View view, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        Intrinsics.checkNotNullParameter(insets, "insets");
        int i = insets.getInsets(WindowInsetsCompat.Type.systemBars()).bottom;
        Guideline guideline2 = guideline;
        ViewGroup.LayoutParams layoutParams = guideline2.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ConstraintLayout.LayoutParams layoutParams3 = layoutParams2;
        ViewGroup.LayoutParams layoutParams4 = guideline2.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams4 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams4 : null;
        layoutParams3.guideEnd = i + (marginLayoutParams != null ? marginLayoutParams.bottomMargin : 0);
        guideline2.setLayoutParams(layoutParams2);
        return WindowInsetsCompat.CONSUMED;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startCamera(final CameraSelector cameraSelector, final int flashMode) {
        final ResolutionSelector resolutionSelectorBuild = new ResolutionSelector.Builder().setAspectRatioStrategy(AspectRatioStrategy.RATIO_4_3_FALLBACK_AUTO_STRATEGY).build();
        Intrinsics.checkNotNullExpressionValue(resolutionSelectorBuild, "build(...)");
        ProcessCameraProvider.Companion companion = ProcessCameraProvider.INSTANCE;
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        final ListenableFuture<ProcessCameraProvider> companion2 = companion.getInstance(fragmentActivityRequireActivity);
        companion2.addListener(new Runnable() { // from class: com.box.android.capture.imagecapture.presentation.CameraPreviewFragment$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                CameraPreviewFragment.startCamera$lambda$0(companion2, resolutionSelectorBuild, this, flashMode, cameraSelector);
            }
        }, ContextCompat.getMainExecutor(requireActivity()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void startCamera$lambda$0(ListenableFuture listenableFuture, ResolutionSelector resolutionSelector, CameraPreviewFragment cameraPreviewFragment, int i, CameraSelector cameraSelector) {
        ProcessCameraProvider processCameraProvider = (ProcessCameraProvider) listenableFuture.get();
        Preview previewBuild = new Preview.Builder().setResolutionSelector(resolutionSelector).build();
        previewBuild.setSurfaceProvider(cameraPreviewFragment.getBinding().captureCameraPreview.getSurfaceProvider());
        Intrinsics.checkNotNullExpressionValue(previewBuild, "also(...)");
        cameraPreviewFragment.imageCapture = new ImageCapture.Builder().setFlashMode(i).setResolutionSelector(resolutionSelector).build();
        try {
            processCameraProvider.unbindAll();
            cameraPreviewFragment.camera = processCameraProvider.bindToLifecycle(cameraPreviewFragment, cameraSelector, previewBuild, cameraPreviewFragment.imageCapture);
        } catch (Exception e) {
            BoxLogUtils.e("Camera binding failed", new Throwable(e.getMessage()));
        }
        cameraPreviewFragment.setupOnClickEvents();
        CameraUtils cameraUtils = CameraUtils.INSTANCE;
        Camera camera = cameraPreviewFragment.camera;
        if (camera == null) {
            Intrinsics.throwUninitializedPropertyAccessException("camera");
            camera = null;
        }
        PreviewView captureCameraPreview = cameraPreviewFragment.getBinding().captureCameraPreview;
        Intrinsics.checkNotNullExpressionValue(captureCameraPreview, "captureCameraPreview");
        cameraUtils.setupZoom(camera, captureCameraPreview);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        getOrientationEventListener().enable();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        getOrientationEventListener().disable();
    }

    private final void setupOnClickEvents() {
        getBinding().captureCameraSwitchButton.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.imagecapture.presentation.CameraPreviewFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CameraPreviewFragment.setupOnClickEvents$lambda$0(this.f$0, view);
            }
        });
        getBinding().captureShutterButton.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.imagecapture.presentation.CameraPreviewFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CameraPreviewFragment.setupOnClickEvents$lambda$1(this.f$0, view);
            }
        });
        getBinding().captureHistoryButton.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.imagecapture.presentation.CameraPreviewFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.showCaptureHistory();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupOnClickEvents$lambda$0(CameraPreviewFragment cameraPreviewFragment, View view) {
        cameraPreviewFragment.cameraStore.send(ImageCaptureReducer.Action.ToggleCamera.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupOnClickEvents$lambda$1(CameraPreviewFragment cameraPreviewFragment, View view) {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(cameraPreviewFragment), null, null, new CameraPreviewFragment$setupOnClickEvents$2$1(cameraPreviewFragment, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showCaptureHistory() {
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "getParentFragmentManager(...)");
        FragmentTransaction fragmentTransactionBeginTransaction = parentFragmentManager.beginTransaction();
        fragmentTransactionBeginTransaction.addToBackStack(null);
        KeyEventDispatcher.Component activity = getActivity();
        ICaptureActivity iCaptureActivity = activity instanceof ICaptureActivity ? (ICaptureActivity) activity : null;
        if (iCaptureActivity != null) {
            iCaptureActivity.showCaptureHistory(fragmentTransactionBeginTransaction);
        }
        fragmentTransactionBeginTransaction.commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object captureImage(Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        final File file;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        Executor executor = null;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                BoxAmplitudeAnalytics.createCaptureEventBuilder().logCapturePhotoSnapped();
                File newFile = getCaptureViewModel().getNewFile();
                ImageMetadataHelper imageMetadataHelper = ImageMetadataHelper.INSTANCE;
                boolean saveGpsLocation = this.cameraStore.getState().getValue().getSaveGpsLocation();
                FusedLocationProviderClient fusedLocationProviderClient = this.fusedLocationClient;
                if (fusedLocationProviderClient == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fusedLocationClient");
                    fusedLocationProviderClient = null;
                }
                anonymousClass1.L$0 = newFile;
                anonymousClass1.label = 1;
                Object metadata = imageMetadataHelper.getMetadata(saveGpsLocation, fusedLocationProviderClient, anonymousClass1);
                if (metadata == coroutine_suspended) {
                    return coroutine_suspended;
                }
                file = newFile;
                obj = metadata;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                file = (File) anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj);
            }
            ImageCapture.OutputFileOptions outputFileOptionsBuild = new ImageCapture.OutputFileOptions.Builder(file).setMetadata((ImageCapture.Metadata) obj).build();
            Intrinsics.checkNotNullExpressionValue(outputFileOptionsBuild, "build(...)");
            ImageCapture imageCapture = this.imageCapture;
            if (imageCapture != null) {
                Executor executor2 = this.cameraExecutor;
                if (executor2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cameraExecutor");
                } else {
                    executor = executor2;
                }
                imageCapture.m146lambda$takePicture$2$androidxcameracoreImageCapture(outputFileOptionsBuild, executor, new ImageCapture.OnImageSavedCallback() { // from class: com.box.android.capture.imagecapture.presentation.CameraPreviewFragment.captureImage.2
                    @Override // androidx.camera.core.ImageCapture.OnImageSavedCallback
                    public void onImageSaved(ImageCapture.OutputFileResults outputFileResults) {
                        Intrinsics.checkNotNullParameter(outputFileResults, "outputFileResults");
                        CameraPreviewFragment.this.cameraStore.send(new ImageCaptureReducer.Action.ImageSaved(file, ((ImageCaptureReducer.State.Camera) CameraPreviewFragment.this.cameraStore.getState().getValue()).getPhotoQuality()));
                        BoxLogUtils.i(ExtensionsKt.getTAG(this), "Successfully captured a photo");
                    }

                    @Override // androidx.camera.core.ImageCapture.OnImageSavedCallback
                    public void onError(ImageCaptureException exception) {
                        Intrinsics.checkNotNullParameter(exception, "exception");
                        BoxLogUtils.w(ExtensionsKt.getTAG(this), "Failed to capture image");
                    }
                });
            }
        } catch (IOException unused) {
            BoxLogUtils.w(ExtensionsKt.getTAG(this), "Failed to create new file");
        }
        return Unit.INSTANCE;
    }
}
