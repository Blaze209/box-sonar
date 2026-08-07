package com.google.firebase.iid;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@20.1.0 */
/* JADX INFO: loaded from: classes14.dex */
final /* synthetic */ class zzg implements ThreadFactory {
    static final ThreadFactory zza = new zzg();

    private zzg() {
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return zzh.zza(runnable);
    }
}
