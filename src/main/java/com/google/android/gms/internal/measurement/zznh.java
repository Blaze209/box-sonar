package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
public final class zznh implements zzcz<zznk> {
    private static zznh zza = new zznh();
    private final zzcz<zznk> zzb;

    public static boolean zzb() {
        return ((zznk) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zznk) zza.zza()).zzb();
    }

    private zznh(zzcz<zznk> zzczVar) {
        this.zzb = zzdc.zza((zzcz) zzczVar);
    }

    public zznh() {
        this(zzdc.zza(new zznj()));
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zznk zza() {
        return this.zzb.zza();
    }
}
