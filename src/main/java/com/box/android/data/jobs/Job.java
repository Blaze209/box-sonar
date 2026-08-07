package com.box.android.data.jobs;

import android.content.Context;
import com.box.android.data.persistence.jobs.JobEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: Job.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\n\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0010J\u000e\u0010\u0011\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010\fJ\u000e\u0010\u0012\u001a\u00020\u0013H¦@¢\u0006\u0002\u0010\fR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0014À\u0006\u0003"}, d2 = {"Lcom/box/android/data/jobs/Job;", "", "appContext", "Landroid/content/Context;", "getAppContext", "()Landroid/content/Context;", "jobService", "Lcom/box/android/data/jobs/JobService;", "getJobService", "()Lcom/box/android/data/jobs/JobService;", "start", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "run", "jobEntity", "Lcom/box/android/data/persistence/jobs/JobEntity;", "(Lcom/box/android/data/persistence/jobs/JobEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cleanup", "shouldBeRemovedFromDbOnSuccess", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface Job {

    /* JADX INFO: renamed from: com.box.android.data.jobs.Job$run$1, reason: invalid class name */
    /* JADX INFO: compiled from: Job.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.Job", f = "Job.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {46, 47}, m = "run$suspendImpl", n = {"$this", "jobEntity", "constraints", "workRequest", "$this", "jobEntity", "constraints", "workRequest"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Job.run$suspendImpl(Job.this, null, this);
        }
    }

    Object cleanup(Continuation<? super Unit> continuation);

    Context getAppContext();

    JobService getJobService();

    default Object run(JobEntity jobEntity, Continuation<? super Unit> continuation) {
        return run$suspendImpl(this, jobEntity, continuation);
    }

    Object shouldBeRemovedFromDbOnSuccess(Continuation<? super Boolean> continuation);

    Object start(Continuation<? super Unit> continuation);

    /* JADX INFO: compiled from: Job.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static Object run(Job job, JobEntity jobEntity, Continuation<? super Unit> continuation) {
            return Job.super.run(jobEntity, continuation);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00ff, code lost:
    
        if (r4.jobSubmitted(r10, r0) == r1) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object run$suspendImpl(com.box.android.data.jobs.Job r9, com.box.android.data.persistence.jobs.JobEntity r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            Method dump skipped, instruction units count: 261
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.Job.run$suspendImpl(com.box.android.data.jobs.Job, com.box.android.data.persistence.jobs.JobEntity, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
