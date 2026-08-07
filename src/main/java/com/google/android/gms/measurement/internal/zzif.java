package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
final class zzif implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zzhp zzb;

    zzif(zzhp zzhpVar, AtomicReference atomicReference) {
        this.zzb = zzhpVar;
        this.zza = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zza) {
            try {
                this.zza.set(Double.valueOf(this.zzb.zzt().zzc(this.zzb.zzg().zzab(), zzap.zzam)));
                this.zza.notify();
            } catch (Throwable th) {
                this.zza.notify();
                throw th;
            }
        }
    }
}
