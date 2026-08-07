package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzjj implements zzcz<zzjm> {
    private static zzjj zza = new zzjj();
    private final zzcz<zzjm> zzb;

    public static boolean zzb() {
        return ((zzjm) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzjm) zza.zza()).zzb();
    }

    private zzjj(zzcz<zzjm> zzczVar) {
        this.zzb = zzdc.zza((zzcz) zzczVar);
    }

    public zzjj() {
        this(zzdc.zza(new zzjl()));
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zzjm zza() {
        return this.zzb.zza();
    }
}
