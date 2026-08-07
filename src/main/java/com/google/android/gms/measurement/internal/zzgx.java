package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
final class zzgx implements Runnable {
    private final /* synthetic */ zzan zza;
    private final /* synthetic */ zzm zzb;
    private final /* synthetic */ zzgp zzc;

    zzgx(zzgp zzgpVar, zzan zzanVar, zzm zzmVar) {
        this.zzc = zzgpVar;
        this.zza = zzanVar;
        this.zzb = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzan zzanVarZzb = this.zzc.zzb(this.zza, this.zzb);
        this.zzc.zza.zzo();
        this.zzc.zza.zza(zzanVarZzb, this.zzb);
    }
}
