package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
final class zziz implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzkz zzb;
    private final /* synthetic */ zzm zzc;
    private final /* synthetic */ zzix zzd;

    zziz(zzix zzixVar, boolean z, zzkz zzkzVar, zzm zzmVar) {
        this.zzd = zzixVar;
        this.zza = z;
        this.zzb = zzkzVar;
        this.zzc = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfc zzfcVar = this.zzd.zzb;
        if (zzfcVar == null) {
            this.zzd.zzr().zzf().zza("Discarding data. Failed to set user property");
        } else {
            this.zzd.zza(zzfcVar, this.zza ? null : this.zzb, this.zzc);
            this.zzd.zzaj();
        }
    }
}
