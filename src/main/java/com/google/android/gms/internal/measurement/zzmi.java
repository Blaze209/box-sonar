package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzmi implements zzcz<zzmh> {
    private static zzmi zza = new zzmi();
    private final zzcz<zzmh> zzb;

    public static boolean zzb() {
        return ((zzmh) zza.zza()).zza();
    }

    private zzmi(zzcz<zzmh> zzczVar) {
        this.zzb = zzdc.zza((zzcz) zzczVar);
    }

    public zzmi() {
        this(zzdc.zza(new zzmk()));
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zzmh zza() {
        return this.zzb.zza();
    }
}
