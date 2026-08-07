package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
final class zzhe implements Runnable {
    private final /* synthetic */ zzm zza;
    private final /* synthetic */ zzgp zzb;

    zzhe(zzgp zzgpVar, zzm zzmVar) {
        this.zzb = zzgpVar;
        this.zza = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzo();
        this.zzb.zza.zzb(this.zza);
    }
}
