package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzkn implements zzcz<zzkq> {
    private static zzkn zza = new zzkn();
    private final zzcz<zzkq> zzb;

    public static boolean zzb() {
        return ((zzkq) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzkq) zza.zza()).zzb();
    }

    private zzkn(zzcz<zzkq> zzczVar) {
        this.zzb = zzdc.zza((zzcz) zzczVar);
    }

    public zzkn() {
        this(zzdc.zza(new zzkp()));
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zzkq zza() {
        return this.zzb.zza();
    }
}
