package com.box.android.capture.videorecording.presentation;

import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.media3.common.MediaItem;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.media3.ui.PlayerView;
import com.box.android.capture.R;
import com.box.android.capture.databinding.FragmentVideoReviewBinding;
import com.box.android.capture.videorecording.VideoReviewReducer;
import com.box.android.cpl.Store;
import com.box.android.utilities.FlowExtensionsKt;
import dagger.hilt.android.AndroidEntryPoint;
import java.io.File;
import kotlin.Metadata;
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

/* JADX INFO: compiled from: VideoReviewFragment.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0004H\u0002J\b\u0010\u001b\u001a\u00020\u0015H\u0002J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/box/android/capture/videorecording/presentation/VideoReviewFragment;", "Lcom/box/android/base/presentation/fragments/BoxFragment;", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/capture/videorecording/VideoReviewReducer$State;", "Lcom/box/android/capture/videorecording/VideoReviewReducer$Action;", "<init>", "(Lcom/box/android/cpl/Store;)V", "exoPlayer", "Landroidx/media3/exoplayer/ExoPlayer;", "binding", "Lcom/box/android/capture/databinding/FragmentVideoReviewBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "supportEdgeToEdge", "onDestroyView", "renderUI", "state", "showDiscardWarningDialog", "prepareMediaPlayer", "recordedFileUri", "Landroid/net/Uri;", "Companion", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class VideoReviewFragment extends Hilt_VideoReviewFragment {
    private static final long SEEK_INCREMENT_IN_MS = 10000;
    private FragmentVideoReviewBinding binding;
    private ExoPlayer exoPlayer;
    private final Store<VideoReviewReducer.State, VideoReviewReducer.Action> store;
    public static final int $stable = 8;

    public VideoReviewFragment(Store<VideoReviewReducer.State, VideoReviewReducer.Action> store) {
        Intrinsics.checkNotNullParameter(store, "store");
        this.store = store;
    }

    /* JADX INFO: renamed from: com.box.android.capture.videorecording.presentation.VideoReviewFragment$onCreateView$1, reason: invalid class name */
    /* JADX INFO: compiled from: VideoReviewFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.videorecording.presentation.VideoReviewFragment$onCreateView$1", f = "VideoReviewFragment.kt", i = {}, l = {37}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return VideoReviewFragment.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.box.android.capture.videorecording.presentation.VideoReviewFragment$onCreateView$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: VideoReviewFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.capture.videorecording.presentation.VideoReviewFragment$onCreateView$1$1", f = "VideoReviewFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class C01521 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ VideoReviewFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01521(VideoReviewFragment videoReviewFragment, Continuation<? super C01521> continuation) {
                super(2, continuation);
                this.this$0 = videoReviewFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C01521 c01521 = new C01521(this.this$0, continuation);
                c01521.L$0 = obj;
                return c01521;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01521) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX INFO: renamed from: com.box.android.capture.videorecording.presentation.VideoReviewFragment$onCreateView$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: VideoReviewFragment.kt */
            @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/box/android/capture/videorecording/VideoReviewReducer$State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
            @DebugMetadata(c = "com.box.android.capture.videorecording.presentation.VideoReviewFragment$onCreateView$1$1$1", f = "VideoReviewFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            static final class C01531 extends SuspendLambda implements Function2<VideoReviewReducer.State, Continuation<? super Unit>, Object> {
                /* synthetic */ Object L$0;
                int label;
                final /* synthetic */ VideoReviewFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C01531(VideoReviewFragment videoReviewFragment, Continuation<? super C01531> continuation) {
                    super(2, continuation);
                    this.this$0 = videoReviewFragment;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C01531 c01531 = new C01531(this.this$0, continuation);
                    c01531.L$0 = obj;
                    return c01531;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(VideoReviewReducer.State state, Continuation<? super Unit> continuation) {
                    return ((C01531) create(state, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    VideoReviewReducer.State state = (VideoReviewReducer.State) this.L$0;
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
                FlowKt.launchIn(FlowKt.onEach(this.this$0.store.getState(), new C01531(this.this$0, null)), coroutineScope);
                FlowKt.launchIn(FlowKt.onEach(FlowExtensionsKt.observe(this.this$0.store.getState(), new PropertyReference1Impl() { // from class: com.box.android.capture.videorecording.presentation.VideoReviewFragment.onCreateView.1.1.2
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj2) {
                        return ((VideoReviewReducer.State) obj2).getOutputFile();
                    }
                }), new AnonymousClass3(this.this$0, null)), coroutineScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: com.box.android.capture.videorecording.presentation.VideoReviewFragment$onCreateView$1$1$3, reason: invalid class name */
            /* JADX INFO: compiled from: VideoReviewFragment.kt */
            @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Ljava/io/File;"}, k = 3, mv = {2, 2, 0}, xi = 48)
            @DebugMetadata(c = "com.box.android.capture.videorecording.presentation.VideoReviewFragment$onCreateView$1$1$3", f = "VideoReviewFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            static final class AnonymousClass3 extends SuspendLambda implements Function2<File, Continuation<? super Unit>, Object> {
                /* synthetic */ Object L$0;
                int label;
                final /* synthetic */ VideoReviewFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass3(VideoReviewFragment videoReviewFragment, Continuation<? super AnonymousClass3> continuation) {
                    super(2, continuation);
                    this.this$0 = videoReviewFragment;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.this$0, continuation);
                    anonymousClass3.L$0 = obj;
                    return anonymousClass3;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(File file, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass3) create(file, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    File file = (File) this.L$0;
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    VideoReviewFragment videoReviewFragment = this.this$0;
                    Uri uriFromFile = Uri.fromFile(file);
                    Intrinsics.checkNotNullExpressionValue(uriFromFile, "fromFile(...)");
                    videoReviewFragment.exoPlayer = videoReviewFragment.prepareMediaPlayer(uriFromFile);
                    FragmentVideoReviewBinding fragmentVideoReviewBinding = this.this$0.binding;
                    ExoPlayer exoPlayer = null;
                    if (fragmentVideoReviewBinding == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        fragmentVideoReviewBinding = null;
                    }
                    fragmentVideoReviewBinding.videoPlayer.setControllerShowTimeoutMs(3000);
                    FragmentVideoReviewBinding fragmentVideoReviewBinding2 = this.this$0.binding;
                    if (fragmentVideoReviewBinding2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        fragmentVideoReviewBinding2 = null;
                    }
                    PlayerView playerView = fragmentVideoReviewBinding2.videoPlayer;
                    ExoPlayer exoPlayer2 = this.this$0.exoPlayer;
                    if (exoPlayer2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("exoPlayer");
                    } else {
                        exoPlayer = exoPlayer2;
                    }
                    playerView.setPlayer(exoPlayer);
                    return Unit.INSTANCE;
                }
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LifecycleOwner viewLifecycleOwner = VideoReviewFragment.this.getViewLifecycleOwner();
                Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(viewLifecycleOwner, Lifecycle.State.STARTED, new C01521(VideoReviewFragment.this, null), this) == coroutine_suspended) {
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
        FragmentVideoReviewBinding fragmentVideoReviewBinding = null;
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new AnonymousClass1(null), 3, null);
        OnBackPressedDispatcherKt.addCallback$default(requireActivity().getOnBackPressedDispatcher(), getViewLifecycleOwner(), false, new Function1() { // from class: com.box.android.capture.videorecording.presentation.VideoReviewFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return VideoReviewFragment.onCreateView$lambda$0(this.f$0, (OnBackPressedCallback) obj);
            }
        }, 2, null);
        FragmentVideoReviewBinding fragmentVideoReviewBindingInflate = FragmentVideoReviewBinding.inflate(getLayoutInflater(), container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentVideoReviewBindingInflate, "inflate(...)");
        this.binding = fragmentVideoReviewBindingInflate;
        if (fragmentVideoReviewBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentVideoReviewBinding = fragmentVideoReviewBindingInflate;
        }
        ConstraintLayout root = fragmentVideoReviewBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0(VideoReviewFragment videoReviewFragment, OnBackPressedCallback addCallback) {
        Intrinsics.checkNotNullParameter(addCallback, "$this$addCallback");
        videoReviewFragment.store.send(VideoReviewReducer.Action.TryDiscardRecording.INSTANCE);
        return Unit.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        FragmentVideoReviewBinding fragmentVideoReviewBinding = this.binding;
        FragmentVideoReviewBinding fragmentVideoReviewBinding2 = null;
        if (fragmentVideoReviewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVideoReviewBinding = null;
        }
        fragmentVideoReviewBinding.videoRecordingDiscard.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.videorecording.presentation.VideoReviewFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                VideoReviewFragment.onViewCreated$lambda$0(this.f$0, view2);
            }
        });
        FragmentVideoReviewBinding fragmentVideoReviewBinding3 = this.binding;
        if (fragmentVideoReviewBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentVideoReviewBinding2 = fragmentVideoReviewBinding3;
        }
        fragmentVideoReviewBinding2.videoRecordingSave.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.videorecording.presentation.VideoReviewFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                VideoReviewFragment.onViewCreated$lambda$1(this.f$0, view2);
            }
        });
        supportEdgeToEdge();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(VideoReviewFragment videoReviewFragment, View view) {
        videoReviewFragment.store.send(VideoReviewReducer.Action.TryDiscardRecording.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(VideoReviewFragment videoReviewFragment, View view) {
        videoReviewFragment.store.send(VideoReviewReducer.Action.PrepareRecording.INSTANCE);
    }

    private final void supportEdgeToEdge() {
        FragmentVideoReviewBinding fragmentVideoReviewBinding = this.binding;
        if (fragmentVideoReviewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVideoReviewBinding = null;
        }
        ViewCompat.setOnApplyWindowInsetsListener(fragmentVideoReviewBinding.getRoot(), new OnApplyWindowInsetsListener() { // from class: com.box.android.capture.videorecording.presentation.VideoReviewFragment$$ExternalSyntheticLambda1
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return VideoReviewFragment.supportEdgeToEdge$lambda$0(this.f$0, view, windowInsetsCompat);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat supportEdgeToEdge$lambda$0(VideoReviewFragment videoReviewFragment, View view, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        Intrinsics.checkNotNullParameter(insets, "insets");
        int i = insets.getInsets(WindowInsetsCompat.Type.systemBars()).bottom;
        FragmentVideoReviewBinding fragmentVideoReviewBinding = videoReviewFragment.binding;
        if (fragmentVideoReviewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVideoReviewBinding = null;
        }
        ConstraintLayout bottomBar = fragmentVideoReviewBinding.bottomBar;
        Intrinsics.checkNotNullExpressionValue(bottomBar, "bottomBar");
        ConstraintLayout constraintLayout = bottomBar;
        ViewGroup.LayoutParams layoutParams = constraintLayout.getLayoutParams();
        if (layoutParams != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = i;
            constraintLayout.setLayoutParams(marginLayoutParams);
            return WindowInsetsCompat.CONSUMED;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ExoPlayer exoPlayer = this.exoPlayer;
        if (exoPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("exoPlayer");
            exoPlayer = null;
        }
        exoPlayer.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderUI(VideoReviewReducer.State state) {
        if (state.isDiscarding()) {
            showDiscardWarningDialog();
        }
    }

    private final void showDiscardWarningDialog() {
        new AlertDialog.Builder(requireContext(), R.style.Theme_Box_Dialog_Alert).setTitle(R.string.video_recording_discard_title).setMessage(R.string.video_recording_discard_message).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.box.android.capture.videorecording.presentation.VideoReviewFragment$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                VideoReviewFragment.showDiscardWarningDialog$lambda$0(this.f$0, dialogInterface);
            }
        }).setNegativeButton(R.string.audio_recording_cancel, new DialogInterface.OnClickListener() { // from class: com.box.android.capture.videorecording.presentation.VideoReviewFragment$$ExternalSyntheticLambda5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).setPositiveButton(R.string.LS_Delete, new DialogInterface.OnClickListener() { // from class: com.box.android.capture.videorecording.presentation.VideoReviewFragment$$ExternalSyntheticLambda6
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                VideoReviewFragment.showDiscardWarningDialog$lambda$2(this.f$0, dialogInterface, i);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDiscardWarningDialog$lambda$0(VideoReviewFragment videoReviewFragment, DialogInterface dialogInterface) {
        videoReviewFragment.store.send(VideoReviewReducer.Action.KeepRecording.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDiscardWarningDialog$lambda$2(VideoReviewFragment videoReviewFragment, DialogInterface dialogInterface, int i) {
        videoReviewFragment.store.send(VideoReviewReducer.Action.DiscardRecording.INSTANCE);
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ExoPlayer prepareMediaPlayer(Uri recordedFileUri) {
        ExoPlayer exoPlayerBuild = new ExoPlayer.Builder(requireContext()).setSeekForwardIncrementMs(10000L).setSeekBackIncrementMs(10000L).build();
        Intrinsics.checkNotNullExpressionValue(exoPlayerBuild, "build(...)");
        exoPlayerBuild.setMediaItem(MediaItem.fromUri(recordedFileUri));
        exoPlayerBuild.prepare();
        return exoPlayerBuild;
    }
}
