package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
final class zziv implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ long zzb;
    private final /* synthetic */ zzit zzc;
    private final /* synthetic */ zzit zzd;
    private final /* synthetic */ zziw zze;

    zziv(zziw zziwVar, boolean z, long j, zzit zzitVar, zzit zzitVar2) {
        this.zze = zziwVar;
        this.zza = z;
        this.zzb = j;
        this.zzc = zzitVar;
        this.zzd = zzitVar2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z = false;
        if (this.zze.zzt().zza(zzap.zzba)) {
            if (this.zza && this.zze.zza != null) {
                z = true;
            }
            if (z) {
                zziw zziwVar = this.zze;
                zziwVar.zza(zziwVar.zza, true, this.zzb);
            }
        } else if (this.zza && this.zze.zza != null) {
            zziw zziwVar2 = this.zze;
            zziwVar2.zza(zziwVar2.zza, true, this.zzb);
        }
        zzit zzitVar = this.zzc;
        if (zzitVar == null || zzitVar.zzc != this.zzd.zzc || !zzla.zzc(this.zzc.zzb, this.zzd.zzb) || !zzla.zzc(this.zzc.zza, this.zzd.zza)) {
            Bundle bundle = new Bundle();
            zziw.zza(this.zzd, bundle, true);
            zzit zzitVar2 = this.zzc;
            if (zzitVar2 != null) {
                if (zzitVar2.zza != null) {
                    bundle.putString("_pn", this.zzc.zza);
                }
                bundle.putString("_pc", this.zzc.zzb);
                bundle.putLong("_pi", this.zzc.zzc);
            }
            if (this.zze.zzt().zza(zzap.zzba) && z) {
                long jZzb = this.zze.zzk().zzb.zzb();
                if (jZzb > 0) {
                    this.zze.zzp().zza(bundle, jZzb);
                }
            }
            this.zze.zzf().zzb("auto", "_vs", bundle);
        }
        this.zze.zza = this.zzd;
        this.zze.zzh().zza(this.zzd);
    }
}
