package com.box.android.data.jobs;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: JobService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.data.jobs.JobService", f = "JobService.kt", i = {0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3}, l = {346, 348, 362, 365}, m = "runNextJob$doRunNextJob", n = {"this$0", "this$0", "$this$map$iv", "jobEntity", "$i$f$map", "$i$a$-map-JobService$runNextJob$doRunNextJob$2", "this$0", "$this$map$iv", "jobEntity", "e", "$i$f$map", "$i$a$-map-JobService$runNextJob$doRunNextJob$2", "this$0", "$this$map$iv", "jobEntity", "job", "$i$f$map", "$i$a$-map-JobService$runNextJob$doRunNextJob$2"}, s = {"L$0", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1"}, v = 1)
final class JobService$runNextJob$doRunNextJob$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    JobService$runNextJob$doRunNextJob$1(Continuation<? super JobService$runNextJob$doRunNextJob$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return JobService.runNextJob$doRunNextJob(null, this);
    }
}
