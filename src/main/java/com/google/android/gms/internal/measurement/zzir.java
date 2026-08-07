package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzir implements zzcz<zziu> {
    private static zzir zza = new zzir();
    private final zzcz<zziu> zzb;

    public static boolean zzb() {
        return ((zziu) zza.zza()).zza();
    }

    private zzir(zzcz<zziu> zzczVar) {
        this.zzb = zzdc.zza((zzcz) zzczVar);
    }

    public zzir() {
        this(zzdc.zza(new zzit()));
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zziu zza() {
        return this.zzb.zza();
    }
}
