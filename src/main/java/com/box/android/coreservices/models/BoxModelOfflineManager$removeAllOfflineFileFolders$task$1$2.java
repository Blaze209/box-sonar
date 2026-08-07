package com.box.android.coreservices.models;

import com.box.android.domain.services.IJobService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: BoxModelOfflineManager.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.coreservices.models.BoxModelOfflineManager$removeAllOfflineFileFolders$task$1$2", f = "BoxModelOfflineManager.kt", i = {}, l = {741}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class BoxModelOfflineManager$removeAllOfflineFileFolders$task$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IJobService $jobService;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BoxModelOfflineManager$removeAllOfflineFileFolders$task$1$2(IJobService iJobService, Continuation<? super BoxModelOfflineManager$removeAllOfflineFileFolders$task$1$2> continuation) {
        super(2, continuation);
        this.$jobService = iJobService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BoxModelOfflineManager$removeAllOfflineFileFolders$task$1$2(this.$jobService, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BoxModelOfflineManager$removeAllOfflineFileFolders$task$1$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.$jobService.cancelAllMarkForOfflineJobs(this) == coroutine_suspended) {
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
