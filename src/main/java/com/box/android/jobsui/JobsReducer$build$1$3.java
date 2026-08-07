package com.box.android.jobsui;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: JobsReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/jobsui/JobsReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.jobsui.JobsReducer$build$1$3", f = "JobsReducer.kt", i = {0, 0, 0, 0, 1, 1}, l = {205, 207}, m = "invokeSuspend", n = {"$this$flow", "domainError", "it", "$i$a$-let-JobsReducer$build$1$3$1", "$this$flow", "domainError"}, s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1"}, v = 1)
final class JobsReducer$build$1$3 extends SuspendLambda implements Function2<FlowCollector<? super JobsReducer.Action>, Continuation<? super Unit>, Object> {
    final /* synthetic */ JobsReducer.State $state;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ JobsReducer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    JobsReducer$build$1$3(JobsReducer jobsReducer, JobsReducer.State state, Continuation<? super JobsReducer$build$1$3> continuation) {
        super(2, continuation);
        this.this$0 = jobsReducer;
        this.$state = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        JobsReducer$build$1$3 jobsReducer$build$1$3 = new JobsReducer$build$1$3(this.this$0, this.$state, continuation);
        jobsReducer$build$1$3.L$0 = obj;
        return jobsReducer$build$1$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super JobsReducer.Action> flowCollector, Continuation<? super Unit> continuation) {
        return ((JobsReducer$build$1$3) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0084, code lost:
    
        if (r0.emit(new com.box.android.jobsui.JobsReducer.Action.Load(false, 1, null), r7) == r1) goto L17;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.InterruptedException {
        /*
            r7 = this;
            java.lang.Object r0 = r7.L$0
            kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r7.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L2f
            if (r2 == r5) goto L23
            if (r2 != r4) goto L1b
            java.lang.Object r7 = r7.L$1
            com.box.android.domain.models.DomainError r7 = (com.box.android.domain.models.DomainError) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L87
        L1b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L23:
            java.lang.Object r2 = r7.L$2
            com.box.android.domain.models.DomainError r2 = (com.box.android.domain.models.DomainError) r2
            java.lang.Object r2 = r7.L$1
            com.box.android.domain.models.DomainError r2 = (com.box.android.domain.models.DomainError) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L5a
        L2f:
            kotlin.ResultKt.throwOnFailure(r8)
            com.box.android.jobsui.JobsReducer r8 = r7.this$0
            com.box.android.jobsui.JobsReducer$State r2 = r7.$state
            com.box.android.domain.models.DomainError r2 = com.box.android.jobsui.JobsReducer.access$deleteSelectedJobs(r8, r2)
            if (r2 == 0) goto L5a
            com.box.android.jobsui.JobsReducer$Action$ActionFailed r8 = new com.box.android.jobsui.JobsReducer$Action$ActionFailed
            r8.<init>(r2)
            r7.L$0 = r0
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r7.L$1 = r6
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r7.L$2 = r6
            r7.I$0 = r3
            r7.label = r5
            java.lang.Object r8 = r0.emit(r8, r7)
            if (r8 != r1) goto L5a
            goto L86
        L5a:
            com.box.android.jobsui.JobsReducer r8 = r7.this$0
            com.box.android.jobsui.JobsUIEnvironment r8 = com.box.android.jobsui.JobsReducer.access$getEnvironment$p(r8)
            com.box.android.jobsui.IJobNotificationService r8 = r8.getJobNotificationService()
            r8.refreshSubscription()
            com.box.android.jobsui.JobsReducer$Action$Load r8 = new com.box.android.jobsui.JobsReducer$Action$Load
            r6 = 0
            r8.<init>(r3, r5, r6)
            r3 = r7
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
            r7.L$0 = r5
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r7.L$1 = r2
            r7.L$2 = r6
            r7.label = r4
            java.lang.Object r7 = r0.emit(r8, r3)
            if (r7 != r1) goto L87
        L86:
            return r1
        L87:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.jobsui.JobsReducer$build$1$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
