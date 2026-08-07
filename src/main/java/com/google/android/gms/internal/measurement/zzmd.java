package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzmd implements zzcz<zzmg> {
    private static zzmd zza = new zzmd();
    private final zzcz<zzmg> zzb;

    public static boolean zzb() {
        return ((zzmg) zza.zza()).zza();
    }

    private zzmd(zzcz<zzmg> zzczVar) {
        this.zzb = zzdc.zza((zzcz) zzczVar);
    }

    public zzmd() {
        this(zzdc.zza(new zzmf()));
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zzmg zza() {
        return this.zzb.zza();
    }
}
