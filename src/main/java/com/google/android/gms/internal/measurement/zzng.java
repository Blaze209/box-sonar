package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzng implements zzcz<zznf> {
    private static zzng zza = new zzng();
    private final zzcz<zznf> zzb;

    public static boolean zzb() {
        return ((zznf) zza.zza()).zza();
    }

    private zzng(zzcz<zznf> zzczVar) {
        this.zzb = zzdc.zza((zzcz) zzczVar);
    }

    public zzng() {
        this(zzdc.zza(new zzni()));
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zznf zza() {
        return this.zzb.zza();
    }
}
