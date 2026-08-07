package com.box.android.jobsui;

import com.box.android.cpl.Identifiable;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.utils.result.Result;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: JobsReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.jobsui.JobsReducer$deleteSelectedJobs$1$1$1", f = "JobsReducer.kt", i = {}, l = {138}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class JobsReducer$deleteSelectedJobs$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<DomainError> $domainError;
    final /* synthetic */ String $it;
    final /* synthetic */ JobsReducer.State $state;
    int label;
    final /* synthetic */ JobsReducer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    JobsReducer$deleteSelectedJobs$1$1$1(JobsReducer jobsReducer, JobsReducer.State state, String str, Ref.ObjectRef<DomainError> objectRef, Continuation<? super JobsReducer$deleteSelectedJobs$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = jobsReducer;
        this.$state = state;
        this.$it = str;
        this.$domainError = objectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new JobsReducer$deleteSelectedJobs$1$1$1(this.this$0, this.$state, this.$it, this.$domainError, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((JobsReducer$deleteSelectedJobs$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r5v7, types: [T, com.box.android.domain.models.DomainError] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            JobsReducer jobsReducer = this.this$0;
            Identifiable byId = this.$state.getJobsList().getById(this.$it);
            Intrinsics.checkNotNull(byId);
            this.label = 1;
            obj = jobsReducer.deleteJob((JobItemReducer.State) byId, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        Result result = (Result) obj;
        Ref.ObjectRef<DomainError> objectRef = this.$domainError;
        if (!(result instanceof Result.Success)) {
            if (result instanceof Result.Error) {
                objectRef.element = (DomainError) ((Result.Error) result).getValue();
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        return Unit.INSTANCE;
    }
}
