package com.box.android.capture.adapter;

import com.box.android.domain.models.JobInfo;
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
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: PendingCaptureFilesAdapter.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.capture.adapter.PendingCaptureFilesAdapter$PendingJobViewHolder$bindItem$1", f = "PendingCaptureFilesAdapter.kt", i = {}, l = {218}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class PendingCaptureFilesAdapter$PendingJobViewHolder$bindItem$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ PendingCaptureFilesAdapter.PendingJobViewHolder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PendingCaptureFilesAdapter$PendingJobViewHolder$bindItem$1(PendingCaptureFilesAdapter.PendingJobViewHolder pendingJobViewHolder, Continuation<? super PendingCaptureFilesAdapter$PendingJobViewHolder$bindItem$1> continuation) {
        super(2, continuation);
        this.this$0 = pendingJobViewHolder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PendingCaptureFilesAdapter$PendingJobViewHolder$bindItem$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PendingCaptureFilesAdapter$PendingJobViewHolder$bindItem$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            JobInfo jobInfo = this.this$0.getCaptureHistoryModel().getJobInfo();
            Intrinsics.checkNotNull(jobInfo);
            Flow<JobInfo.Status> status = jobInfo.getStatus();
            final PendingCaptureFilesAdapter.PendingJobViewHolder pendingJobViewHolder = this.this$0;
            this.label = 1;
            if (status.collect(new FlowCollector() { // from class: com.box.android.capture.adapter.PendingCaptureFilesAdapter$PendingJobViewHolder$bindItem$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((JobInfo.Status) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(JobInfo.Status status2, Continuation<? super Unit> continuation) {
                    pendingJobViewHolder.getCommonBinding().jobProgressView.updateProgress(status2);
                    pendingJobViewHolder.updateIndicator(status2);
                    return Unit.INSTANCE;
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
        return Unit.INSTANCE;
    }
}
