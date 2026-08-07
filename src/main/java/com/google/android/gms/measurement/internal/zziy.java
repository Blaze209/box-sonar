package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
final class zziy implements Runnable {
    private final /* synthetic */ zzit zza;
    private final /* synthetic */ long zzb;
    private final /* synthetic */ zziw zzc;

    zziy(zziw zziwVar, zzit zzitVar, long j) {
        this.zzc = zziwVar;
        this.zza = zzitVar;
        this.zzb = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zza(this.zza, false, this.zzb);
        this.zzc.zza = null;
        this.zzc.zzh().zza((zzit) null);
    }
}
