package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
final class zzai implements Runnable {
    private final /* synthetic */ zzhh zza;
    private final /* synthetic */ zzaf zzb;

    zzai(zzaf zzafVar, zzhh zzhhVar) {
        this.zzb = zzafVar;
        this.zza = zzhhVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzu();
        if (zzw.zza()) {
            this.zza.zzq().zza(this);
            return;
        }
        boolean zZzb = this.zzb.zzb();
        zzaf.zza(this.zzb, 0L);
        if (zZzb) {
            this.zzb.zza();
        }
    }
}
