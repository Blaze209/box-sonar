package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
final class zzgr implements Runnable {
    private final /* synthetic */ zzv zza;
    private final /* synthetic */ zzgp zzb;

    zzgr(zzgp zzgpVar, zzv zzvVar) {
        this.zzb = zzgpVar;
        this.zza = zzvVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzo();
        if (this.zza.zzc.zza() == null) {
            this.zzb.zza.zzb(this.zza);
        } else {
            this.zzb.zza.zza(this.zza);
        }
    }
}
