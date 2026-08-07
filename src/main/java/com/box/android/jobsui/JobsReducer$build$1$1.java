package com.box.android.jobsui;

import com.box.android.domain.services.IJobService;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.KotlinNothingValueException;
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

/* JADX INFO: compiled from: JobsReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/jobsui/JobsReducer$Action$Load;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.jobsui.JobsReducer$build$1$1", f = "JobsReducer.kt", i = {0}, l = {Token.YIELD_STAR}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"}, v = 1)
final class JobsReducer$build$1$1 extends SuspendLambda implements Function2<FlowCollector<? super JobsReducer.Action.Load>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ JobsReducer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    JobsReducer$build$1$1(JobsReducer jobsReducer, Continuation<? super JobsReducer$build$1$1> continuation) {
        super(2, continuation);
        this.this$0 = jobsReducer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        JobsReducer$build$1$1 jobsReducer$build$1$1 = new JobsReducer$build$1$1(this.this$0, continuation);
        jobsReducer$build$1$1.L$0 = obj;
        return jobsReducer$build$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super JobsReducer.Action.Load> flowCollector, Continuation<? super Unit> continuation) {
        return ((JobsReducer$build$1$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        final FlowCollector flowCollector = (FlowCollector) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
            this.label = 1;
            if (this.this$0.environment.getJobService().getJobEnqueuedFlow().collect(new FlowCollector() { // from class: com.box.android.jobsui.JobsReducer$build$1$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((IJobService.JobEnqueuedEvent) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(IJobService.JobEnqueuedEvent jobEnqueuedEvent, Continuation<? super Unit> continuation) {
                    Object objEmit = flowCollector.emit(new JobsReducer.Action.Load(true), continuation);
                    return objEmit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit : Unit.INSTANCE;
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }
}
