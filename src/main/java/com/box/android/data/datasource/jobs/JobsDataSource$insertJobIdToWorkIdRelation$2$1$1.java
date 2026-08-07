package com.box.android.data.datasource.jobs;

import com.box.android.data.persistence.BoxDatabase;
import com.box.android.data.persistence.jobs.JobIdToWorkIdRelation;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: JobsDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.data.datasource.jobs.JobsDataSource$insertJobIdToWorkIdRelation$2$1$1", f = "JobsDataSource.kt", i = {}, l = {363}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class JobsDataSource$insertJobIdToWorkIdRelation$2$1$1 extends SuspendLambda implements Function1<Continuation<? super Long>, Object> {
    final /* synthetic */ BoxDatabase $boxDatabase;
    final /* synthetic */ JobIdToWorkIdRelation $jobIdToWorkIdRelation;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    JobsDataSource$insertJobIdToWorkIdRelation$2$1$1(BoxDatabase boxDatabase, JobIdToWorkIdRelation jobIdToWorkIdRelation, Continuation<? super JobsDataSource$insertJobIdToWorkIdRelation$2$1$1> continuation) {
        super(1, continuation);
        this.$boxDatabase = boxDatabase;
        this.$jobIdToWorkIdRelation = jobIdToWorkIdRelation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new JobsDataSource$insertJobIdToWorkIdRelation$2$1$1(this.$boxDatabase, this.$jobIdToWorkIdRelation, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Long> continuation) {
        return ((JobsDataSource$insertJobIdToWorkIdRelation$2$1$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
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
        Object objInsertJobIdToWorkId = this.$boxDatabase.jobsDao().insertJobIdToWorkId(this.$jobIdToWorkIdRelation, this);
        return objInsertJobIdToWorkId == coroutine_suspended ? coroutine_suspended : objInsertJobIdToWorkId;
    }
}
