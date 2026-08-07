package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
final class zzkr implements Runnable {
    private final /* synthetic */ zzkx zza;
    private final /* synthetic */ zzks zzb;

    zzkr(zzks zzksVar, zzkx zzkxVar) {
        this.zzb = zzksVar;
        this.zza = zzkxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza(this.zza);
        this.zzb.zza();
    }
}
