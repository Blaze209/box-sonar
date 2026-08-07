package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzjv implements zzcz<zzjy> {
    private static zzjv zza = new zzjv();
    private final zzcz<zzjy> zzb;

    public static boolean zzb() {
        return ((zzjy) zza.zza()).zza();
    }

    private zzjv(zzcz<zzjy> zzczVar) {
        this.zzb = zzdc.zza((zzcz) zzczVar);
    }

    public zzjv() {
        this(zzdc.zza(new zzjx()));
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zzjy zza() {
        return this.zzb.zza();
    }
}
