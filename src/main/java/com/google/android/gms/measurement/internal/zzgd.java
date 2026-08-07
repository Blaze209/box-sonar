package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
final class zzgd implements Runnable {
    private final /* synthetic */ zzgo zza;
    private final /* synthetic */ zzfk zzb;

    zzgd(zzge zzgeVar, zzgo zzgoVar, zzfk zzfkVar) {
        this.zza = zzgoVar;
        this.zzb = zzfkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zza.zzf() == null) {
            this.zzb.zzf().zza("Install Referrer Reporter is null");
        } else {
            this.zza.zzf().zza();
        }
    }
}
