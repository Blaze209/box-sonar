package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
final class zzhc implements Runnable {
    private final /* synthetic */ zzkz zza;
    private final /* synthetic */ zzm zzb;
    private final /* synthetic */ zzgp zzc;

    zzhc(zzgp zzgpVar, zzkz zzkzVar, zzm zzmVar) {
        this.zzc = zzgpVar;
        this.zza = zzkzVar;
        this.zzb = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zza.zzo();
        if (this.zza.zza() == null) {
            this.zzc.zza.zzb(this.zza, this.zzb);
        } else {
            this.zzc.zza.zza(this.zza, this.zzb);
        }
    }
}
