package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzll implements zzcz<zzlo> {
    private static zzll zza = new zzll();
    private final zzcz<zzlo> zzb;

    public static boolean zzb() {
        return ((zzlo) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzlo) zza.zza()).zzb();
    }

    private zzll(zzcz<zzlo> zzczVar) {
        this.zzb = zzdc.zza((zzcz) zzczVar);
    }

    public zzll() {
        this(zzdc.zza(new zzln()));
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zzlo zza() {
        return this.zzb.zza();
    }
}
