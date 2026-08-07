package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzjo implements zzcz<zzjn> {
    private static zzjo zza = new zzjo();
    private final zzcz<zzjn> zzb;

    public static boolean zzb() {
        return ((zzjn) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzjn) zza.zza()).zzb();
    }

    private zzjo(zzcz<zzjn> zzczVar) {
        this.zzb = zzdc.zza((zzcz) zzczVar);
    }

    public zzjo() {
        this(zzdc.zza(new zzjq()));
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zzjn zza() {
        return this.zzb.zza();
    }
}
