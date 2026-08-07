package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
final class zzfu implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzfr zzb;

    zzfu(zzfr zzfrVar, boolean z) {
        this.zzb = zzfrVar;
        this.zza = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzb.zza(this.zza);
    }
}
