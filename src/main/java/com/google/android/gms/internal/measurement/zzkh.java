package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzkh implements zzcz<zzkk> {
    private static zzkh zza = new zzkh();
    private final zzcz<zzkk> zzb;

    public static boolean zzb() {
        return ((zzkk) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzkk) zza.zza()).zzb();
    }

    private zzkh(zzcz<zzkk> zzczVar) {
        this.zzb = zzdc.zza((zzcz) zzczVar);
    }

    public zzkh() {
        this(zzdc.zza(new zzkj()));
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zzkk zza() {
        return this.zzb.zza();
    }
}
