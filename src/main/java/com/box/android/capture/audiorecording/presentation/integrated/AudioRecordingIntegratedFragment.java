package com.box.android.capture.audiorecording.presentation.integrated;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.view.KeyEventDispatcher;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.box.android.capture.ICaptureActivity;
import com.box.android.capture.R;
import com.box.android.capture.audiorecording.RecordingFileState;
import com.box.android.capture.audiorecording.cpl.AudioRecordingReducer;
import com.box.android.capture.audiorecording.logic.IAudioRecordingHelper;
import com.box.android.capture.databinding.FragmentIntegratedAudioRecordingBinding;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.cpl.Store;
import com.box.android.domain.models.DomainError;
import com.box.android.utilities.FlowExtensionsKt;
import com.box.androidsdk.content.utils.BoxLogUtils;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: AudioRecordingIntegratedFragment.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 .2\u00020\u0001:\u0001.B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001f\u001a\u00020\u001dH\u0002J\b\u0010 \u001a\u00020\u001dH\u0002J\b\u0010!\u001a\u00020\u001dH\u0002J\u0010\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020\u001dH\u0002J\b\u0010&\u001a\u00020\u001dH\u0002J\b\u0010'\u001a\u00020\u001dH\u0002J\u0016\u0010(\u001a\u00020\u001d2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001d0*H\u0002J\u0010\u0010+\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020-H\u0002R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006/"}, d2 = {"Lcom/box/android/capture/audiorecording/presentation/integrated/AudioRecordingIntegratedFragment;", "Lcom/box/android/base/presentation/fragments/BoxFragment;", "audioRecordingStore", "Lcom/box/android/cpl/Store;", "Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$State;", "Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action;", "<init>", "(Lcom/box/android/cpl/Store;)V", "audioRecordingHelper", "Lcom/box/android/capture/audiorecording/logic/IAudioRecordingHelper;", "getAudioRecordingHelper", "()Lcom/box/android/capture/audiorecording/logic/IAudioRecordingHelper;", "setAudioRecordingHelper", "(Lcom/box/android/capture/audiorecording/logic/IAudioRecordingHelper;)V", "binding", "Lcom/box/android/capture/databinding/FragmentIntegratedAudioRecordingBinding;", "getBinding", "()Lcom/box/android/capture/databinding/FragmentIntegratedAudioRecordingBinding;", "setBinding", "(Lcom/box/android/capture/databinding/FragmentIntegratedAudioRecordingBinding;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setupUI", "supportEdgeToEdge", "showCaptureHistory", "updateViews", "recordingFileState", "Lcom/box/android/capture/audiorecording/RecordingFileState;", "startRecording", "resumeRecording", "pauseRecording", "showDiscardWarningDialog", "positiveAction", "Lkotlin/Function0;", "showErrorDialog", "message", "", "Companion", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class AudioRecordingIntegratedFragment extends Hilt_AudioRecordingIntegratedFragment {
    private static final String LOG_TAG = "AudioRecordingIntegratedFragment";

    @Inject
    public IAudioRecordingHelper audioRecordingHelper;
    private final Store<AudioRecordingReducer.State, AudioRecordingReducer.Action> audioRecordingStore;
    public FragmentIntegratedAudioRecordingBinding binding;
    public static final int $stable = 8;

    /* JADX INFO: compiled from: AudioRecordingIntegratedFragment.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RecordingFileState.values().length];
            try {
                iArr[RecordingFileState.RECORDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RecordingFileState.PAUSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RecordingFileState.NOT_RECORDING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AudioRecordingIntegratedFragment(Store<AudioRecordingReducer.State, AudioRecordingReducer.Action> audioRecordingStore) {
        Intrinsics.checkNotNullParameter(audioRecordingStore, "audioRecordingStore");
        this.audioRecordingStore = audioRecordingStore;
    }

    public final IAudioRecordingHelper getAudioRecordingHelper() {
        IAudioRecordingHelper iAudioRecordingHelper = this.audioRecordingHelper;
        if (iAudioRecordingHelper != null) {
            return iAudioRecordingHelper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("audioRecordingHelper");
        return null;
    }

    public final void setAudioRecordingHelper(IAudioRecordingHelper iAudioRecordingHelper) {
        Intrinsics.checkNotNullParameter(iAudioRecordingHelper, "<set-?>");
        this.audioRecordingHelper = iAudioRecordingHelper;
    }

    public final FragmentIntegratedAudioRecordingBinding getBinding() {
        FragmentIntegratedAudioRecordingBinding fragmentIntegratedAudioRecordingBinding = this.binding;
        if (fragmentIntegratedAudioRecordingBinding != null) {
            return fragmentIntegratedAudioRecordingBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(FragmentIntegratedAudioRecordingBinding fragmentIntegratedAudioRecordingBinding) {
        Intrinsics.checkNotNullParameter(fragmentIntegratedAudioRecordingBinding, "<set-?>");
        this.binding = fragmentIntegratedAudioRecordingBinding;
    }

    /* JADX INFO: renamed from: com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingIntegratedFragment$onCreateView$1, reason: invalid class name */
    /* JADX INFO: compiled from: AudioRecordingIntegratedFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingIntegratedFragment$onCreateView$1", f = "AudioRecordingIntegratedFragment.kt", i = {}, l = {50}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AudioRecordingIntegratedFragment.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingIntegratedFragment$onCreateView$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: AudioRecordingIntegratedFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingIntegratedFragment$onCreateView$1$1", f = "AudioRecordingIntegratedFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class C01341 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ AudioRecordingIntegratedFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01341(AudioRecordingIntegratedFragment audioRecordingIntegratedFragment, Continuation<? super C01341> continuation) {
                super(2, continuation);
                this.this$0 = audioRecordingIntegratedFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C01341 c01341 = new C01341(this.this$0, continuation);
                c01341.L$0 = obj;
                return c01341;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01341) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX INFO: renamed from: com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingIntegratedFragment$onCreateView$1$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: AudioRecordingIntegratedFragment.kt */
            @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/box/android/domain/models/DomainError;"}, k = 3, mv = {2, 2, 0}, xi = 48)
            @DebugMetadata(c = "com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingIntegratedFragment$onCreateView$1$1$2", f = "AudioRecordingIntegratedFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            static final class AnonymousClass2 extends SuspendLambda implements Function2<DomainError, Continuation<? super Unit>, Object> {
                /* synthetic */ Object L$0;
                int label;
                final /* synthetic */ AudioRecordingIntegratedFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass2(AudioRecordingIntegratedFragment audioRecordingIntegratedFragment, Continuation<? super AnonymousClass2> continuation) {
                    super(2, continuation);
                    this.this$0 = audioRecordingIntegratedFragment;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, continuation);
                    anonymousClass2.L$0 = obj;
                    return anonymousClass2;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(DomainError domainError, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass2) create(domainError, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    DomainError domainError = (DomainError) this.L$0;
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    if (domainError != null) {
                        AudioRecordingIntegratedFragment audioRecordingIntegratedFragment = this.this$0;
                        audioRecordingIntegratedFragment.showErrorDialog(audioRecordingIntegratedFragment.getAudioRecordingHelper().getMessageForError(domainError));
                    }
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
                FlowKt.launchIn(FlowKt.onEach(FlowExtensionsKt.observe(this.this$0.audioRecordingStore.getState(), new PropertyReference1Impl() { // from class: com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingIntegratedFragment.onCreateView.1.1.1
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj2) {
                        return ((AudioRecordingReducer.State) obj2).getError();
                    }
                }), new AnonymousClass2(this.this$0, null)), coroutineScope);
                FlowKt.launchIn(FlowKt.onEach(FlowExtensionsKt.observe(this.this$0.audioRecordingStore.getState(), new PropertyReference1Impl() { // from class: com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingIntegratedFragment.onCreateView.1.1.3
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj2) {
                        return Boolean.valueOf(((AudioRecordingReducer.State) obj2).isDeleting());
                    }
                }), new AnonymousClass4(this.this$0, null)), coroutineScope);
                FlowKt.launchIn(FlowKt.onEach(this.this$0.audioRecordingStore.getState(), new AnonymousClass5(this.this$0, null)), coroutineScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingIntegratedFragment$onCreateView$1$1$4, reason: invalid class name */
            /* JADX INFO: compiled from: AudioRecordingIntegratedFragment.kt */
            @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
            @DebugMetadata(c = "com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingIntegratedFragment$onCreateView$1$1$4", f = "AudioRecordingIntegratedFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            static final class AnonymousClass4 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
                /* synthetic */ boolean Z$0;
                int label;
                final /* synthetic */ AudioRecordingIntegratedFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass4(AudioRecordingIntegratedFragment audioRecordingIntegratedFragment, Continuation<? super AnonymousClass4> continuation) {
                    super(2, continuation);
                    this.this$0 = audioRecordingIntegratedFragment;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass4 anonymousClass4 = new AnonymousClass4(this.this$0, continuation);
                    anonymousClass4.Z$0 = ((Boolean) obj).booleanValue();
                    return anonymousClass4;
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
                    return invoke(bool.booleanValue(), continuation);
                }

                public final Object invoke(boolean z, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass4) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
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
                        final AudioRecordingIntegratedFragment audioRecordingIntegratedFragment = this.this$0;
                        audioRecordingIntegratedFragment.showDiscardWarningDialog(new Function0() { // from class: com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingIntegratedFragment$onCreateView$1$1$4$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return AudioRecordingIntegratedFragment.AnonymousClass1.C01341.AnonymousClass4.invokeSuspend$lambda$0(audioRecordingIntegratedFragment);
                            }
                        });
                    }
                    return Unit.INSTANCE;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final Unit invokeSuspend$lambda$0(AudioRecordingIntegratedFragment audioRecordingIntegratedFragment) {
                    audioRecordingIntegratedFragment.audioRecordingStore.send(AudioRecordingReducer.Action.DiscardRecording.INSTANCE);
                    return Unit.INSTANCE;
                }
            }

            /* JADX INFO: renamed from: com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingIntegratedFragment$onCreateView$1$1$5, reason: invalid class name */
            /* JADX INFO: compiled from: AudioRecordingIntegratedFragment.kt */
            @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
            @DebugMetadata(c = "com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingIntegratedFragment$onCreateView$1$1$5", f = "AudioRecordingIntegratedFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            static final class AnonymousClass5 extends SuspendLambda implements Function2<AudioRecordingReducer.State, Continuation<? super Unit>, Object> {
                /* synthetic */ Object L$0;
                int label;
                final /* synthetic */ AudioRecordingIntegratedFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass5(AudioRecordingIntegratedFragment audioRecordingIntegratedFragment, Continuation<? super AnonymousClass5> continuation) {
                    super(2, continuation);
                    this.this$0 = audioRecordingIntegratedFragment;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass5 anonymousClass5 = new AnonymousClass5(this.this$0, continuation);
                    anonymousClass5.L$0 = obj;
                    return anonymousClass5;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(AudioRecordingReducer.State state, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass5) create(state, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    AudioRecordingReducer.State state = (AudioRecordingReducer.State) this.L$0;
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.this$0.updateViews(state.toRecordingState());
                        this.this$0.getBinding().waveVisualizer.updateAmps(state.getRecordedSamples());
                        if (state.getHasPendingRecording()) {
                            this.this$0.getBinding().captureHistoryButton.setVisibility(8);
                        } else {
                            this.this$0.getBinding().captureHistoryButton.setVisibility(0);
                        }
                        this.this$0.getBinding().elapsedTime.setText(state.getElapsedTime());
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
                LifecycleOwner viewLifecycleOwner = AudioRecordingIntegratedFragment.this.getViewLifecycleOwner();
                Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(viewLifecycleOwner, Lifecycle.State.STARTED, new C01341(AudioRecordingIntegratedFragment.this, null), this) == coroutine_suspended) {
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
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new AnonymousClass1(null), 3, null);
        OnBackPressedDispatcherKt.addCallback$default(requireActivity().getOnBackPressedDispatcher(), getViewLifecycleOwner(), false, new Function1() { // from class: com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingIntegratedFragment$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AudioRecordingIntegratedFragment.onCreateView$lambda$0(this.f$0, (OnBackPressedCallback) obj);
            }
        }, 2, null);
        FragmentIntegratedAudioRecordingBinding fragmentIntegratedAudioRecordingBindingInflate = FragmentIntegratedAudioRecordingBinding.inflate(getLayoutInflater(), container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentIntegratedAudioRecordingBindingInflate, "inflate(...)");
        setBinding(fragmentIntegratedAudioRecordingBindingInflate);
        return getBinding().getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0(AudioRecordingIntegratedFragment audioRecordingIntegratedFragment, OnBackPressedCallback addCallback) {
        Intrinsics.checkNotNullParameter(addCallback, "$this$addCallback");
        audioRecordingIntegratedFragment.audioRecordingStore.send(AudioRecordingReducer.Action.CloseRecording.INSTANCE);
        return Unit.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setupUI();
    }

    private final void setupUI() {
        supportEdgeToEdge();
        getBinding().audioRecordingDone.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingIntegratedFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudioRecordingIntegratedFragment.setupUI$lambda$0(this.f$0, view);
            }
        });
        getBinding().captureHistoryButton.initView(this);
        getBinding().audioRecordingTrash.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingIntegratedFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudioRecordingIntegratedFragment.setupUI$lambda$1(this.f$0, view);
            }
        });
        getBinding().captureHistoryButton.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingIntegratedFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.showCaptureHistory();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupUI$lambda$0(AudioRecordingIntegratedFragment audioRecordingIntegratedFragment, View view) {
        audioRecordingIntegratedFragment.audioRecordingStore.send(AudioRecordingReducer.Action.StopRecording.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupUI$lambda$1(AudioRecordingIntegratedFragment audioRecordingIntegratedFragment, View view) {
        audioRecordingIntegratedFragment.audioRecordingStore.send(AudioRecordingReducer.Action.CancelRecording.INSTANCE);
    }

    private final void supportEdgeToEdge() {
        final Guideline guidelineBottomInset = getBinding().guidelineBottomInset;
        Intrinsics.checkNotNullExpressionValue(guidelineBottomInset, "guidelineBottomInset");
        ConstraintLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        ViewCompat.setOnApplyWindowInsetsListener(root, new OnApplyWindowInsetsListener() { // from class: com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingIntegratedFragment$$ExternalSyntheticLambda6
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return AudioRecordingIntegratedFragment.supportEdgeToEdge$lambda$0(guidelineBottomInset, view, windowInsetsCompat);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat supportEdgeToEdge$lambda$0(Guideline guideline, View view, WindowInsetsCompat insets) {
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
    public final void updateViews(RecordingFileState recordingFileState) {
        int i = WhenMappings.$EnumSwitchMapping$0[recordingFileState.ordinal()];
        if (i == 1) {
            getBinding().recordingButton.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingIntegratedFragment$$ExternalSyntheticLambda11
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.pauseRecording();
                }
            });
            getBinding().recordingButton.setImageResource(R.drawable.pause_recording_button);
            TextView textView = getBinding().recordingMessage;
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            textView.setTextColor(CommonBoxUtil.getColorFromAttribute(contextRequireContext, R.attr.contentPrimary));
            getBinding().recordingMessage.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.recording_indicator, 0, 0, 0);
            getBinding().elapsedTime.setVisibility(0);
            getBinding().waveVisualizer.setVisibility(0);
            getBinding().audioRecordingExtendedControls.setVisibility(8);
            getBinding().noRecordingLayout.setVisibility(8);
        } else if (i == 2) {
            getBinding().recordingButton.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingIntegratedFragment$$ExternalSyntheticLambda12
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.resumeRecording();
                }
            });
            getBinding().recordingButton.setImageResource(R.drawable.recording_button);
            TextView textView2 = getBinding().recordingMessage;
            Context contextRequireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
            textView2.setTextColor(CommonBoxUtil.getColorFromAttribute(contextRequireContext2, R.attr.contentSecondary));
            getBinding().recordingMessage.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0);
            getBinding().elapsedTime.setVisibility(0);
            getBinding().waveVisualizer.setVisibility(0);
            getBinding().audioRecordingExtendedControls.setVisibility(0);
            getBinding().noRecordingLayout.setVisibility(8);
        } else if (i == 3) {
            getBinding().recordingButton.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingIntegratedFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.startRecording();
                }
            });
            getBinding().recordingButton.setImageResource(R.drawable.recording_button);
            TextView textView3 = getBinding().recordingMessage;
            Context contextRequireContext3 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
            textView3.setTextColor(CommonBoxUtil.getColorFromAttribute(contextRequireContext3, R.attr.contentSecondary));
            getBinding().recordingMessage.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0);
            getBinding().elapsedTime.setVisibility(8);
            getBinding().waveVisualizer.setVisibility(8);
            getBinding().noRecordingLayout.setVisibility(0);
            getBinding().audioRecordingExtendedControls.setVisibility(8);
        } else {
            BoxLogUtils.e(LOG_TAG, "Unexpected else branch");
        }
        Integer messageId = recordingFileState.getMessageId();
        if (messageId != null) {
            getBinding().recordingMessage.setText(getString(messageId.intValue()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startRecording() {
        this.audioRecordingStore.send(AudioRecordingReducer.Action.StartRecording.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resumeRecording() {
        this.audioRecordingStore.send(AudioRecordingReducer.Action.ResumeRecording.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pauseRecording() {
        this.audioRecordingStore.send(AudioRecordingReducer.Action.PauseRecording.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showDiscardWarningDialog(final Function0<Unit> positiveAction) {
        new AlertDialog.Builder(requireContext(), R.style.Theme_Box_Dialog_Alert).setTitle(R.string.audio_recording_discard_title).setMessage(R.string.audio_recording_discard_message).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingIntegratedFragment$$ExternalSyntheticLambda8
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                AudioRecordingIntegratedFragment.showDiscardWarningDialog$lambda$0(this.f$0, dialogInterface);
            }
        }).setNegativeButton(R.string.audio_recording_cancel, new DialogInterface.OnClickListener() { // from class: com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingIntegratedFragment$$ExternalSyntheticLambda9
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).setPositiveButton(R.string.LS_Delete, new DialogInterface.OnClickListener() { // from class: com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingIntegratedFragment$$ExternalSyntheticLambda10
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                positiveAction.invoke();
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDiscardWarningDialog$lambda$0(AudioRecordingIntegratedFragment audioRecordingIntegratedFragment, DialogInterface dialogInterface) {
        audioRecordingIntegratedFragment.audioRecordingStore.send(AudioRecordingReducer.Action.KeepRecording.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showErrorDialog(String message) {
        new AlertDialog.Builder(requireContext(), R.style.Theme_Box_Dialog_Alert).setMessage(message).setNeutralButton(R.string.button_ok, new DialogInterface.OnClickListener() { // from class: com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingIntegratedFragment$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingIntegratedFragment$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                AudioRecordingIntegratedFragment.showErrorDialog$lambda$1(this.f$0, dialogInterface);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showErrorDialog$lambda$1(AudioRecordingIntegratedFragment audioRecordingIntegratedFragment, DialogInterface dialogInterface) {
        audioRecordingIntegratedFragment.audioRecordingStore.send(AudioRecordingReducer.Action.DismissError.INSTANCE);
    }
}
