package com.box.android.data.jobs;

import com.box.android.data.api.models.upload.UploadFileChunkDTO;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.utils.Progress;
import com.box.android.domain.utils.result.ResultProgressWrapper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: ChunkUploadJob.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.data.jobs.ChunkUploadJob$start$3$progressFlowJob$1", f = "ChunkUploadJob.kt", i = {}, l = {124}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class ChunkUploadJob$start$3$progressFlowJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ResultProgressWrapper<UploadFileChunkDTO, DomainError, Progress> $progressWrapper;
    int label;
    final /* synthetic */ ChunkUploadJob this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ChunkUploadJob$start$3$progressFlowJob$1(ResultProgressWrapper<UploadFileChunkDTO, DomainError, Progress> resultProgressWrapper, ChunkUploadJob chunkUploadJob, Continuation<? super ChunkUploadJob$start$3$progressFlowJob$1> continuation) {
        super(2, continuation);
        this.$progressWrapper = resultProgressWrapper;
        this.this$0 = chunkUploadJob;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChunkUploadJob$start$3$progressFlowJob$1(this.$progressWrapper, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ChunkUploadJob$start$3$progressFlowJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow<Progress> progress = this.$progressWrapper.getProgress();
            final ChunkUploadJob chunkUploadJob = this.this$0;
            this.label = 1;
            if (progress.collect(new FlowCollector() { // from class: com.box.android.data.jobs.ChunkUploadJob$start$3$progressFlowJob$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((Progress) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(Progress progress2, Continuation<? super Unit> continuation) {
                    Object objTaskProgress = chunkUploadJob.getJobService().taskProgress(chunkUploadJob.getJobId(), progress2.getCompleted(), progress2.getTotalSize(), continuation);
                    return objTaskProgress == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objTaskProgress : Unit.INSTANCE;
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
