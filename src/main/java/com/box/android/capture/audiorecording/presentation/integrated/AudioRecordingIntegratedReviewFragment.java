package com.box.android.capture.audiorecording.presentation.integrated;

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
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Player;
import androidx.media3.datasource.DefaultDataSource;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.source.ProgressiveMediaSource;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.media3.ui.TimeBar;
import com.box.android.capture.R;
import com.box.android.capture.audiorecording.cpl.AudioReviewReducer;
import com.box.android.capture.databinding.AudioReviewRecordingControlsBinding;
import com.box.android.capture.databinding.FragmentIntegratedAudioReviewRecordingBinding;
import com.box.android.cpl.Store;
import com.box.android.utilities.FlowExtensionsKt;
import dagger.hilt.android.AndroidEntryPoint;
import kotlin.Deprecated;
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
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: AudioRecordingIntegratedReviewFragment.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0015H\u0002J\b\u0010\u0019\u001a\u00020\u0015H\u0016J\b\u0010\u001a\u001a\u00020\u0015H\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u0015H\u0002R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/box/android/capture/audiorecording/presentation/integrated/AudioRecordingIntegratedReviewFragment;", "Lcom/box/android/base/presentation/fragments/BoxFragment;", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/capture/audiorecording/cpl/AudioReviewReducer$State;", "Lcom/box/android/capture/audiorecording/cpl/AudioReviewReducer$Action;", "<init>", "(Lcom/box/android/cpl/Store;)V", "binding", "Lcom/box/android/capture/databinding/FragmentIntegratedAudioReviewRecordingBinding;", "controlsBinding", "Lcom/box/android/capture/databinding/AudioReviewRecordingControlsBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setupUI", "supportEdgeToEdge", "onDestroyView", "onPause", "prepareMediaPlayer", "Landroidx/media3/exoplayer/ExoPlayer;", "recordedFileUri", "Landroid/net/Uri;", "showDiscardWarningDialog", "Companion", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class AudioRecordingIntegratedReviewFragment extends Hilt_AudioRecordingIntegratedReviewFragment {
    private static final int PROGRESS_UPDATE_INTERVAL_IN_MS = 100;
    private static final long SEEK_INCREMENT_IN_MS = 10000;
    private FragmentIntegratedAudioReviewRecordingBinding binding;
    private AudioReviewRecordingControlsBinding controlsBinding;
    private final Store<AudioReviewReducer.State, AudioReviewReducer.Action> store;
    public static final int $stable = 8;

    public AudioRecordingIntegratedReviewFragment(Store<AudioReviewReducer.State, AudioReviewReducer.Action> store) {
        Intrinsics.checkNotNullParameter(store, "store");
        this.store = store;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        OnBackPressedDispatcherKt.addCallback$default(requireActivity().getOnBackPressedDispatcher(), getViewLifecycleOwner(), false, new Function1() { // from class: com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingIntegratedReviewFragment$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AudioRecordingIntegratedReviewFragment.onCreateView$lambda$0(this.f$0, (OnBackPressedCallback) obj);
            }
        }, 2, null);
        FragmentIntegratedAudioReviewRecordingBinding fragmentIntegratedAudioReviewRecordingBindingInflate = FragmentIntegratedAudioReviewRecordingBinding.inflate(getLayoutInflater(), container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentIntegratedAudioReviewRecordingBindingInflate, "inflate(...)");
        this.binding = fragmentIntegratedAudioReviewRecordingBindingInflate;
        FragmentIntegratedAudioReviewRecordingBinding fragmentIntegratedAudioReviewRecordingBinding = null;
        if (fragmentIntegratedAudioReviewRecordingBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentIntegratedAudioReviewRecordingBindingInflate = null;
        }
        AudioReviewRecordingControlsBinding audioReviewRecordingControlsBindingBind = AudioReviewRecordingControlsBinding.bind(fragmentIntegratedAudioReviewRecordingBindingInflate.audioPlayer.findViewById(R.id.audio_player_controller_root));
        Intrinsics.checkNotNullExpressionValue(audioReviewRecordingControlsBindingBind, "bind(...)");
        this.controlsBinding = audioReviewRecordingControlsBindingBind;
        FragmentIntegratedAudioReviewRecordingBinding fragmentIntegratedAudioReviewRecordingBinding2 = this.binding;
        if (fragmentIntegratedAudioReviewRecordingBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentIntegratedAudioReviewRecordingBinding = fragmentIntegratedAudioReviewRecordingBinding2;
        }
        return fragmentIntegratedAudioReviewRecordingBinding.getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0(AudioRecordingIntegratedReviewFragment audioRecordingIntegratedReviewFragment, OnBackPressedCallback addCallback) {
        Intrinsics.checkNotNullParameter(addCallback, "$this$addCallback");
        audioRecordingIntegratedReviewFragment.store.send(AudioReviewReducer.Action.TryDiscardRecording.INSTANCE);
        return Unit.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setupUI();
    }

    private final void setupUI() {
        FragmentIntegratedAudioReviewRecordingBinding fragmentIntegratedAudioReviewRecordingBinding = this.binding;
        FragmentIntegratedAudioReviewRecordingBinding fragmentIntegratedAudioReviewRecordingBinding2 = null;
        if (fragmentIntegratedAudioReviewRecordingBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentIntegratedAudioReviewRecordingBinding = null;
        }
        fragmentIntegratedAudioReviewRecordingBinding.audioRecordingDiscard.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingIntegratedReviewFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudioRecordingIntegratedReviewFragment.setupUI$lambda$0(this.f$0, view);
            }
        });
        supportEdgeToEdge();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new AnonymousClass2(null), 3, null);
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner2), null, null, new AnonymousClass3(null), 3, null);
        AudioReviewRecordingControlsBinding audioReviewRecordingControlsBinding = this.controlsBinding;
        if (audioReviewRecordingControlsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("controlsBinding");
            audioReviewRecordingControlsBinding = null;
        }
        audioReviewRecordingControlsBinding.exoProgress.addListener(new TimeBar.OnScrubListener() { // from class: com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingIntegratedReviewFragment.setupUI.4
            @Override // androidx.media3.ui.TimeBar.OnScrubListener
            public void onScrubStart(TimeBar timeBar, long position) {
                Intrinsics.checkNotNullParameter(timeBar, "timeBar");
                FragmentIntegratedAudioReviewRecordingBinding fragmentIntegratedAudioReviewRecordingBinding3 = AudioRecordingIntegratedReviewFragment.this.binding;
                if (fragmentIntegratedAudioReviewRecordingBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentIntegratedAudioReviewRecordingBinding3 = null;
                }
                fragmentIntegratedAudioReviewRecordingBinding3.waveVisualizer.setScrubbing(true);
            }

            @Override // androidx.media3.ui.TimeBar.OnScrubListener
            public void onScrubMove(TimeBar timeBar, long position) {
                Intrinsics.checkNotNullParameter(timeBar, "timeBar");
                FragmentIntegratedAudioReviewRecordingBinding fragmentIntegratedAudioReviewRecordingBinding3 = AudioRecordingIntegratedReviewFragment.this.binding;
                if (fragmentIntegratedAudioReviewRecordingBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentIntegratedAudioReviewRecordingBinding3 = null;
                }
                fragmentIntegratedAudioReviewRecordingBinding3.waveVisualizer.forceUpdateTime(position);
            }

            @Override // androidx.media3.ui.TimeBar.OnScrubListener
            public void onScrubStop(TimeBar timeBar, long position, boolean canceled) {
                Intrinsics.checkNotNullParameter(timeBar, "timeBar");
                FragmentIntegratedAudioReviewRecordingBinding fragmentIntegratedAudioReviewRecordingBinding3 = AudioRecordingIntegratedReviewFragment.this.binding;
                if (fragmentIntegratedAudioReviewRecordingBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentIntegratedAudioReviewRecordingBinding3 = null;
                }
                fragmentIntegratedAudioReviewRecordingBinding3.waveVisualizer.setScrubbing(false);
            }
        });
        FragmentIntegratedAudioReviewRecordingBinding fragmentIntegratedAudioReviewRecordingBinding3 = this.binding;
        if (fragmentIntegratedAudioReviewRecordingBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentIntegratedAudioReviewRecordingBinding3 = null;
        }
        fragmentIntegratedAudioReviewRecordingBinding3.audioPlayer.setTimeBarMinUpdateInterval(100);
        FragmentIntegratedAudioReviewRecordingBinding fragmentIntegratedAudioReviewRecordingBinding4 = this.binding;
        if (fragmentIntegratedAudioReviewRecordingBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentIntegratedAudioReviewRecordingBinding2 = fragmentIntegratedAudioReviewRecordingBinding4;
        }
        fragmentIntegratedAudioReviewRecordingBinding2.audioRecordingSave.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingIntegratedReviewFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudioRecordingIntegratedReviewFragment.setupUI$lambda$1(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupUI$lambda$0(AudioRecordingIntegratedReviewFragment audioRecordingIntegratedReviewFragment, View view) {
        audioRecordingIntegratedReviewFragment.store.send(AudioReviewReducer.Action.TryDiscardRecording.INSTANCE);
    }

    /* JADX INFO: renamed from: com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingIntegratedReviewFragment$setupUI$2, reason: invalid class name */
    /* JADX INFO: compiled from: AudioRecordingIntegratedReviewFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingIntegratedReviewFragment$setupUI$2", f = "AudioRecordingIntegratedReviewFragment.kt", i = {}, l = {78}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AudioRecordingIntegratedReviewFragment.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingIntegratedReviewFragment$setupUI$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: AudioRecordingIntegratedReviewFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingIntegratedReviewFragment$setupUI$2$1", f = "AudioRecordingIntegratedReviewFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ AudioRecordingIntegratedReviewFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(AudioRecordingIntegratedReviewFragment audioRecordingIntegratedReviewFragment, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = audioRecordingIntegratedReviewFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX INFO: renamed from: com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingIntegratedReviewFragment$setupUI$2$1$2, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: AudioRecordingIntegratedReviewFragment.kt */
            @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Landroid/net/Uri;"}, k = 3, mv = {2, 2, 0}, xi = 48)
            @DebugMetadata(c = "com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingIntegratedReviewFragment$setupUI$2$1$2", f = "AudioRecordingIntegratedReviewFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            static final class C01372 extends SuspendLambda implements Function2<Uri, Continuation<? super Unit>, Object> {
                /* synthetic */ Object L$0;
                int label;
                final /* synthetic */ AudioRecordingIntegratedReviewFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C01372(AudioRecordingIntegratedReviewFragment audioRecordingIntegratedReviewFragment, Continuation<? super C01372> continuation) {
                    super(2, continuation);
                    this.this$0 = audioRecordingIntegratedReviewFragment;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C01372 c01372 = new C01372(this.this$0, continuation);
                    c01372.L$0 = obj;
                    return c01372;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Uri uri, Continuation<? super Unit> continuation) {
                    return ((C01372) create(uri, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Uri uri = (Uri) this.L$0;
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                    booleanRef.element = true;
                    final ExoPlayer exoPlayerPrepareMediaPlayer = this.this$0.prepareMediaPlayer(uri);
                    final AudioRecordingIntegratedReviewFragment audioRecordingIntegratedReviewFragment = this.this$0;
                    exoPlayerPrepareMediaPlayer.addListener(new Player.Listener() { // from class: com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingIntegratedReviewFragment.setupUI.2.1.2.1
                        @Override // androidx.media3.common.Player.Listener
                        @Deprecated(message = "Deprecated in Java")
                        public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
                            if (booleanRef.element && playbackState == 3) {
                                audioRecordingIntegratedReviewFragment.store.send(new AudioReviewReducer.Action.PlayerInitialized(exoPlayerPrepareMediaPlayer));
                                booleanRef.element = false;
                            }
                            if (!playWhenReady || playbackState != 3) {
                                audioRecordingIntegratedReviewFragment.store.send(AudioReviewReducer.Action.PlaybackStopped.INSTANCE);
                            } else {
                                audioRecordingIntegratedReviewFragment.store.send(AudioReviewReducer.Action.PlaybackStarted.INSTANCE);
                            }
                        }
                    });
                    FragmentIntegratedAudioReviewRecordingBinding fragmentIntegratedAudioReviewRecordingBinding = this.this$0.binding;
                    if (fragmentIntegratedAudioReviewRecordingBinding == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        fragmentIntegratedAudioReviewRecordingBinding = null;
                    }
                    fragmentIntegratedAudioReviewRecordingBinding.audioPlayer.setPlayer(exoPlayerPrepareMediaPlayer);
                    return Unit.INSTANCE;
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
                FlowKt.launchIn(FlowKt.onEach(FlowExtensionsKt.observe(this.this$0.store.getState(), new PropertyReference1Impl() { // from class: com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingIntegratedReviewFragment.setupUI.2.1.1
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj2) {
                        return ((AudioReviewReducer.State) obj2).getRecordedFileUri();
                    }
                }), new C01372(this.this$0, null)), coroutineScope);
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LifecycleOwner viewLifecycleOwner = AudioRecordingIntegratedReviewFragment.this.getViewLifecycleOwner();
                Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(viewLifecycleOwner, Lifecycle.State.CREATED, new AnonymousClass1(AudioRecordingIntegratedReviewFragment.this, null), this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingIntegratedReviewFragment$setupUI$3, reason: invalid class name */
    /* JADX INFO: compiled from: AudioRecordingIntegratedReviewFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingIntegratedReviewFragment$setupUI$3", f = "AudioRecordingIntegratedReviewFragment.kt", i = {}, l = {106}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AudioRecordingIntegratedReviewFragment.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingIntegratedReviewFragment$setupUI$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: AudioRecordingIntegratedReviewFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingIntegratedReviewFragment$setupUI$3$1", f = "AudioRecordingIntegratedReviewFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ AudioRecordingIntegratedReviewFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(AudioRecordingIntegratedReviewFragment audioRecordingIntegratedReviewFragment, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = audioRecordingIntegratedReviewFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX INFO: renamed from: com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingIntegratedReviewFragment$setupUI$3$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: AudioRecordingIntegratedReviewFragment.kt */
            @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Lcom/box/android/capture/audiorecording/cpl/AudioReviewReducer$State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
            @DebugMetadata(c = "com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingIntegratedReviewFragment$setupUI$3$1$1", f = "AudioRecordingIntegratedReviewFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            static final class C01391 extends SuspendLambda implements Function2<AudioReviewReducer.State, Continuation<? super Unit>, Object> {
                /* synthetic */ Object L$0;
                int label;
                final /* synthetic */ AudioRecordingIntegratedReviewFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C01391(AudioRecordingIntegratedReviewFragment audioRecordingIntegratedReviewFragment, Continuation<? super C01391> continuation) {
                    super(2, continuation);
                    this.this$0 = audioRecordingIntegratedReviewFragment;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C01391 c01391 = new C01391(this.this$0, continuation);
                    c01391.L$0 = obj;
                    return c01391;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(AudioReviewReducer.State state, Continuation<? super Unit> continuation) {
                    return ((C01391) create(state, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    AudioReviewReducer.State state = (AudioReviewReducer.State) this.L$0;
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    FragmentIntegratedAudioReviewRecordingBinding fragmentIntegratedAudioReviewRecordingBinding = null;
                    if (state.isInitialized()) {
                        FragmentIntegratedAudioReviewRecordingBinding fragmentIntegratedAudioReviewRecordingBinding2 = this.this$0.binding;
                        if (fragmentIntegratedAudioReviewRecordingBinding2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            fragmentIntegratedAudioReviewRecordingBinding2 = null;
                        }
                        fragmentIntegratedAudioReviewRecordingBinding2.waveVisualizer.initializeWaveForm(state.getRecordedSamples(), state.getPlaybackDuration());
                    }
                    FragmentIntegratedAudioReviewRecordingBinding fragmentIntegratedAudioReviewRecordingBinding3 = this.this$0.binding;
                    if (fragmentIntegratedAudioReviewRecordingBinding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        fragmentIntegratedAudioReviewRecordingBinding3 = null;
                    }
                    fragmentIntegratedAudioReviewRecordingBinding3.waveVisualizer.updateTime(state.getPlaybackPosition());
                    AudioReviewRecordingControlsBinding audioReviewRecordingControlsBinding = this.this$0.controlsBinding;
                    if (audioReviewRecordingControlsBinding == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("controlsBinding");
                        audioReviewRecordingControlsBinding = null;
                    }
                    audioReviewRecordingControlsBinding.playerPosition.setText(state.getElapsedTime());
                    AudioReviewRecordingControlsBinding audioReviewRecordingControlsBinding2 = this.this$0.controlsBinding;
                    if (audioReviewRecordingControlsBinding2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("controlsBinding");
                        audioReviewRecordingControlsBinding2 = null;
                    }
                    audioReviewRecordingControlsBinding2.playerDuration.setText(state.getRemainingTime());
                    FragmentIntegratedAudioReviewRecordingBinding fragmentIntegratedAudioReviewRecordingBinding4 = this.this$0.binding;
                    if (fragmentIntegratedAudioReviewRecordingBinding4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        fragmentIntegratedAudioReviewRecordingBinding = fragmentIntegratedAudioReviewRecordingBinding4;
                    }
                    fragmentIntegratedAudioReviewRecordingBinding.elapsedTime.setText(state.getElapsedTime());
                    return Unit.INSTANCE;
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
                FlowKt.launchIn(FlowKt.onEach(this.this$0.store.getState(), new C01391(this.this$0, null)), coroutineScope);
                FlowKt.launchIn(FlowKt.onEach(FlowExtensionsKt.observe(this.this$0.store.getState(), new PropertyReference1Impl() { // from class: com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingIntegratedReviewFragment.setupUI.3.1.2
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj2) {
                        return Boolean.valueOf(((AudioReviewReducer.State) obj2).isDiscarding());
                    }
                }), new C01403(this.this$0, null)), coroutineScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingIntegratedReviewFragment$setupUI$3$1$3, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: AudioRecordingIntegratedReviewFragment.kt */
            @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
            @DebugMetadata(c = "com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingIntegratedReviewFragment$setupUI$3$1$3", f = "AudioRecordingIntegratedReviewFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            static final class C01403 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
                /* synthetic */ boolean Z$0;
                int label;
                final /* synthetic */ AudioRecordingIntegratedReviewFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C01403(AudioRecordingIntegratedReviewFragment audioRecordingIntegratedReviewFragment, Continuation<? super C01403> continuation) {
                    super(2, continuation);
                    this.this$0 = audioRecordingIntegratedReviewFragment;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C01403 c01403 = new C01403(this.this$0, continuation);
                    c01403.Z$0 = ((Boolean) obj).booleanValue();
                    return c01403;
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
                    return invoke(bool.booleanValue(), continuation);
                }

                public final Object invoke(boolean z, Continuation<? super Unit> continuation) {
                    return ((C01403) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    boolean z = this.Z$0;
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    if (z) {
                        this.this$0.showDiscardWarningDialog();
                    }
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
                LifecycleOwner viewLifecycleOwner = AudioRecordingIntegratedReviewFragment.this.getViewLifecycleOwner();
                Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(viewLifecycleOwner, Lifecycle.State.STARTED, new AnonymousClass1(AudioRecordingIntegratedReviewFragment.this, null), this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupUI$lambda$1(AudioRecordingIntegratedReviewFragment audioRecordingIntegratedReviewFragment, View view) {
        audioRecordingIntegratedReviewFragment.store.send(AudioReviewReducer.Action.PrepareAudioRecording.INSTANCE);
    }

    private final void supportEdgeToEdge() {
        FragmentIntegratedAudioReviewRecordingBinding fragmentIntegratedAudioReviewRecordingBinding = this.binding;
        if (fragmentIntegratedAudioReviewRecordingBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentIntegratedAudioReviewRecordingBinding = null;
        }
        ViewCompat.setOnApplyWindowInsetsListener(fragmentIntegratedAudioReviewRecordingBinding.getRoot(), new OnApplyWindowInsetsListener() { // from class: com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingIntegratedReviewFragment$$ExternalSyntheticLambda5
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return AudioRecordingIntegratedReviewFragment.supportEdgeToEdge$lambda$0(this.f$0, view, windowInsetsCompat);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat supportEdgeToEdge$lambda$0(AudioRecordingIntegratedReviewFragment audioRecordingIntegratedReviewFragment, View view, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        Intrinsics.checkNotNullParameter(insets, "insets");
        int i = insets.getInsets(WindowInsetsCompat.Type.systemBars()).bottom;
        FragmentIntegratedAudioReviewRecordingBinding fragmentIntegratedAudioReviewRecordingBinding = audioRecordingIntegratedReviewFragment.binding;
        if (fragmentIntegratedAudioReviewRecordingBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentIntegratedAudioReviewRecordingBinding = null;
        }
        ConstraintLayout bottomBar = fragmentIntegratedAudioReviewRecordingBinding.bottomBar;
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
        ExoPlayer player = this.store.getState().getValue().getPlayer();
        if (player != null) {
            player.release();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ExoPlayer player = this.store.getState().getValue().getPlayer();
        if (player != null) {
            player.setPlayWhenReady(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ExoPlayer prepareMediaPlayer(Uri recordedFileUri) {
        ExoPlayer exoPlayerBuild = new ExoPlayer.Builder(requireContext()).setSeekBackIncrementMs(10000L).setSeekForwardIncrementMs(10000L).setAudioAttributes(new AudioAttributes.Builder().setContentType(2).setUsage(1).build(), true).build();
        Intrinsics.checkNotNullExpressionValue(exoPlayerBuild, "build(...)");
        ProgressiveMediaSource progressiveMediaSourceCreateMediaSource = new ProgressiveMediaSource.Factory(new DefaultDataSource.Factory(requireContext())).createMediaSource(MediaItem.fromUri(recordedFileUri));
        Intrinsics.checkNotNullExpressionValue(progressiveMediaSourceCreateMediaSource, "createMediaSource(...)");
        exoPlayerBuild.setMediaSource(progressiveMediaSourceCreateMediaSource);
        exoPlayerBuild.prepare();
        return exoPlayerBuild;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showDiscardWarningDialog() {
        new AlertDialog.Builder(requireContext(), R.style.Theme_Box_Dialog_Alert).setTitle(R.string.audio_recording_discard_title).setMessage(R.string.audio_recording_discard_message).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingIntegratedReviewFragment$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                AudioRecordingIntegratedReviewFragment.showDiscardWarningDialog$lambda$0(this.f$0, dialogInterface);
            }
        }).setNegativeButton(R.string.audio_recording_cancel, new DialogInterface.OnClickListener() { // from class: com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingIntegratedReviewFragment$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).setPositiveButton(R.string.LS_Delete, new DialogInterface.OnClickListener() { // from class: com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingIntegratedReviewFragment$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                AudioRecordingIntegratedReviewFragment.showDiscardWarningDialog$lambda$2(this.f$0, dialogInterface, i);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDiscardWarningDialog$lambda$0(AudioRecordingIntegratedReviewFragment audioRecordingIntegratedReviewFragment, DialogInterface dialogInterface) {
        audioRecordingIntegratedReviewFragment.store.send(AudioReviewReducer.Action.KeepRecording.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDiscardWarningDialog$lambda$2(AudioRecordingIntegratedReviewFragment audioRecordingIntegratedReviewFragment, DialogInterface dialogInterface, int i) {
        audioRecordingIntegratedReviewFragment.store.send(AudioReviewReducer.Action.DiscardRecording.INSTANCE);
        dialogInterface.dismiss();
    }
}
