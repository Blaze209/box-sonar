package com.google.firebase.iid;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@20.1.0 */
/* JADX INFO: loaded from: classes14.dex */
final /* synthetic */ class zzm implements Executor {
    static final Executor zza = new zzm();

    private zzm() {
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
