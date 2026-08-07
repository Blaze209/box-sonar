package com.google.firebase.analytics.connector;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-api@@17.2.3 */
/* JADX INFO: loaded from: classes14.dex */
final /* synthetic */ class zzb implements Executor {
    static final Executor zza = new zzb();

    private zzb() {
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
