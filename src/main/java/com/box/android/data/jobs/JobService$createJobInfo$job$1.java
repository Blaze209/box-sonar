package com.box.android.data.jobs;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.box.android.data.persistence.jobs.JobEntity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: JobService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/box/android/data/jobs/Job;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.data.jobs.JobService$createJobInfo$job$1", f = "JobService.kt", i = {}, l = {TypedValues.TransitionType.TYPE_INTERPOLATOR}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class JobService$createJobInfo$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {
    final /* synthetic */ JobEntity $jobEntity;
    int label;
    final /* synthetic */ JobService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    JobService$createJobInfo$job$1(JobService jobService, JobEntity jobEntity, Continuation<? super JobService$createJobInfo$job$1> continuation) {
        super(2, continuation);
        this.this$0 = jobService;
        this.$jobEntity = jobEntity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new JobService$createJobInfo$job$1(this.this$0, this.$jobEntity, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Job> continuation) {
        return ((JobService$createJobInfo$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        ResultKt.throwOnFailure(obj);
        this.label = 1;
        Object job = this.this$0.getJob(this.$jobEntity.getId(), this);
        return job == coroutine_suspended ? coroutine_suspended : job;
    }
}
