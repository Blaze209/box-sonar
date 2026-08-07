package com.box.android.capture.documentscanning.presentation;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.RepeatOnLifecycleKt;
import com.box.android.capture.documentscanning.ScanPageReducer;
import com.box.android.domain.models.capture.FlashMode;
import com.box.android.utilities.FlowExtensionsKt;
import com.geniusscansdk.camera.ScanFragment;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: IntegratedDocumentScanFragment.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanFragment$getCameraCallback$1$onCameraReady$1", f = "IntegratedDocumentScanFragment.kt", i = {}, l = {306}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class IntegratedDocumentScanFragment$getCameraCallback$1$onCameraReady$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ IntegratedDocumentScanFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    IntegratedDocumentScanFragment$getCameraCallback$1$onCameraReady$1(IntegratedDocumentScanFragment integratedDocumentScanFragment, Continuation<? super IntegratedDocumentScanFragment$getCameraCallback$1$onCameraReady$1> continuation) {
        super(2, continuation);
        this.this$0 = integratedDocumentScanFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IntegratedDocumentScanFragment$getCameraCallback$1$onCameraReady$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((IntegratedDocumentScanFragment$getCameraCallback$1$onCameraReady$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanFragment$getCameraCallback$1$onCameraReady$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: IntegratedDocumentScanFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanFragment$getCameraCallback$1$onCameraReady$1$1", f = "IntegratedDocumentScanFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ IntegratedDocumentScanFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(IntegratedDocumentScanFragment integratedDocumentScanFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = integratedDocumentScanFragment;
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

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            FlowKt.launchIn(FlowKt.onEach(FlowExtensionsKt.observe(this.this$0.getStore().getState(), new PropertyReference1Impl() { // from class: com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanFragment.getCameraCallback.1.onCameraReady.1.1.1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                public Object get(Object obj2) {
                    return ((ScanPageReducer.State) obj2).getFlashMode();
                }
            }), new AnonymousClass2(this.this$0, null)), coroutineScope);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanFragment$getCameraCallback$1$onCameraReady$1$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: IntegratedDocumentScanFragment.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/box/android/domain/models/capture/FlashMode;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanFragment$getCameraCallback$1$onCameraReady$1$1$2", f = "IntegratedDocumentScanFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class AnonymousClass2 extends SuspendLambda implements Function2<FlashMode, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ IntegratedDocumentScanFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(IntegratedDocumentScanFragment integratedDocumentScanFragment, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = integratedDocumentScanFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, continuation);
                anonymousClass2.L$0 = obj;
                return anonymousClass2;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(FlashMode flashMode, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(flashMode, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                FlashMode flashMode = (FlashMode) this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    ScanFragment scanFragment = this.this$0.scanFragment;
                    ScanFragment scanFragment2 = null;
                    if (scanFragment == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("scanFragment");
                        scanFragment = null;
                    }
                    List<com.geniusscansdk.camera.FlashMode> availableFlashModes = scanFragment.getAvailableFlashModes();
                    Intrinsics.checkNotNullExpressionValue(availableFlashModes, "getAvailableFlashModes(...)");
                    String stringValue = flashMode.getStringValue();
                    Locale ROOT = Locale.ROOT;
                    Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
                    String upperCase = stringValue.toUpperCase(ROOT);
                    Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                    if (availableFlashModes.contains(com.geniusscansdk.camera.FlashMode.valueOf(upperCase))) {
                        ScanFragment scanFragment3 = this.this$0.scanFragment;
                        if (scanFragment3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("scanFragment");
                        } else {
                            scanFragment2 = scanFragment3;
                        }
                        String stringValue2 = flashMode.getStringValue();
                        Locale ROOT2 = Locale.ROOT;
                        Intrinsics.checkNotNullExpressionValue(ROOT2, "ROOT");
                        String upperCase2 = stringValue2.toUpperCase(ROOT2);
                        Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
                        scanFragment2.setFlashMode(com.geniusscansdk.camera.FlashMode.valueOf(upperCase2));
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
            this.label = 1;
            if (RepeatOnLifecycleKt.repeatOnLifecycle(this.this$0, Lifecycle.State.STARTED, new AnonymousClass1(this.this$0, null), this) == coroutine_suspended) {
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
