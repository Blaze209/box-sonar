package com.geniusscansdk.scanflow;

import com.geniusscansdk.core.DocumentDetector;
import com.geniusscansdk.core.Quadrangle;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: BorderDetectionFragment.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00070\u0001¢\u0006\u0002\b\u0002*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/geniusscansdk/core/Quadrangle;", "Lkotlin/jvm/internal/EnhancedNullability;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.geniusscansdk.scanflow.BorderDetectionFragment$startDetection$1$quadrangle$1", f = "BorderDetectionFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class BorderDetectionFragment$startDetection$1$quadrangle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Quadrangle>, Object> {
    int label;
    final /* synthetic */ BorderDetectionFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BorderDetectionFragment$startDetection$1$quadrangle$1(BorderDetectionFragment borderDetectionFragment, Continuation<? super BorderDetectionFragment$startDetection$1$quadrangle$1> continuation) {
        super(2, continuation);
        this.this$0 = borderDetectionFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BorderDetectionFragment$startDetection$1$quadrangle$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Quadrangle> continuation) {
        return ((BorderDetectionFragment$startDetection$1$quadrangle$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            DocumentDetector documentDetector = this.this$0.documentDetector;
            if (documentDetector == null) {
                Intrinsics.throwUninitializedPropertyAccessException("documentDetector");
                documentDetector = null;
            }
            return documentDetector.detectDocument(this.this$0.getPage().getOriginalImage());
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
