package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
final class zzhd implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ long zzd;
    private final /* synthetic */ zzgp zze;

    zzhd(zzgp zzgpVar, String str, String str2, String str3, long j) {
        this.zze = zzgpVar;
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zza == null) {
            this.zze.zza.zzs().zzv().zza(this.zzb, (zzit) null);
        } else {
            this.zze.zza.zzs().zzv().zza(this.zzb, new zzit(this.zzc, this.zza, this.zzd));
        }
    }
}
