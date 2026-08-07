package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
final class zzgq implements Runnable {
    private final /* synthetic */ zzhq zza;
    private final /* synthetic */ zzgo zzb;

    zzgq(zzgo zzgoVar, zzhq zzhqVar) {
        this.zzb = zzgoVar;
        this.zza = zzhqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza(this.zza);
        this.zzb.zza();
    }
}
