package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
final class zzhx implements Runnable {
    private final /* synthetic */ zzho zza;
    private final /* synthetic */ zzhp zzb;

    zzhx(zzhp zzhpVar, zzho zzhoVar) {
        this.zzb = zzhpVar;
        this.zza = zzhoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza(this.zza);
    }
}
