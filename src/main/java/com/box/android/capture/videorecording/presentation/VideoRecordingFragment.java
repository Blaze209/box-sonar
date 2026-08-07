package com.box.android.capture.videorecording.presentation;

import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.video.FallbackStrategy;
import androidx.camera.video.FileOutputOptions;
import androidx.camera.video.PendingRecording;
import androidx.camera.video.Quality;
import androidx.camera.video.QualitySelector;
import androidx.camera.video.Recorder;
import androidx.camera.video.Recording;
import androidx.camera.video.VideoCapture;
import androidx.camera.video.VideoRecordEvent;
import androidx.camera.view.PreviewView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.content.ContextCompat;
import androidx.core.util.Consumer;
import androidx.core.view.KeyEventDispatcher;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.box.android.capture.CameraUtils;
import com.box.android.capture.ICaptureActivity;
import com.box.android.capture.R;
import com.box.android.capture.databinding.FragmentCameraPreviewBinding;
import com.box.android.capture.videorecording.VideoRecordingReducer;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.cpl.Store;
import com.box.android.domain.models.capture.FlashMode;
import com.box.android.domain.models.capture.VideoQuality;
import com.box.android.utilities.FlowExtensionsKt;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.google.common.util.concurrent.ListenableFuture;
import dagger.hilt.android.AndroidEntryPoint;
import java.io.File;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: VideoRecordingFragment.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J$\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u001b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u0004H\u0002J\b\u0010$\u001a\u00020\u0014H\u0002J\u0010\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020'H\u0003J\b\u0010(\u001a\u00020\u0014H\u0002J\u0018\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0002J\b\u0010.\u001a\u00020\u0014H\u0002J\b\u0010/\u001a\u00020\u0014H\u0016J\b\u00100\u001a\u00020\u0014H\u0002J\f\u00101\u001a\u000202*\u00020-H\u0002R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/box/android/capture/videorecording/presentation/VideoRecordingFragment;", "Lcom/box/android/base/presentation/fragments/BoxFragment;", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/capture/videorecording/VideoRecordingReducer$State;", "Lcom/box/android/capture/videorecording/VideoRecordingReducer$Action;", "<init>", "(Lcom/box/android/cpl/Store;)V", "camera", "Landroidx/camera/core/Camera;", "cameraExecutor", "Ljava/util/concurrent/Executor;", "videoCapture", "Landroidx/camera/video/VideoCapture;", "Landroidx/camera/video/Recorder;", "activeRecording", "Landroidx/camera/video/Recording;", "binding", "Lcom/box/android/capture/databinding/FragmentCameraPreviewBinding;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "handleFlashMode", "flashMode", "Lcom/box/android/domain/models/capture/FlashMode;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "renderUI", "state", "setupUI", "startRecording", "outputFile", "Ljava/io/File;", "stopRecording", "startCamera", "cameraSelector", "Landroidx/camera/core/CameraSelector;", "videoQuality", "Lcom/box/android/domain/models/capture/VideoQuality;", "setupOnClickEvents", "onPause", "showCaptureHistory", "mapToCameraXQuality", "Landroidx/camera/video/Quality;", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class VideoRecordingFragment extends Hilt_VideoRecordingFragment {
    public static final int $stable = 8;
    private Recording activeRecording;
    private FragmentCameraPreviewBinding binding;
    private Camera camera;
    private Executor cameraExecutor;
    private final Store<VideoRecordingReducer.State, VideoRecordingReducer.Action> store;
    private VideoCapture<Recorder> videoCapture;

    /* JADX INFO: compiled from: VideoRecordingFragment.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[FlashMode.values().length];
            try {
                iArr[FlashMode.AUTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FlashMode.ON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FlashMode.OFF.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[VideoQuality.values().length];
            try {
                iArr2[VideoQuality.QUALITY_720P.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[VideoQuality.QUALITY_1080P.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[VideoQuality.QUALITY_4K.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public VideoRecordingFragment(Store<VideoRecordingReducer.State, VideoRecordingReducer.Action> store) {
        Intrinsics.checkNotNullParameter(store, "store");
        this.store = store;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Executor mainExecutor = ContextCompat.getMainExecutor(requireActivity());
        Intrinsics.checkNotNullExpressionValue(mainExecutor, "getMainExecutor(...)");
        this.cameraExecutor = mainExecutor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleFlashMode(FlashMode flashMode) {
        int i = WhenMappings.$EnumSwitchMapping$0[flashMode.ordinal()];
        Camera camera = null;
        if (i == 1) {
            Camera camera2 = this.camera;
            if (camera2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("camera");
            } else {
                camera = camera2;
            }
            camera.getCameraControl().enableTorch(false);
            return;
        }
        if (i == 2) {
            Camera camera3 = this.camera;
            if (camera3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("camera");
            } else {
                camera = camera3;
            }
            camera.getCameraControl().enableTorch(true);
            return;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        Camera camera4 = this.camera;
        if (camera4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("camera");
        } else {
            camera = camera4;
        }
        camera.getCameraControl().enableTorch(false);
    }

    /* JADX INFO: renamed from: com.box.android.capture.videorecording.presentation.VideoRecordingFragment$onCreateView$1, reason: invalid class name */
    /* JADX INFO: compiled from: VideoRecordingFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.videorecording.presentation.VideoRecordingFragment$onCreateView$1", f = "VideoRecordingFragment.kt", i = {}, l = {71}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return VideoRecordingFragment.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.box.android.capture.videorecording.presentation.VideoRecordingFragment$onCreateView$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: VideoRecordingFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.capture.videorecording.presentation.VideoRecordingFragment$onCreateView$1$1", f = "VideoRecordingFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class C01501 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ VideoRecordingFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01501(VideoRecordingFragment videoRecordingFragment, Continuation<? super C01501> continuation) {
                super(2, continuation);
                this.this$0 = videoRecordingFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C01501 c01501 = new C01501(this.this$0, continuation);
                c01501.L$0 = obj;
                return c01501;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01501) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX INFO: renamed from: com.box.android.capture.videorecording.presentation.VideoRecordingFragment$onCreateView$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: VideoRecordingFragment.kt */
            @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/box/android/capture/videorecording/VideoRecordingReducer$State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
            @DebugMetadata(c = "com.box.android.capture.videorecording.presentation.VideoRecordingFragment$onCreateView$1$1$1", f = "VideoRecordingFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            static final class C01511 extends SuspendLambda implements Function2<VideoRecordingReducer.State, Continuation<? super Unit>, Object> {
                /* synthetic */ Object L$0;
                int label;
                final /* synthetic */ VideoRecordingFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C01511(VideoRecordingFragment videoRecordingFragment, Continuation<? super C01511> continuation) {
                    super(2, continuation);
                    this.this$0 = videoRecordingFragment;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C01511 c01511 = new C01511(this.this$0, continuation);
                    c01511.L$0 = obj;
                    return c01511;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(VideoRecordingReducer.State state, Continuation<? super Unit> continuation) {
                    return ((C01511) create(state, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    VideoRecordingReducer.State state = (VideoRecordingReducer.State) this.L$0;
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.this$0.renderUI(state);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                FlowKt.launchIn(FlowKt.onEach(this.this$0.store.getState(), new C01511(this.this$0, null)), coroutineScope);
                FlowKt.launchIn(FlowKt.onEach(FlowExtensionsKt.observeAndReturnState(this.this$0.store.getState(), new PropertyReference1Impl() { // from class: com.box.android.capture.videorecording.presentation.VideoRecordingFragment.onCreateView.1.1.2
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj2) {
                        return ((VideoRecordingReducer.State) obj2).getCameraSelector();
                    }
                }), new AnonymousClass3(this.this$0, null)), coroutineScope);
                FlowKt.launchIn(FlowKt.onEach(FlowExtensionsKt.observe(this.this$0.store.getState(), new PropertyReference1Impl() { // from class: com.box.android.capture.videorecording.presentation.VideoRecordingFragment.onCreateView.1.1.4
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj2) {
                        return ((VideoRecordingReducer.State) obj2).getFlashMode();
                    }
                }), new AnonymousClass5(this.this$0, null)), coroutineScope);
                FlowKt.launchIn(FlowKt.onEach(FlowExtensionsKt.observeAndReturnState(this.this$0.store.getState(), new PropertyReference1Impl() { // from class: com.box.android.capture.videorecording.presentation.VideoRecordingFragment.onCreateView.1.1.6
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj2) {
                        return Boolean.valueOf(((VideoRecordingReducer.State) obj2).isRecording());
                    }
                }), new AnonymousClass7(this.this$0, null)), coroutineScope);
                FlowKt.launchIn(FlowKt.onEach(FlowKt.filterNotNull(FlowExtensionsKt.observe(this.this$0.store.getState(), new PropertyReference1Impl() { // from class: com.box.android.capture.videorecording.presentation.VideoRecordingFragment.onCreateView.1.1.8
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj2) {
                        return ((VideoRecordingReducer.State) obj2).getOutputFile();
                    }
                })), new AnonymousClass9(this.this$0, null)), coroutineScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: com.box.android.capture.videorecording.presentation.VideoRecordingFragment$onCreateView$1$1$3, reason: invalid class name */
            /* JADX INFO: compiled from: VideoRecordingFragment.kt */
            @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Lcom/box/android/capture/videorecording/VideoRecordingReducer$State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
            @DebugMetadata(c = "com.box.android.capture.videorecording.presentation.VideoRecordingFragment$onCreateView$1$1$3", f = "VideoRecordingFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            static final class AnonymousClass3 extends SuspendLambda implements Function2<VideoRecordingReducer.State, Continuation<? super Unit>, Object> {
                /* synthetic */ Object L$0;
                int label;
                final /* synthetic */ VideoRecordingFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass3(VideoRecordingFragment videoRecordingFragment, Continuation<? super AnonymousClass3> continuation) {
                    super(2, continuation);
                    this.this$0 = videoRecordingFragment;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.this$0, continuation);
                    anonymousClass3.L$0 = obj;
                    return anonymousClass3;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(VideoRecordingReducer.State state, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass3) create(state, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    VideoRecordingReducer.State state = (VideoRecordingReducer.State) this.L$0;
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.this$0.startCamera(state.getCameraSelector(), state.getVideoQuality());
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX INFO: renamed from: com.box.android.capture.videorecording.presentation.VideoRecordingFragment$onCreateView$1$1$5, reason: invalid class name */
            /* JADX INFO: compiled from: VideoRecordingFragment.kt */
            @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "flashMode", "Lcom/box/android/domain/models/capture/FlashMode;"}, k = 3, mv = {2, 2, 0}, xi = 48)
            @DebugMetadata(c = "com.box.android.capture.videorecording.presentation.VideoRecordingFragment$onCreateView$1$1$5", f = "VideoRecordingFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            static final class AnonymousClass5 extends SuspendLambda implements Function2<FlashMode, Continuation<? super Unit>, Object> {
                /* synthetic */ Object L$0;
                int label;
                final /* synthetic */ VideoRecordingFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass5(VideoRecordingFragment videoRecordingFragment, Continuation<? super AnonymousClass5> continuation) {
                    super(2, continuation);
                    this.this$0 = videoRecordingFragment;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass5 anonymousClass5 = new AnonymousClass5(this.this$0, continuation);
                    anonymousClass5.L$0 = obj;
                    return anonymousClass5;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(FlashMode flashMode, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass5) create(flashMode, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    FlashMode flashMode = (FlashMode) this.L$0;
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label == 0) {
                        ResultKt.throwOnFailure(obj);
                        if (this.this$0.camera != null) {
                            this.this$0.handleFlashMode(flashMode);
                        }
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX INFO: renamed from: com.box.android.capture.videorecording.presentation.VideoRecordingFragment$onCreateView$1$1$7, reason: invalid class name */
            /* JADX INFO: compiled from: VideoRecordingFragment.kt */
            @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Lcom/box/android/capture/videorecording/VideoRecordingReducer$State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
            @DebugMetadata(c = "com.box.android.capture.videorecording.presentation.VideoRecordingFragment$onCreateView$1$1$7", f = "VideoRecordingFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            static final class AnonymousClass7 extends SuspendLambda implements Function2<VideoRecordingReducer.State, Continuation<? super Unit>, Object> {
                /* synthetic */ Object L$0;
                int label;
                final /* synthetic */ VideoRecordingFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass7(VideoRecordingFragment videoRecordingFragment, Continuation<? super AnonymousClass7> continuation) {
                    super(2, continuation);
                    this.this$0 = videoRecordingFragment;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass7 anonymousClass7 = new AnonymousClass7(this.this$0, continuation);
                    anonymousClass7.L$0 = obj;
                    return anonymousClass7;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(VideoRecordingReducer.State state, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass7) create(state, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    VideoRecordingReducer.State state = (VideoRecordingReducer.State) this.L$0;
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    if (!state.isRecording() && state.getOutputFile() != null) {
                        this.this$0.stopRecording();
                    }
                    return Unit.INSTANCE;
                }
            }

            /* JADX INFO: renamed from: com.box.android.capture.videorecording.presentation.VideoRecordingFragment$onCreateView$1$1$9, reason: invalid class name */
            /* JADX INFO: compiled from: VideoRecordingFragment.kt */
            @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "outputFile", "Ljava/io/File;"}, k = 3, mv = {2, 2, 0}, xi = 48)
            @DebugMetadata(c = "com.box.android.capture.videorecording.presentation.VideoRecordingFragment$onCreateView$1$1$9", f = "VideoRecordingFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            static final class AnonymousClass9 extends SuspendLambda implements Function2<File, Continuation<? super Unit>, Object> {
                /* synthetic */ Object L$0;
                int label;
                final /* synthetic */ VideoRecordingFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass9(VideoRecordingFragment videoRecordingFragment, Continuation<? super AnonymousClass9> continuation) {
                    super(2, continuation);
                    this.this$0 = videoRecordingFragment;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass9 anonymousClass9 = new AnonymousClass9(this.this$0, continuation);
                    anonymousClass9.L$0 = obj;
                    return anonymousClass9;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(File file, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass9) create(file, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    File file = (File) this.L$0;
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.this$0.startRecording(file);
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
                LifecycleOwner viewLifecycleOwner = VideoRecordingFragment.this.getViewLifecycleOwner();
                Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(viewLifecycleOwner, Lifecycle.State.STARTED, new C01501(VideoRecordingFragment.this, null), this) == coroutine_suspended) {
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
        FragmentCameraPreviewBinding fragmentCameraPreviewBinding = null;
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new AnonymousClass1(null), 3, null);
        OnBackPressedDispatcherKt.addCallback$default(requireActivity().getOnBackPressedDispatcher(), getViewLifecycleOwner(), false, new Function1() { // from class: com.box.android.capture.videorecording.presentation.VideoRecordingFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return VideoRecordingFragment.onCreateView$lambda$0(this.f$0, (OnBackPressedCallback) obj);
            }
        }, 2, null);
        FragmentCameraPreviewBinding fragmentCameraPreviewBindingInflate = FragmentCameraPreviewBinding.inflate(getLayoutInflater(), container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentCameraPreviewBindingInflate, "inflate(...)");
        this.binding = fragmentCameraPreviewBindingInflate;
        if (fragmentCameraPreviewBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentCameraPreviewBinding = fragmentCameraPreviewBindingInflate;
        }
        ConstraintLayout root = fragmentCameraPreviewBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0(VideoRecordingFragment videoRecordingFragment, OnBackPressedCallback addCallback) {
        Intrinsics.checkNotNullParameter(addCallback, "$this$addCallback");
        videoRecordingFragment.store.send(VideoRecordingReducer.Action.CloseCamera.INSTANCE);
        return Unit.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setupUI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderUI(VideoRecordingReducer.State state) {
        FragmentCameraPreviewBinding fragmentCameraPreviewBinding = null;
        if (Intrinsics.areEqual(state.getCameraSelector(), CameraSelector.DEFAULT_BACK_CAMERA)) {
            FragmentCameraPreviewBinding fragmentCameraPreviewBinding2 = this.binding;
            if (fragmentCameraPreviewBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentCameraPreviewBinding2 = null;
            }
            fragmentCameraPreviewBinding2.captureCameraSwitchButton.setImageResource(R.drawable.ic_front_camera_24);
        } else if (Intrinsics.areEqual(state.getCameraSelector(), CameraSelector.DEFAULT_FRONT_CAMERA)) {
            FragmentCameraPreviewBinding fragmentCameraPreviewBinding3 = this.binding;
            if (fragmentCameraPreviewBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentCameraPreviewBinding3 = null;
            }
            fragmentCameraPreviewBinding3.captureCameraSwitchButton.setImageResource(R.drawable.ic_back_camera_24);
        }
        FragmentCameraPreviewBinding fragmentCameraPreviewBinding4 = this.binding;
        if (fragmentCameraPreviewBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentCameraPreviewBinding4 = null;
        }
        fragmentCameraPreviewBinding4.captureShutterButton.setImageResource(state.isRecording() ? R.drawable.capture_stop_rounded_btn : R.drawable.capture_red_rounded_btn);
        ConstraintSet constraintSet = new ConstraintSet();
        FragmentCameraPreviewBinding fragmentCameraPreviewBinding5 = this.binding;
        if (fragmentCameraPreviewBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentCameraPreviewBinding5 = null;
        }
        constraintSet.clone(fragmentCameraPreviewBinding5.caprureCameraParent);
        FragmentCameraPreviewBinding fragmentCameraPreviewBinding6 = this.binding;
        if (fragmentCameraPreviewBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentCameraPreviewBinding6 = null;
        }
        constraintSet.setDimensionRatio(fragmentCameraPreviewBinding6.captureCameraPreview.getId(), "9:16");
        FragmentCameraPreviewBinding fragmentCameraPreviewBinding7 = this.binding;
        if (fragmentCameraPreviewBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentCameraPreviewBinding7 = null;
        }
        constraintSet.applyTo(fragmentCameraPreviewBinding7.caprureCameraParent);
        if (state.isRecording()) {
            FragmentCameraPreviewBinding fragmentCameraPreviewBinding8 = this.binding;
            if (fragmentCameraPreviewBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentCameraPreviewBinding8 = null;
            }
            fragmentCameraPreviewBinding8.captureHistoryButton.setVisibility(8);
            FragmentCameraPreviewBinding fragmentCameraPreviewBinding9 = this.binding;
            if (fragmentCameraPreviewBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentCameraPreviewBinding = fragmentCameraPreviewBinding9;
            }
            fragmentCameraPreviewBinding.captureCameraSwitchButton.setVisibility(8);
            return;
        }
        FragmentCameraPreviewBinding fragmentCameraPreviewBinding10 = this.binding;
        if (fragmentCameraPreviewBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentCameraPreviewBinding10 = null;
        }
        fragmentCameraPreviewBinding10.captureHistoryButton.setVisibility(0);
        FragmentCameraPreviewBinding fragmentCameraPreviewBinding11 = this.binding;
        if (fragmentCameraPreviewBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentCameraPreviewBinding = fragmentCameraPreviewBinding11;
        }
        fragmentCameraPreviewBinding.captureCameraSwitchButton.setVisibility(0);
    }

    private final void setupUI() {
        FragmentCameraPreviewBinding fragmentCameraPreviewBinding = this.binding;
        FragmentCameraPreviewBinding fragmentCameraPreviewBinding2 = null;
        if (fragmentCameraPreviewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentCameraPreviewBinding = null;
        }
        fragmentCameraPreviewBinding.captureShutterButton.setImageResource(R.drawable.capture_red_rounded_btn);
        FragmentCameraPreviewBinding fragmentCameraPreviewBinding3 = this.binding;
        if (fragmentCameraPreviewBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentCameraPreviewBinding3 = null;
        }
        fragmentCameraPreviewBinding3.captureHistoryButton.initView(this);
        FragmentCameraPreviewBinding fragmentCameraPreviewBinding4 = this.binding;
        if (fragmentCameraPreviewBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentCameraPreviewBinding4 = null;
        }
        final Guideline guidelineBottomInset = fragmentCameraPreviewBinding4.guidelineBottomInset;
        Intrinsics.checkNotNullExpressionValue(guidelineBottomInset, "guidelineBottomInset");
        FragmentCameraPreviewBinding fragmentCameraPreviewBinding5 = this.binding;
        if (fragmentCameraPreviewBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentCameraPreviewBinding2 = fragmentCameraPreviewBinding5;
        }
        ConstraintLayout root = fragmentCameraPreviewBinding2.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        ViewCompat.setOnApplyWindowInsetsListener(root, new OnApplyWindowInsetsListener() { // from class: com.box.android.capture.videorecording.presentation.VideoRecordingFragment$$ExternalSyntheticLambda5
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return VideoRecordingFragment.setupUI$lambda$0(guidelineBottomInset, view, windowInsetsCompat);
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
        return insets;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startRecording(File outputFile) {
        FileOutputOptions fileOutputOptionsBuild = new FileOutputOptions.Builder(outputFile).build();
        Intrinsics.checkNotNullExpressionValue(fileOutputOptionsBuild, "build(...)");
        VideoCapture<Recorder> videoCapture = this.videoCapture;
        if (videoCapture != null) {
            PendingRecording pendingRecordingWithAudioEnabled = ((Recorder) videoCapture.getOutput()).prepareRecording(requireContext(), fileOutputOptionsBuild).withAudioEnabled();
            Intrinsics.checkNotNullExpressionValue(pendingRecordingWithAudioEnabled, "withAudioEnabled(...)");
            Executor executor = this.cameraExecutor;
            if (executor == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cameraExecutor");
                executor = null;
            }
            this.activeRecording = pendingRecordingWithAudioEnabled.start(executor, new Consumer() { // from class: com.box.android.capture.videorecording.presentation.VideoRecordingFragment$$ExternalSyntheticLambda1
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    VideoRecordingFragment.startRecording$lambda$0$0(this.f$0, (VideoRecordEvent) obj);
                }
            });
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.setRequestedOrientation(14);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startRecording$lambda$0$0(VideoRecordingFragment videoRecordingFragment, VideoRecordEvent videoRecordEvent) {
        if (videoRecordEvent instanceof VideoRecordEvent.Finalize) {
            videoRecordingFragment.store.send(VideoRecordingReducer.Action.ReviewRecording.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopRecording() {
        Recording recording = this.activeRecording;
        if (recording != null) {
            recording.stop();
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setRequestedOrientation(!getResources().getBoolean(com.box.android.domain.R.bool.is7inchOrLarger) ? 1 : -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startCamera(final CameraSelector cameraSelector, VideoQuality videoQuality) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        requireActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        final int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final int statusBarHeight = i2 + CommonBoxUtil.getStatusBarHeight(contextRequireContext);
        Quality qualityMapToCameraXQuality = mapToCameraXQuality(videoQuality);
        final QualitySelector qualitySelectorFrom = QualitySelector.from(qualityMapToCameraXQuality, FallbackStrategy.lowerQualityThan(qualityMapToCameraXQuality));
        Intrinsics.checkNotNullExpressionValue(qualitySelectorFrom, "from(...)");
        ProcessCameraProvider.Companion companion = ProcessCameraProvider.INSTANCE;
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        final ListenableFuture<ProcessCameraProvider> companion2 = companion.getInstance(fragmentActivityRequireActivity);
        companion2.addListener(new Runnable() { // from class: com.box.android.capture.videorecording.presentation.VideoRecordingFragment$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                VideoRecordingFragment.startCamera$lambda$0(companion2, i, statusBarHeight, qualitySelectorFrom, this, cameraSelector);
            }
        }, ContextCompat.getMainExecutor(requireActivity()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void startCamera$lambda$0(ListenableFuture listenableFuture, int i, int i2, QualitySelector qualitySelector, VideoRecordingFragment videoRecordingFragment, CameraSelector cameraSelector) {
        ProcessCameraProvider processCameraProvider = (ProcessCameraProvider) listenableFuture.get();
        Preview previewBuild = new Preview.Builder().setTargetResolution(new Size(i, i2)).build();
        FragmentCameraPreviewBinding fragmentCameraPreviewBinding = videoRecordingFragment.binding;
        FragmentCameraPreviewBinding fragmentCameraPreviewBinding2 = null;
        if (fragmentCameraPreviewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentCameraPreviewBinding = null;
        }
        previewBuild.setSurfaceProvider(fragmentCameraPreviewBinding.captureCameraPreview.getSurfaceProvider());
        Intrinsics.checkNotNullExpressionValue(previewBuild, "also(...)");
        Recorder recorderBuild = new Recorder.Builder().setQualitySelector(qualitySelector).build();
        Intrinsics.checkNotNullExpressionValue(recorderBuild, "build(...)");
        videoRecordingFragment.videoCapture = VideoCapture.withOutput(recorderBuild);
        try {
            processCameraProvider.unbindAll();
            videoRecordingFragment.camera = processCameraProvider.bindToLifecycle(videoRecordingFragment, cameraSelector, videoRecordingFragment.videoCapture, previewBuild);
            videoRecordingFragment.handleFlashMode(videoRecordingFragment.store.getState().getValue().getFlashMode());
        } catch (Exception e) {
            BoxLogUtils.e("Camera binding failed", new Throwable(e.getMessage()));
        }
        videoRecordingFragment.setupOnClickEvents();
        CameraUtils cameraUtils = CameraUtils.INSTANCE;
        Camera camera = videoRecordingFragment.camera;
        if (camera == null) {
            Intrinsics.throwUninitializedPropertyAccessException("camera");
            camera = null;
        }
        FragmentCameraPreviewBinding fragmentCameraPreviewBinding3 = videoRecordingFragment.binding;
        if (fragmentCameraPreviewBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentCameraPreviewBinding2 = fragmentCameraPreviewBinding3;
        }
        PreviewView captureCameraPreview = fragmentCameraPreviewBinding2.captureCameraPreview;
        Intrinsics.checkNotNullExpressionValue(captureCameraPreview, "captureCameraPreview");
        cameraUtils.setupZoom(camera, captureCameraPreview);
    }

    private final void setupOnClickEvents() {
        FragmentCameraPreviewBinding fragmentCameraPreviewBinding = this.binding;
        FragmentCameraPreviewBinding fragmentCameraPreviewBinding2 = null;
        if (fragmentCameraPreviewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentCameraPreviewBinding = null;
        }
        fragmentCameraPreviewBinding.captureCameraSwitchButton.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.videorecording.presentation.VideoRecordingFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoRecordingFragment.setupOnClickEvents$lambda$0(this.f$0, view);
            }
        });
        FragmentCameraPreviewBinding fragmentCameraPreviewBinding3 = this.binding;
        if (fragmentCameraPreviewBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentCameraPreviewBinding3 = null;
        }
        fragmentCameraPreviewBinding3.captureShutterButton.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.videorecording.presentation.VideoRecordingFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoRecordingFragment.setupOnClickEvents$lambda$1(this.f$0, view);
            }
        });
        FragmentCameraPreviewBinding fragmentCameraPreviewBinding4 = this.binding;
        if (fragmentCameraPreviewBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentCameraPreviewBinding2 = fragmentCameraPreviewBinding4;
        }
        fragmentCameraPreviewBinding2.captureHistoryButton.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.videorecording.presentation.VideoRecordingFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.showCaptureHistory();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupOnClickEvents$lambda$0(VideoRecordingFragment videoRecordingFragment, View view) {
        videoRecordingFragment.store.send(VideoRecordingReducer.Action.ToggleCamera.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupOnClickEvents$lambda$1(VideoRecordingFragment videoRecordingFragment, View view) {
        if (videoRecordingFragment.store.getState().getValue().isRecording()) {
            videoRecordingFragment.store.send(VideoRecordingReducer.Action.StopRecording.INSTANCE);
        } else {
            videoRecordingFragment.store.send(VideoRecordingReducer.Action.TryStartRecording.INSTANCE);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.store.getState().getValue().isRecording()) {
            this.store.send(VideoRecordingReducer.Action.StopRecording.INSTANCE);
        }
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

    private final Quality mapToCameraXQuality(VideoQuality videoQuality) {
        int i = WhenMappings.$EnumSwitchMapping$1[videoQuality.ordinal()];
        if (i == 1) {
            Quality HD = Quality.HD;
            Intrinsics.checkNotNullExpressionValue(HD, "HD");
            return HD;
        }
        if (i == 2) {
            Quality FHD = Quality.FHD;
            Intrinsics.checkNotNullExpressionValue(FHD, "FHD");
            return FHD;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        Quality UHD = Quality.UHD;
        Intrinsics.checkNotNullExpressionValue(UHD, "UHD");
        return UHD;
    }
}
