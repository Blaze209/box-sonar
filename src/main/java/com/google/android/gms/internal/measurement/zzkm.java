package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzkm implements zzcz<zzkl> {
    private static zzkm zza = new zzkm();
    private final zzcz<zzkl> zzb;

    public static boolean zzb() {
        return ((zzkl) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzkl) zza.zza()).zzb();
    }

    private zzkm(zzcz<zzkl> zzczVar) {
        this.zzb = zzdc.zza((zzcz) zzczVar);
    }

    public zzkm() {
        this(zzdc.zza(new zzko()));
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zzkl zza() {
        return this.zzb.zza();
    }
}
