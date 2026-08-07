package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
final class zzii implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzhp zzb;

    zzii(zzhp zzhpVar, boolean z) {
        this.zzb = zzhpVar;
        this.zza = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzd(this.zza);
    }
}
