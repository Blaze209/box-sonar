package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
final class zzih implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzhp zzb;

    zzih(zzhp zzhpVar, boolean z) {
        this.zzb = zzhpVar;
        this.zza = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zZzab = this.zzb.zzx.zzab();
        boolean zZzaa = this.zzb.zzx.zzaa();
        this.zzb.zzx.zza(this.zza);
        if (zZzaa == this.zza) {
            this.zzb.zzx.zzr().zzx().zza("Default data collection state already set to", Boolean.valueOf(this.zza));
        }
        if (this.zzb.zzx.zzab() == zZzab || this.zzb.zzx.zzab() != this.zzb.zzx.zzaa()) {
            this.zzb.zzx.zzr().zzk().zza("Default data collection is different than actual status", Boolean.valueOf(this.zza), Boolean.valueOf(zZzab));
        }
        this.zzb.zzam();
    }
}
