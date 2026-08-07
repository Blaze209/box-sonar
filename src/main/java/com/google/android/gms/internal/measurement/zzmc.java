package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzmc implements zzcz<zzmb> {
    private static zzmc zza = new zzmc();
    private final zzcz<zzmb> zzb;

    public static boolean zzb() {
        return ((zzmb) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzmb) zza.zza()).zzb();
    }

    private zzmc(zzcz<zzmb> zzczVar) {
        this.zzb = zzdc.zza((zzcz) zzczVar);
    }

    public zzmc() {
        this(zzdc.zza(new zzme()));
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zzmb zza() {
        return this.zzb.zza();
    }
}
