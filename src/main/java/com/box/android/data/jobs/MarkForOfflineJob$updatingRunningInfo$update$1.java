package com.box.android.data.jobs;

import com.box.androidsdk.content.models.BoxRepresentation;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: MarkForOfflineJob.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.data.jobs.MarkForOfflineJob$updatingRunningInfo$update$1", f = "MarkForOfflineJob.kt", i = {1, 1, 2, 2, 3}, l = {786, 790, 792, 797}, m = "invokeSuspend", n = {ReactNativeFeatureActivity.RESULT_EXTRA_KEY, BoxRepresentation.FIELD_INFO, ReactNativeFeatureActivity.RESULT_EXTRA_KEY, BoxRepresentation.FIELD_INFO, ReactNativeFeatureActivity.RESULT_EXTRA_KEY}, s = {"L$0", "L$1", "L$0", "L$1", "L$0"}, v = 1)
final class MarkForOfflineJob$updatingRunningInfo$update$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<MarkForOfflineRunningInfo, Continuation<? super Unit>, Object> $updateRunningData;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ MarkForOfflineJob this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    MarkForOfflineJob$updatingRunningInfo$update$1(MarkForOfflineJob markForOfflineJob, Function2<? super MarkForOfflineRunningInfo, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super MarkForOfflineJob$updatingRunningInfo$update$1> continuation) {
        super(1, continuation);
        this.this$0 = markForOfflineJob;
        this.$updateRunningData = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new MarkForOfflineJob$updatingRunningInfo$update$1(this.this$0, this.$updateRunningData, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((MarkForOfflineJob$updatingRunningInfo$update$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0064, code lost:
    
        if (r2.invoke(r1, r7) == r0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0086, code lost:
    
        if (r7.this$0.markNotOfflinedAndFailJob(new com.box.android.domain.models.OfflineDomainError.RunningInfoNotAvailable(null, 1, null), r7) == r0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a7, code lost:
    
        if (r7.this$0.markNotOfflinedAndFailJob((com.box.android.domain.models.DomainError) ((com.box.android.domain.utils.result.Result.Error) r8).getValue(), r7) == r0) goto L31;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L2e
            if (r1 == r5) goto L2a
            if (r1 == r4) goto L1d
            if (r1 == r3) goto L1d
            if (r1 != r2) goto L15
            goto L21
        L15:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L1d:
            java.lang.Object r0 = r7.L$1
            com.box.android.data.jobs.MarkForOfflineRunningInfo r0 = (com.box.android.data.jobs.MarkForOfflineRunningInfo) r0
        L21:
            java.lang.Object r7 = r7.L$0
            com.box.android.domain.utils.result.Result r7 = (com.box.android.domain.utils.result.Result) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto Laa
        L2a:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L3f
        L2e:
            kotlin.ResultKt.throwOnFailure(r8)
            com.box.android.data.jobs.MarkForOfflineJob r8 = r7.this$0
            r1 = r7
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r7.label = r5
            java.lang.Object r8 = r8.getRunningInfo(r1)
            if (r8 != r0) goto L3f
            goto La9
        L3f:
            com.box.android.domain.utils.result.Result r8 = (com.box.android.domain.utils.result.Result) r8
            boolean r1 = r8 instanceof com.box.android.domain.utils.result.Result.Success
            if (r1 == 0) goto L89
            r1 = r8
            com.box.android.domain.utils.result.Result$Success r1 = (com.box.android.domain.utils.result.Result.Success) r1
            java.lang.Object r1 = r1.getValue()
            com.box.android.data.jobs.MarkForOfflineRunningInfo r1 = (com.box.android.data.jobs.MarkForOfflineRunningInfo) r1
            if (r1 == 0) goto L67
            kotlin.jvm.functions.Function2<com.box.android.data.jobs.MarkForOfflineRunningInfo, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r2 = r7.$updateRunningData
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r7.L$0 = r8
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r7.L$1 = r8
            r7.label = r4
            java.lang.Object r7 = r2.invoke(r1, r7)
            if (r7 != r0) goto Laa
            goto La9
        L67:
            com.box.android.data.jobs.MarkForOfflineJob r2 = r7.this$0
            com.box.android.domain.models.OfflineDomainError$RunningInfoNotAvailable r4 = new com.box.android.domain.models.OfflineDomainError$RunningInfoNotAvailable
            r6 = 0
            r4.<init>(r6, r5, r6)
            com.box.android.domain.models.DomainError r4 = (com.box.android.domain.models.DomainError) r4
            r5 = r7
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r7.L$0 = r8
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r7.L$1 = r8
            r7.label = r3
            java.lang.Object r7 = com.box.android.data.jobs.MarkForOfflineJob.access$markNotOfflinedAndFailJob(r2, r4, r5)
            if (r7 != r0) goto Laa
            goto La9
        L89:
            boolean r1 = r8 instanceof com.box.android.domain.utils.result.Result.Error
            if (r1 == 0) goto Lad
            com.box.android.data.jobs.MarkForOfflineJob r1 = r7.this$0
            r3 = r8
            com.box.android.domain.utils.result.Result$Error r3 = (com.box.android.domain.utils.result.Result.Error) r3
            java.lang.Object r3 = r3.getValue()
            com.box.android.domain.models.DomainError r3 = (com.box.android.domain.models.DomainError) r3
            r4 = r7
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r7.L$0 = r8
            r7.label = r2
            java.lang.Object r7 = com.box.android.data.jobs.MarkForOfflineJob.access$markNotOfflinedAndFailJob(r1, r3, r4)
            if (r7 != r0) goto Laa
        La9:
            return r0
        Laa:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        Lad:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.MarkForOfflineJob$updatingRunningInfo$update$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
