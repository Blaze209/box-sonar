package com.box.android.capture.viewmodel;

import com.box.android.domain.models.JobInfo;
import com.box.android.domain.models.JobInfosSummary;
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

/* JADX INFO: compiled from: CaptureHistoryButtonViewModel.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/models/JobInfosSummary;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.capture.viewmodel.CaptureHistoryButtonViewModel$jobInfosSummary$1$3", f = "CaptureHistoryButtonViewModel.kt", i = {0}, l = {78}, m = "invokeSuspend", n = {"$this$onEmpty"}, s = {"L$0"}, v = 1)
final class CaptureHistoryButtonViewModel$jobInfosSummary$1$3 extends SuspendLambda implements Function2<FlowCollector<? super JobInfosSummary>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    CaptureHistoryButtonViewModel$jobInfosSummary$1$3(Continuation<? super CaptureHistoryButtonViewModel$jobInfosSummary$1$3> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CaptureHistoryButtonViewModel$jobInfosSummary$1$3 captureHistoryButtonViewModel$jobInfosSummary$1$3 = new CaptureHistoryButtonViewModel$jobInfosSummary$1$3(continuation);
        captureHistoryButtonViewModel$jobInfosSummary$1$3.L$0 = obj;
        return captureHistoryButtonViewModel$jobInfosSummary$1$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super JobInfosSummary> flowCollector, Continuation<? super Unit> continuation) {
        return ((CaptureHistoryButtonViewModel$jobInfosSummary$1$3) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FlowCollector flowCollector = (FlowCollector) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
            this.label = 1;
            if (flowCollector.emit(new JobInfosSummary(0, false, new JobInfo.Progress(0.0d, 0.0d)), this) == coroutine_suspended) {
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
