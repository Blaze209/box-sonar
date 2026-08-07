package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
final class zzig implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zzhp zzb;

    zzig(zzhp zzhpVar, AtomicReference atomicReference) {
        this.zzb = zzhpVar;
        this.zza = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zza) {
            try {
                this.zza.set(Integer.valueOf(this.zzb.zzt().zzb(this.zzb.zzg().zzab(), zzap.zzal)));
                this.zza.notify();
            } catch (Throwable th) {
                this.zza.notify();
                throw th;
            }
        }
    }
}
