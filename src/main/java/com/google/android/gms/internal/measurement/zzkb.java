package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzkb implements zzcz<zzke> {
    private static zzkb zza = new zzkb();
    private final zzcz<zzke> zzb;

    public static boolean zzb() {
        return ((zzke) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzke) zza.zza()).zzb();
    }

    public static boolean zzd() {
        return ((zzke) zza.zza()).zzc();
    }

    public static boolean zze() {
        return ((zzke) zza.zza()).zzd();
    }

    public static boolean zzf() {
        return ((zzke) zza.zza()).zze();
    }

    private zzkb(zzcz<zzke> zzczVar) {
        this.zzb = zzdc.zza((zzcz) zzczVar);
    }

    public zzkb() {
        this(zzdc.zza(new zzkd()));
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zzke zza() {
        return this.zzb.zza();
    }
}
