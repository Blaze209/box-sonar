package com.google.firebase.iid;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@20.1.0 */
/* JADX INFO: loaded from: classes14.dex */
final class zzh {
    private static final Executor zza = zzj.zza;

    static Executor zza() {
        return zza;
    }

    static ExecutorService zzb() {
        return new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), zzg.zza);
    }

    static final /* synthetic */ Thread zza(Runnable runnable) {
        return new Thread(runnable, "firebase-iid-executor");
    }
}
