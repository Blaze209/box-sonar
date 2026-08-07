package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzju implements zzcz<zzjt> {
    private static zzju zza = new zzju();
    private final zzcz<zzjt> zzb;

    public static boolean zzb() {
        return ((zzjt) zza.zza()).zza();
    }

    private zzju(zzcz<zzjt> zzczVar) {
        this.zzb = zzdc.zza((zzcz) zzczVar);
    }

    public zzju() {
        this(zzdc.zza(new zzjw()));
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zzjt zza() {
        return this.zzb.zza();
    }
}
