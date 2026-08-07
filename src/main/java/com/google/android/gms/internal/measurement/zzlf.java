package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzlf implements zzcz<zzli> {
    private static zzlf zza = new zzlf();
    private final zzcz<zzli> zzb;

    public static boolean zzb() {
        return ((zzli) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzli) zza.zza()).zzb();
    }

    private zzlf(zzcz<zzli> zzczVar) {
        this.zzb = zzdc.zza((zzcz) zzczVar);
    }

    public zzlf() {
        this(zzdc.zza(new zzlh()));
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zzli zza() {
        return this.zzb.zza();
    }
}
