package com.box.android.jobsui;

import com.box.android.data.jobs.JobWorker;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: JobItemReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.jobsui.JobItemReducer", f = "JobItemReducer.kt", i = {0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {46, 53, 55}, m = "build$lambda$0$retryJob", n = {"$state", "this$0", "$state", "this$0", "jobStatus", JobWorker.JOB_ID_PARAM, "groupId", "$state", "this$0", "jobStatus", JobWorker.JOB_ID_PARAM, "groupId"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"}, v = 1)
final class JobItemReducer$build$1$retryJob$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;

    JobItemReducer$build$1$retryJob$1(Continuation<? super JobItemReducer$build$1$retryJob$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return JobItemReducer.build$lambda$0$retryJob(null, null, this);
    }
}
