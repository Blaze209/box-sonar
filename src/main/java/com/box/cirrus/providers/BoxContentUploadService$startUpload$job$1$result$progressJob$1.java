package com.box.cirrus.providers;

import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.utils.Progress;
import com.box.android.domain.utils.result.ResultProgressWrapper;
import com.margelo.nitro.boxcontext.PendingItemUpdate;
import com.margelo.nitro.boxcontext.PendingItemUpdateType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: BoxContentUploadService.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.cirrus.providers.BoxContentUploadService$startUpload$job$1$result$progressJob$1", f = "BoxContentUploadService.kt", i = {}, l = {83}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class BoxContentUploadService$startUpload$job$1$result$progressJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<PendingItemUpdate, Unit> $onUpdate;
    final /* synthetic */ ResultProgressWrapper<FileModel, DomainError, Progress> $progressWrapper;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    BoxContentUploadService$startUpload$job$1$result$progressJob$1(ResultProgressWrapper<FileModel, DomainError, Progress> resultProgressWrapper, Function1<? super PendingItemUpdate, Unit> function1, Continuation<? super BoxContentUploadService$startUpload$job$1$result$progressJob$1> continuation) {
        super(2, continuation);
        this.$progressWrapper = resultProgressWrapper;
        this.$onUpdate = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BoxContentUploadService$startUpload$job$1$result$progressJob$1(this.$progressWrapper, this.$onUpdate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BoxContentUploadService$startUpload$job$1$result$progressJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow<Progress> progress = this.$progressWrapper.getProgress();
            final Function1<PendingItemUpdate, Unit> function1 = this.$onUpdate;
            this.label = 1;
            if (progress.collect(new FlowCollector() { // from class: com.box.cirrus.providers.BoxContentUploadService$startUpload$job$1$result$progressJob$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((Progress) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(Progress progress2, Continuation<? super Unit> continuation) {
                    function1.invoke(new PendingItemUpdate(PendingItemUpdateType.PROGRESS, Boxing.boxDouble(progress2.percentage()), null, null));
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
