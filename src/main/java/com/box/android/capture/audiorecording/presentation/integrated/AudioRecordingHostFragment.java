package com.box.android.capture.audiorecording.presentation.integrated;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.box.android.capture.R;
import com.box.android.capture.audiorecording.cpl.AudioCaptureReducer;
import com.box.android.capture.audiorecording.cpl.AudioRecordingReducer;
import com.box.android.capture.audiorecording.cpl.AudioReviewReducer;
import com.box.android.cpl.Store;
import com.box.android.cpl.StoreKt;
import com.box.android.utilities.CoroutineExtensionsKt;
import com.pspdfkit.BuildConfig;
import dagger.hilt.android.AndroidEntryPoint;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.KClassesJvm;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: AudioRecordingHostFragment.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/box/android/capture/audiorecording/presentation/integrated/AudioRecordingHostFragment;", "Lcom/box/android/base/presentation/fragments/BoxFragment;", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/capture/audiorecording/cpl/AudioCaptureReducer$State;", "Lcom/box/android/capture/audiorecording/cpl/AudioCaptureReducer$Action;", "<init>", "(Lcom/box/android/cpl/Store;)V", "getStore", "()Lcom/box/android/cpl/Store;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "replaceFragment", BuildConfig.FLAVOR, "Landroidx/fragment/app/Fragment;", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class AudioRecordingHostFragment extends Hilt_AudioRecordingHostFragment {
    public static final int $stable = 8;
    private final Store<AudioCaptureReducer.State, AudioCaptureReducer.Action> store;

    public AudioRecordingHostFragment(Store<AudioCaptureReducer.State, AudioCaptureReducer.Action> store) {
        Intrinsics.checkNotNullParameter(store, "store");
        this.store = store;
    }

    public final Store<AudioCaptureReducer.State, AudioCaptureReducer.Action> getStore() {
        return this.store;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.layout_container, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Store<AudioCaptureReducer.State, AudioCaptureReducer.Action> store = this.store;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(AudioCaptureReducer.State.Recording.class);
        AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
        AudioRecordingHostFragment audioRecordingHostFragment = this;
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(audioRecordingHostFragment);
        final Flow flowDistinctUntilChanged = FlowKt.distinctUntilChanged(store.getState(), new Function2<AudioCaptureReducer.State, AudioCaptureReducer.State, Boolean>() { // from class: com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingHostFragment$onViewCreated$$inlined$switchEmbeddedScope$1
            @Override // kotlin.jvm.functions.Function2
            public final Boolean invoke(AudioCaptureReducer.State old, AudioCaptureReducer.State state) {
                Intrinsics.checkNotNullParameter(old, "old");
                Intrinsics.checkNotNullParameter(state, "new");
                return Boolean.valueOf((old instanceof AudioCaptureReducer.State.Recording) && (state instanceof AudioCaptureReducer.State.Recording));
            }
        });
        FlowKt.launchIn(FlowKt.onEach(new Flow<AudioCaptureReducer.State.Recording>() { // from class: com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingHostFragment$onViewCreated$$inlined$switchEmbeddedScope$2

            /* JADX INFO: renamed from: com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingHostFragment$onViewCreated$$inlined$switchEmbeddedScope$2$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2", "com/box/android/cpl/StoreKt$switchEmbeddedScope$$inlined$mapNotNull$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingHostFragment$onViewCreated$$inlined$switchEmbeddedScope$2$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingHostFragment$onViewCreated$$inlined$switchEmbeddedScope$2$2", f = "AudioRecordingHostFragment.kt", i = {0, 0, 0, 0, 0, 0}, l = {221}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
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
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        AudioCaptureReducer.State.Recording recording = (AudioCaptureReducer.State.Recording) (!(obj instanceof AudioCaptureReducer.State.Recording) ? null : obj);
                        if (recording != null) {
                            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                            anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(recording);
                            anonymousClass1.I$0 = 0;
                            anonymousClass1.label = 1;
                            if (flowCollector.emit(recording, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i2 = anonymousClass1.I$0;
                        Object obj3 = anonymousClass1.L$2;
                        Object obj4 = anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super AudioCaptureReducer.State.Recording> flowCollector, Continuation continuation) {
                Object objCollect = flowDistinctUntilChanged.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, new AudioRecordingHostFragment$onViewCreated$$inlined$switchEmbeddedScope$3(store, orCreateKotlinClass, anonymousClass1, null, this)), StoreKt.registerCoroutineScope(store, CoroutineExtensionsKt.getChildScope(lifecycleScope), KClassesJvm.getJvmName(orCreateKotlinClass)));
        Store<AudioCaptureReducer.State, AudioCaptureReducer.Action> store2 = this.store;
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(AudioCaptureReducer.State.PermissionRequired.class);
        LifecycleCoroutineScope lifecycleScope2 = LifecycleOwnerKt.getLifecycleScope(audioRecordingHostFragment);
        AudioRecordingHostFragment$onViewCreated$$inlined$switchScope$1 audioRecordingHostFragment$onViewCreated$$inlined$switchScope$1 = new Function1<AudioCaptureReducer.Action, AudioCaptureReducer.Action>() { // from class: com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingHostFragment$onViewCreated$$inlined$switchScope$1
            @Override // kotlin.jvm.functions.Function1
            public final AudioCaptureReducer.Action invoke(AudioCaptureReducer.Action action) {
                return action;
            }
        };
        final Flow flowDistinctUntilChanged2 = FlowKt.distinctUntilChanged(store2.getState(), new Function2<AudioCaptureReducer.State, AudioCaptureReducer.State, Boolean>() { // from class: com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingHostFragment$onViewCreated$$inlined$switchScope$2
            @Override // kotlin.jvm.functions.Function2
            public final Boolean invoke(AudioCaptureReducer.State old, AudioCaptureReducer.State state) {
                Intrinsics.checkNotNullParameter(old, "old");
                Intrinsics.checkNotNullParameter(state, "new");
                return Boolean.valueOf((old instanceof AudioCaptureReducer.State.PermissionRequired) && (state instanceof AudioCaptureReducer.State.PermissionRequired));
            }
        });
        FlowKt.launchIn(FlowKt.onEach(new Flow<AudioCaptureReducer.State.PermissionRequired>() { // from class: com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingHostFragment$onViewCreated$$inlined$switchScope$3

            /* JADX INFO: renamed from: com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingHostFragment$onViewCreated$$inlined$switchScope$3$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2", "com/box/android/cpl/StoreKt$switchScope$$inlined$mapNotNull$1$2", "com/box/android/cpl/StoreKt$switchScope$$inlined$switchScope$2$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingHostFragment$onViewCreated$$inlined$switchScope$3$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingHostFragment$onViewCreated$$inlined$switchScope$3$2", f = "AudioRecordingHostFragment.kt", i = {0, 0, 0, 0, 0, 0}, l = {221}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
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
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        AudioCaptureReducer.State.PermissionRequired permissionRequired = (AudioCaptureReducer.State.PermissionRequired) (!(obj instanceof AudioCaptureReducer.State.PermissionRequired) ? null : obj);
                        if (permissionRequired != null) {
                            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                            anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(permissionRequired);
                            anonymousClass1.I$0 = 0;
                            anonymousClass1.label = 1;
                            if (flowCollector.emit(permissionRequired, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i2 = anonymousClass1.I$0;
                        Object obj3 = anonymousClass1.L$2;
                        Object obj4 = anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super AudioCaptureReducer.State.PermissionRequired> flowCollector, Continuation continuation) {
                Object objCollect = flowDistinctUntilChanged2.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, new AudioRecordingHostFragment$onViewCreated$$inlined$switchScope$4(store2, orCreateKotlinClass2, audioRecordingHostFragment$onViewCreated$$inlined$switchScope$1, null, this)), StoreKt.registerCoroutineScope(store2, CoroutineExtensionsKt.getChildScope(lifecycleScope2), KClassesJvm.getJvmName(orCreateKotlinClass2)));
        Store<AudioCaptureReducer.State, AudioCaptureReducer.Action> store3 = this.store;
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(AudioCaptureReducer.State.Review.class);
        AnonymousClass4 anonymousClass4 = AnonymousClass4.INSTANCE;
        LifecycleCoroutineScope lifecycleScope3 = LifecycleOwnerKt.getLifecycleScope(audioRecordingHostFragment);
        final Flow flowDistinctUntilChanged3 = FlowKt.distinctUntilChanged(store3.getState(), new Function2<AudioCaptureReducer.State, AudioCaptureReducer.State, Boolean>() { // from class: com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingHostFragment$onViewCreated$$inlined$switchEmbeddedScope$4
            @Override // kotlin.jvm.functions.Function2
            public final Boolean invoke(AudioCaptureReducer.State old, AudioCaptureReducer.State state) {
                Intrinsics.checkNotNullParameter(old, "old");
                Intrinsics.checkNotNullParameter(state, "new");
                return Boolean.valueOf((old instanceof AudioCaptureReducer.State.Review) && (state instanceof AudioCaptureReducer.State.Review));
            }
        });
        FlowKt.launchIn(FlowKt.onEach(new Flow<AudioCaptureReducer.State.Review>() { // from class: com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingHostFragment$onViewCreated$$inlined$switchEmbeddedScope$5

            /* JADX INFO: renamed from: com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingHostFragment$onViewCreated$$inlined$switchEmbeddedScope$5$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2", "com/box/android/cpl/StoreKt$switchEmbeddedScope$$inlined$mapNotNull$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingHostFragment$onViewCreated$$inlined$switchEmbeddedScope$5$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingHostFragment$onViewCreated$$inlined$switchEmbeddedScope$5$2", f = "AudioRecordingHostFragment.kt", i = {0, 0, 0, 0, 0, 0}, l = {221}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
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
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        AudioCaptureReducer.State.Review review = (AudioCaptureReducer.State.Review) (!(obj instanceof AudioCaptureReducer.State.Review) ? null : obj);
                        if (review != null) {
                            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                            anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(review);
                            anonymousClass1.I$0 = 0;
                            anonymousClass1.label = 1;
                            if (flowCollector.emit(review, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i2 = anonymousClass1.I$0;
                        Object obj3 = anonymousClass1.L$2;
                        Object obj4 = anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super AudioCaptureReducer.State.Review> flowCollector, Continuation continuation) {
                Object objCollect = flowDistinctUntilChanged3.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, new AudioRecordingHostFragment$onViewCreated$$inlined$switchEmbeddedScope$6(store3, orCreateKotlinClass3, anonymousClass4, null, this)), StoreKt.registerCoroutineScope(store3, CoroutineExtensionsKt.getChildScope(lifecycleScope3), KClassesJvm.getJvmName(orCreateKotlinClass3)));
    }

    /* JADX INFO: renamed from: com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingHostFragment$onViewCreated$1, reason: invalid class name */
    /* JADX INFO: compiled from: AudioRecordingHostFragment.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<AudioRecordingReducer.Action, AudioCaptureReducer.Action.Recording> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1, AudioCaptureReducer.Action.Recording.class, "<init>", "<init>(Lcom/box/android/capture/audiorecording/cpl/AudioRecordingReducer$Action;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final AudioCaptureReducer.Action.Recording invoke(AudioRecordingReducer.Action p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return new AudioCaptureReducer.Action.Recording(p0);
        }
    }

    /* JADX INFO: renamed from: com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingHostFragment$onViewCreated$4, reason: invalid class name */
    /* JADX INFO: compiled from: AudioRecordingHostFragment.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<AudioReviewReducer.Action, AudioCaptureReducer.Action.Reviewing> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        AnonymousClass4() {
            super(1, AudioCaptureReducer.Action.Reviewing.class, "<init>", "<init>(Lcom/box/android/capture/audiorecording/cpl/AudioReviewReducer$Action;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final AudioCaptureReducer.Action.Reviewing invoke(AudioReviewReducer.Action p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return new AudioCaptureReducer.Action.Reviewing(p0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void replaceFragment(Fragment fragment) {
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "getParentFragmentManager(...)");
        FragmentTransaction fragmentTransactionBeginTransaction = parentFragmentManager.beginTransaction();
        fragmentTransactionBeginTransaction.setReorderingAllowed(true);
        fragmentTransactionBeginTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransactionBeginTransaction.commit();
    }
}
