package com.box.android.data.datasource.jobs;

import com.box.android.data.persistence.BoxDatabase;
import com.box.android.data.persistence.jobs.JobEntity;
import com.box.android.domain.jobs.JobId;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: JobsDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.data.datasource.jobs.JobsDataSource$insertOrUpdateJob$2$1$1", f = "JobsDataSource.kt", i = {1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {27, 30, 36}, m = "invokeSuspend", n = {"$this$forEach$iv", "element$iv", "tag", "$i$f$forEach", "$i$a$-forEach-JobsDataSource$insertOrUpdateJob$2$1$1$1", "$this$forEach$iv", "element$iv", "dependency", "$i$f$forEach", "$i$a$-forEach-JobsDataSource$insertOrUpdateJob$2$1$1$2"}, s = {"L$0", "L$4", "L$5", "I$0", "I$1", "L$0", "L$4", "L$5", "I$0", "I$1"}, v = 1)
final class JobsDataSource$insertOrUpdateJob$2$1$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ BoxDatabase $boxDatabase;
    final /* synthetic */ Set<JobId> $dependingOn;
    final /* synthetic */ JobEntity $jobEntity;
    final /* synthetic */ Set<String> $tags;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    JobsDataSource$insertOrUpdateJob$2$1$1(BoxDatabase boxDatabase, JobEntity jobEntity, Set<String> set, Set<JobId> set2, Continuation<? super JobsDataSource$insertOrUpdateJob$2$1$1> continuation) {
        super(1, continuation);
        this.$boxDatabase = boxDatabase;
        this.$jobEntity = jobEntity;
        this.$tags = set;
        this.$dependingOn = set2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new JobsDataSource$insertOrUpdateJob$2$1$1(this.$boxDatabase, this.$jobEntity, this.$tags, this.$dependingOn, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((JobsDataSource$insertOrUpdateJob$2$1$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0083  */
    /* JADX WARN: Code duplicated, block: B:24:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:30:0x010c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:32:? A[LOOP:0: B:22:0x00ce->B:32:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:34:0x010c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:? A[LOOP:1: B:16:0x007d->B:36:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0067, code lost:
    
        if (r13.$boxDatabase.jobsDao().insertOrUpdateJob(r13.$jobEntity, r13) == r0) goto L26;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            Method dump skipped, instruction units count: 272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.datasource.jobs.JobsDataSource$insertOrUpdateJob$2$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
