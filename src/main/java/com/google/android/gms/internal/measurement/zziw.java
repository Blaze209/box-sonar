package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
public final class zziw implements zzcz<zziv> {
    private static zziw zza = new zziw();
    private final zzcz<zziv> zzb;

    public static boolean zzb() {
        return ((zziv) zza.zza()).zza();
    }

    private zziw(zzcz<zziv> zzczVar) {
        this.zzb = zzdc.zza((zzcz) zzczVar);
    }

    public zziw() {
        this(zzdc.zza(new zziy()));
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zziv zza() {
        return this.zzb.zza();
    }
}
