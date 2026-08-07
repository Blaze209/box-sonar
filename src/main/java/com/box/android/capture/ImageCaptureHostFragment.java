package com.box.android.capture;

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
import com.box.android.capture.cpl.ImageCaptureReducer;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.KClassesJvm;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: ImageCaptureHostFragment.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/box/android/capture/ImageCaptureHostFragment;", "Lcom/box/android/base/presentation/fragments/BoxFragment;", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/capture/cpl/ImageCaptureReducer$State;", "Lcom/box/android/capture/cpl/ImageCaptureReducer$Action;", "<init>", "(Lcom/box/android/cpl/Store;)V", "getStore", "()Lcom/box/android/cpl/Store;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "replaceFragment", BuildConfig.FLAVOR, "Landroidx/fragment/app/Fragment;", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class ImageCaptureHostFragment extends Hilt_ImageCaptureHostFragment {
    public static final int $stable = 8;
    private final Store<ImageCaptureReducer.State, ImageCaptureReducer.Action> store;

    /* JADX INFO: Access modifiers changed from: private */
    public static final ImageCaptureReducer.Action onViewCreated$lambda$0(ImageCaptureReducer.Action localAction) {
        Intrinsics.checkNotNullParameter(localAction, "localAction");
        return localAction;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ImageCaptureReducer.Action onViewCreated$lambda$2(ImageCaptureReducer.Action localAction) {
        Intrinsics.checkNotNullParameter(localAction, "localAction");
        return localAction;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ImageCaptureReducer.Action onViewCreated$lambda$4(ImageCaptureReducer.Action localAction) {
        Intrinsics.checkNotNullParameter(localAction, "localAction");
        return localAction;
    }

    public ImageCaptureHostFragment(Store<ImageCaptureReducer.State, ImageCaptureReducer.Action> store) {
        Intrinsics.checkNotNullParameter(store, "store");
        this.store = store;
    }

    public final Store<ImageCaptureReducer.State, ImageCaptureReducer.Action> getStore() {
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
        Store<ImageCaptureReducer.State, ImageCaptureReducer.Action> store = this.store;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ImageCaptureReducer.State.PermissionRequired.class);
        Function1 function1 = new Function1() { // from class: com.box.android.capture.ImageCaptureHostFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ImageCaptureHostFragment.onViewCreated$lambda$0((ImageCaptureReducer.Action) obj);
            }
        };
        ImageCaptureHostFragment imageCaptureHostFragment = this;
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(imageCaptureHostFragment);
        final Flow flowDistinctUntilChanged = FlowKt.distinctUntilChanged(store.getState(), new Function2<ImageCaptureReducer.State, ImageCaptureReducer.State, Boolean>() { // from class: com.box.android.capture.ImageCaptureHostFragment$onViewCreated$$inlined$switchScope$1
            @Override // kotlin.jvm.functions.Function2
            public final Boolean invoke(ImageCaptureReducer.State old, ImageCaptureReducer.State state) {
                Intrinsics.checkNotNullParameter(old, "old");
                Intrinsics.checkNotNullParameter(state, "new");
                return Boolean.valueOf((old instanceof ImageCaptureReducer.State.PermissionRequired) && (state instanceof ImageCaptureReducer.State.PermissionRequired));
            }
        });
        FlowKt.launchIn(FlowKt.onEach(new Flow<ImageCaptureReducer.State.PermissionRequired>() { // from class: com.box.android.capture.ImageCaptureHostFragment$onViewCreated$$inlined$switchScope$2

            /* JADX INFO: renamed from: com.box.android.capture.ImageCaptureHostFragment$onViewCreated$$inlined$switchScope$2$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2", "com/box/android/cpl/StoreKt$switchScope$$inlined$mapNotNull$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.box.android.capture.ImageCaptureHostFragment$onViewCreated$$inlined$switchScope$2$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.capture.ImageCaptureHostFragment$onViewCreated$$inlined$switchScope$2$2", f = "ImageCaptureHostFragment.kt", i = {0, 0, 0, 0, 0, 0}, l = {221}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
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
                        ImageCaptureReducer.State.PermissionRequired permissionRequired = (ImageCaptureReducer.State.PermissionRequired) (!(obj instanceof ImageCaptureReducer.State.PermissionRequired) ? null : obj);
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
            public Object collect(FlowCollector<? super ImageCaptureReducer.State.PermissionRequired> flowCollector, Continuation continuation) {
                Object objCollect = flowDistinctUntilChanged.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, new ImageCaptureHostFragment$onViewCreated$$inlined$switchScope$3(store, orCreateKotlinClass, function1, null, this)), StoreKt.registerCoroutineScope(store, CoroutineExtensionsKt.getChildScope(lifecycleScope), KClassesJvm.getJvmName(orCreateKotlinClass)));
        Store<ImageCaptureReducer.State, ImageCaptureReducer.Action> store2 = this.store;
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(ImageCaptureReducer.State.Camera.class);
        Function1 function2 = new Function1() { // from class: com.box.android.capture.ImageCaptureHostFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ImageCaptureHostFragment.onViewCreated$lambda$2((ImageCaptureReducer.Action) obj);
            }
        };
        LifecycleCoroutineScope lifecycleScope2 = LifecycleOwnerKt.getLifecycleScope(imageCaptureHostFragment);
        final Flow flowDistinctUntilChanged2 = FlowKt.distinctUntilChanged(store2.getState(), new Function2<ImageCaptureReducer.State, ImageCaptureReducer.State, Boolean>() { // from class: com.box.android.capture.ImageCaptureHostFragment$onViewCreated$$inlined$switchScope$4
            @Override // kotlin.jvm.functions.Function2
            public final Boolean invoke(ImageCaptureReducer.State old, ImageCaptureReducer.State state) {
                Intrinsics.checkNotNullParameter(old, "old");
                Intrinsics.checkNotNullParameter(state, "new");
                return Boolean.valueOf((old instanceof ImageCaptureReducer.State.Camera) && (state instanceof ImageCaptureReducer.State.Camera));
            }
        });
        FlowKt.launchIn(FlowKt.onEach(new Flow<ImageCaptureReducer.State.Camera>() { // from class: com.box.android.capture.ImageCaptureHostFragment$onViewCreated$$inlined$switchScope$5

            /* JADX INFO: renamed from: com.box.android.capture.ImageCaptureHostFragment$onViewCreated$$inlined$switchScope$5$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2", "com/box/android/cpl/StoreKt$switchScope$$inlined$mapNotNull$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.box.android.capture.ImageCaptureHostFragment$onViewCreated$$inlined$switchScope$5$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.capture.ImageCaptureHostFragment$onViewCreated$$inlined$switchScope$5$2", f = "ImageCaptureHostFragment.kt", i = {0, 0, 0, 0, 0, 0}, l = {221}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
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
                        ImageCaptureReducer.State.Camera camera = (ImageCaptureReducer.State.Camera) (!(obj instanceof ImageCaptureReducer.State.Camera) ? null : obj);
                        if (camera != null) {
                            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                            anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(camera);
                            anonymousClass1.I$0 = 0;
                            anonymousClass1.label = 1;
                            if (flowCollector.emit(camera, anonymousClass1) == coroutine_suspended) {
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
            public Object collect(FlowCollector<? super ImageCaptureReducer.State.Camera> flowCollector, Continuation continuation) {
                Object objCollect = flowDistinctUntilChanged2.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, new ImageCaptureHostFragment$onViewCreated$$inlined$switchScope$6(store2, orCreateKotlinClass2, function2, null, this)), StoreKt.registerCoroutineScope(store2, CoroutineExtensionsKt.getChildScope(lifecycleScope2), KClassesJvm.getJvmName(orCreateKotlinClass2)));
        Store<ImageCaptureReducer.State, ImageCaptureReducer.Action> store3 = this.store;
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(ImageCaptureReducer.State.Review.class);
        Function1 function3 = new Function1() { // from class: com.box.android.capture.ImageCaptureHostFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ImageCaptureHostFragment.onViewCreated$lambda$4((ImageCaptureReducer.Action) obj);
            }
        };
        LifecycleCoroutineScope lifecycleScope3 = LifecycleOwnerKt.getLifecycleScope(imageCaptureHostFragment);
        final Flow flowDistinctUntilChanged3 = FlowKt.distinctUntilChanged(store3.getState(), new Function2<ImageCaptureReducer.State, ImageCaptureReducer.State, Boolean>() { // from class: com.box.android.capture.ImageCaptureHostFragment$onViewCreated$$inlined$switchScope$7
            @Override // kotlin.jvm.functions.Function2
            public final Boolean invoke(ImageCaptureReducer.State old, ImageCaptureReducer.State state) {
                Intrinsics.checkNotNullParameter(old, "old");
                Intrinsics.checkNotNullParameter(state, "new");
                return Boolean.valueOf((old instanceof ImageCaptureReducer.State.Review) && (state instanceof ImageCaptureReducer.State.Review));
            }
        });
        FlowKt.launchIn(FlowKt.onEach(new Flow<ImageCaptureReducer.State.Review>() { // from class: com.box.android.capture.ImageCaptureHostFragment$onViewCreated$$inlined$switchScope$8

            /* JADX INFO: renamed from: com.box.android.capture.ImageCaptureHostFragment$onViewCreated$$inlined$switchScope$8$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2", "com/box/android/cpl/StoreKt$switchScope$$inlined$mapNotNull$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.box.android.capture.ImageCaptureHostFragment$onViewCreated$$inlined$switchScope$8$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.capture.ImageCaptureHostFragment$onViewCreated$$inlined$switchScope$8$2", f = "ImageCaptureHostFragment.kt", i = {0, 0, 0, 0, 0, 0}, l = {221}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
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
                        ImageCaptureReducer.State.Review review = (ImageCaptureReducer.State.Review) (!(obj instanceof ImageCaptureReducer.State.Review) ? null : obj);
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
            public Object collect(FlowCollector<? super ImageCaptureReducer.State.Review> flowCollector, Continuation continuation) {
                Object objCollect = flowDistinctUntilChanged3.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, new ImageCaptureHostFragment$onViewCreated$$inlined$switchScope$9(store3, orCreateKotlinClass3, function3, null, this)), StoreKt.registerCoroutineScope(store3, CoroutineExtensionsKt.getChildScope(lifecycleScope3), KClassesJvm.getJvmName(orCreateKotlinClass3)));
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
