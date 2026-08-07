package com.box.android.base.presentation.components.topbar.component.jobsprogress;

import com.box.android.domain.services.IJobService;
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

/* JADX INFO: compiled from: JobsProgressReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/base/presentation/components/topbar/component/jobsprogress/JobsProgressReducer$Action$Load;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.base.presentation.components.topbar.component.jobsprogress.JobsProgressReducer$build$1$1", f = "JobsProgressReducer.kt", i = {0}, l = {46}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"}, v = 1)
final class JobsProgressReducer$build$1$1 extends SuspendLambda implements Function2<FlowCollector<? super JobsProgressReducer.Action.Load>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ JobsProgressReducer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    JobsProgressReducer$build$1$1(JobsProgressReducer jobsProgressReducer, Continuation<? super JobsProgressReducer$build$1$1> continuation) {
        super(2, continuation);
        this.this$0 = jobsProgressReducer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        JobsProgressReducer$build$1$1 jobsProgressReducer$build$1$1 = new JobsProgressReducer$build$1$1(this.this$0, continuation);
        jobsProgressReducer$build$1$1.L$0 = obj;
        return jobsProgressReducer$build$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super JobsProgressReducer.Action.Load> flowCollector, Continuation<? super Unit> continuation) {
        return ((JobsProgressReducer$build$1$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
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
            if (this.this$0.environment.getJobService().getJobEnqueuedFlow().collect(new FlowCollector() { // from class: com.box.android.base.presentation.components.topbar.component.jobsprogress.JobsProgressReducer$build$1$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((IJobService.JobEnqueuedEvent) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(IJobService.JobEnqueuedEvent jobEnqueuedEvent, Continuation<? super Unit> continuation) {
                    Object objEmit = flowCollector.emit(JobsProgressReducer.Action.Load.INSTANCE, continuation);
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
