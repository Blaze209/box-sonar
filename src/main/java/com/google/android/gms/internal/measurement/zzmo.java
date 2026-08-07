package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzmo implements zzcz<zzmn> {
    private static zzmo zza = new zzmo();
    private final zzcz<zzmn> zzb;

    public static boolean zzb() {
        return ((zzmn) zza.zza()).zza();
    }

    private zzmo(zzcz<zzmn> zzczVar) {
        this.zzb = zzdc.zza((zzcz) zzczVar);
    }

    public zzmo() {
        this(zzdc.zza(new zzmq()));
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zzmn zza() {
        return this.zzb.zza();
    }
}
