package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzji implements zzcz<zzjh> {
    private static zzji zza = new zzji();
    private final zzcz<zzjh> zzb;

    public static boolean zzb() {
        return ((zzjh) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzjh) zza.zza()).zzb();
    }

    private zzji(zzcz<zzjh> zzczVar) {
        this.zzb = zzdc.zza((zzcz) zzczVar);
    }

    public zzji() {
        this(zzdc.zza(new zzjk()));
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zzjh zza() {
        return this.zzb.zza();
    }
}
