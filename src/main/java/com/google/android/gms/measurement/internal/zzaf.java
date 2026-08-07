package com.google.android.gms.measurement.internal;

import android.os.Handler;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
abstract class zzaf {
    private static volatile Handler zzb;
    private final zzhh zza;
    private final Runnable zzc;
    private volatile long zzd;

    zzaf(zzhh zzhhVar) {
        Preconditions.checkNotNull(zzhhVar);
        this.zza = zzhhVar;
        this.zzc = new zzai(this, zzhhVar);
    }

    public abstract void zza();

    public final void zza(long j) {
        zzc();
        if (j >= 0) {
            this.zzd = this.zza.zzm().currentTimeMillis();
            if (zzd().postDelayed(this.zzc, j)) {
                return;
            }
            this.zza.zzr().zzf().zza("Failed to schedule delayed post. time", Long.valueOf(j));
        }
    }

    public final boolean zzb() {
        return this.zzd != 0;
    }

    final void zzc() {
        this.zzd = 0L;
        zzd().removeCallbacks(this.zzc);
    }

    private final Handler zzd() {
        Handler handler;
        if (zzb != null) {
            return zzb;
        }
        synchronized (zzaf.class) {
            if (zzb == null) {
                zzb = new com.google.android.gms.internal.measurement.zzj(this.zza.zzn().getMainLooper());
            }
            handler = zzb;
        }
        return handler;
    }

    static /* synthetic */ long zza(zzaf zzafVar, long j) {
        zzafVar.zzd = 0L;
        return 0L;
    }
}
