package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzka implements zzcz<zzjz> {
    private static zzka zza = new zzka();
    private final zzcz<zzjz> zzb;

    public static boolean zzb() {
        return ((zzjz) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzjz) zza.zza()).zzb();
    }

    private zzka(zzcz<zzjz> zzczVar) {
        this.zzb = zzdc.zza((zzcz) zzczVar);
    }

    public zzka() {
        this(zzdc.zza(new zzkc()));
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zzjz zza() {
        return this.zzb.zza();
    }
}
