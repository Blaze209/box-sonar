package com.box.android.base.presentation.components.topbar.component.jobsprogress;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: JobsProgressReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/base/presentation/components/topbar/component/jobsprogress/JobsProgressReducer$Action$SubscribeToStatuses;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.base.presentation.components.topbar.component.jobsprogress.JobsProgressReducer$build$1$2", f = "JobsProgressReducer.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 2}, l = {59, 64, 67}, m = "invokeSuspend", n = {"$this$flow", "statusFlows", "$this$flow", "statusFlows", "legacyJobsMap", "$this$flow", "statusFlows", "legacyJobsMap", "jobsList"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"}, v = 1)
final class JobsProgressReducer$build$1$2 extends SuspendLambda implements Function2<FlowCollector<? super JobsProgressReducer.Action.SubscribeToStatuses>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ JobsProgressReducer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    JobsProgressReducer$build$1$2(JobsProgressReducer jobsProgressReducer, Continuation<? super JobsProgressReducer$build$1$2> continuation) {
        super(2, continuation);
        this.this$0 = jobsProgressReducer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        JobsProgressReducer$build$1$2 jobsProgressReducer$build$1$2 = new JobsProgressReducer$build$1$2(this.this$0, continuation);
        jobsProgressReducer$build$1$2.L$0 = obj;
        return jobsProgressReducer$build$1$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super JobsProgressReducer.Action.SubscribeToStatuses> flowCollector, Continuation<? super Unit> continuation) {
        return ((JobsProgressReducer$build$1$2) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:32:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:38:0x0107 A[LOOP:1: B:36:0x0101->B:38:0x0107, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:44:0x00f5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:47:0x00e2 A[SYNTHETIC] */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x013b, code lost:
    
        if (r0.emit(new com.box.android.base.presentation.components.topbar.component.jobsprogress.JobsProgressReducer.Action.SubscribeToStatuses(r4), r10) == r1) goto L41;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            Method dump skipped, instruction units count: 321
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.base.presentation.components.topbar.component.jobsprogress.JobsProgressReducer$build$1$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
