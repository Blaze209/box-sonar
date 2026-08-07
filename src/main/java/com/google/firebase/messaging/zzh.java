package com.google.firebase.messaging;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@20.1.1 */
/* JADX INFO: loaded from: classes14.dex */
final /* synthetic */ class zzh implements Executor {
    static final Executor zza = new zzh();

    private zzh() {
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
