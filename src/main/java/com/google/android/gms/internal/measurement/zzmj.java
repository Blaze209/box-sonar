package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzmj implements zzcz<zzmm> {
    private static zzmj zza = new zzmj();
    private final zzcz<zzmm> zzb;

    public static boolean zzb() {
        return ((zzmm) zza.zza()).zza();
    }

    public static double zzc() {
        return ((zzmm) zza.zza()).zzb();
    }

    public static long zzd() {
        return ((zzmm) zza.zza()).zzc();
    }

    public static long zze() {
        return ((zzmm) zza.zza()).zzd();
    }

    public static String zzf() {
        return ((zzmm) zza.zza()).zze();
    }

    private zzmj(zzcz<zzmm> zzczVar) {
        this.zzb = zzdc.zza((zzcz) zzczVar);
    }

    public zzmj() {
        this(zzdc.zza(new zzml()));
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zzmm zza() {
        return this.zzb.zza();
    }
}
