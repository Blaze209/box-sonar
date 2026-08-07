package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
public final class zznb implements zzcz<zzne> {
    private static zznb zza = new zznb();
    private final zzcz<zzne> zzb;

    public static boolean zzb() {
        return ((zzne) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzne) zza.zza()).zzb();
    }

    public static boolean zzd() {
        return ((zzne) zza.zza()).zzc();
    }

    private zznb(zzcz<zzne> zzczVar) {
        this.zzb = zzdc.zza((zzcz) zzczVar);
    }

    public zznb() {
        this(zzdc.zza(new zznd()));
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zzne zza() {
        return this.zzb.zza();
    }
}
