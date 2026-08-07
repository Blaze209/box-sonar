package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzkt implements zzcz<zzkw> {
    private static zzkt zza = new zzkt();
    private final zzcz<zzkw> zzb;

    public static boolean zzb() {
        return ((zzkw) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzkw) zza.zza()).zzb();
    }

    private zzkt(zzcz<zzkw> zzczVar) {
        this.zzb = zzdc.zza((zzcz) zzczVar);
    }

    public zzkt() {
        this(zzdc.zza(new zzkv()));
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zzkw zza() {
        return this.zzb.zza();
    }
}
