package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
final class zzhv implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zzhp zzb;

    zzhv(zzhp zzhpVar, AtomicReference atomicReference) {
        this.zzb = zzhpVar;
        this.zza = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzh().zza(this.zza);
    }
}
