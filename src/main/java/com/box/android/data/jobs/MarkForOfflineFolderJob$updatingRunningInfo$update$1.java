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

/* JADX INFO: compiled from: MarkForOfflineFolderJob.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.data.jobs.MarkForOfflineFolderJob$updatingRunningInfo$update$1", f = "MarkForOfflineFolderJob.kt", i = {1, 1, 2, 2, 3}, l = {442, 446, 448, 453}, m = "invokeSuspend", n = {ReactNativeFeatureActivity.RESULT_EXTRA_KEY, BoxRepresentation.FIELD_INFO, ReactNativeFeatureActivity.RESULT_EXTRA_KEY, BoxRepresentation.FIELD_INFO, ReactNativeFeatureActivity.RESULT_EXTRA_KEY}, s = {"L$0", "L$1", "L$0", "L$1", "L$0"}, v = 1)
final class MarkForOfflineFolderJob$updatingRunningInfo$update$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<MarkForOfflineFolderRunningInfo, Continuation<? super Unit>, Object> $updateRunningData;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ MarkForOfflineFolderJob this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    MarkForOfflineFolderJob$updatingRunningInfo$update$1(MarkForOfflineFolderJob markForOfflineFolderJob, Function2<? super MarkForOfflineFolderRunningInfo, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super MarkForOfflineFolderJob$updatingRunningInfo$update$1> continuation) {
        super(1, continuation);
        this.this$0 = markForOfflineFolderJob;
        this.$updateRunningData = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new MarkForOfflineFolderJob$updatingRunningInfo$update$1(this.this$0, this.$updateRunningData, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((MarkForOfflineFolderJob$updatingRunningInfo$update$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0067, code lost:
    
        if (r2.invoke(r1, r9) == r0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0093, code lost:
    
        if (r9.this$0.getJobService().jobFailed(r9.this$0.getJobId(), com.box.android.domain.jobs.JobType.MARK_FOR_OFFLINE_FOLDER, new com.box.android.domain.models.OfflineDomainError.RunningInfoNotAvailable(null, 1, null), r9) == r0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00be, code lost:
    
        if (r9.this$0.getJobService().jobFailed(r9.this$0.getJobId(), com.box.android.domain.jobs.JobType.MARK_FOR_OFFLINE_FOLDER, (com.box.android.domain.models.DomainError) ((com.box.android.domain.utils.result.Result.Error) r10).getValue(), r9) == r0) goto L31;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            Method dump skipped, instruction units count: 202
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.MarkForOfflineFolderJob$updatingRunningInfo$update$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
