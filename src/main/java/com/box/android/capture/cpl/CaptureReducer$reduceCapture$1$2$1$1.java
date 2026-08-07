package com.box.android.capture.cpl;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: CaptureReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "error", "Lcom/box/android/capture/cpl/CaptureReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.capture.cpl.CaptureReducer$reduceCapture$1$2$1$1", f = "CaptureReducer.kt", i = {0}, l = {207}, m = "invokeSuspend", n = {"error"}, s = {"L$0"}, v = 1)
final class CaptureReducer$reduceCapture$1$2$1$1 extends SuspendLambda implements Function2<CaptureReducer.Action, Continuation<? super Unit>, Object> {
    final /* synthetic */ FlowCollector<CaptureReducer.Action> $$this$flow;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    CaptureReducer$reduceCapture$1$2$1$1(FlowCollector<? super CaptureReducer.Action> flowCollector, Continuation<? super CaptureReducer$reduceCapture$1$2$1$1> continuation) {
        super(2, continuation);
        this.$$this$flow = flowCollector;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CaptureReducer$reduceCapture$1$2$1$1 captureReducer$reduceCapture$1$2$1$1 = new CaptureReducer$reduceCapture$1$2$1$1(this.$$this$flow, continuation);
        captureReducer$reduceCapture$1$2$1$1.L$0 = obj;
        return captureReducer$reduceCapture$1$2$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CaptureReducer.Action action, Continuation<? super Unit> continuation) {
        return ((CaptureReducer$reduceCapture$1$2$1$1) create(action, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CaptureReducer.Action action = (CaptureReducer.Action) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.L$0 = SpillingKt.nullOutSpilledVariable(action);
            this.label = 1;
            if (this.$$this$flow.emit(action, this) == coroutine_suspended) {
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
