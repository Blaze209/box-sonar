package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
public final class zznm implements zzcz<zznl> {
    private static zznm zza = new zznm();
    private final zzcz<zznl> zzb;

    public static boolean zzb() {
        return ((zznl) zza.zza()).zza();
    }

    private zznm(zzcz<zznl> zzczVar) {
        this.zzb = zzdc.zza((zzcz) zzczVar);
    }

    public zznm() {
        this(zzdc.zza(new zzno()));
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zznl zza() {
        return this.zzb.zza();
    }
}
