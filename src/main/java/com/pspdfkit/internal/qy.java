package com.pspdfkit.internal;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes3.dex */
public final class qy {
    public final ConcurrentHashMap<Integer, Job> a = new ConcurrentHashMap<>();

    public final void a(final int i, final Job job) {
        job.getClass();
        Job job2 = this.a.get(Integer.valueOf(i));
        if (job2 != null && job2.isActive()) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        this.a.put(Integer.valueOf(i), job);
        job.invokeOnCompletion(new Function1() { // from class: com.pspdfkit.internal.qy$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return qy.a(this.f$0, i, job, (Throwable) obj);
            }
        });
    }

    public static final Unit a(qy qyVar, int i, Job job, Throwable th) {
        qyVar.a.remove(Integer.valueOf(i), job);
        return Unit.INSTANCE;
    }
}
